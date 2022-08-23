/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.query;

import config.Database;
import dao.PerformanceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Performance;

/**
 *
 * @author fkrfd
 */
public class PerformanceQuery implements PerformanceDAO {

    private final Connection conn = Database.getConnection();

    private String query;

    @Override
    public List<Performance> getPerformances() {
        List<Performance> performances = new ArrayList<>();

        query = "SELECT * FROM performances";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Performance performance = new Performance();
                performance.setId(rs.getInt(1));
                performance.setName(rs.getString(2));

                performances.add(performance);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return performances;
    }

    @Override
    public Performance getPerformance(int id) {
        Performance performance = new Performance();

        query = "SELECT * FROM performances WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                performance.setId(rs.getInt(1));
                performance.setName(rs.getString(2));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return performance;
    }

    @Override
    public boolean insertPerformance(String name) {
        query = "INSERT INTO performances (name) VALUES (?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);

            int row = stmt.executeUpdate();

            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return false;
    }

    @Override
    public boolean updatePerformance(Performance performance) {
        query = "UPDATE performances SET name = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, performance.getName());
            stmt.setInt(2, performance.getId());

            int row = stmt.executeUpdate();

            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return false;
    }

    @Override
    public boolean deletePerformance(int id) {
        query = "DELETE FROM performances WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int row = stmt.executeUpdate();

            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return false;
    }

}
