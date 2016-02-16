/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

import POS.Main.MyDB;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S7_uom {

    public static class to_uom {

        public final String id;
        public final String name;
        public final double amount;

        public to_uom(String id, String name, double amount) {
            this.id = id;
            this.name = name;
            this.amount = amount;
        }
    }

    public static List<to_uom> ret_data() {
        List<to_uom> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select id,uom,uom_amount from "+MyDB.getNames()+".uom";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                double amount = rs.getDouble(3);
                to_uom to = new to_uom(id, name, amount);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_uom(String name, double qty) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into "+MyDB.getNames()+".uom(uom,uom_amount)values(?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setDouble(2, qty);
            stmt.execute();

            Prompt.call("Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_uom(String name, double qty, String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".uom set uom='" + name + "',uom_amount='" + qty + "' where id='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Prompt.call("Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_uom(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  "+MyDB.getNames()+".uom  where id='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Prompt.call("Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_product_uom {

        public final String id;
        public String uom;
        public double uom_amount;
        public final String product_id;

        public to_product_uom(String id, String uom, double uom_amount, String product_id) {
            this.id = id;
            this.uom = uom;
            this.uom_amount = uom_amount;
            this.product_id = product_id;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public void setUom_amount(double uom_amount) {
            this.uom_amount = uom_amount;
        }
    }

    public static List<to_product_uom> ret_data(String product_ids) {
        List<to_product_uom> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select id,uom,uom_amount,prod_num from "+MyDB.getNames()+".product_uom where prod_num='" + product_ids + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                String uom = rs.getString(2);
                double uom_amount = rs.getDouble(3);
                String product_id = rs.getString(4);
                to_product_uom to = new to_product_uom(id, uom, uom_amount, product_id);
                datas.add(to);
            }


            return datas;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_product_uom(String uom, double uom_amount, String product_id) {

        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into "+MyDB.getNames()+".product_uom(uom,uom_amount,prod_num)values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, uom);
            stmt.setDouble(2, uom_amount);
            stmt.setString(3, product_id);
            stmt.execute();

            Prompt.call("Successfully Added");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_product_uom(String uom, double uom_amount, String id) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "update "+MyDB.getNames()+".product_uom set uom='" + uom + "' , uom_amount='" + uom_amount + "' where id='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Prompt.call("Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_product_uom(String id) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from  "+MyDB.getNames()+".product_uom  where id='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
//            Prompt.call("Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int get_barcode() {
        int code = 0;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select max(id) from "+MyDB.getNames()+".inventory2_stocks_left ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                code = rs.getInt(1);
            }

            code++;
            return code;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static boolean check_barcode(String codes) {
        boolean code = false;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select product_name from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + codes + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                code = true;
                break;
            }


            return code;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

  

    public static List<String> uoms(String product_code) {
//        JOptionPane.showMessageDialog(null, product_codeC);
        List<String> datas = new ArrayList();
        datas.add("pcs");
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select uom from "+MyDB.getNames()+".product_uom where prod_num='" + product_code + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
//                JOptionPane.showMessageDialog(null, "adadad");
                datas.add(name);
            }   
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_uom_amount(String uom, String product_id) {
        double qty = 0;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select uom_amount from "+MyDB.getNames()+".product_uom where uom='" + uom + "' and prod_num='" + product_id + "' ";
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
      public static void main(String[] args) {
        System.out.println(get_uom_amount("pack","4803925320002"));
    }
}
