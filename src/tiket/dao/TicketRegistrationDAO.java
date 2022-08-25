/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao;

import java.util.List;
import tiket.model.TicketRegistration;

/**
 *
 * @author fkrfd
 */
public interface TicketRegistrationDAO {

    public List<TicketRegistration> getTicketRegistrations();

    public TicketRegistration getTicketRegistration(int id);

    public boolean insertTicketRegistration(int eventId, int stageId, int ticketCategoryId, String name, String address, String email, int ticketTotal, int priceTotal, String orderedAt);
}
