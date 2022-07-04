/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author fkrfd
 */
public interface UserDAO {

    public int login(String username, String password);

    public boolean register(User user);

    public List<User> getUsers();
    
    public User getUser(String id);
}
