/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.rpt2;

import java.util.Date;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.DateUtil;
import mijzcx.synapse.desk.utils.JasperUtil;

/**
 *
 * @author Dummy
 */
public class rpt_test {
    
    public final Date date_from;
    public final Date date_to;

    public rpt_test(Date date_from, Date date_to) {
        this.date_from = date_from;
        this.date_to = date_to;
    }
    
    
    public static void main(String[] args) throws Exception {
        
        Date date_from = DateUtil.asDateAsciiFormat("2011-01-01");
        Date date_to = new Date();
        rpt_test to = new rpt_test(date_from, date_to);
        
        JRViewer jv = JasperUtil.getJasperViewer(
                JasperUtil.getJasper(rpt_test.class,"rpt_inventory_to"), 
                JasperUtil.setParameter(to), 
                JasperUtil.emptyDatasource());
        
        
        Application.launchMainFrame(jv, "test");
        
    }
}
