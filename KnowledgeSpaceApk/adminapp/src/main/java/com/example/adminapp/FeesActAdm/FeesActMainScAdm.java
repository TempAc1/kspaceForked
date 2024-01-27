package com.example.adminapp.FeesActAdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.adminapp.GroupFragAdm.GrpQuizesAdm.QuizesMainScAdm;
import com.example.adminapp.R;

public class FeesActMainScAdm extends AppCompatActivity {
    private FrameLayout frameLayFeesActMainScAdm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_act_main_sc_adm);

        frameLayFeesActMainScAdm =findViewById(R.id.frameLayFeesActMainScAdm);

        Fragment fragment = new DefaultFragFeesActAdm();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayFeesActMainScAdm, fragment).commit();
        fragmentTransaction.addToBackStack(null);

    }
}