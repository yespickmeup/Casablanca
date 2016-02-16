/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlg_check_date.java
 *
 * Created on Jan 29, 2012, 9:13:40 PM
 */
package POS.dlg;

import POS.svc2.S5_ret_system_date;
import POS.to2.to_system_date;
import POS.utl.DateTo;
import POS.utl.DateType;
import POS.utl.Prompt;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.DateUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_check_date extends javax.swing.JDialog {

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
    private Dlg_check_date(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_check_date(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_check_date() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_check_date myRef;

    private void setThisRef(Dlg_check_date myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_check_date> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_check_date create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_check_date create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_check_date dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_check_date((java.awt.Frame) parent, false);
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
            Dlg_check_date dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_check_date((java.awt.Dialog) parent, false);
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


        Dlg_check_date dialog = Dlg_check_date.create(new javax.swing.JFrame(), true);
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

        lb_date = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lb_date1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_date.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lb_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_date.setAutoscrolls(true);
        lb_date.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lb_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 20, 330, 34));

        jButton1.setText("Yes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 118, 73, -1));

        jButton2.setText("No");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 118, 70, -1));

        lb_date1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lb_date1.setText("Is the Date Correct?");
        getContentPane().add(lb_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 72, 220, 34));

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    cancel();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    do_set_date();
}//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_date;
    private javax.swing.JLabel lb_date1;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc=" myInit ">
    private void myInit() {
        initActionKey();
        do_hide_date();
        set_date();
    }

    private void do_hide_date() {
//        dp_date.setVisible(false);
//        dp_ok.setVisible(false);
    }

    private void set_date() {

        String set = DateType.sf1.format(new Date());
        lb_date.setText(set);
    }

    private void do_set_na() {

        String date = DateType.sf.format(new Date());
        lb_date.setText(DateTo.date_comma(date));
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
    private String type;

    public void pass(String us_lvl) {
        type = us_lvl;
    }

    public void load(InputData data) {
    }

    private void cancel() {
        do_ok();

    }

    private void do_ok() {
        if (callback == null) {
            return;
        }


        prcss_work_on();

    }

    private void prcss_work_on() {

        String date = DateType.sf.format(new Date());

        to_system_date.setCurrent_date(new Date());
        callback.ok(new CloseDialog(this), new OutputData());
        this.dispose();
    }

    private void do_set_date() {
//        JOptionPane.showMessageDialog(null, type);
        if (type.equals("1")) {
            JOptionPane.showMessageDialog(null, "Change System Date");
//            Window w = (Window) this;
//            Dlg_set_date d = Dlg_set_date.create(w, true);
//            d.setTitle("Set Date");
//            d.setCallback(new Dlg_set_date.Callback() {
//
//                @Override
//                public void ok(CloseDialog cd, Dlg_set_date.OutputData data) {
//                    cd.ok();
//                    do_set_na();
//                    do_ok();
//                }
//            });
//
//            Application.locateOnParentCenter(w, d);
//
//            d.setVisible(true);

        } else {
             Prompt.call("Contact Administrator to change Date");
//            JOptionPane.showMessageDialog(null, "Contact Administrator to change Date");
            System.exit(1);
        }
    }
}
