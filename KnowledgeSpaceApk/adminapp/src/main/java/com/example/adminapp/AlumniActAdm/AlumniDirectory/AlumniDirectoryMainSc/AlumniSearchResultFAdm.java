package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.adminapp.R;

import java.util.ArrayList;


public class AlumniSearchResultFAdm extends Fragment {

    private RecyclerView recyclerVAlumniSearchResultFAdm;
    private ArrayList<DataModelAlumniSearchResultFAdm> dataHolder;


    public AlumniSearchResultFAdm() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_alumni_search_result_f_adm, container, false);
        recyclerVAlumniSearchResultFAdm = view.findViewById(R.id.recyclerVAlumniSearchResultFAdm);
        recyclerVAlumniSearchResultFAdm.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();
        addData();
        recyclerVAlumniSearchResultFAdm.setAdapter(new AdapterAlumniSearchResultFAdm(dataHolder));

        return view;
    }

    private void addData() {
        DataModelAlumniSearchResultFAdm card1 = new DataModelAlumniSearchResultFAdm("Shrikant","2023","56218","Computer",R.drawable.linkedin,R.drawable.ic_baseline_person_24);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
    }
}