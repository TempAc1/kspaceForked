package com.example.adminapp.SettingsAct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.adminapp.MainActivity;
import com.example.adminapp.R;
import com.example.adminapp.databinding.ActivitySettingBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class settingAct extends AppCompatActivity {

    private ActivitySettingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        actClicked();
    }

    private void actClicked() {
        binding.profileSettingTvSettingsAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),settingFrManagerAct.class);
                i.putExtra("view",getTag(view));
//                Log.i("Id ====== ",getTag(view));
                startActivity(i);
            }
        });
        binding.tNcTvSettingsAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),settingFrManagerAct.class);
                i.putExtra("view",getTag(view));
//                Log.i("Id ====== ",getTag(view));
                startActivity(i);
            }
        });
        binding.signOutTvSettingsAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),settingFrManagerAct.class);
                i.putExtra("view",getTag(view));
//                Log.i("Id ====== ",getTag(view));
                startActivity(i);
            }
        });

    }

    private String getTag(View view){
        String tag = (String) view.getTag();
        return tag;
    }
}