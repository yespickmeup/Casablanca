/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dummy
 */
public class DateTo {

    public static String date_comma(String date) {

        Date d = new Date();
        try {
            d = DateType.sf.parse(date);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(DateTo.class.getName()).log(Level.SEVERE, null, ex);
        }

        date = DateType.sf1.format(d);

        return date;


    }
    
    

    public static String date_dash(String date) {


        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM dd,yyyy");
  

        Date myDate=new Date();
        try {
            myDate = formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateTo.class.getName()).log(Level.SEVERE, null, ex);
        }


        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

        String myDateString = formatter2.format(myDate);
//        System.out.println(myDateString);
        
        return myDateString;


    }

    public static void main(String[] args) {

        System.out.println(date_dash("Tue, 13 Nov 2001"));

    }
}
