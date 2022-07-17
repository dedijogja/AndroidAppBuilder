/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksitombol;

import isitahugenerator.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DekaStudio
 */
public class AksiClear {
    private final MainFrame mainFrame;

    public AksiClear(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void eksekusi(){
        if(!mainFrame.getListPathFolder().isEmpty()){
            mainFrame.getListPathFolder().clear();
            mainFrame.getListNamaFolder().clear();
            mainFrame.getTxtAreaDaftarGarapan().setText("");
            mainFrame.getTxtDaftarGarapan().setText("List Hajar :");
            mainFrame.getTxtKegarap().setText("Kegarap : ");
        }else{
            JOptionPane.showMessageDialog(null, "List sudah berada dalam keadaan kosong!", "Isi Tahu Generator", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
