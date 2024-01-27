package com.example.adminapp.PlacementActAdm;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adminapp.FeesActAdm.AdapterFeesResultFAdm;
import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class PlacementDefaultFAdm extends Fragment {

    private ArrayList<DataModelRecVPlacementDefaultFAdm> dataHolder;
    private RecyclerView recyclerView;
    private AdapterPlacementDefaultFAdm adapter;
    private FloatingActionButton floatingBtnPlacementDefaultFAdm;
//    Dialog box
    private ImageView cancelBtnImgVCusDiaAddPlacementOffer;
    private EditText setOfferTitleTvCusDiaAddPlacementOffer,setOfferLinkTvCusDiaAddPlacementOffer,setOfferDescriptionTvCusDiaAddPlacementOffer;
    private Button addOfferBtnCusDiaAddPlacementOffer;

    public PlacementDefaultFAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_placement_default_f_adm, container, false);

        //All Ui need to add here:
        recyclerView = view.findViewById(R.id.recyclerVPlacementDefaultFAdm);
        floatingBtnPlacementDefaultFAdm  = view.findViewById(R.id.floatingBtnPlacementDefaultFAdm);


        //Setting Up Recycler View:
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        addObjToHolder();
        recyclerView.setAdapter(new AdapterPlacementDefaultFAdm(dataHolder));


        floatingBtnPlacementDefaultFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                Toast.makeText(getContext(), "Clicked yeah", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void openDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.cus_dia_add_placement_offer_fadm);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        cancelBtnImgVCusDiaAddPlacementOffer = dialog.findViewById(R.id.cancelBtnImgVCusDiaAddPlacementOffer);
        cancelBtnImgVCusDiaAddPlacementOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setCancelable(true);
                dialog.dismiss();
            }
        });

        addOfferBtnCusDiaAddPlacementOffer = dialog.findViewById(R.id.addOfferBtnCusDiaAddPlacementOffer);
        addOfferBtnCusDiaAddPlacementOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setCancelable(true);
                dialog.dismiss();
                Toast.makeText(getContext(), "Adding Offer...without backend", Toast.LENGTH_SHORT).show();
            }
        });



        dialog.show();

    }

    private void addObjToHolder() {
        dataHolder = new ArrayList<>();
        DataModelRecVPlacementDefaultFAdm obj = new DataModelRecVPlacementDefaultFAdm("Jio Platforms",
                "Dear Students Greetings from D. Y. Patil International University, Akurdi! It gives us immense pleasure to invite you for the Campus Recruitment of Pi Techniques Private Limited for 2023 Graduating Batch",
                "https://www.pitechniques.com/");
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
        dataHolder.add(obj);
    }
}