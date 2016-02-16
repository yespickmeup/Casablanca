/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.Date;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S3_select_session_id {

    //<editor-fold defaultstate="collapsed" desc="p_ret_cashier_session">
    public static int p_ret_cashier_session(String name) {

        try {

            Connection conn = MyConnection.connect();

            String s0 = "select cs.id from " + MyDB.getNames() + ".cashier_sessions cs "
                        + "where "
                        + "cs.cashier_name = :a_name and date(created) = :a_date;";

            s0 = SqlStringUtil.parse(s0).setString("a_name", name).setDate("a_date", new Date()).ok();

            PreparedStatement pstmt = conn.prepareStatement(s0);
            ResultSet rs = pstmt.executeQuery(s0);

            rs.next();

            if (rs.next()) {
                return rs.getInt("id");
            }

            return 0;


        } catch (Exception e) {

            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>

    public static void main(String[] args) {

        System.out.println(p_ret_cashier_session("cashier"));


    }
}
