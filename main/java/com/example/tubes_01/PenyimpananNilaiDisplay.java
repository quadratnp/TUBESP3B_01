package com.example.tubes_01;

import android.content.Context;
import android.content.SharedPreferences;

public class PenyimpananNilaiDisplay {
    protected SharedPreferences sharedPref;
    protected final static String NAMA_SHARED_PREF = "SP_NILAI_DISPLAY";
    protected final static String KEY_BARANG = "BARANG";
    protected final static String KEY_HARGA = "HARGA";
    protected final static String KEY_KETERANGAN = "KETERANGAN";

    public PenyimpananNilaiDisplay(Context context){
        this.sharedPref = context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }
    public void saveNama(String nama){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_BARANG, nama);
        editor.commit();
    }

    public void deleteNama(){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_BARANG, "");
        editor.commit();
    }
    public String getNama(){
        return sharedPref.getString(KEY_BARANG,"");
    }
}
