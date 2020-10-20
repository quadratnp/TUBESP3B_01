package com.example.tubes_01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainPresenter {
    protected List<Menu> menus;
    protected IMainActivity ui;

    public MainPresenter (IMainActivity aktifitas){
        this.ui = aktifitas;
        this.menus = new LinkedList<Menu>();
    }

    public void loadData(){
        this.menus.addAll(Arrays.asList(MockMenu.menuObjectArr));
        this.ui.updateList(this.menus);
    }

    public void deleteList(int position){
        this.menus.remove(position);
        this.ui.updateList(this.menus);
    }

    public void addList(String nama, String deskripsi, String tag, String bahan, String langkah, String lokasi ){
        this.menus.add(new Menu(nama,deskripsi,tag,bahan, langkah, lokasi));
        this.ui.updateList(this.menus);
        this.ui.resetAddForm();
    }

    public void editList(int position, String nama, String deskripsi, String tag, String bahan, String langkah, String lokasi ){
        this.menus.set(position,new Menu(nama,deskripsi,tag,bahan, langkah, lokasi) );
        this.ui.updateList(this.menus);
        this.ui.resetAddForm();
    }
}
