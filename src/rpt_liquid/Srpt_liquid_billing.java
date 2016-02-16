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
import rpt_liquid.Srpt_bar_and_resto.field;

/**
 *
 * @author i1
 */
public class Srpt_liquid_billing {

    public final String busi_name;
    public final double room_rate;
    public final String accomodation;
    public final String SUBREPORT_DIR;
    public final List<Srpt_bar_and_resto.field> rpt_bar_and_resto;
    public final List<Srpt_others.field> rpt_others;
    public final String my_date;
    public final String guest_id;
    public final String table_no;
    public final String check_in;
    public final String transfers;
    public final String accomodation_1;
    public final double accom_total;
    public final String img_path;
    public final double to_pay;
    public final String guest_name;
    public final double dollar;
    public final double total_charges;
    public final double discount;

    public Srpt_liquid_billing(String busi_name, double room_rate, String accomodation, String SUBREPORT_DIR, List<field> rpt_bar_and_resto, List<Srpt_others.field> rpt_others, String my_date, String guest_id, String table_no, String check_in, String transfers, String accomodation_1, double accom_total, String img_path, double to_pay, String guest_name, double dollar, double total_charges, double discount) {
        this.busi_name = busi_name;
        this.room_rate = room_rate;
        this.accomodation = accomodation;
        this.SUBREPORT_DIR = SUBREPORT_DIR;
        this.rpt_bar_and_resto = rpt_bar_and_resto;
        this.rpt_others = rpt_others;
        this.my_date = my_date;
        this.guest_id = guest_id;
        this.table_no = table_no;
        this.check_in = check_in;
        this.transfers = transfers;
        this.accomodation_1 = accomodation_1;
        this.accom_total = accom_total;
        this.img_path = img_path;
        this.to_pay = to_pay;
        this.guest_name = guest_name;
        this.dollar = dollar;
        this.total_charges = total_charges;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public String getSUBREPORT_DIR() {
        return SUBREPORT_DIR;
    }

    public double getAccom_total() {
        return accom_total;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public String getAccomodation_1() {
        return accomodation_1;
    }

    public String getBusi_name() {
        return busi_name;
    }

    public String getCheck_in() {
        return check_in;
    }

    public double getDollar() {
        return dollar;
    }

    public String getGuest_id() {
        return guest_id;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public String getImg_path() {
        return img_path;
    }

    public String getMy_date() {
        return my_date;
    }

    public double getRoom_rate() {
        return room_rate;
    }

    public List<field> getRpt_bar_and_resto() {
        return rpt_bar_and_resto;
    }

    public List<Srpt_others.field> getRpt_others() {
        return rpt_others;
    }

    public String getTable_no() {
        return table_no;
    }

    public double getTo_pay() {
        return to_pay;
    }

    public double getTotal_charges() {
        return total_charges;
    }

    public String getTransfers() {
        return transfers;
    }

    public static void main(String[] args) {

        String busi_name = "Synapse Casa";
        double room_rate = 100;
        String accomodation = "accomodation";
//        String SUBREPORT_DIR = "/POS/rpt_liquid/";
        String SUBREPORT_DIR = System.getProperty("img_path", "C:\\Users\\i1\\") + "img_templates\\rpt\\";
//         String SUBREPORT_DIR = "C:\\Users\\i1\\Dropbox\\ronald_prototypes\\report_no_db\\src\\rpt_liquid\\";
        // array list for restos

        String my_date = "January 1,2013";
        String guest_id = "1";
        String table_no = "1";
        String check_in = "check in";
        String transfers = "none";
        String accomodation_1 = "accom@";
        double accom_total = 1000;
        String img_path = System.getProperty("img_path", "C:\\Users\\i1\\");
        double to_pay = 1002;
        String guest_name = "Ron@";
        double dollar_rate = 14;
        double dollar = to_pay / dollar_rate;
        List<Srpt_bar_and_resto.field> rpt_bar_and_resto = new ArrayList();
        for (int i = 0; i < 3; i++) {
            Srpt_bar_and_resto.field tbar = new Srpt_bar_and_resto.field("desc" + i, new Date(), i + 100, 0);
            rpt_bar_and_resto.add(tbar);
        }

        List<Srpt_others.field> rpt_others = new ArrayList();
        int h = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                h++;
            }
            Srpt_others.field tbar = new Srpt_others.field("category" + h, "desc", i, 100 + i);
            rpt_others.add(tbar);

        }
        Srpt_liquid_billing rpt = new Srpt_liquid_billing(busi_name, room_rate, accomodation, SUBREPORT_DIR, rpt_bar_and_resto, rpt_others, my_date, guest_id, table_no, check_in, transfers, accomodation_1, accom_total, img_path, to_pay, guest_name, dollar, 0, 0);
        JRViewer viewer = Srpt_liquid_billing.get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_billing_liquid.jrxml";
            InputStream is = Srpt_liquid_billing.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pdf_viewer(Srpt_liquid_billing to) {

        JasperUtil.pdfViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }

    public static JRViewer get_viewer(Srpt_liquid_billing to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.emptyDatasource());

    }
}
