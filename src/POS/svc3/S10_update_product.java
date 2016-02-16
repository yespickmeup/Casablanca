/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.inventory.S5_printing_assemlby;
import POS.svc.S3_insert_new_user;
import POS.to.to_users;
import POS.utl.DateType;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S10_update_product {

    public static void do_update_product_name(String name, String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2 set product_name='" + name + "' where product_name='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);

//            stmt.execute();
            String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set product_name='" + name + "' where product_name='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_update_product_desc(String desc, String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2 set description='" + desc + "' where prod_num='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);

//            stmt.execute();
            String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set description='" + desc + "' where product_name='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_update_product_price(String price, String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2 set price='" + price + "' where product_name='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);

//            stmt.execute();
            String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set price='" + price + "' where product_name='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_update_product_cost(double cost, String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".inventory2 set comm_amount='" + cost + "' where product_name='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);

//            stmt.execute();
            String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set cost='" + cost + "' where product_name='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
//            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_update_linient(String stmt, String num) {
        try {
            Connection conn = MyConnection.connect();

            String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set is_linient='" + stmt + "' where product_name='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_update_comm(String stmt, String num, double amount) {
        try {
            Connection conn = MyConnection.connect();

            String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set w_commission='" + stmt + "',comm_amount='" + amount + "' where product_name='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_update_product_vat(String vat, String num) {
        if (vat.equalsIgnoreCase("yes")) {
            vat = "1";
        } else {
            vat = "0";
        }
        try {
            Connection conn = MyConnection.connect();
//            String s0 = "update "+MyDB.getNames()+".inventory2 set price='" + price + "' where prod_num='" + num + "'";
//            PreparedStatement stmt = conn.prepareStatement(s0);

//            stmt.execute();
            String s1 = "update " + MyDB.getNames() + ".inventory2 set is_vat='" + vat + "' where product_name='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_update_qty(String num, double qty, String supplier, String name, String desc, String price, String remarks) {
        String[] t = new String[5];
        t[0] = "";
        t[1] = "";

        String date = DateType.datetime.format(new Date());


        try {
            Connection conn = MyConnection.connect();


            String s0 = "insert into " + MyDB.getNames() + ".stock_out(prod_num,prod_name,qty,amount,date_added,cashier_name,cashier_id,remarks)values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setString(2, desc);
            stmt.setDouble(3, qty);
            stmt.setString(4, price);
            stmt.setString(5, date);
            stmt.setString(6, to_users.get_user());
            stmt.setString(7, S3_insert_new_user.get_id(to_users.get_user()));
            stmt.setString(8, remarks);
            stmt.execute();

            String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set product_qty='" + qty + "' where product_name='" + num + "' ";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void do_update_qty_stock_out(String num, double qty, String supplier, String name, String desc, String price, double cost, double current_qty) {
        String[] t = new String[5];
        t[0] = "";
        t[1] = "";
        t = S10_update_product.do_get_types(num);

        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into " + MyDB.getNames() + ".inventory2(prod_num,product_name,description,price,product_qty,remarks,types,types_num,supplier_id,cost)values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, num);
            stmt.setString(2, name);
            stmt.setString(3, desc);
            stmt.setString(4, price);
            stmt.setDouble(5, current_qty);
            stmt.setString(6, "");
            stmt.setString(7, t[0]);
            stmt.setString(8, t[1]);
            stmt.setString(9, supplier);
            stmt.setDouble(10, cost);
            stmt.execute();

            String s1 = "update " + MyDB.getNames() + ".inventory2_stocks_left set product_qty='" + qty + "' where product_name='" + num + "' ";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

            S10_update_product.do_update_product_cost(cost, num);

            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static String[] do_get_types(String num) {

        String[] t = new String[5];
        t[0] = "";
        t[1] = "";

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select types,types_num from " + MyDB.getNames() + ".inventory2_stocks_left where prod_num='" + num + "' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                t[0] = rs.getString(1);
                t[1] = rs.getString(2);
            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

//    public static void main(String[] args) {
//        String[] t = new String[5];
//        t = do_get_types("1");
//        System.out.println(t[0]);
//    }
    public static void do_delete_product(String num) {
        try {
            Connection conn = MyConnection.connect();
//            String s0 = "delete from "+MyDB.getNames()+".inventory2 where prod_num='" + num + "'";
            String s1 = "delete from " + MyDB.getNames() + ".inventory2_stocks_left where product_name='" + num + "'";
//            PreparedStatement stmt = conn.prepareStatement(s0);
//            stmt.execute();
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();
            Prompt.call("Successfully Deleted");
//            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_category_name(String type_id) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select type_name from " + MyDB.getNames() + ".category_type where type_num='" + type_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_category_idss(String type_name) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select type_num from " + MyDB.getNames() + ".category_type where type_name='" + type_name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_category_id(String type_name) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_name from " + MyDB.getNames() + ".category_type where type_num='" + type_name + "' limit 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_class_name(String cat_num) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_name from " + MyDB.getNames() + ".category where cat_num='" + cat_num + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_classid(String cat_num) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_num from " + MyDB.getNames() + ".category where cat_name='" + cat_num + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

//    public static void main(String[] args) {
//        System.out.println(get_class_id("1"));
//    }
    public static void add_types(String id, String types, String types_num, String cat_id, String assembly) {
        try {
            Connection conn = MyConnection.connect();
            int group_id = S5_printing_assemlby.get_category_group_id(cat_id);
            int printing_assembly = S5_printing_assemlby.get_category_assembly_id(cat_id);
            String s0 = "update " + MyDB.getNames() + ".inventory2_stocks_left set types='" + types + "', types_num='" + types_num + "'"
                    + ",cat_id='" + cat_id + "',prod_assembly='" + assembly + "',group_id='" + group_id + "',printing_assembly='" + printing_assembly + "' where product_name='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
//            Prompt.call("Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }
}
