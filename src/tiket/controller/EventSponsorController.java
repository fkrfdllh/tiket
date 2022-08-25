/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.controller;

import tiket.dao.EventSponsorDAO;
import tiket.dao.query.EventSponsorQuery;
import java.util.List;
import tiket.model.EventSponsor;

/**
 *
 * @author fkrfd
 */
public class EventSponsorController {

    private final EventSponsorDAO eventSponsorDAO = new EventSponsorQuery();

    public List<EventSponsor> getAll() {
        return eventSponsorDAO.getEventSponsors();
    }
    
    public EventSponsor get(int id) {
        return eventSponsorDAO.getEventSponsor(id);
    }
    
    public boolean insert(int eventId, String name, int tier) {
        return eventSponsorDAO.insertEventSponsor(eventId, name, tier);
    }
    
    public boolean update(EventSponsor sponsor) {
        return eventSponsorDAO.updateEventSponsor(sponsor);
    }
    
    public boolean delete(int id) {
        return eventSponsorDAO.deleteEventSponsor(id);
    }
}
