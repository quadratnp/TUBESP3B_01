package com.example.tubes_01;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ThirdFragment extends Fragment {
    protected TextView nama;
    protected TextView deskripsi;
    protected TextView tag;
    protected TextView bahan;
    protected TextView langkah;
    protected TextView lokasi;
    protected FragmentListener fl;
    protected LihatMenu lm;
    protected Menu menu;
    protected PenyimpananNilaiDisplay pencatat;

    public ThirdFragment() {
        // Required empty public constructor
    }



    public static ThirdFragment newInstance() {
        ThirdFragment fragment = new ThirdFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_third, container, false);
        this.nama = view.findViewById(R.id.tv_nama);
        this.deskripsi = view.findViewById(R.id.tv_deskripsi);
        this.tag = view.findViewById(R.id.tv_tag);
        this.bahan = view.findViewById(R.id.tv_bahan);
        this.langkah = view.findViewById(R.id.tv_langkah);
        this.lokasi = view.findViewById(R.id.tv_lokasi);
        this.pencatat = new PenyimpananNilaiDisplay(this.getContext());

        read();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fl = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString()
                    + "must implement FragmentListener");
        }
    }

    public void gantiPage(int i){
        this.fl.changePage(i);
    }

    private void read(){
        lm = new MainPresenter(this.getContext());
        Cursor cursor = lm.readData(this.pencatat.getNama());

        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            this.nama.setText(cursor.getString(1).toString());
            this.deskripsi.setText(cursor.getString(2).toString());
            this.tag.setText(cursor.getString(3).toString());
            this.bahan.setText(cursor.getString(4).toString());
            this.langkah.setText(cursor.getString(5).toString());
            this.lokasi.setText(cursor.getString(6).toString());
        }
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }



}