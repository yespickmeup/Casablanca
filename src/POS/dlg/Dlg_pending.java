/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dlg_pending.java
 *
 * Created on Nov 19, 2011, 12:47:44 PM
 */
package POS.dlg;

import POS.dlg2.Dlg_confirm;
import POS.dlg2.dlg_keyboard;
import POS.dlg2.dlg_keyboard2;
import POS.svc.S13_select_pending_orders;
import POS.svc3.S2_update_pending;
import POS.to.to_order;
import POS.utl.Prompt;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_pending extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void add(CloseDialog closeDialog, OutputDataAdd data);

        void delete(CloseDialog closeDialog, Data data);
    }

    public static class OutputData {

        public final String selected_customer;

        public OutputData(String selected_customer) {
            this.selected_customer = selected_customer;
        }
    }

    public static class OutputDataAdd {

        public final String customer_added;

        public OutputDataAdd(String selected_customer) {
            this.customer_added = selected_customer;
        }
    }

    public static class InputData {

        public final List<to_order> orders;

        public InputData(List<to_order> orders) {
            this.orders = orders;
        }
    }

    public static class Data {

        public Data() {
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_pending(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_pending(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_pending() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_pending myRef;

    private void setThisRef(Dlg_pending myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_pending> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_pending create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_pending create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_pending dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_pending((java.awt.Frame) parent, false);
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
            Dlg_pending dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_pending((java.awt.Dialog) parent, false);
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


        Dlg_pending dialog = Dlg_pending.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_pending_customers = new org.jdesktop.swingx.JXList();
        btn_cancel = new javax.swing.JButton();
        lb_customer_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_cancel1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setNextFocusableComponent(lb_customer_name);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("Pending Customers");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 14, 420, -1));

        jScrollPane1.setFocusTraversalPolicyProvider(true);

        lst_pending_customers.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        lst_pending_customers.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        lst_pending_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lst_pending_customersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lst_pending_customers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 420, 270));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/delete.png"))); // NOI18N
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setFocusable(false);
        btn_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/delete-MO.png"))); // NOI18N
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/delete-MO.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 70, 60));

        lb_customer_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_customer_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_customer_nameMouseClicked(evt);
            }
        });
        lb_customer_name.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lb_customer_nameMouseDragged(evt);
            }
        });
        lb_customer_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lb_customer_nameActionPerformed(evt);
            }
        });
        lb_customer_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lb_customer_nameKeyReleased(evt);
            }
        });
        jPanel1.add(lb_customer_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 420, 40));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Customer Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 70, 50));

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(41, 9, 149));
        jLabel9.setText("(DEL)");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, 20));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(41, 9, 149));
        jLabel10.setText("(ENTER)");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("DELETE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("SAVE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 50, -1));

        btn_cancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_cancel1.setBorderPainted(false);
        btn_cancel1.setContentAreaFilled(false);
        btn_cancel1.setFocusable(false);
        btn_cancel1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 50, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CLOSE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(41, 9, 149));
        jLabel11.setText("(ESC)");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 50, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
    do_cancel();
}//GEN-LAST:event_btn_cancelActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    save_pending_order();

}//GEN-LAST:event_jButton1ActionPerformed

private void lb_customer_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lb_customer_nameKeyReleased
// TODO add your handling code here:
    select_pending_list();
}//GEN-LAST:event_lb_customer_nameKeyReleased

private void lb_customer_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lb_customer_nameActionPerformed
// TODO add your handling code here:
    save_pending_order();
}//GEN-LAST:event_lb_customer_nameActionPerformed

    private void lb_customer_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_customer_nameMouseClicked
        // TODO add your handling code here:
        keyboard(lb_customer_name, evt);
    }//GEN-LAST:event_lb_customer_nameMouseClicked

    private void lst_pending_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lst_pending_customersMouseClicked
        // TODO add your handling code here:
        do_ok();
    }//GEN-LAST:event_lst_pending_customersMouseClicked

    private void lb_customer_nameMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_customer_nameMouseDragged
        // TODO add your handling code here:
        keyboard(lb_customer_name);
    }//GEN-LAST:event_lb_customer_nameMouseDragged

    private void btn_cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancel1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_cancel1;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lb_customer_name;
    private org.jdesktop.swingx.JXList lst_pending_customers;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc=" myInit ">
    private void myInit() {
//          if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
//           
//            this.setUndecorated(true);
//        } else {
////             JOptionPane.showMessageDialog(null, System.getProperty("os.name"));
//            this.setUndecorated(false);
//        }
        do_hide();
        initActionKey();
        init_focus();
        select_pending_list();
//        select_cust();
//        set_selected();
        lb_customer_name.grabFocus();
        jButton1.setFocusable(false);
        btn_cancel.setFocusable(false);
        clear_lb_customer_name();
//        init_load_pendings();
    }

    private void clear_lb_customer_name() {
        lb_customer_name.setText("");
    }

    private void select_cust() {
        int row = lst_pending_customers.getElementCount();
        String name = lb_customer_name.getText();
//        JOptionPane.showMessageDialog(null, row);
        int index = 0;
        if (row == 0) {
        } else {

            for (int i = 0; i < row; i++) {
                String n = lst_pending_customers.getElementAt(i).
                        toString();
                if (n.equals(name)) {
                    lst_pending_customers.setSelectedIndex(i);
                }
            }
        }
    }

    private void do_hide() {
//        btn_cancel.setVisible(false);
    }
    int rows = 0;
    ArrayListModel l = new ArrayListModel();

    public void pass(ArrayListModel tbl_orders_ALM, String name) {
        lb_customer_name.setText(name);
//        JOptionPane.showMessageDialog(null, "adadad"+name+"dad");
        select_pending_list();
        int row = tbl_orders_ALM.getSize();
        rows = row;
        l = tbl_orders_ALM;
    }
//     public void pass2(List<to_order> datas , String name) {
//        lb_customer_name.setText(name);
////        JOptionPane.showMessageDialog(null, "adadad"+name+"dad");
//        select_pending_list();
//        int row = datas.getSize();
//        rows = row;
//        l = datas;
//    }

    private void set_selected() {
//        int row = lst_pending_customers.getElementCount();
//
//        System.out.println(row);
//        if (row > 0) {
//            lst_pending_customers.setSelectedIndex(0);
//        }
//
//        lb_customer_name.setFocusable(true);
    }
//    
//    private void init_load_pendings() {
//        ObjectSerPersister osp = new ObjectSerPersister("pendings");
//        osp.openSerFile();
//
//        Map map = null;
//        if (osp.hasLeftOver()) {
//            map = (Map) osp.loadLeftOver();
//        } else {
//            map = new HashMap();
//        }
//        
//        Set<String> key_sets = map.keySet();
//        List<String> pending_customers = new ArrayList();
//        for(String key : key_sets ) {
//            pending_customers.add(key);
//        }
//        
//        lst_pending_customers.setModel(new ArrayListModel(pending_customers));
//    }

    private void init_focus() {
        lst_pending_customers.requestFocusInWindow();
    }

    private void dis() {
        this.dispose();
    }

    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
                dis();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ENTER, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                do_ok();


            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_DELETE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                btn_cancel.doClick();


            }
        });

    }
    //</editor-fold>
    public JTable tbl_pending_orders;

//    public void load(JTable tbl_orders) {
//        tbl_pending_orders = tbl_orders;
////         to_pending_orders to=new to_pending_orders(inputData., null, WIDTH, WIDTH)
//
//    }
    private void do_select(KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            do_ok();
            evt.consume();

        }



    }

    private void do_cancel() {

//        JOptionPane.showMessageDialog(null, "adadad");
        int row = lst_pending_customers.getSelectedIndex();

        if (row >= 0) {
            Window p = (Window) this;
            Dlg_confirm nd = Dlg_confirm.create(p, true);
            nd.setTitle("Prompt");

            nd.setCallback(new Dlg_confirm.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                    closeDialog.ok();
                    do_delete();

                }

                @Override
                public void cancel(CloseDialog cd) {
                    cd.ok();
                }
            });

            Center.setCenter(nd);
//            Application.locateOnParentCenter(this, p);
            nd.setVisible(true);
        }
    }

    private void do_ok() {


        if (callback == null) {
            return;
        }

        int count = lst_pending_customers.getElementCount();
        if (count == 0) {
            return;
        }
        String selected_customer = lst_pending_customers.getSelectedValue().
                toString();

        lb_customer_name.setText("");
        callback.ok(new CloseDialog(this), new OutputData(selected_customer));
        this.dispose();

    }

    private void select_pending_list() {

        lst_pending_customers.setModel(S13_select_pending_orders.get_pending_request(lb_customer_name.getText()));

    }

    private void save_pending_order() {

        if (callback == null) {
            return;
        }
        String customer_name = lb_customer_name.getText();

        if (rows == 0) {
            Prompt.call("No orders");
//            JOptionPane.showMessageDialog(null, "No orders");
            return;
        }

        int siz = lst_pending_customers.getElementCount();

        if (siz == 0) {
            if (customer_name.equals("")) {
            } else {
                callback.add(new CloseDialog(this), new OutputDataAdd(customer_name));
                this.dispose();
            }

        } else {

            int row = lst_pending_customers.getSelectedIndex();
            if (row >= 0) {
                S2_update_pending.update(lst_pending_customers.getSelectedValue().
                        toString(), l);
            }

        }

    }

    private void do_delete() {

        String name = lst_pending_customers.getSelectedValue().
                toString();
        S2_update_pending.delete(name);
//        JOptionPane.showMessageDialog(null, name);

        del();
        lb_customer_name.setText("");
        select_pending_list();
        lb_customer_name.grabFocus();

    }

    private void del() {
        if (callback != null) {
            callback.delete(new CloseDialog(this), new Data());
        }
        this.dispose();
    }

    private void keyboard(final JTextField tf, MouseEvent evt) {
        Center.setLeft(this);
        if (evt.getClickCount() == 2) {
            save_pending_order();
        }
        if (evt.getClickCount() == 1) {
            Window p = (Window) this;
            dlg_keyboard2 nd = dlg_keyboard2.create(p, true);
            nd.setTitle("");
            nd.do_pass(tf.getText());
            nd.setCallback(new dlg_keyboard2.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, dlg_keyboard2.OutputData data) {
//                closeDialog.ok();
                    tf.setText(data.name);
                    select_pending_list();
                    select_cust();
//                    go_left();

                }

                @Override
                public void ok1(CloseDialog closeDialog, dlg_keyboard2.OutputData data) {
                    tf.setText(data.name);
                    select_pending_list();
                    select_cust();
                    go_left();
                }
            });

            Center.setRight(nd);


            nd.setVisible(true);
        }

    }

    private void go_left() {
        Center.setCenter(this);
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
                select_pending_list();
                select_cust();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);


    }
}
