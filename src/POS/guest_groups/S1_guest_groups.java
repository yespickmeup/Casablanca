/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guest_groups;

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
 * @author Maytopacka
 */
public class S1_guest_groups {

    public static class to_guest_groups {

        public final int id;
        public final String group_name;

        public to_guest_groups(int id, String group_name) {
            this.id = id;
            this.group_name = group_name;
        }
    }

    public static void add_data(to_guest_groups to_guest_groups) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".guest_groups("
                    + "group_name"
                    + ")values("
                    + ":group_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("group_name", to_guest_groups.group_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest_groups.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_guest_groups to_guest_groups) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".guest_groups set "
                    + "group_name= '" + to_guest_groups.group_name + "'"
                    + "where "
                    + " id ='" + to_guest_groups.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest_groups.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_guest_groups to_guest_groups) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".guest_groups where "
                    + " id ='" + to_guest_groups.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest_groups.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_guest_groups> ret_data(String search) {
        List<to_guest_groups> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",group_name"
                    + " from " + MyDB.getNames() + ".guest_groups where "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String group_name = rs.getString(2);

                to_guest_groups to = new to_guest_groups(id, group_name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
    
}
