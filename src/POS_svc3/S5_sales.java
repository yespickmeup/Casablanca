/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc3;

import POS.Main.MyDB;
import POS.utl.DateType;
import POS.utl.Prompt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S5_sales {

    public static class to_sales {

        public final String id;
        public final String product_id;
        public final String product_name;
        public final double price;
        public final double qty_sold;
        public final String date_added;
        public final String cashier_id;
        public final double commission;
        public final double remitance;
        public final double remit_cost;

        public to_sales(String id, String product_id, String product_name, double price, double qty_sold, String date_added, String cashier_id, double commission, double remitance, double remit_cost) {
            this.id = id;
            this.product_id = product_id;
            this.product_name = product_name;
            this.price = price;
            this.qty_sold = qty_sold;
            this.date_added = date_added;
            this.cashier_id = cashier_id;
            this.commission = commission;
            this.remitance = remitance;
            this.remit_cost = remit_cost;
        }
    }

    public static List<to_sales> ret_data(String cashier_id, String item, String dates) {
        List<to_sales> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select id,product_id,product_name,price,qty_sold,date_added,cashierid,commission,remitance,remit_cost from "+MyDB.getNames()+".sales where  date(date_added)='" + dates + "'and cashierid='" + cashier_id + "' and product_name like '%" + item + "%'   order by date_added asc ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                String product_id = rs.getString(2);
                String product_name = rs.getString(3);
                double price = rs.getDouble(4);
                double qty_sold = rs.getDouble(5);
                String date = rs.getString(6);
                String cash_od = rs.getString(7);
                double commission = rs.getDouble(8);
                double remitance = rs.getDouble(9);
                double remit_cost = rs.getDouble(10);
                to_sales to = new to_sales(id, product_id, product_name, price, qty_sold, date, cash_od, commission, remitance, remit_cost);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void do_cancel(double qty, String cashier_id, String product_id, double new_qty, String id, double price,String name) {

        double qty_left = S4_endorsements.get_left(product_id, cashier_id);

        String date=DateType.datetime.format(new Date());

        try {
            Connection conn = MyConnection.connect();
            if (qty == new_qty) {
                
                String s0 = "delete from "+MyDB.getNames()+".sales where id='" + id + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                qty_left += new_qty;
                String s1 = "update "+MyDB.getNames()+".endorsements set qty_left='" + qty_left + "' where cashier_id='" + cashier_id + "' and product_id='" + product_id + "'";
                PreparedStatement stmt2 = conn.prepareStatement(s1);
                stmt2.execute();
                
                
                String s2 = "insert into "+MyDB.getNames()+".cancelled_sales(product_id,product_name,price,qty,date_added)values(?,?,?,?,?)";
                PreparedStatement stmt3 = conn.prepareStatement(s2);
                stmt3.setString(1, product_id);
                stmt3.setString(2, name);
                stmt3.setDouble(3, price);
                stmt3.setDouble(4, new_qty);
                stmt3.setString(5, date);
                stmt3.execute();
                
                
            } else {
                double aw = qty - new_qty;
                double commission = 0;
                double rate = S4_endorsements.get_commission_rate(product_id);
                rate = (rate / 100);

                commission = (new_qty * price) * rate;

                String s0 = "update "+MyDB.getNames()+".sales set qty_sold='" + new_qty + "',commission='" + commission + "' where id='" + id + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                qty_left += new_qty;
                String s1 = "update "+MyDB.getNames()+".endorsements set qty_left='" + qty_left + "' where cashier_id='" + cashier_id + "' and product_id='" + product_id + "'";
                PreparedStatement stmt2 = conn.prepareStatement(s1);
                stmt2.execute();

                String s2 = "insert into "+MyDB.getNames()+".cancelled_sales(product_id,product_name,price,qty,date_added)values(?,?,?,?,?)";
                PreparedStatement stmt3 = conn.prepareStatement(s2);
                stmt3.setString(1, product_id);
                stmt3.setString(2, name);
                stmt3.setDouble(3, price);
                stmt3.setDouble(4, qty-new_qty);
                stmt3.setString(5, date);
                stmt3.execute();

            }

            Prompt.call("Successfully Updated");
//            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
