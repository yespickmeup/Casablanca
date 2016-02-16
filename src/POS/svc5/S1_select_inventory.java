/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc5;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S1_select_inventory {

    public static class to_inventory {

        public final String barcode;
        public final String name;
        public final double price;
        public final double qty;

        public to_inventory(String barcode, String name, double price, double qty) {
            this.barcode = barcode;
            this.name = name;
            this.price = price;
            this.qty = qty;
        }
    }

    public static List<to_inventory> ret_items() {
        List<to_inventory> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select product_name,description,price,product_qty from "+MyDB.getNames()+".inventory2_stocks_left";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String barcode = rs.getString(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                to_inventory to = new to_inventory(barcode, name, price, qty);
                datas.add(to);
            }
            return datas;
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
