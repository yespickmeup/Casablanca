/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import POS.guests.Dlg_guest;
import POS.rooms.S1_check_in;
import POS.to.to_users;
import POS.utl.DateType;
import POS_svc4.S2_search;
import POS_svc4.S5_tables;
import de.jgrid.JGrid;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import POS.utl.Center;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
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
public class Dlg_check_liquid_2 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_check
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void check_in(CloseDialog closeDialog, OutputData data);

        void check_out(CloseDialog closeDialog, OutputData data);

        void order(CloseDialog closeDialog, OutputData data);

        void cancel(CloseDialog closeDialog, OutputData data);

        void add_guest(CloseDialog closeDialog, OutputData data);

        void set_order(CloseDialog closeDialog, OutputData data);

        void set_bill(CloseDialog closeDialog, OutputData data);

        void set_prepaid(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final List<Dlg_check_liquid_2.to_guests> to1;
        public final double percentages;

        public OutputData(List<Dlg_check_liquid_2.to_guests> to1, double percentages) {
            this.to1 = to1;
            this.percentages = percentages;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_check_liquid_2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_check_liquid_2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_check_liquid_2() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_check_liquid_2 myRef;

    private void setThisRef(Dlg_check_liquid_2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_check_liquid_2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_check_liquid_2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.APPLICATION_MODAL);

    }

    public static Dlg_check_liquid_2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_check_liquid_2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_check_liquid_2((java.awt.Frame) parent, false);
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
            Dlg_check_liquid_2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_check_liquid_2((java.awt.Dialog) parent, false);
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


        Dlg_check_liquid_2 dialog = Dlg_check_liquid_2.create(new javax.swing.JFrame(), true);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_p_check = new javax.swing.JButton();
        btn_p_order = new javax.swing.JButton();
        btn_p_cancel = new javax.swing.JButton();
        btn_prepaid = new javax.swing.JButton();
        btn_bill = new javax.swing.JButton();
        lbl_plus = new javax.swing.JLabel();
        btn_p_close1 = new javax.swing.JButton();
        btn_p_close = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_guest = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_p_check.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_check.setText("CHECK IN");
        btn_p_check.setFocusable(false);
        btn_p_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_checkActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 120, 40));

        btn_p_order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_order.setText("ORDER");
        btn_p_order.setFocusable(false);
        btn_p_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_orderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 160, 40));

        btn_p_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_cancel.setText("CLEAR");
        btn_p_cancel.setFocusable(false);
        btn_p_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 160, 40));

        btn_prepaid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_prepaid.setText("PREPAID");
        btn_prepaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prepaidActionPerformed(evt);
            }
        });
        getContentPane().add(btn_prepaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 160, 40));

        btn_bill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_bill.setText("BILL");
        btn_bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_billActionPerformed(evt);
            }
        });
        getContentPane().add(btn_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 160, 40));

        lbl_plus.setBackground(new java.awt.Color(255, 204, 204));
        lbl_plus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_plus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_plus.setText("+");
        lbl_plus.setToolTipText("");
        lbl_plus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_plus.setOpaque(true);
        lbl_plus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_plusMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 40, 40));

        btn_p_close1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_close1.setText("TRANSFER");
        btn_p_close1.setFocusable(false);
        btn_p_close1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_close1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 160, 40));

        btn_p_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_close.setText("CLOSE");
        btn_p_close.setFocusable(false);
        btn_p_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_closeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 160, 40));

        tbl_guest.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_guest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_guestMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_guest);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 280));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_p_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_closeActionPerformed
        disposed();
    }//GEN-LAST:event_btn_p_closeActionPerformed

    private void btn_p_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_checkActionPerformed
        check_in();
    }//GEN-LAST:event_btn_p_checkActionPerformed

    private void btn_p_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_orderActionPerformed
        order();
    }//GEN-LAST:event_btn_p_orderActionPerformed

    private void lbl_plusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_plusMouseClicked
        add_guests();
    }//GEN-LAST:event_lbl_plusMouseClicked

    private void btn_p_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_cancelActionPerformed
        void_order();
    }//GEN-LAST:event_btn_p_cancelActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    }//GEN-LAST:event_formMouseExited

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
    }//GEN-LAST:event_formFocusLost

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    }//GEN-LAST:event_formWindowLostFocus

    private void tbl_guestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestMouseClicked
        mouseover();
        set_order();
    }//GEN-LAST:event_tbl_guestMouseClicked

    private void btn_billActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_billActionPerformed
        bill();
    }//GEN-LAST:event_btn_billActionPerformed

    private void btn_prepaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prepaidActionPerformed
        advance();
    }//GEN-LAST:event_btn_prepaidActionPerformed

    private void btn_p_close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_close1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_p_close1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bill;
    private javax.swing.JButton btn_p_cancel;
    private javax.swing.JButton btn_p_check;
    private javax.swing.JButton btn_p_close;
    private javax.swing.JButton btn_p_close1;
    private javax.swing.JButton btn_p_order;
    private javax.swing.JButton btn_prepaid;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_plus;
    private javax.swing.JTable tbl_guest;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_tbl_tables();
//        sample();
    }

    private void sample() {
        tbl_tables_ALM.clear();
        List<Dlg_check_liquid_2.to_guests> tt = new ArrayList();
        tt = tbl_tables_ALM;

        for (int i = 0; i < 10; i++) {
            Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests("" + i, "Ronald Pascua" + i, false);
            tt.add(to);
        }

        loadData_tables(tt);
    }
    JGrid jg_orders1 = new JGrid();
    DefaultListModel orders_model1 = new DefaultListModel();
    ArrayListModel tbl_table_orders_ALM1;
    int row_selected = 0;
    String room_no = "";
    String type = "";
    double percentage = 0;

    public void do_pass2(JGrid jg_orders, DefaultListModel orders_model, int selected, String room, String types, double percent, String user_id, String status, ArrayListModel tbl_table_orders_ALM) {
        jg_orders1 = jg_orders;
        orders_model1 = orders_model;
        tbl_table_orders_ALM1 = tbl_table_orders_ALM;
        row_selected = selected;
        room_no = room;
        type = types;
        percentage = percent;
        int check_in = to_users.get_check_ins();
        int check_out = to_users.get_check_outs();
//        JOptionPane.showMessageDialog(null, orders_model1.size());
        set_order();
        final String version = System.getProperty("version", "ordering");
        if (version.equals("ordering") && user_id.equals("7") || version.equals("ordering") && user_id.equals("")) {
            if (btn_p_check.getText().
                    equals("TAKE-OUT")) {
                btn_p_check.setEnabled(true);
            } else {
                btn_p_check.setEnabled(false);
                btn_p_order.setEnabled(true);
            }
        }
        if (version.equals("ordering") && user_id.equals("0") || user.equals("6") || user.equals("5")) {
            if (btn_p_check.getText().
                    equals("TAKE-OUT")) {
                btn_p_check.setEnabled(true);
            } else {
                if (user_id.equals("0")) {
                    btn_p_order.setEnabled(true);
                    btn_p_check.setEnabled(false);
                } else {
//                    if (check_in == 1) {
//                        btn_p_order.setEnabled(false);
//                        btn_p_check.setEnabled(true);
//                        btn_p_check.setText("CHECK-IN");
//                    } else {
//                        btn_p_order.setEnabled(false);
//                        btn_p_check.setEnabled(true);
//                    }
                }



            }
        }

        if (status.equals("BUSY")) {
            btn_p_check.setEnabled(true);
        }
    }

    private void refresh_guest() {
        final String ui_items = System.getProperty("ui_items", "list");
        final String version = System.getProperty("version", "ordering");
        String name = "";
        if (version.equals("ordering")) {
            name = "TABLE";
        } else {
            name = "ROOM";
        }
        List<S5_tables.to_tables2> room = S5_tables.get_tables("");
//       
        Object value = new Object();
        if (ui_items.equals("list")) {
            tbl_table_orders_ALM1.clear();
        } else {
            orders_model1.clear();
            for (S5_tables.to_tables2 t : room) {
                S2_search.to_rooms to = new S2_search.to_rooms(t.no, name, "" + t.name, t.status, t.amount, t.guest_id, t.guest_name, t.date_added, t.name, t.rate, t.to_guest, t.rate_type, t.percentage, t.table_location_id);
                orders_model1.addElement(to);
            }

        }
//         JOptionPane.showMessageDialog(null, row_selected);
        value = orders_model1.getElementAt(row_selected);
        final S2_search.to_rooms t = (S2_search.to_rooms) value;
//        List<Dlg_check_liquid_2.to_guests> datas = t.to_guest;
//
//        for (Dlg_check_liquid_2.to_guests g : datas) {
//        }
        selected = -1;
//        do_pass(datas, t, user);
    }

    public static class to_guests {

        public final String id;
        public String name;
        public boolean status;

        public to_guests(String id, String name, boolean status) {
            this.id = id;
            this.name = name;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }
//    List<Dlg_check_liquid.to_guests> tbl_tables_ALM = new ArrayList();
    int selected = -1;

    private void mouseover() {
//

        int row = tbl_guest.getSelectedRow();
        if (row < 0) {
            return;
        }
        Dlg_check_liquid_2.to_guests to = (Dlg_check_liquid_2.to_guests) tbl_tables_ALM.get((row));
        if (to.status == true) {
            to.setStatus(false);
        } else {
            to.setStatus(true);
        }

        tbl_tables_M.fireTableDataChanged();
    }
    String user = "0";

    public void do_pass(List<Dlg_check_liquid_2.to_guests> tt, S2_search.to_rooms t, String user_lvl) {
        int check_in = to_users.get_check_ins();
        int check_out = to_users.get_check_outs();
        if (user_lvl.equals("7")) {
            user = "7";
            btn_p_check.setEnabled(false);
        } else if (user_lvl.equals("6")) {
            user = "6";
            btn_p_check.setEnabled(false);
        } else {
            user = "0";
            btn_p_check.setEnabled(true);
        }

        btn_prepaid.setEnabled(false);
        btn_bill.setEnabled(false);
//        JOptionPane.showMessageDialog(null, t.status);
        if (t.status.equalsIgnoreCase("available")) {
            lbl_plus.setEnabled(false);
            if (user.equals("6") || user.equals("7")) {

                if (check_in == 1) {
                    btn_p_order.setEnabled(false);
                    btn_p_check.setEnabled(true);
                } else {
                    btn_p_order.setEnabled(true);
                    btn_p_check.setEnabled(false);
                }
                btn_prepaid.setEnabled(false);
                btn_bill.setEnabled(false);
            } else {
                btn_p_order.setEnabled(false);
                btn_prepaid.setEnabled(false);
                btn_bill.setEnabled(false);
            }

            btn_p_cancel.setEnabled(false);
            if (System.getProperty("version", "ordering").
                    equals("ordering")) {
                btn_p_check.setEnabled(false);
                btn_p_order.setEnabled(true);
                btn_p_check.setText("PAY");
            }
        } else {
            lbl_plus.setEnabled(true);
            btn_p_check.setEnabled(true);
            btn_prepaid.setEnabled(true);
            btn_bill.setEnabled(true);
            final String version = System.getProperty("version", "ordering");
            if (version.equals("ordering")) {
                btn_p_check.setText("PAY");
            } else {
                btn_p_check.setText("CHECK-OUT");
            }
            if (user.equals("6") || user.equals("7")) {
                if (check_out == 1) {
                    btn_p_check.setText("CHECK-OUT");
                } else {
                    btn_p_check.setText("PAY");
                }

                btn_prepaid.setEnabled(false);
                btn_bill.setEnabled(false);
            } else {
                btn_prepaid.setEnabled(true);
                btn_bill.setEnabled(true);
            }
        }

        tbl_tables_ALM.clear();

        loadData_tables(tt);
        tbl_tables_M.fireTableDataChanged();
//        selected = 0;
//        mouseover(lbl_p_name_1);
//        set_order();
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

    private void check_in() {
        List<Dlg_check_liquid_2.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid_2.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid_2.to_guests a : datas) {
            System.out.println(a.status);
            if (a.status == true) {
                Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests(a.id, a.name, a.status);
                ok.add(to);
            }
        }
        if (callback != null) {
            if (btn_p_check.getText().
                    equals("CHECK IN")) {

//                JOptionPane.showMessageDialog(null, ok.size());
                callback.check_in(new CloseDialog(this), new OutputData(ok, percentag));
                this.dispose();
            } else {
                if (!tbl_tables_ALM.isEmpty() && ok.isEmpty()) {
                    for (Dlg_check_liquid_2.to_guests a : datas) {
                        System.out.println(a.status);
                        Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests(a.id, a.name, a.status);
                        ok.add(to);
                    }
                }
                if (System.getProperty("version", "resto").
                        equals("resto")) {
                    if (tbl_tables_ALM.isEmpty()) {
//                        JOptionPane.showMessageDialog(null, "Enter Guest");
//                        return;
                    }
                } else {
                }

                if (System.getProperty("version", "resto").
                        equals("ordering")) {
//                JOptionPane.showMessageDialog(null, tbl_tables_ALM.size());
                    if (tbl_tables_ALM.size() == 1) {
                        Dlg_check_liquid_2.to_guests to = (Dlg_check_liquid_2.to_guests) tbl_tables_ALM.get((0));
                        ok.add(to);
                    }

                }

                this.dispose();
                callback.check_out(new CloseDialog(this), new OutputData(ok, percentag));

//                refresh_guest();
            }
        }
    }

    private void order() {
        List<Dlg_check_liquid_2.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid_2.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid_2.to_guests a : datas) {
            System.out.println(a.status);
            if (a.status == true) {
                Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests(a.id, a.name, a.status);
                ok.add(to);
            }
        }
        int check_in = to_users.get_check_ins();
        String version = System.getProperty("version", "ordering");
        if (ok.isEmpty()) {
            if (version.equals("ordering")) {
                Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests("" + -1, "Walk-in", true);
                ok.add(to);
            } else {
                if (user.equals("5")) {
                    JOptionPane.showMessageDialog(null, "Choose Guest");
                    return;
                } else {
                    if (check_in == 1) {
                        JOptionPane.showMessageDialog(null, "Choose Guest");
                        return;
                    }

                }

            }
        }
        if (callback != null) {
            this.dispose();
            callback.order(new CloseDialog(this), new OutputData(ok, percentag));
        }
    }
    double percentag = 0;

    private void add_guests() {

        Object value = orders_model1.getElementAt(row_selected);
        final S2_search.to_rooms t = (S2_search.to_rooms) value;

        String version = System.getProperty("version", "ordering");
        Window p = (Window) this;
        Dlg_guest nd = Dlg_guest.create(p, true);
        nd.setTitle("");
        nd.do_pass(version, room_no, type, percentage,"");
        nd.setCallback(new Dlg_guest.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_guest.OutputData data) {
                closeDialog.ok();
                percentag = data.percentages;
                String id = "0";
                String table_no = t.id;
                String date_added = DateType.datetime.format(new Date());
                double amount = t.topay;
                String or_no = "0";
                String status = "0";
                S1_check_in.to_customer_tables to = new S1_check_in.to_customer_tables(id, table_no, date_added, amount, or_no, status);
                if (user.equals("6")) {
//                    JOptionPane.showMessageDialog(null, "6");
                    S1_check_in.check_in3(to, data.to1, t.room_rate, 1);
                } else {
                    S1_check_in.check_in(to, data.to1, t.room_rate, 1);
                }

//                    popup_check.hide();
//                refresh_guest();
                add_guest();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);

    }

    private void add_guest() {

        List<Dlg_check_liquid_2.to_guests> ok = new ArrayList();
        if (callback != null) {
            this.dispose();
            callback.add_guest(new CloseDialog(this), new OutputData(ok, percentag));
        }
    }

    private void void_order() {


        List<Dlg_check_liquid_2.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid_2.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid_2.to_guests a : datas) {
            System.out.println(a.status);
            if (a.status == true) {
                Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests(a.id, a.name, a.status);
//                System.out.println(a.id);
                ok.add(to);
            }
        }
//        System.out.println(ok.size());
        if (ok.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Choose Guest");
//            return;
        }
        if (callback != null) {
            this.dispose();
            callback.cancel(new CloseDialog(this), new OutputData(ok, percentag));
        }
    }

    private void set_order() {
        List<Dlg_check_liquid_2.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid_2.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid_2.to_guests a : datas) {
            if (a.status == true) {
                Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests(a.id, a.name, a.status);
                ok.add(to);
            }
        }
        if (callback != null) {
            callback.set_order(new CloseDialog(this), new OutputData(ok, percentag));
        }
    }
    private ArrayListModel tbl_tables_ALM;
    private TbltablesModel tbl_tables_M;

    private void init_tbl_tables() {
        tbl_tables_ALM = new ArrayListModel();
        tbl_tables_M = new TbltablesModel(tbl_tables_ALM);
        tbl_guest.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_guest.setModel(tbl_tables_M);
        tbl_guest.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_guest.setRowHeight(25);
        int[] tbl_widths_tables = {0, 100, 60};
        for (int i = 0, n = tbl_widths_tables.length; i < n; i++) {
            if (i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_guest, i, tbl_widths_tables[i]);
        }
        Dimension d = tbl_guest.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_guest.getTableHeader().setPreferredSize(d);
        tbl_guest.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_guest.setRowHeight(35);
        tbl_guest.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_tables(List<Dlg_check_liquid_2.to_guests> acc) {
        tbl_tables_ALM.clear();
        tbl_tables_ALM.addAll(acc);
    }

    public static class TbltablesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "NAME", ""
        };

        public TbltablesModel(ListModel listmodel) {
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
            if (col == 2) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Dlg_check_liquid_2.to_guests tt = (Dlg_check_liquid_2.to_guests) getRow(row);
            switch (col) {
            case 0:
                return tt.id;
            case 1:
                return tt.name;
            default:
                return tt.status;
            }
        }
    }

    private void data_cols() {
        loadData_tables(new ArrayListModel());
    }

    private void bill() {
        List<Dlg_check_liquid_2.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid_2.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid_2.to_guests a : datas) {
            System.out.println(a.status);
//            if (a.status == true) {
            Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests(a.id, a.name, a.status);
            ok.add(to);
//            }
        }


        String version = System.getProperty("version", "ordering");
//        if (ok.isEmpty()) {
//            if (version.equals("ordering") || version.equals("resto") && user.equals("6")|| version.equals("resto") && user.equals("5")) {
//                Dlg_check_liquid.to_guests to = new Dlg_check_liquid.to_guests("" + -1, "Walk-in", true);
//                ok.add(to);
//            } else {
//                JOptionPane.showMessageDialog(null, "Choose Guest");
//                return;
//            }
//        }
        if (callback != null) {
//            this.dispose();
            callback.set_bill(new CloseDialog(this), new OutputData(ok, percentag));
        }
    }

    private void advance() {
        List<Dlg_check_liquid_2.to_guests> ok = new ArrayList();
        List<Dlg_check_liquid_2.to_guests> datas = tbl_tables_ALM;
        for (Dlg_check_liquid_2.to_guests a : datas) {
            System.out.println(a.status);
            if (a.status == true) {
                Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests(a.id, a.name, a.status);
                ok.add(to);
            }
        }
        String version = System.getProperty("version", "ordering");
        if (ok.isEmpty()) {
            if (version.equals("ordering") || version.equals("resto") && user.equals("6")) {
                Dlg_check_liquid_2.to_guests to = new Dlg_check_liquid_2.to_guests("" + -1, "Walk-in", true);
                ok.add(to);
            } else {
                JOptionPane.showMessageDialog(null, "Choose Guest");
                return;
            }
        }
        if (callback != null) {
            this.dispose();
            callback.set_prepaid(new CloseDialog(this), new OutputData(ok, percentag));
        }
    }
}
