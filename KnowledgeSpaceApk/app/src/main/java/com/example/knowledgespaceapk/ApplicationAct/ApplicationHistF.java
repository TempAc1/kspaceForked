package com.example.knowledgespaceapk.ApplicationAct;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;


public class ApplicationHistF extends Fragment {

    private ArrayList<DataModelRecVAppHistF> dataHolder;
    private AdapterRecVAppHistF adapter;
    private RecyclerView recyclerVAppHistF;


    public ApplicationHistF() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_application_hist, container, false);
        recyclerVAppHistF = view.findViewById(R.id.recyclerVAppHistF);
        recyclerVAppHistF.setHasFixedSize(true);
        recyclerVAppHistF.setLayoutManager(new LinearLayoutManager(getContext()));
        addDataToHolder();
        recyclerVAppHistF.setAdapter(new AdapterRecVAppHistF(dataHolder));


        return view;
    }

    private void addDataToHolder() {
        dataHolder = new ArrayList<>();
        DataModelRecVAppHistF obj = new DataModelRecVAppHistF(
                "#54621","Leave Application","Random Description  While our memory is critically \n" +
                "                important to us, individual memories do not drive our personality.Psychologists and \n" +
                "        cognitive scientists often talk about autobiographical memory as having \n" +
                "                (at least) three key functions. According to the self function, we know who we are because\n" +
                "        of our past experiences. According to the social function, telling memory stories helps us to socialise\n" +
                "        and bond with others. Finally, according to the directive function, our memories help us learn \n" +
                "        lessons from the past and solve problems into the future\n" +
                "                Some salient memories may be particularly important for our identity. For example, winning the\n" +
                "        state volleyball championship may be critical for how we view ourselves as an athlete. Underlying \n" +
                "        personality traits, however, are relatively stable", "Pass"
        );
        dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);
        dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);dataHolder.add(obj);

    }
}