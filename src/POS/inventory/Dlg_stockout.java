/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.Main;
import POS.branches.Dlg_branches;
import POS.svc.S3_insert_new_user;
import POS.svc3.S9_add_product;
import POS.to.to_users;
import POS.to2.to_add_product;
import POS.utl.Center;
import POS.utl.DateType;
import POS.utl.TableUtility;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Dummy
 */
public class Dlg_stockout extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_stockout
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
    private Dlg_stockout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_stockout(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_stockout() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_stockout myRef;

    private void setThisRef(Dlg_stockout myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_stockout> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_stockout create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_stockout create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_stockout dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_stockout((java.awt.Frame) parent, false);
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
            Dlg_stockout dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_stockout((java.awt.Dialog) parent, false);
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


        Dlg_stockout dialog = Dlg_stockout.create(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

        dialog.setSize(xSize, ySize);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prod = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_stock_out = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_ref_no = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_remarks = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        cb_stock_in = new javax.swing.JCheckBox();
        cb_stock_out = new javax.swing.JCheckBox();
        cb_stock_in_ref = new javax.swing.JCheckBox();
        cb_stock_usb = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_prod.setFocusable(false);
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_prod);

        tbl_stock_out.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_stock_out.setFocusable(false);
        tbl_stock_out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_stock_outMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_stock_out);

        jButton1.setText("OK");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CLOSE");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("SEARCH:");

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("BRANCH:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("REMARKS:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("REFERENCE #:");

        lbl_ref_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_ref_no.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ref_no.setText("00001");

        tf_remarks.setColumns(20);
        tf_remarks.setRows(5);
        jScrollPane3.setViewportView(tf_remarks);

        jButton3.setText("+");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(cb_stock_in);
        cb_stock_in.setSelected(true);
        cb_stock_in.setText("STOCK IN (NORMAL)");

        buttonGroup1.add(cb_stock_out);
        cb_stock_out.setText("STOCK OUT");

        buttonGroup1.add(cb_stock_in_ref);
        cb_stock_in_ref.setText("STOCK IN (REFERENCE NO)");
        cb_stock_in_ref.setEnabled(false);

        buttonGroup1.add(cb_stock_usb);
        cb_stock_usb.setText("STOCK IN (USB)");
        cb_stock_usb.setEnabled(false);

        jLabel5.setForeground(java.awt.Color.red);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.setToolTipText("NO CONNECTION");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setForeground(java.awt.Color.red);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("X");
        jLabel6.setToolTipText("NO USB DETECTED");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        lbl_branch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_branch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_branch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_stock_in, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_stock_usb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_stock_in_ref, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cb_stock_out, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 208, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_stock_in)
                            .addComponent(cb_stock_out)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_stock_in_ref)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cb_stock_usb)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 5, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_branch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(5, 5, 5))))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("STOCK IN  AND STOCK OUT");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tf_search))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_search, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_employee_search();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        click(evt);
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_stock_outMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_stock_outMouseClicked
        do_edit_out();
    }//GEN-LAST:event_tbl_stock_outMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        stock_out();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        stock_in_usb();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        branches();
    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cb_stock_in;
    private javax.swing.JCheckBox cb_stock_in_ref;
    private javax.swing.JCheckBox cb_stock_out;
    private javax.swing.JCheckBox cb_stock_usb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_ref_no;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTable tbl_stock_out;
    private javax.swing.JTextArea tf_remarks;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_casablanca");
        init_key();
        init_ref_no();
        tf_search.grabFocus();
        init_tbl_baptism();
        init_tbl_out();
    }

    private void init_ref_no() {
        lbl_ref_no.setText(S1_stock_out.ret_stock_main_no());

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
        tbl_prod.getTableHeader().
                setPreferredSize(new Dimension(100, 30));

        tbl_prod.setModel(tbl_employee_payroll_M);
        tbl_prod.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_prod.setRowHeight(25);

        tbl_prod.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
//        tbl_prod.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 300, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_prod, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        TableUtility.align_row_to_left(tbl_prod, 1);
        TableUtility.align_row_to_right(tbl_prod, 2);
        TableUtility.align_row_to_Center(tbl_prod, 3);
//        TableUtility.align_column_to_Center(tbl_prod, 2);
//        TableUtility.align_column_to_Center(tbl_prod, 3);

        tbl_prod.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_prod.setRowHeight(35);
        tbl_prod.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_baptism(List<to_add_product> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "PRODUCT CODE", "DESCRIPTION", "PRICE", "QUANTITY", "num", "VAT", "category_id", "is_linient", "w_comm", "amount", "cat_id", "cost"
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
            to_add_product tt = (to_add_product) getRow(row);

            switch (col) {
            case 0:
                return tt.name;
            case 1:
                return tt.desc;

            case 2:
                return FitIn.fmt_wc_0(tt.price);

            case 3:
                return tt.qty;
            case 4:
                return tt.num;
            case 5:
                return tt.vat;
            case 6:
                return tt.category_id;
            case 7:
                return tt.is_linient;
            case 8:
                return tt.w_commission;
            case 9:
                return tt.comm_amount;
            case 10:
                return tt.cat_id;

            default:
                return tt.cost;
            }
        }
    }

    private void data_employee_search() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
////        int row = cb_type.getItemCount();
////        System.out.println(row);
//        if (row == 0) {
//            tbl_employee_payroll_ALM.clear();
//            tbl_employee_payroll_M.fireTableDataChanged();
//            return;
//        }

        String name = tf_search.getText();

        loadData_baptism(S9_add_product.ret_products_search_like("", name));
    }

    private void click(MouseEvent evt) {
        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String name = tbl_prod.getModel().
                getValueAt(row, 0).
                toString();
        final String desc = tbl_prod.getModel().
                getValueAt(row, 1).
                toString();
        final String price = tbl_prod.getModel().
                getValueAt(row, 2).
                toString();
        final String qty = tbl_prod.getModel().
                getValueAt(row, 3).
                toString();
        final String num = tbl_prod.getModel().
                getValueAt(row, 4).
                toString();
        final String vat = tbl_prod.getModel().
                getValueAt(row, 5).
                toString();
        final String category_id = tbl_prod.getModel().
                getValueAt(row, 6).
                toString();
        final String is_linient = tbl_prod.getModel().
                getValueAt(row, 7).
                toString();
        final String w_commission = tbl_prod.getModel().
                getValueAt(row, 8).
                toString();
        final double comm_amount = FitIn.toDouble(tbl_prod.getModel().
                getValueAt(row, 9).
                toString());
        final String cat_id = tbl_prod.getModel().
                getValueAt(row, 10).
                toString();
        final double cost = FitIn.toDouble(tbl_prod.getModel().
                getValueAt(row, 11).
                toString());


        Window p = (Window) this;
        Dlg_number21 nd = Dlg_number21.create(p, true);
        nd.setTitle("");
        nd.do_pass("");
        nd.setCallback(new Dlg_number21.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_number21.OutputData data) {
                closeDialog.ok();
                List<to_add_product> acc = new ArrayList();
                to_add_product to = new to_add_product(name, desc, price, "" + data.qty, num, vat, category_id, is_linient, w_commission, comm_amount, cat_id, data.cost, 0, 0,"","","");
                acc.add(to);
                loadData_out(acc);
            }

            @Override
            public void cancel(CloseDialog closeDialog, Dlg_number21.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);

        nd.setVisible(true);
////        Center.setCenter(nd);
//        int x = evt.getXOnScreen();
//        int y = evt.getYOnScreen();
//        nd.setLocation(x, y);
//        nd.setVisible(true);
    }
    private ArrayListModel tbl_out_ALM;
    private TbloutModel tbl_out_M;
////    

    private void init_tbl_out() {
        tbl_out_ALM = new ArrayListModel();
        tbl_out_M = new TbloutModel(tbl_out_ALM);
        tbl_stock_out.getTableHeader().
                setPreferredSize(new Dimension(100, 30));

        tbl_stock_out.setModel(tbl_out_M);
        tbl_stock_out.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_stock_out.setRowHeight(25);

        tbl_stock_out.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
//        tbl_prod.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 300, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_stock_out, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        TableUtility.align_row_to_left(tbl_stock_out, 1);
        TableUtility.align_row_to_right(tbl_stock_out, 2);
        TableUtility.align_row_to_Center(tbl_stock_out, 3);
//        TableUtility.align_column_to_Center(tbl_prod, 2);
//        TableUtility.align_column_to_Center(tbl_prod, 3);

        tbl_stock_out.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_stock_out.setRowHeight(35);
        tbl_stock_out.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_out(List<to_add_product> acc) {
//        tbl_out_ALM.clear();
        tbl_out_ALM.addAll(acc);
    }

    public static class TbloutModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "PRODUCT CODE", "DESCRIPTION", "PRICE", "QUANTITY", "num", "VAT", "category_id", "is_linient", "w_comm", "amount", "cat_id", "cost"
        };

        public TbloutModel(ListModel listmodel) {
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
            to_add_product tt = (to_add_product) getRow(row);

            switch (col) {
            case 0:
                return tt.name;
            case 1:
                return tt.desc;

            case 2:
                return FitIn.fmt_wc_0(tt.price);

            case 3:
                return tt.qty;
            case 4:
                return tt.num;
            case 5:
                return tt.vat;
            case 6:
                return tt.category_id;
            case 7:
                return tt.is_linient;
            case 8:
                return tt.w_commission;
            case 9:
                return tt.comm_amount;
            case 10:
                return tt.cat_id;

            default:
                return tt.cost;
            }
        }
    }

    private void do_edit_out() {


        int idx = tbl_stock_out.getSelectedRow();
        if (idx < 0) {
            return;
        }

        String qty = tbl_stock_out.getModel().
                getValueAt(idx, 3).
                toString();

        Window p = (Window) this;
        Dlg_number21 nd = Dlg_number21.create(p, true);
        nd.setTitle("");
        nd.do_pass(qty);

        nd.setCallback(new Dlg_number21.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_number21.OutputData data) {
                closeDialog.ok();
                edit(data.qty, data.cost);
            }

            @Override
            public void cancel(CloseDialog closeDialog, Dlg_number21.OutputData data) {
                int[] idx = tbl_stock_out.getSelectedRows();
                List rem = new ArrayList();
                for (int ix : idx) {
                    if (tbl_stock_out.isRowSelected(ix)) {
                        int mx = tbl_stock_out.convertRowIndexToModel(ix);
                        rem.add(tbl_out_ALM.get(mx));
                    }
                }
                tbl_out_ALM.removeAll(rem);
                tbl_out_M.fireTableDataChanged();
                closeDialog.ok();
            }
        });
        Application.locateOnParentCenter(p, nd);

        nd.setVisible(true);
    }

    private void edit(double qty, double cost) {

        int idx = tbl_stock_out.getSelectedRow();
        if (idx < 0) {
            return;
        }

        to_add_product order = (to_add_product) tbl_out_ALM.get(tbl_stock_out.convertRowIndexToModel(idx));

        order.setQty("" + qty);
        order.setCost(cost);

        tbl_out_M.fireTableDataChanged();

        tbl_stock_out.getSelectionModel().
                setSelectionInterval(idx, idx);
        HelpScrollToView.view(idx, tbl_stock_out);

    }

    private void stock_out() {
        if (tbl_out_ALM.isEmpty()) {
            return;
        }
        List<to_add_product> datas = tbl_out_ALM;

        String remarks = tf_remarks.getText();
        String branch = "main";
        String branch_id = "0";

        String ref_no = lbl_ref_no.getText();
        int item_count = tbl_out_ALM.size();

        double c = 0;
        for (to_add_product t : datas) {
            c += FitIn.toDouble(t.price) * FitIn.toDouble(t.qty);

        }
        double total_cost = c;
        String date_added = DateType.datetime.format(new Date());

        String user = "";
        String user_id = "";
        if (to_users.get_user() == null) {
            user = "NO";
            user_id = "0";
        } else {
            user = to_users.get_user();
            user_id = S3_insert_new_user.get_id(to_users.get_user());
        }
        String status = "0";



        S1_stock_out.to_stock_out_main t_main = new S1_stock_out.to_stock_out_main(ref_no, item_count, total_cost, date_added, branch, branch_id, user_id, user_id, status);

        if (cb_stock_out.isSelected()) {
            S1_stock_out.stock_out(datas, remarks, branch, branch_id, t_main);
            JOptionPane.showMessageDialog(null, "STOCK OUT");
        }

        if (cb_stock_in.isSelected()) {
//            S3_stockout_usb.save_ending_to_usb(datas);
            S1_stock_out.stock_in(datas, remarks, branch, branch_id, t_main);
            JOptionPane.showMessageDialog(null, "STOCK IN");
        }
        if (cb_stock_in_ref.isSelected()) {
//            S1_stock_out.stock_in(datas, remarks, branch, branch_id, t_main);
//            JOptionPane.showMessageDialog(null, "STOCK IN");
        }
        if (cb_stock_usb.isSelected()) {
//            S1_stock_out.stock_in(datas, remarks, branch, branch_id, t_main);
//            JOptionPane.showMessageDialog(null, "STOCK IN");
        }



        tbl_out_ALM.clear();
        data_employee_search();
        init_ref_no();

        ok1();
    }

    private void stock_in_usb() {
        S3_stockout_usb.get_from_usb();
    }

    private void branches() {
        Window p = (Window) this;
        Dlg_branches nd = Dlg_branches.create(p, true);
        nd.setTitle("");
        nd.do_pass(lbl_branch.getText());
        nd.setCallback(new Dlg_branches.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_branches.OutputData data) {
                closeDialog.ok();
                lbl_branch.setText(data.branch);
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
