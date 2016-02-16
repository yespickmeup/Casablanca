/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author i1
 */
public class Srpt_cashout {

    public final List<Srpt_cashout.field> fields;

    public Srpt_cashout() {
        this.fields = new ArrayList();
    }

    public static class field {

        String date_added;
        double amount;
        String purpose;

        public field(String date_added, double amount, String purpose) {
            this.date_added = date_added;
            this.amount = amount;
            this.purpose = purpose;
        }

        public field() {
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }
    }

    public static void main(String[] args) {

        List<Srpt_cashout.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_cashout.field s = new Srpt_cashout.field("", i, "purpose");
            fields.add(s);
        }

        Srpt_cashout rpt = new Srpt_cashout();
        rpt.fields.addAll(fields);
        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_cashout_liquid.jrxml";
            InputStream is = Srpt_cashout.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_cashout to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
