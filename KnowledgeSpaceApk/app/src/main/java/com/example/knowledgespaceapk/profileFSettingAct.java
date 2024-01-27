package com.example.knowledgespaceapk;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class profileFSettingAct extends Fragment {

    private TextView passTvProfileFSettingAct,confPassTvProfileFSettingAct;
    private ImageView showPassImgProfileFSettingAct,showConfPassImgProfileFSettingAct;
    private MaterialButton signOutBtn;

    public profileFSettingAct(){
        //no-args constructor req
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_profile_f_setting_act, container, false);

        showPassImgProfileFSettingAct = view.findViewById(R.id.showPassImgProfileFSettingAct);
        showConfPassImgProfileFSettingAct = view.findViewById(R.id.showConfPassImgProfileFSettingAct);
        passTvProfileFSettingAct = view.findViewById(R.id.passTvProfileFSettingAct);
        confPassTvProfileFSettingAct = view.findViewById(R.id.confPassTvProfileFSettingAct);
        signOutBtn =view.findViewById(R.id.saveMaterialBtnProfileFSettingAct);

        signOutBtn.setOnClickListener(view1 -> {
            Toast.makeText(view1.getContext(), "Saved Successfully", Toast.LENGTH_SHORT).show();
        });
        showPass();
        showConfPass();
        return view;
    }

    private void showConfPass() {
        showConfPassImgProfileFSettingAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confPassTvProfileFSettingAct.setTransformationMethod(null);
            }
        });
    }

    private void showPass() {
        showPassImgProfileFSettingAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passTvProfileFSettingAct.setTransformationMethod(null);
            }
        });
    }
}