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


public class GroupFragAdm extends Fragment {

    private RecyclerView recyclerVFragGroupSc;
    adapterRecVGroupFragAdm adapter;
    private ArrayList<dataModelRecVGroupFragAdm> dataHolder;

    public GroupFragAdm() {
        // Required empty public constructor
    }


   

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_group_frag_adm, container, false);
        recyclerVFragGroupSc = view.findViewById(R.id.recyclerVFragGroupScAdm);
        recyclerVFragGroupSc.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        dataModelRecVGroupFragAdm obj1 = new dataModelRecVGroupFragAdm("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj1);
        dataModelRecVGroupFragAdm obj2 = new dataModelRecVGroupFragAdm("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj2);
        dataModelRecVGroupFragAdm obj3 = new dataModelRecVGroupFragAdm("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj3);
        dataModelRecVGroupFragAdm obj4 = new dataModelRecVGroupFragAdm("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj4);
        dataModelRecVGroupFragAdm obj5 = new dataModelRecVGroupFragAdm("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj5);
        dataModelRecVGroupFragAdm obj6 = new dataModelRecVGroupFragAdm("Random",
                "Robotics",R.drawable.banana,R.drawable.orange);
        dataHolder.add(obj6);

        recyclerVFragGroupSc.setAdapter(new adapterRecVGroupFragAdm(dataHolder));

        return view;
    }
}