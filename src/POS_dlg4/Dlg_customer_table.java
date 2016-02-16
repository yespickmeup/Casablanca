/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_dlg4;

import POS.utl.TableUtility;
import POS_svc4.S5_customer_tables;
import POS_to4.to_customer_table;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.*;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;


/**
 *
 * @author i1
 */
public class Dlg_customer_table extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_table
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void order(CloseDialog closeDialog, OutputData data);

        void pay(CloseDialog closeDialog, OutputData data);

        void add_order(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final String table_no;

        public OutputData(String table_no) {
            this.table_no = table_no;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_customer_table(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_customer_table(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_customer_table() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_customer_table myRef;

    private void setThisRef(Dlg_customer_table myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customer_table> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customer_table create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_customer_table create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customer_table dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_table((java.awt.Frame) parent, false);
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
            Dlg_customer_table dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_table((java.awt.Dialog) parent, false);
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


        Dlg_customer_table dialog = Dlg_customer_table.create(new javax.swing.JFrame(), true);
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

        pm_pop = new javax.swing.JPopupMenu();
        btn_add = new javax.swing.JMenuItem();
        btn_order = new javax.swing.JMenuItem();
        btn_pay = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tables = new javax.swing.JTable();

        btn_add.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_add.setText("ADD ORDER");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        pm_pop.add(btn_add);

        btn_order.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_order.setText("ORDER");
        btn_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orderActionPerformed(evt);
            }
        });
        pm_pop.add(btn_order);

        btn_pay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_pay.setText("PAY");
        btn_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_payActionPerformed(evt);
            }
        });
        pm_pop.add(btn_pay);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(java.awt.Color.white);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "TABLE NO.", "TIME", "AMOUNT", "OR No.", "STATUS"
            }
        ));
        tbl_tables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_tablesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_tablesMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbl_tablesMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tables);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1177, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_tablesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseExited
        // TODO add your handling code here:
        t.start();
    }//GEN-LAST:event_tbl_tablesMouseExited

    private void tbl_tablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseClicked
        // TODO add your handling code here:
//        do_pay();
    }//GEN-LAST:event_tbl_tablesMouseClicked

    private void tbl_tablesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMousePressed
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_tablesMousePressed

    private void tbl_tablesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseReleased
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_tablesMouseReleased

    private void btn_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orderActionPerformed
        // TODO add your handling code here
        ok_order();
    }//GEN-LAST:event_btn_orderActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        ok_add_order();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_payActionPerformed
        // TODO add your handling code here:
        ok_pay();
    }//GEN-LAST:event_btn_payActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
//        ok_order();
    }//GEN-LAST:event_formWindowClosing
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btn_add;
    private javax.swing.JMenuItem btn_order;
    private javax.swing.JMenuItem btn_pay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu pm_pop;
    private javax.swing.JTable tbl_tables;
    // End of variables declaration//GEN-END:variables
    int g = -1;

    private void myInit() {
        init_key();

        init_tbl_baptism();
        data_employee();
        t.start();
        init_auto_scroll();
    }
    Timer t = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            data_employee();
            t.stop();
        }
    });

    private void pm_tbl_users(MouseEvent evt) {

        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }
        g = row;
        String available = tbl_tables.getModel().getValueAt(row, 4).toString();
        if (available.equals("AVAILABLE")) {
//            btn_order.setText("ORDER");
            btn_add.setVisible(false);
            btn_order.setVisible(true);
            btn_pay.setVisible(false);
        } else {
//            btn_add.setText("ADD ORDER");
            btn_add.setVisible(true);
            btn_pay.setVisible(true);
            btn_order.setVisible(false);
//            btn_order.setText("PAY");

        }
        if (evt.isPopupTrigger()) {
            pm_pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    public void do_pass() {
        g = 0;
        data_employee();
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
//                disposed();
            }
        });
    }
    // </editor-fold>
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_auto_scroll() {
//        tbl_tables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        ComponentDragScrollListener l = new ComponentDragScrollListener(tbl_tables);
//        tbl_tables.addMouseMotionListener(l);
//        tbl_tables.addMouseListener(l);
//        tbl_tables.addHierarchyListener(l);
    }

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);



        tbl_tables.setModel(tbl_employee_payroll_M);
        tbl_tables.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_tables.setRowHeight(25);

//        tbl_tables.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {100, 0, 100, 0, 100, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0 || i==4) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_tables, i, tbl_widths_accounts[i]);
        }
        
//        TableWidthUtilities.setColumnCenterRenderer(tbl_tables, 0);
////        TableWidthUtilities.setColumnCenterRenderer(tbl_tables, 1);
//        TableWidthUtilities.setColumnCenterRenderer(tbl_tables, 2);
////        TableWidthUtilities.setColumnCenterRenderer(tbl_tables, 3);
//        TableWidthUtilities.setColumnCenterRenderer(tbl_tables, 4);

        tbl_tables.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 15));

        tbl_tables.setRowHeight(50);
//         tbl_tables.setCHeight(50);
        tbl_tables.setFont(new java.awt.Font("Arial", 1, 15));
        TableUtility.align_column_to_Center(tbl_tables, 0);

        TableUtility.align_column_to_Center(tbl_tables, 4);
    }

    private void loadData_baptism(List<to_customer_table.tables> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "TABLE", "TIME", "AMOUNT", "OR NO", "STATUS", "id"
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
            to_customer_table.tables tt = (to_customer_table.tables) getRow(row);

            switch (col) {
                case 0:
                    return tt.table_no;
                case 1:
                    return tt.time;
                case 2:
                    if(tt.amount==0.00){
                        return "- - -";
                    }else{
                        return tt.amount;
                    }
                    
                case 3:
                    return tt.or_no;
                case 4:
                    return tt.status;

                default:
                    return tt.id;
            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
        loadData_baptism(S5_customer_tables.get_customer_tables());
    }

    private void do_pay() {
//        JOptionPane.showMessageDialog(null, g);
    }

    private void ok_order() {
        String tbl_no = tbl_tables.getModel().getValueAt(g, 0).toString();
        
        if (callback != null) {
            callback.order(new CloseDialog(this), new OutputData(tbl_no));
        }
    }

    private void ok_pay() {
        String tbl_no = tbl_tables.getModel().getValueAt(g, 0).toString();
        if (callback != null) {
            callback.pay(new CloseDialog(this), new OutputData(tbl_no));
        }
    }

    private void ok_add_order() {
        String tbl_no = tbl_tables.getModel().getValueAt(g, 0).toString();
        if (callback != null) {
            callback.add_order(new CloseDialog(this), new OutputData(tbl_no));
        }
    }
}
