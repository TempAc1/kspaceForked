package com.example.knowledgespaceapk.FeesAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.knowledgespaceapk.R;
import com.google.android.material.tabs.TabLayout;

public class FeesActMainSc extends AppCompatActivity {

    TabLayout tabLayFeesActMainSc;
    ViewPager2 viewPager2FeesActMainSc;
    ViewPager2AdapterFeesAct viewPager2AdapterFeesAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_act_main_sc);

        tabLayFeesActMainSc = findViewById(R.id.tabLayFeesActMainSc);
        viewPager2FeesActMainSc = findViewById(R.id.viewPager2FeesActMainSc);

        tabLayFeesActMainSc.addTab(tabLayFeesActMainSc.newTab().setText("Fees Overview"));
        tabLayFeesActMainSc.addTab(tabLayFeesActMainSc.newTab().setText("Fees History"));

        FragmentManager fm = getSupportFragmentManager();
        viewPager2AdapterFeesAct = new ViewPager2AdapterFeesAct(fm,getLifecycle());
        viewPager2FeesActMainSc.setAdapter(viewPager2AdapterFeesAct);

        tabLayFeesActMainSc.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2FeesActMainSc.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2FeesActMainSc.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayFeesActMainSc.selectTab(tabLayFeesActMainSc.getTabAt(position));
            }
        });
    }
}