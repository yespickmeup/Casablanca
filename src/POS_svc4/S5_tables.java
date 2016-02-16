/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

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
import test.Dlg_check;
import test.Dlg_check.to_guests;
import test.Dlg_check_liquid;

/**
 *
 * @author i1
 */
public class S5_tables {

    public static class to_tables {

        public String name;
        public String no;

        public to_tables(String name, String no) {
            this.name = name;
            this.no = no;
        }
    }

    public static class to_tables2 {

        public final String name;
        public final String no;
        public final String status;
        public final double amount;
        public final double rate;
        public final String guest_id;
        public final String guest_name;
        public final String date_added;
        public final List<Dlg_check_liquid.to_guests> to_guest;
        public final String rate_type;
        public final double percentage;
        public final String state;
        public final int table_location_id;

        public to_tables2(String name, String no, String status, double amount, double rate, String guest_id, String guest_name, String date_added, List<Dlg_check_liquid.to_guests> to_guest, String rate_type, double percentage, String state, int table_location_id) {
            this.name = name;
            this.no = no;
            this.status = status;
            this.amount = amount;
            this.rate = rate;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
            this.date_added = date_added;
            this.to_guest = to_guest;
            this.rate_type = rate_type;
            this.percentage = percentage;
            this.state = state;
            this.table_location_id = table_location_id;
        }
    }

    public static List<to_tables2> get_tables(String table_location_ids) {
        List<to_tables2> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String version = System.getProperty("version", "ordering");

            String s0 = "";
            if (version.equals("resto")) {
                s0 = "select table_name,id,rate,rate_type,percentage,table_location_id from " + MyDB.getNames() + ".tables where status='" + "0" + "' ";

            } else {
                s0 = "select table_name,id,rate,rate_type,percentage,table_location_id from " + MyDB.getNames() + ".tables where status='" + "0" + "' and table_location_id like '%" + table_location_ids + "%'";

            }


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String id = rs.getString(2);
                double rate = rs.getDouble(3);
                String ids = "0";
                String guest_id = "0";
                String guest_name = "";
                String date_added = DateType.datetime.format(new Date());
                String rate_type = rs.getString(4);
                double percentage = rs.getDouble(5);
                int table_location_id = rs.getInt(6);
                String s1 = "select status,id,guest_id,guest_name,checkin_date,rooom_id from " + MyDB.getNames() + ".room_guests where rooom_id='" + id + "' and status='" + "0" + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s1);
                double amount = 0;
                String status = "1";
                List<Dlg_check_liquid.to_guests> guest = new ArrayList();
                while (rs2.next()) {
                    amount = 0;
                    status = rs2.getString(1);
                    ids = rs2.getString(6);
                    guest_id = rs2.getString(3);
                    guest_name = rs2.getString(4);
                    date_added = rs2.getString(5);
                    boolean status1 = false;
                    if (status.equals("0")) {
                        status1 = false;
                    }
                    Dlg_check_liquid.to_guests t = new Dlg_check_liquid.to_guests(guest_id, guest_name, status1);
                    guest.add(t);
                }
                if (status.equals("0")) {
                    amount = 0;
                    status = "BUSY";
                    id = ids;
                } else {
                    status = "AVAILABLE";
                }

                if (version.equals("ordering")) {
                    rate = 0;
                } else {
                    rate = rs.getDouble(3);
                    double deduct = (percentage / 100) * rate;
                    rate = rate - deduct;
                }
                to_tables2 to = new to_tables2(name, id, status, amount, rate, guest_id, guest_name, date_added, guest, rate_type, percentage, "", table_location_id);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_tables2> get_tables22() {
        List<to_tables2> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
//            System.out.println(MyDB.getNames());
            String s0 = "select table_name,id,rate,rate_type,percentage,table_location_id from " + MyDB.getNames() + ".tables2 where status='" + "0" + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String id = rs.getString(2);
                double rate = rs.getDouble(3);
                String ids = "0";
                String guest_id = "0";
                String guest_name = "";
                String date_added = DateType.datetime.format(new Date());
                String rate_type = rs.getString(4);
                double percentage = rs.getDouble(5);
                int table_location_id = rs.getInt(6);
//                
                String s1 = "select status,id,guest_id,guest_name,checkin_date,rooom_id from " + MyDB.getNames() + ".room_guests2 where rooom_id='" + id + "' and status='" + "0" + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s1);
                double amount = 0;
                String status = "1";
                List<Dlg_check_liquid.to_guests> guest = new ArrayList();
                while (rs2.next()) {
                    amount = 0;
                    status = rs2.getString(1);
                    ids = rs2.getString(6);
                    guest_id = rs2.getString(3);
                    guest_name = rs2.getString(4);
                    date_added = rs2.getString(5);

                    boolean status1 = false;
                    if (status.equals("0")) {
                        status1 = true;
                    }
//                    System.out.println(guest_name);
                    Dlg_check_liquid.to_guests t = new Dlg_check_liquid.to_guests(guest_id, guest_name, status1);
                    guest.add(t);
                }
//                System.out.println(id + " - " + status);
                if (status.equals("0")) {
                    amount = 0;
//                    status = "AVAILABLE";
                    status = "BUSY";
                    id = ids;
                } else {
//                    status = "BUSY";
                    status = "AVAILABLE";

                }

//                System.out.println(id + " - room id - " + guest.size());
//                System.out.println(amount);
                String version = System.getProperty("version", "ordering");
                if (version.equals("ordering")) {
                    rate = 0;
                } else {
                    rate = rs.getDouble(3);
                    double deduct = (percentage / 100) * rate;
                    rate = rate - deduct;
                }


                to_tables2 to = new to_tables2(name, id, status, amount, rate, guest_id, guest_name, date_added, guest, rate_type, percentage, "", table_location_id);
                datas.add(to);
            }
            return datas;


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_tables2> get_tables2() {
        List<to_tables2> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select table_name,id,rate,rate_type,percentage,status,table_location_id from " + MyDB.getNames() + ".tables";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String id = rs.getString(2);
                double rate = rs.getDouble(3);
                String ids = "0";
                String guest_id = "0";
                String guest_name = "";
                String date_added = DateType.datetime.format(new Date());
                String rate_type = rs.getString(4);
                double percentage = rs.getDouble(5);
                String status = rs.getString(6);
                int table_location_id = rs.getInt(7);
                if (status.equals("0")) {
                    status = "ACTIVE";
                } else {
                    status = "INACTIVE";
                }
//             

                to_tables2 to = new to_tables2(name, id, "0", rate, rate, guest_id, guest_name, date_added, new ArrayList(), rate_type, percentage, status, table_location_id);
                datas.add(to);
            }
            return datas;


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_tables2> get_tables3() {
        List<to_tables2> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select table_name,id,rate,rate_type,percentage,status,table_location_id from " + MyDB.getNames() + ".tables2";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String name = rs.getString(1);
                String id = rs.getString(2);
                double rate = rs.getDouble(3);
                String ids = "0";
                String guest_id = "0";
                String guest_name = "";
                String date_added = DateType.datetime.format(new Date());
                String rate_type = rs.getString(4);
                double percentage = rs.getDouble(5);
                String status = rs.getString(6);
                int table_location_id = rs.getInt(7);
                if (status.equals("0")) {
                    status = "ACTIVE";
                } else {
                    status = "INACTIVE";
                }
//             

                to_tables2 to = new to_tables2(name, id, "0", rate, rate, guest_id, guest_name, date_added, new ArrayList(), rate_type, percentage, status, table_location_id);
                datas.add(to);
            }
            return datas;


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add(String name, double rate, String type, double percent, String table_location_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".tables(table_name,rate,rate_type,percentage,status,table_location_id)values(?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setDouble(2, rate);
            stmt.setString(3, type);
            stmt.setDouble(4, percent);
            stmt.setInt(5, 0);
            stmt.setString(6, table_location_id);

            stmt.execute();

            Prompt.call("Added Successfully");
//             JOptionPane.showMessageDialog(null, "Added Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add3(String name, double rate, String type, double percent) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into " + MyDB.getNames() + ".tables2(table_name,rate,rate_type,percentage,status)values(?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, name);
            stmt.setDouble(2, rate);
            stmt.setString(3, type);
            stmt.setDouble(4, percent);
            stmt.setInt(5, 0);

            stmt.execute();

            Prompt.call("Added Successfully");
//             JOptionPane.showMessageDialog(null, "Added Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit(String name, String no, double rate, String type, double percent, String table_location_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".tables set "
                        + "table_name='" + name + "'"
                        + ",rate='" + rate + "' "
                        + ",rate_type='" + type + "'"
                        + ",percentage='" + percent + "' "
                        + ",table_location_id='" + table_location_id + "' "
                        + "where id='" + no + "'";

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

    public static void edit3(String name, String no, double rate, String type, double percent) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".tables2 set "
                        + "table_name='" + name + "'"
                        + ",rate='" + rate + "' "
                        + ",rate_type='" + type + "'"
                        + ",percentage='" + percent + "' where id='" + no + "'";

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

    public static void update_table_status(String table_id, String status) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".tables set "
                        + "status='" + status + "'"
                        + " where id='" + table_id + "'";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_table_location_id(String id, String table_location_id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".tables set "
                        + "table_location_id='" + table_location_id + "'"
                        + " where id='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_table_status3(String table_id, String status) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".tables2 set "
                        + "status='" + status + "'"
                        + " where id='" + table_id + "'";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

//            Prompt.call("Successfully Updated");
//             JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
//            Prompt.call("Successfully Updated");
    }

    public static void delete(String no) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".tables where id='" + no + "'";

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

    public static void delete3(String no) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".tables2 where id='" + no + "'";

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
