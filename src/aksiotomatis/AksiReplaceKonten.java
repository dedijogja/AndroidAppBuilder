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
import util.Constant;

/**
 *
 * @author DekaStudio
 */
public class AksiReplaceKonten {
    private final AppModel appModel;

    public AksiReplaceKonten(AppModel appModel) {
        this.appModel = appModel;
    }
    
    public void eksekusi() {
        File folderAsset = new File(appModel.getFolderModuleTujuan()+ "\\src\\main\\assets");
        hapusAssetAndroid(folderAsset);
        tulisAssetAndroid();
    }
    
    private void hapusAssetAndroid(File file){
         File[] contents = file.listFiles();
            if (contents != null) {
                for (File f : contents) {
                    hapusAssetAndroid(f);
                }
            }
        file.delete();
    }
    
    private void tulisAssetAndroid() {
        File source = new File(appModel.getFolderSumberSource() + "\\" + Constant.namaFolderHasilEnskrip);
        File target = new File(appModel.getFolderModuleTujuan() + "\\src\\main\\assets");
        copyDirectory(source, target);
    }
    
    
    public void copy(File sourceLocation, File targetLocation)  {
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

    private void copyFile(File source, File target)  {        
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
            Logger.getLogger(AksiReplaceKonten.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(AksiReplaceKonten.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
    }
}
