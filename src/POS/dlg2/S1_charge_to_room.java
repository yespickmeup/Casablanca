/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg2;

import POS.Main.MyDB;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class S1_charge_to_room {

    public static class to_tables {

        public final int id;
        public final String table_name;
        public final double rate;
        public final String rate_type;
        public final double percentage;
        public final int status;

        public to_tables(int id, String table_name, double rate, String rate_type, double percentage, int status) {
            this.id = id;
            this.table_name = table_name;
            this.rate = rate;
            this.rate_type = rate_type;
            this.percentage = percentage;
            this.status = status;
        }
    }

    public static List<to_tables> ret_data(String search) {
        List<to_tables> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",table_name"
                    + ",rate"
                    + ",rate_type"
                    + ",percentage"
                    + ",status"
                    + " from " + MyDB.getNames() + ".tables where status <>'" + "1" + "'"
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String table_name = rs.getString(2);
                double rate = rs.getDouble(3);
                String rate_type = rs.getString(4);
                double percentage = rs.getDouble(5);
                int status = rs.getInt(6);

                to_tables to = new to_tables(id, table_name, rate, rate_type, percentage, status);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static class to_room_guests {

        public final int id;
        public final int rooom_id;
        public final String guest_id;
        public final String guest_name;
        public final String checkin_date;
        public final String checkout_date;
        public final int status;
        public final double to_pay;
        public final double paid;
        public final double room_rate;

        public to_room_guests(int id, int rooom_id, String guest_id, String guest_name, String checkin_date, String checkout_date, int status, double to_pay, double paid, double room_rate) {
            this.id = id;
            this.rooom_id = rooom_id;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.checkin_date = checkin_date;
            this.checkout_date = checkout_date;
            this.status = status;
            this.to_pay = to_pay;
            this.paid = paid;
            this.room_rate = room_rate;
        }
    }

    public static List<to_room_guests> ret_data_guest(String table_id) {
        List<to_room_guests> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",rooom_id"
                    + ",guest_id"
                    + ",guest_name"
                    + ",checkin_date"
                    + ",checkout_date"
                    + ",status"
                    + ",to_pay"
                    + ",paid"
                    + ",room_rate"
                    + " from " + MyDB.getNames() + ".room_guests where "
                    + " rooom_id ='" + table_id + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                int rooom_id = rs.getInt(2);
                String guest_id = rs.getString(3);
                String guest_name = rs.getString(4);
                String checkin_date = rs.getString(5);
                String checkout_date = rs.getString(6);
                int status = rs.getInt(7);
                double to_pay = rs.getDouble(8);
                double paid = rs.getDouble(9);
                double room_rate = rs.getDouble(10);

                to_room_guests to = new to_room_guests(id, rooom_id, guest_id, guest_name, checkin_date, checkout_date, status, to_pay, paid, room_rate);
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
