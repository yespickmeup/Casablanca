/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class Check_product_if_existing {

    //<editor-fold defaultstate="collapsed" desc="do_check">
    public static boolean do_check(String name) {
        try {

            String s0 = "select p.id from " + MyDB.getNames() + ".products p where p.product_name = :product_name; ";

            s0 = SqlStringUtil.parse(s0).setString("product_name", name).ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
//            JOptionPane.showMessageDialog(null, "adad");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    public static void main(String[] args) {
        System.out.println(do_check("LIEMPO"));
    }
}
