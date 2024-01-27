package com.example.knowledgespaceapk.Settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.HomeSc.homeSc;
import com.example.knowledgespaceapk.MainActivity;
import com.example.knowledgespaceapk.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class settingMainScF extends Fragment {


    private TextView profileSettingTvSettingsMainScF,tNcTvSettingsMainScF,signOutTvMainScF;
    private  FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    public settingMainScF() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting_main_sc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profileSettingTvSettingsMainScF = view.findViewById(R.id.profileSettingTvSettingsMainScF);
        tNcTvSettingsMainScF = view.findViewById(R.id.tNcTvSettingsMainScF);
        signOutTvMainScF = view.findViewById(R.id.signOutTvMainScF);

        final NavController navController = Navigation.findNavController(view);

        profileSettingTvSettingsMainScF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_settingMainScF_to_profileFSettingAct);
            }
        });

        tNcTvSettingsMainScF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_settingMainScF_to_TNcFSettingAct);
            }
        });
        signOutTvMainScF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                navController.navigate(R.id.action_settingMainScF_to_loginNSignupMainFrag);
                Toast.makeText(getContext(), "Signed Out!!", Toast.LENGTH_LONG).show();
            }
        });

    }


}