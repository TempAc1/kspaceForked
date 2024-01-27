package com.example.knowledgespaceapk.GroupAct.SpecificChapDetailsF;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;


public class SpecificChapterDetailsF extends Fragment {

    private RecyclerView recyclerView;
    private AdapterSpecificChapDetailsF adapter;
    private ArrayList<DataModelRecVSpecificChapDetailsF> dataHolder;

    public SpecificChapterDetailsF() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_specific_chapter_details, container, false);

        //ADD YOUR CODE HERE
        recyclerView = view.findViewById(R.id.recyclerVSpecificChapDetailsF);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder =  new ArrayList<>();
        addData();
        recyclerView.setAdapter(new AdapterSpecificChapDetailsF(dataHolder));

        return view;
    }

    private void addData() {
        DataModelRecVSpecificChapDetailsF obj1 = new DataModelRecVSpecificChapDetailsF("Blockchain 7201856",
                "Module first","Chapter Decentenralize",
                "Not available");
        dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);
    }
}