package com.example.knowledgespaceapk.Alumni.Directory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlumniSearchResultF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlumniSearchResultF extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView recyclerVAlumniSearchResultF;
    private ArrayList<DataModelAlumniSearchResultF> dataHolder;

    public AlumniSearchResultF() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlumniSearchResultF.
     */
    // TODO: Rename and change types and number of parameters
    public static AlumniSearchResultF newInstance(String param1, String param2) {
        AlumniSearchResultF fragment = new AlumniSearchResultF();
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
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_alumni_search_result, container, false);
        recyclerVAlumniSearchResultF = view.findViewById(R.id.recyclerVAlumniSearchResultF);
        recyclerVAlumniSearchResultF.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();
        addData();
        recyclerVAlumniSearchResultF.setAdapter(new AdapterAlumniSearchResultF(dataHolder));
        return view;
    }

    private void addData() {
        DataModelAlumniSearchResultF card1 = new DataModelAlumniSearchResultF("Shrikant","2023","56218","Computer",R.drawable.contacts,R.drawable.ic_baseline_person_24);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
    }
}