/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.to2;

import java.util.Date;

/**
 *
 * @author Dummy
 */
public class to_receipts {
    
    
    public final String trans_number;
    public final String trans_date;
    public final String tendered;
    public final String discount;
    public final double amount;
    
    public to_receipts(String trans_number, String trans_date, String tendered, String discount,double amount) {
        this.trans_number = trans_number;
        this.trans_date = trans_date;
        this.tendered = tendered;
        this.discount = discount;
        this.amount=amount;
    }

    
    public static class aw{
        
        public  String name="";
        public  double price=0;
        public  double qty=0;
        public  double amount=0;
        public  String id="";
        public int prod_num=0;

       
        public aw(String name, double price, double qty,double amount,String id,int prod_num) {
            this.name=name;
            this.price=price;
            this.qty=qty;
            this.amount=amount;
            this.id=id;
            this.prod_num=prod_num;
        }

     
        public String getid(){
            return id;
        }
        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public double getQty() {
            return qty;
        }
         public double getamount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }
        public void setId(String id){
            this.id=id;
        }

        public void setProd_num(int prod_num) {
            this.prod_num = prod_num;
        }

        public double getAmount() {
            return amount;
        }

        public String getId() {
            return id;
        }

        public int getProd_num() {
            return prod_num;
        }
         
        
        
        
    }
}
