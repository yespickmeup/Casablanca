/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.loader;

import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import mijzcx.synapse.desk.utils.Application;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.Executor;

/**
 *
 * @author mijzcx
 */
public class Loader {

    public static void doExecute(JFrame ff, final Executor.Task task) {
        final Progress d = Progress.create(new JFrame(), true);
        d.setDisLabel("Please Wait...");
        final SwingWorker work = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                task.work_on();
                return null;
            }
        };
        work.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent pce) {
                if ("state".equals(pce.getPropertyName()) && SwingWorker.StateValue.DONE == pce.getNewValue()) {
                    d.setVisible(false);
                }
            }
        });
        d.setTitle("Processing");
        d.setCallback(new Progress.Callback() {

            @Override
            public void cancel(CloseDialog closeDialog) {
                work.cancel(true);
                closeDialog.ok();
            }
        });
        Center.setCenter(d);
//        work.execute();
//        d.setVisible(true);
    }

    public static interface Task {

        void work_on();
    }

   static int stat=0;
    public static void doExecute(final Window w, final Task task) {
        final Progress d = Progress.create(new JFrame(), true);
        d.setDisLabel("Please Wait...");
        final SwingWorker work = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                task.work_on();
                return null;
            }
        };
        work.execute();
        work.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent pce) {
                if ("state".equals(pce.getPropertyName()) && SwingWorker.StateValue.DONE == pce.getNewValue()) {
                    stat=100;
                    d.dispose();
                }
            }
        });
        d.setTitle("Processing");
        d.setCallback(new Progress.Callback() {

            
            @Override
            public void cancel(CloseDialog closeDialog) {
                work.cancel(true);
                closeDialog.ok();
                d.dispose();

            }
        });

        Center.setCenter(d);

        d.setVisible(true);

    }
}
