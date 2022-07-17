/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksitombol;

import isitahugenerator.MainFrame;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author DekaStudio
 */
public class AksiBrowse {
    private MainFrame mainFrame;
    
    public AksiBrowse(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void eksekusi(){
        mainFrame.getChooserFolder().setMultiSelectionEnabled(true);
        mainFrame.getChooserFolder().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = mainFrame.getChooserFolder().showOpenDialog(mainFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] file = mainFrame.getChooserFolder().getSelectedFiles();
            for (int i =0; i<file.length; i++){
                if(mainFrame.getListPathFolder().isEmpty()){
                    mainFrame.getListPathFolder().add(file[i].getPath());
                    mainFrame.getListNamaFolder().add(file[i].getName());
                }else{
                    boolean cek = true;
                    for(int j=0; j<mainFrame.getListPathFolder().size(); j++){
                        if(mainFrame.getListPathFolder().get(j).equals(file[i].getPath())){
                           cek = false;
                        }
                    }
                    if(cek){
                        mainFrame.getListPathFolder().add(file[i].getPath());
                        mainFrame.getListNamaFolder().add(file[i].getName());
                    }
                }
            }        
            mainFrame.getTxtDaftarGarapan().setText("List Hajar : "+mainFrame.getListPathFolder().size()+" App");
            String textAhir = "";
            for(int i =0; i<mainFrame.getListPathFolder().size(); i++ ){
                textAhir += i+1+".  ";
                textAhir += mainFrame.getListNamaFolder().get(i);
                if(i!=mainFrame.getListPathFolder().size()-1)
                textAhir += "\n";
            }
            mainFrame.getTxtAreaDaftarGarapan().setText(textAhir);
        } else {
            System.out.println("Di cancel oleh user");
        }
    }
}
