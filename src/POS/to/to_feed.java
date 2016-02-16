/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to;

/**
 *
 * @author i1
 */
public class to_feed {

    public final String image;
    public final String barcode;
    public final String name;
    public final double price;
    public final double qty;

    public to_feed(String image, String barcode, String name, double price, double qty) {
        this.image = image;
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}
