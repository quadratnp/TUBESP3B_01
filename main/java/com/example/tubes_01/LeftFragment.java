package com.example.tubes_01;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class LeftFragment extends Fragment implements View.OnClickListener {
    protected Button btn_home;
    protected Button btn_cari;
    protected Button btn_menu;
    protected Button btn_settings;
    protected Button btn_exit;
    protected FragmentListener fl;

    public LeftFragment(){
        //empty
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        this.btn_home = view.findViewById(R.id.btn_home);
        this.btn_cari = view.findViewById(R.id.btn_cari);
        this.btn_menu = view.findViewById(R.id.btn_menu);
        this.btn_settings = view.findViewById(R.id.btn_settings);
        this.btn_exit = view.findViewById(R.id.btn_exit);
        this.btn_home.setOnClickListener(this);
        this.btn_cari.setOnClickListener(this);
        this.btn_menu.setOnClickListener(this);
        this.btn_settings.setOnClickListener(this);
        this.btn_exit.setOnClickListener(this);
        return view.getRootView();
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


    @Override
    public void onClick(View v) {
        if(v.getId() == this.btn_home.getId()){
            this.fl.changePage(1);
        }
        else if(v.getId() == this.btn_cari .getId()){
            this.fl.changePage(2);
        }
        else if(v.getId() == this.btn_menu .getId()){
            this.fl.changePage(3);
        }
        else if(v.getId() == this.btn_settings .getId()){
            this.fl.changePage(4);
        }
        else if(v.getId() == this.btn_exit.getId()){
            this.fl.closeApplication();
        }
    }
}