package com.example.knowledgespaceapk.PlacementAct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.knowledgespaceapk.PlacementAct.DefaultF.PlacementDefaultF;
import com.example.knowledgespaceapk.PlacementAct.Resources.PlacementResourcesF;

public class ViewPagerAdapterPlacement extends FragmentPagerAdapter {

    public ViewPagerAdapterPlacement(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new PlacementDefaultF();
        }
        return new PlacementResourcesF();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Placement Offers";
        }
        return "Resources";
    }
}
