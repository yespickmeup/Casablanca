/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to2;

/**
 *
 * @author Dummy
 */
public class to_add_product {

    public String name;
    public String desc;
    public String price;
    public String qty;
    public String num;
    public String vat;
    public String category_id;
    public String is_linient;
    public String w_commission;
    public double comm_amount;
    public String cat_id;
    public double cost;
    public int printing_assembly;
    public int is_active;
    public final String category_name;
    public final String type_id;
    public final String type_name;

    public to_add_product(String name, String desc, String price, String qty, String num, String vat, String category_id, String is_linient, String w_commission, double comm_amount, String cat_id, double cost, int printing_assembly, int is_active, String category_name, String type_id, String type_name) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.qty = qty;
        this.num = num;
        this.vat = vat;
        this.category_id = category_id;
        this.is_linient = is_linient;
        this.w_commission = w_commission;
        this.comm_amount = comm_amount;
        this.cat_id = cat_id;
        this.cost = cost;
        this.printing_assembly = printing_assembly;
        this.is_active = is_active;
        this.category_name = category_name;
        this.type_id = type_id;
        this.type_name = type_name;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public double getComm_amount() {
        return comm_amount;
    }

    public void setComm_amount(double comm_amount) {
        this.comm_amount = comm_amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIs_linient() {
        return is_linient;
    }

    public void setIs_linient(String is_linient) {
        this.is_linient = is_linient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getW_commission() {
        return w_commission;
    }

    public void setW_commission(String w_commission) {
        this.w_commission = w_commission;
    }
}
