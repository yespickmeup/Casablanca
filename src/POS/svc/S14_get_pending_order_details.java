/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.svc4.S3_get_qty_price;
import POS.to.to_order;
import java.sql.Connection;
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
public class S14_get_pending_order_details {

    //<editor-fold defaultstate="collapsed" desc="p_select_pending_lists">
//    public static List<to_order> p_select_pending_lists(String cust_name) {
//        try {
//            String s0 = "call pb_pos_restaurant.p_select_pending_lists( "
//                        + "  :a_customer_name "
//                        + "); ";
//            s0 = SqlStringUtil.parse(s0).setString("a_customer_name", cust_name).ok();
//
//            Lg.$.severe(s0);
//
//            Connection conn = MyConnection.connect();
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//
//            List<to_order> retval = new ArrayList();
//            while (rs.next()) {
//                String product_name = rs.getString("product_name");
//                double price = rs.getDouble("price");
//                double qty = rs.getDouble("qty");
//                String desc = rs.getString("description");
//                to_order to = new to_order(desc, price, qty, "", product_name, 0, "-1", "-1","cat",0);
//                retval.add(to);
//            }
//
//            return retval;
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
    //</editor-fold>

    public static void main(String[] args) {
//        p_select_pending_lists("pascua");

    }
}
