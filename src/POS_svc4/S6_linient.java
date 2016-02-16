/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S6_linient {

    public static boolean is_linient(String prod_num) {
        boolean is_linient = false;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select is_linient from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + prod_num + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String is = rs.getString(1);
//                System.out.println(is);
                if (is.equals("0")) {
                    is_linient = false;
                } else {
                    is_linient = true;
                }
            }
            return is_linient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(is_linient("230"));
    }
}
