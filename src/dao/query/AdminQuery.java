/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.query;

import config.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Admin;
import dao.AdminDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fkrfd
 */
public class AdminQuery implements AdminDAO {

    @Override
    public int login(String email, String password) {
        String query = "SELECT * FROM admins WHERE email = ?";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, email);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String encryptedPassword = rs.getString("password");

                try {
                    String query1 = "SELECT PASSWORD(?) AS password_check";
                    PreparedStatement statement1 = Database.getConnection().prepareStatement(query1);
                    statement1.setString(1, password);

                    ResultSet rs1 = statement1.executeQuery();

                    if (rs1.next()) {
                        if (rs1.getString("password_check").equals(encryptedPassword)) {
                            return 1;
                        }

                        return 2;
                    }
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }

            return 3;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public boolean register(String name, String email, String password) {
        String query = "INSERT INTO admins (name, email, password) VALUES (?, ?, ?, PASSWORD(?))";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    @Override
    public List<Admin> getAdmins() {
        String query = "SELECT * FROM admins";

        List<Admin> admins = new ArrayList<>();

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt(1));
                admin.setName(rs.getString(2));
                admin.setEmail(rs.getString(3));

                admins.add(admin);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return admins;
    }

    @Override
    public Admin getAdmin(int id) {
        String query = "SELECT * FROM admins WHERE id = ?";

        Admin admin = new Admin();

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                admin.setId(rs.getInt(1));
                admin.setName(rs.getString(2));
                admin.setEmail(rs.getString(3));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return admin;
    }

}
