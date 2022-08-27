/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiket.helper;

/**
 *
 * @author fkrfd
 */
public class StrHelper {

    public String slug(String data) {
        data = data.toLowerCase();
        String[] temp = data.split(" ");
        
        return temp[0] + "-" + temp[1];
    }
    
    public String unSlug(String data) {
        String temp[] = data.split("-");
        
        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1);
        }
        
        return temp[0] + " " + temp[1];
    }
    
}
