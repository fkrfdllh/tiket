/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Performance;

/**
 *
 * @author fkrfd
 */
public interface PerformanceDAO {

    public List<Performance> getPerformances();

    public Performance getPerformance(int id);

    public boolean insertPerformance(String name);

    public boolean updatePerformance(Performance performance);

    public boolean deletePerformance(int id);
}
