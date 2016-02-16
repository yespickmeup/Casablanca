/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.utl.DateType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S11_cash_out {

    //<editor-fold defaultstate="collapsed" desc="p_cash_count">
    public static void p_cash_count(int a_cashier_session_id, double a_cash_out, double a_addtl_cash) {
        try {

            String s0 = " update " + MyDB.getNames() + ".cash_drawer cd "
                        + "set cd.cash_out = :a_cash_out"
                        + ",cd.addtl_cash = :a_addtl_cash"
                        + ",cd.date_added = :current_timestamp "
                        + "where "
                        + "cd.cashier_session_id = :a_cashier_session_id";

            s0 = SqlStringUtil.parse(s0).setNumber("a_cash_out", a_cash_out).setNumber("a_addtl_cash", a_addtl_cash)
                    .setString("current_timestamp", DateType.datetime.format(new Date())).setNumber("a_cashier_session_id", a_cashier_session_id).ok();

            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();
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
