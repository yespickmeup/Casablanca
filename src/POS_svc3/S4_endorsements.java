/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc3;

import POS.Main.MyDB;
import POS.svc2.S10_select_products;
import POS.to.to_order;
import POS.utl.DateType;
import POS.utl.Prompt;
import POS_svc4.S8_commission;
import com.jgoodies.binding.list.ArrayListModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S4_endorsements {

    public static class to_endorsements {

        public final String id;
        public final String barcode;
        public final String prod_name;
        public final double price;
        public final double qty_endorsed;
        public final double qty_left;
        public final double sold;
        public final String date_added;
        public final String cashier_id;
        public final String remarks;
        public final double sales;

        public to_endorsements(String id, String barcode, String prod_name, double price, double qty_endorsed, double qty_left, double sold, String date_added, String cashier_id, String remarks, double sales) {
            this.id = id;
            this.barcode = barcode;
            this.prod_name = prod_name;
            this.price = price;
            this.qty_endorsed = qty_endorsed;
            this.qty_left = qty_left;
            this.sold = sold;
            this.date_added = date_added;
            this.cashier_id = cashier_id;
            this.remarks = remarks;
            this.sales = sales;
        }
    }
// "id", "BARCODE", "PRODUCT NAME","Price","ENDORSED", "LEFT", "SOLD", "cashier_ids", "remarks","SALES"

    public static List<to_endorsements> get_endorsements(String cashier_id) {
        List<to_endorsements> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",product_id"
                    + ",product_name"
                    + ",qty_endorsed"
                    + ",qty_left"
                    + ",date_added "
                    + ",cashier_id"
                    + ",remarks "
                    + "from "+MyDB.getNames()+".endorsements where cashier_id='" + cashier_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                String product_id = rs.getString(2);

//                String name = get_prod_name(product_id);
                String name = rs.getString(3);

                double price = get_prod_price(product_id);
                double qty_endorsed = rs.getDouble(4);
                double qty_left = rs.getDouble(5);
                String date_added = rs.getString(6);
                String cashier_ids = rs.getString(7);
                String remarks = rs.getString(8);
                double sold = qty_endorsed - qty_left;
                double sales = sold * price;

                to_endorsements to = new to_endorsements(id, product_id, name, price, qty_endorsed, qty_left, sold, date_added, cashier_ids, remarks, sales);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_endorsements> get_endorsements_search(String cashier_id, String search) {
        List<to_endorsements> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",product_id"
                    + ",product_name"
                    + ",qty_endorsed"
                    + ",qty_left"
                    + ",date_added "
                    + ",cashier_id"
                    + ",remarks "
                    + "from "+MyDB.getNames()+".endorsements where cashier_id='" + cashier_id + "' and product_name like '%" + search + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                String product_id = rs.getString(2);

//                String name = get_prod_name(product_id);
                String name = rs.getString(3);

                double price = get_prod_price(product_id);
                double qty_endorsed = rs.getDouble(4);
                double qty_left = rs.getDouble(5);
                String date_added = rs.getString(6);
                String cashier_ids = rs.getString(7);
                String remarks = rs.getString(8);
                double sold = qty_endorsed - qty_left;
                double sales = sold * price;

                to_endorsements to = new to_endorsements(id, product_id, name, price, qty_endorsed, qty_left, sold, date_added, cashier_ids, remarks, sales);
                datas.add(to);
            }

            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String get_prod_name(String barcode) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select description  from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + barcode + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                name = rs.getString(1);
            }
            return name;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_prod_price(String barcode) {
        double price = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select price  from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + barcode + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                price = rs.getDouble(1);
            }
            return price;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_endorsement(ArrayListModel l, String cashier_id, double qty) {
//         product_id   | varchar(100) | YES  |     | NULL    |                |
//| qty_endorsed | double       | YES  |     | NULL    |                |
//| qty_left     | double       | YES  |     | NULL    |                |
//| date_added   | datetime     | YES  |     | NULL    |                |
//| cashier_id   | int(11)      | YES  |     | NULL    |                |
//| remarks      | varchar(100) | YES  |     | NULL    |                |

        List<to_order> datas = l;
        String date = DateType.datetime.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            for (to_order to : datas) {

                double tot_endorse = if_endorsed(to.code, cashier_id);

                if (tot_endorse == 0) {
                    String s0 = "insert into "+MyDB.getNames()+".endorsements(product_id,product_name,qty_endorsed,qty_left,date_added,cashier_id,remarks)values(?,?,?,?,?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.setString(1, to.code);
                    stmt.setString(2, to.product_name);
                    stmt.setDouble(3, to.hd_uom);
                    stmt.setDouble(4, to.hd_uom);
                    stmt.setString(5, date);
                    stmt.setString(6, cashier_id);
                    stmt.setString(7, "");
                    stmt.execute();

//                    JOptionPane.showMessageDialog(null, cashier_id);
                    String s1 = "update "+MyDB.getNames()+".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";


                    double qtyy = S10_select_products.get_qty(to.code);

                    double total = qtyy - to.hd_uom;
//                    JOptionPane.showMessageDialog(null, qtyy+ " - "+ to.hd_uom+ " = "+ total + " "+to.code);
//                 JOptionPane.showMessageDialog(null, " "+too.code);

                    s1 = SqlStringUtil.parse(s1).setNumber("total", total).setString("product_name", to.code).ok();

                    PreparedStatement psmt3 = conn.prepareStatement(s1);
                    psmt3.execute();


                    String s2 = "insert into "+MyDB.getNames()+".endorsement_histories(product_id,product_name,prev_endorsed,qty_endorsed,date_added,cashier_id)values(?,?,?,?,?,?)";


                    PreparedStatement stmt3 = conn.prepareStatement(s2);
                    stmt3.setString(1, to.code);
                    stmt3.setString(2, to.product_name);
                    stmt3.setDouble(3, tot_endorse);
                    stmt3.setDouble(4, qty);
                    stmt3.setString(5, date);
                    stmt3.setString(6, cashier_id);
                    stmt3.execute();


                } else {
                    double new_endorsed = tot_endorse + to.hd_uom;

//                    JOptionPane.showMessageDialog(null, to.hd_uom);
                    double left = get_left(to.code, cashier_id) + to.hd_uom;
                    String s0 = "update "+MyDB.getNames()+".endorsements set qty_endorsed='" + new_endorsed + "',qty_left='" + left + "' where cashier_id='" + cashier_id + "' and product_id='" + to.code + "' ";
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();

                    String s1 = "update "+MyDB.getNames()+".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";


                    double qtyy = S10_select_products.get_qty(to.code);

                    double total = qtyy - to.hd_uom;
//                    JOptionPane.showMessageDialog(null, to.hd_uom);
//                 JOptionPane.showMessageDialog(null, " "+too.code);
//                   JOptionPane.showMessageDialog(null, qtyy+ " - "+ to.hd_uom+ " = "+ total + " "+to.code);
                    s1 = SqlStringUtil.parse(s1).setNumber("total", total).setString("product_name", to.code).ok();

                    PreparedStatement psmt3 = conn.prepareStatement(s1);
                    psmt3.execute();



                    String s2 = "insert into "+MyDB.getNames()+".endorsement_histories(product_id,product_name,prev_endorsed,qty_endorsed,date_added,cashier_id)values(?,?,?,?,?,?)";

                    PreparedStatement stmt3 = conn.prepareStatement(s2);
                    stmt3.setString(1, to.code);
                    stmt3.setString(2, to.product_name);
                    stmt3.setDouble(3, tot_endorse);
                    stmt3.setDouble(4, qty);
                    stmt3.setString(5, date);
                    stmt3.setString(6, cashier_id);
                    stmt3.execute();

                }

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }


    }

    public static double if_endorsed(String barcode, String cashier_id) {
        double qty_endorsed = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select qty_endorsed from "+MyDB.getNames()+".endorsements where product_id='" + barcode + "' and cashier_id='" + cashier_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                qty_endorsed = rs.getDouble(1);
            }
            return qty_endorsed;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_left(String barcode, String cashier_id) {
        double qty_endorsed = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select qty_left from "+MyDB.getNames()+".endorsements where product_id='" + barcode + "' and cashier_id='" + cashier_id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                qty_endorsed = rs.getDouble(1);
            }
            return qty_endorsed;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_end(String barcode, double qty, String cashier_id, double qty_left, String prod_name, double price, String date_sold, String id) {

        double tot = qty_left - qty;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".endorsements set qty_left ='" + tot + "' where cashier_id='" + cashier_id + "' and product_id='" + barcode + "' ";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

//            product_id   | varchar(100) | YES  |     | NULL    |                |
//| product_name | varchar(100) | YES  |     | NULL    |                |
//| price        | double       | YES  |     | NULL    |                |
//| qty_sold     | double       | YES  |     | NULL    |                |
//| date_added   | datetime     | YES  |     | NULL    |                |
//| cashierid
//            String date = DateType.datetime.format(new Date());
            String s1 = "insert into "+MyDB.getNames()+".sales(product_id,product_name,price,qty_sold,date_added,cashierid,cat_id,commission,remitance,remit_cost)values(?,?,?,?,?,?,?,?,?,?)";
            double commission = 0;
            double rate = get_commission_rate(barcode);
            rate = (rate / 100);

            commission = (qty * price) * rate;

            double[] remitance = new double[2];

            remitance = get_remmitance(barcode);

//            JOptionPane.showMessageDialog(null, commission + " "+remitance);


            PreparedStatement stmt2 = conn.prepareStatement(s1);
            stmt2.setString(1, barcode);
            stmt2.setString(2, prod_name);
            stmt2.setDouble(3, price);
            stmt2.setDouble(4, qty);
            stmt2.setString(5, date_sold);
            stmt2.setString(6, cashier_id);
            String cat_id = S8_commission.get_category_id_2(barcode);
//            JOptionPane.showMessageDialog(null, cat_id);
            stmt2.setString(7, cat_id);
            stmt2.setDouble(8, commission);
            stmt2.setDouble(9, remitance[0]);
            stmt2.setDouble(10, remitance[1]);

            stmt2.execute();

            if (qty == qty_left) {
                String s2 = "delete from "+MyDB.getNames()+".endorsements where id='" + id + "' ";
                PreparedStatement stmt4 = conn.prepareStatement(s2);
//                stmt4.execute();
            }
            Prompt.call("Updated Successfully");


//            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void cancel_endorsement(String barcode, double qty, String cashier_id, double qty_left, String prod_name, double price, double endorsed) {


        double prev = qty_left;

        String date = DateType.datetime.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            if (qty == qty_left) {

                String s0 = "delete from "+MyDB.getNames()+".endorsements  where cashier_id='" + cashier_id + "' and product_id='" + barcode + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                String s1 = "update "+MyDB.getNames()+".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";


                double qtyy = S10_select_products.get_qty(barcode);

                double total = qtyy + qty;

//                 JOptionPane.showMessageDialog(null, " "+too.code);

                s1 = SqlStringUtil.parse(s1).setNumber("total", total).setString("product_name", barcode).ok();

                PreparedStatement psmt3 = conn.prepareStatement(s1);
                psmt3.execute();


                String s2 = "insert into "+MyDB.getNames()+".cancelled_endorsements(product_id,product_name,prev_endorsed,qty,date_added,cashier_id)values(?,?,?,?,?,?)";
                PreparedStatement stmt3 = conn.prepareStatement(s2);
                stmt3.setString(1, barcode);
                stmt3.setString(2, prod_name);
                stmt3.setDouble(3, prev);
                stmt3.setDouble(4, qty);
                stmt3.setString(5, date);
                stmt3.setString(6, cashier_id);
                stmt3.execute();



            } else {
                qty_left -= qty;
                endorsed -= qty;

                String s0 = "update "+MyDB.getNames()+".endorsements set qty_endorsed ='" + endorsed + "',qty_left='" + qty_left + "' where cashier_id='" + cashier_id + "' and product_id='" + barcode + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                String s1 = "update "+MyDB.getNames()+".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";


                double qtyy = S10_select_products.get_qty(barcode);

                double total = qtyy + qty;

//                 JOptionPane.showMessageDialog(null, " "+too.code);

                s1 = SqlStringUtil.parse(s1).setNumber("total", total).setString("product_name", barcode).ok();

                PreparedStatement psmt3 = conn.prepareStatement(s1);
                psmt3.execute();



                String s2 = "insert into "+MyDB.getNames()+".cancelled_endorsements(product_id,product_name,prev_endorsed,qty,date_added,cashier_id)values(?,?,?,?,?,?)";
                PreparedStatement stmt3 = conn.prepareStatement(s2);
                stmt3.setString(1, barcode);
                stmt3.setString(2, prod_name);
                stmt3.setDouble(3, prev);
                stmt3.setDouble(4, qty);
                stmt3.setString(5, date);
                stmt3.setString(6, cashier_id);
                stmt3.execute();

            }

            Prompt.call("ENDORSEMENT CANCELLED");
//            JOptionPane.showMessageDialog(null, "ENDORSEMENT CANCELLED");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
     public static void return_endorsement(String barcode, double qty, String cashier_id, double qty_left, String prod_name, double price, double endorsed) {


        double prev = qty_left;

        String date = DateType.datetime.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            if (qty == qty_left) {

                String s0 = "delete from "+MyDB.getNames()+".endorsements  where cashier_id='" + cashier_id + "' and product_id='" + barcode + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                String s1 = "update "+MyDB.getNames()+".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";


                double qtyy = S10_select_products.get_qty(barcode);

                double total = qtyy + qty;

//                 JOptionPane.showMessageDialog(null, " "+too.code);

                s1 = SqlStringUtil.parse(s1).setNumber("total", total).setString("product_name", barcode).ok();

                PreparedStatement psmt3 = conn.prepareStatement(s1);
                psmt3.execute();


                String s2 = "insert into "+MyDB.getNames()+".cancelled_endorsements(product_id,product_name,prev_endorsed,qty,date_added,cashier_id)values(?,?,?,?,?,?)";
                PreparedStatement stmt3 = conn.prepareStatement(s2);
                stmt3.setString(1, barcode);
                stmt3.setString(2, prod_name);
                stmt3.setDouble(3, prev);
                stmt3.setDouble(4, qty);
                stmt3.setString(5, date);
                stmt3.setString(6, cashier_id);
                stmt3.execute();



            } else {
                qty_left -= qty;
                endorsed -= qty;

                String s0 = "update "+MyDB.getNames()+".endorsements set qty_endorsed ='" + endorsed + "',qty_left='" + qty_left + "' where cashier_id='" + cashier_id + "' and product_id='" + barcode + "'";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();

                String s1 = "update "+MyDB.getNames()+".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";


                double qtyy = S10_select_products.get_qty(barcode);

                double total = qtyy + qty;

//                 JOptionPane.showMessageDialog(null, " "+too.code);

                s1 = SqlStringUtil.parse(s1).setNumber("total", total).setString("product_name", barcode).ok();

                PreparedStatement psmt3 = conn.prepareStatement(s1);
                psmt3.execute();



                String s2 = "insert into "+MyDB.getNames()+".cancelled_endorsements(product_id,product_name,prev_endorsed,qty,date_added,cashier_id)values(?,?,?,?,?,?)";
                PreparedStatement stmt3 = conn.prepareStatement(s2);
                stmt3.setString(1, barcode);
                stmt3.setString(2, prod_name);
                stmt3.setDouble(3, prev);
                stmt3.setDouble(4, qty);
                stmt3.setString(5, date);
                stmt3.setString(6, cashier_id);
                stmt3.execute();

            }

            Prompt.call("ENDORSEMENT CANCELLED");
//            JOptionPane.showMessageDialog(null, "ENDORSEMENT CANCELLED");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }


    public static void add_direct_sales(String code, String name, double price, double quantity, String cat_id, Date dates) {


        try {
            Connection conn = MyConnection.connect();

            String s1 = "update "+MyDB.getNames()+".inventory2_stocks_left p set p.product_qty = :total where p.product_name = :product_name; ";


            double qtyy = S10_select_products.get_qty(code);
            double total = qtyy - quantity;
            s1 = SqlStringUtil.parse(s1).setNumber("total", total).setString("product_name", code).ok();

            PreparedStatement psmt3 = conn.prepareStatement(s1);
            psmt3.execute();
//           
            String date = DateType.datetime.format(new Date());
//            String s0 = "insert into "+MyDB.getNames()+".sales("
//                    + "product_id"
//                    + ",product_name"
//                    + ",price"
//                    + ",qty_sold"
//                    + ",date_added"
//                    + ",cashierid"
//                    + ",cat_id)values(?,?,?,?,?,?,?)";
//            PreparedStatement stmt = conn.prepareStatement(s0);
//            stmt.setString(1, code);
//            stmt.setString(2, name);
//            stmt.setDouble(3, price);
//            stmt.setDouble(4, quantity);
//            stmt.setString(5, date);
//            stmt.setString(6, "1000");
//            stmt.setString(7, cat_id);
//            stmt.execute();
            String s2 = "insert into "+MyDB.getNames()+".sales(product_id,product_name,price,qty_sold,date_added,cashierid,cat_id,commission,remitance,remit_cost)values(?,?,?,?,?,?,?,?,?,?)";
            double commission = 0;
            double rate = get_commission_rate(code);
            rate = (rate / 100);

            commission = (quantity * price) * rate;

            double[] remitance = new double[2];

            remitance = get_remmitance(code);

//            JOptionPane.showMessageDialog(null, commission + " "+remitance);


            String date_sold = DateType.datetime.format(new Date());

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.setString(1, code);
            stmt2.setString(2, name);
            stmt2.setDouble(3, price);
            stmt2.setDouble(4, quantity);
            stmt2.setString(5, date_sold);
            stmt2.setString(6, "1000");
            String cat_ids = S8_commission.get_category_id(code);
            stmt2.setString(7, cat_ids);
            stmt2.setDouble(8, commission);
            stmt2.setDouble(9, remitance[0]);
            stmt2.setDouble(10, remitance[1]);

            stmt2.execute();
            Prompt.call("Added Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_commission(String barcode) {

        double amount = 0;
        try {
            Connection conn = MyConnection.connect();

            String s0 = "select comm_amount,price from "+MyDB.getNames()+".sales where product_name='" + barcode + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                double comm = rs.getDouble(1);
                double price = rs.getDouble(2);
                amount = price - comm;
            }
            return amount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        System.out.println(get_remmitance("3"));
    }

    public static double[] get_remmitance(String product_name) {

        double[] remit = new double[2];
        remit[0] = 0;
        remit[1] = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select price,cost from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + product_name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                double price = rs.getDouble(1);
                double cost = rs.getDouble(2);
                System.out.println(price + " - " + cost);
                remit[0] = price - cost;   // remitance
                remit[1] = cost;
//                remit = cost;
            }
            return remit;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double get_commission_rate(String product_name) {

        double remit = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select comm_amount from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + product_name + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                remit = rs.getDouble(1);

            }
            return remit;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
