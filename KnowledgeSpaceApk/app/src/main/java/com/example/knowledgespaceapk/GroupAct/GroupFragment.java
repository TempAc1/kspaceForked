package com.example.knowledgespaceapk.GroupAct;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class GroupFragment extends Fragment {



    private RecyclerView recyclerVFragGroupSc;
    adapterRecVGroupFrag adapter;
    private ArrayList<dataModelRecVFragGroup> dataHolder;

    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_group, container, false);
        recyclerVFragGroupSc = view.findViewById(R.id.recyclerVFragGroupSc);

        //Add Grid col-2 type recyclerview
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        recyclerVFragGroupSc.setLayoutManager(gridLayoutManager);
        //Add space in grid
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL);
        recyclerVFragGroupSc.addItemDecoration(dividerItemDecoration);
        recyclerVFragGroupSc.addItemDecoration(dividerItemDecoration);

        dataHolder = new ArrayList<>();

        dataModelRecVFragGroup obj1 = new dataModelRecVFragGroup("Apple",
                                                R.drawable.apple);
        dataHolder.add(obj1);
        dataModelRecVFragGroup obj2 = new dataModelRecVFragGroup("Apple",
                R.drawable.orange);
        dataHolder.add(obj2);
        dataModelRecVFragGroup obj3 = new dataModelRecVFragGroup("Apple",
                R.drawable.apple);
        dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);dataHolder.add(obj3);


        recyclerVFragGroupSc.setAdapter(new adapterRecVGroupFrag(dataHolder));
        
        return view;
    }
}