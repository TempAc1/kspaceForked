package com.example.adminapp.FeesActAdm;

import com.example.adminapp.R;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;


public class DefaultFragFeesActAdm extends Fragment {

    private Button viewFeesBtnDefaultFFeesActAdm,downloadFeesBtnDefaultFFeesActAdm;
    private EditText roleEditTvFeesActMainScAdm,rolePassEditTvFeesActMainScAdm;
    private ChipGroup chipGrpDefaultFragFeesActAdm;
    private Chip feesPaidChipBtnChipGrpDefaultFragFeesActAdm,feesNotPaidChipBtnChipGrpDefaultFragFeesActAdm,
            allFeesChipBtnChipGrpDefaultFragFeesActAdm;
    private AutoCompleteTextView textInputLayDefaultFeesFragAdm;

    public DefaultFragFeesActAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_default_frag_fees_act_adm, container, false);
        viewFeesBtnDefaultFFeesActAdm = view.findViewById(R.id.viewFeesBtnDefaultFFeesActAdm);
        downloadFeesBtnDefaultFFeesActAdm = view.findViewById(R.id.downloadFeesBtnDefaultFFeesActAdm);
        roleEditTvFeesActMainScAdm = view.findViewById(R.id.roleEditTvFeesActMainScAdm);
        rolePassEditTvFeesActMainScAdm = view.findViewById(R.id.rolePassEditTvFeesActMainScAdm);
        chipGrpDefaultFragFeesActAdm = view.findViewById(R.id.chipGrpDefaultFragFeesActAdm);
        chipGrpDefaultFragFeesActAdm.setSelectionRequired(true);
        feesPaidChipBtnChipGrpDefaultFragFeesActAdm = view.findViewById(R.id.feesPaidChipBtnChipGrpDefaultFragFeesActAdm);
        feesNotPaidChipBtnChipGrpDefaultFragFeesActAdm = view.findViewById(R.id.feesNotPaidChipBtnChipGrpDefaultFragFeesActAdm);
        allFeesChipBtnChipGrpDefaultFragFeesActAdm = view.findViewById(R.id.allFeesChipBtnChipGrpDefaultFragFeesActAdm);
        textInputLayDefaultFeesFragAdm = view.findViewById(R.id.autoCompleteTextViewDefaultFFeesAdm);

        //We will use this data to inflate the drop-down items
        String[] authorityLevel = new String[]{"Administrator","Teacher-Guardian","Class Teacher","H.O.D","Principle"};

        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),R.layout.dropdown_menuitems_defaultfees_f_adm,authorityLevel);
        textInputLayDefaultFeesFragAdm.setAdapter(adapter);

        textInputLayDefaultFeesFragAdm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "" + textInputLayDefaultFeesFragAdm.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        viewFeesBtnDefaultFFeesActAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new FeesResultFragFeesActAdm();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayFeesActMainScAdm,fr).commit();
                ft.addToBackStack(null);
            }
        });

        return view;
    }
}