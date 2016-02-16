/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S9_cashier_session {

    public static String check_strict(String username, int user_lvl) {
        String exists = "-1";
//        
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + " from " + MyDB.getNames() + ".cashier_sessions where "
                        + " cashier_name <>'" + username + "' and login_status='" + "1" + "' and user_level='" + user_lvl + "'"
                        + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                exists = rs.getString(1);

            }
            return exists;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
//        System.out.println(check_strict("top"));
    }
}
