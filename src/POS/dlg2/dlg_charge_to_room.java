/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg2;

import POS.Main;
import POS.dlg2.S1_charge_to_room.to_tables;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Dummy
 */
public class dlg_charge_to_room extends javax.swing.JDialog {

    /**
     * Creates new form dlg_charge_to_room
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

        public final String table_id;
        public final String table_name;
        public final String guest_id;
        public final String guest_name;

        public OutputData(String table_id, String table_name, String guest_id, String guest_name) {
            this.table_id = table_id;
            this.table_name = table_name;
            this.guest_id = guest_id;
            this.guest_name = guest_name;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private dlg_charge_to_room(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private dlg_charge_to_room(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public dlg_charge_to_room() {
        super();
        initComponents();
        myInit();

    }
    private dlg_charge_to_room myRef;

    private void setThisRef(dlg_charge_to_room myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, dlg_charge_to_room> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static dlg_charge_to_room create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static dlg_charge_to_room create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            dlg_charge_to_room dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new dlg_charge_to_room((java.awt.Frame) parent, false);
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
            dlg_charge_to_room dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new dlg_charge_to_room((java.awt.Dialog) parent, false);
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


        dlg_charge_to_room dialog = dlg_charge_to_room.create(new javax.swing.JFrame(), true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tables = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_room_guests = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_tables.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_tables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tables);

        tbl_room_guests.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_room_guests);

        jButton1.setText("OK");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHOOSE TABLE AND GUEST");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ok1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_tablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablesMouseClicked
        data_guest();
    }//GEN-LAST:event_tbl_tablesMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_room_guests;
    private javax.swing.JTable tbl_tables;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        init_key();
        init_tbl_tables();
        data_cols();

        init_tbl_room_guests();
        data_guest();
    }

    public void do_pass() {
        data_cols();
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
    private ArrayListModel tbl_tables_ALM;
    private TbltablesModel tbl_tables_M;

    private void init_tbl_tables() {
        tbl_tables_ALM = new ArrayListModel();
        tbl_tables_M = new TbltablesModel(tbl_tables_ALM);
        tbl_tables.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_tables.setModel(tbl_tables_M);
        tbl_tables.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_tables.setRowHeight(25);
        int[] tbl_widths_tables = {0, 100, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_tables.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_tables, i, tbl_widths_tables[i]);
        }
        Dimension d = tbl_tables.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_tables.getTableHeader().
                setPreferredSize(d);
        tbl_tables.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_tables.setRowHeight(35);
        tbl_tables.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_tables(List<to_tables> acc) {
        tbl_tables_ALM.clear();
        tbl_tables_ALM.addAll(acc);
    }

    public static class TbltablesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "table_name", "rate", "rate_type", "percentage", "status"
        };

        public TbltablesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//            if (column == 1) {
//                return true;
//            }
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
            to_tables tt = (to_tables) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.table_name;
                case 2:
                    return tt.rate;
                case 3:
                    return tt.rate_type;
                case 4:
                    return tt.percentage;
                default:
                    return tt.status;
            }
        }
    }

    private void data_cols() {
        loadData_tables(S1_charge_to_room.ret_data(""));
    }
    private ArrayListModel tbl_room_guests_ALM;
    private Tblroom_guestsModel tbl_room_guests_M;

    private void init_tbl_room_guests() {
        tbl_room_guests_ALM = new ArrayListModel();
        tbl_room_guests_M = new Tblroom_guestsModel(tbl_room_guests_ALM);
        tbl_room_guests.getTableHeader().
                setPreferredSize(new Dimension(100, 40));
        tbl_room_guests.setModel(tbl_room_guests_M);
        tbl_room_guests.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_room_guests.setRowHeight(25);
        int[] tbl_widths_room_guests = {0, 0, 0, 100, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_room_guests.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_room_guests, i, tbl_widths_room_guests[i]);
        }
        Dimension d = tbl_room_guests.getTableHeader().
                getPreferredSize();
        d.height = 30;
        tbl_room_guests.getTableHeader().
                setPreferredSize(d);
        tbl_room_guests.getTableHeader().
                setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_room_guests.setRowHeight(35);
        tbl_room_guests.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_room_guests(List<S1_charge_to_room.to_room_guests> acc) {
        tbl_room_guests_ALM.clear();
        tbl_room_guests_ALM.addAll(acc);
    }

    public static class Tblroom_guestsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "rooom_id", "guest_id", "guest_name", "checkin_date", "checkout_date", "status", "to_pay", "paid", "room_rate"
        };

        public Tblroom_guestsModel(ListModel listmodel) {
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
            S1_charge_to_room.to_room_guests tt = (S1_charge_to_room.to_room_guests) getRow(row);
            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.rooom_id;
                case 2:
                    return tt.guest_id;
                case 3:
                    return tt.guest_name;
                case 4:
                    return tt.checkin_date;
                case 5:
                    return tt.checkout_date;
                case 6:
                    return tt.status;
                case 7:
                    return tt.to_pay;
                case 8:
                    return tt.paid;
                default:
                    return tt.room_rate;
            }
        }
    }

    private void data_guest() {
        int idx = tbl_tables.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.
                convertRowIndexToModel(idx));


        loadData_room_guests(S1_charge_to_room.ret_data_guest("" + to.id));
    }

    private void ok1() {
        int idx = tbl_tables.getSelectedRow();
        if (idx < 0) {
            return;
        }

        final to_tables to = (to_tables) tbl_tables_ALM.get(tbl_tables.
                convertRowIndexToModel(idx));

        int idx2 = tbl_room_guests.getSelectedRow();
        if (idx2 < 0) {
            return;
        }

        final S1_charge_to_room.to_room_guests to2 = (S1_charge_to_room.to_room_guests) tbl_room_guests_ALM.
                get(tbl_room_guests.convertRowIndexToModel(idx2));

        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData("" + to.id, to.table_name, "" + to2.guest_id, to2.guest_name));
        }
    }
}
