package org.rlopez.GUI.dao;

/**
 *
 * @author Richard Lopez
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost/dahouet";
        String login = "root";
        String passwd = "pouet";
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        return cn;
    }

}
