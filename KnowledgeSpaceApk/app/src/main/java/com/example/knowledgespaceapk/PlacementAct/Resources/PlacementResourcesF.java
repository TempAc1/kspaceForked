package com.example.knowledgespaceapk.PlacementAct.Resources;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.knowledgespaceapk.PlacementAct.Resources.AdapterPlacementResourcesF;
import com.example.knowledgespaceapk.PlacementAct.Resources.DataModelPlacementResourcesF;
import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class PlacementResourcesF extends Fragment {

    private ArrayList<DataModelPlacementResourcesF> dataHolder;
    private AdapterPlacementResourcesF adapter;
    private RecyclerView recyclerVPlacementResourcesF;
    private FloatingActionButton floationBtnAddResourcesPlacementResourcesF;


    public PlacementResourcesF() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_placement_resources, container, false);
        recyclerVPlacementResourcesF = view.findViewById(R.id.recyclerVPlacementResourcesF);
        floationBtnAddResourcesPlacementResourcesF = view.findViewById(R.id.floatingBtnAddResourcesPlacementResourcesF);

        recyclerVPlacementResourcesF.setLayoutManager(new LinearLayoutManager(getContext()));
        addObjToHolder();
        recyclerVPlacementResourcesF.setAdapter(new AdapterPlacementResourcesF(dataHolder));

        //FloatingBtn:
        floationBtnAddResourcesPlacementResourcesF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  openDialog();
            }
        });
        return view;
    }

    private void addObjToHolder() {
        dataHolder = new ArrayList<>();
        DataModelPlacementResourcesF obj = new
                DataModelPlacementResourcesF("Demo",
                "demo");
        dataHolder.add(obj);

    }
}