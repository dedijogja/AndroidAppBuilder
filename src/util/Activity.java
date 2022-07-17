/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author DekaStudio
 */
public class Activity{
    private final String namaActivity;
    private Intent singleIntent = null;
    private Intent[] multipleIntent = null;

    public Activity(String namaActivity, Intent[] multipleIntent) {
        this.namaActivity = namaActivity;
        this.multipleIntent = multipleIntent;
    } 

    public Activity(String namaActivity) {
        this.namaActivity = namaActivity;
    }


    public Activity(String namaActivity, Intent singleIntent) {
        this.namaActivity = namaActivity;
        this.singleIntent = singleIntent;
    }

    public Intent[] getMultipleIntent() {
        return multipleIntent;
    }

    public String getNamaActivity() {
        return namaActivity;
    }

    public Intent getSingleIntent() {
        return singleIntent;
    }         
}
