/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc3;

import POS.Main.MyDB;
import POS.to2.to_discount;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S2_get_discounts {

    public static List<to_discount> get_discounts() {
        List<to_discount> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select name,rate,id from " + MyDB.getNames() + ".discounts order by rate asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String rate = rs.getString(2);
                String rate2 = rs.getString(2) + " %";
                String num = rs.getString(3);
                to_discount to = new to_discount(name, rate, rate2, num);
                datas.add(to);

            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static List<String> get_discounts_for_cb() {
        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select name from " + MyDB.getNames() + ".discounts order by rate asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);

//                to_discount to = new to_discount(name, rate, num);
                datas.add(name);

            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static String get_discounts_rate(String name) {
//        List<String> datas = new ArrayList();
        String rate = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "d.rate "
                    + "from "
                    + "" + MyDB.getNames() + ".discounts d "
                    + "where "
                    + "d.name='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                rate = rs.getString(1);
            }
            return rate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static void add_discount(String name, String rate) {

        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".discounts(name,rate)values(?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setString(2, rate);
            stmt.execute();

            Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_discount(String name, String rate, String num) {

//        JOptionPane.showMessageDialog(null, name + " "+rate+ " "+num);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".discounts"
                    + " set "
                    + "rate='" + rate + "'"
                    + ",name='" + name + "'"
                    + " where id='" + num + "' ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_discount(String num) {

        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".discounts where id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            Prompt.call("Successfully Deleted");
//            JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
