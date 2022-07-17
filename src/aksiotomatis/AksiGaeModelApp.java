/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksiotomatis;

import enskriptdeskriptor.dataset.DataSet;
import enskriptdeskriptor.enskriptor.Enskripsi;
import isitahugenerator.MainFrame;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import model.AppModel;
import util.Constant;
import model.KontenModel;

/**
 *
 * @author DekaStudio
 */
public class AksiGaeModelApp {
    private final MainFrame mainFrame;
    private final int posisi;
    
    public AksiGaeModelApp(MainFrame mainFrame, int posisi){
        this.mainFrame = mainFrame;
        this.posisi = posisi;
 
    }
    
    public AppModel eksekusi(){
        AppModel appModel = new AppModel();
        appModel.setNamaApp(mainFrame.getListNamaFolder().get(posisi));
        appModel.setPackageApp(Constant.awalanPackage + packageGenerator(mainFrame.getListNamaFolder().get(posisi)));
        appModel.setKeyEnskripsiText(Constant.keyEnskripsiText);
        appModel.setKeyEnskripsiAsset(Constant.keyEnskripsiAsset);
        appModel.setPackageAppTerenskripsi(enskripsiGenerator(Constant.awalanPackage + packageGenerator(mainFrame.getListNamaFolder().get(posisi))));
        appModel.setFolderModuleTujuan(Constant.folderModuleTujuan);
        appModel.setFolderSumberSource(mainFrame.getListPathFolder().get(posisi));
        appModel.setListKontenModel(generateListKontenModel(appModel.getFolderSumberSource()));
        appModel.setFormatEnskripsi(Constant.formatEnskripsi);
        return appModel;
    }
    
    private List<KontenModel> generateListKontenModel(String folderSource){
        File folder = new File(folderSource +"\\"+Constant.namaFolderSumberKonten);
        if(bacaSemuaFolder(folder).isEmpty()){
            List<KontenModel> hasil = new ArrayList<>();
            hasil.add(new KontenModel(null, bacaSemuaFileDalamFolder(folder)));
            return hasil;
        }else{
            List<String> listFolder = bacaSemuaFolder(folder);
            List<KontenModel> hasil = new ArrayList<>();
            
            if(!bacaSemuaFileDalamFolder(folder).isEmpty()){
                hasil.add(new KontenModel(null, bacaSemuaFileDalamFolder(folder)));
            }
            
            for(int i = 0; i<listFolder.size(); i++){
                File file = new File(folderSource +"\\"+Constant.namaFolderSumberKonten+"\\" + listFolder.get(i));
                hasil.add(new KontenModel(listFolder.get(i), bacaSemuaFileDalamFolder(file)));
            }
            return hasil;
        }
    }
    
    public List<String> bacaSemuaFolder(final File folder) {
        List<String> listFolder = new ArrayList<>();
        if(folder.exists()){
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    listFolder.add(fileEntry.getName());
                }
            }
        }else{
            System.out.println("<AksiGaeModelApp> Kesalahan saat bacaSemuaFolder index "  + posisi);
        }   
        return listFolder;
    }
    
    private List<String> bacaSemuaFileDalamFolder(File folder){
        List<String> listFile = new ArrayList<>();
        if(folder.exists()){
            for (final File fileEntry : folder.listFiles()) {
                if (!fileEntry.isDirectory()) {
                    listFile.add(fileEntry.getName());
                }
            }
        }else{
            System.out.println("<AksiGaeModelApp> Kesalahan saat bacaSemuaFileDalamFolder index "  + posisi);
        }   
        return listFile;
    }
    
    private String packageGenerator(String namaApp){
        String retunan = namaApp.replaceAll("\\s+", "").toLowerCase();
        return retunan;
    }
    
    private String enskripsiGenerator(String packAge){
        Enskripsi enskripsi = new Enskripsi();
        enskripsi.setKey(Constant.keyEnskripsiText); 
        enskripsi.setTextUntukDiEnskripsi(packAge);
        String hasilEnskripsi = enskripsi.dapatkanTextEnskripsi();
        return hasilEnskripsi;
    }
    
    
    private String getKeyTextFix(String keyText){
        String pkg = Constant.awalanPackage + packageGenerator(mainFrame.getListNamaFolder().get(posisi));
        String empatHurufPkg = "";
        char[] pkgChar = pkg.toCharArray();
        for(int i = pkgChar.length; i>pkgChar.length-5; i--){
            empatHurufPkg += String.valueOf(pkgChar[i-1]);      
        }
        return keyText+empatHurufPkg;
    }
    
    private String keyTextGenerator(){
        DataSet dataSet = new DataSet();
        char hasil[] = new char[16];
        for(int i=0; i<16; i++){
            int index = ThreadLocalRandom.current().nextInt(0, dataSet.dataSet.length);
            hasil[i] = dataSet.dataSet[index];
        }
        return String.valueOf(hasil);
    }
}
