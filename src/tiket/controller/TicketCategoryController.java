/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiket.controller;

import tiket.dao.TicketCategoryDAO;
import tiket.dao.query.TicketCategoryQuery;
import java.util.List;
import tiket.model.TicketCategory;

/**
 *
 * @author fkrfd
 */
public class TicketCategoryController {
    private final TicketCategoryDAO categoryDAO = new TicketCategoryQuery();
    
    public List<TicketCategory> getAll(int eventId, int stageId) {
        return categoryDAO.getTicketCategories(eventId, stageId);
    }
    
    public TicketCategory get(int id) {
        return categoryDAO.getTicketCategory(id);
    }
    
    public boolean insert(int eventId, int stageId, String name, String category, String type, int price, int quota) {
        return categoryDAO.insertTicketCategory(eventId, stageId, name, category, type, price, quota);
    }
    
    public boolean update(TicketCategory ticketCategory) {
        return categoryDAO.updateTicketCategory(ticketCategory);
    }
    
    public boolean delete(int id) {
        return categoryDAO.deleteTicketCategory(id);
    }
            
}
