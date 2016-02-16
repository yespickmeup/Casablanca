/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cashier;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S1_users {

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select user_code from " + MyDB.getNames() + ".users where user_level='" + "0" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String ret_data(String user_code) {
        String user = "";

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "user_name"
                        + " from " + MyDB.getNames() + ".users where "
                        + " user_code ='" + user_code + "' "
                        + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                user = rs.getString(1);
            }
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
