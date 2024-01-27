package com.example.knowledgespaceapk.NotificationAct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.knowledgespaceapk.R;

public class NotiActMainSc extends AppCompatActivity {

    TextView notiHeadingTvNotiActMainSc,notiDescriptionTvNotiActMainSc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti_act_main_sc);
        notiHeadingTvNotiActMainSc = findViewById(R.id.notiHeadingTvNotiActMainSc);
        notiDescriptionTvNotiActMainSc = findViewById(R.id.notiDescriptionTvNotiActMainSc);
        notiDescriptionTvNotiActMainSc.setMovementMethod(new ScrollingMovementMethod());
    }
}