/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AppModel;
import util.Constant;

/**
 *
 * @author DekaStudio
 */
public class AksiGaeDeskripsi {
    
    private final AppModel appModel;
    private final String namaFolderList = Constant.listFolderKonten;

    public AksiGaeDeskripsi(AppModel appModel) {
        this.appModel = appModel;
    }
    
    public void eksekusi(){
        String deskripsi = "";
        deskripsi += buatSortDeskripsi() +"\n\n";
        deskripsi += buatLongDeskripsi();
        tulisDeskripsi(deskripsi);
    }
    
    private void tulisDeskripsi(String deskripsi) {
        FileWriter fw = null;
        try {
            File newTextFile = new File(appModel.getFolderSumberSource() + "\\deskripsi.txt");
            fw = new FileWriter(newTextFile);
            fw.write(deskripsi);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(AksiGaeDeskripsi.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(AksiGaeDeskripsi.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }
    }
    
    private String buatLongDeskripsi(){
        String  longDeskripsi = "";
        longDeskripsi += Constant.tAwalLongDeskripsiAtas[dapatkanRandom(Constant.tAwalLongDeskripsiAtas.length)];
        longDeskripsi += appModel.getNamaApp();
        longDeskripsi += Constant.tAhirLongDeskripsiAtas[dapatkanRandom(Constant.tAhirLongDeskripsiAtas.length)];
        longDeskripsi += Constant.tJudulFitur[dapatkanRandom(Constant.tJudulFitur.length)];
//        for(int j = 0; j<appModel.getNamaKontenDenganNamaFolder(namaFolderList).size(); j++){
//            longDeskripsi += "- " + appModel.getNamaKontenDenganNamaFolder(namaFolderList).get(j).substring(0, appModel.getNamaKontenDenganNamaFolder(namaFolderList).get(j).length()-4) + "\n";
//        }
        longDeskripsi += "- Full animasi, semua tema dalam bentuk animasi yang cantik\n";
        longDeskripsi += "- HD, animasi dalam kualitas terbaik\n";
        longDeskripsi += "- Dapat bergonta-ganti tema dengan mudah\n";
        longDeskripsi += "- Terdapat banyak tema dalam satu aplikasi untuk pilihan anda\n";
        longDeskripsi += "- Terdapat tema premium yang dapat anda unlock secara gratis\n";
        longDeskripsi += "- Gratis dan akan selalu begitu\n";
        longDeskripsi += Constant.tAwalLongDeskripsiBawah[dapatkanRandom(Constant.tAwalLongDeskripsiBawah.length)];
        longDeskripsi += appModel.getNamaApp();
        longDeskripsi += Constant.tAhirLongDeskripsiBawah[dapatkanRandom(Constant.tAhirLongDeskripsiBawah.length)];
        return longDeskripsi;
    }
    
    private String buatSortDeskripsi(){
        String sortDeskripsi = "";
        sortDeskripsi += Constant.tAwalSortDeskripsi[dapatkanRandom(Constant.tAwalSortDeskripsi.length)];
        sortDeskripsi += appModel.getNamaApp();
        sortDeskripsi += Constant.tAhirSortDeskripsi[dapatkanRandom(Constant.tAhirSortDeskripsi.length)];
        return sortDeskripsi;
    }
    
    private int dapatkanRandom(int panjang){
        Random random = new Random();
        return random.nextInt(panjang);
    }
}
