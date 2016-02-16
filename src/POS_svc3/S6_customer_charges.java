/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc3;

import POS.Main.MyDB;
import POS.utl.DateType;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class S6_customer_charges {

//      id int auto_increment primary key
//    ->     ,cashier_id int
//    ->     ,product_id varchar(100)
//    ->     ,qty double
//    ->     ,price double
//    ->     ,date_added datetime
//    ->     ,is_payed varchar(100)
//    ->     ,date_payed datetime
//    ->     ,user_id int
    public static class to_customer_charges {

        public final String id;
        public final String cashier_id;
        public final String customer_id;
        public final String product_id;
        public final String product_name;
        public final double qty;
        public final double price;
        public final String date_added;
        public final String is_payed;
        public final String date_payed;
        public final String user_id;
        public final double amount;

        public to_customer_charges(String id, String cashier_id, String customer_id, String product_id, String product_name, double qty, double price, String date_added, String is_payed, String date_payed, String user_id, double amount) {
            this.id = id;
            this.cashier_id = cashier_id;
            this.customer_id = customer_id;
            this.product_id = product_id;
            this.product_name = product_name;
            this.qty = qty;
            this.price = price;
            this.date_added = date_added;
            this.is_payed = is_payed;
            this.date_payed = date_payed;
            this.user_id = user_id;
            this.amount = amount;
        }
    }

    public static List<to_customer_charges> get_charges(String cust_id) {
        List<to_customer_charges> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select id,cashier_id,customer_id,product_id,qty,price,date(date_added),is_payed,date_payed,user_id,product_name from "+MyDB.getNames()+".member_charges where customer_id='" + cust_id + "' and is_payed='" + "no" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {

                String id = rs.getString(1);
                String cashier_id = rs.getString(2);
                String customer_id = rs.getString(3);
                String product_id = rs.getString(4);
//                String product_name = S4_endorsements.get_prod_name(product_id);
                double qty = rs.getDouble(5);
                double price = rs.getDouble(6);
                String date_added = rs.getString(7);
                String is_payed = rs.getString(8);
                String date_payed = rs.getString(9);
                String user_id = rs.getString(10);
                String product_name = rs.getString(11);
                double amount = qty * price;
                to_customer_charges to = new to_customer_charges(id, cashier_id, customer_id, product_id, product_name, qty, price, date_added, is_payed, date_payed, user_id, amount);
                datas.add(to);

            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_charge(String barcode, String product_name, double price, double qty, String cashier_id, String cust_num, String date) {
        try {


            double commission = 0;
            double rate = S4_endorsements.get_commission_rate(barcode);
            rate = (rate / 100);

            commission = (qty * price) * rate;



            Connection conn = MyConnection.connect();
            String date_added = DateType.datetime.format(new Date());
            String s0 = "insert into "+MyDB.getNames()+".member_charges(cashier_id,customer_id,product_id,qty,price,date_added,is_payed,date_payed,user_id,product_name)values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, cashier_id);
            stmt.setString(2, cust_num);
            stmt.setString(3, barcode);
            stmt.setDouble(4, qty);
            stmt.setDouble(5, price);
            stmt.setString(6, date);
            stmt.setString(7, "no");
            stmt.setString(8, date_added);
            stmt.setString(9, "1");
            stmt.setString(10, product_name);
            stmt.execute();
            Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Added");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_charges(String id, String barcode, String prod_name, double qty, double new_qty) {

        try {
            Connection conn = MyConnection.connect();
            if (qty == new_qty) {
                String s0 = "delete from  "+MyDB.getNames()+".member_charges  where id ='" + id + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Prompt.call("Successfully deleted");
//                JOptionPane.showMessageDialog(null, "Successfully deleted");
            } else {
                String s0 = "update "+MyDB.getNames()+".member_charges set qty='" + new_qty + "' where id ='" + id + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Prompt.call("Successfully Updated");
//                JOptionPane.showMessageDialog(null, "Successfully Updated");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_charges(String id, String barcode, String prod_name, double qty, double new_qty) {

        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from  "+MyDB.getNames()+".member_charges  where id ='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Prompt.call("Successfully deleted");
//            JOptionPane.showMessageDialog(null, "Successfully deleted");



        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_cashier_charges(String cashier_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select qty,price from "+MyDB.getNames()+".member_charges where cashier_id='" + cashier_id + "' and is_payed='no' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                double qty = rs.getDouble(1);
                double price = rs.getDouble(2);
                amount += qty * price;
            }
            return amount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_member_credit {

        public final String member_id;
        public final String member_name;
        public final double credit;

        public to_member_credit(String member_id, String member_name, double credit) {
            this.member_id = member_id;
            this.member_name = member_name;
            this.credit = credit;
        }
    }

    public static List<to_member_credit> get_credits(String date, String names, String cashier_id) {

        List<to_member_credit> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "c.id"
                    + ",c.member_name "
                    + "from "+MyDB.getNames()+".customers c "
                    + " where  c.member_name like '" + names + "%'";

////            mc.is_payed='" + "no" + "' and
////            c.member_name like '" + names + "%' 
////                and date(mc.date_added) =date('" + date + "')
//            String s0 = "call pb_pos_restaurant.pb_select_charges(:a_name,:a_date)";
//
//            s0 = SqlStringUtil.parse(s0).setString("a_name", names).setString("a_date", date).ok();


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                double credit = get_credit(id, date, cashier_id);
                to_member_credit to = new to_member_credit(id, name, credit);
                datas.add(to);
            }


            return datas;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static double get_credit(String customer_id, String date, String cashier_id) {

        double credit = 0;

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select ifnull(sum(qty * price),0) as credit from "+MyDB.getNames()+".member_charges where customer_id='" + customer_id + "' and  date(date_added) =date('" + date + "')  and  is_payed='" + "no" + "' and cashier_id='" + cashier_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                credit = rs.getDouble(1);
            }
            return credit;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_direct_credit(String cashier_id, double amount, String date) {
        try {
            Connection conn = MyConnection.connect();
            boolean aa = get_direct_credit_naa(cashier_id, date);

            if (aa == false) {
                String s0 = "insert into "+MyDB.getNames()+".direct_credit(cashier_id,date_added,amount)values(?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.setString(1, cashier_id);
                stmt.setString(2, date);
                stmt.setDouble(3, amount);
                stmt.execute();
                Prompt.call("Successfully Added");
            } else {

                String s0 = "update "+MyDB.getNames()+".direct_credit set amount='" + amount + "' where date_added='" + date + "' ";
                PreparedStatement stmt = conn.prepareStatement(s0);

                stmt.execute();
                Prompt.call("Successfully Updated");
            }




        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_sales_commission(String cashier_id, double amount, String date) {
        try {
            Connection conn = MyConnection.connect();
            boolean aa = get_sales_comm_naa(cashier_id, date);

            if (aa == false) {
                String s0 = "insert into "+MyDB.getNames()+".sales_commission(cashier_id,date_added,comm)values(?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.setString(1, cashier_id);
                stmt.setString(2, date);
                stmt.setDouble(3, amount);
                stmt.execute();
                Prompt.call("Successfully Added");
            } else {

                String s0 = "update "+MyDB.getNames()+".sales_commission set comm='" + amount + "' where date_added='" + date + "' and cashier_id='"+cashier_id+"' ";
                PreparedStatement stmt = conn.prepareStatement(s0);

                stmt.execute();
                Prompt.call("Successfully Updated");
            }




        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_direct_credit(String cashier_id, double amount, String date) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".direct_credit set amount='" + amount + "' where date_added='" + date + "' ";
            PreparedStatement stmt = conn.prepareStatement(s0);

            stmt.execute();
            Prompt.call("Successfully Updated");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_daily_sales(String date) {
        double sales = 0;
        try {

            String s0 = "select sum(price*qty_sold) as s from "+MyDB.getNames()+".sales where date(date_added)='" + date + "'";
            Connection conn = MyConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                sales = rs.getDouble(1);
            }

            return sales;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_cashier_commission_ballfield(String date, String cashier_id) {
        double sales = 0;
        try {

            String s0 = "select comm from "+MyDB.getNames()+".sales_commission where date(date_added)='" + date + "'";
            Connection conn = MyConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                sales = rs.getDouble(1);
            }

            return sales;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_cashier_commission_canteen(String date, String cashier_id) {
        double sales = 0;
        try {

            String s0 = "select comm from "+MyDB.getNames()+".sales_commission where date(date_added)='" + date + "' and cashier_id<>'16'";
            Connection conn = MyConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                sales = rs.getDouble(1);
            }

            return sales;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(get_cashier_commission_ballfield("2012-08-07", "16"));
    }

    public static double get_direct_credit(String cashier_id, String date) {
        double amount = 0;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select amount from "+MyDB.getNames()+".direct_credit where date_added='" + date + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                amount = rs.getDouble(1);
            }

            return amount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static boolean get_direct_credit_naa(String cashier_id, String date) {
        boolean naa = false;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select amount from "+MyDB.getNames()+".direct_credit where date_added='" + date + "' and cashier_id='" + cashier_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                naa = true;
            }

            return naa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static boolean get_sales_comm_naa(String cashier_id, String date) {
        boolean naa = false;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select comm from "+MyDB.getNames()+".sales_commission where date_added='" + date + "' and cashier_id='" + cashier_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                naa = true;
            }

            return naa;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
