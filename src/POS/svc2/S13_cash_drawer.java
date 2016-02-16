/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

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
public class S13_cash_drawer {

    //<editor-fold defaultstate="collapsed" desc="do_save_cash_in">
    public static void do_save_cash_in(int session_id, String name, double cash_in) {

        String date = DateType.sf.format(new Date());

//        String date = S5_ret_system_date.do_ret_system_date2();
//        String id = "" + S12_cashier_sessions.get_cashier_ses_id(name);
//        JOptionPane.showMessageDialog(null, date);
        try {
            String s0 = "insert into " + MyDB.getNames() + ".cash_drawer( "
                        + "  cashier_session_id"
                        + " ,user_name"
                        + " ,cash_in "
                        + " ,date_added "
                        + " ) value ( "
                        + "  :cashier_session_id"
                        + " ,:user_name"
                        + " ,:cash_in"
                        + " ,:a_date_added"
                        + " ) ";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("cashier_session_id", session_id).
                    setString("user_name", name).
                    setNumber("cash_in", cash_in).
                    setString("a_date_added", date).
                    ok();

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
