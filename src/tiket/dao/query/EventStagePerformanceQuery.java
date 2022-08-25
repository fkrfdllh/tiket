/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao.query;

import tiket.config.Database;
import tiket.dao.EventDAO;
import tiket.dao.EventStagePerformanceDAO;
import tiket.dao.PerformanceDAO;
import tiket.dao.StageDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiket.model.EventStagePerformance;

/**
 *
 * @author fkrfd
 */
public class EventStagePerformanceQuery implements EventStagePerformanceDAO {

    private final Connection conn = Database.getConnection();

    private final EventDAO eventDAO = new EventQuery();

    private final StageDAO stageDAO = new StageQuery();

    private final PerformanceDAO performanceDAO = new PerformanceQuery();

    private String query;

    @Override
    public List<EventStagePerformance> getEventStagePerformances() {
        List<EventStagePerformance> list = new ArrayList<>();

        query = "SELECT * FROM event_stage_performace";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EventStagePerformance item = new EventStagePerformance();
                item.setId(rs.getInt(1));
                item.setEvent(eventDAO.getEvent(rs.getInt(2)));
                item.setStage(stageDAO.getStage(rs.getInt(3)));
                item.setPerformance(performanceDAO.getPerformance(4));

                list.add(item);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return list;
    }

    @Override
    public EventStagePerformance getEventStagePerformance(int id) {
        EventStagePerformance item = new EventStagePerformance();

        query = "SELECT * FROM event_stage_performace WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                item.setId(rs.getInt(1));
                item.setEvent(eventDAO.getEvent(rs.getInt(2)));
                item.setStage(stageDAO.getStage(rs.getInt(3)));
                item.setPerformance(performanceDAO.getPerformance(4));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return item;
    }

    @Override
    public boolean insertEventStagePerformance(int eventId, int stageId, int performanceId) {
        query = "INSERT INTO event_stage_performance (event_id, stage_id, performance_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventId);
            stmt.setInt(2, stageId);
            stmt.setInt(3, performanceId);

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
    public boolean updateEventStagePerformance(EventStagePerformance eventStagePerformance) {
        query = "UPDATE event_stage_performance SET event_id = ?, stage_id = ?, performance_id = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventStagePerformance.getEvent().getId());
            stmt.setInt(2, eventStagePerformance.getStage().getId());
            stmt.setInt(3, eventStagePerformance.getPerformance().getId());
            stmt.setInt(4, eventStagePerformance.getId());

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
    public boolean deleteEventStagePerformance(int id) {
        query = "DELETE FROM event_stage_performance WHERE id = ?";

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
