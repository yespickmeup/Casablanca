/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.rpt2;

import POS.rpt_liquid.Srpt_liquid;
import POS_to4.to_barcode;
import com.jgoodies.binding.list.ArrayListModel;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.swing.JRViewer;
import mijzcx.synapse.desk.utils.JasperUtil;
import POS.utl.MyConnection;
import java.io.InputStream;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Dummy
 */
public class rpt_barcode {

    public final String entityName;
    public final List<field> fields;

    public rpt_barcode(String entityName) {
        this.entityName = entityName;
        this.fields = new ArrayList();
    }

    public static class field {

        private String barcode;
        private String description;
        private double price;

        public field() {
        }

        public field(String barcode, String description, double price) {
            this.barcode = barcode;
            this.description = description;
            this.price = price;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public JRViewer report() {

        return JasperUtil.getJasperViewer(
                JasperUtil.getJasper(this.getClass()),
                JasperUtil.setParameter(this),
                JasperUtil.makeDatasource(this.fields));
    }

    public static void pdf_viewer_receipts2(to_date_to to, String template) {

        Connection conn = null;
        try {

            conn = MyConnection.connect();


            JasperUtil.pdfViewer(
                    JasperUtil.compileJasper(rpt_barcode.class, template),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void main(String[] args) {

        rpt_barcode to = new rpt_barcode("Sample Entity");

        for (int i = 0; i < 10; i++) {
            rpt_barcode.field field = new rpt_barcode.field("aa23423423423423assdf", "z", i);
            to.fields.add(field);
        }
        JasperUtil.pdfViewer(
                JasperUtil.compileJasper(rpt_barcode.class, "rpt_barcode"),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
//        
//        rpt_barcode to = new rpt_barcode("Sample Entity");
//        
//        for( int i = 0; i < 10; i++) {
//            rpt_barcode.field field = new rpt_barcode.field("i", "z", i);
//            to.fields.add(field);
//        }
//        
//        Application.launchMainFrame(to.report(), "Test");
    }

    public static void print_barcode(String ent_name, String barcode, String desc, double p) {
        rpt_barcode to = new rpt_barcode(ent_name);

        for (int i = 0; i < 10; i++) {
            rpt_barcode.field field = new rpt_barcode.field(barcode, desc, p);
            to.fields.add(field);
        }

        JasperUtil.pdfViewer(
                JasperUtil.compileJasper(rpt_barcode.class, "rpt_barcode"),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
//        
    }

    public static JRViewer get_viewer_conn(String ent_name, ArrayListModel tbl_barcode_ALM) {

        try {

            rpt_barcode to = new rpt_barcode(ent_name);
            List<to_barcode> datas = tbl_barcode_ALM;
            for (to_barcode to1 : datas) {
                rpt_barcode.field field = new rpt_barcode.field(to1.code, to1.desc, to1.price);
                to.fields.add(field);
            }

            return JasperUtil.getJasperViewer(
                    JasperUtil.compileJasper(rpt_barcode.class, "rpt_barcode_2"),
                    JasperUtil.setParameter(to),
                    JasperUtil.makeDatasource(to.fields));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static JasperReport compileJasper(String rpt_name) {
        try {
            String jrxml = rpt_name;
            InputStream is = Srpt_liquid.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void print_barcode2(String ent_name, ArrayListModel tbl_barcode_ALM) {
        rpt_barcode to = new rpt_barcode(ent_name);
        List<to_barcode> datas = tbl_barcode_ALM;
        for (to_barcode to1 : datas) {
            rpt_barcode.field field = new rpt_barcode.field(to1.code, to1.desc, to1.price);
            to.fields.add(field);
        }
        for (int i = 0; i < 10; i++) {
        }

        JasperUtil.pdfViewer(
                JasperUtil.compileJasper(rpt_barcode.class, "rpt_barcode_2"),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
//        
    }
}
