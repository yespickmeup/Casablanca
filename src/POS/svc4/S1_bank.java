/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc4;

import POS.Main.MyDB;
import POS.to2.to_bank;
import POS.to2.to_card_type;
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
public class S1_bank {

    public static List<to_bank> ret_banks() {
        List<to_bank> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select bank_name,id from "+MyDB.getNames()+".bank";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String num = rs.getString(2);
                to_bank to = new to_bank(name, num);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_bank(String name) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into "+MyDB.getNames()+".bank(bank_name)values(?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.execute();
             Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_card_type(String name, String bank_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into "+MyDB.getNames()+".bank_card_type(name,bank_id)values(?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setString(2, bank_id);
            stmt.execute();
               Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_bank(String name, String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".bank set bank_name='" + name + "' where id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
               Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_type(String name, String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".bank_card_type set name='" + name + "' where id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
               Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_bank(String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  "+MyDB.getNames()+".bank  where id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
               Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_type(String num) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from  "+MyDB.getNames()+".bank_card_type  where id='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
               Prompt.call("Successfully Added");
//            JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_card_type> card_type(String nums) {
        List<to_card_type> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select name,id,bank_id from "+MyDB.getNames()+".bank_card_type where bank_id='" + nums + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String id = rs.getString(2);
                String num = rs.getString(2);
                to_card_type to = new to_card_type(name, id, num);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> get_banks() {
        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select bank_name from "+MyDB.getNames()+".bank";
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
     public static List<String> get_types(String id) {
        List<String> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select name from "+MyDB.getNames()+".bank_card_type where bank_id='"+id+"'";
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
    
    public static String get_bank_id(String name){
        String id="";
        try {
            Connection conn = MyConnection.connect();
            String s0="select id from "+MyDB.getNames()+".bank where  bank_name='"+name+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                id= rs.getString(1);
            }
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
}
