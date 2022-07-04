/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dao.query.UserQuery;

/**
 *
 * @author fkrfd
 */
public class AuthController {
    private UserDAO userDao = new UserQuery();
    
    public int login(String username, String password) {
        return userDao.login(username, password);
    }
}
