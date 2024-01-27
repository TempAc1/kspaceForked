package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.knowledgespaceapk.homesc.homeSc;

public class commentSc extends AppCompatActivity {
ImageView backArrowImgVCommentSc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_sc);

        backArrowImgVCommentSc = findViewById(R.id.backArrorImgVCommentSc);
        backArrowImgVCommentSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), homeSc.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_left_to_right,R.anim.slide_right_to_left);
            }
        });
    }
}