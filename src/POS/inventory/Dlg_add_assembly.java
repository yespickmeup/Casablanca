/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.*;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_add_assembly extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_add_assembly
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
    private Dlg_add_assembly(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_add_assembly(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_add_assembly() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_add_assembly myRef;

    private void setThisRef(Dlg_add_assembly myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_add_assembly> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_add_assembly create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_add_assembly create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_add_assembly dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_add_assembly((java.awt.Frame) parent, false);
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
            Dlg_add_assembly dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_add_assembly((java.awt.Dialog) parent, false);
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


        Dlg_add_assembly dialog = Dlg_add_assembly.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

        dialog.setSize(xSize, ySize);
        dialog.setVisible(true);
//        dialog.setVisible(true);

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

        pm_pop = new javax.swing.JPopupMenu();
        pm_edit = new javax.swing.JMenuItem();
        pm_delete = new javax.swing.JMenuItem();
        pm_added = new javax.swing.JPopupMenu();
        pm_a_edit = new javax.swing.JMenuItem();
        pm_a_delete = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_search = new javax.swing.JTable();
        tf_search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_entries = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_added = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        pm_edit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pm_edit.setText("EDIT");
        pm_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_editActionPerformed(evt);
            }
        });
        pm_pop.add(pm_edit);

        pm_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pm_delete.setText("DELETE");
        pm_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_deleteActionPerformed(evt);
            }
        });
        pm_pop.add(pm_delete);

        pm_a_edit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pm_a_edit.setText("EDIT");
        pm_a_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_a_editActionPerformed(evt);
            }
        });
        pm_added.add(pm_a_edit);

        pm_a_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pm_a_delete.setText("DELETE");
        pm_a_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_a_deleteActionPerformed(evt);
            }
        });
        pm_added.add(pm_a_delete);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_search.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_searchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_search);

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("SEARCH:");

        tbl_entries.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_entries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_entriesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_entriesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_entriesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_entries);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NEW ENTRIES:");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbl_added.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_added.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_addedMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_addedMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_addedMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_added);

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ADDED ENTRIES:");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setText("ADD BY LIST");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_search))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        data_cols();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void tbl_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_searchMouseClicked
        data_entries();
    }//GEN-LAST:event_tbl_searchMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add_data();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_entriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_entriesMouseClicked
    }//GEN-LAST:event_tbl_entriesMouseClicked

    private void tbl_addedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_addedMouseClicked
    }//GEN-LAST:event_tbl_addedMouseClicked

    private void pm_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_deleteActionPerformed
        delete_entry();
    }//GEN-LAST:event_pm_deleteActionPerformed

    private void pm_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_editActionPerformed
        edit_entry();
    }//GEN-LAST:event_pm_editActionPerformed

    private void tbl_entriesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_entriesMousePressed
        pm_tbl_entries(evt);
    }//GEN-LAST:event_tbl_entriesMousePressed

    private void tbl_entriesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_entriesMouseReleased
        pm_tbl_entries(evt);
    }//GEN-LAST:event_tbl_entriesMouseReleased

    private void pm_a_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_a_deleteActionPerformed
        delete_entry_assembly();
    }//GEN-LAST:event_pm_a_deleteActionPerformed

    private void pm_a_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_a_editActionPerformed
        edit_entry_assembly();
    }//GEN-LAST:event_pm_a_editActionPerformed

    private void tbl_addedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_addedMousePressed
        pm_tbl_added(evt);
    }//GEN-LAST:event_tbl_addedMousePressed

    private void tbl_addedMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_addedMouseReleased
        pm_tbl_added(evt);
    }//GEN-LAST:event_tbl_addedMouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        data_entries_list();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem pm_a_delete;
    private javax.swing.JMenuItem pm_a_edit;
    private javax.swing.JPopupMenu pm_added;
    private javax.swing.JMenuItem pm_delete;
    private javax.swing.JMenuItem pm_edit;
    private javax.swing.JPopupMenu pm_pop;
    private javax.swing.JTable tbl_added;
    private javax.swing.JTable tbl_entries;
    private javax.swing.JTable tbl_search;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_inventory2_stocks_left();
        init_tbl_assembly();
        init_tbl_assembly_entries();
        load_date_e();
    }
    String ref = "10";

    public void do_pass(String reference_no) {
        ref = reference_no;
        load_date_e();
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
    private ArrayListModel tbl_inventory2_stocks_left_ALM;
    private Tblinventory2_stocks_leftModel tbl_inventory2_stocks_left_M;

    private void init_tbl_inventory2_stocks_left() {
        tbl_inventory2_stocks_left_ALM = new ArrayListModel();
        tbl_inventory2_stocks_left_M = new Tblinventory2_stocks_leftModel(tbl_inventory2_stocks_left_ALM);
        tbl_search.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_search.setModel(tbl_inventory2_stocks_left_M);
        tbl_search.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_search.setRowHeight(25);
//        tbl_search.setAutoResizeMode(0);
        int[] tbl_widths_inventory2_stocks_left = {0, 0, 0, 0, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_inventory2_stocks_left.length; i < n; i++) {
            if (i == 4) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_search, i, tbl_widths_inventory2_stocks_left[i]);
        }
        Dimension d = tbl_search.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_search.getTableHeader().setPreferredSize(d);
        tbl_search.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_search.setRowHeight(35);
        tbl_search.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_inventory2_stocks_left(List<S2_assembly.to_inventory2_stocks_left> acc) {
        tbl_inventory2_stocks_left_ALM.clear();
        tbl_inventory2_stocks_left_ALM.addAll(acc);
    }

    public static class Tblinventory2_stocks_leftModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "lookup_code", "prod_num", "product_name", "Description", "PRICE", "QTY", "types", "types_num", "is_vat", "prod_assembly", "is_linient", "w_commission", "comm_amount", "cat_id", "cost", "img_path"
        };

        public Tblinventory2_stocks_leftModel(ListModel listmodel) {
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
            S2_assembly.to_inventory2_stocks_left tt = (S2_assembly.to_inventory2_stocks_left) getRow(row);
            switch (col) {
            case 0:
                return tt.id;
            case 1:
                return tt.lookup_code;
            case 2:
                return tt.prod_num;
            case 3:
                return tt.product_name;
            case 4:
                return tt.description;
            case 5:
                return tt.price;
            case 6:
                return tt.product_qty;
            case 7:
                return tt.types;
            case 8:
                return tt.types_num;
            case 9:
                return tt.is_vat;
            case 10:
                return tt.prod_assembly;
            case 11:
                return tt.is_linient;
            case 12:
                return tt.w_commission;
            case 13:
                return tt.comm_amount;
            case 14:
                return tt.cat_id;
            case 15:
                return tt.cost;
            default:
                return tt.img_path;
            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        loadData_inventory2_stocks_left(S2_assembly.ret_data_assembly(search));
    }
    private ArrayListModel tbl_assembly_ALM;
    private TblassemblyModel tbl_assembly_M;

    private void init_tbl_assembly() {
        tbl_assembly_ALM = new ArrayListModel();
        tbl_assembly_M = new TblassemblyModel(tbl_assembly_ALM);
        tbl_entries.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_entries.setModel(tbl_assembly_M);
        tbl_entries.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_entries.setRowHeight(25);
        int[] tbl_widths_assembly = {0, 0, 100, 100, 100, 0, 0};
        for (int i = 0, n = tbl_widths_assembly.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_entries, i, tbl_widths_assembly[i]);
        }
        Dimension d = tbl_entries.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_entries.getTableHeader().setPreferredSize(d);
        tbl_entries.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_entries.setRowHeight(35);
        tbl_entries.setFont(new java.awt.Font("Arial", 1, 12));
        tbl_entries.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }
        });

    }

    private void loadData_assembly(List<S2_assembly.to_assembly> acc) {
//        tbl_assembly_ALM.clear();
        tbl_assembly_ALM.addAll(acc);
    }

    public static class TblassemblyModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "prod_num", "description", "price", "product_qty", "ref_num", "status"
        };

        public TblassemblyModel(ListModel listmodel) {
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

    private void data_entries() {
        final List<S2_assembly.to_assembly> datas = new ArrayList();
        final int row = tbl_search.getSelectedRow();
        if (row < 0) {
            return;
        }
        final int id = FitIn.toInt(tbl_search.getModel().getValueAt(row, 0).toString());
        final int prod_num = FitIn.toInt(tbl_search.getModel().getValueAt(row, 3).toString());
        final String description = tbl_search.getModel().getValueAt(row, 4).toString();
        final double price = FitIn.toDouble(tbl_search.getModel().getValueAt(row, 5).toString());
        List<S2_assembly.to_assembly> data2 = tbl_assembly_e_ALM;
        for (S2_assembly.to_assembly to : data2) {
            if (description.equals(to.description)) {
                JOptionPane.showMessageDialog(null, "List Already Added");
                return;
            }
        }
        Window p = (Window) this;
        Dlg_number2 nd = Dlg_number2.create(p, true);
        nd.setTitle("");
        nd.do_pass("");
        nd.setCallback(new Dlg_number2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_number2.OutputData data) {
                closeDialog.ok();
                double product_qty = data.qty;
                String ref_num = ref;
                int status = 0;
                S2_assembly.to_assembly to = new S2_assembly.to_assembly(id, prod_num, description, price, product_qty, ref_num, status);
                datas.add(to);
                loadData_assembly(datas);
            }

            @Override
            public void cancel(CloseDialog closeDialog, Dlg_number2.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
//        Center.setCenter(nd);
        nd.setVisible(true);
    }

    private void data_entries_list() {
        final List<S2_assembly.to_assembly> datas = new ArrayList();
        final List<S2_assembly.to_assembly> data2 = tbl_assembly_e_ALM;

        Window p = (Window) this;
        Dlg_assembly_list nd = Dlg_assembly_list.create(p, true);
        nd.setTitle("");
//        nd.do_pass(""+de);
        nd.setCallback(new Dlg_assembly_list.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_assembly_list.OutputData data) {
                for (S2_assembly.to_assembly to : data2) {
                    if (data.to1.description.equals(to.description)) {
                        JOptionPane.showMessageDialog(null, "List Already Added");
                        return;
                    }
                }
                closeDialog.ok();
                S2_assembly.to_assembly to = new S2_assembly.to_assembly(data.to1.id, data.to1.prod_num, data.to1.description, data.to1.price, data.to1.product_qty, ref, data.to1.status);
                datas.add(to);
                loadData_assembly(datas);
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
//        Center.setCenter(nd);
        nd.setVisible(true);
    }

    private void edit_entry() {

        final int row = tbl_entries.getSelectedRow();
        if (row < 0) {
            return;
        }

        String qtyy = tbl_entries.getModel().getValueAt(row, 4).toString();
        int idx = tbl_entries.getSelectedRow();
        if (idx < 0) {
            return;
        }

        Window p = (Window) this;
        Dlg_number2 nd = Dlg_number2.create(p, true);
        nd.setTitle("");
        nd.do_pass(qtyy);
        nd.setCallback(new Dlg_number2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_number2.OutputData data) {
                closeDialog.ok();
                S2_assembly.to_assembly to_assembly = (S2_assembly.to_assembly) tbl_assembly_ALM.get(tbl_entries.convertRowIndexToModel(row));
                to_assembly.setProduct_qty(data.qty);
                tbl_assembly_M.fireTableDataChanged();
//                datas.add(to);
//                loadData_assembly(datas);
            }

            @Override
            public void cancel(CloseDialog closeDialog, Dlg_number2.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(jScrollPane2);
//        Center.setCenter(nd);
        nd.setVisible(true);
    }

    private void pm_tbl_entries(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    private ArrayListModel tbl_assembly_e_ALM;
    private TblassemblyeModel tbl_assembly_e_M;

    private void init_tbl_assembly_entries() {
        tbl_assembly_e_ALM = new ArrayListModel();
        tbl_assembly_e_M = new TblassemblyeModel(tbl_assembly_e_ALM);
        tbl_added.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_added.setModel(tbl_assembly_e_M);
        tbl_added.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_added.setRowHeight(25);
        int[] tbl_widths_assembly = {0, 0, 100, 100, 100, 0, 0};
        for (int i = 0, n = tbl_widths_assembly.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_added, i, tbl_widths_assembly[i]);
        }
        Dimension d = tbl_added.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_added.getTableHeader().setPreferredSize(d);
        tbl_added.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_added.setRowHeight(35);
        tbl_added.setFont(new java.awt.Font("Arial", 1, 12));
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
        loadData_assembly_e(S2_assembly.ret_data(ref));
        ok1();
    }

    private void add_data() {
        List<S2_assembly.to_assembly> datas = tbl_assembly_ALM;
        S2_assembly.add_assembly(datas);
        load_date_e();
        tbl_assembly_ALM.clear();
        tbl_assembly_M.fireTableDataChanged();
    }

    private void delete_entry() {
        int row = tbl_entries.getSelectedRow();
        if (row < 0) {
            return;
        }

        tbl_assembly_ALM.remove(row);
        tbl_assembly_M.fireTableDataChanged();
    }

    private void delete_entry_assembly() {
        int row = tbl_added.getSelectedRow();
        if (row < 0) {
            return;
        }


        int id = FitIn.toInt(tbl_added.getModel().getValueAt(row, 0).toString());
        int prod_num = FitIn.toInt(tbl_added.getModel().getValueAt(row, 3).toString());
        String description = tbl_added.getModel().getValueAt(row, 4).toString();
        double price = FitIn.toDouble(tbl_added.getModel().getValueAt(row, 5).toString());
        double product_qty = FitIn.toDouble(tbl_added.getModel().getValueAt(row, 6).toString());
        String ref_num = ref;
        int status = 0;
        S2_assembly.to_assembly to = new S2_assembly.to_assembly(id, prod_num, description, price, product_qty, ref_num, status);
        S2_assembly.delete_assembly(to);
        load_date_e();
    }

    private void pm_tbl_added(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_added.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void edit_entry_assembly() {
        int row = tbl_added.getSelectedRow();
        if (row < 0) {
            return;
        }


        final int id = FitIn.toInt(tbl_added.getModel().getValueAt(row, 0).toString());
        final int prod_num = FitIn.toInt(tbl_added.getModel().getValueAt(row, 3).toString());
        final String description = tbl_added.getModel().getValueAt(row, 4).toString();
        final double price = FitIn.toDouble(tbl_added.getModel().getValueAt(row, 5).toString());
        final double product_qty = FitIn.toDouble(tbl_added.getModel().getValueAt(row, 4).toString());
        final String ref_num = ref;
        final int status = 0;
        Window p = (Window) this;
        Dlg_number2 nd = Dlg_number2.create(p, true);
        nd.setTitle("");
        nd.do_pass("" + product_qty);
        nd.setCallback(new Dlg_number2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_number2.OutputData data) {
                closeDialog.ok();
                S2_assembly.to_assembly to = new S2_assembly.to_assembly(id, prod_num, description, price, data.qty, ref_num, status);
                S2_assembly.edit_assembly(to);
                load_date_e();
            }

            @Override
            public void cancel(CloseDialog closeDialog, Dlg_number2.OutputData data) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(jScrollPane3);

        nd.setVisible(true);
    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
}
