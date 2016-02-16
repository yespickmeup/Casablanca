/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_dlg4;

import POS.dlg3.Dlg_customer_endorsements;
import POS.rpt2.rpt_report;
import POS.rpt2.to_date_from;
import POS.utl.Center;
import POS.utl.Prompt;
import POS.utl.TableUtility;
import POS_dlg4.Dlg_sales.OutputData2;
import POS_svc3.S2_cashiers;
import POS_svc3.S4_endorsements;
import POS_svc3.S6_customer_charges;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_endorsements extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_endorsements
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
    private Dlg_endorsements(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_endorsements(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_endorsements() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_endorsements myRef;

    private void setThisRef(Dlg_endorsements myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_endorsements> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_endorsements create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_endorsements create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_endorsements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_endorsements((java.awt.Frame) parent, false);
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
            Dlg_endorsements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_endorsements((java.awt.Dialog) parent, false);
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


        Dlg_endorsements dialog = Dlg_endorsements.create(new javax.swing.JFrame(), true);
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
        sp_endorsements = new javax.swing.JScrollPane();
        tbl_endorsements = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cb_cashier = new javax.swing.JComboBox();
        lb_sales = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_recev = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        lbl_item_count = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_qty_unsold = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_endorsements.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_endorsements.setFocusable(false);
        tbl_endorsements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_endorsementsMouseClicked(evt);
            }
        });
        sp_endorsements.setViewportView(tbl_endorsements);

        jPanel1.add(sp_endorsements, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 138, 1150, 460));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup-MO.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup-MO.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 340, 80, 55));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/rrowdown.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowdown-MO.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowdown-MO.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 470, 80, 52));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/print.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/print-MO.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/print-MO.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 90, 90, 52));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 570, 90, -1));

        cb_cashier.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cb_cashier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cashier.setFocusable(false);
        cb_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashierActionPerformed(evt);
            }
        });
        jPanel1.add(cb_cashier, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 375, 41));

        lb_sales.setBackground(new java.awt.Color(0, 0, 0));
        lb_sales.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lb_sales.setForeground(java.awt.Color.green);
        lb_sales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_sales.setText("0.0");
        lb_sales.setOpaque(true);
        jPanel1.add(lb_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, 30, 20));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/sales.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/sales-MO.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/sales-MO.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 230, 76, 52));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ENDORSEMENT");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 180, 140, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SALES");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 290, 60, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CLOSE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 650, 63, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("QUANTITY UNSOLD");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 190, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("TOTAL SALES:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, 30, -1));

        lb_recev.setBackground(new java.awt.Color(0, 0, 0));
        lb_recev.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lb_recev.setForeground(java.awt.Color.green);
        lb_recev.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_recev.setText("0.0");
        lb_recev.setOpaque(true);
        jPanel1.add(lb_recev, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, 10, 20));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("ENDORSEMENTS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/search.png"))); // NOI18N
        jButton7.setText("VIEW");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/search-MO.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 20, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DOWN");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1202, 450, 70, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("UP");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 400, 80, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("SEARCH:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 100, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PRINT ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 150, 120, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("SELECT CASHIER:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 50));

        tf_search.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });
        jPanel1.add(tf_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 89, 470, 40));

        lbl_item_count.setBackground(new java.awt.Color(0, 0, 0));
        lbl_item_count.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_item_count.setForeground(java.awt.Color.green);
        lbl_item_count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_item_count.setText("0.0");
        lbl_item_count.setOpaque(true);
        jPanel1.add(lbl_item_count, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 630, 170, 40));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ITEM COUNT");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 600, 170, 30));

        lbl_qty_unsold.setBackground(new java.awt.Color(0, 0, 0));
        lbl_qty_unsold.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_qty_unsold.setForeground(java.awt.Color.green);
        lbl_qty_unsold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_qty_unsold.setText("0.0");
        lbl_qty_unsold.setOpaque(true);
        jPanel1.add(lbl_qty_unsold, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 630, 190, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cb_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashierActionPerformed
        // TODO add your handling code here:
        data_employee();
        get_charges();
//        compute_total();
    }//GEN-LAST:event_cb_cashierActionPerformed

    private void tbl_endorsementsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_endorsementsMouseClicked
        // TODO add your handling code here:
        do_menu();
    }//GEN-LAST:event_tbl_endorsementsMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        sales();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        print_endorsement();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        do_down();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
//        do_down();
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
//        do_up();
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
//         do_down();
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
//           do_up();
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        do_up();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        customers();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_employee2();
    }//GEN-LAST:event_tf_searchKeyReleased
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_cashier;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lb_recev;
    private javax.swing.JLabel lb_sales;
    private javax.swing.JLabel lbl_item_count;
    private javax.swing.JLabel lbl_qty_unsold;
    private javax.swing.JScrollPane sp_endorsements;
    private javax.swing.JTable tbl_endorsements;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        
        init_key();
        hidn();
        get_cashiers();
        init_tbl_baptism();
        data_employee();
        get_charges();
        init_scroller();

    }

    private void hidn() {
        jButton7.setVisible(false);
        lb_sales.setVisible(false);
        jLabel7.setVisible(false);
        lb_recev.setVisible(false);
    }

    private void do_down() {

//            tbl_endorsements.scrollRectToVisible(tbl_endorsements.getCellRect(j, 0, false));
        sp_endorsements.transferFocusDownCycle();
        sp_endorsements.getVerticalScrollBar().setValue(sp_endorsements.getVerticalScrollBar().getValue() + sp_endorsements.getVerticalScrollBar().getBlockIncrement() + 20);

//      
    }

    private void do_up() {

        sp_endorsements.transferFocusUpCycle();
        sp_endorsements.getVerticalScrollBar().setValue(sp_endorsements.getVerticalScrollBar().getValue() - sp_endorsements.getVerticalScrollBar().getBlockIncrement() - 20);


    }
//    private ScrollDecorator scroll;

    private void get_cashiers() {
        cb_cashier.setModel(new ListComboBoxModel(S2_cashiers.get_cashiers_names()));
    }

    private void init_scroller() {
//        scroll = new ScrollDecorator(tbl_endorsements);

    }
    int j = 12;

    private void do_down2() {

//            tbl_endorsements.scrollRectToVisible(tbl_endorsements.getCellRect(j, 0, false));
        sp_endorsements.transferFocusDownCycle();
        sp_endorsements.getVerticalScrollBar().setValue(sp_endorsements.getVerticalScrollBar().getValue() + sp_endorsements.getVerticalScrollBar().getBlockIncrement() + 20);

//      
    }

    private void do_up2() {

        sp_endorsements.transferFocusUpCycle();
        sp_endorsements.getVerticalScrollBar().setValue(sp_endorsements.getVerticalScrollBar().getValue() - sp_endorsements.getVerticalScrollBar().getBlockIncrement() - 20);


    }

    public void do_pass() {
        get_cashiers();
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


        tbl_endorsements.setModel(tbl_employee_payroll_M);
        tbl_endorsements.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_endorsements.setRowHeight(25);
        tbl_endorsements.getTableHeader().setPreferredSize(new Dimension(100, 30));
//        tbl_endorsements.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 0, 200, 100, 100, 100, 100, 0, 0, 0, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }

            TableWidthUtilities.setColumnWidth(tbl_endorsements, i, tbl_widths_accounts[i]);
//            TableWidthUtilities.

//          TableWidthUtilities.
//          TableWidthUtilities.
        }
        TableUtility.align_row_to_Center(tbl_endorsements, 1);
        TableUtility.align_row_to_Center(tbl_endorsements, 2);
        TableUtility.align_row_to_Center(tbl_endorsements, 3);
        TableUtility.align_row_to_Center(tbl_endorsements, 4);
        TableUtility.align_row_to_Center(tbl_endorsements, 5);
        TableUtility.align_row_to_Center(tbl_endorsements, 6);

        TableUtility.align_row_to_right(tbl_endorsements, 10);
        tbl_endorsements.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_endorsements.setRowHeight(50);
        tbl_endorsements.setFont(new java.awt.Font("Arial", 1, 14));
    }

    private void loadData_baptism(List<S4_endorsements.to_endorsements> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

//        static String en = "<html>QUANTITY<BR>ENDORSED</html>";
//        static String le = "<html>QUANTITY<BR>LEFT</html>";
//        static String so = "<html>QUANTITY<BR>SOLD</html>";
        public static String[] COLUMNS = {
            "id", "BARCODE", "DESCRIPTION", "PRICE", "ENDORSED", "LEFT", "SOLD", "date_added", "cashier_ids", "remarks", "SALES"
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
            S4_endorsements.to_endorsements tt = (S4_endorsements.to_endorsements) getRow(row);

            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.barcode;
                case 2:
                    return tt.prod_name;
                case 3:
                    return FitIn.fmt_wc_0(tt.price);
                case 4:
                    return FitIn.fmt_woc(tt.qty_endorsed);
                case 5:
                    return FitIn.fmt_woc(tt.qty_left);
                case 6:
                    return FitIn.fmt_woc(tt.sold);
                case 7:
                    return tt.date_added;
                case 8:
                    return tt.cashier_id;
                case 9:
                    return tt.remarks;

                default:
                    return FitIn.fmt_wc_0(tt.sales);
            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();
        String name = cb_cashier.getSelectedItem().toString();
//        String search=tf_search.getText();

        name = S2_cashiers.get_cashiers_id(name);
        loadData_baptism(S4_endorsements.get_endorsements(name));
        compute_total();

    }

    private void data_employee2() {
//        String date = lb_date_baptism.getText();
        String name = cb_cashier.getSelectedItem().toString();
//        String search=tf_search.getText();

        name = S2_cashiers.get_cashiers_id(name);
        String se = tf_search.getText();
        loadData_baptism(S4_endorsements.get_endorsements_search(name, se));
        compute_total();

    }

    private void do_qty() {
        int row = tbl_endorsements.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String id = tbl_endorsements.getModel().getValueAt(row, 0).toString();
        final String barcode = tbl_endorsements.getModel().getValueAt(row, 1).toString();
        final double qty_left = Double.parseDouble(tbl_endorsements.getModel().getValueAt(row, 5).toString());
        final double endorsed = Double.parseDouble(tbl_endorsements.getModel().getValueAt(row, 4).toString());
        final String cashier_id = tbl_endorsements.getModel().getValueAt(row, 8).toString();
        final String prod_name = tbl_endorsements.getModel().getValueAt(row, 2).toString();
        final double price = Double.parseDouble(FitIn.fmt_woc(tbl_endorsements.getModel().getValueAt(row, 3).toString()));
        if (qty_left == 0) {
            Prompt.call("No Quantity Left, Please Endorse Again");
            return;

        }


        Window p = (Window) this;
        Dlg_endorsement_qty nd = Dlg_endorsement_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(endorsed, qty_left, prod_name);
        nd.setCallback(new Dlg_endorsement_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_endorsement_qty.OutputData data) {
                closeDialog.ok();
                update_endorsement(barcode, data.qty, cashier_id, qty_left, prod_name, price, data.date_sold, id);
                data_employee();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_endorsement(String barcode, double qty, String cashier_id, double left, String prod_name, double price, String date_sold, String id) {
        S4_endorsements.update_end(barcode, qty, cashier_id, left, prod_name, price, date_sold, id);

    }

    private void sales() {
        Window p = (Window) this;
        Dlg_sales nd = Dlg_sales.create(p, true);
        nd.setTitle("");
        nd.do_pass("1");
        nd.setCallback(new Dlg_sales.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_sales.OutputData data) {
//                closeDialog.ok();
                data_employee();
                ok1();
            }

            @Override
            public void charges(CloseDialog closeDialog, OutputData2 data) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_menu() {

        int row = tbl_endorsements.getSelectedRow();
        if (row < 0) {
            return;
        }



        final double qty_left = Double.parseDouble(tbl_endorsements.getModel().getValueAt(row, 5).toString());

        if (qty_left == 0) {
            Prompt.call("No Quantity Left, Please Endorse Again");
            return;

        }


        Window p = (Window) this;
        Dlg_menu_endorsement nd = Dlg_menu_endorsement.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_menu_endorsement.Callback() {

            @Override
            public void cancel(CloseDialog closeDialog, Dlg_menu_endorsement.OutputData data) {
                closeDialog.ok();
                do_cancel_endorsement();
                ok1();
            }

            @Override
            public void update(CloseDialog closeDialog, Dlg_menu_endorsement.OutputData data) {
                closeDialog.ok();
                do_qty();
                ok1();
            }

            @Override
            public void returns(CloseDialog closeDialog, Dlg_menu_endorsement.OutputData data) {
                closeDialog.ok();
//                do_qty();
//                ok1();
            }
            
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_cancel_endorsement() {
        int row = tbl_endorsements.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String barcode = tbl_endorsements.getModel().getValueAt(row, 1).toString();
        final double qty_left = Double.parseDouble(tbl_endorsements.getModel().getValueAt(row, 5).toString());
        final double endorsed = Double.parseDouble(tbl_endorsements.getModel().getValueAt(row, 4).toString());
        final String cashier_id = tbl_endorsements.getModel().getValueAt(row, 8).toString();
        final String prod_name = tbl_endorsements.getModel().getValueAt(row, 2).toString();
        final double price = Double.parseDouble(FitIn.fmt_woc(tbl_endorsements.getModel().getValueAt(row, 3).toString()));
        Window p = (Window) this;
        Dlg_endorsement_qty nd = Dlg_endorsement_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(endorsed, qty_left, prod_name);
        nd.setCallback(new Dlg_endorsement_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_endorsement_qty.OutputData data) {
                closeDialog.ok();
                cancel_endorsement(barcode, data.qty, cashier_id, qty_left, prod_name, price, endorsed);
                data_employee();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

     private void do_return_endorsement() {
        int row = tbl_endorsements.getSelectedRow();
        if (row < 0) {
            return;
        }

        final String barcode = tbl_endorsements.getModel().getValueAt(row, 1).toString();
        final double qty_left = Double.parseDouble(tbl_endorsements.getModel().getValueAt(row, 5).toString());
        final double endorsed = Double.parseDouble(tbl_endorsements.getModel().getValueAt(row, 4).toString());
        final String cashier_id = tbl_endorsements.getModel().getValueAt(row, 8).toString();
        final String prod_name = tbl_endorsements.getModel().getValueAt(row, 2).toString();
        final double price = Double.parseDouble(FitIn.fmt_woc(tbl_endorsements.getModel().getValueAt(row, 3).toString()));
        Window p = (Window) this;
        Dlg_endorsement_qty nd = Dlg_endorsement_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(endorsed, qty_left, prod_name);
        nd.setCallback(new Dlg_endorsement_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_endorsement_qty.OutputData data) {
                closeDialog.ok();
                cancel_endorsement(barcode, data.qty, cashier_id, qty_left, prod_name, price, endorsed);
                data_employee();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void cancel_endorsement(String barcode, double qty, String cashier_id, double qty_left, String prod_name, double price, double endorsed) {
        S4_endorsements.cancel_endorsement(barcode, qty, cashier_id, qty_left, prod_name, price, endorsed);
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void print_endorsement() {

        String name = System.getProperty("entityName", "Intelink-One");

        String names = cb_cashier.getSelectedItem().toString();
        names = S2_cashiers.get_cashiers_id(names);
        final to_date_from.to_endorsement to = new to_date_from.to_endorsement(new Date(), name, names);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_endorsement(to, "rpt_endorsements_1_1");
            }
        });

    }

    private void do_compute() {
//        for()
    }

    private void get_charges() {
        String names = cb_cashier.getSelectedItem().toString();
        names = S2_cashiers.get_cashiers_id(names);
        double amount = S6_customer_charges.get_cashier_charges(names);
        lb_recev.setText(FitIn.fmt_wc_0(amount));
    }

    private void compute_total() {

        int amount = 0;
//         int amount = 0;

        List<S4_endorsements.to_endorsements> datas = tbl_employee_payroll_ALM;
        for (S4_endorsements.to_endorsements to : datas) {
            amount += Integer.parseInt(FitIn.fmt_woc(to.qty_left));
        }

        lbl_qty_unsold.setText(FitIn.fmt_wc(amount));
        lbl_item_count.setText("" + tbl_employee_payroll_ALM.size());

    }

    private void customers() {
        String names = cb_cashier.getSelectedItem().toString();
        names = S2_cashiers.get_cashiers_id(names);
        Window p = (Window) this;
        Dlg_customer_endorsements nd = Dlg_customer_endorsements.create(p, true);
        nd.setTitle("");
//        nd.do_pass(0);
        nd.do_pass2(names);
        nd.setCallback(new Dlg_customer_endorsements.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customer_endorsements.OutputData data) {
                closeDialog.ok();

            }
        });
        Center.setCenter(nd);
        nd.setVisible(true);
    }
}
