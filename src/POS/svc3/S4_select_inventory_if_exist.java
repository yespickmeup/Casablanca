/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import POS.Main.MyDB;
import POS.utl.DateType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S4_select_inventory_if_exist {

    public static String[] ret_inventory(String prod_name, Date date, String time) {


        String[] details = new String[6];
        details[0] = "wala";
        details[1] = "wala";
        details[2] = "wala";
        details[3] = "wala";
        details[4] = "wala";

        try {
            Connection conn = MyConnection.connect();
//            String s0 = "select physical_count,variance from "+MyDB.getNames()+".inventory where name='"+prod_name+"' and date_added between '" + date + "' and '" + date + "'   ";
            String s1 = "select physical_count,variance,beg,end,total from " + MyDB.getNames() + ".inventory "
                        + "where date(a_date_added) between date(:a_date_added) and date(:a_date_added) "
                        + "and name=:a_name and time(date_added)=:a_time";
            s1 = SqlStringUtil.parse(s1).
                    setString("a_name", prod_name).
                    setDate("a_date_added", date).
                    setString("a_time", time).
                    ok();


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s1);
            while (rs.next()) {
                details[0] = rs.getString(1);
                details[1] = rs.getString(2);
                details[2] = rs.getString(3);
                details[3] = rs.getString(4);
                details[4] = rs.getString(5);


            }
            return details;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void main(String[] args) {


        Date d = new Date();
        try {
            d = DateType.sf.parse("2012-03-16");
        } catch (ParseException ex) {
            Logger.getLogger(S4_select_inventory_if_exist.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        String[] aw = new String[3];
        aw = ret_inventory("Tiil", d, "");


//        System.out.println(aw[0]);
//        System.out.println(aw[1]);
    }
}
