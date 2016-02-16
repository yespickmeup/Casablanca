/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S15_update_product {

    //<editor-fold defaultstate="collapsed" desc="update_product">
    public static void update_product(String old_name, String new_name) {

        try {
            String s0 =
                    "update "+MyDB.getNames()+".products p "
                    + "  set p.product_name = :new_name "
                    + "where p.product_name = :old_name; ";

            s0 = SqlStringUtil.parse(s0).setString("new_name", new_name).setString("old_name", old_name).ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
            PreparedStatement psmt = conn.prepareStatement(s0);
            psmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get_qty">
    public static double get_qty(String name, String table_no) {

        double qty = 0;
        try {

            String s0 = "select ifnull(product_qty,0) as qty "
                    + "from "+MyDB.getNames()+".inventory2_stocks_left where product_name = :prod_num; ";

            s0 = SqlStringUtil.parse(s0).setString("prod_num", name).ok();

            Lg.$.severe(s0);

            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                qty = rs.getDouble("qty");
            }


//            JOptionPane.showMessageDialog(null, name + " "+qty2);

//            System.out.println(name + " ------ " + qty2 + " = " + qty);

            return qty;


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
    
    
    public static double get_qty2(String name){
        try {
            Connection conn = MyConnection.connect();
            
            String s1 = "select sum(qty) from "+MyDB.getNames()+".customer_tables_details where product_name = '" + name + "' ";
            System.out.println(name);

            Lg.$.severe(s1);
//            System.out.println(name + " "+qty);
            double qty2 = 0;
            String cashiering_for = System.getProperty("cashiering_for", "retail_store");
            System.out.println(cashiering_for + " asdadad");
//        JOptionPane.showMessageDialog(null, cashiering_for);
            if (cashiering_for.equals("restaurant_w_fixed_table")) {

                PreparedStatement pstmt1 = conn.prepareStatement(s1);
                ResultSet rs1 = pstmt1.executeQuery();

                while (rs1.next()) {
                    qty2 = rs1.getDouble(1);

                }
            }

            return qty2;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static double get_qty2_not(String name,String table_no){
        try {
            Connection conn = MyConnection.connect();
            
            String s1 = "select sum(qty) from "+MyDB.getNames()+".customer_tables_details where product_name ='" + name + "' ";
//              String s1 = "select sum(qty) from "+MyDB.getNames()+".customer_tables_details where product_name <>'" + name + "' and table_no_id='"+table_no+"'";
            System.out.println(name);

            Lg.$.severe(s1);
//            System.out.println(name + " "+qty);
            double qty2 = 0;
            String cashiering_for = System.getProperty("cashiering_for", "restaurant_w_fixed_table");
            System.out.println(cashiering_for + " asdadad");
//        JOptionPane.showMessageDialog(null, cashiering_for);
            if (cashiering_for.equals("restaurant_w_fixed_table")) {

                PreparedStatement pstmt1 = conn.prepareStatement(s1);
                ResultSet rs1 = pstmt1.executeQuery();

                while (rs1.next()) {
                    qty2 = rs1.getDouble(1);

                }
            }

            return qty2;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
      public static double get_qty2_not2(String name,String table_no){
        try {
            Connection conn = MyConnection.connect();
//            
//            String s1 = "select sum(qty) from "+MyDB.getNames()+".customer_tables_details where product_name ='" + name + "' ";
              String s1 = "select sum(qty) from "+MyDB.getNames()+".customer_tables_details where product_name ='" + name + "' and table_no_id <>'"+table_no+"'";
            System.out.println(name);

            Lg.$.severe(s1);
//            System.out.println(name + " "+qty);
            double qty2 = 0;
            String cashiering_for = System.getProperty("cashiering_for", "restaurant_w_fixed_table");
            System.out.println(cashiering_for + "restaurant_w_fixed_table");
//        JOptionPane.showMessageDialog(null, cashiering_for);
            if (cashiering_for.equals("restaurant_w_fixed_table")) {

                PreparedStatement pstmt1 = conn.prepareStatement(s1);
                ResultSet rs1 = pstmt1.executeQuery();

                while (rs1.next()) {
                    qty2 = rs1.getDouble(1);

                }
            }

            return qty2;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
    
    //</editor-fold>

    public static void main(String[] args) {
//        System.out.println(get_qty("LUMO"));
    }
}
