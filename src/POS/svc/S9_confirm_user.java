/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S9_confirm_user {

    public static boolean conf_user(String user_name, String password) {

        try {
            String s0 = "select u.user_name "
                        + "from " + MyDB.getNames() + ".users u "
                        + "where u.user_name= :user_name "
                        + "and u.password = :password ";

            s0 = SqlStringUtil.parse(s0).setString("user_name", user_name).setString("password", password).ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static void main(String[] args) {
        System.out.println(conf_user("pas121", "adad"));
    }
}
