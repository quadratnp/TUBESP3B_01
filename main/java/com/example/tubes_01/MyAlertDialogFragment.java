package com.example.tubes_01;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class MyAlertDialogFragment extends DialogFragment {
    public MyAlertDialogFragment(){
        // empty
    }

    public static MyAlertDialogFragment newInstance(String title) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }
}
