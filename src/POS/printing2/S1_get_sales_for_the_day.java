/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.printing2;

import POS.Main;
import POS.Main.MyDB;
import POS.currency.S1_currency;
import rpt_liquid.Srpt_credits;
import rpt_liquid.Srpt_credits.field;
import rpt_liquid.Srpt_expenses;
import POS.to.to_users;
import POS.utl.DateType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import POS.utl.MyConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author i1
 */
public class S1_get_sales_for_the_day {

    public static class to_reciept_sales {

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
        public final String SUBREPORT_DIR;
        public final List<Srpt_credits.field> rpt_credits;
        public final List<Srpt_expenses.field> rpt_expenses;

        public to_reciept_sales(Date date_from, Date date_to, String busi_name, String my_db, double dollar, double tendered, double discount, double credit, double foods, double beverages, double expences, double tot_bev, double net_total, String SUBREPORT_DIR, List<field> rpt_credits, List<Srpt_expenses.field> rpt_expenses) {
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
            this.SUBREPORT_DIR = SUBREPORT_DIR;
            this.rpt_credits = new ArrayList();
            this.rpt_expenses = new ArrayList();
        }

        public String getSUBREPORT_DIR() {
            return SUBREPORT_DIR;
        }

        public double getBeverages() {
            return beverages;
        }

        public String getBusi_name() {
            return busi_name;
        }

        public double getCredit() {
            return credit;
        }

        public Date getDate_from() {
            return date_from;
        }

        public Date getDate_to() {
            return date_to;
        }

        public double getDiscount() {
            return discount;
        }

        public double getDollar() {
            return dollar;
        }

        public double getExpences() {
            return expences;
        }

        public double getFoods() {
            return foods;
        }

        public String getMy_db() {
            return my_db;
        }

        public double getNet_total() {
            return net_total;
        }

        public List<field> getRpt_credits() {
            return rpt_credits;
        }

        public List<Srpt_expenses.field> getRpt_expenses() {
            return rpt_expenses;
        }

        public double getTendered() {
            return tendered;
        }

        public double getTot_bev() {
            return tot_bev;
        }
    }

    public static to_reciept_sales ret_data(String date, Date date_from, Date date_to, String busi_name, double dollar) {
        to_reciept_sales to1 = new to_reciept_sales(new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), new ArrayList());
        double tendered = 0;
        double discount = 0;
        double credit = 0;
        double foods = 0;
        double beverages = 0;
        double expences = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "(peso)"
                        + ",(discount)"
                        + ",(credit)"
                        + ",or_number"
                        + ",(credit_dollar)"
                        + " from " + Main.MyDB.getNames() + ".receipts where "
                        + " date(receipt_date) ='" + date + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                tendered += rs.getDouble(1);
                discount += rs.getDouble(2);
                credit += (rs.getDouble(3) + rs.getDouble(5));

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
            String s3 = "select sum(amount) from " + Main.MyDB.getNames() + ".expenses where ";
            String user_name = "";
            if (to_users.username1 == null) {
                user_name = "Ronald Pascua";
            } else {
                user_name = to_users.ret_data(to_users.username1);
            }

//            System.out.println(tendered + " " + discount + " " + credit + " " + foods + " " + beverages + " " + expences);
            double net = ((tendered + discount) - credit) - expences;
            to1 = new to_reciept_sales(date_from, date_to, busi_name, user_name, dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, "", new ArrayList(), new ArrayList());
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_reciept_sales ret_data_session(String session_id, Date date_from, Date date_to, String busi_name, double dollar, String dfrom, String dto) {

        to_reciept_sales to1 = new to_reciept_sales(new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), new ArrayList());

        double tendered = 0;
        double discount = 0;
        double credit = 0;
        double foods = 0;
        double beverages = 0;
        double expences = 0;
        double my_dollar = 0;
        try {
            Connection conn = MyConnection.connect();
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
                        + " from " + Main.MyDB.getNames() + ".credits where session_id='" + session_id + "'"
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

                Srpt_credits.field to = new field(trans_no, card_type, card_holder, card_no, approval_code, amount, additional, dollar_rate);
                rpt_credits.add(to);
            }


            List<Srpt_expenses.field> rpt_expenses = new ArrayList();

            String s5 = "select "
                        + "date_added"
                        + ",amount"
                        + ",purpose"
                        + " from " + MyDB.getNames() + ".expenses where "
                        + " session_id ='" + session_id + "' "
                        + " ";

            Statement stmt5 = conn.createStatement();
            ResultSet rs5 = stmt5.executeQuery(s5);
            while (rs5.next()) {
                String date_added = rs5.getString(1);
                double amount = rs5.getDouble(2);
                String purpose = rs5.getString(3);

                Srpt_expenses.field to = new Srpt_expenses.field(date_added, amount, purpose);
                rpt_expenses.add(to);
            }


            to1 = new to_reciept_sales(date_from, date_to, busi_name, user_name, my_dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, SUBREPORT_DIR, rpt_credits, rpt_expenses);
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_reciept_sales ret_data2(String date, Date date_from, Date date_to, String busi_name, double dollar) {
        to_reciept_sales to1 = new to_reciept_sales(new Date(), new Date(), "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, "", new ArrayList(), new ArrayList());

        double tendered = 0;
        double discount = 0;
        double credit = 0;
        double foods = 0;
        double beverages = 0;
        double expences = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "(tendered)"
                        + ",(discount)"
                        + ",(credit)"
                        + ",or_number"
                        + " from " + Main.MyDB.getNames() + ".receipts where "
                        + " date(receipt_date) ='" + date + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                tendered += rs.getDouble(1);
                discount += rs.getDouble(2);
                credit += rs.getDouble(3);

                String receipt_id = rs.getString(4);
                String s2 = "select "
                            + "qty"
                            + ",unit_price"
                            + ",cat_name"
                            + " from " + Main.MyDB.getNames() + ".receipt_items where "
                            + " receipt_id ='" + receipt_id + "' "
                            + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    double qty = rs2.getDouble(1);
                    double unit_price = rs2.getDouble(2);
                    String cat_name = rs2.getString(3);
                    System.out.println(qty + " * " + unit_price + " = " + (qty * unit_price));
                    if (cat_name.equals("Mixed Drinks") || cat_name.equals("Coffee & Tea")
                        || cat_name.equals("Fruit Juices & Shakes")
                        || cat_name.equals("Softdrinks")
                        || cat_name.equals("Beers")
                        || cat_name.equals("Liquors")) {
                        beverages += (qty * unit_price);
                    } else {
                        foods += (qty * unit_price);
                    }
                }
            }
            foods = 0;
            beverages = 0;
            System.out.println(tendered + " " + discount + " " + credit + " " + foods + " " + beverages + " " + expences);
            double net = ((tendered + discount) - credit) - expences;
            String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";
            List<Srpt_credits.field> rpt_credits = new ArrayList();
            List<Srpt_expenses.field> rpt_expenses = new ArrayList();
            to1 = new to_reciept_sales(date_from, date_to, busi_name, "", dollar, tendered, discount, credit, foods, beverages, expences, (foods + beverages), net, SUBREPORT_DIR, rpt_credits, rpt_expenses);
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        double tendered = 0;
        double discount = 0;
        double credit = 0;
        double foods = 0;
        double beverages = 0;
        double expences = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "(tendered)"
                        + ",(discount)"
                        + ",(credit)"
                        + ",or_number"
                        + " from " + "db_pos_casablanca" + ".receipts where "
                        + " date(receipt_date) ='" + "2013-01-01" + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                tendered += rs.getDouble(1);
                discount += rs.getDouble(2);
                credit += rs.getDouble(3);

                String receipt_id = rs.getString(4);
                String s2 = "select "
                            + "qty"
                            + ",unit_price"
                            + ",cat_name"
                            + " from " + "db_pos_casablanca" + ".receipt_items where "
                            + " receipt_id ='" + receipt_id + "' "
                            + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    double qty = rs2.getDouble(1);
                    double unit_price = rs2.getDouble(2);
                    String cat_name = rs2.getString(3);
                    System.out.println(qty + " * " + unit_price + " = " + (qty * unit_price));
                    if (cat_name.equals("Mixed Drinks") || cat_name.equals("Coffee & Tea")
                        || cat_name.equals("Fruit Juices & Shakes")
                        || cat_name.equals("Softdrinks")
                        || cat_name.equals("Beers")
                        || cat_name.equals("Liquors")) {
                        beverages += (qty * unit_price);
                    } else {
                        foods += (qty * unit_price);
                    }
                }

            }
            System.out.println(tendered + " " + discount + " " + credit + " " + foods + " " + beverages + " " + expences);
//            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
