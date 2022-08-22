/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventDAO;
import dao.query.EventQuery;
import java.util.ArrayList;
import java.util.List;
import model.Event;

/**
 *
 * @author fkrfd
 */
public class EventController {

    private final EventDAO eventDao = new EventQuery();
    
    public List<Event> getEvents() {
        List<Event> events = eventDao.getEvents();
        
        return events;
    }
    
    public Event getEvent(int id) {
        Event event = eventDao.getEvent(id);
        
        return event;
    }
    
    public boolean insert(String name, String location, String startedAt, String finishedAt) {
        boolean isEventCreated = eventDao.insertEvent(name, location, startedAt, finishedAt);
        
        return isEventCreated;
    }
    
    public boolean update(Event event) {
        boolean isEventUpdated = eventDao.updateEvent(event);
        
        return isEventUpdated;
    }
    
    public boolean delete(int id) {
        boolean isEventDeleted = eventDao.deleteEvent(id);
        
        return isEventDeleted;
    }
}
