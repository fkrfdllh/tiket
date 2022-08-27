/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiket.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author fkrfd
 */
public class DTHelper {

    public String formatToSQL(String data, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        SimpleDateFormat SQLFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date parsed;
        String SQLFormat = null;

        try {
            parsed = formatter.parse(data);
            SQLFormat = SQLFormatter.format(parsed);
        } catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }

        return SQLFormat;
    }
    
    public String formatMysqlDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public String setTimeFromDB(String time) {
        String[] tempTime = time.split(":");
        String[] copyTempTime = Arrays.copyOf(tempTime, tempTime.length - 1);

        return String.join(":", copyTempTime);
    }

    public String formatMysqlDate(String startedDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
