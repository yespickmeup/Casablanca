/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S6_save_new_product {

    //<editor-fold defaultstate="collapsed" desc="p_save_new_product">
//    public static void p_save_new_product(String lookup_code, String prod_name,
//            String desc, double price, double qty_per_head, double qty, String remarks) {
//
//        try {
//
//            Connection conn = MyConnection.connect();
//            String s0 =
//                    "call pb_pos_restaurant.p_save_new_product( "
//                    + "  :a_lookup_code "
//                    + " ,:a_prod_name "
//                    + " ,:a_desc "
//                    + " ,:a_price "
//                    + " ,:a_qty_per_head "
//                    + " ,:a_qty "
//                    + " ,:a_remarks "
//                    + "); ";
//
//
//            s0 = SqlStringUtil.parse(s0).setString("a_lookup_code", lookup_code).setString("a_prod_name", prod_name).setString("a_desc", desc).setNumber("a_price", price).setNumber("a_qty_per_head", qty_per_head).setNumber("a_qty", qty).setString("a_remarks", remarks).ok();
//
//            PreparedStatement stmt = conn.prepareStatement(s0);
//            stmt.execute();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
    //</editor-fold>
}
