package com.example.adminapp.SettingsAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.adminapp.R;

public class settingFrManagerAct extends AppCompatActivity {

    public settingFrManagerAct() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_fr_manager);
        Intent intent = getIntent();
        String viewTag = intent.getStringExtra("view");
        loadFrag(viewTag);
    }

    private void loadFrag(String viewTag) {
        switch (viewTag){
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
                fttnc.add(R.id.frameLSettingAct,new TnCFSettingAct());
                fttnc.commit();
                break;
        }
    }
}