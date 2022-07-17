/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author DekaStudio
 */
public class LayerModel {
    public static final int samaDenganAsli = 0;
    private String pathLayer;
    private int lebar;
    private int tinggi;
    private int posisiX;
    private int posisiY;

    public LayerModel() {
    }

    public LayerModel(String pathLayer, int lebar, int tinggi, int posisiX, int posisiY) {
        try {
            this.pathLayer = pathLayer;
            this.lebar = lebar;
            this.tinggi = tinggi;
            this.posisiX = posisiX;
            this.posisiY = posisiY;
            if(this.lebar == samaDenganAsli) this.lebar = ImageIO.read(new File(pathLayer)).getWidth();
            if(this.tinggi == samaDenganAsli) this.tinggi = ImageIO.read(new File(pathLayer)).getHeight();
        } catch (IOException ex) {
            Logger.getLogger(LayerModel.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println(ex);
        }
    }

    public void aturPosisiXkeTengah(BufferedImage bufferedImage){
        this.posisiX = (bufferedImage.getWidth()/2)-(this.lebar/2);
    }
    
    public void aturPosisiYkeTengah(BufferedImage bufferedImage){
        this.posisiY = (bufferedImage.getHeight()/2)-(this.tinggi/2);
    }
    
    public void aturPosisiXYkeTengah(BufferedImage bufferedImage){
        this.posisiX = (bufferedImage.getWidth()/2)-(this.lebar/2);
        this.posisiY = (bufferedImage.getHeight()/2)-(this.tinggi/2);
    }    
    
    public String getPathLayer() {
        return pathLayer;
    }

    public void setPathLayer(String pathLayer) {
        this.pathLayer = pathLayer;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    } 
}
