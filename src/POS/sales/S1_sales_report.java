/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.Main.MyDB;
import POS.utl.DateType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S1_sales_report {

    public static class to_receipts {

        public final int id;
        public final int cashier_session_id;
        public final double tendered;
        public final String or_number;
        public final int receipt_status;
        public final String receipt_date;
        public final double discount;
        public final double credit;
        public final String approval_code;
        public final String member_id;
        public final String is_payed;
        public final double dollar;

        public to_receipts(int id, int cashier_session_id, double tendered, String or_number, int receipt_status, String receipt_date, double discount, double credit, String approval_code, String member_id, String is_payed, double dollar) {
            this.id = id;
            this.cashier_session_id = cashier_session_id;
            this.tendered = tendered;
            this.or_number = or_number;
            this.receipt_status = receipt_status;
            this.receipt_date = receipt_date;
            this.discount = discount;
            this.credit = credit;
            this.approval_code = approval_code;
            this.member_id = member_id;
            this.is_payed = is_payed;
            this.dollar = dollar;
        }
    }

    public static class to_receipt_items {

        public final int id;
        public final String receipt_id;
        public final String product_name;
        public final double unit_price;
        public final double qty;
        public final String type_name;
        public final String cat_name;
        public final String description;

        public to_receipt_items(int id, String receipt_id, String product_name, double unit_price, double qty, String type_name, String cat_name, String description) {
            this.id = id;
            this.receipt_id = receipt_id;
            this.product_name = product_name;
            this.unit_price = unit_price;
            this.qty = qty;
            this.type_name = type_name;
            this.cat_name = cat_name;
            this.description = description;
        }
    }

    public static List<to_receipts> ret_data(String session_id) {
        List<to_receipts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",cashier_session_id"
                        + ",tendered"
                        + ",or_number"
                        + ",receipt_status"
                        + ",receipt_date"
                        + ",discount"
                        + ",credit"
                        + ",approval_code"
                        + ",member_id"
                        + ",is_payed"
                        + ",dollar"
                        + ",credit_dollar"
                        + " from " + MyDB.getNames() + ".receipts where "
                        + " cashier_session_id ='" + session_id + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int cashier_session_id = rs.getInt(2);
                double tendered = rs.getDouble(3);
                String or_number = rs.getString(4);
                int receipt_status = rs.getInt(5);
                Date d = new Date();
                String receipt_date = rs.getString(6);
                d = DateType.datetime.parse(receipt_date);

                receipt_date = DateType.time.format(d);
                double discount = rs.getDouble(7);
                double credit = rs.getDouble(8);

                String approval_code = rs.getString(9);
                String member_id = rs.getString(10);
                String is_payed = rs.getString(11);
                double dollar = rs.getDouble(12);
                double credit_dollar = rs.getDouble(13);
                credit += credit_dollar;
                to_receipts to = new to_receipts(id, cashier_session_id, tendered, or_number, receipt_status, receipt_date, discount, credit, approval_code, member_id, is_payed, dollar);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipt_items> ret_items(String receipt_no) {
        List<to_receipt_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",receipt_id"
                        + ",product_name"
                        + ",unit_price"
                        + ",qty"
                        + ",type_name"
                        + ",cat_name"
                        + ",description"
                        + " from " + MyDB.getNames() + ".receipt_items where "
                        + " receipt_id ='" + receipt_no + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_id = rs.getString(2);
                String product_name = rs.getString(3);
                double unit_price = rs.getDouble(4);
                double qty = rs.getDouble(5);
                String type_name = rs.getString(6);
                String cat_name = rs.getString(7);
                String description = rs.getString(8);
                to_receipt_items to = new to_receipt_items(id, receipt_id, product_name, unit_price, qty, type_name, cat_name, description);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_cash_in(String cashier_session) {
        double cashin = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "cash_in"
                        + " from " + MyDB.getNames() + ".cash_drawer where "
                        + " cashier_session_id ='" + cashier_session + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
            return cashin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_expenses(String cashier_session) {
        double cashin = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount)"
                        + " from " + MyDB.getNames() + ".expenses where "
                        + " session_id ='" + cashier_session + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                cashin = rs.getDouble(1);
            }
            return cashin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_my_sales {

        public final double peso;
        public final double dollar;
        public final double credit;
        public final double discounts;
        public final double expenses;
        public final double cash_in;
        public final double cash_out;

        public to_my_sales(double peso, double dollar, double credit, double discounts, double expenses, double cash_in, double cash_out) {
            this.peso = peso;
            this.dollar = dollar;
            this.credit = credit;
            this.discounts = discounts;
            this.expenses = expenses;
            this.cash_in = cash_in;
            this.cash_out = cash_out;
        }
    }

    public static to_my_sales ret_sales(String date_from, String date_to) {

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(tendered)"
                        + ",sum(dollar)"
                        + ",sum(credit)"
                        + ",sum(discount)"
                        + ",sum(credit_dollar)"
                        + ",dollar_rate"
                        + " from " + MyDB.getNames() + ".receipts where "
                        + " date(receipt_date) between '" + date_from + "' and '" + date_to + "' "
                        + " ";
            to_my_sales to = new to_my_sales(0, 0, 0, 0, 0, 0, 0);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);

            double peso = 0;
            double dollar = 0;
            double credit = 0;
            double discounts = 0;
            double expenses = 0;
            double cash_in = 0;
            double cash_out = 0;
            if (rs.next()) {
                peso = rs.getDouble(1);
                dollar = rs.getDouble(2);
                credit = rs.getDouble(3);
                discounts = rs.getDouble(4);
                double credit_dollar = rs.getDouble(5);
                credit += credit_dollar;
                expenses = 0;
                cash_in = 0;
                cash_out = 0;
            }
            String s2 = "select "
                        + "sum(amount)"
                        + " from " + MyDB.getNames() + ".expenses where "
                        + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                        + " ";

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);

            if (rs2.next()) {
                expenses = rs2.getDouble(1);
            }

            to = new to_my_sales(peso, dollar, credit, discounts, expenses, cash_in, cash_out);
            return to;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
