/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import mijzcx.synapse.desk.utils.CloseDialog;

/**
 *
 * @author mijzcx
 */
public class Executor2 {

    public static interface Task {

        void work_on();
    }

    public static void doExecute(final Window w, final Task task) {


        final ProgressDialog d = ProgressDialog.create(new JFrame(), true);
        //  d.setDisLabel("Please Wait...");
        final SwingWorker work = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                task.work_on();
                return null;
            }

            @Override
            protected void done() {
                d.dispose();
            }
        };

        work.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent pce) {
                if ("state".equals(pce.getPropertyName()) && SwingWorker.StateValue.DONE == pce.getNewValue()) {

                    d.dispose();

                }
            }
        });


        d.setTitle("Processing");
        d.setCallback(new ProgressDialog.Callback() {

            @Override
            public void cancel(CloseDialog closeDialog) {
                work.cancel(true);
                closeDialog.ok();
            }
        });
//        Center.setCenter(d);
//        work.execute();
//        d.setVisible(true);

    }
}
