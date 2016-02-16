/*
 * AdjustersReport.java
 *
 * Created on October 2, 2006, 10:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package POS.rpt;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.ProxoolConnection;

/**
 *
 * @author admin
 */
public class rpt_admin_report {

    private rpt_admin_report() {
    }

    public InputStream getJasper() {
        try {
            String jasper = "rpt_admin_report.jasper";
            InputStream is = rpt_admin_report.class.getResourceAsStream(jasper);
            return is;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Map setParameter() {
        Map pMap = new HashMap();
        return pMap;
    }

    public static JRViewer printJRViewer() {

        try {

            Connection conn = ProxoolConnection.connectToOverallPOSDB();
            rpt_admin_report report = new rpt_admin_report();

            JasperPrint jrPrint = JasperFillManager.fillReport(
                    report.getJasper(),
                    report.setParameter(),
                    conn);

            JRViewer jrViewer = new JRViewer(jrPrint);
            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
           
        }

        
    }
    
    public static void main(String[] args) {
        Application.launchMainFrame( printJRViewer(), "Nothing");
    }
}
