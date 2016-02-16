/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg2;

import POS.rpt2.rpt_barcode;
import POS.rpt_liquid.Srpt_liquid;
import POS_svc4.S2_search;
import POS_to4.to_barcode;
import POS_to4.to_search_prod;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.Executor;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Dummy
 */
public class Dlg_search_product extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_search_product
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

        public final String name;
        public final String price;
        public final String qty;

        public OutputData(String name, String price, String qty) {
            this.name = name;
            this.price = price;
            this.qty = qty;
        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_search_product(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_search_product(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_search_product() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_search_product myRef;

    private void setThisRef(Dlg_search_product myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_search_product> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_search_product create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_search_product create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_search_product dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_search_product((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_search_product dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_search_product((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dlg_search_product dialog = Dlg_search_product.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
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

        pm_items = new javax.swing.JPopupMenu();
        add = new javax.swing.JMenuItem();
        pm_barcode = new javax.swing.JPopupMenu();
        DELETE = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_add_barcode = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_search = new javax.swing.JTable();

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        pm_items.add(add);

        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        pm_barcode.add(DELETE);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("SEARCH:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, 30));

        tf_search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_searchKeyTyped(evt);
            }
        });
        jPanel1.add(tf_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 470, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add32x32.png"))); // NOI18N
        jButton1.setText("ADD");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 110, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/print32X32.png"))); // NOI18N
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, -1, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close32x32.png"))); // NOI18N
        jButton3.setText("CLOSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 90, 110, 40));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("INVENTORY");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1220, 60));

        tbl_add_barcode.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "PRODUCT CODE", "DESCRIPTION"
            }
        ));
        tbl_add_barcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_add_barcodeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_add_barcodeMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_add_barcode);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 520, 480));

        tbl_search.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PRODUCT NAME", "DESCRIPTION", "PRICE", "QUANTITY"
            }
        ));
        tbl_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_searchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_searchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_searchMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_search);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 670, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_searchKeyTyped

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_employee();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_searchMouseClicked
        // TODO add your handling code here:
//        ok1();
    }//GEN-LAST:event_tbl_searchMouseClicked

    private void tbl_searchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_searchMousePressed
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_searchMousePressed

    private void tbl_searchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_searchMouseReleased
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_searchMouseReleased

    private void tbl_add_barcodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_add_barcodeMousePressed
        // TODO add your handling code here:
        pm_tbl_barcode(evt);
    }//GEN-LAST:event_tbl_add_barcodeMousePressed

    private void tbl_add_barcodeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_add_barcodeMouseReleased
        // TODO add your handling code here:
        pm_tbl_barcode(evt);
    }//GEN-LAST:event_tbl_add_barcodeMouseReleased

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        data_barcode();
    }//GEN-LAST:event_addActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        // TODO add your handling code here:\
        do_remove();
    }//GEN-LAST:event_DELETEActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        do_print_code();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DELETE;
    private javax.swing.JMenuItem add;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu pm_barcode;
    private javax.swing.JPopupMenu pm_items;
    private javax.swing.JTable tbl_add_barcode;
    private javax.swing.JTable tbl_search;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        init_tbl_baptism();
        data_employee();
        init_tbl_barcode();
    }
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);


        tbl_search.setModel(tbl_employee_payroll_M);
        tbl_search.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_search.setRowHeight(25);

//        tbl_search.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {200, 300, 100, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_search, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        tbl_search.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_search.setRowHeight(35);
        tbl_search.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_baptism(List<to_search_prod> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "PRODUCT CODE", "DESCRIPTION", "UNIT COST", "QTY"
        };

        public TblInvoicesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_search_prod tt = (to_search_prod) getRow(row);

            switch (col) {
            case 0:
                return tt.name;
            case 1:
                return tt.desc;
            case 2:
                return tt.price;


            default:
                return tt.qty;
            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();
        String name = tf_search.getText();
        if (name.isEmpty() || name.equals("")) {
            tbl_employee_payroll_ALM.clear();
            tbl_employee_payroll_M.fireTableDataChanged();
            return;
        }
        loadData_baptism(S2_search.ret_product(name));
    }

    private void do_input() {
    }

    private void ok1() {
        int row = tbl_search.getSelectedRow();
        if (row < 0) {
            return;
        }
        if (tf_search.getText().isEmpty()) {
            return;
        }
        String name = tbl_search.getModel().getValueAt(row, 0).toString();
        String price = tbl_search.getModel().getValueAt(row, 2).toString();
        String qty = tbl_search.getModel().getValueAt(row, 3).toString();

//        JOptionPane.showMessageDialog(null, name+ price+qty);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(name, price, qty));
        }
    }
    private ArrayListModel tbl_barcode_ALM;
    private TblbarcodeModel tbl_barcode_M;
////    

    private void init_tbl_barcode() {
        tbl_barcode_ALM = new ArrayListModel();
        tbl_barcode_M = new TblbarcodeModel(tbl_barcode_ALM);


        tbl_add_barcode.setModel(tbl_barcode_M);
        tbl_add_barcode.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_add_barcode.setRowHeight(25);

//        tbl_add_barcode.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {200, 300, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_add_barcode, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        tbl_add_barcode.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_add_barcode.setRowHeight(35);
        tbl_add_barcode.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_barcode(List<to_barcode> acc) {
//        tbl_barcode_ALM.clear();
        tbl_barcode_ALM.addAll(acc);
    }

    public static class TblbarcodeModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "CODE", "DESCRIPTION", "PRICE"
        };

        public TblbarcodeModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_barcode tt = (to_barcode) getRow(row);

            switch (col) {
            case 0:
                return tt.code;
            case 1:
                return tt.desc;

            default:
                return tt.price;
            }
        }
    }

    private void data_barcode() {
        int row = tbl_search.getSelectedRow();
        if (row < 0) {
            return;
        }
        String code = tbl_search.getModel().getValueAt(row, 0).toString();
        String name = tbl_search.getModel().getValueAt(row, 1).toString();
        double price = Double.parseDouble(tbl_search.getModel().getValueAt(row, 2).toString());
//        String date = lb_date_baptism.getText();
//        JOptionPane.showMessageDialog(null, code+ " " +name);
        loadData_barcode(to_barcode.set(code, name, tbl_barcode_ALM, price));
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_items.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void pm_tbl_barcode(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_barcode.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void do_remove() {
        int[] idx = tbl_add_barcode.getSelectedRows();

        List rem = new ArrayList();
        for (int ix : idx) {
            if (tbl_add_barcode.isRowSelected(ix)) {
                int mx = tbl_add_barcode.convertRowIndexToModel(ix);
                rem.add(tbl_barcode_ALM.get(mx));
            }
        }

        tbl_barcode_ALM.removeAll(rem);
        tbl_barcode_M.fireTableDataChanged();
    }

    private void do_print_code() {

        if (tbl_barcode_ALM.isEmpty()) {
            return;
        }
        final String name = System.getProperty("entityName", "Synapse Software Technologies");
//        Executor.doExecute(this, new Executor.Task() {
//
//            @Override
//            public void work_on() {
        JRViewer viewer = rpt_barcode.get_viewer_conn("", tbl_barcode_ALM);
        JFrame f = Application.launchMainFrame3(viewer, "", true);
//        rpt_barcode.print_barcode2(name, tbl_barcode_ALM);
//              disposed();
//            }
//        });
    }

    private void disposed() {
        this.dispose();
    }
}
