/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc2;

import POS.Main.MyDB;
import POS.utl.DateType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.DateUtil;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import java.sql.SQLException;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S12_cashier_sessions {

    //<editor-fold defaultstate="collapsed" desc="add_cashier_session">
    public static void add_cashier_session(String name, int user_level) {

//        Date date = S5_ret_system_date.do_ret_system_date();
        String date = DateType.sf.format(new Date());
        String log = DateType.datetime.format(new Date());
        try {

            String s0 = "insert into " + MyDB.getNames() + ".cashier_sessions( "
                        + "  cashier_name "
                        + " ,login_status "
                        + " ,modified "
                        + " ,created "
                        + " ,login_time "
                        + " ,user_level "
                        + ") values ( "
                        + "  :cashier_name "
                        + " ,:login_status "
                        + " ,:modified "
                        + " ,:created "
                        + " ,:a_login "
                        + " ,:user_level "
                        + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("cashier_name", name).
                    setNumber("login_status", 1).
                    setString("modified", date).
                    setString("created", date).
                    setString("a_login", log).
                    setNumber("user_level", user_level).
                    ok();

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

    //<editor-fold defaultstate="collapsed" desc="update_sessions">
    public static void update_sessions(String name) {

//        JOptionPane.showMessageDialog(null, name);
        Date date = new Date();
        String now = DateType.datetime.format(new Date());
        try {

            String s0 = "update " + MyDB.getNames() + ".cashier_sessions "
                        + "set login_status = '0'"
                        + ",logout_time= '" + now + "'"
                        + "where cashier_name = :cashier_name "
                        + "and date(modified) = date(:date) ";

            s0 = SqlStringUtil.parse(s0).
                    setString("cashier_name", name).
                    setDate("date", date).
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

    //<editor-fold defaultstate="collapsed" desc="is_logout">
    public static String is_logout(String name) {


        Date date = new Date();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//and date(modified='"+"2012-03-25 12:00:00"+"') 
//        String d = sf.format(date);
        String logout = "yes";

//        String d=""+sf.format(date) + " 00:00:00";
////        d=d.replaceAll(".0", "");
//        JOptionPane.showMessageDialog(null,date);
        try {

            String s0 = "select "
                        + "cashier_name "
                        + "from "
                        + "" + MyDB.getNames() + ".cashier_sessions"
                        + " where login_status='" + "1" + "' "
//                        + "and cashier_name='" + name + "'"
                        + " and"
                        + " modified between '" + sf.format(date) + "' and '" + sf.format(date) + "' ";


            Lg.$.severe(s0);
            Connection conn = MyConnection.connect();

            PreparedStatement stmt = conn.prepareStatement(s0);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                logout = rs.getString(1);
            }
//            JOptionPane.showMessageDialog(null, logout);

            return logout;

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error1" + e);
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="get_cashier_ses_id">
    public static int get_cashier_ses_id(String name) {

        int id = 0;
        try {

            Connection conn = MyConnection.connect();
            String s0 = "select id from " + MyDB.getNames() + ".cashier_sessions"
                        + " where "
                        + "cashier_name=:cashier_name "
                        + "and Date(created)=:created and login_status='" + "1" + "'";


            s0 = SqlStringUtil.parse(s0).setString("cashier_name", name).setString("created", DateType.sf.format(new Date())).ok();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            Lg.s(S1_check_version.class, s0);
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(get_cashier_ses_id("top2"));
    }

    public static String get_cashier_user_name(String name) {

//        S5_ret_system_date.do_ret_system_date2();
        String d = DateType.sf.format(new Date());
        Date date = DateUtil.asDateAsciiFormat(d);
//        JOptionPane.showMessageDialog(null, date);
        String user_name = "-1";
        try {

            Connection conn = MyConnection.connect();
            String s0 = "select user_name from " + MyDB.getNames() + ".users  "
                        + "where user_code = '" + name + "' ";


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                user_name = rs.getString(1);
            }
            Lg.s(S1_check_version.class, s0);
            return user_name;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error" + e);
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int get_cashier_ses_id2(String name) {
        int id = 0;
        try {
            Connection conn = MyConnection.connect();
            String s2 = "select user_name from " + MyDB.getNames() + ".users  "
                        + "where user_code = '" + name + "' ";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            if (rs2.next()) {
                name = rs2.getString(1);
            }
            String s0 = "select max(id) from " + MyDB.getNames() + ".cashier_sessions where cashier_name = '" + name + "' and login_status = 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            Lg.s(S1_check_version.class, s0);
            return id;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error" + e);
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    //</editor-fold>
}
