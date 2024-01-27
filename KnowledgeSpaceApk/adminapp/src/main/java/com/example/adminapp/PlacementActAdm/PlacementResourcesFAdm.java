package com.example.adminapp.PlacementActAdm;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class PlacementResourcesFAdm extends Fragment {

  private ArrayList<DataModelRecVPlacementResourcesFAdm> dataHolder;
  private AdapterPlacementResourcesFAdm adapter;
  private RecyclerView recyclerVPlacementResourcesFAdm;
  private FloatingActionButton floationBtnAddResourcesPlacementResourcesFAdm;

  //cus Dialog:
  private ImageView cancelBtnImgVCusDiaAddResources;
  private TextView setResourceTvCusDiaAddResources;
  private EditText setResourceTitleTvCusDiaAddResources;
  private Button addResourceBtnCusDiaAddResources;

    public PlacementResourcesFAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_placement_resources_f_adm, container, false);

        recyclerVPlacementResourcesFAdm = view.findViewById(R.id.recyclerVPlacementResourcesFAdm);
        floationBtnAddResourcesPlacementResourcesFAdm = view.findViewById(R.id.floationBtnAddResourcesPlacementResourcesFAdm);

        recyclerVPlacementResourcesFAdm.setLayoutManager(new LinearLayoutManager(getContext()));
        addObjToHolder();
        recyclerVPlacementResourcesFAdm.setAdapter(new AdapterPlacementResourcesFAdm(dataHolder));

        //FloatingBtn:
        floationBtnAddResourcesPlacementResourcesFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        return view;
    }

    private void openDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.cus_dia_add_resources_fadm);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        cancelBtnImgVCusDiaAddResources = dialog.findViewById(R.id.cancelBtnImgVCusDiaAddResources);
        cancelBtnImgVCusDiaAddResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setCancelable(true);
                dialog.dismiss();
            }
        });

        addResourceBtnCusDiaAddResources = dialog.findViewById(R.id.addResourceBtnCusDiaAddResources);
        addResourceBtnCusDiaAddResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setCancelable(true);
                dialog.dismiss();
                Toast.makeText(getContext(), "Adding Offer...without backend", Toast.LENGTH_SHORT).show();
            }
        });

        setResourceTvCusDiaAddResources = dialog.findViewById(R.id.setResourceTvCusDiaAddResources);
        setResourceTvCusDiaAddResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int PICKFILE_RESULT_CODE=1;
                Intent acessFilesIntent = new Intent(Intent.ACTION_GET_CONTENT);
                acessFilesIntent.setType("*/*");
                startActivityForResult(acessFilesIntent,PICKFILE_RESULT_CODE);
            }
        });

        dialog.show();
    }

    private void addObjToHolder() {
        dataHolder = new ArrayList<>();
        DataModelRecVPlacementResourcesFAdm obj = new
                DataModelRecVPlacementResourcesFAdm("Demo",
                "demo");
        dataHolder.add(obj);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String filePath = data.getData().getPath();
                    Log.i("file path ----- ", filePath);
                    setResourceTvCusDiaAddResources.setText(filePath);
                }
        }
    }
}