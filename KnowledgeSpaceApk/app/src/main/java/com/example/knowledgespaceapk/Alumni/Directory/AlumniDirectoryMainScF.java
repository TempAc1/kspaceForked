package com.example.knowledgespaceapk.Alumni.Directory;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AlumniDirectoryMainScF extends Fragment {

    //Mine Declarations:
    private EditText editTextTextPersonNameAlumniDirectoryMainScF,editTvBatchYrAlumniDirMainScF,
            editTvDeptNameAlumniDirMainScF,editTvRegNoAlumniDirMainScF;
    private Button searchBtnAlumniDirectoryMainScF;
    private EditText editTextTextPersonNameAddCusDialogAlumniDirectoryF,editTvBatchYrCusDialogAlumniDirMainScF,
            editTvDeptNameCusDialogAlumniDirMainScF,editTvRegNoCusDialogAlumniDirMainScF;
    private Button addAlumniBtnCusDialogAlumniDirF;
    private ImageView imgVCusDialogAddAlumniDirF,cancelBtnImgVCusDiaAddAlumniDirF,cancelBtnImgVCusDiaAskinAlumniAddF;
    int RESULT_LOAD_IMAGE = 100;
    private TextView batchTvAskinAddInBatchOrSingleAlumniDialog,singleTvAskinAddInBatchOrSingleAlumniDialog;

    public AlumniDirectoryMainScF() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_alumni_directory_main_sc, container, false);

        editTextTextPersonNameAlumniDirectoryMainScF = view.findViewById(R.id.editTvNameCusDialogAddAlumniF);
        editTvBatchYrAlumniDirMainScF = view.findViewById(R.id.editTvBatchYrCusDialogAlumniDirMainScF);
        editTvDeptNameAlumniDirMainScF = view.findViewById(R.id.editTvDeptNameCusDialogAlumniDirMainScF);
        editTvRegNoAlumniDirMainScF = view.findViewById(R.id.editTvRegNoCusDialogAlumniDirMainScF);





        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        searchBtnAlumniDirectoryMainScF = view.findViewById(R.id.searchBtnAlumniDirectoryMainScF);
        searchBtnAlumniDirectoryMainScF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_alumniDirectoryMainScF_to_alumniSearchResultF);
            }
        });

    }

    //    private void openAddAlumniDialog() {
//        Dialog dialog = new Dialog(getActivity());
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.dialog_askadmin_add_in_batchorsingle_alumni);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
//
//        batchTvAskAdminAddInBatchOrSingleAlumniDialog = dialog.findViewById(R.id.batchTvAskAdminAddInBatchOrSingleAlumniDialog);
//        batchTvAskinAddInBatchOrSingleAlumniDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openBatchAddAlumniDialog();
//                dialog.setCancelable(true);dialog.dismiss();
//            }
//        });
//
//        singleTvAskAdminAddInBatchOrSingleAlumniDialog = dialog.findViewById(R.id.singleTvAskAdminAddInBatchOrSingleAlumniDialog);
//        singleTvAskinAddInBatchOrSingleAlumniDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openSingularAddAlumniDialog();dialog.setCancelable(true);dialog.dismiss();
//            }
//        });
//
//        cancelBtnImgVCusDiaAskAdminAlumniAddF = dialog.findViewById(R.id.cancelBtnImgVCusDiaAskAdminAlumniAddF);
//        cancelBtnImgVCusDiaAddAlumniDirF.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setCancelable(true);dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
//
//    private void openSingularAddAlumniDialog() {
//        Dialog dialog = new Dialog(getActivity());
//        dialog.setCancelable(false);
//        dialog.setContentView(R.layout.dialog_add_alumni_dir_f_adm);
//        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
//
//        editTextTextPersonNameAddCusDialogAlumniDirectoryF = dialog.findViewById(R.id.editTvNameCusDialogAddAlumniF);
//        editTvBatchYrCusDialogAlumniDirMainScF = dialog.findViewById(R.id.editTvBatchYrCusDialogAlumniDirMainScF);
//        editTvRegNoCusDialogAlumniDirMainScF = dialog.findViewById(R.id.editTvRegNoCusDialogAlumniDirMainScF);
//        editTvDeptNameCusDialogAlumniDirMainScF = dialog.findViewById(R.id.editTvDeptNameCusDialogAlumniDirMainScF);
//
//        imgVCusDialogAddAlumniDirF = dialog.findViewById(R.id.imgVCusDialogAddAlumniDirF);
//        imgVCusDialogAddAlumniDirF.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(i, RESULT_LOAD_IMAGE);
//            }
//        });
//
//        cancelBtnImgVCusDiaAddAlumniDirF = dialog.findViewById(R.id.cancelBtnImgVCusDiaAskAdminAlumniAddF);
//        cancelBtnImgVCusDiaAddAlumniDirF.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.setCancelable(true);dialog.dismiss();
//            }
//        });
//
//        addAlumniBtnCusDialogAlumniDirF = dialog.findViewById(R.id.addAlumniBtnCusDialogAlumniDirF);
//        addAlumniBtnCusDialogAlumniDirF.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Added without backend", Toast.LENGTH_SHORT).show();
//                dialog.setCancelable(true);dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//
//    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK){
            Uri uri = data.getData();
            imgVCusDialogAddAlumniDirF.setImageURI(uri);
            Log.i("image path ---> ",uri.getPath());
        }
    }
}