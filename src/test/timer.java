/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author u2
 */
public class timer {
       
    static String timer = "";
    static int g=0;
    
     Timer t = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println(g);
            g++;
            
           
        }
    });

//    
//    public static void main(String[] args) {
//        aw();
//    }
//    
//    
//    private  void aw(){
//        t.start();
//    }
}
