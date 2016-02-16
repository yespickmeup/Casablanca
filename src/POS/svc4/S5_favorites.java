/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc4;

import POS.Main.MyDB;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S5_favorites {

    public static void do_add(String num) {
        if (if_exists(num) == true) {
             Prompt.call("Already Added");
//            JOptionPane.showMessageDialog(null, "Already Added");
            return;
        }
        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into "+MyDB.getNames()+".favorites(prod_code)values(?)";
            PreparedStatement stmt = conn.prepareStatement(s0);

            stmt.setString(1, num);
            stmt.execute();
             Prompt.call("ADDED TO FAVORITES");
//            JOptionPane.showMessageDialog(null, "ADDED TO FAVORITES");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_delete(String num) {
//        JOptionPane.showMessageDialog(null, "adadad");

        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from "+MyDB.getNames()+".favorites where prod_code='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);

//            stmt.setString(1, num);
            stmt.execute();
            
               Prompt.call("DELETED");
//            JOptionPane.showMessageDialog(null, "DELETED");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

     public static int count() {
//        JOptionPane.showMessageDialog(null, "adadad");
         int count=0;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select Count(id) from "+MyDB.getNames()+".favorites ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static boolean if_exists(String num) {
        boolean exists = false;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select prod_code from "+MyDB.getNames()+".favorites where prod_code='" + num + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
//                String num = rs.getString(1);
                exists = true;
            }
            return exists;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(count());
    }
}
