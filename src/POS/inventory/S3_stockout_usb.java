/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inventory;

import POS.to2.to_add_product;
import java.io.File;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ObjectSerPersister;

/**
 *
 * @author i1
 */
public class S3_stockout_usb {
    // saving to usb snippet.

    public static void save_ending_to_usb(List<to_add_product> datas) {

        if (datas.isEmpty()) {
            return;
        }

        String path = System.getProperty("user.home");
        JFileChooser f = new JFileChooser(path + "/");
        f.setDialogTitle("Save Ending Inventory");
        f.setMultiSelectionEnabled(false);
        f.setFileFilter(new FileNameExtensionFilter("Inventory", "ending"));
        f.setApproveButtonText("Save");
        f.setApproveButtonMnemonic('S');
        f.setAcceptAllFileFilterUsed(false);

        Date date_saved = new Date();
        f.setSelectedFile(new File(
                MessageFormat.format("{0}_{1,date,yyyyMMddhhmmss}",
                "Ronald", date_saved)));


        int action = f.showDialog(null, "Save");
        if (action == JFileChooser.APPROVE_OPTION) {
            File file = f.getSelectedFile();

            if (file.getName().
                    isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please choose a filename");
            }

            try {

                // save the file here
                String filename = file.getAbsoluteFile() + ".ending";
                Lg.$.info(filename);
                ObjectSerPersister osp = new ObjectSerPersister(filename);
                osp.openSerFile();


                String screen_name = "Ronald";
                int cashier_refid = 111;
                String comments = "comment";

                to_add_product tie = new to_add_product(path, path, path, path, path, path, path, comments, comments, action, path, action,0,0,"","","");

                // do not include canceled
//                for (int i = 0, n = datas.size(); i < n; i++) {
//                    to_add_product t = (to_add_product) datas.get(i);
//                    if (!t.isCancel()) {
//                        tie..add(t);
//                    }
//
//                }

                osp.persist(tie);

                JOptionPane.showMessageDialog(null, "Save OK");

            } catch (Exception e) {
                Lg.$.info(e.getMessage());
                throw new RuntimeException(e);
//                JOptionPane.showMessageDialog(null, "Cannot be save");
            }

        }

    }
    public static void get_from_usb() {
        // open a JFileChooser
        String path = System.getProperty("user.home");
        JFileChooser f = new JFileChooser(path + "/");

        f.setDialogTitle("Open To Ending Inventory");
        f.setFileFilter(new FileNameExtensionFilter("Inventory", "ending"));
        f.setAcceptAllFileFilterUsed(false);
        f.setControlButtonsAreShown(true);
        f.setMultiSelectionEnabled(false);

        int action = f.showDialog(null, "Open");
        if (action == JFileChooser.APPROVE_OPTION) {
            File file = f.getSelectedFile();

            if (file.getName().
                    isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please choose a filename");
            }

            try {


                String filename = file.getAbsolutePath();
                Lg.$.info(filename);
                ObjectSerPersister osp = new ObjectSerPersister(filename);
                osp.openSerFile();
                Lg.$.info(Boolean.toString(osp.hasLeftOver()));
                to_add_product tie = (to_add_product) osp.loadLeftOver();
                
                // view first
//                fill_and_load(tie);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid format");
            }

        }
    }
}
