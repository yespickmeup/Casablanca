/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.advance_payment;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_cash_advance {

    public static String get_guest_id(String guest) {
        String id = "-2";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "guest_id"
                        + " from " + MyDB.getNames() + ".room_guests where guest_name='" + guest + "'"
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            return id;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_room_id(String room) {
        String id = "-2";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + " from " + MyDB.getNames() + ".tables where table_name='" + room + "'"
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            return id;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_guest_advance(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount_paid)"
                        + " from " + MyDB.getNames() + ".guest_advance_payment where room_id='" + room_id + "' and guest_id='" + guest_id + "' and status='" + "0" + "'"
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_guest_advance_all(String room_id, String guest_id) {
        double amount = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount_paid)"
                        + " from " + MyDB.getNames() + ".guest_advance_payment where room_id='" + room_id + "'  and status='" + "0" + "'"
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    
    public static double get_guest_advance_where(String where) {
        double amount = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount_paid)"
                        + " from " + MyDB.getNames() + ".guest_advance_payment "
                        + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
   public static double get_guest_advance_where3(String where) {
        double amount = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "sum(amount_paid)"
                        + " from " + MyDB.getNames() + ".guest_advance_payment2 "
                        + "" + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    public static class to_guest_advance_payment {

        public final int id;
        public final String room_id;
        public final String guest_name;
        public final String guest_id;
        public final String date_added;
        public final double amount_paid;
        public final int status;

        public to_guest_advance_payment(int id, String room_id, String guest_name, String guest_id, String date_added, double amount_paid, int status) {
            this.id = id;
            this.room_id = room_id;
            this.guest_name = guest_name;
            this.guest_id = guest_id;
            this.date_added = date_added;
            this.amount_paid = amount_paid;
            this.status = status;
        }
    }

    public static void add_data(to_guest_advance_payment to_guest_advance_payment) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".guest_advance_payment("
                        + "room_id"
                        + ",guest_name"
                        + ",guest_id"
                        + ",date_added"
                        + ",amount_paid"
                        + ",status"
                        + ")values("
                        + ":room_id"
                        + ",:guest_name"
                        + ",:guest_id"
                        + ",:date_added"
                        + ",:amount_paid"
                        + ",:status"
                        + ")";

            s0 = SqlStringUtil.parse(s0).setString("room_id", to_guest_advance_payment.room_id).setString("guest_name", to_guest_advance_payment.guest_name).setString("guest_id", to_guest_advance_payment.guest_id).setString("date_added", to_guest_advance_payment.date_added).setNumber("amount_paid", to_guest_advance_payment.amount_paid).setNumber("status", to_guest_advance_payment.status).ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_advance.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_data(to_guest_advance_payment to_guest_advance_payment) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".guest_advance_payment set "
                        + "room_id= '" + to_guest_advance_payment.room_id + "'"
                        + ",guest_name= '" + to_guest_advance_payment.guest_name + "'"
                        + ",guest_id= '" + to_guest_advance_payment.guest_id + "'"
                        + ",date_added= '" + to_guest_advance_payment.date_added + "'"
                        + ",amount_paid= '" + to_guest_advance_payment.amount_paid + "'"
                        + ",status= '" + to_guest_advance_payment.status + "'"
                        + "where "
                        + " room_id ='" + to_guest_advance_payment.room_id + "' "
                        + " and guest_id ='" + to_guest_advance_payment.guest_id + "' "
                        + " and status ='" + "0"
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_advance.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_guest_advance_payment to_guest_advance_payment) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".guest_advance_payment where "
                        + " room_id ='" + to_guest_advance_payment.room_id + "' "
                        + " and guest_id ='" + to_guest_advance_payment.guest_id + "' "
                        + " and status ='" + to_guest_advance_payment.status + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_advance.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
