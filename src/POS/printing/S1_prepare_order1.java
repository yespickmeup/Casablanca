/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.printing;

import POS.Main.MyDB;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S1_prepare_order1 {

    public static class to_prepare_receipt {

        public final String table_no;
        public final String printing_assembly;
        public final String printing_assembly_name;
        public final String table_name;
        public final String waiter;

        public to_prepare_receipt(String table_no, String printing_assembly, String printing_assembly_name, String table_name, String waiter) {
            this.table_no = table_no;
            this.printing_assembly = printing_assembly;
            this.printing_assembly_name = printing_assembly_name;
            this.table_name = table_name;
            this.waiter = waiter;
        }
    }

    public static class to_print_order {

        public final String table_no;
        public final String business_name;
        public final String operated_by;
        public final String address;
        public final String telephone_number;
        public final String traction_no;
        public final String cashier_name;
        public final String waiter_name;
        public final String tin_no;
        public final String min_no;
        public final String serial_no;
        public final String permit_no;
        public final String or_no;
        public final String trans_no;
        public final String pos_no;

        public to_print_order(String table_no, String business_name, String operated_by, String address, String telephone_number, String traction_no, String cashier_name, String waiter_name, String tin_no, String min_no, String serial_no, String permit_no, String or_no, String trans_no, String pos_no) {
            this.table_no = table_no;
            this.business_name = business_name;
            this.operated_by = operated_by;
            this.address = address;
            this.telephone_number = telephone_number;
            this.traction_no = traction_no;
            this.cashier_name = cashier_name;
            this.waiter_name = waiter_name;
            this.tin_no = tin_no;
            this.min_no = min_no;
            this.serial_no = serial_no;
            this.permit_no = permit_no;
            this.or_no = or_no;
            this.trans_no = trans_no;
            this.pos_no = pos_no;
        }
    }

    public static void main(String[] args) {

        S1_prepare_order1.to_prepare_receipt to = new S1_prepare_order1.to_prepare_receipt("" + "8", "3", "asdasdasd", "", "");
        try {
            JasperReport jasperReport;
            JasperPrint jasperPrint;
            Connection conn = MyConnection.connect();
            String l = "/POS/printing/rpt_prepare_receipt_1.jrxml";
            InputStream is = S1_prepare_order1.class.getResourceAsStream(l);
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(to), conn);
            JasperPrintManager.printPage(jasperPrint, 0, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    public static void prepare_food(to_prepare_receipt to) {
        try {
            JasperReport jasperReport;
            JasperPrint jasperPrint;
            Connection conn = MyConnection.connect();
            String l = "";
            if (System.getProperty("version", "resto").
                    equals("ordering")) {
//                JOptionPane.showMessageDialog(null, "adadad");
                l = "/POS/printing/rpt_prepare_casablanca_2_1.jrxml";
            } else {
                l = "/POS/printing/rpt_prepare_liquid_1.jrxml";
                Lg.s(S1_prepare_order1.class, l);
            }
            InputStream is = S1_prepare_order1.class.getResourceAsStream(l);
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(to), conn);
            JasperPrintManager.printPage(jasperPrint, 0, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    public static void bill_table(to_print_order to) {
        try {
            JasperReport jasperReport;
            JasperPrint jasperPrint;
            Connection conn = MyConnection.connect();
            String l = "";
            if (System.getProperty("version", "resto").
                    equals("resto")) {
                l = "/POS/printing/rpt_print_orders_liquid.jrxml";
            } else {
                l = "/POS/printing/rpt_print_orders_casablanca_2_1.jrxml";
            }
            InputStream is = S1_prepare_order1.class.getResourceAsStream(l);
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(to), conn);
            JasperPrintManager.printPage(jasperPrint, 0, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }

    }

    public static String get_table_id(String table_name) {
        String id = "0";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + " from " + MyDB.getNames() + ".tables where "
                        + " table_name ='" + table_name + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_table_name(String table_name) {
        String id = "0";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "table_name"
                        + " from " + MyDB.getNames() + ".tables where "
                        + " id ='" + table_name + "' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                id = rs.getString(1);
            }
            return id;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
