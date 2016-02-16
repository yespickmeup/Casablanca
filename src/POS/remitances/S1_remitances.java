/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.remitances;

import POS.Main;
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
public class S1_remitances {

    public static class to_remitances {

        public final int id;
        public final String user_id;
        public final String user_name;
        public final String user_lvl;
        public final double amount;
        public final String date_added;
        public final String screen_name;

        public to_remitances(int id, String user_id, String user_name, String user_lvl, double amount, String date_added, String screen_name) {
            this.id = id;
            this.user_id = user_id;
            this.user_name = user_name;
            this.user_lvl = user_lvl;
            this.amount = amount;
            this.date_added = date_added;
            this.screen_name = screen_name;
        }
    }

    public static void add_data(to_remitances to_remitances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".remitances("
                        + "user_id"
                        + ",user_name"
                        + ",user_lvl"
                        + ",amount"
                        + ",date_added"
                        + ",screen_name"
                        + ")values("
                        + ":user_id"
                        + ",:user_name"
                        + ",:user_lvl"
                        + ",:amount"
                        + ",:date_added"
                        + ",:screen_name"
                        + ")";

            s0 = SqlStringUtil.parse(s0).setString("user_id", to_remitances.user_id).setString("user_name", to_remitances.user_name).setString("user_lvl", to_remitances.user_lvl).setNumber("amount", to_remitances.amount).setString("date_added", to_remitances.date_added).setString("screen_name", to_remitances.screen_name).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_remitances.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_remitances to_remitances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".remitances set "
                        + "user_id= '" + to_remitances.user_id + "'"
                        + ",user_name= '" + to_remitances.user_name + "'"
                        + ",user_lvl= '" + to_remitances.user_lvl + "'"
                        + ",amount= '" + to_remitances.amount + "'"
                        + ",date_added= '" + to_remitances.date_added + "'"
                        + "where "
                        + " id ='" + to_remitances.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_remitances.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_remitances to_remitances) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".remitances where "
                        + " id ='" + to_remitances.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_remitances.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_remitances> ret_data(String search, String date) {
        List<to_remitances> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",user_id"
                        + ",user_name"
                        + ",user_lvl"
                        + ",amount"
                        + ",date_added"
                        + ",screen_name"
                        + " from " + MyDB.getNames() + ".remitances where "
                        + " date(date_added) ='" + date + "' and user_name like '%" + search + "%'"
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_name = rs.getString(3);
                String user_lvl = rs.getString(4);
                double amount = rs.getDouble(5);
                String date_added = rs.getString(6);
                String screen_name = rs.getString(7);
                to_remitances to = new to_remitances(id, user_id, user_name, user_lvl, amount, date_added, screen_name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_remitances> ret_data2(String search, String date) {
        List<to_remitances> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",cashier_name"
                        + ",user_level"
                        + ",created"
                        + " from " + MyDB.getNames() + ".cashier_sessions where "
                        + " date(created) ='" + date + "' and cashier_name like '%" + search + "%' and login_status='"+"1"+"'"
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = "";
                String user_name = rs.getString(2);
                String screen_name = "";
                String s2 = "select id,user_code from " + MyDB.getNames() + ".users where user_name ='" + user_name + "' ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    user_id = rs2.getString(1);
                    screen_name = rs2.getString(2);
                }
                String user_lvl = rs.getString(3);
                double amount = 0;
                String date_added = rs.getString(4);
                to_remitances to = new to_remitances(id, user_id, user_name, user_lvl, amount, date_added, screen_name);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String[] user_checker(String username, String password) {
        String[] lvl = new String[3];
        lvl[0] = "-1";
        lvl[1] = "-1";
        lvl[2] = "-1";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",user_level"
                        + ",user_code"
                        + " from " + MyDB.getNames() + ".users where "
                        + " user_name ='" + username + "' "
                        + " and password ='" + password + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                lvl[0] = rs.getString(1);
                lvl[1] = rs.getString(2);
                lvl[2] = rs.getString(3);
            }
            return lvl;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}