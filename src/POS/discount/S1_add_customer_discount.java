/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.discount;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S1_add_customer_discount {

    public static class to_customer_discounts {

        public final int id;
        public final String customer_name;
        public final String card_no;
        public final String address;

        public to_customer_discounts(int id, String customer_name, String card_no, String address) {
            this.id = id;
            this.customer_name = customer_name;
            this.card_no = card_no;
            this.address = address;
        }
    }

    public static List<to_customer_discounts> ret_data(String search) {
        List<to_customer_discounts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",customer_name"
                        + ",card_no"
                        + ",address"
                        + " from " + MyDB.getNames() + ".customer_discounts where "
                        + " customer_name like'%" + "" + "%' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_name = rs.getString(2);
                String card_no = rs.getString(3);
                String address = rs.getString(4);

                to_customer_discounts to = new to_customer_discounts(id, customer_name, card_no, address);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_data(to_customer_discounts to_customer_discounts) {
        try {
            Connection conn = MyConnection.connect();
            String s2 = "select id from " + MyDB.getNames() + ".customer_discounts where customer_name='" + to_customer_discounts.customer_name + "'";
            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(s2);
            if (rs.next()) {
//                JOptionPane.showMessageDialog(null, "Customer Already Exists");
            } else {
                String s0 = "insert into " + MyDB.getNames() + ".customer_discounts("
                            + "customer_name"
                            + ",card_no"
                            + ",address"
                            + ")values("
                            + ":customer_name"
                            + ",:card_no"
                            + ",:address"
                            + ")";

                s0 = SqlStringUtil.parse(s0).
                        setString("customer_name", to_customer_discounts.customer_name).
                        setString("card_no", to_customer_discounts.card_no).
                        setString("address", to_customer_discounts.address).
                        ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_add_customer_discount.class, "Successfully Added");

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
