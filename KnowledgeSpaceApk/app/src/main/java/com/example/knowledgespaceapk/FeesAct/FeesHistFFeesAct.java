package com.example.knowledgespaceapk.FeesAct;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.knowledgespaceapk.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class FeesHistFFeesAct extends Fragment {

    RecyclerView recyclerVFeesHistF;
    FrameLayout frameLayFeesHistF;
    AdapterRecVFeesHistF adapter;
    ArrayList<DataModelRecVFeesHistF> dataHolder;

    public FeesHistFFeesAct() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fees_hist_f_fees_act, container, false);

        frameLayFeesHistF = view.findViewById(R.id.frameLayFeesHistF);
        recyclerVFeesHistF = view.findViewById(R.id.recyclerVFeesHistF);
        recyclerVFeesHistF.setLayoutManager(new LinearLayoutManager(getContext()));
        addDataToHolder();
        recyclerVFeesHistF.setAdapter(new AdapterRecVFeesHistF(dataHolder));

        return view;
    }

    private void addDataToHolder() {
        dataHolder = new ArrayList<>();
        Date currentDate = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        String str = dateFormat.format(currentDate);
        DataModelRecVFeesHistF obj = new DataModelRecVFeesHistF("#78560",
              str,"Academics","Success",8954600,
                R.drawable.success_tick);
        dataHolder.add(obj);dataHolder.add(obj);
        dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);
        dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);
    }
}