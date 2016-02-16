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
public class to_order implements Serializable {

    public final String product_name;
    public final double unit_price;
    public double quantity;
    public final String uom;
    public final String code;
    public double hd_uom;
    public final String guest_id;
    public final String cat_id;
    public final String category_name;
    public final int printing_assemblyl;
    public final int group_id;
    public to_order(String product_name, double unit_price, double quantity, String uom, String code, double hd_uom, String guest_id, String cat_id, String category_name, int printing_assemblyl,int group_id) {
        this.product_name = product_name;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.uom = uom;
        this.code = code;
        this.hd_uom = hd_uom;
        this.guest_id = guest_id;
        this.cat_id = cat_id;
        this.category_name = category_name;
        this.printing_assemblyl = printing_assemblyl;
        this.group_id=group_id;
    }

    public void setHd_uom(double hd_uom) {
        this.hd_uom = hd_uom;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return quantity * unit_price;
    }

    @Override
    public String toString() {
        return "to_order{" + "product_name=" + product_name + ", unit_price=" + unit_price + ", quantity=" + quantity + '}';
    }
}
