/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dummy
 */
public class SysTime {

    public static void set() {
//        String strDateToSet="2012-01-01 00:00:00";
        try {
            Runtime.getRuntime().exec("cmd /C date " + System.currentTimeMillis());
        } catch (IOException ex) {
            Logger.getLogger(SysTime.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            Runtime .getRuntime().exec("date -s " + strDateToSet);
//        } catch (IOException ex) {
//            Logger.getLogger(SysTime.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public static void main(String[] args) {
        String strDateToSet="2012-01-01 00:00:00";
        try {
            Runtime.getRuntime().exec("cmd /C date " + System.currentTimeMillis());
        } catch (IOException ex) {
            Logger.getLogger(SysTime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
