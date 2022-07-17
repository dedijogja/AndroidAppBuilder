/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Arrays;
import java.util.Collections;
import model.AppModel;
import model.LayerModel;

/**
 *
 * @author DekaStudio
 */
public class Constant {
    
    //daftar activity untuk screenshot
    public static final Activity[] getDaftarActivity = {
        new util.Activity("com.ganbateo.livetheme.activity.LoadingActivity"),
        new util.Activity("com.ganbateo.livetheme.activity.MenuActivity"),
        new util.Activity("com.ganbateo.livetheme.activity.PilihWallpaperActivity"),
        new util.Activity("com.ganbateo.livetheme.activity.PreviewWallpaper", new Intent("kodetematerpilih", "0")),
        new util.Activity("com.ganbateo.livetheme.activity.PreviewWallpaper", new Intent("kodetematerpilih", "1")),
        new util.Activity("com.ganbateo.livetheme.activity.PreviewWallpaper", new Intent("kodetematerpilih", "2")),
        new util.Activity("com.ganbateo.livetheme.activity.PreviewWallpaper", new Intent("kodetematerpilih", "3")),
    };
    
    //random layer icon
    public static LayerModel[] getLayerIcon (AppModel appModel, int posisi) {
        final LayerModel[][] kumpulanLayer = {
            new LayerModel[]{
                new LayerModel(appModel.getFolderSumberSource() + "\\" + namaFolderIconSumber + "\\" + "ic.jpg", 438, 442, 39, 34),
                new LayerModel("G:\\kerja\\Live Wallpaper Project\\Workspace\\important\\asset\\icon.png", 0, 0, 0, 0),
            },
           
        };
        
        Integer[] arr = new Integer[kumpulanLayer.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = i;
        }    
        Collections.rotate(Arrays.asList(arr), posisi);
        return kumpulanLayer[arr[0]];
    }
    
    //random layer pembungkus screenshot
    public static LayerModel[] getLayerPembungkusScreenShot(AppModel appModel, int posisi) {
        final LayerModel[][] kumpulanLayer = {
            new LayerModel[]{
                new LayerModel("C:\\Users\\DekaStudio\\Desktop\\Resep Workspace\\important\\pendukung\\sc_hp.png", 0, 0, 0, 0),
            }
        };
        Integer[] arr = new Integer[kumpulanLayer.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = i;
        }    
        Collections.rotate(Arrays.asList(arr), posisi);
        return kumpulanLayer[arr[0]];
    }
    
    //random layer gambar promosi 1024x500
    public static LayerModel[] getLayerGambarPromosi(AppModel appModel, int posisi) {
        final LayerModel[][] kumpulanLayer = {
            new LayerModel[]{
                new LayerModel("G:\\kerja\\Live Wallpaper Project\\Workspace\\important\\asset\\layer promote.png", 0, 0, 0, 0),
                new LayerModel(appModel.getFolderSumberSource() + "\\" + namaFolderIconTujuan + "\\" + "ic_launcher512.png", 324, 324, 350, 88),
            }
        };
        Integer[] arr = new Integer[kumpulanLayer.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = i;
        }    
        Collections.rotate(Arrays.asList(arr), posisi);
        return kumpulanLayer[arr[0]];
    }
    
    
    
    //core aplikasi
    public static final String keyEnskripsiText = "voEdPR9eNJR!.=2w";
    public static final String keyEnskripsiAsset = "wE4LKAcj9b/2xbq6Wmhp2w==";
    public static final String awalanPackage = "com.ganbateo.";
    public static final String lokasiADB = "D:\\android-sdks\\platform-tools"; 
    public static final String folderModuleTujuan = "G:\\kerja\\Live Wallpaper Project\\Workspace\\important\\source\\WallpaperProject\\app";
    public static final String formatEnskripsi = ".anm";
    public static final String listFolderKonten = "animasi";
    public static final String namaDev = "Ganbateo";
    public static final String pathStringXML = "G:\\kerja\\Live Wallpaper Project\\Workspace\\important\\sistem\\strings.xml";
    public static final String pathBuildGRADLE = "G:\\kerja\\Live Wallpaper Project\\Workspace\\important\\sistem\\build.gradle";
    public static final String pathNativeLibCPP = "G:\\kerja\\Live Wallpaper Project\\Workspace\\important\\sistem\\native-lib.cpp";
    
    //Area keystore
    public static final String pathKeyStore = "G:\\kerja\\Live Wallpaper Project\\Workspace\\important\\sistem\\keystore.jks";
    public static final String storePassword = "4231#$^uz3dhj}";
    public static final String storeAlias = "Ganbateo";
    public static final String storeAliasPassword = "4231#$^uz3dhj}";
        
    public static final String[] tAwalSortDeskripsi= {
        "Daftar ",
        "Berbagai macam ",
        "Koleksi ",
        "Kumpulan ",
        "Keren "
    };
    
    public static final String[] tAhirSortDeskripsi = {
        " Yang sangat keren untuk anda",
        " tercanggih bergerak",
        " lengkap dari " + namaDev +"",
        " dengan fitur live bergerak",
        " yang sangat interaktif"
    };
   
    
    public static final String[] tAwalLongDeskripsiAtas = {
        "Kami menyediakan berbagai macam tema keren dengan judul ",
        "Aplikasi dengan judul ",
        "Tema android terkeren hanya di ",
        "Kami telah merelease sebuah aplikasi keren dengan nama "
    };
    
    public static final String[] tAhirLongDeskripsiAtas = {
        " Yang berisi koleksi tema terkeren yang pernah ada \n\n",
        ". Jadi tak perlu kawatir tampilan ponsel anda usang karena dengan aplikasi ini akan selalu terlihat baru dan canggih \n\n",
        " yang sangat cocok untuk anda jadikan sebagai aplikasi favorit anda \n\n"
    };
    
    public static final String[] tJudulFitur = {
        "Beberapa fitur dalam aplikasi ini : \n",
        "Kumpulan fitur dalam aplikasi : \n",
        "Fitur : \n",
        "Yang akan anda dapat : \n"
    };
    
    public static final String[] tAwalLongDeskripsiBawah = {
        "\nTunggu apalagi ayo download aplikasi ",
        "\nJangan banyak berfikir lagi silakan download aplikasi ",
        "\nUnduh gratis aplikasi ",
        "\nDapatkan secara gratis aplikasi "
    };
    
    public static final String[] tAhirLongDeskripsiBawah = {
        " sekarang juga dan warnai harimu dengan Tema keren",
        " dan dapatkan koleksi tema terbaik dari kami",
        " untuk keluarga anda dan Salam dari " + namaDev,
        " dan kreasikan kreatifitas tanpa batas anda dalam mengcustomize android anda"
    };
    
    
    //area jarang diubah
    public static final String namaFolderAPKjadi = "apk jadi";
    public static final String namaFolderHasilEnskrip = "enskrip";
    public static final String namaFolderSumberKonten = "konten";
    public static final String namaFolderScreenshot = "screenshot";
    public static final String namaFolderIconSumber = "icon";
    public static final String namaFolderIconTujuan = "images";
    public static final String namaFolderInfoApp = "info";
    
}
