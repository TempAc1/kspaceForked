package com.example.adminapp.PlacementActAdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.adminapp.R;
import com.google.android.material.tabs.TabLayout;

public class PlacementMainActAdm extends AppCompatActivity {

    TabLayout tabLayPlacementMainActAdm;
    ViewPager viewPagerPlacementMainScAdm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_main_act_adm);

//        Fragment fr = new PlacementDefaultFAdm();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.frameLayPlacementMainActAdm,fr).commit();
//        ft.addToBackStack(null);

        tabLayPlacementMainActAdm = findViewById(R.id.tabLayPlacementMainActAdm);
        viewPagerPlacementMainScAdm = findViewById(R.id.viewPagerPlacementMainScAdm);

        ViewPagerAdapterPlacementAdm adapter = new ViewPagerAdapterPlacementAdm(getSupportFragmentManager());
        viewPagerPlacementMainScAdm.setAdapter(adapter);

        tabLayPlacementMainActAdm.setupWithViewPager(viewPagerPlacementMainScAdm);
    }
}