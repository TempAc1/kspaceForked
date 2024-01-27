package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AttendanceAct extends AppCompatActivity {

    private RecyclerView recyclerViewAttendanceAct;
    private ArrayList<dataModelRecVAttendanceAct> dataHolderAttendanceAct;
    private adapterRecVAttendanceAct itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        recyclerViewAttendanceAct = findViewById(R.id.recyclerVAttendance);
        recyclerViewAttendanceAct.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        dataHolderAttendanceAct = new ArrayList<>();

        //add data to arrayList
        dataModelRecVAttendanceAct obj1 = new dataModelRecVAttendanceAct("A.I","COMPBEB0866",90);
        dataHolderAttendanceAct.add(obj1);
        dataModelRecVAttendanceAct obj2 = new dataModelRecVAttendanceAct("DBMS","COMPBEB0866",75);
        dataHolderAttendanceAct.add(obj2);
        dataModelRecVAttendanceAct obj3 = new dataModelRecVAttendanceAct("Web","COMPBEB0866",89);
        dataHolderAttendanceAct.add(obj3);
        dataModelRecVAttendanceAct obj4 = new dataModelRecVAttendanceAct("A.I","COMPBEB0866",90);
        dataHolderAttendanceAct.add(obj4);
        dataModelRecVAttendanceAct obj5 = new dataModelRecVAttendanceAct("DBMS","COMPBEB0866",75);
        dataHolderAttendanceAct.add(obj5);
        dataModelRecVAttendanceAct obj6 = new dataModelRecVAttendanceAct("Web","COMPBEB0866",89);
        dataHolderAttendanceAct.add(obj6);
        dataModelRecVAttendanceAct obj7 = new dataModelRecVAttendanceAct("A.I","COMPBEB0866",90);
        dataHolderAttendanceAct.add(obj7);
        dataModelRecVAttendanceAct obj8 = new dataModelRecVAttendanceAct("DBMS","COMPBEB0866",75);
        dataHolderAttendanceAct.add(obj8);
        dataModelRecVAttendanceAct obj9 = new dataModelRecVAttendanceAct("Web","COMPBEB0866",89);
        dataHolderAttendanceAct.add(obj9);
        dataModelRecVAttendanceAct obj10 = new dataModelRecVAttendanceAct("A.I","COMPBEB0866",90);
        dataHolderAttendanceAct.add(obj10);
        dataModelRecVAttendanceAct obj11 = new dataModelRecVAttendanceAct("DBMS","COMPBEB0866",75);
        dataHolderAttendanceAct.add(obj11);
        dataModelRecVAttendanceAct obj12 = new dataModelRecVAttendanceAct("Web","COMPBEB0866",89);
        dataHolderAttendanceAct.add(obj12);
        dataModelRecVAttendanceAct obj13 = new dataModelRecVAttendanceAct("A.I","COMPBEB0866",90);
        dataHolderAttendanceAct.add(obj13);
        dataModelRecVAttendanceAct obj14 = new dataModelRecVAttendanceAct("DBMS","COMPBEB0866",75);
        dataHolderAttendanceAct.add(obj14);
        dataModelRecVAttendanceAct obj15 = new dataModelRecVAttendanceAct("Web","COMPBEB0866",89);
        dataHolderAttendanceAct.add(obj15);

        itemAdapter = new adapterRecVAttendanceAct(dataHolderAttendanceAct);
        recyclerViewAttendanceAct.setAdapter(itemAdapter);
    }
}