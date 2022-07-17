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
import util.Activity;
import util.Constant;

/**
 *
 * @author DekaStudio
 */
public class AksiMbungkusScreenshot {
    private final AppModel appModel;
    private final LayerModel[] listLayer;
    private final Activity[] daftarActivity = Constant.getDaftarActivity;

    public AksiMbungkusScreenshot(AppModel appModel, int posisi) {
        this.appModel = appModel;
        this.listLayer = Constant.getLayerPembungkusScreenShot(appModel, posisi);
    }
    
    public void eksekusi() {
        for(int i = 0; i<daftarActivity.length; i++){
            try {
                String alamatTujuanIcon = appModel.getFolderSumberSource() + "\\" + Constant.namaFolderScreenshot;
                BufferedImage hasilIcon = new BufferedImage(1190, 2435, BufferedImage.TYPE_INT_ARGB);
                Graphics graphics = hasilIcon.getGraphics();
                LayerModel mentah = new LayerModel(appModel.getFolderSumberSource() + "\\" + Constant.namaFolderScreenshot + "\\" + "ss"+(i+1)+".png", 0, 0, 51, 224);
                BufferedImage bMentah = Thumbnails.of(new File(mentah.getPathLayer()))
                        .forceSize(mentah.getLebar(), mentah.getTinggi())
                        .asBufferedImage();
                graphics.drawImage(bMentah, mentah.getPosisiX(), mentah.getPosisiY(), null);
                for (LayerModel layerModel : listLayer) {
                    try {
                        BufferedImage layer = Thumbnails.of(new File(layerModel.getPathLayer()))
                                .forceSize(layerModel.getLebar(), layerModel.getTinggi())
                                .asBufferedImage();
                        graphics.drawImage(layer, layerModel.getPosisiX(), layerModel.getPosisiY(), null);
                    } catch (IOException ex) {
                        Logger.getLogger(AksiMbungkusScreenshot.class.getName()).log(Level.SEVERE, null, ex);
                        System.err.println(ex);
                    }
                }
                File file = new File(alamatTujuanIcon, "bungkus_ss"+(i+1)+".png");
                if (file.getParentFile().mkdirs()) {
                    try {
                        ImageIO.write(hasilIcon, "PNG", file);
                    } catch (IOException ex) {
                        Logger.getLogger(AksiMbungkusScreenshot.class.getName()).log(Level.SEVERE, null, ex);
                        System.err.println(ex);
                    }
                }else{
                    try {
                        ImageIO.write(hasilIcon, "PNG", file);
                    } catch (IOException ex) {
                        Logger.getLogger(AksiMbungkusScreenshot.class.getName()).log(Level.SEVERE, null, ex);
                        System.err.println(ex);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(AksiMbungkusScreenshot.class.getName()).log(Level.SEVERE, null, ex);
                 System.err.println(ex);
            }  
        }
    }
    
    
    
}
