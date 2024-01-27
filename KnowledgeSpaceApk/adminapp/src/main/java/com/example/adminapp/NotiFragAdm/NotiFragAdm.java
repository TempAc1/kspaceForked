package com.example.adminapp.NotiFragAdm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adminapp.R;

import java.util.ArrayList;


public class NotiFragAdm extends Fragment {


    private RecyclerView recyclerVFragNotiSc;
    adapterRecVNotiFragAdm adapter;
    private ArrayList<dataModelRecVFragNotiAdm> dataHolderNotiFrag;

    public NotiFragAdm() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.fragment_noti_frag_adm, container, false);
        recyclerVFragNotiSc = view.findViewById(R.id.recyclerVNotiFragAdm);
        recyclerVFragNotiSc.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolderNotiFrag = new ArrayList<>();

        for(int i=0;i<50;i++){
            dataModelRecVFragNotiAdm obj1 = new dataModelRecVFragNotiAdm("You have a pending assignment Lab-"+(i)
                    +"Please Submit it before tomorrow 2 p.m at school teacher office to Sir.Y.K Pandey");
            dataHolderNotiFrag.add(obj1);
        }

        recyclerVFragNotiSc.setAdapter(new adapterRecVNotiFragAdm(dataHolderNotiFrag));

        return  view;
    }
}