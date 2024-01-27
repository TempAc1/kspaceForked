package com.example.knowledgespaceapk;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class GroupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerVFragGroupSc;
    adapterRecVGroupFrag adapter;
    private ArrayList<dataModelRecVFragGroup> dataHolder;

    public GroupFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static GroupFragment newInstance(String param1, String param2) {
        GroupFragment fragment = new GroupFragment();
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

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_group, container, false);
        recyclerVFragGroupSc = view.findViewById(R.id.recyclerVFragGroupSc);
        recyclerVFragGroupSc.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        dataModelRecVFragGroup obj1 = new dataModelRecVFragGroup("Apple","Orange",
                                                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj1);
        dataModelRecVFragGroup obj2 = new dataModelRecVFragGroup("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj2);
        dataModelRecVFragGroup obj3 = new dataModelRecVFragGroup("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj3);
        dataModelRecVFragGroup obj4 = new dataModelRecVFragGroup("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj4);
        dataModelRecVFragGroup obj5 = new dataModelRecVFragGroup("Apple","Orange",
                R.drawable.apple,R.drawable.orange);
        dataHolder.add(obj5);
        dataModelRecVFragGroup obj6 = new dataModelRecVFragGroup("Random",
                "Robotics",R.drawable.banana,R.drawable.orange);
        dataHolder.add(obj6);

        recyclerVFragGroupSc.setAdapter(new adapterRecVGroupFrag(dataHolder));
        
        return view;
    }
}