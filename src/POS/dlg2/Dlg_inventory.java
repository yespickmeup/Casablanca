/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlg_inventory.java
 *
 * Created on Feb 25, 2012, 5:52:34 PM
 */
package POS.dlg2;

import POS.rpt2.rpt_report;
import POS.svc2.S5_ret_system_date;
import POS.svc3.S1_select_products;
import POS.svc3.S4_select_inventory_if_exist;
import POS.svc3.S5_update_inventory;
import POS.svc3.S6_check_time;
import POS.to2.to_product_list;
import POS.utl.DateType;
import POS.utl.Prompt;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.Application;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_inventory extends javax.swing.JDialog {

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
    private Dlg_inventory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_inventory(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_inventory() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_inventory myRef;

    private void setThisRef(Dlg_inventory myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_inventory> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_inventory create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_inventory create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory((java.awt.Frame) parent, false);
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
            Dlg_inventory dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_inventory((java.awt.Dialog) parent, false);
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
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.
                    getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Dlg_inventory dialog = Dlg_inventory.create(new javax.swing.JFrame(), true);
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

        tf_amount2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_edit1 = new javax.swing.JButton();
        btn_edit2 = new javax.swing.JButton();
        btn_edit3 = new javax.swing.JButton();
        btn_edit4 = new javax.swing.JButton();
        btn_edit5 = new javax.swing.JButton();
        btn_edit6 = new javax.swing.JButton();
        btn_edit7 = new javax.swing.JButton();
        btn_edit8 = new javax.swing.JButton();
        btn_edit9 = new javax.swing.JButton();
        lb_p9 = new javax.swing.JLabel();
        lb_b3 = new javax.swing.JLabel();
        lb_p1 = new javax.swing.JLabel();
        lb_p2 = new javax.swing.JLabel();
        lb_p3 = new javax.swing.JLabel();
        lb_p4 = new javax.swing.JLabel();
        lb_p5 = new javax.swing.JLabel();
        lb_p6 = new javax.swing.JLabel();
        lb_p7 = new javax.swing.JLabel();
        lb_p8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lb_b1 = new javax.swing.JLabel();
        lb_b2 = new javax.swing.JLabel();
        lb_b6 = new javax.swing.JLabel();
        lb_b4 = new javax.swing.JLabel();
        lb_b5 = new javax.swing.JLabel();
        lb_b9 = new javax.swing.JLabel();
        lb_b7 = new javax.swing.JLabel();
        lb_b8 = new javax.swing.JLabel();
        lb_e3 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lb_e1 = new javax.swing.JLabel();
        lb_e2 = new javax.swing.JLabel();
        lb_e6 = new javax.swing.JLabel();
        lb_e4 = new javax.swing.JLabel();
        lb_e5 = new javax.swing.JLabel();
        lb_e9 = new javax.swing.JLabel();
        lb_e7 = new javax.swing.JLabel();
        lb_e8 = new javax.swing.JLabel();
        lb_v3 = new javax.swing.JLabel();
        lb_v1 = new javax.swing.JLabel();
        lb_v2 = new javax.swing.JLabel();
        lb_v6 = new javax.swing.JLabel();
        lb_v4 = new javax.swing.JLabel();
        lb_v5 = new javax.swing.JLabel();
        lb_v9 = new javax.swing.JLabel();
        lb_v7 = new javax.swing.JLabel();
        lb_v8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bt_stat = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tf_am2 = new javax.swing.JTextField();
        tf_am3 = new javax.swing.JTextField();
        tf_am1 = new javax.swing.JTextField();
        tf_am4 = new javax.swing.JTextField();
        tf_am5 = new javax.swing.JTextField();
        tf_am6 = new javax.swing.JTextField();
        tf_am7 = new javax.swing.JTextField();
        tf_am8 = new javax.swing.JTextField();
        tf_am9 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lb_var1 = new javax.swing.JLabel();
        lb_var2 = new javax.swing.JLabel();
        lb_var3 = new javax.swing.JLabel();
        lb_var4 = new javax.swing.JLabel();
        lb_var5 = new javax.swing.JLabel();
        lb_var6 = new javax.swing.JLabel();
        lb_var7 = new javax.swing.JLabel();
        lb_var8 = new javax.swing.JLabel();
        lb_var9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        dp_date = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        cb_time = new javax.swing.JComboBox();

        tf_amount2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_amount2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_amount2.setText("0.0");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(249, 206, 206));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel2.setText("END");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 40, 39));

        btn_edit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit1.setBorderPainted(false);
        btn_edit1.setContentAreaFilled(false);
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 40, 40));

        btn_edit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit2.setBorderPainted(false);
        btn_edit2.setContentAreaFilled(false);
        btn_edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 250, 40, 40));

        btn_edit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit3.setBorderPainted(false);
        btn_edit3.setContentAreaFilled(false);
        btn_edit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 290, 40, 40));

        btn_edit4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit4.setBorderPainted(false);
        btn_edit4.setContentAreaFilled(false);
        btn_edit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 330, 40, 40));

        btn_edit5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit5.setBorderPainted(false);
        btn_edit5.setContentAreaFilled(false);
        btn_edit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, 40, 40));

        btn_edit6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit6.setBorderPainted(false);
        btn_edit6.setContentAreaFilled(false);
        btn_edit6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, 40, 40));

        btn_edit7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit7.setBorderPainted(false);
        btn_edit7.setContentAreaFilled(false);
        btn_edit7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 40, 40));

        btn_edit8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit8.setBorderPainted(false);
        btn_edit8.setContentAreaFilled(false);
        btn_edit8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 490, 40, 40));

        btn_edit9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/edit2.png"))); // NOI18N
        btn_edit9.setBorderPainted(false);
        btn_edit9.setContentAreaFilled(false);
        btn_edit9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit9ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 40, 40));

        lb_p9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p9.setText("PRODUCTS");
        jPanel1.add(lb_p9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 240, 39));

        lb_b3.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 60, 39));

        lb_p1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p1.setText("PRODUCTS");
        jPanel1.add(lb_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 240, 39));

        lb_p2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p2.setText("PRODUCTS");
        jPanel1.add(lb_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 240, 39));

        lb_p3.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p3.setText("PRODUCTS");
        jPanel1.add(lb_p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 240, 39));

        lb_p4.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p4.setText("PRODUCTS");
        jPanel1.add(lb_p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 160, 39));

        lb_p5.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p5.setText("PRODUCTS");
        jPanel1.add(lb_p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 240, 39));

        lb_p6.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p6.setText("PRODUCTS");
        jPanel1.add(lb_p6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 240, 39));

        lb_p7.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p7.setText("PRODUCTS");
        jPanel1.add(lb_p7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 240, 39));

        lb_p8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_p8.setText("PRODUCTS");
        jPanel1.add(lb_p8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 240, 39));

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
        jLabel16.setText("Physical Count");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 110, 39));

        lb_b1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 60, 39));

        lb_b2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 60, 39));

        lb_b6.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 60, 39));

        lb_b4.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 60, 39));

        lb_b5.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 60, 39));

        lb_b9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 60, 39));

        lb_b7.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, 60, 39));

        lb_b8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_b8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_b8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 60, 39));

        lb_e3.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 60, 39));

        jLabel29.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel29.setText("SOLD OUT");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, 39));

        lb_e1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 60, 39));

        lb_e2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 60, 39));

        lb_e6.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 60, 39));

        lb_e4.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 60, 39));

        lb_e5.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 60, 39));

        lb_e9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 60, 39));

        lb_e7.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 60, 39));

        lb_e8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_e8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_e8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_e8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 60, 39));

        lb_v3.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 60, 39));

        lb_v1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 60, 39));

        lb_v2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 60, 39));

        lb_v6.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 60, 39));

        lb_v4.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 60, 39));

        lb_v5.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 60, 39));

        lb_v9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 60, 39));

        lb_v7.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 60, 39));

        lb_v8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_v8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_v8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_v8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 60, 39));

        jButton1.setText("NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 590, 350, 30));

        bt_stat.setText("0 / 0");
        jPanel1.add(bt_stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 590, 160, 30));

        jButton3.setText("PREVIOUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 350, 30));

        tf_am2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am2.setText("0.0");
        tf_am2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am2KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 70, 40));

        tf_am3.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am3.setText("0.0");
        tf_am3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am3KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 70, 40));

        tf_am1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am1.setText("0.0");
        tf_am1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am1KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 70, 40));

        tf_am4.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am4.setText("0.0");
        tf_am4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am4KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 70, 40));

        tf_am5.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am5.setText("0.0");
        tf_am5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am5KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 70, 40));

        tf_am6.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am6.setText("0.0");
        tf_am6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am6KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 70, 40));

        tf_am7.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am7.setText("0.0");
        tf_am7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am7KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 70, 40));

        tf_am8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am8.setText("0.0");
        tf_am8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am8KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 70, 40));

        tf_am9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        tf_am9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_am9.setText("0.0");
        tf_am9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_am9KeyReleased(evt);
            }
        });
        jPanel1.add(tf_am9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 70, 40));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 0, 36));
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("INVENTORY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addGap(173, 173, 173))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 860, 90));

        btn_print.setText("PRINT");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel1.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 100, 30));

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel8.setText("PRODUCTS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 132, 39));

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel9.setText("Time:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 60, 39));

        jLabel17.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel17.setText("BEG");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 40, 39));

        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 100, 430));

        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 860, 40));

        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 120, 430));

        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 100, 430));

        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 620, 430));

        jLabel20.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel20.setText("VARIANCE");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 80, 39));

        lb_var1.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var1.setText("0.0");
        lb_var1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 60, 39));

        lb_var2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var2.setText("0.0");
        lb_var2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 250, 60, 39));

        lb_var3.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var3.setText("0.0");
        lb_var3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 290, 60, 39));

        lb_var4.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var4.setText("0.0");
        lb_var4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 60, 39));

        lb_var5.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var5.setText("0.0");
        lb_var5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 370, 60, 39));

        lb_var6.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var6.setText("0.0");
        lb_var6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, 60, 39));

        lb_var7.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var7.setText("0.0");
        lb_var7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 60, 39));

        lb_var8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var8.setText("0.0");
        lb_var8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 60, 39));

        lb_var9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        lb_var9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_var9.setText("0.0");
        lb_var9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lb_var9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 60, 39));

        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 120, 430));

        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 120, 430));

        btn_clear.setText("SAVE");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 90, 30));

        dp_date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dp_datePropertyChange(evt);
            }
        });
        jPanel1.add(dp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 190, -1));

        jLabel11.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel11.setText("DATE:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 39));

        cb_time.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_timeMouseClicked(evt);
            }
        });
        cb_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_timeActionPerformed(evt);
            }
        });
        cb_time.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cb_timePropertyChange(evt);
            }
        });
        jPanel1.add(cb_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    do_next();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
    do_prev();
}//GEN-LAST:event_jButton3ActionPerformed

private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
// TODO add your handling code here:
    print();
}//GEN-LAST:event_btn_printActionPerformed

    private void tf_am1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am1KeyReleased
        // TODO add your handling code here:
        diff1();
    }//GEN-LAST:event_tf_am1KeyReleased

    private void tf_am9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am9KeyReleased
        // TODO add your handling code here:
        diff9();
    }//GEN-LAST:event_tf_am9KeyReleased

    private void tf_am8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am8KeyReleased
        // TODO add your handling code here:
        diff8();
    }//GEN-LAST:event_tf_am8KeyReleased

    private void tf_am7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am7KeyReleased
        // TODO add your handling code here:
        diff7();
    }//GEN-LAST:event_tf_am7KeyReleased

    private void tf_am6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am6KeyReleased
        // TODO add your handling code here:
        diff6();
    }//GEN-LAST:event_tf_am6KeyReleased

    private void tf_am5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am5KeyReleased
        // TODO add your handling code here:
        diff5();
    }//GEN-LAST:event_tf_am5KeyReleased

    private void tf_am4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am4KeyReleased
        // TODO add your handling code here:
        diff4();
    }//GEN-LAST:event_tf_am4KeyReleased

    private void tf_am3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am3KeyReleased
        // TODO add your handling code here:
        diff3();
    }//GEN-LAST:event_tf_am3KeyReleased

    private void tf_am2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_am2KeyReleased
        // TODO add your handling code here:
        diff2();
    }//GEN-LAST:event_tf_am2KeyReleased

private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
// TODO add your handling code here:
    update();
}//GEN-LAST:event_btn_clearActionPerformed

private void btn_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit1ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p1, lb_b1, lb_v1, lb_e1, lb_var1, tf_am1);
}//GEN-LAST:event_btn_edit1ActionPerformed

private void btn_edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit2ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p2, lb_b2, lb_v2, lb_e2, lb_var2, tf_am2);
}//GEN-LAST:event_btn_edit2ActionPerformed

private void btn_edit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit3ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p3, lb_b3, lb_v3, lb_e3, lb_var3, tf_am3);
}//GEN-LAST:event_btn_edit3ActionPerformed

private void btn_edit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit4ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p4, lb_b4, lb_v4, lb_e4, lb_var4, tf_am4);
}//GEN-LAST:event_btn_edit4ActionPerformed

private void btn_edit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit5ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p5, lb_b5, lb_v5, lb_e5, lb_var5, tf_am5);
}//GEN-LAST:event_btn_edit5ActionPerformed

private void btn_edit6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit6ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p6, lb_b6, lb_v6, lb_e6, lb_var6, tf_am6);
}//GEN-LAST:event_btn_edit6ActionPerformed

private void btn_edit7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit7ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p7, lb_b7, lb_v7, lb_e7, lb_var7, tf_am7);
}//GEN-LAST:event_btn_edit7ActionPerformed

private void btn_edit8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit8ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p8, lb_b8, lb_v8, lb_e8, lb_var8, tf_am8);
}//GEN-LAST:event_btn_edit8ActionPerformed

private void btn_edit9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit9ActionPerformed
    // TODO add your handling code here:
    do_edit(lb_p9, lb_b9, lb_v9, lb_e9, lb_var9, tf_am9);
}//GEN-LAST:event_btn_edit9ActionPerformed

private void dp_datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dp_datePropertyChange
// TODO add your handling code here:
    set_time(timer);
//    do_next();
}//GEN-LAST:event_dp_datePropertyChange

private void cb_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_timeActionPerformed
// TODO add your handling code here:
//    do_next();
//    JOptionPane.showMessageDialog(null, sets);
//    if (sets == 1) {
//        set_main_items();
//    }
//    if (sets == 2) {
////        jj-=9;
////        do_next();
//    }
//    if (sets == 3) {
////         jj-=9;
//        do_prev();
//    }
//    set_main_items();
    set_items();

//        do_next();
}//GEN-LAST:event_cb_timeActionPerformed

private void cb_timePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cb_timePropertyChange
// TODO add your handling code here:
//      do_next();
}//GEN-LAST:event_cb_timePropertyChange

private void cb_timeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_timeMouseClicked
// TODO add your handling code here:
    set();

}//GEN-LAST:event_cb_timeMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_stat;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_edit2;
    private javax.swing.JButton btn_edit3;
    private javax.swing.JButton btn_edit4;
    private javax.swing.JButton btn_edit5;
    private javax.swing.JButton btn_edit6;
    private javax.swing.JButton btn_edit7;
    private javax.swing.JButton btn_edit8;
    private javax.swing.JButton btn_edit9;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox cb_time;
    private com.toedter.calendar.JDateChooser dp_date;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_b1;
    private javax.swing.JLabel lb_b2;
    private javax.swing.JLabel lb_b3;
    private javax.swing.JLabel lb_b4;
    private javax.swing.JLabel lb_b5;
    private javax.swing.JLabel lb_b6;
    private javax.swing.JLabel lb_b7;
    private javax.swing.JLabel lb_b8;
    private javax.swing.JLabel lb_b9;
    private javax.swing.JLabel lb_e1;
    private javax.swing.JLabel lb_e2;
    private javax.swing.JLabel lb_e3;
    private javax.swing.JLabel lb_e4;
    private javax.swing.JLabel lb_e5;
    private javax.swing.JLabel lb_e6;
    private javax.swing.JLabel lb_e7;
    private javax.swing.JLabel lb_e8;
    private javax.swing.JLabel lb_e9;
    private javax.swing.JLabel lb_p1;
    private javax.swing.JLabel lb_p2;
    private javax.swing.JLabel lb_p3;
    private javax.swing.JLabel lb_p4;
    private javax.swing.JLabel lb_p5;
    private javax.swing.JLabel lb_p6;
    private javax.swing.JLabel lb_p7;
    private javax.swing.JLabel lb_p8;
    private javax.swing.JLabel lb_p9;
    private javax.swing.JLabel lb_v1;
    private javax.swing.JLabel lb_v2;
    private javax.swing.JLabel lb_v3;
    private javax.swing.JLabel lb_v4;
    private javax.swing.JLabel lb_v5;
    private javax.swing.JLabel lb_v6;
    private javax.swing.JLabel lb_v7;
    private javax.swing.JLabel lb_v8;
    private javax.swing.JLabel lb_v9;
    private javax.swing.JLabel lb_var1;
    private javax.swing.JLabel lb_var2;
    private javax.swing.JLabel lb_var3;
    private javax.swing.JLabel lb_var4;
    private javax.swing.JLabel lb_var5;
    private javax.swing.JLabel lb_var6;
    private javax.swing.JLabel lb_var7;
    private javax.swing.JLabel lb_var8;
    private javax.swing.JLabel lb_var9;
    private javax.swing.JTextField tf_am1;
    private javax.swing.JTextField tf_am2;
    private javax.swing.JTextField tf_am3;
    private javax.swing.JTextField tf_am4;
    private javax.swing.JTextField tf_am5;
    private javax.swing.JTextField tf_am6;
    private javax.swing.JTextField tf_am7;
    private javax.swing.JTextField tf_am8;
    private javax.swing.JTextField tf_am9;
    private javax.swing.JTextField tf_amount2;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">

    private void myInit() {
        initActionKey();
        set_date();
        get_records();
        set_main_items();
        numbers_only();
        hides();
//        t.start();
    }

    private void hides() {
//        btn_print.setVisible(false);
    }

    private void numbers_only() {
//        tf_am1.setDocument(new CurrencyDocument(true, 20));
//        tf_am2.setDocument(new CurrencyDocument(true, 20));
//        tf_am3.setDocument(new CurrencyDocument(true, 20));
//        tf_am4.setDocument(new CurrencyDocument(true, 20));
//        tf_am5.setDocument(new CurrencyDocument(true, 20));
//        tf_am6.setDocument(new CurrencyDocument(true, 20));
//        tf_am7.setDocument(new CurrencyDocument(true, 20));
//        tf_am8.setDocument(new CurrencyDocument(true, 20));
//        tf_am9.setDocument(new CurrencyDocument(true, 20));
    }

    private void set_date() {

//        lb_date.setText(DateUtil.toStringDate(
//                DateUtil.FMT_Date_MMM_dd_yyyy, S5_ret_system_date.
//                do_ret_system_date()));
        dp_date.setDate(S5_ret_system_date.do_ret_system_date());

    }
    int g = 0;
    String timer = "";
    Timer t = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {


            Date d = new Date();
            SimpleDateFormat ss = new SimpleDateFormat("hh:mm:ss");
            timer = ss.format(new Date());
//            System.out.println(g);
            int ro = cb_time.getItemCount();
            if (ro == 0) {
                return;
            }
            int sel = cb_time.getSelectedIndex();
            System.out.println(sel);
            if (sel == 0) {
//                set_time(timer);
            } else {
            }

//            g++;

        }
    });

    private void set_time(String time) {

//        cb_time.setModel(new ListComboBoxModel(S6_check_time.check_time(dp_date.
//                getDate(), timer)));

//          JOptionPane.showMessageDialog(null, "adad");
    }

    private void set() {
//        JOptionPane.showMessageDialog(null, "adad");
    }

    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    //</editor-fold>

    public void load(InputData data) {
    }

    private void cancel() {
        this.setVisible(false);
    }

    private void do_ok() {
        if (callback == null) {
            return;
        }

//        Executor.doExecute(this, new Executor.Task() {
//
//            @Override
//            public void work_on() {
        prcss_work_on();
//            }
//        });
    }

    private void prcss_work_on() {
        callback.ok(new CloseDialog(this), new OutputData());
    }
    int base = 0;
    int limit = 9;
    List<to_product_list> datas = new ArrayList();
    List name = new ArrayList();
    List beg = new ArrayList();
    List end = new ArrayList();
    int rows = 0;
    int sets = 0;

    private void get_records() {

        datas = S1_select_products.ret_products();
        rows = datas.size();
//        System.out.println(rows);

        for (to_product_list t : datas) {
            name.add(t.name);
            beg.add(t.beg);
            end.add(t.end);
//            System.out.println(t.beg);
        }
        bt_stat.setText("" + (limit) + " / " + (rows));
//        System.out.println(lbl.length);
    }
    int jj = 0;

    private void set_main_items() {

        holder = jj;
        sets = 1;
        if (jj > rows) {
            jj = rows;
        }

        if (rows == 0) {
            return;
        }
        int aw = 0;
        JLabel[] lbl = {lb_p1, lb_p2, lb_p3, lb_p4, lb_p5, lb_p6, lb_p7, lb_p8, lb_p9};
        JLabel[] begs = {lb_b1, lb_b2, lb_b3, lb_b4, lb_b5, lb_b6, lb_b7, lb_b8, lb_b9};
        JLabel[] ends = {lb_e1, lb_e2, lb_e3, lb_e4, lb_e5, lb_e6, lb_e7, lb_e8, lb_e9};
        JLabel[] variance = {lb_v1, lb_v2, lb_v3, lb_v4, lb_v5, lb_v6, lb_v7, lb_v8, lb_v9};
        JTextField[] update = {tf_am1, tf_am2, tf_am3, tf_am4, tf_am5, tf_am6, tf_am7, tf_am8, tf_am9};

        JLabel[] new_variance = {lb_var1, lb_var2, lb_var3, lb_var4, lb_var5, lb_var6, lb_var7, lb_var8, lb_var9};
        JButton[] edit = {btn_edit1, btn_edit2, btn_edit3, btn_edit4, btn_edit5, btn_edit6, btn_edit7, btn_edit8, btn_edit9};
        String[] aww = new String[6];


        for (JLabel b : lbl) {
//            lbl[aw].setText(FitIn.fmt_number(aw, "#")); // name.get(aw).toString());


            if (jj > rows) {
//                break;
            }
//            JOptionPane.showMessageDialog(null, jj);

//            System.out.println(jj + " adad");
            lbl[aw].setText(name.get(aw).
                    toString());
//            System.out.println(lbl[aw].getText());
            begs[aw].setText(beg.get(aw).
                    toString());
            variance[aw].setText(end.get(aw).
                    toString());

            ends[aw].setText(end.get(aw).
                    toString());

            double var = Double.parseDouble(begs[aw].getText()) - Double.
                    parseDouble(ends[aw].getText());
            variance[aw].setText("" + var);


            String time = "";
            int row = cb_time.getItemCount();
//            System.out.println(row);
            if (row == 0) {
                time = "";
            } else {
                time = cb_time.getSelectedItem().
                        toString();
            }

            aww = S4_select_inventory_if_exist.ret_inventory(name.get(aw).
                    toString(), dp_date.getDate(), time);
//            JOptionPane.showMessageDialog(null, time);
//            System.out.println(aww[0]);
            if (aww[0].equals("wala")) {
                update[aw].setText("0.0");
                update[aw].setEnabled(true);
                edit[aw].setEnabled(false);
                new_variance[aw].setText("0.0");
            } else {

                update[aw].setText(aww[0]);
                new_variance[aw].setText(aww[1]);
                begs[aw].setText(aww[2]);
                variance[aw].setText(aww[3]);
                ends[aw].setText(aww[4]);

                update[aw].setEnabled(false);
                edit[aw].setEnabled(true);

            }

            aw++;
            jj = aw;
        }
    }

    private void set_items() {

//        System.out.println(holder + " set items");
//        JOptionPane.showMessageDialog(null, jj);


        sets = 1;
//        if (jj > rows) {
//            jj = rows;
//        }

        if (rows == 0) {
            return;
        }

        int aw = 0;
        int j = holder;
//        aw=holder-1;
//        System.out.println( aw + " adad");


        JLabel[] lbl = {lb_p1, lb_p2, lb_p3, lb_p4, lb_p5, lb_p6, lb_p7, lb_p8, lb_p9};
        JLabel[] begs = {lb_b1, lb_b2, lb_b3, lb_b4, lb_b5, lb_b6, lb_b7, lb_b8, lb_b9};
        JLabel[] ends = {lb_e1, lb_e2, lb_e3, lb_e4, lb_e5, lb_e6, lb_e7, lb_e8, lb_e9};
        JLabel[] variance = {lb_v1, lb_v2, lb_v3, lb_v4, lb_v5, lb_v6, lb_v7, lb_v8, lb_v9};
        JTextField[] update = {tf_am1, tf_am2, tf_am3, tf_am4, tf_am5, tf_am6, tf_am7, tf_am8, tf_am9};

        JLabel[] new_variance = {lb_var1, lb_var2, lb_var3, lb_var4, lb_var5, lb_var6, lb_var7, lb_var8, lb_var9};
        JButton[] edit = {btn_edit1, btn_edit2, btn_edit3, btn_edit4, btn_edit5, btn_edit6, btn_edit7, btn_edit8, btn_edit9};
        String[] aww = new String[6];


        if (j >= rows) {
            j -= 9;
        }

        System.out.println(j + " jjjjjj " + rows + " rwowowo");
        for (JLabel b : lbl) {
//            lbl[aw].setText(FitIn.fmt_number(aw, "#")); // name.get(aw).toString());

//            JOptionPane.showMessageDialog(null, jj);

////            System.out.println(jj + " adad");
            if (j >= rows) {
                break;
            }


            lbl[aw].setText(name.get(j).
                    toString());
            System.out.println(j + " sfsdsdf");
//            System.out.println(lbl[aw].getText());
            begs[aw].setText(beg.get(j).
                    toString());
            variance[aw].setText(end.get(j).
                    toString());

            ends[aw].setText(end.get(j).
                    toString());

            double var = Double.parseDouble(begs[aw].getText()) - Double.
                    parseDouble(ends[aw].getText());
            variance[aw].setText("" + var);


            String time = "";
            int row = cb_time.getItemCount();
//            System.out.println(row);
            if (row == 0) {
                time = "";
            } else {
                time = cb_time.getSelectedItem().
                        toString();
            }

            aww = S4_select_inventory_if_exist.ret_inventory(name.get(j).
                    toString(), dp_date.getDate(), time);
//            JOptionPane.showMessageDialog(null, time);
//            System.out.println(aww[0]);
            if (aww[0].equals("wala")) {
                update[aw].setText("0.0");
                update[aw].setEnabled(true);
                edit[aw].setEnabled(false);
                edit[aw].setVisible(false);
                new_variance[aw].setText("0.0");
            } else {

                update[aw].setText(aww[0]);
                new_variance[aw].setText(aww[1]);
                begs[aw].setText(aww[2]);
                variance[aw].setText(aww[3]);
                ends[aw].setText(aww[4]);

                update[aw].setEnabled(false);
                edit[aw].setEnabled(true);

            }

//            System.out.println(holder + " --");
            aw++;
            j++;
//            jj = holder;
        }

//       holder=jj;

    }
    int holder = 0;

    private void do_next() {
        System.out.println(jj + " adadaadadad");
        holder = jj;
        sets = 2;
        int aw = 0;

//        JOptionPane.showMessageDialog(null, jj + " " +rows);
        JLabel[] lbl = {lb_p1, lb_p2, lb_p3, lb_p4, lb_p5, lb_p6, lb_p7, lb_p8, lb_p9};

        JLabel[] begs = {lb_b1, lb_b2, lb_b3, lb_b4, lb_b5, lb_b6, lb_b7, lb_b8, lb_b9};
        JLabel[] ends = {lb_e1, lb_e2, lb_e3, lb_e4, lb_e5, lb_e6, lb_e7, lb_e8, lb_e9};
        JLabel[] variance = {lb_v1, lb_v2, lb_v3, lb_v4, lb_v5, lb_v6, lb_v7, lb_v8, lb_v9};
        JTextField[] update = {tf_am1, tf_am2, tf_am3, tf_am4, tf_am5, tf_am6, tf_am7, tf_am8, tf_am9};
        JLabel[] variance_1 = {lb_var1, lb_var2, lb_var3, lb_var4, lb_var5, lb_var6, lb_var7, lb_var8, lb_var9};


        JLabel[] new_variance = {lb_var1, lb_var2, lb_var3, lb_var4, lb_var5, lb_var6, lb_var7, lb_var8, lb_var9};

        JButton[] edit = {btn_edit1, btn_edit2, btn_edit3, btn_edit4, btn_edit5, btn_edit6, btn_edit7, btn_edit8, btn_edit9};
        String[] aww = new String[3];
        for (JLabel b : lbl) {

            if (lb_p9.getText().
                    equals("")) {
                break;
            }

            if (jj >= rows) {
                lbl[aw].setText("");
                lbl[aw].setVisible(false);
                begs[aw].setText("");
                begs[aw].setVisible(false);
                ends[aw].setText("");
                ends[aw].setVisible(false);
                variance[aw].setText("");
                variance[aw].setVisible(false);

                edit[aw].setVisible(false);

                update[aw].setText("");

                variance_1[aw].setText("");
                variance_1[aw].setVisible(false);

                update[aw].setEnabled(false);
                update[aw].setVisible(false);
            } else {

                lbl[aw].setVisible(true);
                begs[aw].setVisible(true);
                ends[aw].setVisible(true);
                variance[aw].setVisible(true);
                update[aw].setVisible(true);
                edit[aw].setVisible(true);

                lbl[aw].setText(name.get(jj).
                        toString());
                begs[aw].setText(beg.get(jj).
                        toString());
                ends[aw].setText(end.get(jj).
                        toString());

                double var = Double.parseDouble(begs[aw].getText()) - Double.
                        parseDouble(ends[aw].getText());
                variance[aw].setText("" + var);

                String time = "";
                int row = cb_time.getItemCount();
//                System.out.println(row);
                if (row == 0) {
                    time = "";
                } else {
                    time = cb_time.getSelectedItem().
                            toString();
                }


                aww = S4_select_inventory_if_exist.ret_inventory(name.get(jj).
                        toString(), dp_date.getDate(), time);
//                System.out.println(aww[0]);
                if (aww[0].equals("wala")) {
                    update[aw].setText("0.0");
                    new_variance[aw].setText("0.0");
                    update[aw].setEnabled(true);
//                    edit[aw].setVisible(false);
                    edit[aw].setEnabled(false);
                } else {
                    update[aw].setText(aww[0]);
                    new_variance[aw].setText(aww[1]);
                    begs[aw].setText(aww[2]);
                    variance[aw].setText(aww[4]);
                    ends[aw].setText(aww[3]);


                    update[aw].setEnabled(false);
                    edit[aw].setEnabled(true);
                }
//                System.out.println(lbl[aw].getText());
                if (lbl[aw].getText().
                        equals(" ")) {
                }
            }

            aw++;
            jj++;


            int jjj = jj;
            if (jj > rows) {
                jjj = rows;
            } else {
                jjj = jj;
            }
            bt_stat.setText("" + (jjj) + " / " + (rows));
//            jj = aw;
        }
//        JOptionPane.showMessageDialog(null, jj);
    }

    private void do_prev() {

        sets = 3;
//       JOptionPane.showMessageDialog(null, jj);
        if (jj == 9) {

            return;
        }
        jj = jj - 18;
        holder = jj;
        System.out.println(holder + " holder");
        int aw = 0;
        String[] aww = new String[3];
//          JOptionPane.showMessageDialog(null, jj);
        JLabel[] lbl = {lb_p1, lb_p2, lb_p3, lb_p4, lb_p5, lb_p6, lb_p7, lb_p8, lb_p9};
        JLabel[] begs = {lb_b1, lb_b2, lb_b3, lb_b4, lb_b5, lb_b6, lb_b7, lb_b8, lb_b9};
        JLabel[] ends = {lb_e1, lb_e2, lb_e3, lb_e4, lb_e5, lb_e6, lb_e7, lb_e8, lb_e9};
        JLabel[] variance = {lb_v1, lb_v2, lb_v3, lb_v4, lb_v5, lb_v6, lb_v7, lb_v8, lb_v9};
        JTextField[] update = {tf_am1, tf_am2, tf_am3, tf_am4, tf_am5, tf_am6, tf_am7, tf_am8, tf_am9};
        JButton[] edit = {btn_edit1, btn_edit2, btn_edit3, btn_edit4, btn_edit5, btn_edit6, btn_edit7, btn_edit8, btn_edit9};
        JLabel[] new_variance = {lb_var1, lb_var2, lb_var3, lb_var4, lb_var5, lb_var6, lb_var7, lb_var8, lb_var9};
        for (JLabel b : lbl) {

            lbl[aw].setVisible(true);
            begs[aw].setVisible(true);
            ends[aw].setVisible(true);
            variance[aw].setVisible(true);
            update[aw].setVisible(true);
            new_variance[aw].setVisible(true);
            edit[aw].setVisible(true);
            lbl[aw].setText(name.get(jj).
                    toString());
            begs[aw].setText(beg.get(jj).
                    toString());
            ends[aw].setText(end.get(jj).
                    toString());
            double var = Double.parseDouble(begs[aw].getText()) - Double.
                    parseDouble(ends[aw].getText());
            variance[aw].setText("" + var);

            String time = "";
            int row = cb_time.getItemCount();
//            System.out.println(row);
            if (row == 0) {
                time = "";
            } else {
                time = cb_time.getSelectedItem().
                        toString();
            }


            aww = S4_select_inventory_if_exist.ret_inventory(name.get(jj).
                    toString(), dp_date.getDate(), time);
//            System.out.println(aww[0]);
            if (aww[0].equals("wala")) {
                update[aw].setText("0.0");
                new_variance[aw].setText("0.0");
                update[aw].setEnabled(true);
                edit[aw].setEnabled(false);

            } else {
                update[aw].setText(aww[0]);
                new_variance[aw].setText(aww[1]);
                begs[aw].setText(aww[2]);
                variance[aw].setText(aww[4]);
                ends[aw].setText(aww[3]);


                update[aw].setEnabled(false);
                edit[aw].setEnabled(true);
            }

            aw++;
            jj++;

            bt_stat.setText("" + (jj) + " / " + (rows));
//            jj = aw;
        }

    }
//     kk
    List<to_product_list> samp = new ArrayList();

    private void do_update() {





//        if (btn_edit1.isEnabled()) {
//            JOptionPane.showMessageDialog(null, "Record Existing");
//        } else {
//            return;
//        }


        int aw = 0;
        JLabel[] lbl = {lb_p1, lb_p2, lb_p3, lb_p4, lb_p5, lb_p6, lb_p7, lb_p8, lb_p9};
        JLabel[] begs = {lb_b1, lb_b2, lb_b3, lb_b4, lb_b5, lb_b6, lb_b7, lb_b8, lb_b9};
        JLabel[] ends = {lb_e1, lb_e2, lb_e3, lb_e4, lb_e5, lb_e6, lb_e7, lb_e8, lb_e9};
        JLabel[] variance = {lb_v1, lb_v2, lb_v3, lb_v4, lb_v5, lb_v6, lb_v7, lb_v8, lb_v9};
        JTextField[] update = {tf_am1, tf_am2, tf_am3, tf_am4, tf_am5, tf_am6, tf_am7, tf_am8, tf_am9};
        JLabel[] variance_1 = {lb_var1, lb_var2, lb_var3, lb_var4, lb_var5, lb_var6, lb_var7, lb_var8, lb_var9};



        SimpleDateFormat ss = new SimpleDateFormat("hh:mm:ss");
        String time = ss.format(new Date());


        String date = DateType.sf.format(dp_date.getDate());


        date = date + " " + time;

        for (JLabel b : lbl) {

            if (lbl[aw].getText().
                    equals("")) {
//                return;
            } else {
                String name1 = lbl[aw].getText();
                String beg1 = begs[aw].getText();
                String ends1 = ends[aw].getText();
                String var1 = variance[aw].getText();
                String new1 = update[aw].getText();

                String new_var = variance_1[aw].getText();


                double new_balances = 0;
                if (new1.isEmpty()) {
                    new_balances = 0;
                } else {
                    new_balances = Double.parseDouble(new1);
                }

//                Date date = DateUtil.asDateAsciiFormat(lb_date.getText());


                S1_select_products.do_update_inventory(date, name1, Double.
                        parseDouble(beg1), Double.parseDouble(ends1), Double.
                        parseDouble(var1), new_balances, Double.parseDouble(new_var));

//                JOptionPane.showMessageDialog(null, "Successfully Saved");

            }
            aw++;

        }



        datas = S1_select_products.ret_products();
        datas.clear();
        name.clear();
        beg.clear();
        end.clear();

        samp = S1_select_products.ret_products();

//        samp=datas;


//        System.out.println(rows);

        for (to_product_list t : samp) {
            name.add(t.name);
            beg.add(t.beg);
            end.add(t.end);
//            System.out.println(t.name + " -- " + t.beg);
        }


        aw = 0;
        jj -= 9;

        for (JLabel b : lbl) {
//            System.out.println(name.get(jj) + " -- " + beg.get(jj));
            lbl[aw].setVisible(true);
            begs[aw].setVisible(true);
            ends[aw].setVisible(true);
            variance[aw].setVisible(true);
            update[aw].setVisible(true);

            if (jj >= rows) {
                lbl[aw].setVisible(false);
                begs[aw].setVisible(false);
                ends[aw].setVisible(false);
                variance[aw].setVisible(false);
                update[aw].setVisible(false);
                break;
            }



            lbl[aw].setText(name.get(jj).
                    toString());
            System.out.println(lbl[aw].getText());
            begs[aw].setText(beg.get(jj).
                    toString());
            ends[aw].setText(end.get(jj).
                    toString());
//            System.out.println(name.get(jj)+ " -- "+beg.get(jj));

            double var = Double.parseDouble(begs[aw].getText()) - Double.
                    parseDouble(ends[aw].getText());
            variance[aw].setText("" + var);
            update[aw].setText("0.0");
            update[aw].setEnabled(true);
            aw++;
            jj++;
//            jj = aw;
        }
        set_time("");

    }
    to_product_list tt;

    private void update() {
        if (!tf_am1.isEnabled()) {
             Prompt.call("Records Existing");
//            JOptionPane.showMessageDialog(null, "Records Existing");
            return;
        }
        Window w = (Window) this;
        Dlg_confirm d = Dlg_confirm.create(w, true);
        d.setTitle("Logout?");
        d.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog cd, Dlg_confirm.Data data) {
                cd.ok();
                //    kk
                do_update();

            }

            @Override
            public void cancel(CloseDialog cd) {
                cd.ok();
            }
        });

        Application.locateOnParentCenter(w, d);

        d.setVisible(true);
    }

    private void diff1() {
        double pi = 0;
        if (tf_am1.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am1.getText());

        }

        lb_var1.setText("" + (Double.parseDouble(lb_e1.getText()) - pi));
    }

    private void diff2() {
        double pi = 0;
        if (tf_am2.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am2.getText());

        }

        lb_var2.setText("" + (Double.parseDouble(lb_e2.getText()) - pi));
    }

    private void diff3() {
        double pi = 0;
        if (tf_am3.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am3.getText());

        }

        lb_var3.setText("" + (Double.parseDouble(lb_e3.getText()) - pi));
    }

    private void diff4() {
        double pi = 0;
        if (tf_am4.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am4.getText());

        }

        lb_var4.setText("" + (Double.parseDouble(lb_e4.getText()) - pi));
    }

    private void diff5() {
        double pi = 0;
        if (tf_am5.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am5.getText());

        }

        lb_var5.setText("" + (Double.parseDouble(lb_e5.getText()) - pi));
    }

    private void diff6() {
        double pi = 0;
        if (tf_am6.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am6.getText());

        }

        lb_var6.setText("" + (Double.parseDouble(lb_e6.getText()) - pi));
    }

    private void diff7() {
        double pi = 0;
        if (tf_am7.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am7.getText());

        }

        lb_var7.setText("" + (Double.parseDouble(lb_e7.getText()) - pi));
    }

    private void diff8() {
        double pi = 0;
        if (tf_am8.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am8.getText());

        }

        lb_var8.setText("" + (Double.parseDouble(lb_e8.getText()) - pi));
    }

    private void diff9() {
        double pi = 0;
        if (tf_am9.getText().
                isEmpty()) {
            pi = 0;
        } else {

            pi = Double.parseDouble(tf_am9.getText());

        }

        lb_var9.setText("" + (Double.parseDouble(lb_e9.getText()) - pi));
    }

    private void do_edit(JLabel name, JLabel beg, JLabel sold, JLabel end, final JLabel variance, final JTextField p_count) {

        final String names = name.getText();
        double begs = Double.parseDouble(beg.getText());
        double solds = Double.parseDouble(sold.getText());
        double ends = Double.parseDouble(end.getText());
        double variances = Double.parseDouble(variance.getText());
        double counts = Double.parseDouble(p_count.getText());

        Window p = (Window) this;
        dlg_edit_inventory nd = dlg_edit_inventory.create(p, true);
        nd.setTitle("Prompt");
        nd.pass(new dlg_edit_inventory.InputData(names, counts, begs, solds, ends, variances));
        nd.setCallback(new dlg_edit_inventory.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, dlg_edit_inventory.OutputData data) {
                closeDialog.ok();
                p_count.setText("" + data.count);
                variance.setText("" + data.variance);
//                JOptionPane.showMessageDialog(null, data.count + " "+data.variance);
                update_inve(names, p_count.getText(), variance.getText());
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_inve(String name, String count, String variance) {
        S5_update_inventory.do_update_grade(name, count, variance, dp_date.
                getDate(), cb_time.getSelectedItem().
                toString());
    }

    private void print() {

        Date d = new Date();
//            d = DateType.sf.parse(S5_ret_system_date.do_ret_system_date());

        rpt_report.do_report_inventory(dp_date.getDate());
    }
}
