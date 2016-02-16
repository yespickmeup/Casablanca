/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.category_types;

import POS.Main.MyDB;
import POS.utl.Prompt;
import POS_to4.to_name;
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
public class S1_categories {

    public static class to_name_cat {

        public final String name;
        public final String num;
        public final String img_path;
        public final int open_item;
        public final int printing_assembly;
        public final int group_id;

        public to_name_cat(String name, String num, String img_path, int open_item, int printing_assembly, int group_id) {
            this.name = name;
            this.num = num;
            this.img_path = img_path;
            this.open_item = open_item;
            this.printing_assembly = printing_assembly;
            this.group_id = group_id;
        }
    }

    public static List<to_name_cat> ret_categories_others(String cat_id) {

        List<to_name_cat> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(cat_name,''),cat_num,img_path,open_item,printing_assembly,group_id from " + MyDB.getNames() + ".category where id like '%" + cat_id + "%' order by cat_name asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String num = rs.getString(2);
                String img_path = rs.getString(3);
                int open_item = rs.getInt(4);
                int printing_assembly = rs.getInt(5);
                int group_id = rs.getInt(6);
                to_name_cat to = new to_name_cat(name, num, img_path, open_item, printing_assembly, group_id);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_name_cat> ret_categories(String cat_id) {

        List<to_name_cat> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(cat_name,''),cat_num,img_path,open_item,printing_assembly,group_id from " + MyDB.getNames() + ".category where id like '%" + cat_id + "%' order by cat_name asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String num = rs.getString(2);
                String img_path = rs.getString(3);
                int open_item = rs.getInt(4);
                int printing_assembly = rs.getInt(5);
                int group_id = rs.getInt(6);
                to_name_cat to = new to_name_cat(name, num, img_path, open_item, printing_assembly, group_id);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_name_cat> ret_categories_bar(String cat_id) {

        List<to_name_cat> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(cat_name,''),cat_num,img_path,open_item,printing_assembly,group_id from " + MyDB.getNames() + ".category where id = '" + "10" + "' order by cat_name asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String num = rs.getString(2);
                String img_path = rs.getString(3);
                int open_item = rs.getInt(4);
                int printing_assembly = rs.getInt(5);
                int group_id = rs.getInt(6);
                to_name_cat to = new to_name_cat(name, num, img_path, open_item, printing_assembly, group_id);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_name> ret_categories2(String names) {

        List<to_name> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(type_name,''),type_num from " + MyDB.getNames() + ".category_type where cat_name='" + names + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String num = rs.getString(2);
                to_name to = new to_name(name, num);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_categories_for_cb() {

        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(cat_name,'') from " + MyDB.getNames() + ".category order by cat_name asc";
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

    public static String ret_type_id(String type_name) {

        String id = "0";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select id from " + MyDB.getNames() + ".category_type where type_name='" + type_name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }

            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_category_types_for_cb(String names) {

        List<String> datas = new ArrayList();
        datas.add("NONE");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select ifnull(type_name,'') from " + MyDB.getNames() + ".category_type where cat_name='" + names + "' order by type_name asc";
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

    public static void add_category(String name, String img_path) {

        int num = S1_categories.cat_num();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".category(cat_name,cat_num,img_path,open_item,printing_assembly,group_id)values(?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setInt(2, num);
            stmt.setString(3, img_path);
            stmt.setInt(4, 0);
            stmt.setInt(5, 0);
            stmt.setInt(6, 0);
            stmt.execute();
            Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_open_item(String id, int open_item) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".category set open_item='" + open_item + "' where cat_num='" + id + "'";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
//            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_group_id(String id, int open_item) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".category set group_id='" + open_item + "' where cat_num='" + id + "'";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update " + MyDB.getNames() + ".inventory2_stocks_left set group_id='" + open_item + "' where cat_id='" + id + "'";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
//            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_type(String type, String cat) {

        int num = S1_categories.type_num();
        int cat_num = S1_categories.cat_num2(cat);
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".category_type(type_name,type_num,cat_name,cat_num)values(?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, type);
            stmt.setInt(2, num);
            stmt.setString(3, cat);
            stmt.setInt(4, cat_num);
            stmt.execute();
            Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    private static int cat_num() {

        int num = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(ifnull(cat_num,0)) from " + MyDB.getNames() + ".category";
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

    private static int cat_num2(String name) {


        int num = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_num from " + MyDB.getNames() + ".category where cat_name='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                num = rs.getInt(1);

            }
//            num++;
            return num;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static int prod_type(String name) {

        int num = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select type_num from " + MyDB.getNames() + ".category_type where type_name='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                num = rs.getInt(1);

            }
//            num++;
            return num;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    private static int type_num() {

        int num = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(ifnull(type_num,0)) from " + MyDB.getNames() + ".category_type";
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

    public static String[] product_category(String name) {
        String[] cat = new String[5];
        cat[0] = "";
        cat[1] = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select types from " + MyDB.getNames() + ".inventory2_stocks_left where product_name='" + name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {

                cat[0] = rs.getString(1);
//                System.out.println(cat[0]);
            }

            String s1 = "select cat_name from " + MyDB.getNames() + ".category_type where type_name='" + cat[0] + "'";
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery(s1);
            while (rs1.next()) {

                cat[1] = rs1.getString(1);
//                System.out.println(cat[0]);
            }

            return cat;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void main(String[] args) {
        String aw[] = new String[5];
        aw = product_category("TIIL");
        System.out.println((aw[1]));
    }
//    public static void get_
}
