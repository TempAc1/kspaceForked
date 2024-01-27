package com.example.adminapp.GroupFragAdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.adminapp.R;

public class FragmentHolderActGrpAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder_act_grp_adm);
        //default fragment hold
        replaceFrag(new GroupOverviewFragGrpAdm());
    }

    public  void replaceFrag(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm,fragment);
        fragmentTransaction.commit();
    }
}