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
public class to_system_date {

    public static Date current_date;

    public static Date getCurrent_date() {
        return current_date;
    }

    public static void setCurrent_date(Date current_date) {
        to_system_date.current_date = current_date;
    }
}
