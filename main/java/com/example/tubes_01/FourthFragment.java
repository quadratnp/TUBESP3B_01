package com.example.tubes_01;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FourthFragment extends Fragment implements View.OnClickListener {

    protected EditText etnama,etdeskirpsi,ettag,etbahan, etlangkah, etlokasi;
    protected Button btn_add;
    protected LihatMenu lihatmenu;
    protected FragmentListener fl;
    protected SecondFragment f2;

    public FourthFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FourthFragment newInstance() {
        FourthFragment fragment = new FourthFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        etnama = view.findViewById(R.id.editText1);
        etdeskirpsi = view.findViewById(R.id.editText2);
        ettag= view.findViewById(R.id.editText3);
        etbahan = view.findViewById(R.id.editText4);
        etlangkah = view.findViewById(R.id.editText5);
        etlokasi = view.findViewById(R.id.editText6);
        f2 =  SecondFragment.newInstance();
        btn_add = view.findViewById(R.id.btn_tambahkan);
        btn_add.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        create();
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

    protected void create(){
        lihatmenu = new MainPresenter(this.getContext());
        Menu menu = new Menu(
            null,
                etnama.getText().toString(),
                etdeskirpsi.getText().toString(),
                ettag.getText().toString(),
                etbahan.getText().toString(),
                etlangkah.getText().toString(),
                etlokasi.getText().toString()

        );
        if(lihatmenu.create(menu)){
            Toast.makeText(getContext(), "Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            fl.changePage(2);
        }
    }
}