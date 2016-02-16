/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to;

/**
 *
 * @author u2
 */
public class to_admin_product {
    
    public final String product_name;
    public final double price;
    public final double est_heads;
    public final double no_of_heads;

    public to_admin_product(String product_name, double price, double est_heads, double no_of_heads) {
        this.product_name = product_name;
        this.price = price;
        this.est_heads = est_heads;
        this.no_of_heads = no_of_heads;
    }

    @Override
    public String toString() {
        return "to_admin_product{" + "product_name=" + product_name + ", price=" + price + ", est_heads=" + est_heads + ", no_of_heads=" + no_of_heads + '}';
    }
        
    
}
