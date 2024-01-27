package com.example.knowledgespaceapk.QnAact.CommentSc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.knowledgespaceapk.QnAact.QnAAct;
import com.example.knowledgespaceapk.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class QNAnsCommentAct extends AppCompatActivity {
    private ArrayList<DataModelCommentSc> dataHolder;
    private RecyclerView recyclerVQnNActCommentSc;
    private AdapterCommentSc adapterCommentSc;
    private FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    private EditText editTVAddCommentCommentSc;
    private ImageView postCommentImgVQNAnsCommentSc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qnans_comment);
        recyclerVQnNActCommentSc = findViewById(R.id.recyclerVQnNActCommentSc);
        editTVAddCommentCommentSc = findViewById(R.id.editTVAddCommentCommentSc);
        recyclerVQnNActCommentSc.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        addDataToHolder();
        recyclerVQnNActCommentSc.setAdapter(new AdapterCommentSc(dataHolder));

        postCommentImgVQNAnsCommentSc = findViewById(R.id.postCommentImgVQNAnsCommentSc);
        postCommentImgVQNAnsCommentSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                editTVAddCommentCommentSc.setText("");
            }
        });

        //Todo addBackend and

        editTVAddCommentCommentSc.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    try {
                        Log.i("EditTv Value - ",editTVAddCommentCommentSc.getText().toString().trim());
                        InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                        Toast.makeText(QNAnsCommentAct.this, "No Backend", Toast.LENGTH_SHORT).show();
                        editTVAddCommentCommentSc.setText("");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
//        startActivity(new Intent(getApplicationContext(), QnAAct.class));
        super.onBackPressed();
    }

    private void addDataToHolder() {
        dataHolder = new ArrayList<>();
        DataModelCommentSc card1 = new DataModelCommentSc("Shrikant","Nice Post");
        dataHolder.add(card1);dataHolder.add(card1);dataHolder.add(card1);dataHolder.add(card1);
        dataHolder.add(card1);dataHolder.add(card1);dataHolder.add(card1);dataHolder.add(card1);
        dataHolder.add(card1);dataHolder.add(card1);dataHolder.add(card1);dataHolder.add(card1);
        dataHolder.add(card1);
    }
}