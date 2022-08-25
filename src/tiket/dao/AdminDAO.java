/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.dao;

import java.util.List;
import tiket.model.Admin;

/**
 *
 * @author fkrfd
 */
public interface AdminDAO {

    public int login(String email, String password);

    public boolean register(String name, String email, String password);

    public List<Admin> getAdmins();
    
    public Admin getAdmin(int id);
}
