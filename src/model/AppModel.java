/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DekaStudio
 */
public class AppModel {
    private String namaApp;
    private String packageApp;
    private String packageAppTerenskripsi;
    private String keyEnskripsiText;
    private String keyEnskripsiAsset;
    private String folderModuleTujuan;
    private String folderSumberSource;
    private List<KontenModel> listKontenModel = new ArrayList<>();
    private String formatEnskripsi; 

    public AppModel() {
    }
    
     public String getFormatEnskripsi() {
        return formatEnskripsi;
    }

    public void setFormatEnskripsi(String formatEnskripsi) {
        this.formatEnskripsi = formatEnskripsi;
    }
    
    public void setFolderModuleTujuan(String folderModuleTujuan) {
        this.folderModuleTujuan = folderModuleTujuan;
    }
    
    public void setNamaApp(String namaApp) {
        this.namaApp = namaApp;
    }

    public void setPackageApp(String packageApp) {
        this.packageApp = packageApp;
    }

    public void setPackageAppTerenskripsi(String packageAppTerenskripsi) {
        this.packageAppTerenskripsi = packageAppTerenskripsi;
    }

    public void setKeyEnskripsiText(String keyEnskripsiText) {
        this.keyEnskripsiText = keyEnskripsiText;
    }

    public void setKeyEnskripsiAsset(String keyEnskripsiAsset) {
        this.keyEnskripsiAsset = keyEnskripsiAsset;
    }
    
    public void setFolderSumberSource(String folderSumberSource) {
        this.folderSumberSource = folderSumberSource;
    }    

    public void setListKontenModel(List<KontenModel> listKontenModel) {
        this.listKontenModel = listKontenModel;
    }
    
    public List<String> getNamaKontenDenganNamaFolder(String namaFolder) {
        List<String> hasil = new ArrayList<>();
        for(int i = 0; i<getListKontenModel().size(); i++){
            if(getListKontenModel().get(i).getNamaFolder() != null ){
                if(getListKontenModel().get(i).getNamaFolder().equals(namaFolder)){
                    for(int j = 0; j<getListKontenModel().get(i).getNamaKonten().size(); j++){
                        hasil.add(getListKontenModel().get(i).getNamaKonten().get(j));
                    }
                }
            }
        }
        return hasil;
    }
    
    public List<KontenModel> getListKontenModel() {
        return listKontenModel;
    }
    
    public String getFolderSumberSource() {
        return folderSumberSource;
    }
    
    public String getFolderModuleTujuan() {
        return folderModuleTujuan;
    }

    public String getNamaApp() {
        return namaApp;
    }

    public String getPackageApp() {
        return packageApp;
    }

    public String getPackageAppTerenskripsi() {
        return packageAppTerenskripsi;
    }

    public String getKeyEnskripsiText() {
        return keyEnskripsiText;
    }

    public String getKeyEnskripsiAsset() {
        return keyEnskripsiAsset;
    }
    
    
}
