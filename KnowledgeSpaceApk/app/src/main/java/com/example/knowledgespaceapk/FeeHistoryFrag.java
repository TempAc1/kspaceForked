package com.example.knowledgespaceapk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FeeHistoryFrag extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    //Custom
    private RecyclerView recyclerVFeeHistoryFrag;
    adapterRecVFeeHistoryFrag adapter;
    private ArrayList<dataModelRecVFeeHistoryFrag> dataHolderFeeHistoryFrag;

    public FeeHistoryFrag() {
        // Required empty public constructor
    }

    public static FeeHistoryFrag newInstance(String param1, String param2) {
        FeeHistoryFrag fragment = new FeeHistoryFrag();
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
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fee_history, container, false);
        recyclerVFeeHistoryFrag = view.findViewById(R.id.recyclerVFeeHistoryTabItem);
        recyclerVFeeHistoryFrag.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolderFeeHistoryFrag = new ArrayList<>();

        dataModelRecVFeeHistoryFrag obj1 = new dataModelRecVFeeHistoryFrag("Paid on 2 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj1);
        dataModelRecVFeeHistoryFrag obj2 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.failed);dataHolderFeeHistoryFrag.add(obj2);
        dataModelRecVFeeHistoryFrag obj3 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj3);
        dataModelRecVFeeHistoryFrag obj4 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.failed);dataHolderFeeHistoryFrag.add(obj4);
        dataModelRecVFeeHistoryFrag obj5 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.failed);dataHolderFeeHistoryFrag.add(obj5);
        dataModelRecVFeeHistoryFrag obj6 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj6);
        dataModelRecVFeeHistoryFrag obj7 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.failed);dataHolderFeeHistoryFrag.add(obj7);
        dataModelRecVFeeHistoryFrag obj8 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj8);
        dataModelRecVFeeHistoryFrag obj9 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.failed);dataHolderFeeHistoryFrag.add(obj9);
        dataModelRecVFeeHistoryFrag obj10 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj10);
        dataModelRecVFeeHistoryFrag obj11 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.failed);dataHolderFeeHistoryFrag.add(obj11);
        dataModelRecVFeeHistoryFrag obj12 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.failed);dataHolderFeeHistoryFrag.add(obj12);
        dataModelRecVFeeHistoryFrag obj13 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj13);
        dataModelRecVFeeHistoryFrag obj14 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj14);
        dataModelRecVFeeHistoryFrag obj15 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj15);
        dataModelRecVFeeHistoryFrag obj16 = new dataModelRecVFeeHistoryFrag("Could not pay on 10 oct",R.drawable.approved);dataHolderFeeHistoryFrag.add(obj16);

        recyclerVFeeHistoryFrag.setAdapter(new adapterRecVFeeHistoryFrag(dataHolderFeeHistoryFrag));
        return view;
    }

}