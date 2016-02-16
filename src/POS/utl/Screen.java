/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.awt.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author i1
 */
public class Screen {

    public static void set(JFrame frame) {
        GraphicsEnvironment localEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultDevice = localEnvironment.getDefaultScreenDevice();
        defaultDevice.setFullScreenWindow(frame);
    }

    public static void set_normal(JFrame frame) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        frame.setSize(xSize, ySize);
    }

    public static void set_normal(JDialog frame) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        frame.setSize(xSize, ySize);
    }

    public static void set_normal(JPanel frame) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

        frame.setSize(xSize, ySize);
    }
}
