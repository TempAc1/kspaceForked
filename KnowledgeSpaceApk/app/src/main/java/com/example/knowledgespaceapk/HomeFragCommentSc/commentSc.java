package com.example.knowledgespaceapk.HomeFragCommentSc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.HomeFragCommentSc.AdapterCommentScHomeF;
import com.example.knowledgespaceapk.HomeFragCommentSc.DataModelCommentScHomeF;
import com.example.knowledgespaceapk.HomeSc.homeSc;
import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class commentSc extends AppCompatActivity {
ImageView backArrowImgVCommentSc;
private RecyclerView recyclerVCommentScHomeFrag;
private ArrayList<DataModelCommentScHomeF> dataHolder;
private AdapterCommentScHomeF adapter;
private TextView commentEditTVCommentScHomeFrag;
private ImageView commentNowImgVCommentScHomefrag;

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

        recyclerVCommentScHomeFrag = findViewById(R.id.recyclerVCommentScHomeFrag);
        recyclerVCommentScHomeFrag.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dataHolder = new ArrayList<>();
        addData();
        recyclerVCommentScHomeFrag.setAdapter(new AdapterCommentScHomeF(dataHolder));

        commentEditTVCommentScHomeFrag = findViewById(R.id.commentEditTVCommentScHomeFrag);
        commentEditTVCommentScHomeFrag.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                Toast.makeText(getApplicationContext(), "No Backend", Toast.LENGTH_SHORT).show();
                commentEditTVCommentScHomeFrag.setText("");
                return true;
            }
        });

        commentNowImgVCommentScHomefrag = findViewById(R.id.commentNowImgVCommentScHomefrag);
        commentNowImgVCommentScHomefrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                Toast.makeText(getApplicationContext(), "No Backend", Toast.LENGTH_SHORT).show();
                commentEditTVCommentScHomeFrag.setText("");
            }
        });
    }

    private void addData() {
        DataModelCommentScHomeF card1 = new DataModelCommentScHomeF("Shrikanth","hi");
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
    }
}