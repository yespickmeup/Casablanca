/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import POS.utl.Wrapper;
import POS_svc4.S2_search;
import de.jgrid.JGrid;
import de.jgrid.renderer.GridCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.jdesktop.swingx.JXLabel;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_scroll extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_scroll
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
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_scroll(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_scroll(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_scroll() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_scroll myRef;

    private void setThisRef(Dlg_scroll myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_scroll> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_scroll create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_scroll create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_scroll dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_scroll((java.awt.Frame) parent, false);
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
            Dlg_scroll dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_scroll((java.awt.Dialog) parent, false);
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


        Dlg_scroll dialog = Dlg_scroll.create(new javax.swing.JFrame(), true);
        Center.setCenter(dialog);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jg_orders = new de.jgrid.JGrid();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setViewportView(jg_orders);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private de.jgrid.JGrid jg_orders;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_items();
        scrolling();

    }

    private void scrolling() {
        Scrolling.ComponentDragScrollListener l = new Scrolling.ComponentDragScrollListener(jg_orders);
        jg_orders.addMouseMotionListener(l);
        jg_orders.addMouseListener(l);
        jg_orders.addHierarchyListener(l);
    }
    DefaultListModel item_model = new DefaultListModel();

    private void init_items() {
        item_model.clear();
        String img_path = System.getProperty("img_path", "C:\\Users\\Dummy\\img_templates\\item_img\\");
//            String search = tf_search.getText();
//            if (search.isEmpty() && category_id.isEmpty()) {
//                return;
//            }

        List<S2_search.to_items> results = S2_search.ret_items("", "","",0);
        int i = 0;
        for (S2_search.to_items s : results) {
            S2_search.to_items to = new S2_search.to_items(s.name, s.uom, s.desc, s.price, s.qty, s.img_path, s.qty2, "-1", s.cat_id, s.category_name, s.printing_assembly, s.status, s.disc_name, s.disc_rate, s.discount, s.customer_name, s.customer_address, s.customer_address,"",s.group_id);
            item_model.add(i, to);
            i++;
        }
        jg_orders.setModel(item_model);
//        jg_items.setPreferredSize(new Dimension(400, 400));
        jg_orders.setFixedCellDimension(170);
        jg_orders.setHorizonztalMargin(4);
        jg_orders.setVerticalMargin(10);
        jg_orders.setCellBackground(Color.white);
        jg_orders.setSelectionBackground(Color.lightGray);

        jg_orders.getCellRendererManager().
                setDefaultRenderer(new POS.pnl.Dashboard.Items());
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

    // <editor-fold defaultstate="collapsed" desc="Items">
    public static class Items extends JPanel implements GridCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getGridCellRendererComponent(JGrid grid,
                Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
//            if (value != null && value instanceof Color) {
//                this.setBackground((Color) value);
//            }


            JXLabel lbl_qty = new JXLabel();

            JXLabel lbl_price = new JXLabel();
            JXLabel lbl_prod_name = new JXLabel();
            JLabel ip_img = new JLabel();

//            String img_path = System.getProperty("img_path", "C:\\Users\\Dummy\\img_templates\\item_img\\");
            String img_path = System.getProperty("img_path", "C:\\Users\\i1\\");
            img_path = img_path + "img_templates\\item_img\\";
            S2_search.to_items t = (S2_search.to_items) value;
//            System.out.println(t.logo + "");
            JPanel jPanel11 = new javax.swing.JPanel() {

                @Override
                public void paintComponent(Graphics og) {
                    super.paintComponent(og);

//                    Graphics2D g = (Graphics2D) og;
//
//                    GradientPaint gradient = new GradientPaint(0, 100, Color.white, 0, 0, Color.white, true);
//
//                    g.setPaint(gradient);
//                    g.fillRoundRect(0, 0, 470, 255, 30, 30);

                }
            };
            jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            lbl_qty.setBackground(new java.awt.Color(0, 0, 0));
            lbl_qty.setForeground(new java.awt.Color(255, 255, 255));
            lbl_qty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 51), new java.awt.Color(255, 51, 0), new java.awt.Color(255, 0, 0)));
            lbl_qty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl_qty.setText(FitIn.fmt_wc_0(t.qty));
            lbl_qty.setOpaque(true);
            jPanel11.add(lbl_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

            lbl_price.setBackground(new java.awt.Color(0, 153, 255));
            lbl_price.setForeground(new java.awt.Color(255, 255, 255));
            lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl_price.setText("P " + FitIn.fmt_wc_0(t.price));
            lbl_price.setOpaque(true);
            jPanel11.add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 70, 30));
//
            lbl_prod_name.setBackground(new java.awt.Color(255, 255, 255));
            lbl_prod_name.setForeground(new java.awt.Color(0, 0, 0));
            lbl_prod_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            lbl_prod_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            lbl_prod_name.setText(Wrapper.wrap(t.desc, 27));
//            lbl_prod_name.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N

            lbl_prod_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            lbl_prod_name.setOpaque(true);
            lbl_prod_name.setVerticalAlignment(javax.swing.SwingConstants.TOP);
//            lbl_prod_name.setLineWrap(true);
            jPanel11.add(lbl_prod_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 170, 40));


//            System.out.println(t.img_path);
//            jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            ip_img.setIcon(new javax.swing.ImageIcon(img_path + t.img_path)); // NOI18N
//              ip_img.setIcon(new javax.swing.ImageIcon("/home/i1/img_templates/item_img/asd.jpeg")); // NOI18N
            File f = new File(img_path + t.img_path);
            BufferedImage img;
            try {
                img = ImageIO.read(f);
                int width = 200; //jLabel3.getWidth();
                int height = 170; //jLabel3.getHeight();
                BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.OPAQUE);
                Graphics2D graphics2D = scaledImage.createGraphics();
                graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                        RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                graphics2D.drawImage(img, 0, 0, width, height, null);
                graphics2D.dispose();
                ImageIcon myIcon = new ImageIcon(scaledImage);
                ip_img.setIcon(myIcon);
            } catch (IOException ex) {
//                throw new RuntimeException(ex);
            }

            jPanel11.add(ip_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

            return jPanel11;
        }
    }
    // </editor-fold>
}
