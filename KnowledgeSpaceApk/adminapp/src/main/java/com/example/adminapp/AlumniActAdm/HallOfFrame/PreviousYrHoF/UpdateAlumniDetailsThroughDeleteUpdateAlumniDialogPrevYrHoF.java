package com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adminapp.R;


public class UpdateAlumniDetailsThroughDeleteUpdateAlumniDialogPrevYrHoF extends Fragment {


    private ImageView imgVEditTvNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof,imgVEditTvDeptNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof,
            imgVEditTvSocialLinkEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof,alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof;
    private EditText alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof,alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof,
            alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof;
    private Button updateBtnDialogAlumniDetailsPrevyrHoF;
    private static final int PICK_IMG_UPDATE_DIALOG_PREVYR = 1;

    public UpdateAlumniDetailsThroughDeleteUpdateAlumniDialogPrevYrHoF() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_update_alumni_details_through_delete_update_alumni_dialog_prev_yr_ho, container, false);


        updateBtnDialogAlumniDetailsPrevyrHoF = view.findViewById(R.id.updateBtnDialogAlumniDetailsPrevyrHoF);

        imgVEditTvNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof = view.findViewById(R.id.imgVEditTvNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof);
        alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof =view.findViewById(R.id.alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof);
        imgVEditTvNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setEnabled(true);
                alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setFocusable(true);
                alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setCursorVisible(true);
                //Todo
            }
        });

        imgVEditTvDeptNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof = view.findViewById(R.id.imgVEditTvDeptNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof);
        alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof = view.findViewById(R.id.alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof);
        imgVEditTvDeptNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setEnabled(true);
                alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setFocusable(true);
                alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setCursorVisible(true);
            }
        });

        imgVEditTvSocialLinkEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof = view.findViewById(R.id.imgVEditTvSocialLinkEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof);
        alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof = view.findViewById(R.id.alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof);
        imgVEditTvSocialLinkEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setEnabled(true);
                alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setFocusable(true);
                alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setCursorVisible(true);

            }
        });

        updateBtnDialogAlumniDetailsPrevyrHoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "Closing Without backend", Toast.LENGTH_SHORT).show();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FrameLayout fl = activity.findViewById(R.id.frameLayUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof);
                fl.removeAllViews();
                Fragment fragment = new PreviousYrHoFMainScFrag();
                FragmentManager manager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayPrevYrHoFMainSc,fragment).commit();
                fragmentTransaction.disallowAddToBackStack();

            }
        });

        //Handle ImgV Intent:
        alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof = view.findViewById(R.id.alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof);
        alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selectImgIntent = new Intent();
                selectImgIntent.setType("image/*");
                selectImgIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(selectImgIntent,"Select Picture"),PICK_IMG_UPDATE_DIALOG_PREVYR);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMG_UPDATE_DIALOG_PREVYR && resultCode == RESULT_OK){
            try{
                Uri uri = data.getData();
                alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof.setImageURI(uri);
                Log.i(TAG, uri.getPath());
            }catch (Exception e){
                Toast.makeText(getContext(), "Could not fetch image", Toast.LENGTH_SHORT).show();
            }
        }
        Log.i(TAG, "hii");
    }
}