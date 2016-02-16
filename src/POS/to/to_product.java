/*
 * To change this template; choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to;

/**
 *
 * @author u2
 */
public class to_product {

    public final double price;
    public final double qty_per_head;
    public final double product_qty;

    public to_product(double price, double qty_per_head, double product_qty) {
        this.price = price;
        this.qty_per_head = qty_per_head;
        this.product_qty = product_qty;
    }
}
