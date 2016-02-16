/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.guests;

import POS.Main;
import POS.dlg.country.S1_countries;
import POS.guests.S1_guest.to_guests;
import POS.tables.S1_table_types;
import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.lowagie.text.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;

/**
 *
 * @author Dummy
 */
public class Dlg_guest extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_guest
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

        public final List<to_guests> to1;
        public final double percentages;

        public OutputData(List<to_guests> to1, double percentages) {
            this.to1 = to1;
            this.percentages = percentages;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_guest(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    private Dlg_guest(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myInit();
    }

    public Dlg_guest() {
        super();
        initComponents();
        myInit();

    }
    private Dlg_guest myRef;

    private void setThisRef(Dlg_guest myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_guest> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_guest create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_guest create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_guest dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_guest((java.awt.Frame) parent, false);
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
            Dlg_guest dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_guest((java.awt.Dialog) parent, false);
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


        Dlg_guest dialog = Dlg_guest.create(new javax.swing.JFrame(), true);
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

        pm_add = new javax.swing.JPopupMenu();
        pm_a = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_guests = new javax.swing.JTable();
        tf_search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_email_address = new javax.swing.JTextField();
        tf_s_lname = new javax.swing.JTextField();
        tf_s_fname = new javax.swing.JTextField();
        tf_s_mi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_s_county = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        lbl_i_id = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_level = new javax.swing.JTextField();
        tf_contact = new javax.swing.JTextField();
        tf_contact_name = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tf_passport = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cb_how = new javax.swing.JComboBox();
        tf_remarks = new javax.swing.JTextField();
        cx_updates = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_add = new javax.swing.JTable();
        lbl_room = new javax.swing.JLabel();
        btn_walkin = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_rate = new javax.swing.JLabel();
        cb_rate_type = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        btn_ok = new javax.swing.JButton();

        pm_a.setText("ADD");
        pm_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pm_aActionPerformed(evt);
            }
        });
        pm_add.add(pm_a);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_guests.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_guests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_guestsMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_guestsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_guestsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_guests);

        tf_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tf_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_searchKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SEARCH:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("FIRST NAME:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("LAST NAME:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("EMAIL ADD:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("M.I");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("COUNTRY:");

        cb_s_county.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_s_county.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("ID #:");

        lbl_i_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_i_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_i_id.setText("00000001");
        lbl_i_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("DIVER'S CERTIFIED LEVEL:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("EMERGENCY CONTACT NO:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("EMERGENCY CONTACT NAME:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("PASSPORT NO:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("REMARKS:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("HOW DID YOU KNOW?");

        cb_how.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Friends?", "Love Ones?", "Advertisement?", "Web?", "Dont Know" }));

        cx_updates.setSelected(true);
        cx_updates.setText("AUTOMATIC UPDATES?");

        jButton5.setText("CLEAR");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("ADD");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_s_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tf_s_mi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_i_id, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_s_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cb_how, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tf_remarks))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tf_passport, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_s_county, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(cx_updates, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_level)
                                    .addComponent(tf_contact)
                                    .addComponent(tf_contact_name, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(541, 541, 541)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_email_address, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_i_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_s_mi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(tf_s_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb_s_county, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cx_updates)
                                .addComponent(tf_s_lname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_email_address, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_level, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_passport, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_remarks, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_contact_name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_how, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tbl_add.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_add);

        lbl_room.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_room.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_room.setText("ROOM GUESTS");
        lbl_room.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_walkin.setText("WALK-IN");
        btn_walkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_walkinActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("RATE TYPE:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("RATE:");

        lbl_rate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_rate.setText("0.00");
        lbl_rate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cb_rate_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_rate_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_rate_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_rate_typeActionPerformed(evt);
            }
        });

        jButton4.setText("CLOSE");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_ok.setText("OK");
        btn_ok.setFocusable(false);
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_walkin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 155, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_rate_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbl_room, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_walkin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_room, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(cb_rate_type)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5)))
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        disposed();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_guestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestsMouseClicked
        // TODO add your handling code here:
        select(evt);
    }//GEN-LAST:event_tbl_guestsMouseClicked

    private void tf_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_searchKeyReleased
        // TODO add your handling code here:
        ret_data();
    }//GEN-LAST:event_tf_searchKeyReleased

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        ok1();
    }//GEN-LAST:event_btn_okActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_guestsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestsMousePressed
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_guestsMousePressed

    private void tbl_guestsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_guestsMouseReleased
        pm_tbl_users(evt);
    }//GEN-LAST:event_tbl_guestsMouseReleased

    private void pm_aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pm_aActionPerformed
        add_guest();
    }//GEN-LAST:event_pm_aActionPerformed

    private void btn_walkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_walkinActionPerformed
        add_walkin();
    }//GEN-LAST:event_btn_walkinActionPerformed

    private void cb_rate_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_rate_typeActionPerformed
        get_rate();
    }//GEN-LAST:event_cb_rate_typeActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_walkin;
    private javax.swing.JComboBox cb_how;
    private javax.swing.JComboBox cb_rate_type;
    private javax.swing.JComboBox cb_s_county;
    private javax.swing.JCheckBox cx_updates;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_i_id;
    private javax.swing.JLabel lbl_rate;
    private javax.swing.JLabel lbl_room;
    private javax.swing.JMenuItem pm_a;
    private javax.swing.JPopupMenu pm_add;
    private javax.swing.JTable tbl_add;
    private javax.swing.JTable tbl_guests;
    private javax.swing.JTextField tf_contact;
    private javax.swing.JTextField tf_contact_name;
    private javax.swing.JTextField tf_email_address;
    private javax.swing.JTextField tf_level;
    private javax.swing.JTextField tf_passport;
    private javax.swing.JTextField tf_remarks;
    private javax.swing.JTextField tf_s_fname;
    private javax.swing.JTextField tf_s_lname;
    private javax.swing.JTextField tf_s_mi;
    private javax.swing.JTextField tf_search;
    // End of variables declaration//GEN-END:variables

    private void myInit() {
//        Main.MyDB.setNames("db_pos_restaurant");
        btn_ok.setVisible(false);
        tf_search.grabFocus();
        set_country();
        init_key();
        init_id();
        init_tbl_guests();
        ret_data();
        init_tbl_add();
        init_room();
        get_rate();
    }

    private void init_room() {
        cb_rate_type.setModel(new ListComboBoxModel(S1_table_types.ret_cb_data()));
    }

    private void get_rate() {
        lbl_rate.setText("" + S1_table_types.ret_data(cb_rate_type.getSelectedItem().toString()));
    }

    private void set_country() {
        List<String> countries = S1_countries.ret_cb_data();

//        Locale[] locales = Locale.getAvailableLocales();
//        for (Locale locale : locales) {
//            String name = locale.getDisplayCountry();
//            
//            if (!"".equals(name)) {
//                countries.add(name);
//            }
//        }
//        for (String s : countries) {
//            int id = -1;
//            String country = s;
//            String capital = "";
//            S1_countries.to_countries to = new S1_countries.to_countries(id, country, capital);
////            S1_countries.add_country(to);
//        }
        cb_s_county.setEditable(true);
        AutoCompleteDecorator.decorate(cb_s_county);
        cb_s_county.setModel(new ListComboBoxModel(countries));
    }

    private void init_id() {
        lbl_i_id.setText(S1_guest.get_id());
    }

    public void do_pass(String version, String room_no, String type, double percentage,String table_name) {

        lbl_room.setVisible(true);
        btn_ok.setVisible(true);
        jScrollPane2.setVisible(true);
        jLabel8.setVisible(true);
        String versions = System.getProperty("version", "ordering");
        if (versions.equals("ordering")) {
            lbl_room.setText("TABLE " + table_name);
        } else {

            lbl_room.setText("ROOM " + table_name);
        }

        cb_rate_type.setSelectedItem(type);
        lbl_rate.setText("" + percentage);

        if (version.equals("resto")) {
            btn_walkin.setVisible(false);

        }
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
//-- 
    private ArrayListModel tbl_guests_ALM;
    private TblguestsModel tbl_guests_M;

    private void init_tbl_guests() {
        tbl_guests_ALM = new ArrayListModel();
        tbl_guests_M = new TblguestsModel(tbl_guests_ALM);
        tbl_guests.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_guests.setModel(tbl_guests_M);
        tbl_guests.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_guests.setRowHeight(25);
        tbl_guests.setAutoResizeMode(0);
        int[] tbl_widths_guests = {0, 0, 100, 100, 100, 100, 100, 0, 100, 100, 100, 100, 100, 100, 100};
        for (int i = 0, n = tbl_widths_guests.length; i < n; i++) {
            if (i == 100) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_guests, i, tbl_widths_guests[i]);
        }
        Dimension d = tbl_guests.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_guests.getTableHeader().setPreferredSize(d);
        tbl_guests.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_guests.setRowHeight(35);
        tbl_guests.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_guests(List<to_guests> acc) {
        tbl_guests_ALM.clear();
        tbl_guests_ALM.addAll(acc);
    }

    public static class TblguestsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "guest_id", "FIRST NAME", "LAST NAME", "MI", "COUNTRY", "EMAIL ADDRESS", "status", "DIVER'S LEVEL", "CONTACT NO", "EM. CONTACT NAME", "PASSPORT NO", "REMARKS", "HOW", "UPDATES"
        };

        public TblguestsModel(ListModel listmodel) {
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
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_guests tt = (to_guests) getRow(row);
            switch (col) {
            case 0:
                return tt.id;
            case 1:
                return tt.guest_id;
            case 2:
                return tt.fname;
            case 3:
                return tt.lname;
            case 4:
                return tt.mi;
            case 5:
                return tt.country;
            case 6:
                return tt.email_address;
            case 7:
                return tt.status;
            case 8:
                return tt.diver_cert_lvl;
            case 9:
                return tt.contact_no;
            case 10:
                return tt.emergency_contact_name;
            case 11:
                return tt.passport_no;
            case 12:
                return tt.remarks;
            case 13:
                return tt.how;
            default:
                return tt.newsletter;
            }
        }
    }

    private void ret_data() {
        loadData_guests(S1_guest.ret_data(tf_search.getText()));
    }

    private void add() {
        int id = 0;
        String guest_id = S1_guest.get_id();
        String fname = tf_s_fname.getText();
        String lname = tf_s_lname.getText();
        String mi = tf_s_mi.getText();
        String country = cb_s_county.getSelectedItem().
                toString();
        String email_address = tf_email_address.getText();
        int status = 0;
        String diver_cert_lvl = tf_level.getText();
        String contact_no = tf_contact.getText();
        String emergency_contact_name = tf_contact_name.getText();
        String passport_no = tf_passport.getText();
        String remarks = tf_remarks.getText();
        String how = cb_how.getSelectedItem().toString();
        int newsletter = 0;
        if (cx_updates.isSelected()) {
            newsletter = 1;
        }
        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter);

        S1_guest.add_guest(to);
        ret_data();
        clear();
//        JOptionPane.showMessageDialog(null, "Successfully Added");
    }

    private void clear() {
        tf_email_address.setText("");
        tf_s_fname.setText("");
        tf_s_lname.setText("");
        tf_s_mi.setText("");
        ids = 0;
        tf_contact.setText("");
        tf_contact_name.setText("");
        tf_level.setText("");
        tf_passport.setText("");
        tf_remarks.setText("");
        cx_updates.setSelected(true);
//        tf_s_mi.setText("");
        init_id();
    }
    int ids = 0;

    private void select(MouseEvent e) {
        if (e.getClickCount() == 2) {
            add_guest();
        } else {
            int row = tbl_guests.getSelectedRow();
            if (row < 0) {
                return;
            }
            ids = Integer.parseInt(tbl_guests.getModel().getValueAt(row, 0).toString());


            String guest_id = (tbl_guests.getModel().
                    getValueAt(row, 1).
                    toString());
            String fname = (tbl_guests.getModel().
                    getValueAt(row, 2).
                    toString());
            String lname = (tbl_guests.getModel().
                    getValueAt(row, 3).
                    toString());
            String mi = (tbl_guests.getModel().
                    getValueAt(row, 4).
                    toString());
            String country = (tbl_guests.getModel().
                    getValueAt(row, 5).
                    toString());
            toString();
            String email_address = (tbl_guests.getModel().
                    getValueAt(row, 6).
                    toString());
            int status = Integer.parseInt(tbl_guests.getModel().
                    getValueAt(row, 7).
                    toString());

            String diver_cert_lvl = (tbl_guests.getModel().getValueAt(row, 8).toString());
            String contact_no = (tbl_guests.getModel().getValueAt(row, 9).toString());
            String emergency_contact_name = (tbl_guests.getModel().getValueAt(row, 10).toString());
            String passport_no = (tbl_guests.getModel().getValueAt(row, 11).toString());
            String remarks = (tbl_guests.getModel().getValueAt(row, 12).toString());
            String how = (tbl_guests.getModel().getValueAt(row, 13).toString());
            String newsletter = (tbl_guests.getModel().getValueAt(row, 14).toString());
            if (newsletter.equals("1")) {
                cx_updates.setSelected(true);
            } else {
                cx_updates.setSelected(false);
            }

            lbl_i_id.setText("" + guest_id);
            tf_s_fname.setText(fname);
            tf_s_lname.setText(lname);
            tf_s_mi.setText(mi);
            cb_s_county.setSelectedItem(country);
            tf_email_address.setText(email_address);
            tf_contact.setText(contact_no);
            tf_contact_name.setText(emergency_contact_name);
            tf_passport.setText(passport_no);
            tf_remarks.setText(remarks);
            cb_how.setSelectedItem(how);
            tf_level.setText(diver_cert_lvl);
        }

    }

    private void edit() {

        int id = ids;
        String guest_id = lbl_i_id.getText();
        String fname = tf_s_fname.getText();
        String lname = tf_s_lname.getText();
        String mi = tf_s_mi.getText();
        String country = cb_s_county.getSelectedItem().
                toString();
        String email_address = tf_email_address.getText();
        int status = 0;
        String diver_cert_lvl = tf_level.getText();
        String contact_no = tf_contact.getText();
        String emergency_contact_name = tf_contact_name.getText();
        String passport_no = tf_passport.getText();
        String remarks = tf_remarks.getText();
        String how = cb_s_county.getSelectedItem().toString();

        int newsletter = 0;
        if (cx_updates.isSelected()) {
            newsletter = 1;
        }
        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter);

        S1_guest.edit_guest(to);
        ret_data();
        clear();
        JOptionPane.showMessageDialog(null, "Successfully Updated");
    }

    private void delete() {
        int id = 0;
        String guest_id = lbl_i_id.getText();
        String fname = tf_s_fname.getText();
        String lname = tf_s_lname.getText();
        String mi = tf_s_mi.getText();
        String country = cb_s_county.getSelectedItem().
                toString();
        String email_address = tf_email_address.getText();
        int status = 0;
        String diver_cert_lvl = tf_level.getText();
        String contact_no = tf_contact.getText();
        String emergency_contact_name = tf_contact_name.getText();
        String passport_no = tf_passport.getText();
        String remarks = tf_remarks.getText();
        String how = cb_s_county.getSelectedItem().toString();

        int newsletter = 0;
        if (cx_updates.isSelected()) {
            newsletter = 1;
        }
        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter);


        S1_guest.delete_guest(to, ids);
        ret_data();
        clear();
    }

    private void ok1() {
        if (tbl_add_ALM.isEmpty()) {
            return;
        }
        double per = FitIn.toDouble(lbl_rate.getText());
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData(tbl_add_ALM, per));
        }
    }

    private void pm_tbl_users(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            pm_add.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void add_guest() {
        int row = tbl_guests.getSelectedRow();
        if (row < 0) {
            return;
        }

        int id = Integer.parseInt(tbl_guests.getModel().getValueAt(row, 0).toString());
        String guest_id = tbl_guests.getModel().getValueAt(row, 1).toString();
        String fname = tbl_guests.getModel().getValueAt(row, 2).toString();
        String lname = tbl_guests.getModel().getValueAt(row, 3).toString();
        String mi = tbl_guests.getModel().getValueAt(row, 4).toString();
        String country = tbl_guests.getModel().getValueAt(row, 5).toString();
        String email_address = tbl_guests.getModel().getValueAt(row, 6).toString();
        int status = Integer.parseInt(tbl_guests.getModel().getValueAt(row, 7).toString());
        String diver_cert_lvl = tbl_guests.getModel().getValueAt(row, 8).toString();
        String contact_no = tbl_guests.getModel().getValueAt(row, 9).toString();
        String emergency_contact_name = tbl_guests.getModel().getValueAt(row, 10).toString();
        String passport_no = tbl_guests.getModel().getValueAt(row, 11).toString();
        String remarks = tbl_guests.getModel().getValueAt(row, 12).toString();
        String how = tbl_guests.getModel().getValueAt(row, 13).toString();
        int newsletter = Integer.parseInt(tbl_guests.getModel().getValueAt(row, 15).toString());
        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter);
        List<to_guests> datas = new ArrayList();
        datas.add(to);
        loadData_add(datas);
    }

    private void add_walkin() {
        int id = -1;
        String guest_id = "-1";
        String fname = "Walk-In";
        String lname = "";
        String mi = "";
        String country = "";
        String email_address = "";
        int status = 0;
        String diver_cert_lvl = "0";
        String contact_no = "0";
        String emergency_contact_name = "0";
        String passport_no = "0";
        String remarks = "0";
        String how = "0";
        int newsletter = 0;
        to_guests to = new to_guests(id, guest_id, fname, lname, mi, country, email_address, status, diver_cert_lvl, contact_no, emergency_contact_name, passport_no, remarks, how, newsletter);
        List<to_guests> datas = new ArrayList();
        datas.add(to);
        loadData_add(datas);
        ok1();
    }
    private ArrayListModel tbl_add_ALM;
    private TbladdModel tbl_add_M;

    private void init_tbl_add() {
        tbl_add_ALM = new ArrayListModel();
        tbl_add_M = new TbladdModel(tbl_add_ALM);
        tbl_add.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tbl_add.setModel(tbl_add_M);
        tbl_add.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_add.setRowHeight(25);
//        tbl_add.setAutoResizeMode(0);
        int[] tbl_widths_guests = {0, 0, 100, 100, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_guests.length; i < n; i++) {
            if (i == 2) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_add, i, tbl_widths_guests[i]);
        }
        Dimension d = tbl_add.getTableHeader().getPreferredSize();
        d.height = 30;
        tbl_add.getTableHeader().setPreferredSize(d);
        tbl_add.getTableHeader().setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        tbl_add.setRowHeight(35);
        tbl_add.setFont(new java.awt.Font("Arial", 1, 12));
    }

    private void loadData_add(List<to_guests> acc) {
//        tbl_add_ALM.clear();
        tbl_add_ALM.addAll(acc);
    }

    public static class TbladdModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "id", "guest_id", "FIRST NAME", "LAST NAME", "MI", "COUNTRY", "EMAIL ADDRESS", "status", "DIVER'S LEVEL", "CONTACT NO", "EM. CONTACT NAME", "PASSPORT NO", "REMARKS", "HOW", "UPDATES"
        };

        public TbladdModel(ListModel listmodel) {
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
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_guests tt = (to_guests) getRow(row);
            switch (col) {
            case 0:
                return tt.id;
            case 1:
                return tt.guest_id;
            case 2:
                return tt.fname;
            case 3:
                return tt.lname;
            case 4:
                return tt.mi;
            case 5:
                return tt.country;
            case 6:
                return tt.email_address;
            case 7:
                return tt.status;
            case 8:
                return tt.diver_cert_lvl;
            case 9:
                return tt.contact_no;
            case 10:
                return tt.emergency_contact_name;
            case 11:
                return tt.passport_no;
            case 12:
                return tt.remarks;
            case 13:
                return tt.how;
            default:
                return tt.newsletter;
            }
        }
    }
}
