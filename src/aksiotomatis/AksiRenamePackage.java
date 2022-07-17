/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AppModel;
import util.Constant;
import util.Replacer;

/**
 *
 * @author DekaStudio
 */
public class AksiRenamePackage { 
    private final AppModel appModel;

    public AksiRenamePackage(AppModel appModel) {
        this.appModel = appModel;
    }
    
    public void eksekusi() {
        hapusFileBuildGradle();
      
        tulisFileBuildGradle(new Replacer(appModel).replaceTeksDalamFile(Constant.pathBuildGRADLE));
        
        hapusFileCePlus();
       
        tulisFileCeplus(new Replacer(appModel).replaceTeksDalamFile(Constant.pathNativeLibCPP));  
       
    }  
    
    private void hapusFileBuildGradle(){
        File doomedFile = new File (appModel.getFolderModuleTujuan(), "build.gradle");
        doomedFile.delete();
    }
    
    private void tulisFileBuildGradle(String isiFile) {
        FileWriter fw = null;
        try {
            File newTextFile = new File(appModel.getFolderModuleTujuan() + "\\build.gradle");
            fw = new FileWriter(newTextFile);
            fw.write(isiFile);
            fw.close();
        } catch (IOException ex) {
           
             System.err.println(ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
               
                 System.err.println(ex);
            }
        }
    }
    
    private void hapusFileCePlus(){
        try{
        File doomedFile = new File (appModel.getFolderModuleTujuan() + "\\src\\main\\cpp", "native-lib.cpp");
        doomedFile.delete();
        }catch(Exception ex){
             
             System.err.println(ex);
        }
    }
    
    private void tulisFileCeplus(String isiFile) {
        FileWriter fw = null;
        try {
            File newTextFile = new File(appModel.getFolderModuleTujuan() + "\\src\\main\\cpp" + "\\native-lib.cpp");
            fw = new FileWriter(newTextFile);
            fw.write(isiFile);
            fw.close();
           
        } catch (IOException ex) {
             System.err.println(ex);
           
            
        } finally {
            try {
                fw.close();
               
            } catch (IOException ex) {
                
                 System.err.println(ex);
            }
        }
    }
    
}
