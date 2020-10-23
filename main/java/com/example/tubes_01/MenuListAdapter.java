package com.example.tubes_01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

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


    private class ViewHolder implements View.OnClickListener {
        protected TextView nama;
        protected Menu menu;
        protected MainPresenter presenter;
        protected FragmentListener fl;
        private SecondFragment f2;
        protected int position;

        public ViewHolder (View view, MainPresenter presenter){
            this.nama = view.findViewById(R.id.tv_nama_menu);
            this.presenter = presenter;
            this.nama.setOnClickListener(this);
            this.f2 = SecondFragment.newInstance();

        }


        @Override
        public void onClick(View v){
            if(v.getId() == this.nama.getId()){
//                Menu menu = this.menu;
//                this.presenter.changePage(3);
//                this.presenter.getList(menu);
                final Menu menu = listMenus.get(0);

                String[] pilihan = {"Ubah","Hapus"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this.f2.getContext());
                builder.setTitle("Pilihan");
                builder.setItems(pilihan, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
//                                Intent intent = new Intent(f2.getContext(), f3.getClass());
//                                intent.putExtra("nama", menu.getNama());
//                                intent.putExtra("deskripsi", menu.getDeskripsi());
//                                intent.putExtra("tag", menu.getTag());
//                                intent.putExtra("bahan", menu.getBahan());
//                                intent.putExtra("langkah", menu.getLangkah());
//                                intent.putExtra("lokasi", menu.getLokasi());
//                                context.startActivity(intent);

                                Bundle bundle = new Bundle();
                                bundle.putString("nama",menu.getNama());
                                f3.setArguments(bundle);

                                break;

                            case 1:

                                break;
                        }
                    }
                });
                    builder.show();
            }
        }

        public void updateView(Menu menu, int position){
            this.position = position;
            this.menu = menu;
            this.nama.setText(menu.getNama());
        }
    }
}
