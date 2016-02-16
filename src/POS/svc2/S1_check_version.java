/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import POS.to2.to_version;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S1_check_version {
    
    //<editor-fold defaultstate="collapsed" desc="ret_version_details">
    public static List<to_version> ret_version_details(){
        
        List<to_version> datas=new ArrayList();
        
        try {
            Connection conn = MyConnection.connect();
            
            String s0 = "select a.account_name, a.exp_date, a.date_added from "+MyDB.getNames()+".accounts a";
            
            Lg.$.severe(s0);
            
            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery(s0);
            
            while (rs.next()) {
                String name = rs.getString("account_name");
                Date exp_date = rs.getTimestamp("exp_date");
                Date date_added = rs.getTimestamp("date_added");
                
                to_version to=new to_version(name, exp_date, date_added);
                datas.add(to);
            }
            
            return datas;
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
    
    
}
