/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dlg_user_registration.java
 *
 * Created on Nov 19, 2011, 11:33:35 AM
 */
package POS.dlg;

import POS.Main;
import POS.svc.S2_ret_user_details;
import POS.svc.S3_insert_new_user;
import POS.svc.S4_delete_user;
import POS.svc.S5_delete_user;
import POS.to.to_users;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author u2
 */
public class Dlg_user_registration extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class OutputData {
    }

    public static class InputData {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_user_registration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_user_registration(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_user_registration() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_user_registration myRef;

    private void setThisRef(Dlg_user_registration myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_user_registration> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_user_registration create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_user_registration create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_user_registration dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_user_registration((java.awt.Frame) parent, false);
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
            Dlg_user_registration dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_user_registration((java.awt.Dialog) parent, false);
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


        Dlg_user_registration dialog = Dlg_user_registration.create(new javax.swing.JFrame(), true);
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
//            validateTree();
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

        pm_tbl_users = new javax.swing.JPopupMenu();
        pm_tbl_users_edit = new javax.swing.JMenuItem();
        pm_tbl_users_delete = new javax.swing.JMenuItem();
        pm_check_in = new javax.swing.JMenu();
        check_in = new javax.swing.JCheckBoxMenuItem();
        check_out = new javax.swing.JCheckBoxMenuItem();
        pm_edit_delete = new javax.swing.JPopupMenu();
        Edit = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        delete = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        tb_username = new javax.swing.JTextField();
        tb_password = new javax.swing.JPasswordField();
        tb_password1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cb_role = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        ds_error = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        ds_error1 = new javax.swing.JLabel();
        tb_match = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_users = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();

        pm_tbl_users_edit.setText("Edit User");
        pm_tbl_users_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pm_tbl_users_editMouseClicked(evt);
            }
        });
        pm_tbl_users_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_tbl_users_editActionPerformed(evt);
            }
        });
        pm_tbl_users.add(pm_tbl_users_edit);

        pm_tbl_users_delete.setText("Delete User");
        pm_tbl_users_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pm_tbl_users_deleteMouseClicked(evt);
            }
        });
        pm_tbl_users_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_tbl_users_deleteActionPerformed(evt);
            }
        });
        pm_tbl_users.add(pm_tbl_users_delete);

        pm_check_in.setText("CHECK IN/OUT");

        check_in.setSelected(true);
        check_in.setText("CHECK IN");
        check_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_inActionPerformed(evt);
            }
        });
        pm_check_in.add(check_in);

        check_out.setSelected(true);
        check_out.setText("CHECK OUT");
        check_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_outActionPerformed(evt);
            }
        });
        pm_check_in.add(check_out);

        pm_tbl_users.add(pm_check_in);

        Edit.setText("jMenu1");
        pm_edit_delete.add(Edit);
        pm_edit_delete.add(jSeparator1);

        delete.setText("jMenu2");
        pm_edit_delete.add(delete);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, -1));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("USER REGISTRATION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(ds_title)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 660, 90));

        tb_username.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(tb_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 300, 33));

        tb_password.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        tb_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_passwordActionPerformed(evt);
            }
        });
        tb_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_passwordKeyReleased(evt);
            }
        });
        jPanel1.add(tb_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 250, 33));

        tb_password1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        tb_password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_password1ActionPerformed(evt);
            }
        });
        tb_password1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_password1KeyReleased(evt);
            }
        });
        jPanel1.add(tb_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 250, 33));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Confirm Password:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, 30));

        cb_role.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Role:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        ds_error.setFont(new java.awt.Font("DejaVu Sans", 2, 13)); // NOI18N
        ds_error.setForeground(java.awt.Color.red);
        ds_error.setText("* password mismatched");
        jPanel1.add(ds_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 208, 28));

        btn_ok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        btn_ok.setText("OK");
        btn_ok.setBorderPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_ok.setFocusable(false);
        btn_ok.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_ok.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_okMouseClicked(evt);
            }
        });
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 110, 40));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/button-close-ronald_2.png"))); // NOI18N
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setFocusable(false);
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/button-close-ronald-MO_1.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 50, 180));

        ds_error1.setFont(new java.awt.Font("DejaVu Sans", 2, 13)); // NOI18N
        ds_error1.setForeground(java.awt.Color.red);
        ds_error1.setText("Right Click to edit or delete users");
        jPanel1.add(ds_error1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 237, 28));

        tb_match.setText("mismatch");
        jPanel1.add(tb_match, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        tbl_users.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_users.setRowHeight(25);
        tbl_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usersMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_usersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_usersMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_users);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 640, 180));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add32x32.png"))); // NOI18N
        jButton1.setText("NEW");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Username:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, -1));

        tf_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(tf_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 290, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tb_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_passwordActionPerformed
    do_ok();
}//GEN-LAST:event_tb_passwordActionPerformed

private void tb_password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_password1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tb_password1ActionPerformed

private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
    insert_new_user();
}//GEN-LAST:event_btn_okActionPerformed

private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
    do_cancel();
}//GEN-LAST:event_btn_cancelActionPerformed

private void tbl_usersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMousePressed
    pm_tbl_users(evt);
}//GEN-LAST:event_tbl_usersMousePressed

private void tbl_usersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMouseReleased
    pm_tbl_users(evt);
}//GEN-LAST:event_tbl_usersMouseReleased

private void tb_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_passwordKeyReleased
// TODO add your handling code here:

    check_pass();
}//GEN-LAST:event_tb_passwordKeyReleased

private void tb_password1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_password1KeyReleased
// TODO add your handling code here:

    check_pass();
}//GEN-LAST:event_tb_password1KeyReleased

private void btn_okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_okMouseClicked
// TODO add your handling code here:
    insert_new_user();
}//GEN-LAST:event_btn_okMouseClicked

private void tbl_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMouseClicked
// TODO add your handling code here:
    edit();
    disable_input();
}//GEN-LAST:event_tbl_usersMouseClicked

private void pm_tbl_users_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_tbl_users_editActionPerformed
// TODO add your handling code here:
    enable_input();
}//GEN-LAST:event_pm_tbl_users_editActionPerformed

private void pm_tbl_users_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pm_tbl_users_editMouseClicked
// TODO add your handling code here:
    enable_input();
}//GEN-LAST:event_pm_tbl_users_editMouseClicked

private void pm_tbl_users_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pm_tbl_users_deleteMouseClicked
// TODO add your handling code here:

    delete_user();
}//GEN-LAST:event_pm_tbl_users_deleteMouseClicked

private void pm_tbl_users_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_tbl_users_deleteActionPerformed
// TODO add your handling code here:
    delete_user();
}//GEN-LAST:event_pm_tbl_users_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        trigger = 0;
        clear();
        tb_password.setEnabled(true);
        tb_password1.setEnabled(true);
        tb_username.setEnabled(true);
        cb_role.setEnabled(true);
        tf_name.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void check_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_inActionPerformed
        update_check_in();
    }//GEN-LAST:event_check_inActionPerformed

    private void check_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_outActionPerformed
        update_check_out();
    }//GEN-LAST:event_check_outActionPerformed

    private void pm_tbl_users(MouseEvent evt) {
        popup(evt);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox cb_role;
    private javax.swing.JCheckBoxMenuItem check_in;
    private javax.swing.JCheckBoxMenuItem check_out;
    private javax.swing.JMenu delete;
    private javax.swing.JLabel ds_error;
    private javax.swing.JLabel ds_error1;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu pm_check_in;
    private javax.swing.JPopupMenu pm_edit_delete;
    private javax.swing.JPopupMenu pm_tbl_users;
    private javax.swing.JMenuItem pm_tbl_users_delete;
    private javax.swing.JMenuItem pm_tbl_users_edit;
    private javax.swing.JLabel tb_match;
    private javax.swing.JPasswordField tb_password;
    private javax.swing.JPasswordField tb_password1;
    private javax.swing.JTextField tb_username;
    private javax.swing.JTable tbl_users;
    private javax.swing.JTextField tf_name;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        set_account_names();
        initActionKey();
        check_pass();
        init_tbl_users();
        data_netpay();
    }

    private void popup(MouseEvent evt) {
        String version = System.getProperty("version", "resto");
        if (evt.isPopupTrigger()) {
            int idx = tbl_users.getSelectedRow();
            if (idx < 0) {
                return;
            }
            final to_users.u to = (to_users.u) tbl_user_ALM.get(tbl_users.convertRowIndexToModel(idx));
            if (!version.equals("resto")) {
                pm_check_in.setVisible(false);
            } else {
                pm_check_in.setVisible(true);
                if (to.user_level.equals("1")) {
                    pm_check_in.setVisible(false);
                } else {
                    pm_check_in.setVisible(true);
                }
            }
            if (to.check_in == 1) {
                check_in.setSelected(true);
            } else {
                check_in.setSelected(false);
            }
            if (to.check_out == 1) {
                check_out.setSelected(true);
            } else {
                check_out.setSelected(false);
            }
            pm_tbl_users.show(evt.getComponent(), evt.getX(), evt.getY());
        }

    }

    private void set_account_names() {
        DefaultListModel dm = new DefaultListModel();

        String version = System.getProperty("version", "retail");
        if (version.equals("retail")) {
            cb_role.addItem("Administrator");
            cb_role.addItem("Cashier");
        }

        if (version.equals("resto")) {
            cb_role.addItem("Administrator");
            cb_role.addItem("Cashier-Front");
            cb_role.addItem("Cashier-Top");
        }
        if (version.equals("endorsements")) {
            cb_role.addItem("Administrator");
            cb_role.addItem("Cashier");
        }
        if (version.equals("ordering")) {
            cb_role.addItem("Administrator");
            cb_role.addItem("Cashier");
            cb_role.addItem("Waiter");
        }

    }

    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    //</editor-fold>

    public void load(InputData data) {
    }

    private void do_cancel() {
        this.setVisible(false);
    }

    private void do_ok() {
        if (callback == null) {
            return;
        }

        prcss_work_on();

    }

    private void prcss_work_on() {
//        callback.ok(new CloseDialog(this), new OutputData());
//        this.dispose();
    }

    private void check_pass() {
        String password = tb_password.getText();
        String confirm_password = tb_password1.getText();
        if (password.equals(confirm_password)) {
            tb_match.setText("Match");
        } else if (confirm_password.equals(password)) {
            tb_match.setText("Match");
        } else {
            tb_match.setText("MisMatch");
        }


    }
    //<editor-fold defaultstate="collapse" desc="table">
    private static ArrayListModel tbl_user_ALM;
    private static TbluserModel tbluser_M;

    private void init_tbl_users() {
        tbl_user_ALM = new ArrayListModel();
        tbluser_M = new TbluserModel(tbl_user_ALM);

        tbl_users.setModel(tbluser_M);


        tbl_users.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_users.setRowHeight(25);

//        tbl_users.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {200, 100, 200, 0, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_users, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        tbl_users.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_users.setRowHeight(35);
        tbl_users.setFont(new java.awt.Font("Arial", 1, 12));

    }

    private static class TbluserModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {"User Name", "User Level", "name", "check_in", "check_out"};

        public TbluserModel(ListModel listModel) {
            super(listModel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return super.isCellEditable(rowIndex, columnIndex);
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            super.setValueAt(aValue, rowIndex, columnIndex);
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_users.u to = (to_users.u) getRow(row);



            switch (col) {
            case 0:
                return to.username;
            case 1:
                return to.user_level;
            case 2:
                return to.name;
            case 3:
                return to.check_in;

            default:
                return to.check_out;
            }
        }
    }

    private void loadData_users(List<to_users.u> acc) {
        tbl_user_ALM.clear();
        tbl_user_ALM.addAll(acc);
        tbluser_M.fireTableDataChanged();
//       
    }

    private void data_netpay() {

        loadData_users(S2_ret_user_details.get_user_data());

    }

    private void update_check_in() {

        int idx = tbl_users.getSelectedRow();
        if (idx < 0) {
            return;
        }
        final to_users.u to = (to_users.u) tbl_user_ALM.get(tbl_users.convertRowIndexToModel(idx));
        int check_ins = 0;
        if (check_in.isSelected()) {
//            JOptionPane.showMessageDialog(null, to.username);
            check_ins = 1;
        }
        S2_ret_user_details.update_check_in(to.username, check_ins);
        data_netpay();
    }

    private void update_check_out() {
        int idx = tbl_users.getSelectedRow();
        if (idx < 0) {
            return;
        }
        final to_users.u to = (to_users.u) tbl_user_ALM.get(tbl_users.convertRowIndexToModel(idx));
        int check_ins = 0;
        if (check_out.isSelected()) {
            check_ins = 1;
        }
        S2_ret_user_details.update_check_out(to.username, check_ins);
        data_netpay();
    }
    //</editor-fold>
    public int trigger = 0;

    private void insert_new_user() {
        String user_name = tb_username.getText();
        String password = tb_password.getText();
        String name = tf_name.getText();
        int check_in = 0;
        int check_out = 0;
        int user_level = 0;
        if (cb_role.getSelectedItem().equals("Administrator")) {
            user_level = 1;

        } else if (cb_role.getSelectedItem().equals("Cashier-Front")) {
            user_level = 5;
            check_in = 1;
            check_out = 1;
        } else if (cb_role.getSelectedItem().equals("Cashier-Top")) {
            user_level = 6;
        } else if (cb_role.getSelectedItem().equals("Waiter")) {
            user_level = 7;
        } else {
            user_level = 0;
        }
        if (trigger == 0) {
            S3_insert_new_user.insert_new_user(user_name, password, user_level, name, check_in, check_out);
//            JOptionPane.showMessageDialog(null, "saved");
            data_netpay();
            clear();
            enable_input();
            trigger = 0;
        } else {

            int row = tbl_users.getSelectedRow();
            if (row < 0) {
            } else {
                String cur_user = tbl_users.getModel().
                        getValueAt(row, 0).
                        toString();
                String names = tf_name.getText();
                S5_delete_user.delete_user(cur_user, user_name, password, user_level, names);
                trigger = 0;
                clear();
                enable_input();


            }
//          JOptionPane.showMessageDialog(null,"update");
        }

        data_netpay();
        ok1();
    }

    private void edit() {

        trigger = 1;
        int row = tbl_users.getSelectedRow();

        if (row < 0) {
        } else {
            String user_name = tbl_users.getModel().
                    getValueAt(row, 0).
                    toString();
//          
            String name = tbl_users.getModel().
                    getValueAt(row, 2).
                    toString();

            S2_ret_user_details.get_user_data2(user_name);
            tb_password.setText(S2_ret_user_details.password);
            tb_password1.setText(S2_ret_user_details.password);
            tb_username.setText(user_name);
            tf_name.setText(name);
            System.out.println(S2_ret_user_details.userlevel);
            int lvl = S2_ret_user_details.userlevel;
            if (lvl == 0) {
                cb_role.setSelectedIndex(1);
            } else {
                cb_role.setSelectedIndex(0);
            }


        }
    }

    private void disable_input() {
        tb_password.enable(false);
        tb_password1.enable(false);
        tb_username.enable(false);
        tf_name.enable(false);
        cb_role.enable(false);

    }

    private void enable_input() {
        trigger = 1;
//          JOptionPane.showMessageDialog(this, "adad");
        tb_password.setEnabled(true);
        tb_password1.setEnabled(true);
        tb_username.setEnabled(true);
        tf_name.enable(true);
        cb_role.setEnabled(true);
    }

    private void delete_user() {
//           JOptionPane.showMessageDialog(this, "adad");
        String user_name = tb_username.getText();
        S4_delete_user.delete_user(user_name);
        data_netpay();
        clear();
        ok1();

    }

    private void clear() {
        tb_username.setText("");
        tb_password.setText("");
        tb_password1.setText("");
        tf_name.setText("");
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
