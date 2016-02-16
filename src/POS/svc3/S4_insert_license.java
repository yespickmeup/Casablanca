/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc3;

import java.sql.Connection;
import POS.utl.MyConnection;

/**
 *
 * @author u2
 */
public class S4_insert_license {
    
    
    
    public static void insert_license_date(){
        
        try {
            Connection conn = MyConnection.connect();
            String s0="";
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    
}
