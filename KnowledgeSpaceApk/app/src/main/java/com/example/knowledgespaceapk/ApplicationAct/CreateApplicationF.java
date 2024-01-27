package com.example.knowledgespaceapk.ApplicationAct;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;


public class CreateApplicationF extends Fragment {

    private EditText senderIdEditTvCreateApplicationF,applicationSubjectEditTvCreateApplicationF,
            applicationBodyEditTvCreateApplicationF;
    private TextView applicationAttachmentEditTvCreateApplicationF;
    private Button sendApplicationBtnCreateApplicationF,okayBtnCusDiaCreateAppF;

    public CreateApplicationF() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_create_application, container, false);
        senderIdEditTvCreateApplicationF = view.findViewById(R.id.senderIdEditTvCreateApplicationF);
        applicationSubjectEditTvCreateApplicationF = view.findViewById(R.id.applicationSubjectEditTvCreateApplicationF);
        applicationBodyEditTvCreateApplicationF = view.findViewById(R.id.applicationBodyEditTvCreateApplicationF);
        applicationAttachmentEditTvCreateApplicationF = view.findViewById(R.id.applicationAttachmentEditTvCreateApplicationF);
        sendApplicationBtnCreateApplicationF = view.findViewById(R.id.sendApplicationBtnCreateApplicationF);

        sendApplicationBtnCreateApplicationF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "On Backend", Toast.LENGTH_SHORT).show();
                openDialog();
            }
        });



        applicationAttachmentEditTvCreateApplicationF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ADDATTACHMENT_RESULT_CODE = 1;
                Intent accessFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                accessFileIntent.setType("*" + "/*");
                startActivityForResult(accessFileIntent,ADDATTACHMENT_RESULT_CODE);
            }
        });
        return view;
    }

    private void openDialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_dialog_createapplication_f);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        okayBtnCusDiaCreateAppF = dialog.findViewById(R.id.okayBtnCusDiaCreateAppF);
        okayBtnCusDiaCreateAppF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String filePath = data.getData().getPath();
                    Log.i("file path ----- ", filePath);
                    applicationAttachmentEditTvCreateApplicationF.setText(filePath);
                }
        }
    }
}