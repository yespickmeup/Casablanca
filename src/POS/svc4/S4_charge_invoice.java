/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc4;

import POS.Main.MyDB;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S4_charge_invoice {

    public static int get_ci_no() {
        int num=0;
        try {
            Connection conn = MyConnection.connect();
            String s0="select max(ci_num) from "+MyDB.getNames()+".ci_no";
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
    public static void do_add(String num){
        try {
            Connection conn = MyConnection.connect();
            String s0="insert into "+MyDB.getNames()+".ci_no(ci_num)values(?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1,num);
            stmt.execute();
//            JOptionPane.showMessageDialog(null, num);
        } catch (Exception e) {
              Prompt.call("Failed to Add");
//            JOptionPane.showMessageDialog(null, "Failed to Add");
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static void main(String[] args) {
        System.out.println(get_ci_no());
    }
}
