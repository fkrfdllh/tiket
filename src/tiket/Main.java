/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket;

import java.util.Date;
import tiket.view.LoginForm;
import tiket.view.authenticated.DashboardForm;

/**
 *
 * @author fkrfd
 */
public class Main {
    
    public static void main(String[] args) {
        
//        LoginForm form  = new LoginForm();
        DashboardForm form = new DashboardForm();
        form.setVisible(true);
        
    }
}
