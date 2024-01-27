package com.example.knowledgespaceapk.NotificationAct.NotificationFrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerVFragNotiSc;
    adapterRecVNotificationFrag adapter;
    private ArrayList<dataModelRecVFragNotification> dataHolderNotiFrag;

    public NotificationFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NotificationFragment newInstance(String param1, String param2) {
        NotificationFragment fragment = new NotificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.fragment_notification, container, false);
        recyclerVFragNotiSc = view.findViewById(R.id.recyclerVFragNotificationSc);
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