/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

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
 * @author u2
 */
public class S10_select_products {

    //<editor-fold defaultstate="collapsed" desc="ret_products">
    public static List<String> ret_products(int key_category) {
        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select p.product_name from " + MyDB.getNames() + ".products p where p.key_category like :key_category; ";

            s0 = SqlStringUtil.parse(s0).setNumber("key_category", key_category).ok();

            Lg.$.severe(s0);

            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String prod = rs.getString("product_name");
                datas.add(prod);
            }

            int count = datas.size();

            // query -- is this paging?
            if (count != 9) {
                int diff = 9 - count;
                for (int i = 0; i < diff; i++) {
                    String n = " ";
                    datas.add(n);
                }
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ret_products_string">
    public static List<String> ret_products_string(int key_category) {

        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select p.product_name from "+MyDB.getNames()+".products p where p.key_category like :key_category; ";

            s0 = SqlStringUtil.parse(s0).setNumber("key_category", key_category).
                    ok();

            Lg.$.severe(s0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String prod = rs.getString(1);
                datas.add(prod);
            }
            int count = datas.size();

            // query -- is this paging?
            if (count != 9) {
                int diff = 9 - count;
                for (int i = 0; i < diff; i++) {
                    String n = " ";
                    datas.add(n);
                }
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get_qty">
    public static double get_qty(String product_name) {

        double qty = 0;
        try {
            String s0 = "select p.product_qty "
                        + "from "+MyDB.getNames()+".inventory2_stocks_left p "
                        + "where p.product_name = '" + product_name + "' ";

            Connection conn = MyConnection.connect();
//            
//            s0 = SqlStringUtil.parse(s0)
//                    .setString("product_name", product_name).
//                    ok();
//            
            Lg.$.info(s0);
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery(s0);

            if (rs.next()) {
                qty = rs.getDouble(1);
            }

            return qty;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get_price">
    public static double get_price(String product_name) {

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(p.price, 0) as price "
                        + "from "+MyDB.getNames()+".inventory2_stocks_left p "
                        + "where p.product_name = :product_name; ";

            s0 = SqlStringUtil.parse(s0).setString("product_name", product_name).
                    ok();

            Lg.$.severe(s0);
            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("price");
            }

            return 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    public static void main(String[] args) {
        System.out.println(get_qty("Royal 1"));
    }
}
