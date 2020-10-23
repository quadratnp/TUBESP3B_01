package com.example.tubes_01;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment implements IMainActivity, View.OnClickListener {
    String[] daftar;
    protected Cursor cursor;
    DataHelper dbcenter;
    protected ListView lstMenus;
    protected MenuListAdapter mla;
    protected MainPresenter presenter;
    protected Button btn_add;
    protected ThirdFragment tf;
    protected FragmentListener fl;
    protected List<Menu> menuList;
    protected LihatMenu lm;
    public SecondFragment() {
        //empty
    }

    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        this.presenter = new MainPresenter(this.getContext());
        this.lstMenus = view.findViewById(R.id.lst_menus);
        this.btn_add = view.findViewById(R.id.btn_add);
        this.btn_add.setOnClickListener(this);
        read();
        return view;
    }




    private void read(){
        menuList = new ArrayList<>();

        lm = new MainPresenter(this.getContext());

        Cursor cursor = lm.read();
        if(cursor.moveToFirst()){
            do{
                Menu menu = new Menu(
                        null,
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                menuList.add(menu);
            }
            while(cursor.moveToNext());
        }
        mla = new MenuListAdapter(this.getActivity(), this.presenter, menuList);
        lstMenus.setAdapter(mla);
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
    public void updateList(List<Menu> menus) {
        this.mla.update(menus);
    }

    @Override
    public void resetAddForm() {

    }
    @Override
    public void transferList(Menu menu){

    }


    @Override
    public void onClick(View v) {
        fl.changePage(4);
    }
}