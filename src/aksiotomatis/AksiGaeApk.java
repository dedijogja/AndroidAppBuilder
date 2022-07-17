/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AppModel;
import util.Constant;

/**
 *
 * @author DekaStudio
 */
public class AksiGaeApk {
    private final AppModel appModel;

    public AksiGaeApk(AppModel appModel) {
        this.appModel = appModel;
    }
    
    public void eksekusi(){
        gaeApk();     
    }
    
    private void gaeApk(){
        try {
            File file = new File(appModel.getFolderModuleTujuan());
            String rootFolder = file.getParentFile().toString();
            String perintahClean = "";
            if(rootFolder.startsWith("c:") || rootFolder.startsWith("C:")){
                perintahClean = "c: && ";
            }else if(rootFolder.startsWith("d:") || rootFolder.startsWith("D:")){
                perintahClean = "d: && ";
            }else if(rootFolder.startsWith("e:") || rootFolder.startsWith("E:")){
                perintahClean = "e: && ";
            }else if(rootFolder.startsWith("f:") || rootFolder.startsWith("F:")){
                perintahClean = "f: && ";
            }else if(rootFolder.startsWith("g:") || rootFolder.startsWith("G:")){
                perintahClean = "g: && ";
            }else if(rootFolder.startsWith("h:") || rootFolder.startsWith("H:")){
                perintahClean = "h: && ";
            }else if(rootFolder.startsWith("i:") || rootFolder.startsWith("I:")){
                perintahClean = "i: && "; 
            }

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", perintahClean + "cd \""+rootFolder+"\" && gradlew assembleRelease");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    copyApk();
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(AksiGaeApk.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
    }
    
    private void copyApk(){
        File sourceFile = new File(appModel.getFolderModuleTujuan() + "\\build\\outputs\\apk");
        File destination = new File(appModel.getFolderSumberSource() + "\\"+Constant.namaFolderAPKjadi);
        copyDirectory(sourceFile, destination);
    }
    
     
    public void copy(File sourceLocation, File targetLocation) {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else {
            copyFile(sourceLocation, targetLocation);
        }
    }

    private void copyDirectory(File source, File target) {
        if (!target.exists()) {
            target.mkdir();
        }

        for (String f : source.list()) {
            copy(new File(source, f), new File(target, f));
        }
    }

    private void copyFile(File source, File target) {        
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)
        ) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AksiGaeApk.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(AksiGaeApk.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
    }
}
