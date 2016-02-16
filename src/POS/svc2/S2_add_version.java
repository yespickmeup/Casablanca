/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import POS.utl.Constants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S2_add_version {
    
    //<editor-fold defaultstate="collapsed" desc="do_add_version">
    public static void do_add_version(){
        

        try {
            
            String s0 = "insert into "+MyDB.getNames()+".accounts(account_name, date_added ) "
                    + "values( :account_name, :date_added ); ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("account_name", Constants.TRIAL_VERSION)
                    .setDate("date_added", new Date())
                    .ok();
            
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
        do_add_version();
    }
}
