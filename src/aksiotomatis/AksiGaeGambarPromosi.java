/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
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
public class AksiGaeGambarPromosi {
    private final AppModel appModel;
    private final String namaFolderScreenshot = Constant.namaFolderScreenshot;
    private final LayerModel[] listLayer;

    public AksiGaeGambarPromosi(AppModel appModel, int posisi) {
        this.appModel = appModel;
        this.listLayer = Constant.getLayerGambarPromosi(appModel, posisi); 
    }
    
    public void eksekusi() {
        buatGambarAds();
    }  
    
    private void buatGambarAds() {     
        String alamatTujuanIcon = appModel.getFolderSumberSource() + "\\" + namaFolderScreenshot;  
        BufferedImage hasilIcon = new BufferedImage(1024, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = hasilIcon.createGraphics();
        for (LayerModel layerModel : listLayer) {           
            try {
                BufferedImage layer = Thumbnails.of(new File(layerModel.getPathLayer())).forceSize(layerModel.getLebar(), layerModel.getTinggi()).asBufferedImage();
                graphics.drawImage(layer, layerModel.getPosisiX(), layerModel.getPosisiY(), null);
            } catch (IOException ex) {
                Logger.getLogger(AksiGaeGambarPromosi.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }   
        
//        int jumlahList = 6;
//        if(appModel.getNamaKontenDenganNamaFolder(Constant.listFolderKonten).size() < jumlahList){
//            jumlahList = appModel.getListKontenModel().get(0).getNamaKonten().size();
//        }
//        
//        int yPertama = 157;
//        for(int i = 0; i<jumlahList; i++){
//            graphics.setPaint(new Color(255, 255, 255));
//            graphics.setFont(new Font("Arial", Font.PLAIN, 20));
//            String a = appModel.getNamaKontenDenganNamaFolder(Constant.listFolderKonten).get(i).substring(0, appModel.getNamaKontenDenganNamaFolder(Constant.listFolderKonten).get(i).length()-4);
//            yPertama +=  40;
//            graphics.drawString("-" + a, 390, yPertama);
//        }
//        graphics.setPaint(new Color(255, 255, 255));
//        graphics.setFont(new Font("Arial", Font.BOLD, 30));
//        String judul = appModel.getNamaApp();
//        graphics.drawString("Varian Resep", 362, 120);
//        graphics.drawString(judul, 362, 150);
//
//        graphics.setPaint(new Color(255, 255, 255));
//        graphics.setFont(new Font("Arial", Font.PLAIN, 20));
//        graphics.drawString(" Dan lain lain", 390, yPertama+= 40);  
        
        File file = new File(alamatTujuanIcon, "Ads.png");    
        if (file.getParentFile().mkdirs()) {
            try {
                ImageIO.write(hasilIcon, "PNG", file);
            } catch (IOException ex) {
                Logger.getLogger(AksiGaeGambarPromosi.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }else{
            try {
                ImageIO.write(hasilIcon, "PNG", file);
            } catch (IOException ex) {
                Logger.getLogger(AksiGaeGambarPromosi.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }
        }  
    }
}
