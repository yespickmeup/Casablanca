/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_svc4;

import POS.category_types.S1_categories;
import POS.Main.MyDB;
import POS.utl.Prompt;
import com.jgoodies.binding.list.ArrayListModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import POS.utl.MyConnection;

/**
 *
 * @author i1
 */
public class S8_commission {

    public static class to_commission {

        public final String id;
        public final String cat_id;
        public final String cat_name;
        public double total_sales;
        public double comm_amount;

        public to_commission(String id, String cat_id, String cat_name, double total_sales, double comm_amount) {
            this.id = id;
            this.cat_id = cat_id;
            this.cat_name = cat_name;
            this.total_sales = total_sales;
            this.comm_amount = comm_amount;
        }

        public void setComm_amount(double comm_amount) {
            this.comm_amount = comm_amount;
//            System.out.println("asdasd");
        }

        public void setTotal_sales(double total_sales) {
            this.total_sales = total_sales;
        }
    }

    public static List<to_commission> add_details() {
        List<to_commission> datas = new ArrayList();


        return datas;


    }

    public static double get_sales(String cat_id, String date) {
        double sales = 0;


        try {
            Connection conn = MyConnection.connect();
            String s0 = "select sum(price* qty_sold) as am from "+MyDB.getNames()+".sales where cat_id='" + cat_id + "'  and date(date_added)='" + date + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                sales = rs.getDouble(1);
            }

            return sales;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static List<to_commission> ret_data(String date) {
        List<to_commission> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();

            List<S1_categories.to_name_cat> categories = S1_categories.ret_categories("");





            for (S1_categories.to_name_cat t : categories) {

                String s0 = "select id,cat_id,total_sales,commission from "+MyDB.getNames()+".commission where date(date)='" + date + "' and cat_id='" + t.num + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                String id = "wala";
                String cat_id = "";
                String cat_name = "";


                double total_sales = 0;
                double comm_amount = 0;
                while (rs.next()) {
                    id = rs.getString(1);
                    cat_id = rs.getString(2);
                    cat_name = get_category_name(cat_id);


                    total_sales = rs.getDouble(3);
                    comm_amount = rs.getDouble(4);
                }

                to_commission to = new to_commission(id, t.num, t.name, total_sales, comm_amount);
                datas.add(to);
            }

            return datas;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_commission> ret_data2(String date) {
        List<to_commission> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select id,cat_id,total_sales,commission from "+MyDB.getNames()+".commission where date(date)='" + date + "' and cat_id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            List<S1_categories.to_name_cat> categories = S1_categories.ret_categories("");
            while (rs.next()) {
                String id = rs.getString(1);
                String cat_id = rs.getString(2);
                String cat_name = get_category_name(cat_id);


                double total_sales = rs.getDouble(3);
                double comm_amount = rs.getDouble(4);



                for (S1_categories.to_name_cat t : categories) {








                    if (cat_id.equals(t.num)) {

                        id = rs.getString(1);
                        cat_id = rs.getString(2);
                        cat_name = get_category_name(cat_id);


                        total_sales = rs.getDouble(3);
                        comm_amount = rs.getDouble(4);

                    } else {
                        id = "wala";
                        cat_id = t.num;
                        cat_name = t.name;
                        total_sales = 0;
                        comm_amount = 0;
                    }

                    to_commission to = new to_commission(id, cat_id, cat_name, total_sales, comm_amount);
                    datas.add(to);


                }

            }




            return datas;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_commission> set_data(String date) {
        List<to_commission> datas = new ArrayList();

        List<S1_categories.to_name_cat> categories = S1_categories.ret_categories("");


        for (S1_categories.to_name_cat t : categories) {

            double sales = get_sales(t.num, date);
//            System.out.println(t.num + " " + t.name + " " + sales);

            to_commission to = new to_commission("wala", t.num, t.name, sales, 0);

            datas.add(to);


        }


        return datas;

    }

    public static boolean check_sales(String date) {
        boolean exists = false;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select id from "+MyDB.getNames()+".commission where date(date)='" + date + "' limit 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                exists = true;
            }
            return exists;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void add_commission(String cat_id, double total_sales, double commission, String date) {


        try {
            Connection conn = MyConnection.connect();


            String s1 = "delete from "+MyDB.getNames()+".commission where date(date)='" + date + "' ";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
//            stmt1.execute();

            String s0 = "insert into "+MyDB.getNames()+".commission(cat_id,total_sales,commission,date)values(?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.setString(1, cat_id);
            stmt.setDouble(2, total_sales);
            stmt.setDouble(3, commission);
            stmt.setString(4, date);
            stmt.execute();

            Prompt.call("Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void add_commission2(String cat_id, double sales, double amount, String date, ArrayListModel tbl_employee_payroll_ALM) {

        List<S8_commission.to_commission> datas = tbl_employee_payroll_ALM;
        try {
            Connection conn = MyConnection.connect();

            for (S8_commission.to_commission to : datas) {
                String s0 = "insert into "+MyDB.getNames()+".commission(cat_id,total_sales,commission,date)values(?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.setString(1, to.cat_id);
                stmt.setDouble(2, to.total_sales);
                stmt.setDouble(3, to.comm_amount);
                stmt.setString(4, date);
                stmt.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }



    }

    public static void edit_commission(String id, double total_sales, double commission) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update "+MyDB.getNames()+".commission set total_sales='" + total_sales + "',commission='" + commission + "' where id='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Prompt.call("Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_commission(String id) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from "+MyDB.getNames()+".commission where id='" + id + "'";
            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Prompt.call("Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
//        System.out.println(get_sales("2012-07-01"));
    }

    public static String get_category_id(String prod_id) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_id from "+MyDB.getNames()+".inventory2_stocks_left where id='" + prod_id + "'";
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
     public static String get_category_id_2(String prod_id) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_id from "+MyDB.getNames()+".inventory2_stocks_left where product_name='" + prod_id + "'";
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

    public static String get_category_name(String cat_id) {
        String name = "";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select cat_name from "+MyDB.getNames()+".category where cat_num='" + cat_id + "'";
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
}
