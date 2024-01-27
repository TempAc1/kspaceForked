package com.example.adminapp.ApplicationActAdm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;

import com.example.adminapp.GroupFragAdm.GrpQuizesAdm.QuizesMainScAdm;
import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ApplicationActMainFAdm extends Fragment {

    private RecyclerView recyclerVApplicationActMainFAdm;
    private FrameLayout frameLayApplicationActMainFAdm;
    private FloatingActionButton floatingBtnApplicationActMainFAdm;

    private ArrayList<DataModelRecVApplicationMainFAdm> dataHolder;
    private AdapterApplicationMainFAdm adapter;

    public ApplicationActMainFAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_application_act_main_f_adm, container, false);

        recyclerVApplicationActMainFAdm = view.findViewById(R.id.recyclerVApplicationActMainFAdm);
        frameLayApplicationActMainFAdm = view.findViewById(R.id.frameLayApplicationActMainFAdm);
        floatingBtnApplicationActMainFAdm = view.findViewById(R.id.floatingBtnApplicationActMainFAdm);
        floatingBtnApplicationActMainFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Custom_Add_ApplicationOptAdm();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayApplicationActAdm, fragment).commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        recyclerVApplicationActMainFAdm.setLayoutManager(new LinearLayoutManager(getContext()));
        addDataToHolder();
        recyclerVApplicationActMainFAdm.setAdapter(new AdapterApplicationMainFAdm(dataHolder));


        return view;
    }

    private void addDataToHolder() {
        dataHolder = new ArrayList<>();
        DataModelRecVApplicationMainFAdm obj = new DataModelRecVApplicationMainFAdm(
                "#58464",
                "Leave Application",
                "Demo Description here"
        );
        dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);
        dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);
    }
}