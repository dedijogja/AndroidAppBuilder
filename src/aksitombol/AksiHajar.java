/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aksitombol;

import aksiotomatis.ManajemenAksi;
import isitahugenerator.MainFrame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author DekaStudio
 */
public class AksiHajar {
    private final MainFrame mainFrame;

    public AksiHajar(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    public void eksekusi(){
        if(!mainFrame.getListPathFolder().isEmpty()){
             new SabarKerja().execute();
        }else{
            JOptionPane.showMessageDialog(null, "Daftar garapan kosong!", "Isi Tahu Generator", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public class SabarKerja extends SwingWorker<Integer, Integer>{
        public SabarKerja() {
           
        }   

        @Override
        protected Integer doInBackground() throws Exception {
            for(int i = 0; i<mainFrame.getListPathFolder().size(); i++){
                new ManajemenAksi(mainFrame, i).eksekusi();
                Thread.sleep(500);
            }
            return 0;
        }           
        
        @Override
        protected void done() {
            JOptionPane.showMessageDialog(null, "Kabeh Wes Rampung", "lapor ndan!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
