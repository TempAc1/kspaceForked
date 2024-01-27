package com.example.knowledgespaceapk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.knowledgespaceapk.databinding.ActivityRoutineBinding;

public class RoutineAct extends AppCompatActivity {

    private ActivityRoutineBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRoutineBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.downloadRoutineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RoutineAct.this, "Downloading...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}