/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlg_cash_in.java
 *
 * Created on Feb 4, 2012, 2:29:28 PM
 */
package POS.dlg;

import POS.svc2.S12_cashier_sessions;
import POS.svc2.S13_cash_drawer;
import POS.utl.Backspace;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.CurrencyDocument;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_cash_in extends javax.swing.JDialog {

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

        public final int cashier_session_id;
        public final String cashier_name;

        public InputData(int cashier_session_id, String cashier_name) {
            this.cashier_session_id = cashier_session_id;
            this.cashier_name = cashier_name;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_cash_in(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_cash_in(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_cash_in() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_cash_in myRef;

    private void setThisRef(Dlg_cash_in myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_cash_in> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_cash_in create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_cash_in create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_cash_in dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cash_in((java.awt.Frame) parent, false);
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
            Dlg_cash_in dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_cash_in((java.awt.Dialog) parent, false);
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


        Dlg_cash_in dialog = Dlg_cash_in.create(new javax.swing.JFrame(), true);
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
        lb_name = new javax.swing.JLabel();
        pnl_numpad = new javax.swing.JPanel();
        btn_9 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_dot = new javax.swing.JButton();
        lbl_cash_in = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_ok = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btn_clear_all = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        btn_cashcount = new javax.swing.JButton();
        lbl_addtlcash = new javax.swing.JLabel();
        btn_addtlcash = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(159, 207, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_name.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lb_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lb_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 370, 30));

        pnl_numpad.setBackground(new java.awt.Color(159, 207, 243));
        pnl_numpad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 9, 149), 3, true));
        pnl_numpad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_9.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_9.setForeground(new java.awt.Color(41, 9, 149));
        btn_9.setText("9");
        btn_9.setFocusable(false);
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 140, 90));

        btn_6.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_6.setForeground(new java.awt.Color(41, 9, 149));
        btn_6.setText("6");
        btn_6.setFocusable(false);
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 140, 90));

        btn_8.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_8.setForeground(new java.awt.Color(41, 9, 149));
        btn_8.setText("8");
        btn_8.setFocusable(false);
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 140, 90));

        btn_4.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_4.setForeground(new java.awt.Color(41, 9, 149));
        btn_4.setText("4");
        btn_4.setFocusable(false);
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 90));

        btn_5.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_5.setForeground(new java.awt.Color(41, 9, 149));
        btn_5.setText("5");
        btn_5.setFocusable(false);
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 140, 90));

        btn_7.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_7.setForeground(new java.awt.Color(41, 9, 149));
        btn_7.setText("7");
        btn_7.setFocusable(false);
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 90));

        btn_3.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_3.setForeground(new java.awt.Color(41, 9, 149));
        btn_3.setText("3");
        btn_3.setFocusable(false);
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 140, 90));

        btn_1.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_1.setForeground(new java.awt.Color(41, 9, 149));
        btn_1.setText("1");
        btn_1.setFocusable(false);
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 140, 90));

        btn_2.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_2.setForeground(new java.awt.Color(41, 9, 149));
        btn_2.setText("2");
        btn_2.setFocusable(false);
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 140, 90));

        btn_0.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_0.setForeground(new java.awt.Color(41, 9, 149));
        btn_0.setText("0");
        btn_0.setFocusable(false);
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 290, 90));

        btn_dot.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_dot.setForeground(new java.awt.Color(41, 9, 149));
        btn_dot.setText(".");
        btn_dot.setFocusable(false);
        btn_dot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dotActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 140, 90));

        jPanel2.add(pnl_numpad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 460, 410));

        lbl_cash_in.setBackground(new java.awt.Color(0, 0, 0));
        lbl_cash_in.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        lbl_cash_in.setForeground(java.awt.Color.green);
        lbl_cash_in.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cash_in.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_cash_in.setOpaque(true);
        jPanel2.add(lbl_cash_in, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 370, 50));

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        btn_ok.setBorderPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setFocusable(false);
        btn_ok.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        jPanel6.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 60, 51));

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(149, 9, 12));
        jLabel9.setText("(F5)");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 40, 20));

        btn_clear_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields1.png"))); // NOI18N
        btn_clear_all.setBorderPainted(false);
        btn_clear_all.setContentAreaFilled(false);
        btn_clear_all.setFocusable(false);
        btn_clear_all.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields-MO.png"))); // NOI18N
        btn_clear_all.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields-MO.png"))); // NOI18N
        btn_clear_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear_allActionPerformed(evt);
            }
        });
        jPanel6.add(btn_clear_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 70, 49));

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(41, 9, 149));
        jLabel12.setText("CLEAR ");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 70, 20));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_clear.setBorderPainted(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setFocusable(false);
        btn_clear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel6.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, 50));

        btn_cashcount.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_cashcount.setForeground(new java.awt.Color(41, 9, 149));
        btn_cashcount.setText("Cash Count");
        btn_cashcount.setFocusable(false);
        btn_cashcount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cashcountActionPerformed(evt);
            }
        });
        jPanel6.add(btn_cashcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 20));

        lbl_addtlcash.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        lbl_addtlcash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel6.add(lbl_addtlcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 30, 30));

        btn_addtlcash.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_addtlcash.setForeground(new java.awt.Color(41, 9, 149));
        btn_addtlcash.setText("Addtl Cash");
        btn_addtlcash.setFocusable(false);
        btn_addtlcash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addtlcashActionPerformed(evt);
            }
        });
        jPanel6.add(btn_addtlcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 30, 30));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(41, 9, 149));
        jLabel10.setText("OK");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 30, -1));

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(149, 9, 12));
        jLabel11.setText("(ENTER)");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 80, -1));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(41, 9, 149));
        jLabel13.setText("CLOSE");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 70, 20));

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(149, 9, 12));
        jLabel14.setText("ESCAPE");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 70, 20));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 470, 100));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel2.setText("Cash In:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 50));

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel3.setText("Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 80, 30));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("CASH IN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 480, 90));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
}//GEN-LAST:event_formWindowClosing

private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
    do_9();
}//GEN-LAST:event_btn_9ActionPerformed

private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
    do_6();
}//GEN-LAST:event_btn_6ActionPerformed

private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
    do_8();
}//GEN-LAST:event_btn_8ActionPerformed

private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
    do_4();
}//GEN-LAST:event_btn_4ActionPerformed

private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
    do_5();
}//GEN-LAST:event_btn_5ActionPerformed

private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
    do_7();
}//GEN-LAST:event_btn_7ActionPerformed

private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
    do_3();
}//GEN-LAST:event_btn_3ActionPerformed

private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
    do_1();
}//GEN-LAST:event_btn_1ActionPerformed

private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
    do_2();
}//GEN-LAST:event_btn_2ActionPerformed

private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
    do_0();
}//GEN-LAST:event_btn_0ActionPerformed

private void btn_dotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dotActionPerformed
    do_dot();
}//GEN-LAST:event_btn_dotActionPerformed

private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
//    do_ok();
    add_cashin();
}//GEN-LAST:event_btn_okActionPerformed

private void btn_clear_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear_allActionPerformed
    do_clearall();
}//GEN-LAST:event_btn_clear_allActionPerformed

private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
//    do_cancel();
//     clear_field();
    System.exit(1);
}//GEN-LAST:event_btn_clearActionPerformed

private void btn_cashcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cashcountActionPerformed
}//GEN-LAST:event_btn_cashcountActionPerformed

private void btn_addtlcashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addtlcashActionPerformed
}//GEN-LAST:event_btn_addtlcashActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_addtlcash;
    private javax.swing.JButton btn_cashcount;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_clear_all;
    private javax.swing.JButton btn_dot;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel ds_title;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lbl_addtlcash;
    private javax.swing.JLabel lbl_cash_in;
    private javax.swing.JPanel pnl_numpad;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">

    private void myInit() {
        initActionKey();
        initTfDummy();
        init_number_only();
        lbl_addtlcash.setVisible(false);
        btn_addtlcash.setVisible(false);
//        btn_cancel.setVisible(false);
        btn_cashcount.setVisible(false);
    }

    private void do_clearall() {

//        lbl_cashcount.setText("");
        tf_dummy.setText("");
        lbl_cash_in.setText(tf_dummy.getText());
    }

    private void init_number_only() {
//        tf_cash_in.setDocument(new CurrencyDocument(true, 100));
    }

    private void clear_field() {
        Backspace.clear_lbl(lbl_cash_in);
        tf_dummy.setText(lbl_cash_in.getText());
    }

    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_BACK_SPACE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clear_field();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ENTER, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add_cashin();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD0, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_0.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_0, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_0.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_1.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_1.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_2.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_2.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_3.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_3.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD4, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_4.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_4, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_4.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_5.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_5.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD6, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_6.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_6, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_6.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD7, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_7.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_7, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_7.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD8, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_8.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_8, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_8.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD9, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_9.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_9, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_9.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_DECIMAL, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_dot.doClick();
            }
        });

    }

    private void do_7() {
        put_text("7");
    }

    private void do_8() {
        put_text("8");
    }

    private void do_9() {
        put_text("9");
    }

    private void do_4() {
        put_text("4");
    }

    private void do_5() {
        put_text("5");
    }

    private void do_6() {
        put_text("6");
    }

    private void do_1() {
        put_text("1");
    }

    private void do_2() {
        put_text("2");
    }

    private void do_3() {
        put_text("3");
    }

    private void do_0() {
        put_text("0");
    }

    private void do_dot() {
        put_text(".");
    }

    private void initTfDummy() {
        tf_dummy = new JTextField();
        CurrencyDocument cd = new CurrencyDocument(true, 10);
        tf_dummy.setDocument(cd);
    }
    private JTextField tf_dummy;

    private void put_text(String str) {
        CurrencyDocument.decimalInserter(tf_dummy, str);
        lbl_cash_in.setText(tf_dummy.getText());
    }

    //</editor-fold>
    public void load(InputData data) {
    }

    private void cancel() {
        this.setVisible(false);
    }

    private void do_ok() {
        if (callback == null) {
            return;
        }

//        Executor.doExecute(this, new Executor.Task() {
//
//            @Override
//            public void work_on() {
        prcss_work_on();
//            }
//        });
    }

    private void prcss_work_on() {
        callback.ok(new CloseDialog(this), new OutputData());
    }
    private InputData input;
    int user_lvl = -1;

    public void pass(InputData inputData) {
        this.input = inputData;

        lb_name.setText(input.cashier_name);
    }

    public void pass2(int user_level) {
        user_lvl = user_level;
    }

    private void add_cashin() {

        String un = lb_name.getText();



//        JOptionPane.showMessageDialog(null, id+ " - "+un);
//        Double.parseDouble(tf_cash_in.getText());
        double cashin = 0.0;
        if (lbl_cash_in.getText().
                isEmpty()) {
//            cashin = 0.0;
//            JOptionPane.showMessageDialog(null, "Input Amount");
            return;
        } else {
            cashin = Double.parseDouble(lbl_cash_in.getText());
        }
        S12_cashier_sessions.add_cashier_session(un, user_lvl);
        int id = S12_cashier_sessions.get_cashier_ses_id(un);
        S13_cash_drawer.do_save_cash_in(id, un, cashin);

        callback.ok(new CloseDialog(this), new OutputData());
        this.dispose();
    }
}
