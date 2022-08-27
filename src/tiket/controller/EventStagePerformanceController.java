/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.controller;

import java.util.Date;
import tiket.dao.EventStagePerformanceDAO;
import tiket.dao.query.EventStagePerformanceQuery;
import java.util.List;
import tiket.helper.DTHelper;
import tiket.model.EventStagePerformance;

/**
 *
 * @author fkrfd
 */
public class EventStagePerformanceController {

    private final EventStagePerformanceDAO eventStagePerformanceDAO = new EventStagePerformanceQuery();
    
    private final DTHelper dTHelper = new DTHelper();

    public List<EventStagePerformance> getAll(int eventId, int stageId) {
        return eventStagePerformanceDAO.getEventStagePerformances(eventId, stageId);
    }

    public EventStagePerformance get(int id) {
        return eventStagePerformanceDAO.getEventStagePerformance(id);
    }

    public boolean insert(int eventId, int stageId, int performanceId, Date startedDate, String startedTime) {
        String sDate = dTHelper.formatMysqlDate(startedDate);
        
        String startedAt = sDate + " " + startedTime;
        
        return eventStagePerformanceDAO.insertEventStagePerformance(eventId, stageId, performanceId, startedAt);
    }

    public boolean update(EventStagePerformance eventStagePerformance) {
        return eventStagePerformanceDAO.updateEventStagePerformance(eventStagePerformance);
    }

    public boolean delete(int id) {
        return eventStagePerformanceDAO.deleteEventStagePerformance(id);
    }

}
