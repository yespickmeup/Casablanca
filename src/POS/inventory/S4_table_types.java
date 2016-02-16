/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S4_table_types {

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

    public static void add_data(to_table_types to_table_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".table_types("
                        + "table_type"
                        + ",percentage"
                        + ")values("
                        + ":table_type"
                        + ",:percentage"
                        + ")";

            s0 = SqlStringUtil.parse(s0).setString("table_type", to_table_types.table_type).setNumber("percentage", to_table_types.percentage).ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S4_table_types.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_table_types to_table_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".table_types set "
                        + "table_type= '" + to_table_types.table_type + "'"
                        + ",percentage= '" + to_table_types.percentage + "'"
                        + "where "
                        + " id ='" + to_table_types.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S4_table_types.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_table_types to_table_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".table_types where "
                        + " id ='" + to_table_types.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S4_table_types.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static List<to_table_types> ret_data() {
        List<to_table_types> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",table_type"
                        + ",percentage"
                        + " from " + MyDB.getNames() + ".table_types "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String table_type = rs.getString(2);
                double percentage = rs.getDouble(3);

                to_table_types to = new to_table_types(id, table_type, percentage);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
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

    public static double ret_percentage(String name) {
        double rate = 0;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select percentage from " + MyDB.getNames() + ".table_types where table_type='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                rate = rs.getDouble(1);
            }
            return rate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
//      public static String ret_percentage(String name) {
//         String cat_id="0";
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 = "select id from " + MyDB.getNames() + ".category where table_type='" + name + "'";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            if (rs.next()) {
//                rate = rs.getDouble(1);
//            }
//            return rate;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
}
