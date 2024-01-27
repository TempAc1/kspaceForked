package com.example.knowledgespaceapk.PlacementAct.DefaultF;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.knowledgespaceapk.PlacementAct.DefaultF.AdapterPlacementDefaultF;
import com.example.knowledgespaceapk.PlacementAct.DefaultF.DataModelPlacementDefaultF;
import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class PlacementDefaultF extends Fragment {


    private ArrayList<DataModelPlacementDefaultF> dataHolder;
    private RecyclerView recyclerView;



    public PlacementDefaultF() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_placement_default, container, false);

        //All Ui need to add here:
        recyclerView = view.findViewById(R.id.recyclerVPlacementDefaultF);



        //Setting Up Recycler View:
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        addObjToHolder();
        recyclerView.setAdapter(new AdapterPlacementDefaultF(dataHolder));


        return view;
    }



    private void addObjToHolder() {
        dataHolder = new ArrayList<>();
        DataModelPlacementDefaultF obj = new DataModelPlacementDefaultF("Jio Platforms",
                "Dear Students Greetings from D. Y. Patil International University, Akurdi! It gives us immense pleasure to invite you for the Campus Recruitment of Pi Techniques Private Limited for 2023 Graduating Batch",
                "https://www.pitechniques.com/");
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
    }
}