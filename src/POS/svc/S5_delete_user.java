/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import POS.utl.MyConnection;

/**
 *
 * @author u2
 */
public class S5_delete_user {

    //<editor-fold defaultstate="collapsed" desc="delete_user">
    public static void delete_user(String cur_user, String new_user_name, String password, int user_level, String name) {
        try {
            Connection conn = MyConnection.connect();
//            String s0 =
//                    "call pb_pos_restaurant.update_user_details( "
//                    + "  :a_current_user_name "
//                    + "  ,:a_user_name "
//                    + "  ,:a_password "
//                    + "  ,:a_user_level "
//                    + "); ";
//            
//            
//            s0=SqlStringUtil.parse(s0)
//                     .setString("a_current_user_name", cur_user)
//                     .setString("a_user_name", new_user_name)
//                     .setString("a_password", password)
//                     .setNumber("a_user_level", user_level)
//                    .ok();

            String s1 = "update " + MyDB.getNames() + ".users set "
                        + "user_name='" + new_user_name + "'"
                        + ",password='" + password + "' "
                        + ",user_level='" + user_level + "'"
                        + ",user_code='" + name + "'"
                        + " where user_name='" + cur_user + "'";
            PreparedStatement stmt = conn.prepareStatement(s1);
            stmt.execute();
            Prompt.call("Account Updated");
//            JOptionPane.showMessageDialog(null, "Account Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
}
