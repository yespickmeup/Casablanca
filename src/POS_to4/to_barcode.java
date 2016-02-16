/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_to4;

import com.jgoodies.binding.list.ArrayListModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author i1
 */
public class to_barcode {

    
  
    
    
    public final String code;
    public final String desc;
    public final double price;

    public to_barcode(String code, String desc,double price) {
        this.code = code;
        this.desc = desc;
        this.price=price;
    }
    
    public static List<to_barcode> set(String code,String desc,ArrayListModel tbl_barcode_ALM,double price){
        List<to_barcode> datas=new ArrayList();
        to_barcode to=new to_barcode(code, desc,price);
        datas.add(to);
        return datas;
    }
    
}
