package com.example.knowledgespaceapk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {


    private RecyclerView recyclerVFragNotiSc;
    adapterRecVNotificationFrag adapter;
    private ArrayList<dataModelRecVFragNotification> dataHolderNotiFrag;

    public NotificationFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.fragment_notification, container, false);
        recyclerVFragNotiSc = view.findViewById(R.id.recyclerVNotiFrag);
        recyclerVFragNotiSc.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolderNotiFrag = new ArrayList<>();

        for(int i=0;i<50;i++){
            dataModelRecVFragNotification obj1 = new dataModelRecVFragNotification("You have a pending assignment Lab-"+(i)
                                                    +"Please Submit it before tomorrow 2 p.m at school teacher office to Sir.Y.K Pandey");
            dataHolderNotiFrag.add(obj1);
        }

        recyclerVFragNotiSc.setAdapter(new adapterRecVNotificationFrag(dataHolderNotiFrag));

        return  view;
    }
}