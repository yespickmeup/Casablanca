/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.addtl_cashins;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_addtl_cashins {

    public static class to_cashout {

        public final int id;
        public final String date_added;
        public final String user_name;
        public final String amount;
        public final String purpose;
        public final int session_id;

        public to_cashout(int id, String date_added, String user_name, String amount, String purpose, int session_id) {
            this.id = id;
            this.date_added = date_added;
            this.user_name = user_name;
            this.amount = amount;
            this.purpose = purpose;
            this.session_id = session_id;
        }
    }

    public static void add_data(to_cashout to_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".addt_cashins("
                    + "date_added"
                    + ",user_name"
                    + ",amount"
                    + ",purpose"
                    + ",session_id"
                    + ")values("
                    + ":date_added"
                    + ",:user_name"
                    + ",:amount"
                    + ",:purpose"
                    + ",:session_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("date_added", to_expenses.date_added).
                    setString("user_name", to_expenses.user_name).
                    setString("amount", to_expenses.amount).
                    setString("purpose", to_expenses.purpose).
                    setNumber("session_id", to_expenses.session_id).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_addtl_cashins.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_cashout to_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".addt_cashins set "
                    + "date_added= '" + to_expenses.date_added + "'"
                    + ",user_name= '" + to_expenses.user_name + "'"
                    + ",amount= '" + to_expenses.amount + "'"
                    + ",purpose= '" + to_expenses.purpose + "'"
                    + "where "
                    + " id ='" + to_expenses.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_addtl_cashins.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_cashout to_expenses) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".addt_cashins where "
                    + " id ='" + to_expenses.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_addtl_cashins.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cashout> ret_data(String date, String user_names) {
        List<to_cashout> datas = new ArrayList();
        
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",date_added"
                    + ",user_name"
                    + ",amount"
                    + ",purpose"
                    + ",session_id"
                    + " from " + MyDB.getNames() + ".addt_cashins where "
                    + " Date(date_added) ='" + date + "'  "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String date_added = rs.getString(2);
                String user_name = rs.getString(3);
                String amount = rs.getString(4);
                String purpose = rs.getString(5);
                int session_id = rs.getInt(6);
                to_cashout to = new to_cashout(id, date_added, user_name, amount, purpose, session_id);
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
