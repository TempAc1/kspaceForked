package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc;

import static android.app.Activity.RESULT_OK;
import static com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc.AdapterAlumniSearchResultFAdm.PICK_IMAGE;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.R;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class UpdateAlumniDetailsFAdm extends Fragment {

    private static final int PICK_IMG = 1;
    private ImageView imgVRegNoUpdateAlumniDetailFAdm,imgVDeptUpdateAlumniDetailFAdm,
            imgVBatchYrUpdateAlumniDetailFAdm,imgVEditTvNameUpdateAlumniDetailFAdm;
    private TextView editTvRegNoUpdateAlumniDetailFAdm,editTvBatchYrUpdateAlumniDetailFAdm,editTvDeptNameUpdateAlumniDetailFAdm,
            editTvNameUpdateAlumniDetailFAdm;
    private ImageView imgVUpdateAlumniDetailFAdm;
    private Button updateAlumniBtnUpdateAlumniDetailFAdm;

    public UpdateAlumniDetailsFAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_update_alumni_details_f_adm, container, false);

        imgVUpdateAlumniDetailFAdm = view.findViewById(R.id.imgVUpdateAlumniDetailFAdm);
        imgVUpdateAlumniDetailFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Alumni Picture"),PICK_IMAGE);
            }
        });




        imgVEditTvNameUpdateAlumniDetailFAdm = view.findViewById(R.id.imgVEditTvNameUpdateAlumniDetailFAdm);
        editTvNameUpdateAlumniDetailFAdm = view.findViewById(R.id.editTvNameUpdateAlumniDetailFAdm);
        editTvNameUpdateAlumniDetailFAdm.setEnabled(false);
        imgVEditTvNameUpdateAlumniDetailFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTvNameUpdateAlumniDetailFAdm.setEnabled(true);
            }
        });



        imgVBatchYrUpdateAlumniDetailFAdm = view.findViewById(R.id.imgVBatchYrUpdateAlumniDetailFAdm);
        editTvBatchYrUpdateAlumniDetailFAdm = view.findViewById(R.id.editTvBatchYrUpdateAlumniDetailFAdm);
        editTvBatchYrUpdateAlumniDetailFAdm.setEnabled(false);
        imgVBatchYrUpdateAlumniDetailFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTvBatchYrUpdateAlumniDetailFAdm.setEnabled(true);
            }
        });


        imgVDeptUpdateAlumniDetailFAdm = view.findViewById(R.id.imgVDeptUpdateAlumniDetailFAdm);
        editTvDeptNameUpdateAlumniDetailFAdm = view.findViewById(R.id.editTvDeptNameUpdateAlumniDetailFAdm);
        editTvDeptNameUpdateAlumniDetailFAdm.setEnabled(false);
        imgVDeptUpdateAlumniDetailFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTvDeptNameUpdateAlumniDetailFAdm.setEnabled(true);
            }
        });


        imgVRegNoUpdateAlumniDetailFAdm = view.findViewById(R.id.imgVRegNoUpdateAlumniDetailFAdm);
        editTvRegNoUpdateAlumniDetailFAdm = view.findViewById(R.id.editTvRegNoUpdateAlumniDetailFAdm);
        editTvRegNoUpdateAlumniDetailFAdm.setEnabled(false);
        imgVRegNoUpdateAlumniDetailFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTvRegNoUpdateAlumniDetailFAdm.setEnabled(true);
            }
        });


//        cancelBtnImgVUpdateAlumniDetailFAdm = view.findViewById(R.id.cancelBtnImgVUpdateAlumniDetailFAdm);
//        cancelBtnImgVUpdateAlumniDetailFAdm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                view.setCancelable(true);
////                view.dismiss();
//            }
//        });

        updateAlumniBtnUpdateAlumniDetailFAdm = view.findViewById(R.id.updateAlumniBtnUpdateAlumniDetailFAdm);
        updateAlumniBtnUpdateAlumniDetailFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });



        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMG && resultCode == RESULT_OK){
            Uri uri = data.getData();
            imgVUpdateAlumniDetailFAdm.setImageURI(uri);
            Log.i("image path ---> ",uri.getPath());
        }
    }
}