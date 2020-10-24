package com.example.tubes_01;

import android.database.Cursor;

public interface LihatMenu {
    public Cursor read();
    public boolean create(Menu menu);
    public boolean update(Integer id, String nama, String deskripsi, String tag,String bahan, String langkah, String lokasi);
    public boolean delete(Integer id);
    public Cursor readData(String nama);
}
