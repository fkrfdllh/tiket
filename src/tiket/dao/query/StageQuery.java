/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao.query;

import tiket.config.Database;
import tiket.dao.EventDAO;
import tiket.dao.StageDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiket.model.Stage;

/**
 *
 * @author fkrfd
 */
public class StageQuery implements StageDAO {

    private String query;

    private final Connection conn = Database.getConnection();

    private final EventDAO eventDAO = new EventQuery();

    @Override
    public List<Stage> getStages(int eventId) {
        List<Stage> stages = new ArrayList<>();

        query = "SELECT * FROM stages WHERE event_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Stage stage = new Stage();
                stage.setId(rs.getInt(1));
                stage.setEvent(eventDAO.getEvent(rs.getInt(2)));
                stage.setName(rs.getString(3));
                stage.setNumber(rs.getInt(4));
                stage.setLocation(rs.getString(5));
                stage.setStartedAt(rs.getString(6));
                stage.setFinishedAt(rs.getString(7));

                stages.add(stage);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return stages;
    }

    @Override
    public Stage getStage(int id) {
        Stage stage = new Stage();

        query = "SELECT * FROM stages WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                stage.setId(rs.getInt(1));
                stage.setEvent(eventDAO.getEvent(rs.getInt(2)));
                stage.setName(rs.getString(3));
                stage.setNumber(rs.getInt(4));
                stage.setLocation(rs.getString(5));
                stage.setStartedAt(rs.getString(6));
                stage.setFinishedAt(rs.getString(7));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return stage;
    }

    @Override
    public boolean insertStage(int eventId, String name, int number, String location, String startedAt, String finishedAt) {
        query = "INSERT INTO stages (event_id, name, number, location, started_at, finished_at) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventId);
            stmt.setString(2, name);
            stmt.setInt(3, number);
            stmt.setString(4, location);
            stmt.setString(5, startedAt);
            stmt.setString(6, finishedAt);

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
    public boolean updateStage(Stage stage) {
        query = "UPDATE stages SET event_id = ?, name = ?, number = ?, location = ?, started_at = ?, finished_at = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, stage.getEvent().getId());
            stmt.setString(2, stage.getName());
            stmt.setInt(3, stage.getNumber());
            stmt.setString(4, stage.getLocation());
            stmt.setString(5, stage.getStartedAt());
            stmt.setString(6, stage.getFinishedAt());
            stmt.setInt(7, stage.getId());

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
    public boolean deleteStage(int id) {
        query = "DELETE FROM stages WHERE id = ?";

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
