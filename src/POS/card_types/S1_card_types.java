/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.card_types;

import POS.Main.MyDB;
import POS.utl.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_card_types {

    public static class to_card_types {

        public final int id;
        public final String name;
        public final double rate;

        public to_card_types(int id, String name, double rate) {
            this.id = id;
            this.name = name;
            this.rate = rate;
        }
    }

    public static void add_data(to_card_types to_card_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".card_types("
                        + "id"
                        + ",name"
                        + ",rate"
                        + ")values("
                        + ":id"
                        + ",:name"
                        + ",:rate"
                        + ")";

            s0 = SqlStringUtil.parse(s0).setNumber("id", to_card_types.id).setString("name", to_card_types.name).setNumber("rate", to_card_types.rate).ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_card_types.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_card_types to_card_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".card_types set "
                        + "name= '" + to_card_types.name + "'"
                        + ",rate= '" + to_card_types.rate + "'"
                        + "where "
                        + " id ='" + to_card_types.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_card_types.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_card_types to_card_types) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".card_types where "
                        + " id ='" + to_card_types.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_card_types.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_card_types> ret_data(String search) {
        List<to_card_types> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",name"
                        + ",rate"
                        + " from " + MyDB.getNames() + ".card_types where "
                        + " name like'%" + search + "%' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double rate = rs.getDouble(3);
                to_card_types to = new to_card_types(id, name, rate);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select name from " + MyDB.getNames() + ".card_types";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_rate(String search) {
        double rate = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "rate"
                        + " from " + MyDB.getNames() + ".card_types where "
                        + " name ='" + search + "' "
                        + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                rate = rs.getDouble(1);
            }
            return rate;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
