/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author i1
 */
public class Bottom {

    public static Component setBottom(Component com) {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


        // Determine the new location of the window
        int w = com.getSize().width;
        int h = com.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        System.out.println(w);
        System.out.println(h);
        // Move the window
        com.setLocation(x, y+180);

        return com;
    }
    
      public static Component setBottom2(Component com) {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


        // Determine the new location of the window
        int w = com.getSize().width;
        int h = com.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        System.out.println(w);
        System.out.println(h);
        // Move the window
        com.setLocation(x, y+210);

        return com;
    }
}
