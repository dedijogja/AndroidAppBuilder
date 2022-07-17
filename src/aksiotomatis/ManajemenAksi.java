/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import isitahugenerator.MainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import model.AppModel;

/**
 *
 * @author DekaStudio
 */
public class ManajemenAksi {
    private final MainFrame mainFrame;
    private final int posisi;

    public ManajemenAksi(MainFrame mainFrame, int posisi) {
        this.mainFrame = mainFrame;
        this.posisi = posisi;
        gaeLoading();
    }
    
    public void eksekusi() {
      
        try {
            mainFrame.getTxtKegarap().setText("Kehajar : " + (posisi) + " APK");
            mainFrame.getTxtJudulApp().setText(mainFrame.getListNamaFolder().get(posisi));
            Thread.sleep(500);
            
            //Gae App Model
            setProgressLagiProsess(mainFrame.getProgressGaeAppModel());
            AppModel appModel = new AksiGaeModelApp(mainFrame, posisi).eksekusi();
            Thread.sleep(200);
            setProgressTelahSelesai(mainFrame.getProgressGaeAppModel());
            Thread.sleep(100);
            
            //Gae icon
            if(mainFrame.getCheckBoxGaeIcon()){
                setProgressLagiProsess(mainFrame.getProgressGaeicon());
                new AksiGaeIcon(appModel, posisi).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressGaeicon());
                Thread.sleep(100);
            }      
            
            //Rename jeneng app
            if(mainFrame.getCheckBoxRenameJenengApp()){
                setProgressLagiProsess(mainFrame.getProgressRenameJenengApp());
                new AksiRenameJenengApp(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressRenameJenengApp());
                Thread.sleep(100);
            }
            
            //rename package
            if(mainFrame.getCheckBoxRenamePackage()){
                setProgressLagiProsess(mainFrame.getProgresRenamePackage());
                new AksiRenamePackage(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgresRenamePackage());
                Thread.sleep(100);
            }
            
            //replace icon
            if(mainFrame.getCheckBoxReplaceIcon()){
                setProgressLagiProsess(mainFrame.getProgressReplaceIcon());
                new AksiReplaceIcon(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressReplaceIcon());
                Thread.sleep(100);
            }
            
            
            //enskripsi konten
            if(mainFrame.getCheckBoxEnskripsiKonten()){
                setProgressLagiProsess(mainFrame.getProgressEnskripsiKonten());
                new AksiEnskripsiKonten(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressEnskripsiKonten());
                Thread.sleep(100);
            }
            
            //replace konten
            if(mainFrame.getCheckBoxReplaceKonten()){
                setProgressLagiProsess(mainFrame.getProgressReplaceKonten());
                new AksiReplaceKonten(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressReplaceKonten());
                Thread.sleep(100);
            }
            
            //aksi resik resik satu
            if(mainFrame.getCheckBoxResikResikSatu()){
                setProgressLagiProsess(mainFrame.getProgressResikResikSatu());
                new AksiResikResik(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressResikResikSatu());
                Thread.sleep(100);
            }
            
            //aksi gae apk
            if(mainFrame.getCheckBoxGaeApk()){
                setProgressLagiProsess(mainFrame.getProgressGaeApk());
                new AksiGaeApk(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressGaeApk());
                Thread.sleep(100);
            }
            
            //aksi resik resik dua
            if(mainFrame.getCheckBoxResikResikDua()){
                setProgressLagiProsess(mainFrame.getProgressResikResikDua());
                new AksiResikResik(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressResikResikDua());
                Thread.sleep(100);
            }
            
            //proses backup source
            if(mainFrame.getCheckBoxBackUpSource()){
                setProgressLagiProsess(mainFrame.getProgressBackUpSource());
                new AksiBackUpSource(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressBackUpSource());
                Thread.sleep(100);
            }
            
            //proses gae deskripsi
            if(mainFrame.getCheckBoxGaeDeskripsi()){
                setProgressLagiProsess(mainFrame.getProgressGaeDeskripsi());
                new AksiGaeDeskripsi(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressGaeDeskripsi());
                Thread.sleep(100);
            }
            
            //proses gae screenshot
            if(mainFrame.getCheckBoxGaeScreenshot()){
                setProgressLagiProsess(mainFrame.getProGressGaeScreenShot());
                new AksiGaeScreenShot(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProGressGaeScreenShot());
                Thread.sleep(100);
            }
            
            //proses bungkus screenshot
            if(mainFrame.getCheckBoxBungkusScreenshot()){
                setProgressLagiProsess(mainFrame.getProgressBungkusScreenshoot());
                new AksiMbungkusScreenshot(appModel, posisi).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressBungkusScreenshoot());
                Thread.sleep(100);
            }
            
            //proses gae gambar promosi
            if(mainFrame.getCheckBoxGaeGambarPromosi()){
                setProgressLagiProsess(mainFrame.getProgressGaeGambarPromosi());
                new AksiGaeGambarPromosi(appModel, posisi).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgressGaeGambarPromosi());
                Thread.sleep(100);
            }
            
            //proses gae info app
            if(mainFrame.getCheckBoxGaeInfoApp()){
                setProgressLagiProsess(mainFrame.getProgresGaeInfoApp());
                new AksiGaeInfoApp(appModel).eksekusi();
                Thread.sleep(200);
                setProgressTelahSelesai(mainFrame.getProgresGaeInfoApp());
                Thread.sleep(100);
            }
            
            //set Jumlah kegarap
            mainFrame.getTxtKegarap().setText("Kehajar : " + (posisi+1) + " APK");
        } catch (InterruptedException ex) {
            Logger.getLogger(ManajemenAksi.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
    }
    
    private void gaeLoading(){
        setProgressBarAwal(mainFrame.getProgressGaeAppModel());
        if(mainFrame.getCheckBoxRenameJenengApp()) setProgressBarAwal(mainFrame.getProgressRenameJenengApp());
        if(mainFrame.getCheckBoxRenamePackage()) setProgressBarAwal(mainFrame.getProgresRenamePackage());
        if(mainFrame.getCheckBoxReplaceIcon()) setProgressBarAwal(mainFrame.getProgressReplaceIcon());
        if(mainFrame.getCheckBoxEnskripsiKonten()) setProgressBarAwal(mainFrame.getProgressEnskripsiKonten());
        if(mainFrame.getCheckBoxReplaceKonten()) setProgressBarAwal(mainFrame.getProgressReplaceKonten());
        if(mainFrame.getCheckBoxResikResikSatu()) setProgressBarAwal(mainFrame.getProgressResikResikSatu());
        if(mainFrame.getCheckBoxGaeApk()) setProgressBarAwal(mainFrame.getProgressGaeApk());
        if(mainFrame.getCheckBoxResikResikDua()) setProgressBarAwal(mainFrame.getProgressResikResikDua());
        if(mainFrame.getCheckBoxBackUpSource()) setProgressBarAwal(mainFrame.getProgressBackUpSource());
        if(mainFrame.getCheckBoxGaeDeskripsi()) setProgressBarAwal(mainFrame.getProgressGaeDeskripsi());
        if(mainFrame.getCheckBoxGaeIcon()) setProgressBarAwal(mainFrame.getProgressGaeicon());
        if(mainFrame.getCheckBoxGaeGambarPromosi()) setProgressBarAwal(mainFrame.getProgressGaeGambarPromosi());
        if(mainFrame.getCheckBoxGaeScreenshot()) setProgressBarAwal(mainFrame.getProGressGaeScreenShot());
        if(mainFrame.getCheckBoxBungkusScreenshot()) setProgressBarAwal(mainFrame.getProgressBungkusScreenshoot());
        if(mainFrame.getCheckBoxGaeGambarPromosi()) setProgressBarAwal(mainFrame.getProgressGaeGambarPromosi());
        if(mainFrame.getCheckBoxGaeInfoApp()) setProgressBarAwal(mainFrame.getProgresGaeInfoApp());
    }
    
    private void setProgressTelahSelesai(JProgressBar progressBar){
        progressBar.setString("-RAMPUNG-");
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(false);
    }
    
    private void setProgressLagiProsess(JProgressBar progressBar){
        progressBar.setString("MENGHAJAR...");
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(true);
    }
    
    private void setProgressBarAwal(JProgressBar progressBar){
        progressBar.setString("Antri...");
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(true);
    }
}
