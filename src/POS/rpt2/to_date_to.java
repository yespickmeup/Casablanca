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
public class to_date_to {

    public final Date date_from;
    public final Date date_to;
    public final String busi_name;
    public final String mydb;
    public final double dollar;

    public to_date_to(Date date_from, Date date_to, String busi_name, String mydb, double dollar) {
        this.date_from = date_from;
        this.date_to = date_to;
        this.busi_name = busi_name;
        this.mydb = mydb;
        this.dollar = dollar;
    }

    public static class session {

        public final Date date_from;
        public final Date date_to;
        public final String busi_name;
        public final String mydb;
        public final double dollar;
        public final String cashier_session;

        public session(Date date_from, Date date_to, String busi_name, String mydb, double dollar, String cashier_session) {
            this.date_from = date_from;
            this.date_to = date_to;
            this.busi_name = busi_name;
            this.mydb = mydb;
            this.dollar = dollar;
            this.cashier_session = cashier_session;
        }
    }
}
