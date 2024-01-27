package com.example.adminapp.MyPosts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import com.example.adminapp.databinding.ActivityMyPostActAdmBinding;

import java.util.ArrayList;

public class MyPostActAdm extends AppCompatActivity {
    private ActivityMyPostActAdmBinding binding;
    private adapterMyPostsAdm adapter;
    private ArrayList<dataModelRecVMyPostsAdm> dataHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyPostActAdmBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.recyclerVMyPostActAdm.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getData();
        adapter = new adapterMyPostsAdm(dataHolder);
        binding.recyclerVMyPostActAdm.setAdapter(adapter);

    }

    private void getData() {
        dataHolder = new ArrayList<>();
        //Add data
        dataModelRecVMyPostsAdm obj1 = new dataModelRecVMyPostsAdm("Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp");dataHolder.add(obj1);
        dataModelRecVMyPostsAdm obj2 = new dataModelRecVMyPostsAdm("Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp");dataHolder.add(obj2);
        dataModelRecVMyPostsAdm obj3 = new dataModelRecVMyPostsAdm("Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp");dataHolder.add(obj3);
        dataModelRecVMyPostsAdm obj4 = new dataModelRecVMyPostsAdm("Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp joaijspdjpwajdpw pjpwadmpmwpwmpo pjsapdjpwmpwajwm pojdpampwmp");dataHolder.add(obj4);
        dataModelRecVMyPostsAdm obj5 = new dataModelRecVMyPostsAdm("Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp");dataHolder.add(obj5);
        dataModelRecVMyPostsAdm obj6 = new dataModelRecVMyPostsAdm("Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp");dataHolder.add(obj6);
        dataHolder.add(obj5);dataHolder.add(obj5);dataHolder.add(obj5);dataHolder.add(obj5);dataHolder.add(obj5);



    }
}