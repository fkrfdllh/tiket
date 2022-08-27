/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiket.controller;

import java.util.List;
import tiket.dao.AdminDAO;
import tiket.dao.query.AdminQuery;
import tiket.model.Admin;

/**
 *
 * @author fkrfd
 */
public class AdminController {

    private final AdminDAO adminDao = new AdminQuery();
    
    public boolean register(String name, String email, String password) {
        return adminDao.register(name, email, password);
    }

    public List<Admin> getAdmins() {
        return adminDao.getAdmins();
    }
    
    public boolean update(Admin admin) {
        return adminDao.update(admin);
    }
    
    public boolean delete(int id) {
        return adminDao.delete(id);
    }
    
}
