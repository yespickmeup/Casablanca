/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection;

/**
 *
 * @author u2
 */
public class S3_insert_new_user {

    public static void insert_new_user(String user_name, String password, int user_level, String name, int check_in, int check_out) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into " + MyDB.getNames() + ".users(user_name,password,user_level,user_code,check_in,check_out)values(?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, user_name);
            stmt.setString(2, password);
            stmt.setInt(3, user_level);
            stmt.setString(4, name);
            stmt.setInt(5, check_in);
            stmt.setInt(6, check_out);
            stmt.execute();

            Prompt.call("Succesfully Saved");
//            JOptionPane.showMessageDialog(null, "Succesfully Saved");
        } catch (Exception e) {

            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_name(String un) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select user_code from " + MyDB.getNames() + ".users where user_name='" + un + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name = rs.getString(1);

            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(get_name("admin1"));
    }

    public static String get_id(String names) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select id from " + MyDB.getNames() + ".users where user_code='" + names + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name = rs.getString(1);

            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
