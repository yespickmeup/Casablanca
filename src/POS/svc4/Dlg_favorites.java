/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.svc4;

import POS.svc2.S10_select_products;
import POS.svc2.S11_check_available_kilos;
import POS.to.to_order;
import POS.utl.next_line;
import POS_svc3.S1_get_category;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.*;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;

/**
 *
 * @author i1
 */
public class Dlg_favorites extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_favorites
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void order(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {

        public final String num;
        public final String desc;
        public final double qty;
        public final double price;
        public final String uom;

        public OutputData(String num, String desc, double qty, double price,String uom) {
            this.num = num;
            this.desc = desc;
            this.qty = qty;
            this.price = price;
            this.uom=uom;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_favorites(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_favorites(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_favorites() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_favorites myRef;

    private void setThisRef(Dlg_favorites myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_favorites> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_favorites create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_favorites create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_favorites dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_favorites((java.awt.Frame) parent, false);
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
            Dlg_favorites dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_favorites((java.awt.Dialog) parent, false);
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


        Dlg_favorites dialog = Dlg_favorites.create(new javax.swing.JFrame(), true);
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
        btn_18 = new javax.swing.JButton();
        btn_13 = new javax.swing.JButton();
        btn_14 = new javax.swing.JButton();
        btn_15 = new javax.swing.JButton();
        btn_16 = new javax.swing.JButton();
        btn_17 = new javax.swing.JButton();
        btn_19 = new javax.swing.JButton();
        btn_20 = new javax.swing.JButton();
        btn_21 = new javax.swing.JButton();
        btn_22 = new javax.swing.JButton();
        btn_23 = new javax.swing.JButton();
        btn_24 = new javax.swing.JButton();
        btn_25 = new javax.swing.JButton();
        btn_26 = new javax.swing.JButton();
        btn_27 = new javax.swing.JButton();
        btn_28 = new javax.swing.JButton();
        btn_29 = new javax.swing.JButton();
        btn_30 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_1.setFocusable(false);
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_1MouseReleased(evt);
            }
        });
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 120));

        btn_2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_2.setFocusable(false);
        btn_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_2MouseReleased(evt);
            }
        });
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 190, 120));

        btn_3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_3.setFocusable(false);
        btn_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_3MouseReleased(evt);
            }
        });
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 190, 120));

        btn_4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_4.setFocusable(false);
        btn_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_4MouseReleased(evt);
            }
        });
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 190, 120));

        btn_5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_5.setFocusable(false);
        btn_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_5MouseReleased(evt);
            }
        });
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 190, 120));

        btn_6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_6.setFocusable(false);
        btn_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_6MouseReleased(evt);
            }
        });
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 190, 120));

        btn_7.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_7.setFocusable(false);
        btn_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_7MouseReleased(evt);
            }
        });
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 190, 120));

        btn_8.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_8.setFocusable(false);
        btn_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_8MouseReleased(evt);
            }
        });
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 190, 120));

        btn_9.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_9.setFocusable(false);
        btn_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_9MouseReleased(evt);
            }
        });
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 190, 120));

        btn_10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_10.setFocusable(false);
        btn_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_10MouseReleased(evt);
            }
        });
        btn_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_10ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 190, 120));

        btn_11.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_11.setFocusable(false);
        btn_11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_11MouseReleased(evt);
            }
        });
        btn_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_11ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 190, 120));

        btn_12.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_12.setFocusable(false);
        btn_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_12MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_12MouseReleased(evt);
            }
        });
        btn_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_12ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 140, 190, 120));

        btn_18.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_18.setFocusable(false);
        btn_18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_18MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_18MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_18MouseReleased(evt);
            }
        });
        btn_18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_18ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, 120));

        btn_13.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_13.setFocusable(false);
        btn_13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_13MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_13MouseReleased(evt);
            }
        });
        btn_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_13ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 190, 120));

        btn_14.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_14.setFocusable(false);
        btn_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_14MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_14MouseReleased(evt);
            }
        });
        btn_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_14ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 190, 120));

        btn_15.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_15.setFocusable(false);
        btn_15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_15MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_15MouseReleased(evt);
            }
        });
        btn_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_15ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 190, 120));

        btn_16.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_16.setFocusable(false);
        btn_16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_16MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_16MouseReleased(evt);
            }
        });
        btn_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_16ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 190, 120));

        btn_17.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_17.setFocusable(false);
        btn_17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_17MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_17MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_17MouseReleased(evt);
            }
        });
        btn_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_17ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 270, 190, 120));

        btn_19.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_19.setFocusable(false);
        btn_19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_19MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_19MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_19MouseReleased(evt);
            }
        });
        btn_19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_19ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 190, 120));

        btn_20.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_20.setFocusable(false);
        btn_20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_20MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_20MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_20MouseReleased(evt);
            }
        });
        btn_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_20ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 190, 120));

        btn_21.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_21.setFocusable(false);
        btn_21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_21MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_21MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_21MouseReleased(evt);
            }
        });
        btn_21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_21ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 190, 120));

        btn_22.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_22.setFocusable(false);
        btn_22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_22MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_22MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_22MouseReleased(evt);
            }
        });
        btn_22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_22ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 190, 120));

        btn_23.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_23.setFocusable(false);
        btn_23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_23MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_23MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_23MouseReleased(evt);
            }
        });
        btn_23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_23ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, 190, 120));

        btn_24.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_24.setFocusable(false);
        btn_24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_24MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_24MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_24MouseReleased(evt);
            }
        });
        btn_24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_24ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 400, 190, 120));

        btn_25.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_25.setFocusable(false);
        btn_25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_25MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_25MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_25MouseReleased(evt);
            }
        });
        btn_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_25ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 190, 120));

        btn_26.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_26.setFocusable(false);
        btn_26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_26MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_26MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_26MouseReleased(evt);
            }
        });
        btn_26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_26ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 190, 120));

        btn_27.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_27.setFocusable(false);
        btn_27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_27MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_27MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_27MouseReleased(evt);
            }
        });
        btn_27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_27ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 190, 120));

        btn_28.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_28.setFocusable(false);
        btn_28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_28MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_28MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_28MouseReleased(evt);
            }
        });
        btn_28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_28ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 190, 120));

        btn_29.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_29.setFocusable(false);
        btn_29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_29MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_29MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_29MouseReleased(evt);
            }
        });
        btn_29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_29ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 530, 190, 120));

        btn_30.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btn_30.setFocusable(false);
        btn_30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_30MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_30MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_30MouseReleased(evt);
            }
        });
        btn_30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_30ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 530, 190, 120));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/button-close-ronald_2.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/button-close-ronald-MO_1.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/button-close-ronald-MO_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 200, 50, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        // TODO add your handling code here:
        btn = 1;
        do_click();
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        // TODO add your handling code here:
        btn = 2;
        do_click();
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        // TODO add your handling code here:
        btn = 3;
        do_click();
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        // TODO add your handling code here:
        btn = 4;
        do_click();
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        // TODO add your handling code here:
        btn = 5;
        do_click();
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        // TODO add your handling code here:
        btn = 6;
        do_click();
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        // TODO add your handling code here:
        btn = 7;
        do_click();
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        // TODO add your handling code here:'
        btn = 8;
        do_click();
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        // TODO add your handling code here:
        btn = 9;
        do_click();
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_10ActionPerformed
        // TODO add your handling code here:
        btn = 10;
        do_click();
    }//GEN-LAST:event_btn_10ActionPerformed

    private void btn_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_11ActionPerformed
        // TODO add your handling code here:
        btn = 11;
        do_click();
    }//GEN-LAST:event_btn_11ActionPerformed

    private void btn_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_12ActionPerformed
        // TODO add your handling code here:
        btn = 12;
        do_click();
    }//GEN-LAST:event_btn_12ActionPerformed

    private void btn_18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_18ActionPerformed
        // TODO add your handling code here:
        btn = 18;
        do_click();
    }//GEN-LAST:event_btn_18ActionPerformed

    private void btn_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_13ActionPerformed
        // TODO add your handling code here:
        btn = 13;
        do_click();
    }//GEN-LAST:event_btn_13ActionPerformed

    private void btn_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_14ActionPerformed
        // TODO add your handling code here:
        btn = 14;
        do_click();
    }//GEN-LAST:event_btn_14ActionPerformed

    private void btn_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_15ActionPerformed
        // TODO add your handling code here:
        btn = 15;
        do_click();
    }//GEN-LAST:event_btn_15ActionPerformed

    private void btn_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_16ActionPerformed
        // TODO add your handling code here:
        btn = 16;
        do_click();
    }//GEN-LAST:event_btn_16ActionPerformed

    private void btn_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_17ActionPerformed
        // TODO add your handling code here:
        btn = 17;
        do_click();
    }//GEN-LAST:event_btn_17ActionPerformed

    private void btn_19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_19ActionPerformed
        // TODO add your handling code here:
        btn = 18;
        do_click();
    }//GEN-LAST:event_btn_19ActionPerformed

    private void btn_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_20ActionPerformed
        // TODO add your handling code here:
        btn = 20;
        do_click();
    }//GEN-LAST:event_btn_20ActionPerformed

    private void btn_21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_21ActionPerformed
        // TODO add your handling code here:
        btn = 21;
        do_click();
    }//GEN-LAST:event_btn_21ActionPerformed

    private void btn_22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_22ActionPerformed
        // TODO add your handling code here:
        btn = 22;
        do_click();
    }//GEN-LAST:event_btn_22ActionPerformed

    private void btn_23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_23ActionPerformed
        // TODO add your handling code here:
        btn = 23;
        do_click();
    }//GEN-LAST:event_btn_23ActionPerformed

    private void btn_24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_24ActionPerformed
        // TODO add your handling code here:
        btn = 24;
        do_click();
    }//GEN-LAST:event_btn_24ActionPerformed

    private void btn_25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_25ActionPerformed
        // TODO add your handling code here:
        btn = 25;
        do_click();
    }//GEN-LAST:event_btn_25ActionPerformed

    private void btn_26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_26ActionPerformed
        // TODO add your handling code here:
        btn = 26;
        do_click();
    }//GEN-LAST:event_btn_26ActionPerformed

    private void btn_27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_27ActionPerformed
        // TODO add your handling code here:
        btn = 27;
        do_click();
    }//GEN-LAST:event_btn_27ActionPerformed

    private void btn_28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_28ActionPerformed
        // TODO add your handling code here:
        btn = 28;
        do_click();
    }//GEN-LAST:event_btn_28ActionPerformed

    private void btn_29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_29ActionPerformed
        // TODO add your handling code here:
        btn = 29;
        do_click();
    }//GEN-LAST:event_btn_29ActionPerformed

    private void btn_30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_30ActionPerformed
        // TODO add your handling code here:
        btn = 30;
        do_click();
    }//GEN-LAST:event_btn_30ActionPerformed

    private void btn_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_1MousePressed

    private void btn_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_2MousePressed

    private void btn_3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_3MousePressed

    private void btn_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_4MousePressed

    private void btn_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_5MousePressed

    private void btn_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_6MousePressed

    private void btn_7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_7MousePressed

    private void btn_8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_8MousePressed

    private void btn_9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_9MousePressed

    private void btn_10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_10MousePressed

    private void btn_11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_11MousePressed

    private void btn_12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_12MousePressed

    private void btn_18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_18MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_18MousePressed

    private void btn_13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_13MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_13MousePressed

    private void btn_14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_14MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_14MousePressed

    private void btn_15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_15MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_15MousePressed

    private void btn_16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_16MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_16MousePressed

    private void btn_17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_17MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_17MousePressed

    private void btn_19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_19MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_19MousePressed

    private void btn_20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_20MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_20MousePressed

    private void btn_21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_21MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_21MousePressed

    private void btn_22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_22MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_22MousePressed

    private void btn_23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_23MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_23MousePressed

    private void btn_24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_24MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_24MousePressed

    private void btn_25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_25MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_25MousePressed

    private void btn_26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_26MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_26MousePressed

    private void btn_27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_27MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_27MousePressed

    private void btn_28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_28MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_28MousePressed

    private void btn_29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_29MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_29MousePressed

    private void btn_30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_30MousePressed
        // TODO add your handling code here:
        pressedtime = new Date();
    }//GEN-LAST:event_btn_30MousePressed

    private void btn_1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_1MouseReleased

    private void btn_2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_2MouseReleased

    private void btn_3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_3MouseReleased

    private void btn_4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_4MouseReleased

    private void btn_5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_5MouseReleased

    private void btn_6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_6MouseReleased

    private void btn_7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_7MouseReleased

    private void btn_8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_8MouseReleased

    private void btn_9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_9MouseReleased

    private void btn_10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_10MouseReleased

    private void btn_11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_11MouseReleased

    private void btn_12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_12MouseReleased

    private void btn_18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_18MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_18MouseReleased

    private void btn_13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_13MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_13MouseReleased

    private void btn_14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_14MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_14MouseReleased

    private void btn_15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_15MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_15MouseReleased

    private void btn_16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_16MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_16MouseReleased

    private void btn_17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_17MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_17MouseReleased

    private void btn_19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_19MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_19MouseReleased

    private void btn_20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_20MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_20MouseReleased

    private void btn_21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_21MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_21MouseReleased

    private void btn_22MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_22MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_22MouseReleased

    private void btn_23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_23MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_23MouseReleased

    private void btn_24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_24MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_24MouseReleased

    private void btn_25MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_25MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_25MouseReleased

    private void btn_26MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_26MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_26MouseReleased

    private void btn_27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_27MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_27MouseReleased

    private void btn_28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_28MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_28MouseReleased

    private void btn_29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_29MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_29MouseReleased

    private void btn_30MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_30MouseReleased
        // TODO add your handling code here:
        do_pressed();
    }//GEN-LAST:event_btn_30MouseReleased

    private void btn_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_1MouseClicked

    private void btn_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_2MouseClicked

    private void btn_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_3MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_3MouseClicked

    private void btn_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_4MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_4MouseClicked

    private void btn_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_5MouseClicked

    private void btn_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_6MouseClicked

    private void btn_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_7MouseClicked

    private void btn_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_8MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_8MouseClicked

    private void btn_9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_9MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_9MouseClicked

    private void btn_10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_10MouseClicked

    private void btn_11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_11MouseClicked

    private void btn_12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_12MouseClicked

    private void btn_18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_18MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_18MouseClicked

    private void btn_13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_13MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_13MouseClicked

    private void btn_14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_14MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_14MouseClicked

    private void btn_15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_15MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_15MouseClicked

    private void btn_16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_16MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_16MouseClicked

    private void btn_17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_17MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_17MouseClicked

    private void btn_19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_19MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_19MouseClicked

    private void btn_20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_20MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_20MouseClicked

    private void btn_21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_21MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_21MouseClicked

    private void btn_22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_22MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_22MouseClicked

    private void btn_23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_23MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_23MouseClicked

    private void btn_24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_24MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_24MouseClicked

    private void btn_25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_25MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_25MouseClicked

    private void btn_26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_26MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_26MouseClicked

    private void btn_27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_27MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_27MouseClicked

    private void btn_28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_28MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_28MouseClicked

    private void btn_29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_29MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_29MouseClicked

    private void btn_30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_30MouseClicked
        // TODO add your handling code here:
        ok1();
    }//GEN-LAST:event_btn_30MouseClicked

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
    private javax.swing.JButton btn_26;
    private javax.swing.JButton btn_27;
    private javax.swing.JButton btn_28;
    private javax.swing.JButton btn_29;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_30;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
        init_key();
//         do_init_list();
        do_init_list();
        t.start();
    }
    Timer t = new Timer(4000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            do_init_list();
        }
    });
    JTable table = new JTable();
    String table_no = "0";
    ArrayListModel model = new ArrayListModel();

    public void do_pass(JTable tbl, String tbl_no, ArrayListModel l) {
        model = l;
        table_no = tbl_no;
        table = tbl;
        do_init_list();
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
    List<String> categories_num = new ArrayList();
    List<String> categories_name = new ArrayList();
    List<S1_get_category.to> categories = new ArrayList();
    List<String> cat_number = new ArrayList();
    int btn = 0;

    private void do_init_list() {
        categories.clear();
        categories_num.clear();
        categories_name.clear();
        cat_number.clear();
//            JOptionPane.showMessageDialog(null, category_flip_num);
        categories = S1_get_category.get_product2();


        int size = categories.size();
//        System.out.println(size +" v ");
        if (size == 0) {
//            JOptionPane.showMessageDialog(null, "adadad");
            return;
        }

        for (S1_get_category.to t : categories) {
//            System.out.println(t.names);
            categories_num.add(t.nums);

            categories_name.add(t.names);
            System.out.println(t.names + " adad");
//            System.out.println(t.nums);
//            System.out.println(t.names);
        }
        set_btns();
    }

    private void set_btns() {

        JButton[] btn1 = {
            btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15, btn_16, btn_17, btn_18, btn_19, btn_20, btn_21, btn_22, btn_23, btn_24, btn_25, btn_26, btn_27, btn_28, btn_29, btn_30
        };

        int tt = 0;
        int gg = 0;
        int size2 = categories_num.size();
        for (JButton b : btn1) {
            String name = "";
            String num = "";
            if (tt >= size2) {
                name = "";
                num = "";
            } else {
//                System.out.println(cat.get(tt));
//                    name = cat.get(tt);
                num = categories_num.get(tt);
//                b.setText(num);
                name = categories_name.get(tt);
//            Next_line2.do_set_btn(b, name);

            }
            if (!name.isEmpty()) {
                next_line.do_next(gg, b, name, table, name, num, table_no, 3);
                tt++;
                gg++;
//                System.out.println(name + " --------  ");
            }
        }
    }

    private void ok1() {
        int size = categories_num.size();
        if (btn - 1 >= size) {
            return;
        }
        boolean if_exists = S11_check_available_kilos.prod_exists(categories_num.get(btn - 1));
        if (if_exists == false) {
            return;
        }
        
        double qt=S11_check_available_kilos.get_kilos(categories_num.get(btn - 1));
        if(qt==0){
            return;
        }
        String num = categories_num.get(btn - 1);
        String name = categories_name.get(btn - 1);
        double qty = S11_check_available_kilos.get_kilos(num);
        double new_qty = 0;
        int rows = table.getRowCount();
        if (rows < 0) {
//            return;
        } else {
            for (int i = 0; i < rows; i++) {
                String pro = table.getModel().
                        getValueAt(i, 5).
                        toString();
                if (pro.equals(num)) {
                    new_qty = FitIn.toDouble(table.getModel().
                            getValueAt(i, 0).
                            toString());
                    break;
                }
            }
        }


        
        qty -= new_qty;
        double price1 = S10_select_products.get_price(categories_num.get(btn - 1));
        if (callback != null) {
            t.stop();
            callback.order(new CloseDialog(this), new OutputData(num, name, qty, price1,"pcs"));
        }
    }

    private void ok2() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData("", "", 0, 0,""));
        }
    }
    Date pressedtime;
    long timeClicked;

    private void do_click() {
//        JOptionPane.showMessageDialog(null, categories_num.get(btn - 1));
    }

    private void do_pressed() {
        t.stop();
        timeClicked = (new Date()).getTime() - pressedtime.getTime();
//                JOptionPane.showMessageDialog(null, timeClicked);
        if (timeClicked >= 400) {

//                     JOptionPane.showMessageDialog(null, timeClicked);
            do_delete();
        }
    }

    private void do_delete() {
        int size = categories_num.size();
        if (btn - 1 >= size) {
            return;
        }
        boolean if_exists = S11_check_available_kilos.prod_exists(categories_num.get(btn - 1));
        if (if_exists == false) {
            return;
        }
        S5_favorites.do_delete(categories_num.get(btn - 1));
        t.start();

        JButton[] btn1 = {
            btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15, btn_16, btn_17, btn_18, btn_19, btn_20, btn_21, btn_22, btn_23, btn_24, btn_25, btn_26, btn_27, btn_28, btn_29, btn_30
        };
        for (JButton btn : btn1) {
            btn.setText("");
        }
        do_init_list();
        SwingUtilities.updateComponentTreeUI(this);
        ok2();
//        JOptionPane.showMessageDialog(null, "adadad");
    }
}
