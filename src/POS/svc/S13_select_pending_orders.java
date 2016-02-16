/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;

/**
 *
 * @author u2
 */
public class S13_select_pending_orders {


    //<editor-fold defaultstate="collapsed" desc="get_values">
   
    //</editor-fold>

    public static ListModel get_pending_request(String text) {
        System.out.println(text+ " ad");
         DefaultListModel retval=new DefaultListModel();
        try {
            
            String s0 = "select p.customer_name "
                    + "from "+MyDB.getNames()+".pending_orders p "
                    + "where customer_name like '"+text+"%' ";
            
//            s0 = SqlStringUtil.parse(s0)
//                    .setString("customer_name", text + "%")
//                    .ok();
//            
            Lg.$.info(s0);
            
            Connection conn = MyConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
           
            while(rs.next()) {
                String cust = rs.getString(1);
                System.out.println(cust);
                retval.addElement(cust);
            }
            
            return retval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
        
    }
    
    
    
}
