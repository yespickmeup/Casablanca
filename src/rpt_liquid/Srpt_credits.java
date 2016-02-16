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
public class Srpt_credits {

    public final List<field> fields;

    public Srpt_credits() {
        this.fields = new ArrayList();
    }

    public static class field {

        String trans_no;
        String card_type;
        String card_holder;
        String card_no;
        String approval_code;
        double amount;
        double additional;
        double dollar_rate;

        public field(String trans_no, String card_type, String card_holder, String card_no, String approval_code, double amount, double additional, double dollar_rate) {
            this.trans_no = trans_no;
            this.card_type = card_type;
            this.card_holder = card_holder;
            this.card_no = card_no;
            this.approval_code = approval_code;
            this.amount = amount;
            this.additional = additional;
            this.dollar_rate = dollar_rate;
        }

        public field() {
        }

        public double getAdditional() {
            return additional;
        }

        public void setAdditional(double additional) {
            this.additional = additional;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getApproval_code() {
            return approval_code;
        }

        public void setApproval_code(String approval_code) {
            this.approval_code = approval_code;
        }

        public String getCard_holder() {
            return card_holder;
        }

        public void setCard_holder(String card_holder) {
            this.card_holder = card_holder;
        }

        public String getCard_no() {
            return card_no;
        }

        public void setCard_no(String card_no) {
            this.card_no = card_no;
        }

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public double getDollar_rate() {
            return dollar_rate;
        }

        public void setDollar_rate(double dollar_rate) {
            this.dollar_rate = dollar_rate;
        }

        public String getTrans_no() {
            return trans_no;
        }

        public void setTrans_no(String trans_no) {
            this.trans_no = trans_no;
        }
    }

    public static void main(String[] args) {

        List<Srpt_credits.field> fields = new ArrayList();
        for (int i = 0; i < 20; i++) {
            Srpt_credits.field s = new field("trans", "type", "holder", "no", "code", i, i, i);
            fields.add(s);
        }

        Srpt_credits rpt = new Srpt_credits();
        rpt.fields.addAll(fields);

        JRViewer viewer = get_viewer(rpt);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static JasperReport compileJasper() {
        try {
            String jrxml = "rpt_credits.jrxml";
            InputStream is = Srpt_credits.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_credits to) {

        return JasperUtil.getJasperViewer(
                compileJasper(),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));

    }
}
