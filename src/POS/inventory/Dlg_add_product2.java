/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.dlg2.Dlg_supplier;
import POS.inventory.S2_assembly.to_assembly;
import POS.svc4.S3_get_qty_price;
import POS.utl.Center;
import POS.utl.Prompt;
import POS_dlg4.Dlg_add_uom;
import POS_svc3.S1_get_category;
import POS_svc4.S7_uom;
import POS_svc4.S7_uom.to_product_uom;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.*;

/**
 *
 * @author Dummy
 */
public class Dlg_add_product2 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_add_product2
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
        public final String description;
        public final String price;
        public final String qty;
        public final String remarks;
        public final String supplier;
        public final String vat;
        public final String assemby;
        public final List<S7_uom.to_product_uom> tt;
        public final String is_linient;
        public final String w_com;
        public final double amount;
        public final double cost;
        public final String img_path;
        public final int is_active;
//        public final String 
        public OutputData(String name, String description, String price, String qty, String remarks, String supplier, String vat, String assemby, List<to_product_uom> tt, String is_linient, String w_com, double amount, double cost, String img_path,int is_active) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.qty = qty;
            this.remarks = remarks;
            this.supplier = supplier;
            this.vat = vat;
            this.assemby = assemby;
            this.tt = tt;
            this.is_linient = is_linient;
            this.w_com = w_com;
            this.amount = amount;
            this.cost = cost;
            this.img_path = img_path;
            this.is_active=is_active;
        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_add_product2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_add_product2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_add_product2() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_add_product2 myRef;

    private void setThisRef(Dlg_add_product2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_add_product2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_add_product2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_add_product2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_add_product2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_add_product2((java.awt.Frame) parent, false);
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
            Dlg_add_product2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_add_product2((java.awt.Dialog) parent, false);
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


        Dlg_add_product2 dialog = Dlg_add_product2.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_desc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_qty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_remarks = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cb_supplier = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cb_vat = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cb_assembly = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_uom = new javax.swing.JTable();
        ds_title1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cb_w_commission = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cb_linient = new javax.swing.JComboBox();
        tf_cost = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_com_amount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lbl_photo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_assembly = new javax.swing.JTable();
        ds_title2 = new javax.swing.JLabel();
        cx_default = new javax.swing.JCheckBox();
        cx_assemble = new javax.swing.JCheckBox();
        cx_list = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cb_is_selected = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BARCODE:");

        tf_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameActionPerformed(evt);
            }
        });
        tf_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nameKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Description:");

        tf_desc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Supplier:");

        tf_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_price.setText("0");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Quantity:");

        tf_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_qty.setText("0");
        tf_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_qtyActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("KITCHEN ASSEMBLY:");

        tf_remarks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_remarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_remarksActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Price:");

        cb_supplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_supplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add 16x16.png"))); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Remarks:");

        cb_vat.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cb_vat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("%");

        cb_assembly.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cb_assembly.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        tbl_uom.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_uom.setFocusable(false);
        jScrollPane1.setViewportView(tbl_uom);

        ds_title1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ds_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title1.setText("Unit of Measure");
        ds_title1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton4.setText("ADD");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("DELETE");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("EDIT");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("VAT:");

        cb_w_commission.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cb_w_commission.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        cb_w_commission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_w_commissionActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("LENIENT:");

        cb_linient.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cb_linient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

        tf_cost.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tf_cost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_cost.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("WITH COMMISSION:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("COST:");

        tf_com_amount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tf_com_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_com_amount.setText("0");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("RATE:");

        lbl_photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_photo.setText("NO PHOTO");
        lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.setFocusable(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("OK");
        jButton2.setFocusable(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        jButton2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("ASSEMBLY");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("UNIT OF MEASURE");
        jButton8.setEnabled(false);
        jButton8.setFocusable(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        tbl_assembly.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_assembly.setFocusable(false);
        jScrollPane2.setViewportView(tbl_assembly);

        ds_title2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ds_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title2.setText("ASSEMBLY");
        ds_title2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(cx_default);
        cx_default.setSelected(true);
        cx_default.setText("DEFAULT");

        buttonGroup1.add(cx_assemble);
        cx_assemble.setText("ASSEMBLE");

        buttonGroup1.add(cx_list);
        cx_list.setText("LIST");

        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        jLabel9.setFocusable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("+");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        cb_is_selected.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cb_is_selected.setSelected(true);
        cb_is_selected.setText("IS ACTIVE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(160, 160, 160)
                                            .addComponent(cb_assembly, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1))
                                    .addGap(20, 20, 20)
                                    .addComponent(lbl_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tf_desc)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(cb_vat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(160, 160, 160)
                                    .addComponent(cb_w_commission, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cb_linient, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tf_com_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cb_is_selected))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(cb_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(10, 10, 10)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addComponent(ds_title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cx_default)
                                .addGap(18, 18, 18)
                                .addComponent(cx_assemble)
                                .addGap(18, 18, 18)
                                .addComponent(cx_list)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ds_title2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ds_title1)
                            .addComponent(ds_title2))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cx_default, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cx_list, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cx_assemble, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cb_assembly, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel2))))
                            .addComponent(jLabel9))
                        .addGap(6, 6, 6)
                        .addComponent(tf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_price, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tf_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(cb_is_selected)
                                        .addGap(18, 18, 18)
                                        .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cb_vat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel10))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cb_w_commission, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel11)
                                                .addComponent(cb_linient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tf_com_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        cancel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_remarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_remarksActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_tf_remarksActionPerformed

    private void tf_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_qtyActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_tf_qtyActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        supplier();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameActionPerformed
        // TODO add your handling code here:
        check_code();
    }//GEN-LAST:event_tf_nameActionPerformed

    private void tf_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nameKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        add_uom();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        do_edit_uom();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        do_remove();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cb_w_commissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_w_commissionActionPerformed
        // TODO add your handling code here:
        set();
    }//GEN-LAST:event_cb_w_commissionActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setEnabled(false);
        jButton7.setEnabled(true);
        set_uom();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jButton8.setEnabled(true);
        jButton7.setEnabled(false);
        set_assembly();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        assembly();
    }//GEN-LAST:event_jLabel15MouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_assembly;
    private javax.swing.JCheckBox cb_is_selected;
    private javax.swing.JComboBox cb_linient;
    private javax.swing.JComboBox cb_supplier;
    private javax.swing.JComboBox cb_vat;
    private javax.swing.JComboBox cb_w_commission;
    private javax.swing.JCheckBox cx_assemble;
    private javax.swing.JCheckBox cx_default;
    private javax.swing.JCheckBox cx_list;
    private javax.swing.JLabel ds_title1;
    private javax.swing.JLabel ds_title2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JTable tbl_assembly;
    private javax.swing.JTable tbl_uom;
    private javax.swing.JTextField tf_com_amount;
    private javax.swing.JTextField tf_cost;
    private javax.swing.JTextField tf_desc;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_price;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_remarks;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        jLabel12.setVisible(false);
        set();
        get_suppliers();

        init_tbl_uom();
        init_tbl_assembly_entries();
        tf_name.setText("" + S7_uom.get_barcode());
//        tf_name.setText("10");
        load_date_e();
        jLabel5.setVisible(false);
        cb_assembly.setVisible(false);
        jLabel8.setVisible(false);

    }

    private void set_assembly() {
        ds_title1.setVisible(false);
        jScrollPane1.setVisible(false);
        jButton4.setVisible(false);
        jButton6.setVisible(false);
        jButton5.setVisible(false);
    }

    private void set_uom() {
        ds_title1.setVisible(true);
        jScrollPane1.setVisible(true);
        jButton4.setVisible(true);
        jButton6.setVisible(true);
        jButton5.setVisible(true);

    }

    public void do_pass() {
        tf_qty.setVisible(false);
        jLabel4.setVisible(false);

//        System.setProperty("cashiering_for", "endorsements");
        String cashiering_for = System.getProperty("cashiering_for", "retail_store");
        if (cashiering_for.equals("restaurant_w_order_no")) {
            jLabel12.setVisible(true);
            jLabel5.setVisible(true);
            cb_assembly.setVisible(true);
        } else {

            if (cashiering_for.equals("endorsements")) {

                cb_w_commission.setVisible(true);

//                jLabel5.setVisible(false);
//                cb_assembly.setVisible(false);

                jLabel8.setVisible(true);
                tf_cost.setVisible(true);
                jLabel12.setVisible(true);


            } else {
                jLabel12.setVisible(false);
                cb_w_commission.setVisible(false);

//                jLabel5.setVisible(true);
//                cb_assembly.setVisible(true);

//                jLabel8.setVisible(true);
//                tf_cost.setVisible(true);

            }



        }
//         jLabel12.setVisible(false);
    }

    private void set() {
//        if (cb_w_commission.getSelectedIndex() == 0) {
//            tf_com_amount.enable(false);
//        } else {
//            tf_com_amount.enable(true);
//        }
    }

    private void get_suppliers() {
        cb_supplier.setModel(new ListComboBoxModel(S1_get_category.get_suppliers()));
    }
    String im_path = "empty";

    private void ok1() {

        boolean c = check_code();
//        JOptionPane.showMessageDialog(null, c);
        if (c) {


            Prompt.call("Barcode Already Exists");
            return;
        }

        if (tf_cost.getText().isEmpty()) {


            Prompt.call("Input Cost");
            return;
        }
        if (tf_com_amount.getText().isEmpty()) {


            Prompt.call("Input Commission Rate");
            return;
        }
        double cost = Double.parseDouble(tf_cost.getText());
        double amount = Double.parseDouble(tf_com_amount.getText());
        String name = tf_name.getText();

//        boolean c=S7_uom.check_barcode(name);
//        if(c==true){
//            Prompt.call("Barcode Already Exists");
//            return;
//        }
        String desc = tf_desc.getText();
        String price = tf_price.getText();
        String qty = tf_qty.getText();
        String remarks = tf_remarks.getText();
        String supplier = cb_supplier.getSelectedItem().toString();
        String id = "" + S1_get_category.get_supplier_id(supplier);
        String vat = cb_vat.getSelectedItem().toString();
//        check_code();
        String assembly = "";
        String is_linient = "";
        String w_com = "";
        int is_active=0;
        
        if(cb_is_selected.isSelected()){
            is_active=1;
        }
        if (cx_default.isSelected()) {
            assembly = "0";
        }
        if (cx_assemble.isSelected()) {
            assembly = "1";
        }
        if (cx_list.isSelected()) {
            assembly = "2";
        }

        if (cb_linient.getSelectedIndex() == 0) {
            is_linient = "1";
        } else {
            is_linient = "0";
        }

        if (cb_w_commission.getSelectedIndex() == 0) {
            w_com = "1";
        } else {
            w_com = "2";
        }

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(name, desc, price, qty, remarks, id, vat, assembly, tbl_employee_payroll_ALM, is_linient, w_com, amount, cost, im_path,is_active));
        }
    }

    private void supplier() {
        Window p = (Window) this;
        Dlg_supplier nd = Dlg_supplier.create(p, true);
        nd.setTitle("Supplier");
//        nd.pass(date);
        nd.setCallback(new Dlg_supplier.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_supplier.OutputData data) {
//                closeDialog.ok();
                get_suppliers();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private boolean check_code() {
        boolean j = false;

        if (tf_name.getText().isEmpty()) {
            return true;
        }
        String if_ok = S3_get_qty_price.get_code(tf_name.getText());
        if (if_ok.equals(tf_name.getText())) {
            Prompt.call("Product Already exists");
//            JOptionPane.showMessageDialog(null, "Product Already exists");
            tf_name.setText("");
            tf_name.setCaretPosition(0);
            tf_name.selectAll();
            j = true;
        } else {
            j = false;
//            JOptionPane.showMessageDialog(null, "Product Already exists");
        }
        return j;

    }
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_uom() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);

        tbl_uom.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_uom.setModel(tbl_employee_payroll_M);
        tbl_uom.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_uom.setRowHeight(25);

//        tbl_uom.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 100, 100, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_uom, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        tbl_uom.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 10));
        tbl_uom.setRowHeight(35);
        tbl_uom.setFont(new java.awt.Font("Arial", 1, 10));
    }

    private void loadData_uom(List<S7_uom.to_product_uom> acc) {
//        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "UOM", "PC/S", "product id"
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
            S7_uom.to_product_uom tt = (S7_uom.to_product_uom) getRow(row);

            switch (col) {
            case 0:
                return tt.id;
            case 1:
                return tt.uom;
            case 2:
                return tt.uom_amount;

            default:
                return tt.product_id;
            }
        }
    }

    private void data_uom(String uom, double amount) {
        List<S7_uom.to_product_uom> datas = new ArrayList();
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
        S7_uom.to_product_uom to = new S7_uom.to_product_uom("0", uom, amount, "0");
        datas.add(to);
        loadData_uom(datas);
    }

    private void add_uom() {
        Window p = (Window) this;
        Dlg_add_uom nd = Dlg_add_uom.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_add_uom.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_uom.OutputData data) {
                closeDialog.ok();
                data_uom(data.name, data.qty);
            }
        });
        Center.setCenter(nd);
//        Application.locateOnParentCenter(p, nd);

        nd.setVisible(true);
    }

    private void do_edit_uom() {
        int idx = tbl_uom.getSelectedRow();
        if (idx < 0) {
            return;
        }
        String uom = tbl_uom.getModel().getValueAt(idx, 1).toString();
        double amount = Double.parseDouble(tbl_uom.getModel().getValueAt(idx, 2).toString());

        Window p = (Window) this;
        Dlg_add_uom nd = Dlg_add_uom.create(p, true);
        nd.setTitle("");
        nd.do_pass(uom, amount);
        nd.setCallback(new Dlg_add_uom.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_uom.OutputData data) {
                closeDialog.ok();
                set_val(data);
            }
        });
        Center.setCenter(nd);
//        Application.locateOnParentCenter(p, nd);

        nd.setVisible(true);


    }

    private void set_val(Dlg_add_uom.OutputData data) {
        int idx = tbl_uom.getSelectedRow();
        if (idx < 0) {
            return;
        }

        S7_uom.to_product_uom order = (S7_uom.to_product_uom) tbl_employee_payroll_ALM.get(tbl_uom.convertRowIndexToModel(idx));
        order.setUom(data.name);
        order.setUom_amount(data.qty);

        tbl_employee_payroll_M.fireTableDataChanged();

        tbl_uom.getSelectionModel().setSelectionInterval(idx, idx);
        HelpScrollToView.view(idx, tbl_uom);


    }

    private void do_remove() {
        int[] idx = tbl_uom.getSelectedRows();

        List rem = new ArrayList();
        for (int ix : idx) {
            if (tbl_uom.isRowSelected(ix)) {
                int mx = tbl_uom.convertRowIndexToModel(ix);
                rem.add(tbl_employee_payroll_ALM.get(mx));
            }
        }

        tbl_employee_payroll_ALM.removeAll(rem);
        tbl_employee_payroll_M.fireTableDataChanged();
    }
    private ArrayListModel tbl_assembly_e_ALM;
    private TblassemblyeModel tbl_assembly_e_M;

    private void init_tbl_assembly_entries() {
        tbl_assembly_e_ALM = new ArrayListModel();
        tbl_assembly_e_M = new TblassemblyeModel(tbl_assembly_e_ALM);
        tbl_assembly.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_assembly.setModel(tbl_assembly_e_M);
        tbl_assembly.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_assembly.setRowHeight(25);
//        tbl_assembly.setAutoResizeMode(0);
        int[] tbl_widths_assembly = {0, 0, 100, 100, 100, 0, 0};
        for (int i = 0, n = tbl_widths_assembly.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_assembly, i, tbl_widths_assembly[i]);
        }
        Dimension d = tbl_assembly.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_assembly.getTableHeader().setPreferredSize(d);
        tbl_assembly.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_assembly.setRowHeight(35);
        tbl_assembly.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_assembly_e(List<S2_assembly.to_assembly> acc) {
        tbl_assembly_e_ALM.clear();
        tbl_assembly_e_ALM.addAll(acc);
    }

    public static class TblassemblyeModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "prod_num", "description", "price", "product_qty", "ref_num", "status"
        };

        public TblassemblyeModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 1) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S2_assembly.to_assembly tt = (S2_assembly.to_assembly) getRow(row);
            switch (col) {
            case 0:
                return tt.id;
            case 1:
                return tt.prod_num;
            case 2:
                return tt.description;
            case 3:
                return tt.price;
            case 4:
                return tt.product_qty;
            case 5:
                return tt.ref_num;
            default:
                return tt.status;
            }
        }
    }

    private void load_date_e() {
        String ref = tf_name.getText();
        loadData_assembly_e(S2_assembly.ret_data(ref));
    }

    private void assembly() {
        Window p = (Window) this;
        Dlg_add_assembly nd = Dlg_add_assembly.create(p, true);
        nd.setTitle("");
        nd.do_pass(tf_name.getText());
        nd.setCallback(new Dlg_add_assembly.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_assembly.OutputData data) {
//                closeDialog.ok();
                load_date_e();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void cancel() {
        List<to_assembly> datas = tbl_assembly_e_ALM;
        S2_assembly.delete_assembly_cancel(datas);
        tbl_assembly_e_ALM.clear();
        tbl_assembly_e_M.fireTableDataChanged();
    }
}
