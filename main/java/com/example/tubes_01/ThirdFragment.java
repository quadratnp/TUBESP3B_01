package com.example.tubes_01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ThirdFragment extends Fragment {
    protected TextView nama;
    protected TextView deskripsi;
    protected TextView tag;
    protected TextView bahan;
    protected TextView langkah;
    protected TextView lokasi;

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
        Bundle bundle = this.getArguments();
        if (bundle != null){
            String i = bundle.getString("nama", "");
            this.nama.setText(i);
        }

        return view;
    }

    public void changeMenu(Menu menu){
        this.nama.setText(menu.getNama());
        this.bahan.setText(menu.getBahan());
        this.deskripsi.setText(menu.getDeskripsi());
        this.langkah.setText(menu.getLangkah());
        this.tag.setText(menu.getTag());
        this.lokasi.setText(menu.getLokasi());
    }
}