/*
 * AdjustersReport.java
 *
 * Created on October 2, 2006, 10:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package POS.rpt2;

import POS.Main;
import POS.printing2.S1_get_sales_for_the_day;
import POS.svc2.S4_select_endorsements;
import POS.to.to_wala;
import POS.to2.to_cashier_session;

import POS.to2.to_rpt_admin_sales;

import java.sql.Connection;
import java.util.Date;


import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import POS.utl.MyConnection;

/**
 *
 * @author admin
 */
public class rpt_report {

    static Connection conn;

    //<editor-fold defaultstate="collapse" desc="rpt1">
    public static JRViewer printJRViewer(final to_cashier_session to) {


        String template = "rpt_cashier_report";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static void do_pending() {

        to_wala to = new to_wala();
//        pdf_viewer_pendings(to, "rpt_pendings");
        Application.launchMainFrame3(pendings(to), "Pendings", true).setAlwaysOnTop(true);


    }

    public static void pdf_viewer_pendings(to_date_from to, String template) {

        Connection conn = null;
        try {

            conn = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void pdf_viewer_guest_billing(to_date_from.to_guest_billing to, String template) {

        Connection conn = null;
        try {

            conn = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static JRViewer printJRViewer1(final to_rpt_admin_sales to) {


        String template = "rpt_admin_sales_report";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static JRViewer printJRViewer2(final to_rpt_admin_sales to) {


        String template = "rpt_admin_sales_all";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static JRViewer printJRViewer_inventory(final to_date_from to) {


        String template = "rpt_inventory";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static JRViewer printJRViewer_inventory_to(final to_date_to to) {


        String template = "rpt_inventory_to";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static JRViewer pdf_receipt_daily(final to_date_from to) {


        String template = "rpt_receipts_category";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

//       rpt_stockcards
    //</editor-fold>
    public static void do_admin_report(Date date_from, Date date_to) {


        int kilos = S4_select_endorsements.do_search_kilos();


//        to_rpt_admin_sales to = new to_rpt_admin_sales(date_from, date_to, kilos);
//
//        Application.launchMainFrame3(printJRViewer1(to), "nothing", true).setAlwaysOnTop(true);
//         to_date_from to = new to_date_from(date_from);
//        Application.launchMainFrame3(receipts(to), "nothing", true).setAlwaysOnTop(true);

    }

    public static void do_admin_report_all(Date date_from, Date date_to) {
//        to_date_to to = new to_date_to(date_from,date_to);
//        Application.launchMainFrame3(receipts_by_period(to), "nothing", true).setAlwaysOnTop(true);
    }

    public static void do_report_inventory(Date date_from) {
//        try {
//            date_from=DateFormat.sf1.parse("2012-02-26");
//        } catch (ParseException ex) {
//            Logger.getLogger(rpt_report.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        to_date_from to = new to_date_from(date_from);
//
////        Application.launchMainFrame3(printJRViewer_inventory(to), "nothing", true).setAlwaysOnTop(true);
//        pdf_viewer_inv(to, "rpt_inventory");
//        to_date_from to = new to_date_from(date_from);
//        Application.launchMainFrame3(inventory_daily(to), "nothing", true).setAlwaysOnTop(true);
    }

    public static void pdf_viewer_inv(to_date_from to, String template) {

        Connection con11 = null;
        try {

            con11 = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    con11);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void do_report_inventory_to(Date date_from, Date date_to) {
//
//        to_date_to to = new to_date_to(date_from, date_to);
//
////        Application.launchMainFrame3(printJRViewer_inventory_to(to), "nothing", true).setAlwaysOnTop(true);
//        pdf_viewer_inv_to(to, "rpt_inventory_to");
//         to_date_to to = new to_date_to(date_from,date_to);
//        Application.launchMainFrame3(inventory_by_period(to), "Inventory", true).setAlwaysOnTop(true);
    }

    public static void pdf_viewer_inv_to(to_date_to to, String template) {

        Connection con11 = null;
        try {

            con11 = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    con11);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void do_cashier_report(String number) {

        Date date_from = new Date();
//        try {
//            date_from = DateFormat.sf1.parse("2012-02-16");
//        } catch (ParseException ex) {
//            Logger.getLogger(rpt_report.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        to_date_from to = new to_date_from(date_from);
//
//        Application.launchMainFrame3(printJRViewer_inventory(to), "nothing", true).setAlwaysOnTop(true);


    }

    public static JRViewer pdf_cashier_report(final to_date_from to) {


        String template = "rpt_inventory";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static void pdf_viewer_receipts(to_date_from to, String template) {

        Connection con11 = null;
        try {

            con11 = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    con11);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void pdf_viewer_endorsement(to_date_from.to_endorsement to, String template) {

        Connection conn = null;
        try {
           
            conn = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                     conn);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void pdf_viewer_receipts2(to_date_to to, String template) {

        Connection con11 = null;
        try {
            con11 = MyConnection.connect();
            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    con11);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void pdf_cashier_session(to_date_to.session to, String template) {

        Connection con11 = null;
        try {

            con11 = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    con11);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void pdf_viewer_sales_summary(S1_get_sales_for_the_day.to_reciept_sales to, String template) {

        Connection con11 = null;
        try {

            con11 = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    con11);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static JRViewer receipts(final to_date_from to) {


        String template = "rpt_receipts_category";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static JRViewer receipts_by_period(final to_date_to to) {


        String template = "rpt_receipts_category_by_period";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static JRViewer inventory_daily(final to_date_from to) {


        String template = "rpt_receipts_category";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static JRViewer inventory_by_period(final to_date_to to) {


        String template = "rpt_inventory2_by_period";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static JRViewer pendings(final to_wala to) {


        String template = "rpt_pendings";
        try {

            conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_report.class, template),
                    JasperUtil.setParameter(to),
                    conn);

            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static JRViewer rpt_barcode() {


        rpt_barcode to = new rpt_barcode("Sample Entity");

        for (int i = 0; i < 10; i++) {
            rpt_barcode.field field = new rpt_barcode.field("i", "z", i);
            to.fields.add(field);
        }

        return to.report();
    }

    public static void main(String[] args) {
//        Date date_added = new Date();
////             
//        to_date_from to = new to_date_from(date_added);
//        Application.launchMainFrame3(receipts(to), "nothing", true).setAlwaysOnTop(true);
////         
        to_date_from.to_endorsement to = new to_date_from.to_endorsement(new Date(), "", "2");
        pdf_viewer_endorsement(to, "rpt_endorsements");
//         to_wala to = new to_wala();
//         Application.launchMainFrame3(receipts(to), "nothing", true).setAlwaysOnTop(true);
//        Application.launchMainFrame3(pdf_viewer_pendings(to,"rpt_pendings"), "nothing", true).setAlwaysOnTop(true);
//       
    }
}
