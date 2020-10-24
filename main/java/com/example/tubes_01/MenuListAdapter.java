package com.example.tubes_01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class MenuListAdapter extends BaseAdapter {
    private List<Menu> listMenus;
    private Activity activity;
    private MainPresenter presenter;
    protected FragmentListener fl;
    private SecondFragment f2;
    private ThirdFragment f3;


    public MenuListAdapter(Activity activity, MainPresenter presenter, List<Menu> menuList ){
        this.activity=activity;
        this.presenter = presenter;
        this.listMenus = menuList;
    }

    public void add(Menu newItem){
        this.listMenus.add(newItem);
        this.notifyDataSetChanged();
    }

    public int getCount(){
        return listMenus.size();
    }

    public Object getItem(int i){
        return listMenus.get(i);
    }

    public long getItemId(int i){
        return 0;
    }

    public View getView(int i, View convertView, ViewGroup parent){
        ViewHolder viewHolder ;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.activity).inflate(R.layout.menu_list_string, parent, false);
            viewHolder = new ViewHolder(convertView,this.presenter);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.updateView((Menu)this.getItem(i),i);


        return convertView;
    }

    public void update(List<Menu> menus) {
        this.listMenus.clear();
        this.listMenus.addAll((menus));
        this.notifyDataSetChanged();

    }



    private class ViewHolder  {
        protected TextView nama;
        protected Menu menu;
        protected MainPresenter presenter;
        protected FragmentListener fl;
        private SecondFragment f2;
        protected ThirdFragment f3;
        protected int position;
        protected FragmentManager fragmentManager;
        protected SharedPreferences sharedPref;
        protected final static String NAMA_SHARED_PREF = "SP_NILAI_DISPLAY";
        protected final static String KEY_BARANG = "BARANG";
        protected final static String KEY_HARGA = "HARGA";
        protected final static String KEY_KETERANGAN = "KETERANGAN";

        public ViewHolder (View view, MainPresenter presenter){
            this.nama = view.findViewById(R.id.tv_nama_menu);
            this.presenter = presenter;
//            this.nama.setOnClickListener(this);
            fl = new MainActivity();
        }



//        @Override
//        public void onClick(View v){
//            if(v.getId() == this.nama.getId()) {
//                Log.d("test", this.nama.getId()+"");
//
//            }
//        }

        public void updateView(Menu menu, int position){
            this.position = position;
            this.menu = menu;
            this.nama.setText(menu.getNama());
        }


    }
}
