/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import java.io.InputStream;
import java.util.ArrayList;
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
public class Srpt_others {

    public final List<field> fields;

    public Srpt_others() {
        this.fields = new ArrayList();
    }

    public static class field {

        String category;
        String desc;
        double qty;
        double price;

        public field() {
        }

        public field(String category, String desc, double qty, double price) {
            this.category = category;
            this.desc = desc;
            this.qty = qty;
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
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

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_others.jrxml";
            InputStream is = Srpt_others.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        List<Srpt_others.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_others.field tbar = new Srpt_others.field("category" + i, "desc", i, 100 + i);
            fields.add(tbar);
        }

        Srpt_others rpt = new Srpt_others();
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_others.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_others to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_others.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_others to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
