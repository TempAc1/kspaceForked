package com.example.knowledgespaceapk;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class adapterFeeActTabLayFragItem extends FragmentStateAdapter {

    public adapterFeeActTabLayFragItem(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1){
            return new FeeHistoryFrag();
        }else{
            return new AcademicFeesFrag();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
