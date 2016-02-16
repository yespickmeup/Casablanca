/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc;

import POS.Main.MyDB;
import POS.svc2.S10_select_products;
import POS.svc4.S2_customers;
import POS.svc4.S4_charge_invoice;
import POS.to.to_order;
import POS.to.to_pay;
import POS.to.to_users;
import POS.to2.to_credit;
import POS.to2.to_disc;
import POS.utl.DateType;
import POS.utl.MyConnection;
import POS.category_types.S1_categories;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.*;

import test.Dlg_check_liquid;

/**
 *
 * @author u2
 */
public class Svc_1 {

    public static int p_receipts_add(int a_cashier_session_id,
            double a_tendered, String a_or_number, Date a_receipt_date, String discount, to_credit to2) {
        try {
            String s0 = "insert into " + MyDB.getNames() + ".receipts(cashier_session_id,tendered,or_number,receipt_date,discount )"
                    + "values(:a_cashier_session_id,:a_tendered,:a_or_number,:a_receipt_date ,:a_discount)";

            s0 = SqlStringUtil.parse(s0).
                    setNumber("a_cashier_session_id", a_cashier_session_id).
                    setNumber("a_tendered", a_tendered).
                    setString("a_or_number", a_or_number).
                    setDate("a_receipt_date", a_receipt_date).
                    setString("a_discount", discount).
                    ok();

            Connection conn = MyConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(s0);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
////                JOptionPane.showMessageDialog(null, rs.getInt("or_number"));
//                return rs.getInt("or_number");
//
//            }
            return FitIn.toInt(a_or_number) + 1;

//            return 0;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "adadad");
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static int p_receipts_add2(int a_cashier_session_id,
            double a_tendered, String a_or_number, Date a_receipt_date, String discount, to_credit to2, int bb, String member_id) {
        String app_code = "";
        String payed = "";
        double credit = 0;
        if (bb == 0) {
            app_code = "";
            credit = 0;
            payed = "yes";
        } else {
            app_code = to2.author_code;
            credit = to2.amount;
            payed = "no";
        }
        if (bb == 3) {
            credit = 0;
            payed = "yes";
        }
//        JOptionPane.showMessageDialog(null, a_tendered + " "+a_or_number + " "+a_receipt_date + " "+discount);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".receipts(cashier_session_id,tendered,or_number,receipt_date,discount,credit,approval_code,member_id,is_payed)"
                    + "values(:a_cashier_session_id,:a_tendered,:a_or_number,:a_receipt_date,:a_discount,:a_credit,:a_approval_code,:a_member_id,:a_is_payed)  ";
            s0 = SqlStringUtil.parse(s0).
                    setNumber("a_cashier_session_id", a_cashier_session_id).
                    setNumber("a_tendered", a_tendered).
                    setString("a_or_number", a_or_number).
                    setDate("a_receipt_date", a_receipt_date).
                    setString("a_discount", discount).
                    setNumber("a_credit", credit).
                    setString("a_approval_code", app_code).
                    setString("a_member_id", member_id).
                    setString("a_is_payed", payed).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Svc_1.class, "Successfully Added");
            return FitIn.toInt(a_or_number);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "adadad");
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void p_receipt_items_add(int a_receipt_id,
            String a_product_name, double a_unit_price, double a_qty, String num, String tot_disc, String prod_name) {
        String[] cat = new String[5];
        cat = S1_categories.product_category(a_product_name);

        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".receipt_items("
                    + "receipt_id"
                    + ",product_name"
                    + ",unit_price"
                    + ",qty"
                    + ",type_name"
                    + ",cat_name"
                    + ",description"
                    + ")values("
                    + ":receipt_id"
                    + ",:product_name"
                    + ",:unit_price"
                    + ",:qty"
                    + ",:type_name"
                    + ",:cat_name"
                    + ",:description"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("receipt_id", num).
                    setString("product_name", a_product_name).
                    setNumber("unit_price", a_unit_price).
                    setNumber("qty", a_qty).
                    setString("type_name", "type").
                    setString("cat_name", "category").
                    setString("description", prod_name).
                    ok();
            PreparedStatement pstmt = conn.prepareStatement(s0);
            pstmt.execute();
            Lg.s(Svc_1.class, "Successfully AddedReceipt Item");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void pay(to_pay to_pay, String name, to_disc to1, to_credit to2, int bb, String member_id, List<Dlg_check_liquid.to_guests> my_guest, String table_no, String user_id, String or_no, int table_location_id, double peso, String table_name) {

        to_disc to = to1;

        int yy = 0;
        String guest_id = "";
        String guest_name = "";

        for (Dlg_check_liquid.to_guests tt : my_guest) {
            if (yy == 0) {
                guest_id = guest_id + tt.id;
                guest_name = guest_name + tt.name;

            } else {
                guest_id = guest_id + "," + tt.id;
                guest_name = guest_name + "," + tt.name;

            }
            yy++;
        }

        String user_name = to_users.ret_user(to_users.username1);
        try {
            Connection conn = MyConnection.connect();
            Date date = new Date();
            int id = 0;
            String s12 = "select user_name from " + MyDB.getNames() + ".users  "
                    + "where user_code = '" + name + "' ";
            Statement stmt12 = conn.createStatement();
            ResultSet rs2 = stmt12.executeQuery(s12);
            if (rs2.next()) {
                name = rs2.getString(1);
            }
            String s10 = "select max(id) from " + MyDB.getNames() + ".cashier_sessions where cashier_name = '" + name + "' and login_status = 1";
            Statement stmt10 = conn.createStatement();
            ResultSet rs = stmt10.executeQuery(s10);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            double credit = 0;
            double disc = 0;
            String app_code = "";
            double discount = 0;
            if (to1 != null) {

                discount = FitIn.toDouble(to1.tot_disc);

            }

            if (to2 != null) {
                credit = to2.amount;

                member_id = to2.card_holder;
                app_code = to2.author_code;
            } else {
                credit = 0;
                member_id = "0";
            }

            int receipt_id = 0;
            String cust_name = "";
            String cust_address = "";
            if (bb == 2) {
                receipt_id = p_receipts_add2(id, to_pay.tendered, to_pay.or, date, "0", to2, bb, member_id);
                String s5 = "insert into " + MyDB.getNames() + ".credits("
                        + "or_no"
                        + ",bank_name"
                        + ",card_type"
                        + ",card_holder"
                        + ",card_no"
                        + ",approval_code"
                        + ",amount"
                        + ",user_name"
                        + ",user_id"
                        + ",date_payed"
                        + ",dollar_amount"
                        + ",dollar_rate"
                        + ",session_id"
                        + ")values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt5 = conn.prepareStatement(s5);
                String num = S2_customers.get_cust_num(to2.card_holder);
                stmt5.setString(1, "" + to_pay.or);
                stmt5.setString(2, to2.bank);
                stmt5.setString(3, to2.card_type);
                stmt5.setString(4, to2.card_holder);
                stmt5.setString(5, to2.credit_card_no);
                stmt5.setString(6, to2.author_code);
                stmt5.setDouble(7, to2.amount);
                stmt5.setString(8, to_users.get_user());
                stmt5.setString(9, "1");
                stmt5.setString(10, DateType.datetime.format(date));
                stmt5.setDouble(11, to2.credit_dollar);
                stmt5.setDouble(12, to_pay.dollar_rate);
                stmt5.setString(13, "" + id);
                stmt5.execute();
                cust_name = to2.card_holder;
                cust_address = to2.credit_card_no;
                if (System.getProperty("version", "ordering").
                        equals("coop")) {
                    S4_charge_invoice.do_add(to2.bank);
                }

                String s0 = "insert into " + MyDB.getNames() + ".receipts(cashier_session_id,tendered"
                        + ",or_number,receipt_date,discount,credit,approval_code,member_id"
                        + ",is_payed,dollar,credit_dollar,dollar_rate,peso,user_name,table_id,table_name,guest_id,guest_name)"
                        + "values(:a_cashier_session_id,:a_tendered,:a_or_number,:a_receipt_date"
                        + ",:a_discount,:a_credit,:a_approval_code,:a_member_id,:a_is_payed"
                        + ",:a_dollar,:a_credit_dollar,:a_dollar_rate,:a_peso,:user_name,:table_id,:table_name,:guest_id,:guest_name)  ";
                s0 = SqlStringUtil.parse(s0).
                        setNumber("a_cashier_session_id", id).
                        setNumber("a_tendered", to_pay.tendered).
                        setString("a_or_number", or_no).
                        setDate("a_receipt_date", date).
                        setNumber("a_discount", discount).
                        setNumber("a_credit", credit).
                        setString("a_approval_code", app_code).
                        setString("a_member_id", member_id).
                        setString("a_is_payed", "no").
                        setNumber("a_dollar", to_pay.dollar_tendered).
                        setNumber("a_credit_dollar", to2.credit_dollar).
                        setNumber("a_dollar_rate", to_pay.dollar_rate).
                        setNumber("a_peso", peso).
                        setString("user_name", user_name).
                        setString("table_id", table_no).
                        setString("table_name", table_name).
                        setString("guest_id", guest_id).
                        setString("guest_name", guest_name).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

            } else if (bb == 3 || bb == 2) {
                cust_name = to2.card_holder;
                cust_address = to2.credit_card_no;
                double bal = S2_customers.get_balance(member_id);
                bal -= to_pay.tendered;
                String s3 = "update " + MyDB.getNames() + ".customers set balance='" + bal + "' where id='" + member_id + "'";
                PreparedStatement stmt1 = conn.prepareStatement(s3);
                stmt1.execute();

                String payed = "no";

                String s0 = "insert into " + MyDB.getNames() + ".receipts(cashier_session_id,tendered,or_number"
                        + ",receipt_date,discount,credit,approval_code,member_id,is_payed,dollar,credit_dollar"
                        + ",dollar_rate,peso,user_name,table_id,table_name,guest_id,guest_name)"
                        + "values(:a_cashier_session_id,:a_tendered,:a_or_number,:a_receipt_date"
                        + ",:a_discount,:a_credit,:a_approval_code,:a_member_id,:a_is_payed"
                        + ",:a_dollar,:a_credit_dollar,:a_dollar_rate,:a_peso,:user_name,:table_id,:table_name,:guest_id,:guest_name)  ";
                s0 = SqlStringUtil.parse(s0).
                        setNumber("a_cashier_session_id", id).
                        setNumber("a_tendered", to_pay.tendered).
                        setString("a_or_number", or_no).
                        setDate("a_receipt_date", date).
                        setNumber("a_discount", discount).
                        setNumber("a_credit", credit).
                        setString("a_approval_code", app_code).
                        setString("a_member_id", member_id).
                        setString("a_is_payed", payed).
                        setNumber("a_dollar", to_pay.dollar_tendered).
                        setNumber("a_credit_dollar", to2.credit_dollar).
                        setNumber("a_dollar_rate", to_pay.dollar_rate).
                        setNumber("a_peso", peso).
                        setString("user_name", user_name).
                        setString("table_id", table_no).
                        setString("table_name", table_name).
                        setString("guest_id", guest_id).
                        setString("guest_name", guest_name).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

            } else {

                String payed = "";

                if (bb == 3) {
                    payed = "no";
                }

                String s0 = "insert into " + MyDB.getNames() + ".receipts(cashier_session_id,tendered,or_number"
                        + ",receipt_date,discount,credit,approval_code,member_id,is_payed,dollar,credit_dollar"
                        + ",dollar_rate,peso,user_name,table_id,table_name,guest_id,guest_name)"
                        + "values(:a_cashier_session_id,:a_tendered,:a_or_number,:a_receipt_date"
                        + ",:a_discount,:a_credit,:a_approval_code,:a_member_id,:a_is_payed,:a_dollar"
                        + ",:a_credit_dollar,:a_dollar_rate,:a_peso.:user_name,:table_id,:table_name,:guest_id,:guest_name)  ";
                s0 = SqlStringUtil.parse(s0).
                        setNumber("a_cashier_session_id", id).
                        setNumber("a_tendered", to_pay.tendered).
                        setString("a_or_number", or_no).
                        setDate("a_receipt_date", date).
                        setNumber("a_discount", discount).
                        setNumber("a_credit", credit).
                        setString("a_approval_code", app_code).
                        setString("a_member_id", member_id).
                        setString("a_is_payed", payed).
                        setNumber("a_dollar", to_pay.dollar_tendered).
                        setNumber("a_credit_dollar", to2.credit_dollar).
                        setNumber("a_dollar_rate", to_pay.dollar_rate).
                        setNumber("a_peso", peso).
                        setString("user_name", user_name).
                        setString("table_id", table_no).
                        setString("table_name", table_name).
                        setString("guest_id", guest_id).
                        setString("guest_name", guest_name).
                        ok();
//                ,dollar,credit_dollar,dollar_rate
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
//                JOptionPane.showMessageDialog(null, "adadada");
            }
            List<to_order> tps = to_pay.orders;
            String now = DateType.datetime.format(new Date());
            for (to_order too : tps) {
//                p_receipt_items_add(receipt_id, too.code, too.unit_price, too.hd_uom, to_pay.or, to1.tot_disc, too.product_name);

                String s0 = "insert into " + MyDB.getNames() + ".receipt_items("
                        + "receipt_id"
                        + ",product_name"
                        + ",unit_price"
                        + ",qty"
                        + ",type_name"
                        + ",cat_name"
                        + ",description"
                        + ",group_id"
                        + ",date_added"
                        + ",table_id"
                        + ",table_name"
                        + ",guest_id"
                        + ",guest_name"
                        + ")values("
                        + ":receipt_id"
                        + ",:product_name"
                        + ",:unit_price"
                        + ",:qty"
                        + ",:type_name"
                        + ",:cat_name"
                        + ",:description"
                        + ",:group_id"
                        + ",:date_added"
                        + ",:table_id"
                        + ",:table_name"
                        + ",:guest_id"
                        + ",:guest_name"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("receipt_id", or_no).
                        setString("product_name", too.code).
                        setNumber("unit_price", too.unit_price).
                        setNumber("qty", too.hd_uom).
                        setString("type_name", "type").
                        setString("cat_name", too.category_name).
                        setString("description", too.product_name).
                        setNumber("group_id", too.group_id).
                        setString("date_added", now).
                        setString("table_id", table_no).
                        setString("table_name", table_name).
                        setString("guest_id", too.guest_id).
                        setString("guest_name", guest_name).
                        ok();
                PreparedStatement pstmt = conn.prepareStatement(s0);
                pstmt.execute();
            }
            int check_out = to_users.get_check_outs();
            for (to_order too : tps) {
                String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";
                double qty = S10_select_products.get_qty(too.code);
                double total = qty - too.hd_uom;
                s1 = SqlStringUtil.parse(s1).
                        setNumber("total", total).
                        setString("product_name", too.code).
                        ok();
                PreparedStatement psmt3 = conn.prepareStatement(s1);
                psmt3.execute();
                String s4 = "update " + MyDB.getNames() + ".customer_tables_details set status='" + "1" + "' where "
                        + "table_no_id='" + table_no + "' "
                        + "and product_name='" + too.code + "' "
                        + "and status<>'" + "1" + "' "
                        + "and guest_id='" + too.guest_id + "'";
                PreparedStatement stmt4 = conn.prepareStatement(s4);
                stmt4.execute();
                Lg.s(Svc_1.class, "Status Updated customer_tables" + too.code + " = " + too.guest_id + " = " + table_no);
                if (user_id.equals("5") || (check_out == 1 && user_id.equals("6")) || user_id.
                        equals("0")) {
                    String s5 = "update " + MyDB.getNames() + ".guest_charges set status='" + "1" + "' where "
                            + "guest_id='" + too.guest_id + "' and status='" + "0" + "' and table_no='" + table_no + "'";
                    PreparedStatement stmt5 = conn.prepareStatement(s5);
                    stmt5.execute();
                    Lg.s(Svc_1.class, "Status Updated Guest Charges" + too.guest_id);
                }
            }
            for (Dlg_check_liquid.to_guests t_guest : my_guest) {
                if (user_id.equals("5") || (check_out == 1 && user_id.equals("6")) || user_id.
                        equals("0")) {
                    String s3 = "update " + MyDB.getNames() + ".room_guests set status='" + "1" + "' where rooom_id='" + table_no + "' and guest_id='" + t_guest.id + "'";
                    PreparedStatement stmt3 = conn.prepareStatement(s3);
                    stmt3.execute();
                    Lg.s(Svc_1.class, "Status Updated room guest" + t_guest);
                    String s5 = "update " + MyDB.getNames() + ".guest_advance_payment set status='" + "1" + "' where room_id='" + table_no + "' and guest_id='" + t_guest.id + "'";
                    PreparedStatement stmt5 = conn.prepareStatement(s5);
                    stmt5.execute();
                    Lg.s(Svc_1.class, "Status Updated guest advances " + t_guest.id);
                }

            }

            if (to1.dis_name == null) {
            } else {
                String s2 = "insert into " + MyDB.getNames() + ".receipt_discount(or_number,disc_no,disc_name,disc_percent,disc_rate,cust_name,cust_no,cust_address)values(?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(s2);
                stmt.setInt(1, receipt_id);
                stmt.setString(2, "1");
                stmt.setString(3, to1.dis_name);
                stmt.setString(4, to1.dis_rate);
                stmt.setString(5, to1.tot_disc);
                stmt.setString(6, to1.cust_name);
                stmt.setString(7, to1.cust_no);
                stmt.setString(8, to1.cus_add);
                stmt.execute();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    // bir
    public static void pay2(to_pay to_pay, String name, to_disc to1, to_credit to2, int bb, String member_id, List<Dlg_check_liquid.to_guests> my_guest, String table_no, String user_id, String or_no, int tbl_location_id, double peso, String table_name) {

//        JOptionPane.showMessageDialog(null, or_no);
        int yy = 0;
        String guest_id = "";
        String guest_name = "";

        for (Dlg_check_liquid.to_guests tt : my_guest) {
            if (yy == 0) {
                guest_id = guest_id + tt.id;
                guest_name = guest_name + tt.name;

            } else {
                guest_id = guest_id + "," + tt.id;
                guest_name = guest_name + "," + tt.name;

            }
            yy++;
        }

        String user_name = to_users.ret_user(to_users.username1);
        try {
            Connection conn = MyConnection.connect();

            Date date = new Date();
            int id = 0;
            String s12 = "select user_name from " + MyDB.getNames() + ".users  "
                    + "where user_code = '" + name + "' ";
            Statement stmt12 = conn.createStatement();
            ResultSet rs2 = stmt12.executeQuery(s12);
            if (rs2.next()) {
                name = rs2.getString(1);
            }
            String s10 = "select max(id) from " + MyDB.getNames() + ".cashier_sessions where cashier_name = '" + name + "' and login_status = 1";
            Statement stmt10 = conn.createStatement();
            ResultSet rs = stmt10.executeQuery(s10);
            if (rs.next()) {
                id = rs.getInt(1);
            }
            double disc = 0;
            String cust_name = "";
            String cust_address = "";
            int receipt_id = 0;

            String app_code = "";
            double credit = 0;
            double discount = 0;
            if (to1 != null) {
                discount = FitIn.toDouble(to1.tot_disc);
            }
            if (to2 != null) {
                credit = to2.amount;
                member_id = to2.card_holder;
                app_code = to2.author_code;
            } else {
                credit = 0;
                member_id = "0";
            }
            if (bb == 2) {
                cust_name = to2.card_holder;
                cust_address = to2.credit_card_no;
                String s5 = "insert into " + MyDB.getNames() + ".credits("
                        + "or_no"
                        + ",bank_name"
                        + ",card_type"
                        + ",card_holder"
                        + ",card_no"
                        + ",approval_code"
                        + ",amount"
                        + ",user_name"
                        + ",user_id"
                        + ",date_payed"
                        + ",dollar_amount"
                        + ",dollar_rate"
                        + ",session_id"
                        + ")values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt5 = conn.prepareStatement(s5);
                stmt5.setString(1, "" + to_pay.or);
                stmt5.setString(2, to2.bank);
                stmt5.setString(3, to2.card_type);
                stmt5.setString(4, to2.card_holder);
                stmt5.setString(5, to2.credit_card_no);
                stmt5.setString(6, to2.author_code);
                stmt5.setDouble(7, to2.amount);
                stmt5.setString(8, to_users.get_user());
                stmt5.setString(9, "1");
                stmt5.setString(10, DateType.datetime.format(date));
                stmt5.setDouble(11, to2.credit_dollar);
                stmt5.setDouble(12, to_pay.dollar_rate);
                stmt5.setString(13, "" + id);
                stmt5.execute();
                if (System.getProperty("version", "ordering").
                        equals("coop")) {
                    S4_charge_invoice.do_add(to2.bank);
                }
                String s0 = "insert into " + MyDB.getNames() + ".receipts("
                        + "cashier_session_id"
                        + ",tendered"
                        + ",or_number"
                        + ",receipt_date"
                        + ",discount"
                        + ",credit"
                        + ",approval_code"
                        + ",member_id"
                        + ",is_payed"
                        + ",dollar"
                        + ",credit_dollar"
                        + ",dollar_rate"
                        + ",peso"
                        + ",user_name"
                        + ",table_id"
                        + ",table_name"
                        + ",guest_id"
                        + ",guest_name)"
                        + "values("
                        + ":a_cashier_session_id"
                        + ",:a_tendered"
                        + ",:a_or_number"
                        + ",:a_receipt_date"
                        + ",:a_discount"
                        + ",:a_credit"
                        + ",:a_approval_code"
                        + ",:a_member_id"
                        + ",:a_is_payed"
                        + ",:a_dollar"
                        + ",:a_credit_dollar"
                        + ",:a_dollar_rate"
                        + ",:a_peso"
                        + ",:user_name"
                        + ",:table_id"
                        + ",:table_name"
                        + ",:guest_id"
                        + ",:guest_name)  ";
                s0 = SqlStringUtil.parse(s0).
                        setNumber("a_cashier_session_id", id).
                        setNumber("a_tendered", to_pay.tendered).
                        setString("a_or_number", or_no).
                        setDate("a_receipt_date", date).
                        setNumber("a_discount", discount).
                        setNumber("a_credit", credit).
                        setString("a_approval_code", app_code).
                        setString("a_member_id", member_id).
                        setString("a_is_payed", "no").
                        setNumber("a_dollar", to_pay.dollar_tendered).
                        setNumber("a_credit_dollar", to2.credit_dollar).
                        setNumber("a_dollar_rate", to_pay.dollar_rate).
                        setNumber("a_peso", peso).
                        setString("user_name", user_name).
                        setString("table_id", table_no).
                        setString("table_name", table_name).
                        setString("guest_id", guest_id).
                        setString("guest_name", guest_name).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            } else if (bb == 3) {
                cust_name = to2.card_holder;
                cust_address = to2.credit_card_no;
                double bal = S2_customers.get_balance(member_id);
                bal -= to_pay.tendered;
                String s3 = "update " + MyDB.getNames() + ".customers set balance='" + bal + "' where id='" + member_id + "'";
                PreparedStatement stmt1 = conn.prepareStatement(s3);
                stmt1.execute();
                String payed = "no";
                String s0 = "insert into " + MyDB.getNames() + ".receipts("
                        + "cashier_session_id,tendered,or_number"
                        + ",receipt_date,discount,credit,approval_code,member_id,is_payed,dollar"
                        + ",credit_dollar,dollar_rate,peso,user_name,table_id,table_name,guest_id,guest_name)"
                        + "values(:a_cashier_session_id,:a_tendered,:a_or_number,:a_receipt_date,:a_discount"
                        + ",:a_credit,:a_approval_code,:a_member_id,:a_is_payed,:a_dollar"
                        + ",:a_credit_dollar,:a_dollar_rate,:a_peso,:user_name,:table_id,:table_name,:guest_id,:guest_name)  ";
                s0 = SqlStringUtil.parse(s0).
                        setNumber("a_cashier_session_id", id).
                        setNumber("a_tendered", to_pay.tendered).
                        setString("a_or_number", or_no).
                        setDate("a_receipt_date", date).
                        setNumber("a_discount", discount).
                        setNumber("a_credit", credit).
                        setString("a_approval_code", app_code).
                        setString("a_member_id", member_id).
                        setString("a_is_payed", payed).
                        setNumber("a_dollar", to_pay.dollar_tendered).
                        setNumber("a_credit_dollar", to2.credit_dollar).
                        setNumber("a_dollar_rate", to_pay.dollar_rate).
                        setNumber("a_peso", peso).
                        setString("user_name", user_name).
                        setString("table_id", table_no).
                        setString("table_name", table_name).
                        setString("guest_id", guest_id).
                        setString("guest_name", guest_name).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            } else {
                String payed = "";
                if (bb == 3) {
                    payed = "no";
                }
                String s0 = "insert into " + MyDB.getNames() + ".receipts(cashier_session_id,tendered,or_number"
                        + ",receipt_date,discount,credit,approval_code,member_id,is_payed,dollar"
                        + ",credit_dollar,dollar_rate,peso,user_name,table_id,table_name,guest_id,guest_name)"
                        + "values(:a_cashier_session_id,:a_tendered,:a_or_number,:a_receipt_date,:a_discount"
                        + ",:a_credit,:a_approval_code,:a_member_id,:a_is_payed,:a_dollar,:a_credit_dollar"
                        + ",:a_dollar_rate,:a_peso,:user_name,:table_id,:table_name,:guest_id,:guest_name)  ";
                s0 = SqlStringUtil.parse(s0).
                        setNumber("a_cashier_session_id", id).
                        setNumber("a_tendered", to_pay.tendered).
                        setString("a_or_number", or_no).
                        setDate("a_receipt_date", date).
                        setNumber("a_discount", discount).
                        setNumber("a_credit", credit).
                        setString("a_approval_code", app_code).
                        setString("a_member_id", member_id).
                        setString("a_is_payed", payed).
                        setNumber("a_dollar", to_pay.dollar_tendered).
                        setNumber("a_credit_dollar", to2.credit_dollar).
                        setNumber("a_dollar_rate", to_pay.dollar_rate).
                        setNumber("a_peso", peso).
                        setString("user_name", user_name).
                        setString("table_id", table_no).
                        setString("table_name", table_name).
                        setString("guest_id", guest_id).
                        setString("guest_name", guest_name).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
            }
            String now = DateType.datetime.format(new Date());
            List<to_order> tps = to_pay.orders;
            for (to_order too : tps) {
//                p_receipt_items_add(receipt_id, too.code, too.unit_price, too.hd_uom, to_pay.or, "0", too.product_name);
                String s9 = "insert into " + MyDB.getNames() + ".receipt_items("
                        + "receipt_id"
                        + ",product_name"
                        + ",unit_price"
                        + ",qty"
                        + ",type_name"
                        + ",cat_name"
                        + ",description"
                        + ",group_id"
                        + ",date_added"
                        + ",table_id"
                        + ",table_name"
                        + ",guest_id"
                        + ",guest_name"
                        + ")values("
                        + ":receipt_id"
                        + ",:product_name"
                        + ",:unit_price"
                        + ",:qty"
                        + ",:type_name"
                        + ",:cat_name"
                        + ",:description"
                        + ",:group_id"
                        + ",:date_added"
                        + ",:table_id"
                        + ",:table_name"
                        + ",:guest_id"
                        + ",:guest_name"
                        + ")";
                s9 = SqlStringUtil.parse(s9).
                        setString("receipt_id", or_no).
                        setString("product_name", too.code).
                        setNumber("unit_price", too.unit_price).
                        setNumber("qty", too.hd_uom).
                        setString("type_name", too.cat_id).
                        setString("cat_name", too.category_name).
                        setString("description", too.product_name).
                        setNumber("group_id", too.group_id).
                        setString("date_added", now).
                        setString("table_id", table_no).
                        setString("table_name", table_name).
                        setString("guest_id", too.guest_id).
                        setString("guest_name", guest_name).
                        ok();
                PreparedStatement pstmt = conn.prepareStatement(s9);
                pstmt.execute();
                Lg.s(Svc_1.class, "Successfully AddedReceipt Item");
            }
            int check_out = to_users.get_check_outs();
            int check_in = to_users.get_check_ins();
            String version = System.getProperty("version", "resto");
            for (to_order too : tps) {
                String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";
                double qty = S10_select_products.get_qty(too.code);
                double total = qty - too.hd_uom;
                s1 = SqlStringUtil.parse(s1).
                        setNumber("total", total).
                        setString("product_name", too.code).
                        ok();
                PreparedStatement psmt3 = conn.prepareStatement(s1);
                psmt3.execute();
                String s4 = "update " + MyDB.getNames() + ".customer_tables_details set status='" + "1" + "' where "
                        + "table_no_id='" + table_no + "' "
                        + "and product_name='" + too.code + "' "
                        + "and status<>'" + "1" + "' "
                        + "and guest_id='" + too.guest_id + "'";
                PreparedStatement stmt4 = conn.prepareStatement(s4);
                stmt4.execute();
                Lg.s(Svc_1.class, "Status Updated customer_tables" + too.code + " = " + too.guest_id + " = " + table_no);
                if (user_id.equals("5") || (check_out == 1 && user_id.equals("6")) || user_id.
                        equals("0") || (check_in == 0 && check_out == 0 && tbl_location_id == 1 && version.
                        equals("resto"))) {
                    String s5 = "update " + MyDB.getNames() + ".guest_charges set status='" + "1" + "' where "
                            + "guest_id='" + too.guest_id + "' and status='" + "0" + "' and table_no='" + table_no + "'";

                    PreparedStatement stmt5 = conn.prepareStatement(s5);
                    stmt5.execute();
                    Lg.s(Svc_1.class, "Status Updated Guest Charges" + too.guest_id);
                }
            }

            for (Dlg_check_liquid.to_guests t_guest : my_guest) {
                if (user_id.equals("5") || (check_out == 1 && user_id.equals("6")) || user_id.
                        equals("0") || (check_in == 0 && check_out == 0 && tbl_location_id == 1 && version.
                        equals("resto"))) {
                    String s3 = "update " + MyDB.getNames() + ".room_guests set status='" + "1" + "' where rooom_id='" + table_no + "' and guest_id='" + t_guest.id + "'";
                    PreparedStatement stmt3 = conn.prepareStatement(s3);
                    stmt3.execute();
                    Lg.s(Svc_1.class, "Status Updated room guest" + t_guest);
                } else {
                }
                String s5 = "update " + MyDB.getNames() + ".guest_advance_payment set status='" + "1" + "' where room_id='" + table_no + "' and guest_id='" + t_guest.id + "'";
                PreparedStatement stmt5 = conn.prepareStatement(s5);
                stmt5.execute();
                Lg.s(Svc_1.class, "Status Updated guest advances " + t_guest.id);
            }
            String s3 = "update " + MyDB.getNames() + ".bill_discounts set status='" + "1" + "' where table_id='" + table_no + "' and status='" + "0" + "'";
            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    // bir
    public static void print_receipt(Component parent, String orno) {

        try {
            Connection conn = MyConnection.connect();

//            DBOutlet dbo = DBConnectionPool.db_outlet(conn, false);
//            birsession.rpt.rpt_receipt rr = svc_bir.print_receipt(dbo, orno); -kani
//            birsession.rpt.rpt_receipt.print(parent, rr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    private void bir_sessions(to_pay to_pay, String name, to_disc to1, to_credit to2) {
        try {
            Connection conn = MyConnection.connect();
//            svc_1.issue_receipt(conn, null);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void test_pay() {

        List<to_order> orders = new ArrayList();

        for (int i = 0; i < 10; i++) {
//            to_order to = new to_order("productx" + i, i + 1, 1, "","");
//            to.setQuantity(i * 10);
//            orders.add(to);
        }

        to_pay tp = new to_pay(100, new Date(), "cashiera2", orders, "123478", 0, 0);
//        pay(tp, "adad");

    }

    // many times or receipt
    public static int get_latest_or() {

        int or_number = 0;
        try {
            Connection conn = MyConnection.connect();
            Statement stmt = conn.createStatement();

            String s0 = "select max(r.or_number) from " + MyDB.getNames() + ".receipts r ";
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                or_number = rs.getInt(1);
//                System.out.println(or_number);
            }
            or_number++;
            return or_number;
//            return Integer.parseInt(ReceiptIncrementor.increment(""+or_number));
        } catch (Exception e) {
//            return 0;
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

//    public static void main(String[] args) {
//        System.out.println(get_latest_or2());
//    }
    public static int get_latest_or2() {

        int or_number = 0;
        try {

            Connection conn = MyConnection.connect();
            Statement stmt = conn.createStatement();

            String s0 = "select max(r.or_number) from " + MyDB.getNames() + ".receipts r ";
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                or_number = rs.getInt(1);
//                System.out.println(or_number);
            }
            or_number++;
            return or_number;
//            return Integer.parseInt(ReceiptIncrementor.increment(""+or_number));
        } catch (Exception e) {
//            return 0;
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String id = "000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(r.id) from " + MyDB.getNames() + ".receipts r ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            int i = 0;
            if (rs.next()) {
                i = rs.getInt(1);
            }
            i++;
            return "" + i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(increment_id());
    }
}
