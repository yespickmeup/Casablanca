/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc5;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author i1
 */
public class RSS_Feed1 {

    public static class RssFeed {

        public final String name;
        public final String url;
        public final Article[] articles;

        public RssFeed(String name, String url, Article[] articles) {
            this.name = name;
            this.url = url;
            this.articles = articles;
        }
    }

    public static class Article {

        public final String title;
        public final String url;
        public final String content;

        public Article(String title, String url, String content) {
            this.title = title;
            this.url = url;
            this.content = content;
        }
    }

    public static class RssFeedCellRenderer implements TableCellRenderer {

        public Component get_column_0_build(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            RssFeed feed = (RssFeed) value;

            JButton showButton = new JButton("View Articles");
            showButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane.showMessageDialog(null, "HA-HA!");
                }
            });

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            String aw = "<html>"
                    + " <strong> " + feed.name + "<strong>"
                    + feed.url + "Articles " + feed.articles.length
                    + "</html>";
//            panel.add(new JLabel("<strong>" + feed.name + "</strong>"
//                    + feed.url + "Articles " + feed.articles.length + ""));
////            panel.add(showButton);
            panel.add(new JLabel(aw));
            if (isSelected) {
                panel.setBackground(new java.awt.Color(51, 153, 255));
            } else {
                panel.setBackground(new java.awt.Color(255, 255, 255));
            }

            panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


            JLabel lbl_name = new javax.swing.JLabel();
            JLabel lbl_qty_left = new javax.swing.JLabel();
            JLabel lbl_price = new javax.swing.JLabel();
            JLabel lbl_photo = new javax.swing.JLabel();
            JButton jButton1 = new javax.swing.JButton();
            JButton jButton2 = new javax.swing.JButton();

            lbl_name.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
            lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl_name.setText("C1- 1pc Chicken with Lechon Manok");
            lbl_name.setAlignmentX(10.0F);
            lbl_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            panel.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 300, 30));

            lbl_qty_left.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
            lbl_qty_left.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            lbl_qty_left.setText("QTY LEFT: 10");
            lbl_qty_left.setAlignmentX(10.0F);
            lbl_qty_left.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            lbl_qty_left.setIconTextGap(10);
            panel.add(lbl_qty_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 130, 30));

            lbl_price.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
            lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            lbl_price.setText("Price P 50.00");
            lbl_price.setAlignmentX(10.0F);
            lbl_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            panel.add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 160, 30));

            lbl_photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/svc5/naruto-3461673.jpg"))); // NOI18N
            lbl_photo.setText("PHOTO HERE");
            lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            panel.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 70));

            jButton1.setText("REMOVE");
            jButton1.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                }
            });
//            panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 90, 30));

            jButton2.setText("ORDER");
//            panel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 90, 30));

            return panel;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {


            if (column == 0) {
                return get_column_0_build(table, value, isSelected, hasFocus, row, column);
            } else {
     
                    return new JTextField(""+value);

            }


        }
    }

    public static class RssFeedTableModel extends AbstractTableModel {

        List feeds;
        public String[] COLUMNS = {
            "Num", "Name" // , "Question", "Date Added"
        };

        public RssFeedTableModel(List feeds, String[] COLUMNS) {
            this.feeds = feeds;
            this.COLUMNS = COLUMNS;

        }

        @Override
        public Class getColumnClass(int columnIndex) {
            return RssFeed.class;
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length; //4;
        }

        @Override
        public String getColumnName(int i) {
            return COLUMNS[i];
        }

        @Override
        public int getRowCount() {
            return (feeds == null) ? 0 : feeds.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            
            return (feeds == null) ? null : feeds.get(rowIndex);
            
        }

        @Override
        public boolean isCellEditable(int columnIndex, int rowIndex) {
            return true;
        }
    }
}
