/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.controller;

import java.util.Date;
import tiket.dao.StageDAO;
import tiket.dao.query.StageQuery;
import java.util.List;
import tiket.helper.DTHelper;
import tiket.model.Stage;

/**
 *
 * @author fkrfd
 */
public class StageController {

    private final StageDAO stageDao = new StageQuery();
    
    private final DTHelper dTHelper = new DTHelper();

    public List<Stage> getAll(int eventId) {
        List<Stage> stages = stageDao.getStages(eventId);

        return stages;
    }

    public Stage get(int id) {
        Stage stage = stageDao.getStage(id);

        return stage;
    }

    public boolean insert(int eventId, String name, int number, String location, Date startedDate, String startedTime, Date finishedDate, String finishedTime) {
        String sDate = dTHelper.formatMysqlDate(startedDate);
        String fDate = dTHelper.formatMysqlDate(finishedDate);

        String startedAt = sDate + " " + startedTime;
        String finishedAt = fDate + " " + finishedTime;
        
        boolean isStageInserted = stageDao.insertStage(eventId, name, number, location, startedAt, finishedAt);

        return isStageInserted;
    }

    public boolean update(Stage stage) {
        boolean isStageUpdated = stageDao.updateStage(stage);

        return isStageUpdated;
    }

    public boolean delete(int id) {
        boolean isStageDeleted = stageDao.deleteStage(id);

        return isStageDeleted;
    }
}
