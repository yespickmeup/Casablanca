/*
 * To change this template; choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author u2
 */
public final class to_new_product implements Serializable {

    public final int key;
    public final String look_up_code;
    public final String name;
    public final String desc;
    public final double price;
    public final String remarks;
    public final Date date_added;
    public final int size;

    public to_new_product(int key, String look_up_code, String name, String desc, 
            double price, String remarks, Date date_added, int size) {
        this.key = key;
        this.look_up_code = look_up_code;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.remarks = remarks;
        this.date_added = date_added;
        this.size = size;
    }
    
    
}
