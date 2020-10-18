package com.example.tubes_01;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    protected FragmentManager fragmentManager;
    protected FirstFragment fragment1;
    protected Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        this.fragment1 = FirstFragment.newInstance();
        this.fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.fragment1)
                .addToBackStack(null)
                .commit();

        toolbar.setTitle(R.string.fragmentName);
        this.drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,drawer, toolbar, R.string.openDrawer, R.string.closeDrawer );
        drawer.addDrawerListener(abdt);
        abdt.syncState();
    }

    public void changePage(int page){
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page==1){
            if(this.fragment1.isAdded()){
                ft.show(this.fragment1);
            }else{
                ft.add(R.id.fragment_container, this.fragment1);
            }

        }
        ft.commit();
    }    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }
}