/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.dlg3;

import POS.svc4.S2_customers;
import POS.utl.DateType;
import POS.utl.NumType;
import POS.utl.Prompt;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Dummy
 */
public class Dlg_customers extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_customers
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void balance(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final String name;
        public final String add;
        public final String contact;
        public final String occupation;
        public final String income;
        public final String bday;
        public final String civil_status;
        public final String gender;
        public final double balance;
        public final double credit_limit;

        public OutputData(String name, String add, String contact, String occupation, String income, String bday, String civil_status, String gender, double balance, double credit_limit) {
            this.name = name;
            this.add = add;
            this.contact = contact;
            this.occupation = occupation;
            this.income = income;
            this.bday = bday;
            this.civil_status = civil_status;
            this.gender = gender;
            this.balance = balance;
            this.credit_limit = credit_limit;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_customers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_customers(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_customers() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_customers myRef;

    private void setThisRef(Dlg_customers myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customers> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customers create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_customers create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customers((java.awt.Frame) parent, false);
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
            Dlg_customers dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customers((java.awt.Dialog) parent, false);
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


        Dlg_customers dialog = Dlg_customers.create(new javax.swing.JFrame(), true);
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
        jLabel1 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        tf_address = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_contact = new javax.swing.JTextField();
        tf_occupation = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_income = new javax.swing.JTextField();
        dp_bday = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_status = new javax.swing.JComboBox();
        cb_gender = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_balance = new javax.swing.JLabel();
        btn_bal = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tf_limit = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Customer Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 48, -1, 20));

        tf_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nameActionPerformed(evt);
            }
        });
        jPanel1.add(tf_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 42, 549, 36));

        tf_address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_addressActionPerformed(evt);
            }
        });
        jPanel1.add(tf_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 93, 549, 36));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Address:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 99, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Contact #:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 158, -1, 20));

        tf_contact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_contactActionPerformed(evt);
            }
        });
        jPanel1.add(tf_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 148, 263, 36));

        tf_occupation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf_occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 196, 549, 37));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Occupation:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 198, -1, 35));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Source of Income:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 251, -1, 35));

        tf_income.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf_income, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 252, 549, 35));

        dp_bday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(dp_bday, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 304, 182, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Birth Date:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 304, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Civil Status:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, 20));

        cb_status.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married", "Widow" }));
        jPanel1.add(cb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 167, 34));

        cb_gender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        jPanel1.add(cb_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 86, 34));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Gender:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Balance:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 309, -1, 20));

        lb_balance.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_balance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_balance.setText("0.00");
        lb_balance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lb_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 305, 136, 30));

        btn_bal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/add32x32.png"))); // NOI18N
        btn_bal.setText("ADD");
        btn_bal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_balActionPerformed(evt);
            }
        });
        jPanel1.add(btn_bal, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 302, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Credit Limit:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 348, -1, 20));

        tf_limit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tf_limit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_limit.setText("1000.00");
        jPanel1.add(tf_limit, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 343, 126, 34));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        jButton1.setText("CANCEL");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_ok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        btn_ok.setText("OK");
        btn_ok.setBorderPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(491, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btn_ok)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 790, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        disposed();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_okActionPerformed

    private void tf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nameActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_tf_nameActionPerformed

    private void tf_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_addressActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_tf_addressActionPerformed

    private void tf_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_contactActionPerformed
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_tf_contactActionPerformed

    private void btn_balActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_balActionPerformed
        // TODO add your handling code here:
        do_balance();
    }//GEN-LAST:event_btn_balActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bal;
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox cb_gender;
    private javax.swing.JComboBox cb_status;
    private com.toedter.calendar.JDateChooser dp_bday;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lb_balance;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_contact;
    private javax.swing.JTextField tf_income;
    private javax.swing.JTextField tf_limit;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_occupation;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        dp_bday.setDate(new Date());
    }
    double bal = 0;
    String num11 = "0";

    public void do_pass(String member_name, String address, String contact, String occupation, String income, String b_date, String civil_status, String is_male, double balance, String num, double credit_limit) {
        num11 = num;
        bal = balance;
        lb_balance.setText("" + NumType.with_comma(balance));
        tf_name.setText(member_name);
        tf_address.setText(address);
        tf_contact.setText(contact);
        tf_occupation.setText(occupation);
        tf_income.setText(income);

        cb_status.setSelectedItem(civil_status);
        if (is_male.equals("1")) {
            cb_gender.setSelectedItem("Male");
        } else {
            cb_gender.setSelectedItem("Female");
        }
        Date d = new Date();
        try {
            d = DateType.sf.parse(b_date);
        } catch (ParseException ex) {
            Logger.getLogger(Dlg_customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        dp_bday.setDate(d);

        tf_limit.setText("" + credit_limit);

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

    private void do_balance() {

        Window p = (Window) this;
        Dlg_balance nd = Dlg_balance.create(p, true);
        nd.setTitle("");
        nd.do_pass(bal);
        nd.setCallback(new Dlg_balance.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_balance.OutputData data) {
                closeDialog.ok();
                update_balance(data.balances);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void update_balance(double b) {
        double new_bal = b + bal;
        if (System.getProperty("version", "resto").equals("resto")) {
            S2_customers.update_balance_guest(num11, new_bal);
        } else {
            S2_customers.update_balance(num11, new_bal);
        }

        lb_balance.setText(NumType.with_comma(new_bal));
        ok_bal();
        bal = new_bal;
    }

    private void ok_bal() {
        if (callback != null) {
            callback.balance(new CloseDialog(this), new OutputData("", "", "", "", "", "", "", "", 0, 0));
        }
    }

    private void ok1() {
        String name = tf_name.getText();
        String ad = tf_address.getText();
        String con = tf_contact.getText();
        String occupation = tf_occupation.getText();
        String income = tf_income.getText();
        String bday = DateType.sf.format(dp_bday.getDate());
        String civil_status = cb_status.getSelectedItem().toString();
        String gender = cb_gender.getSelectedItem().toString();
        if (gender.equals("Male")) {
            gender = "1";
        } else {
            gender = "0";
        }

//        if (name.isEmpty()) {
//            Prompt.call("Please Input name");
////            JOptionPane.showMessageDialog(null, "Please Input name");
//            return;
//        }
        double credit_limit = 0;

        try {

            if (tf_limit.getText().isEmpty()) {
                Prompt.call("Fillup Entry for Limit");
            } else {
                credit_limit = Double.parseDouble(tf_limit.getText());
            }

        } catch (Exception e) {
            Prompt.call("Incorrect Entry for Limit");
        }



        double bal = FitIn.toDouble(lb_balance.getText());
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(name, ad, con, occupation, income, bday, civil_status, gender, bal, credit_limit));
        }
    }
}
