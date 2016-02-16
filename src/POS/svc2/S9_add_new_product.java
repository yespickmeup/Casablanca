/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import POS.to.to_new_product;
import POS.utl.increment_number;
import java.sql.Connection;
import java.sql.PreparedStatement;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S9_add_new_product {

    //<editor-fold defaultstate="collapsed" desc="add">
    public static void add(to_new_product to) {

        try {
            Connection conn = MyConnection.connect();

            if (!increment_number.if_exists(to.key)) {

                String s0 = "insert into "+MyDB.getNames()+".key_products(key_number, key_size) values ( :key_number, :key_size); ";
                s0 = SqlStringUtil.parse(s0)
                        .setNumber("key_number", to.key)
                        .setNumber("key_size", 1) // size is 1
                        .ok();
                
                Lg.$.severe(s0);
                PreparedStatement pstmt = conn.prepareStatement(s0);
                pstmt.execute();

                
            } else {

                String s0 = "update "+MyDB.getNames()+".key_products set key_size = :key_size where key_number = :key_number; ";
                s0 = SqlStringUtil.parse(s0)
                        .setNumber("key_number", to.key)
                        .setNumber("key_size", to.size) // size is 1
                        .ok();
                
                
                Lg.$.severe(s0);
                PreparedStatement psmt1 = conn.prepareStatement(s0);
                psmt1.execute();

            }


            String s0 = "insert into "+MyDB.getNames()+".products( "
                    + "  key_category "
                    + " ,lookup_code "
                    + " ,product_name "
                    + " ,description "
                    + " ,price "
                    + " ,remarks "
                    + " ,modified "
                    + ") values ( "
                    + "  :key_category "
                    + " ,:lookup_code "
                    + " ,:product_name "
                    + " ,:description "
                    + " ,:price "
                    + " ,:remarks "
                    + " ,:modified ); ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("key_category", to.key)
                    .setString("lookup_code", to.look_up_code)
                    .setString("product_name", to.name)
                    .setString("description", to.desc)
                    .setNumber("price", to.price)
                    .setString("remarks", to.remarks)
                    .setDate("modified", to.date_added)
                    .ok();
            
            Lg.$.severe(s0);
            PreparedStatement psmt = conn.prepareStatement(s0);
            psmt.execute();


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }
    //</editor-fold>
    
    
}
