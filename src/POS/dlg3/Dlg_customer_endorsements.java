/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg3;

import POS.dlg.Dlg_quantity1;
import POS.dlg2.Dlg_confirm;
import POS.dlg2.dlg_keyboard;
import POS.svc4.S2_customers;
import POS.to.to_users;
import POS.to2.to_credit;
import POS.utl.Center;
import POS.utl.DateType;
import POS.utl.NumType;
import POS.utl.Prompt;
import POS.utl.TableUtility;
import POS_dlg4.Dlg_sales;
import POS_dlg4.Dlg_sales.OutputData2;
import POS_dlg4.Dlg_sales_qty;
import POS_svc3.S6_customer_charges;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.*;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Dummy
 */
public class Dlg_customer_endorsements extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_customer_charges
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
        public final String address;
        public final String con;
        public final to_credit to;
        public final String payment_mode;
        public final String member_id;

        public OutputData(String name, String address, String con, to_credit to, String payment_mode, String member_id) {
            this.name = name;
            this.address = address;
            this.con = con;
            this.to = to;
            this.payment_mode = payment_mode;
            this.member_id = member_id;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_customer_endorsements(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_customer_endorsements(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_customer_endorsements() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_customer_endorsements myRef;

    private void setThisRef(Dlg_customer_endorsements myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customer_endorsements> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customer_endorsements create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_customer_endorsements create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customer_endorsements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_endorsements((java.awt.Frame) parent, false);
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
            Dlg_customer_endorsements dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_endorsements((java.awt.Dialog) parent, false);
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


        Dlg_customer_endorsements dialog = Dlg_customer_endorsements.create(new javax.swing.JFrame(), true);
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

        pm_table = new javax.swing.JPopupMenu();
        pay = new javax.swing.JMenuItem();
        pm_cust = new javax.swing.JPopupMenu();
        Edit = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Delete = new javax.swing.JMenuItem();
        pop_balance = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sp_cust = new javax.swing.JScrollPane();
        tbl_cust = new javax.swing.JTable();
        tf_search = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_total = new javax.swing.JLabel();
        sp_charges = new javax.swing.JScrollPane();
        tbl_charges = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_ok1 = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        pay.setText("PAY");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        pm_table.add(pay);

        Edit.setText("EDIT");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });
        pm_cust.add(Edit);
        pm_cust.add(jSeparator1);

        Delete.setText("DELETE");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        pm_cust.add(Delete);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(159, 207, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SEARCH:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 30));

        tbl_cust.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CUSTOMER NAME", "num"
            }
        ));
        tbl_cust.setFocusable(false);
        tbl_cust.setRowHeight(30);
        tbl_cust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_custMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_custMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_custMouseReleased(evt);
            }
        });
        sp_cust.setViewportView(tbl_cust);

        jPanel2.add(sp_cust, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 480, 500));

        tf_search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_searchMouseClicked(evt);
            }
        });
        tf_search.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tf_searchMouseDragged(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });
        jPanel2.add(tf_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 380, 35));

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add 16x16.png"))); // NOI18N
        btn_add.setFocusable(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 60, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("TOTAL CHARGES:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, 35));

        tf_total.setBackground(new java.awt.Color(0, 0, 0));
        tf_total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_total.setForeground(java.awt.Color.green);
        tf_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_total.setText(".00");
        tf_total.setOpaque(true);
        jPanel2.add(tf_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 380, 30));

        tbl_charges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "OR NUMBER", "AMOUNT"
            }
        ));
        tbl_charges.setFocusable(false);
        tbl_charges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_chargesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_chargesMouseReleased(evt);
            }
        });
        sp_charges.setViewportView(tbl_charges);

        jPanel2.add(sp_charges, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 600, 510));

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(41, 9, 149));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("CLOSE");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 610, 70, 20));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(41, 9, 149));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("OK");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 540, 60, -1));

        btn_ok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        btn_ok1.setBorderPainted(false);
        btn_ok1.setContentAreaFilled(false);
        btn_ok1.setFocusable(false);
        btn_ok1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ok1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, 70, 50));

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setFocusable(false);
        btn_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel2.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 560, 60, 50));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("MEMBERS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1396, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 1400, 60));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup-MO.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup-MO.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 80, 60));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/rrowdown.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowdown-MO.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowdown-MO.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, 70, 60));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add 16x16.png"))); // NOI18N
        jButton5.setText("ADD");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 120, 120, 45));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/edit-pencil.png"))); // NOI18N
        jButton6.setText("EDIT");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 170, 120, 40));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close32x32.png"))); // NOI18N
        jButton7.setText("DELETE");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 220, 120, 40));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup-MO.png"))); // NOI18N
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup-MO.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 310, 80, 60));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/rrowdown.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusable(false);
        jButton9.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowdown-MO.png"))); // NOI18N
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowdown-MO.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 430, 70, 60));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/edit-pencil.png"))); // NOI18N
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 60, 40));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close32x32.png"))); // NOI18N
        jButton11.setFocusable(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 60, 40));

        jButton3.setText("PAY");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 270, 120, 40));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ADD");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 60, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DOWN");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 410, 60, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DELETE");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 60, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("EDIT");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 60, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("UP");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 60, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("DOWN");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 50, -1));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("UP");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 370, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_employee();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        add_customer();
    }//GEN-LAST:event_btn_addActionPerformed

    private void tbl_custMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_custMouseClicked
        // TODO add your handling code here:
        data_charges();
//        data_charges(evt);
    }//GEN-LAST:event_tbl_custMouseClicked

    private void tbl_chargesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chargesMousePressed
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_chargesMousePressed

    private void tbl_chargesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chargesMouseReleased
        // TODO add your handling code here:
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_chargesMouseReleased

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
        do_pay();
    }//GEN-LAST:event_payActionPerformed

    private void tbl_custMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_custMousePressed
        // TODO add your handling code here:
        pm_tbl_customers(evt);
    }//GEN-LAST:event_tbl_custMousePressed

    private void tbl_custMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_custMouseReleased
        // TODO add your handling code here:
        pm_tbl_customers(evt);
    }//GEN-LAST:event_tbl_custMouseReleased

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:

        edit_customer();
    }//GEN-LAST:event_EditActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        delete_cust();
    }//GEN-LAST:event_DeleteActionPerformed

    private void btn_ok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ok1ActionPerformed
//        do_ok();
        ok1();
    }//GEN-LAST:event_btn_ok1ActionPerformed

    private void tf_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseClicked
        // TODO add your handling code here:
        keyboard(tf_search);
    }//GEN-LAST:event_tf_searchMouseClicked

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
//    clear_field();
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void tf_searchMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_searchMouseDragged
        // TODO add your handling code here:
        keyboard(tf_search);
    }//GEN-LAST:event_tf_searchMouseDragged

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        edit_customer();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        delete_cust();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        add_charges();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        do_edit();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        do_delete();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        do_pay();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        do_down();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        do_up();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        do_down2();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        do_up2();
    }//GEN-LAST:event_jButton8ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenuItem Edit;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_ok1;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem pay;
    private javax.swing.JPopupMenu pm_cust;
    private javax.swing.JPopupMenu pm_table;
    private javax.swing.JPopupMenu pop_balance;
    private javax.swing.JScrollPane sp_charges;
    private javax.swing.JScrollPane sp_cust;
    private javax.swing.JTable tbl_charges;
    private javax.swing.JTable tbl_cust;
    private javax.swing.JTextField tf_search;
    private javax.swing.JLabel tf_total;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//           if (System.getProperty("os.name").equalsIgnoreCase("linux")) {
//           
//            this.setUndecorated(true);
//        } else {
////             JOptionPane.showMessageDialog(null, System.getProperty("os.name"));
//            this.setUndecorated(false);
//        }
        init_long_press();
        init_key();
        init_tbl_baptism();
        data_employee();
//        init_auto_scroll();
        init_tbl_charges();
        hiden(false);
    }

    public void do_set(String cust_id) {
        tf_search.setText(cust_id);
        data_employee();
        
//        tbl_cust.setRowSelectionInterval(0, 1);
        init_tbl_charges();
    }

    private void init_auto_scroll() {
//        tbl_cust.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        ComponentDragScrollListener l = new ComponentDragScrollListener(tbl_cust);
//        tbl_cust.addMouseMotionListener(l);
//        tbl_cust.addMouseListener(l);
//        tbl_cust.addHierarchyListener(l);
    }

    private void do_down() {
//            tbl_endorsements.scrollRectToVisible(tbl_endorsements.getCellRect(j, 0, false));
        sp_cust.transferFocusDownCycle();
        sp_cust.getVerticalScrollBar().setValue(sp_cust.getVerticalScrollBar().getValue() + sp_cust.getVerticalScrollBar().getBlockIncrement() + 20);
//      
    }

    private void do_up() {
        sp_cust.transferFocusUpCycle();
        sp_cust.getVerticalScrollBar().setValue(sp_cust.getVerticalScrollBar().getValue() - sp_cust.getVerticalScrollBar().getBlockIncrement() - 20);
    }

    private void do_down2() {
//            tbl_endorsements.scrollRectToVisible(tbl_endorsements.getCellRect(j, 0, false));
        sp_charges.transferFocusDownCycle();
        sp_charges.getVerticalScrollBar().setValue(sp_charges.getVerticalScrollBar().getValue() + sp_charges.getVerticalScrollBar().getBlockIncrement() + 20);
//      
    }

    private void do_up2() {
        sp_charges.transferFocusUpCycle();
        sp_charges.getVerticalScrollBar().setValue(sp_charges.getVerticalScrollBar().getValue() - sp_charges.getVerticalScrollBar().getBlockIncrement() - 20);
    }
    double credit_amount = 0;

    public void do_pass(double amount) {

        credit_amount = amount;

//        JOptionPane.showMessageDialog(null, to_users.user_level1);
        if (to_users.user_level1.equals("3")) {
            btn_add.setVisible(true);

            hiden(false);

        } else {
            btn_add.setVisible(false);

            hiden(true);
        }



    }
    String cashier_id = "";
    int t = 0;

    public void do_pass2(String cashier_d) {
        cashier_id = cashier_d;
        t = 1;
        data_employee();
    }

    private void hiden(boolean aw) {
        btn_ok1.setVisible(aw);
        jLabel13.setVisible(aw);

//        jLabel14.setVisible(aw);

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
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);

        tbl_cust.getTableHeader().setPreferredSize(new Dimension(100, 20));

        tbl_cust.setModel(tbl_employee_payroll_M);
        tbl_cust.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cust.setRowHeight(25);

        tbl_cust.getTableHeader().setPreferredSize(new Dimension(100, 40));
//        tbl_cust.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {450, 0, 100, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cust, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        TableUtility.align_row_to_Center(tbl_cust, 1);
        TableUtility.align_row_to_Center(tbl_cust, 2);
        TableUtility.align_row_to_Center(tbl_cust, 3);

        tbl_cust.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_cust.setRowHeight(50);
        tbl_cust.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_baptism(List<S2_customers.to_customers> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "NAME", "num", "BALANCE", "CREDIT LIMIT"
        };

        public TblInvoicesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S2_customers.to_customers tt = (S2_customers.to_customers) getRow(row);

            switch (col) {
                case 0:
                    return tt.name;
                case 1:
                    return tt.num;
                case 2:
                    return tt.balance;
                default:
                    return tt.credit_limit;
            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();

        if (t == 1) {

            String name = tf_search.getText();
//            JOptionPane.showMessageDialog(null, "adadad");
            loadData_baptism(S2_customers.ret_customers_by_cashier(name, cashier_id));
        } else {

            String name = tf_search.getText();
            if (name.isEmpty()) {
                return;
            }
            loadData_baptism(S2_customers.ret_customers(name,""));
        }



    }

    private void add_customer() {


        Window p = (Window) this;
        Dlg_customers nd = Dlg_customers.create(p, true);
        nd.setTitle("");
//        nd.do_pass2();
        nd.setCallback(new Dlg_customers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                closeDialog.ok();
                add_cust(data.name, data.add, data.contact, data.occupation, data.income, data.bday, data.civil_status, data.gender, data.credit_limit);
            }

            @Override
            public void balance(CloseDialog closeDialog, Dlg_customers.OutputData data) {
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_cust(String name, String add, String contact, String occupation, String income, String bday, String civil_status, String gender, double credit_limit) {
        S2_customers.add(name, add, contact, occupation, income, bday, civil_status, gender, credit_limit);
        data_employee();
    }
    private ArrayListModel tbl_charges_ALM;
    private TblchargesModel tbl_charges_M;
////    

    private void init_tbl_charges() {
        tbl_charges_ALM = new ArrayListModel();
        tbl_charges_M = new TblchargesModel(tbl_charges_ALM);


        tbl_charges.setModel(tbl_charges_M);
        tbl_charges.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_charges.setRowHeight(25);

        tbl_charges.getTableHeader().setPreferredSize(new Dimension(100, 40));


//        tbl_charges.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 0, 0, 0, 200, 100, 100, 100, 0, 0, 0, 100};
        for (int i = 0, n = tbl_widths_accounts.length;
                i < n;
                i++) {
            if (i == 4) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_charges, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        tbl_charges.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
//         tbl_charges.getTableHeader().setColumnModel(new TableColumnModelExt() {});

        tbl_charges.setRowHeight(50);
        tbl_charges.setFont(new java.awt.Font("Arial", 1, 12));


    }

    private void loadData_charges(List<S6_customer_charges.to_customer_charges> acc) {
        tbl_charges_ALM.clear();
        tbl_charges_ALM.addAll(acc);


    }

    public static class TblchargesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "cashier_id", "customer_id", "BARCODE", " PRODUCT NAME", "QTY", "PRICE", "DATE ADDED", "is_payed", "date_payed", "user_id", "AMOUNT"
        };

        public TblchargesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S6_customer_charges.to_customer_charges tt = (S6_customer_charges.to_customer_charges) getRow(row);
//              "id", "cashier_id", "customer_id", "BARCODE"," PRODUCT NAME", "QTY", "PRICE", "DATE ADDED", "is_payed", "date_payed", "user_id","Amount"
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.cashier_id;
                case 2:
                    return tt.customer_id;
                case 3:
                    return tt.product_id;
                case 4:
                    return tt.product_name;

                case 5:
                    return tt.qty;

                case 6:
                    return tt.price;

                case 7:
                    return tt.date_added;

                case 8:
                    return tt.is_payed;

                case 9:
                    return tt.date_payed;
                case 10:
                    return tt.user_id;


                default:
                    return (tt.amount);
            }
        }
    }

    private void init_long_press() {
//        tbl_cust.addMouseListener(new MouseAdapter() {
//
//            Date pressedtime;
//            long timeClicked;
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                pressedtime = new Date();
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                timeClicked = (new Date()).getTime() - pressedtime.getTime();
////                JOptionPane.showMessageDialog(null, timeClicked);
//                if (timeClicked >= 500) {
////                     JOptionPane.showMessageDialog(null, timeClicked);
//                     ok1();
//                }
//            }
//            
//        });
    }

    private void data_charges(MouseEvent evt) {
//        String date = lb_date_baptism.getText();
//        if (evt.getClickCount() >= 2) {
//            ok1();
//            return;
//        }
//        int row = tbl_cust.getSelectedRow();
//        if (row < 0) {
//            return;
//        }
//        String num = tbl_cust.getModel().getValueAt(row, 1).toString();
////        JOptionPane.showMessageDialog(null, num);
//        loadData_charges(S6_customer_charges.get_charges(num));
//        compute_charges();
    }

    private void data_charges() {
//        String date = lb_date_baptism.getText();
        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        String num = tbl_cust.getModel().getValueAt(row, 1).toString();
//        JOptionPane.showMessageDialog(null, num);
        loadData_charges(S6_customer_charges.get_charges(num));
        compute_charges();
    }

    private void ok1() {

        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String num = tbl_cust.getModel().getValueAt(row, 1).toString();
        final double balance = Double.parseDouble(tbl_cust.getModel().getValueAt(row, 2).toString());
        String[] details = new String[3];
        details = S2_customers.get_details(num);

        final String name = details[0];
        final String add = details[1];
        final String contact = details[2];
//           final String name=details[0];
        Window p = (Window) this;

        Dlg_credit_card nd = Dlg_credit_card.create(p, true);
        nd.setTitle("");
        nd.do_pass(details[0], details[1], details[2], credit_amount, balance);
        nd.setCallback(new Dlg_credit_card.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_credit_card.OutputData data) {
                closeDialog.ok();

                ok2(name, add, contact, credit_amount, data.to, data.pay_mode, num);
                disposed();
            }

            @Override
            public void credit(CloseDialog closeDialog, Dlg_credit_card.OutputData data) {
                ok2(name, add, contact, credit_amount, data.to, data.pay_mode, num);
                disposed();
            }

            @Override
            public void prepaid(CloseDialog closeDialog, Dlg_credit_card.OutputData data) {
                ok2(name, add, contact, credit_amount, data.to, data.pay_mode, num);
                disposed();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);

    }

    private void ok2(String name, String add, String contact, double amount, to_credit to, String payment_mode, String member_id) {
        this.disposed();
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(name, add, contact, to, payment_mode, member_id));
        }
//        if (callback != null) {
//            callback.ok(new CloseDialog(this), new OutputData());
//        }
    }

    private void compute_charges() {
//        
        double total = 0;
        if (tbl_charges_ALM.isEmpty()) {
            total = 0;
        } else {
            List<S6_customer_charges.to_customer_charges> datas = tbl_charges_ALM;
            for (S6_customer_charges.to_customer_charges to : datas) {
                total += to.amount;
            }
        }
        tf_total.setText("" + NumType.with_comma(Double.parseDouble("" + total)));
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_table.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void do_pay() {


        int[] idx = tbl_charges.getSelectedRows();
//        JOptionPane.showMessageDialog(null, idx);
        if (idx.length <= 0) {
            return;
        }

        final List<String> rem = new ArrayList();
        double charges = 0;
        for (int ix : idx) {
            charges += Double.parseDouble(NumType.no_comma(tbl_charges.getModel().getValueAt(ix, 11).toString()));
            rem.add(tbl_charges.getModel().getValueAt(ix, 0).toString());
//            System.out.println(tbl_charges.getModel().getValueAt(ix, 1).toString());
        }
        final double ch = charges;

        int row1 = tbl_cust.getSelectedRow();
        if (row1 < 0) {
            return;
        }
        final String cust_id = tbl_cust.getModel().getValueAt(row1, 1).toString();


        int row = tbl_charges.getSelectedRow();
        if (row < 0) {
            return;
        }
        String num = tbl_charges.getModel().getValueAt(row, 1).toString();

        Window p = (Window) this;
        Dlg_quantity1 nd = Dlg_quantity1.create(p, true);
        nd.setTitle("");
        nd.do_pass(charges);
        nd.setCallback(new Dlg_quantity1.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_quantity1.OutputData data) {
                closeDialog.ok();
                pay(rem, cust_id, ch);
                data_charges();
                data_employee();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void pay(List<String> ci, String cust_id, double amount) {

        for (String aw : ci) {
//            String num = tbl_charges.getModel().getValueAt(row, 1).toString();
            S2_customers.pay2(aw);

        }
        double bal = S2_customers.get_balance(cust_id);
        if (bal <= 0) {
        } else {
            S2_customers.do_update_balance(cust_id, amount);
        }

        JOptionPane.showMessageDialog(null, "Payed");
//        int row = tbl_charges.getSelectedRow();
//        if (row < 0) {
//            return;
//        }

    }

    private void pm_tbl_customers(MouseEvent evt) {

//        if (to_users.user_level1 == null) {
//            return;
//        }
////        JOptionPane.showMessageDialog(null, to_users.user_level1 + " "+ to_users.username1);
//        if (to_users.user_level1.equals("0")) {
//            return;
//        }
        if (evt.isPopupTrigger()) {
            pm_cust.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void edit_customer() {

        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String num = tbl_cust.getModel().getValueAt(row, 1).toString();
        S2_customers.customers to = S2_customers.get_cust_details(num);
//         JOptionPane.showMessageDialog(null, to.b_date);
        Window p = (Window) this;
        Dlg_customers nd = Dlg_customers.create(p, true);
        nd.setTitle("");
        nd.do_pass(to.member_name, to.address, to.contact, to.occupation, to.income, to.b_date, to.civil_status, to.is_male, to.balance, num, to.credit_limit);
        nd.setCallback(new Dlg_customers.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                closeDialog.ok();
                do_edit_customer(data.name, data.add, data.contact, data.occupation, data.income, data.bday, data.civil_status, data.gender, num, data.balance, data.credit_limit);
            }

            @Override
            public void balance(CloseDialog closeDialog, Dlg_customers.OutputData data) {
                data_employee();
                int row = tbl_cust.getSelectedRow();
                if (row < 0) {
                    return;
                }
                String num = tbl_cust.getModel().getValueAt(row, 1).toString();
//        JOptionPane.showMessageDialog(null, num);
                loadData_charges(S6_customer_charges.get_charges(num));
                compute_charges();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_edit_customer(String member_name, String address, String contact, String occupation, String income, String b_date, String civil_status, String is_male, String num, double balance, double credit_limit) {

        S2_customers.edit_customer(member_name, address, contact, occupation, income, b_date, civil_status, is_male, num, balance, credit_limit);
        data_employee();
    }

    private void delete_cust() {
        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String num = tbl_cust.getModel().getValueAt(row, 1).toString();
        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                delete(num);
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void delete(String num) {
        S2_customers.delete(num);
        data_employee();
    }

    private void keyboard(final JTextField tf) {
        Window p = (Window) this;
        dlg_keyboard nd = dlg_keyboard.create(p, true);
        nd.setTitle("");
        nd.do_pass(tf.getText());
        nd.setCallback(new dlg_keyboard.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, dlg_keyboard.OutputData data) {
//                closeDialog.ok();
                tf.setText(data.name);
                data_employee();
            }
        });
        Center.setRight(nd);


        nd.setVisible(true);
    }

    private void add_charges() {



        int row = tbl_cust.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String cust_num = tbl_cust.getModel().getValueAt(row, 1).toString();
        double credit_limit = Double.parseDouble(tbl_cust.getModel().getValueAt(row, 1).toString());

        double credit = Double.parseDouble(FitIn.fmt_woc(tf_total.getText()));

        if (credit >= credit_limit) {
            Prompt.call("Cannot Proceed, Credit Limit Reached");
        }
        Window p = (Window) this;
        Dlg_sales nd = Dlg_sales.create(p, true);
        nd.setTitle("");
        nd.do_pass("3");
        nd.setCallback(new Dlg_sales.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_sales.OutputData data) {
                closeDialog.ok();

            }

            @Override
            public void charges(CloseDialog closeDialog, OutputData2 data) {
                closeDialog.ok();
                do_add(data.barcode, data.product_name, data.price, data.qty, data.cashier_id, cust_num);
                data_charges();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_add(String barcode, String product_name, double price, double qty, String cashier_id, String cust_num) {
        String date=DateType.sf.format(new Date());
        S6_customer_charges.add_charge(barcode, product_name, price, qty, cashier_id, cust_num,date);
    }

    private void do_edit() {
        int row = tbl_charges.getSelectedRow();
        if (row < 0) {
            return;
        }
//         "id", "cashier_id", "customer_id", "BARCODE", " PRODUCT NAME", "QTY", "PRICE", "DATE ADDED", "is_payed", "date_payed", "user_id", "AMOUNT"

        final String id = tbl_charges.getModel().getValueAt(row, 0).toString();
        final String cashier_id = tbl_charges.getModel().getValueAt(row, 1).toString();
        final String customer_id = tbl_charges.getModel().getValueAt(row, 2).toString();
        final String barcode = tbl_charges.getModel().getValueAt(row, 3).toString();
        final String prod_name = tbl_charges.getModel().getValueAt(row, 4).toString();
        final double qty = Double.parseDouble(tbl_charges.getModel().getValueAt(row, 5).toString());
        final double price = Double.parseDouble(tbl_charges.getModel().getValueAt(row, 6).toString());
        final String date_added = tbl_charges.getModel().getValueAt(row, 7).toString();
        final String is_payed = tbl_charges.getModel().getValueAt(row, 8).toString();

        Window p = (Window) this;
        Dlg_sales_qty nd = Dlg_sales_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(qty, prod_name, "EDIT CREDIT");
        nd.setCallback(new Dlg_sales_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_sales_qty.OutputData data) {
                closeDialog.ok();
                update_charges(id, barcode, prod_name, qty, data.qty);
                data_charges();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_charges(String id, String barcode, String prod_name, double qty, double new_qty) {
        S6_customer_charges.edit_charges(id, barcode, prod_name, qty, new_qty);
    }

    private void do_delete() {
        int row = tbl_charges.getSelectedRow();
        if (row < 0) {
            return;
        }
//         "id", "cashier_id", "customer_id", "BARCODE", " PRODUCT NAME", "QTY", "PRICE", "DATE ADDED", "is_payed", "date_payed", "user_id", "AMOUNT"

        final String id = tbl_charges.getModel().getValueAt(row, 0).toString();
        final String cashier_id = tbl_charges.getModel().getValueAt(row, 1).toString();
        final String customer_id = tbl_charges.getModel().getValueAt(row, 2).toString();
        final String barcode = tbl_charges.getModel().getValueAt(row, 3).toString();
        final String prod_name = tbl_charges.getModel().getValueAt(row, 4).toString();
        final double qty = Double.parseDouble(tbl_charges.getModel().getValueAt(row, 5).toString());
        final double price = Double.parseDouble(tbl_charges.getModel().getValueAt(row, 6).toString());
        final String date_added = tbl_charges.getModel().getValueAt(row, 7).toString();
        final String is_payed = tbl_charges.getModel().getValueAt(row, 8).toString();

        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//        nd.do_pass(qty, prod_name, "EDIT CREDIT");
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                delete_charges(id, barcode, prod_name, qty, 0);
                data_charges();
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void delete_charges(String id, String barcode, String prod_name, double qty, double new_qty) {
        S6_customer_charges.delete_charges(id, barcode, prod_name, qty, new_qty);
    }
}
