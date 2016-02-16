/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * dlg_keyboard.java
 *
 * Created on Apr 1, 2012, 6:38:47 PM
 */
package POS.dlg2;

import POS.utl.Backspace;
import POS.utl.TextInserter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author u2
 */
public class dlg_keyboard2 extends javax.swing.JDialog {

    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void ok1(CloseDialog closeDialog, OutputData data);
    }

    public static class OutputData {

        public final String name;

        public OutputData(String name) {
            this.name = name;
        }
    }

    public static class InputData {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private dlg_keyboard2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private dlg_keyboard2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public dlg_keyboard2() {
        super();
        initComponents();
        myInit();

    }
    private dlg_keyboard2 myRef;

    private void setThisRef(dlg_keyboard2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, dlg_keyboard2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static dlg_keyboard2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static dlg_keyboard2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            dlg_keyboard2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new dlg_keyboard2((java.awt.Frame) parent, false);
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
            dlg_keyboard2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new dlg_keyboard2((java.awt.Dialog) parent, false);
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


        dlg_keyboard2 dialog = dlg_keyboard2.create(new javax.swing.JFrame(), true);
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
        btn_clear = new javax.swing.JButton();
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
        tf_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(717, 350));
        setUndecorated(true);
        getContentPane().setLayout(null);

        cp_menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jXPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jXPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_w.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_w.setText("W");
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
        jXPanel1.add(btn_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 60, 50));

        btn_q.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_q.setText("Q");
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
        jXPanel1.add(btn_q, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 50));

        btn_e.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_e.setText("E");
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
        jXPanel1.add(btn_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 60, 50));

        btn_r.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_r.setText("R");
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
        jXPanel1.add(btn_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 60, 50));

        btn_t.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_t.setText("T");
        btn_t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tMouseClicked(evt);
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
        jXPanel1.add(btn_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 60, 50));

        btn_y.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_y.setText("Y");
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
        jXPanel1.add(btn_y, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 60, 50));

        btn_u.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_u.setText("U");
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
        jXPanel1.add(btn_u, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 60, 50));

        btn_i.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_i.setText("I");
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
        jXPanel1.add(btn_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 60, 50));

        btn_o.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_o.setText("O");
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
        jXPanel1.add(btn_o, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 60, 50));

        btn_p.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_p.setText("P");
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
        jXPanel1.add(btn_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 60, 50));

        btn_a.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_a.setText("A");
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
        jXPanel1.add(btn_a, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 60, 50));

        btn_s.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_s.setText("S");
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
        jXPanel1.add(btn_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 60, 50));

        btn_d.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_d.setText("D");
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
        jXPanel1.add(btn_d, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 60, 50));

        btn_f.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_f.setText("F");
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
        jXPanel1.add(btn_f, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 60, 50));

        btn_g.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_g.setText("G");
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
        jXPanel1.add(btn_g, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 60, 50));

        btn_h.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_h.setText("H");
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
        jXPanel1.add(btn_h, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 60, 50));

        btn_j.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_j.setText("J");
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
        jXPanel1.add(btn_j, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 60, 50));

        btn_k.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_k.setText("K");
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
        jXPanel1.add(btn_k, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 60, 50));

        btn_l.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_l.setText("L");
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
        jXPanel1.add(btn_l, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 60, 50));

        btn_clear.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_clear.setText("CLEAR");
        btn_clear.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_clearMouseDragged(evt);
            }
        });
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 110, 50));

        btn_x.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_x.setText("X");
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
        jXPanel1.add(btn_x, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 60, 50));

        btn_c.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_c.setText("C");
        btn_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cMouseClicked(evt);
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
        jXPanel1.add(btn_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 60, 50));

        btn_v.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_v.setText("V");
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
        jXPanel1.add(btn_v, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 60, 50));

        btn_b.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_b.setText("B");
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
        jXPanel1.add(btn_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 60, 50));

        btn_n.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_n.setText("N");
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
        jXPanel1.add(btn_n, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 60, 50));

        btn_m.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_m.setText("M");
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
        jXPanel1.add(btn_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 60, 50));

        btn_z.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_z.setText("Z");
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
        jXPanel1.add(btn_z, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 60, 50));

        btn_space.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_space.setText("SPACE");
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
        jXPanel1.add(btn_space, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 420, 50));

        btn_return.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_return.setText("ENTER");
        btn_return.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btn_returnMouseDragged(evt);
            }
        });
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        jXPanel1.add(btn_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 140, 50));

        btn_caps.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_caps.setSelected(true);
        btn_caps.setText("[A]");
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
        jXPanel1.add(btn_caps, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 80, 50));

        btn_chars.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        btn_chars.setSelected(true);
        btn_chars.setText(".?123");
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
        jXPanel1.add(btn_chars, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 100, 50));

        tf_text.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tf_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_textActionPerformed(evt);
            }
        });
        tf_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_textKeyReleased(evt);
            }
        });
        jXPanel1.add(tf_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, 690, 40));

        javax.swing.GroupLayout cp_menuLayout = new javax.swing.GroupLayout(cp_menu.getContentPane());
        cp_menu.getContentPane().setLayout(cp_menuLayout);
        cp_menuLayout.setHorizontalGroup(
            cp_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cp_menuLayout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cp_menuLayout.setVerticalGroup(
            cp_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cp_menuLayout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        getContentPane().add(cp_menu);
        cp_menu.setBounds(0, -5, 720, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_qActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_qActionPerformed
// TODO add your handling code here:
    do_set(btn_q.getText());
}//GEN-LAST:event_btn_qActionPerformed

private void btn_wActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_wActionPerformed
// TODO add your handling code here:do_set(btn_Q");
    do_set(btn_w.getText());
}//GEN-LAST:event_btn_wActionPerformed

private void btn_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eActionPerformed
// TODO add your handling code here:
    do_set(btn_e.getText());
}//GEN-LAST:event_btn_eActionPerformed

private void btn_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rActionPerformed
// TODO add your handling code here:
    do_set(btn_r.getText());
}//GEN-LAST:event_btn_rActionPerformed

private void btn_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tActionPerformed
// TODO add your handling code here:
    do_set(btn_t.getText());
}//GEN-LAST:event_btn_tActionPerformed

private void btn_yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yActionPerformed
// TODO add your handling code here:
    do_set(btn_y.getText());
}//GEN-LAST:event_btn_yActionPerformed

private void btn_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uActionPerformed
// TODO add your handling code here:
    do_set(btn_u.getText());
}//GEN-LAST:event_btn_uActionPerformed

private void btn_iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iActionPerformed
// TODO add your handling code here:
    do_set(btn_i.getText());
}//GEN-LAST:event_btn_iActionPerformed

private void btn_oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oActionPerformed
// TODO add your handling code here:
    do_set(btn_o.getText());
}//GEN-LAST:event_btn_oActionPerformed

private void btn_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pActionPerformed
// TODO add your handling code here:
    do_set(btn_p.getText());
}//GEN-LAST:event_btn_pActionPerformed

private void btn_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aActionPerformed
// TODO add your handling code here:
    do_set(btn_a.getText());
}//GEN-LAST:event_btn_aActionPerformed

private void btn_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sActionPerformed
// TODO add your handling code here:
    do_set(btn_s.getText());
}//GEN-LAST:event_btn_sActionPerformed

private void btn_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dActionPerformed
// TODO add your handling code here:
    do_set(btn_d.getText());
}//GEN-LAST:event_btn_dActionPerformed

private void btn_fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fActionPerformed
// TODO add your handling code here:
    do_set(btn_f.getText());
}//GEN-LAST:event_btn_fActionPerformed

private void btn_gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gActionPerformed
// TODO add your handling code here:
    do_set(btn_g.getText());
}//GEN-LAST:event_btn_gActionPerformed

private void btn_hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hActionPerformed
// TODO add your handling code here:
    do_set(btn_h.getText());
}//GEN-LAST:event_btn_hActionPerformed

private void btn_jActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jActionPerformed
// TODO add your handling code here:
    do_set(btn_j.getText());
}//GEN-LAST:event_btn_jActionPerformed

private void btn_kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kActionPerformed
// TODO add your handling code here:
    do_set(btn_k.getText());
}//GEN-LAST:event_btn_kActionPerformed

private void btn_lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lActionPerformed
// TODO add your handling code here:
    do_set(btn_l.getText());
}//GEN-LAST:event_btn_lActionPerformed

private void btn_zActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_zActionPerformed
// TODO add your handling code here:
    do_set(btn_z.getText());
}//GEN-LAST:event_btn_zActionPerformed

private void btn_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xActionPerformed
// TODO add your handling code here:
    do_set(btn_x.getText());
}//GEN-LAST:event_btn_xActionPerformed

private void btn_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cActionPerformed
// TODO add your handling code here:
    do_set(btn_c.getText());
}//GEN-LAST:event_btn_cActionPerformed

private void btn_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vActionPerformed
// TODO add your handling code here:
    do_set(btn_v.getText());
}//GEN-LAST:event_btn_vActionPerformed

private void btn_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bActionPerformed
// TODO add your handling code here:
    do_set(btn_b.getText());
}//GEN-LAST:event_btn_bActionPerformed

private void btn_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nActionPerformed
// TODO add your handling code here:
    do_set(btn_n.getText());
}//GEN-LAST:event_btn_nActionPerformed

private void btn_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mActionPerformed
// TODO add your handling code here:
    do_set(btn_m.getText());
}//GEN-LAST:event_btn_mActionPerformed

private void btn_spaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_spaceActionPerformed
// TODO add your handling code here:
    do_set(" ");
}//GEN-LAST:event_btn_spaceActionPerformed

private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
// TODO add your handling code here:
    clear_field();
}//GEN-LAST:event_btn_clearActionPerformed

private void btn_charsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_charsActionPerformed
// TODO add your handling code here:
    do_num();
}//GEN-LAST:event_btn_charsActionPerformed

    private void btn_capsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capsActionPerformed
        // TODO add your handling code here:
        caps();
    }//GEN-LAST:event_btn_capsActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        // TODO add your handling code here:
//        ok1();
        ok2();
        this.dispose();
    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_qMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qMouseDragged
        // TODO add your handling code here:
//         do_set(btn_q.getText());
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
//          do_set(btn_r.getText());
    }//GEN-LAST:event_btn_rMouseDragged

    private void btn_tMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tMouseClicked

    private void btn_tMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tMouseDragged
        // TODO add your handling code here:
//           do_set(btn_t.getText());
    }//GEN-LAST:event_btn_tMouseDragged

    private void btn_yMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_yMouseDragged
        // TODO add your handling code here:
//         do_set(btn_y.getText());
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
//         do_set(btn_o.getText());
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
//         do_set(btn_s.getText());
    }//GEN-LAST:event_btn_sMouseDragged

    private void btn_dMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dMouseDragged
        // TODO add your handling code here:
//         do_set(btn_d.getText());
    }//GEN-LAST:event_btn_dMouseDragged

    private void btn_fMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fMouseDragged
        // TODO add your handling code here:
//          do_set(btn_f.getText());
    }//GEN-LAST:event_btn_fMouseDragged

    private void btn_gMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gMouseDragged
        // TODO add your handling code here:
//         do_set(btn_g.getText());
    }//GEN-LAST:event_btn_gMouseDragged

    private void btn_hMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hMouseDragged
        // TODO add your handling code here:
//         do_set(btn_h.getText());
    }//GEN-LAST:event_btn_hMouseDragged

    private void btn_jMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_jMouseDragged
//         TODO add your handling code here:
//          do_set(btn_j.getText());
    }//GEN-LAST:event_btn_jMouseDragged

    private void btn_kMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kMouseDragged
        // TODO add your handling code here:
//        do_set(btn_k.getText());
    }//GEN-LAST:event_btn_kMouseDragged

    private void btn_lMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lMouseDragged
        // TODO add your handling code here:
//         do_set(btn_l.getText());
    }//GEN-LAST:event_btn_lMouseDragged

    private void btn_capsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_capsMouseDragged
        // TODO add your handling code here:
//            caps();
    }//GEN-LAST:event_btn_capsMouseDragged

    private void btn_zMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_zMouseDragged
        // TODO add your handling code here:
//          do_set(btn_z.getText());
    }//GEN-LAST:event_btn_zMouseDragged

    private void btn_xMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xMouseDragged
        // TODO add your handling code here:
//         do_set(btn_x.getText());
    }//GEN-LAST:event_btn_xMouseDragged

    private void btn_cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cMouseClicked

    private void btn_cMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cMouseDragged
        // TODO add your handling code here:
//         do_set(btn_c.getText());
    }//GEN-LAST:event_btn_cMouseDragged

    private void btn_vMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vMouseDragged
        // TODO add your handling code here:
//        do_set(btn_v.getText());
    }//GEN-LAST:event_btn_vMouseDragged

    private void btn_bMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bMouseDragged
        // TODO add your handling code here:
//          do_set(btn_b.getText());
    }//GEN-LAST:event_btn_bMouseDragged

    private void btn_nMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nMouseDragged
        // TODO add your handling code here:
//         do_set(btn_n.getText());
    }//GEN-LAST:event_btn_nMouseDragged

    private void btn_mMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mMouseDragged
        // TODO add your handling code here:
//          do_set(btn_m.getText());
    }//GEN-LAST:event_btn_mMouseDragged

    private void btn_clearMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseDragged
        // TODO add your handling code here:
//         clear_field();
    }//GEN-LAST:event_btn_clearMouseDragged

    private void btn_charsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_charsMouseDragged
        // TODO add your handling code here:
//         do_num();
    }//GEN-LAST:event_btn_charsMouseDragged

    private void btn_spaceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_spaceMouseDragged
        // TODO add your handling code here:
//          do_set(" ");
    }//GEN-LAST:event_btn_spaceMouseDragged

    private void btn_returnMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnMouseDragged
        // TODO add your handling code here:
//         ok1();
//         this.dispose();
    }//GEN-LAST:event_btn_returnMouseDragged

    private void tf_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_textKeyReleased
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_tf_textKeyReleased

    private void tf_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_textActionPerformed
        // TODO add your handling code here:
        ok1();
        this.disposed();
//        JOptionPane.showMessageDialog(null, "adadad");
    }//GEN-LAST:event_tf_textActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_a;
    private javax.swing.JButton btn_b;
    private javax.swing.JButton btn_c;
    private javax.swing.JToggleButton btn_caps;
    private javax.swing.JToggleButton btn_chars;
    private javax.swing.JButton btn_clear;
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
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private javax.swing.JTextField tf_text;
    // End of variables declaration//GEN-END:variables
    //<editor-fold defaultstate="collapsed" desc=" myInit ">

    private void myInit() {
        initActionKey();
        init_cp();
        show_cp();
    }

    public void do_pass(String name) {
        tf_text.setText(name);
    }

    private void init_cp() {
        cp_menu.setVisible(false);
        cp_menu.setCollapsed(true);

    }

    private void show_cp() {

        cp_menu.setCollapsed(false);
        cp_menu.setVisible(true);
    }

    private void hide_cp() {
//        cp_menu.setVisible(false);
        cp_menu.setCollapsed(true);
    }

    private void disposed() {
        this.dispose();
    }

    private void initActionKey() {

        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                disposed();
            }
        });
    }
    //</editor-fold>

    private void clear_field() {

        Backspace.clear_lbl(tf_text);
        ok1();
//        tf_dummy.setText(tf_text.getText());

    }

    private void caps() {
        if (btn_caps.isSelected()) {
            btn_caps.setText("[A]");
            do_num();
        } else {
            btn_caps.setText("[a]");
            do_num();
        }
    }

    public void load(InputData data) {
    }

    private void cancel() {
        this.setVisible(false);
    }

//    private void do_ok() {
//        if (callback == null) {
//            return;
//        }
//
//        Executor.doExecute(this, new Executor.Task() {
//
//            @Override
//            public void work_on() {
//                prcss_work_on();
//            }
//        });
//    }
//    private void prcss_work_on() {
//        callback.ok(new CloseDialog(this), new OutputData());
//    }
    private void do_set(String data) {
//        btn_space
        if (btn_caps.isSelected()) {
            data = data.toUpperCase();
        } else {
            data = data.toLowerCase();
        }

        tf_text.setText(TextInserter.setText(tf_text.getText(), data));
        ok1();
    }

    private void do_num() {
        if (btn_chars.isSelected()) {

            if (btn_caps.isSelected()) {
                btn_chars.setText(".?123");

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

            btn_chars.setText(".?ABC");

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

    private void ad(){
        JOptionPane.showMessageDialog(null, "adadad");
    }
    private void ok1() {
//        ad();
        if(tf_text.getText().isEmpty() ||tf_text.getText().equals("") ){
            return;
        }
        System.out.println(tf_text.getText() + "----");
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(tf_text.getText()));
        }

    }

    private void ok2() {
        if (callback != null) {
            callback.ok1(new CloseDialog(this), new OutputData(tf_text.getText()));
        }

    }
}
