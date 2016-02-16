/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_to4;

/**
 *
 * @author Dummy
 */
public class to_search_prod {

    public String name;
    public String uom;
    public String desc;
    public String price;
    public double qty;

    public to_search_prod(String name, String uom, String desc, String price, double qty) {
        this.name = name;
        this.uom = uom;
        this.desc = desc;
        this.price = price;
        this.qty = qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
