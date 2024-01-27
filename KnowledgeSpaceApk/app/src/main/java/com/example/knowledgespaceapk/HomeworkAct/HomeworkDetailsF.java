package com.example.knowledgespaceapk.HomeworkAct;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.knowledgespaceapk.R;
import com.google.android.material.button.MaterialButton;


public class HomeworkDetailsF extends Fragment {

    FrameLayout frameLayHomeworkDetailsF;
    TextView homeworkTitleTvHomeworkDetailsF,homeworkDesTvHomeworkDetailsF,homeworkDueDateTvHomeworkDetailsF,
            homeworkDueTimeTvHomeworkDetailsF;
    MaterialButton materialBtnSubmitHomeworkHomeworkDetailsF;

    public HomeworkDetailsF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = LayoutInflater.from(getContext()).inflate(R.layout.fragment_homework_details, container, false);

        materialBtnSubmitHomeworkHomeworkDetailsF = view.findViewById(R.id.materialBtnSubmitHomeworkHomeworkDetailsF);
        //TODO material btn clickable tab tak rhega jab tk due date n time valid hai

        return view;
    }
}