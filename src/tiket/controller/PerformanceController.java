/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiket.controller;

import tiket.dao.PerformanceDAO;
import tiket.dao.query.PerformanceQuery;
import java.util.List;
import tiket.model.Performance;

/**
 *
 * @author fkrfd
 */
public class PerformanceController {
    private final PerformanceDAO performanceDAO = new PerformanceQuery();
    
    public List<Performance> getAll() {
        return performanceDAO.getPerformances();
    }
    
    public Performance get(int id) {
        return performanceDAO.getPerformance(id);
    }
    
    public boolean insert(String name) {
        return performanceDAO.insertPerformance(name);
    }
    
    public boolean update(Performance performance) {
        return performanceDAO.updatePerformance(performance);
    }
    
    public boolean delete(int id) {
        return performanceDAO.deletePerformance(id);
    }
}
