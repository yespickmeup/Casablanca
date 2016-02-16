/*
 * AdjustersReport.java
 *
 * Created on October 2, 2006, 10:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package POS.rpt2;

import POS.to2.to_cashier_session;

import java.sql.Connection;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import POS.utl.MyConnection;

/**
 *
 * @author admin
 */
public class rpt_cashier_report {
    
    static Connection conn;
    
    //<editor-fold defaultstate="collapse" desc="rpt1">


    public static JRViewer printJRViewer(final to_cashier_session to) {


        String template = "rpt_cashier_report";
        try {

           conn = MyConnection.connect();

            JRViewer jrViewer =
                    JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_cashier_report.class, template),
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
        String number="15";
        to_cashier_session to = new to_cashier_session(number);

        Application.launchMainFrame3(printJRViewer(to), "nothing", true).setAlwaysOnTop(true);

    }
     
    public static void do_cashier_report(String number){

        to_cashier_session to = new to_cashier_session(number);

        Application.launchMainFrame3(printJRViewer(to), "nothing", true).setAlwaysOnTop(true);
        
    } 
    
    
}
