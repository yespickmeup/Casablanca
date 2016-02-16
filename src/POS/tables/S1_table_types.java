/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.tables;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S1_table_types {

    public static class to_table_types {

        public final int id;
        public final String table_type;
        public final double percentage;

        public to_table_types(int id, String table_type, double percentage) {
            this.id = id;
            this.table_type = table_type;
            this.percentage = percentage;
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select table_type from " + MyDB.getNames() + ".table_types";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_data(String type) {
        double percent = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "percentage"
                        + " from " + MyDB.getNames() + ".table_types where "
                        + " table_type ='" + type + "' "
                        + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                percent = rs.getDouble(1);
            }
            return percent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
