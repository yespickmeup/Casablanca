/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dlg_logout.java
 *
 * Created on Nov 19, 2011, 10:47:33 AM
 */
package POS.dlg;

import POS.svc.S11_cash_out;
import POS.svc2.S12_cashier_sessions;
import POS.svc2.S16_ret_cashier_sales;
import POS.utl.Backspace;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.CurrencyDocument;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_logout1 extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class OutputData {

        public String user;

        public OutputData(String user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "OutputData{" + "user=" + user + '}';
        }
    }

    public static class InputData {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_logout1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_logout1(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_logout1() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_logout1 myRef;

    private void setThisRef(Dlg_logout1 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_logout1> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_logout1 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_logout1 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_logout1 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_logout1((java.awt.Frame) parent, false);
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
            Dlg_logout1 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_logout1((java.awt.Dialog) parent, false);
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


        Dlg_logout1 dialog = Dlg_logout1.create(new javax.swing.JFrame(), true);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_ok = new javax.swing.JButton();
        btn_clearall = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_cashcount = new javax.swing.JButton();
        lbl_addtlcash = new javax.swing.JLabel();
        btn_addtlcash = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        lbl_cashcount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_cashcount1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ds_title.setText("Logout");
        jPanel2.add(ds_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 120, 31));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 9, 149));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("(Please ensure correct entry of cash in the fields below.)");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 360, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 440, 60));

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
        jPanel6.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, 60));

        btn_clearall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields1.png"))); // NOI18N
        btn_clearall.setBorderPainted(false);
        btn_clearall.setContentAreaFilled(false);
        btn_clearall.setFocusable(false);
        btn_clearall.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields-MO.png"))); // NOI18N
        btn_clearall.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields-MO.png"))); // NOI18N
        btn_clearall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearallActionPerformed(evt);
            }
        });
        jPanel6.add(btn_clearall, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 70, 60));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_clear.setBorderPainted(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setFocusable(false);
        btn_clear.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_clear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel6.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 80, 60));

        btn_cashcount.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_cashcount.setForeground(new java.awt.Color(41, 9, 149));
        btn_cashcount.setText("Cash Count");
        btn_cashcount.setFocusable(false);
        btn_cashcount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cashcountActionPerformed(evt);
            }
        });
        jPanel6.add(btn_cashcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 20));

        lbl_addtlcash.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        lbl_addtlcash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel6.add(lbl_addtlcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 20, 20));

        btn_addtlcash.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_addtlcash.setForeground(new java.awt.Color(41, 9, 149));
        btn_addtlcash.setText("Addtl Cash");
        btn_addtlcash.setFocusable(false);
        btn_addtlcash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addtlcashActionPerformed(evt);
            }
        });
        jPanel6.add(btn_addtlcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 20, 30));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(41, 9, 149));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CLOSE");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 80, 20));

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(149, 9, 12));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("(ESCAPE)");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, 20));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(149, 9, 12));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("(F5)");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 70, 20));

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(149, 9, 12));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("(ENTER)");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 80, -1));

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(41, 9, 149));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("OK");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 80, -1));

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(41, 9, 149));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CLEAR ");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 70, 20));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 440, 110));

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
        pnl_numpad.add(btn_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 110, 80));

        btn_6.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_6.setForeground(new java.awt.Color(41, 9, 149));
        btn_6.setText("6");
        btn_6.setFocusable(false);
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 110, 80));

        btn_8.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_8.setForeground(new java.awt.Color(41, 9, 149));
        btn_8.setText("8");
        btn_8.setFocusable(false);
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, 80));

        btn_4.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_4.setForeground(new java.awt.Color(41, 9, 149));
        btn_4.setText("4");
        btn_4.setFocusable(false);
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 80));

        btn_5.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_5.setForeground(new java.awt.Color(41, 9, 149));
        btn_5.setText("5");
        btn_5.setFocusable(false);
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 110, 80));

        btn_7.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_7.setForeground(new java.awt.Color(41, 9, 149));
        btn_7.setText("7");
        btn_7.setFocusable(false);
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 80));

        btn_3.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_3.setForeground(new java.awt.Color(41, 9, 149));
        btn_3.setText("3");
        btn_3.setFocusable(false);
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 110, 80));

        btn_1.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_1.setForeground(new java.awt.Color(41, 9, 149));
        btn_1.setText("1");
        btn_1.setFocusable(false);
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 80));

        btn_2.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_2.setForeground(new java.awt.Color(41, 9, 149));
        btn_2.setText("2");
        btn_2.setFocusable(false);
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 110, 80));

        btn_0.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_0.setForeground(new java.awt.Color(41, 9, 149));
        btn_0.setText("0");
        btn_0.setFocusable(false);
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 220, 60));

        btn_dot.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_dot.setForeground(new java.awt.Color(41, 9, 149));
        btn_dot.setText(".");
        btn_dot.setFocusable(false);
        btn_dot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dotActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 110, 60));

        jPanel1.add(pnl_numpad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 350, 320));

        lbl_cashcount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_cashcount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbl_cashcount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_cashcountActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_cashcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 290, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("USD:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 60, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Php:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 60, 50));

        lbl_cashcount1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_cashcount1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbl_cashcount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_cashcount1ActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_cashcount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 290, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_cashcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cashcountActionPerformed
    do_cashcount();
}//GEN-LAST:event_btn_cashcountActionPerformed

private void btn_addtlcashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addtlcashActionPerformed
    do_addtlcash();
}//GEN-LAST:event_btn_addtlcashActionPerformed

private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
//    do_cancel();
//    clear_field();
    this.dispose();
}//GEN-LAST:event_btn_clearActionPerformed

private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
    do_ok();
}//GEN-LAST:event_btn_okActionPerformed

private void btn_clearallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearallActionPerformed
    do_clearall();
}//GEN-LAST:event_btn_clearallActionPerformed

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

    private void lbl_cashcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_cashcountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_cashcountActionPerformed

    private void lbl_cashcount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_cashcount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_cashcount1ActionPerformed

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
    private javax.swing.JButton btn_clearall;
    private javax.swing.JButton btn_dot;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel ds_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_addtlcash;
    private javax.swing.JTextField lbl_cashcount;
    private javax.swing.JTextField lbl_cashcount1;
    private javax.swing.JPanel pnl_numpad;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">

    private void myInit() {
        initActionKey();
        initTfDummy();
        lbl_addtlcash.setVisible(false);
        btn_addtlcash.setVisible(false);
//        btn_cancel.setVisible(false);
        btn_cashcount.setVisible(false);


//        JOptionPane.showMessageDialog(null, OutputData.);
    }

    private void clear_field() {
        Backspace.clear_lbl(lbl_cashcount);
        tf_dummy.setText(lbl_cashcount.getText());
    }
    public String user = "";

    public void pass(String user_name) {

        user = user_name;

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
                do_ok();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                do_clearall();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_C, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                do_cashcount();
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
        lbl_cashcount.setText(tf_dummy.getText());

    }
    //</editor-fold>

    private void numbers_only() {
//        lbl_cashcount.setDo
    }

    public void pass1(String userName) {
        user = userName;
    }

    public void load(InputData data) {
    }

    private void do_cashcount() {
        Window w = (Window) this.getSurface().
                getTopLevelAncestor();
        Dlg_numpad d = Dlg_numpad.create(w, true);
        d.setTitle("Cash Counted");

        d.setCallback(new Dlg_numpad.Callback() {

            @Override
            public void ok(CloseDialog cd, Dlg_numpad.OutputData data) {
                process_cashcount_ok(cd, data);
            }
        });
        Application.locateOnParentCenter(w, d);
        d.setVisible(true);

    }

    private void process_cashcount_ok(CloseDialog cd, Dlg_numpad.OutputData data) {
        lbl_cashcount.setText(data.input);
        cd.ok();
    }

    private void do_addtlcash() {
        Window w = (Window) this.getSurface().
                getTopLevelAncestor();
        Dlg_numpad d = Dlg_numpad.create(w, true);
        d.setTitle("Additional Cash");

        d.setCallback(new Dlg_numpad.Callback() {

            @Override
            public void ok(CloseDialog cd, Dlg_numpad.OutputData data) {
                process_addtlcash_ok(cd, data);
            }
        });

        Application.locateOnParentCenter(w, d);
        d.setVisible(true);
    }

    private void process_addtlcash_ok(CloseDialog cd, Dlg_numpad.OutputData data) {

        lbl_addtlcash.setText(data.input);
        cd.ok();
    }

    private void do_clearall() {

//        lbl_cashcount.setText("");
        tf_dummy.setText("");
        lbl_cashcount.setText(tf_dummy.getText());
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
        final String user_name = S12_cashier_sessions.get_cashier_user_name(user);

        final int ses_id = S12_cashier_sessions.get_cashier_ses_id(user_name);

        double addtl_cash = 0.0;
        final double cash_out = FitIn.toDouble(lbl_cashcount.getText());
        if (lbl_addtlcash.getText().
                isEmpty()) {
            addtl_cash = 0;
        } else {
            addtl_cash = FitIn.toDouble(lbl_addtlcash.getText());
        }

        final double add_c = addtl_cash;
        double total = cash_out + addtl_cash;

        Window w = (Window) this;
        Dlg_check_cashier_sales d = Dlg_check_cashier_sales.create(w, true);
        d.setTitle("Check Sales?");


        double sales = S16_ret_cashier_sales.ret_sales(ses_id);

        d.pass(total, sales);
        d.setCallback(new Dlg_check_cashier_sales.Callback() {

            @Override
            public void ok(CloseDialog cd, Dlg_check_cashier_sales.OutputData data) {
                do_ok1(ses_id, user_name, cash_out, add_c);

            }
        });

        Application.locateOnParentCenter(w, d);

        d.setVisible(true);


    }

    private void do_ok1(int id, String user_name, double cash_out, double addtl_cash) {

        S11_cash_out.p_cash_count(id, cash_out, addtl_cash);

        S12_cashier_sessions.update_sessions(user_name);

        callback.ok(new CloseDialog(this), new OutputData(""));
        this.dispose();
    }
}
