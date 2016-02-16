/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import POS.Main;
import POS.currency.S1_currency;
import POS.sales.S1_my_sales;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author i1
 */
public class Srpt_cashier_report {

    public final String SUBREPORT_DIR;
    public final List<Srpt_credits.field> rpt_credits;
    public final List<Srpt_expenses.field> rpt_expenses;
    public final List<Srpt_cashout.field> rpt_cashout;
    public final List<Srpt_addt_cashins.field> rpt_addt_cashin;
    public final Date date_from;
    public final Date date_to;
    public final String busi_name;
    public final String my_db;
    public final double dollar;
    public final double tendered;
    public final double discount;
    public final double credit;
    public final double foods;
    public final double beverages;
    public final double expences;
    public final double tot_bev;
    public final double net_total;
    public final String user_name;
    public final List<Srpt_cashiers.field> rpt_cashiers;
    public final double cashin;
    public final double cashout;
    public final double addtl_cashin;
    public final double net_sales;

    public Srpt_cashier_report(String SUBREPORT_DIR, List<Srpt_credits.field> rpt_credits, List<Srpt_expenses.field> rpt_expenses, List<Srpt_cashout.field> rpt_cashout, List<Srpt_addt_cashins.field> rpt_addt_cashin, Date date_from, Date date_to, String busi_name, String my_db, double dollar, double tendered, double discount, double credit, double foods, double beverages, double expences, double tot_bev, double net_total, String user_name, List<Srpt_cashiers.field> rpt_cashiers, double cashin, double cashout, double addtl_cashin, double net_sales) {
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.rpt_credits = rpt_credits;
        this.rpt_expenses = rpt_expenses;
        this.rpt_cashout = rpt_cashout;
        this.rpt_addt_cashin = rpt_addt_cashin;
        this.date_from = date_from;
        this.date_to = date_to;
        this.busi_name = busi_name;
        this.my_db = my_db;
        this.dollar = dollar;
        this.tendered = tendered;
        this.discount = discount;
        this.credit = credit;
        this.foods = foods;
        this.beverages = beverages;
        this.expences = expences;
        this.tot_bev = tot_bev;
        this.net_total = net_total;
        this.user_name = user_name;
        this.rpt_cashiers = rpt_cashiers;
        this.cashin = cashin;
        this.cashout = cashout;
        this.addtl_cashin = addtl_cashin;
        this.net_sales = net_sales;
    }

    public static class field {

        String cashier_name;
        double sales;

        public field() {
        }

        public field(String cashier_name, double sales) {
            this.cashier_name = cashier_name;
            this.sales = sales;
        }

        public String getCashier_name() {
            return cashier_name;
        }

        public void setCashier_name(String cashier_name) {
            this.cashier_name = cashier_name;
        }

        public double getSales() {
            return sales;
        }

        public void setSales(double sales) {
            this.sales = sales;
        }
    }

    public static Srpt_cashier_report ret_data_session(String session_id, Date date_from, Date date_to, String busi_name, double dollar, String dfrom, String dto, List<S1_my_sales.to_receipts> receipts, double tendered, double discount, double credit, double expences, String users, double cashin, double cashout, double addtl_cashin, String user_name) {

        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Guinness\\") + "img_templates\\rpt\\";
        Srpt_cashier_report to1 = new Srpt_cashier_report(SUBREPORT_DIR, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), 0, 0, 0, 0);

        String user = to_users.username1;

        try {
            Connection conn = MyConnection.connect();

            double foods = 0;
            double beverages = 0;
            double my_dollar = 0;
            for (S1_my_sales.to_receipts t : receipts) {
                String s11 = "select sum(qty*unit_price),group_id from "
                        + "" + Main.MyDB.getNames() + ".receipt_items where receipt_id='" + t.or_number + "' group by group_id asc";
                Statement stmt11 = conn.createStatement();
                ResultSet rs11 = stmt11.executeQuery(s11);
                while (rs11.next()) {
                    String group_id = rs11.getString(2);
                    if (group_id.equals("0")) {
                        foods += rs11.getDouble(1);
                    } else {
                        beverages += rs11.getDouble(1);
                    }
                }
            }

            double net = (tendered + cashin + addtl_cashin) - (expences + cashout);

            List<Srpt_credits.field> rpt_credits = new ArrayList();
            String s4 = "select "
                    + "or_no"
                    + ",card_type"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",amount"
                    + ",dollar_amount"
                    + ",dollar_rate"
                    + " from " + Main.MyDB.getNames() + ".credits where   Date(date_payed) between '" + dfrom + "' and '" + dto + "' and user_name like '%" + user_name + "%' "
                    + " ";
            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            while (rs4.next()) {
                String trans_no = rs4.getString(1);
                String card_type = rs4.getString(2);
                String card_holder = rs4.getString(3);
                String card_no = rs4.getString(4);
                String approval_code = rs4.getString(5);
                double amount = rs4.getDouble(6);
                double additional = rs4.getDouble(7);
                double dollar_rate = rs4.getDouble(8);
                Srpt_credits.field to = new Srpt_credits.field(trans_no, card_type, card_holder, card_no, approval_code, amount, additional, dollar_rate);
                rpt_credits.add(to);
            }
//
            List<Srpt_expenses.field> rpt_expenses = new ArrayList();
            String s5 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + " from " + Main.MyDB.getNames() + ".expenses where "
                    + "  Date(date_added) between '" + dfrom + "' and '" + dto + "' and user_name like '%" + user_name + "%'"
                    + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs5.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose);
                rpt_expenses.add(to);
            }

            List<Srpt_cashout.field> rpt_cashout = new ArrayList();
            String s16 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + " from " + Main.MyDB.getNames() + ".cashouts where "
                    + "  Date(date_added) between '" + dfrom + "' and '" + dto + "' and user_name like '%" + user_name + "%' "
                    + " ";

            Statement stmt16 = conn.createStatement();
            ResultSet rs16 = stmt16.executeQuery(s16);
            while (rs16.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs16.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs16.getDouble(2);
                String purpose = rs16.getString(3);

                Srpt_cashout.field to = new Srpt_cashout.field(date_added, amount, purpose);
                rpt_cashout.add(to);
            }
            List<Srpt_addt_cashins.field> rpt_addt_cashin = new ArrayList();
            String s17 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + " from " + Main.MyDB.getNames() + ".addt_cashins where "
                    + "  Date(date_added) between '" + dfrom + "' and '" + dto + "' and user_name like '%" + user_name + "%'"
                    + " ";

            Statement stmt17 = conn.createStatement();
            ResultSet rs17 = stmt17.executeQuery(s17);
            while (rs17.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs17.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs17.getDouble(2);
                String purpose = rs17.getString(3);

                Srpt_addt_cashins.field to = new Srpt_addt_cashins.field(date_added, amount, purpose);
                rpt_addt_cashin.add(to);
            }

            for (S1_my_sales.to_receipts to : receipts) {
            }
            List<String> datas = S1_my_sales.ret_cashier();
            List<Srpt_cashiers.field> data = new ArrayList();
            for (String s : datas) {
//                System.out.println(s);
//                Srpt_cashier_report.field.
//                users = to_users.ret_user(s);
//                double am = 0;
//                String s6 = "select sum(peso) from " + Main.MyDB.getNames() + ".receipts where Date(receipt_date) between '" + dfrom + "' and '" + dto + "'"
//                        + " and user_name like '%" + users + "%'";
//                Statement stmt6 = conn.createStatement();
//                ResultSet rs6 = stmt6.executeQuery(s6);
//                if (rs6.next()) {
//                    am = rs6.getDouble(1);
//                }
//                Srpt_cashiers.field t = new Srpt_cashiers.field(s, am);
//                data.add(t);
            }
//            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\Maytopacka\\") + "img_templates\\rpt\\";
            String date = "( " + DateType.liquid.format(date_from) + " - " + DateType.liquid.
                    format(date_to) + " )";
            to1 = new Srpt_cashier_report(SUBREPORT_DIR, rpt_credits, rpt_expenses, rpt_cashout, rpt_addt_cashin, date_from, date_to, busi_name, date, my_dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, user, data, cashin, cashout, addtl_cashin, tendered);

            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_sales_category.field> get_sales_category(List<S1_my_sales.to_receipts> receipts, String business_name, String date_from) {

        List<Srpt_sales_category.field> datas = new ArrayList();
        Date d = new Date();
        double all = 0;
        List<String> categories = ret_cb_data();
        try {
            Connection conn = MyConnection.connect();

            for (S1_my_sales.to_receipts t : receipts) {

                String s2 = "select "
                        + "(qty)"
                        + ",unit_price"
                        + ",cat_name"
                        + ",group_id"
                        + ",description"
                        + ",date_added"
                        + " from " + Main.MyDB.getNames() + ".receipt_items where "
                        + " receipt_id ='" + t.id + "'  order by description asc "
                        + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    double qty = rs2.getDouble(1);
                    double unit_price = rs2.getDouble(2);
                    String cat_name = rs2.getString(3);
                    String description = rs2.getString(5);
                    String date_added = rs2.getString(6);

                    if (date_added == null) {
                        date_added = DateType.time.format(d);
                    } else {
                        d = DateType.datetime.parse(date_added);
                        date_added = DateType.time2.format(d);
                    }
                    if (qty * unit_price != 0) {
                        Srpt_sales_category.field to = new Srpt_sales_category.field(cat_name, description, qty, qty * unit_price, unit_price, date_added);
                        datas.add(to);
                        all += qty * unit_price;
                    }
                }
            }

            List<Srpt_sales_category.field> datas2 = new ArrayList();
            for (String cat : categories) {
                List<Srpt_sales_category.field> contacts = new ArrayList<Srpt_sales_category.field>();
                for (Srpt_sales_category.field t : datas) {
                    if (t.cat_name.equalsIgnoreCase(cat)) {
                        contacts.add(t);
                    }
                }
                Collections.sort(contacts, new Comparator<Srpt_sales_category.field>() {

                    @Override
                    public int compare(Srpt_sales_category.field one, Srpt_sales_category.field other) {
                        return one.description.compareTo(other.description);
                    }
                });
                datas2.addAll(contacts);

            }

            return datas2;
        } catch (SQLException e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } catch (ParseException e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static List<Srpt_sales_category.field> get_sales_category2(List<S1_my_sales.to_receipts> receipts, String business_name, String date_from) {

        List<Srpt_sales_category.field> datas = new ArrayList();
        Date d = new Date();
        double all = 0;
        List<String> categories = ret_cb_data();
        try {
            Connection conn = MyConnection.connect();
            String where = " where ";
            int i = 0;
            for (S1_my_sales.to_receipts t : receipts) {
                if (i == 0) {
                    where = where + " receipt_id ='" + t.id + "' ";
                } else {
                    where = where + " or receipt_id ='" + t.id + "' ";
                }
                i++;
            }
            where = where + " group by description order by cat_name,description asc ";
            System.out.println(where);
            String s2 = "select "
                    + "sum(qty)"
                    + ",unit_price"
                    + ",cat_name"
                    + ",group_id"
                    + ",description"
                    + ",date_added"
                    + " from " + Main.MyDB.getNames() + ".receipt_items "
                    + " " + where;
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            while (rs2.next()) {
                double qty = rs2.getDouble(1);
                double unit_price = rs2.getDouble(2);
                String cat_name = rs2.getString(3);
                String description = rs2.getString(5);
                String date_added = rs2.getString(6);

                if (date_added == null) {
                    date_added = DateType.time.format(d);
                } else {
                    d = DateType.datetime.parse(date_added);
                    date_added = DateType.time2.format(d);
                }
                if (qty * unit_price != 0) {
                    Srpt_sales_category.field to = new Srpt_sales_category.field(cat_name, description, qty, qty * unit_price, unit_price, "");
                    datas.add(to);
                    all += qty * unit_price;
                }
            }

            List<Srpt_sales_category.field> datas2 = new ArrayList();
            for (String cat : categories) {
                List<Srpt_sales_category.field> contacts = new ArrayList<Srpt_sales_category.field>();
                for (Srpt_sales_category.field t : datas) {
                    if (t.cat_name.equalsIgnoreCase(cat)) {
                        contacts.add(t);
                    }
                }
                Collections.sort(contacts, new Comparator<Srpt_sales_category.field>() {

                    @Override
                    public int compare(Srpt_sales_category.field one, Srpt_sales_category.field other) {
                        return one.description.compareTo(other.description);
                    }
                });
                datas2.addAll(contacts);

            }

            return datas2;
        } catch (SQLException e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } catch (ParseException e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_name from " + Main.MyDB.getNames() + ".category";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static Srpt_cashier_report ret_data_date(String session_id, Date date_from, Date date_to, String busi_name, double dollar, String dfrom, String dto) {
        Srpt_cashier_report to1 = new Srpt_cashier_report("", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), 0, 0, 0, 0);

        String user = to_users.username1;
        String user_name = to_users.ret_user(to_users.username1);

        try {
            Connection conn = MyConnection.connect();

            double tendered = 0;
            double discount = 0;
            double credit = 0;
            double foods = 0;
            double beverages = 0;
            double expences = 0;
            double my_dollar = 0;

            String s0 = "select "
                    + "(peso)"
                    + ",(discount)"
                    + ",(credit)"
                    + ",or_number"
                    + ",(dollar)"
                    + ",(credit_dollar)"
                    + " from " + Main.MyDB.getNames() + ".receipts where "
                    + " user_name ='" + user_name + "' and Date(receipt_date) between '" + dfrom + "' and '" + dto + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                tendered += rs.getDouble(1);
                discount += rs.getDouble(2);
                credit += (rs.getDouble(3));
                my_dollar += rs.getDouble(5);
                String receipt_id = rs.getString(4);
                String s2 = "select "
                        + "qty"
                        + ",unit_price"
                        + ",cat_name"
                        + ",group_id"
                        + " from " + Main.MyDB.getNames() + ".receipt_items where "
                        + " receipt_id ='" + receipt_id + "' "
                        + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    double qty = rs2.getDouble(1);
                    double unit_price = rs2.getDouble(2);
                    String cat_name = rs2.getString(3);
                    int group_id = rs2.getInt(4);
                    //                    System.out.println(qty + " * " + unit_price + " = " + (qty * unit_price));
                    if (group_id == 1) {
                        beverages += (qty * unit_price);
                    } else {
                        foods += (qty * unit_price);
                    }
                }
            }
//            JOptionPane.showMessageDialog(null, session_id);
            String s3 = "select sum(amount) from " + Main.MyDB.getNames() + ".expenses where user_name='" + user_name + "' and Date(date_added) between '" + dfrom + "' and '" + dto + "'";
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(s3);
            if (rs3.next()) {
                expences = rs3.getDouble(1);
            }

//            String user_name = "";
//            if (to_users.username1 == null) {
//                user_name = "Ronald Pascua";
//            } else {
//                user_name = to_users.ret_data(to_users.username1);
//            }
//            System.out.println(tendered + " " + discount + " " + credit + " " + foods + " " + beverages + " " + expences);
            double net = ((tendered + discount) - credit) - expences;
            dollar = S1_currency.ret_dollar(DateType.sf.format(new Date()));

            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";
//            JOptionPane.showMessageDialog(null, SUBREPORT_DIR);
            List<Srpt_credits.field> rpt_credits = new ArrayList();
            String s4 = "select "
                    + "or_no"
                    + ",card_type"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",amount"
                    + ",dollar_amount"
                    + ",dollar_rate"
                    + " from " + Main.MyDB.getNames() + ".credits where user_name='" + user_name + "' and Date(date_payed) between '" + dfrom + "' and '" + dto + "'"
                    + " ";
            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            while (rs4.next()) {
                String trans_no = rs4.getString(1);
                String card_type = rs4.getString(2);
                String card_holder = rs4.getString(3);
                String card_no = rs4.getString(4);
                String approval_code = rs4.getString(5);
                double amount = rs4.getDouble(6);
                double additional = rs4.getDouble(7);
                double dollar_rate = rs4.getDouble(8);
//                System.out.println(approval_code);
                Srpt_credits.field to = new Srpt_credits.field(trans_no, card_type, card_holder, card_no, approval_code, amount, additional, dollar_rate);
                rpt_credits.add(to);
            }

            List<Srpt_expenses.field> rpt_expenses = new ArrayList();

            String s5 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + " from " + Main.MyDB.getNames() + ".expenses where "
                    + " user_name ='" + user_name + "' and Date(date_added) between '" + dfrom + "' and '" + dto + "'"
                    + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs5.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose);
                System.out.println(amount);
                rpt_expenses.add(to);
            }

            to1 = new Srpt_cashier_report(SUBREPORT_DIR, rpt_credits, rpt_expenses, new ArrayList(), new ArrayList(), date_from, date_to, busi_name, user_name, my_dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, user, new ArrayList(), 0, 0, 0, 0);
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {

//        Main.MyDB.setNames("db_pos_restaurant");
        String session_id = "1";
        Date date_from = new Date();
        Date date_to = new Date();
        String busi_name = "";
        double dollar = 0;
        String dfrom = "2013-01-21";
        String dto = "2013-01-21";
        Srpt_cashier_report to1 = new Srpt_cashier_report("", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), 0, 0, 0, 0);

        try {
            Connection conn = MyConnection.connect();

            double tendered = 0;
            double discount = 0;
            double credit = 0;
            double foods = 0;
            double beverages = 0;
            double expences = 0;
            double my_dollar = 0;

            String s0 = "select "
                    + "(peso)"
                    + ",(discount)"
                    + ",(credit)"
                    + ",or_number"
                    + ",(dollar)"
                    + ",(credit_dollar)"
                    + " from " + Main.MyDB.getNames() + ".receipts where "
                    + " cashier_session_id ='" + session_id + "' and Date(receipt_date) between '" + dfrom + "' and '" + dto + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                tendered += rs.getDouble(1);
                discount += rs.getDouble(2);
                credit += (rs.getDouble(3));
                my_dollar += rs.getDouble(5);
                String receipt_id = rs.getString(4);
                String s2 = "select "
                        + "qty"
                        + ",unit_price"
                        + ",cat_name"
                        + ",group_id"
                        + " from " + Main.MyDB.getNames() + ".receipt_items where "
                        + " receipt_id ='" + receipt_id + "' "
                        + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    double qty = rs2.getDouble(1);
                    double unit_price = rs2.getDouble(2);
                    String cat_name = rs2.getString(3);
                    int group_id = rs2.getInt(4);
                    //                    System.out.println(qty + " * " + unit_price + " = " + (qty * unit_price));
                    if (group_id == 1) {
                        beverages += (qty * unit_price);
                    } else {
                        foods += (qty * unit_price);
                    }
                }
            }
//            JOptionPane.showMessageDialog(null, session_id);
            String s3 = "select sum(amount) from " + Main.MyDB.getNames() + ".expenses where session_id='" + session_id + "' and Date(date_added) between '" + dfrom + "' and '" + dto + "'";
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(s3);
            if (rs3.next()) {
                expences = rs3.getDouble(1);
            }

            String user_name = "";
            if (to_users.username1 == null) {
                user_name = "Ronald Pascua";
            } else {
                user_name = to_users.ret_data(to_users.username1);
            }

//            System.out.println(tendered + " " + discount + " " + credit + " " + foods + " " + beverages + " " + expences);
            double net = ((tendered + discount) - credit) - expences;
            dollar = S1_currency.ret_dollar(DateType.sf.format(new Date()));

            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";
//            JOptionPane.showMessageDialog(null, SUBREPORT_DIR);
            List<Srpt_credits.field> rpt_credits = new ArrayList();
            String s4 = "select "
                    + "or_no"
                    + ",card_type"
                    + ",card_holder"
                    + ",card_no"
                    + ",approval_code"
                    + ",amount"
                    + ",dollar_amount"
                    + ",dollar_rate"
                    + " from " + Main.MyDB.getNames() + ".credits where session_id='" + session_id + "' and Date(date_payed) between '" + dfrom + "' and '" + dto + "'"
                    + " ";
            Statement stmt4 = conn.createStatement();
            ResultSet rs4 = stmt4.executeQuery(s4);
            while (rs4.next()) {
                String trans_no = rs4.getString(1);
                String card_type = rs4.getString(2);
                String card_holder = rs4.getString(3);
                String card_no = rs4.getString(4);
                String approval_code = rs4.getString(5);
                double amount = rs4.getDouble(6);
                double additional = rs4.getDouble(7);
                double dollar_rate = rs4.getDouble(8);
//                System.out.println(approval_code);
                Srpt_credits.field to = new Srpt_credits.field(trans_no, card_type, card_holder, card_no, approval_code, amount, additional, dollar_rate);
                rpt_credits.add(to);
            }

            List<Srpt_expenses.field> rpt_expenses = new ArrayList();

            String s5 = "select "
                    + "date_added"
                    + ",amount"
                    + ",purpose"
                    + " from " + Main.MyDB.getNames() + ".expenses where "
                    + " session_id ='" + session_id + "' and Date(date_added) between '" + dfrom + "' and '" + dto + "'"
                    + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs5.getString(1));
                String date_added = DateType.time.format(d);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose);
                System.out.println(amount);
                rpt_expenses.add(to);
            }

            to1 = new Srpt_cashier_report(SUBREPORT_DIR, rpt_credits, rpt_expenses, new ArrayList(), new ArrayList(), date_from, date_to, busi_name, user_name, my_dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, "", new ArrayList(), 0, 0, 0, 0);
            JRViewer viewer = get_viewer_conn_summary(to1, "rpt_daily_sales_liquid.jrxml");
            JFrame f = Application.launchMainFrame3(viewer, "", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static JRViewer get_viewer_conn_summary(Srpt_cashier_report to, String rpt_name) {
//        Connection con11 = null;
        try {
//            con11 = MyConnection.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_cashier_report.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
