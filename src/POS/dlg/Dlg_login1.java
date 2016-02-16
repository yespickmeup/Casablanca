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

import POS.Dlg_version;
import POS.dlg2.Dlg_confirm;
import POS.dlg2.dlg_keyboard;
import POS.svc.S12_retval_user_level;
import POS.svc.S9_confirm_user;
import POS.svc2.S12_cashier_sessions;
import POS.svc2.S14_chech_if_admin;
import POS.utl.Backspace;
import POS.utl.Prompt;
import POS.utl.TextInserter;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import mijzcx.synapse.desk.utils.Application;
import POS.utl.Center;
import POS_svc4.S9_cashier_session;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class Dlg_login1 extends javax.swing.JDialog {

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
        public final int check_in;
        public final int check_out;

        public OutputData(String un, String pw, int check_in, int check_out) {
            this.un = un;
            this.pw = pw;
            this.check_in = check_in;
            this.check_out = check_out;
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
    private Dlg_login1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_login1(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_login1() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_login1 myRef;

    private void setThisRef(Dlg_login1 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_login1> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_login1 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_login1 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_login1 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_login1((java.awt.Frame) parent, false);
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
            Dlg_login1 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_login1((java.awt.Dialog) parent, false);
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


        Dlg_login1 dialog = Dlg_login1.create(new javax.swing.JFrame(), true);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_log = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ds_error = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();
        pf_password = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cp_menu = new org.jdesktop.swingx.JXCollapsiblePane();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        btn_w = new javax.swing.JButton();
        btn_q = new javax.swing.JButton();
        btn_e = new javax.swing.JButton();
        btn_r = new javax.swing.JButton();
        btn_t = new javax.swing.JButton();
        btn_y = new javax.swing.JButton();
        btn_u = new javax.swing.JButton();
        btn_i = new javax.swing.JButton();
        btn_o = new javax.swing.JButton();
        btn_p = new javax.swing.JButton();
        btn_a = new javax.swing.JButton();
        btn_s = new javax.swing.JButton();
        btn_d = new javax.swing.JButton();
        btn_f = new javax.swing.JButton();
        btn_g = new javax.swing.JButton();
        btn_h = new javax.swing.JButton();
        btn_j = new javax.swing.JButton();
        btn_k = new javax.swing.JButton();
        btn_l = new javax.swing.JButton();
        btn_clear1 = new javax.swing.JButton();
        btn_x = new javax.swing.JButton();
        btn_c = new javax.swing.JButton();
        btn_v = new javax.swing.JButton();
        btn_b = new javax.swing.JButton();
        btn_n = new javax.swing.JButton();
        btn_m = new javax.swing.JButton();
        btn_z = new javax.swing.JButton();
        btn_space = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_caps = new javax.swing.JToggleButton();
        btn_chars = new javax.swing.JToggleButton();
        tf_password = new javax.swing.JPasswordField();
        tf_user_name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(828, 378));
        getContentPane().setLayout(null);

        pnl_log.setBackground(new java.awt.Color(159, 207, 243));
        pnl_log.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/users-login_1.png"))); // NOI18N
        pnl_log.add(jLabel1);
        jLabel1.setBounds(60, 110, 170, 170);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 9, 149));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Username:");
        pnl_log.add(jLabel2);
        jLabel2.setBounds(200, 130, 150, 22);

        tf_username.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tf_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_usernameMouseClicked(evt);
            }
        });
        tf_username.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tf_usernameMouseDragged(evt);
            }
        });
        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });
        pnl_log.add(tf_username);
        tf_username.setBounds(360, 120, 340, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(41, 9, 149));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Password:");
        pnl_log.add(jLabel3);
        jLabel3.setBounds(204, 182, 150, 40);

        ds_error.setFont(new java.awt.Font("DejaVu Sans", 2, 13)); // NOI18N
        ds_error.setForeground(java.awt.Color.red);
        ds_error.setText("* invalid username/password");
        pnl_log.add(ds_error);
        ds_error.setBounds(50, 290, 208, 28);

        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check.png"))); // NOI18N
        btn_ok.setBorderPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/check-MO.png"))); // NOI18N
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });
        pnl_log.add(btn_ok);
        btn_ok.setBounds(570, 230, 70, 50);

        pf_password.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        pf_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pf_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pf_passwordMouseClicked(evt);
            }
        });
        pf_password.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pf_passwordMouseDragged(evt);
            }
        });
        pf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_passwordActionPerformed(evt);
            }
        });
        pnl_log.add(pf_password);
        pf_password.setBounds(360, 180, 340, 40);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("Please provide your login information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ds_title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_log.add(jPanel2);
        jPanel2.setBounds(50, 30, 730, 57);

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields1.png"))); // NOI18N
        btn_clear.setBorderPainted(false);
        btn_clear.setContentAreaFilled(false);
        btn_clear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/clear-fields-MO.png"))); // NOI18N
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        pnl_log.add(btn_clear);
        btn_clear.setBounds(450, 230, 81, 57);

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(41, 9, 149));
        jLabel13.setText("OK");
        pnl_log.add(jLabel13);
        jLabel13.setBounds(640, 240, 30, 17);

        jLabel14.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(149, 9, 12));
        jLabel14.setText("(ENTER)");
        pnl_log.add(jLabel14);
        jLabel14.setBounds(620, 260, 80, 17);

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(41, 9, 149));
        jLabel15.setText("CLEAR");
        pnl_log.add(jLabel15);
        jLabel15.setBounds(520, 240, 60, 20);

        jLabel18.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(149, 9, 12));
        jLabel18.setText("(F5)");
        pnl_log.add(jLabel18);
        jLabel18.setBounds(520, 260, 40, 20);

        btn_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close_1.png"))); // NOI18N
        btn_cancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn_cancel.setBorderPainted(false);
        btn_cancel.setContentAreaFilled(false);
        btn_cancel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO_1.png"))); // NOI18N
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        pnl_log.add(btn_cancel);
        btn_cancel.setBounds(300, 230, 70, 60);

        jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(41, 9, 149));
        jLabel16.setText("CLOSE");
        pnl_log.add(jLabel16);
        jLabel16.setBounds(370, 240, 90, 17);

        jLabel17.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(149, 9, 12));
        jLabel17.setText("ESCAPE");
        pnl_log.add(jLabel17);
        jLabel17.setBounds(370, 260, 90, 17);

        getContentPane().add(pnl_log);
        pnl_log.setBounds(0, 0, 830, 360);

        jXPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jXPanel1.setLayout(null);

        btn_w.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_w.setText("W");
        btn_w.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_wMouseReleased(evt);
            }
        });
        btn_w.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_wMouseDragged(evt);
            }
        });
        btn_w.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_wActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_w);
        btn_w.setBounds(100, 80, 70, 60);

        btn_q.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_q.setText("Q");
        btn_q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_qMouseReleased(evt);
            }
        });
        btn_q.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_qMouseDragged(evt);
            }
        });
        btn_q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_qActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_q);
        btn_q.setBounds(20, 80, 70, 60);

        btn_e.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_e.setText("E");
        btn_e.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_eMouseReleased(evt);
            }
        });
        btn_e.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_eMouseDragged(evt);
            }
        });
        btn_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_e);
        btn_e.setBounds(180, 80, 70, 60);

        btn_r.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_r.setText("R");
        btn_r.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_rMouseReleased(evt);
            }
        });
        btn_r.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_rMouseDragged(evt);
            }
        });
        btn_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_r);
        btn_r.setBounds(260, 80, 70, 60);

        btn_t.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_t.setText("T");
        btn_t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_tMouseReleased(evt);
            }
        });
        btn_t.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_tMouseDragged(evt);
            }
        });
        btn_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_t);
        btn_t.setBounds(340, 80, 70, 60);

        btn_y.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_y.setText("Y");
        btn_y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_yMouseReleased(evt);
            }
        });
        btn_y.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_yMouseDragged(evt);
            }
        });
        btn_y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_y);
        btn_y.setBounds(420, 80, 70, 60);

        btn_u.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_u.setText("U");
        btn_u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_uMouseReleased(evt);
            }
        });
        btn_u.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_uMouseDragged(evt);
            }
        });
        btn_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_u);
        btn_u.setBounds(500, 80, 70, 60);

        btn_i.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_i.setText("I");
        btn_i.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_iMouseReleased(evt);
            }
        });
        btn_i.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_iMouseDragged(evt);
            }
        });
        btn_i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_i);
        btn_i.setBounds(580, 80, 70, 60);

        btn_o.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_o.setText("O");
        btn_o.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_oMouseReleased(evt);
            }
        });
        btn_o.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_oMouseDragged(evt);
            }
        });
        btn_o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_oActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_o);
        btn_o.setBounds(660, 80, 70, 60);

        btn_p.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_p.setText("P");
        btn_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_pMouseReleased(evt);
            }
        });
        btn_p.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_pMouseDragged(evt);
            }
        });
        btn_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_p);
        btn_p.setBounds(740, 80, 70, 60);

        btn_a.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_a.setText("A");
        btn_a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_aMouseReleased(evt);
            }
        });
        btn_a.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_aMouseDragged(evt);
            }
        });
        btn_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_a);
        btn_a.setBounds(60, 150, 70, 60);

        btn_s.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_s.setText("S");
        btn_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_sMouseReleased(evt);
            }
        });
        btn_s.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_sMouseDragged(evt);
            }
        });
        btn_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_s);
        btn_s.setBounds(140, 150, 70, 60);

        btn_d.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_d.setText("D");
        btn_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_dMouseReleased(evt);
            }
        });
        btn_d.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_dMouseDragged(evt);
            }
        });
        btn_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_d);
        btn_d.setBounds(220, 150, 70, 60);

        btn_f.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_f.setText("F");
        btn_f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_fMouseReleased(evt);
            }
        });
        btn_f.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_fMouseDragged(evt);
            }
        });
        btn_f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_f);
        btn_f.setBounds(300, 150, 70, 60);

        btn_g.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_g.setText("G");
        btn_g.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_gMouseReleased(evt);
            }
        });
        btn_g.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_gMouseDragged(evt);
            }
        });
        btn_g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_g);
        btn_g.setBounds(380, 150, 70, 60);

        btn_h.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_h.setText("H");
        btn_h.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_hMouseReleased(evt);
            }
        });
        btn_h.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_hMouseDragged(evt);
            }
        });
        btn_h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_h);
        btn_h.setBounds(460, 150, 70, 60);

        btn_j.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_j.setText("J");
        btn_j.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_jMouseReleased(evt);
            }
        });
        btn_j.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_jMouseDragged(evt);
            }
        });
        btn_j.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_j);
        btn_j.setBounds(540, 150, 70, 60);

        btn_k.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_k.setText("K");
        btn_k.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_kMouseReleased(evt);
            }
        });
        btn_k.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_kMouseDragged(evt);
            }
        });
        btn_k.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_k);
        btn_k.setBounds(620, 150, 70, 60);

        btn_l.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_l.setText("L");
        btn_l.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_lMouseReleased(evt);
            }
        });
        btn_l.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_lMouseDragged(evt);
            }
        });
        btn_l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_l);
        btn_l.setBounds(700, 150, 70, 60);

        btn_clear1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_clear1.setText("CLEAR");
        btn_clear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_clear1MouseReleased(evt);
            }
        });
        btn_clear1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_clear1MouseDragged(evt);
            }
        });
        btn_clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear1ActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_clear1);
        btn_clear1.setBounds(700, 220, 110, 60);

        btn_x.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_x.setText("X");
        btn_x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_xMouseReleased(evt);
            }
        });
        btn_x.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_xMouseDragged(evt);
            }
        });
        btn_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_x);
        btn_x.setBounds(220, 220, 70, 60);

        btn_c.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_c.setText("C");
        btn_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_cMouseReleased(evt);
            }
        });
        btn_c.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_cMouseDragged(evt);
            }
        });
        btn_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_c);
        btn_c.setBounds(300, 220, 70, 60);

        btn_v.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_v.setText("V");
        btn_v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_vMouseReleased(evt);
            }
        });
        btn_v.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_vMouseDragged(evt);
            }
        });
        btn_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_v);
        btn_v.setBounds(380, 220, 70, 60);

        btn_b.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_b.setText("B");
        btn_b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_bMouseReleased(evt);
            }
        });
        btn_b.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_bMouseDragged(evt);
            }
        });
        btn_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_b);
        btn_b.setBounds(460, 220, 70, 60);

        btn_n.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_n.setText("N");
        btn_n.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_nMouseReleased(evt);
            }
        });
        btn_n.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_nMouseDragged(evt);
            }
        });
        btn_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_n);
        btn_n.setBounds(540, 220, 70, 60);

        btn_m.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_m.setText("M");
        btn_m.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_mMouseReleased(evt);
            }
        });
        btn_m.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_mMouseDragged(evt);
            }
        });
        btn_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_m);
        btn_m.setBounds(620, 220, 70, 60);

        btn_z.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_z.setText("Z");
        btn_z.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_zMouseReleased(evt);
            }
        });
        btn_z.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_zMouseDragged(evt);
            }
        });
        btn_z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_zActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_z);
        btn_z.setBounds(140, 220, 70, 60);

        btn_space.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_space.setText("SPACE");
        btn_space.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_spaceMouseReleased(evt);
            }
        });
        btn_space.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_spaceMouseDragged(evt);
            }
        });
        btn_space.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_spaceActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_space);
        btn_space.setBounds(210, 290, 420, 50);

        btn_return.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_return.setText("ENTER");
        btn_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_returnMouseReleased(evt);
            }
        });
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_return);
        btn_return.setBounds(640, 290, 170, 50);

        btn_caps.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_caps.setSelected(true);
        btn_caps.setText("[A]");
        btn_caps.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_capsMouseReleased(evt);
            }
        });
        btn_caps.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_capsMouseDragged(evt);
            }
        });
        btn_caps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capsActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_caps);
        btn_caps.setBounds(20, 220, 110, 60);

        btn_chars.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        btn_chars.setSelected(true);
        btn_chars.setText(".?123");
        btn_chars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_charsMouseReleased(evt);
            }
        });
        btn_chars.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_charsMouseDragged(evt);
            }
        });
        btn_chars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_charsActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_chars);
        btn_chars.setBounds(20, 290, 180, 50);

        tf_password.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        tf_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jXPanel1.add(tf_password);
        tf_password.setBounds(20, 17, 790, 50);

        tf_user_name.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        tf_user_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jXPanel1.add(tf_user_name);
        tf_user_name.setBounds(20, 17, 790, 50);

        javax.swing.GroupLayout cp_menuLayout = new javax.swing.GroupLayout(cp_menu.getContentPane());
        cp_menu.getContentPane().setLayout(cp_menuLayout);
        cp_menuLayout.setHorizontalGroup(
            cp_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        cp_menuLayout.setVerticalGroup(
            cp_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        getContentPane().add(cp_menu);
        cp_menu.setBounds(0, 0, 830, 370);

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

private void btn_wActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_wActionPerformed
// TODO add your handling code here:do_set(btn_Q");
}//GEN-LAST:event_btn_wActionPerformed

private void btn_qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_qActionPerformed
// TODO add your handling code here:
//    do_set(btn_q.getText());
}//GEN-LAST:event_btn_qActionPerformed

private void btn_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eActionPerformed
// TODO add your handling code here:
//    do_set(btn_e.getText());
}//GEN-LAST:event_btn_eActionPerformed

private void btn_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rActionPerformed
// TODO add your handling code here:
//    do_set(btn_r.getText());
}//GEN-LAST:event_btn_rActionPerformed

private void btn_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tActionPerformed
// TODO add your handling code here:
//    do_set(btn_t.getText());
}//GEN-LAST:event_btn_tActionPerformed

private void btn_yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yActionPerformed
// TODO add your handling code here:
//    do_set(btn_y.getText());
}//GEN-LAST:event_btn_yActionPerformed

private void btn_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uActionPerformed
// TODO add your handling code here:
//    do_set(btn_u.getText());
}//GEN-LAST:event_btn_uActionPerformed

private void btn_iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iActionPerformed
// TODO add your handling code here:
//    do_set(btn_i.getText());
}//GEN-LAST:event_btn_iActionPerformed

private void btn_oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oActionPerformed
// TODO add your handling code here:
//    do_set(btn_o.getText());
}//GEN-LAST:event_btn_oActionPerformed

private void btn_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pActionPerformed
// TODO add your handling code here:
//    do_set(btn_p.getText());
}//GEN-LAST:event_btn_pActionPerformed

private void btn_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aActionPerformed
// TODO add your handling code here:
//    do_set(btn_a.getText());
}//GEN-LAST:event_btn_aActionPerformed

private void btn_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sActionPerformed
// TODO add your handling code here:
//    do_set(btn_s.getText());
}//GEN-LAST:event_btn_sActionPerformed

private void btn_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dActionPerformed
// TODO add your handling code here:
//    do_set(btn_d.getText());
}//GEN-LAST:event_btn_dActionPerformed

private void btn_fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fActionPerformed
// TODO add your handling code here:
//    do_set(btn_f.getText());
}//GEN-LAST:event_btn_fActionPerformed

private void btn_gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gActionPerformed
// TODO add your handling code here:
//    do_set(btn_g.getText());
}//GEN-LAST:event_btn_gActionPerformed

private void btn_hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hActionPerformed
// TODO add your handling code here:
//    do_set(btn_h.getText());
}//GEN-LAST:event_btn_hActionPerformed

private void btn_jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jActionPerformed
// TODO add your handling code here:
//    do_set(btn_j.getText());
}//GEN-LAST:event_btn_jActionPerformed

private void btn_kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kActionPerformed
// TODO add your handling code here:
//    do_set(btn_k.getText());
}//GEN-LAST:event_btn_kActionPerformed

private void btn_lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lActionPerformed
// TODO add your handling code here:
//    do_set(btn_l.getText());
}//GEN-LAST:event_btn_lActionPerformed

private void btn_clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear1ActionPerformed
// TODO add your handling code here:
//    clear_field();
}//GEN-LAST:event_btn_clear1ActionPerformed

private void btn_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xActionPerformed
// TODO add your handling code here:
//    do_set(btn_x.getText());
}//GEN-LAST:event_btn_xActionPerformed

private void btn_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cActionPerformed
// TODO add your handling code here:
//  v
}//GEN-LAST:event_btn_cActionPerformed

private void btn_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vActionPerformed
// TODO add your handling code here:
//    do_set(btn_v.getText());
}//GEN-LAST:event_btn_vActionPerformed

private void btn_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bActionPerformed
// TODO add your handling code here:
//    do_set(btn_b.getText());
}//GEN-LAST:event_btn_bActionPerformed

private void btn_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nActionPerformed
// TODO add your handling code here:
//    do_set(btn_n.getText());
}//GEN-LAST:event_btn_nActionPerformed

private void btn_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mActionPerformed
// TODO add your handling code here:
//    do_set(btn_m.getText());
}//GEN-LAST:event_btn_mActionPerformed

private void btn_zActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_zActionPerformed
// TODO add your handling code here:
//    do_set(btn_z.getText());
}//GEN-LAST:event_btn_zActionPerformed

private void btn_spaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_spaceActionPerformed
// TODO add your handling code here:
//    do_set(" ");
}//GEN-LAST:event_btn_spaceActionPerformed

private void btn_charsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charsActionPerformed
// TODO add your handling code here:
//    do_num();
}//GEN-LAST:event_btn_charsActionPerformed

private void tf_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_usernameMouseClicked
// TODO add your handling code here:
    show_keyboard_user_name();
}//GEN-LAST:event_tf_usernameMouseClicked

    private void show_keyboard_user_name() {
        if (System.getProperty("touch", "false").
                equals("true")) {
            type = 1;
            tf_password.setVisible(false);
            tf_user_name.setVisible(true);
            tf_user_name.setText(tf_username.getText());
            show_cp();
        } else {
        }

    }

private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
// TODO add your handling code here:
//    hide_cp();
}//GEN-LAST:event_btn_returnActionPerformed

private void pf_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pf_passwordMouseClicked
// TODO add your handling code here:
    show_keyboard_user_password();
}//GEN-LAST:event_pf_passwordMouseClicked

    private void show_keyboard_user_password() {
        if (System.getProperty("touch", "false").
                equals("true")) {
            type = 2;
            tf_password.setVisible(true);
            tf_user_name.setVisible(false);
            tf_user_name.setText(pf_password.getText());
            show_cp();
        } else {
        }

    }
private void btn_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseClicked
// TODO add your handling code here:
    hide_cp();
}//GEN-LAST:event_btn_returnMouseClicked

    private void btn_capsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capsActionPerformed
        // TODO add your handling code here:
//        caps();
    }//GEN-LAST:event_btn_capsActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
//    clear_field();
//        this.dispose();
        out();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void tf_usernameMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_usernameMouseDragged
        // TODO add your handling code here:
        show_keyboard_user_name();
    }//GEN-LAST:event_tf_usernameMouseDragged

    private void pf_passwordMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pf_passwordMouseDragged
        // TODO add your handling code here:
        show_keyboard_user_password();
    }//GEN-LAST:event_pf_passwordMouseDragged

    private void btn_qMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qMouseDragged
        // TODO add your handling code here:
//          do_set(btn_q.getText());
//          evt.consume();
    }//GEN-LAST:event_btn_qMouseDragged

    private void btn_wMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_wMouseDragged
        // TODO add your handling code here:
//          do_set(btn_w.getText());
    }//GEN-LAST:event_btn_wMouseDragged

    private void btn_eMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eMouseDragged
        // TODO add your handling code here:
//          do_set(btn_e.getText());
    }//GEN-LAST:event_btn_eMouseDragged

    private void btn_rMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rMouseDragged
        // TODO add your handling code here:
//         do_set(btn_r.getText());
    }//GEN-LAST:event_btn_rMouseDragged

    private void btn_tMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tMouseDragged
        // TODO add your handling code here:
//         do_set(btn_t.getText());
    }//GEN-LAST:event_btn_tMouseDragged

    private void btn_yMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_yMouseDragged
        // TODO add your handling code here:
//          do_set(btn_y.getText());
    }//GEN-LAST:event_btn_yMouseDragged

    private void btn_uMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_uMouseDragged
        // TODO add your handling code here:
//          do_set(btn_u.getText());
    }//GEN-LAST:event_btn_uMouseDragged

    private void btn_iMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iMouseDragged
        // TODO add your handling code here:
//         do_set(btn_i.getText());
    }//GEN-LAST:event_btn_iMouseDragged

    private void btn_oMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_oMouseDragged
        // TODO add your handling code here:
//           do_set(btn_o.getText());
    }//GEN-LAST:event_btn_oMouseDragged

    private void btn_pMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pMouseDragged
        // TODO add your handling code here:
//         do_set(btn_p.getText());
    }//GEN-LAST:event_btn_pMouseDragged

    private void btn_aMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aMouseDragged
        // TODO add your handling code here:
//          do_set(btn_a.getText());
    }//GEN-LAST:event_btn_aMouseDragged

    private void btn_sMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sMouseDragged
        // TODO add your handling code here:
//          do_set(btn_s.getText());
    }//GEN-LAST:event_btn_sMouseDragged

    private void btn_dMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dMouseDragged
        // TODO add your handling code here:
//         do_set(btn_d.getText());
    }//GEN-LAST:event_btn_dMouseDragged

    private void btn_fMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fMouseDragged
        // TODO add your handling code here:
//         do_set(btn_f.getText());
    }//GEN-LAST:event_btn_fMouseDragged

    private void btn_gMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gMouseDragged
        // TODO add your handling code here:
//          do_set(btn_g.getText());
    }//GEN-LAST:event_btn_gMouseDragged

    private void btn_hMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hMouseDragged
        // TODO add your handling code here:
//         do_set(btn_h.getText());
    }//GEN-LAST:event_btn_hMouseDragged

    private void btn_jMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_jMouseDragged
        // TODO add your handling code here:
//          do_set(btn_j.getText());
    }//GEN-LAST:event_btn_jMouseDragged

    private void btn_kMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kMouseDragged
        // TODO add your handling code here:
//          do_set(btn_k.getText());
    }//GEN-LAST:event_btn_kMouseDragged

    private void btn_lMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lMouseDragged
        // TODO add your handling code here:
//          do_set(btn_l.getText());
    }//GEN-LAST:event_btn_lMouseDragged

    private void btn_capsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_capsMouseDragged
        // TODO add your handling code here:
//          caps();
    }//GEN-LAST:event_btn_capsMouseDragged

    private void btn_zMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_zMouseDragged
        // TODO add your handling code here:
//         do_set(btn_z.getText());
    }//GEN-LAST:event_btn_zMouseDragged

    private void btn_xMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xMouseDragged
        // TODO add your handling code here:
//         do_set(btn_x.getText());
    }//GEN-LAST:event_btn_xMouseDragged

    private void btn_cMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cMouseDragged
        // TODO add your handling code here:
//         do_set(btn_c.getText());
    }//GEN-LAST:event_btn_cMouseDragged

    private void btn_vMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vMouseDragged
        // TODO add your handling code here:
//          do_set(btn_v.getText());
    }//GEN-LAST:event_btn_vMouseDragged

    private void btn_bMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bMouseDragged
        // TODO add your handling code here:
//         do_set(btn_b.getText());
    }//GEN-LAST:event_btn_bMouseDragged

    private void btn_nMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nMouseDragged
        // TODO add your handling code here:
//          do_set(btn_n.getText());
    }//GEN-LAST:event_btn_nMouseDragged

    private void btn_mMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mMouseDragged
        // TODO add your handling code here:
//        do_set(btn_m.getText());
    }//GEN-LAST:event_btn_mMouseDragged

    private void btn_clear1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clear1MouseDragged
//         TODO add your handling code here:
        clear_field();
    }//GEN-LAST:event_btn_clear1MouseDragged

    private void btn_charsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_charsMouseDragged
        // TODO add your handling code here:
//          do_num();
    }//GEN-LAST:event_btn_charsMouseDragged

    private void btn_spaceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_spaceMouseDragged
        // TODO add your handling code here:
//         do_set(" ");
    }//GEN-LAST:event_btn_spaceMouseDragged

    private void btn_qMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qMouseReleased
        // TODO add your handling code here:
        do_set(btn_q.getText());
    }//GEN-LAST:event_btn_qMouseReleased

    private void btn_wMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_wMouseReleased
        // TODO add your handling code here:
        do_set(btn_w.getText());
    }//GEN-LAST:event_btn_wMouseReleased

    private void btn_eMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eMouseReleased
        // TODO add your handling code here:
        do_set(btn_e.getText());
    }//GEN-LAST:event_btn_eMouseReleased

    private void btn_rMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rMouseReleased
        // TODO add your handling code here:
        do_set(btn_r.getText());
    }//GEN-LAST:event_btn_rMouseReleased

    private void btn_tMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tMouseReleased
        // TODO add your handling code here:
        do_set(btn_t.getText());
    }//GEN-LAST:event_btn_tMouseReleased

    private void btn_yMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_yMouseReleased
        // TODO add your handling code here:
        do_set(btn_y.getText());
    }//GEN-LAST:event_btn_yMouseReleased

    private void btn_uMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_uMouseReleased
        // TODO add your handling code here:
        do_set(btn_u.getText());
    }//GEN-LAST:event_btn_uMouseReleased

    private void btn_iMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iMouseReleased
        // TODO add your handling code here:
        do_set(btn_i.getText());
    }//GEN-LAST:event_btn_iMouseReleased

    private void btn_oMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_oMouseReleased
        // TODO add your handling code here:
        do_set(btn_o.getText());
    }//GEN-LAST:event_btn_oMouseReleased

    private void btn_pMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pMouseReleased
        // TODO add your handling code here:
        do_set(btn_p.getText());
    }//GEN-LAST:event_btn_pMouseReleased

    private void btn_aMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aMouseReleased
        // TODO add your handling code here:
        do_set(btn_a.getText());
    }//GEN-LAST:event_btn_aMouseReleased

    private void btn_sMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sMouseReleased
        // TODO add your handling code here:
        do_set(btn_s.getText());
    }//GEN-LAST:event_btn_sMouseReleased

    private void btn_dMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dMouseReleased
        // TODO add your handling code here:
        do_set(btn_d.getText());
    }//GEN-LAST:event_btn_dMouseReleased

    private void btn_fMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fMouseReleased
        // TODO add your handling code here:
        do_set(btn_f.getText());
    }//GEN-LAST:event_btn_fMouseReleased

    private void btn_gMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gMouseReleased
        // TODO add your handling code here:
        do_set(btn_g.getText());
    }//GEN-LAST:event_btn_gMouseReleased

    private void btn_hMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hMouseReleased
        // TODO add your handling code here:
        do_set(btn_h.getText());
    }//GEN-LAST:event_btn_hMouseReleased

    private void btn_jMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_jMouseReleased
        // TODO add your handling code here:
        do_set(btn_j.getText());
    }//GEN-LAST:event_btn_jMouseReleased

    private void btn_kMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kMouseReleased
        // TODO add your handling code here:
        do_set(btn_k.getText());
    }//GEN-LAST:event_btn_kMouseReleased

    private void btn_lMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lMouseReleased
        // TODO add your handling code here:
        do_set(btn_l.getText());
    }//GEN-LAST:event_btn_lMouseReleased

    private void btn_capsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_capsMouseReleased
        // TODO add your handling code here:
        caps();
    }//GEN-LAST:event_btn_capsMouseReleased

    private void btn_zMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_zMouseReleased
        // TODO add your handling code here:
        do_set(btn_z.getText());
    }//GEN-LAST:event_btn_zMouseReleased

    private void btn_xMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xMouseReleased
        // TODO add your handling code here:
        do_set(btn_x.getText());
    }//GEN-LAST:event_btn_xMouseReleased

    private void btn_cMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cMouseReleased
        // TODO add your handling code here:
        do_set(btn_c.getText());
    }//GEN-LAST:event_btn_cMouseReleased

    private void btn_vMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vMouseReleased
        // TODO add your handling code here:
        do_set(btn_v.getText());
    }//GEN-LAST:event_btn_vMouseReleased

    private void btn_bMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bMouseReleased
        // TODO add your handling code here:
        do_set(btn_b.getText());
    }//GEN-LAST:event_btn_bMouseReleased

    private void btn_nMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nMouseReleased
        // TODO add your handling code here:
        do_set(btn_n.getText());
    }//GEN-LAST:event_btn_nMouseReleased

    private void btn_mMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mMouseReleased
        // TODO add your handling code here:
        do_set(btn_m.getText());
    }//GEN-LAST:event_btn_mMouseReleased

    private void btn_clear1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clear1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clear1MouseReleased

    private void btn_charsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_charsMouseReleased
        // TODO add your handling code here:
        do_num();
    }//GEN-LAST:event_btn_charsMouseReleased

    private void btn_spaceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_spaceMouseReleased
        // TODO add your handling code here:
        do_set(" ");
    }//GEN-LAST:event_btn_spaceMouseReleased

    private void btn_returnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseReleased
        // TODO add your handling code here:
        hide_cp();
    }//GEN-LAST:event_btn_returnMouseReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_a;
    private javax.swing.JButton btn_b;
    private javax.swing.JButton btn_c;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JToggleButton btn_caps;
    private javax.swing.JToggleButton btn_chars;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_clear1;
    private javax.swing.JButton btn_d;
    private javax.swing.JButton btn_e;
    private javax.swing.JButton btn_f;
    private javax.swing.JButton btn_g;
    private javax.swing.JButton btn_h;
    private javax.swing.JButton btn_i;
    private javax.swing.JButton btn_j;
    private javax.swing.JButton btn_k;
    private javax.swing.JButton btn_l;
    private javax.swing.JButton btn_m;
    private javax.swing.JButton btn_n;
    private javax.swing.JButton btn_o;
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_p;
    private javax.swing.JButton btn_q;
    private javax.swing.JButton btn_r;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_s;
    private javax.swing.JButton btn_space;
    private javax.swing.JButton btn_t;
    private javax.swing.JButton btn_u;
    private javax.swing.JButton btn_v;
    private javax.swing.JButton btn_w;
    private javax.swing.JButton btn_x;
    private javax.swing.JButton btn_y;
    private javax.swing.JButton btn_z;
    private org.jdesktop.swingx.JXCollapsiblePane cp_menu;
    private javax.swing.JLabel ds_error;
    private javax.swing.JLabel ds_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JPanel pnl_log;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_user_name;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">
    int type = 0;

    private void myInit() {
        init_cp();
        initActionKey();
        initHideError();
        initXButton();
        init_limit_username();
    }
    int i = 0;
    Timer t = new Timer(100, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (i == 1) {
                pnl_log.setVisible(false);
                i = 0;
                t.stop();
            }
            i++;
        }
    });

    private void init_cp() {
        cp_menu.setVisible(false);
        cp_menu.setCollapsed(true);
    }

    private void show_cp() {

        cp_menu.setCollapsed(false);
        cp_menu.setVisible(true);
//         tf_user_name.setText("");
        t.start();
    }

    private void hide_cp() {

        cp_menu.setCollapsed(true);
//        cp_menu.setVisible(false);
        pnl_log.setVisible(true);

        if (type == 1) {
            tf_username.setFocusable(true);
            tf_username.setCaretPosition(0);
            tf_username.setText(tf_user_name.getText());
//            tf_holder.setText("");
        }
        if (type == 2) {
            pf_password.setFocusable(true);
            pf_password.setCaretPosition(0);
            pf_password.setText(tf_password.getText());
//            JOptionPane.showMessageDialog(null, tf_holder.getText());
//            tf_holder.setText("");
        }

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
                KeyEvent.VK_F10, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (System.getProperty("admin", "true").
                        equals("true")) {
                    set_ver();
                }
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

    private void set_ver() {
        Window p = (Window) this;
        Dlg_version nd = Dlg_version.create(p, true);
        nd.setTitle("");
//                   nd.do_pass("");
        nd.setCallback(new Dlg_version.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_version.OutputData data) {
                closeDialog.ok();
                System.setProperty("version", data.version);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }
    //</editor-fold>

    private void caps() {
        if (btn_caps.isSelected()) {
            btn_caps.setText("[A]");
            do_num();
        } else {
            btn_caps.setText("[a]");
            do_num();
        }
    }

    private void out() {
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
        if (callback != null) {
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

        int check_in = 0;
        int check_out = 0;
        final String un = tf_username.getText();
        final String pw = new String(pf_password.getPassword());
        if (!S9_confirm_user.conf_user(un, pw)) {
            Prompt.call("Wrong UserName/Password");
            tf_username.setText("");
            pf_password.setText("");
            tf_user_name.setText("");
            tf_username.grabFocus();
            tf_username.setCaretPosition(0);
        } else {
            int lvl = S14_chech_if_admin.do_check_if_adming(tf_username.getText());
            if (lvl != 1) {
                String cashiering_for = System.getProperty("cashiering_for", "retail_store");
                if (cashiering_for.equals("endorsements")) {
                    Prompt.call("Wrong UserName/Password");
                    tf_username.setText("");
                    pf_password.setText("");
                    tf_user_name.setText("");
                    tf_username.grabFocus();
                    tf_username.setCaretPosition(0);
                    return;
                }
                String version = System.getProperty("version", "ordering");
//                JOptionPane.showMessageDialog(null, version);
                final int user_level = S12_retval_user_level.get_user_level(un);
                if (version.equals("ordering")) {
                    if (user_level == 7 || user_level == 0 || user_level == 1) {
                    } else {
                        Prompt.call("Wrong UserName/Password");
                        tf_username.setText("");
                        pf_password.setText("");
                        tf_user_name.setText("");
                        tf_username.grabFocus();
                        tf_username.setCaretPosition(0);
                        return;
                    }
                }
                if (version.equals("retail")) {
                    if (user_level == 6 || user_level == 7 || user_level == 5) {
                        Prompt.call("Wrong UserName/Password");
                        tf_username.setText("");
                        pf_password.setText("");
                        tf_user_name.setText("");
                        tf_username.grabFocus();
                        tf_username.setCaretPosition(0);
                        return;
                    } else {
                    }
                }
                if (version.equals("resto")) {
                    if (user_level == 5 || user_level == 6) {

                        String strict_cashout = System.getProperty("strict_cashout", "false");
                        if (strict_cashout.equals("true")) {
                            String check = S9_cashier_session.check_strict(un, user_level);
                            if (check.equals("-1")) {
                            } else {
                                Prompt.call("Previous Shift Must Log-out");
                                tf_username.setText("");
                                pf_password.setText("");
                                tf_user_name.setText("");
                                tf_username.grabFocus();
                                tf_username.setCaretPosition(0);
                                return;
                            }
                        }
                    } else {
                        Prompt.call("Wrong UserName/Password");
                        tf_username.setText("");
                        pf_password.setText("");
                        tf_user_name.setText("");
                        tf_username.grabFocus();
                        tf_username.setCaretPosition(0);
                        return;
                    }
                }
                int cashier_session_id = S12_cashier_sessions.get_cashier_ses_id(un);
                String log = S12_cashier_sessions.is_logout(un);

                if (log.equals("yes")) {
                    if (version.equals("ordering")) {
                        if (user_level == 7) {
                            do_ok(un, pw);
                        } else {
                            Window w = (Window) this;
                            Dlg_cash_in d = Dlg_cash_in.create(w, true);
                            d.setTitle("Cash-in");
                            d.pass(new Dlg_cash_in.InputData(cashier_session_id, un));
                            d.pass2(user_level);
                            d.setCallback(new Dlg_cash_in.Callback() {

                                @Override
                                public void ok(CloseDialog cd, Dlg_cash_in.OutputData data) {
                                    cd.ok();
                                }
                            });
//                    Application.locateOnParentCenter(w, d);
                            Center.setCenter(d);
                            d.setVisible(true);
                        }
                    } else {
                        Window w = (Window) this;
                        Dlg_cash_in d = Dlg_cash_in.create(w, true);
                        d.setTitle("Cash-in");
                        d.pass(new Dlg_cash_in.InputData(cashier_session_id, un));
                        d.pass2(user_level);
                        d.setCallback(new Dlg_cash_in.Callback() {

                            @Override
                            public void ok(CloseDialog cd, Dlg_cash_in.OutputData data) {
                                cd.ok();
                            }
                        });

//                    Application.locateOnParentCenter(w, d);
                        Center.setCenter(d);

                        d.setVisible(true);
                    }


                } else {
                }
                do_ok(un, pw);
            } else {
                do_ok(un, pw);
            }


        }


    }

    private void do_ok(String un, String pw) {
        this.dispose();
        callback.ok(new CloseDialog(this), new OutputData(un, pw, 0, 0));

        tf_username.setText("");
        pf_password.setText("");
    }
    JTextField tf_holder = new JTextField();

    private void do_set(String data) {

        if (btn_caps.isSelected()) {
            data = data.toUpperCase();
        } else {
            data = data.toLowerCase();
        }

//        JOptionPane.showMessageDialog(null, type);
        if (type == 1) {
            tf_user_name.setText(TextInserter.setText(tf_user_name.getText(), data));
        }
        if (type == 2) {
            tf_password.setText(TextInserter.setText(tf_password.getText(), data));
        }

    }

    private void do_num() {
        if (btn_chars.isSelected()) {

            if (btn_caps.isSelected()) {

                //------------------\
                btn_q.setText("Q");
                btn_w.setText("W");
                btn_e.setText("E");
                btn_r.setText("R");
                btn_t.setText("T");
                btn_y.setText("Y");
                btn_u.setText("U");
                btn_i.setText("I");
                btn_o.setText("O");
                btn_p.setText("P");

                btn_a.setText("A");
                btn_s.setText("S");
                btn_d.setText("D");
                btn_f.setText("F");
                btn_g.setText("G");
                btn_h.setText("H");
                btn_j.setText("J");
                btn_k.setText("K");
                btn_l.setText("L");

                btn_z.setText("Z");
                btn_x.setText("X");
                btn_c.setText("C");
                btn_v.setText("V");
                btn_b.setText("B");
                btn_n.setText("N");
                btn_m.setText("M");
            } else {
                btn_q.setText("q");
                btn_w.setText("w");
                btn_e.setText("e");
                btn_r.setText("r");
                btn_t.setText("t");
                btn_y.setText("y");
                btn_u.setText("u");
                btn_i.setText("i");
                btn_o.setText("o");
                btn_p.setText("p");



                btn_a.setText("a");
                btn_s.setText("s");
                btn_d.setText("d");
                btn_f.setText("f");
                btn_g.setText("g");
                btn_h.setText("h");
                btn_j.setText("j");
                btn_k.setText("k");
                btn_l.setText("l");

                btn_z.setText("z");
                btn_x.setText("x");
                btn_c.setText("c");
                btn_v.setText("v");
                btn_b.setText("b");
                btn_n.setText("n");
                btn_m.setText("m");
            }



        } else {


            btn_q.setText("1");
            btn_w.setText("2");
            btn_e.setText("3");
            btn_r.setText("4");
            btn_t.setText("5");
            btn_y.setText("6");
            btn_u.setText("7");
            btn_i.setText("8");
            btn_o.setText("9");
            btn_p.setText("0");



            btn_a.setText("@");
            btn_s.setText("#");
            btn_d.setText("%");
            btn_f.setText("&");
            btn_g.setText("*");
            btn_h.setText("/");
            btn_j.setText("$");
            btn_k.setText("(");
            btn_l.setText(")");

            btn_z.setText("?");
            btn_x.setText("!");
            btn_c.setText("^");
            btn_v.setText("'");
            btn_b.setText(":");
            btn_n.setText(";");
            btn_m.setText(",");

        }
    }

    private void clear_field() {

        JLabel lb = new JLabel();
        lb.setText(tf_user_name.getText());
        Backspace.clear_lbl(lb);
        tf_user_name.setText(lb.getText());
//        tf_dummy.setText(tf_text.getText());

        JLabel lbl = new JLabel();
        lbl.setText(tf_password.getText());
        Backspace.clear_lbl(lbl);
        tf_password.setText(lb.getText());
    }

    private void keyboard(final JTextField tf) {
        Window p = (Window) this;
        dlg_keyboard nd = dlg_keyboard.create(p, true);
        nd.setTitle("");
        nd.do_pass(tf.getText());
        nd.setCallback(new dlg_keyboard.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, dlg_keyboard.OutputData data) {
//                closeDialog.ok();
                tf.setText(data.name);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }
}
