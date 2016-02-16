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
public class Srpt_cashiers {

    public final List<field> fields;

    public Srpt_cashiers() {
        this.fields = new ArrayList();
    }

    public static class field {

        String cashier_name;
        double sales;

        public field() {
        }

        public field(String cashier_name, double sales) {
            this.cashier_name = cashier_name;
            this.sales = sales;
        }

        
        public String getCashier_name() {
            return cashier_name;
        }

        public void setCashier_name(String cashier_name) {
            this.cashier_name = cashier_name;
        }

        public double getSales() {
            return sales;
        }

        public void setSales(double sales) {
            this.sales = sales;
        }

        
       
    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_cashiers.jrxml";
            InputStream is = Srpt_cashiers.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        List<Srpt_cashiers.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_cashiers.field tbar = new field("aa", i);
            fields.add(tbar);
        }

        Srpt_cashiers rpt = new Srpt_cashiers();
        rpt.fields.addAll(fields);

        JRViewer viewer = Srpt_cashiers.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void pdf_view(Srpt_cashiers to) {

        JasperUtil.pdfViewer(
                JasperUtil.getJasper(Srpt_cashiers.class),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static JRViewer get_viewer(Srpt_cashiers to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
