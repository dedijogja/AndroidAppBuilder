/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AppModel;

/**
 *
 * @author DekaStudio
 */
public class AksiResikResik {

    private final AppModel appModel;

    public AksiResikResik(AppModel appModel) {
        this.appModel = appModel;
    }
    
    
    public void eksekusi() {
        try {
            String perintahClean = "";
            File file = new File(appModel.getFolderModuleTujuan());
            String rootFolder = file.getParentFile().toString();
            
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
                    "cmd.exe", "/c", perintahClean + "cd \""+rootFolder+"\" && gradlew clean");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(AksiResikResik.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
    }
}
