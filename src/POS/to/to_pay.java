/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author u2
 */
public class to_pay implements Serializable {

    public final double tendered;
    public final Date date;
    public final String cashier;
    public final List<to_order> orders;
    public final String or;
    public final double dollar_rate;
    public final double dollar_tendered;

    public to_pay(double tendered, Date date, String cashier, List<to_order> orders, String or, double dollar_rate,double dollar_tendered) {
        this.tendered = tendered;
        this.date = date;
        this.cashier = cashier;
        this.orders = orders;
        this.or = or;
        this.dollar_rate = dollar_rate;
        this.dollar_tendered=dollar_tendered;
    }

    @Override
    public String toString() {
        return "to_pay{" + "tendered=" + tendered + ", date=" + date + ", cashier=" + cashier + ", orders=" + orders + ", or=" + or + ", dollar_rate=" + dollar_rate + ", dollar_tendered=" + dollar_tendered + '}';
    }

  
}
