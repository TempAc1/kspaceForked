package com.example.knowledgespaceapk.Alumni.HallOfFrame.PreviousYrHoF;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.Alumni.HallOfFrame.PreviousYrHoF.RecyclerVMainSc.AdapterRecVMainScPrevYrHoF;
import com.example.knowledgespaceapk.Alumni.HallOfFrame.PreviousYrHoF.RecyclerVMainSc.DataModelRecVMainScPrevYrHoF;
import com.example.knowledgespaceapk.R;

import java.util.ArrayList;


public class PreviousYrHoFMainScFrag extends Fragment implements AdapterView.OnItemSelectedListener {


    private RecyclerView recyclerVPrevYrHoFMainSc;
    private TextView selectYrPrevYrHoFMainScF;
    private Button searchBtnPrevYrHoFMainScFrag;
    private ArrayList<DataModelRecVMainScPrevYrHoF> dataHolder;
    private Spinner spinnerSelectYearPrevYrHoFMainScF;
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

        recyclerVPrevYrHoFMainSc = view.findViewById(R.id.recyclerVPrevYrHoFMainSc);
//        selectYrPrevYrHoFMainScF = view.findViewById(R.id.selectYrPrevYrHoFMainScF);
        searchBtnPrevYrHoFMainScFrag = view.findViewById(R.id.searchBtnPrevYrHoFMainScFrag);

        spinnerSelectYearPrevYrHoFMainScF = view.findViewById(R.id.spinnerSelectYearPrevYrHoFMainScF);

        //Todo koi method h iske liye?
        dataHolderSpinner = new ArrayList<>();
        addSpinnerData();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_dropdown_item,years);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerSelectYearPrevYrHoFMainScF.setAdapter(arrayAdapter);
        spinnerSelectYearPrevYrHoFMainScF.setOnItemSelectedListener(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        recyclerVPrevYrHoFMainSc.setLayoutManager(gridLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerVPrevYrHoFMainSc.addItemDecoration(dividerItemDecoration);
        dataHolder = new ArrayList<>();
        addData();
        recyclerVPrevYrHoFMainSc.setAdapter(new AdapterRecVMainScPrevYrHoF(dataHolder));

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
                R.drawable.ic_baseline_home_24,
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
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
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
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}