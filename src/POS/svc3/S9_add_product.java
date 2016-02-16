/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.to2.to_add_product;
import POS.utl.Prompt;
import POS.category_types.S1_categories;
import POS_svc4.S7_uom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S9_add_product {

    public static List<to_add_product> ret_products(String type, String names) {
        List<to_add_product> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select product_name,description,price,product_qty,prod_num,is_vat,types_num,is_linient,w_commission,comm_amount"
                        + ",cat_id,cost,printing_assembly,is_active,types_num,types  from " + MyDB.getNames() + ".inventory2_stocks_left"
                        + " where types='" + type + "' and  product_name like '" + names + "%' or types='" + type + "' and  description like '" + names + "%' order by description asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String desc = rs.getString(2);
                String price = rs.getString(3);
                String qty = rs.getString(4);
                String num = rs.getString(5);
                String vat = rs.getString(6);
                String types_num = rs.getString(7);
                String is_linient = rs.getString(8);
                String w_commission = rs.getString(9);
                double comm_amount = rs.getDouble(10);
                String cat_id = rs.getString(11);
                double cost = rs.getDouble(12);
                int printing_assembly = rs.getInt(13);
                int is_active = rs.getInt(14);
                String type_id = rs.getString(15);
                String type_name = rs.getString(16);

                String category_name = "";
                String s3 = "select cat_name from " + MyDB.getNames() + ".category where cat_num='" + cat_id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s3);
                if (rs2.next()) {
                    category_name = rs2.getString(1);
                }
                to_add_product to = new to_add_product(name, desc, price, qty, num, vat, types_num, is_linient, w_commission, comm_amount, cat_id, cost, printing_assembly, is_active, category_name, type_id, type_name);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_add_product> ret_products_category(String type, String names, String cat_id) {

        List<to_add_product> datas = new ArrayList();


        try {
            Connection conn = MyConnection.connect();

            String s0 = "select product_name,description,price,product_qty,prod_num,is_vat,types_num"
                        + ",is_linient,w_commission,comm_amount,cat_id"
                        + ",cost,printing_assembly,is_active,types_num,types  from " + MyDB.getNames() + ".inventory2_stocks_left"
                        + " where cat_id='" + cat_id + "' and  product_name like '" + names + "%' or cat_id='" + type + "' and  description like '" + names + "%' order by description asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String desc = rs.getString(2);
                String price = rs.getString(3);
                String qty = rs.getString(4);
                String num = rs.getString(5);
                String vat = rs.getString(6);
                String types_num = rs.getString(7);
                String is_linient = rs.getString(8);
                String w_commission = rs.getString(9);
                double comm_amount = rs.getDouble(10);
                String cat_ids = rs.getString(11);
                double cost = rs.getDouble(12);
                int printing_assembly = rs.getInt(13);
                int is_active = rs.getInt(14);
                String type_id = rs.getString(15);
                String type_name = rs.getString(16);

                String category_name = "";
                String s3 = "select cat_name from " + MyDB.getNames() + ".category where cat_num='" + cat_id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s3);
                if (rs2.next()) {
                    category_name = rs2.getString(1);
                }
                to_add_product to = new to_add_product(name, desc, price, qty, num, vat, types_num, is_linient, w_commission, comm_amount, cat_ids, cost, printing_assembly, is_active, category_name, type_id, type_name);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_add_product> ret_products_search_like(String type, String names) {
        List<to_add_product> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select product_name,description,price,product_qty,prod_num,is_vat,types_num,is_linient"
                        + ",w_commission,comm_amount,cat_id,cost,printing_assembly"
                        + ",is_active,types_num,types  from " + MyDB.getNames() + ".inventory2_stocks_left"
                        + " where description like '%" + names + "%'  order by description asc limit 100";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String desc = rs.getString(2);
                String price = rs.getString(3);
                String qty = rs.getString(4);
                String num = rs.getString(5);
                String vat = rs.getString(6);
                String types_num = rs.getString(7);
                String is_linient = rs.getString(8);
                String w_commission = rs.getString(9);


                double comm_amount = rs.getDouble(10);
                String cat_id = rs.getString(11);
                double cost = rs.getDouble(12);
                int printing_assembly = rs.getInt(13);
                int is_active = rs.getInt(14);

                String type_id = rs.getString(15);
                String type_name = rs.getString(16);

                String category_name = "";
                String s3 = "select cat_name from " + MyDB.getNames() + ".category where cat_num='" + cat_id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s3);
                if (rs2.next()) {
                    category_name = rs2.getString(1);
                }

                to_add_product to = new to_add_product(name, desc, price, qty, num, vat, types_num, is_linient, w_commission, comm_amount, cat_id, cost, printing_assembly, is_active, category_name, type_id, type_name);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_add_product> ret_products_search_category(String type, String names, String type_id) {
        List<to_add_product> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select product_name,description,price,product_qty,prod_num,is_vat,types_num"
                        + ",is_linient,w_commission,comm_amount,cat_id,cost,printing_assembly"
                        + ",is_active, types_num,types from " + MyDB.getNames() + ".inventory2_stocks_left"
                        + " where description like '%" + names + "%' and cat_id = '" + type + "' and types_num='" + type_id + "' order by description asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String desc = rs.getString(2);
                String price = rs.getString(3);
                String qty = rs.getString(4);
                String num = rs.getString(5);
                String vat = rs.getString(6);
                String types_num = rs.getString(7);
                String is_linient = rs.getString(8);
                String w_commission = rs.getString(9);


                double comm_amount = rs.getDouble(10);
                String cat_id = rs.getString(11);
                double cost = rs.getDouble(12);
                int printing_assembly = rs.getInt(13);
                int is_active = rs.getInt(14);

                String type_ids = rs.getString(15);
                String type_name = rs.getString(16);

                String category_name = "";
                String s3 = "select cat_name from " + MyDB.getNames() + ".category where cat_num='" + cat_id + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s3);
                if (rs2.next()) {
                    category_name = rs2.getString(1);
                }
                to_add_product to = new to_add_product(name, desc, price, qty, num, vat, types_num, is_linient, w_commission, comm_amount, cat_id, cost, printing_assembly, is_active, category_name, type_ids, type_name);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add(String name, String description, String price, String qty, String remarks, String types, String supp_id, String vat, String assembly, List<S7_uom.to_product_uom> tt, String is_linient, String w_com, double com_amount, String cat_id, double cost, String img_path, int is_active, int printing_assembly, int group_id, String type_name, String type_id) {


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d = new Date();
        String date = sf.format(d);

        int num = get_prod_num();

        int type_num = S1_categories.prod_type(types);
        if (types.equals("0")) {
            type_num = 0;
        }
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".inventory2(prod_num,product_name,description,price,product_qty,remarks,types,types_num,supplier_id,created,modified)values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setString(4, price);
            stmt.setString(5, qty);
            stmt.setString(6, remarks);
            stmt.setString(7, types);
            stmt.setInt(8, type_num);
            stmt.setString(9, supp_id);
            stmt.setString(10, date);
            stmt.setString(11, date);
//            stmt.execute();

            String s1 = "insert into " + MyDB.getNames() + ".inventory2_stocks_left("
                        + "prod_num,product_name,description,price,product_qty,types,types_num"
                        + ",is_vat,prod_assembly,is_linient,w_commission,comm_amount,cat_id,cost"
                        + ",img_path,is_active,printing_assembly,group_id)"
                        + "values"
                        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt2 = conn.prepareStatement(s1);
            stmt2.setInt(1, num);
            stmt2.setString(2, name);
            stmt2.setString(3, description);
            stmt2.setString(4, price);
            stmt2.setString(5, qty);
            stmt2.setString(6, type_name);
            stmt2.setString(7, type_id);
            stmt2.setString(8, vat);
            stmt2.setString(9, assembly);
            stmt2.setString(10, is_linient);
            stmt2.setString(11, w_com);
            stmt2.setDouble(12, com_amount);
            stmt2.setString(13, cat_id);
            stmt2.setDouble(14, cost);
            stmt2.setString(15, img_path);
            stmt2.setInt(16, is_active);
            stmt2.setInt(17, printing_assembly);
            stmt2.setInt(18, group_id);
            stmt2.execute();


            if (tt.isEmpty()) {
            } else {
                for (S7_uom.to_product_uom t : tt) {
                    String s2 = "insert into " + MyDB.getNames() + ".product_uom(uom,uom_amount,prod_num)values(?,?,?)";
                    PreparedStatement stmt3 = conn.prepareStatement(s2);
                    stmt3.setString(1, t.uom);
                    stmt3.setDouble(2, t.uom_amount);
                    stmt3.setString(3, name);
                    stmt3.execute();

                }
            }
            Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Added");


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    private static int get_prod_num() {

        int num = 0;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select max(ifnull(prod_num,0)) from " + MyDB.getNames() + ".inventory2_stocks_left";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                num = rs.getInt(1);
            }
            num++;
            return num;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_product_qty(String name) {
        double qty = 0;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select product_qty from " + MyDB.getNames() + ".inventory2_stocks_left where product_name='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                qty = rs.getDouble(1);
            }
            return qty;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int get_product_num(String name) {
        int qty = 0;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select prod_num from " + MyDB.getNames() + ".inventory2_stocks_left where product_name='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                qty = rs.getInt(1);
            }
            return qty;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(get_product_num("ChitzuA"));
    }
}
