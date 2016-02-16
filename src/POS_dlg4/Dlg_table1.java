/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_dlg4;

import POS.Main;
import POS.dlg2.Dlg_confirm;
import POS.utl.Center;
import POS.utl.TableUtility;
import POS_svc4.S5_tables;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_table1 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_table
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
    private Dlg_table1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_table1(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_table1() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_table1 myRef;

    private void setThisRef(Dlg_table1 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_table1> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_table1 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_table1 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_table1 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_table1((java.awt.Frame) parent, false);
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
            Dlg_table1 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_table1((java.awt.Dialog) parent, false);
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


        Dlg_table1 dialog = Dlg_table1.create(new javax.swing.JFrame(), true);
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

        pm_po = new javax.swing.JPopupMenu();
        jcb_enable = new javax.swing.JCheckBoxMenuItem();
        jcb_disable = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tables = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        lbl_name = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jcb_enable.setText("ACTIVE");
        jcb_enable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_enableActionPerformed(evt);
            }
        });
        pm_po.add(jcb_enable);

        jcb_disable.setText("INACTIVE");
        jcb_disable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_disableActionPerformed(evt);
            }
        });
        pm_po.add(jcb_disable);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbl_tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "TABLE", "NO."
            }
        ));
        tbl_tables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_tablesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_tablesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tables);

        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbl_name.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name.setText("TABLES");
        lbl_name.setOpaque(true);

        jButton3.setText("EDIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("TYPES");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lbl_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_name, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_tablesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMousePressed
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_tablesMousePressed

    private void tbl_tablesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseReleased
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_tablesMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        do_add_table();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        do_edit_table();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        do_delete_table();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        types();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jcb_enableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_enableActionPerformed
        update_table_status_enable();
    }//GEN-LAST:event_jcb_enableActionPerformed

    private void jcb_disableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_disableActionPerformed
        update_table_status_disable();
    }//GEN-LAST:event_jcb_disableActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBoxMenuItem jcb_disable;
    private javax.swing.JCheckBoxMenuItem jcb_enable;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JPopupMenu pm_po;
    private javax.swing.JTable tbl_tables;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        if (System.getProperty("version", "resto").
                equals("resto")) {
//            lbl_name.setText("ROOM MANAGEMENT");
        }
        init_key();
        init_tbl_baptism();
        data_employee();
        init_auto_scroll();
    }

    private void pm_tbl_users(MouseEvent evt) {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String no = tbl_tables.getModel().
                getValueAt(row, 1).
                toString();
        final String status = tbl_tables.getModel().
                getValueAt(row, 5).
                toString();
//        JOptionPane.showMessageDialog(null, status);
        if (status.equals("ACTIVE")) {
            jcb_enable.setSelected(true);
            jcb_disable.setSelected(false);
        } else {
            jcb_disable.setSelected(true);
            jcb_enable.setSelected(false);
        }
        if (evt.isPopupTrigger()) {

            pm_po.show(evt.getComponent(), evt.getX(), evt.getY());

        }
    }

    private void init_auto_scroll() {
//        tbl_tables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        ComponentDragScrollListener l = new ComponentDragScrollListener(tbl_tables);
//        tbl_tables.addMouseMotionListener(l);
//        tbl_tables.addMouseListener(l);
//        tbl_tables.addHierarchyListener(l);
    }

    public void do_pass() {
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
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);


        tbl_tables.setModel(tbl_employee_payroll_M);
        tbl_tables.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_tables.setRowHeight(25);

//        tbl_tables.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {200, 0, 100, 100, 100, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_tables, i, tbl_widths_accounts[i]);

//          TableWidthUtilities.
//          TableWidthUtilities.
        }
        tbl_tables.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_tables.setRowHeight(30);
        tbl_tables.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        TableUtility.align_row_to_Center(tbl_tables, 0);

    }

    private void loadData_baptism(List<S5_tables.to_tables2> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "TABLES", "No", "RATE", "Rate Type", "Percentage", "STATUS"
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
            S5_tables.to_tables2 tt = (S5_tables.to_tables2) getRow(row);

            switch (col) {
                case 0:
                    return tt.name;
                case 1:
                    return tt.no;
                case 2:
                    return FitIn.fmt_wc_0(tt.rate);
                case 3:
                    return tt.rate_type;
                case 4:
                    return tt.percentage;
                default:
                    return tt.state;
            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();

        loadData_baptism(S5_tables.get_tables3());
    }

    private void do_add_table() {
        Window p = (Window) this;
        Dlg_name_w_rate_percent nd = Dlg_name_w_rate_percent.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_name_w_rate_percent.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_name_w_rate_percent.OutputData data) {
                closeDialog.ok();
                add_table(data.name, data.rate, data.type, data.percent);
                data_employee();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_table(String name, double rate, String type, double percent) {
        S5_tables.add3(name, rate, type, percent);
    }

    private void do_edit_table() {

        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        final String no = tbl_tables.getModel().
                getValueAt(row, 1).
                toString();
        final String rate = tbl_tables.getModel().
                getValueAt(row, 2).
                toString();
        final String type = tbl_tables.getModel().
                getValueAt(row, 3).
                toString();
        final String percent = tbl_tables.getModel().
                getValueAt(row, 4).
                toString();
        Window p = (Window) this;
        Dlg_name_w_rate_percent nd = Dlg_name_w_rate_percent.create(p, true);
        nd.setTitle("");
        nd.do_pass2(name, rate, type, percent,"");
        nd.setCallback(new Dlg_name_w_rate_percent.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_name_w_rate_percent.OutputData data) {
                closeDialog.ok();
                edit_table(data.name, no, data.rate, data.type, data.percent);
                data_employee();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void edit_table(String name, String no, double rate, String type, double percent) {
        S5_tables.edit3(name, no, rate, type, percent);
    }

    private void update_table_status_enable() {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String no = tbl_tables.getModel().
                getValueAt(row, 1).
                toString();

        S5_tables.update_table_status3(no, "0");
        data_employee();
    }

    private void update_table_status_disable() {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String no = tbl_tables.getModel().
                getValueAt(row, 1).
                toString();

        S5_tables.update_table_status3(no, "1");
        data_employee();
    }

    private void do_delete_table() {

        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String name = tbl_tables.getModel().
                getValueAt(row, 0).
                toString();
        final String no = tbl_tables.getModel().
                getValueAt(row, 1).
                toString();
        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//        nd.do_pass2(name);
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                delete_table(no);
                data_employee();
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void delete_table(String no) {
        S5_tables.delete3(no);
    }

    private void types() {

        Window p = (Window) this;
        Dlg_table_types nd = Dlg_table_types.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_table_types.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_table_types.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
}
