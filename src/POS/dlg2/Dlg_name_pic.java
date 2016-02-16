/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg2;

import POS.dlg3.Dlg_choose_img;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;

/**
 *
 * @author Dummy
 */
public class Dlg_name_pic extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_name
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
    }

    public static class OutputData {

        public final String name;
        public final String img_name;

        public OutputData(String name, String img_name) {
            this.name = name;
            this.img_name = img_name;
        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_name_pic(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_name_pic(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_name_pic() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_name_pic myRef;

    private void setThisRef(Dlg_name_pic myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_name_pic> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_name_pic create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_name_pic create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_name_pic dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_name_pic((java.awt.Frame) parent, false);
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
            Dlg_name_pic dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_name_pic((java.awt.Dialog) parent, false);
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


        Dlg_name_pic dialog = Dlg_name_pic.create(new javax.swing.JFrame(), true);
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

        jPanel1 = new javax.swing.JPanel();
        tf_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbl_photo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_name.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameActionPerformed(evt);
            }
        });
        jPanel1.add(tf_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 480, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NAME:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 110, -1));

        lbl_photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_photo.setText("NO PHOTO");
        lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_photo.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_photoMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

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

    private void tf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_tf_nameActionPerformed

    private void lbl_photoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_photoMouseClicked
        pic();
    }//GEN-LAST:event_lbl_photoMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JTextField tf_name;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        String img_path = System.getProperty("img_path", "C:\\Users\\Dummy\\");
        img_path = img_path + "img_templates\\category_img\\";
        set_pic(img_path, "d_1.jpeg");
    }

    private void set_pic(String img_path, String imgs) {
        lbl_photo.setIcon(new javax.swing.ImageIcon(img_path + imgs)); // NOI18N
        File f = new File(img_path + imgs);
        BufferedImage img;
        try {
            img = ImageIO.read(f);
            int width = 150; //jLabel3.getWidth();
            int height = 150; //jLabel3.getHeight();
            BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = scaledImage.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                    RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            graphics2D.drawImage(img, 0, 0, width, height, null);
            graphics2D.dispose();
            ImageIcon myIcon = new ImageIcon(scaledImage);
            lbl_photo.setIcon(myIcon);
        } catch (IOException ex) {
//               return;
        }
    }

    private void pic() {
        Window p = (Window) this;
        Dlg_choose_img nd = Dlg_choose_img.create(p, true);
        nd.setTitle("");
//        final String img_path = System.getProperty("img_path", "/home/i1/img_templates/category_img/");
        String img_path1 = System.getProperty("img_path", "C:\\Users\\Dummy\\");
        final String img_path = img_path1 + "img_templates\\category_img\\";
        nd.do_pass();
        nd.setCallback(new Dlg_choose_img.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_choose_img.OutputData data) {
                closeDialog.ok();
                im_path = data.img_name;
                set_pic(img_path, im_path);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void set_icon() {
        String img_path = System.getProperty("img_path", "/home/i1/img_templates/category_img/");


    }

    public void do_pass(String name, String img) {
        tf_name.setText(name);
        im_path = img;
//        String img_path = System.getProperty("img_path", "/home/i1/img_templates/category_img/");
        String img_path = System.getProperty("img_path", "C:\\Users\\Dummy\\");
        img_path = img_path + "img_templates\\category_img\\";
//        JOptionPane.showMessageDialog(null, img);
        if (img.equals("empty") || im_path.isEmpty()) {
            im_path = "d_1.jpeg";
        }

        set_pic(img_path, im_path);
    }
    String im_path = "";

    private void ok1() {

        if (im_path.equals("empty")) {
            im_path = "d_1.jpeg";
        }
        if (tf_name.getText().
                isEmpty() || im_path.isEmpty()) {
            return;
        }

//        JOptionPane.showMessageDialog(null, tf_name.getText() + " = " + im_path);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(tf_name.getText(), im_path));
        }
        tf_name.setText("");
    }
}
