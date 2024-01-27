package com.example.knowledgespaceapk.GroupAct.CourseSelectedF;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class CourseSelectedF extends Fragment {

    private RecyclerView recyclerVCourseSelectedOpt;

    private AdapterCourseSelectedF adapter;
    private ArrayList<DataModelCourseSelectedF> dataHolder;
    private boolean isBtnVisible = false;
    private ImageView cancelBtnAddCourseDialog,cancelBtnCusDiaAddModule;
    private Button addCourseBtnCusDiaAddCourse;
    private String[] courseAvailable = new String[] {"A.I","Blockchain","Data Science","Maths","Physics"};
    private ArrayAdapter<String> stringArrayAdapter;
    private Button addModuleBtnCusDiaAddModule;

    public CourseSelectedF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_course_selected, container, false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        recyclerVCourseSelectedOpt = view.findViewById(R.id.recyclerVCourseSelectedOpt);
        recyclerVCourseSelectedOpt.setLayoutManager(new LinearLayoutManager(getContext()));
        addObjToHolder();
        recyclerVCourseSelectedOpt.setAdapter(new AdapterCourseSelectedF(Navigation.findNavController(requireView()),dataHolder));


    }



    private void addObjToHolder() {
        dataHolder = new ArrayList<>();
        DataModelCourseSelectedF obj1 = new DataModelCourseSelectedF("Blochain", 8);
        dataHolder.add(obj1);
        DataModelCourseSelectedF obj2 = new DataModelCourseSelectedF("Iot", 10);
        dataHolder.add(obj2);dataHolder.add(obj1);dataHolder.add(obj2);dataHolder.add(obj1);dataHolder.add(obj2);
        dataHolder.add(obj1);dataHolder.add(obj2);dataHolder.add(obj1);dataHolder.add(obj2);dataHolder.add(obj1);
        dataHolder.add(obj2);dataHolder.add(obj2);
    }
}