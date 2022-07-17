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
public class Intent{
    private final String kodeIntent;
    private final String isiIntent;

    public Intent(String kodeIntent, String isiIntent) {
        this.kodeIntent = kodeIntent;
        this.isiIntent = isiIntent;
    }

    public String getKodeIntent() {
        return kodeIntent;
    }

    public String getIsiIntent() {
        return isiIntent;
    }
}
