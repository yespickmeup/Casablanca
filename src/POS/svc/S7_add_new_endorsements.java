/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.svc2.S5_ret_system_date;
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
public class S7_add_new_endorsements {

    public static void add_new_endorsements(String prod_name,
            double no_of_head_endorsed, double num_prod_per_head,
            double total_kilos, String remarks, String remarks2, Date date_delivered) {
        
        date_delivered = S5_ret_system_date.do_ret_system_date();
        

        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into "+MyDB.getNames()+".head_endorsements( "
                    + "  date_delivered "
                    + " ,no_of_heads_endorsed "
                    + " ,total_kilos "
                    + " ,remarks "
                    + " ,remarks2 "
                    + ")values( "
                    + "  :date_delivered "
                    + " ,:no_of_head_endorsed "
                    + " ,:total_kilos "
                    + " ,:remarks "
                    + " ,:remarks2 ); "; 
            
            s0 = SqlStringUtil.parse(s0)
                    .setDate("date_delivered", date_delivered)
                    .setNumber("no_of_head_endorsed", no_of_head_endorsed)
                    .setNumber("total_kilos", total_kilos)
                    .setString("remarks", remarks)
                    .setString("remarks2", remarks2 )
                    .ok();

            Lg.$.severe(s0);
            PreparedStatement pstmt = conn.prepareStatement(s0);
            pstmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
