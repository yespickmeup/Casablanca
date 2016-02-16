/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.remitances;

import POS.Main.MyDB;
import POS.dlg2.Dlg_confirm;
import POS.remitances.S1_remitances.to_remitances;
import POS.svc.S11_cash_out;
import POS.svc2.S12_cashier_sessions;
import POS.utl.DateType;
import POS.utl.Prompt;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author i1
 */
public class Dlg_remit extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_remit
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
    private Dlg_remit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_remit(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_remit() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_remit myRef;

    private void setThisRef(Dlg_remit myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_remit> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_remit create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_remit create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_remit dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_remit((java.awt.Frame) parent, false);
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
            Dlg_remit dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_remit((java.awt.Dialog) parent, false);
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


        Dlg_remit dialog = Dlg_remit.create(new javax.swing.JFrame(), true);
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

        pm_set = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_remitances = new javax.swing.JTable();
        dp_date = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        tf_user = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();

        jMenuItem1.setText("EDIT");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        pm_set.add(jMenuItem1);

        jMenuItem2.setText("DELETE");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        pm_set.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_remitances.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_remitances.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_remitancesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_remitancesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_remitancesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_remitances);

        dp_date.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("USER NAME:");

        tf_user.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CHOOSE REMIT DATE:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("PASSWORD:");

        tf_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("AMOUNT:");

        tf_amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REMITANCES");
        jLabel5.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("SEARCH NAME:");

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(dp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(70, 70, 70)
                                .addComponent(tf_search)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(tf_user, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_password, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dp_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap(21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        data_cols();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        edd();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        delete();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tbl_remitancesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_remitancesMousePressed
        pm_tbl_menu(evt);
    }//GEN-LAST:event_tbl_remitancesMousePressed

    private void tbl_remitancesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_remitancesMouseReleased
        pm_tbl_menu(evt);
    }//GEN-LAST:event_tbl_remitancesMouseReleased

    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        add();
    }//GEN-LAST:event_tf_passwordActionPerformed

    private void tbl_remitancesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_remitancesMouseClicked
        edit();
    }//GEN-LAST:event_tbl_remitancesMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dp_date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu pm_set;
    private javax.swing.JTable tbl_remitances;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        MyDB.setNames("db_pos_restaurant");
        tf_search.grabFocus();
        jLabel1.setVisible(false);
        tf_user.setVisible(false);
        jLabel3.setVisible(false);
        tf_password.setVisible(false);

        dp_date.setDate(new Date());
        init_key();
        init_tbl_remitances();
        data_cols();
        dp_date.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                data_cols();
            }
        });
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
    private ArrayListModel tbl_remitances_ALM;
    private TblremitancesModel tbl_remitances_M;

    private void init_tbl_remitances() {
        tbl_remitances_ALM = new ArrayListModel();
        tbl_remitances_M = new TblremitancesModel(tbl_remitances_ALM);
        tbl_remitances.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_remitances.setModel(tbl_remitances_M);
        tbl_remitances.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_remitances.setRowHeight(25);
        int[] tbl_widths_remitances = {0, 0, 100, 0, 0, 0};
        for (int i = 0, n = tbl_widths_remitances.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_remitances, i, tbl_widths_remitances[i]);
        }
        Dimension d = tbl_remitances.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_remitances.getTableHeader().setPreferredSize(d);
        tbl_remitances.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_remitances.setRowHeight(35);
        tbl_remitances.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_remitances(List<to_remitances> acc) {
        tbl_remitances_ALM.clear();
        tbl_remitances_ALM.addAll(acc);
    }

    public static class TblremitancesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "user_id", "USER NAME", "user_lvl", "REMITANCE", "date_added"
        };

        public TblremitancesModel(ListModel listmodel) {
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
            to_remitances tt = (to_remitances) getRow(row);
            switch (col) {
            case 0:
                return tt.id;
            case 1:
                return tt.user_id;
            case 2:
                return tt.user_name;
            case 3:
                return tt.user_lvl;
            case 4:
                return tt.amount;
            default:
                return tt.date_added;
            }
        }
    }

    private void data_cols() {
        String search = tf_search.getText();
        String date = DateType.sf.format(dp_date.getDate());
        loadData_remitances(S1_remitances.ret_data2(search, date));
    }

    private void add() {
        String user = tf_user.getText();
//        String password = tf_password.getText();
//        double am = FitIn.toDouble(tf_amount.getText());
//        if (am == 0) {
////            return;
//        }
//
//        String[] lvl = S1_remitances.user_checker(user, password);
//        if (lvl[1].equals("5") || lvl[1].equals("6")) {
//        } else {
//            Prompt.call("Wrong UserName/Password");
//            tf_user.setText("");
//            tf_password.setText("");
//            tf_amount.setText("");
//            return;
//        }
//        int id = FitIn.toInt(lvl[0]);
//        String user_id = "" + lvl[0];
//        String user_name = user;
//        String user_lvl = "" + lvl[1];
//        double amount = am;
//        String date_added = DateType.datetime.format(new Date());
//
//        String version = System.getProperty("version", "resto");
//        if (version.equals("resto")) {
//        }
//        S1_remitances.to_remitances to = new to_remitances(id, user_id, user_name, user_lvl, amount, date_added, lvl[2]);
//        S1_remitances.add_data(to);
//        data_cols();
//        tf_user.setText("");
//        tf_password.setText("");
//        tf_amount.setText("");

        int idx = tbl_remitances.getSelectedRow();
        if (idx < 0) {
            return;
        }
        double am = FitIn.toDouble(tf_amount.getText());
        if (am == 0) {
//            return;
        }

        final to_remitances to = (to_remitances) tbl_remitances_ALM.get(tbl_remitances.convertRowIndexToModel(idx));
        int id = to.id;
        double amount = FitIn.toDouble(tf_amount.getText());

        final int ses_id = S12_cashier_sessions.get_cashier_ses_id(to.user_name);

        if (amount == 0) {
            JOptionPane.showMessageDialog(null, "Input Amount");
            return;
        }
        S11_cash_out.p_cash_count(ses_id, amount, 0);

        S12_cashier_sessions.update_sessions(to.user_name);
        data_cols();
        tf_user.setText("");
        tf_password.setText("");
        tf_amount.setText("");
        JOptionPane.showMessageDialog(null, "Successfully Added");
    }

    private void edit() {
        int idx = tbl_remitances.getSelectedRow();
        if (idx < 0) {
            return;
        }
        double am = FitIn.toDouble(tf_amount.getText());
        if (am == 0) {
//            return;
        }

        final to_remitances to = (to_remitances) tbl_remitances_ALM.get(tbl_remitances.convertRowIndexToModel(idx));
        int id = to.id;
        String user_id = to.user_id;
        String user_name = to.user_name;
        String user_lvl = to.user_lvl;
        double amount = am;
        tf_amount.setText("" + to.amount);
        tf_user.setText("" + to.user_name);
//        String date_added = DateType.datetime.format(new Date());
//
//        S1_remitances.to_remitances to1 = new to_remitances(id, user_id, user_name, user_lvl, amount, date_added);
//        S1_remitances.edit_data(to);
//        data_cols();
    }

    private void edd() {
        int idx = tbl_remitances.getSelectedRow();
        if (idx < 0) {
            return;
        }
        double am = FitIn.toDouble(tf_amount.getText());
        if (am == 0) {
//            return;
        }

        final to_remitances to = (to_remitances) tbl_remitances_ALM.get(tbl_remitances.convertRowIndexToModel(idx));
        int id = to.id;
        String user_id = to.user_id;
        String user_name = to.user_name;
        String user_lvl = to.user_lvl;
        double amount = am;
        String date_added = DateType.datetime.format(new Date());
        String screen_name = to.screen_name;
        String user = tf_user.getText();
        String password = tf_password.getText();
        String[] lvl = S1_remitances.user_checker(user, password);
        if (lvl[1].equals("5") || lvl[1].equals("6")) {
        } else {
            Prompt.call("Wrong UserName/Password");
            tf_user.setText("");
            tf_password.setText("");
            tf_amount.setText("");
            return;
        }


        S1_remitances.to_remitances to1 = new to_remitances(id, user_id, user_name, user_lvl, amount, date_added, screen_name);
        S1_remitances.edit_data(to1);
        data_cols();
        tf_user.setText("");
        tf_password.setText("");
        tf_amount.setText("");
    }

    private void delete() {
        final int idx = tbl_remitances.getSelectedRow();
        if (idx < 0) {
            return;
        }

        Window p = (Window) this;
        Dlg_confirm nd = Dlg_confirm.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_confirm.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm.Data data) {
                closeDialog.ok();
                final to_remitances to = (to_remitances) tbl_remitances_ALM.get(tbl_remitances.convertRowIndexToModel(idx));
                S1_remitances.delete_data(to);
                data_cols();
            }

            @Override
            public void cancel(CloseDialog closeDialog) {
                closeDialog.ok();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);


    }

    private void pm_tbl_menu(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_set.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
}
