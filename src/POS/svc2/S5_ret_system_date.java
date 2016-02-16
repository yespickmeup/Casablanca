/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import mijzcx.synapse.desk.utils.DateUtil;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S5_ret_system_date {

    //<editor-fold defaultstate="collapsed" desc="do_ret_system_date">
    public static Date do_ret_system_date() {

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select sd.curr_date from "+MyDB.getNames()+".system_date sd order by sd.curr_date asc limit 1; ";

            Lg.$.severe(s0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                return rs.getTimestamp("curr_date");
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
     public static String do_ret_system_date2() {

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select sd.curr_date from "+MyDB.getNames()+".system_date sd ";

            Lg.$.severe(s0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                return rs.getString(1);
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
    
    

    //<editor-fold defaultstate="collapsed" desc="set_date">
    public static void set_date(Date date) {

        try {
            
            String s0 = "update "+MyDB.getNames()+".system_date sd set sd.curr_date = :curr_date ";
            
            s0 = SqlStringUtil.parse(s0)
                    .setDate("curr_date", date)
                    .ok();
            
            Lg.$.severe(s0);
            
            Connection conn = MyConnection.connect();
            
            PreparedStatement psmt = conn.prepareStatement(s0);
            psmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
    
    public static void main(String[] args) {
        set_date(DateUtil.asDateAsciiFormat("2012-01-31"));
    }
}
