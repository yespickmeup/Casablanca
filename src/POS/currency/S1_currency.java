/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.currency;

import POS.Main;
import POS.Main.MyDB;
import POS.utl.DateType;
import POS.utl.DateUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Dummy
 */
public class S1_currency {

    public static class to_currencies {

        public final int id;
        public final String dollar;
        public final String amount;
        public final String date_added;

        public to_currencies(int id, String dollar, String amount, String date_added) {
            this.id = id;
            this.dollar = dollar;
            this.amount = amount;
            this.date_added = date_added;
        }
    }

    public static void add_data(to_currencies to_currencies) {
        try {
            Connection conn = MyConnection.connect();
            String s1 = "select id from " + MyDB.getNames() + ".currencies where Date(date_added)='" + to_currencies.date_added + "'";
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(s1);
            if (rs1.next()) {

                String s0 = "update " + MyDB.getNames() + ".currencies set "
                        + "dollar= '" + to_currencies.dollar + "'"
                        + ",amount= '" + to_currencies.amount + "'"
                        + ",date_added= '" + to_currencies.date_added + "'"
                        + "where "
                        + " Date(date_added) ='" + to_currencies.date_added + "' "
                        + " ";

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_currency.class, "Successfully Updated");

            } else {
                String s0 = "insert into " + MyDB.getNames() + ".currencies("
                        + "id"
                        + ",dollar"
                        + ",amount"
                        + ",date_added"
                        + ")values("
                        + ":id"
                        + ",:dollar"
                        + ",:amount"
                        + ",:date"
                        + ")";

                s0 = SqlStringUtil.parse(s0).
                        setNumber("id", to_currencies.id).
                        setString("dollar", to_currencies.dollar).
                        setString("amount", to_currencies.amount).
                        setString("date", to_currencies.date_added).
                        ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_currency.class, "Successfully Added");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }

    }

    public static void edit_data(to_currencies to_currencies) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".currencies set "
                    + "dollar= '" + to_currencies.dollar + "'"
                    + ",amount= '" + to_currencies.amount + "'"
                    + ",date_added= '" + to_currencies.date_added + "'"
                    + "where "
                    + " Date(date_added)='" + to_currencies.date_added + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_currency.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_currencies to_currencies) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".currencies where "
                    + " id ='" + to_currencies.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_currency.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_currencies> ret_data(String date) {
        List<to_currencies> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",dollar"
                    + ",amount"
                    + ",date_added"
                    + " from " + MyDB.getNames() + ".currencies where "
                    + " Date(date_added) ='" + date + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String dollar = rs.getString(2);
                String amount = rs.getString(3);
                String date_added = rs.getString(4);
                to_currencies to = new to_currencies(id, dollar, amount, date_added);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_cashier_session() {
        String date=DateType.sf.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".cashier_sessions set "
                    + "login_status= '" + "0" + "'"
                    + "where "
                    + " login_status ='" + "1" + "' "
                    + " and Date(modified) <> '" + date + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_currency.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static double ret_dollar(String date) {
        double amount = 41;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "amount"
                    + " from " + MyDB.getNames() + ".currencies where "
                    + " Date(date_added) ='" + date + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                amount = rs.getDouble(1);
            }
            return amount;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void main(String[] args) {
        Main.MyDB.setNames("db_pos_restaurant");
        update_currency();
    }

    public static void update_currency() {

        String date = DateType.sf.format(new Date());
        double amount = 0;
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "amount"
                    + " from " + MyDB.getNames() + ".currencies where "
                    + " Date(date_added) ='" + date + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            String s2 = "select "
                    + "max(id)"
                    + " from " + MyDB.getNames() + ".currencies"
                    + " ";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(s2);
            if (rs2.next()) {
                String id = rs2.getString(1);
                String s3 = "select "
                        + "date_added"
                        + ",amount"
                        + " from " + MyDB.getNames() + ".currencies where "
                        + " id ='" + id + "' "
                        + " ";

                Statement stmt3 = conn.createStatement();
                ResultSet rs3 = stmt3.executeQuery(s3);
                Date da = new Date();
                if (rs3.next()) {
                    da = DateType.sf.parse(rs3.getString(1));
                    amount = rs3.getDouble(2);
                }
                int count_days = DateUtils.count_days(da, new Date());
                Date a = new Date();
                a = da;
                if (count_days > -1) {
                    for (int i = 0; i < count_days; i++) {
                        a = DateUtils.add_day(a, 1);

                        String s4 = "insert into " + MyDB.getNames() + ".currencies(dollar,amount,date_added)values(?,?,?)";
                        PreparedStatement stmt4 = conn.prepareStatement(s4);
                        stmt4.setString(1, "dollar");
                        stmt4.setDouble(2, amount);
                        stmt4.setString(3, DateType.sf.format(a));
                        stmt4.execute();
                    }
                }


            }
//            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
