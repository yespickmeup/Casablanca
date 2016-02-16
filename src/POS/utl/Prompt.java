/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.utl;

import java.awt.Window;
import javax.swing.JFrame;
import POS.utl.Center;
import mijzcx.synapse.desk.utils.CloseDialog;

/**
 *
 * @author i1
 */
public class Prompt {
    
    
    public static void call(String message){
        Window p = (Window) new JFrame();
        Dlg_prompt nd = Dlg_prompt.create(p, true);
        nd.setTitle("");
        nd.do_pass(message);
        nd.setCallback(new Dlg_prompt.Callback() {
            
            @Override
            public void ok(CloseDialog closeDialog, Dlg_prompt.OutputData data) {
                closeDialog.ok();
            }
        });
        Center.setCenter(nd);
        
        nd.setVisible(true);
    }
    public static void main(String[] args) {
        call("adad");
    }
}
