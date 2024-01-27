package com.example.adminapp.ApplicationActAdm;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.R;


public class Custom_Add_ApplicationOptAdm extends Fragment {

    private EditText receiverIdEditTvCusAddApplicationOptAdm,applicationSubjectEditTvCusAddApplicationOptAdm,
            applicationBodyEditTvCusAddApplicationOptAdm;
    private TextView applicationAttachmentEditTvCusAddApplicationOptAdm;
    private Button sendApplicationBtnCusAddApplicationOptAdm;


    public Custom_Add_ApplicationOptAdm() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_custom__add__application_opt_adm, container, false);
        receiverIdEditTvCusAddApplicationOptAdm = view.findViewById(R.id.receiverIdEditTvCusAddApplicationOptAdm);
        applicationSubjectEditTvCusAddApplicationOptAdm = view.findViewById(R.id.applicationSubjectEditTvCusAddApplicationOptAdm);
        applicationBodyEditTvCusAddApplicationOptAdm = view.findViewById(R.id.applicationBodyEditTvCusAddApplicationOptAdm);
        applicationAttachmentEditTvCusAddApplicationOptAdm = view.findViewById(R.id.applicationAttachmentEditTvCusAddApplicationOptAdm);
        sendApplicationBtnCusAddApplicationOptAdm = view.findViewById(R.id.sendApplicationBtnCusAddApplicationOptAdm);

        applicationAttachmentEditTvCusAddApplicationOptAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ADDATTACHMENT_RESULT_CODE = 1;
                Intent accessFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                accessFileIntent.setType("*" + "/*");
                startActivityForResult(accessFileIntent,ADDATTACHMENT_RESULT_CODE);
            }
        });

        sendApplicationBtnCusAddApplicationOptAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getFragmentManager().getBackStackEntryCount() != 0) {
                    getFragmentManager().popBackStack();
                }
                Toast.makeText(getContext(), "No Backend", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String filePath = data.getData().getPath();
                    Log.i("file path ----- ", filePath);
                    applicationAttachmentEditTvCusAddApplicationOptAdm.setText(filePath);
                }
        }
    }
}