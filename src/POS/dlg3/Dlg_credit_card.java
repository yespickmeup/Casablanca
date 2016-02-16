/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg3;

import POS.dlg2.dlg_keyboard;
import POS.remitances.Dlg_credit_card_2;
import POS.svc4.S1_bank;
import POS.svc4.S4_charge_invoice;
import POS.to2.to_credit;
import POS.utl.NumType;
import POS.utl.Prompt;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.JComponent;
import javax.swing.JTextField;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Dummy
 */
public class Dlg_credit_card extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_credit_card
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void credit(CloseDialog closeDialog, OutputData data);

        void prepaid(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final to_credit to;
        public final String pay_mode;

        public OutputData(to_credit to, String pay_mode) {
            this.to = to;
            this.pay_mode = pay_mode;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_credit_card(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_credit_card(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_credit_card() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_credit_card myRef;

    private void setThisRef(Dlg_credit_card myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_credit_card> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_credit_card create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_credit_card create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_credit_card dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_credit_card((java.awt.Frame) parent, false);
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
            Dlg_credit_card dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_credit_card((java.awt.Dialog) parent, false);
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


        Dlg_credit_card dialog = Dlg_credit_card.create(new javax.swing.JFrame(), true);
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

        jPanel2 = new javax.swing.JPanel();
        tf_owner = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_address = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_contact_no = new javax.swing.JTextField();
        tf_amount = new javax.swing.JTextField();
        tf_ci_num = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lb_balance = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_type = new javax.swing.JComboBox();
        cb_bank = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btn_cancel1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_ok1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(159, 207, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_owner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_owner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_ownerMouseClicked(evt);
            }
        });
        tf_owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ownerActionPerformed(evt);
            }
        });
        jPanel2.add(tf_owner, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 478, 33));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CUSTOMER NAME:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ADDRESS:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        tf_address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_addressMouseClicked(evt);
            }
        });
        jPanel2.add(tf_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 478, 33));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("CHARGE INVOICE #:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("CONTACT NUMBER:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 30));

        tf_contact_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_contact_no.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_contact_noMouseClicked(evt);
            }
        });
        tf_contact_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contact_noActionPerformed(evt);
            }
        });
        jPanel2.add(tf_contact_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 320, 30));

        tf_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_amount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_amountMouseClicked(evt);
            }
        });
        tf_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_amountActionPerformed(evt);
            }
        });
        jPanel2.add(tf_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 176, 33));

        tf_ci_num.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_ci_num.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_ci_numMouseClicked(evt);
            }
        });
        tf_ci_num.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tf_ci_numMouseDragged(evt);
            }
        });
        tf_ci_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ci_numActionPerformed(evt);
            }
        });
        jPanel2.add(tf_ci_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 210, 33));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("BALANCE:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 30));

        lb_balance.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_balance.setToolTipText("");
        lb_balance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lb_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 210, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("CARD TYPE:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 20, 10));

        cb_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cb_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 10, 20));

        cb_bank.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_bank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_bankActionPerformed(evt);
            }
        });
        jPanel2.add(cb_bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BANK");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 10));

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setFocusable(false);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        jButton8.setText("CLOSE");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(899, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1060, 70));

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setFocusable(false);

        btn_cancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_cancel1.setBorderPainted(false);
        btn_cancel1.setContentAreaFilled(false);
        btn_cancel1.setFocusable(false);
        btn_cancel1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(41, 9, 149));
        jLabel19.setText("CLOSE");

        jLabel20.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(149, 9, 12));
        jLabel20.setText("(ESCAPE)");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/prepaid.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/prepaid-MO.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/prepaid-MO.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(41, 9, 149));
        jLabel17.setText("PREPAID");

        jLabel18.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(149, 9, 12));
        jLabel18.setText("(F1)");

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(149, 9, 12));
        jLabel16.setText("(F2)");

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(41, 9, 149));
        jLabel15.setText("CREDIT");

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/credit.png"))); // NOI18N
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setFocusable(false);
        btn_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/credit-MO.png"))); // NOI18N
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/credit-MO.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_ok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/cash.png"))); // NOI18N
        btn_ok1.setBorderPainted(false);
        btn_ok1.setContentAreaFilled(false);
        btn_ok1.setFocusable(false);
        btn_ok1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/cash-MO.png"))); // NOI18N
        btn_ok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ok1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(41, 9, 149));
        jLabel13.setText("CASH");

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(149, 9, 12));
        jLabel14.setText("(F3)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cancel1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ok1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_ok1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel1)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 670, 140));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("AMOUNT:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_bankActionPerformed
        // TODO add your handling code here:
        get_card_types();
    }//GEN-LAST:event_cb_bankActionPerformed

    private void tf_ownerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ownerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ownerActionPerformed

    private void tf_ownerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_ownerMouseClicked
        // TODO add your handling code here:
//        keyboard(tf_owner);
//        cust();
    }//GEN-LAST:event_tf_ownerMouseClicked

    private void tf_addressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_addressMouseClicked
        // TODO add your handling code here:
//        keyboard(tf_card_number);
    }//GEN-LAST:event_tf_addressMouseClicked

    private void tf_contact_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contact_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_contact_noActionPerformed

    private void tf_contact_noMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_contact_noMouseClicked
        // TODO add your handling code here:
//        keyboard(tf_code);
    }//GEN-LAST:event_tf_contact_noMouseClicked

    private void tf_amountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_amountMouseClicked
        // TODO add your handling code here:
//        keyboard(tf_amount);
    }//GEN-LAST:event_tf_amountMouseClicked

    private void tf_ci_numMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_ci_numMouseClicked
        // TODO add your handling code here:
        keyboard(tf_ci_num);
    }//GEN-LAST:event_tf_ci_numMouseClicked

    private void tf_ci_numMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_ci_numMouseDragged
        // TODO add your handling code here:
        keyboard(tf_ci_num);
    }//GEN-LAST:event_tf_ci_numMouseDragged

    private void btn_ok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ok1ActionPerformed
//        do_ok();
        ok1();
    }//GEN-LAST:event_btn_ok1ActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
//    clear_field();
//        this.dispose();
        ok_credit();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ok_prepaid();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel1ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_btn_cancel1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tf_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_amountActionPerformed

    private void tf_ci_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ci_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ci_numActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_cancel1;
    private javax.swing.JButton btn_ok1;
    private javax.swing.JComboBox cb_bank;
    private javax.swing.JComboBox cb_type;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lb_balance;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_ci_num;
    private javax.swing.JTextField tf_contact_no;
    private javax.swing.JTextField tf_owner;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
//
//            this.setUndecorated(true);
//        } else {
////             JOptionPane.showMessageDialog(null, System.getProperty("os.name"));
//            this.setUndecorated(false);
//        }
        init_key();
//        init_bank();
//        get_card_types();
        gohide();
        init_num();
    }

    private void disabled() {
        tf_owner.enable(false);
        tf_address.enable(false);
        tf_contact_no.enable(false);
        tf_amount.enable(false);
    }

    private void gohide() {
        hide(cb_bank);
        hide(jLabel1);
        hide(jLabel6);
        hide(cb_type);
//       hide(cb_bank); hide(jLabel1);

    }

    private void init_num() {
        tf_ci_num.setText("" + S4_charge_invoice.get_ci_no());
    }
    double balance1 = 0;

    public void do_pass(String name, String address, String contact, double amount, double balance) {
        lb_balance.setText("" + NumType.with_comma(balance));
        balance1 = balance;
        am = amount;
        init_num();
        tf_owner.setText(name);
        tf_address.setText(address);
        tf_contact_no.setText(contact);
        tf_amount.setText("" + amount);
        disabled();
    }

    private void hide(JComponent comp) {
        comp.setVisible(false);
    }

    private void init_bank() {
        cb_bank.setModel(new ListComboBoxModel(S1_bank.get_banks()));
    }

    private void get_card_types() {
        if (cb_bank.getItemCount() == 0) {
            return;

        }
        String name = cb_bank.getSelectedItem().
                toString();
        String id = S1_bank.get_bank_id(name);
        cb_type.setModel(new ListComboBoxModel(S1_bank.get_types(id)));
    }
    double am = 0;

    public void do_pass(double amount) {
        am = amount;
        tf_amount.setText("" + amount);
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

    private void ok1() {
        if (callback != null) {
            if (tf_amount.getText().
                    isEmpty() || tf_owner.getText().
                    isEmpty() || tf_ci_num.getText().
                    isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Please Complete Details");
                Prompt.call("Please Complete Details");
                return;
            }




            if (Double.parseDouble(tf_amount.getText()) > am) {
                Prompt.call("Amount must be lesser than Due");
//                JOptionPane.showMessageDialog(null, "Amount must be lesser than Due");
                return;
            }
//        String bank = cb_bank.getSelectedItem().toString();
            String ci = tf_ci_num.getText();
//        String type = cb_type.getSelectedItem().toString();
            String type = "";
            to_credit to = new to_credit(tf_address.getText(), tf_owner.getText(), tf_contact_no.
                    getText(), ci, type, Double.parseDouble(tf_amount.getText()),0);
            if (callback != null) {
                callback.ok(new CloseDialog(this), new OutputData(to, "cash"));
            }
            this.disposed();
        }
    }

    private void ok_credit() {


        Window p = (Window) this;
        Dlg_credit_card_2 nd = Dlg_credit_card_2.create(p, true);
        nd.setTitle("");
        nd.do_pass(am);
        nd.setCallback(new Dlg_credit_card_2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_credit_card_2.OutputData data) {
                closeDialog.ok();
                tf_amount.setText("" + data.credit_amount);
                do_credt(data.app_code, data.bank, data.card_no, data.credit_amount, data.type);

            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void do_credt(String app_code, String bank, String card_no, double credit_amount, String type) {
        if (callback != null) {
            if (tf_amount.getText().
                    isEmpty() || tf_owner.getText().
                    isEmpty() || tf_ci_num.getText().
                    isEmpty()) {
                Prompt.call("Please Complete Details");
//                JOptionPane.showMessageDialog(null, "Please Complete Details");
                return;
            }

            if (Double.parseDouble(tf_amount.getText()) > am) {
                Prompt.call("Amount must be lesser than Due");
//                JOptionPane.showMessageDialog(null, "Amount must be lesser than Due");
                return;
            }
//        String bank = cb_bank.getSelectedItem().toString();
            String ci = tf_ci_num.getText();
//        String type = cb_type.getSelectedItem().toString();
//            String type = "";
            to_credit to = new to_credit(card_no, tf_owner.getText(), app_code, bank, type, credit_amount,0);
            if (callback != null) {
                callback.credit(new CloseDialog(this), new OutputData(to, "credit"));
            }
            this.disposed();
        }
    }

    private void ok_prepaid() {

        if (balance1 == 0) {
            Prompt.call("Sorry!!! Zero Balance");
//            JOptionPane.showMessageDialog(null, "Sorry!!! Zero Balance");
            return;
        }

        if (callback != null) {
            if (tf_amount.getText().
                    isEmpty() || tf_owner.getText().
                    isEmpty()) {
                Prompt.call("Please Complete Details");
//                JOptionPane.showMessageDialog(null, "Please Complete Details");
                return;
            }

            if (Double.parseDouble(tf_amount.getText()) > balance1) {
                Prompt.call("Out of Balance");
//                JOptionPane.showMessageDialog(null, "Out of Balance");
                return;
            }
            if (Double.parseDouble(tf_amount.getText()) > am) {
                Prompt.call("Amount must be lesser than Due");
//                JOptionPane.showMessageDialog(null, "Amount must be lesser than Due");
                return;
            }
//        String bank = cb_bank.getSelectedItem().toString();
            String ci = tf_ci_num.getText();
//        String type = cb_type.getSelectedItem().toString();
            String type = "";
            to_credit to = new to_credit(tf_address.getText(), tf_owner.getText(), tf_contact_no.
                    getText(), ci, type, Double.parseDouble(tf_amount.getText()),0);
            if (callback != null) {
                callback.credit(new CloseDialog(this), new OutputData(to, "prepaid"));
            }
            this.disposed();
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
        Center.setCenter(nd);

        nd.setVisible(true);
    }
//    private void cust() {
//        Window p = (Window) this;
//        Dlg_customer_charges nd = Dlg_customer_charges.create(p, true);
//        nd.setTitle("");
//        nd.do_pass();
//        nd.setCallback(new Dlg_customer_charges.Callback() {
//
//            @Override
//            public void ok(CloseDialog closeDialog, Dlg_customer_charges.OutputData data) {
//                closeDialog.ok();
//                tf_owner.setText(data.name);
//                tf_card_number.setText(data.address);
//                tf_code.setText(data.con);
//            }
//        });
//        Center.setCenter(nd);
//
//        nd.setVisible(true);
//    }
}
