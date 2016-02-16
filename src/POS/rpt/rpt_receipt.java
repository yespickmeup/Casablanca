/*
 * AdjustersReport.java
 *
 * Created on October 2, 2006, 10:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package POS.rpt;


import java.awt.Component;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

import mijzcx.synapse.desk.utils.JasperUtil;


/**
 *
 * @author admin
 */
public class rpt_receipt {

    private rpt_receipt() {
    }

    //<editor-fold defaultstate="collapsed" desc=" compileJasper ">
    public JasperReport compileJasper() {
        try {
            String jrxml = "rpt_receipt.jrxml";
            InputStream is = rpt_receipt.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getJasper() {
        try {
            String jasper = "rpt_receipt.jasper";
            InputStream is = rpt_receipt.class.getResourceAsStream(jasper);

            return is;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setParameter ">
    private Map setParameter(to_rpt_receipt to) {

        Map pMap = new HashMap();

        pMap.put("cashier", to.cashier);
        pMap.put("orno", to.orno);
        pMap.put("date", to.date);
        pMap.put("time", to.time);
        pMap.put("payment_mode", to.payment_mode);
        pMap.put("account_name", to.account_name);
        pMap.put("paid", to.paid);
        pMap.put("discount", to.discount);

        pMap.put("total_amount", to.getTotal_amount());
        pMap.put("vatable_sales", to.getVatable_sales());
        pMap.put("vat12p", to.getVat12p());
        pMap.put("due", to.getDue());
        pMap.put("chg", to.getChg());

        return pMap;

    }
    //</editor-fold>

    private JRDataSource makeDatasource(List<to_rpt_receipt.to_particular> fields) {

        JRDataSource dataSource = new JRBeanCollectionDataSource(fields, false);
        return dataSource;

    }

    public static void main(String[] args) {

        String cashier = "cashier1";
        String orno = "1234";
        Date date = new Date();
        Date time = new Date();
        String payment_mode = "payment_mode";
        String account_name = "account_name";
        double paid = 2000.0;
        double discount = 100.0;

        to_rpt_receipt to = new to_rpt_receipt(cashier, orno, date, time,
                payment_mode, account_name, paid, discount);

        for (int i = 0; i < 13; i++) {
            String particular = "particular" + i;
            double price = i + 10;
            double qty = i;
            to_rpt_receipt.to_particular p = new to_rpt_receipt.to_particular();
            p.setQty(qty);
            p.setProduct(particular);
            p.setPrice(price);
            to.particulars.add(p);
        }


//        System.setProperty("receipt_printer", "Star-TSP143-(STR_T-001)");
        System.setProperty("receipt_printer_show_dialog", "false");

        rpt_receipt.print(new JFrame(), to);
//        pdfViewer(to);

//        Application.launchMainFrame(printJRViewer(to), "nothing", true);
    }

//    public static void print(final Component parent, final Orders o) {
//
//        String cashier = o.cashier;
//        String orno = o.getOrNumber();
//        Date date = new Date();
//        Date time = new Date();
//        String payment_mode = "";
//        String account_name = o.number;
//        double paid = o.cashTendered;
//        double discount = 0;
//
//        to_rpt_receipt to = new to_rpt_receipt(cashier, orno, date, time, payment_mode, account_name, paid, discount);
//
//        for (Order order : o.orders) {
//            to_particular p = new to_particular();
//
//            p.setPrice(order.price);
//            p.setProduct(order.description);
//            p.setQty(order.quantity);
//
//            to.particulars.add(p);
//        }
//
//        print(parent, to);
//
//    }

    public static void print(final Component parent, final to_rpt_receipt to) {


        rpt_receipt report = new rpt_receipt();
        String receipt_printer = System.getProperty("receipt_printer");
        String receipt_printer_show_dialog = System.getProperty("receipt_printer_show_dialog");

        System.out.println(receipt_printer + " show dialog " + Boolean.
                parseBoolean(receipt_printer_show_dialog));
        if (receipt_printer == null || receipt_printer.isEmpty()) {
            JasperUtil.printJasperReport(report.getJasper(), report.setParameter(to), report.
                    makeDatasource(to.particulars), Boolean.parseBoolean(receipt_printer_show_dialog));
        } else {
            JasperUtil.printJasperReport(receipt_printer, report.getJasper(), report.
                    setParameter(to), report.makeDatasource(to.particulars), Boolean.
                    parseBoolean(receipt_printer_show_dialog));

        }


    }

    public static void print_view(final Component parent, final to_rpt_receipt to) {


//        rpt_receipt1 report = new rpt_receipt1();
//        String receipt_printer = System.getProperty("receipt_printer");
//        String receipt_printer_show_dialog = System.getProperty("receipt_printer_show_dialog");
//
//        System.out.println(receipt_printer + " show dialog " + Boolean.parseBoolean(receipt_printer_show_dialog));
//        if (receipt_printer == null || receipt_printer.isEmpty()) {
//            JasperUtil.printJasperReport(report.getJasper(), report.setParameter(to), report.makeDatasource(to.particulars), Boolean.parseBoolean(receipt_printer_show_dialog));
//        } else {
//            JasperUtil.printJasperReport(receipt_printer, report.getJasper(), report.setParameter(to), report.makeDatasource(to.particulars), Boolean.parseBoolean(receipt_printer_show_dialog));
//
//        }

//        JRViewer pv = printJRViewer(to);
//        JFrame fm = Application.launchMainFrame3(pv, "Receipt", true);
//
//        ModalFrameUtil.showAsModal(fm, new JFrame());

        pdfViewer(to);
    }

    public static JRViewer printJRViewer(final to_rpt_receipt to) {

        try {

            rpt_receipt report = new rpt_receipt();

            JasperPrint jrPrint = JasperFillManager.fillReport(
                    report.getJasper(), report.setParameter(to), report.
                    makeDatasource(to.particulars));

            JRViewer jrViewer = new JRViewer(jrPrint);
            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static void pdfViewer(final to_rpt_receipt to) {


        try {

            rpt_receipt report = new rpt_receipt();
//            PdfViewer.fillReport(
//                    report.getJasper(), report.setParameter(to), report.makeDatasource(to.particulars));
//            
            JasperUtil.pdfViewer(report.compileJasper(), report.setParameter(to), report.
                    makeDatasource(to.particulars),
                    "/home/mijzcx/FoxitReader", "/home/mijzcx", "receipt");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static class to_rpt_receipt {

        public final String cashier;
        public final String orno;
        public final Date date;
        public final Date time;
        public final String payment_mode;
        public final String account_name;
        public final double paid;
        public final double discount;
        public final List<to_rpt_receipt.to_particular> particulars;

        public to_rpt_receipt(String cashier, String orno, Date date, Date time,
                String payment_mode, String account_name, double paid, double discount) {
            this.cashier = cashier;
            this.orno = orno;
            this.date = date;
            this.time = time;
            this.payment_mode = payment_mode;
            this.account_name = account_name;
            this.paid = paid;
            this.discount = discount;
            this.particulars = new ArrayList();
        }

        public double getTotal_amount() {
            double total_amount = 0;
            for (to_rpt_receipt.to_particular to : particulars) {
                total_amount += to.price * to.qty;
            }

            return total_amount;
        }

        public double getVatable_sales() {
            double vatable_sales = (getTotal_amount() - discount) / 1.12;
            return vatable_sales;
        }

        public double getVat12p() {
            double vat12p = (getTotal_amount() - discount) - getVatable_sales();
            return vat12p;
        }

        public double getDue() {
            double due = (getTotal_amount() - discount);
            return due;
        }

        public double getChg() {
            double chg = paid - getDue();
            return chg;
        }

        public static class to_particular {

            private double qty;
            private String product;
            private double price;

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getProduct() {
                return product;
            }

            public void setProduct(String product) {
                this.product = product;
            }

            public double getQty() {
                return qty;
            }

            public void setQty(double qty) {
                this.qty = qty;
            }
        }
    }
}
