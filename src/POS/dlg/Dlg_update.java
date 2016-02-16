/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dlg_update.java
 *
 * Created on Nov 16, 2011, 6:48:57 PM
 */
package POS.dlg;

import POS.svc.S10_update_product;
import POS.svc.S8_ret_values_from_resultset;
import POS.to.to_admin_product;
import POS.to.to_product;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_update extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class OutputData {

        public final to_admin_product tap;

        public OutputData(to_admin_product tap) {
            this.tap = tap;
        }
    }

    public static class InputData {

        public final String title;

        public InputData(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "InputData{" + "title=" + title + '}';
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_update(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_update(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_update() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_update myRef;

    private void setThisRef(Dlg_update myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_update> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_update create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_update create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_update dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_update((java.awt.Frame) parent, false);
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
            Dlg_update dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_update((java.awt.Dialog) parent, false);
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


        Dlg_update dialog = Dlg_update.create(new javax.swing.JFrame(), true);
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
        jPanel3 = new javax.swing.JPanel();
        ds_product = new javax.swing.JLabel();
        ds_title2 = new javax.swing.JLabel();
        tf_price = new javax.swing.JTextField();
        tf_kilos = new javax.swing.JTextField();
        ds_title4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_cancel = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();
        btn_clearall = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 195, 191));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_product.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        ds_product.setForeground(new java.awt.Color(41, 9, 149));
        ds_product.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ds_product.setText("LUMO");

        ds_title2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ds_title2.setForeground(new java.awt.Color(41, 9, 149));
        ds_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title2.setText("PRICE:");

        tf_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_priceActionPerformed(evt);
            }
        });

        tf_kilos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        ds_title4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ds_title4.setForeground(new java.awt.Color(41, 9, 149));
        ds_title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title4.setText("Available Kilo/s:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ds_product, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(ds_title2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ds_title4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_kilos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(ds_product, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ds_title2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ds_title4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_kilos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 88, 390, -1));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("ADMIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 390, -1));

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/cancel_login.png"))); // NOI18N
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/cancel_login_mo.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/ok_login.png"))); // NOI18N
        btn_ok.setBorderPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/ok_login_mo.png"))); // NOI18N
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        jPanel4.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 60, 50));

        btn_clearall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/clear.png"))); // NOI18N
        btn_clearall.setBorderPainted(false);
        btn_clearall.setContentAreaFilled(false);
        btn_clearall.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/clear_mo.png"))); // NOI18N
        btn_clearall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearallActionPerformed(evt);
            }
        });
        jPanel4.add(btn_clearall, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(41, 9, 149));
        jLabel10.setText("(ENTER)");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, 40));

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(41, 9, 149));
        jLabel9.setText("F5");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 279, 390, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tf_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_priceActionPerformed
}//GEN-LAST:event_tf_priceActionPerformed

private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
    do_cancel();
}//GEN-LAST:event_btn_cancelActionPerformed

private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
    do_ok();
}//GEN-LAST:event_btn_okActionPerformed

private void btn_clearallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearallActionPerformed
    do_clearall();
}//GEN-LAST:event_btn_clearallActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_clearall;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel ds_product;
    private javax.swing.JLabel ds_title;
    private javax.swing.JLabel ds_title2;
    private javax.swing.JLabel ds_title4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tf_kilos;
    private javax.swing.JTextField tf_price;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">

    private void myInit() {
        initActionKey();
        do_hide();
        do_key();

    }

    private void do_hide() {
        btn_cancel.setVisible(false);
    }

    private void hides() {
        this.dispose();
    }

    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hides();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(), KeyEvent.VK_NUMPAD8, new KeyMapping.KeyAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                change_product();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(), KeyEvent.VK_F10, new KeyMapping.KeyAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                change_product();
            }
        });


        KeyMapping.mapKeyWIFW(getSurface(), KeyEvent.VK_ENTER, new KeyMapping.KeyAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                do_ok();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(), KeyEvent.VK_F5, new KeyMapping.KeyAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                do_clearall();
            }
        });

    }
    //</editor-fold>
    private InputData data;

    public void load(InputData data) {
        this.data = data;
        ds_product.setText(this.data.title);
        init_get_prod_details();
    }

    private void init_get_prod_details() {

        String prod = ds_product.getText();
//        JOptionPane.showMessageDialog(null, prod+ "add");
        if (prod.equals("") || prod.isEmpty()) {
            return;
        }
        to_product tp = S8_ret_values_from_resultset.get_id_product2(prod);
        System.out.println(tp);
//        JOptionPane.showMessageDialog(null, tp);
        if (tp == null) {
            return;
        }
//        if((""+tp.price)==null || (""+tp.product_qty)==null){
//            return;
//        }
        tf_price.setText(FitIn.fmt_woc_0(tp.price));
        tf_kilos.setText(FitIn.fmt_woc(tp.product_qty));

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

    private void do_clearall() {

        tf_price.setText("");
        tf_kilos.setText("");
    }

    private void prcss_work_on() {
//        if (callback == null) {
//            return;
//        }

        String product_name = ds_product.getText();
        double price = Double.parseDouble(tf_price.getText());
        double est_heads = Double.parseDouble(tf_kilos.getText());
        double no_of_heads = Double.parseDouble(tf_kilos.getText());
        to_admin_product tap = new to_admin_product(product_name, price, est_heads, no_of_heads);

//        S10_update_product.p_update_product(tap);
        callback.ok(new CloseDialog(this), new OutputData(tap));
        this.dispose();
    }

//    private class MyDispatcher implements KeyEventDispatcher {
//
//        @Override
//        public boolean dispatchKeyEvent(KeyEvent e) {
//            if (e.getID() == KeyEvent.KEY_RELEASED) {
//                if (e.getKeyCode() == KeyEvent.VK_F10) {
//                    change_product();
//
//                }
//            }
//
//
//
//            return false;
//        }
//    }
    private void do_key() {
//        KeyboardFocusManager manager = KeyboardFocusManager.
//                getCurrentKeyboardFocusManager();
//        manager.addKeyEventDispatcher(new MyDispatcher());
    }

    private void change_product() {
        String name = ds_product.getText();
        Window w = (Window) this;
        Dlg_update_product d = Dlg_update_product.create(w, true);
        d.setTitle("update");
        d.pass(name);
        d.setCallback(new Dlg_update_product.Callback() {

            @Override
            public void ok(CloseDialog cd, Dlg_update_product.OutputData data) {
                cd.ok();

                do_ok2(data);
            }
        });

        Application.locateOnParentCenter(w, d);

        d.setVisible(true);
    }

    private void do_ok2(Dlg_update_product.OutputData data) {
        if (callback != null) {

            to_admin_product tap = new to_admin_product("", 0, 0, 0);
            callback.ok(new CloseDialog(this), new OutputData(tap));
        }
        this.dispose();
    }
}
