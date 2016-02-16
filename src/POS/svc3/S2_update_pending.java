/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.svc.S15_save_new_pen_orders;
import POS.to.to_order;
import POS_svc4.S2_search;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S2_update_pending {

    //<editor-fold defaultstate="collapsed" desc="update">
    public static void update(String customer_name, List<to_order> orders) {


        try {

            String s0 = "select customer_name "
                        + "from "+MyDB.getNames()+".pending_orders "
                        + "where customer_name = :customer_name; ";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", customer_name).
                    ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();


            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                do_update(customer_name, orders);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void update_2(String customer_name, List<to_order> orders, List<S2_search.to_orders> data) {


        try {

            String s0 = "select customer_name "
                        + "from "+MyDB.getNames()+".pending_orders "
                        + "where customer_name = :customer_name; ";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", customer_name).
                    ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();


            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
//                do_update(customer_name, orders);
                do_update_2(customer_name, orders, data);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="do_update">
    private static void do_update(String customer_name, List<to_order> orders) {

        try {

            Connection conn = MyConnection.connect();

            String id = "";
            String s3 = "select id from "+MyDB.getNames()+".pending_order_details where customer_name='" + customer_name + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s3);
            if (rs.next()) {
                id = rs.getString(1);
            }

            String s0 = "delete from "+MyDB.getNames()+".pending_order_details "
                        + "where customer_name = :customer_name ";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", customer_name).
                    ok();

            PreparedStatement pstmt = conn.prepareStatement(s0);
            pstmt.execute();


            for (to_order to_pending_order_details : orders) {

                String s1 = "insert into "+MyDB.getNames()+".pending_order_details("
                            + "pending_order_id"
                            + ",customer_name"
                            + ",qty"
                            + ",product_name"
                            + ",price"
                            + ",amount"
                            + ",description"
                            + ",status"
                            + ")values("
                            + ":pending_order_id"
                            + ",:customer_name"
                            + ",:qty"
                            + ",:product_name"
                            + ",:price"
                            + ",:amount"
                            + ",:description"
                            + ",:status"
                            + ")";

                s0 = SqlStringUtil.parse(s0).setString("pending_order_id", id).setString("customer_name", customer_name).setNumber("qty", to_pending_order_details.quantity).setString("product_name", to_pending_order_details.code).setNumber("price", to_pending_order_details.unit_price).setNumber("amount", (to_pending_order_details.unit_price * to_pending_order_details.quantity)).setString("description", to_pending_order_details.product_name).setNumber("status", 0).ok();

                PreparedStatement stmt2 = conn.prepareStatement(s1);
                stmt2.execute();
                Lg.s(S2_update_pending.class, "Successfully Added");


            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    private static void do_update_2(String customer_name, List<to_order> orders, List<S2_search.to_orders> data) {

        try {

            Connection conn = MyConnection.connect();

            String id = "";
            String s3 = "select id from "+MyDB.getNames()+".pending_order_details where customer_name='" + customer_name + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s3);
            if (rs.next()) {
                id = rs.getString(1);
            }

            String s0 = "delete from "+MyDB.getNames()+".pending_order_details "
                        + "where customer_name = :customer_name ";

            s0 = SqlStringUtil.parse(s0).
                    setString("customer_name", customer_name).
                    ok();

            PreparedStatement pstmt = conn.prepareStatement(s0);
            pstmt.execute();


            for (S2_search.to_orders to_pending_order_details : data) {

                String s1 = "insert into "+MyDB.getNames()+".pending_order_details("
                            + "pending_order_id"
                            + ",customer_name"
                            + ",qty"
                            + ",product_name"
                            + ",price"
                            + ",amount"
                            + ",description"
                            + ",status"
                            + ")values("
                            + ":pending_order_id"
                            + ",:customer_name"
                            + ",:qty"
                            + ",:product_name"
                            + ",:price"
                            + ",:amount"
                            + ",:description"
                            + ",:status"
                            + ")";

                s0 = SqlStringUtil.parse(s0).setString("pending_order_id", id).setString("customer_name", customer_name).setNumber("qty", to_pending_order_details.qty).setString("product_name", to_pending_order_details.name).setNumber("price", to_pending_order_details.price).setNumber("amount", (to_pending_order_details.price * to_pending_order_details.qty)).setString("description", to_pending_order_details.desc).setNumber("status", 0).ok();

                PreparedStatement stmt2 = conn.prepareStatement(s1);
                stmt2.execute();
                Lg.s(S2_update_pending.class, "Successfully Added -item");
                
                for(S2_search.to_items_status sub: to_pending_order_details.to_sub){
                     String s4 = "insert into "+MyDB.getNames()+".pending_order_detail_assembly("
                            + "pod_id"
                            + ",prod_num"
                            + ",description"
                            + ",price"
                            + ",product_qty"
                            + ",ref_num"
                            + ",status"
                            + ")values("
                            + ":pod_id"
                            + ",:prod_num"
                            + ",:description"
                            + ",:price"
                            + ",:product_qty"
                            + ",:ref_num"
                            + ",:status"
                            + ")";

                s0 = SqlStringUtil.parse(s0).setString("pod_id", id)
                        .setString("prod_num", sub.name)
                        .setString("description", sub.desc)
                        .setNumber("price", sub.price)
                        .setNumber("product_qty", sub.qty)
                        .setString("ref_num", to_pending_order_details.name)
                        .setNumber("status", 0)
                        .ok();

                PreparedStatement stmt4 = conn.prepareStatement(s4);
                stmt4.execute();
                Lg.s(S2_update_pending.class, "Successfully Added - subs");
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    public static void delete(String name) {
        // adapt
        S15_save_new_pen_orders.do_delete_pending(name);
    }

    public static void delete_if_empty(String name11) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from "+MyDB.getNames()+".pending_orders where customer_name='" + name11 + "'";
            String s1 = "delete from "+MyDB.getNames()+".pending_order_details where customer_name='" + name11 + "'";
            PreparedStatement psmt = conn.prepareStatement(s0);
            psmt.execute();
            PreparedStatement psmt2 = conn.prepareStatement(s1);
            psmt2.execute();


//            JOptionPane.showMessageDialog(null, "adad");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
