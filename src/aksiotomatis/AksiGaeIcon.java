/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.AppModel;
import model.LayerModel;
import net.coobird.thumbnailator.Thumbnails;
import util.Constant;

/**
 *
 * @author DekaStudio
 */
public class AksiGaeIcon {
    private final AppModel appModel;
    private final String namaFolderIconSumber = Constant.namaFolderIconSumber;
    private final String namaFolderIconTujuan = Constant.namaFolderIconTujuan;
    private final LayerModel[] listLayer;
   
    private final ModelIcon[] daftarModelIcon = {
        new ModelIcon("ic_launcher36.png", 36, 36),
        new ModelIcon("ic_launcher48.png", 48, 48),
        new ModelIcon("ic_launcher72.png", 72, 72),
        new ModelIcon("ic_launcher96.png", 96, 96),
        new ModelIcon("ic_launcher144.png", 144, 144),
        new ModelIcon("ic_launcher192.png", 192, 192),
        new ModelIcon("ic_launcher512.png", 512, 512),
    };
    
    public AksiGaeIcon(AppModel appModel, int posisi) {
        this.appModel = appModel;
        this.listLayer = Constant.getLayerIcon(appModel, posisi);
    }
    
    public void eksekusi() {
        buatTempIcon();
        duplikatIcon();
    }
    
    private void duplikatIcon() {
        String alamatTujuanIcon = appModel.getFolderSumberSource() + "\\" + namaFolderIconTujuan;
        for (ModelIcon modelIcon : daftarModelIcon) {
            try {
                Thumbnails.of(new File(alamatTujuanIcon, "tempIcon.png"))
                        .forceSize(modelIcon.getLebar(), modelIcon.getTinggi())          
                        .toFile(new File(alamatTujuanIcon, modelIcon.getNamaIcon()));
            } catch (IOException ex) {
                Logger.getLogger(AksiGaeIcon.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }
        hapusFileTemp();
    }
    
    private void buatTempIcon() {     
        String alamatTujuanIcon = appModel.getFolderSumberSource() + "\\" + namaFolderIconTujuan;  
        BufferedImage hasilIcon = new BufferedImage(512, 512, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = hasilIcon.getGraphics();
        for (LayerModel layerModel : listLayer) {
            if(layerModel.getPathLayer().equals(appModel.getFolderSumberSource() + "\\" + namaFolderIconSumber + "\\" + "layer0.png")){
                try {
                    layerModel.aturPosisiXYkeTengah(hasilIcon);
                    BufferedImage layer = Thumbnails.of(new File(layerModel.getPathLayer())).forceSize(layerModel.getLebar(), layerModel.getTinggi()).asBufferedImage();
                    graphics.drawImage(layer, layerModel.getPosisiX(), layerModel.getPosisiY(), null);
                } catch (IOException ex) {
                    Logger.getLogger(AksiGaeIcon.class.getName()).log(Level.SEVERE, null, ex);
                     System.err.println(ex);
                }
            }else{
                try {
                    BufferedImage layer = Thumbnails.of(new File(layerModel.getPathLayer())).forceSize(layerModel.getLebar(), layerModel.getTinggi()).asBufferedImage();
                    graphics.drawImage(layer, layerModel.getPosisiX(), layerModel.getPosisiY(), null);
                } catch (IOException ex) {
                    Logger.getLogger(AksiGaeIcon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
        File file = new File(alamatTujuanIcon, "tempIcon.png");    
        if (file.getParentFile().mkdirs()) {
            try {
                ImageIO.write(hasilIcon, "PNG", file);
            } catch (IOException ex) {
                Logger.getLogger(AksiGaeIcon.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }else{
            try {
                ImageIO.write(hasilIcon, "PNG", file);
            } catch (IOException ex) {
                Logger.getLogger(AksiGaeIcon.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }  
    }
    
    private void hapusFileTemp(){
        File doomedFile = new File (appModel.getFolderSumberSource() + "\\" + namaFolderIconTujuan, "tempIcon.png");
        doomedFile.delete();
    } 
    
    class ModelIcon{
        private final int lebar;
        private final int tinggi;
        private final String namaIcon;

        public ModelIcon(String namaIcon, int lebar, int tinggi) {
            this.lebar = lebar;
            this.tinggi = tinggi;
            this.namaIcon = namaIcon;
        }   

        public int getLebar() {
            return lebar;
        }

        public int getTinggi() {
            return tinggi;
        }    

        public String getNamaIcon() {
            return namaIcon;
        }    
    }
}
