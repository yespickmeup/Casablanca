/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.rpt_liquid;

import POS.printing2.S1_get_sales_for_the_day;
import POS.rpt2.to_date_from;
import POS.rpt2.to_date_to;
import POS.utl.MyConnection;
import java.io.InputStream;
import java.sql.Connection;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Dummy
 */
public class Srpt_liquid {

    public static JRViewer get_viewer_conn(to_date_to to, String rpt_name) {
        Connection con11 = null;
        try {

            con11 = MyConnection.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static JRViewer get_viewer_conn(to_date_to.session to, String rpt_name) {
        Connection con11 = null;
        try {

            con11 = MyConnection.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static JRViewer get_viewer(to_date_to to, String rpt_name) {
        Connection con11 = null;
        try {

            con11 = MyConnection.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static JRViewer get_viewer_from(to_date_from to, String rpt_name) {
        Connection con11 = null;
        try {

            con11 = MyConnection.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static JRViewer get_viewer_conn_summary(S1_get_sales_for_the_day.to_reciept_sales to, String rpt_name) {
        Connection con11 = null;
        try {

            con11 = MyConnection.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(rpt_name),
                    JasperUtil.setParameter(to),
                    con11);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            MyConnection.close();
        }

    }

    public static void main(String[] args) {
//        S1_get_sales_for_the_day.to_reciept_sales
//         Main.MyDB.setNames("db_pos_restaurant");
//         to_date_to to = new to_date_to(new Date(), new Date(), "", "", 0);
//        JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_receipts_w_category_liquid_1.jrxml");
//        JFrame f = Application.launchMainFrame3(viewer, "Billing Statement", true);
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
}
