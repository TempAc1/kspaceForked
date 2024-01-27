package com.example.knowledgespaceapk.HomeworkAct;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class HomeworkDefaultFrag extends Fragment {

    private RecyclerView recyclerView;
    AdapterHomeworkDefaultF adapter;
    private ArrayList<DataModelHomeworkDefaultF> dataHolder;
    private FloatingActionButton createHwBtn;


    public HomeworkDefaultFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = LayoutInflater.from(getContext()).inflate(R.layout.fragment_homework_default, container, false);
        recyclerView = view.findViewById(R.id.recyclerVHomeworkDefaultFrag);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        for(int i=0;i<20;i++){
            DataModelHomeworkDefaultF obj1 = new DataModelHomeworkDefaultF("Lp-3 Assignment 4");
            dataHolder.add(obj1);
        }
        recyclerView.setAdapter(new AdapterHomeworkDefaultF(dataHolder));
        createHwBtn = view.findViewById(R.id.floatingBtnHomeworkDefaultFrag);
        createHwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentTransaction fragmentTransaction = getActivity()
//                        .getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.frameLayHomeworkMainAct, new CreateHomeworkFrag());
//                fragmentTransaction.commit();
            }
        });
        return view;
    }
}