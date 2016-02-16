/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.Main.MyDB;
import POS.to2.to_add_product;
import POS.utl.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.PoolConnection;

/**
 *
 * @author Dummy
 */
public class S6_items {

    public static void edit_data(to_add_product to_add_product, String is_linient, String is_active, String type, String type_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set "
                        + "product_name= '" + to_add_product.name + "'"
                        + ",description= '" + to_add_product.desc + "'"
                        + ",price= '" + to_add_product.price + "'"
                        + ",product_qty= '" + to_add_product.qty + "'"
                        + ",is_vat= '" + to_add_product.vat + "'"
                        + ",prod_assembly= '" + "0" + "'"
                        + ",is_linient= '" + is_linient + "'"
                        + ",w_commission= '" + to_add_product.w_commission + "'"
                        + ",comm_amount= '" + to_add_product.comm_amount + "'"
                        + ",cat_id= '" + to_add_product.cat_id + "'"
                        + ",cost= '" + to_add_product.cost + "'"
                        + ",img_path= '" + "empty" + "'"
                        + ",printing_assembly= '" + to_add_product.printing_assembly + "'"
                        + ",is_active= '" + is_active + "'"
                        //                        + ",types= '" + type + "'"
                        //                        + ",types_num= '" + type_id + "'"
                        + "where "
                        + " product_name ='" + to_add_product.name + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S6_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_type(String num, String cat_id, String type, String type_id) {
//        JOptionPane.showMessageDialog(null, num + ", " + cat_id + " = " + type + " " + type_id);C
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set "
                        + "types= '" + type + "' "
                        + ",types_num= '" + type_id + "' "
                        + ",cat_id= '" + cat_id + "' "
                        + "where "
                        + " product_name ='" + num + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S6_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_types {

        public final String cat_id;
        public final String type_id;

        public to_types(String cat_id, String type_id) {
            this.cat_id = cat_id;
            this.type_id = type_id;
        }
    }

    public static to_types select_type(String cat_name, String type_name) {

        to_types to = new to_types("0", "0");

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_num from " + MyDB.getNames() + ".category "
                        + "where "
                        + " cat_name ='" + cat_name + "' "
                        + " ";

            String cat_id = "0";
            String type_id = "0";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cat_id = rs.getString(1);
            }
//           
            String s2 = "select type_num from " + MyDB.getNames() + ".category_type "
                        + "where "
                        + " type_name ='" + type_name + "' and cat_num='" + cat_id + "' "
                        + " ";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            if (rs2.next()) {
                type_id = rs2.getString(1);
            }

            to = new to_types(cat_id, type_id);
//            JOptionPane.showMessageDialog(null, to.cat_id + " = " + cat_name);
            return to;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data_active(String barcode, String is_active) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set "
                        + "is_active= '" + is_active + "'"
                        + "where "
                        + " product_name ='" + barcode + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S6_items.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_add_product to_inventory2_stocks_left) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".inventory2_stocks_left where "
                        + " product_name ='" + to_inventory2_stocks_left.name + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S6_items.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            PoolConnection.close();
        }
    }
}
