package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlumniDirectoryMainScFAdm#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlumniDirectoryMainScFAdm extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Mine Declarations:
    private EditText editTextTextPersonNameAlumniDirectoryMainScFAdm,editTvBatchYrAlumniDirMainScFAdm,
            editTvDeptNameAlumniDirMainScFAdm,editTvRegNoAlumniDirMainScFAdm;
    private Button searchBtnAlumniDirectoryMainScFAdm;
    private FloatingActionButton floatingBtnAddAlumniAlumniDirMainScFAdm;
    private EditText editTextTextPersonNameAddCusDialogAlumniDirectoryFAdm,editTvBatchYrCusDialogAlumniDirMainScFAdm,
            editTvDeptNameCusDialogAlumniDirMainScFAdm,editTvRegNoCusDialogAlumniDirMainScFAdm;
    private Button addAlumniBtnCusDialogAlumniDirFAdm;
    private ImageView imgVCusDialogAddAlumniDirFAdm,cancelBtnImgVCusDiaAddAlumniDirFAdm,cancelBtnImgVCusDiaAskAdminAlumniAddFAdm;
    int RESULT_LOAD_IMAGE = 100;
    private TextView batchTvAskAdminAddInBatchOrSingleAlumniDialog,singleTvAskAdminAddInBatchOrSingleAlumniDialog;

    public AlumniDirectoryMainScFAdm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlumniDirectoryMainScFAdm.
     */
    // TODO: Rename and change types and number of parameters
    public static AlumniDirectoryMainScFAdm newInstance(String param1, String param2) {
        AlumniDirectoryMainScFAdm fragment = new AlumniDirectoryMainScFAdm();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_alumni_directory_main_sc_f_adm, container, false);

        editTextTextPersonNameAlumniDirectoryMainScFAdm = view.findViewById(R.id.editTvNameCusDialogAddAlumniFAdm);
        editTvBatchYrAlumniDirMainScFAdm = view.findViewById(R.id.editTvBatchYrCusDialogAlumniDirMainScFAdm);
        editTvDeptNameAlumniDirMainScFAdm = view.findViewById(R.id.editTvDeptNameCusDialogAlumniDirMainScFAdm);
        editTvRegNoAlumniDirMainScFAdm = view.findViewById(R.id.editTvRegNoCusDialogAlumniDirMainScFAdm);

        searchBtnAlumniDirectoryMainScFAdm = view.findViewById(R.id.searchBtnAlumniDirectoryMainScFAdm);
        searchBtnAlumniDirectoryMainScFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Opening without backend", Toast.LENGTH_SHORT).show();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FrameLayout fl = activity.findViewById(R.id.frameLayAlumniFragHomeSc);
                fl.removeAllViews();
                Fragment fragment = new AlumniSearchResultFAdm();
                FragmentManager manager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayAlumniFragHomeSc,fragment).commit();
                fragmentTransaction.addToBackStack(String.valueOf(R.layout.fragment_alumni_frag_home_sc));
            }
        });

        floatingBtnAddAlumniAlumniDirMainScFAdm = view.findViewById(R.id.floatingBtnAddAlumniAlumniDirMainScFAdm);
        floatingBtnAddAlumniAlumniDirMainScFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddAlumniDialog();
            }
        });



        return view;
    }

    private void openAddAlumniDialog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_askadmin_add_in_batchorsingle_alumni);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        batchTvAskAdminAddInBatchOrSingleAlumniDialog = dialog.findViewById(R.id.batchTvAskAdminAddInBatchOrSingleAlumniDialog);
        batchTvAskAdminAddInBatchOrSingleAlumniDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBatchAddAlumniDialog();
                dialog.setCancelable(true);dialog.dismiss();
            }
        });

        singleTvAskAdminAddInBatchOrSingleAlumniDialog = dialog.findViewById(R.id.singleTvAskAdminAddInBatchOrSingleAlumniDialog);
        singleTvAskAdminAddInBatchOrSingleAlumniDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSingularAddAlumniDialog();dialog.setCancelable(true);dialog.dismiss();
            }
        });

        cancelBtnImgVCusDiaAskAdminAlumniAddFAdm = dialog.findViewById(R.id.cancelBtnImgVCusDiaAskAdminAlumniAddFAdm);
        cancelBtnImgVCusDiaAskAdminAlumniAddFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setCancelable(true);dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void openBatchAddAlumniDialog() {
    }

    private void openSingularAddAlumniDialog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_add_alumni_dir_f_adm);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        editTextTextPersonNameAddCusDialogAlumniDirectoryFAdm = dialog.findViewById(R.id.editTvNameCusDialogAddAlumniFAdm);
        editTvBatchYrCusDialogAlumniDirMainScFAdm = dialog.findViewById(R.id.editTvBatchYrCusDialogAlumniDirMainScFAdm);
        editTvRegNoCusDialogAlumniDirMainScFAdm = dialog.findViewById(R.id.editTvRegNoCusDialogAlumniDirMainScFAdm);
        editTvDeptNameCusDialogAlumniDirMainScFAdm = dialog.findViewById(R.id.editTvDeptNameCusDialogAlumniDirMainScFAdm);

        imgVCusDialogAddAlumniDirFAdm = dialog.findViewById(R.id.imgVCusDialogAddAlumniDirFAdm);
        imgVCusDialogAddAlumniDirFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        cancelBtnImgVCusDiaAddAlumniDirFAdm = dialog.findViewById(R.id.cancelBtnImgVCusDiaAskAdminAlumniAddFAdm);
        cancelBtnImgVCusDiaAddAlumniDirFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setCancelable(true);dialog.dismiss();
            }
        });

        addAlumniBtnCusDialogAlumniDirFAdm = dialog.findViewById(R.id.addAlumniBtnCusDialogAlumniDirFAdm);
        addAlumniBtnCusDialogAlumniDirFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Added without backend", Toast.LENGTH_SHORT).show();
                dialog.setCancelable(true);dialog.dismiss();
            }
        });

        dialog.show();

    }
    //TODO editext ka value save karna hai backend me av kch v save nahi ho raha h
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK){
            Uri uri = data.getData();
            imgVCusDialogAddAlumniDirFAdm.setImageURI(uri);
            Log.i("image path ---> ",uri.getPath());
        }
    }
}