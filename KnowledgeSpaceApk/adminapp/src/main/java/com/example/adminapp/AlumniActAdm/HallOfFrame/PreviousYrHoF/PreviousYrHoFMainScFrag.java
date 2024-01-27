package com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.RecyclerVMainSc.AdapterRecVMainScPrevYrHoFAdm;
import com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.RecyclerVMainSc.DataModelRecVMainScPrevYrHoF;
import com.example.adminapp.R;

import java.util.ArrayList;


public class PreviousYrHoFMainScFrag extends Fragment implements AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerVPrevYrHoFMainScAdm;
    private TextView selectYrPrevYrHoFMainScFAdm;
    private Button searchBtnPrevYrHoFMainScFragAdm;
    private ArrayList<DataModelRecVMainScPrevYrHoF> dataHolder;
    private Spinner spinnerSelectYearPrevYrHoFMainScFAdm;
    private ArrayList<DataModelForSpinnerPrevYrOpts> dataHolderSpinner;


    private static final String[] years = {"20XX", "2019", "2020","2021","2022","2023"};

    public PreviousYrHoFMainScFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_previous_yr_ho_f_main_sc, container, false);

        recyclerVPrevYrHoFMainScAdm = view.findViewById(R.id.recyclerVPrevYrHoFMainScAdm);
//        selectYrPrevYrHoFMainScFAdm = view.findViewById(R.id.selectYrPrevYrHoFMainScFAdm);
        searchBtnPrevYrHoFMainScFragAdm = view.findViewById(R.id.searchBtnPrevYrHoFMainScFragAdm);

        spinnerSelectYearPrevYrHoFMainScFAdm = view.findViewById(R.id.spinnerSelectYearPrevYrHoFMainScFAdm);

        //Todo koi method h iske liye?
        dataHolderSpinner = new ArrayList<>();
        addSpinnerData();


        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_dropdown_item,years);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerSelectYearPrevYrHoFMainScFAdm.setAdapter(arrayAdapter);
        spinnerSelectYearPrevYrHoFMainScFAdm.setOnItemSelectedListener(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        recyclerVPrevYrHoFMainScAdm.setLayoutManager(gridLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerVPrevYrHoFMainScAdm.addItemDecoration(dividerItemDecoration);
        dataHolder = new ArrayList<>();
        addData();
        recyclerVPrevYrHoFMainScAdm.setAdapter(new AdapterRecVMainScPrevYrHoFAdm(dataHolder));

        return view;
    }

    private void addSpinnerData() {
        DataModelForSpinnerPrevYrOpts obj = new DataModelForSpinnerPrevYrOpts(2019);
        dataHolderSpinner.add(obj);
        dataHolderSpinner.add(obj);
        DataModelForSpinnerPrevYrOpts obj2 = new DataModelForSpinnerPrevYrOpts(2020);
        dataHolderSpinner.add(obj2);
        DataModelForSpinnerPrevYrOpts obj3 = new DataModelForSpinnerPrevYrOpts(2022);
        dataHolderSpinner.add(obj3);
        DataModelForSpinnerPrevYrOpts obj4 = new DataModelForSpinnerPrevYrOpts(2023);
        dataHolderSpinner.add(obj4);
        DataModelForSpinnerPrevYrOpts obj5 = new DataModelForSpinnerPrevYrOpts(2024);
        dataHolderSpinner.add(obj5);
        DataModelForSpinnerPrevYrOpts obj6 = new DataModelForSpinnerPrevYrOpts(2025);
        dataHolderSpinner.add(obj6);
    }

    //Todo add backend linked profile link
    private void addData() {
        DataModelRecVMainScPrevYrHoF card1 = new DataModelRecVMainScPrevYrHoF(
                R.drawable.ic_baseline_person_24,
                R.drawable.linkedin,
                "Shrikant","Computer");
        dataHolder.add(card1);
        dataHolder.add(card1); dataHolder.add(card1); dataHolder.add(card1);
        dataHolder.add(card1); dataHolder.add(card1); dataHolder.add(card1); dataHolder.add(card1);
        dataHolder.add(card1); dataHolder.add(card1);
        dataHolder.add(card1); dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);
        dataHolder.add(card1);


    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                //Do nothing
                break;
            case 1:
                Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getContext(), "4", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(getContext(), "5", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}