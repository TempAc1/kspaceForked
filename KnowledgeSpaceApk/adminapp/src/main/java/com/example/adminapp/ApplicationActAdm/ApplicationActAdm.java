package com.example.adminapp.ApplicationActAdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.adminapp.GroupFragAdm.GrpQuizesAdm.QuizesMainScAdm;
import com.example.adminapp.R;

public class ApplicationActAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_act_adm);

        Fragment fragment = new ApplicationActMainFAdm();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayApplicationActAdm, fragment).commit();
        fragmentTransaction.addToBackStack(null);
    }
}