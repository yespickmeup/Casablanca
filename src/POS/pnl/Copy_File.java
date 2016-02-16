/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.pnl;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i1
 */
public class Copy_File {

    public static void copy(File source, File destination)
            throws IOException {
// Open file to be copied
        InputStream in = new FileInputStream(source);

// And where to copy it to
        OutputStream out = new FileOutputStream(destination);

// Read bytes and write to destination until eof

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf)) >= 0) {
            out.write(buf, 0, len);
        }

// close both streams

        in.close();
        out.close();
    }

    
    public static void add_folder(String strDirectoy, String strManyDirectories) {
        try {
            String new_path=strManyDirectories+strDirectoy;
            boolean success = (new File(new_path)).mkdirs();
            if (success==true) {
                System.out.println("Directories: "
                        + strManyDirectories + " created");
            }else{
                  System.out.println("Directory exists!!");
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } 
    }

    public static void main(String[] args) {

//        File source = new File("/home/i1/Pictures/copy/1.jpeg");
//        File destination = new File("/home/i1/Pictures/paste/1.jpeg");
//        try {
//            copy(source, destination);
//        } catch (IOException ex) {
//            Logger.getLogger(Copy_File.class.getName()).log(Level.SEVERE, null, ex);
//        }
        String strDirectoy = "ronald";
        String strManyDirectories = "/home/i1/img_templates/";
        add_folder(strDirectoy, strManyDirectories);
    }
}
