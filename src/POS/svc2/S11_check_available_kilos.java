/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S11_check_available_kilos {

    //<editor-fold defaultstate="collapsed" desc="get_kilos">
    public static double get_kilos(String product_name) {

        double qty=0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(product_qty,0) as qty "
                    + "from "+MyDB.getNames()+".inventory2_stocks_left "
                    + "where product_name = :product_name ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("product_name", product_name)
                    .ok();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while(rs.next()){
                qty=rs.getDouble(1);
            }
           return qty;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
      public static double get_kilos2(String product_name) {

        double qty=0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(product_qty,0) as qty "
                    + "from "+MyDB.getNames()+".inventory2_stocks_left "
                    + "where product_name = :product_name ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("product_name", product_name)
                    .ok();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while(rs.next()){
                qty=rs.getDouble(1);
            }
           return qty;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
    public static boolean prod_exists(String num){
        boolean exists=false;
        try {
            Connection conn = MyConnection.connect();
            String s0="select product_name from "+MyDB.getNames()+".inventory2_stocks_left where product_name='"+num+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
               exists=true;
            }
            return exists;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }   
    }
    public static void main(String[] args) {
        System.out.println(prod_exists("Mountain Dew 1.0L1"));
    }
}
