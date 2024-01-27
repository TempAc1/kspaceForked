package com.example.adminapp.GroupFragAdm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adminapp.R;

import java.util.ArrayList;

public class SpecificChapterDetailsFAdm extends Fragment {

    private RecyclerView recyclerView;
    private  adapterRecVSpecificChapDetailsGrpFAdm adapter;
    private ArrayList<dataModelRecVSpecificChapDetailsFAdm> dataHolder;

    public SpecificChapterDetailsFAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_specific_chapter_details_f_adm, container, false);

        //ADD YOUR CODE HERE
        recyclerView = view.findViewById(R.id.recyclerVSpecificChapDetailsFAdm);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder =  new ArrayList<>();
        addData();
        recyclerView.setAdapter(new adapterRecVSpecificChapDetailsGrpFAdm(dataHolder));

        return view;
    }

    private void addData() {
        dataModelRecVSpecificChapDetailsFAdm obj1 = new dataModelRecVSpecificChapDetailsFAdm("Blockchain 7201856",
                "Module first","Chapter Decentenralize",
                "Not available");
        dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);
    }
}