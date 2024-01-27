package com.example.knowledgespaceapk.ScholarshipAct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class ScholarshipMainAct extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataModelScholarMainAct> dataHolder;
    private AdapterScholarshipMainAct adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship_main);

        recyclerView = findViewById(R.id.recyclerVScholarshipAct);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        setData();
        adapter = new AdapterScholarshipMainAct(dataHolder);
        recyclerView.setAdapter(adapter);
    }

    private void setData() {
        dataHolder = new ArrayList<>();
        //Add data
        DataModelScholarMainAct obj1 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj1);
        DataModelScholarMainAct obj2 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj2);
        DataModelScholarMainAct obj3 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj3);
        DataModelScholarMainAct obj4 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj4);
        DataModelScholarMainAct obj5 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj5);
        DataModelScholarMainAct obj6 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj6);
        DataModelScholarMainAct obj7 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj7);
        DataModelScholarMainAct obj8 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj8);
        DataModelScholarMainAct obj9 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj9);
        DataModelScholarMainAct obj10 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj10);
        DataModelScholarMainAct obj11 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj11);
        DataModelScholarMainAct obj12 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj12);
        DataModelScholarMainAct obj13 = new DataModelScholarMainAct("Demo","demo.com",R.drawable.fest);
        dataHolder.add(obj13);
    }
}