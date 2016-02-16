/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

import POS.Main.MyDB;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S1_update_category {

    public static void do_edit(String name, String num,String img_path) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".category set cat_name='" + name + "',img_path='" + img_path + "' where cat_num='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s1 = "update "+MyDB.getNames()+".category_type set cat_name='" + name + "' where cat_num='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Updated Successfully");
//            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_delete_category(String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from "+MyDB.getNames()+".category where cat_num='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s1 = "delete from "+MyDB.getNames()+".category_type where cat_num='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Updated Successfully");
//            JOptionPane.showMessageDialog(null, "Updated Successfully");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_edit_type(String name, String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".category_type set type_name='" + name + "' where type_num='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s1 = "update "+MyDB.getNames()+".inventory2 set types='" + name + "' where types_num='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

            String s2 = "update "+MyDB.getNames()+".inventory2_stocks_left set types='" + name + "' where types_num='" + num + "'";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Prompt.call("Updated Successfully");

//            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_delete_category_type(String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from "+MyDB.getNames()+".category_type where type_num='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s1 = "delete from "+MyDB.getNames()+".inventory2_stocks_left where types_num='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

            String s2 = "delete from "+MyDB.getNames()+".inventory2 where types_num='" + num + "'";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Prompt.call("Updated Successfully");

//            JOptionPane.showMessageDialog(null, "Updated Successfully");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
