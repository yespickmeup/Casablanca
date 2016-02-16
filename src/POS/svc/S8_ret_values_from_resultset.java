/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.to.to_product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S8_ret_values_from_resultset {

   
    public static void main(String[] args) {
//        System.out.println(get_id_product("paaa"));
    }

    //<editor-fold defaultstate="collapsed" desc="get_id_product2">
    public static to_product get_id_product2(String product_name) {


        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "  ifnull(p.price,0) as price "
                    + " ,ifnull(p.qty_per_head,0) as qty_per_head "
                    + " ,ifnull(p.product_qty,0) as product_qty "
                    + "from "+MyDB.getNames()+".products p "
                    + "where product_name = :product_name; ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("product_name", product_name)
                    .ok();

            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            
            to_product retval = null; 
            
            if(rs.next()) {
            
                double price = rs.getDouble("price");
                double qty_per_head = rs.getDouble("qty_per_head");
                double product_qty = rs.getInt("product_qty");
            
                retval = new to_product(price, qty_per_head, product_qty);
            }
            
            
            return retval;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }
    //</editor-fold>
    
}
