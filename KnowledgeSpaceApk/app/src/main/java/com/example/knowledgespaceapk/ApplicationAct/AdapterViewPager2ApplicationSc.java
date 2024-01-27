package com.example.knowledgespaceapk.ApplicationAct;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterViewPager2ApplicationSc extends FragmentStateAdapter {
    public AdapterViewPager2ApplicationSc(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return new CreateApplicationF();
        }
        return new ApplicationHistF();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
