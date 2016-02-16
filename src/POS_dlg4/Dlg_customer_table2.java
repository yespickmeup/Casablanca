/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_dlg4;

import POS_svc4.S5_customer_tables;
import POS_to4.to_customer_table;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_customer_table2 extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_customer_table2
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void order(CloseDialog closeDialog, Dlg_customer_table2.OutputData data);

        void pay(CloseDialog closeDialog, Dlg_customer_table2.OutputData data);

        void add_order(CloseDialog closeDialog, Dlg_customer_table2.OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final String table_no;

        public OutputData(String table_no) {
            this.table_no = table_no;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_customer_table2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_customer_table2(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_customer_table2() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_customer_table2 myRef;

    private void setThisRef(Dlg_customer_table2 myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_customer_table2> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_customer_table2 create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_customer_table2 create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_customer_table2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_table2((java.awt.Frame) parent, false);
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
            Dlg_customer_table2 dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_customer_table2((java.awt.Dialog) parent, false);
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


        Dlg_customer_table2 dialog = Dlg_customer_table2.create(new javax.swing.JFrame(), true);
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

        jPanel3 = new javax.swing.JPanel();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_10 = new javax.swing.JButton();
        btn_11 = new javax.swing.JButton();
        btn_12 = new javax.swing.JButton();
        btn_13 = new javax.swing.JButton();
        btn_14 = new javax.swing.JButton();
        btn_15 = new javax.swing.JButton();
        btn_16 = new javax.swing.JButton();
        btn_17 = new javax.swing.JButton();
        btn_18 = new javax.swing.JButton();
        btn_19 = new javax.swing.JButton();
        btn_20 = new javax.swing.JButton();
        btn_21 = new javax.swing.JButton();
        btn_22 = new javax.swing.JButton();
        btn_23 = new javax.swing.JButton();
        btn_24 = new javax.swing.JButton();
        btn_25 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lb_standby2 = new javax.swing.JLabel();
        lb_standby_pagedown2 = new javax.swing.JLabel();
        jButton55 = new javax.swing.JButton();
        lb_standby1 = new javax.swing.JLabel();
        lb_standby_pagedown1 = new javax.swing.JLabel();
        jButton53 = new javax.swing.JButton();
        lb_standby = new javax.swing.JLabel();
        lb_standby_pagedown = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(159, 207, 243));

        btn_1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_1.setText("TABLE 1");
        btn_1.setFocusable(false);
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });

        btn_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_2.setText("TABLE 1");
        btn_2.setFocusable(false);
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });

        btn_3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_3.setText("TABLE 1");
        btn_3.setFocusable(false);
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });

        btn_4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_4.setForeground(java.awt.Color.black);
        btn_4.setText("TABLE 1");
        btn_4.setFocusable(false);
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });

        btn_5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_5.setText("TABLE 1");
        btn_5.setFocusable(false);
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });

        btn_6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_6.setText("TABLE 1");
        btn_6.setFocusable(false);
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });

        btn_7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_7.setText("TABLE 1");
        btn_7.setFocusable(false);
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });

        btn_8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_8.setText("TABLE 1");
        btn_8.setFocusable(false);
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });

        btn_9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_9.setText("TABLE 1");
        btn_9.setFocusable(false);
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });

        btn_10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_10.setText("TABLE 1");
        btn_10.setFocusable(false);
        btn_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_10ActionPerformed(evt);
            }
        });

        btn_11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_11.setText("TABLE 1");
        btn_11.setFocusable(false);
        btn_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_11ActionPerformed(evt);
            }
        });

        btn_12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_12.setText("TABLE 1");
        btn_12.setFocusable(false);
        btn_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_12ActionPerformed(evt);
            }
        });

        btn_13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_13.setText("TABLE 1");
        btn_13.setFocusable(false);
        btn_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_13ActionPerformed(evt);
            }
        });

        btn_14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_14.setText("TABLE 1");
        btn_14.setFocusable(false);
        btn_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_14ActionPerformed(evt);
            }
        });

        btn_15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_15.setText("TABLE 1");
        btn_15.setFocusable(false);
        btn_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_15ActionPerformed(evt);
            }
        });

        btn_16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_16.setText("TABLE 1");
        btn_16.setFocusable(false);
        btn_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_16ActionPerformed(evt);
            }
        });

        btn_17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_17.setText("TABLE 1");
        btn_17.setFocusable(false);
        btn_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_17ActionPerformed(evt);
            }
        });

        btn_18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_18.setText("TABLE 1");
        btn_18.setFocusable(false);
        btn_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_18ActionPerformed(evt);
            }
        });

        btn_19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_19.setText("TABLE 1");
        btn_19.setFocusable(false);
        btn_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_19ActionPerformed(evt);
            }
        });

        btn_20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_20.setText("TABLE 1");
        btn_20.setFocusable(false);
        btn_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_20ActionPerformed(evt);
            }
        });

        btn_21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_21.setText("TABLE 1");
        btn_21.setFocusable(false);
        btn_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_21ActionPerformed(evt);
            }
        });

        btn_22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_22.setText("TABLE 1");
        btn_22.setFocusable(false);
        btn_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_22ActionPerformed(evt);
            }
        });

        btn_23.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_23.setText("TABLE 1");
        btn_23.setFocusable(false);
        btn_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_23ActionPerformed(evt);
            }
        });

        btn_24.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_24.setText("TABLE 1");
        btn_24.setFocusable(false);
        btn_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_24ActionPerformed(evt);
            }
        });

        btn_25.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_25.setText("TABLE 1");
        btn_25.setFocusable(false);
        btn_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_25ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/cancel_login.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/cancel_login_mo.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lb_standby2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lb_standby2.setForeground(new java.awt.Color(41, 9, 149));
        lb_standby2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_standby2.setText("CLOSE");
        lb_standby2.setFocusable(false);

        lb_standby_pagedown2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lb_standby_pagedown2.setForeground(new java.awt.Color(225, 39, 63));
        lb_standby_pagedown2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_standby_pagedown2.setText("(ESCAPE)");
        lb_standby_pagedown2.setFocusable(false);

        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/arrow-right-mo.png"))); // NOI18N
        jButton55.setBorderPainted(false);
        jButton55.setContentAreaFilled(false);
        jButton55.setFocusable(false);
        jButton55.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/arrow-right.png"))); // NOI18N
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        lb_standby1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lb_standby1.setForeground(new java.awt.Color(41, 9, 149));
        lb_standby1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_standby1.setText("NEXT");
        lb_standby1.setFocusable(false);

        lb_standby_pagedown1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lb_standby_pagedown1.setForeground(new java.awt.Color(225, 39, 63));
        lb_standby_pagedown1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_standby_pagedown1.setText("(ARROW RIGHT)");
        lb_standby_pagedown1.setFocusable(false);

        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/arrow-left-mo.png"))); // NOI18N
        jButton53.setBorderPainted(false);
        jButton53.setContentAreaFilled(false);
        jButton53.setFocusable(false);
        jButton53.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img/arrow-left.png"))); // NOI18N
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        lb_standby.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lb_standby.setForeground(new java.awt.Color(41, 9, 149));
        lb_standby.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_standby.setText("PREVIOUS");
        lb_standby.setFocusable(false);

        lb_standby_pagedown.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lb_standby_pagedown.setForeground(new java.awt.Color(225, 39, 63));
        lb_standby_pagedown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_standby_pagedown.setText("(ARROW LEFT)");
        lb_standby_pagedown.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_standby, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_standby_pagedown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_standby_pagedown1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_standby1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_standby_pagedown2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_standby2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_standby2)
                        .addGap(3, 3, 3)
                        .addComponent(lb_standby_pagedown2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_standby)
                        .addGap(3, 3, 3)
                        .addComponent(lb_standby_pagedown))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_standby1)
                        .addGap(3, 3, 3)
                        .addComponent(lb_standby_pagedown1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_12, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_15, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_16, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_18, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_19, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_24, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_25, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_25, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int btn_no = 0;
    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        // TODO add your handling code here:
        btn_no = 0;
        do_click(btn_1);


    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        // TODO add your handling code here:
        btn_no = 1;
        do_click(btn_2);

    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        // TODO add your handling code here:
        btn_no = 2;
        do_click(btn_3);

    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        // TODO add your handling code here:
        btn_no = 3;
        do_click(btn_4);

    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        // TODO add your handling code here:
        btn_no = 4;
        do_click(btn_5);

    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        // TODO add your handling code here:
        btn_no = 5;
        do_click(btn_6);

    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        // TODO add your handling code here:
        btn_no = 6;
        do_click(btn_7);

    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        // TODO add your handling code here
        btn_no = 7;
        do_click(btn_8);

    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        // TODO add your handling code here:
        btn_no = 8;
        do_click(btn_9);

    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_10ActionPerformed
        // TODO add your handling code here:
        btn_no = 9;
        do_click(btn_10);

    }//GEN-LAST:event_btn_10ActionPerformed

    private void btn_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_11ActionPerformed
        // TODO add your handling code here:
        btn_no = 10;
        do_click(btn_11);

    }//GEN-LAST:event_btn_11ActionPerformed

    private void btn_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_12ActionPerformed
        // TODO add your handling code here:
        btn_no = 11;
        do_click(btn_12);

    }//GEN-LAST:event_btn_12ActionPerformed

    private void btn_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_13ActionPerformed
        // TODO add your handling code here:
        btn_no = 12;
        do_click(btn_13);

    }//GEN-LAST:event_btn_13ActionPerformed

    private void btn_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_14ActionPerformed
        // TODO add your handling code here:
        btn_no = 13;
        do_click(btn_14);

    }//GEN-LAST:event_btn_14ActionPerformed

    private void btn_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_15ActionPerformed
        // TODO add your handling code here:
        btn_no = 14;
        do_click(btn_15);

    }//GEN-LAST:event_btn_15ActionPerformed

    private void btn_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_16ActionPerformed
        // TODO add your handling code here:
        btn_no = 15;
        do_click(btn_16);

    }//GEN-LAST:event_btn_16ActionPerformed

    private void btn_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_17ActionPerformed
        // TODO add your handling code here:
        btn_no = 16;
        do_click(btn_17);

    }//GEN-LAST:event_btn_17ActionPerformed

    private void btn_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_18ActionPerformed
        // TODO add your handling code here:
        btn_no = 17;
        do_click(btn_18);

    }//GEN-LAST:event_btn_18ActionPerformed

    private void btn_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_19ActionPerformed
        // TODO add your handling code here:
        btn_no = 18;
        do_click(btn_19);

    }//GEN-LAST:event_btn_19ActionPerformed

    private void btn_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_20ActionPerformed
        // TODO add your handling code here:
        btn_no = 19;
        do_click(btn_20);

    }//GEN-LAST:event_btn_20ActionPerformed

    private void btn_21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_21ActionPerformed
        // TODO add your handling code here:
        btn_no = 20;
        do_click(btn_21);

    }//GEN-LAST:event_btn_21ActionPerformed

    private void btn_22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_22ActionPerformed
        // TODO add your handling code here:
        btn_no = 21;
        do_click(btn_22);

    }//GEN-LAST:event_btn_22ActionPerformed

    private void btn_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_23ActionPerformed
        // TODO add your handling code here:
        btn_no = 22;
        do_click(btn_23);

    }//GEN-LAST:event_btn_23ActionPerformed

    private void btn_24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_24ActionPerformed
        // TODO add your handling code here:
        btn_no = 23;
        do_click(btn_24);

    }//GEN-LAST:event_btn_24ActionPerformed

    private void btn_25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_25ActionPerformed
        // TODO add your handling code here:
        btn_no = 24;
        do_click(btn_25);

    }//GEN-LAST:event_btn_25ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
        do_next();
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
        do_prev();
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_10;
    private javax.swing.JButton btn_11;
    private javax.swing.JButton btn_12;
    private javax.swing.JButton btn_13;
    private javax.swing.JButton btn_14;
    private javax.swing.JButton btn_15;
    private javax.swing.JButton btn_16;
    private javax.swing.JButton btn_17;
    private javax.swing.JButton btn_18;
    private javax.swing.JButton btn_19;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_20;
    private javax.swing.JButton btn_21;
    private javax.swing.JButton btn_22;
    private javax.swing.JButton btn_23;
    private javax.swing.JButton btn_24;
    private javax.swing.JButton btn_25;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton55;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lb_standby;
    private javax.swing.JLabel lb_standby1;
    private javax.swing.JLabel lb_standby2;
    private javax.swing.JLabel lb_standby_pagedown;
    private javax.swing.JLabel lb_standby_pagedown1;
    private javax.swing.JLabel lb_standby_pagedown2;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        init_table_records();
        set_table_status();
        t.start();
    }
    Timer t = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            init_table_records();
            set_table_status();
        }
    });

    public void do_pass() {
        init_table_records();
        set_table_status();
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
         KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_RIGHT, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                 do_next();
            }
        });
          KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_LEFT, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                 do_prev();
            }
        });
    }
    // </editor-fold>
    List<to_customer_table.tables> records = new ArrayList();
    List<String> status = new ArrayList();
    List<String> table_name = new ArrayList();
    List<String> tbs = new ArrayList();
    List<String> col = new ArrayList();

    private void init_table_records() {
        records.clear();
        status.clear();
        table_name.clear();
        tbs.clear();
        records = S5_customer_tables.get_customer_tables();

        for (to_customer_table.tables to : records) {
            status.add(to.status);
            table_name.add(to.table_no);

        }
//        System.out.println("ad");

    }

    private void set_table_status() {
        JButton[] btn = {btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15, btn_16, btn_17, btn_18, btn_19, btn_20, btn_21, btn_22, btn_23, btn_24, btn_25};

        //        tbs.clear();     
        List<String> d = new ArrayList();
        List<String> tbl_no = new ArrayList();
//        System.out.println(limit);
        for (int i = base; i < limit; i++) {
            if (i >= status.size()) {
                break;
            }
            d.add(status.get(i));
            tbl_no.add(table_name.get(i));
            tbs.add(table_name.get(i));
//            System.out.println(table_name.get(i));
        }


        String table = "TABLE";
        int i = 0;
        for (JButton b : btn) {
            String st = "";
            String no = "";

            if (i >= d.size()) {
                st = "AVAILABLE";
                no = "";
            } else {
                st = d.get(i);
                no = tbl_no.get(i);
            }

            String color = "";

            if (st.equals("AVAILABLE")) {
                color = "BLACK";

            } else {
                color = "RED";
            }

            String html = "<html><center><font color=" + color + " size=5>"
                    + "<br>" + no
                    + "<br>"
                    + "<center></html>";

            b.setText("" + html);
            i++;
        }
    }
    int base = 0;
    int limit = 25;

    private void do_next() {
        System.out.println(limit + " " + table_name.size());
        if (limit > table_name.size()) {
//            JOptionPane.showMessageDialog(null, limit);
        } else {
            base += 25;
            limit += 25;
            init_table_records();
            set_table_status();
        }




    }

    private void do_prev() {
        if (base == 0) {
        } else {
            base -= 25;
            limit -= 25;
            init_table_records();
            set_table_status();
        }
    }

//    private String get_btn_num(){
//        
//    }
    private void do_click(JButton btn) {

//        System.out.println(btn.getText());
        String b1 = "<html><center><font color=BLACK size=5><br><br><center></html>";
        String b2 = "<html><center><font color=RED size=5><br><br><center></html>";
        if (btn.getText().equals(b1) || btn.getText().equals(b2)) {
//            JOptionPane.showMessageDialog(null, "adadad");
            return;
        }
        Color g = btn.getForeground();
        final String text = tbs.get(btn_no);
//        JOptionPane.showMessageDialog(null, g);
//        System.out.println(g + " " + Color.BLACK);

        boolean naa = S5_customer_tables.get_details2(text);
//             JOptionPane.showMessageDialog(null, naa);
        if (naa == false) {
//            final String text = btn.getText();


//            System.out.println(text);
//            JOptionPane.showMessageDialog(null, text);
            Window p = (Window) this;
            Dlg_order nd = Dlg_order.create(p, true);
            nd.setTitle("");
//            nd.do_pass("");
            nd.setCallback(new Dlg_order.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_order.OutputData data) {
                   
                    ok_order(text);
                    closeDialog.ok();
                    btn_no = 0;
                }
            });
            Center.setCenter(nd);

            nd.setVisible(true);


//            JOptionPane.showMessageDialog(null, "order");
        } else {
//            final String text = btn.getText();


//            System.out.println(text);
//            JOptionPane.showMessageDialog(null, text);
            Window p = (Window) this;
            Dlg_add_order nd = Dlg_add_order.create(p, true);
            nd.setTitle("");
//            nd.do_pass("");
            nd.setCallback(new Dlg_add_order.Callback() {

                @Override
                public void add_order(CloseDialog closeDialog, Dlg_add_order.OutputData data) {
                   

                    ok_add_order(text);
                     closeDialog.ok();
                    btn_no = 0;
                }

                @Override
                public void pay(CloseDialog closeDialog, Dlg_add_order.OutputData data) {
                  
                    ok_pay(text);
                      closeDialog.ok();
                    btn_no = 0;
                }
            });
            Center.setCenter(nd);

            nd.setVisible(true);
//            JOptionPane.showMessageDialog(null, "order");
        }

    }

    private void ok_order(String text) {
//        JOptionPane.showMessageDialog(null, text);
        if (callback != null) {
            callback.order(new CloseDialog(this), new Dlg_customer_table2.OutputData(text));
        }
        
    }
//

    private void ok_pay(String text) {
//         JOptionPane.showMessageDialog(null, text);
        if (callback != null) {
            callback.pay(new CloseDialog(this), new Dlg_customer_table2.OutputData(text));
        }
    }
//

    
    private void ok_add_order(String text) {
//         JOptionPane.showMessageDialog(null, text);
        if (callback != null) {
            callback.add_order(new CloseDialog(this), new Dlg_customer_table2.OutputData(text));
        }
    }
}
