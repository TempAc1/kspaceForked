package com.example.adminapp.PlacementActAdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.adminapp.R
import com.google.android.material.tabs.TabLayout

class PlacementMainActAdm : AppCompatActivity() {
    var tabLayPlacementMainActAdm: TabLayout? = null
    var viewPagerPlacementMainScAdm: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placement_main_act_adm)

//        Fragment fr = new PlacementDefaultFAdm();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.frameLayPlacementMainActAdm,fr).commit();
//        ft.addToBackStack(null);
        tabLayPlacementMainActAdm = findViewById(R.id.tabLayPlacementMainActAdm)
        viewPagerPlacementMainScAdm = findViewById(R.id.viewPagerPlacementMainScAdm)
        val adapter = ViewPagerAdapterPlacementAdm(supportFragmentManager)
        viewPagerPlacementMainScAdm?.setAdapter(adapter)
        tabLayPlacementMainActAdm?.setupWithViewPager(viewPagerPlacementMainScAdm)
    }
}