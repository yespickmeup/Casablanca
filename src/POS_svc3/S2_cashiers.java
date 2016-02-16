/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc3;

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
public class S2_cashiers {

    public static class to_cashiers {

        public final String cashier_name;
        public final String id;
        public boolean check;

        public to_cashiers(String cashier_name, String id, boolean check) {
            this.cashier_name = cashier_name;
            this.id = id;
            this.check = check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }
    }

    public static List<to_cashiers> get_cashiers() {
        List<to_cashiers> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select user_code,id from "+MyDB.getNames()+".users where user_level='" + "0" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String id = rs.getString(2);

                to_cashiers to = new to_cashiers(name, id, false);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> get_cashiers_names() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select user_code,id from "+MyDB.getNames()+".users where user_level='" + "0" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);

                datas.add(name);
            }
            datas.add("DIRECT SALES");
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_cashiers_id(String name) {
        String id = "";
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select id from "+MyDB.getNames()+".users where user_code='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                id = rs.getString(1);

//                datas.add(name);
            }
            return id;
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
