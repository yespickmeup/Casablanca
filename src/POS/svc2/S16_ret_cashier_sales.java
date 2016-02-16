/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S16_ret_cashier_sales {
    
    
    //<editor-fold defaultstate="collapsed" desc="ret_sales">
    public static double ret_sales(int user_id){
        
        try {
            
            String s0 = "select r.tendered from "+MyDB.getNames()+".receipts r where r.cashier_session_id = :user_id; ";
            String s1 = "select cd.cash_in from "+MyDB.getNames()+".cash_drawer cd where cd.cashier_session_id = :user_id; ";
            
            s0 = SqlStringUtil.parse(s0)
                    .setNumber("user_id", user_id)
                    .ok();
            
            s1 = SqlStringUtil.parse(s1)
                    .setNumber("user_id", user_id)
                    .ok();
            
            Lg.$.severe(s0);
            Lg.$.severe(s1);
            
            Connection conn = MyConnection.connect();
       
            double tendered = 0;
            double cash_in = 0;
            
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tendered += rs.getDouble("tendered");
            }
            
            pstmt = conn.prepareStatement(s1);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cash_in += rs.getDouble("cash_in");
            }
            
            return tendered + cash_in;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }     
        
    }
    //</editor-fold>
    
    public static void main(String[] args) {
        System.out.println(ret_sales(47));
    }
}
