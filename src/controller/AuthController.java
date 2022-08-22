/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.query.AdminQuery;
import dao.AdminDAO;

/**
 *
 * @author fkrfd
 */
public class AuthController {

    private final AdminDAO userDao = new AdminQuery();

    public int login(String email, String password) {
        return userDao.login(email, password);
    }
}
