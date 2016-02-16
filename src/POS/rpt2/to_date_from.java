/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.rpt2;

import java.util.Date;

/**
 *
 * @author u2
 */
public class to_date_from {

    public final Date date_from;
    public final String busi_name;

    public to_date_from(Date date_from, String busi_name) {
        this.date_from = date_from;
        this.busi_name = busi_name;
    }

    public static class to_endorsement {

        public final Date date_from;
        public final String busi_name;
        public final String cashier_id;

        public to_endorsement(Date date_from, String busi_name, String cashier_id) {
            this.date_from = date_from;
            this.busi_name = busi_name;
            this.cashier_id = cashier_id;
        }
    }

    public static class to_guest_billing {

        public final String my_date;
        public final String guest_id;
        public final String table_no;
        public final String check_in;
        public final String transfers;
        public final String accomodation;
        public final double accom_total;
        public final String img_path;
        public final double to_pay;

        public to_guest_billing(String my_date, String guest_id, String table_no, String check_in, String transfers, String accomodation, double accom_total, String img_path, double to_pay) {
            this.my_date = my_date;
            this.guest_id = guest_id;
            this.table_no = table_no;
            this.check_in = check_in;
            this.transfers = transfers;
            this.accomodation = accomodation;
            this.accom_total = accom_total;
            this.img_path = img_path;
            this.to_pay = to_pay;
        }

       

        
    }
}
