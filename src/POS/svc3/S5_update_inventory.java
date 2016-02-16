/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S5_update_inventory {

    public static void do_update_grade(String name, String count, String variance, Date d, String time) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "update " + MyDB.getNames() + ".inventory set physical_count=:a_count,variance=:a_variance "
                        + "where name=:a_name  and date(date_added) between date(:a_date) and date(:a_date) and time(date_added)=:a_time";

            s0 = SqlStringUtil.parse(s0).setString("a_name", name).setString("a_count", count).setString("a_variance", variance).setDate("a_date", d).setString("a_time", time).ok();


            PreparedStatement stmt = conn.prepareStatement(s0);

            stmt.execute();

            Prompt.call("Updated");
//            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
