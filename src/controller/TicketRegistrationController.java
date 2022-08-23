/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.TicketRegistrationDAO;
import dao.query.TicketRegistrationQuery;
import java.util.List;
import model.TicketRegistration;

/**
 *
 * @author fkrfd
 */
public class TicketRegistrationController {

    private final TicketRegistrationDAO registrationDAO = new TicketRegistrationQuery();
    
    public List<TicketRegistration> getAll() {
        return registrationDAO.getTicketRegistrations();
    }
    
    public TicketRegistration get(int id) {
        return registrationDAO.getTicketRegistration(id);
    }
    
    public boolean register(int eventId, int stageId, int ticketCategoryId, String name, String address, String email, int ticketTotal, int priceTotal, String orderedAt) {
        return registrationDAO.insertTicketRegistration(eventId, stageId, ticketCategoryId, name, address, email, ticketTotal, priceTotal, orderedAt);
    }
}
