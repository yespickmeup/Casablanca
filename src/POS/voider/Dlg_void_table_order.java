/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.voider;

import POS.Main;
import POS.utl.Prompt;
import POS.voider.S1_void_table_orders.to_tables;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Dummy
 */
public class Dlg_void_table_order extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_void_table_order
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_void_table_order(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_void_table_order(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_void_table_order() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_void_table_order myRef;

    private void setThisRef(Dlg_void_table_order myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_void_table_order> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_void_table_order create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_void_table_order create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_void_table_order dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_void_table_order((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_void_table_order dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_void_table_order((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().
                        log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dlg_void_table_order dialog = Dlg_void_table_order.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().
                    removeAll();
            initComponents();
            myInit();
            repaint();
        }


    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tables = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_customer_tables_details = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_search_table = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_search_item = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_tables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tables);

        tbl_customer_tables_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_customer_tables_details);

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("SEARCH:");

        tf_search_table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search_table.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_search_tableKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("SEARCH:");

        tf_search_item.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search_item.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(tf_search_table, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(tf_search_item)
                        .addGap(22, 22, 22)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tf_search_table, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tf_search_item, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_search_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_search_tableKeyReleased
        data_cols();
    }//GEN-LAST:event_tf_search_tableKeyReleased

    private void tbl_tablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseClicked
        selected = 1;
        data_orders();
    }//GEN-LAST:event_tbl_tablesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        delete_to_customer_tables_details();
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_customer_tables_details;
    private javax.swing.JTable tbl_tables;
    private javax.swing.JTextField tf_search_item;
    private javax.swing.JTextField tf_search_table;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_casablanca");
        init_key();
        init_tbl_tables();
        data_cols();

        init_tbl_customer_tables_details();
    }

    public void do_pass(String table_id) {
        tf_search_table.setText(table_id);
        data_cols();
    }
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_tables_ALM;
    private TbltablesModel tbl_tables_M;

    private void init_tbl_tables() {
        tbl_tables_ALM = new ArrayListModel();
        tbl_tables_M = new TbltablesModel(tbl_tables_ALM);
        tbl_tables.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_tables.setModel(tbl_tables_M);
        tbl_tables.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_tables.setRowHeight(25);
        int[] tbl_widths_tables = {0, 100, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_tables.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_tables, i, tbl_widths_tables[i]);
        }
        Dimension d = tbl_tables.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_tables.getTableHeader().
                setPreferredSize(d);
        tbl_tables.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_tables.setRowHeight(35);
        tbl_tables.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_tables(List<to_tables> acc) {
        tbl_tables_ALM.clear();
        tbl_tables_ALM.addAll(acc);
    }

    public static class TbltablesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "TABLE", "rate", "rate_type", "percentage", "status"
        };

        public TbltablesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return false;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_tables tt = (to_tables) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.table_name;
                case 2:
                    return tt.rate;
                case 3:
                    return tt.rate_type;
                case 4:
                    return tt.percentage;
                default:
                    return tt.status;
            }
        }
    }

    private void data_cols() {
        String search_table = tf_search_table.getText();
        loadData_tables(S1_void_table_orders.ret_table(search_table));
    }
    private ArrayListModel tbl_customer_tables_details_ALM;
    private Tblcustomer_tables_detailsModel tbl_customer_tables_details_M;

    private void init_tbl_customer_tables_details() {
        tbl_customer_tables_details_ALM = new ArrayListModel();
        tbl_customer_tables_details_M = new Tblcustomer_tables_detailsModel(tbl_customer_tables_details_ALM);
        tbl_customer_tables_details.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_customer_tables_details.setModel(tbl_customer_tables_details_M);
        tbl_customer_tables_details.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_customer_tables_details.setRowHeight(25);
        int[] tbl_widths_customer_tables_details = {0, 0, 0, 100, 0, 100, 100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_customer_tables_details.length; i < n; i++) {
            if (i == 5) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_customer_tables_details, i, tbl_widths_customer_tables_details[i]);
        }
        Dimension d = tbl_customer_tables_details.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_customer_tables_details.getTableHeader().
                setPreferredSize(d);
        tbl_customer_tables_details.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_customer_tables_details.setRowHeight(35);
        tbl_customer_tables_details.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_customer_tables_details(List<S1_void_table_orders.to_customer_tables_details> acc) {
        tbl_customer_tables_details_ALM.clear();
        tbl_customer_tables_details_ALM.addAll(acc);
    }

    public static class Tblcustomer_tables_detailsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "table_no_id", "or_no", "QTY", "product_name", "DESCRIPTION", "PRICE", "img_path", "status", "guest_id", "guest_name", "cat_id", "date_added", "printing_assembly"
        };

        public Tblcustomer_tables_detailsModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S1_void_table_orders.to_customer_tables_details tt = (S1_void_table_orders.to_customer_tables_details) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.table_no_id;
                case 2:
                    return tt.or_no;
                case 3:
                    return tt.qty;
                case 4:
                    return tt.product_name;
                case 5:
                    return tt.description;
                case 6:
                    return tt.price;
                case 7:
                    return tt.img_path;
                case 8:
                    return tt.status;
                case 9:
                    return tt.guest_id;
                case 10:
                    return tt.guest_name;
                case 11:
                    return tt.cat_id;
                case 12:
                    return tt.date_added;
                default:
                    return tt.printing_assembly;
            }
        }
    }
    int selected = 0;

    private void data_orders() {
        if (selected == 0) {
        } else {
            int idx = tbl_tables.getSelectedRow();
            if (idx < 0) {
                return;
            }
            String order = tf_search_item.getText();
            final to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.
                    convertRowIndexToModel(idx));
            loadData_customer_tables_details(S1_void_table_orders.ret_data("" + to.id, order));
        }
    }

    private void delete_to_customer_tables_details() {
        int[] idx = tbl_customer_tables_details.getSelectedRows();
//        JOptionPane.showMessageDialog(null, idx.length);
        if (idx.length == 0) {
            return;
        }
        List<S1_void_table_orders.to_customer_tables_details> rem = new ArrayList();
        for (int ix : idx) {
            if (tbl_customer_tables_details.isRowSelected(ix)) {
                final S1_void_table_orders.to_customer_tables_details to = (S1_void_table_orders.to_customer_tables_details) tbl_customer_tables_details_ALM.
                        get(tbl_customer_tables_details.convertRowIndexToModel(ix));
                rem.add(to);
            }
        }

        S1_void_table_orders.delete_data(rem);
//        selected = 0;
//       
        data_orders();
        data_cols();
//        tbl_customer_tables_details_ALM.removeAll(rem);
        Prompt.call("Order Cancelled");
        tbl_customer_tables_details_M.fireTableDataChanged();
        ok1();
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
