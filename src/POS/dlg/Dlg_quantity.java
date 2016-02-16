/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dlg_quantity.java
 *
 * Created on Nov 16, 2011, 6:28:55 PM
 */
package POS.dlg;

import POS.to.to_order;
import POS.utl.Backspace;
import POS.utl.NumType;
import POS.utl.Prompt;
import POS_svc4.S6_linient;
import POS_svc4.S7_uom;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.MessageFormat;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.CurrencyDocument;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_quantity extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class OutputData {

        public final to_order order;

        public OutputData(to_order order) {
            this.order = order;
        }
    }

    public static class InputData {

        public final String uom;
        public final double price;
        public final String title;
        public final double qty;
        public final String names;

        public InputData(String uom, double price, String title, double qty, String names) {
            this.uom = uom;
            this.price = price;
            this.title = title;
            this.qty = qty;
            this.names = names;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_quantity(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_quantity(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_quantity() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_quantity myRef;

    private void setThisRef(Dlg_quantity myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_quantity> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_quantity create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_quantity create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_quantity dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_quantity((java.awt.Frame) parent, false);
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
            Dlg_quantity dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_quantity((java.awt.Dialog) parent, false);
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


        Dlg_quantity dialog = Dlg_quantity.create(new javax.swing.JFrame(), true);
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

        pnl_floor = new javax.swing.JPanel();
        pnl_layer1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ds_amountdue = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_qty = new javax.swing.JLabel();
        lbl_price_per_kilo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_available_kilos = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cb_uom = new javax.swing.JComboBox();
        pnl_numpad = new javax.swing.JPanel();
        btn_9 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_dot = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_floor.setBackground(new java.awt.Color(159, 207, 243));
        pnl_floor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnl_layer1.setBackground(java.awt.Color.white);
        pnl_layer1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_layer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(41, 9, 149));
        jLabel7.setText("UOM:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 183, -1));

        ds_amountdue.setBackground(java.awt.Color.black);
        ds_amountdue.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ds_amountdue.setForeground(java.awt.Color.green);
        ds_amountdue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ds_amountdue.setText("100000000");
        ds_amountdue.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        ds_amountdue.setOpaque(true);
        jPanel5.add(ds_amountdue, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 320, 50));

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(41, 9, 149));
        jLabel8.setText("AMOUNT DUE");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 183, -1));

        lbl_qty.setBackground(java.awt.Color.white);
        lbl_qty.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_qty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_qty.setText("100.00");
        lbl_qty.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(java.awt.Color.lightGray, 3, true), javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 5))));
        lbl_qty.setOpaque(true);
        jPanel5.add(lbl_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 320, 50));

        lbl_price_per_kilo.setBackground(new java.awt.Color(204, 204, 204));
        lbl_price_per_kilo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_price_per_kilo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_price_per_kilo.setText("0");
        lbl_price_per_kilo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(java.awt.Color.lightGray, 3, true), javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 5))));
        lbl_price_per_kilo.setOpaque(true);
        jPanel5.add(lbl_price_per_kilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, 50));

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(41, 9, 149));
        jLabel9.setText("Available Stocks");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, -1));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(41, 9, 149));
        jLabel10.setText("PRICE");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 183, -1));

        lbl_available_kilos.setBackground(new java.awt.Color(204, 204, 204));
        lbl_available_kilos.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbl_available_kilos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_available_kilos.setText("1");
        lbl_available_kilos.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(java.awt.Color.lightGray, 3, true), javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 5))));
        lbl_available_kilos.setOpaque(true);
        jPanel5.add(lbl_available_kilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 320, 50));

        jLabel17.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(41, 9, 149));
        jLabel17.setText("QTY ");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 183, -1));

        cb_uom.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        cb_uom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_uom.setFocusable(false);
        cb_uom.setOpaque(false);
        cb_uom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_uomActionPerformed(evt);
            }
        });
        jPanel5.add(cb_uom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 244, 320, 50));

        pnl_layer1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -6, 380, 530));

        pnl_numpad.setBackground(new java.awt.Color(159, 207, 243));
        pnl_numpad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 9, 149), 3, true));
        pnl_numpad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_9.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_9.setForeground(new java.awt.Color(41, 9, 149));
        btn_9.setText("9");
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 140, 100));

        btn_6.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_6.setForeground(new java.awt.Color(41, 9, 149));
        btn_6.setText("6");
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 140, 100));

        btn_8.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_8.setForeground(new java.awt.Color(41, 9, 149));
        btn_8.setText("8");
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 140, 100));

        btn_4.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_4.setForeground(new java.awt.Color(41, 9, 149));
        btn_4.setText("4");
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 130, 100));

        btn_5.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_5.setForeground(new java.awt.Color(41, 9, 149));
        btn_5.setText("5");
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 140, 100));

        btn_7.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_7.setForeground(new java.awt.Color(41, 9, 149));
        btn_7.setText("7");
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 100));

        btn_3.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_3.setForeground(new java.awt.Color(41, 9, 149));
        btn_3.setText("3");
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 140, 100));

        btn_1.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_1.setForeground(new java.awt.Color(41, 9, 149));
        btn_1.setText("1");
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 130, 100));

        btn_2.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_2.setForeground(new java.awt.Color(41, 9, 149));
        btn_2.setText("2");
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 140, 100));

        btn_0.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_0.setForeground(new java.awt.Color(41, 9, 149));
        btn_0.setText("0");
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 270, 90));

        btn_dot.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        btn_dot.setForeground(new java.awt.Color(41, 9, 149));
        btn_dot.setText(".");
        btn_dot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dotActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 140, 90));

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        btn_ok.setBorderPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 70, 70));

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(41, 9, 149));
        jLabel11.setText("OK");
        pnl_numpad.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 30, -1));

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(149, 9, 12));
        jLabel12.setText("(ENTER)");
        pnl_numpad.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 80, -1));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields1.png"))); // NOI18N
        btn_clear.setBorderPainted(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields-MO.png"))); // NOI18N
        btn_clear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields-MO.png"))); // NOI18N
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 90, -1));

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(41, 9, 149));
        jLabel15.setText("CLEAR");
        pnl_numpad.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 50, 20));

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(149, 9, 12));
        jLabel16.setText("(F5)");
        pnl_numpad.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 40, 20));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_cancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        pnl_numpad.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 70, -1));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(41, 9, 149));
        jLabel13.setText("CLOSE");
        pnl_numpad.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 60, 20));

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(149, 9, 12));
        jLabel14.setText("ESCAPE");
        pnl_numpad.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 70, 20));

        lbl_title.setBackground(java.awt.Color.white);
        lbl_title.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("LUMO");
        lbl_title.setOpaque(true);

        javax.swing.GroupLayout pnl_floorLayout = new javax.swing.GroupLayout(pnl_floor);
        pnl_floor.setLayout(pnl_floorLayout);
        pnl_floorLayout.setHorizontalGroup(
            pnl_floorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_floorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_floorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_floorLayout.createSequentialGroup()
                        .addComponent(pnl_layer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_numpad, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnl_floorLayout.setVerticalGroup(
            pnl_floorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_floorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_floorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_numpad, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(pnl_layer1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_floor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_floor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
    do_6();
}//GEN-LAST:event_btn_6ActionPerformed

private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
    do_3();
}//GEN-LAST:event_btn_3ActionPerformed

private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
    do_7();
}//GEN-LAST:event_btn_7ActionPerformed

private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
    do_8();
}//GEN-LAST:event_btn_8ActionPerformed

private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
    do_9();
}//GEN-LAST:event_btn_9ActionPerformed

private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
    do_4();
}//GEN-LAST:event_btn_4ActionPerformed

private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
    do_5();
}//GEN-LAST:event_btn_5ActionPerformed

private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
    do_1();
}//GEN-LAST:event_btn_1ActionPerformed

private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
    do_2();
}//GEN-LAST:event_btn_2ActionPerformed

private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
    do_0();
}//GEN-LAST:event_btn_0ActionPerformed

private void btn_dotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dotActionPerformed
    do_dot();
}//GEN-LAST:event_btn_dotActionPerformed

private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
    do_ok();
}//GEN-LAST:event_btn_okActionPerformed

private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
//    clear_field();
    this.dispose();
}//GEN-LAST:event_btn_cancelActionPerformed

private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
    do_clear();
}//GEN-LAST:event_btn_clearActionPerformed

    private void cb_uomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_uomActionPerformed
        // TODO add your handling code here:
        get_uom_amount();
    }//GEN-LAST:event_cb_uomActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_dot;
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox cb_uom;
    private javax.swing.JLabel ds_amountdue;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_available_kilos;
    private javax.swing.JLabel lbl_price_per_kilo;
    private javax.swing.JLabel lbl_qty;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_floor;
    private javax.swing.JPanel pnl_layer1;
    private javax.swing.JPanel pnl_numpad;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//          if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
//           
//            this.setUndecorated(true);
//        } else {
//             JOptionPane.showMessageDialog(null, System.getProperty("os.name"));
//            this.setUndecorated(false);
//        }

        initActionKey();
        initTfDummy();
        initDisableBtnFocus();
//        init_uom();
//        btn_cancel.setVisible(false);
    }

    public void pass() {
        cb_uom.setEnabled(false);
    }

    private void init_uom() {
        cb_uom.setModel(new ListComboBoxModel(S7_uom.uoms(code)));
    }

    private void get_uom_amount() {
        double due_amount = 0;
        if (cb_uom.getSelectedIndex() == 0) {
            lbl_available_kilos.setText(NumType.no_decimal(q));
            lbl_price_per_kilo.setText(NumType.with_comma(p));

            double qty = 0;
            if (lbl_qty.getText().isEmpty()) {
                qty = 0;
            } else {
                qty = Double.parseDouble(lbl_qty.getText());
            }


            due_amount = qty * input_data.price;

            String str_amt_due = MessageFormat.format("{0,number,#,##0.00}", due_amount);
            ds_amountdue.setText(str_amt_due);
        } else {
            String uom = cb_uom.getSelectedItem().toString();
            double uom_amount = S7_uom.get_uom_amount(uom, code);
            double total = q / uom_amount;
            double total_price = p * uom_amount;
            lbl_available_kilos.setText(FitIn.fmt_woc_0(total));
            lbl_price_per_kilo.setText(NumType.with_comma(total_price));

            double qty = 0;
            if (lbl_qty.getText().isEmpty()) {
                qty = 0;
            } else {
                qty = Double.parseDouble(lbl_qty.getText());
            }
            due_amount = (qty * uom_amount) * input_data.price;
//            lbl_available_kilos.setText(FitIn.fmt_woc_0(total));
//            lbl_price_per_kilo.setText(NumType.with_comma(total_price));
//            JOptionPane.showMessageDialog(null, uom_amount);


            String str_amt_due = MessageFormat.format("{0,number,#,##0.00}", due_amount);
            ds_amountdue.setText(str_amt_due);
//            JOptionPane.showMessageDialog(null, uom_amount);
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" myInit ">
    private void clear_field() {
        Backspace.clear_lbl(lbl_qty);
        tf_dummy.setText(lbl_qty.getText());

//        put_text(lbl_qty.getText());
        compute_2();

    }

    private void initDisableBtnFocus() {
        JButton[] bs = new JButton[]{
            btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_dot,
            btn_cancel, btn_clear, btn_ok
        };

        for (JButton b : bs) {
            b.setFocusable(false);
        }
    }

    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_BACK_SPACE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clear_field();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD0, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_0.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_0, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_0.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_PERIOD, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_dot.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_1.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_1.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_2.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_2.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_3.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_3.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD4, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_4.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_4, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_4.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_5.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_5.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD6, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_6.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_6, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_6.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD7, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_7.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_7, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_7.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD8, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_8.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_8, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_8.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_NUMPAD9, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_9.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_9, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_9.doClick();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_DECIMAL, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_dot.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ENTER, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_ok.doClick();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btn_clear.doClick();
            }
        });
    }
    //</editor-fold>
    private JTextField tf_dummy;

    private void initTfDummy() {
        lbl_price_per_kilo.setText("");
        lbl_qty.setText("");
        ds_amountdue.setText("");
        tf_dummy = new JTextField();
        CurrencyDocument cd = new CurrencyDocument(true, 10);
        tf_dummy.setDocument(cd);
    }
    private InputData input_data;
    String code = "";
    double q = 0;
    double p = 0;

    public void load(InputData data) {
        code = data.names;
        init_uom();
        this.input_data = data;
        q = data.qty;
        p = data.price;


        if (data.uom.equals("pcs")) {
            cb_uom.setSelectedIndex(0);
            lbl_price_per_kilo.setText(NumType.with_comma(input_data.price));
            lbl_title.setText(input_data.title);
//        lbl_available_kilos.setText(FitIn.fmt_number(input_data.qty, "#.##"));
            lbl_available_kilos.setText(NumType.no_decimal(data.qty));

        } else {
//            JOptionPane.showMessageDialog(null, data.uom);
            cb_uom.setSelectedItem(data.uom);
            get_uom_amount();
        }

    }

    private void put_text(String str) {

        boolean linient = S6_linient.is_linient(code);
//        JOptionPane.showMessageDialog(null, linient + " " + code);
        if (linient == false) {
            if (lbl_available_kilos.getText().
                    equals("0")) {
                Prompt.call("No Stocks Available");
//                JOptionPane.showMessageDialog(null, "No Stocks Available");
                return;
            }
            CurrencyDocument.decimalInserter(tf_dummy, str);
//        JOptionPane.showMessageDialog(null, str);
            double qtyy = 0;
            if (tf_dummy.getText().
                    isEmpty()) {
                qtyy = 0;
            }

            qtyy = Double.parseDouble(tf_dummy.getText());

            if (qtyy > Double.parseDouble((lbl_available_kilos.getText()))) {
//            tf_dummy.setText("0");
//            return;
//            JOptionPane.showMessageDialog(null, "adadad");
            } else {



                lbl_qty.setText(tf_dummy.getText());



//                lbl_price_per_kilo.setText(MessageFormat.format("{0,number,#,##0.00}", input_data.price));

                double due_amount = 0;


                try {
                    if (cb_uom.getSelectedIndex() == 0) {
                        due_amount = Double.parseDouble(lbl_qty.getText()) * input_data.price;
                    } else {
                        String uoms = cb_uom.getSelectedItem().toString();
                        double uom_amount = S7_uom.get_uom_amount(uoms, code);
                        double total = q / uom_amount;
                        double total_price = p * uom_amount;

                        due_amount = (Double.parseDouble(lbl_qty.getText()) * uom_amount) * input_data.price;
//            lbl_available_kilos.setText(FitIn.fmt_woc_0(total));
//            lbl_price_per_kilo.setText(NumType.with_comma(total_price));
//            JOptionPane.showMessageDialog(null, uom_amount);
                    }
                } catch (Exception e) {
                    due_amount = 0;
                }

                String str_amt_due = MessageFormat.format("{0,number,#,##0.00}", due_amount);
                ds_amountdue.setText(str_amt_due);
            }
        } else {

            CurrencyDocument.decimalInserter(tf_dummy, str);
//        JOptionPane.showMessageDialog(null, str);
            double qtyy = 0;
            if (tf_dummy.getText().
                    isEmpty()) {
                qtyy = 0;
            }

            qtyy = Double.parseDouble(tf_dummy.getText());

//            if (qtyy > Double.parseDouble((lbl_available_kilos.getText()))) {
////            tf_dummy.setText("0");
////            return;
////            JOptionPane.showMessageDialog(null, "adadad");
//            } else {




            lbl_qty.setText(tf_dummy.getText());



//            lbl_price_per_kilo.setText(MessageFormat.format("{0,number,#,##0.00}", input_data.price));

            double due_amount = 0;




            try {
                if (cb_uom.getSelectedIndex() == 0) {
                    due_amount = Double.parseDouble(lbl_qty.getText()) * input_data.price;
                } else {
                    String uom = cb_uom.getSelectedItem().toString();
                    double uom_amount = S7_uom.get_uom_amount(uom, code);
                    double total = q / uom_amount;
                    double total_price = p * uom_amount;
                    due_amount = Double.parseDouble(lbl_qty.getText()) * total_price;
//            JOptionPane.showMessageDialog(null, uom_amount);
                }

            } catch (Exception e) {
                due_amount = 0;
            }

            String str_amt_due = MessageFormat.format("{0,number,#,##0.00}", due_amount);
            ds_amountdue.setText(str_amt_due);
//            }
        }





    }

    private void compute_2() {
//        CurrencyDocument.decimalInserter(tf_dummy, str);
//        JOptionPane.showMessageDialog(null, str);
        double qtyy = 0;
        if (tf_dummy.getText().
                isEmpty()) {
            qtyy = 0;
        } else {
            qtyy = Double.parseDouble(tf_dummy.getText());
        }



        if (qtyy > Double.parseDouble((lbl_available_kilos.getText()))) {
            return;
        }

        lbl_qty.setText(tf_dummy.getText());



        lbl_price_per_kilo.setText(MessageFormat.format("{0,number,#,##0.00}", input_data.price));

        double due_amount = 0;
        try {
            due_amount = Double.parseDouble(lbl_qty.getText()) * input_data.price;
        } catch (Exception e) {
            due_amount = 0;
        }

        String str_amt_due = MessageFormat.format("{0,number,#,##0.00}", due_amount);
        ds_amountdue.setText(str_amt_due);
    }

    private void do_clear() {
        tf_dummy.setText("");
        lbl_qty.setText(tf_dummy.getText());

        double due_amount = 0;
        try {
            due_amount = Double.parseDouble(lbl_qty.getText()) * input_data.price;
        } catch (Exception e) {
            due_amount = 0;
        }

        String str_amt_due = MessageFormat.format("{0,number,#,##0.00}", due_amount);
        ds_amountdue.setText(str_amt_due);

    }

    private void do_7() {
        put_text("7");
    }

    private void do_8() {
        put_text("8");
    }

    private void do_9() {
        put_text("9");
    }

    private void do_4() {
        put_text("4");
    }

    private void do_5() {
        put_text("5");
    }

    private void do_6() {
        put_text("6");
    }

    private void do_1() {
        put_text("1");
    }

    private void do_2() {
        put_text("2");
    }

    private void do_3() {
        put_text("3");
    }

    private void do_0() {
        put_text("0");
    }

    private void do_dot() {
        put_text(".");
    }

    private void do_cancel() {
        this.setVisible(false);
    }

    private void do_ok() {
        if (callback == null) {
            return;
        }


        prcss_work_on();

    }

    private void prcss_work_on() {

        double hd_uom = 0;


        if (lbl_qty.getText().isEmpty()) {
            Prompt.call("Input Quantity");
            return;
        }

        double qty = 0;
        try {
            qty = Double.parseDouble(lbl_qty.getText());
        } catch (Exception e) {
            qty = 0;
        }
        double price = Double.parseDouble(FitIn.fmt_woc(lbl_price_per_kilo.getText()));

        String uom = cb_uom.getSelectedItem().toString();
        double pricing = 0;
        if (cb_uom.getSelectedIndex() == 0) {
            pricing = input_data.price;
            hd_uom = qty;
        } else {
            String uoms = cb_uom.getSelectedItem().toString();
            double uom_amount = S7_uom.get_uom_amount(uoms, code);
            double total = q / uom_amount;
            double total_price = p * uom_amount;
            pricing = total_price;
            hd_uom = qty * uom_amount;
//            lbl_available_kilos.setText(FitIn.fmt_woc_0(total));
//            lbl_price_per_kilo.setText(NumType.with_comma(total_price));
//            JOptionPane.showMessageDialog(null, uom_amount);
        }


        boolean linient = S6_linient.is_linient(code);

        if (linient == true) {
//            order.setQuantity(qty);
            to_order order = new to_order(input_data.title, pricing, qty, uom, input_data.names, hd_uom, "-1", "-1","cat",0,0);
            callback.ok(new CloseDialog(this), new Dlg_quantity.OutputData(order));
            this.dispose();
        } else {
            if (qty == 0) {
                Prompt.call("Enter Quantity");
//                JOptionPane.showMessageDialog(this, "Enter Quantity");
//                return;
            } else {
//                order.setQuantity(qty);
                to_order order = new to_order(input_data.title, pricing, qty, uom, input_data.names, hd_uom, "-1", "-1","cat",0,0);
                callback.ok(new CloseDialog(this), new Dlg_quantity.OutputData(order));
                this.dispose();
            }
        }



    }
}
