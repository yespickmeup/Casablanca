/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to2;

import java.util.Date;

/**
 *
 * @author u2
 */
public class to_rpt_admin_sales {
    
    
    public final Date date_from;
    public final Date date_to;
    public final int kilos;

    public to_rpt_admin_sales(Date date_from, Date date_to, int kilos) {
        this.date_from = date_from;
        this.date_to = date_to;
        this.kilos = kilos;
    }

    @Override
    public String toString() {
        return "to_rpt_admin_sales{" + "date_from=" + date_from + ", date_to=" + date_to + ", kilos=" + kilos + '}';
    }

   

  
    
}
