/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProgressDialog.java
 *
 * Created on 01 14, 11, 1:40:06 PM
 */
package POS.utl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import javax.swing.Timer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.Lg;

/**
 *
 * @author admin
 */
public class ProgressDialog extends javax.swing.JDialog {

    /**
     * Creates new form CatalogDialog
     */
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private ProgressDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private ProgressDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public ProgressDialog() {
        super();
        initComponents();
        myInit();
    }
    private ProgressDialog myRef;

    private void setThisRef(ProgressDialog myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, ProgressDialog> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static ProgressDialog create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static ProgressDialog create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            ProgressDialog dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new ProgressDialog((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                Lg.$.log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            ProgressDialog dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new ProgressDialog((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                Lg.$.log(Level.INFO, "instances: {0}", dialogContainer.size());
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

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    ProgressDialog dialog = ProgressDialog.create(new javax.swing.JFrame(), true);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    System.exit(0);
                }
            }
        });
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

        disLabel = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnCancel = new javax.swing.JButton();
        lblSeconds = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        disLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
        disLabel.setText("Extracting Data Please Wait... ");

        jProgressBar1.setIndeterminate(true);

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblSeconds.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblSeconds.setText("2 sec");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(disLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(disLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(lblSeconds))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cancel();
    }//GEN-LAST:event_btnCancelActionPerformed
    private Callback callback;

    public void setCallback(Callback callback) {

        this.callback = callback;
        btnCancel.setVisible(callback != null);

    }

    public static interface Callback {

        void cancel(CloseDialog closeDialog);
    }

    private void cancel() {
        if (callback != null) {
            callback.cancel(new CloseDialog(this));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel disLabel;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblSeconds;
    // End of variables declaration//GEN-END:variables

    public void setDisLabel(String label) {
        this.disLabel.setText(label);
    }

    private void myInit() {
        init_timer();
        init_hides();
    }

    private void init_hides() {
        btnCancel.setVisible(false);
    }
    private Timer timer;

    private void init_timer() {
        timer = new Timer(0, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                incrSeconds();
            }
        });
        timer.setDelay(1000);
        timer.start();
    }

    @Override
    public void setVisible(boolean visible) {
        if (!visible) {
            timer.stop();
        } else {
            i = 0;
            timer.start();
        }

        super.setVisible(visible);
    }
    int i = 0;

    private void incrSeconds() {

        lblSeconds.setText(i++ + " sec");
    }
}