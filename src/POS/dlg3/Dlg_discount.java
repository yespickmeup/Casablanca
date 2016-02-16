/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg3;

import POS.Main;
import POS.discount.S1_add_customer_discount;
import POS.dlg2.dlg_keyboard;
import POS.to2.to_credit;
import POS.utl.Bottom;
import POS_svc3.S2_get_discounts;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.CloseDialog;

/**
 *
 * @author Dummy
 */
public class Dlg_discount extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_discount
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

        public final String disc_name;
        public final String disc_percent;
        public final String cust_name;
        public final String cust_num;
        public final String cust_address;
        public final String tot_disc;

        public OutputData(String disc_name, String disc_percent, String cust_name, String cust_num, String cust_address, String tot_disc) {
            this.disc_name = disc_name;
            this.disc_percent = disc_percent;
            this.cust_name = cust_name;
            this.cust_num = cust_num;
            this.cust_address = cust_address;
            this.tot_disc = tot_disc;
        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_discount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_discount(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_discount() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_discount myRef;

    private void setThisRef(Dlg_discount myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_discount> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_discount create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_discount create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_discount dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_discount((java.awt.Frame) parent, false);
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
            Dlg_discount dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_discount((java.awt.Dialog) parent, false);
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


        Dlg_discount dialog = Dlg_discount.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_type = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        lb_rate = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        ds_title4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cb_cust_name = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tf_cust_no = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_address = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("TYPE:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 50, 40));

        cb_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_typeActionPerformed(evt);
            }
        });
        jPanel1.add(cb_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 341, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("%");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 40));

        lb_rate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_rate.setText("12");
        lb_rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_rate.setOpaque(true);
        jPanel1.add(lb_rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 142, 70, 40));

        jPanel7.setBackground(java.awt.Color.white);
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title4.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title4.setForeground(new java.awt.Color(41, 9, 149));
        ds_title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title4.setText("DISCOUNT");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 730, 60));

        jPanel8.setBackground(java.awt.Color.white);
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CUSTOMER NAME:");

        cb_cust_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_cust_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cust_nameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("CARD/ID #:");

        tf_cust_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_cust_no.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cust_noMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("CUSTOMER ADDRESS:");

        tf_address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_addressMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cb_cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tf_cust_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tf_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_address, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cust_no, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 730, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("RATE:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 146, 50, 30));

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_typeActionPerformed
        // TODO add your handling code here:
        get_rate();
    }//GEN-LAST:event_cb_typeActionPerformed

    private void tf_cust_noMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cust_noMouseClicked
        // TODO add your handling code here:
//        keyboard(tf_cust_no);
    }//GEN-LAST:event_tf_cust_noMouseClicked

    private void tf_addressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_addressMouseClicked
        // TODO add your handling code here:
//        keyboard(tf_address);
    }//GEN-LAST:event_tf_addressMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        discount();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb_cust_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cust_nameActionPerformed
        choose();
    }//GEN-LAST:event_cb_cust_nameActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_cust_name;
    private javax.swing.JComboBox cb_type;
    private javax.swing.JLabel ds_title4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lb_rate;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_cust_no;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        jLabel4.setVisible(false);
        cb_cust_name.setVisible(false);
        jLabel5.setVisible(false);
        tf_cust_no.setVisible(false);
        jLabel6.setVisible(false);
        tf_address.setVisible(false);
//        Main.MyDB.setNames("db_pos_restaurant");
        init_cb();
//        cb_cust_name.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//            }
//        });
    }

    private void choose() {
        if (!datas_cus.isEmpty()) {


            int sel = cb_cust_name.getSelectedIndex();
//                    JOptionPane.showMessageDialog(null, sel);
            if (sel == -1) {
            } else {
//                System.out.println(datas_cus.size() + " = " + sel);
                final S1_add_customer_discount.to_customer_discounts to = (S1_add_customer_discount.to_customer_discounts) datas_cus.get(sel);
                tf_cust_no.setText(to.card_no);
                tf_address.setText(to.address);
            }

        }
    }

    public void do_pass(to_credit to_c, String member_id) {

        if (to_c.card_holder.equals("")) {
//            tf_cust_name.setText("");
            tf_cust_no.setText("0");
            tf_address.setText("");
            cb_cust_name.setEnabled(true);
            tf_cust_no.setEnabled(true);
            tf_address.setEnabled(true);

        } else {
            cb_cust_name.setSelectedItem(to_c.card_holder);
            tf_cust_no.setText(member_id);
            tf_address.setText(to_c.credit_card_no);
            cb_cust_name.setEnabled(false);
            tf_cust_no.setEnabled(false);
            tf_address.setEnabled(false);
        }
    }
    List<S1_add_customer_discount.to_customer_discounts> datas_cus = new ArrayList();

    private void init_cb() {
        datas_cus.clear();
        cb_type.setModel(new ListComboBoxModel(S2_get_discounts.get_discounts_for_cb()));
        get_rate();
        List<String> cust1 = new ArrayList();
        datas_cus = S1_add_customer_discount.ret_data("");
        for (S1_add_customer_discount.to_customer_discounts to : datas_cus) {
            cust1.add(to.customer_name);
        }
        cb_cust_name.setEditable(true);
        AutoCompleteDecorator.decorate(cb_cust_name);
        cb_cust_name.setModel(new ListComboBoxModel(cust1));
    }

    private void get_rate() {
        int row = cb_type.getItemCount();
        if (row <= 0) {
            return;
        }
        System.out.println(cb_type.getSelectedItem().
                toString());
        String rate = S2_get_discounts.get_discounts_rate(cb_type.getSelectedItem().
                toString());
        lb_rate.setText(rate);
//         System.out.println(rate);
    }

    private void ok1() {
        String disc_name = cb_type.getSelectedItem().
                toString();
        String rate = lb_rate.getText();
        String name = cb_cust_name.getSelectedItem().
                toString();
        String num = tf_cust_no.getText();
        String address = tf_address.getText();

        int id = 0;
        String customer_name = cb_cust_name.getSelectedItem().
                toString();
        String card_no = tf_cust_no.getText();

        S1_add_customer_discount.to_customer_discounts to = new S1_add_customer_discount.to_customer_discounts(id, customer_name, card_no, address);
        S1_add_customer_discount.add_data(to);
        init_cb();

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(disc_name, rate, name, num, address, ""));
        }
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
            }
        });
        Bottom.setBottom(nd);
//        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void discount() {
        Window p = (Window) this;
        Dlg_add_discount nd = Dlg_add_discount.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_add_discount.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_discount.OutputData data) {
//                closeDialog.ok();
                init_cb();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
}
