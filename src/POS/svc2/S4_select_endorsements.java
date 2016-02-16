/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;

/**
 *
 * @author u2
 */
public class S4_select_endorsements {

    //<editor-fold defaultstate="collapsed" desc="do_search_kilos">
    public static int do_search_kilos() {

        Date date = S5_ret_system_date.do_ret_system_date();

        
        try {

            // query -- sum ba ni?
            String s0 = "select ifnull(sum(he.total_kilos), 0) as total_kilos "
                    + "from "+MyDB.getNames()+".head_endorsements he "
                    + "where he.date_delivered ='"+date+"' ";

//            s0 = SqlStringUtil.parse(s0)
//                    .setDate("date_delivered", date)
//                    .ok();

            Lg.$.severe(s0);

            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("total_kilos");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
    
    public static void main(String[] args) {
        System.out.println(do_search_kilos());
    }
}
