package com.example.tubes_01;

public class Menu {
    public String nama;
    public String deskripsi;
    public String tag;
    public String bahan;
    public String langkah;
    public String lokasi;

    public Menu(String nama,String deskripsi, String tag, String bahan, String langkah, String lokasi){
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.tag = tag;
        this.bahan = bahan;
        this.langkah = langkah;
        this.lokasi = lokasi;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLangkah() {
        return langkah;
    }

    public void setLangkah(String langkah) {
        this.langkah = langkah;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
