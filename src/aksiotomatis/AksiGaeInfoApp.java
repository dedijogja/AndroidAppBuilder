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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AppModel;
import util.Constant;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DekaStudio
 */
public class AksiGaeInfoApp {
    private final AppModel appModel;
    
    public AksiGaeInfoApp(AppModel appModel) {
        this.appModel = appModel;
    }
    
    public void eksekusi() {
        buatDetailTXT();
        copyKeyStore();
    }
    
    private void buatDetailTXT(){
        File file = new File(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderInfoApp+"\\"+"info.txt");
        File folders = new File(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderInfoApp);         
        if(!folders.exists()){
            if (file.getParentFile().mkdirs()) {
                FileWriter fw = null;
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String isiFile = "";
                    isiFile += "------INFO APLIKASI------";
                    isiFile += "\n";
                    isiFile += "Nama App  : " + appModel.getNamaApp();
                    isiFile += "\n";
                    isiFile += "Package   : " + appModel.getPackageApp();
                    isiFile += "\n";
                    isiFile += "Key Text  : " + appModel.getKeyEnskripsiText();
                    isiFile += "\n";
                    isiFile += "Key Asset : " + appModel.getKeyEnskripsiAsset();
                    isiFile += "\n";
                    isiFile += "Dibuat    : " + dateFormat.format(new Date()) + " - (yyyy/MM/dd HH:mm:ss)";
                    isiFile += "\n";
                    isiFile += "\n";
                    isiFile += "------INFO KEYSTORE------";
                    isiFile += "\n";
                    isiFile += "Store File Name      : " + "keystore.jks (terletak satu folder dengan file ini)";
                    isiFile += "\n";
                    isiFile += "Store Password       : " + Constant.storePassword;
                    isiFile += "\n";
                    isiFile += "Store Alias          : " + Constant.storeAlias;
                    isiFile += "\n";
                    isiFile += "Store Alias Password : " + Constant.storeAliasPassword;
                    
                    File newTextFile = new File(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderInfoApp+"\\"+"info.txt");
                    fw = new FileWriter(newTextFile);
                    fw.write(isiFile);
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(AksiGaeInfoApp.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(AksiGaeInfoApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                System.err.println("Failed to create directory " + file.getParent());
            }
        } else{
            FileWriter fw = null;
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String isiFile = "";
                isiFile += "------INFO APLIKASI------";
                isiFile += "\n";
                isiFile += "Nama App  : " + appModel.getNamaApp();
                isiFile += "\n";
                isiFile += "Package   : " + appModel.getPackageApp();
                isiFile += "\n";
                isiFile += "Key Text  : " + appModel.getKeyEnskripsiText();
                isiFile += "\n";
                isiFile += "Key Asset : " + appModel.getKeyEnskripsiAsset();
                isiFile += "\n";
                isiFile += "Dibuat    : " + dateFormat.format(new Date()) + " - (yyyy/MM/dd HH:mm:ss)";
                isiFile += "\n";
                isiFile += "\n";
                isiFile += "------INFO KEYSTORE------";
                isiFile += "\n";
                isiFile += "Store File Name      : " + "keystore.jks (terletak satu folder dengan file ini)";
                isiFile += "\n";
                isiFile += "Store Password       : " + Constant.storePassword;
                isiFile += "\n";
                isiFile += "Store Alias          : " + Constant.storeAlias;
                isiFile += "\n";
                isiFile += "Store Alias Password : " + Constant.storeAliasPassword;

                File newTextFile = new File(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderInfoApp+"\\"+"info.txt");
                fw = new FileWriter(newTextFile);
                fw.write(isiFile);
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(AksiGaeInfoApp.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(AksiGaeInfoApp.class.getName()).log(Level.SEVERE, null, ex);
                     System.err.println(ex);
                }
            }
        } 
    }  
    
    private void copyKeyStore() {
        File sourceFile = new File(Constant.pathKeyStore);
        File destination = new File(appModel.getFolderSumberSource() + "\\"+ Constant.namaFolderInfoApp + "\\" + "keystore.jks");
        copyFile(sourceFile, destination);
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
            Logger.getLogger(AksiGaeInfoApp.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(AksiGaeInfoApp.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
    }
}
