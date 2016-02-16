/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

import POS.Main.MyDB;
import POS.svc4.S3_get_qty_price;
import POS.to.to_order;
import POS.utl.DateType;
import POS.utl.NumType;
import POS.utl.Prompt;
import POS_svc4.S5_tables.to_tables2;
import POS_to4.to_customer_table;
import com.jgoodies.binding.list.ArrayListModel;
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
public class S5_customer_tables {

    public static List<to_customer_table.tables> get_customer_tables() {

        List<to_customer_table.tables> datas = new ArrayList();

        List<to_tables2> ta = S5_tables.get_tables("");
//   
        for (to_tables2 to : ta) {

            try {
                Connection conn = MyConnection.connect();
                String s0 = "select table_no,date_added,amount,or_no,id from " + MyDB.getNames() + ".customer_tables where table_no='" + to.name + "' ";

                String time = "- - -";
                double amount = 0.00;
                String or_no = "- - -";
                String status = "AVAILABLE";
                String id = "- - -";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                if (rs.next()) {
                    time = rs.getString(2);
                    amount = rs.getDouble(3);
                    status = "NOT AVAILABLE";
                    id = rs.getString(5);
                    or_no = rs.getString(4);
                    to_customer_table.tables to1 = new to_customer_table.tables(to.name, time, amount, or_no, status, id);
                    datas.add(to1);
                } else {
                    to_customer_table.tables to1 = new to_customer_table.tables(to.name, time, amount, or_no, status, id);
                    datas.add(to1);
                }



            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                MyConnection.close();
            }

        }
        return datas;
    }

    public static List<String> get_customer_tables_2() {

        List<String> datas = new ArrayList();


//   


        try {
            Connection conn = MyConnection.connect();
            String s0 = "select table_name from " + MyDB.getNames() + ".tables ";


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);

                datas.add(name);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }



    }

    public static List<to_order> get_details(String table_no) {
//        JOptionPane.showMessageDialog(null, table_no);
        List<to_order> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select qty,product_name"
                        + ",price,guest_id,cat_id,printing_assembly,group_id from " + MyDB.getNames() + ".customer_tables_details where table_no_id='" + table_no + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {


                double qty = rs.getDouble(1);
                String code = rs.getString(2);
                double price = rs.getDouble(3);
                String name = S3_get_qty_price.get_name(code);
                String guest_id = rs.getString(4);
                String cat_id = rs.getString(5);
                int printing_assembly = rs.getInt(6);
                int group_id = rs.getInt(7);
                String s2 = "select "
                            + "cat_name"
                            + " from " + MyDB.getNames() + ".category where "
                            + " id ='" + cat_id + "' "
                            + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                to_order to = new to_order(name, price, qty, "pcs", code, 0, guest_id, cat_id, cat_name, printing_assembly,group_id);
//                System.out.println(to);
                datas.add(to);
            }
            return datas;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static boolean get_details2(String table_no) {

        boolean naa = false;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select qty from " + MyDB.getNames() + ".customer_tables_details    where table_no_id='" + table_no + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {


                double qty = rs.getDouble(1);
                naa = true;
                break;
            }
            return naa;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void order(String table, String or, ArrayListModel tbl_orders_ALM, String total) {


        List<to_order> datas = tbl_orders_ALM;
        total = NumType.no_comma(total);

        String date = DateType.datetime.format(new Date());

        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".customer_tables(table_no,date_added,amount,or_no)values(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, table);
            stmt.setString(2, date);
            stmt.setString(3, total);
            stmt.setString(4, or);
            stmt.execute();

            for (to_order to : datas) {
                String s1 = "insert into " + MyDB.getNames() + ".customer_tables_details(table_no_id,or_no,qty,product_name,price,amount)values(?,?,?,?,?,?)";
                PreparedStatement stmt1 = conn.prepareStatement(s1);
                stmt1.setString(1, table);
                stmt1.setString(2, or);
                stmt1.setDouble(3, to.quantity);
                stmt1.setString(4, to.code);
                stmt1.setDouble(5, to.unit_price);
                double amount = to.quantity * to.unit_price;
                stmt1.setDouble(6, amount);
                stmt1.execute();
            }

            Prompt.call("Successfully Added");

//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_order(String table, String or, ArrayListModel tbl_orders_ALM, String text1) {
        List<to_order> datas = tbl_orders_ALM;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".customer_tables_details where table_no_id='" + table + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);

            stmt.execute();
            double am = 0;
            for (to_order to : datas) {
                String s1 = "insert into " + MyDB.getNames() + ".customer_tables_details(table_no_id,or_no,qty,product_name,price,amount)values(?,?,?,?,?,?)";
                PreparedStatement stmt1 = conn.prepareStatement(s1);
                stmt1.setString(1, table);
                stmt1.setString(2, or);
                stmt1.setDouble(3, to.quantity);
                stmt1.setString(4, to.code);
                stmt1.setDouble(5, to.unit_price);
                double amount = to.quantity * to.unit_price;
                stmt1.setDouble(6, amount);
                stmt1.execute();
                am += to.quantity * to.unit_price;
            }
            String s2 = "update  " + MyDB.getNames() + ".customer_tables set amount='" + am + "' where table_no='" + table + "'";
            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Prompt.call("Order Updated");
//            JOptionPane.showMessageDialog(null, "Order Updated");s
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static void pay(String table) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from " + MyDB.getNames() + ".customer_tables where table_no='" + table + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            String s1 = "delete from " + MyDB.getNames() + ".customer_tables_details where table_no_id='" + table + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
//            JOptionPane.showMessageDialog(null, "Payed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
