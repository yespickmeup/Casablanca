/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to2;

/**
 *
 * @author u2
 */
public class to_product_list {
    
   public final String name;
   public final double beg;
   public final double end;

    public to_product_list(String name, double beg, double end) {
        this.name = name;
        this.beg = beg;
        this.end = end;
    }

    @Override
    public String toString() {
        return "to_product_list{" + "name=" + name + ", beg=" + beg + ", end=" + end + '}';
    }
   
    
}
