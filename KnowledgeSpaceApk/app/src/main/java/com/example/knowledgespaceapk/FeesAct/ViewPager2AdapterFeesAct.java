package com.example.knowledgespaceapk.FeesAct;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2AdapterFeesAct extends FragmentStateAdapter {


    public ViewPager2AdapterFeesAct(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new PayFeesFFeesAct();
        }
        return new FeesHistFFeesAct();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
