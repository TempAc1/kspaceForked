package com.example.adminapp.FeesActAdm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adminapp.R;

import java.util.ArrayList;


public class FeesResultFragFeesActAdm extends Fragment {

    private ArrayList<DataModelRecVFeesResultFAdm> dataHolder;
    private AdapterFeesResultFAdm adapter;
    private RecyclerView recyclerVFeesResultFAdm;

    public FeesResultFragFeesActAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fees_result_frag_fees_act_adm, container, false);
        recyclerVFeesResultFAdm = view.findViewById(R.id.recyclerVFeesResultFAdm);
        recyclerVFeesResultFAdm.setLayoutManager(new LinearLayoutManager(getContext()));
        addDataToHolder();
        recyclerVFeesResultFAdm.setAdapter(new AdapterFeesResultFAdm(dataHolder));


        return view;
    }

    private void addDataToHolder() {
        dataHolder = new ArrayList<>();
        DataModelRecVFeesResultFAdm obj = new DataModelRecVFeesResultFAdm(452680,"Shrikant",
                56000);
        dataHolder.add(obj);
    }
}