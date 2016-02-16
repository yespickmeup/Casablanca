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
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import rpt_liquid.Srpt_sales_category.field;

/**
 *
 * @author i1
 */
public class Srpt_category {

    public final List<Srpt_sales_category.field> rpt_sales_category;
    public final String SUBREPORT_DIR;
    public final String cashier;
    public final double gross_sales;
    public final String date;
    public Srpt_category(List<field> rpt_sales_category, String SUBREPORT_DIR, String cashier, double gross_sales,String date) {
        this.rpt_sales_category = rpt_sales_category;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.cashier = cashier;
        this.gross_sales = gross_sales;
        this.date=date;
    }

    public List<field> getRpt_sales_category() {
        return rpt_sales_category;
    }

    public String getSUBREPORT_DIR() {
        return SUBREPORT_DIR;
    }

    public String getCashier() {
        return cashier;
    }

    public double getGross_sales() {
        return gross_sales;
    }

    public static void main(String[] args) {



        List<Srpt_sales_category.field> fields = new ArrayList();
//        for (int i = 0; i < 20; i++) {
//            Srpt_sales_category.field s = new field("trans", "type", i, i, i);
////            fields.add(s);
//        }
        double price = 100;
        double qty = 2;
        for (int i = 0; i < 40; i++) {
            String category = "Category " + 1;
            if (i == 10) {
                category = "Category " + 2;
                qty = 3;
            }
            if (i == 20) {
                category = "Category " + 3;
                qty = 1;
            }
            if (i >= 30) {
                category = "Category " + 4;
                qty = 1;
            }
            Srpt_sales_category.field to = new Srpt_sales_category.field(category, "desc", qty, qty * price, price, "");
            fields.add(to);
            System.out.println(category + " desc");
        }

        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";

        Srpt_category to = new Srpt_category(fields, SUBREPORT_DIR, "",0,"");
        JRViewer viewer = Srpt_category.get_viewer(to);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_cat.jrxml";
            InputStream is = Srpt_category.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pdf_viewer(Srpt_category to) {

        JasperUtil.pdfViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JRViewer get_viewer(Srpt_category to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }
}
