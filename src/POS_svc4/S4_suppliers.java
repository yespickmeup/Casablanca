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
 * @author Dummy
 */
public class S4_suppliers {

    public static class to_suppliers {

        public String name;
        public String adddress;
        public String contact;
        public String id;

        public to_suppliers(String name, String adddress, String contact, String id) {
            this.name = name;
            this.adddress = adddress;
            this.contact = contact;
            this.id = id;
        }
    }

    public static List<to_suppliers> get_suppliers() {
        List<to_suppliers> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select supplier_name,ifnull(address,''),ifnull(contact,''), id from "+MyDB.getNames()+".product_supplier";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String address = rs.getString(2);
                String contact = rs.getString(3);
                String num = rs.getString(4);
                to_suppliers to = new to_suppliers(name, address, contact, num);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_supplier(String name, String address, String contact) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into "+MyDB.getNames()+".product_supplier(supplier_name,address,contact)values(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, contact);
            stmt.execute();
             Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_supplier(String num) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from "+MyDB.getNames()+".product_supplier where id='" + num + "'";
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

    public static void edit_supplier(String num, String name,String address,String contact) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "update  "+MyDB.getNames()+".product_supplier set supplier_name='" + name + "',address='" + address + "',contact='" + contact + "' where id='" + num + "'";
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
}
