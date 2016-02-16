/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to;

import java.io.Serializable;

/**
 *
 * @author u2
 */
public class to_pending_orders implements Serializable{
  
    
    public final double qty;
    public final String product_name;
    public final double price;
    public final double amount;

    public to_pending_orders(double qty, String product_name, double price, double amount) {
        this.qty = qty;
        this.product_name = product_name;
        this.price = price;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public double getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return "to_pending_orders{" + "qty=" + qty + ", product_name=" + product_name + ", price=" + price + ", amount=" + amount + '}';
    }
    
    
    
    
    
}
