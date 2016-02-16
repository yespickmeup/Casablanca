/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i1
 */
public class DateUtils {

    public static void main(String[] args) {
        String d1 = "2012-12-08";
//        String d2 = "2012-12-08";
//
        Date date_from = new Date();
//        Date date_to = new Date();
        try {
            date_from = DateType.sf.parse(d1);
//            date_to = DateType.sf.parse(d2);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
//        int count = count_days(date_from, date_to);
//        System.out.println(count);
//        System.out.println(add_day(new Date(), 2));
        for (int i = 0; i < 3; i++) {
            date_from = DateUtils.add_day(date_from, i);
            System.out.println(date_from);
//            j++;
        }
    }

    public static Date add_day(Date date_added, int days) {
        date_added.setDate(date_added.getDate() + days);
        return date_added;
    }

    public static int count_days(Date date_from, Date date_to) {
        int count = 0;
        int d1_year = Integer.parseInt(DateType.y.format(date_from));
        int d1_month = Integer.parseInt(DateType.m1.format(date_from));
        int d1_day = Integer.parseInt(DateType.d.format(date_from));

        int d2_year = Integer.parseInt(DateType.y.format(date_to));
        int d2_month = Integer.parseInt(DateType.m1.format(date_to));
        int d2_day = Integer.parseInt(DateType.d.format(date_to));


        Calendar c1 = Calendar.getInstance();
        c1.set(d1_year, d1_month, d1_day);
        Calendar c2 = Calendar.getInstance();
        c2.set(d2_year, d2_month, d2_day);

        Date d1 = c1.getTime();
        Date d2 = c2.getTime();

        long diff = d2.getTime() - d1.getTime();
        int noofdays = (int) (diff / (1000 * 24 * 60 * 60));
        count = noofdays;
        return count;
    }
}
