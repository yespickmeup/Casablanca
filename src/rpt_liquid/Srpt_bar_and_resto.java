/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;

/**
 *
 * @author i1
 */
public class Srpt_bar_and_resto {

    public final List<field> fields;

    public Srpt_bar_and_resto() {
        this.fields = new ArrayList();
    }

    public static class field {

        String desc;
        Date date_added;
        double total;
        double qty;

        public field() {
        }

        public field(String desc, Date date_added, double total, double qty) {
            this.desc = desc;
            this.date_added = date_added;
            this.total = total;
            this.qty = qty;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public Date getDate_added() {
            return date_added;
        }

        public void setDate_added(Date date_added) {
            this.date_added = date_added;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_bar_and_resto.jrxml";
            InputStream is = Srpt_bar_and_resto.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        List<Srpt_bar_and_resto.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field("desc" + i, new Date(), i + 100, 0);
            fields.add(tbar);
        }

        Srpt_bar_and_resto rpt = new Srpt_bar_and_resto();
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_bar_and_resto.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_bar_and_resto to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_bar_and_resto.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_bar_and_resto to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
