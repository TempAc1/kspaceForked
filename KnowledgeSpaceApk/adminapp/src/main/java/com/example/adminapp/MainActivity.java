package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.adminapp.AttendanceAct.AttendanceAct;
import com.example.adminapp.SettingsAct.settingAct;
import com.example.adminapp.contactAct.ContactAct;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.DoubleBounce;

public class MainActivity extends AppCompatActivity {
    ImageView imgviewMainactAdm;
    TextView tVMainAct2Adm,textViewMainActAdm;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgviewMainactAdm = findViewById(R.id.imgviewMainactAdm);
        tVMainAct2Adm = findViewById(R.id.tVMainAct2Adm);
        textViewMainActAdm = findViewById(R.id.textViewMainActAdm);
        progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        showLoadingSpinner();
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               hideAll();
               getSupportFragmentManager().beginTransaction()
                       .add(R.id.containerFragMainActAdm,new LoginScAdmFrag()).commitAllowingStateLoss();
//               progressBar.setVisibility(View.GONE);
           }
       },2000);
    }

    private void hideAll() {
        imgviewMainactAdm.setVisibility(View.GONE);
        textViewMainActAdm.setVisibility(View.GONE);
        tVMainAct2Adm.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    private void showLoadingSpinner() {
        Sprite cubeGrid = new CubeGrid();
        progressBar.setIndeterminateDrawable(cubeGrid);
        progressBar.setVisibility(View.VISIBLE);
    }
}