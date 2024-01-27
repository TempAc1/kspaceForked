package com.example.adminapp.ScholarshipAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adminapp.R;

import java.util.ArrayList;

public class ScholarshipActAdm extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<dataModelRecVScholarshipActAdm> dataHolder;
    private adapterScholarshipActAdm adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship_act_adm);
        recyclerView = findViewById(R.id.recyclerVScholarshipActAdm);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setData();
        adapter = new adapterScholarshipActAdm(dataHolder);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        dataHolder = new ArrayList<>();
        //Add data
        dataModelRecVScholarshipActAdm obj1 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj1);
        dataModelRecVScholarshipActAdm obj2 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj2);
        dataModelRecVScholarshipActAdm obj3 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj3);
        dataModelRecVScholarshipActAdm obj4 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj4);
        dataModelRecVScholarshipActAdm obj5 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj5);
        dataModelRecVScholarshipActAdm obj6 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj6);
        dataModelRecVScholarshipActAdm obj7 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj7);
        dataModelRecVScholarshipActAdm obj8 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj8);
        dataModelRecVScholarshipActAdm obj9 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj9);
        dataModelRecVScholarshipActAdm obj10 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj10);
        dataModelRecVScholarshipActAdm obj11 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj11);
        dataModelRecVScholarshipActAdm obj12 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj12);
        dataModelRecVScholarshipActAdm obj13 = new dataModelRecVScholarshipActAdm("Demo","demo.com",R.drawable.maths_quize);
        dataHolder.add(obj13);
    }
}