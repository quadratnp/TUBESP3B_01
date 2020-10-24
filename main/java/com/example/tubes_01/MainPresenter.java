package com.example.tubes_01;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainPresenter extends SQLiteOpenHelper implements LihatMenu {


    public MainPresenter (Context context){
        super(context, "menu.db", null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table menu(id INTEGER PRIMARY KEY AUTOINCREMENT, nama text , deskripsi text , tag text , bahan text , langkah text , lokasi text );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tbl_resepmakan");
    }

    @Override
    public Cursor read() {
        SQLiteDatabase sql = getWritableDatabase();
        return sql.rawQuery("select * from menu", null);
    }

    @Override
    public boolean create(Menu menu) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("insert into menu values(null, '"+menu.getNama()+"','"+menu.getDeskripsi()+"','"+menu.getTag()+"','"+menu.getBahan()+"','"+menu.getLangkah()+"','"+menu.getLokasi()+"')");
        return true;
    }

    @Override
    public boolean update(Integer id, String nama, String deskripsi, String tag,String bahan, String langkah, String lokasi) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("update menu set nama='"+nama+"', deskripsi='"+deskripsi+"', tag='"+tag+"', bahan='"+bahan+"', langkah='"+langkah+"', lokasi='"+lokasi+"' where id = '"+id+"'");
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("delete from menu where id = '"+id+"'");
        return true;
    }

    public Cursor readData(String nama){
        SQLiteDatabase sql = getWritableDatabase();
        return sql.rawQuery("select * from menu where nama ='"+nama+"'", null);
    }
}
