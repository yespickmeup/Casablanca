/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Timer;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author u2
 */
public class S6_check_time {

//    public static List<String> check_time(Date d, String timers) {
//
//        SimpleDateFormat ss = new SimpleDateFormat("hh:mm:ss");
//        String times = ss.format(new Date());
//
////        time(timer);
//
//        List<String> datas = new ArrayList();
//        datas.add("New:");
//        try {
//            Connection conn = MyConnection.connect();
////            String s0="select time(p.date_added) from "+MyDB.getNames()+".inventory p where date(p.date_added)=date('"+d+"')";
//            String s0 = "call pb_pos_restaurant.check_time_inventory(:a_date_added)";
//
//            s0 = SqlStringUtil.parse(s0).
//                    setDate("a_date_added", d).
//                    ok();
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(s0);
//            while (rs.next()) {
//                String time = rs.getString(1);
//                datas.add(time);
//            }
//
//            return datas;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            MyConnection.close();
//        }
//    }

    private static String time(String timer) {



////        t.start();
//        
//        
////        Date d = new Date();
////        SimpleDateFormat ss = new SimpleDateFormat("hh:mm:ss");
////        timer = ss.format(new Date());
        return timer;

    }
//    public static void main(String[] args) {
//        
//        t.start();
//        
////        System.out.println(time(timer));
//    }
}
