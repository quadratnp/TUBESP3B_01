package com.example.tubes_01;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuListAdapter extends BaseAdapter {
    private List<Menu> listMenu;
    private Activity activity;
    private MainPresenter presenter;

    public MenuListAdapter(Activity activity, MainPresenter presenter){
        this.activity = activity;
        this.listMenu = new ArrayList<Menu>();
        this.presenter = presenter;
    }

    public int getCount(){
        return this.listMenu.size();
    }

    public Object getItem(int i){
        return this.listMenu.get(i);
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
        this.listMenu.clear();
        this.listMenu.addAll((menus));
        this.notifyDataSetChanged();

    }

    private class ViewHolder {
        protected TextView nama;
        protected int position;

        public ViewHolder(View view, MainPresenter presenter){
            this.nama = view.findViewById(R.id.tv_nama_menu);
        }

        public void updateView(Menu menu, int position){
            this.position = position;
            this.nama.setText(menu.getNama());
        }
    }
}
