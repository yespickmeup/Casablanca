/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

/**
 *
 * @author u2
 */
public class TextInserter {

    public static String setText(String text, String message) {
        String data = text;
        data = text + message;
        return data;
    }

    public static String setText_pass(String text, String message) {
        int l_text = text.length();
        int l_message = message.length();

        int row = l_text + l_message;


        String data = text;
        String asterisk="";
        data = text + message;

        for (int i = 0; i < row; i++) {
            asterisk=asterisk + "*";
        }
        return asterisk;
    }
}
