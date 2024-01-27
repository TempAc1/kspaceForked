package com.example.adminapp.UsersCommentScAdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adminapp.R;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UsersCommentScAdm extends AppCompatActivity {
private RecyclerView recyclerView;
private adapterUsersCommentScAdm adapter;
private ArrayList<dataModelUsersCommentScAdm> dataHolder;
FirebaseAuth auth =  FirebaseAuth.getInstance();
private String uId,uEmail,currentDate,currentTime,uName,uDp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_comment_sc_adm);
        uId = auth.getUid();uEmail = auth.getCurrentUser().getEmail();uName = auth.getCurrentUser().getDisplayName();
        uDp = auth.getCurrentUser().getProviderId();
        currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        recyclerView = findViewById(R.id.recyclerVUsersCommentScAdm);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setDataHolder();
        adapter = new adapterUsersCommentScAdm(this,dataHolder,uId,uId);
        recyclerView.setAdapter(adapter);

    }

    private void setDataHolder() {
        dataHolder =  new ArrayList<>();
        dataModelUsersCommentScAdm obj1 = new dataModelUsersCommentScAdm(uId,"Hello",currentTime
                ,uDp,uEmail,uId,uName);
        int i=1;
        while(i<15){
            dataHolder.add(obj1);
            i++;
        }
    }
}