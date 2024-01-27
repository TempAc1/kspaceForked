package com.example.adminapp.NotiFragAdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.R;

public class NotiActMainScAdm extends AppCompatActivity {

    TextView notiHeadingTvNotiActMainScAdm,notiDescriptionTvNotiActMainScAdm;
    Button deleteNotiBtnNotificationMainScAdm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti_act_main_sc_adm);
        notiHeadingTvNotiActMainScAdm = findViewById(R.id.notiHeadingTvNotiActMainScAdm);
        notiDescriptionTvNotiActMainScAdm = findViewById(R.id.notiDescriptionTvNotiActMainScAdm);
        notiDescriptionTvNotiActMainScAdm.setMovementMethod(new ScrollingMovementMethod());

        deleteNotiBtnNotificationMainScAdm = findViewById(R.id.deleteNotiBtnNotificationMainScAdm);
        deleteNotiBtnNotificationMainScAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Deleting without backend", Toast.LENGTH_SHORT).show();
            }
        });
    }
}