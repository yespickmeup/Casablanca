/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

import POS.Main.MyDB;
import POS.utl.DateType;
import POS.utl.DateUtils;
import POS_to4.to_search_prod;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;
import java.util.Date;
import test.Dlg_check_liquid;

/**
 *
 * @author Dummy
 */
public class S2_search {

    public static List<to_search_prod> ret_product(String name) {

        List<to_search_prod> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select product_name,description,price,product_qty from " + MyDB.getNames() + ".inventory2_stocks_left where description like '%" + name + "%' or lookup_code like '%" + name + "%' or product_name like '" + name + "%' ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                String price = rs.getString(3);
                double qty = rs.getDouble(4);
                to_search_prod to = new to_search_prod(names, "pcs", desc, price, qty);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_items {

        public String name;
        public String uom;
        public String desc;
        public final double price;
        public double qty;
        public String img_path;
        public double qty2;
        public final String guest_id;
        public final String cat_id;
        public final String category_name;
        public final int printing_assembly;
        public final int status;
        public String disc_name;
        public double disc_rate;
        public double discount;
        public String customer_name;
        public String customer_id;
        public String customer_address;
        public final String date_added;
        public final int group_id;

        public to_items(String name, String uom, String desc, double price, double qty, String img_path, double qty2, String guest_id, String cat_id, String category_name, int printing_assembly, int status, String disc_name, double disc_rate, double discount, String customer_name, String customer_id, String customer_address, String date_added, int group_id) {
            this.name = name;
            this.uom = uom;
            this.desc = desc;
            this.price = price;
            this.qty = qty;
            this.img_path = img_path;
            this.qty2 = qty2;
            this.guest_id = guest_id;
            this.cat_id = cat_id;
            this.category_name = category_name;
            this.printing_assembly = printing_assembly;
            this.status = status;
            this.disc_name = disc_name;
            this.disc_rate = disc_rate;
            this.discount = discount;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.customer_address = customer_address;
            this.date_added = date_added;
            this.group_id = group_id;
        }

        public String getDisc_name() {
            return disc_name;
        }

        public void setDisc_name(String disc_name) {
            this.disc_name = disc_name;
        }

        public String getCustomer_address() {
            return customer_address;
        }

        public void setCustomer_address(String customer_address) {
            this.customer_address = customer_address;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public double getDisc_rate() {
            return disc_rate;
        }

        public void setDisc_rate(double disc_rate) {
            this.disc_rate = disc_rate;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

//        public void setPrice(double price) {
//            this.price = price;
//        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getQty2() {
            return qty2;
        }

        public void setQty2(double qty2) {
            this.qty2 = qty2;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }
    }

    public static class to_items_status {

        public double qty;
        public String name;
        public String uom;
        public String desc;
        public double price;
        public String img_path;
        public double qty2;
        public boolean status;

        public to_items_status(double qty, String name, String uom, String desc, double price, String img_path, double qty2, boolean status) {
            this.qty = qty;
            this.name = name;
            this.uom = uom;
            this.desc = desc;
            this.price = price;
            this.img_path = img_path;
            this.qty2 = qty2;
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public double getQty2() {
            return qty2;
        }

        public void setQty2(double qty2) {
            this.qty2 = qty2;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

    public static class to_orders {

        public String name;
        public String uom;
        public String desc;
        public final double price;
        public double qty;
        public String img_path;
        public double qty2;
        public List<S2_search.to_items_status> to_sub;
        public final double amount_to_pay;
        public String cat_id;
        public final String category_name;
        public final int printing_assembly;
        public String disc_name;
        public double disc_rate;
        public double discount;
        public String customer_name;
        public String customer_id;
        public String customer_address;
        public int group_id;

        public to_orders(String name, String uom, String desc, double price, double qty, String img_path, double qty2, List<to_items_status> to_sub, double amount_to_pay, String cat_id, String category_name, int printing_assembly, String disc_name, double disc_rate, double discount, String customer_name, String customer_id, String customer_address, int group_id) {
            this.name = name;
            this.uom = uom;
            this.desc = desc;
            this.price = price;
            this.qty = qty;
            this.img_path = img_path;
            this.qty2 = qty2;
            this.to_sub = to_sub;
            this.amount_to_pay = amount_to_pay;
            this.cat_id = cat_id;
            this.category_name = category_name;
            this.printing_assembly = printing_assembly;
            this.disc_name = disc_name;
            this.disc_rate = disc_rate;
            this.discount = discount;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.customer_address = customer_address;
            this.group_id = group_id;
        }

        public double getAmount_to_pay() {
            return amount_to_pay;
        }

       

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getCustomer_address() {
            return customer_address;
        }

        public void setCustomer_address(String customer_address) {
            this.customer_address = customer_address;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public double getDisc_rate() {
            return disc_rate;
        }

        public void setDisc_rate(double disc_rate) {
            this.disc_rate = disc_rate;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public String getImg_path() {
            return img_path;
        }

        public void setImg_path(String img_path) {
            this.img_path = img_path;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

       

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getQty2() {
            return qty2;
        }

        public void setQty2(double qty2) {
            this.qty2 = qty2;
        }

        public List<to_items_status> getTo_sub() {
            return to_sub;
        }

        public void setTo_sub(List<to_items_status> to_sub) {
            this.to_sub = to_sub;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public String getDisc_name() {
            return disc_name;
        }

        public void setDisc_name(String disc_name) {
            this.disc_name = disc_name;
        }
    }

    public static class to_rooms {

        public final String id;
        public final String name;
        public final String num;
        public final String status;
        public final double topay;
        public final String guest_id;
        public final String guest_name;
        public final String date_added;
        public final String room;
        public final double room_rate;
        public final List<Dlg_check_liquid.to_guests> to_guest;
        public final String type;
        public double percentage;
        public final int table_location_id;

        public to_rooms(String id, String name, String num, String status, double topay, String guest_id, String guest_name, String date_added, String room, double room_rate, List<Dlg_check_liquid.to_guests> to_guest, String type, double percentage, int table_location_id) {
            this.id = id;
            this.name = name;
            this.num = num;
            this.status = status;
            this.topay = topay;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.date_added = date_added;
            this.room = room;
            this.room_rate = room_rate;
            this.to_guest = to_guest;
            this.type = type;
            this.percentage = percentage;
            this.table_location_id = table_location_id;
        }

        public double getPercentage() {
            return percentage;
        }

        public void setPercentage(double percentage) {
            this.percentage = percentage;
        }
    }

    public static List<to_items> ret_items(String cat_id, String name, String is_active,int type_id) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",price"
                        + ",product_qty"
                        + ",img_path "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",group_id "
                        + "from " + MyDB.getNames() + ".inventory2_stocks_left "
                        + "where "
                        + "description like '%" + name + "%' and cat_id = '" + cat_id + "' and is_active like '%" + is_active + "%' and types_num='"+type_id+"' or "
                        + "lookup_code like '%" + name + "%' and cat_id = '" + cat_id + "' and is_active like '%" + is_active + "%' and types_num='"+type_id+"' or "
                        + "product_name like '" + name + "%' and cat_id = '" + cat_id + "' and is_active like '%" + is_active + "%' and types_num='"+type_id+"'  order by description asc limit 30";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String cat_ids = rs.getString(6);
                int printing_assembly = rs.getInt(7);
                int group_id = rs.getInt(8);
                int status = 0;
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                            + "cat_name"
                            + " from " + MyDB.getNames() + ".category where "
                            + " id ='" + cat_ids + "' "
                            + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, "-1", cat_ids, cat_name, printing_assembly, status, "", 0, 0, "", "", "", "", group_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_items> ret_items_no_category(String cat_id, String name, String is_active) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",price"
                        + ",product_qty"
                        + ",img_path "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",group_id "
                        + "from " + MyDB.getNames() + ".inventory2_stocks_left "
                        + "where "
                        + "description like '%" + name + "%' and cat_id like '%" + cat_id + "%' and is_active like '%" + is_active + "%' or "
                        + "lookup_code like '%" + name + "%' and cat_id like '%" + cat_id + "%'  and is_active like '%" + is_active + "%' or "
                        + "product_name like '" + name + "%' and cat_id like '%" + cat_id + "%'  and is_active like '%" + is_active + "%' order by description asc limit 30";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String cat_ids = rs.getString(6);
                int printing_assembly = rs.getInt(7);
                int group_id = rs.getInt(8);
                int status = 0;
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                String s2 = "select "
                            + "cat_name"
                            + " from " + MyDB.getNames() + ".category where "
                            + " id ='" + cat_ids + "' "
                            + " ";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                String cat_name = "";
                if (rs2.next()) {
                    cat_name = rs2.getString(1);
                }
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, "-1", cat_ids, cat_name, printing_assembly, status, "", 0, 0, "", "", "", "", group_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_items> ret_items_room(String room_no) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",price"
                        + ",qty"
                        + ",img_path "
                        + ",guest_id "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",status"
                        + ",disc_name"
                        + ",disc_rate"
                        + ",discount"
                        + ",customer_name"
                        + ",customer_id"
                        + ",customer_address "
                        + ",date_added "
                        + ",group_id "
                        + "from " + MyDB.getNames() + ".customer_tables_details "
                        + "where "
                        + "table_no_id = '" + room_no + "' and status <>'" + "1" + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }

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
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_items> ret_items_room3(String room_no) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",price"
                        + ",qty"
                        + ",img_path "
                        + ",guest_id "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",status "
                        + ",disc_name "
                        + ",disc_rate "
                        + ",discount"
                        + ",customer_name "
                        + ",customer_id"
                        + ",customer_address "
                        + ",date_added "
                        + ",group_id "
                        + "from " + MyDB.getNames() + ".customer_tables_details2 "
                        + "where "
                        + "table_no_id = '" + room_no + "' and status <>'" + "1" + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
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
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_items> ret_guest_orders(String room_no, String guest_name) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",price"
                        + ",qty"
                        + ",img_path "
                        + ",guest_id "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",status "
                        + ",disc_name "
                        + ",disc_rate "
                        + ",discount"
                        + ",customer_name "
                        + ",customer_id"
                        + ",customer_address "
                        + ",date_added "
                        + ",group_id "
                        + "from " + MyDB.getNames() + ".customer_tables_details "
                        + "where "
                        + "table_no_id = '" + room_no + "' and status<>'" + "1" + "' and guest_name like '%" + guest_name + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);


                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
//                System.out.println(desc + " 0asdasd");
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
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
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_items> ret_guest_orders_where(String room_no, String where) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",price"
                        + ",qty"
                        + ",img_path "
                        + ",guest_id "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",status "
                        + ",disc_name "
                        + ",disc_rate "
                        + ",discount"
                        + ",customer_name "
                        + ",customer_id"
                        + ",customer_address "
                        + ",date_added "
                        + ",group_id "
                        + "from " + MyDB.getNames() + ".customer_tables_details "
                        + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
//                System.out.println(desc + " 0asdasd");
                int group_id = rs.getInt(17);
                System.out.println(guest_id + " - sss");
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
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
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_items> ret_guest_orders_where3(String room_no, String where) {

        List<to_items> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "product_name"
                        + ",description"
                        + ",price"
                        + ",qty"
                        + ",img_path "
                        + ",guest_id "
                        + ",cat_id "
                        + ",printing_assembly "
                        + ",status "
                        + ",disc_name "
                        + ",disc_rate "
                        + ",discount"
                        + ",customer_name "
                        + ",customer_id"
                        + ",customer_address "
                        + ",date_added "
                        + ",group_id "
                        + "from " + MyDB.getNames() + ".customer_tables_details2 "
                        + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String names = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                double qty = rs.getDouble(4);
                String img_path = rs.getString(5);
                String guest_id = rs.getString(6);
                String cat_id = rs.getString(7);
                int printing_assembly = rs.getInt(8);
                int status = rs.getInt(9);

                String disc_name = rs.getString(10);
                double disc_rate = rs.getDouble(11);
                double discount = rs.getDouble(12);
                String customer_name = rs.getString(13);
                String customer_id = rs.getString(14);
                String customer_address = rs.getString(15);
                String date_added = rs.getString(16);
                int group_id = rs.getInt(17);
                System.out.println(guest_id + " - sss");
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
                if (img_path.equals("empty")) {
                    img_path = "siopao.jpeg";
                }
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
                to_items to = new to_items(names, "pcs", desc, price, qty, img_path, qty, guest_id, cat_id, cat_name, printing_assembly, status, disc_name, disc_rate, discount, customer_name, customer_id, customer_address, date_added, group_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_guest_chargers_where(String room_no, String where) {

        double charge = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount)"
                        + "from " + MyDB.getNames() + ".guest_charges "
                        + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_guest_chargers_where3(String room_no, String where) {

        double charge = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount)"
                        + "from " + MyDB.getNames() + ".guest_charges2 "
                        + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int ret_guest_charge_count(String room_no, String where) {

//        JOptionPane.showMessageDialog(null, room_no);
        int charge = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "checkin_date "
                        + "from " + MyDB.getNames() + ".room_guests"
                        + "" + where + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                Date d = new Date();
                d = DateType.datetime.parse(rs.getString(1));
                charge = DateUtils.count_days(d, new Date());
//                charge = rs.getInt(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_guest_charge_(String room_no, String where) {

//        JOptionPane.showMessageDialog(null, room_no);
        double charge = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount)"
                        + "from " + MyDB.getNames() + ".guest_charges "
                        + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_table_charge(String room_no, String where) {

//        JOptionPane.showMessageDialog(null, room_no);
        double charge = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "(amount)"
                        + "from " + MyDB.getNames() + ".guest_charges "
                        + " " + where + "";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_guest_chargers_where_all(String room_no) {

        double charge = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount)"
                        + "from " + MyDB.getNames() + ".guest_charges "
                        + " where status='" + "0" + "' and table_no = '" + room_no + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_guest_chargers_where_all3(String room_no) {

        double charge = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount)"
                        + "from " + MyDB.getNames() + ".guest_charges2 "
                        + " where status='" + "0" + "' and table_no = '" + room_no + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                charge = rs.getDouble(1);
            }
            return charge;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
