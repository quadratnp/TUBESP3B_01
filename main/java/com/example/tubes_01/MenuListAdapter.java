package com.example.tubes_01;

import android.app.Activity;
import android.content.Context;
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

        protected int position;

        public ViewHolder (View view, MainPresenter presenter){
            this.nama = view.findViewById(R.id.tv_nama_menu);
            this.presenter = presenter;
            this.nama.setOnClickListener(this);


        }


        @Override
        public void onClick(View v){
            if(v.getId() == this.nama.getId()){
//                Menu menu = this.menu;
//                this.presenter.changePage(3);
//                this.presenter.getList(menu);
                Menu menu = listMenus.get(this.nama.getId());
            }
        }

        public void updateView(Menu menu, int position){
            this.position = position;
            this.menu = menu;
            this.nama.setText(menu.getNama());
        }
    }
}