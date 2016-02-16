/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S3_getpending {

    //<editor-fold defaultstate="collapsed" desc="get_pending_count">
    public static int get_pending_count() {

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select count(p.customer_name) as customer_count "
                    + "from "+MyDB.getNames()+".pending_orders p ";

            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery(s0);
            rs.next();

            return rs.getInt("customer_count");

        } catch (Exception e) {
            
               Prompt.call("No Connection");
//            JOptionPane.showMessageDialog(null, "No Connection");
             return 0;
//            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
    
}
