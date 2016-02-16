/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class increment_number {

    public static int increment_number_key_product() {

        int key_number = 0;
        int size = 0;
        try {

            String s0 = "select key_number from db_pos_meatshop.key_products";


            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery(s0);
            while (rs.next()) {
                key_number = rs.getInt(1);
            }

            if (key_number == 0) {
                key_number++;
            }

//            JOptionPane.showMessageDialog(null, key_number + " "+size);
            
//            JOptionPane.showMessageDialog(null, key_number);
            String s1 = "select ifnull(key_size,1) from db_pos_meatshop.key_products where key_number = :key_number ";

            s1 = SqlStringUtil.parse(s1).setNumber("key_number", key_number).ok();

            Lg.$.severe(s1);
            pstmt = conn.prepareStatement(s1);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                size = rs.getInt(1);
            }

            if (size == 9) {
                key_number++;

            }
//            JOptionPane.showMessageDialog(null,key_number+ " "+ size);



//             JOptionPane.showMessageDialog(null, key_number + " "+size);
            return key_number;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int do_search_size(String num) {


        int size = 0;
        try {
            Connection conn = MyConnection.connect();
            String s1 = "select ifnull(key_size,0) as size from db_pos_meatshop.key_products where key_number='" + num + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s1);
            while (rs.next()) {
                size = rs.getInt(1);
            }
            if (size == 9) {
                size = 1;
            } else {
                size++;
            }


            return size;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static boolean if_exists(int key_number) {

        try {

            String s0 = "select kp.key_number "
                    + "from db_pos_meatshop.key_products kp "
                    + "where kp.key_number = :key_number; ";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("key_number", key_number).
                    ok();

            Connection conn = MyConnection.connect();

            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery(s0);

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int do_search_key_number() {

        int max = 0;

        try {
            Connection conn = MyConnection.connect();
            String s1 = "select Max(key_number) from  db_pos_meatshop.key_products";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s1);
            while (rs.next()) {
                max = rs.getInt(1);
            }
            return max;


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(do_search_key_number());
    }
}
