/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao.query;

import tiket.config.Database;
import tiket.dao.EventDAO;
import tiket.dao.StageDAO;
import tiket.dao.TicketCategoryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiket.model.TicketCategory;

/**
 *
 * @author fkrfd
 */
public class TicketCategoryQuery implements TicketCategoryDAO {

    private final Connection conn = Database.getConnection();

    private String query;

    private final EventDAO eventDAO = new EventQuery();

    private final StageDAO stageDAO = new StageQuery();

    @Override
    public List<TicketCategory> getTicketCategories(int eventId, int stageId) {
        List<TicketCategory> categories = new ArrayList<>();

        query = "SELECT * FROM ticket_categories WHERE event_id = ? AND stage_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventId);
            stmt.setInt(2, stageId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TicketCategory category = new TicketCategory();
                category.setId(rs.getInt(1));
                category.setEvent(eventDAO.getEvent(rs.getInt(2)));
                category.setStage(stageDAO.getStage(rs.getInt(3)));
                category.setName(rs.getString(4));
                category.setCategory(rs.getString(5));
                category.setType(rs.getString(6));
                category.setPrice(rs.getInt(7));
                category.setQuota(rs.getInt(8));

                categories.add(category);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return categories;
    }

    @Override
    public TicketCategory getTicketCategory(int id) {
        TicketCategory category = new TicketCategory();

        query = "SELECT * FROM ticket_categories WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                category.setId(rs.getInt(1));
                category.setEvent(eventDAO.getEvent(rs.getInt(2)));
                category.setStage(stageDAO.getStage(rs.getInt(3)));
                category.setName(rs.getString(4));
                category.setCategory(rs.getString(5));
                category.setType(rs.getString(6));
                category.setPrice(rs.getInt(7));
                category.setQuota(rs.getInt(8));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }

        return category;
    }

    @Override
    public boolean insertTicketCategory(int eventId, int stageId, String name, String category, String type, int price, int quota) {
        query = "INSERT INTO ticket_categories (event_id, stage_id, name, category, type, price, quota) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventId);
            stmt.setInt(2, stageId);
            stmt.setString(3, name);
            stmt.setString(4, category);
            stmt.setString(5, type);
            stmt.setInt(6, price);
            stmt.setInt(7, quota);

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
    public boolean updateTicketCategory(TicketCategory ticketCategory) {
        query = "UPDATE ticket_categories SET event_id = ?, stage_id = ?, name = ?, category = ?, type = ?, price = ?, quota = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, ticketCategory.getEvent().getId());
            stmt.setInt(2, ticketCategory.getStage().getId());
            stmt.setString(3, ticketCategory.getName());
            stmt.setString(4, ticketCategory.getCategory());
            stmt.setString(5, ticketCategory.getType());
            stmt.setInt(6, ticketCategory.getPrice());
            stmt.setInt(7, ticketCategory.getQuota());
            stmt.setInt(8, ticketCategory.getId());

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
    public boolean deleteTicketCategory(int id) {
        query = "DELETE FROM ticket_categories WHERE id = ?";

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
