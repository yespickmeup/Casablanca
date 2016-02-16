/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.table_location;

import POS.Main.MyDB;
import POS.utl.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S1_table_location {

    public static class to_table_locations {

        public final int id;
        public final String location;

        public to_table_locations(int id, String location) {
            this.id = id;
            this.location = location;
        }
    }

    public static void add_data(to_table_locations to_table_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".table_locations("
                        + "location"
                        + ")values("
                        + ":location"
                        + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("location", to_table_locations.location).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_location.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_table_locations to_table_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".table_locations set "
                        + "location= '" + to_table_locations.location + "'"
                        + "where "
                        + " id ='" + to_table_locations.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_location.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_table_locations to_table_locations) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".table_locations where "
                        + " id ='" + to_table_locations.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_location.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_table_locations> ret_data(String search) {
        List<to_table_locations> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",location"
                        + " from " + MyDB.getNames() + ".table_locations where "
                        + " location like'%" + search + "%' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String location = rs.getString(2);

                to_table_locations to = new to_table_locations(id, location);
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
            String s0 = "select location from " + MyDB.getNames() + ".table_locations";
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

    public static List<to_table_locations> ret_locations() {
        List<to_table_locations> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select id,location from " + MyDB.getNames() + ".table_locations";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String location = rs.getString(2);
                to_table_locations to = new to_table_locations(id, location);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int ret_location_id(String location) {
        int id = 0;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + " from " + MyDB.getNames() + ".table_locations where "
                        + " location ='" + location + "' "
                        + " ";

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

    public static String ret_location_name(String id) {
        String location = "";

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "location"
                        + " from " + MyDB.getNames() + ".table_locations where "
                        + " id ='" + id + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                location = rs.getString(1);
            }
            return location;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
