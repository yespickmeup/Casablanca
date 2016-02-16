/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.rpt2;

import java.sql.Connection;
import java.util.Date;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.DateUtil;
import mijzcx.synapse.desk.utils.JasperUtil;
import POS.utl.MyConnection;

/**
 *
 * @author Dummy
 */
public class rpt_inventory_to {

    public final Date date_from;
    public final Date date_to;

    public rpt_inventory_to(Date date_from, Date date_to) {
        this.date_from = date_from;
        this.date_to = date_to;
    }

    public static void main(String[] args) {
        Date date_from = DateUtil.asDateAsciiFormat("2012-01-01");
        Date date_to = new Date();
        rpt_inventory_to to = new rpt_inventory_to(date_from, date_to);
        pdf_viewer(to);
        
        
//       Application.launchMainFrame3(pdf_viewer(to), "nothing", true).setAlwaysOnTop(true);
        
    }

//    public static JRViewer pdf_viewer(rpt_inventory_to to) {
//        Connection conn = null;
//        
//        try {} catch( Exception e) {
//        
//        } finally {}
//    }
    
    public static void pdf_viewer(rpt_inventory_to to) {

        Connection conn = null;
        try {

            conn = MyConnection.connect();


            JasperUtil.pdfViewer(
                   JasperUtil.compileJasper(rpt_inventory_to.class,"rpt_inventory_to"),
                    JasperUtil.setParameter(to),
                    conn);
      
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }
    
    public static JRViewer pdf_viewer2(rpt_inventory_to to) {

        Connection conn = null;
        try {

            conn = MyConnection.connect();


            JRViewer jrViewer = JasperUtil.getJasperViewer(
                   JasperUtil.compileJasper(rpt_inventory_to.class,"rpt_inventory_to"),
                    JasperUtil.setParameter(to),
                    conn);

            
            return jrViewer;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }
}
