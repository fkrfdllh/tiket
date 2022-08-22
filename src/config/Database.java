package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fkrfd
 */
public class Database {

    private static Connection connection = null;

    public Database() {
        if (!isConnect()) {
            System.err.println("Database isn't connected");
        }
    }

    public static Connection getConnection() {
        if (connection == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                connection = DriverManager.getConnection("jdbc:mysql://" + Environment.HOST + ":" + String.valueOf(Environment.PORT) +  "/" + Environment.DB_NAME, Environment.DB_USER, Environment.DB_PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();

                return null;
            }

        }

        return connection;
    }

    public static boolean isConnect() {
        try {
            if (getConnection() != null) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
}
