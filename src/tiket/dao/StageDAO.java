/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao;

import java.util.List;
import tiket.model.Stage;

/**
 *
 * @author fkrfd
 */
public interface StageDAO {

    public List<Stage> getStages(int eventId);

    public Stage getStage(int id);

    public boolean insertStage(int eventId, String name, int number, String location, String startedAt, String finishedAt);

    public boolean updateStage(Stage stage);

    public boolean deleteStage(int id);
}
