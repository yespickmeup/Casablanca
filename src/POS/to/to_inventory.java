/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author u2
 */
public final class to_inventory implements Serializable {

    public final Date inventory_date;
    public final String product_name;
    public final double qty_beg;
    public final double qty_end;
    public final double qty_variance;
    public final double qty_beg_new;
    public final double qty_variance_new;

    public to_inventory(Date inventory_date, String product_name, double qty_beg, 
            double qty_end, double qty_variance, 
            double qty_beg_new, double qty_variance_new) {
        this.inventory_date = inventory_date;
        this.product_name = product_name;
        this.qty_beg = qty_beg;
        this.qty_end = qty_end;
        this.qty_variance = qty_variance;
        this.qty_beg_new = qty_beg_new;
        this.qty_variance_new = qty_variance_new;
    }
}
