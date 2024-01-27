package com.example.knowledgespaceapk.Settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.knowledgespaceapk.MainActivity;
import com.example.knowledgespaceapk.databinding.ActivitySettingsBinding;

public class SettingsAct extends AppCompatActivity {

    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        actClicked();
    }//End OnCreate

//    private void actClicked() {
//        binding.profileSettingTvSettingsAct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), SettingHostAct.class);
//                i.putExtra("view",getTag(view));
////                Log.i("Id ====== ",getTag(view));
//                startActivity(i);
//            }
//        });
//        binding.tNcTvSettingsAct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), SettingHostAct.class);
//                i.putExtra("view",getTag(view));
////                Log.i("Id ====== ",getTag(view));
//                startActivity(i);
//            }
//        });
//        binding.signOutTvSettingsAct.setOnClickListener(view -> {startActivity(new Intent(view.getContext(),
//                                            MainActivity.class));});
//    }

    private String getTag(View view){
        String tag = (String) view.getTag();
        return tag;
    };


}//Main