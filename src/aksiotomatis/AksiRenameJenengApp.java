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
public class AksiRenameJenengApp {

    private final AppModel appModel;
    
    public AksiRenameJenengApp(AppModel appModel) {
        this.appModel = appModel;
    }
    
    public void eksekusi()  {
        hapusFileStringXML();   
        tulisFileStringXML(new Replacer(appModel).replaceTeksDalamFile(Constant.pathStringXML));
    }
    
    
    private void hapusFileStringXML(){
        File doomedFile = new File (appModel.getFolderModuleTujuan() + "\\src\\main\\res\\values", "strings.xml");
        doomedFile.delete();
    }
    
    private void tulisFileStringXML(String isiFile) {
        FileWriter fw = null;
        try {
            File newTextFile = new File(appModel.getFolderModuleTujuan() + "\\src\\main\\res\\values"+"\\strings.xml");
            fw = new FileWriter(newTextFile);
            fw.write(isiFile);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(AksiRenameJenengApp.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(AksiRenameJenengApp.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }
    }
}
