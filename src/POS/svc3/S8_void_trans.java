/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.to2.to_receipts;
import POS.utl.Prompt;
import com.jgoodies.binding.list.ArrayListModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S8_void_trans {

    public static void void_receipt(String num) {
       
        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from "+MyDB.getNames()+".receipts where or_number='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();


            String s1 = "delete from "+MyDB.getNames()+".receipt_items where receipt_id='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

              Prompt.call("Transaction Cancelled");
//            JOptionPane.showMessageDialog(null, "Transaction Cancelled");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
     public static void void_receipt2(String num,ArrayListModel l) {
        List<to_receipts.aw> datas=l;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "delete from "+MyDB.getNames()+".receipts where or_number='" + num + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();


            String s1 = "delete from "+MyDB.getNames()+".receipt_items where receipt_id='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date=sf.format(new Date());
            
             for (to_receipts.aw  t : datas) {
                double qty1=S9_add_product.get_product_qty(t.name);
                double total=t.qty+qty1;
                String s2 = "update  "+MyDB.getNames()+".inventory2_stocks_left set product_qty='"+total+"'where prod_num='" + t.prod_num + "'";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
                
                String s3="insert into "+MyDB.getNames()+".cancelled_order(or_num,or_date,prod_name,qty,price)values(?,?,?,?,?)";
                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.setString(1,num);
                stmt3.setString(2,date);
                stmt3.setString(3,t.name);
                stmt3.setDouble(4,t.qty);
                stmt3.setDouble(5,t.price);              
                stmt3.execute();
            }
             
              Prompt.call("Transaction Cancelled");
//            JOptionPane.showMessageDialog(null, "Transaction Cancelled");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
//drop table if exists "+MyDB.getNames()+".cancelled_order;
//create table "+MyDB.getNames()+".cancelled_order(
//   id int auto_increment primary key
//   ,or_num int
//   ,or_date datetime
//   ,prod_name varchar(100)
//   ,qty int
//   ,price double
//);


    public static void void_receipt_items(String num, String prod_num,String prod_name,String qty,String price) {

     

        try {
            Connection conn = MyConnection.connect();

            String s1 = "delete from "+MyDB.getNames()+".receipt_items where id='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();


            
            SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date=sf.format(new Date());
            
            
                double qty1=S9_add_product.get_product_qty(prod_name);
                double total=Double.parseDouble(qty)+qty1;
                String s2 = "update  "+MyDB.getNames()+".inventory2_stocks_left set product_qty='"+total+"'where prod_num='" + prod_num + "'";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
            
                 String s3="insert into "+MyDB.getNames()+".cancelled_order(or_num,or_date,prod_name,qty,price)values(?,?,?,?,?)";
                PreparedStatement stmt3 = conn.prepareStatement(s3);
                stmt3.setString(1,num);
                stmt3.setString(2,date);
                stmt3.setString(3,prod_name);
                stmt3.setString(4,qty);
                stmt3.setString(5,price);              
                stmt3.execute();
                
                 Prompt.call("Transaction Cancelled");
//            JOptionPane.showMessageDialog(null, "Transaction Cancelled");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
     public static void void_receipt_items2(String num, ArrayListModel l) {

        List<to_receipts.aw > datas = l;

        try {
            Connection conn = MyConnection.connect();

            String s1 = "delete from "+MyDB.getNames()+".receipt_items where id='" + num + "'";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();


            for (to_receipts.aw  t : datas) {
                double qty1=S9_add_product.get_product_qty(t.name);
                double total=t.qty+qty1;
                String s2 = "update  "+MyDB.getNames()+".inventory2_stocks_left set product_qty='"+total+"'where id='" + t.prod_num + "'";
                PreparedStatement stmt2 = conn.prepareStatement(s2);
                stmt2.execute();
            }
             Prompt.call("Transaction Cancelled");
//            JOptionPane.showMessageDialog(null, "Transaction Cancelled");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
//        void_receipt("13");
    }
}
