package com.example.knowledgespaceapk.PlacementAct;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.knowledgespaceapk.R;
import com.google.android.material.tabs.TabLayout;


public class PlacementMainScF extends Fragment {

    private TabLayout tabLayPlacementMainF;
    private ViewPager viewPagerPlacementMainF;



    public PlacementMainScF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_placement_main_sc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayPlacementMainF = view.findViewById(R.id.tabLayPlacementMainF);
        viewPagerPlacementMainF = view.findViewById(R.id.viewPagerPlacementMainF);

        ViewPagerAdapterPlacement adapter = new ViewPagerAdapterPlacement(getChildFragmentManager());
        viewPagerPlacementMainF.setAdapter(adapter);

        tabLayPlacementMainF.setupWithViewPager(viewPagerPlacementMainF);

    }
}