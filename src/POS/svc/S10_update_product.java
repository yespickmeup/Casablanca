/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.to.to_admin_product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S10_update_product {

    //<editor-fold defaultstate="collapsed" desc="p_update_product">
//    public static void p_update_product(to_admin_product to) {
//
//        try {
//            Connection conn = MyConnection.connect();
//            String s0 =
//                    "call pb_pos_restaurant.p_update_product( "
//                    + "  :a_product_name "
//                    + " ,:a_price "
//                    + " ,:a_est_heads "
//                    + " ,:a_no_of_heads "
//                    + "); ";
//            s0 = SqlStringUtil.parse(s0)
//                    .setString("a_product_name", to.product_name)
//                    .setNumber("a_price", to.price)
//                    .setNumber("a_est_heads", to.no_of_heads)
//                    .setNumber("a_no_of_heads", to.no_of_heads)
//                    .ok();
//
//            Lg.$.severe(s0);
//
//            PreparedStatement psmt = conn.prepareStatement(s0);
//            psmt.execute();
//            
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//
//    }
    //</editor-fold>
    
}
