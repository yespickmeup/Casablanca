/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to2;

import java.util.Date;

/**
 *
 * @author Dummy
 */
public class to_version {
    
   public final String account;
   public final Date exp_date;
   public final Date date_added;

    public to_version(String account, Date exp_date, Date date_added) {
        this.account = account;
        this.exp_date = exp_date;
        this.date_added = date_added;
    }

    @Override
    public String toString() {
        return "to_version{" + "account=" + account + ", exp_date=" + exp_date + ", date_added=" + date_added + '}';
    }
   
   
    
}
