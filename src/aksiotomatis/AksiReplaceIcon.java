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
public class AksiReplaceIcon {
    private final AppModel appModel;

    public AksiReplaceIcon(AppModel appModel) {
        this.appModel = appModel;
    }
       
    private final String garisMiring = "\\";
    private final String subFolderIcon = garisMiring+"src"+garisMiring+"main"+garisMiring+"res"+garisMiring;
    
    private final String[] namaFileSource = {
        "ic_launcher72.png",
        "ic_launcher48.png",
        "ic_launcher96.png",
        "ic_launcher144.png",
        "ic_launcher192.png"
    };
    
    private final String[] daftarDirektoriIcon = {
        subFolderIcon + "mipmap-hdpi" + garisMiring,
        subFolderIcon + "mipmap-mdpi" + garisMiring,
        subFolderIcon + "mipmap-xhdpi" + garisMiring,
        subFolderIcon + "mipmap-xxhdpi" + garisMiring,
        subFolderIcon + "mipmap-xxxhdpi" + garisMiring,
        
    };

    private final String[] namaFileYangAkanDiReplace = {
        "ic_launcher.png",
        "ic_launcher_round.png"
    };
    
    public void eksekusi(){
        lakukanReplace();
    }
    
    private void lakukanReplace(){
        try{
            for(int a = 0; a<namaFileYangAkanDiReplace.length; a++){
                for(int i = 0; i<daftarDirektoriIcon.length; i++){
                    String pathFix = appModel.getFolderModuleTujuan()+daftarDirektoriIcon[i]+namaFileYangAkanDiReplace[a];
                    File sourceFile = new File(appModel.getFolderSumberSource()+garisMiring+Constant.namaFolderIconTujuan+ garisMiring + namaFileSource[i]);
                    File fileDestination = new File(pathFix);
                    if(sourceFile.isFile()){
                        copyFileUsingStream(sourceFile, fileDestination);
                    }else{
                        System.out.println(sourceFile.getPath() + " Bukan file <replace icon>");
                    }
                }
            }
    	}catch(Exception e){
           System.out.println("Terjadi kesalahan saat replace icon " + appModel.getNamaApp() + " : " + e.toString());
    	}   
    }
    
     private void copyFileUsingStream(File source, File dest)  {
        InputStream is = null;
        OutputStream os = null;
        try {
            try {
                is = new FileInputStream(source);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AksiReplaceIcon.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
            try {
                os = new FileOutputStream(dest);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AksiReplaceIcon.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
            byte[] buffer = new byte[1024];
            int length;
            try {
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } catch (IOException ex) {
                Logger.getLogger(AksiReplaceIcon.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException ex) {
                Logger.getLogger(AksiReplaceIcon.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }
    }
    
}
