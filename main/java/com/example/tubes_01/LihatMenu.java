package com.example.tubes_01;

import android.database.Cursor;

public interface LihatMenu {
    public Cursor read();
    public boolean create(Menu menu);
    public boolean update(Menu menu);
    public boolean delete(String id);
}
