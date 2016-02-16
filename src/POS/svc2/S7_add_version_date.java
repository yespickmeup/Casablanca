/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import POS.utl.Constants;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S7_add_version_date {

    //<editor-fold defaultstate="collapsed" desc="add_version_date">
    public static void add_version_date() {
        
        try {

            Date cdate = new Date();
            
            String s0 = "insert into "+MyDB.getNames()+".accounts( "
                    + "  account_name "
                    + " ,date_added ) "
                    + "values(:account_name, :date_added); ";

            String s1 = "insert into "+MyDB.getNames()+".system_date( "
                    + "  curr_date ) "
                    + "values( :curr_date ); ";
            
            
            s0 = SqlStringUtil.parse(s0)
                    .setString("account_name", Constants.TRIAL_VERSION)
                    .setDate("date_added", cdate)
                    .ok();

            s1 = SqlStringUtil.parse(s1)
                    .setDate( "curr_date", cdate)
                    .ok();
            
            Lg.$.severe(s0);
            Lg.$.severe(s1);
            
            Connection conn = MyConnection.connect();
            PreparedStatement psmt = conn.prepareStatement(s0);
            psmt.execute();
            
            psmt = conn.prepareStatement(s1);
            psmt.execute();


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
    public static void add_version_Full() {
        
        try {

            Date cdate = new Date();
            
            String s0 = "insert into "+MyDB.getNames()+".accounts( "
                    + "  account_name "
                    + " ,date_added ) "
                    + "values(:account_name, :date_added); ";

            String s1 = "insert into "+MyDB.getNames()+".system_date( "
                    + "  curr_date ) "
                    + "values( :curr_date ); ";
            
            
            s0 = SqlStringUtil.parse(s0)
                    .setString("account_name", "Full Version")
                    .setDate("date_added", cdate)
                    .ok();
               Prompt.call("Full");
//            JOptionPane.showMessageDialog(null, "Full");
            s1 = SqlStringUtil.parse(s1)
                    .setDate( "curr_date", cdate)
                    .ok();
            
            Lg.$.severe(s0);
            Lg.$.severe(s1);
            
            Connection conn = MyConnection.connect();
            PreparedStatement psmt = conn.prepareStatement(s0);
            psmt.execute();
            
            psmt = conn.prepareStatement(s1);
            psmt.execute();


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
    

    public static void main(String[] args) {
        add_version_date();
    }
}
