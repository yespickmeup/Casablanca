/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc5;

import POS.to.to_feed;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import mijzcx.synapse.desk.utils.FitIn;

/**
 *
 * @author i1
 */
public class RSS_Feed {

    public static class RssFeed {

        public final to_feed to_feed;
        public final String image;
        public final String barcode;
        public final String name;
        public final double price;
        public final double qty;

        public RssFeed(String image, String barcode, String name, double price, double qty) {
            this.to_feed = new to_feed(image, barcode, name, price, qty);

            this.image = image;
            this.barcode = barcode;
            this.name = name;
            this.price = price;
            this.qty = qty;
        }
    }

    public static class RssFeedCellRenderer implements TableCellRenderer {

        public Component get_column_0_build(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
//            RssFeed feed = (RssFeed) value;

//            String image = "";
//            String barcode = "0001";
//            String name = "name";
//            double price = 10;
//            double qty = 10;
//            
//            to_feed to_feed = new to_feed(image, barcode, name, price, qty);

            to_feed to_feed = (to_feed) value;

            JButton showButton = new JButton("View Articles");
            showButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    JOptionPane.showMessageDialog(null, "HA-HA!");
                }
            });

//       
//           
//

            JPanel jPanel1 = new javax.swing.JPanel();
            JLabel lbl_qty = new javax.swing.JLabel();
            JLabel lbl_pic = new javax.swing.JLabel();
            final JLabel lbl_name = new javax.swing.JLabel();
            JLabel lbl_price = new javax.swing.JLabel();
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            lbl_qty.setBackground(new java.awt.Color(0, 0, 0));
            lbl_qty.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
            lbl_qty.setForeground(new java.awt.Color(255, 255, 255));
            lbl_qty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl_qty.setText("" + to_feed.qty);
            lbl_qty.setOpaque(true);
            jPanel1.add(lbl_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

            lbl_pic.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
            lbl_pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl_pic.setIcon(new javax.swing.ImageIcon("/home/i1/Documents/food.jpeg")); // NOI18N
//            lbl_pic.setText(to_feed.name);
            lbl_pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jPanel1.add(lbl_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 80));

            lbl_name.setBackground(new java.awt.Color(255, 255, 255));
            lbl_name.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
            lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            lbl_name.setText(to_feed.name);
            lbl_name.setOpaque(true);
            jPanel1.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 90, 30));

            lbl_price.setBackground(new java.awt.Color(0, 0, 0));
            lbl_price.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
            lbl_price.setForeground(new java.awt.Color(255, 255, 255));
            lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl_price.setText("" + to_feed.price);
            lbl_price.setOpaque(true);
            jPanel1.add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 50, 30));
            if (isSelected) {
                lbl_name.setBackground(new java.awt.Color(153, 255, 255));
                lbl_price.setForeground(java.awt.Color.green);
                lbl_qty.setForeground(java.awt.Color.green);
            } else {
                lbl_name.setBackground(new java.awt.Color(255, 255, 255));
                lbl_price.setForeground(new java.awt.Color(255, 255, 255));
                lbl_qty.setForeground(new java.awt.Color(255, 255, 255));
            }

            return jPanel1;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            if (value instanceof to_feed) {
                return get_column_0_build(table, value, isSelected, hasFocus, row, column);
            } else {
                return new JTextField("" + value);
            }


        }
    }

    public static class RssFeedTableModel extends AbstractTableModel {

        List<RssFeed> feeds;
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
            RssFeed to = feeds.get(rowIndex);
//            barcode", "NAme", "Price", "QTY"
            switch (columnIndex) {
                case 0:
                    return to.to_feed;
                case 1:
                    return to.barcode;
                case 2:
                    return to.name;
                case 3:
                    return to.price;

                default:
                    return to.price;
            }
//            return (feeds == null) ? null : feeds.get(rowIndex);
        }

        @Override
        public boolean isCellEditable(int columnIndex, int rowIndex) {
            return true;
        }
    }
}
