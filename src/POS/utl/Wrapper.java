/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

/**
 *
 * @author i1
 */
public class Wrapper {

    public static void main(String[] args) {
        String text = "Emergency First Response + Care for Children + Rescue";

        System.out.println(wrap(text, 27));
    }

    public static String wrap(String text, int length) {
//        String text = "Emergency First Response + Care for Children + Rescue";
        String first = "";
        String second = "";
//        System.out.println(text.length());
        if (text.length() < length) {
            first = text.substring(0, text.length());
            second = "";
        } else {
            first = text.substring(0, length);
            second = text.substring(length, text.length());
        }
        
        String output ="<html>"+ first + "\n" + second+"</html>";
//        System.out.println(output);
        return output;
    }
}
