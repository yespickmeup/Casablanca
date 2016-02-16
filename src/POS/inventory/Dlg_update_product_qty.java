/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POS.inventory;

import POS.dlg2.Dlg_supplier;
import POS_svc3.S1_get_category;
import java.awt.Window;
import java.util.logging.Level;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;

/**
 *
 * @author Dummy
 */
public class Dlg_update_product_qty extends javax.swing.JDialog {

    /** Creates new form Dlg_update_product */
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
        public final String prod_name;
        public final String supplier_id;
        public final Double qty;
        public final double cost;

        public OutputData(String prod_name, String supplier_id, Double qty, double cost) {
            this.prod_name = prod_name;
            this.supplier_id = supplier_id;
            this.qty = qty;
            this.cost = cost;
        }
        
        
        
        
        
        
        
    }


//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_update_product_qty(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_update_product_qty(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_update_product_qty() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_update_product_qty myRef;

    private void setThisRef(Dlg_update_product_qty myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_update_product_qty> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_update_product_qty create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_update_product_qty create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_update_product_qty dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_update_product_qty((java.awt.Frame) parent, false);
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
            Dlg_update_product_qty dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_update_product_qty((java.awt.Dialog) parent, false);
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


        Dlg_update_product_qty dialog = Dlg_update_product_qty.create(new javax.swing.JFrame(), true);
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_product = new javax.swing.JLabel();
        cb_supplier = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_cost = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        ds_title1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(159, 207, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("PRODUCT NAME:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 120, -1));

        tf_product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_product.setText("PRODUCT NAME:");
        tf_product.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        tf_product.setOpaque(true);
        jPanel2.add(tf_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 515, 40));

        cb_supplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(cb_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 393, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("SUPPLIER:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 80, -1));

        tf_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
            }
        });
        jPanel2.add(tf_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 134, 34));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ENTER QUANTITY:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("COST:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 50, 30));

        tf_cost.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tf_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_costActionPerformed(evt);
            }
        });
        jPanel2.add(tf_cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 134, 36));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        jButton2.setText("OK");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 426, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 700, 60));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add32x32.png"))); // NOI18N
        jButton3.setLabel("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 100, 40));

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title1.setForeground(new java.awt.Color(41, 9, 149));
        ds_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title1.setText("STOCK IN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 700, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_qtyActionPerformed

    private void tf_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_costActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        supplier();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_supplier;
    private javax.swing.JLabel ds_title1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JLabel tf_product;
    private javax.swing.JTextField tf_qty;
    // End of variables declaration//GEN-END:variables

     private void myInit(){
         get_suppliers();
     }
     private void get_suppliers(){
         cb_supplier.setModel(new ListComboBoxModel(S1_get_category.get_suppliers()));
     }
     public  void do_pass(String product_name,String cost){
         tf_product.setText(product_name);
         tf_cost.setText(cost);
     }
     public  void do_pass2(){
//         tf_product.setText(product_name);
         jLabel3.setVisible(false);
         cb_supplier.setVisible(false);
         tf_cost.setVisible(false);
         jLabel2.setVisible(false);
     }
     
     private void ok1() {
        if (callback != null) {
            String name=tf_product.getText();
            String supp="";
//                String supp=cb_supplier.getSelectedItem().toString();
            double qty=0;
            double cost=0;
            if(tf_qty.getText().isEmpty()){
                  qty=0;
                  return;
            }else{
                  qty= Double.parseDouble(tf_qty.getText());
            }
            if(tf_cost.getText().isEmpty()){
                  cost=0;
            }else{
                  cost= Double.parseDouble(tf_cost.getText());
            }
            
            String id=""+S1_get_category.get_supplier_id(supp);
              
            callback.ok(new CloseDialog(this), new OutputData(name,id,qty,cost));
        }
    }
     private void supplier(){
         Window p = (Window) this;
         Dlg_supplier nd = Dlg_supplier.create(p, true);
         nd.setTitle("");
//         nd.do_pass("");
         nd.setCallback(new Dlg_supplier.Callback() {
             
             @Override
             public void ok(CloseDialog closeDialog, Dlg_supplier.OutputData data) {
                 closeDialog.ok();
                 get_suppliers();
             }
         });
         Center.setCenter(nd);
         
         nd.setVisible(true);
     }
}
