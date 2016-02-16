/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_to4;

/**
 *
 * @author i1
 */
public class to_customer_table {
    
    public static class tables{
        
        public final String table_no;
        public final String time;
        public final double amount;
        public final String or_no;
        public final String status;
        public final String id;

        public tables(String table_no, String time, double amount, String or_no, String status,String id) {
            this.table_no = table_no;
            this.time = time;
            this.amount = amount;
            this.or_no = or_no;
            this.status = status;
            this.id=id;
        }       
    }
    
   public static class to_customer_order_details{
 
         public final String id;
         public final double qty;
         public final String product_code;
         public final double price;
         public final double amount;

        public to_customer_order_details(String id, double qty, String product_code, double price, double amount) {
            this.id = id;
            this.qty = qty;
            this.product_code = product_code;
            this.price = price;
            this.amount = amount;
        }
         
         
   }
      
}
