/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc4;

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
import javax.swing.JOptionPane;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S2_customers {

    public static class to_customers {

        public String name;
        public String num;
        public double balance;
        public double credit_limit;
        public double refund;

        public to_customers(String name, String num, double balance, double credit_limit, double refund) {
            this.name = name;
            this.num = num;
            this.balance = balance;
            this.credit_limit = credit_limit;
            this.refund = refund;
        }
    }

    public static class to_cust_charges {

        public final String or;
        public final String ci_number;
        public final double amount;
        public final String date_added;

        public to_cust_charges(String or, String ci_number, double amount, String date_added) {
            this.or = or;
            this.ci_number = ci_number;
            this.amount = amount;
            this.date_added = date_added;
        }
    }

    public static class customers {

        public final String member_name;
        public final String address;
        public final String contact;
        public final String occupation;
        public final String income;
        public final String b_date;
        public final String civil_status;
        public final String is_male;
        public final double balance;
        public final double credit_limit;

        public customers(String member_name, String address, String contact, String occupation, String income, String b_date, String civil_status, String is_male, double balance, double credit_limit) {

            this.member_name = member_name;
            this.address = address;
            this.contact = contact;
            this.occupation = occupation;
            this.income = income;
            this.b_date = b_date;
            this.civil_status = civil_status;
            this.is_male = is_male;
            this.balance = balance;
            this.credit_limit = credit_limit;
        }
    }

    public static List<S2_customers.to_customers> ret_customers(String name, String year) {
        List<S2_customers.to_customers> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select member_name,id,balance,credit_limit from " + MyDB.getNames() + ".customers where member_name like '" + name + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String ids = rs.getString(2);
                double balance = rs.getDouble(3);
                double credit_limit = rs.getDouble(4);
                double refund = 0;
//
                String s2 = "select tendered from " + MyDB.getNames() + ".receipts where member_id='" + ids + "' and YEAR(receipt_date)='" + year + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    refund += rs2.getDouble(1) * .05;
                }

                S2_customers.to_customers to = new S2_customers.to_customers(names, ids, balance, credit_limit, refund);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<S2_customers.to_customers> ret_guest(String name, String year) {
        List<S2_customers.to_customers> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select concat(fname,space(1),mi,space(1),lname) as name,guest_id,balance,credit_limit from " + MyDB.getNames() + ".guests where concat(fname,mi,lname) like '" + name + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String ids = rs.getString(2);
                double balance = rs.getDouble(3);
                double credit_limit = rs.getDouble(4);
                double refund = 0;
//
                String s2 = "select sum(tendered) from " + MyDB.getNames() + ".receipts where member_id='" + ids + "' and YEAR(receipt_date)='" + year + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    refund += rs2.getDouble(1) * .05;
                }

                S2_customers.to_customers to = new S2_customers.to_customers(names, ids, balance, credit_limit, refund);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<S2_customers.to_customers> ret_customers_by_cashier(String name, String cashier_id) {
        List<S2_customers.to_customers> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
//            String s0 = "select member_name,id,balance,credit_limit from "+MyDB.getNames()+".customers where member_name like '" + name + "%'";

            String s0 = "select "
                        + "c.member_name"
                        + ",c.id"
                        + ",balance"
                        + ",credit_limit from " + MyDB.getNames() + ".member_charges mc join " + MyDB.getNames() + ".customers c on mc.customer_id=c.id where mc.cashier_id='" + cashier_id + "'group by c.id";


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String ids = rs.getString(2);
                double balance = rs.getDouble(3);
                double credit_limit = rs.getDouble(4);
                double refund = 0;

                S2_customers.to_customers to = new S2_customers.to_customers(names, ids, balance, credit_limit, refund);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String[] get_details(String num) {
        String[] details = new String[3];
        details[0] = "";
        details[1] = "";
        details[2] = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select member_name,address,contact from " + MyDB.getNames() + ".customers where id = '" + num + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
//                String names = rs.getString(1);
//                String ids = rs.getString(2);
                details[0] = rs.getString(1);
                details[1] = rs.getString(2);
                details[2] = rs.getString(3);
            }

            return details;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add(String name, String add, String contact, String occupation, String income, String bday, String civil_status, String gender, double credit_limit) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".customers(member_name,address,contact,occupation,income,b_date,civil_status,is_male,balance,credit_limit)values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setString(2, add);
            stmt.setString(3, contact);
            stmt.setString(4, occupation);
            stmt.setString(5, income);
            stmt.setString(6, bday);
            stmt.setString(7, civil_status);
            stmt.setString(8, gender);
            stmt.setString(9, "0");
            stmt.setDouble(10, credit_limit);

            stmt.execute();


            Prompt.call("Successfully Added");

//            JOptionPane.showMessageDialog(null, "Successfully Added");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<S2_customers.to_cust_charges> ret_charges(String num) {
        List<S2_customers.to_cust_charges> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select or_num,ci_num,amount,date_added from " + MyDB.getNames() + ".customer_charges where cust_num='" + num + "' and is_payed='" + "no" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String or_num = rs.getString(1);

                String ci_num = rs.getString(2);
                double amount = rs.getDouble(3);
                String date = rs.getString(4);
                S2_customers.to_cust_charges to = new S2_customers.to_cust_charges(or_num, ci_num, amount, date);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_cust_num(String name) {
        String num = "";
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select id from " + MyDB.getNames() + ".customers where member_name='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                num = rs.getString(1);
            }
            return num;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void pay(String num) {
        String date = DateType.sf.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".customer_charges set "
                        + "is_payed='yes'"
                        + ",date_payed='" + date + "' "
                        + "where ci_num='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);

            stmt.execute();

//            String s1 = "update "+MyDB.getNames()+".receipts set is_payed='"+"yes"+"' where or_numer='"++"'";
//            PreparedStatement stmt2 = conn.prepareStatement(s1);
//
//            stmt2.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void pay3(String ci_num, String or_num) {
//        JOptionPane.showMessageDialog(null, ci_num);
        String date = DateType.sf.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".customer_charges set "
                        + "is_payed='yes'"
                        + ",date_payed='" + date + "' "
                        + "where ci_num='" + ci_num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);


            stmt.execute();

            String s1 = "update " + MyDB.getNames() + ".receipts set is_payed='" + "yes" + "' where or_number='" + or_num + "'";
            PreparedStatement stmt2 = conn.prepareStatement(s1);

            stmt2.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void pay2(String num) {
        String date = DateType.sf.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".member_charges set "
                        + "is_payed='yes'"
                        + ",date_payed='" + date + "' "
                        + "where id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);

            stmt.execute();





        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_update_balance(String cust_id, double amount) {
        try {
            Connection conn = MyConnection.connect();

            double bal = S2_customers.get_balance(cust_id);

            bal -= amount;
            String s3 = "update " + MyDB.getNames() + ".customers set balance='" + bal + "' where id='" + cust_id + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s3);
            stmt1.execute();




        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static S2_customers.customers get_cust_details(String num) {
        S2_customers.customers to = null;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "member_name"
                        + ",address"
                        + ",contact"
                        + ",occupation"
                        + ",income"
                        + ",b_date"
                        + ",civil_status"
                        + ",is_male"
                        + ",balance"
                        + ",credit_limit"
                        + " from "
                        + "" + MyDB.getNames() + ".customers where id='" + num + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String member_name = rs.getString(1);
                String address = rs.getString(2);
                String contact = rs.getString(3);
                String occupation = rs.getString(4);
                String income = rs.getString(5);
                String b_date = rs.getString(6);

                System.out.println(b_date);
//                if(b_date.equals("0000-00-00")){
//                    b_date="1990-05-05";
//                }
//                  JOptionPane.showMessageDialog(null, b_date);
                String civil_status = rs.getString(7);
                String is_male = rs.getString(8);
                double balance = rs.getDouble(9);
                double credit_limit = rs.getDouble(10);
                to = new S2_customers.customers(member_name, address, contact, occupation, income, b_date, civil_status, is_male, balance, credit_limit);

            }
            return to;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static S2_customers.customers get_cust_guest(String num) {
        S2_customers.customers to = null;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "member_name"
                        + ",address"
                        + ",contact"
                        + ",occupation"
                        + ",income"
                        + ",b_date"
                        + ",civil_status"
                        + ",is_male"
                        + ",balance"
                        + ",credit_limit"
                        + " from "
                        + "" + MyDB.getNames() + ".guests where guest_id='" + num + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String member_name = rs.getString(1);
                String address = rs.getString(2);
                String contact = rs.getString(3);
                String occupation = rs.getString(4);
                String income = rs.getString(5);
                String b_date = rs.getString(6);

                System.out.println(b_date);
//                if(b_date.equals("0000-00-00")){
//                    b_date="1990-05-05";
//                }
//                  JOptionPane.showMessageDialog(null, b_date);
                String civil_status = rs.getString(7);
                String is_male = rs.getString(8);
                double balance = rs.getDouble(9);
                double credit_limit = rs.getDouble(10);
                to = new S2_customers.customers(member_name, address, contact, occupation, income, b_date, civil_status, is_male, balance, credit_limit);

            }
            return to;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_customer(String member_name, String address, String contact, String occupation, String income, String b_date, String civil_status, String _male, String num, double balance, double credit_limit) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".customers set "
                        + "member_name='" + member_name + "'"
                        + ",address='" + address + "'"
                        + ",contact='" + contact + "'"
                        + ",occupation='" + occupation + "'"
                        + ",income='" + income + "'"
                        + ",b_date='" + b_date + "'"
                        + ",civil_status='" + civil_status + "'"
                        + ",is_male='" + _male + "' "
                        + ",credit_limit='" + credit_limit + "' "
                        + "where id ='" + num + "'";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_guest(String member_name, String address, String contact, String occupation, String income, String b_date, String civil_status, String _male, String num, double balance, double credit_limit) {

//        JOptionPane.showMessageDialog(null, num);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".guests set "
                        + "member_name='" + member_name + "'"
                        + ",address='" + address + "'"
                        + ",contact='" + contact + "'"
                        + ",occupation='" + occupation + "'"
                        + ",income='" + income + "'"
                        + ",b_date='" + b_date + "'"
                        + ",civil_status='" + civil_status + "'"
                        + ",is_male='" + _male + "' "
                        + ",credit_limit='" + credit_limit + "' "
                        + "where guest_id ='" + num + "'";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated"+num+ " "+credit_limit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete(String num) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from " + MyDB.getNames() + ".customers where id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            Prompt.call("Successfully Deleted");
//            JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_balance(String num) {
        double bal = 0;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select balance from " + MyDB.getNames() + ".customers where id='" + num + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                bal = rs.getDouble(1);
            }
            return bal;
//             JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_balance(String num, double bal) {

        try {
            Connection conn = MyConnection.connect();

            String s0 = "update  " + MyDB.getNames() + ".customers set balance='" + bal + "' where id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();


            Prompt.call("Balance updated");
//            JOptionPane.showMessageDialog(null, "Balance updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_balance_guest(String num, double bal) {

        try {
            Connection conn = MyConnection.connect();

            String s0 = "update  " + MyDB.getNames() + ".guests set balance='" + bal + "' where guest_id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();


            Prompt.call("Balance updated");
//            JOptionPane.showMessageDialog(null, "Balance updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(get_balance("2012000164"));
    }
}
