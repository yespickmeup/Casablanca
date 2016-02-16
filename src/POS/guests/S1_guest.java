/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guests;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S1_guest {

    public static class to_guests {

        public final int id;
        public final String guest_id;
        public final String fname;
        public final String lname;
        public final String mi;
        public final String country;
        public final String email_address;
        public final int status;
        public final String diver_cert_lvl;
        public final String contact_no;
        public final String emergency_contact_name;
        public final String passport_no;
        public final String remarks;
        public final String how;
        public final int newsletter;

        public to_guests(int id, String guest_id, String fname, String lname, String mi, String country, String email_address, int status, String diver_cert_lvl, String contact_no, String emergency_contact_name, String passport_no, String remarks, String how, int newsletter) {
            this.id = id;
            this.guest_id = guest_id;
            this.fname = fname;
            this.lname = lname;
            this.mi = mi;
            this.country = country;
            this.email_address = email_address;
            this.status = status;
            this.diver_cert_lvl = diver_cert_lvl;
            this.contact_no = contact_no;
            this.emergency_contact_name = emergency_contact_name;
            this.passport_no = passport_no;
            this.remarks = remarks;
            this.how = how;
            this.newsletter = newsletter;
//           
        }
    }

    public static List<to_guests> ret_data(String search) {
        List<to_guests> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",guest_id"
                        + ",fname"
                        + ",lname"
                        + ",mi"
                        + ",country"
                        + ",email_address"
                        + ",status"
                        + ",diver_cert_lvl"
                        + ",contact_no"
                        + ",emergency_contact_name"
                        + ",passport_no"
                        + ",remarks"
                        + ",how"
                        + ",newsletter"
                        + " from " + MyDB.getNames() + ".guests where "
                        + " concat(fname,space(1),mi,space(1),lname) like '%" + search + "%'"
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String guest_id = rs.getString(2);
                String fname = rs.getString(3);
                String lname = rs.getString(4);
                String mi = rs.getString(5);
                String country = rs.getString(6);
                String email_address = rs.getString(7);
                int status = rs.getInt(8);
                String diver_cert_lvl = rs.getString(9);
                String contact_no = rs.getString(10);
                String emergency_contact_name = rs.getString(11);
                String passport_no = rs.getString(12);
                String remarks = rs.getString(13);
                String how = rs.getString(14);
                int newsletter = rs.getInt(15);

                to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_id() {
        String guest_id = "00000000";
        try {
            Connection conn = MyConnection.connect();

           String s0 = "select guest_id from " + MyDB.getNames() + ".guests  order by id desc limit 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                guest_id = rs.getString(1);
            }
            guest_id = ReceiptIncrementor.increment(guest_id);
            return guest_id;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_guest(to_guests to_guests) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into " + MyDB.getNames() + ".guests("
                        + "guest_id"
                        + ",fname"
                        + ",lname"
                        + ",mi"
                        + ",country"
                        + ",email_address"
                        + ",status"
                        + ",diver_cert_lvl"
                        + ",contact_no"
                        + ",emergency_contact_name"
                        + ",passport_no"
                        + ",remarks"
                        + ",how"
                        + ",newsletter"
                        + ",balance"
                        + ",credit_limit"
                        + ",address"
                        + ",contact"
                        + ",occupation"
                        + ",income"
                        + ",b_date"
                        + ",civil_status"
                        + ",is_male"
                        + ",groups"
                        + ",member_name"
                        + ")values("
                        + ":guest_id"
                        + ",:fname"
                        + ",:lname"
                        + ",:mi"
                        + ",:country"
                        + ",:email_address"
                        + ",:status"
                        + ",:diver_cert_lvl"
                        + ",:contact_no"
                        + ",:emergency_contact_name"
                        + ",:passport_no"
                        + ",:remarks"
                        + ",:how"
                        + ",:newsletter"
                        + ",:balance"
                        + ",:credit_limit"
                        + ",:address"
                        + ",:contact"
                        + ",:occupation"
                        + ",:income"
                        + ",:b_date"
                        + ",:civil_status"
                        + ",:is_male"
                        + ",:groups"
                        + ",:member_name"
                        + ")";

            s0 = SqlStringUtil.parse(s0).setString("guest_id", to_guests.guest_id).setString("fname", to_guests.fname).setString("lname", to_guests.lname).setString("mi", to_guests.mi).setString("country", to_guests.country).setString("email_address", to_guests.email_address).setNumber("status", to_guests.status).setString("diver_cert_lvl", to_guests.diver_cert_lvl).setString("contact_no", to_guests.contact_no).setString("emergency_contact_name", to_guests.emergency_contact_name).setString("passport_no", to_guests.passport_no).setString("remarks", to_guests.remarks).setString("how", to_guests.how).setNumber("newsletter", to_guests.newsletter).setNumber("balance", 0).setNumber("credit_limit", 0).setString("address", "").setString("contact", "").setString("occupation", "").setString("income", "").setString("b_date", "1500-01-01").setString("civil_status", "0").setNumber("is_male", 0).setString("groups", "0").setString("member_name", to_guests.fname + " " + to_guests.mi + " " + to_guests.lname).ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest.class, "Successfully Added");

        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void edit_guest(to_guests to_guests) {
        try {
            Connection conn = MyConnection.connect();


            String s0 = "update " + MyDB.getNames() + ".guests set "
                        + "fname= '" + to_guests.fname + "'"
                        + ",lname= '" + to_guests.lname + "'"
                        + ",mi= '" + to_guests.mi + "'"
                        + ",country= '" + to_guests.country + "'"
                        + ",email_address= '" + to_guests.email_address + "'"
                        + ",status= '" + to_guests.status + "'"
                        + ",diver_cert_lvl= '" + to_guests.diver_cert_lvl + "'"
                        + ",contact_no= '" + to_guests.contact_no + "'"
                        + ",emergency_contact_name= '" + to_guests.emergency_contact_name + "'"
                        + ",passport_no= '" + to_guests.passport_no + "'"
                        + ",remarks= '" + to_guests.remarks + "'"
                        + ",how= '" + to_guests.how + "'"
                        + ",newsletter= '" + to_guests.newsletter + "'"
                        + "where "
                        + " id ='" + to_guests.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_guest.class, "Successfully Updated");
            ;
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_guest(to_guests to, int ids) {
        try {
            Connection conn = MyConnection.connect();
            String s1 = "delete from " + MyDB.getNames() + ".guests where id=:id";
            s1 = SqlStringUtil.parse(s1).
                    setNumber("id", ids).
                    ok();
            PreparedStatement stmt = conn.prepareStatement(s1);
            stmt.execute();
        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_room_guest(String room_id) {
        List<String> datas = new ArrayList();
        datas.add("All");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + ",guest_name"
                        + " from " + MyDB.getNames() + ".room_guests where "
                        + " rooom_id ='" + room_id + "' "
                        + " and status ='" + "0" + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String guest_name = rs.getString(1);
                datas.add(guest_name);
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
            String s0 = "select user_code from "+MyDB.getNames()+".users where user_level='" + "7" + "' or user_level='" + "0" + "'";
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
    
    
}
