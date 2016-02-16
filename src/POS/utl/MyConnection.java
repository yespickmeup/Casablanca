/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.logicalcobwebs.proxool.ProxoolFacade;

/**
 *
 * @author i1
 */
public class MyConnection {

    private void config_pool_connection() {
        try {
            Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
            Properties info = new Properties();
            info.setProperty("proxool.maximum-connection-count", "5000000");

            String host = System.getProperty("pool_host", "localhost");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");

            info.setProperty("user", user);
            info.setProperty("password", password);
            String alias = "pool_connection";
            String driverClass = "com.mysql.jdbc.Driver";

            String driverUrl = "jdbc:mysql://" + host + "/";
            String url = "proxool." + alias + ":" + driverClass + ":" + driverUrl;
            ProxoolFacade.registerConnectionPool(url, info);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private MyConnection() {
        config_pool_connection();
    }
    private static MyConnection connection;

    private static void init() {
        if (connection == null) {
            connection = new MyConnection();
        }
    }
    private static Connection conn;

    public static Connection connect() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost:3306");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/";

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        connect();
    }
}
