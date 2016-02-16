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
public class S5_printing_assemlby {

    public static class to_printing_assembly {

        public final int id;
        public final String place;

        public to_printing_assembly(int id, String place) {
            this.id = id;
            this.place = place;
        }
    }

    public static void add_data(to_printing_assembly to_printing_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".printing_assembly("
                    + "place"
                    + ")values("
                    + ":place"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("place", to_printing_assembly.place).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S5_printing_assemlby.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_printing_assembly to_printing_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".printing_assembly set "
                    + "place= '" + to_printing_assembly.place + "'"
                    + "where "
                    + " id ='" + to_printing_assembly.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S5_printing_assemlby.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_printing_assembly to_printing_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".printing_assembly where "
                    + " id ='" + to_printing_assembly.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S5_printing_assemlby.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_printing_assembly> ret_data(String search) {
        List<to_printing_assembly> datas = new ArrayList();
        S5_printing_assemlby.to_printing_assembly a = new S5_printing_assemlby.to_printing_assembly(0, "Normal");
        datas.add(a);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",place"
                    + " from " + MyDB.getNames() + ".printing_assembly  "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String place = rs.getString(2);

                to_printing_assembly to = new to_printing_assembly(id, place);
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
            String s0 = "select id from " + MyDB.getNames() + ".printing_assembly";
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

    public static void update_printing_assembly_item(String prod_num, int assembly_id) {

        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set printing_assembly='" + assembly_id + "' where product_name='" + prod_num + "' ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S5_printing_assemlby.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_category_printing_assembly_item(String cat_id, int assembly_id) {

        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set printing_assembly='" + assembly_id + "' where cat_id='" + cat_id + "' ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update " + MyDB.getNames() + ".category set printing_assembly='" + assembly_id + "' where cat_num='" + cat_id + "' ";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S5_printing_assemlby.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int get_category_assembly_id(String cat_id) {
        int id = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select printing_assembly from " + MyDB.getNames() + ".category  where cat_num='" + cat_id + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static int get_category_group_id(String cat_id) {
        int id = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select group_id from " + MyDB.getNames() + ".category  where cat_num='" + cat_id + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_order_status(String table_id, String printing_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".customer_tables_details set "
                    + "status='" + "2" + "' where table_no_id='" + table_id + "' "
                    + "and printing_assembly='" + printing_assembly + "' and status='" + "0" + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S5_printing_assemlby.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
