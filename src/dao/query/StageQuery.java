/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.query;

import config.Database;
import dao.StageDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Event;
import model.Stage;

/**
 *
 * @author fkrfd
 */
public class StageQuery implements StageDAO {

    private String query;

    private final Connection conn = Database.getConnection();

    @Override
    public List<Stage> getStages() {
        List<Stage> stages = new ArrayList<>();

        query = "SELECT stages.*, events.* FROM stages LEFT JOIN events ON stages.event_id = events.id";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Stage stage = new Stage();
                stage.setId(rs.getInt(1));
                stage.setName(rs.getString(3));
                stage.setNumber(rs.getInt(4));
                stage.setLocation(rs.getString(5));
                stage.setStartedAt(rs.getString(6));
                stage.setFinishedAt(rs.getString(7));

                Event event = new Event();
                event.setId(rs.getInt(8));
                event.setName(rs.getString(9));
                event.setLocation(rs.getString(10));
                event.setStartedAt(rs.getString(11));
                event.setFinishedAt(rs.getString(12));

                stage.setEvent(event);

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

        query = "SELECT stages.*, events.* FROM stages LEFT JOIN events ON stages.event_id = events.id WHERE stages.id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                stage.setId(rs.getInt(1));
                stage.setName(rs.getString(3));
                stage.setNumber(rs.getInt(4));
                stage.setLocation(rs.getString(5));
                stage.setStartedAt(rs.getString(6));
                stage.setFinishedAt(rs.getString(7));

                Event event = new Event();
                event.setId(rs.getInt(8));
                event.setName(rs.getString(9));
                event.setLocation(rs.getString(10));
                event.setStartedAt(rs.getString(11));
                event.setFinishedAt(rs.getString(12));

                stage.setEvent(event);
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
