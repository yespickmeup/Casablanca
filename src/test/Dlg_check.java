/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import POS.guests.Dlg_guest;
import POS.rooms.S1_check_in;
import POS.utl.DateType;
import POS_svc4.S2_search;
import POS_svc4.S5_tables;
import de.jgrid.JGrid;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXLabel;
import POS.utl.Center;
import com.jgoodies.binding.list.ArrayListModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author Dummy
 */
public class Dlg_check extends javax.swing.JDialog {

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
    }

    public static class InputData {
    }

    public static class OutputData {

        public final List<to_guests> to1;
        public final double percentages;

        public OutputData(List<to_guests> to1, double percentages) {
            this.to1 = to1;
            this.percentages = percentages;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_check(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_check(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_check() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_check myRef;

    private void setThisRef(Dlg_check myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_check> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_check create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.APPLICATION_MODAL);

    }

    public static Dlg_check create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_check dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_check((java.awt.Frame) parent, false);
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
            Dlg_check dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_check((java.awt.Dialog) parent, false);
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


        Dlg_check dialog = Dlg_check.create(new javax.swing.JFrame(), true);
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
        lbl_plus = new javax.swing.JLabel();
        btn_p_close = new javax.swing.JButton();
        btn_p_check = new javax.swing.JButton();
        btn_p_order = new javax.swing.JButton();
        btn_p_cancel = new javax.swing.JButton();
        lbl_p_name_1 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_2 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_3 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_4 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_5 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_6 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_7 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_8 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_9 = new org.jdesktop.swingx.JXLabel();
        lbl_p_name_10 = new org.jdesktop.swingx.JXLabel();
        pnl_back = new javax.swing.JPanel();

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

        lbl_plus.setBackground(new java.awt.Color(102, 204, 255));
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
        getContentPane().add(lbl_plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 30, 30));

        btn_p_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_close.setText("CLOSE");
        btn_p_close.setFocusable(false);
        btn_p_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_closeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 50));

        btn_p_check.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_check.setText("CHECK IN");
        btn_p_check.setFocusable(false);
        btn_p_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_checkActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 50));

        btn_p_order.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_order.setText("ORDER");
        btn_p_order.setFocusable(false);
        btn_p_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_orderActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 50));

        btn_p_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_p_cancel.setText("CLEAR");
        btn_p_cancel.setFocusable(false);
        btn_p_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_p_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 50));

        lbl_p_name_1.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_1.setIconTextGap(10);
        lbl_p_name_1.setOpaque(true);
        lbl_p_name_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_p_name_1MouseEntered(evt);
            }
        });
        lbl_p_name_1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_1MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 30, 200));

        lbl_p_name_2.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_2.setIconTextGap(10);
        lbl_p_name_2.setOpaque(true);
        lbl_p_name_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_p_name_2MouseEntered(evt);
            }
        });
        lbl_p_name_2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_2MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_2MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 30, 200));

        lbl_p_name_3.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_3.setIconTextGap(10);
        lbl_p_name_3.setOpaque(true);
        lbl_p_name_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_3MouseClicked(evt);
            }
        });
        lbl_p_name_3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_3MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_3MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 30, 200));

        lbl_p_name_4.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_4.setIconTextGap(10);
        lbl_p_name_4.setOpaque(true);
        lbl_p_name_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_4MouseClicked(evt);
            }
        });
        lbl_p_name_4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_4MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_4MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 30, 200));

        lbl_p_name_5.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_5.setIconTextGap(10);
        lbl_p_name_5.setOpaque(true);
        lbl_p_name_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_5MouseClicked(evt);
            }
        });
        lbl_p_name_5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_5MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_5MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 30, 200));

        lbl_p_name_6.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_6.setIconTextGap(10);
        lbl_p_name_6.setOpaque(true);
        lbl_p_name_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_6MouseClicked(evt);
            }
        });
        lbl_p_name_6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_6MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_6MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 200));

        lbl_p_name_7.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_7.setIconTextGap(10);
        lbl_p_name_7.setOpaque(true);
        lbl_p_name_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_7MouseClicked(evt);
            }
        });
        lbl_p_name_7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_7MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_7MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 30, 200));

        lbl_p_name_8.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_8.setIconTextGap(10);
        lbl_p_name_8.setOpaque(true);
        lbl_p_name_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_8MouseClicked(evt);
            }
        });
        lbl_p_name_8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_8MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_8MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 30, 200));

        lbl_p_name_9.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_9.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_9.setIconTextGap(10);
        lbl_p_name_9.setOpaque(true);
        lbl_p_name_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_p_name_9MouseEntered(evt);
            }
        });
        lbl_p_name_9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_9MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_9MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 30, 200));

        lbl_p_name_10.setBackground(new java.awt.Color(153, 153, 153));
        lbl_p_name_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbl_p_name_10.setForeground(new java.awt.Color(255, 255, 255));
        lbl_p_name_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_p_name_10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_p_name_10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_p_name_10.setIconTextGap(10);
        lbl_p_name_10.setOpaque(true);
        lbl_p_name_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_p_name_10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_p_name_10MouseEntered(evt);
            }
        });
        lbl_p_name_10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_p_name_10MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_p_name_10MouseMoved(evt);
            }
        });
        getContentPane().add(lbl_p_name_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 30, 200));

        pnl_back.setBackground(new java.awt.Color(255, 204, 204));
        pnl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnl_backMouseExited(evt);
            }
        });
        getContentPane().add(pnl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_p_name_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_4MouseClicked
        selected = 3;
        mouseover(lbl_p_name_4);
        set_order();

    }//GEN-LAST:event_lbl_p_name_4MouseClicked

    private void lbl_p_name_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_3MouseClicked
        selected = 2;
        mouseover(lbl_p_name_3);
        set_order();
    }//GEN-LAST:event_lbl_p_name_3MouseClicked

    private void lbl_p_name_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_2MouseEntered
   }//GEN-LAST:event_lbl_p_name_2MouseEntered

    private void lbl_p_name_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_2MouseClicked
        selected = 1;
        mouseover(lbl_p_name_2);
        set_order();
    }//GEN-LAST:event_lbl_p_name_2MouseClicked

    private void lbl_p_name_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_1MouseEntered
   }//GEN-LAST:event_lbl_p_name_1MouseEntered

    private void lbl_p_name_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_1MouseClicked
        selected = 0;
        mouseover(lbl_p_name_1);
        set_order();
    }//GEN-LAST:event_lbl_p_name_1MouseClicked

    private void lbl_p_name_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_5MouseClicked
        selected = 4;
        mouseover(lbl_p_name_5);
        set_order();
    }//GEN-LAST:event_lbl_p_name_5MouseClicked

    private void lbl_p_name_1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_1MouseDragged
    }//GEN-LAST:event_lbl_p_name_1MouseDragged

    private void lbl_p_name_2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_2MouseDragged
    }//GEN-LAST:event_lbl_p_name_2MouseDragged

    private void lbl_p_name_3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_3MouseDragged
    }//GEN-LAST:event_lbl_p_name_3MouseDragged

    private void lbl_p_name_4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_4MouseDragged
    }//GEN-LAST:event_lbl_p_name_4MouseDragged

    private void lbl_p_name_5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_5MouseDragged
    }//GEN-LAST:event_lbl_p_name_5MouseDragged

    private void lbl_p_name_5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_5MouseMoved
//        selected = 4;
//        mouseover(lbl_p_name_5);
    }//GEN-LAST:event_lbl_p_name_5MouseMoved

    private void lbl_p_name_4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_4MouseMoved
//        selected = 3;
//        mouseover(lbl_p_name_4);
    }//GEN-LAST:event_lbl_p_name_4MouseMoved

    private void lbl_p_name_3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_3MouseMoved
//        selected = 2;
//        mouseover(lbl_p_name_3);
    }//GEN-LAST:event_lbl_p_name_3MouseMoved

    private void lbl_p_name_2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_2MouseMoved
//        selected = 1;
//        mouseover(lbl_p_name_2);
    }//GEN-LAST:event_lbl_p_name_2MouseMoved

    private void lbl_p_name_1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_1MouseMoved
//        selected = 0;
//        mouseover(lbl_p_name_1);
    }//GEN-LAST:event_lbl_p_name_1MouseMoved

    private void btn_p_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_closeActionPerformed
        disposed();
    }//GEN-LAST:event_btn_p_closeActionPerformed

    private void btn_p_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_checkActionPerformed
        check_in();
    }//GEN-LAST:event_btn_p_checkActionPerformed

    private void btn_p_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_orderActionPerformed
        order();
    }//GEN-LAST:event_btn_p_orderActionPerformed

    private void lbl_p_name_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_6MouseClicked
        selected = 5;
        mouseover(lbl_p_name_6);
        set_order();

    }//GEN-LAST:event_lbl_p_name_6MouseClicked

    private void lbl_p_name_6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_6MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_6MouseDragged

    private void lbl_p_name_6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_6MouseMoved

    private void lbl_p_name_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_7MouseClicked
        selected = 6;
        mouseover(lbl_p_name_7);
        set_order();

    }//GEN-LAST:event_lbl_p_name_7MouseClicked

    private void lbl_p_name_7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_7MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_7MouseDragged

    private void lbl_p_name_7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_7MouseMoved

    private void lbl_p_name_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_8MouseClicked
        selected = 7;
        mouseover(lbl_p_name_8);
        set_order();
//
    }//GEN-LAST:event_lbl_p_name_8MouseClicked

    private void lbl_p_name_8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_8MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_8MouseDragged

    private void lbl_p_name_8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_8MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_8MouseMoved

    private void lbl_p_name_9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_9MouseClicked
        selected = 8;
        mouseover(lbl_p_name_9);
        set_order();

    }//GEN-LAST:event_lbl_p_name_9MouseClicked

    private void lbl_p_name_9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_9MouseEntered

    private void lbl_p_name_9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_9MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_9MouseDragged

    private void lbl_p_name_9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_9MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_9MouseMoved

    private void lbl_p_name_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_10MouseClicked
        selected = 9;
        mouseover(lbl_p_name_10);
        set_order();

    }//GEN-LAST:event_lbl_p_name_10MouseClicked

    private void lbl_p_name_10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_10MouseEntered

    private void lbl_p_name_10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_10MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_10MouseDragged

    private void lbl_p_name_10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_p_name_10MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_p_name_10MouseMoved

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

    private void pnl_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_backMouseExited
    }//GEN-LAST:event_pnl_backMouseExited
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_p_cancel;
    private javax.swing.JButton btn_p_check;
    private javax.swing.JButton btn_p_close;
    private javax.swing.JButton btn_p_order;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXLabel lbl_p_name_1;
    private org.jdesktop.swingx.JXLabel lbl_p_name_10;
    private org.jdesktop.swingx.JXLabel lbl_p_name_2;
    private org.jdesktop.swingx.JXLabel lbl_p_name_3;
    private org.jdesktop.swingx.JXLabel lbl_p_name_4;
    private org.jdesktop.swingx.JXLabel lbl_p_name_5;
    private org.jdesktop.swingx.JXLabel lbl_p_name_6;
    private org.jdesktop.swingx.JXLabel lbl_p_name_7;
    private org.jdesktop.swingx.JXLabel lbl_p_name_8;
    private org.jdesktop.swingx.JXLabel lbl_p_name_9;
    private javax.swing.JLabel lbl_plus;
    private javax.swing.JPanel pnl_back;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
        lbl_p_name_1.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_2.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_3.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_4.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_5.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_6.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_7.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_8.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_9.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
        lbl_p_name_10.setTextRotation((90 * Math.PI / 180)); // 45 degrees in radian.
//        sample();
    }

    private void sample() {
        my_guests.clear();
        List<to_guests> tt = new ArrayList();
//        tt.add(new to_guests("", "Ronald Pascua", false));
//        tt.add(new to_guests("", "Ronald Pascua", false));
//        tt.add(new to_guests("", "Ronald Pascua", false));
//        tt.add(new to_guests("", "Ronald Pascua", false));
//        tt.add(new to_guests("", "Ronald Pascua", false));

        tt = my_guests;
        JXLabel[] lbl = {lbl_p_name_1, lbl_p_name_2, lbl_p_name_3, lbl_p_name_4, lbl_p_name_5, lbl_p_name_6, lbl_p_name_7, lbl_p_name_8, lbl_p_name_9, lbl_p_name_10};

        for (int i = 0; i < 10; i++) {
            to_guests to = new to_guests("" + i, "Ronald Pascua" + i, false);
            my_guests.add(to);

        }
//        

        int ded = 0;
        int bounds = 0;
        if (tt.isEmpty()) {
            lbl_p_name_1.setVisible(false);
            lbl_p_name_2.setVisible(false);
            lbl_p_name_3.setVisible(false);
            lbl_p_name_4.setVisible(false);
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            lbl_plus.setVisible(false);
            ded = 300;
//            bounds = 300;
        }
        if (tt.size() == 1) {
            ded = 270;
            lbl_p_name_2.setVisible(false);
            lbl_p_name_3.setVisible(false);
            lbl_p_name_4.setVisible(false);
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 190;
        }
        if (tt.size() == 2) {
            ded = 240;
            lbl_p_name_3.setVisible(false);
            lbl_p_name_4.setVisible(false);
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 220;
        }
        if (tt.size() == 3) {
            ded = 210;
            lbl_p_name_4.setVisible(false);
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 250;
        }
        if (tt.size() == 4) {
            ded = 180;
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 280;
        }
        if (tt.size() == 5) {
            ded = 150;
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 310;
        }
        if (tt.size() == 6) {
            ded = 120;
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 340;
        }
        if (tt.size() == 7) {
            ded = 90;
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 370;
        }
        if (tt.size() == 8) {
            ded = 60;
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 400;
        }
        if (tt.size() == 9) {
            ded = 30;
            lbl_p_name_10.setVisible(false);
            bounds = 430;
        }


        if (tt.size() == 10) {
            ded = 0;
            bounds = 450;
            lbl_plus.setVisible(false);
        }

//        for (to_guests tt1 : tt) {
//            to_guests to = new to_guests("" + 0, tt1.name, false);
//            my_guests.add(to);
//        }

        int i = -1;
        for (to_guests to : tt) {
            i++;
            if (i == 10) {
                break;
            }
            lbl[i].setText(to.name);
//            System.out.println(to.name);
        }

//        lbl[4].setVisible(false);
//        lbl[3].setVisible(false);
//        ded += 60;
        int width = 490;
        int height = 220;

        this.setPreferredSize(new Dimension(width - ded, height));
        pnl_back.setPreferredSize(new Dimension(width - ded, height));
//        Rectangle l = lbl_plus.getBounds();
//        getContentPane().add(lbl_plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 30, 30));
        lbl_plus.setBounds(new java.awt.Rectangle(bounds, 0, 30, 30));
//        lbl_plus.setLocation(100, 30);
//        repaint();
        Container frame = getContentPane();
        frame.setLayout(null);
        this.pack();

        for (to_guests a : my_guests) {
            System.out.println(a.status);
        }
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
        final String version = System.getProperty("version", "ordering");
//        JOptionPane.showMessageDialog(null, user_id);
        if (version.equals("ordering") && user_id.equals("7") || version.equals("ordering") && user_id.equals("")) {
            if (btn_p_check.getText().
                    equals("TAKE-OUT")) {
                btn_p_check.setEnabled(true);
            } else {
                btn_p_check.setEnabled(false);
                btn_p_order.setEnabled(true);
            }
//            JOptionPane.showMessageDialog(null, user_id);
//            btn_p_order.setEnabled(false);
        }
        if (version.equals("ordering") && user_id.equals("0") || user.equals("6")) {
            if (btn_p_check.getText().
                    equals("TAKE-OUT")) {
                btn_p_check.setEnabled(true);
            } else {
                btn_p_check.setEnabled(false);
                btn_p_order.setEnabled(true);
            }
//            JOptionPane.showMessageDialog(null, user_id);
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
//        tbl_table_orders_ALM1
        List<S5_tables.to_tables2> room = S5_tables.get_tables("");
        if (ui_items.equals("list")) {
            tbl_table_orders_ALM1.clear();

        } else {
            orders_model1.clear();
            for (S5_tables.to_tables2 t : room) {
                S2_search.to_rooms to = new S2_search.to_rooms(t.no, name, "" + t.name, t.status, t.amount, t.guest_id, t.guest_name, t.date_added, t.name, t.rate, t.to_guest, t.rate_type, t.percentage,t.table_location_id);
                orders_model1.addElement(to);
            }
        }


        Object value = orders_model1.getElementAt(row_selected);
        final S2_search.to_rooms t = (S2_search.to_rooms) value;

//        JOptionPane.showMessageDialog(null, row_selected);
        List<Dlg_check_liquid.to_guests> datas = t.to_guest;

        for (Dlg_check_liquid.to_guests g : datas) {
//            System.out.println(g.name + " -  asdasd");
        }
        selected = -1;
        do_pass(datas, t, user);
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
    List<to_guests> my_guests = new ArrayList();
    int selected = -1;

    private void mouseover(JLabel lbl) {
//
        to_guests to = (to_guests) my_guests.get((selected));
        if (to.status == true) {
            lbl.setBackground(new java.awt.Color(153, 153, 153));
            to.setStatus(false);
        } else {
            lbl.setBackground(new java.awt.Color(0, 153, 255));
            to.setStatus(true);
        }

    }

    private void mouseout(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(153, 153, 153));
    }
    String user = "0";

    public void do_pass(List<Dlg_check_liquid.to_guests> tt, S2_search.to_rooms t, String user_lvl) {
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
//        JOptionPane.showMessageDialog(null, t.status);
        if (t.status.equalsIgnoreCase("available")) {
            if (user.equals("6")) {
                btn_p_order.setEnabled(true);
            } else {
                btn_p_order.setEnabled(false);
            }

            btn_p_cancel.setEnabled(false);
            if (System.getProperty("version", "ordering").
                    equals("ordering")) {
                btn_p_check.setEnabled(false);
                btn_p_order.setEnabled(true);
                btn_p_check.setText("PAY");
            }
        } else {
            btn_p_check.setEnabled(true);
            final String version = System.getProperty("version", "ordering");
            if (version.equals("ordering")) {
                btn_p_check.setText("PAY");

            } else {
                btn_p_check.setText("CHECK-OUT");
            }
        }
        if (user.equals("6")) {
            btn_p_check.setText("PAY");
        }
        my_guests.clear();
        JXLabel[] lbl = {lbl_p_name_1, lbl_p_name_2, lbl_p_name_3, lbl_p_name_4, lbl_p_name_5, lbl_p_name_6, lbl_p_name_7, lbl_p_name_8, lbl_p_name_9, lbl_p_name_10};
//        for (int i = 0; i < tt.; i++) {
//            to_guests to = new to_guests("" + i, "Ronald Pascua" + i, false);
//            my_guests.add(to);
//            
//        }
//        

        int ded = 0;
        int bounds = 0;
        if (tt.isEmpty()) {
            lbl_p_name_1.setVisible(false);
            lbl_p_name_2.setVisible(false);
            lbl_p_name_3.setVisible(false);
            lbl_p_name_4.setVisible(false);
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            lbl_plus.setVisible(false);
            ded = 300;
//            bounds = 300;
        }
        if (tt.size() == 1) {
            ded = 270;
            lbl_p_name_1.setVisible(true);

            lbl_p_name_2.setVisible(false);
            lbl_p_name_3.setVisible(false);
            lbl_p_name_4.setVisible(false);
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 190;
        }
        if (tt.size() == 2) {
            ded = 240;
            lbl_p_name_1.setVisible(true);
            lbl_p_name_2.setVisible(true);

            lbl_p_name_3.setVisible(false);
            lbl_p_name_4.setVisible(false);
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 220;
        }
        if (tt.size() == 3) {
            ded = 210;
            lbl_p_name_1.setVisible(true);
            lbl_p_name_2.setVisible(true);
            lbl_p_name_3.setVisible(true);


            lbl_p_name_4.setVisible(false);
            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 250;
        }
        if (tt.size() == 4) {
            ded = 180;
            lbl_p_name_1.setVisible(true);
            lbl_p_name_2.setVisible(true);
            lbl_p_name_3.setVisible(true);
            lbl_p_name_4.setVisible(true);

            lbl_p_name_5.setVisible(false);
            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 280;
        }
        if (tt.size() == 5) {
            ded = 150;
            lbl_p_name_1.setVisible(true);
            lbl_p_name_2.setVisible(true);
            lbl_p_name_3.setVisible(true);
            lbl_p_name_4.setVisible(true);
            lbl_p_name_5.setVisible(true);

            lbl_p_name_6.setVisible(false);
            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 310;
        }
        if (tt.size() == 6) {
            ded = 120;
            lbl_p_name_1.setVisible(true);
            lbl_p_name_2.setVisible(true);
            lbl_p_name_3.setVisible(true);
            lbl_p_name_4.setVisible(true);
            lbl_p_name_5.setVisible(true);
            lbl_p_name_6.setVisible(true);


            lbl_p_name_7.setVisible(false);
            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 340;
        }
        if (tt.size() == 7) {
            ded = 90;
            lbl_p_name_1.setVisible(true);
            lbl_p_name_2.setVisible(true);
            lbl_p_name_3.setVisible(true);
            lbl_p_name_4.setVisible(true);
            lbl_p_name_5.setVisible(true);
            lbl_p_name_6.setVisible(true);
            lbl_p_name_7.setVisible(true);


            lbl_p_name_8.setVisible(false);
            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 370;
        }
        if (tt.size() == 8) {
            ded = 60;
            lbl_p_name_1.setVisible(true);
            lbl_p_name_2.setVisible(true);
            lbl_p_name_3.setVisible(true);
            lbl_p_name_4.setVisible(true);
            lbl_p_name_5.setVisible(true);
            lbl_p_name_6.setVisible(true);
            lbl_p_name_7.setVisible(true);
            lbl_p_name_8.setVisible(true);

            lbl_p_name_9.setVisible(false);
            lbl_p_name_10.setVisible(false);
            bounds = 400;
        }
        if (tt.size() == 9) {
            ded = 30;
            lbl_p_name_2.setVisible(true);
            lbl_p_name_3.setVisible(true);
            lbl_p_name_4.setVisible(true);
            lbl_p_name_5.setVisible(true);
            lbl_p_name_6.setVisible(true);
            lbl_p_name_7.setVisible(true);
            lbl_p_name_8.setVisible(true);
            lbl_p_name_9.setVisible(true);

            lbl_p_name_10.setVisible(false);
            bounds = 430;
        }


        if (tt.size() == 10) {
            ded = 0;
            bounds = 450;
            lbl_p_name_2.setVisible(true);
            lbl_p_name_3.setVisible(true);
            lbl_p_name_4.setVisible(true);
            lbl_p_name_5.setVisible(true);
            lbl_p_name_6.setVisible(true);
            lbl_p_name_7.setVisible(true);
            lbl_p_name_8.setVisible(true);
            lbl_p_name_9.setVisible(true);
            lbl_p_name_10.setVisible(true);
            lbl_plus.setVisible(false);
        }

        for (Dlg_check_liquid.to_guests tt1 : tt) {
            to_guests to = new to_guests(tt1.id, tt1.name, false);
            my_guests.add(to);
        }

        int i = -1;
        for (Dlg_check_liquid.to_guests to : tt) {
            i++;
            if (i == 10) {
                break;
            }
            lbl[i].setText(to.name);
//            System.out.println(to.name);
        }

//        lbl[4].setVisible(false);
//        lbl[3].setVisible(false);
//        ded += 60;
        int width = 510;
        int height = 250;

        this.setPreferredSize(new Dimension(width - ded, height));
        pnl_back.setPreferredSize(new Dimension(width - ded, height));
//        Rectangle l = lbl_plus.getBounds();
//        getContentPane().add(lbl_plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 30, 30));
        lbl_plus.setBounds(new java.awt.Rectangle(bounds, 0, 30, 30));
//        lbl_plus.setLocation(100, 30);
//        repaint();
        Container frame = getContentPane();
        frame.setLayout(null);
        this.pack();
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
        List<to_guests> ok = new ArrayList();
        for (to_guests a : my_guests) {
            System.out.println(a.status);
            if (a.status == true) {
                to_guests to = new to_guests(a.id, a.name, a.status);
                ok.add(to);
            }

        }

        if (callback != null) {
            if (btn_p_check.getText().
                    equals("CHECK IN")) {
                this.dispose();
                callback.check_in(new CloseDialog(this), new OutputData(ok, percentag));
            } else {
                if (!my_guests.isEmpty() && ok.isEmpty()) {
                    for (to_guests a : my_guests) {
                        System.out.println(a.status);
                        to_guests to = new to_guests(a.id, a.name, a.status);
                        ok.add(to);
                    }
                }
                if (System.getProperty("version", "resto").
                        equals("resto")) {
                    if (my_guests.isEmpty()) {
//                        JOptionPane.showMessageDialog(null, "Enter Guest");
//                        return;
                    }
                } else {
                }

                if (System.getProperty("version", "resto").
                        equals("ordering")) {
//                JOptionPane.showMessageDialog(null, my_guests.size());
                    if (my_guests.size() == 1) {
                        to_guests to = (to_guests) my_guests.get((0));
                        ok.add(to);
                    }

                }

                this.dispose();
                callback.check_out(new CloseDialog(this), new OutputData(ok, percentag));

                refresh_guest();
            }
        }
    }

    private void order() {
        List<to_guests> ok = new ArrayList();
        for (to_guests a : my_guests) {
            System.out.println(a.status);
            if (a.status == true) {
                to_guests to = new to_guests(a.id, a.name, a.status);
//                System.out.println(a.id);
                ok.add(to);
            }
        }
//        System.out.println(ok.size());
        String version = System.getProperty("version", "ordering");
//        JOptionPane.showMessageDialog(null, version);
        if (ok.isEmpty()) {
            if (version.equals("ordering") || version.equals("resto") && user.equals("6")) {
                to_guests to = new to_guests("" + -1, "Walk-in", true);
                ok.add(to);

            } else {
                JOptionPane.showMessageDialog(null, "Choose Guest");

                return;
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
                refresh_guest();
                add_guest();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);

    }

    private void add_guest() {

        List<to_guests> ok = new ArrayList();
        if (callback != null) {
            this.dispose();
            callback.add_guest(new CloseDialog(this), new OutputData(ok, percentag));
        }
    }

    private void void_order() {


        List<to_guests> ok = new ArrayList();

        for (to_guests a : my_guests) {
            System.out.println(a.status);
            if (a.status == true) {
                to_guests to = new to_guests(a.id, a.name, a.status);
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
        List<to_guests> ok = new ArrayList();

        for (to_guests a : my_guests) {
            System.out.println(a.status);
            if (a.status == true) {
                to_guests to = new to_guests(a.id, a.name, a.status);
//                System.out.println(a.id);
                ok.add(to);
            }
        }
//        System.out.println(ok.size());
//        if (ok.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Choose Guest");
//            return;
//        }
        if (callback != null) {
//            this.dispose();
            callback.set_order(new CloseDialog(this), new OutputData(ok, percentag));
        }
    }
}
