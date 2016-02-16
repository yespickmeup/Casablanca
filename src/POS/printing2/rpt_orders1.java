/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.printing2;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.JasperUtil;

/**
 *
 * @author i1
 */
public class rpt_orders1 {

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
    public final List<rpt_orders1.field> fields;
    public final double discount;
    public final double my_discount;

    public rpt_orders1(String table_no, String business_name, String operated_by, String address, String telephone_number, String traction_no, String cashier_name, String waiter_name, String tin_no, String min_no, String serial_no, String permit_no, String or_no, String trans_no, String pos_no, double discount,double my_discount) {
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
        this.fields = new ArrayList();
        this.discount = discount;
        this.my_discount=my_discount;
        
    }

    public static class field implements Serializable {

        private int id;
        private double qty;
        private String description;
        private double price;
        private double discount;

        public field(int id, double qty, String description, double price, double discount) {
            this.id = id;
            this.qty = qty;
            this.description = description;
            this.price = price;
            this.discount = discount;
        }

        public field() {
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }
    }

    public static JasperReport compileJasper_prepare() {
        try {
            String jrxml = "rpt_my_orders_2_1.jrxml";
            InputStream is = rpt_orders1.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(rpt_orders1 to) {
        return JasperUtil.getJasperViewer(
                compileJasper_prepare(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static void main(String[] args) {
        String table_name = ("TABLENAME");
//            JOptionPane.showMessageDialog(null, table_name);
        String business_name = System.getProperty("business_name", "");
        String operated_by = System.getProperty("operated_by", "");
        String address = System.getProperty("address", "");
        String telephone_number = System.getProperty("telephone_number", "");
        String transaction_no = "";
        String cashier_name = "cashier name";
        String waiter_name = "Waiter";
        String tin_no = System.getProperty("tin_no", "");
        String min_no = System.getProperty("min_no", "");
        String serial_no = System.getProperty("serial_no", "");
        String permit_no = System.getProperty("permit_no", "");
        String or_no = "0";
        String trans_no = System.getProperty("trans_no", "");
        String pos_no = System.getProperty("pos_no", "");
        rpt_orders1 rpt = new rpt_orders1(table_name, business_name, operated_by, address, telephone_number, transaction_no, cashier_name, waiter_name, tin_no, min_no, serial_no, permit_no, or_no, trans_no, pos_no, 0,0);
        for (int i = 0; i < 30; i++) {
            rpt_orders1.field f = new rpt_orders1.field(
                    i,
                    i,
                    "desc",
                    i + 200,
                    i + 100);
            rpt.fields.add(f);
        }

        try {
            JasperReport jasperReport;
            JasperPrint jasperPrint;
            String l = "/POS/printing2/rpt_my_orders_2_1.jrxml";
            InputStream is = rpt_orders1.class.getResourceAsStream(l);
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(compileJasper_prepare(), JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
            JasperPrintManager.printPage(jasperPrint, 0, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    public static void print_to_place(rpt_orders1 rpt) {

        try {
            JasperReport jasperReport;
            JasperPrint jasperPrint;

            String l = "/POS/printing2/rpt_my_orders_2_1.jrxml";
            InputStream is = rpt_orders1.class.getResourceAsStream(l);
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
            JasperPrintManager.printPage(jasperPrint, 0, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }

    }
    //--------------------------------print bill-----------------------------
}
