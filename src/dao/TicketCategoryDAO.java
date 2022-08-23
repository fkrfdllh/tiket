/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TicketCategory;

/**
 *
 * @author fkrfd
 */
public interface TicketCategoryDAO {

    public List<TicketCategory> getTicketCategories();

    public TicketCategory getTicketCategory(int id);

    public boolean insertTicketCategory(int eventId, int stageId, String name, String category, String type, int price, int quota);

    public boolean updateTicketCategory(TicketCategory ticketCategory);

    public boolean deleteTicketCategory(int id);
}
