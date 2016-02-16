/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlg_report2.java
 *
 * Created on Jan 29, 2012, 3:07:22 PM
 */
package POS_dlg4;

import POS.dlg.*;
import POS.rpt2.rpt_report;
import POS.rpt2.to_date_from;
import POS.rpt2.to_date_to;
import POS.svc2.S5_ret_system_date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.logging.Level;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.Executor;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_report_endorsements extends javax.swing.JDialog {

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
    private Dlg_report_endorsements(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_report_endorsements(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_report_endorsements() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_report_endorsements myRef;

    private void setThisRef(Dlg_report_endorsements myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_report_endorsements> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_report_endorsements create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.MODELESS);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_report_endorsements create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_report_endorsements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_endorsements((java.awt.Frame) parent, false);
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
            Dlg_report_endorsements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_report_endorsements((java.awt.Dialog) parent, false);
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


        Dlg_report_endorsements dialog = Dlg_report_endorsements.create(new javax.swing.JFrame(), true);
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
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(159, 207, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SALES (OVERALL)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 284, 40));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel2.setText("Date To:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 182, -1));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel1.setText("Date from:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 120, -1));
        jPanel2.add(dp_dateto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 260, 30));
        jPanel2.add(dp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 220, 30));

        buttonGroup1.add(rb_period);
        rb_period.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        rb_period.setText("BY PERIOD");
        rb_period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_periodActionPerformed(evt);
            }
        });
        jPanel2.add(rb_period, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        buttonGroup1.add(rb_daily);
        rb_daily.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        rb_daily.setSelected(true);
        rb_daily.setText("DAILY");
        rb_daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_dailyActionPerformed(evt);
            }
        });
        jPanel2.add(rb_daily, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 140, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("INVENTORY (STOCK-IN)");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 284, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("INVENTORY (STOCKS LEFT)");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 284, 40));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("REPORTS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 720, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("COMMISSION");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 284, 42));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("RECEIVABLES");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 284, 40));

        jButton6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton6.setText("SALES IN CANTEEN");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 284, 40));

        jButton7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton7.setText("CLOSE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 284, 40));

        jButton8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton8.setText("SALES IN BALLFIELD");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 284, 40));

        jButton9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton9.setText("DAILY SALES (Denominations)");
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 280, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 540));

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        do_inventory_stocks_left();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        do_inventory_endorsements();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        do_charges();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        do_sales_canteen();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        do_sales_ball_field();
    }//GEN-LAST:event_jButton8ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dp_date;
    private com.toedter.calendar.JDateChooser dp_dateto;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
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
        do_act();
        initActionKey();
        do_set_date();
        hide_period();
    }
    String b_name = "";

    public void do_pass(String name) {
        b_name = name;
    }

    private void do_act() {
        dp_date.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                dp_dateto.setDate(dp_date.getDate());
            }
        });
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

    private void do_sales() {

        String name = System.getProperty("entityName", "Intelink-One");
//        if (rb_daily.isSelected()) {
//
//          final  to_date_from to = new to_date_from(dp_date.getDate(), name);
//            Executor.doExecute(this, new Executor.Task() {
//
//                @Override
//                public void work_on() {
//                    rpt_report.pdf_viewer_receipts(to, "rpt_sales_2_1");
//                }
//            });
//           
//
//        } else {

        final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), name,"",0);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_receipts2(to, "rpt_sales_2_1");
            }
        });

//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());

//        }

//        if (callback != null) {
//            callback.ok(new CloseDialog(this), new OutputData());
//
//        }

    }

    private void do_sales_canteen() {

        String name = System.getProperty("entityName", "Intelink-One");
//        if (rb_daily.isSelected()) {
//
//          final  to_date_from to = new to_date_from(dp_date.getDate(), name);
//            Executor.doExecute(this, new Executor.Task() {
//
//                @Override
//                public void work_on() {
//                    rpt_report.pdf_viewer_receipts(to, "rpt_sales_2_1");
//                }
//            });
//           
//
//        } else {

        final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), name,"",0);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_receipts2(to, "rpt_sales_canteen");
            }
        });

//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());

//        }

//        if (callback != null) {
//            callback.ok(new CloseDialog(this), new OutputData());
//
//        }

    }

    private void do_sales_ball_field() {

        String name = System.getProperty("entityName", "Intelink-One");
//        if (rb_daily.isSelected()) {
//
//          final  to_date_from to = new to_date_from(dp_date.getDate(), name);
//            Executor.doExecute(this, new Executor.Task() {
//
//                @Override
//                public void work_on() {
//                    rpt_report.pdf_viewer_receipts(to, "rpt_sales_2_1");
//                }
//            });
//           
//
//        } else {

        final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), name,"",0);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_receipts2(to, "rpt_sales_ballfield");
            }
        });

//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());

//        }

//        if (callback != null) {
//            callback.ok(new CloseDialog(this), new OutputData());
//
//        }

    }

    private void do_inventory() {



        if (rb_daily.isSelected()) {

            final to_date_from to = new to_date_from(dp_date.getDate(), b_name);
            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    rpt_report.pdf_viewer_receipts(to, "rpt_inventory2_daily");
                }
            });


        } else {

            final to_date_to to = new to_date_to(dp_date.getDate(), dp_dateto.getDate(), b_name,"",0);
            Executor.doExecute(this, new Executor.Task() {

                @Override
                public void work_on() {
                    rpt_report.pdf_viewer_receipts2(to, "rpt_inventory2_daily_2");
                }
            });

//            rpt_report.do_admin_report_all(dp_date.getDate(), dp_dateto.getDate());

        }

    }

    private void do_inventory_stocks_left() {





        final to_date_from to = new to_date_from(dp_date.getDate(), b_name);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_receipts(to, "rpt_stocks_left");
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
                rpt_report.pdf_viewer_pendings(to, "rpt_receivables");
            }
        });
    }

    private void do_custmers() {
        final to_date_from to = new to_date_from(new Date(), b_name);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_pendings(to, "rpt_customers");
            }
        });
    }

    private void do_inventory_endorsements() {





        final to_date_from to = new to_date_from(dp_date.getDate(), b_name);
        Executor.doExecute(this, new Executor.Task() {

            @Override
            public void work_on() {
                rpt_report.pdf_viewer_receipts(to, "rpt_commission_1");
            }
        });




    }
}
