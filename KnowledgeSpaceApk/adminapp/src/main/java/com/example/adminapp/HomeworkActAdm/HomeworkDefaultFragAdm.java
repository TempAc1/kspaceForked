package com.example.adminapp.HomeworkActAdm;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class HomeworkDefaultFragAdm extends Fragment {

    private RecyclerView recyclerView;
    adapterRecVHomeworkActAdm adapter;
    private ArrayList<dataModelRecVHomeworkActAdm> dataHolder;
    private FloatingActionButton createHwBtn;

    public HomeworkDefaultFragAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = LayoutInflater.from(getContext()).inflate(R.layout.fragment_homework_default_frag_adm, container, false);
        recyclerView = view.findViewById(R.id.recyclerVHomeworkDefaultFragAdm);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        for(int i=0;i<20;i++){
            dataModelRecVHomeworkActAdm obj1 = new dataModelRecVHomeworkActAdm("Lp-3 Assignment 4");
            dataHolder.add(obj1);
        }
        recyclerView.setAdapter(new adapterRecVHomeworkActAdm(dataHolder));
        createHwBtn = view.findViewById(R.id.floatingBtnHomeworkDefaultFragAdm);
        createHwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.parentFrameLayoutHomeworkAdm, new CreateHomeworkFragAdm());
                fragmentTransaction.commit();
            }
        });
        return view;
    }


}