/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg3;

import POS.Main.MyDB;
import POS.dlg.Dlg_quantity1;
import POS.dlg2.Dlg_confirm;
import POS.dlg2.dlg_keyboard;
import POS.svc4.S2_customers;
import POS.svc4.S2_customers.to_cust_charges;
import POS.to.to_users;
import POS.to2.to_credit;
import POS.utl.Center;
import POS.utl.NumType;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Dummy
 */
public class Dlg_customer_charges extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_customer_charges
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
        public final String address;
        public final String con;
        public final to_credit to;
        public final String payment_mode;
        public final String member_id;

        public OutputData(String name, String address, String con, to_credit to, String payment_mode, String member_id) {
            this.name = name;
            this.address = address;
            this.con = con;
            this.to = to;
            this.payment_mode = payment_mode;
            this.member_id = member_id;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_customer_charges(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_customer_charges(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_customer_charges() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_customer_charges myRef;

    private void setThisRef(Dlg_customer_charges myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customer_charges> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customer_charges create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_customer_charges create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customer_charges dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_charges((java.awt.Frame) parent, false);
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
            Dlg_customer_charges dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_charges((java.awt.Dialog) parent, false);
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


        Dlg_customer_charges dialog = Dlg_customer_charges.create(new javax.swing.JFrame(), true);
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

        pm_table = new javax.swing.JPopupMenu();
        pay = new javax.swing.JMenuItem();
        pm_cust = new javax.swing.JPopupMenu();
        Edit = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Delete = new javax.swing.JMenuItem();
        pop_balance = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cust = new javax.swing.JTable();
        tf_search = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_total = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_charges = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        btn_ok1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dp_year = new com.toedter.calendar.JYearChooser();

        pay.setText("PAY");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        pm_table.add(pay);

        Edit.setText("EDIT");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        pm_cust.add(Edit);
        pm_cust.add(jSeparator1);

        Delete.setText("DELETE");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        pm_cust.add(Delete);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(159, 207, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SEARCH CUSTOMER:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 117, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tbl_cust.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CUSTOMER NAME", "num"
            }
        ));
        tbl_cust.setRowHeight(30);
        tbl_cust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_custMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_custMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_custMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cust);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 204, 626, 510));

        tf_search.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_searchMouseClicked(evt);
            }
        });
        tf_search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tf_searchMouseDragged(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });
        jPanel2.add(tf_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 152, 626, 46));

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add32x32.png"))); // NOI18N
        btn_add.setText("ADD");
        btn_add.setFocusable(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 112, 125, 34));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("TOTAL CHARGES:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 163, -1, 35));

        tf_total.setBackground(new java.awt.Color(0, 0, 0));
        tf_total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_total.setForeground(java.awt.Color.green);
        tf_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_total.setText("0.00");
        tf_total.setOpaque(true);
        jPanel2.add(tf_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 160, 360, 35));

        tbl_charges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "OR NUMBER", "AMOUNT"
            }
        ));
        tbl_charges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_chargesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_chargesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_charges);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 204, 526, 510));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("MEMBERS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 1254, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 1258, -1));

        btn_ok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        btn_ok1.setBorderPainted(false);
        btn_ok1.setContentAreaFilled(false);
        btn_ok1.setFocusable(false);
        btn_ok1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ok1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1188, 392, 59, 50));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(41, 9, 149));
        jLabel13.setText("OK");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1206, 448, 30, -1));

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(149, 9, 12));
        jLabel14.setText("(ENTER)");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1188, 467, 70, -1));

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(149, 9, 12));
        jLabel16.setText("(ESCAPE)");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1186, 592, -1, 20));

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(41, 9, 149));
        jLabel15.setText("CLOSE");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1198, 571, 60, 20));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setFocusable(false);
        btn_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel2.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1198, 518, 60, 51));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("DATE:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 111, 70, 35));
        jPanel2.add(dp_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 101, 31));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_employee();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        add_customer();
    }//GEN-LAST:event_btn_addActionPerformed

    private void tbl_custMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_custMouseClicked
        // TODO add your handling code here:
        data_charges(evt);
    }//GEN-LAST:event_tbl_custMouseClicked

    private void tbl_chargesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chargesMousePressed
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_chargesMousePressed

    private void tbl_chargesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chargesMouseReleased
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_chargesMouseReleased

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
        do_pay();
    }//GEN-LAST:event_payActionPerformed

    private void tbl_custMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_custMousePressed
        // TODO add your handling code here:
        pm_tbl_customers(evt);
    }//GEN-LAST:event_tbl_custMousePressed

    private void tbl_custMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_custMouseReleased
        // TODO add your handling code here:
        pm_tbl_customers(evt);
    }//GEN-LAST:event_tbl_custMouseReleased

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:

        edit_customer();
    }//GEN-LAST:event_EditActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        delete_cust();
    }//GEN-LAST:event_DeleteActionPerformed

    private void btn_ok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ok1ActionPerformed
//        do_ok();
        ok1();
    }//GEN-LAST:event_btn_ok1ActionPerformed

    private void tf_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseClicked
        // TODO add your handling code here:
        keyboard(tf_search);
    }//GEN-LAST:event_tf_searchMouseClicked

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
//    clear_field();
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void tf_searchMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseDragged
        // TODO add your handling code here:
        keyboard(tf_search);
    }//GEN-LAST:event_tf_searchMouseDragged
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem Edit;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_ok1;
    private com.toedter.calendar.JYearChooser dp_year;
    private javax.swing.JLabel ds_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem pay;
    private javax.swing.JPopupMenu pm_cust;
    private javax.swing.JPopupMenu pm_table;
    private javax.swing.JPopupMenu pop_balance;
    private javax.swing.JTable tbl_charges;
    private javax.swing.JTable tbl_cust;
    private javax.swing.JTextField tf_search;
    private javax.swing.JLabel tf_total;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

//        MyDB.setNames("db_pos_restaurant");
        if (System.getProperty("version", "resto").equals("resto")) {
            ds_title.setText("Customers");
        }
//           if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
//           
//            this.setUndecorated(true);
//        } else {
////             JOptionPane.showMessageDialog(null, System.getProperty("os.name"));
//            this.setUndecorated(false);
//        }
        tf_search.grabFocus();
        init_long_press();
        init_key();
        init_tbl_baptism();
//        init_auto_scroll();
        init_tbl_charges();
        hiden(false);
        action_year();
    }

    private void action_year() {
        dp_year.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                data_employee();
            }
        });
    }

    private void init_auto_scroll() {
//        tbl_cust.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        ComponentDragScrollListener l = new ComponentDragScrollListener(tbl_cust);
//        tbl_cust.addMouseMotionListener(l);
//        tbl_cust.addMouseListener(l);
//        tbl_cust.addHierarchyListener(l);
    }
    double credit_amount = 0;

    public void do_pass(double amount) {

        credit_amount = amount;

//        JOptionPane.showMessageDialog(null, to_users.user_level1);
        if (to_users.user_level1.equals("3")) {
            btn_add.setVisible(true);
            hiden(false);

        } else {
            btn_add.setVisible(false);

            hiden(true);
        }



    }

    private void hiden(boolean aw) {
        btn_ok1.setVisible(aw);
        jLabel13.setVisible(aw);
        jLabel14.setVisible(aw);

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


        tbl_cust.setModel(tbl_employee_payroll_M);
        tbl_cust.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cust.setRowHeight(25);

//        tbl_cust.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {450, 0, 100, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cust, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        tbl_cust.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_cust.setRowHeight(50);
        tbl_cust.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_baptism(List<S2_customers.to_customers> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "NAME", "num", "BALANCE", "REFUND"
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
            S2_customers.to_customers tt = (S2_customers.to_customers) getRow(row);

            switch (col) {
            case 0:
                return tt.name;
            case 1:
                return tt.num;
            case 2:
                return tt.balance;
            default:
                return tt.refund;
            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();
        String name = tf_search.getText();
        if (name.isEmpty()) {
            return;
        }
        String year = "" + dp_year.getYear();
        System.out.println(year);
        if (System.getProperty("version", "resto").equals("resto")) {
            loadData_baptism(S2_customers.ret_guest(name, year));
        } else {
            loadData_baptism(S2_customers.ret_customers(name, year));
        }

    }

    private void add_customer() {


        Window p = (Window) this;
        Dlg_customers nd = Dlg_customers.create(p, true);
        nd.setTitle("");
//        nd.do_pass2();
        nd.setCallback(new Dlg_customers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                closeDialog.ok();
                add_cust(data.name, data.add, data.contact, data.occupation, data.income, data.bday, data.civil_status, data.gender, data.credit_limit);
            }

            @Override
            public void balance(CloseDialog closeDialog, Dlg_customers.OutputData data) {
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_cust(String name, String add, String contact, String occupation, String income, String bday, String civil_status, String gender, double credit_limit) {
        S2_customers.add(name, add, contact, occupation, income, bday, civil_status, gender, credit_limit);
        data_employee();
    }
    private ArrayListModel tbl_charges_ALM;
    private TblchargesModel tbl_charges_M;
////    

    private void init_tbl_charges() {
        tbl_charges_ALM = new ArrayListModel();
        tbl_charges_M = new TblchargesModel(tbl_charges_ALM);


        tbl_charges.setModel(tbl_charges_M);
        tbl_charges.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_charges.setRowHeight(25);

//        tbl_charges.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 0, 200, 150};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_charges, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        tbl_charges.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 10));
        tbl_charges.setRowHeight(35);
        tbl_charges.setFont(new java.awt.Font("Arial", 1, 10));
    }

    private void loadData_charges(List<S2_customers.to_cust_charges> acc) {
        tbl_charges_ALM.clear();
        tbl_charges_ALM.addAll(acc);
    }

    public static class TblchargesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Or", "C . I #", "Amount", "Date Added"
        };

        public TblchargesModel(ListModel listmodel) {
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
            S2_customers.to_cust_charges tt = (S2_customers.to_cust_charges) getRow(row);

            switch (col) {
            case 0:
                return tt.or;
            case 1:
                return tt.ci_number;
            case 2:
                return NumType.with_comma(tt.amount);

            default:
                return (tt.date_added);
            }
        }
    }

    private void init_long_press() {
        tbl_cust.addMouseListener(new MouseAdapter() {

            Date pressedtime;
            long timeClicked;

            @Override
            public void mousePressed(MouseEvent e) {
                pressedtime = new Date();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timeClicked = (new Date()).getTime() - pressedtime.getTime();
//                JOptionPane.showMessageDialog(null, timeClicked);
                if (timeClicked >= 500) {
//                     JOptionPane.showMessageDialog(null, timeClicked);
                    ok1();
                }
            }
        });

    }

    private void data_charges(MouseEvent evt) {
//        String date = lb_date_baptism.getText();
        if (evt.getClickCount() >= 2) {
            ok1();
            return;
        }
        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        String num = tbl_cust.getModel().getValueAt(row, 1).toString();
//        JOptionPane.showMessageDialog(null, num);
        loadData_charges(S2_customers.ret_charges(num));
        compute_charges();

    }

    private void data_charges() {
//        String date = lb_date_baptism.getText();
        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        String num = tbl_cust.getModel().getValueAt(row, 1).toString();
//        JOptionPane.showMessageDialog(null, num);
        loadData_charges(S2_customers.ret_charges(num));
        compute_charges();
    }

    private void ok1() {

        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String num = tbl_cust.getModel().getValueAt(row, 1).toString();
        final String names = tbl_cust.getModel().getValueAt(row, 0).toString();
        final double balance = Double.parseDouble(tbl_cust.getModel().getValueAt(row, 2).toString());
        String[] details = new String[3];
        details = S2_customers.get_details(num);
        final String name = details[0];
        final String add = details[1];
        final String contact = details[2];
//           final String name=details[0];
        Window p = (Window) this;

        Dlg_credit_card nd = Dlg_credit_card.create(p, true);
        nd.setTitle("");
        nd.do_pass(names, details[1], details[2], credit_amount, balance);
        nd.setCallback(new Dlg_credit_card.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_credit_card.OutputData data) {
                closeDialog.ok();

                ok2(name, add, contact, credit_amount, data.to, data.pay_mode, num);
                disposed();
            }
            @Override
            public void credit(CloseDialog closeDialog, Dlg_credit_card.OutputData data) {
                ok2(name, add, contact, credit_amount, data.to, data.pay_mode, num);
//                disposed();
            }
            @Override
            public void prepaid(CloseDialog closeDialog, Dlg_credit_card.OutputData data) {
                ok2(name, add, contact, credit_amount, data.to, data.pay_mode, num);
//                disposed();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);

    }

    private void ok2(String name, String add, String contact, double amount, to_credit to, String payment_mode, String member_id) {

        this.disposed();
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(name, add, contact, to, payment_mode, member_id));
        }
//        if (callback != null) {
//            callback.ok(new CloseDialog(this), new OutputData());
//        }
    }

    private void compute_charges() {
//        
        double total = 0;
        if (tbl_charges_ALM.isEmpty()) {
            total = 0;
        } else {
            List<S2_customers.to_cust_charges> datas = tbl_charges_ALM;
            for (S2_customers.to_cust_charges to : datas) {
                total += to.amount;
            }
        }
        tf_total.setText("" + NumType.with_comma(Double.parseDouble("" + total)));
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_table.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void do_pay() {


        int[] idx = tbl_charges.getSelectedRows();
//        JOptionPane.showMessageDialog(null, idx);
        if (idx.length <= 0) {
            return;
        }

        final List<S2_customers.to_cust_charges> cus = new ArrayList();

        final List<String> rem = new ArrayList();
        double charges = 0;
        for (int ix : idx) {
            charges += Double.parseDouble(NumType.no_comma(tbl_charges.getModel().getValueAt(ix, 2).toString()));
            String or_number = tbl_charges.getModel().getValueAt(ix, 0).toString();
            String ci_number = tbl_charges.getModel().getValueAt(ix, 1).toString();
//            rem.add(tbl_charges.getModel().getValueAt(ix, 1).toString());

            S2_customers.to_cust_charges to = new S2_customers.to_cust_charges(or_number, ci_number, 0, "");

            cus.add(to);
//            System.out.println(tbl_charges.getModel().getValueAt(ix, 1).toString());
        }

        int row = tbl_charges.getSelectedRow();
        if (row < 0) {
            return;
        }
        String num = tbl_charges.getModel().getValueAt(row, 1).toString();

        Window p = (Window) this;
        Dlg_quantity1 nd = Dlg_quantity1.create(p, true);
        nd.setTitle("");
        nd.do_pass(charges);
        nd.setCallback(new Dlg_quantity1.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_quantity1.OutputData data) {
                closeDialog.ok();
                pay3(cus);
//                pay(rem);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void pay3(List<to_cust_charges> cus) {

        for (to_cust_charges t : cus) {

            S2_customers.pay3(t.ci_number, t.or);
            data_charges();
        }
        data_charges();
        Prompt.call("PAYED");
    }

    private void pay(List<String> ci) {

        for (String aw : ci) {
//            String num = tbl_charges.getModel().getValueAt(row, 1).toString();
            S2_customers.pay(aw);
            data_charges();
        }
        JOptionPane.showMessageDialog(null, "Payed");
//        int row = tbl_charges.getSelectedRow();
//        if (row < 0) {
//            return;
//        }

    }

    private void pm_tbl_customers(MouseEvent evt) {

//        if (to_users.user_level1 == null) {
//            return;
//        }
////        JOptionPane.showMessageDialog(null, to_users.user_level1 + " "+ to_users.username1);
//        if (to_users.user_level1.equals("0")) {
//            return;
//        }
        if (evt.isPopupTrigger()) {
            pm_cust.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void edit_customer() {

        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String num = tbl_cust.getModel().getValueAt(row, 1).toString();


//         JOptionPane.showMessageDialog(null, to.b_date);
        Window p = (Window) this;
        Dlg_customers nd = Dlg_customers.create(p, true);
        nd.setTitle("");
        if (System.getProperty("version", "resto").equals("resto")) {
            S2_customers.customers to = S2_customers.get_cust_guest(num);
//            System.out.println(to.member_name + " asdasd");
            nd.do_pass(to.member_name, to.address, to.contact, to.occupation, to.income, to.b_date, to.civil_status, to.is_male, to.balance, num, to.credit_limit);
        } else {
            S2_customers.customers to = S2_customers.get_cust_details(num);
            nd.do_pass(to.member_name, to.address, to.contact, to.occupation, to.income, to.b_date, to.civil_status, to.is_male, to.balance, num, to.credit_limit);
        }

        nd.setCallback(new Dlg_customers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                closeDialog.ok();
                do_edit_customer(data.name, data.add, data.contact, data.occupation, data.income, data.bday, data.civil_status, data.gender, num, data.balance, data.credit_limit);
            }

            @Override
            public void balance(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                data_employee();
                int row = tbl_cust.getSelectedRow();
                if (row < 0) {
                    return;
                }
                String num = tbl_cust.getModel().getValueAt(row, 1).toString();
//        JOptionPane.showMessageDialog(null, num);
                loadData_charges(S2_customers.ret_charges(num));
                compute_charges();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_edit_customer(String member_name, String address, String contact, String occupation, String income, String b_date, String civil_status, String is_male, String num, double balance, double credit_limit) {

        if (System.getProperty("version", "resto").equals("resto")) {
            S2_customers.edit_guest(member_name, address, contact, occupation, income, b_date, civil_status, is_male, num, balance, credit_limit);
        } else {
            S2_customers.edit_customer(member_name, address, contact, occupation, income, b_date, civil_status, is_male, num, balance, credit_limit);
        }

        data_employee();
    }

    private void delete_cust() {
        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String num = tbl_cust.getModel().getValueAt(row, 1).toString();
        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                delete(num);
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void delete(String num) {
        S2_customers.delete(num);
        data_employee();
    }

    private void keyboard(final JTextField tf) {
        Window p = (Window) this;
        dlg_keyboard nd = dlg_keyboard.create(p, true);
        nd.setTitle("");
        nd.do_pass(tf.getText());
        nd.setCallback(new dlg_keyboard.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, dlg_keyboard.OutputData data) {
//                closeDialog.ok();
                tf.setText(data.name);
                data_employee();
            }
        });
        Center.setRight(nd);


        nd.setVisible(true);
    }
}
