package com.example.knowledgespaceapk.ApplicationAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.knowledgespaceapk.R;
import com.google.android.material.tabs.TabLayout;

public class ApplicationActMainSc extends AppCompatActivity {

    TabLayout tabLayApplicationActMainSc;
    ViewPager2 viewPager2ApplicationActMainSc;
    AdapterViewPager2ApplicationSc adapterViewPager2ApplicationSc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_act_main_sc);

        tabLayApplicationActMainSc = findViewById(R.id.tabLayApplicationActMainSc);
        viewPager2ApplicationActMainSc = findViewById(R.id.viewPager2ApplicationActMainSc);

        tabLayApplicationActMainSc.addTab(tabLayApplicationActMainSc.newTab().setText("Application"));
        tabLayApplicationActMainSc.addTab(tabLayApplicationActMainSc.newTab().setText("Application History"));

        FragmentManager fm = getSupportFragmentManager();
        adapterViewPager2ApplicationSc = new AdapterViewPager2ApplicationSc(fm,getLifecycle());
        viewPager2ApplicationActMainSc.setAdapter(adapterViewPager2ApplicationSc);

        tabLayApplicationActMainSc.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2ApplicationActMainSc.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2ApplicationActMainSc.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayApplicationActMainSc.selectTab(tabLayApplicationActMainSc.getTabAt(position));
            }
        });

    }
}