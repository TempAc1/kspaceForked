package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textViewMainAct);
        tv2 = findViewById(R.id.tVMainAct2);
        img1 = findViewById(R.id.imgviewMainact);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideAll();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.containerFragMainAct,new loginNSignupMainFrag()).commit();
            }
        },1500);
    }

    private void hideAll(){
        tv1.setVisibility(View.GONE);
        tv2.setVisibility(View.GONE);
        img1.setVisibility(View.GONE);
    }
}