/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.query;

import config.Database;
import dao.UserDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.User;

/**
 *
 * @author fkrfd
 */
public class UserQuery implements UserDAO {

    @Override
    public int login(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? OR email = ?";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, username);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String encryptedPassword = rs.getString("password");

                String query1 = "SELECT PASSWORD(?) AS password_check";
                PreparedStatement statement1 = Database.getConnection().prepareStatement(query1);
                statement1.setString(1, password);

                ResultSet rs1 = statement1.executeQuery();

                if (rs1.next()) {
                    if (rs1.getString("password_check").equals(encryptedPassword)) {
                        return 1;
                    }

                    statement1.close();
                    
                    return 2;
                }
            }
            statement.close();

            return 3;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public boolean register(User user) {
        String query = "INSERT INTO users (name, email, username, password) VALUES (?, ?, ?, PASSWORD(?))";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());

            int row = statement.executeUpdate();

            if (row > 0) {
                return true;
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
