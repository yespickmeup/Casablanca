/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.text.DecimalFormat;

/**
 *
 * @author i1
 */
public class NumberFormat {
    
    public static DecimalFormat df=new DecimalFormat("####.00");
    
    
    
    public static void main(String[] args) {
        System.out.println(df.format(99.9191));
    }
}
