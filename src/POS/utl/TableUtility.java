/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Dummy
 */
public class TableUtility {

    public static void align_row_to_right(JTable tbl, int row) {

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tbl.getColumnModel().getColumn(row).setCellRenderer(rightRenderer);
    }

    public static void align_row_to_left(JTable tbl, int row) {

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.LEFT);
        tbl.getColumnModel().getColumn(row).setCellRenderer(rightRenderer);
    }

    public static void align_row_to_Center(JTable tbl, int row) {

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl.getColumnModel().getColumn(row).setCellRenderer(rightRenderer);

    }

    public static void align_column_to_Center(JTable tbl, int col) {

        tbl = new JTable() {

            DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();

            {//initializer block
                renderRight.setHorizontalAlignment(SwingConstants.RIGHT);
            }

            @Override
            public TableCellRenderer getCellRenderer(int arg0, int arg1) {
                return renderRight;

            }
        };


    }
}
