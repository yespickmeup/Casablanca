/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dlg_login.java
 *
 * Created on Nov 18, 2011, 2:18:10 PM
 */
package POS.dlg;

import POS.dlg2.Dlg_confirm;
import POS.svc.S9_confirm_user;
import POS.svc2.S12_cashier_sessions;
import POS.svc2.S14_chech_if_admin;
import POS.svc2.S4_select_endorsements;
import POS.utl.Prompt;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.Application;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_login extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        public void show_login_again(CloseDialog closeDialog);
    }

    public static class OutputData {

        public final String un;
        public final String pw;

        public OutputData(String un, String pw) {
            this.un = un;
            this.pw = pw;
        }

        @Override
        public String toString() {
            return "OutputData{" + "un=" + un + ", pw=" + pw + '}';
        }
    }

    public static class InputData {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_login(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_login() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_login myRef;

    private void setThisRef(Dlg_login myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_login> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_login create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_login create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_login dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_login((java.awt.Frame) parent, false);
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
            Dlg_login dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_login((java.awt.Dialog) parent, false);
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


        Dlg_login dialog = Dlg_login.create(new javax.swing.JFrame(), true);
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
//            validateTree();
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ds_error = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();
        pf_password = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 195, 191));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/key-icon.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 74, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setForeground(new java.awt.Color(41, 9, 149));
        jLabel2.setText("Username:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 94, -1, -1));

        tf_username.setFont(new java.awt.Font("Tahoma", 1, 18));
        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });
        jPanel1.add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 84, 216, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setForeground(new java.awt.Color(41, 9, 149));
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 144, -1, -1));

        ds_error.setFont(new java.awt.Font("DejaVu Sans", 2, 13));
        ds_error.setForeground(java.awt.Color.red);
        ds_error.setText("* invalid username/password");
        jPanel1.add(ds_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 213, 208, 28));

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/ok_login.png"))); // NOI18N
        btn_ok.setBorderPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/ok_login_mo.png"))); // NOI18N
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        pf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(pf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 128, 216, 33));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 0, 24));
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("Please provide your login information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 520, -1));

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel9.setForeground(new java.awt.Color(41, 9, 149));
        jLabel9.setText("(F5)");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 50, 30));

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel10.setForeground(new java.awt.Color(41, 9, 149));
        jLabel10.setText("(ENTER)");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, 30));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/clear.png"))); // NOI18N
        btn_clear.setBorderPainted(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/clear_mo.png"))); // NOI18N
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
    do_ok();
}//GEN-LAST:event_btn_okActionPerformed

private void pf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_passwordActionPerformed
    do_ok();
}//GEN-LAST:event_pf_passwordActionPerformed

private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
    do_ok();
}//GEN-LAST:event_tf_usernameActionPerformed

private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
    do_clear();
}//GEN-LAST:event_btn_clearActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel ds_error;
    private javax.swing.JLabel ds_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">

    private void myInit() {
        initActionKey();
        initHideError();
        initXButton();
        init_limit_username();
    }

    private void init_limit_username() {
//        RegexpInputVerifier riv = new RegexpInputVerifier("\\da");
//        tf_username.setInputVerifier( riv );
//        RegexDocument regex = new RegexDocument(VerifierConst.LIMIT_0_3);
//        tf_username.setDocument(regex);
    }

    private void initHideError() {
        ds_error.setVisible(false);
    }

    private void initXButton() {
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
               out();

            }
        });
    }

    
    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                out();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ENTER, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                do_ok();
            }
        });

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                do_clear();
            }
        });
    }
    //</editor-fold>

    
    private void out(){
        Window w = (Window) this;
        Dlg_confirm d = Dlg_confirm.create(w, true);
        d.setTitle("Logout?");
        d.setCallback(new Dlg_confirm.Callback() {
            
            @Override
            public void ok(CloseDialog cd, Dlg_confirm.Data data) {
                System.exit(1);
                
            }

            @Override
            public void cancel(CloseDialog cd) {
                cd.ok();
                show_login();
            }
        });
        
        Application.locateOnParentCenter(w, d);
        
        d.setVisible(true);
    }
    public void load(InputData data) {
    }

    private void show_login() {
        if( callback != null) {
            callback.show_login_again(new CloseDialog(this));
        }
    }
    
    private boolean validation_pass() {
        String un = tf_username.getText();
        String pw = new String(pf_password.getPassword());

        if (un.isEmpty()) {
               Prompt.call("Fillup Username");
//            JOptionPane.showMessageDialog(this.getSurface(), "Fillup Username");
//            ds_error.setText( "Fillup Username");
            tf_username.selectAll();
            tf_username.requestFocusInWindow();
            return false;
        }

        if (pw.isEmpty()) {
             Prompt.call("Fillup Password");
//            JOptionPane.showMessageDialog(this.getSurface(), "Fillup Password");
//            ds_error.setText( "Fillup Password");
            tf_username.selectAll();
            pf_password.requestFocusInWindow();
            return false;
        }

        return true;
    }

    private void do_ok() {

        if (callback == null) {
            return;
        }

        if (!validation_pass()) {
            return;
        }


        prcss_work_on();

    }

    private void do_cancel() {
//        System.exit(0);
        this.dispose();
    }

    private void do_clear() {
        ds_error.setVisible(false);
        tf_username.setText("");
        pf_password.setText("");
        tf_username.requestFocusInWindow();

    }

    private void prcss_work_on() {


        final String un = tf_username.getText();
        String pw = new String(pf_password.getPassword());



        if (!S9_confirm_user.conf_user(un, pw)) {
             Prompt.call("Wrong UserName/Password");
//            JOptionPane.showMessageDialog(null, "Wrong UserName/Password");
        } else {

            int lvl = S14_chech_if_admin.do_check_if_adming(tf_username.getText());



            if (lvl != 1) {

                int kilos = S4_select_endorsements.do_search_kilos();
                System.out.println(kilos);

                if (kilos == 0) {
                     Prompt.call("Contact Administrator for endorsements");
//                    JOptionPane.showMessageDialog(null, "Contact Administrator for endorsements");
                    System.exit(1);
                }


//                   

                int cashier_session_id = S12_cashier_sessions.get_cashier_ses_id(un);
                String log = S12_cashier_sessions.is_logout(un);
                if (log.equals("yes")) {
                    Window w = (Window) this;
                    Dlg_cash_in d = Dlg_cash_in.create(w, true);
                    d.setTitle("Cash-in");
                    d.pass(new Dlg_cash_in.InputData(cashier_session_id, un));
                    d.setCallback(new Dlg_cash_in.Callback() {

                        @Override
                        public void ok(CloseDialog cd, Dlg_cash_in.OutputData data) {
                            cd.ok();
                           
                        }
                    });

//                    Application.locateOnParentCenter(w, d);
                    Center.setCenter(d);

                    d.setVisible(true);     

                }else{
                   
                }

            }

            this.dispose();
            callback.ok(new CloseDialog(this), new OutputData(un, pw));

            tf_username.setText("");
            pf_password.setText("");
        }

    }
}
