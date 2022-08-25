/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.controller;

import tiket.dao.EventStagePerformanceDAO;
import tiket.dao.query.EventStagePerformanceQuery;
import java.util.List;
import tiket.model.EventStagePerformance;

/**
 *
 * @author fkrfd
 */
public class EventStagePerformanceController {

    private final EventStagePerformanceDAO eventStagePerformanceDAO = new EventStagePerformanceQuery();

    public List<EventStagePerformance> getAll() {
        return eventStagePerformanceDAO.getEventStagePerformances();
    }

    public EventStagePerformance get(int id) {
        return eventStagePerformanceDAO.getEventStagePerformance(id);
    }

    public boolean insert(int eventId, int stageId, int performanceId) {
        return eventStagePerformanceDAO.insertEventStagePerformance(eventId, stageId, performanceId);
    }

    public boolean update(EventStagePerformance eventStagePerformance) {
        return eventStagePerformanceDAO.updateEventStagePerformance(eventStagePerformance);
    }

    public boolean delete(int id) {
        return eventStagePerformanceDAO.deleteEventStagePerformance(id);
    }

}
