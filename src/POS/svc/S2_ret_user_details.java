/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.to.to_users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;
import java.sql.PreparedStatement;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author u2
 */
public class S2_ret_user_details {

    public static List<to_users.u> get_user_data() {

        List<to_users.u> datas = new ArrayList();

        String s0 = "select user_name,user_level,user_code,check_in,check_out from " + MyDB.getNames() + ".users ";
        try {
            Connection conn = MyConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String username = rs.getString(1);
                String user_level = rs.getString(2);
                String name = rs.getString(3);
                int check_in = rs.getInt(4);
                int check_out = rs.getInt(5);
                to_users.u to = new to_users.u(username, user_level, name, check_in, check_out);
                System.out.println(username + " "+check_in + " "+check_out);
                datas.add(to);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

        return datas;
    }

    public static void update_check_in(String id, int check_in) {
        try {
            String s0 = "update " + MyDB.getNames() + ".users set check_in='" + check_in + "' where user_name='" + id + "'";
            Connection conn = MyConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_ret_user_details.class, "Successfully Updated " + id + " " + check_in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_check_out(String id, int check_out) {
        try {
            String s0 = "update " + MyDB.getNames() + ".users set check_out='" + check_out + "' where user_name='" + id + "'";
            Connection conn = MyConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_ret_user_details.class, "Successfully Updated " + id + " " + check_out);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static int userlevel = 0;
    public static String password = "";

    public static void get_user_data2(String user_name) {

        String s1 = "select  "
                    + "p.user_code"
                    + ",p.user_name"
                    + ",p.password"
                    + ",p.user_level from " + MyDB.getNames() + ".users p where user_name='" + user_name + "'";
        try {
            Connection conn = MyConnection.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s1);

            while (rs.next()) {
                password = rs.getString(3);
                userlevel = rs.getInt(4);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> get_cashiers() {

        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select user_name from " + MyDB.getNames() + ".users where user_level=0";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String num = rs.getString(1);
                datas.add(num);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(get_cashiers());
    }
}
