/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dummy
 */
public class DateType {

    public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss aa");
    public static SimpleDateFormat time2 = new SimpleDateFormat("hh:mm aa");
    public static SimpleDateFormat sf1 = new SimpleDateFormat("EEE, MMM dd,yyyy");
    public static SimpleDateFormat d = new SimpleDateFormat("dd");
    public static SimpleDateFormat m = new SimpleDateFormat("MMMMMMMMMMM");
    public static SimpleDateFormat m1 = new SimpleDateFormat("MM");
    public static SimpleDateFormat y = new SimpleDateFormat("yyyy");
    public static SimpleDateFormat liquid = new SimpleDateFormat("EEEEEEEEEEE dd MMMMMMMMMMM yyyy");

    public static void main(String[] args) {
        System.out.println(sf1.format(new Date()));
    }
}
