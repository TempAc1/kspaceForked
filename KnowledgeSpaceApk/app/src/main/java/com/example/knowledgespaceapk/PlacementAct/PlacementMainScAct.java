package com.example.knowledgespaceapk.PlacementAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.knowledgespaceapk.R;
import com.google.android.material.tabs.TabLayout;

public class PlacementMainScAct extends AppCompatActivity {

    TabLayout tabLayPlacementMainAct;
    ViewPager viewPagerPlacementMainSc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placement_main_sc);

//        tabLayPlacementMainAct = findViewById(R.id.tabLayPlacementMainF);
//        viewPagerPlacementMainSc = findViewById(R.id.viewPagerPlacementMainF);
//
//        ViewPagerAdapterPlacement adapter = new ViewPagerAdapterPlacement(getSupportFragmentManager());
//        viewPagerPlacementMainSc.setAdapter(adapter);
//
//        tabLayPlacementMainAct.setupWithViewPager(viewPagerPlacementMainSc);
    }
}