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
import util.Activity;
import util.Constant;
import util.Intent;

/**
 *
 * @author DekaStudio
 */
public class AksiGaeScreenShot {
    private final AppModel appModel;
    private final String lokasiADB = Constant.lokasiADB;
    private final Activity[] daftarActivity = Constant.getDaftarActivity;
    
    public AksiGaeScreenShot(AppModel appModel) {
        this.appModel = appModel;
    }
    
    private String pindah = "";
    public void eksekusi() {
        String namaAPk = bacaSemuaFileDalamFolder(new File(appModel.getFolderSumberSource() + "\\" + Constant.namaFolderAPKjadi));
        String pathApk = appModel.getFolderSumberSource() + "\\" + Constant.namaFolderAPKjadi + "\\" + namaAPk;
        
        if(lokasiADB.startsWith("c:") || lokasiADB.startsWith("C:")){
            pindah = "c: && " + "cd "+ "\""+ lokasiADB + "\"" + " && ";
        }else if(lokasiADB.startsWith("d:") || lokasiADB.startsWith("D:")){
            pindah = "d: && " + "cd "+ "\""+ lokasiADB + "\"" + " && ";
        }else if(lokasiADB.startsWith("e:") || lokasiADB.startsWith("E:")){
            pindah = "e: && " + "cd "+ "\""+ lokasiADB + "\"" + " && ";
        }else if(lokasiADB.startsWith("f:") || lokasiADB.startsWith("F:")){
            pindah = "f: && " + "cd "+ "\""+ lokasiADB + "\"" + " && ";
        }else if(lokasiADB.startsWith("g:") || lokasiADB.startsWith("G:")){
            pindah = "g: && " + "cd "+ "\""+ lokasiADB + "\"" + " && ";
        }else if(lokasiADB.startsWith("h:") || lokasiADB.startsWith("H:")){
            pindah = "h: && " + "cd "+ "\""+ lokasiADB + "\"" + " && ";
        }else if(lokasiADB.startsWith("i:") || lokasiADB.startsWith("I:")){
            pindah = "i: && " + "cd "+ "\""+ lokasiADB + "\"" + " && ";
        }  
        
        instalApk(pathApk);  
        ambilScreenShot();
        hapusApk(appModel.getPackageApp());
    }
    
     private String bacaSemuaFileDalamFolder(File folder){
        String listFile = "";
        if(folder.exists()){
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isFile()) {
                    listFile = fileEntry.getName() ;
                }
            }
        }else{
            System.out.println("<Aksi Gae ScreenShot> Kesalahan saat bacaSemuaFileDalamFolder path "  + folder.getPath());
        }   
        return listFile;
    }
    
    private void ambilScreenShot() {
        for(int i = 0; i< daftarActivity.length; i++){
            jalankanActivity(daftarActivity[i]);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AksiGaeScreenShot.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
            String pathHasilScreenshot = appModel.getFolderSumberSource() + "\\" + Constant.namaFolderScreenshot;
            if(!new File(pathHasilScreenshot).exists()){
                new File(pathHasilScreenshot).mkdir();
            }  
            String comandSS = "adb shell /system/bin/screencap -p /sdcard/screenshot.png";
            eksekusiComand(comandSS);
            String namaHasilScreenShot = "\\ss" + (i+1) + ".png";
            String comandSaveKeKompi = "adb pull /sdcard/screenshot.png " + "\"" + pathHasilScreenshot + namaHasilScreenShot + "\"";
            eksekusiComand(comandSaveKeKompi);
            String tutupApp = "adb shell am force-stop " + appModel.getPackageApp();
            eksekusiComand(tutupApp);
        }   
    }
    
    private void jalankanActivity(Activity activity) {
        String comandRunActivity;
        if(activity.getSingleIntent() == null && activity.getMultipleIntent() == null){
            comandRunActivity = "adb shell am start -n"
                    + " "
                    + appModel.getPackageApp()
                    + "/"
                    + activity.getNamaActivity();
        }else if(activity.getMultipleIntent() == null && activity.getSingleIntent() != null){
            comandRunActivity = "adb shell am start -n"
                    + " "
                    + appModel.getPackageApp() 
                    + "/" 
                    + activity.getNamaActivity()
                    + " "
                    + "--es"
                    + " "
                    + "\"" 
                    + activity.getSingleIntent().getKodeIntent()
                    +"\""
                    + " "
                    + "\""
                    + activity.getSingleIntent().getIsiIntent()
                    + "\"";
        }else{
             comandRunActivity = "adb shell am start -n"
                    + " "
                    + appModel.getPackageApp() 
                    + "/" 
                    + activity.getNamaActivity();    
             for(Intent hasil : activity.getMultipleIntent()){
                 comandRunActivity +=  " "
                    + "--es"
                    + " "
                    + "\"" 
                    + hasil.getKodeIntent()
                    + "\""
                    + " "
                    + "\""
                    + hasil.getIsiIntent()
                    + "\" ";
             }
        }
        eksekusiComand(comandRunActivity);
    }
    
    private void instalApk(String pathApk) {
        String comandInstal = "adb install " +"\"" + pathApk + "\"";
        eksekusiComand(comandInstal);
        eksekusiComand("adb root");
    }
    
    private void hapusApk(String packageName) {
        String comandUinstal = "adb uninstall " + packageName;
        eksekusiComand(comandUinstal);
    }
    
    private void eksekusiComand(String comand) {       
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", pindah + comand);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { 
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(AksiGaeScreenShot.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
    }
 
}
