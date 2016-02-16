/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_dlg4;

import POS.dlg.Dlg_quantity;
import POS.svc3.S10_update_product;
import POS.svc3.S9_add_product;
import POS.to2.to_add_product;
import POS.utl.Center;
import POS.utl.TableUtility;
import POS_svc3.S4_endorsements;
import POS.category_types.S1_categories;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author dummy
 */
public class Dlg_direct_sales extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_direct_sales
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
    private Dlg_direct_sales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_direct_sales(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_direct_sales() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_direct_sales myRef;

    private void setThisRef(Dlg_direct_sales myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_direct_sales> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_direct_sales create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_direct_sales create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_direct_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_direct_sales((java.awt.Frame) parent, false);
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
            Dlg_direct_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_direct_sales((java.awt.Dialog) parent, false);
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


        Dlg_direct_sales dialog = Dlg_direct_sales.create(new javax.swing.JFrame(), true);
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
        tbl_prod = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cb_category = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dp_date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_prod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PRODUCT NAME", "DESCRIPTION", "Unit Price", "QTY"
            }
        ));
        tbl_prod.setFocusable(false);
        tbl_prod.setRowHeight(30);
        tbl_prod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_prod);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 193, 1180, 450));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("DIRECT SALES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1330, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("CHOOSE DATE OF SALES:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 270, 40));

        tf_search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });
        jPanel1.add(tf_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 510, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 560, 69, 52));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CLOSE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 630, 57, -1));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 480, 74, 52));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DOWN");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 460, 58, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("UP");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 360, 52, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 300, 74, 52));

        cb_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_category.setFocusable(false);
        cb_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_categoryMouseClicked(evt);
            }
        });
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });
        jPanel1.add(cb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 370, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("SEARCH:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/sales.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/sales-MO.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/sales-MO.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 140, 76, 52));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("SALES");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 200, 60, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("CATEGORY:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 130, 40));

        dp_date.setFocusable(false);
        dp_date.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jPanel1.add(dp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 210, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_prodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prodMouseClicked
        // TODO add your handling code here:
//        set_category();
        do_direct_sales();
    }//GEN-LAST:event_tbl_prodMouseClicked

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_employee_category();

    }//GEN-LAST:event_tf_searchKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        do_down();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        do_up();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_categoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_categoryMouseClicked

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        // TODO add your handling code here:
//        cb_type();
        data_employee_category1();
//        set_category();
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        sales();
    }//GEN-LAST:event_jButton5ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_category;
    private com.toedter.calendar.JDateChooser dp_date;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_prod;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        dp_date.setDate(new Date());
        init_key();
        cb_model();
        init_tbl_baptism();
        data_employee_category1();
    }

    private void cb_model() {

        cb_category.setModel(new ListComboBoxModel(S1_categories.ret_categories_for_cb()));


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

    private void do_down() {

//            tbl_endorsements.scrollRectToVisible(tbl_endorsements.getCellRect(j, 0, false));
        jScrollPane1.transferFocusDownCycle();
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getValue() + jScrollPane1.getVerticalScrollBar().getBlockIncrement() + 20);

//      
    }

    private void do_up() {

        jScrollPane1.transferFocusUpCycle();
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getValue() - jScrollPane1.getVerticalScrollBar().getBlockIncrement() - 20);


    }
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);
        tbl_prod.getTableHeader().setPreferredSize(new Dimension(100, 30));

        tbl_prod.setModel(tbl_employee_payroll_M);
        tbl_prod.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_prod.setRowHeight(40);

        tbl_prod.getTableHeader().setPreferredSize(new Dimension(100, 30));
//        tbl_prod.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 300, 100, 100, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }


            TableWidthUtilities.setColumnWidth(tbl_prod, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        TableUtility.align_row_to_left(tbl_prod, 1);
        TableUtility.align_row_to_right(tbl_prod, 2);
        TableUtility.align_row_to_Center(tbl_prod, 3);
//        TableUtility.align_column_to_Center(tbl_prod, 2);
//        TableUtility.align_column_to_Center(tbl_prod, 3);

        tbl_prod.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_prod.setRowHeight(40);
        tbl_prod.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_baptism(List<to_add_product> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "PRODUCT CODE", "DESCRIPTION", "PRICE", "QUANTITY", "num", "VAT", "category_id", "is_linient", "w_comm", "amount", "cat_id"
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
            to_add_product tt = (to_add_product) getRow(row);

            switch (col) {
            case 0:
                return tt.name;
            case 1:
                return tt.desc;

            case 2:
                return FitIn.fmt_wc_0(tt.price);

            case 3:
                return tt.qty;
            case 4:
                return tt.num;
            case 5:
                return tt.vat;
            case 6:
                return tt.category_id;
            case 7:
                return tt.is_linient;
            case 8:
                return tt.w_commission;
            case 9:
                return tt.comm_amount;

            default:
                return tt.cat_id;
            }
        }
    }

    private void data_employee_category() {

        String name = tf_search.getText();
        loadData_baptism(S9_add_product.ret_products_search_like("", name));

    }

    private void do_direct_sales() {
        int row = tbl_prod.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String code = tbl_prod.getModel().getValueAt(row, 0).toString();
        String uom = "pcs";
        final String name = tbl_prod.getModel().getValueAt(row, 1).toString();
        final String cat_id = tbl_prod.getModel().getValueAt(row, 10).toString();
        final double price = Double.parseDouble(tbl_prod.getModel().getValueAt(row, 2).toString());
        double qty = Double.parseDouble(tbl_prod.getModel().getValueAt(row, 3).toString());
// "PRODUCT CODE", "DESCRIPTION", "PRICE", "QUANTITY", "num", "VAT", "category_id", "is_linient", "w_comm", "amount", "cat_id"


        Window w = (Window) this;
        Dlg_quantity d = Dlg_quantity.create(w, true);
        d.setTitle("Put Kilo " + name);
        d.load(new Dlg_quantity.InputData(uom, price, name, qty, code));
        d.setCallback(new Dlg_quantity.Callback() {

            @Override
            public void ok(CloseDialog cd, Dlg_quantity.OutputData data) {
                cd.ok();

                add_sales(code, name, price, data.order.quantity, cat_id);
                data_employee_category();
            }
        });
        Application.locateOnParentCenter(w, d);
        d.setVisible(true);
    }

    private void add_sales(String code, String name, double price, double quantity, String cat_id) {

        S4_endorsements.add_direct_sales(code, name, price, quantity, cat_id, dp_date.getDate());

    }

    private void data_employee_category1() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
//        int row = cb_type.getItemCount();
//        System.out.println(row);
//        if (row == 0) {
//            tbl_employee_payroll_ALM.clear();
//            tbl_employee_payroll_M.fireTableDataChanged();
//            return;
//        }


        if (cb_category.getItemCount() == 0) {
            return;
        }

        String category_name = cb_category.getSelectedItem().toString();
        final String cat_id = S10_update_product.get_classid(category_name);

        String name = tf_search.getText();



        loadData_baptism(S9_add_product.ret_products_category(cb_category.getSelectedItem().toString(), name, cat_id));



    }

    private void sales() {
        Window p = (Window) this;
        Dlg_sales nd = Dlg_sales.create(p, true);
        nd.setTitle("");
        nd.do_pass("1");
        nd.do_pass2();
        nd.setCallback(new Dlg_sales.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_sales.OutputData data) {
//                closeDialog.ok();
                data_employee_category();
                ok1();
            }

            @Override
            public void charges(CloseDialog closeDialog, Dlg_sales.OutputData2 data) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
