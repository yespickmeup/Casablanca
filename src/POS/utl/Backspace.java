/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author u2
 */
public class Backspace {

    public static void clear_tf(JTextField tf) {
        Document d = tf.getDocument();
        int position = d.getLength() - 1;
        try {
            d.remove(position, 1);
        } catch (BadLocationException ex) {
            Logger.getLogger(Backspace.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void clear_lbl(JLabel lbl) {
        JTextField tf = new JTextField();
        tf.setText(lbl.getText());
        if(tf.getText().isEmpty()){
            return;
        }
        
        Document d = tf.getDocument();
        int position = d.getLength() - 1;
        try {
            d.remove(position, 1);
        } catch (BadLocationException ex) {
            Logger.getLogger(Backspace.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        lbl.setText(tf.getText());
    }
     public static void clear_lbl(JTextField lbl) {
        JTextField tf = new JTextField();
        tf.setText(lbl.getText());
        if(tf.getText().isEmpty()){
            return;
        }
        
        Document d = tf.getDocument();
        int position = d.getLength() - 1;
        try {
            d.remove(position, 1);
        } catch (BadLocationException ex) {
            Logger.getLogger(Backspace.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        lbl.setText(tf.getText());
    }
}
