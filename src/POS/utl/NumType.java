/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.text.DecimalFormat;

/**
 *
 * @author Dummy
 */
public class NumType {

    static DecimalFormat df = new DecimalFormat("#,###.00");
    static DecimalFormat df1 = new DecimalFormat("#");
    static DecimalFormat noDec_wCom = new DecimalFormat("#,###");
    static DecimalFormat df2 = new DecimalFormat("#.00");

    public static String with_comma(double amount) {
        String am = df.format(amount);
        return am;
    }

    public static String no_decimal(double amount) {
        String am = df1.format(amount);
        return am;
    }
    
      public static String nodec_w_comm(double amount) {
        String am = noDec_wCom.format(amount);
        return am;
    }

    public static String with_decimal(double amount) {
        String am = df2.format(amount);
        return am;
    }

    public static String no_comma(String amount) {
        String am = "" + amount;
        am = am.replace(",", "");
        return am;
    }

    public static void main(String[] args) {
//        System.out.println(no_comma("1,000.00"));
    }
}
