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
public class KontenModel {
    private String namaFolder;
    private List<String> namaKonten = new ArrayList<>();
    
    public KontenModel(String namaFolder, List<String> namaKonten) {
        this.namaFolder = namaFolder;
        this.namaKonten = namaKonten;
    }

    public KontenModel() {
    }
    
    public String getNamaFolder() {
        return namaFolder;
    }

    public void setNamaFolder(String namaFolder) {
        this.namaFolder = namaFolder;
    }

    public List<String> getNamaKonten() {
        return namaKonten;
    }

    public void setNamaKonten(List<String> namaKonten) {
        this.namaKonten = namaKonten;
    }  
}
