/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpt_liquid;

import POS.dlg3.Dlg_add_discount;
import POS.printing2.rpt_orders1;
import POS_svc3.S2_get_discounts;
import POS_svc4.S2_search;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.JasperUtil;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

/**
 *
 * @author i1
 */
public class Dlg_billing_report2 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_billing_report
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

        public final String discount;
        public final double rate;

        public OutputData(String discount, double rate) {
            this.discount = discount;
            this.rate = rate;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_billing_report2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_billing_report2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_billing_report2() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_billing_report2 myRef;

    private void setThisRef(Dlg_billing_report2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_billing_report2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_billing_report2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_billing_report2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_billing_report2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_billing_report2((java.awt.Frame) parent, false);
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
            Dlg_billing_report2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_billing_report2((java.awt.Dialog) parent, false);
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


        Dlg_billing_report2 dialog = Dlg_billing_report2.create(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());

        dialog.setSize(xSize, ySize);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_discount = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lb_rate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("DISCOUNT:");

        cb_discount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_discount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_discountActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("RATE:");

        lb_rate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_rate.setText("12");
        lb_rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lb_rate.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("%");

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("CLOSE");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("PRINT");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_discount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        disposed();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_discountActionPerformed
        // TODO add your handling code here:
        get_rate();
    }//GEN-LAST:event_cb_discountActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        discount();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        print();
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_discount;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_rate;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_cb();
    }

    private void init_cb() {

        cb_discount.setModel(new ListComboBoxModel(S2_get_discounts.
                get_discounts_for_cb()));
        get_rate();
    }

    private void get_rate() {
        int row = cb_discount.getItemCount();
        if (row <= 0) {
            return;
        }
        System.out.println(cb_discount.getSelectedItem().
                toString());
        String rate = S2_get_discounts.get_discounts_rate(cb_discount.
                getSelectedItem().
                toString());
        lb_rate.setText(rate);
        double discount = FitIn.toDouble(rate) / 100;
        if (j == 1) {
//            discount = to2.getTo_pay() * discount;
//            double to_pay = to2.to_pay - discount;
//            double dollar = to_pay / 41;
//           report_get_viewer_session(to2, jrxml_name);
        }


//         System.out.println(rate);
    }
    int j = 0;
    rpt_orders1 to1 = new rpt_orders1("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 0, 0);
    double to_pay = 0;
    List<S2_search.to_items> items2 = new ArrayList();

    public void do_pass(rpt_orders1 to, String jrxml_name, List<rpt_orders1.field> datas, List<S2_search.to_items> items, String table_id) {

        to_pay = 0;
        S1_bill_discounts.to_bill_discounts disc = S1_bill_discounts.ret_data(table_id);
        cb_discount.setSelectedItem(disc.discount);
        lb_rate.setText(FitIn.fmt_wc_0(disc.rate));
        j = 1;
        rpt_orders1 to2 = new rpt_orders1(to.table_no, to.business_name, to.operated_by, to.address, to.telephone_number, to.traction_no, to.cashier_name, to.waiter_name, to.tin_no, to.min_no, to.serial_no, to.permit_no, to.or_no, to.trans_no, to.pos_no, to.discount, 0);


        for (S2_search.to_items data : items) {
            rpt_orders1.field f = new rpt_orders1.field(
                    0,
                    data.qty,
                    data.desc,
                    data.price,
                    data.discount);
            datas.add(f);
            to_pay += data.price * data.qty;
            to2.fields.add(f);
        }
        items2 = items;
        to1 = to2;
//        report_get_viewer_session(to2, jrxml_name);
//      
    }
    double my_discount = 0;

    private void print() {

        my_discount = 0;
        double discount = FitIn.toDouble(lb_rate.getText()) / 100;
        discount = to_pay * discount;
        double to_pay1 = to_pay - discount;
        double dollar = to_pay / 41;
        my_discount = discount;
//        JOptionPane.showMessageDialog(null, to_pay + " "+ discount);
        rpt_orders1 to2 = new rpt_orders1(to1.table_no, to1.business_name, to1.operated_by, to1.address, to1.telephone_number, to1.traction_no, to1.cashier_name, to1.waiter_name, to1.tin_no, to1.min_no, to1.serial_no, to1.permit_no, to1.or_no, to1.trans_no, to1.pos_no, discount, my_discount);
        for (S2_search.to_items data : items2) {
            rpt_orders1.field f = new rpt_orders1.field(
                    0,
                    data.qty,
                    data.desc,
                    data.price,
                    data.discount);
            if (data.qty * data.price != 0) {
                to2.fields.add(f);
            }
        }
//         JOptionPane.showMessageDialog(null, my_discount);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        String print = System.getProperty("print_to_receipts", "false");
        if (print.equals("true")) {
            rpt_orders1.print_to_place(to2);
        }

        my_discount = 0;
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        if (FitIn.toDouble(lb_rate.getText()) != 0) {
            ok1();
        }
    }

    private void ok1() {
        String discount = cb_discount.getSelectedItem().
                toString();
        double rate = FitIn.toDouble(lb_rate.getText());
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(discount, rate));
        }
    }

    private void discount() {
        Window p = (Window) this;
        Dlg_add_discount nd = Dlg_add_discount.create(p, true);
        nd.setTitle("");
//        nd.do_pass("");
        nd.setCallback(new Dlg_add_discount.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_add_discount.OutputData data) {
//                closeDialog.ok();
                init_cb();
            }
        });
        nd.setLocationRelativeTo(this);

        nd.setVisible(true);
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

    public static JasperReport compileJasper() {

        try {
            String jrxml = "rpt_my_orders_2_1.jrxml";
            InputStream is = rpt_liquid.Srpt_liquid_billing.class.
                    getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);
            return jasper;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer_conn(rpt_orders1 to, String rpt_name) {
//        Connection con11 = null;


        try {
//            con11 = MyConnection.connect();

            return JasperUtil.getJasperViewer(
                    compileJasper(),
                    JasperUtil.setParameter(to),
                    JasperUtil.emptyDatasource());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }

    }

    private void report_get_viewer_session(final rpt_orders1 to, String jrxml_name) {
//        pnl_rpt.removeAll();
//        pnl_rpt.setLayout(new BorderLayout());
//        try {
//            JRViewer viewer = get_viewer_conn(to, jrxml_name);
//            JPanel pnl = new JPanel();
//            pnl.add(viewer);
//            pnl.setVisible(true);
//            pnl.setVisible(true);
//            pnl_rpt.add(viewer);
//            pnl_rpt.updateUI();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
