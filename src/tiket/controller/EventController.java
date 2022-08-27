/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.controller;

import java.util.Date;
import tiket.dao.EventDAO;
import tiket.dao.query.EventQuery;
import java.util.List;
import tiket.helper.DTHelper;
import tiket.model.Event;

/**
 *
 * @author fkrfd
 */
public class EventController {

    private final EventDAO eventDao = new EventQuery();
    
    private final DTHelper dTHelper = new DTHelper();

    public List<Event> getAll() {
        List<Event> events = eventDao.getEvents();

        return events;
    }

    public Event get(int id) {
        Event event = eventDao.getEvent(id);

        return event;
    }

    public boolean insert(String name, String location, Date startedDate, String startedTime, Date finishedDate, String finishedTime) {
        String sDate = dTHelper.formatMysqlDate(startedDate);
        String fDate = dTHelper.formatMysqlDate(finishedDate);

        String startedAt = sDate + " " + startedTime;
        String finishedAt = fDate + " " + finishedTime;
        
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
