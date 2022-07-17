/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isitahugenerator;

import aksitombol.AksiBrowse;
import aksitombol.AksiClear;
import aksitombol.AksiHajar;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author DekaStudio
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private final List<String> listPathFolder = new ArrayList<>();
    private final List<String> listNamaFolder = new ArrayList<>();
 
    public List<String> getListPathFolder(){
        return listPathFolder;
    }
    
    public List<String> getListNamaFolder(){
        return listNamaFolder;
    }
    
    public JFileChooser getChooserFolder(){
        return chooserFolder;
    }
     
    public JTextArea getTxtAreaDaftarGarapan(){
        return txtAreaDaftarGarapan;
    }
    
    public JLabel getTxtDaftarGarapan(){
        return txtDaftarGarapan;
    }
   
    public JLabel getTxtKegarap(){
        return txtKegarap;
    }
    
    public boolean getCheckBoxGaeInfoApp(){
        return !checkBoxGaeInfoApp.isSelected();
    }
    
    public boolean getCheckBoxGaeGambarPromosi(){
        return !checkBoxGaeGambarPromosi.isSelected();
    }
    
    public boolean getCheckBoxBungkusScreenshot(){
        return !checkBoxBungkusScreenshot.isSelected();
    }
    
    public boolean getCheckBoxGaeScreenshot(){
        return !checkBoxGaeScreenShot.isSelected();
    }
    
    public boolean getCheckBoxGaeDeskripsi(){
        return !checkBoxGaeDeskripsi.isSelected();
    }
    
    public boolean getCheckBoxBackUpSource(){
        return !checkBoxBackUpSource.isSelected();
    }
    
    public boolean getCheckBoxResikResikDua(){
        return !checkBoxResikResikDua.isSelected();
    }
    
    public boolean getCheckBoxGaeApk(){
        return !checkBoxGaeAPK.isSelected();
    }
    
    public boolean getCheckBoxResikResikSatu(){
        return !checkBoxResikResikSatu.isSelected();
    }
    
    public boolean getCheckBoxReplaceKonten(){
        return !checkBoxReplaceKonten.isSelected();
    }
    
    public boolean getCheckBoxEnskripsiKonten(){
        return !checkBoxEnskripsiKonten.isSelected();
    }
    
    public boolean getCheckBoxReplaceIcon(){
        return !checkBoxReplaceIcon.isSelected();
    }
    
    public boolean getCheckBoxRenamePackage(){
        return !checkBoxRenamePackage.isSelected();
    }
    
    public boolean getCheckBoxRenameJenengApp(){
        return !checkBoxRenameJenengApp.isSelected();
    }
     
    public boolean getCheckBoxGaeIcon(){
        return !checkBoxGaeIcon.isSelected();
    }
    
    public JProgressBar getProgresGaeInfoApp(){
        return progresGaeInfoApp;
    }
    
    public JProgressBar getProgressBungkusScreenshoot(){
        return progressBungkusScreenshot;
    }
    
    public JProgressBar getProGressGaeScreenShot(){
        return progressGaeScreenshot;
    }
    
    public JProgressBar getProgressGaeAppModel(){
        return progresGaeaAppModel;
    }
    
    public JProgressBar getProgressGaeicon(){
        return progresGaeIcon;
    }
    
    public JProgressBar getProgressGaeGambarPromosi(){
        return progresGaeGambarPromosi;
    }
    
    public JProgressBar getProgressRenameJenengApp(){
        return progressJenengApp;
    }
    
    public JProgressBar getProgresRenamePackage(){
        return progressRenamePackage;
    }
    
    public JProgressBar getProgressReplaceIcon(){
        return progressReplaceIcon;
    }
    
    public JProgressBar getProgressEnskripsiKonten(){
        return progressEnskripsiKonten;
    }
    
    public JProgressBar getProgressReplaceKonten(){
        return progressReplaceKonten;
    }
    
    public JProgressBar getProgressResikResikSatu(){
        return progressResikResikSatu;
    }    
     
    public JProgressBar getProgressGaeApk(){
        return progressGaeApk;
    }
    
    public JProgressBar getProgressResikResikDua(){
        return progressResikResikDua;
    }
    
    public JProgressBar getProgressBackUpSource(){
        return progressBackupSource;
    }
    
    public JProgressBar getProgressGaeDeskripsi(){
        return progressGaeDeskripsi;
    }
    
    public JLabel getTxtJudulApp(){
        return txtJudulApp;
    }
    
    public MainFrame() {
        initComponents();
       
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this); //implementasinya
            SwingUtilities.updateComponentTreeUI(chooserFolder);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        setResizable(false);
        setLocationRelativeTo(null);
        urusanUI();
        btnBrowse.addActionListener((ActionEvent e) -> {
            new AksiBrowse(MainFrame.this).eksekusi();
        });
        btnClear.addActionListener((ActionEvent e) -> {
            new AksiClear(MainFrame.this).eksekusi();
        });
        btnHajar.addActionListener((ActionEvent e) -> {
            new AksiHajar(MainFrame.this).eksekusi();
        });
    }
    
    private void urusanUI(){
        txtAreaDaftarGarapan.setEditable(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooserFolder = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDaftarGarapan = new javax.swing.JTextArea();
        btnClear = new javax.swing.JButton();
        btnBrowse = new javax.swing.JButton();
        txtDaftarGarapan = new javax.swing.JLabel();
        txtKegarap = new javax.swing.JLabel();
        txtJudulApp = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        progressGaeScreenshot = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        progressJenengApp = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        progressRenamePackage = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        progressReplaceIcon = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        progressEnskripsiKonten = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        progressReplaceKonten = new javax.swing.JProgressBar();
        jLabel12 = new javax.swing.JLabel();
        progressResikResikSatu = new javax.swing.JProgressBar();
        jLabel13 = new javax.swing.JLabel();
        progressGaeApk = new javax.swing.JProgressBar();
        jLabel14 = new javax.swing.JLabel();
        progressResikResikDua = new javax.swing.JProgressBar();
        jLabel15 = new javax.swing.JLabel();
        progressBackupSource = new javax.swing.JProgressBar();
        jLabel16 = new javax.swing.JLabel();
        progressGaeDeskripsi = new javax.swing.JProgressBar();
        btnHajar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        progresGaeIcon = new javax.swing.JProgressBar();
        checkBoxGaeScreenShot = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        checkBoxGaeIcon = new javax.swing.JCheckBox();
        progresGaeaAppModel = new javax.swing.JProgressBar();
        checkBoxRenameJenengApp = new javax.swing.JCheckBox();
        checkBoxRenamePackage = new javax.swing.JCheckBox();
        checkBoxReplaceIcon = new javax.swing.JCheckBox();
        checkBoxEnskripsiKonten = new javax.swing.JCheckBox();
        checkBoxReplaceKonten = new javax.swing.JCheckBox();
        checkBoxResikResikSatu = new javax.swing.JCheckBox();
        checkBoxGaeAPK = new javax.swing.JCheckBox();
        checkBoxResikResikDua = new javax.swing.JCheckBox();
        checkBoxBackUpSource = new javax.swing.JCheckBox();
        checkBoxGaeDeskripsi = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        progressBungkusScreenshot = new javax.swing.JProgressBar();
        checkBoxBungkusScreenshot = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        progresGaeGambarPromosi = new javax.swing.JProgressBar();
        checkBoxGaeGambarPromosi = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        checkBoxGaeInfoApp = new javax.swing.JCheckBox();
        progresGaeInfoApp = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Isi Tahu Generator");

        txtAreaDaftarGarapan.setColumns(20);
        txtAreaDaftarGarapan.setRows(5);
        jScrollPane1.setViewportView(txtAreaDaftarGarapan);

        btnClear.setText("Clear");

        btnBrowse.setText("Browse");

        txtDaftarGarapan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtDaftarGarapan.setText("List Hajar : ");

        txtKegarap.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtKegarap.setText("Kehajar : 0 APK");

        txtJudulApp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtJudulApp.setText("Bismilah..........................................");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Gae Screenshot");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Rename package");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Rename jeneng app");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Replace icon");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Enskripsi Konten");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Replace Konten");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Resik resik");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Gae APK");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Resik Resik");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Gae Deskripsi");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Backup Source");

        btnHajar.setText("Hajar");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Gae Icon");

        checkBoxGaeScreenShot.setText("Rasah");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Gae Model Aplikasi");

        checkBoxGaeIcon.setText("Rasah");

        checkBoxRenameJenengApp.setText("Rasah");

        checkBoxRenamePackage.setText("Rasah");

        checkBoxReplaceIcon.setText("Rasah");

        checkBoxEnskripsiKonten.setText("Rasah");

        checkBoxReplaceKonten.setText("Rasah");

        checkBoxResikResikSatu.setText("Rasah");

        checkBoxGaeAPK.setText("Rasah");

        checkBoxResikResikDua.setText("Rasah");

        checkBoxBackUpSource.setText("Rasah");

        checkBoxGaeDeskripsi.setText("Rasah");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Bungkus Screenshot");

        checkBoxBungkusScreenshot.setText("Rasah");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Gae Gbr promosi");

        checkBoxGaeGambarPromosi.setText("Rasah");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Gae Info App");

        checkBoxGaeInfoApp.setText("Rasah");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addGap(212, 212, 212)
                        .addComponent(btnBrowse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHajar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtDaftarGarapan, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKegarap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(91, 91, 91))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(checkBoxGaeDeskripsi))
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(progressRenamePackage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressJenengApp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressBackupSource, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressResikResikDua, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressGaeApk, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressResikResikSatu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressReplaceKonten, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressEnskripsiKonten, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressReplaceIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(progressGaeDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(checkBoxBungkusScreenshot)
                                                    .addComponent(checkBoxGaeGambarPromosi)
                                                    .addComponent(checkBoxGaeInfoApp))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(progressBungkusScreenshot, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(progresGaeGambarPromosi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(progresGaeInfoApp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(checkBoxGaeScreenShot)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(progressGaeScreenshot, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(checkBoxGaeIcon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(progresGaeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(progresGaeaAppModel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkBoxRenamePackage)
                                            .addComponent(checkBoxRenameJenengApp)
                                            .addComponent(checkBoxReplaceIcon)
                                            .addComponent(checkBoxEnskripsiKonten)
                                            .addComponent(checkBoxReplaceKonten)
                                            .addComponent(checkBoxResikResikSatu)
                                            .addComponent(checkBoxGaeAPK)
                                            .addComponent(checkBoxResikResikDua)
                                            .addComponent(checkBoxBackUpSource))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(txtJudulApp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDaftarGarapan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKegarap, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtJudulApp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progresGaeaAppModel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(progresGaeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkBoxGaeIcon)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(progressJenengApp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressRenamePackage, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressReplaceIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressEnskripsiKonten, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressReplaceKonten, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressResikResikSatu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressGaeApk, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressResikResikDua, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressBackupSource, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressGaeDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxRenameJenengApp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxRenamePackage))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxReplaceIcon))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkBoxEnskripsiKonten)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxReplaceKonten))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxResikResikSatu))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxGaeAPK))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxResikResikDua))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxBackUpSource))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxGaeDeskripsi))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressGaeScreenshot, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkBoxGaeScreenShot)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(progressBungkusScreenshot, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progresGaeGambarPromosi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxBungkusScreenshot))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxGaeGambarPromosi))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkBoxGaeInfoApp))
                            .addComponent(progresGaeInfoApp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBrowse)
                    .addComponent(btnClear)
                    .addComponent(btnHajar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHajar;
    private javax.swing.JCheckBox checkBoxBackUpSource;
    private javax.swing.JCheckBox checkBoxBungkusScreenshot;
    private javax.swing.JCheckBox checkBoxEnskripsiKonten;
    private javax.swing.JCheckBox checkBoxGaeAPK;
    private javax.swing.JCheckBox checkBoxGaeDeskripsi;
    private javax.swing.JCheckBox checkBoxGaeGambarPromosi;
    private javax.swing.JCheckBox checkBoxGaeIcon;
    private javax.swing.JCheckBox checkBoxGaeInfoApp;
    private javax.swing.JCheckBox checkBoxGaeScreenShot;
    private javax.swing.JCheckBox checkBoxRenameJenengApp;
    private javax.swing.JCheckBox checkBoxRenamePackage;
    private javax.swing.JCheckBox checkBoxReplaceIcon;
    private javax.swing.JCheckBox checkBoxReplaceKonten;
    private javax.swing.JCheckBox checkBoxResikResikDua;
    private javax.swing.JCheckBox checkBoxResikResikSatu;
    private javax.swing.JFileChooser chooserFolder;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progresGaeGambarPromosi;
    private javax.swing.JProgressBar progresGaeIcon;
    private javax.swing.JProgressBar progresGaeInfoApp;
    private javax.swing.JProgressBar progresGaeaAppModel;
    private javax.swing.JProgressBar progressBackupSource;
    private javax.swing.JProgressBar progressBungkusScreenshot;
    private javax.swing.JProgressBar progressEnskripsiKonten;
    private javax.swing.JProgressBar progressGaeApk;
    private javax.swing.JProgressBar progressGaeDeskripsi;
    private javax.swing.JProgressBar progressGaeScreenshot;
    private javax.swing.JProgressBar progressJenengApp;
    private javax.swing.JProgressBar progressRenamePackage;
    private javax.swing.JProgressBar progressReplaceIcon;
    private javax.swing.JProgressBar progressReplaceKonten;
    private javax.swing.JProgressBar progressResikResikDua;
    private javax.swing.JProgressBar progressResikResikSatu;
    private javax.swing.JTextArea txtAreaDaftarGarapan;
    private javax.swing.JLabel txtDaftarGarapan;
    private javax.swing.JLabel txtJudulApp;
    private javax.swing.JLabel txtKegarap;
    // End of variables declaration//GEN-END:variables
}
