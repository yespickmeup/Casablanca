/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlg_report2.java
 *
 * Created on Jan 29, 2012, 3:07:22 PM
 */
package POS.dlg;

import POS.Main;
import POS.currency.Dlg_currency;
import POS.currency.S1_currency;
import POS.printing2.S1_get_sales_for_the_day;
import POS.rpt2.rpt_report;
import POS.rpt2.to_date_from;
import POS.rpt2.to_date_to;
import POS.rpt_liquid.Srpt_liquid;
import POS.utl.DateType;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.Executor;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author u2
 */
public class Dlg_report2 extends javax.swing.JDialog {

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
    private Dlg_report2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_report2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_report2() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_report2 myRef;

    private void setThisRef(Dlg_report2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report2((java.awt.Frame) parent, false);
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
            Dlg_report2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report2((java.awt.Dialog) parent, false);
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


        Dlg_report2 dialog = Dlg_report2.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dp_dateto = new com.toedter.calendar.JDateChooser();
        dp_date = new com.toedter.calendar.JDateChooser();
        rb_period = new javax.swing.JRadioButton();
        rb_daily = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        ds_title = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(159, 207, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("SALES BY RECEIPTS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 217, 40));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel2.setText("Date To:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 182, -1));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel1.setText("Date from:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 120, -1));
        jPanel2.add(dp_dateto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 140, 30));
        jPanel2.add(dp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 150, 30));

        buttonGroup1.add(rb_period);
        rb_period.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        rb_period.setText("BY PERIOD");
        rb_period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_periodActionPerformed(evt);
            }
        });
        jPanel2.add(rb_period, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        buttonGroup1.add(rb_daily);
        rb_daily.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        rb_daily.setSelected(true);
        rb_daily.setText("DAILY");
        rb_daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_dailyActionPerformed(evt);
            }
        });
        jPanel2.add(rb_daily, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jButton4.setText("INVENTORY (STOCK-IN)");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 217, 40));

        jButton2.setText("PENDING");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 20, 40));

        jButton3.setText("INVENTORY (STOCKS LEFT)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 217, 40));

        jButton5.setText("CHARGES");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 20, 40));

        jButton6.setText("MEMBERS");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 217, 40));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setText("$");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 50, 50));

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("REPORTS");
        jPanel3.add(ds_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 13, 510, 22));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 26, 520, 50));

        jButton7.setText("CASH COUNT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 220, 42));

        jButton8.setText("PATRONAGE REFUND");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 20, 40));

        jButton9.setText("CLOSE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 220, 40));

        jButton10.setText("CREDIT SALES");
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 20, 40));

        jButton12.setText("SALES FOR THE DAY");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 220, 40));

        jButton13.setText("CREDIT SALES");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 220, 40));

        jButton14.setText("CASH SALES");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 220, 40));

        jButton15.setText("CASHIER SALES");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 220, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:

    do_sales();
}//GEN-LAST:event_jButton1ActionPerformed

private void rb_periodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_periodActionPerformed
// TODO add your handling code here:
    show_period();
}//GEN-LAST:event_rb_periodActionPerformed

private void rb_dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_dailyActionPerformed
// TODO add your handling code here:
    hide_period();
}//GEN-LAST:event_rb_dailyActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
    do_inventory();
}//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        do_pending();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        do_inventory_stocks_left();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        do_charges();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        do_custmers();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        do_refund();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        do_cash();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        currency();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        do_credit_sales();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        do_cash_sales();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        sales_for_the_day();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        cashier_sales();
    }//GEN-LAST:event_jButton15ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dp_date;
    private com.toedter.calendar.JDateChooser dp_dateto;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rb_daily;
    private javax.swing.JRadioButton rb_period;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
//        System.setProperty("version","resto");
        initActionKey();
        do_set_date();
        hide_period();
        b_name = System.getProperty("entityName", "");
        if (System.getProperty("version", "resto").
                equals("resto")) {
            jButton2.setVisible(false);
            jButton5.setVisible(false);
            jButton8.setVisible(false);
            jButton10.setVisible(false);
            jButton6.setText("GUESTS");
            jButton1.setText("SALES");
        } else {
            jButton2.setVisible(false);
            jButton5.setVisible(false);
            jButton8.setVisible(false);
            jButton10.setVisible(false);
        }
        if (System.getProperty("version", "ordering").
                equals("ordering")) {
            jButton6.setText("Customers");
            jButton6.setVisible(false);
        }
    }
    String b_name = "";

    public void do_pass(String name) {
        b_name = name;

    }

    private void do_set_date() {
//        Date date = S5_ret_system_date.do_ret_system_date();
        dp_date.setDate(new Date());
        dp_dateto.setDate(new Date());


    }

    private void hide_period() {
        dp_dateto.setVisible(false);
        jLabel2.setVisible(false);
        dp_date.setVisible(true);
    }

    private void show_period() {
        dp_dateto.setVisible(true);
        jLabel2.setVisible(true);
//        dp_date.setVisible(false);
    }

    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
    }
    //</editor-fold>

    public void load(InputData data) {
    }

    private void cancel() {
        this.dispose();
//        this.setVisible(false);
    }

    private void do_ok() {
//        if (callback == null) {
//            return;
//        }

//        Executor.doExecute(this, new Executor.Task() {
//
//            @Override
//            public void work_on() {
        rpt_report.do_report_inventory(dp_date.getDate());

//            }
//        });
    }

    private void prcss_work_on() {
        do_report();
//        callback.ok(new CloseDialog(this), new OutputData());
    }

    private void do_report() {
        Date date_from = dp_date.getDate();
        Date date_to = dp_dateto.getDate();
        rpt_report.do_admin_report(date_from, date_to);

    }

    private void do_report_all() {
//        Executor.doExecute(this, new Executor.Task() {
//
//            @Override
//            public void work_on() {
        do_all();

//            }
//        });

    }

    private void do_all() {

        Date date_from = dp_date.getDate();
        Date date_to = dp_dateto.getDate();
        rpt_report.do_admin_report_all(date_from, date_to);
        callback.ok(new CloseDialog(this), new OutputData());
    }
    String mydb = System.getProperty("mydb", "db_pos_casablanca");

    private void do_sales() {
//        String name = System.getProperty("entityName", "Intelink-One");
        double amount = S1_currency.ret_dollar(DateType.sf.format(new Date()));

        if (rb_daily.isSelected()) {
            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, amount);
//            Executor.doExecute(this, new Executor.Task() {
//
//                @Override
//                public void work_on() {
            if (System.getProperty("version", "resto").
                    equals("resto")) {
//                        rpt_report.pdf_viewer_receipts2(to, "rpt_receipts_w_category_liquid_1_1");
                JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_receipts_w_category_liquid.jrxml");
                JFrame f = Application.launchMainFrame3(viewer, "", true);
            } else {
                String print_to_receipt = System.getProperty("print_to_receipt", "true");
                if (print_to_receipt.equals("true")) {
                    rpt_report.pdf_viewer_receipts2(to, "rpt_receipts_w_category_casablanca_small_1_1");
                } else {
                    rpt_report.pdf_viewer_receipts2(to, "rpt_receipts_w_category_casablanca_2");
                }

            }
//                }
//            });
        } else {
            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, amount);
//            Executor.doExecute(this, new Executor.Task() {
//
//                @Override
//                public void work_on() {
            if (System.getProperty("version", "resto").
                    equals("resto")) {
//                          rpt_report.pdf_viewer_receipts2(to, "rpt_receipts_w_category_liquid_1_1");
                JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_receipts_w_category_liquid.jrxml");
                JFrame f = Application.launchMainFrame3(viewer, "", true);
            } else {
                rpt_report.pdf_viewer_receipts2(to, "rpt_receipts_w_category_casablanca");
            }
//                }
//            });
//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void do_credit_sales() {
//        String name = System.getProperty("entityName", "Intelink-One");
        double amount = S1_currency.ret_dollar(DateType.sf.format(new Date()));

        if (rb_daily.isSelected()) {
            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, amount);

            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    if (System.getProperty("version", "resto").
                            equals("resto")) {
//                        rpt_report.pdf_viewer_receipts2(to, "rpt_credits_1_1");
                        JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_credit_sales.jrxml");
                        JFrame f = Application.launchMainFrame3(viewer, "", true);
                    } else {
                        String print_to_receipt = System.getProperty("print_to_receipt", "true");
                        if (print_to_receipt.equals("true")) {
                            rpt_report.pdf_viewer_receipts2(to, "rpt_credits");
                        } else {
                            rpt_report.pdf_viewer_receipts2(to, "rpt_credits");
                        }

                    }
                }
            });
        } else {
            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, amount);
            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    if (System.getProperty("version", "resto").
                            equals("resto")) {
                        JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_credit_sales.jrxml");
                        JFrame f = Application.launchMainFrame3(viewer, "", true);
                    } else {
                        rpt_report.pdf_viewer_receipts2(to, "rpt_credits");
                    }
                }
            });
//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void do_cash_sales() {
//        String name = System.getProperty("entityName", "Intelink-One");
        double amount = S1_currency.ret_dollar(DateType.sf.format(new Date()));

        if (rb_daily.isSelected()) {
            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, amount);

            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    if (System.getProperty("version", "resto").
                            equals("resto")) {
//                        rpt_report.pdf_viewer_receipts2(to, "rpt_credits_cash_1_1_1_1");
                        JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_cash_sales.jrxml");
                        JFrame f = Application.launchMainFrame3(viewer, "", true);
                    } else {
                        String print_to_receipt = System.getProperty("print_to_receipt", "true");
                        if (print_to_receipt.equals("true")) {
                            rpt_report.pdf_viewer_receipts2(to, "rpt_credits_cash_1_1");
                        } else {
                            rpt_report.pdf_viewer_receipts2(to, "rpt_credits_cash_1_1");
                        }
                    }
                }
            });
        } else {
            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, amount);
            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    if (System.getProperty("version", "resto").
                            equals("resto")) {
                        JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_cash_sales.jrxml");
                        JFrame f = Application.launchMainFrame3(viewer, "", true);
                    } else {
                        rpt_report.pdf_viewer_receipts2(to, "rpt_credits_cash_1_1");
                    }
                }
            });
//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void sales_for_the_day() {
//        String name = System.getProperty("entityName", "Intelink-One");
        double amount = S1_currency.ret_dollar(DateType.sf.format(new Date()));

        if (rb_daily.isSelected()) {

            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    if (System.getProperty("version", "resto").
                            equals("resto")) {
                        final S1_get_sales_for_the_day.to_reciept_sales to = S1_get_sales_for_the_day.ret_data(DateType.sf.format(dp_date.getDate()), dp_date.getDate(), dp_date.getDate(), b_name, 0);

//                        rpt_report.pdf_viewer_sales_summary(to, "rpt_daily_sales_3_1_1_1");
                        JRViewer viewer = Srpt_liquid.get_viewer_conn_summary(to, "rpt_daily_sales_3_1_1_1.jrxml");
                        JFrame f = Application.launchMainFrame3(viewer, "", true);
                    } else {
                        final S1_get_sales_for_the_day.to_reciept_sales to = S1_get_sales_for_the_day.ret_data(DateType.sf.format(dp_date.getDate()), dp_date.getDate(), dp_date.getDate(), b_name, 0);

                        String print_to_receipt = System.getProperty("print_to_receipt", "true");
                        if (print_to_receipt.equals("true")) {
                            rpt_report.pdf_viewer_sales_summary(to, "rpt_daily_sales_3_1");
                        } else {
                            rpt_report.pdf_viewer_sales_summary(to, "rpt_daily_sales_3_1");
                        }
                    }
                }
            });
        } else {

            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    final S1_get_sales_for_the_day.to_reciept_sales to = S1_get_sales_for_the_day.ret_data(DateType.sf.format(dp_date.getDate()), dp_date.getDate(), dp_date.getDate(), b_name, 0);

                    if (System.getProperty("version", "resto").
                            equals("resto")) {
                        JRViewer viewer = Srpt_liquid.get_viewer_conn_summary(to, "rpt_daily_sales_3_1_1_1.jrxml");
                        JFrame f = Application.launchMainFrame3(viewer, "", true);
                    } else {
                        rpt_report.pdf_viewer_sales_summary(to, "rpt_daily_sales_3_1");
                    }
                }
            });
//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void do_inventory() {

        double amount = S1_currency.ret_dollar(DateType.sf.format(new Date()));
        final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, amount);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                if (System.getProperty("version", "resto").
                        equals("resto")) {
//                    rpt_report.pdf_viewer_receipts2(to, "rpt_inventory2_liquid");
                    JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_inventory2_liquid.jrxml");
                    JFrame f = Application.launchMainFrame3(viewer, "", true);
                } else {
                    rpt_report.pdf_viewer_receipts2(to, "rpt_inventory2_casablanca");
                }

            }
        });

//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());

//        }

    }

    private void do_inventory_stocks_left() {

        final to_date_from to = new to_date_from(dp_date.getDate(), b_name);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                if (System.getProperty("version", "resto").
                        equals("resto")) {
//                    rpt_report.pdf_viewer_receipts(to, "rpt_stocks_left_liquid_1");
                    JRViewer viewer = Srpt_liquid.get_viewer_from(to, "rpt_stocks_left_1.jrxml");
                    JFrame f = Application.launchMainFrame3(viewer, "", true);
                } else {
                    rpt_report.pdf_viewer_receipts(to, "rpt_stocks_left_casablanca_1");
                }

            }
        });




    }

    private void do_cash() {

        final to_date_from to = new to_date_from(dp_date.getDate(), b_name);

        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                if (System.getProperty("version", "resto").
                        equals("resto")) {

//                    rpt_report.pdf_viewer_receipts(to, "rpt_cash_in_out.jrxml");
                    JRViewer viewer = Srpt_liquid.get_viewer_from(to, "rpt_cash_in_out.jrxml");
                    JFrame f = Application.launchMainFrame3(viewer, "", true);
                } else {
                    rpt_report.pdf_viewer_receipts(to, "rpt_cash_in_out_casablanca_1");
                }
            }
        });
    }

    private void do_pending() {

//        rpt_report.do_pending();

        final to_date_from to = new to_date_from(new Date(), b_name);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_pendings(to, "rpt_pendings");
            }
        });

    }

    private void do_charges() {
        final to_date_from to = new to_date_from(new Date(), b_name);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_pendings(to, "rpt_charges");
            }
        });
    }

    private void do_custmers() {
        final to_date_from to = new to_date_from(new Date(), b_name);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_pendings(to, "rpt_customers_2");
                if (System.getProperty("version", "resto").
                        equals("resto")) {
                    rpt_report.pdf_viewer_pendings(to, "rpt_customers_2_1_1");
                } else {
                    rpt_report.pdf_viewer_pendings(to, "rpt_customers_2");
                }
            }
        });
    }

    private void do_refund() {
        final to_date_from to = new to_date_from(new Date(), b_name);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_pendings(to, "rpt_patronage_2");
            }
        });
    }

    private void currency() {
        Window p = (Window) this;
        Dlg_currency nd = Dlg_currency.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_currency.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_currency.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }

    private void cashier_sales() {
        if (rb_daily.isSelected()) {
            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, 0);
            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    if (System.getProperty("version", "resto").
                            equals("resto")) {
//                        rpt_report.pdf_viewer_receipts2(to, "rpt_cashier_sales_1_1");
                        JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_cashier_sales_1_1.jrxml");
                        JFrame f = Application.launchMainFrame3(viewer, "", true);
                    } else {
                        String print_to_receipt = System.getProperty("print_to_receipt", "true");
                        if (print_to_receipt.equals("true")) {
                            rpt_report.pdf_viewer_receipts2(to, "rpt_cashier_sales");
                        } else {
                            rpt_report.pdf_viewer_receipts2(to, "rpt_cashier_sales");
                        }
                    }
                }
            });
        } else {
            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name, mydb, 0);
            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    if (System.getProperty("version", "resto").
                            equals("resto")) {
//                        rpt_report.pdf_viewer_receipts2(to, "rpt_cashier_sales_1_1");
                        JRViewer viewer = Srpt_liquid.get_viewer_conn(to, "rpt_cashier_sales_1_1.jrxml");
                        JFrame f = Application.launchMainFrame3(viewer, "", true);
                    } else {
                        rpt_report.pdf_viewer_receipts2(to, "rpt_cashier_sales");
                    }
                }
            });
//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());
        }
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
