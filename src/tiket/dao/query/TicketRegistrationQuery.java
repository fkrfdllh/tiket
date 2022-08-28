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
import tiket.dao.TicketRegistrationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiket.model.TicketCategory;
import tiket.model.TicketRegistration;

/**
 *
 * @author fkrfd
 */
public class TicketRegistrationQuery implements TicketRegistrationDAO {
    
    private final Connection conn = Database.getConnection();
    
    private final EventDAO eventDAO = new EventQuery();
    
    private final StageDAO stageDAO = new StageQuery();
    
    private final TicketCategoryDAO categoryDAO = new TicketCategoryQuery();
    
    private String query;

    @Override
    public List<TicketRegistration> getTicketRegistrations() {
        List<TicketRegistration> registrations = new ArrayList<>();
        
        query = "SELECT * FROM ticket_registrations";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                TicketRegistration registration = new TicketRegistration();
                registration.setId(rs.getInt(1));
                registration.setEvent(eventDAO.getEvent(rs.getInt(2)));
                registration.setStage(stageDAO.getStage(rs.getInt(3)));
                registration.setTicketCategory(categoryDAO.getTicketCategory(4));
                registration.setName(rs.getString(5));
                registration.setAddress(rs.getString(6));
                registration.setEmail(rs.getString(7));
                registration.setTicketTotal(rs.getInt(8));
                registration.setPriceTotal(rs.getInt(9));
                registration.setOrderedAt(rs.getString(10));
                
                registrations.add(registration);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }
        
        return registrations;
    }

    @Override
    public TicketRegistration getTicketRegistration(int id) {
        TicketRegistration registration = new TicketRegistration();
        
        query = "SELECT * FROM ticket_registrations WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                registration.setId(rs.getInt(1));
                registration.setEvent(eventDAO.getEvent(rs.getInt(2)));
                registration.setStage(stageDAO.getStage(rs.getInt(3)));
                registration.setTicketCategory(categoryDAO.getTicketCategory(4));
                registration.setName(rs.getString(5));
                registration.setAddress(rs.getString(6));
                registration.setEmail(rs.getString(7));
                registration.setTicketTotal(rs.getInt(8));
                registration.setPriceTotal(rs.getInt(9));
                registration.setOrderedAt(rs.getString(10));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }
        
        return registration;
    }

    @Override
    public boolean insertTicketRegistration(int eventId, int stageId, int ticketCategoryId, String name, String address, String email, int ticketTotal, int priceTotal) {
        query = "INSERT INTO ticket_registrations (event_id, stage_id, ticket_category_id, name, address, email, ticket_total, price_total, ordered_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
        
        try {
            conn.setAutoCommit(false);
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, eventId);
            stmt.setInt(2, stageId);
            stmt.setInt(3, ticketCategoryId);
            stmt.setString(4, name);
            stmt.setString(5, address);
            stmt.setString(6, email);
            stmt.setInt(7, ticketTotal);
            stmt.setInt(8, priceTotal);
            
            int row = stmt.executeUpdate();
            
            if (row > 0) {
                conn.commit();
                
                return true;
            }
            
            conn.rollback();
        } catch (SQLException ex) {            
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        }
        
        return false;
    }

    
}
