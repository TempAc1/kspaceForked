package com.example.adminapp.GroupFragAdm;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class CourseSelectedFAdm extends Fragment {

    private RecyclerView recyclerVCourseSelectedOptAdm;
    private TextView addModuleTvCourseSelectedFAdm,addCourseTvCourseSelectedFAdm,
            autoCompleteTvDropDownSpinnerAddModuleDia,moduleAttachmentTvCusDiaAddModuleAdm;
    private FloatingActionButton floatingBtnCourseSelectedOptAdm,addModuleFloatingBtnCourseSelectedFAdm,addCourseFloatingBtnCourseSelectedFAdm;
    private adapterRecVCourseSelectedFAdm adapter;
    private ArrayList<dataModelRecVCourseSelectedFAdm> dataHolder;
    private boolean isBtnVisible = false;
    private ImageView cancelBtnAddCourseDialog,cancelBtnCusDiaAddModuleAdm;
    private Button addCourseBtnCusDiaAddCourseAdm;
    private String[] courseAvailable = new String[] {"A.I","Blockchain","Data Science","Maths","Physics"};
    private ArrayAdapter<String> stringArrayAdapter;
    private Button addModuleBtnCusDiaAddModuleAdm;

    public CourseSelectedFAdm() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_course_selected_f_adm, container, false);
        floatingBtnCourseSelectedOptAdm = view.findViewById(R.id.floatingBtnCourseSelectedOptAdm);
        addCourseFloatingBtnCourseSelectedFAdm = view.findViewById(R.id.addCourseFloatingBtnCourseSelectedFAdm);
        addCourseTvCourseSelectedFAdm = view.findViewById(R.id.addCourseTvCourseSelectedFAdm);
        addModuleFloatingBtnCourseSelectedFAdm = view.findViewById(R.id.addModuleFloatingBtnCourseSelectedFAdm);
        addModuleTvCourseSelectedFAdm = view.findViewById(R.id.addModuleTvCourseSelectedFAdm);


        recyclerVCourseSelectedOptAdm = view.findViewById(R.id.recyclerVCourseSelectedOptAdm);
        recyclerVCourseSelectedOptAdm.setLayoutManager(new LinearLayoutManager(getContext()));
        addObjToHolder();
        recyclerVCourseSelectedOptAdm.setAdapter(new adapterRecVCourseSelectedFAdm(dataHolder));

        floatingBtnCourseSelectedOptAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnVisibility();
            }
        });

        addCourseFloatingBtnCourseSelectedFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddCourseDialog();
            }
        });

        addModuleFloatingBtnCourseSelectedFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddModuleDialog();
            }
        });

        return view;
    }



    private void openAddModuleDialog() {
        Dialog dialog =  new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_addmodule_courseselected_f_adm);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        //Code for dropdown spinner
        autoCompleteTvDropDownSpinnerAddModuleDia = dialog.findViewById(R.id.autoCompleteTvDropDownSpinnerAddModuleDia);
        stringArrayAdapter = new ArrayAdapter<>(dialog.getContext(),R.layout.course_name_dropdown_item_addmodulef_adm,
                courseAvailable);

//        autoCompleteTvDropDownSpinnerAddModuleDia.addTextChangedListener((TextWatcher) dialog.getContext());
        //autoCompleteTvDropDownSpinnerAddModuleDia

        //Code For Add Attachment of Module:
        moduleAttachmentTvCusDiaAddModuleAdm = dialog.findViewById(R.id.moduleAttachmentTvCusDiaAddModuleAdm);
        moduleAttachmentTvCusDiaAddModuleAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int PICKFILE_RESULT_CODE=20;
                Intent acessFilesIntent = new Intent(Intent.ACTION_GET_CONTENT);
                acessFilesIntent.setType("*/*");
                startActivityForResult(acessFilesIntent,PICKFILE_RESULT_CODE);
            }
        });

        //Code for Dialog Cancel Btn
        addModuleBtnCusDiaAddModuleAdm = dialog.findViewById(R.id.addModuleBtnCusDiaAddModuleAdm);
        cancelBtnCusDiaAddModuleAdm = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);

        cancelBtnCusDiaAddModuleAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog.setCancelable(true);
            }
        });
        addModuleBtnCusDiaAddModuleAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setCancelable(true);
                dialog.dismiss();
                Toast.makeText(getActivity(), "Posting...", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    private void openAddCourseDialog() {
        Dialog dialog =  new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_addcourse_courseselected_f_adm);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        //Code for Dialog Cancel Btn
        addCourseBtnCusDiaAddCourseAdm = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm);
        cancelBtnAddCourseDialog = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);

        cancelBtnAddCourseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog.setCancelable(true);
            }
        });
        addCourseBtnCusDiaAddCourseAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setCancelable(true);
                dialog.dismiss();
                Toast.makeText(getActivity(), "Posting...", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    private void setBtnVisibility() {
        if (!isBtnVisible) {
            addCourseFloatingBtnCourseSelectedFAdm.setVisibility(View.VISIBLE);
            addCourseTvCourseSelectedFAdm.setVisibility(View.VISIBLE);
            addModuleFloatingBtnCourseSelectedFAdm.setVisibility(View.VISIBLE);
            addModuleTvCourseSelectedFAdm.setVisibility(View.VISIBLE);
            isBtnVisible = true;
        } else {
            addCourseFloatingBtnCourseSelectedFAdm.setVisibility(View.GONE);
            addCourseTvCourseSelectedFAdm.setVisibility(View.GONE);
            addModuleFloatingBtnCourseSelectedFAdm.setVisibility(View.GONE);
            addModuleTvCourseSelectedFAdm.setVisibility(View.GONE);
            isBtnVisible = false;
        }
    }


    private void addObjToHolder() {
        dataHolder = new ArrayList<>();
        dataModelRecVCourseSelectedFAdm obj1 = new dataModelRecVCourseSelectedFAdm("Blochain", 8);
        dataHolder.add(obj1);
        dataModelRecVCourseSelectedFAdm obj2 = new dataModelRecVCourseSelectedFAdm("Iot", 10);
        dataHolder.add(obj2);dataHolder.add(obj1);dataHolder.add(obj2);dataHolder.add(obj1);dataHolder.add(obj2);
        dataHolder.add(obj1);dataHolder.add(obj2);dataHolder.add(obj1);dataHolder.add(obj2);dataHolder.add(obj1);
        dataHolder.add(obj2);dataHolder.add(obj2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String filePath = data.getData().getPath();
                    Log.i("file path ----- ", filePath);
                    moduleAttachmentTvCusDiaAddModuleAdm.setText(filePath);
                }
        }
    }
}