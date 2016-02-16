/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.to2.to_receipts;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S7_select_receipts {

    static DecimalFormat df1 = new DecimalFormat("#,###.00");

    public static List<to_receipts> get_receipts(String name, Date d) {
        List<to_receipts> datas = new ArrayList();

//        JOptionPane.showMessageDialog(null, d);
        SimpleDateFormat sf = new SimpleDateFormat("MMMMMMMMMM dd,yyyy hh:mm:ss a");
        try {
            Connection conn = MyConnection.connect();

            String s1 = "select "
                        + "r.or_number"
                        + ",r.receipt_date"
                        + ",r.tendered "
                        + ",r.discount "
                        + "from"
                        + "" + MyDB.getNames() + ".receipts r "
                        + "join " + MyDB.getNames() + ".cashier_sessions cs"
                        + "on r.cashier_session_id=cs.id  where cs.cashier_name='" + name + "' and date(r.receipt_date)=date('" + d + "')";

//             and date(r.receipt_date)=date('"+d+"') where cs.cashier_name='" + name + "'"
//            String s2 = "select id,receipt_date,tendered,discount from  " + MyDB.getNames() + ".get_receipts(:a_name,:a_date);";
//
//            s2 = SqlStringUtil.parse(s2).setString("a_name", name).setDate("a_date", d).ok();

            double qq = 0;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s1);
            while (rs.next()) {
                String num = rs.getString(1);
                String aw = sf.format(rs.getTimestamp(2));
                String tendered = (rs.getString(3));
                String discount = rs.getString(4);
                qq = Double.parseDouble(tendered);
                tendered = "" + (qq + Double.parseDouble(discount));
                double amount = Double.parseDouble(tendered) - Double.parseDouble(discount);
                to_receipts to = new to_receipts(num, aw, tendered, discount, amount);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts.aw> ret_items(String num) {


        List<to_receipts.aw> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select description,unit_price,qty,id from " + MyDB.getNames() + ".receipt_items where receipt_id='" + num + "'";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                double price = rs.getDouble(2);
                double qty = rs.getDouble(3);
                double amount = price * qty;
                String id = rs.getString(4);
                System.out.println(name);
                int prod_num = S9_add_product.get_product_num(name);
//                name=S9_add_product.(name);
                to_receipts.aw to = new to_receipts.aw(name, price, qty, amount, id, prod_num);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
