package com.example.knowledgespaceapk.GroupAct.GrpQuizes;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;


public class QuizesMainSc extends Fragment {

    private RecyclerView parentRecVQuizesFragMainSc;
    private AdapterQuizMainSc adapter;
    private ArrayList<DataModelRecVQuizMainSc> dataHolder;


    public QuizesMainSc() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       return LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_quizes_main_sc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        parentRecVQuizesFragMainSc = view.findViewById(R.id.parentRecVQuizesFragMainSc);
        parentRecVQuizesFragMainSc.setLayoutManager(new LinearLayoutManager(getContext()));
        addObjToHolder();
        parentRecVQuizesFragMainSc.setAdapter(new AdapterQuizMainSc(dataHolder));

    }



    private void addObjToHolder() {
        dataHolder = new ArrayList<>();
        QuizData obj = new QuizData();
        String time = obj.getQuizTime();
        String ques = obj.getQuizTotalQues();
        DataModelRecVQuizMainSc obj1 = new DataModelRecVQuizMainSc("IOT", ques,time);
        dataHolder.add(obj1);
        dataHolder.add(obj1);dataHolder.add(obj1);
        dataHolder.add(obj1);dataHolder.add(obj1);
        dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);
        dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);
    }
}