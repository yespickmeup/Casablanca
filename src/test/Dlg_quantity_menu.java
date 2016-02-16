/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import POS.Main;
import POS.discount.S1_add_customer_discount;
import POS.discount.S1_add_customer_discount.to_customer_discounts;
import POS.inventory.S2_assembly;
import POS.svc.S9_confirm_user;
import POS.svc2.S14_chech_if_admin;
import POS.utl.Prompt;
import POS_svc3.S2_get_discounts;
import POS_svc4.S2_search;
import POS_svc4.S2_search.to_items_status;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.*;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_quantity_menu extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_quantity
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void order(CloseDialog closeDialog, OutputData data);

        void cancel(CloseDialog closeDialog, OutputData data);

        void remove(CloseDialog closeDialog);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final S2_search.to_items to_items;
        public final List<S2_search.to_items_status> to_sub;
        public final double to_pay;

        public OutputData(S2_search.to_items to_items, List<to_items_status> to_sub, double to_pay) {
            this.to_items = to_items;
            this.to_sub = to_sub;
            this.to_pay = to_pay;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_quantity_menu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_quantity_menu(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_quantity_menu() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_quantity_menu myRef;

    private void setThisRef(Dlg_quantity_menu myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_quantity_menu> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_quantity_menu create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_quantity_menu create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_quantity_menu dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_quantity_menu((java.awt.Frame) parent, false);
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
            Dlg_quantity_menu dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_quantity_menu((java.awt.Dialog) parent, false);
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


        Dlg_quantity_menu dialog = Dlg_quantity_menu.create(new javax.swing.JFrame(), true);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tf_qty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbl_price = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_price1 = new javax.swing.JLabel();
        tp_list = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        cx_all = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_type = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lb_rate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_cust_no = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_address = new javax.swing.JTextArea();
        cb_cust_name = new javax.swing.JComboBox();
        pnl_login = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tf_user_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setText("OK");
        jButton15.setFocusable(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 80, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("1");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 80, 60));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("2");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 80, 60));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("4");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 80, 60));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("5");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 80, 60));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("6");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 80, 60));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("7");
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 80, 60));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("8");
        jButton9.setFocusable(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 80, 60));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("9");
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 80, 60));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setText("0");
        jButton11.setFocusable(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 80, 60));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setText(".");
        jButton12.setFocusable(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 80, 60));

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setText("CL");
        jButton13.setFocusable(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 80, 60));

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setText("3");
        jButton14.setFocusable(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 80, 60));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("X");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 80, 40));

        tf_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
            }
        });
        tf_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_qtyKeyReleased(evt);
            }
        });
        jPanel1.add(tf_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("REM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 80, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        lbl_price.setBackground(new java.awt.Color(255, 255, 255));
        lbl_price.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_price.setText("1,000.00");
        lbl_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_price.setOpaque(true);
        jPanel2.add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 30));

        lbl_name.setBackground(new java.awt.Color(255, 255, 255));
        lbl_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_name.setText("1 pc Chicken with Rice and Egg");
        lbl_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_name.setOpaque(true);
        jPanel2.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 470, 30));

        lbl_price1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_price1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_price1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_price1.setText("P");
        lbl_price1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_price1.setOpaque(true);
        jPanel2.add(lbl_price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        tp_list.setFocusable(false);
        tp_list.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cx_all.setSelected(true);
        cx_all.setFocusable(false);
        cx_all.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cx_all.setOpaque(false);
        cx_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cx_allMouseClicked(evt);
            }
        });
        jPanel3.add(cx_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 30, 30));

        jScrollPane2.setFocusable(false);

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_items.setFocusable(false);
        tbl_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_items);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 290));

        tp_list.addTab("SUB - LIST", jPanel3);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("TYPE:");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 50, 40));

        cb_type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_typeActionPerformed(evt);
            }
        });
        jPanel5.add(cb_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 200, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RATE:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 50, 40));

        lb_rate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb_rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_rate.setText("12");
        lb_rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_rate.setOpaque(true);
        jPanel5.add(lb_rate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 60, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("NAME:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 50, 30));

        tf_cust_no.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_cust_no.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_cust_noMouseClicked(evt);
            }
        });
        jPanel5.add(tf_cust_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 310, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ID. #:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 50, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ADDRESS:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 70, 30));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        tf_address.setColumns(20);
        tf_address.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_address.setRows(5);
        jScrollPane1.setViewportView(tf_address);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 310, 70));

        cb_cust_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_cust_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cust_nameActionPerformed(evt);
            }
        });
        jPanel5.add(cb_cust_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 310, 30));

        tp_list.addTab("DISCOUNTS", jPanel5);

        pnl_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("PASSWORD:");
        pnl_login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 90, 30));

        tf_user_name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_user_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_user_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_user_nameMouseClicked(evt);
            }
        });
        pnl_login.add(tf_user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 230, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("USER NAME:");
        pnl_login.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 80, 30));

        tf_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnl_login.add(tf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 230, 30));

        tp_list.addTab("LOG - IN", pnl_login);

        jPanel2.add(tp_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 390, 320));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        set_qty("1");
        compute();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        set_qty("2");
        compute();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        set_qty("3");
        compute();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        set_qty("4");
        compute();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        set_qty("5");
        compute();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        set_qty("6");
        compute();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        set_qty("7");
        compute();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        set_qty("8");
        compute();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        set_qty("9");
        compute();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        set_qty("0");
        compute();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        set_qty(".");
        compute();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        clear();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cx_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cx_allMouseClicked
        check_all();
    }//GEN-LAST:event_cx_allMouseClicked

    private void tbl_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_itemsMouseClicked
        set_check();
    }//GEN-LAST:event_tbl_itemsMouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void tf_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_qtyKeyReleased
        compute();
    }//GEN-LAST:event_tf_qtyKeyReleased

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        ok1();

    }//GEN-LAST:event_tf_qtyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cancel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_typeActionPerformed
        // TODO add your handling code here:
        get_rate();
    }//GEN-LAST:event_cb_typeActionPerformed

    private void tf_cust_noMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_cust_noMouseClicked
        // TODO add your handling code here:
//        keyboard(tf_cust_no);
    }//GEN-LAST:event_tf_cust_noMouseClicked

    private void tf_user_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_user_nameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_user_nameMouseClicked

    private void cb_cust_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cust_nameActionPerformed
        choose();
    }//GEN-LAST:event_cb_cust_nameActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_cust_name;
    private javax.swing.JComboBox cb_type;
    private javax.swing.JCheckBox cx_all;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_rate;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_price1;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTextArea tf_address;
    private javax.swing.JTextField tf_cust_no;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_user_name;
    private javax.swing.JTabbedPane tp_list;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_casablanca");
//        tp_list.remove(2);
//        do_pass3();
//        pnl_login.setVisible(false);
        init_key();
        init_tbl_items();
        data_items();
        init_cb();
        cx_all.setVisible(false);


//        assemble = "1";
//        assemble = S2_assembly.get_assembly_no(ref);
//        if (assemble.equals("1")) {
//            cx_all.setVisible(true);
//        } else {
//            cx_all.setVisible(false);
//        }
    }
    int my_oder = 0;

    public void do_pass3() {
        my_oder = 3;
        init_cb();
        tp_list.setSelectedIndex(2);
    }
    int sel = 0;

    public void do_pass4() {
//        my_oder = 3;
//        init_cb();
        tp_list.remove(2);
        tf_qty.setText("1");
        tf_qty.selectAll();
        sel = 1;
        compute();
    }

    private void init_cb() {
        cb_type.setModel(new ListComboBoxModel(S2_get_discounts.get_discounts_for_cb()));
        get_rate();
        List<String> cust1 = new ArrayList();
        datas_cus = S1_add_customer_discount.ret_data("");
        for (S1_add_customer_discount.to_customer_discounts to : datas_cus) {
            cust1.add(to.customer_name);
        }

        cb_cust_name.setEditable(true);
        AutoCompleteDecorator.decorate(cb_cust_name);
        cb_cust_name.setModel(new ListComboBoxModel(cust1));

    }

    private void get_rate() {
        int row = cb_type.getItemCount();
        if (row <= 0) {
            return;
        }
        System.out.println(cb_type.getSelectedItem().
                toString());
        String rate = S2_get_discounts.get_discounts_rate(cb_type.getSelectedItem().
                toString());
        lb_rate.setText(rate);
//         System.out.println(rate);
    }

    private void choose() {
        if (!datas_cus.isEmpty()) {
            int sel = cb_cust_name.getSelectedIndex();
//                    JOptionPane.showMessageDialog(null, sel);
            if (sel == -1) {
            } else {
//                System.out.println(datas_cus.size() + " = " + sel);
                final S1_add_customer_discount.to_customer_discounts to = (S1_add_customer_discount.to_customer_discounts) datas_cus.get(sel);
                tf_cust_no.setText(to.card_no);
                tf_address.setText(to.address);
            }
        }
    }
    List<S1_add_customer_discount.to_customer_discounts> datas_cus = new ArrayList();
    double my_price = 0;
    double my_qty = 0;
    String my_id = "";
    String my_img_path = "";
    String my_uom = "";
    int stat = 0;
    String ref = "263";
    String assemble = "0";
    String guest_id = "-1";
    String cat_id = "-1";
    String category_name = "";
    int print_assme = 0;
    int status = 0;
    int group_id = 0;

    public void do_pass(S2_search.to_items to_items, List<S2_search.to_items_status> to_sub, int state, String guest, String cat, int group_ids) {
        status = to_items.status;
        print_assme = to_items.printing_assembly;
        my_price = to_items.price;
        my_qty = to_items.qty;
        stat = state;
        my_id = to_items.name;
        my_img_path = to_items.img_path;
        my_uom = to_items.uom;
        ref = to_items.name;
        guest_id = guest;
        cat_id = cat;
        lbl_name.setText(to_items.desc);
        category_name = to_items.category_name;
        assemble = S2_assembly.get_assembly_no(ref);
        group_id = group_ids;
        if (assemble.equals("1")) {
            cx_all.setVisible(true);
        } else {
            cx_all.setVisible(false);
        }
//        loadData_items(to_sub);
        data_items();
        tf_qty.setText("");
        tf_qty.selectAll();
        compute();
    }

    public void do_pass_order(S2_search.to_orders to) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_M.fireTableDataChanged();
        my_price = to.price;
        my_qty = to.qty;
        stat = 2;
        my_id = to.name;
        my_img_path = to.img_path;
        my_uom = to.uom;
        ref = to.name;

        lbl_name.setText(to.desc);
        assemble = S2_assembly.get_assembly_no(ref);
        if (assemble.equals("1")) {
            cx_all.setVisible(true);
        } else {
            cx_all.setVisible(false);
        }
        cx_all.setSelected(false);
        cb_type.setSelectedItem(to.disc_name);
        cb_cust_name.setSelectedItem(to.customer_name);
        lb_rate.setText("" + to.disc_rate);
        tf_cust_no.setText(to.customer_id);
        tf_address.setText(to.customer_address);


        loadData_items(to.to_sub);
//        data_items();
        tf_qty.setText("" + to.qty);
//        tf_qty.selectAll();
        compute();
    }
    int set = 0;

    public void do_set_up(int setter) {
        set = setter;
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

    private void set_qty(String text) {
        String t = tf_qty.getText();
        if (sel == 1) {
            t = "";
        }
        sel = 0;
        tf_qty.setText(t + text);
    }

    private void clear() {
        tf_qty.setText("");
    }
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_items() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);
        tbl_items.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_items.setModel(tbl_employee_payroll_M);
        tbl_items.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_items.setRowHeight(25);

        tbl_items.setAutoResizeMode(1);
        int[] tbl_widths_accounts = {60, 0, 0, 100, 60, 0, 0, 60};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_items, i, tbl_widths_accounts[i]);

        }
        Dimension d = tbl_items.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_items.getTableHeader().
                setPreferredSize(d);
        tbl_items.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_items.setRowHeight(35);
        tbl_items.setFont(new java.awt.Font("Arial", 1, 12));
//        tbl_items.getColumnModel().getColumn(7).setHeaderRenderer(
//                new HeaderRenderer2(tbl_items.getTableHeader()));


    }

    private void loadData_items(List<S2_search.to_items_status> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "QTY", "NAME", "UOM", "DESC", "PRICE", "IMG PATH", "QTY2", ""
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
            if (col == 7) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S2_search.to_items_status tt = (S2_search.to_items_status) getRow(row);

            switch (col) {
            case 0:
                return tt.qty;
            case 1:
                return tt.name;
            case 2:
                return tt.uom;
            case 3:
                return tt.desc;
            case 4:
                return tt.price;
            case 5:
                return tt.img_path;
            case 6:
                return tt.qty2;


            default:
                return tt.status;
            }
        }
    }

    private void data_items() {
        List<S2_search.to_items_status> datas = S2_assembly.ret_data_dashboard(ref);
        loadData_items(datas);
        int state = 0;
        for (S2_search.to_items_status t : datas) {
            S2_search.to_items_status order = (S2_search.to_items_status) tbl_employee_payroll_ALM.get(tbl_items.convertRowIndexToModel(state));
            if (state == 0) {
                order.setStatus(true);
            } else {
                order.setStatus(false);
            }
            state++;
        }



        tbl_employee_payroll_M.fireTableDataChanged();

        compute();

    }

    private void compute() {

        List<S2_search.to_items_status> datas = tbl_employee_payroll_ALM;
        double amount = 0;
        for (S2_search.to_items_status to : datas) {
            if (to.status == true) {
                amount += to.price * to.qty;
            }
        }
        if (tbl_employee_payroll_ALM.isEmpty()) {
            double am = my_price * FitIn.toDouble(tf_qty.getText());
            lbl_price.setText(FitIn.fmt_wc_0(am));
        } else {
            amount = amount * FitIn.toDouble(tf_qty.getText());
            lbl_price.setText(FitIn.fmt_wc_0(amount));
        }

    }

    // <editor-fold defaultstate="collapsed" desc="RENDER">
    public class HeaderRenderer2 implements TableCellRenderer {

        private final JCheckBox check = new JCheckBox();

        public HeaderRenderer2(JTableHeader header) {
            check.setOpaque(false);
            check.setFont(header.getFont());
            header.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    JTable table = ((JTableHeader) e.getSource()).getTable();
                    TableColumnModel columnModel = table.getColumnModel();
                    int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                    int modelColumn = table.convertColumnIndexToModel(viewColumn);
                    if (modelColumn == 0 || modelColumn == 1) {
                        check.setSelected(!check.isSelected());
                        TableModel m = table.getModel();
                        Boolean f = check.isSelected();
                        for (int i = 0; i < m.getRowCount(); i++) {
                            m.setValueAt(f, i, modelColumn);
                        }
                        check.setSelected(true);
                        ((JTableHeader) e.getSource()).repaint();

                    }
                }
            });
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable tbl, Object val, boolean isS, boolean hasF, int row, int col) {
            TableCellRenderer r = tbl.getTableHeader().
                    getDefaultRenderer();
            JLabel l = (JLabel) r.getTableCellRendererComponent(tbl, val, isS, hasF, row, col);
            l.setIcon(new CheckBoxIcon(check));
//            check.setSelected(true);
//            l.setVerticalTextPosition(Ch);
            return l;
        }

        public JCheckBox getCheck() {
            return check;
        }
    }

    private static class CheckBoxIcon implements Icon {

        private final JCheckBox check;

        public CheckBoxIcon(JCheckBox check) {
            this.check = check;
        }

        @Override
        public int getIconWidth() {
            return check.getPreferredSize().width;
        }

        @Override
        public int getIconHeight() {
            return check.getPreferredSize().height;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            SwingUtilities.paintComponent(
                    g, check, (Container) c, x, y, getIconWidth(), getIconHeight());
        }
    }
    // </editor-fold>

    private void set_check() {
        int idx = tbl_items.getSelectedRow();
        if (idx < 0) {
            return;
        }

        List<S2_search.to_items_status> datas = tbl_employee_payroll_ALM;

        if (assemble.equals("2")) {

            for (int i = 0; i < tbl_employee_payroll_ALM.size(); i++) {
                S2_search.to_items_status aw = (S2_search.to_items_status) tbl_employee_payroll_ALM.get(tbl_items.convertRowIndexToModel(i));
                if (i == idx) {
                    aw.setStatus(true);
                } else {
                    aw.setStatus(false);
                }
            }
            tbl_employee_payroll_M.fireTableDataChanged();
            HelpScrollToView.view(idx, tbl_items);
        } else {
            S2_search.to_items_status order = (S2_search.to_items_status) tbl_employee_payroll_ALM.get(tbl_items.convertRowIndexToModel(idx));
            boolean stat = false;
            if (order.status == true) {
                stat = false;
            } else {
                stat = true;
            }
            int state = 0;
            for (S2_search.to_items_status t : datas) {
                if (t.status == true) {
                    state += 1;
                }
            }
            if (state == 1) {
                order.setStatus(true);
            } else {
                order.setStatus(stat);
            }

            tbl_employee_payroll_M.fireTableDataChanged();
        }

        compute();
    }

    private void check_all() {

        boolean stat = false;
        if (!cx_all.isSelected()) {

            stat = false;
        } else {

            stat = true;
        }
        for (int i = 0; i < tbl_employee_payroll_ALM.size(); i++) {
            S2_search.to_items_status order = (S2_search.to_items_status) tbl_employee_payroll_ALM.get(tbl_items.convertRowIndexToModel(i));
            order.setStatus(stat);
        }
        tbl_employee_payroll_M.fireTableDataChanged();
        compute();
    }

    private void ok1() {
        if (my_oder == 3) {
        } else {

            String disc_name1 = cb_type.getSelectedItem().toString();
            double disc_rate = FitIn.toDouble(lb_rate.getText());
            double discount = FitIn.toDouble(lbl_price.getText()) * (disc_rate / 100);
            String customer_name1 = cb_cust_name.getSelectedItem().toString();
            String customer_id = tf_cust_no.getText();
            String customer_address = tf_address.getText();

            S2_search.to_items to_items = new S2_search.to_items(my_id, my_uom, lbl_name.getText(), FitIn.toDouble(lbl_price.getText()), FitIn.toDouble(tf_qty.getText()), my_img_path, FitIn.toDouble(tf_qty.getText()), guest_id, cat_id, category_name, print_assme, status, disc_name1, disc_rate, discount, customer_name1, customer_id, customer_address, "", group_id);
            List<S2_search.to_items_status> to_sub = tbl_employee_payroll_ALM;
            double to_pay = FitIn.toDouble(lbl_price.getText());
            double qty = FitIn.toDouble(tf_qty.getText());
            if (qty == 0) {
                Prompt.call("Complete Details");
                return;
            }
            String disc_name = cb_type.getSelectedItem().
                    toString();
            String rate = lb_rate.getText();
            String name = cb_cust_name.getSelectedItem().
                    toString();
            String num = tf_cust_no.getText();
            String address = tf_address.getText();
            int id = 0;
            String customer_name = cb_cust_name.getSelectedItem().
                    toString();
            String card_no = tf_cust_no.getText();
            S1_add_customer_discount.to_customer_discounts to = new S1_add_customer_discount.to_customer_discounts(id, customer_name, card_no, address);
//            S1_add_customer_discount.add_data(to);
            if (callback != null) {
                if (stat == 1) {
                    this.dispose();
                    callback.order(new CloseDialog(this), new OutputData(to_items, to_sub, to_pay));
                } else {
                    this.dispose();
                    callback.cancel(new CloseDialog(this), new OutputData(to_items, to_sub, to_pay));
                }
            }
        }

    }

    private void cancel() {
        if (my_oder == 3) {
            final String un = tf_user_name.getText();
            final String pw = new String(tf_password.getPassword());
            if (!S9_confirm_user.conf_user(un, pw)) {
                tf_user_name.setText("");
                tf_password.setText("");
                tf_user_name.grabFocus();
//                Prompt.call("Wrong UserName/Password");
                JOptionPane.showMessageDialog(null, "Wrong UserName/Password");
//            return;
            } else {

                int lvl = S14_chech_if_admin.do_check_if_adming(tf_user_name.getText());
                if (lvl != 1) {
                    JOptionPane.showMessageDialog(null, "Authentication Failed");
//                    Prompt.call("Authentication Failed");
                    tf_password.setText("");
                    tf_user_name.setText("");

                } else {
                    if (callback != null) {
                        callback.remove(new CloseDialog(this));
                    }
                }
            }
        } else {
            if (callback != null) {
                callback.remove(new CloseDialog(this));
            }
        }
    }
}
