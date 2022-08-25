/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao;

import java.util.List;
import tiket.model.Event;

/**
 *
 * @author fkrfd
 */
public interface EventDAO {

    public List<Event> getEvents();

    public Event getEvent(int id);

    public boolean insertEvent(String name, String location, String startedAt, String finishedAt);

    public boolean updateEvent(Event event);

    public boolean deleteEvent(int id);
}
