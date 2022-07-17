/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AppModel;

/**
 *
 * @author DekaStudio
 */
public class AksiBackUpSource {
    private final AppModel appModel;

    public AksiBackUpSource(AppModel appModel) {
        this.appModel = appModel;
    }
    
    public void eksekusi() {
        lakukanBackup();
    }
    
    private void lakukanBackup() {
        File file = new File(appModel.getFolderModuleTujuan());
        String rootFolder = file.getParentFile().toString();
        File file2 = new File(rootFolder);
        String superRootFolder = file2.getParentFile().toString();
        File source = new File(superRootFolder);
        File target = new File(appModel.getFolderSumberSource());
        copyDirectory(source, target);
    }
    
    
    public void copy(File sourceLocation, File targetLocation) {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        } else {
            copyFile(sourceLocation, targetLocation);
        }
    }

    private void copyDirectory(File source, File target)  {
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
            Logger.getLogger(AksiBackUpSource.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(AksiBackUpSource.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
    }
}
