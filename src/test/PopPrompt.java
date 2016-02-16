/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dummy
 */
public class PopPrompt {

    public static JPanel popup(String message) {

        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel lbl_message = new javax.swing.JLabel();
        JButton btn_ok = new javax.swing.JButton();

//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_message.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_message.setText("SUCCESSFULLY ADDED");
        jPanel1.add(lbl_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 404, 23));

        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jPanel1.di
            }
        });
        jPanel1.add(btn_ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 40, 78, -1));
        return jPanel1;
    }
}
