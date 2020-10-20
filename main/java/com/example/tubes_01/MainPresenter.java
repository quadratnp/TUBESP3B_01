package com.example.tubes_01;

import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainPresenter {
    protected List<Menu> menus;
    protected IMainActivity ui;
    protected FragmentListener fl;

    public MainPresenter (IMainActivity aktifitas, FragmentListener fl){
        this.ui = aktifitas;
        this.menus = new LinkedList<Menu>();
        this.fl = fl;
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

    public void getList(Menu menu ){

    }

    public void changePage(int i){
        this.fl.changePage(i);
    }
}
