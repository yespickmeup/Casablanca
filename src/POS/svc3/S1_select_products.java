/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.to2.to_product_list;
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
public class S1_select_products {

    //<editor-fold defaultstate="collapsed" desc="ret_products">
    public static List<to_product_list> ret_products() {

        try {

            String s0 = "select "
                    + "    p.product_qty2 "
                    + "   ,p.product_qty "
                    + "   ,p.product_name "
                    + "from "+MyDB.getNames()+".products p";

            
            String s1 = "select "
                    + "    p.name "
                    + "   ,p.beg "
                    + "   ,p.end "
                    + "from "+MyDB.getNames()+".inventory p";

            Lg.$.severe(s0);

            Connection conn = MyConnection.connect();

            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery();

            List<to_product_list> retval = new ArrayList();

            while (rs.next()) {
                String prod_name = rs.getString(3);
                double beg = rs.getDouble(1);
                double end = rs.getDouble(2);

                to_product_list to = new to_product_list(prod_name, beg, end);
                retval.add(to);
            }

            return retval;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="has_inventory">
    public static boolean has_inventory(Date date_added) {

        try {

            String s0 = "select id.id "
                    + "from "+MyDB.getNames()+".inventory_dates id "
                    + "where date(id.date_added) = date(:date_added) ";


            s0 = SqlStringUtil.parse(s0).
                    setDate("date_added", date_added).
                    ok();

            Connection conn = MyConnection.connect();

            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery(s0);

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }
    //</editor-fold>
    

    //<editor-fold defaultstate="collapsed" desc="do_update_inventory">
//    public static void do_update_inventory(
//            to_inventory to) {
//
//
//        try {
//            
//             String s0 = 
//                      "insert into "+MyDB.getNames()+".inventory( "
//                    + "  name "
//                    + " ,beg "
//                    + " ,end "
//                    + " ,total "
//                    + " ,physical_count "
//                    + " ,:qty_variance  "
//                    + " ,:date_modified "
//                    + ") values ( "
//                    + "  :product_name "
//                    + " ,:qty_beg "
//                    + " ,:qty_end "
//                    + " ,:qty_total "
//                    + " ,:qty_variance "
//                    + " ,:date_modified ); ";
//                    
//             
//             
//            s0 = SqlStringUtil.parse(s0)
//                    .setString("product_name", to.product_name)
//                    .setNumber("qty_beg", to.qty_beg)
//                    .setNumber("qty_end", to.qty_end)
//                    .setNumber("qty_total", to.qty_variance)
//                    .setNumber("qty_variance", to.qty_variance_new)
//                    .setDate("date_modified", to.inventory_date)
//                    .ok();
//                    
//            
//            Lg.$.severe(s0);
//            Connection conn = MyConnection.connect();
//            
//            PreparedStatement pstmt = conn.prepareStatement(s0);
//            pstmt.execute();
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//
//    }
    //</editor-fold>
     public static void do_update_inventory(String date, String name, double beg, double end, double variance, double new_beg, double new_var) {


//        date = DateTo.date_dash(date);
        System.out.println(date);

        try {
            Connection conn = MyConnection.connect();
//            String s0 = "update "+MyDB.getNames()+".products set product_qty2='" + new_beg + "',product_qty='" + new_beg + "' where product_name='" + name + "'";
//            PreparedStatement psmt = conn.prepareStatement(s0);
//            psmt.execute();

            String s1 = "insert into "+MyDB.getNames()+".inventory("
                    + "name"
                    + ",beg"
                    + ",end"
                    + ",total"
                    + ",date_added"
                    + ",variance"
                    + ",physical_count"
                    + ")"
                    + "values"
                    + "(?,?,?,?,?,?,?)";
            PreparedStatement psmt1 = conn.prepareStatement(s1);
            psmt1.setString(1, name);
            psmt1.setDouble(2, beg);
            psmt1.setDouble(3, end);
            psmt1.setDouble(4, variance);
            psmt1.setString(5, date);
            psmt1.setDouble(6, new_var);
            psmt1.setDouble(7, new_beg);

            psmt1.execute();
//           



        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

//    public static void main(String[] args) {
//        System.out.println(has_inventory(DateUtil.asDateAsciiFormat("2011-02-01")));
//    }
}
