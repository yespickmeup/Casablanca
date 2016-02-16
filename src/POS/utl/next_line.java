/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import POS.svc2.S11_check_available_kilos;
import POS.svc2.S15_update_product;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author u2
 */
public class next_line {

    public static int r = 0;

    public static void do_next(int num, JButton btn, String name, JTable tbl, String prod_name, String nums, String table_no, int coloring) {
        r = num;

        String details = "Num";

        String old = nums;

        double qty = S15_update_product.get_qty(old, table_no);
        double qq = 0;
        int aw = tbl.getRowCount();



        String first = "";
        String last = "";
        String color = "";


        if (aw < 0) {
//            qq=0;
//            System.out.println(nums + " " + qq);
//
//            //            qq=0;
//            if (qty == 0) {
//                color = "red";
//            } else {
//                color = "green";
//
//            }
//
//            qty = qty - qq;
        } else {

            String cashiering_for = System.getProperty("cashiering_for", "retail_store");
//        JOptionPane.showMessageDialog(null, cashiering_for);

            double new_qty = 0;
            for (int i = 0; i < aw; i++) {
                String na = tbl.getModel().
                        getValueAt(i, 2).
                        toString();
                if (na.equals(prod_name)) {
                    qq = Double.parseDouble(tbl.getModel().
                            getValueAt(i, 6).
                            toString());
                    
                    break;
                }
                else{
                    qq=0;
                }
            }
            if (nums.isEmpty()) {
                qq = 0;
            } else {
                
                if (cashiering_for.equals("retail_store")) {

                    
                } else {
                    if (aw == 0) {
                        qq = S15_update_product.get_qty2(nums);

//                         qq += new_qty;
                    } else {
                        new_qty = S15_update_product.get_qty2_not2(nums, table_no);
//                        JOptionPane.showMessageDialog(null, new_qty + " "+nums);
//                    JOptionPane.showMessageDialog(null, new_qty);
                        if (new_qty == 0) {
                            qq += S15_update_product.get_qty2_not(nums, table_no);
//                    JOptionPane.showMessageDialog(null, qq);
                        } else {

                            qq += new_qty;

                        }
                    }
                }

//                 JOptionPane.showMessageDialog(null, qq + " " + nums);



            }



            qty = qty - qq;



            if (qty == 0) {
                color = "red";
            } else {
                color = "green";
            }

            int row = name.length();


            int i = 0;

            for (i = 0; i < row; i++) {
                if (i > 20) {
                    first = name.substring(0, 20);
                    last = name.substring(20, row);
                } else {
                    first = name.substring(0, row);
                    last = "";
                }

            }

            details = details + i;


            btn.setText(html_display(num, first, last, color, qty));
//            if (coloring == 3) {
//            } else {
//                boolean if_exists = S11_check_available_kilos.prod_exists(nums);
//                if (if_exists == false) {
//                    
//                } else {
//                    btn.setBackground(new java.awt.Color(102, 204, 255));
//                }
//            }

            num++;
        }

    }

    private static String html_display(int num, String sfirst,
            String slast, String scolor, double qty) {

        String template = "";

        template =
                "<html> "
                + "  <br> "
                //                + "  <center>Numpad: <font size=5 color=blue>" + num + "</font> "
                + "  <center> "
                + "  <br>" + sfirst + "<br>" + slast + "<br> "
                + "  <font  >Stock/s Left:</font> "
                + "  <font  color=" + scolor + ">" + NumType.no_decimal(qty) + "</font> "
                + "<center></html> ";



//        template = StringTemplate.parse(template)
//                .setNumber("num", num, "#.##")
//                .setString("first", sfirst)
//                .setString("last", slast)
//                .setString("color", scolor)
//                .setNumber("qty", qty, "#.##")
//                .ok();

        Lg.$.severe(template);

        return template;

    }
   
}
