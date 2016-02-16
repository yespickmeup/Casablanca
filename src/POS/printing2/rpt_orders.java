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
public class rpt_orders {

    public final String table_id;
    public final String place;
    public final String cashier;
    public final List<rpt_orders.field> fields;

    public rpt_orders(String table_id, String place, String cashier) {
        this.table_id = table_id;
        this.place = place;
        this.cashier = cashier;
        this.fields = new ArrayList();
    }

    public static class field implements Serializable {

        private String desc;
        private double qty;
        private double price;

        public field(String desc, double qty, double price) {
            this.desc = desc;
            this.qty = qty;
            this.price = price;
        }

        public field() {
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
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
            String jrxml = "rpt_my_orders.jrxml";
            InputStream is = rpt_orders.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(rpt_orders to) {
        return JasperUtil.getJasperViewer(
                compileJasper_prepare(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static void main(String[] args) {
        String table_id = "0";
        String place = "kitchen";
        String cashier = "cashier";
        rpt_orders rpt = new rpt_orders(table_id, place,
                cashier);

        for (int i = 0; i < 30; i++) {
            rpt_orders.field f = new rpt_orders.field(
                    "LETCHON" + i,
                    i + 200,
                    i + 100);
            rpt.fields.add(f);
        }
//        JRViewer viewer = rpt_orders.get_viewer(rpt);
//        Application.launchMainFrame3(viewer, "Sample", true);

        try {
            JasperReport jasperReport;
            JasperPrint jasperPrint;
            String l = "/POS/printing2/rpt_my_orders.jrxml";
            InputStream is = rpt_orders.class.getResourceAsStream(l);
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
            JasperPrintManager.printPage(jasperPrint, 0, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }
    }

    public static void print_to_place(rpt_orders rpt) {
        try {
            JasperReport jasperReport;
            JasperPrint jasperPrint;
            String l = "/POS/printing2/rpt_my_orders.jrxml";
            InputStream is = rpt_orders.class.getResourceAsStream(l);
            jasperReport = JasperCompileManager.compileReport(is);
            jasperPrint = JasperFillManager.fillReport(jasperReport, JasperUtil.setParameter(rpt), JasperUtil.makeDatasource(rpt.fields));
            JasperPrintManager.printPage(jasperPrint, 0, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Failed To Print, Please Check the Printer");
            throw new RuntimeException(e);
        }

    }
    //--------------------------------print bill-----------------------------
}
