/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_dlg4;

import POS.dlg2.Dlg_commission;
import POS.dlg2.dlg_keyboard2;
import POS.dlg3.Dlg_customer_endorsements;
import POS.utl.Bottom;
import POS.utl.DateType;
import POS.utl.TableUtility;
import POS_svc3.S2_cashiers;
import POS_svc3.S5_sales;
import POS_svc3.S6_customer_charges;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author i1
 */
public class Dlg_sales extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_sales
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;


    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);

        void charges(CloseDialog closeDialog, OutputData2 data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }

    public static class OutputData2 {
//          "id", "BARCODE", "PRODUCT NAME", "PRICE", "SOLD", "DATE ADDED", "cashier_id"

        public final String barcode;
        public final String product_name;
        public final double price;
        public final double qty;
        public final String cashier_id;

        public OutputData2(String barcode, String product_name, double price, double qty, String cashier_id) {
            this.barcode = barcode;
            this.product_name = product_name;
            this.price = price;
            this.qty = qty;
            this.cashier_id = cashier_id;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_sales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_sales(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_sales() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_sales myRef;

    private void setThisRef(Dlg_sales myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_sales> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_sales create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_sales create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_sales((java.awt.Frame) parent, false);
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
            Dlg_sales dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_sales((java.awt.Dialog) parent, false);
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


        Dlg_sales dialog = Dlg_sales.create(new javax.swing.JFrame(), true);
        Center.setCenter(dialog);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_cashier = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lb_total = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ds_title = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_search = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lb_remitance = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dp_date = new com.toedter.calendar.JDateChooser();
        lb_commission = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_members = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        tf_member = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lbl_credit = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lbl_credit_direct = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_total_sales = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_actual_sales = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_bakery = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(159, 207, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("REMITTANCE:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 70, 30, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DOWN");
        jLabel6.setFocusable(false);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 440, 58, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CLOSE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 620, 57, 40));

        cb_cashier.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        cb_cashier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cashier.setFocusable(false);
        cb_cashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashierActionPerformed(evt);
            }
        });
        jPanel1.add(cb_cashier, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 320, 40));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("UP");
        jLabel5.setFocusable(false);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 310, 52, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/close-MO.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 560, 69, 52));

        tbl_sales.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_sales.setFocusable(false);
        tbl_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sales);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1200, 420));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("MEMBER:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 70, 20, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup-MO.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowup-MO.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 240, 74, 52));

        lb_total.setBackground(new java.awt.Color(0, 0, 0));
        lb_total.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_total.setForeground(java.awt.Color.green);
        lb_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_total.setText("0.0");
        lb_total.setOpaque(true);
        jPanel1.add(lb_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, 150, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/rrowdown.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowdown-MO.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/POS/img2/arrowdown-MO.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 460, 74, 52));

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ds_title.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        ds_title.setForeground(new java.awt.Color(41, 9, 149));
        ds_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ds_title.setText("SALES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 1326, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ds_title, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 13, -1, 40));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CASHIER SALES");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 590, 150, 30));

        tf_search.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
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
        jPanel1.add(tf_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 460, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("=");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, 20, 70));

        lb_remitance.setBackground(new java.awt.Color(0, 0, 0));
        lb_remitance.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_remitance.setForeground(java.awt.Color.green);
        lb_remitance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_remitance.setText("0.0");
        lb_remitance.setOpaque(true);
        jPanel1.add(lb_remitance, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 70, 30, 30));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("SELECT CASHIER:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 143, 37));

        dp_date.setFocusable(false);
        dp_date.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dp_datePropertyChange(evt);
            }
        });
        jPanel1.add(dp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 230, 40));

        lb_commission.setBackground(new java.awt.Color(0, 0, 0));
        lb_commission.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_commission.setForeground(java.awt.Color.green);
        lb_commission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_commission.setText("0.0");
        lb_commission.setOpaque(true);
        jPanel1.add(lb_commission, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 70, 20, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("COMMISSION:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 70, 20, 30));

        tbl_members.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NAME", "CREDIT"
            }
        ));
        tbl_members.setFocusable(false);
        tbl_members.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_membersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_members);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 30, 30));

        jButton6.setText("+");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 50, 30));

        tf_member.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tf_member.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_member.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_memberKeyReleased(evt);
            }
        });
        jPanel1.add(tf_member, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 30, 30));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("SEARCH:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 80, 30));

        lbl_credit.setBackground(new java.awt.Color(0, 0, 0));
        lbl_credit.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_credit.setForeground(java.awt.Color.green);
        lbl_credit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_credit.setText("0.0");
        lbl_credit.setOpaque(true);
        jPanel1.add(lbl_credit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 70, 10, 30));

        jButton4.setText("CANCEL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 160, 90, 40));

        jButton7.setText("VIEW");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 30, 30));

        jButton5.setText("ADD");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, 30, 30));

        lbl_credit_direct.setBackground(new java.awt.Color(0, 0, 0));
        lbl_credit_direct.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_credit_direct.setForeground(java.awt.Color.green);
        lbl_credit_direct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_credit_direct.setText("0.0");
        lbl_credit_direct.setOpaque(true);
        lbl_credit_direct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_credit_directMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_credit_direct, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 620, 190, 40));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("REC.");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 70, 20, 30));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setText("DATE OF SALES:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 170, 37));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("TOTAL SALES OF THE DAY");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 190, 30));

        lbl_total_sales.setBackground(new java.awt.Color(0, 0, 0));
        lbl_total_sales.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_total_sales.setForeground(java.awt.Color.green);
        lbl_total_sales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total_sales.setText("0.0");
        lbl_total_sales.setOpaque(true);
        lbl_total_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_total_salesMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_total_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 190, 40));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL ACCT. RECEIVABLES");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 590, 190, 30));

        lbl_actual_sales.setBackground(new java.awt.Color(0, 0, 0));
        lbl_actual_sales.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_actual_sales.setForeground(java.awt.Color.yellow);
        lbl_actual_sales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_actual_sales.setText("0.0");
        lbl_actual_sales.setOpaque(true);
        lbl_actual_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_actual_salesMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_actual_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 620, 180, 40));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("BAKERY");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 160, 30));

        lbl_bakery.setBackground(new java.awt.Color(0, 0, 0));
        lbl_bakery.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_bakery.setForeground(java.awt.Color.white);
        lbl_bakery.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_bakery.setText("0.0");
        lbl_bakery.setOpaque(true);
        lbl_bakery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_bakeryMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_bakery, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 620, 160, 40));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ACTUAL SALES");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 180, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 670));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("CASHIER SALES:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 610, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_cashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashierActionPerformed
        // TODO add your handling code here:
        data_employee("");
        data_credit();
    }//GEN-LAST:event_cb_cashierActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_salesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        do_down();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        do_up();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_searchActionPerformed

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        data_employee(tf_search.getText());
    }//GEN-LAST:event_tf_searchKeyReleased

    private void dp_datePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dp_datePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dp_datePropertyChange

    private void tf_memberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_memberKeyReleased
        // TODO add your handling code here:
        data_credit();
    }//GEN-LAST:event_tf_memberKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        do_cancel_sales();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_membersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_membersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_membersMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        view_details();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        add_credit();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void lbl_credit_directMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_credit_directMouseClicked
        // TODO add your handling code here:
        direct_sale();
    }//GEN-LAST:event_lbl_credit_directMouseClicked

    private void lbl_total_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_total_salesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_total_salesMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        do_keyboard();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void lbl_actual_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_actual_salesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_actual_salesMouseClicked

    private void lbl_bakeryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_bakeryMouseClicked
        // TODO add your handling code here:
        add_commission();
    }//GEN-LAST:event_lbl_bakeryMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_cashier;
    private com.toedter.calendar.JDateChooser dp_date;
    private javax.swing.JLabel ds_title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_commission;
    private javax.swing.JLabel lb_remitance;
    private javax.swing.JLabel lb_total;
    private javax.swing.JLabel lbl_actual_sales;
    private javax.swing.JLabel lbl_bakery;
    private javax.swing.JLabel lbl_credit;
    private javax.swing.JLabel lbl_credit_direct;
    private javax.swing.JLabel lbl_total_sales;
    private javax.swing.JTable tbl_members;
    private javax.swing.JTable tbl_sales;
    private javax.swing.JTextField tf_member;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void get_cashiers() {
        dp_date.setDate(new Date());
        dp_date.transferFocus();
        tf_search.grabFocus();
        set_act();
        cb_cashier.setModel(new ListComboBoxModel(S2_cashiers.get_cashiers_names()));
    }

    private void set_act() {
        dp_date.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                data_employee(tf_search.getText());
                get_sales();
                data_credit();

            }
        });
    }

    public void do_pass2() {
        cb_cashier.setSelectedIndex(6);

        cb_cashier.setEnabled(false);
        data_employee("");
//        data_credit();
    }
    int jj = 0;

    private void myInit() {
        hide_f();
        init_key();
        get_cashiers();
        init_tbl_baptism();
        jj = 2;
        data_employee("");

//        init_tbl_credit();
//        data_credit();

    }

    private void hide_f() {
        jButton5.setVisible(false);
        jButton7.setVisible(false);
        jLabel2.setVisible(false);
        tf_member.setVisible(false);
        jScrollPane2.setVisible(false);

        tf_member.setVisible(false);
        jLabel10.setVisible(false);
        lb_commission.setVisible(false);
        lb_remitance.setVisible(false);
        jLabel3.setVisible(false);

        jLabel13.setVisible(false);
        lbl_credit.setVisible(false);
    }

    private void commission() {
        Window p = (Window) this;
        Dlg_commission nd = Dlg_commission.create(p, true);
        nd.setTitle("");
        nd.do_pass("");
        nd.setCallback(new Dlg_commission.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_commission.OutputData data) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_down() {

//            tbl_endorsements.scrollRectToVisible(tbl_endorsements.getCellRect(j, 0, false));
        jScrollPane1.transferFocusDownCycle();
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getValue() + jScrollPane1.getVerticalScrollBar().getBlockIncrement() + 20);

//      
    }

    private void do_up() {

        jScrollPane1.transferFocusUpCycle();
        jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getValue() - jScrollPane1.getVerticalScrollBar().getBlockIncrement() - 20);


    }
    String trap = "0";

    public void do_pass(String tr) {
        trap = tr;
        data_employee("");
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
    private ArrayListModel tbl_employee_payroll_ALM;
    private TblInvoicesModel tbl_employee_payroll_M;
////    

    private void init_tbl_baptism() {
        tbl_employee_payroll_ALM = new ArrayListModel();
        tbl_employee_payroll_M = new TblInvoicesModel(tbl_employee_payroll_ALM);

        tbl_sales.getTableHeader().setPreferredSize(new Dimension(100, 30));
        tbl_sales.setModel(tbl_employee_payroll_M);
        tbl_sales.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_sales.setRowHeight(25);

//        tbl_sales.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 0, 200, 100, 100, 0, 0, 0, 0, 0, 0, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_sales, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }

        TableUtility.align_row_to_Center(tbl_sales, 7);
        TableUtility.align_row_to_Center(tbl_sales, 10);
        TableUtility.align_row_to_Center(tbl_sales, 11);
        TableUtility.align_row_to_right(tbl_sales, 3);
        TableUtility.align_row_to_Center(tbl_sales, 4);
        TableUtility.align_row_to_Center(tbl_sales, 5);
        tbl_sales.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_sales.setRowHeight(45);
        tbl_sales.setFont(new java.awt.Font("Arial", 1, 14));
    }

    private void loadData_baptism(List<S5_sales.to_sales> acc) {
        tbl_employee_payroll_ALM.clear();
        tbl_employee_payroll_ALM.addAll(acc);
    }

    public static class TblInvoicesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "BARCODE", "PRODUCT NAME", "PRICE", "SOLD", "DATE ADDED", "cashier_id", "COMMISSION", "REMITANCE", "REMIT COST", "REMITANCE", "AMOUNT"
        };

        public TblInvoicesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S5_sales.to_sales tt = (S5_sales.to_sales) getRow(row);

            switch (col) {
                case 0:
                    return tt.id;
                case 1:
                    return tt.product_id;
                case 2:
                    return tt.product_name;
                case 3:
                    return FitIn.fmt_wc_0(tt.price);
                case 4:
                    return FitIn.fmt_woc(tt.qty_sold);
                case 5:
                    return tt.date_added;
                case 6:
                    return tt.cashier_id;
                case 7:
                    return tt.commission;
                case 8:
                    return tt.remitance;
                case 9:
                    return tt.remit_cost;
                case 10:
                    return FitIn.fmt_wc_0(tt.remit_cost * tt.qty_sold);


                default:
                    return tt.qty_sold * Double.parseDouble(FitIn.fmt_woc(tt.price));
            }
        }
    }

    private void data_employee(String item) {
//        String date = lb_date_baptism.getText();
        String name = cb_cashier.getSelectedItem().toString();
        if (name.equals("DIRECT SALES")) {
            name = "1000";
        } else {

            name = S2_cashiers.get_cashiers_id(name);
        }

//        JOptionPane.showMessageDialog(null, cb_cashier.getSelectedItem().toString());

        if (cb_cashier.getSelectedItem().toString().equals("DIRECT SALES")) {
//            jLabel17.setVisible(false);
//            lbl_bakery.setVisible(false);

        } else {
            if (cb_cashier.getSelectedItem().toString().equals("BallField")) {
//                jLabel17.setText("Commission(BallField)");
            } else {
//                jLabel17.setText("Commission(Canteen)");
            }
            jLabel17.setVisible(true);
            lbl_bakery.setVisible(true);
        }



        String dates = "";
        if (jj == 0) {
            dates = DateType.sf.format(new Date());
            loadData_baptism(S5_sales.ret_data(name, item, dates));
            compute_total();
        } else {
            dates = DateType.sf.format(dp_date.getDate());
            loadData_baptism(S5_sales.ret_data(name, item, dates));
            compute_total();
        }
//        String item=tf_search.getText();


        get_direct_credit();
        get_commission();
        get_comm();
        get_sales();


    }

    private void do_cancel_sales() {
        String tip = "";
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        final String name = tbl_sales.getModel().getValueAt(row, 2).toString();
        final String qty = (tbl_sales.getModel().getValueAt(row, 4).toString());
        final String cashier_id = tbl_sales.getModel().getValueAt(row, 6).toString();
        final String product_id = tbl_sales.getModel().getValueAt(row, 1).toString();
        final String id = tbl_sales.getModel().getValueAt(row, 0).toString();

        final double qty2 = Double.parseDouble(tbl_sales.getModel().getValueAt(row, 4).toString());
        final double price = Double.parseDouble(FitIn.fmt_woc_0(tbl_sales.getModel().getValueAt(row, 3).toString()));
//       
//            tip = "CREDIT";
//            Window p = (Window) this;
//            Dlg_sales_qty nd = Dlg_sales_qty.create(p, true);
//            nd.setTitle("");
//            nd.do_pass(qty2, name, tip);
//            nd.setCallback(new Dlg_sales_qty.Callback() {
//
//                @Override
//                public void ok(CloseDialog closeDialog, Dlg_sales_qty.OutputData data) {
//                    closeDialog.ok();
//
//                    data_employee("");
//                    ok2(product_id, name, price, data.qty, cashier_id);
//                }
//            });
//            Center.setCenter(nd);
//
//            nd.setVisible(true);

        tip = "CANCEL SALE";

        Window p = (Window) this;
        Dlg_sales_qty nd = Dlg_sales_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(qty2, name, tip);
        nd.setCallback(new Dlg_sales_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_sales_qty.OutputData data) {
                closeDialog.ok();
                do_cancel(qty2, cashier_id, product_id, data.qty, id, price, name);
                data_employee("");
                compute_total();
//                ok1();
            }
        });

        Center.setCenter(nd);

        nd.setVisible(true);


    }

    private void ok2(String product_id, String name, double price, double qty, String cashier_id) {
        if (callback != null) {
            callback.charges(new CloseDialog(this), new OutputData2(product_id, name, price, qty, cashier_id));
        }
    }

    private void do_cancel(double qty, String cashier_id, String product_id, double new_qty, String id, double price, String name) {
        S5_sales.do_cancel(qty, cashier_id, product_id, new_qty, id, price, name);

    }

    private void ok1() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }

    private void do_keyboard() {
        Window p = (Window) this;
        final dlg_keyboard2 nd = dlg_keyboard2.create(p, true);
        nd.setTitle("");
        nd.do_pass("");
        nd.setCallback(new dlg_keyboard2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, dlg_keyboard2.OutputData data) {
//                closeDialog.ok();item
                data_employee(data.name);
            }

            @Override
            public void ok1(CloseDialog closeDialog, dlg_keyboard2.OutputData data) {
                closeDialog.ok();
                data_employee(data.name);
                compute_total();
            }
        });
        Bottom.setBottom(nd);

        nd.setVisible(true);
    }

    private void compute_total() {

        double amount = 0;
        double commission = 0;
        double remitance = 0;

        List<S5_sales.to_sales> datas = tbl_employee_payroll_ALM;
        for (S5_sales.to_sales to : datas) {
            amount += Double.parseDouble(FitIn.fmt_woc(to.price)) * to.qty_sold;
            commission += Double.parseDouble(FitIn.fmt_woc(to.commission));
            remitance += Double.parseDouble(FitIn.fmt_woc(to.qty_sold)) * to.remit_cost;
        }
//z

        lb_total.setText(FitIn.fmt_wc_0(amount));
        lb_commission.setText(FitIn.fmt_wc_0(commission));
        lb_remitance.setText(FitIn.fmt_wc_0(remitance));
    }
    private ArrayListModel tbl_credit_ALM;
    private TblcreditModel tbl_credit_M;
////    

    private void init_tbl_credit() {
        tbl_credit_ALM = new ArrayListModel();
        tbl_credit_M = new TblcreditModel(tbl_credit_ALM);

        tbl_members.getTableHeader().setPreferredSize(new Dimension(100, 30));
        tbl_members.setModel(tbl_credit_M);
        tbl_members.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

//        tbl_members.setAutoResizeMode(0);
        int[] tbl_widths_accounts = {0, 100, 100};

        for (int i = 0, n = tbl_widths_accounts.length; i < n; i++) {
            if (i == 1) {
                continue;
            }

            TableWidthUtilities.setColumnWidth(tbl_members, i, tbl_widths_accounts[i]);
//          TableWidthUtilities.
//          TableWidthUtilities.
        }


        TableUtility.align_row_to_Center(tbl_members, 2);


        tbl_members.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        tbl_members.setRowHeight(40);
        tbl_members.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_charges(List<S6_customer_charges.to_member_credit> acc) {
        tbl_credit_ALM.clear();
        tbl_credit_ALM.addAll(acc);
    }

    public static class TblcreditModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "Name", "Credit"
        };

        public TblcreditModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
//           
//            if (column == 1) {
//                return true;
//            }

            return false;
        }

        @Override
        public Class getColumnClass(int col) {

            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            S6_customer_charges.to_member_credit tt = (S6_customer_charges.to_member_credit) getRow(row);

            switch (col) {
                case 0:
                    return tt.member_id;
                case 1:
                    return tt.member_name;
                default:
                    return FitIn.fmt_wc_0(tt.credit);
            }
        }
    }

    private void data_credit() {
        String name = cb_cashier.getSelectedItem().toString();
        if (name.equals("DIRECT SALES")) {
            name = "1000";
        } else {


            name = S2_cashiers.get_cashiers_id(name);


        }

//        String date = lb_date_baptism.getText();
        String date = DateType.sf.format(dp_date.getDate());
        String mem = tf_member.getText();
//        loadData_charges(S6_customer_charges.get_credits(date, mem, name));

//        compute_credit();
    }

    private void add_credit() {
        int row = tbl_sales.getSelectedRow();
        if (row < 0) {
            return;
        }
        int row2 = tbl_members.getSelectedRow();
        if (row2 < 0) {
            return;
        }


        final String cust_id = tbl_members.getModel().getValueAt(row2, 0).toString();
//        JOptionPane.showMessageDialog(null, cust_id);

        final String name = tbl_sales.getModel().getValueAt(row, 2).toString();
        final String qty = (tbl_sales.getModel().getValueAt(row, 4).toString());
        final String cashier_id = tbl_sales.getModel().getValueAt(row, 6).toString();
        final String product_id = tbl_sales.getModel().getValueAt(row, 1).toString();
        final String id = tbl_sales.getModel().getValueAt(row, 0).toString();

        final double qty2 = Double.parseDouble(tbl_sales.getModel().getValueAt(row, 4).toString());
        final double price = Double.parseDouble(FitIn.fmt_woc_0(tbl_sales.getModel().getValueAt(row, 3).toString()));

        String tip = "CREDIT";
        Window p = (Window) this;
        Dlg_sales_qty nd = Dlg_sales_qty.create(p, true);
        nd.setTitle("");
        nd.do_pass(qty2, name, tip);
        nd.setCallback(new Dlg_sales_qty.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_sales_qty.OutputData data) {
                closeDialog.ok();


                do_add(product_id, name, price, data.qty, cashier_id, cust_id);
                data_employee("");
//                data_credit();
//                ok2(product_id, name, price, data.qty, cashier_id);

            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void do_add(String barcode, String product_name, double price, double qty, String cashier_id, String cust_num) {
        String date = DateType.sf.format(dp_date.getDate());
        S6_customer_charges.add_charge(barcode, product_name, price, qty, cashier_id, cust_num, date);
    }

    private void compute_credit() {

        double credit = 0;


        List<S6_customer_charges.to_member_credit> datas = tbl_credit_ALM;
        for (S6_customer_charges.to_member_credit to : datas) {
            credit += Double.parseDouble(FitIn.fmt_woc_0(to.credit));

        }
//z

        lbl_credit.setText(FitIn.fmt_wc_0(credit));

    }

    private void view_details() {
        int row2 = tbl_members.getSelectedRow();
        if (row2 < 0) {
            return;
        }


        final String cust_id = tbl_members.getModel().getValueAt(row2, 0).toString();
//        JOptionPane.showMessageDialog(null, cust_id);

        Window p = (Window) this;
        Dlg_customer_endorsements nd = Dlg_customer_endorsements.create(p, true);
        nd.setTitle("");
//        nd.do_set(cust_id);
        nd.setCallback(new Dlg_customer_endorsements.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_customer_endorsements.OutputData data) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void direct_sale() {
        double amount = Double.parseDouble(FitIn.fmt_woc_0(lbl_credit_direct.getText()));

        Window p = (Window) this;
        Dlg_direct_credit nd = Dlg_direct_credit.create(p, true);
        nd.setTitle("");
        nd.do_pass(amount, "DIRECT CREDIT");
        nd.setCallback(new Dlg_direct_credit.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_direct_credit.OutputData data) {
                closeDialog.ok();
                add_direct_sale(data.amount);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_direct_sale(double amount) {
        String name = cb_cashier.getSelectedItem().toString();
        if (name.equals("DIRECT SALES")) {
            name = "1000";
        } else {
            name = S2_cashiers.get_cashiers_id(name);
        }

        String date = DateType.sf.format(dp_date.getDate());

        S6_customer_charges.add_direct_credit(name, amount, date);
        get_direct_credit();
        get_sales();
    }

    private void get_direct_credit() {
        String name = cb_cashier.getSelectedItem().toString();
        if (name.equals("DIRECT SALES")) {
            name = "1000";
        } else {
            name = S2_cashiers.get_cashiers_id(name);
        }

        String date = DateType.sf.format(dp_date.getDate());
        double am = S6_customer_charges.get_direct_credit(name, date);
        if (am == 0) {
            lbl_credit_direct.setForeground(java.awt.Color.WHITE);
        } else {
            lbl_credit_direct.setForeground(java.awt.Color.WHITE);
        }
        double c = Double.parseDouble(FitIn.fmt_woc_0(lbl_credit.getText()));

        if (am != c) {
            lbl_credit_direct.setForeground(java.awt.Color.WHITE);
        }
        lbl_credit_direct.setText("" + FitIn.fmt_wc_0(am));


    }

    private void get_sales() {
        String date = DateType.sf.format(dp_date.getDate());

        double sales = S6_customer_charges.get_daily_sales(date);
        lbl_total_sales.setText(FitIn.fmt_wc_0(sales));

        double bakery = FitIn.toDouble(lbl_bakery.getText());
        double total_sales = FitIn.toDouble(lbl_total_sales.getText());
        double total_credit = FitIn.toDouble(lbl_credit_direct.getText());

        double sale = total_sales - (bakery + total_credit);
        lbl_actual_sales.setText(FitIn.fmt_wc_0(sale));


    }

    private void get_commission() {
        String date = DateType.sf.format(dp_date.getDate());


        String name = cb_cashier.getSelectedItem().toString();
        if (name.equals("DIRECT SALES")) {
            name = "1000";
        } else {

            name = S2_cashiers.get_cashiers_id(name);
        }

//        JOptionPane.showMessageDialog(null, cb_cashier.getSelectedItem().toString());

        double comm = 0;
//        if (cb_cashier.getSelectedItem().toString().equals("BallField")) {
//        } else {
//            if (cb_cashier.getSelectedItem().toString().equals("BallField")) {
                comm = S6_customer_charges.get_cashier_commission_ballfield(date, name);

//            } else {
//                comm = S6_customer_charges.get_cashier_commission_canteen(date, name);
//            }

//        

//        double sales = S6_customer_charges.(date);
        lbl_bakery.setText(FitIn.fmt_wc_0(comm));

//        lbl_actual_sales.setText("" + (FitIn.toDouble(lbl_total_sales.getText()) - FitIn.toDouble(lbl_credit_direct.getText())));
    }

    private void add_commission() {
        double amount = Double.parseDouble(FitIn.fmt_woc_0(lbl_bakery.getText()));

        Window p = (Window) this;
        Dlg_direct_credit nd = Dlg_direct_credit.create(p, true);
        nd.setTitle("");
        nd.do_pass(amount, "BAKERY");
        nd.setCallback(new Dlg_direct_credit.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_direct_credit.OutputData data) {
                closeDialog.ok();
                add_sales_commission(data.amount);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }

    private void add_sales_commission(double amount) {
        String name = cb_cashier.getSelectedItem().toString();
        if (name.equals("DIRECT SALES")) {
            name = "1000";
        } else {
            name = S2_cashiers.get_cashiers_id(name);
        }

        String date = DateType.sf.format(dp_date.getDate());

        S6_customer_charges.add_sales_commission(name, amount, date);
//        get_commission();
//        get_sales();
        get_commission();
        get_comm();
        get_direct_credit();
        get_sales();
    }

    private void get_comm() {
        String date = DateType.sf.format(dp_date.getDate());
        double comm_b = 0;
        double comm_c = 0;
        if (cb_cashier.getSelectedItem().toString().equals("DIRECT SALES")) {
            lbl_bakery.setText("0.00");
//            lbl_c_com.setText("0.00");
        } else {

            comm_b = S6_customer_charges.get_cashier_commission_ballfield(date, cb_cashier.getSelectedItem().toString());

            comm_c = S6_customer_charges.get_cashier_commission_canteen(date, cb_cashier.getSelectedItem().toString());
        }
//        double sales = S6_customer_charges.(date);
//        lbl_bakery.setText(FitIn.fmt_wc_0(comm_b));
//        lbl_c_com.setText(FitIn.fmt_wc_0(comm_c));
    }

    private void direct_bakery() {
        double amount = Double.parseDouble(FitIn.fmt_woc_0(lbl_bakery.getText()));

        Window p = (Window) this;
        Dlg_direct_credit nd = Dlg_direct_credit.create(p, true);
        nd.setTitle("");
        nd.do_pass(amount, "BAKERY");
        nd.setCallback(new Dlg_direct_credit.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_direct_credit.OutputData data) {
                closeDialog.ok();
                add_direct_sale(data.amount);
            }
        });
        Center.setCenter(nd);

        nd.setVisible(true);
    }
      private void add_bakery(double amount) {
        String name = cb_cashier.getSelectedItem().toString();
        if (name.equals("DIRECT SALES")) {
            name = "1000";
        } else {
            name = S2_cashiers.get_cashiers_id(name);
        }

        String date = DateType.sf.format(dp_date.getDate());

        S6_customer_charges.add_direct_credit(name, amount, date);
        get_direct_credit();
        get_sales();
    }
}
