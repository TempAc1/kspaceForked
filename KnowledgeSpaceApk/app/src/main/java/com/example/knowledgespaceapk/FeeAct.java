package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeeAct extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private adapterFeeActTabLayFragItem adapterTabItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee);

        tabLayout = findViewById(R.id.tabLayFeeAct);
        viewPager2 = findViewById(R.id.vPagger2FeeAct);

        //Make tabItems dynamically
        tabLayout.addTab(tabLayout.newTab().setText("Academic Fees"));
        tabLayout.addTab(tabLayout.newTab().setText("History"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapterTabItem = new adapterFeeActTabLayFragItem(fragmentManager,getLifecycle());
        viewPager2.setAdapter(adapterTabItem);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}