/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_dlg4;

import POS_svc3.S2_cashiers;
import POS_svc3.S2_cashiers.to_cashiers;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.*;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.HelpScrollToView;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author i1
 */
public class Dlg_cashiers extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_cashiers
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

        public final List<S2_cashiers.to_cashiers> t;

        public OutputData(List<to_cashiers> t) {
            this.t = t;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_cashiers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_cashiers(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_cashiers() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_cashiers myRef;

    private void setThisRef(Dlg_cashiers myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_cashiers> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_cashiers create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_cashiers create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_cashiers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashiers((java.awt.Frame) parent, false);
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
            Dlg_cashiers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cashiers((java.awt.Dialog) parent, false);
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


        Dlg_cashiers dialog = Dlg_cashiers.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cashier = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));

        tbl_cashier.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_cashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cashierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cashier);

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        jButton2.setText("CANCEL");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(489, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_cashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cashierMouseClicked
        // TODO add your handling code here:
//        changeSelection(1, 0, false, false);
        do_check();
    }//GEN-LAST:event_tbl_cashierMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_cashier;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_baptism();
        data_employee();
        InputMap inputMap = tbl_cashier.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK);
        inputMap.put(keyStroke, "none");
    }

    private void ctrl() {
        Toolkit tool = Toolkit.getDefaultToolkit();
//        tool.
    }

    public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
//        tbl_cashier.changeSelection(rowIndex, columnIndex, true, false);
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

        tbl_cashier.setRowSelectionAllowed(true);

        tbl_cashier.setModel(tbl_employee_payroll_M);
        tbl_cashier.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_cashier.setRowHeight(25);

//        tbl_cashier.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {100, 0, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cashier, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        tbl_cashier.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_cashier.setRowHeight(45);
        tbl_cashier.setFont(new java.awt.Font("Arial", 1, 12));



    }

    private void loadData_baptism(List<S2_cashiers.to_cashiers> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "NAME", "id", ""
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

            if (col == 2) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S2_cashiers.to_cashiers tt = (S2_cashiers.to_cashiers) getRow(row);

            switch (col) {
                case 0:
                    return tt.cashier_name;
                case 1:
                    return tt.id;

                default:
                    return tt.check;
            }
        }
    }

    private void do_check() {
        int row = tbl_cashier.getSelectedRow();
        if (row < 0) {
            return;
        }
        boolean check = Boolean.parseBoolean(tbl_cashier.getModel().getValueAt(row, 2).toString());

        if (check == false) {
            check = true;
        } else {
            check = false;
        }

        S2_cashiers.to_cashiers order = (S2_cashiers.to_cashiers) tbl_employee_payroll_ALM.get(tbl_cashier.convertRowIndexToModel(row));
        order.setCheck(check);

        tbl_employee_payroll_M.fireTableDataChanged();

        tbl_cashier.getSelectionModel().setSelectionInterval(row, row);
        HelpScrollToView.view(row, tbl_cashier);

    }

    private void set() {
//        int row=tbl_cashier.getSelectedRow();
//        if(row<0){
//            return;
//        }
//        if(tbl_cashier.isRowSelected(row)){
//              tbl_cashier.addRowSelectionInterval(0, row);
//        }else{
//            tbl_cashier.removeRowSelectionInterval(0, row);
//        }
////        tbl_cashier.repaint();
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
        loadData_baptism(S2_cashiers.get_cashiers());
    }

    private void ok1() {
        int row = tbl_cashier.getSelectedRow();
        if (row < 0) {
            return;
        }

        int[] idx = tbl_cashier.getSelectedRows();

        List<S2_cashiers.to_cashiers> rem = new ArrayList();

//        for (int ix : idx) {
//            if (tbl_cashier.isRowSelected(ix)) {
//                String name = tbl_cashier.getModel().getValueAt(ix, 0).toString();
//                String id = tbl_cashier.getModel().getValueAt(ix, 1).toString();
//                S2_cashiers.to_cashiers to = new S2_cashiers.to_cashiers(name, id, false);
//                rem.add(to);
////                rem.add(tbl_employee_payroll_ALM.get(mx));
//            }
//        }
//        if (callback != null) {
//            callback.ok(new CloseDialog(this), new OutputData(rem));
//        }

        List<S2_cashiers.to_cashiers> datas = tbl_employee_payroll_ALM;


        for (S2_cashiers.to_cashiers to : datas) {

            boolean ch = to.check;
            if (ch == true) {
                String name = to.cashier_name;
                System.out.println(name);
                String id = to.id;
                S2_cashiers.to_cashiers to1 = new S2_cashiers.to_cashiers(name, id, false);
                rem.add(to1);
            }


        }
         if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(rem));
        }
//        tbl_employee_payroll_ALM.removeAll(rem);
//        tbl_employee_payroll_M.fireTableDataChanged();
    }
}
