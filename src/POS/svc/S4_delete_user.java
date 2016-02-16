/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;

/**
 *
 * @author u2
 */
public class S4_delete_user {

    public static void delete_user(String user_name) {
        try {
            Connection conn = MyConnection.connect();
            String s0 ="delete from "+MyDB.getNames()+".users where user_name='"+user_name+"'";
                  

           PreparedStatement stmt=conn.prepareStatement(s0);
           stmt.execute();
           
           Lg.i(S4_delete_user.class, "deleted");
//            JOptionPane.showMessageDialog(null, "deleted");
            

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
    public static void main(String[] args) {
        delete_user("user");
    }
}
