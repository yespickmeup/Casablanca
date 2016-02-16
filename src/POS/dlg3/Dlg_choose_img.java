/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg3;

import de.jgrid.JGrid;
import de.jgrid.renderer.GridCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_choose_img extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_choose_img
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

        public final String img_name;

        public OutputData(String img_name) {
            this.img_name = img_name;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_choose_img(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_choose_img(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_choose_img() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_choose_img myRef;

    private void setThisRef(Dlg_choose_img myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_choose_img> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_choose_img create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_choose_img create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_choose_img dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_choose_img((java.awt.Frame) parent, false);
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
            Dlg_choose_img dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_choose_img((java.awt.Dialog) parent, false);
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
//            System.setProperty("sun.java2d.opengl", "True");
//            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
//            UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dlg_choose_img dialog = Dlg_choose_img.create(new javax.swing.JFrame(), true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jg_pics = new de.jgrid.JGrid();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jg_pics.setFixedCellDimension(100);
        jScrollPane1.setViewportView(jg_pics);

        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private de.jgrid.JGrid jg_pics;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_catogories();
//        jg_pics.setPreferredSize(new Dimension(4000,4000));
    }

    public void do_pass() {
    }
    // <editor-fold defaultstate="collapsed" desc="Key">

    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>

    public static class to_details {

        public final String logo;
        public final String name;
        public final double qty;
        public final double price;

        public to_details(String logo, String name, double qty, double price) {
            this.logo = logo;
            this.name = name;
            this.qty = qty;
            this.price = price;
        }
    }

    private void init_catogories() {
//        /home/i1/img_templates/category_img/bakery3.jpeg
//        /home/i1/img_templates/category_img/bakery3.jpeg
//        String img_path = System.getProperty("img_path", "/home/i1/img_templates/category_img/");
        String img_path = System.getProperty("img_path", "C:\\Users\\Dummy\\");
        img_path = img_path + "img_templates\\category_img\\";
        List<String> results = new ArrayList();
        File[] files = new File(img_path).listFiles();

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());

            }
        }
        int i = 0;
        for (String s : results) {
//            System.out.println(img_path + s);
//            to_details to = new to_details(img_path + s, "NAME", 100, 100);
            to_details to = new to_details(img_path + s, s, 100, 100);
            cat_model.add(i, to);
            i++;
        }




        jg_pics.setModel(cat_model);

//        jg_pics.setFixedCellDimension(150);


        jg_pics.setHorizonztalMargin(5);
        jg_pics.setVerticalMargin(5);
        jg_pics.setCellBackground(Color.white);
        jg_pics.setSelectionBackground(Color.LIGHT_GRAY);
//        jg_categories.setModel(cat_model);
        jg_pics.getCellRendererManager().setDefaultRenderer(new Categories());
        System.out.println(jg_pics.getCellBounds(0));
//        jg_pics.updateUI();
    }
    DefaultListModel cat_model = new DefaultListModel();
    public static class Categories extends JPanel implements GridCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getGridCellRendererComponent(JGrid grid,
                Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
//            if (value != null && value instanceof Color) {
//                this.setBackground((Color) value);
//            }

            JLabel jLabel10 = new javax.swing.JLabel();

            JLabel jLabel12 = new javax.swing.JLabel();
            JLabel jLabel14 = new javax.swing.JLabel();

            to_details t = (to_details) value;

            JPanel jPanel11 = new javax.swing.JPanel() {

                @Override
                public void paintComponent(Graphics og) {
                    super.paintComponent(og);

                    Graphics2D g = (Graphics2D) og;
//                    GradientPaint gradient = new GradientPaint(0, 100, Color.white, 0, 0, Color.white, true);
//                    g.setPaint(gradient);
                    g.fillRoundRect(0, 0, 470, 255, 30, 30);

                }
            };
            jPanel11.setBackground(new java.awt.Color(255, 255, 255));
            jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel12.setBackground(new java.awt.Color(204, 204, 204));
            jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel12.setOpaque(true);
            jLabel12.setText(t.name);
            jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 30));

            jLabel10.setBackground(new java.awt.Color(72, 160, 249));
            jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(255, 255, 255));
            jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel10.setIcon(new javax.swing.ImageIcon(t.logo)); // NOI18N
            File f = new File(t.logo);
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
                jLabel10.setIcon(myIcon);
            } catch (IOException ex) {
//               return;
            }

            jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
            jLabel10.setOpaque(true);
            jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseClicked(java.awt.event.MouseEvent evt) {
                }
            });
            jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 150));

            return jPanel11;
        }
    }

    private void ok1() {
        int row = jg_pics.getSelectedIndex();
        if (row < 0) {
            return;
        }
        Object o = cat_model.getElementAt(row);
        to_details to = (to_details) o;
        String name = to.name;
//        JOptionPane.showMessageDialog(null, name);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(name));
            cat_model.clear();
        }
    }
}
