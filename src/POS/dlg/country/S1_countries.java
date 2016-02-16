/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg.country;

import POS.Main.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import POS.utl.MyConnection;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_countries {

    public static class to_countries {

        public final int id;
        public final String country;
        public final String capital;

        public to_countries(int id, String country, String capital) {
            this.id = id;
            this.country = country;
            this.capital = capital;
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select country from " + MyDB.getNames() + ".countries order by country asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void add_country(to_countries to_countries) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into " + MyDB.getNames() + ".countries("
                        + "country"
                        + ",capital"
                        + ")values("
                        + ":country"
                        + ",:capital"
                        + ")";

            s0 = SqlStringUtil.parse(s0).setString("country", to_countries.country).setString("capital", to_countries.capital).ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_countries.class, "Successfully Added");

        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_country(to_countries to_countries) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update " + MyDB.getNames() + ".countries set "
                        + "country= '" + to_countries.country + "'"
                        + ",capital= '" + to_countries.capital + "'"
                        + "where "
                        + "id ='" + to_countries.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_countries.class, "Successfully Updated");


        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_country(to_countries to_countries) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from " + MyDB.getNames() + ".countries where "
                        + " id ='" + to_countries.id + "' "
                        + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_countries.class, "Successfully Deleted");


        } catch (Exception e) {
            MyConnection.close();
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_countries> ret_data(String search) {
        List<to_countries> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",country"
                        + ",capital"
                        + " from " + MyDB.getNames() + ".countries where "
                        + " country like'%" + search + "%' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String country = rs.getString(2);
                String capital = rs.getString(3);

                to_countries to = new to_countries(id, country, capital);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    public static void main(String[] args) {
        String c = "country - capital";



        List<to_countries> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                        + "id"
                        + ",country"
                        + ",capital"
                        + " from " + MyDB.getNames() + ".countries where "
                        + " country like'%" + "" + "%' "
                        + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String country1 = rs.getString(2);
                String capital1 = rs.getString(3);

                to_countries to = new to_countries(id, country1, capital1);
                datas.add(to);
            }

            for (to_countries to : datas) {
                int start = 0;
                String country = "";
                String capital = "";
                for (int i = 0; i < to.country.length(); i++) {
                    if (to.country.startsWith("-", i)) {
                        start = i;

                    }
                }
                country = to.country.substring(0, start - 1);
                capital = to.country.substring(start + 2, to.country.length());
//                System.out.println(country + " - "+capital);


                to_countries to1 = new to_countries(to.id, country, capital);
                edit_country(to1);
//                System.out.println(capital);
            }



//            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
    // </editor-fold>
}
