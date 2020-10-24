package com.example.tubes_01;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class UbahFragment extends Fragment implements View.OnClickListener {
    protected LihatMenu lm;
    protected EditText text1, text2, text3, text4, text5, text6;
    protected Integer id;
    protected Button btn_ubah;
    protected Menu menu;
    protected FragmentListener fl;
    protected PenyimpananNilaiDisplay pencatat;

    public UbahFragment(){
        //empty;
    }

    public static UbahFragment newInstance(){
        UbahFragment fragment = new UbahFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view =  inflater.inflate(R.layout.fragment_ubah, container, false);
        this.text1 = view.findViewById(R.id.edit_Text1);
        this.text2 = view.findViewById(R.id.edit_Text2);
        this.text3 = view.findViewById(R.id.edit_Text3);
        this.text4 = view.findViewById(R.id.edit_Text4);
        this.text5 = view.findViewById(R.id.edit_Text5);
        this.text6 = view.findViewById(R.id.edit_Text6);
        this.pencatat = new PenyimpananNilaiDisplay(getContext());

        this.btn_ubah = view.findViewById(R.id.btn_edit);
        lm = new MainPresenter(this.getContext());
        read();
        this.pencatat.deleteNama();
        return view;
    }

    private void read() {

        Cursor cursor = lm.readData(this.pencatat.getNama());
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            this.id = Integer.valueOf(cursor.getString(0));
            this.text1.setText(cursor.getString(1).toString());
            this.text2.setText(cursor.getString(2).toString());
            this.text3.setText(cursor.getString(3).toString());
            this.text4.setText(cursor.getString(4).toString());
            this.text5.setText(cursor.getString(5).toString());
            this.text6.setText(cursor.getString(6).toString());

            this.btn_ubah.setOnClickListener(this);
        }


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

       this.lm.update(id,this.text1.getText().toString(),
               this.text2.getText().toString(),
               this.text3.getText().toString(),
               this.text4.getText().toString(),
               this.text5.getText().toString(),
               this.text6.getText().toString());
        //Log.d("test", "onClick: "+this.text2.getText());
        this.fl.changePage(2);
    }
}
