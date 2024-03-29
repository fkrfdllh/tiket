/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao;

import java.util.List;
import tiket.model.EventSponsor;

/**
 *
 * @author fkrfd
 */
public interface EventSponsorDAO {

    public List<EventSponsor> getEventSponsors(int eventId);

    public EventSponsor getEventSponsor(int id);

    public boolean insertEventSponsor(int eventId, String name, int tier);

    public boolean updateEventSponsor(EventSponsor sponsor);

    public boolean deleteEventSponsor(int id);
}
