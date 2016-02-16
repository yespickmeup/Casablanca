/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.dlg2.Dlg_confirm;
import POS.dlg2.Dlg_name;
import POS.dlg2.Dlg_vat;


import POS.svc3.S10_update_product;
import POS.utl.Prompt;
import POS_dlg4.Dlg_add_uom;
import POS_dlg4.Dlg_edit_cb;
import POS_dlg4.Dlg_edit_cb_comm;
import POS_dlg4.Dlg_stock_out;
import POS.category_types.S1_categories;
import POS_svc4.S7_uom;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Dummy
 */
public class Dlg_Menu_update_product extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_Menu_update_product
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;




    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void o2(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final String types;
        public final String types_num;
        public final String barcode;
        public final String cat_id;
        public final String assemble;

        public OutputData(String types, String types_num, String barcode, String cat_id, String assemble) {
            this.types = types;
            this.types_num = types_num;
            this.barcode = barcode;
            this.cat_id = cat_id;
            this.assemble = assemble;
        }
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_Menu_update_product(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_Menu_update_product(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_Menu_update_product() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_Menu_update_product myRef;

    private void setThisRef(Dlg_Menu_update_product myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_Menu_update_product> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_Menu_update_product create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_Menu_update_product create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_Menu_update_product dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_Menu_update_product((java.awt.Frame) parent, false);
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
            Dlg_Menu_update_product dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_Menu_update_product((java.awt.Dialog) parent, false);
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


        Dlg_Menu_update_product dialog = Dlg_Menu_update_product.create(new javax.swing.JFrame(), true);
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
        jLabel4 = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tf_desc1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_price = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        tf_qty = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_vat = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_cancel2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_uom = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox();
        cb_type = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        lb_com = new javax.swing.JLabel();
        lb_linient = new javax.swing.JLabel();
        tf_selling_price = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        lb_comm_amount = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_photo = new javax.swing.JLabel();
        ds_title2 = new javax.swing.JLabel();
        ds_title3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_assembly = new javax.swing.JTable();
        cx_default = new javax.swing.JCheckBox();
        cx_assemble = new javax.swing.JCheckBox();
        cx_list = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("SUB:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 40, 30));

        lb_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_name.setText("PRODUCT NAME:");
        lb_name.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        lb_name.setOpaque(true);
        jPanel1.add(lb_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 400, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 60, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, 30));

        tf_desc1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_desc1.setText("DESCRIPTION");
        tf_desc1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        tf_desc1.setOpaque(true);
        jPanel1.add(tf_desc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 400, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DESCRIPTION:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 120, 20));

        tf_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_price.setText("0.0");
        tf_price.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        tf_price.setOpaque(true);
        jPanel1.add(tf_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 90, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("SELLING PRICE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 120, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("EDIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 70, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("STOCK IN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, 30));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("STOCK OUT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, 30));

        tf_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_qty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_qty.setText("0");
        tf_qty.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        tf_qty.setOpaque(true);
        jPanel1.add(tf_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 88, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("TOTAL QUANTITY:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, -1));

        lb_vat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_vat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_vat.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        lb_vat.setOpaque(true);
        jPanel1.add(lb_vat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 90, 30));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("EDIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 70, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("%");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 20, 30));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("DONE");

        jLabel17.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("CLOSE");

        btn_cancel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_cancel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_cancel2.setBorderPainted(false);
        btn_cancel2.setContentAreaFilled(false);
        btn_cancel2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(882, Short.MAX_VALUE)
                .addComponent(btn_cancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16))
                    .addComponent(btn_cancel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1210, 60));

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
        jScrollPane1.setViewportView(tbl_uom);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 220, 450));

        jButton8.setText("ADD");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 70, 40));

        jButton9.setText("EDIT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 70, 40));

        jButton10.setText("DELETE");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 70, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("BARCODE:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 30));

        cb_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });
        jPanel1.add(cb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 330, 30));

        cb_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_typeActionPerformed(evt);
            }
        });
        jPanel1.add(cb_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 250, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("CATEGORY:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("VAT:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 447, -1, 30));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setText("EDIT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 70, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("LENIENT:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 80, -1));

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton12.setText("EDIT");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 70, 30));

        lb_com.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_com.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_com.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_com.setOpaque(true);
        jPanel1.add(lb_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 90, 30));

        lb_linient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_linient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_linient.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1)));
        lb_linient.setOpaque(true);
        jPanel1.add(lb_linient, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 90, 30));

        tf_selling_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_selling_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tf_selling_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_selling_price.setOpaque(true);
        jPanel1.add(tf_selling_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 90, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("WITH COMMISSION:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 160, 30));

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton13.setText("EDIT");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 70, 30));

        lb_comm_amount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_comm_amount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_comm_amount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_comm_amount.setOpaque(true);
        jPanel1.add(lb_comm_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 70, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("COST:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 60, 40));

        lbl_photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_photo.setText("NO PHOTO");
        lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 140, 130));

        ds_title2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ds_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title2.setText("Unit of Measure");
        ds_title2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ds_title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 220, -1));

        ds_title3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ds_title3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title3.setText("ASSEMBLY");
        ds_title3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ds_title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 450, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, 450));

        buttonGroup1.add(cx_default);
        cx_default.setSelected(true);
        cx_default.setText("DEFAULT");
        jPanel1.add(cx_default, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 530, -1, -1));

        buttonGroup1.add(cx_assemble);
        cx_assemble.setText("ASSEMBLE");
        jPanel1.add(cx_assemble, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 530, -1, -1));

        buttonGroup1.add(cx_list);
        cx_list.setText("LIST");
        jPanel1.add(cx_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 530, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("+");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 530, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        ok2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        update_name();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        update_desc();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        update_price();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        update_qty();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        update_vat();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        update_qty_stock_out();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        add_uom();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        do_edit_uom();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        do_remove();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        // TODO add your handling code here:
        cb_type();
//        data_employee();
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void cb_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_typeActionPerformed
        // TODO add your handling code here:;
//        cb_type();
//        data_employee();
    }//GEN-LAST:event_cb_typeActionPerformed

    private void btn_cancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel2ActionPerformed
//    clear_field();
        this.dispose();
//        out();
    }//GEN-LAST:event_btn_cancel2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        update_comm();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        update_linient();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        update_cost();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        assembly();
    }//GEN-LAST:event_jLabel15MouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_category;
    private javax.swing.JComboBox cb_type;
    private javax.swing.JCheckBox cx_assemble;
    private javax.swing.JCheckBox cx_default;
    private javax.swing.JCheckBox cx_list;
    private javax.swing.JLabel ds_title2;
    private javax.swing.JLabel ds_title3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_com;
    private javax.swing.JLabel lb_comm_amount;
    private javax.swing.JLabel lb_linient;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_vat;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JTable tbl_assembly;
    private javax.swing.JTable tbl_uom;
    private javax.swing.JLabel tf_desc1;
    private javax.swing.JLabel tf_price;
    private javax.swing.JLabel tf_qty;
    private javax.swing.JLabel tf_selling_price;
    // End of variables declaration//GEN-END:variables
    String num1 = "";
    String name1 = "";
    String desc1 = "";
    String price1 = "";
    String qty1 = "";
    String vat1 = "";
    double com_amount = 0;
    double cost = 0;

    public void pass(String num, String name, String desc, String price, String qty, String vat, String type_id, String is_linient, String w_comm, double comm_amount, String cat, double costs) {
        String cashiering_for = System.getProperty("cashiering_for", "retail_store");
//        JOptionPane.showMessageDialog(null, cashiering_for);

        lb_comm_amount.setVisible(false);
        jLabel8.setVisible(false);
//        if (cashiering_for.equals("endorsements") || cashiering_for.equals("retail_store")) {
//            cb_type.setVisible(false);
//            jLabel4.setVisible(false);
//        } else {
//            cb_type.setVisible(true);
//            jLabel4.setVisible(true);
//        }
        num1 = num;
        name1 = name;
        desc1 = desc;
        price1 = price;
        qty1 = qty;
        lb_name.setText(name);
        tf_desc1.setText(desc);
        tf_price.setText(price);
        tf_qty.setText(qty);
        vat1 = vat;
        lb_vat.setText(vat1);
        com_amount = comm_amount;
        tf_selling_price.setText("" + costs);
        data_uom();

        cost = costs;

        lb_comm_amount.setText("" + comm_amount);

        cb_model();
//        cb_type();

        String id = type_id;
//        JOptionPane.showMessageDialog(null, type_id);
        type_id = S10_update_product.get_category_name(type_id);


        String cat_name = S10_update_product.get_category_id(id);
//       


        cat_name = S10_update_product.get_class_name(cat);
        cb_category.setSelectedItem(cat_name);
        cb_type.setSelectedItem(type_id);
        System.out.println(cat_name + " -" + type_id);

        if (is_linient.equals("1")) {
            is_linient = "Yes";
        } else {
            is_linient = "No";
        }

        if (w_comm.equals("1")) {
            w_comm = "Yes";
        } else {
            w_comm = "No";
        }

        lb_linient.setText(is_linient);
        lb_com.setText(w_comm);


//        String cashiering_for = System.getProperty("cashiering_for", "retail_store");
        if (cashiering_for.equals("restaurant_w_order_no")) {
//            jLabel5.setVisible(true);
//            cb_assembly.setVisible(true);
        } else {

            if (cashiering_for.equals("endorsements") || cashiering_for.equals("retail_store")) {
                lb_com.setVisible(true);
                jButton11.setVisible(true);
//                jLabel8.setVisible(true);
                tf_selling_price.setVisible(true);
                jLabel13.setVisible(true);
            } else {
                lb_com.setVisible(false);
                jButton11.setVisible(false);
//                jLabel8.setVisible(true);
                tf_selling_price.setVisible(true);
                jLabel13.setVisible(false);
            }
            
        }

        String assembly = S2_assembly.get_assembly_no(num);
//        JOptionPane.showMessageDialog(null, assembly);
        if (assembly.equals("0")) {
            cx_default.setSelected(true);
        }
        if (assembly.equals("1")) {
            cx_assemble.setSelected(true);
        }
        if (assembly.equals("2")) {
            cx_list.setSelected(true);
        }
//        cb_type.setVisible(false);
//        jLabel4.setVisible(false);
        load_date_e();
    }

    private void cb_model() {

        cb_category.setModel(new ListComboBoxModel(S1_categories.ret_categories_for_cb()));
    }

    private void cb_type() {
        int row = cb_category.getItemCount();
        if (row == 0) {
            return;
        }
        cb_type.setModel(new ListComboBoxModel(S1_categories.ret_category_types_for_cb(cb_category.getSelectedItem().toString())));
    }

    private void myInit() {
        init_tbl_uom();

        cb_model();
        cb_type();
        init_tbl_assembly_entries();
    }

    private void update_name() {
        Window p = (Window) this;
        Dlg_name nd = Dlg_name.create(p, true);
        nd.setTitle("Prompt");
        nd.do_pass(lb_name.getText());
        nd.setCallback(new Dlg_name.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_name.OutputData data) {
                closeDialog.ok();
                do_set_name(data.name);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_set_name(String name) {
        lb_name.setText(name);
        boolean h = S7_uom.check_barcode(name);
        if (h == true) {

            Prompt.call("Barcode Already Exists");
            return;
        }
        S10_update_product.do_update_product_name(name, lb_name.getText());
        ok1();
    }

    private void do_set_desc(String name) {
        tf_desc1.setText(name);
        S10_update_product.do_update_product_desc(name, lb_name.getText());
        ok1();
    }

    private void update_desc() {
        Window p = (Window) this;
        Dlg_name nd = Dlg_name.create(p, true);
        nd.setTitle("");
        nd.do_pass(tf_desc1.getText());
        nd.setCallback(new Dlg_name.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_name.OutputData data) {
                closeDialog.ok();
                do_set_desc(data.name);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_price() {
        Window p = (Window) this;
        Dlg_update_product_price nd = Dlg_update_product_price.create(p, true);
        nd.setTitle("Prompt");
        nd.do_pass("Enter New Price", tf_price.getText());
        nd.setCallback(new Dlg_update_product_price.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_update_product_price.OutputData data) {
                closeDialog.ok();
                do_set_price(data.name);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_cost() {
        Window p = (Window) this;
        Dlg_update_product_price nd = Dlg_update_product_price.create(p, true);
        nd.setTitle("Prompt");
        nd.do_pass("Enter New Cost", tf_selling_price.getText());
        nd.setCallback(new Dlg_update_product_price.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_update_product_price.OutputData data) {
                closeDialog.ok();
                do_set_cost(data.name);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_set_price(String name) {
        tf_price.setText(name);
//        JOptionPane.showMessageDialog(null, num1);
        S10_update_product.do_update_product_price(name, lb_name.getText());
        ok1();
    }

    private void do_set_cost(String name) {
        tf_selling_price.setText(name);

        S10_update_product.do_update_product_cost(Double.parseDouble(name), lb_name.getText());
        Prompt.call("Successfully Updated");
        ok1();
    }

    private void update_linient() {
        String l = lb_linient.getText();
        Window p = (Window) this;
        Dlg_edit_cb nd = Dlg_edit_cb.create(p, true);
        nd.setTitle("");
        nd.do_pass(l, "Linient");
        nd.setCallback(new Dlg_edit_cb.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_edit_cb.OutputData data) {
                closeDialog.ok();
                do_set_linient(data.stmt, num1);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_set_linient(String stmt, String num1) {

        if (stmt.equals("1")) {
            lb_linient.setText("Yes");
        } else {
            lb_linient.setText("No");
        }

        S10_update_product.do_update_linient(stmt, lb_name.getText());
        ok1();

    }

    private void update_comm() {
        String l = lb_com.getText();
        Window p = (Window) this;
        Dlg_edit_cb_comm nd = Dlg_edit_cb_comm.create(p, true);
        nd.setTitle("");
        nd.do_pass(l, "With Commission", com_amount);
        nd.setCallback(new Dlg_edit_cb_comm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_edit_cb_comm.OutputData data) {
                closeDialog.ok();
                do_set_comm(data.stmt, num1, data.amount);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_set_comm(String stmt, String num1, double amount) {

        if (stmt.equals("1")) {
            lb_com.setText("Yes");
        } else {
            lb_com.setText("No");
        }

        lb_comm_amount.setText("" + amount);
        S10_update_product.do_update_comm(stmt, lb_name.getText(), amount);
        ok1();

    }

    private void update_qty() {
        Window p = (Window) this;
        Dlg_update_product_qty nd = Dlg_update_product_qty.create(p, true);
        nd.setTitle("Prompt");
        nd.do_pass(tf_desc1.getText(), tf_selling_price.getText());
        nd.setCallback(new Dlg_update_product_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_update_product_qty.OutputData data) {
                closeDialog.ok();
                do_update_qty(data.qty, data.supplier_id, data.cost);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_qty_stock_out() {

        Window p = (Window) this;
        Dlg_stock_out nd = Dlg_stock_out.create(p, true);
        nd.setTitle("Prompt");
        nd.do_pass(tf_desc1.getText(), tf_selling_price.getText());
        nd.do_pass2();
        nd.setCallback(new Dlg_stock_out.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_stock_out.OutputData data) {
                closeDialog.ok();
                do_update_qty_stock_out(data.qty, data.supplier_id, data.remarks);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_vat() {
        Window p = (Window) this;
        Dlg_vat nd = Dlg_vat.create(p, true);
        nd.setTitle("Vat");
        nd.do_pass(lb_vat.getText());
        nd.setCallback(new Dlg_vat.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_vat.OutputData data) {
                closeDialog.ok();
//                do_update_qty(data.qty, data.supplier_id);
                do_update_vat(data.args);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_update_vat(String name) {
        S10_update_product.do_update_product_vat(name, lb_name.getText());
        lb_vat.setText(name);
        ok1();
    }

    private void do_update_qty(double qty, String supplier_id, double cost) {
        double current_qty = qty;
        double new_qty = Double.parseDouble(qty1) + qty;
//        double new_qty = qty;
        tf_qty.setText("" + new_qty);
        tf_selling_price.setText("" + cost);
        S10_update_product.do_update_qty_stock_out(lb_name.getText(), new_qty, supplier_id, lb_name.getText(), desc1, price1, cost, current_qty);
        ok1();
    }

    private void do_update_qty_stock_out(double qty, String supplier_id, String remarks) {
        double new_qty = Double.parseDouble(tf_qty.getText()) - qty;
        tf_qty.setText("" + new_qty);
        S10_update_product.do_update_qty(lb_name.getText(), new_qty, supplier_id, lb_name.getText(), desc1, price1, remarks);
        ok1();

    }

    private void ok1() {
//        String types = cb_type.getSelectedItem().toString();
//        String types_num = S10_update_product.get_category_idss(types);
//        System.out.println(types + " " + types_num);
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData("", "", "", "", ""));
        }
    }

    private void ok2() {
        String types = "0";
        if (cb_type.getItemCount() == 0) {
            types = "0";
        } else {
            types = cb_type.getSelectedItem().toString();
        }
        String barcode = lb_name.getText();
        String types_num = S10_update_product.get_category_idss(types);
        String category_name = cb_category.getSelectedItem().toString();
        final String cat_id = S10_update_product.get_classid(category_name);
        System.out.println(types + " " + types_num);
        String assembly = "";

        if (cx_default.isSelected()) {
            assembly = "0";
        }
        if (cx_assemble.isSelected()) {
            assembly = "1";
        }
        if (cx_list.isSelected()) {
            assembly = "2";
        }
        if (callback != null) {
            callback.o2(new CloseDialog(this), new OutputData(types, types_num, barcode, cat_id, assembly));
        }
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
        tbl_employee_payroll_ALM.clear();
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

    private void data_uom() {


        loadData_uom(S7_uom.ret_data(name1));
    }

    private void data_uom2(String name, double qty) {
//        List<S7_uom.to_product_uom> datas = new ArrayList();
////        String date = lb_date_baptism.getText();
////        String name = tf_searc.getText();
//        S7_uom.to_product_uom to = new S7_uom.to_product_uom("0", name, qty, "0");
//        datas.add(to);
        S7_uom.add_product_uom(name, qty, lb_name.getText());
        loadData_uom(S7_uom.ret_data(lb_name.getText()));
    }

    private void add_uom() {
        Window p = (Window) this;
        Dlg_add_uom nd = Dlg_add_uom.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_add_uom.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_uom.OutputData data) {
                closeDialog.ok();
                data_uom2(data.name, data.qty);
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
        final String id = tbl_uom.getModel().getValueAt(idx, 0).toString();
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
                set_val(data, id);
                loadData_uom(S7_uom.ret_data(lb_name.getText()));
            }
        });
        Center.setCenter(nd);
//        Application.locateOnParentCenter(p, nd);

        nd.setVisible(true);


    }

    private void set_val(Dlg_add_uom.OutputData data, String id) {
        S7_uom.edit_product_uom(lb_name.getText(), data.qty, id);

//        int idx = tbl_uom.getSelectedRow();
//        if (idx < 0) {
//            return;
//        }
//
//        S7_uom.to_product_uom order = (S7_uom.to_product_uom) tbl_employee_payroll_ALM.get(tbl_uom.convertRowIndexToModel(idx));
//        order.setUom(data.name);
//        order.setUom_amount(data.qty);
//
//        tbl_employee_payroll_M.fireTableDataChanged();
//
//        tbl_uom.getSelectionModel().setSelectionInterval(idx, idx);
//        HelpScrollToView.view(idx, tbl_uom);


    }

    private void do_remove() {
        int[] idx = tbl_uom.getSelectedRows();

        List rem = new ArrayList();
        final List<String> id = new ArrayList();
        for (int ix : idx) {
            if (tbl_uom.isRowSelected(ix)) {
                String i = tbl_uom.getModel().getValueAt(ix, 0).toString();
                id.add(i);
//                int mx = tbl_uom.convertRowIndexToModel(ix);
//                rem.add(tbl_employee_payroll_ALM.get(mx));
            }
        }

        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                delete_uom(id);
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);

//        tbl_employee_payroll_ALM.removeAll(rem);
//        tbl_employee_payroll_M.fireTableDataChanged();
    }

    private void delete_uom(List<String> datas) {
        if (datas.isEmpty()) {
        } else {
            for (String a : datas) {
                S7_uom.delete_product_uom(a);
            }
            Prompt.call("Successfully Deleted");

        }
        loadData_uom(S7_uom.ret_data(lb_name.getText()));
    }

    private void assembly() {
        Window p = (Window) this;
        Dlg_add_assembly nd = Dlg_add_assembly.create(p, true);
        nd.setTitle("");
        nd.do_pass(lb_name.getText());
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
        String ref = lb_name.getText();
        loadData_assembly_e(S2_assembly.ret_data(ref));
    }
}
