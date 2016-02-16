/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc3;

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
 * @author Dummy
 */
public class S1_get_category {

    public static class to {

        public String nums = "";
        public String names = "";

        public to(String num, String name) {
            nums = num;
            names = name;
        }
    }

    public static List<to> get_categories() {


        List<to> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select cat_num,cat_name from "+MyDB.getNames()+".category";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
                to t = new to(num, name);
                datas.add(t);
            }
            return datas;
        } catch (Exception e) {
            Prompt.call("No Connection");
//             JOptionPane.showMessageDialog(null, "No Connection");
            return datas;

//            throw new RuntimeException(e);

        } finally {
            MyConnection.close();
        }
    }

    public static List<to> get_product_by_category(String nums) {


        List<to> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select product_name,description from "+MyDB.getNames()+".inventory2_stocks_left where cat_id='" + nums + "'";
            System.out.println(nums + " --adadadadad");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
                to t = new to(num, name);
                datas.add(t);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to> get_categories_type(String nums) {


        List<to> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select type_num,type_name from "+MyDB.getNames()+".category_type where cat_num='" + nums + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
                to t = new to(num, name);
                datas.add(t);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to> get_product(String nums) {


        List<to> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select product_name,description from "+MyDB.getNames()+".inventory2_stocks_left where types_num='" + nums + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String num = rs.getString(1);
                String name = rs.getString(2);
                to t = new to(num, name);
                datas.add(t);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to> get_product2() {


        List<to> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();

            String s0 = "select prod_code from "+MyDB.getNames()+".favorites ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String num = rs.getString(1);
                String s1 = "select description from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + num + "' ";
                Statement stmt1 = conn.createStatement();
                ResultSet rs1 = stmt1.executeQuery(s1);
                String name = "";
                while (rs1.next()) {
                    name = rs1.getString(1);
                }
                to t = new to(num, name);
                datas.add(t);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    static List<S1_get_category.to> categories = new ArrayList();
    static List<String> categories_num = new ArrayList();
    static List<String> categories_name = new ArrayList();

//    public static void main(String[] args) {
//
//        int y = 0;
//        categories = S1_get_category.get_categories();
//        
//        int size=categories.size();
//        System.out.println(size);
//        if(size==0){
//            return;
//        }
//        
//        for(S1_get_category.to t: categories){
//            System.out.println(t.names);
//            categories_num.add(t.nums);
////            System.out.println(t.nums);
//        }
//       
//
//    }
//  
//    public static void main(String[] args) {
//        try {
//            Connection conn = MyConnection.connect();
//
//            String s0 = "select type_num,type_name from "+MyDB.getNames()+".category_type where cat_num='"+"2"+"'";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                String num = rs.getString(1);
//                String name = rs.getString(2);
//                System.out.println(name);
//                to t = new to(num, name);
////                datas.add(t);
//            }
////            return datas;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }
//    
    public static int get_supplier_id(String name) {


        int id = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select id from "+MyDB.getNames()+".product_supplier where supplier_name='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void insert_supplier(String name) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into "+MyDB.getNames()+".product_supplier(supplier_name)values(?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.execute();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> get_suppliers() {

        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            Statement stmt = conn.createStatement();

            String s0 = "select supplier_name from "+MyDB.getNames()+".product_supplier";
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

    public static void main(String[] args) {
        System.out.println(get_supplier_id("a"));
    }
}
