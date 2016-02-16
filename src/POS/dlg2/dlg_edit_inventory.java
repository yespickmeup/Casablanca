/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg2;

import java.util.logging.Level;
import mijzcx.synapse.desk.utils.CloseDialog;

/**
 *
 * @author Dummy
 */
public class dlg_edit_inventory extends javax.swing.JDialog {

    /**
     * Creates new form dlg_edit_inventory
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

        public final String name;
        public final double count;
        public final double beg;
        public final double sold;
        public final double end;
        public final double variance;

        public InputData(String name, double count, double beg, double sold, double end, double variance) {
            this.name = name;
            this.count = count;
            this.beg = beg;
            this.sold = sold;
            this.end = end;
            this.variance = variance;
        }
    }

    public static class OutputData {

       
        public final double count;    
        public final double variance;

        public OutputData(double count, double variance) {
            this.count = count;
            this.variance = variance;
        }

        
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private dlg_edit_inventory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private dlg_edit_inventory(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public dlg_edit_inventory() {
        super();
        initComponents();
        myInit();

    }
    private dlg_edit_inventory myRef;

    private void setThisRef(dlg_edit_inventory myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, dlg_edit_inventory> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static dlg_edit_inventory create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static dlg_edit_inventory create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            dlg_edit_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new dlg_edit_inventory((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            dlg_edit_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new dlg_edit_inventory((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
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


        dlg_edit_inventory dialog = dlg_edit_inventory.create(new javax.swing.JFrame(), true);
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
        tf_p_count = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lb_variance = new javax.swing.JLabel();
        lb_name2 = new javax.swing.JLabel();
        lb_name1 = new javax.swing.JLabel();
        lb_name3 = new javax.swing.JLabel();
        lb_name4 = new javax.swing.JLabel();
        lb_name5 = new javax.swing.JLabel();
        lb_name6 = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_beg = new javax.swing.JLabel();
        lb_sold = new javax.swing.JLabel();
        lb_end = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 206, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_p_count.setFont(new java.awt.Font("Tahoma", 1, 18));
        tf_p_count.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_p_countActionPerformed(evt);
            }
        });
        tf_p_count.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_p_countKeyReleased(evt);
            }
        });
        jPanel1.add(tf_p_count, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 100, 30));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 67, 30));

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, 30));

        lb_variance.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_variance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_variance.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_variance, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 80, 26));

        lb_name2.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_name2.setText("VARIANCE");
        jPanel1.add(lb_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 80, 26));

        lb_name1.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_name1.setText("NAME:");
        jPanel1.add(lb_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 61, 26));

        lb_name3.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_name3.setText("PHYSICAL COUNT:");
        jPanel1.add(lb_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 150, 26));

        lb_name4.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_name4.setText("Beginning");
        jPanel1.add(lb_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 80, 26));

        lb_name5.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_name5.setText("SOLD");
        jPanel1.add(lb_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 80, 26));

        lb_name6.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_name6.setText("END");
        jPanel1.add(lb_name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 80, 26));

        lb_name.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_name.setText("NAME:");
        lb_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 350, 26));

        lb_beg.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_beg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_beg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_beg, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 70, 26));

        lb_sold.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_sold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_sold.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_sold, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 70, 26));

        lb_end.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_end.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_end.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 70, 26));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_p_countKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_p_countKeyReleased
        // TODO add your handling code here:
        do_compute();
    }//GEN-LAST:event_tf_p_countKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_p_countActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_p_countActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_tf_p_countActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_beg;
    private javax.swing.JLabel lb_end;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_name1;
    private javax.swing.JLabel lb_name2;
    private javax.swing.JLabel lb_name3;
    private javax.swing.JLabel lb_name4;
    private javax.swing.JLabel lb_name5;
    private javax.swing.JLabel lb_name6;
    private javax.swing.JLabel lb_sold;
    private javax.swing.JLabel lb_variance;
    private javax.swing.JTextField tf_p_count;
    // End of variables declaration//GEN-END:variables

    
    public void pass(InputData inputData) {
       lb_name.setText(inputData.name);
       tf_p_count.setText(""+inputData.count);
       lb_beg.setText(""+inputData.beg);
       lb_sold.setText(""+inputData.sold);
       lb_end.setText(""+inputData.end);
       lb_variance.setText(""+inputData.variance);      
    }
        
    private void myInit() {
    }
    
    private void do_compute(){
        double end=Double.parseDouble(lb_end.getText());
        double count=0;
        if(tf_p_count.getText().isEmpty()){
            count=0;
        }else{
            count=Double.parseDouble(tf_p_count.getText());
        }
        lb_variance.setText(""+(end-count));
    }
    
    private void ok1() {
      
        double count=0;
         if(tf_p_count.getText().isEmpty()){
            count=0;
        }else{
            count=Double.parseDouble(tf_p_count.getText());
        }
         double variance=Double.parseDouble(lb_variance.getText());
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(count,variance));
        }
        this.dispose();
    }
}
