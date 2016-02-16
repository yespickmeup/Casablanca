/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg2;

import POS.Main;
import POS.inventory.Dlg_printing_assembly;
import POS.inventory.S5_printing_assemlby;
import POS.utl.TableUtility;
import POS.category_types.S1_categories;
import POS_svc4.S1_update_category;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import POS.utl.Center;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Dummy
 */
public class Dlg_category extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_category
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
    private Dlg_category(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_category(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_category() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_category myRef;

    private void setThisRef(Dlg_category myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_category> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_category create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_category create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_category dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_category((java.awt.Frame) parent, false);
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
            Dlg_category dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_category((java.awt.Dialog) parent, false);
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


        Dlg_category dialog = Dlg_category.create(new javax.swing.JFrame(), true);
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

        pm_open_item = new javax.swing.JPopupMenu();
        category_group = new javax.swing.JMenu();
        cg_foods = new javax.swing.JCheckBoxMenuItem();
        cg_beverages = new javax.swing.JCheckBoxMenuItem();
        assembly = new javax.swing.JMenuItem();
        open_item = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cat = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        category_group.setText("GROUP");

        cg_foods.setSelected(true);
        cg_foods.setText("FOODS");
        cg_foods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cg_foodsActionPerformed(evt);
            }
        });
        category_group.add(cg_foods);

        cg_beverages.setSelected(true);
        cg_beverages.setText("BEVERAGE");
        cg_beverages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cg_beveragesActionPerformed(evt);
            }
        });
        category_group.add(cg_beverages);

        pm_open_item.add(category_group);

        assembly.setText("PRINTING ASSEMBLY");
        assembly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assemblyActionPerformed(evt);
            }
        });
        pm_open_item.add(assembly);

        open_item.setSelected(true);
        open_item.setText("OPEN ITEM");
        open_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_itemActionPerformed(evt);
            }
        });
        pm_open_item.add(open_item);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_cat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "NAME"
            }
        ));
        tbl_cat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_catMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_catMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 470, 440));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/delete-minus.png"))); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 120, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add32x32.png"))); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 120, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/edit-pencil.png"))); // NOI18N
        jButton3.setText("EDIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 120, 40));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("CATEGORY");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 630, 60));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close32x32.png"))); // NOI18N
        jButton4.setText("CLOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        do_delete_category();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        edit_category();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_catMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_catMousePressed
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_catMousePressed

    private void tbl_catMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_catMouseReleased
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_catMouseReleased

    private void open_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_itemActionPerformed
        update_open_item();
    }//GEN-LAST:event_open_itemActionPerformed

    private void assemblyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assemblyActionPerformed
        printing_assembly();
    }//GEN-LAST:event_assemblyActionPerformed

    private void cg_foodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cg_foodsActionPerformed
        update_group();
    }//GEN-LAST:event_cg_foodsActionPerformed

    private void cg_beveragesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cg_beveragesActionPerformed
       update_group2();
    }//GEN-LAST:event_cg_beveragesActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem assembly;
    private javax.swing.JMenu category_group;
    private javax.swing.JCheckBoxMenuItem cg_beverages;
    private javax.swing.JCheckBoxMenuItem cg_foods;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBoxMenuItem open_item;
    private javax.swing.JPopupMenu pm_open_item;
    private javax.swing.JTable tbl_cat;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_casablanca");
        init_tbl_baptism();
        data_employee();
    }

    public void do_pass(String name) {
    }
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);


        tbl_cat.getTableHeader().
                setPreferredSize(new Dimension(100, 30));
        tbl_cat.setModel(tbl_employee_payroll_M);
        tbl_cat.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_cat.setRowHeight(25);

//        tbl_cat.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {400, 0, 0, 0, 0, 0};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_cat, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }
        TableUtility.align_row_to_Center(tbl_cat, 0);

        tbl_cat.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_cat.setRowHeight(35);
        tbl_cat.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_baptism(List<S1_categories.to_name_cat> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "DESCRIPTION", "num", "img path", "open item", "printing_assembly", "group_id"
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
            S1_categories.to_name_cat tt = (S1_categories.to_name_cat) getRow(row);

            switch (col) {
                case 0:
                    return tt.name;
                case 1:
                    return tt.num;
                case 2:
                    return tt.img_path;
                case 3:
                    return tt.open_item;
                case 4:
                    return tt.printing_assembly;
                default:
                    return tt.group_id;
            }
        }
    }

    private void data_employee() {
//        String date = lb_date_baptism.getText();
//        String name = tf_searc.getText();
        loadData_baptism(S1_categories.ret_categories_others(""));
    }

    private void add() {
        Window p = (Window) this;
        Dlg_name_pic nd = Dlg_name_pic.create(p, true);
        nd.setTitle("");
        nd.do_pass("", "");
        nd.setCallback(new Dlg_name_pic.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_name_pic.OutputData data) {
                closeDialog.ok();
                add_category(data.name, data.img_name);
                data_employee();
                ok1();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_open_item() {
        int idx = tbl_cat.getSelectedRow();
        if (idx < 0) {
            return;
        }
        final S1_categories.to_name_cat to = (S1_categories.to_name_cat) tbl_employee_payroll_ALM.
                get(tbl_cat.convertRowIndexToModel(idx));

        int open_items = 0;
        if (open_item.isSelected()) {
            open_items = 1;
        } else {
            open_items = 0;
        }
        S1_categories.update_open_item(to.num, open_items);
        data_employee();
    }

    private void update_group() {
        int idx = tbl_cat.getSelectedRow();
        if (idx < 0) {
            return;
        }
        final S1_categories.to_name_cat to = (S1_categories.to_name_cat) tbl_employee_payroll_ALM.
                get(tbl_cat.convertRowIndexToModel(idx));

        int open_items = 0;
       
        S1_categories.update_group_id(to.num, open_items);
        data_employee();
    }

    private void update_group2() {
        int idx = tbl_cat.getSelectedRow();
        if (idx < 0) {
            return;
        }
        final S1_categories.to_name_cat to = (S1_categories.to_name_cat) tbl_employee_payroll_ALM.
                get(tbl_cat.convertRowIndexToModel(idx));

        int open_items = 1;
        
        S1_categories.update_group_id(to.num, open_items);
        data_employee();
    }
    
    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            int idx = tbl_cat.getSelectedRow();
            if (idx < 0) {
                return;
            }
            pm_open_item.removeAll();

            final S1_categories.to_name_cat to = (S1_categories.to_name_cat) tbl_employee_payroll_ALM.
                    get(tbl_cat.convertRowIndexToModel(idx));

            if (to.open_item == 0) {
                open_item.setSelected(false);
            } else {
                open_item.setSelected(true);
            }

            if (to.group_id == 0) {
                cg_foods.setSelected(true);
                cg_beverages.setSelected(false);
            } else {
                cg_foods.setSelected(false);
                cg_beverages.setSelected(true);
            }


            pm_open_item.add(category_group);
            pm_open_item.add(assembly);
            pm_open_item.add(open_item);
            JMenu jm = new javax.swing.JMenu();
            jm.setText("ASSEMBLY");

            List<S5_printing_assemlby.to_printing_assembly> datas = new ArrayList();

            datas = S5_printing_assemlby.ret_data("");

            for (final S5_printing_assemlby.to_printing_assembly to2 : datas) {
                final JCheckBoxMenuItem p = new javax.swing.JCheckBoxMenuItem();
                p.setText(to2.place);
                if (to2.id == to.printing_assembly) {
                    p.setSelected(true);
                } else {
                    p.setSelected(false);
                }
                p.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        S5_printing_assemlby.
                                update_category_printing_assembly_item(to.num, to2.id);
//                        Prompt.call("Updated Successfully");
//                        data_employee_search();
                        data_employee();
                    }
                });
                jm.add(p);
            }
            pm_open_item.add(jm);
            pm_open_item.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void ok1() {
        if (callback != null) {

            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void add_category(String name, String img_path) {
        S1_categories.add_category(name, img_path);
    }

    private void edit_category() {

        int row = tbl_cat.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String name = tbl_cat.getModel().
                getValueAt(row, 0).
                toString();
        final String num = tbl_cat.getModel().
                getValueAt(row, 1).
                toString();
        final String img_path = tbl_cat.getModel().
                getValueAt(row, 2).
                toString();

        Window p = (Window) this;
        Dlg_name_pic nd = Dlg_name_pic.create(p, true);
        nd.setTitle("");
//        nd.pass(date);
        nd.do_pass(name, img_path);
        nd.setCallback(new Dlg_name_pic.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_name_pic.OutputData data) {
                closeDialog.ok();
                do_edit_category(data.name, num, data.img_name);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_edit_category(String name, String num, String img_path) {
        S1_update_category.do_edit(name, num, img_path);
        data_employee();
        ok1();
    }

    private void do_delete_category() {
        int row = tbl_cat.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String name = tbl_cat.getModel().
                getValueAt(row, 0).
                toString();
        final String num = tbl_cat.getModel().
                getValueAt(row, 1).
                toString();
        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//         nd.do_pass("");
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                S1_update_category.do_delete_category(num);
                data_employee();
                ok1();
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
//        S1_update_category.do_delete_category(num);
//        data_employee();
//        ok1();

    }

    private void printing_assembly() {
        Window p = (Window) this;
        Dlg_printing_assembly nd = Dlg_printing_assembly.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_printing_assembly.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_printing_assembly.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
    }
}
