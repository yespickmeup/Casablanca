/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.Main.MyDB;
import POS_svc4.S2_search;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S2_assembly {

    public static class to_assembly {

        public final int id;
        public final int prod_num;
        public final String description;
        public final double price;
        public double product_qty;
        public final String ref_num;
        public final int status;

        public to_assembly(int id, int prod_num, String description, double price, double product_qty, String ref_num, int status) {
            this.id = id;
            this.prod_num = prod_num;
            this.description = description;
            this.price = price;
            this.product_qty = product_qty;
            this.ref_num = ref_num;
            this.status = status;
        }

        public double getProduct_qty() {
            return product_qty;
        }

        public void setProduct_qty(double product_qty) {
            this.product_qty = product_qty;
        }
    }

    public static void add_assembly(List<to_assembly> datas) {
        try {
            Connection conn = MyConnection.connect();

            for (to_assembly to_assembly : datas) {
                String s0 = "insert into "+MyDB.getNames()+".assembly("
                            + "prod_num"
                            + ",description"
                            + ",price"
                            + ",product_qty"
                            + ",ref_num"
                            + ",status"
                            + ")values("
                            + ":prod_num"
                            + ",:description"
                            + ",:price"
                            + ",:product_qty"
                            + ",:ref_num"
                            + ",:status"
                            + ")";

                s0 = SqlStringUtil.parse(s0).setNumber("prod_num", to_assembly.prod_num).setString("description", to_assembly.description).setNumber("price", to_assembly.price).setNumber("product_qty", to_assembly.product_qty).setString("ref_num", to_assembly.ref_num).setNumber("status", to_assembly.status).ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S2_assembly.class, "Successfully Added");
            }



        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_assembly(to_assembly to_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".assembly set "
                        + "description= '" + to_assembly.description + "'"
                        + ",price= '" + to_assembly.price + "'"
                        + ",product_qty= '" + to_assembly.product_qty + "'"
                        + ",ref_num= '" + to_assembly.ref_num + "'"
                        + ",status= '" + to_assembly.status + "'"
                        + "where "
                        + " id ='" + to_assembly.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_assembly.class, "Successfully Updated");


        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_assembly(to_assembly to_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from "+MyDB.getNames()+".assembly where "
                        + " id ='" + to_assembly.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S2_assembly.class, "Successfully Deleted");


        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_assembly_cancel(List<to_assembly> datas) {
        try {
            Connection conn = MyConnection.connect();
            for (to_assembly to_assembly : datas) {
                String s0 = "delete from "+MyDB.getNames()+".assembly where "
                            + " id ='" + to_assembly.id + "' "
                            + " ";

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S2_assembly.class, "Successfully Deleted");
            }
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_assembly> ret_data(String ref_nums) {
        List<to_assembly> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",prod_num"
                        + ",description"
                        + ",price"
                        + ",product_qty"
                        + ",ref_num"
                        + ",status"
                        + " from "+MyDB.getNames()+".assembly where "
                        + " ref_num like'%" + ref_nums + "%' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int prod_num = rs.getInt(2);
                String description = rs.getString(3);
                double price = rs.getDouble(4);
                double product_qty = rs.getDouble(5);
                String ref_num = rs.getString(6);
                int status = rs.getInt(7);

                to_assembly to = new to_assembly(id, prod_num, description, price, product_qty, ref_num, status);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<S2_search.to_items_status> ret_data_dashboard(String ref_nums) {
        List<S2_search.to_items_status> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",prod_num"
                        + ",description"
                        + ",price"
                        + ",product_qty"
                        + ",ref_num"
                        + ",status"
                        + " from "+MyDB.getNames()+".assembly where "
                        + " ref_num = '" + ref_nums + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String prod_num = rs.getString(2);
                String description = rs.getString(3);
                double price = rs.getDouble(4);
                double product_qty = rs.getDouble(5);
                String ref_num = rs.getString(6);
                int status = rs.getInt(7);

                S2_search.to_items_status to = new S2_search.to_items_status(product_qty, prod_num, "UOM", description, price, "img_path", product_qty, true);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<S2_search.to_items_status> ret_data_table(String prod_nums, String table_no) {
        List<S2_search.to_items_status> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",prod_num"
                        + ",description"
                        + ",price"
                        + ",product_qty"
                        + ",ref_num"
                        + ",is_selected"
                        
                        + " from "+MyDB.getNames()+".customer_table_details_assembly where "
                        + " ref_num = '" + prod_nums + "' and status='" + "0" + "' and table_no='" + table_no + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String prod_num = rs.getString(2);
                String description = rs.getString(3);
                double price = rs.getDouble(4);
                double product_qty = rs.getDouble(5);
                String ref_num = rs.getString(6);
//                boolean stat=true;

                boolean status = true;
//                System.out.println(rs.getString(7));
                if (rs.getString(7).equals("0")) {
                    status = false;
                }

                S2_search.to_items_status to = new S2_search.to_items_status(product_qty, prod_num, "UOM", description, price, "img_path", product_qty, status);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inventory2_stocks_left> ret_data_assembly(String search) {
        List<to_inventory2_stocks_left> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",lookup_code"
                        + ",prod_num"
                        + ",product_name"
                        + ",description"
                        + ",price"
                        + ",product_qty"
                        + ",types"
                        + ",types_num"
                        + ",is_vat"
                        + ",prod_assembly"
                        + ",is_linient"
                        + ",w_commission"
                        + ",comm_amount"
                        + ",cat_id"
                        + ",cost"
                        + ",img_path"
                        + " from "+MyDB.getNames()+".inventory2_stocks_left where "
                        + " description like'%" + search + "%' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String lookup_code = rs.getString(2);
                int prod_num = rs.getInt(3);
                String product_name = rs.getString(4);
                String description = rs.getString(5);
                double price = rs.getDouble(6);
                double product_qty = rs.getDouble(7);
                String types = rs.getString(8);
                String types_num = rs.getString(9);
                String is_vat = rs.getString(10);
                int prod_assembly = rs.getInt(11);
                int is_linient = rs.getInt(12);
                int w_commission = rs.getInt(13);
                double comm_amount = rs.getDouble(14);
                int cat_id = rs.getInt(15);
                double cost = rs.getDouble(16);
                String img_path = rs.getString(17);

                to_inventory2_stocks_left to = new to_inventory2_stocks_left(id, lookup_code, prod_num, product_name, description, price, product_qty, types, types_num, is_vat, prod_assembly, is_linient, w_commission, comm_amount, cat_id, cost, img_path);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_inventory2_stocks_left {

        public final int id;
        public final String lookup_code;
        public final int prod_num;
        public final String product_name;
        public final String description;
        public final double price;
        public final double product_qty;
        public final String types;
        public final String types_num;
        public final String is_vat;
        public final int prod_assembly;
        public final int is_linient;
        public final int w_commission;
        public final double comm_amount;
        public final int cat_id;
        public final double cost;
        public final String img_path;

        public to_inventory2_stocks_left(int id, String lookup_code, int prod_num, String product_name, String description, double price, double product_qty, String types, String types_num, String is_vat, int prod_assembly, int is_linient, int w_commission, double comm_amount, int cat_id, double cost, String img_path) {
            this.id = id;
            this.lookup_code = lookup_code;
            this.prod_num = prod_num;
            this.product_name = product_name;
            this.description = description;
            this.price = price;
            this.product_qty = product_qty;
            this.types = types;
            this.types_num = types_num;
            this.is_vat = is_vat;
            this.prod_assembly = prod_assembly;
            this.is_linient = is_linient;
            this.w_commission = w_commission;
            this.comm_amount = comm_amount;
            this.cat_id = cat_id;
            this.cost = cost;
            this.img_path = img_path;
        }
    }

    public static String get_assembly_no(String product_name) {
        String assembly = "100";

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "prod_assembly"
                        + " from "+MyDB.getNames()+".inventory2_stocks_left where "
                        + " prod_num ='" + product_name + "' "
                        + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                assembly = rs.getString(1);
            }

            return assembly;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
//        System.out.println(get_assembly_no("10"));
    }
}
