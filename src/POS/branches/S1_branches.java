/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.branches;

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
public class S1_branches {

    public static class to_branches {

        public final int id;
        public final String branch_name;
        public final String manager;
        public final String ip_address;

        public to_branches(int id, String branch_name, String manager, String ip_address) {
            this.id = id;
            this.branch_name = branch_name;
            this.manager = manager;
            this.ip_address = ip_address;
        }
    }

    public static void add_data(to_branches to_branches) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".branches("
                        + "branch_name"
                        + ",manager"
                        + ",ip_address"
                        + ")values("
                        + ":branch_name"
                        + ",:manager"
                        + ",:ip_address"
                        + ")";

            s0 = SqlStringUtil.parse(s0).setString("branch_name", to_branches.branch_name).setString("manager", to_branches.manager).setString("ip_address", to_branches.ip_address).ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_branches.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_branches to_branches) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".branches set "
                        + "branch_name= '" + to_branches.branch_name + "'"
                        + ",manager= '" + to_branches.manager + "'"
                        + ",ip_address= '" + to_branches.ip_address + "'"
                        + "where "
                        + " id ='" + to_branches.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_branches.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_branches to_branches) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".branches where "
                        + " id ='" + to_branches.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_branches.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_branches> ret_data(String search) {
        List<to_branches> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",branch_name"
                        + ",manager"
                        + ",ip_address"
                        + " from " + MyDB.getNames() + ".branches where "
                        + " branch_name like'%" + search + "%' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String branch_name = rs.getString(2);
                String manager = rs.getString(3);
                String ip_address = rs.getString(4);

                to_branches to = new to_branches(id, branch_name, manager, ip_address);
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
