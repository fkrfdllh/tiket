/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao;

import java.util.List;
import tiket.model.EventStagePerformance;

/**
 *
 * @author fkrfd
 */
public interface EventStagePerformanceDAO {

    public List<EventStagePerformance> getEventStagePerformances(int eventId, int stageId);

    public EventStagePerformance getEventStagePerformance(int id);

    public boolean insertEventStagePerformance(int eventId, int stageId, int performanceId, String startedAt);

    public boolean updateEventStagePerformance(EventStagePerformance eventStagePerformance);

    public boolean deleteEventStagePerformance(int id);
}
