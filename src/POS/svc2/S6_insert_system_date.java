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
public class S6_insert_system_date {

    //<editor-fold defaultstate="collapsed" desc="do_save_date">
    public static Date do_save_date() {

        try {

            String s0 = "select sd.curr_date from "+MyDB.getNames()+".system_date sd order by sd.curr_date asc limit 1; ";

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();

            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();

            Date retval = null;
            while (rs.next()) {
                retval = rs.getTimestamp("curr_date");
            }
            
            
            return retval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
    

    public static void main(String[] args) {
        System.out.println(do_save_date());
    }
}
