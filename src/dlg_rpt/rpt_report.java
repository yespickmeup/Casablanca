/*
 * AdjustersReport.java
 *
 * Created on October 2, 2006, 10:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package dlg_rpt;

import POS.rpt.rpt_admin_report;
import POS.svc2.S3_select_session_id;
import POS.svc2.S4_select_endorsements;
import POS.to2.to_cashier_session;

import POS.to2.to_rpt_admin_sales;
import com.lowagie.text.pdf.codec.Base64.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.ProxoolConnection;

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

//       rpt_stockcards
    //</editor-fold>
    public static void main(String[] args) {

//
//        Date date_from=new Date();
//         Date date_to=new Date();
//        
//        
//        int kilos = S4_select_endorsements.do_search_kilos();
//
//
//        to_rpt_admin_sales to = new to_rpt_admin_sales(date_from, date_to, kilos);
//
//        Application.launchMainFrame3(printJRViewer1(to), "nothing", true).
//                setAlwaysOnTop(true);

    }

    public static void do_cashier_report(String number) {

        number = "" + S3_select_session_id.p_ret_cashier_session("cashier2");

        to_cashier_session to = new to_cashier_session(number);

        Application.launchMainFrame3(printJRViewer(to), "nothing", true).
                setAlwaysOnTop(true);


    }

    public static void do_admin_report(Date date_from, Date date_to) {





        int kilos = S4_select_endorsements.do_search_kilos();


        to_rpt_admin_sales to = new to_rpt_admin_sales(date_from, date_to, kilos);

        Application.launchMainFrame3(printJRViewer1(to), "nothing", true).
                setAlwaysOnTop(true);


    }

    public static void do_admin_report_all(Date date_from, Date date_to) {

        int kilos = S4_select_endorsements.do_search_kilos();


        to_rpt_admin_sales to = new to_rpt_admin_sales(date_from, date_to, kilos);

        Application.launchMainFrame3(printJRViewer2(to), "nothing", true).
                setAlwaysOnTop(true);


    }

    
    
    
    
    
    //--------------------------------
    public InputStream getJasper() {

        try {
            String jasper = "rpt_admin_sales_all.jasper";
            InputStream is = (InputStream) rpt_report.class.getResourceAsStream(jasper);
            return is;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Map setParameter() {
        Map pMap = new HashMap();
        return pMap;
    }

    
    
    
    
    
    
    public static JRViewer printJRViewers() {

        try {

            Connection conn1 = ProxoolConnection.connectToOverallPOSDB();
            rpt_report report = new rpt_report();

            JasperPrint jrPrint = JasperFillManager.fillReport(
                    report.getJasper(),
                    report.setParameter(),
                    conn1);

            JRViewer jrViewer = new JRViewer(jrPrint);
            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }

    }
}
