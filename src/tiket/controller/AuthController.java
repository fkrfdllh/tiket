/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.controller;

import tiket.dao.query.AdminQuery;
import tiket.dao.AdminDAO;

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
