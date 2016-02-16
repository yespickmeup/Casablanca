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
import rpt_liquid.Srpt_others;

/**
 *
 * @author i1
 */
public class Srpt_sales_category {

    public final List<field> fields;
    public final String cashier;

    public Srpt_sales_category(String cashier) {
        this.fields = new ArrayList();
        this.cashier = cashier;
    }

    public static class field {

        String cat_name;
        String description;
        double qty;
        double amount;
        double unit_price;
        String date_added;

        public field(String cat_name, String description, double qty, double amount, double unit_price,String date_added) {
            this.cat_name = cat_name;
            this.description = description;
            this.qty = qty;
            this.amount = amount;
            this.unit_price = unit_price;
            this.date_added=date_added;
        }

        public field() {
        }

        
        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getUnit_price() {
            return unit_price;
        }

        public void setUnit_price(double unit_price) {
            this.unit_price = unit_price;
        }

        public String getDate_added() {
            return date_added;
        }

        public void setDate_added(String date_added) {
            this.date_added = date_added;
        }
        
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
            Srpt_sales_category.field to = new Srpt_sales_category.field(category, "desc", qty, qty * price, price,"");
            fields.add(to);
            System.out.println(category + " desc");
        }


        Srpt_sales_category rpt = new Srpt_sales_category("");
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_sales_cat_1.jrxml";
            InputStream is = Srpt_sales_category.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_sales_category to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
