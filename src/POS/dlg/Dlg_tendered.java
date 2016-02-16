/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlg_tendered.java
 *
 * Created on Feb 13, 2012, 7:19:08 PM
 */
package POS.dlg;

import POS.utl.NumType;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.Executor;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_tendered extends javax.swing.JDialog {

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
    private Dlg_tendered(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }
    
    private Dlg_tendered(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }
    
    public Dlg_tendered() {
        super();
        initComponents();
        myInit();
        
    }
    private Dlg_tendered myRef;
    
    private void setThisRef(Dlg_tendered myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_tendered> dialogContainer = new java.util.HashMap();
    
    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }
    
    public static Dlg_tendered create(java.awt.Window parent, boolean modal) {
        
        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }
        
        return create(parent, ModalityType.MODELESS);
        
    }
    
    public static Dlg_tendered create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {
        
        if (parent instanceof java.awt.Frame) {
            
            Dlg_tendered dialog = dialogContainer.get(parent);
            
            if (dialog == null) {
                dialog = new Dlg_tendered((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.
                        size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }
            
        }
        
        if (parent instanceof java.awt.Dialog) {
            Dlg_tendered dialog = dialogContainer.get(parent);
            
            if (dialog == null) {
                dialog = new Dlg_tendered((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.
                        size());
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
        
        
        Dlg_tendered dialog = Dlg_tendered.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ds_amountdue = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_tendered = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ds_change = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(41, 9, 149));
        jLabel7.setText("Amount Due:");
        jLabel7.setFocusable(false);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 59, -1, -1));

        ds_amountdue.setBackground(java.awt.Color.black);
        ds_amountdue.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        ds_amountdue.setForeground(java.awt.Color.green);
        ds_amountdue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ds_amountdue.setText("100.00");
        ds_amountdue.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        ds_amountdue.setFocusable(false);
        ds_amountdue.setOpaque(true);
        jPanel1.add(ds_amountdue, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 86, 373, 67));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(41, 9, 149));
        jLabel10.setText("Tendered");
        jLabel10.setFocusable(false);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 158, -1, -1));

        lbl_tendered.setBackground(java.awt.Color.white);
        lbl_tendered.setFont(new java.awt.Font("DialogInput", 1, 40)); // NOI18N
        lbl_tendered.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_tendered.setText("100.00");
        lbl_tendered.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(java.awt.Color.orange, 3, true), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        lbl_tendered.setFocusable(false);
        lbl_tendered.setOpaque(true);
        jPanel1.add(lbl_tendered, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 182, 373, 67));

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(41, 9, 149));
        jLabel9.setText("Change:");
        jLabel9.setFocusable(false);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 266, -1, -1));

        ds_change.setBackground(java.awt.Color.darkGray);
        ds_change.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        ds_change.setForeground(java.awt.Color.green);
        ds_change.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ds_change.setText("400.00");
        ds_change.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        ds_change.setFocusable(false);
        ds_change.setOpaque(true);
        jPanel1.add(ds_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 290, 370, 67));

        jButton2.setText("OK");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 130, 40));

        jButton1.setText("BACK");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
     do_ok();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ds_amountdue;
    private javax.swing.JLabel ds_change;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_tendered;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">
    private void myInit() {
        initActionKey();
    }
    private void dispo(){
        this.dispose();
    }
    private void initActionKey() {
        
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               dispo();
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
                KeyEvent.VK_1, new KeyAction() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "adad");
            }
        });
         
         
    }
    //</editor-fold>

    public void load(InputData data) {
    }
    
    private void cancel() {
        this.setVisible(false);
    }
    
     public void pass(String amount, String change, double tender) {
       ds_amountdue.setText(NumType.with_comma(Double.parseDouble(amount)));
       lbl_tendered.setText(FitIn.fmt_wc_0(tender));
       ds_change.setText(change);
    }
    private void do_ok() {
        if (callback != null) {
              callback.ok(new CloseDialog(this), new OutputData());
        }
         this.dispose();
//         prcss_work_on();
//        Executor.doExecute(this, new Executor.Task() {
//            
//            @Override
//            public void work_on() {
//               
//            }
//        });
    }
    
    private void prcss_work_on() {
      
    }
}
