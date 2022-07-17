/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import model.AppModel;
import model.KontenModel;
import util.Constant;

/**
 *
 * @author DekaStudio
 */
public class AksiEnskripsiKonten {
    private final AppModel appModel;

    public AksiEnskripsiKonten(AppModel appModel) {
        this.appModel = appModel;
    }
    
    public void eksekusi() {
        lakukanEnskripsi();
    } 
    
    private void lakukanEnskripsi() {
        try {
            SecretKey baru =  new SecretKeySpec(Base64.getDecoder().decode(appModel.getKeyEnskripsiAsset()),
                    0, Base64.getDecoder().decode(appModel.getKeyEnskripsiAsset()).length, "AES");
            Cipher AesCipher = Cipher.getInstance("AES");
            
            List<KontenModel> listKontenModel = appModel.getListKontenModel();
            for(int i = 0; i<listKontenModel.size(); i++){
                KontenModel kontenModel = listKontenModel.get(i);
                if(kontenModel.getNamaFolder() == null){
                    for(int j = 0; j<kontenModel.getNamaKonten().size(); j++){
                        
                        byte[] byteText = Files.readAllBytes(Paths.get(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderSumberKonten+"\\"+kontenModel.getNamaKonten().get(j)));
                        AesCipher.init(Cipher.ENCRYPT_MODE, baru);
                        byte[] byteCipherText = AesCipher.doFinal(byteText);
                        
                        File file = new File(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderHasilEnskrip+"\\"+kontenModel.getNamaKonten().get(j));
                        File folders = new File(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderHasilEnskrip);
                        if(!folders.exists()){
                            if (file.getParentFile().mkdirs()) {
                                Files.write(Paths.get(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderHasilEnskrip+"\\"+dapatkanNamaFileTanpaFormat(kontenModel.getNamaKonten().get(j))
                                        +appModel.getFormatEnskripsi()), byteCipherText);
                            } else {
                                throw new IOException("Failed to create directory " + file.getParent());
                            }
                        } else{
                            Files.write(Paths.get(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderHasilEnskrip+"\\"+ dapatkanNamaFileTanpaFormat(kontenModel.getNamaKonten().get(j))
                                    +appModel.getFormatEnskripsi()), byteCipherText);
                        }
                    }
                }else{
                    for(int j = 0; j<kontenModel.getNamaKonten().size(); j++){
                        
                        byte[] byteText = Files.readAllBytes(Paths.get(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderSumberKonten+"\\" + kontenModel.getNamaFolder() +"\\" +kontenModel.getNamaKonten().get(j)));
                        AesCipher.init(Cipher.ENCRYPT_MODE, baru);
                        byte[] byteCipherText = AesCipher.doFinal(byteText);
                        
                        File file = new File(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderHasilEnskrip+"\\" + kontenModel.getNamaFolder() +"\\" +kontenModel.getNamaKonten().get(j));
                        File folders = new File(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderHasilEnskrip+"\\" + kontenModel.getNamaFolder());
                        if(!folders.exists()){
                            if (file.getParentFile().mkdirs()) {
                                Files.write(Paths.get(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderHasilEnskrip+"\\" + kontenModel.getNamaFolder() +"\\" +dapatkanNamaFileTanpaFormat(kontenModel.getNamaKonten().get(j))
                                        +appModel.getFormatEnskripsi()), byteCipherText);
                            } else {
                                System.out.println("Failed to create directory " + file.getParent());
                            }
                        } else{
                            Files.write(Paths.get(appModel.getFolderSumberSource() +"\\"+Constant.namaFolderHasilEnskrip+"\\" + kontenModel.getNamaFolder() +"\\" + dapatkanNamaFileTanpaFormat(kontenModel.getNamaKonten().get(j))
                                    +appModel.getFormatEnskripsi()), byteCipherText);
                        }
                    }
                }    
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IOException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(AksiEnskripsiKonten.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
    }
    
    private String dapatkanNamaFileTanpaFormat(String namaFile){
        return namaFile.substring(0, namaFile.length()-4);
    }
}
