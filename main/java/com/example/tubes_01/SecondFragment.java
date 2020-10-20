package com.example.tubes_01;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class SecondFragment extends Fragment implements IMainActivity  {
    protected ListView lstMenus;
    protected MenuListAdapter mla;
    protected MainPresenter presenter;
    protected ThirdFragment tf;
    protected FragmentListener fl;
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
        this.presenter = new MainPresenter(this,this.fl);
        this.mla = new MenuListAdapter(getActivity(), this.presenter);
        this.lstMenus = view.findViewById(R.id.lst_menus);
        this.lstMenus.setAdapter(this.mla);
        this.presenter.loadData();
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
}