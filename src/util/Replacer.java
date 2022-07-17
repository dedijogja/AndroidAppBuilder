/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import enskriptdeskriptor.enskriptor.Enskripsi;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.AppModel;

/**
 *
 * @author DekaStudio
 */
public class Replacer {
    /* List kode yang akan di replace secara otomatis
        #package -> semua string yang mengandung kata ini akan di replace dengan package
        #ens_package -> semua string yang mengandung kata ini akan di replace dengan hasil enskripsi package
        #nama_app -> akan di replace dengan nama aplikasi
        #inter_kode -> akan di replace dengan kode interstitial terenskripsi
        #banner_kode -> akan di replace dengan kode banner terenskripsi
        #list_native_kode -> akan di replace dengan kode native terenskripsi
        #menu_native_kode -> akan di replace dengan kode native menu terenskripsi
        #pembuka_native_kode -> alan di replace dengan kode native pembuka terenskripsi
        #key_des_text -> akan di replace dengan key enskripsi text
        #startApp_kode -> akan di replace dengan kode startApp terenskripsi
        #pesan_eror -> akan di replace dengan pesan eror terenskripsi
    */
    
    
    private final List<MapReplacer> listMapReplacer = new ArrayList<>();
    
    public Replacer(AppModel appModel){      
        listMapReplacer.add(new MapReplacer("#package", appModel.getPackageApp()));
        //listMapReplacer.add(new MapReplacer("#ens_package", appModel.getPackageAppTerenskripsi()));
        listMapReplacer.add(new MapReplacer("#nama_app", appModel.getNamaApp()));
//        listMapReplacer.add(new MapReplacer("#inter_kode", enskripsiText(appModel,Constant.kodeInterstitial)));
//        listMapReplacer.add(new MapReplacer("#banner_kode", enskripsiText(appModel,Constant.kodeBanner)));
//        listMapReplacer.add(new MapReplacer("#list_native_kode", enskripsiText(appModel,Constant.kodeNativeList)));
//        listMapReplacer.add(new MapReplacer("#menu_native_kode", enskripsiText(appModel, Constant.kodeNativeMenu)));
//        listMapReplacer.add(new MapReplacer("#pembuka_native_kode", enskripsiText(appModel, Constant.kodeNativePembuka)));
//        listMapReplacer.add(new MapReplacer("#key_des_text", appModel.getKeyEnskripsiText()));
//        listMapReplacer.add(new MapReplacer("#startApp_kode", enskripsiText(appModel, Constant.kodeStartApp)));
//        listMapReplacer.add(new MapReplacer("#pesan_eror", enskripsiText(appModel, "Fatal error Fatal error Fatal error Fatal error!")));
    }
    
    
    private String enskripsiText(AppModel appModel, String text){
        Enskripsi enskripsi = new Enskripsi();
        enskripsi.setKey(appModel.getKeyEnskripsiText()); 
        enskripsi.setTextUntukDiEnskripsi(text);
        String hasilEnskripsi = enskripsi.dapatkanTextEnskripsi();
        return hasilEnskripsi;
    }
    
    public String replaceTeksDalamFile(String pathFile){
        String teks = bacaFileKeString(pathFile);
        for(int i = 0; i<listMapReplacer.size(); i++){
            teks = teks.replaceAll(listMapReplacer.get(i).getKode(), listMapReplacer.get(i).getIsiKode());
        }
        return teks;
    }
    
    public String replaceTeksDalamString(String teks){
        for(int i = 0; i<listMapReplacer.size(); i++){
            teks = teks.replaceAll(listMapReplacer.get(i).getKode(), listMapReplacer.get(i).getIsiKode());
        }
        return teks;
    }
    
    private String bacaFileKeString(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            try {
                StringBuilder sb = new StringBuilder();
                String line = "";
                try {
                    line = br.readLine();
                } catch (IOException ex) {
                  
                     System.err.println(ex);
                }
                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    try {
                        line = br.readLine();
                    } catch (IOException ex) {
                       
                         System.err.println(ex);
                    }
                }
                return sb.toString();
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                     System.err.println(ex);
                }
            }
        } catch (FileNotFoundException ex) {
             System.err.println(ex);
            
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
              
                System.err.println(ex);
            }
        }
        return "";
    }
    
    class MapReplacer{
        private final String kode;
        private final String isiKode;
        
        public MapReplacer(String kode, String isiKode){
            this.kode = kode;
            this.isiKode = isiKode;
        }

        public String getKode() {
            return kode;
        }

        public String getIsiKode() {
            return isiKode;
        }
    }
    
}
