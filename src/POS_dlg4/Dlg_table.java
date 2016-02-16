/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_dlg4;

import POS.Main;
import POS.dlg2.Dlg_confirm;
import POS.table_location.Dlg_table_location;
import POS.table_location.S1_table_location;
import POS.utl.Center;
import POS.utl.TableUtility;
import POS_svc4.S5_tables;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_table extends javax.swing.JDialog {

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
    private Dlg_table(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_table(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_table() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_table myRef;

    private void setThisRef(Dlg_table myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_table> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_table create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_table create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_table dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_table((java.awt.Frame) parent, false);
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
            Dlg_table dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_table((java.awt.Dialog) parent, false);
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dlg_table dialog = Dlg_table.create(new javax.swing.JFrame(), true);
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
        m_location = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tables = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        lbl_name = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

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

        m_location.setText("LOCATION");
        pm_po.add(m_location);

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

        jButton6.setText("TABLES");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("LOCATION");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        tables();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        table_location();
    }//GEN-LAST:event_jButton7ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBoxMenuItem jcb_disable;
    private javax.swing.JCheckBoxMenuItem jcb_enable;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JMenu m_location;
    private javax.swing.JPopupMenu pm_po;
    private javax.swing.JTable tbl_tables;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        jButton6.setVisible(false);
//        Main.MyDB.setNames("db_pos_casablanca");
        if (System.getProperty("version", "resto").
                equals("resto")) {
            lbl_name.setText("ROOM MANAGEMENT");
//            jButton6.setVisible(true);jButton6
        }
        init_locations();
        init_key();
        init_tbl_baptism();
        data_employee();
        init_auto_scroll();



    }

    private void init_locations() {
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

        m_location.removeAll();
        List<S1_table_location.to_table_locations> locations = S1_table_location.ret_locations();

        for (final S1_table_location.to_table_locations s : locations) {
            final JCheckBoxMenuItem locate = new JCheckBoxMenuItem();
            locate.setText(s.location);
            int idx = tbl_tables.getSelectedRow();
            if (idx < 0) {
                return;
            }
            final S5_tables.to_tables2 to = (S5_tables.to_tables2) tbl_employee_payroll_ALM.get(tbl_tables.convertRowIndexToModel(idx));
            if (to.table_location_id == s.id) {
                locate.setSelected(true);
            } else {
                locate.setSelected(false);
            }
            locate.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    update_table_location(to.no, "" + s.id);
                }
            });
            m_location.add(locate);
        }


    }

    private void update_table_location(String table_id, String location_id) {
//        JOptionPane.showMessageDialog(null, table_id + " "+location_id);
        S5_tables.update_table_location_id(table_id, location_id);
        data_employee();
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
        int[] tbl_widths_accounts = {200, 0, 100, 100, 100, 100, 0};

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
            "ROOMS", "No", "RATE", "Rate Type", "Percentage", "STATUS", "table_location_id"
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
            case 5:
                return tt.state;
            default:
                return tt.table_location_id;
            }
        }
    }

    private void update_location() {
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();

        loadData_baptism(S5_tables.get_tables2());
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
                add_table(data.name, data.rate, data.type, data.percent, data.location);
                data_employee();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_table(String name, double rate, String type, double percent, String location_id) {
        S5_tables.add(name, rate, type, percent, location_id);
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
        final String location = S1_table_location.ret_location_name(tbl_tables.getModel().
                getValueAt(row, 6).
                toString());
        Window p = (Window) this;
        Dlg_name_w_rate_percent nd = Dlg_name_w_rate_percent.create(p, true);
        nd.setTitle("");
        nd.do_pass2(name, rate, type, percent, location);
        nd.setCallback(new Dlg_name_w_rate_percent.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_name_w_rate_percent.OutputData data) {
                closeDialog.ok();
                edit_table(data.name, no, data.rate, data.type, data.percent, data.location);
                data_employee();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void edit_table(String name, String no, double rate, String type, double percent, String location_id) {
        S5_tables.edit(name, no, rate, type, percent, location_id);
    }

    private void update_table_status_enable() {
        int row = tbl_tables.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String no = tbl_tables.getModel().
                getValueAt(row, 1).
                toString();

        S5_tables.update_table_status(no, "0");
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

        S5_tables.update_table_status(no, "1");
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
        S5_tables.delete(no);
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

    private void tables() {
        Window p = (Window) this;
        Dlg_table1 nd = Dlg_table1.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_table1.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_table1.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void table_location() {
        Window p = (Window) this;
        Dlg_table_location nd = Dlg_table_location.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_table_location.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_table_location.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
}
