package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class AnnouncementAct extends AppCompatActivity {

    TextView announcementTvAnnouncementAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        announcementTvAnnouncementAct = findViewById(R.id.announcementTvAnnouncementAct);
        announcementTvAnnouncementAct.setMovementMethod(new ScrollingMovementMethod());


    }
}