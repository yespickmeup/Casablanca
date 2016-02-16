/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.voider;

import POS.Main.MyDB;
import POS.to.to_users;
import POS.utl.DateType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S1_void_table_orders {

    public static class to_room_guests {

        public final int id;
        public final int rooom_id;
        public final String guest_id;
        public final String guest_name;
        public final String checkin_date;
        public final String checkout_date;
        public final int status;
        public final double to_pay;
        public final double paid;
        public final double room_rate;

        public to_room_guests(int id, int rooom_id, String guest_id, String guest_name, String checkin_date, String checkout_date, int status, double to_pay, double paid, double room_rate) {
            this.id = id;
            this.rooom_id = rooom_id;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.checkin_date = checkin_date;
            this.checkout_date = checkout_date;
            this.status = status;
            this.to_pay = to_pay;
            this.paid = paid;
            this.room_rate = room_rate;
        }
    }

    public static class to_tables {

        public final int id;
        public final String table_name;
        public final double rate;
        public final String rate_type;
        public final double percentage;
        public final int status;

        public to_tables(int id, String table_name, double rate, String rate_type, double percentage, int status) {
            this.id = id;
            this.table_name = table_name;
            this.rate = rate;
            this.rate_type = rate_type;
            this.percentage = percentage;
            this.status = status;
        }
    }

    public static List<to_tables> ret_table(String search) {
        List<to_tables> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",table_name"
                    + ",rate"
                    + ",rate_type"
                    + ",percentage"
                    + ",status"
                    + " from " + MyDB.getNames() + ".tables where "
                    + " table_name like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String table_name = rs.getString(2);
                double rate = rs.getDouble(3);
                String rate_type = rs.getString(4);
                double percentage = rs.getDouble(5);
                int status = rs.getInt(6);
                String s2 = "select id from " + MyDB.getNames() + ".room_guests where rooom_id='" + id + "' and status='" + "0" + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    to_tables to = new to_tables(id, table_name, rate, rate_type, percentage, status);
                    datas.add(to);
                }
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_customer_tables_details {

        public final int id;
        public final String table_no_id;
        public final String or_no;
        public final double qty;
        public final String product_name;
        public final String description;
        public final double price;
        public final String img_path;
        public final int status;
        public final String guest_id;
        public final String guest_name;
        public final String cat_id;
        public final String date_added;
        public final int printing_assembly;

        public to_customer_tables_details(int id, String table_no_id, String or_no, double qty, String product_name, String description, double price, String img_path, int status, String guest_id, String guest_name, String cat_id, String date_added, int printing_assembly) {
            this.id = id;
            this.table_no_id = table_no_id;
            this.or_no = or_no;
            this.qty = qty;
            this.product_name = product_name;
            this.description = description;
            this.price = price;
            this.img_path = img_path;
            this.status = status;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.cat_id = cat_id;
            this.date_added = date_added;
            this.printing_assembly = printing_assembly;
        }
    }

    public static List<to_customer_tables_details> ret_data(String table_no, String search) {
        List<to_customer_tables_details> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",table_no_id"
                    + ",or_no"
                    + ",qty"
                    + ",product_name"
                    + ",description"
                    + ",price"
                    + ",img_path"
                    + ",status"
                    + ",guest_id"
                    + ",guest_name"
                    + ",cat_id"
                    + ",date_added"
                    + ",printing_assembly"
                    + " from " + MyDB.getNames() + ".customer_tables_details where "
                    + " table_no_id ='" + table_no + "' "
                    + " and status <>'" + "1" + "'  and description like '%" + search + "%'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String table_no_id = rs.getString(2);
                String or_no = rs.getString(3);
                double qty = rs.getDouble(4);
                String product_name = rs.getString(5);
                String description = rs.getString(6);
                double price = rs.getDouble(7);
                String img_path = rs.getString(8);
                int status = rs.getInt(9);
                String guest_id = rs.getString(10);
                String guest_name = rs.getString(11);
                String cat_id = rs.getString(12);
                String date_added = rs.getString(13);
                int printing_assembly = rs.getInt(14);

                to_customer_tables_details to = new to_customer_tables_details(id, table_no_id, or_no, qty, product_name, description, price, img_path, status, guest_id, guest_name, cat_id, date_added, printing_assembly);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_cancelled_order {

        public final int id;
        public final int or_num;
        public final String or_date;
        public final String prod_name;
        public final int qty;
        public final double price;
        public final String prod_num;

        public to_cancelled_order(int id, int or_num, String or_date, String prod_name, int qty, double price, String prod_num) {
            this.id = id;
            this.or_num = or_num;
            this.or_date = or_date;
            this.prod_name = prod_name;
            this.qty = qty;
            this.price = price;
            this.prod_num = prod_num;
        }
    }

    public static void delete_data(List<to_customer_tables_details> to1) {
        String user = "";
        if (to_users.username1 == null) {
            user = "ron";
        } else {
            user = to_users.username1;
        }
        try {
            Connection conn = MyConnection.connect();
            for (to_customer_tables_details to : to1) {
                String s0 = "delete from " + MyDB.getNames() + ".customer_tables_details where "
                        + " id ='" + to.id + "' "
                        + " ";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_void_table_orders.class, "Order cancelled");

                String s2 = "insert into " + MyDB.getNames() + ".cancelled_order("
                        + "or_num"
                        + ",or_date"
                        + ",prod_name"
                        + ",qty"
                        + ",price"
                        + ",prod_num"
                        + ",user_name"
                        + ")values("
                        + ":or_num"
                        + ",:or_date"
                        + ",:prod_name"
                        + ",:qty"
                        + ",:price"
                        + ",:prod_num"
                        + ",:user_name"
                        + ")";

                s2 = SqlStringUtil.parse(s2).
                        setNumber("or_num", 0).
                        setString("or_date", DateType.datetime.format(new Date())).
                        setString("prod_name", to.description).
                        setNumber("qty", to.qty).
                        setNumber("price", to.price).
                        setString("prod_num", to.product_name).
                        setString("user_name", user).
                        ok();

                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                Lg.s(S1_void_table_orders.class, "Successfully Added");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
