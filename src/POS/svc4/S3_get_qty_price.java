/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc4;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection;

/**
 *
 * @author u2
 */
public class S3_get_qty_price {

    public static String[] get_details(String code) {
        String[] details = new String[3];
        details[0] = "0";
        details[1] = "0";
        details[2] = "";
        

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select price,product_qty,id from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + code + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                details[0] = rs.getString(1);
                details[1] = rs.getString(2);          
                details[2] = rs.getString(3);           
            }
            return details;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
     public static String get_name(String code) {
        String name="";
       
       
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select description from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + code + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name= rs.getString(1);
                 
            }
            return name;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
       public static String if_code_exists(String stmts) {
           
        String name="no";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select product_name from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + stmts + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name= rs.getString(1);
                 System.out.println(name);
            }
            return name;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
       
       
     public static void main(String[] args) {
         System.out.println(get_name("480191116072"));
                
    }
      public static String get_code(String names) {
        String name="";
       
        

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select product_name from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + names + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name= rs.getString(1);
                 break;
            }
            return name;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
