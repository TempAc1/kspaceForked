package com.example.adminapp.PlacementActAdm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapterPlacementAdm extends FragmentPagerAdapter {


    public ViewPagerAdapterPlacementAdm(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new PlacementDefaultFAdm();
        }
        return new PlacementResourcesFAdm();
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Placement Offers";
        }
        return "Resources";
    }
}
