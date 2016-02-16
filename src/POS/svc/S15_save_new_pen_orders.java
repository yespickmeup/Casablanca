/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.svc4.S3_get_qty_price;
import POS.to.to_order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S15_save_new_pen_orders {

    //<editor-fold defaultstate="collapsed" desc="retrieve_pending_db">
    public static List<to_order> retrieve_pending_db(String customer_name) {
        List<to_order> datas = new ArrayList();
        try {
//             select
//    po.id
//   ,po.customer_name
//   
//  
//  
            String s0 = "select "
                        + "po.id"
                        + ",po.customer_name"
                        + ",po.added "
                        + "from " + MyDB.getNames() + ".pending_orders po "
                        + "where"
                        + " po.customer_name = :a_customer_name";

            s0 = SqlStringUtil.parse(s0).
                    setString("a_customer_name", customer_name).
                    ok();
            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int a_pending_order_id = rs.getInt("id");
                String s1 = "select pod.id,pod.pending_order_id,pod.qty,pod.product_name,pod.price,pod.amount from " + MyDB.getNames() + ".pending_order_details pod"
                            + " where pod.customer_name = :a_pending_order_id";
                s1 = SqlStringUtil.parse(s1).
                        setString("a_pending_order_id", customer_name).
                        ok();
                pstmt = conn.prepareStatement(s1);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    double qty = rs.getDouble("qty");
                    String code = rs.getString("product_name");
                    double price = rs.getDouble("price");
                    String name = S3_get_qty_price.get_name(code);
                    to_order to = new to_order(name, price, qty, "pcs", code, qty, "-1", "-1","cat",0,0);
                    datas.add(to);
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

    //<editor-fold defaultstate="collapsed" desc="p_add_pending_orders">
    public static int p_pending_orders_retrieve(String a_customer_name, Date a_date) {

        try {

            String s0 = "select "
                        + "po.id"
                        + ",po.customer_name"
                        + ",po.added "
                        + "from " + MyDB.getNames() + ".pending_orders po "
                        + "where"
                        + " po.customer_name = :a_customer_name";

            s0 = SqlStringUtil.parse(s0).
                    setString("a_customer_name", a_customer_name).
                    ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            return rs.getInt("id");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="p_add_pending_orders">
    public static int p_pending_orders_add(String a_customer_name, Date a_date) {

        try {
            String s0 = "insert into " + MyDB.getNames() + ".pending_orders(customer_name) values (:a_customer_name);"
                        + " set @c_pending_order_id = last_insert_id();"
                        + " select po.id from " + MyDB.getNames() + ".pending_orders po where po.id = @c_pending_order_id;";

            s0 = SqlStringUtil.parse(s0).
                    setString("a_customer_name", a_customer_name).
                    setDate("a_date", a_date).
                    ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            return rs.getInt("id");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="p_add_pending_order_details">
    public static void p_pending_order_details_add(int a_pending_order_id,
            double a_qty, String a_product_name, double a_price, double a_amount) {

        try {
            String s0 = " insert into " + MyDB.getNames() + ".pending_order_details "
                        + "(pending_order_id,qty,customer_name,product_name,price,amount) values(:a_pending_order_id"
                        + ",:a_qty,:a_product_name,:a_price,a_amount)";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("a_pending_order_id", a_pending_order_id).
                    setNumber("a_qty", a_qty).
                    setString("a_product_name", a_product_name).
                    setNumber("a_price", a_price).
                    setNumber("a_amount", a_amount).
                    ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            pstmt.executeQuery();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    public static void do_add_pending(String customer_name, List<to_order> data) {

        try {

            String s0 = "select "
                        + "po.id"
                        + ",po.customer_name"
                        + ",po.added "
                        + "from " + MyDB.getNames() + ".pending_orders po "
                        + "where"
                        + " po.customer_name = :a_customer_name";


            s0 = SqlStringUtil.parse(s0).
                    setString("a_customer_name", customer_name).
                    ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int a_pending_order_id = rs.getInt("id");
                for (to_order to : data) {

                    String s1 = " insert into " + MyDB.getNames() + ".pending_order_details "
                                + "(pending_order_id,qty,customer_name,product_name,price,amount) values(:a_pending_order_id"
                                + ",:a_qty,:a_customer_name,:a_product_name,:a_price,a_amount)";

                    s1 = SqlStringUtil.parse(s1).
                            setNumber("a_pending_order_id", a_pending_order_id).
                            setNumber("a_qty", to.hd_uom).
                            setString("a_customer_name", customer_name).
                            setString("a_product_name", to.code).
                            setNumber("a_price", to.unit_price).
                            setNumber("a_amount", to.getTotal()).
                            ok();

                    Lg.$.severe(s1);
                    pstmt = conn.prepareStatement(s1);
                    pstmt.execute();

                }

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void do_delete_pending(String name) {

        try {

            String s1 = "delete from " + MyDB.getNames() + ".pending_orders where customer_name= :customer_name; ";
            String s2 = "delete from " + MyDB.getNames() + ".pending_order_details where customer_name = :customer_name; ";


            s1 = SqlStringUtil.parse(s1).setString("customer_name", name).ok();

            s2 = SqlStringUtil.parse(s2).setString("customer_name", name).ok();

            Lg.$.severe(s1);
            Lg.$.severe(s2);

            Connection conn = MyConnection.connect();

            PreparedStatement pstmt = conn.prepareStatement(s1);
            pstmt.execute();
            pstmt = conn.prepareStatement(s2);
            pstmt.execute();


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        do_delete_pending("pascua");
    }
}
