package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SettingFrMangerAct extends AppCompatActivity {
    public SettingFrMangerAct() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_fr_manger);

//        2131231151 --profile
        Intent intent = getIntent();
        String viewTag = intent.getStringExtra("view");
//        Log.i("Id---->  ",view);

        loadFrag(viewTag);

    }

    private void loadFrag(String tag) {
        switch (tag){
            case "profile":
                FragmentManager fmp = getSupportFragmentManager();
                FragmentTransaction ftp = fmp.beginTransaction();
                ftp.add(R.id.frameLSettingAct,new profileFSettingAct());
                ftp.commit();
                break;
            case "signout":
                FragmentManager fms = getSupportFragmentManager();
                FragmentTransaction fts = fms.beginTransaction();
                fts.add(R.id.frameLSettingAct,new SignOutFSettingAct());
                fts.commit();
                break;
            case "tnc":
                FragmentManager fmtnc = getSupportFragmentManager();
                FragmentTransaction fttnc = fmtnc.beginTransaction();
                fttnc.add(R.id.frameLSettingAct,new TNcFSettingAct());
                fttnc.commit();
                break;
        }
    }


}