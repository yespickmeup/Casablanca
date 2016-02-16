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
public class S5_waiter {

    
    
    public static class to_tables{
        public  String name;
        public  String no;

        public to_tables(String name, String no) {
            this.name = name;
            this.no = no;
        }
        
        
    }
    
    
    public static List<to_tables> get_tables(){
         List<to_tables> datas=new ArrayList();
         
         
         try {
            Connection conn = MyConnection.connect();
            
            String s0="select table_name,id from "+MyDB.getNames()+".tables";
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(s0);
             while (rs.next()) {
                 String name = rs.getString(1);
                  String id = rs.getString(2);
                  to_tables to=new to_tables(name, id);
                  datas.add(to);
             }
             return datas;
            
             
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
     public static void add(String name) {
         try {
             Connection conn = MyConnection.connect();
             String s0="insert into "+MyDB.getNames()+".tables(table_name)values(?)";
             
             PreparedStatement stmt = conn.prepareStatement(s0);     
             stmt.setString(1,name);
             
             stmt.execute();
            
                Prompt.call("Added Successfully");
//             JOptionPane.showMessageDialog(null, "Added Successfully");
         } catch (Exception e) {
             throw new RuntimeException(e);
         } finally {
             MyConnection.close();
         }
    }
     
     public static void edit(String name,String no) {
         try {
             Connection conn = MyConnection.connect();
             String s0="update "+MyDB.getNames()+".tables set table_name='"+name+"' where id='"+no+"'";
             
             PreparedStatement stmt = conn.prepareStatement(s0);                 
             stmt.execute();
            
               Prompt.call("Successfully Updated");
//             JOptionPane.showMessageDialog(null, "Successfully Updated");
         } catch (Exception e) {
             throw new RuntimeException(e);
         } finally {
             MyConnection.close();
         }
    }
     public static void delete(String no) {
        try {
             Connection conn = MyConnection.connect();
             String s0="delete from "+MyDB.getNames()+".tables where id='"+no+"'";
             
             PreparedStatement stmt = conn.prepareStatement(s0);                 
             stmt.execute();
            
              Prompt.call("Successfully Deleted");
//             JOptionPane.showMessageDialog(null, "Successfully Deleted");
         } catch (Exception e) {
             throw new RuntimeException(e);
         } finally {
             MyConnection.close();
         }
    }

   
}
