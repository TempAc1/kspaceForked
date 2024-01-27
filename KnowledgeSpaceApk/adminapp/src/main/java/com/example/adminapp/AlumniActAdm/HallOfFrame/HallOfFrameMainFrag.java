package com.example.adminapp.AlumniActAdm.HallOfFrame;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender;
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
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.PreviousYrHoFMainScFrag;
import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;


public class HallOfFrameMainFrag extends Fragment {
    private static final int  PICK_IMAGE = 301 ;
    private ArrayList<DataModelHallOfFrame> dataHolder;
    private AdapterViewFlipper adapterViewFlipper;
    private FloatingActionButton floatingBtnAddHoF;
    private RelativeLayout relativeLayContainerImgNNameVPopUpDialogAddHof;
    private Button viewAllAlumniTvHallOfFrameMainActAdm;

    //Dialog Box:
    private EditText totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr;
    private TextView selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr;
    private Button proceedNxtBtnPopupAskAdmAddHofNoOfAlumnisNYrAdm;
    private ImageView cancelBtnPopupDialogAddHof;

    //Dialog Box Add Alumni Details:
    private TextView tvShowAlumniCountPopupDialogAddHofAdm,yesBtnTvPopupSavingDataPopupDialog,NoTvPopupConfirmSavingData;
    private EditText editTvAlumniNamePopupDialogAddHofAdm;
    private Button addNxtAlumniBtnPopupDialogAddHoFAdm,finalAddAlumniBtnPopupDialogAddHof;
    private ImageView addAlumniImgVPopupDialogAddHof,cancelBtnPopupDialogFinalAddHof;
    private int currentCountOfAlumniHoF = 1;
    private Uri uri;
    private LinearLayout linearLayConfirmSavingDataPopupDialogAddHof;




    public HallOfFrameMainFrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_hall_of_frame_main, container, false);
        adapterViewFlipper = view.findViewById(R.id.adapterViewFlipper);
        dataHolder = new ArrayList<>();
        addData();
        adapterViewFlipper.setAdapter(new HallofframeadmAdp(dataHolder));
        adapterViewFlipper.setFlipInterval(2600);
        adapterViewFlipper.setAutoStart(true);

        viewAllAlumniTvHallOfFrameMainActAdm = view.findViewById(R.id.viewAllAlumniTvHallOfFrameMainActAdm);
        viewAllAlumniTvHallOfFrameMainActAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FrameLayout frameLayout = activity.findViewById(R.id.frameLayHallOfFrameMainSc);
                frameLayout.removeAllViews();
                Fragment fragment = new PreviousYrHoFMainScFrag();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayHallOfFrameMainSc,fragment).commit();
                fragmentTransaction.addToBackStack(String.valueOf(R.layout.fragment_hall_of_frame_main));

            }
        });

        floatingBtnAddHoF = view.findViewById(R.id.floatingBtnAddHoF);
        floatingBtnAddHoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopUpAskAdmAddHof();
            }
        });

        return view;
    }

    private void openPopUpAskAdmAddHof() {
//        scrollViewHoFMainAdm.setVisibility(View.GONE);

        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.popup_askadm_addhof_noofalumnis_n_yr);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(false);
      //  dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr = dialog.findViewById(R.id.totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr);

        //Todo datapicker me bas year show krna hai + noOfAlumnis me make sure sahi no enter ho see diary 4 more details
        selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr = dialog.findViewById(R.id.selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr);
        selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(dialog.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr.setText(year);
                    }
                },year,month,dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });


        proceedNxtBtnPopupAskAdmAddHofNoOfAlumnisNYrAdm = dialog.findViewById(R.id.proceedNxtBtnPopupAskAdmAddHofNoOfAlumnisNYrAdm);
        proceedNxtBtnPopupAskAdmAddHofNoOfAlumnisNYrAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopUpAddHof();
                Log.i("No of alumis ---> ", totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr.getText().toString().trim());
                Toast.makeText(dialog.getContext(), "Saving...without backend", Toast.LENGTH_SHORT).show();
                dialog.setCancelable(true);dialog.dismiss();
//                scrollViewHoFMainAdm.setVisibility(View.VISIBLE);
            }
        });

        cancelBtnPopupDialogAddHof = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);
        cancelBtnPopupDialogAddHof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setCancelable(true);dialog.dismiss();
//                scrollViewHoFMainAdm.setVisibility(View.VISIBLE);
            }
        });


        dialog.show();

    }

    private void openPopUpAddHof() {

        ArrayList<Uri> alumniHoFImgs = new ArrayList<Uri>();
        ArrayList<String> alumniHoFNames = new ArrayList<String>();
        int totalAlumnisToAdd = Integer.parseInt(totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr.getText().toString().trim());
        Log.i("prev dialog inou---> ", String.valueOf(totalAlumnisToAdd));
        String setTvFormat = "/";


        //Todo yr v save kr lo jo same hai for all from prev dialog n check for try n catch error while str to int conversion
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.popupdialog_add_hof);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(false);
        //  dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        yesBtnTvPopupSavingDataPopupDialog = dialog.findViewById(R.id.yesBtnTvPopupSavingDataPopupDialog);
        NoTvPopupConfirmSavingData = dialog.findViewById(R.id.NoTvPopupConfirmSavingData);
        linearLayConfirmSavingDataPopupDialogAddHof = dialog.findViewById(R.id.linearLayConfirmSavingDataPopupDialogAddHof);
        linearLayConfirmSavingDataPopupDialogAddHof.setVisibility(View.GONE);
        relativeLayContainerImgNNameVPopUpDialogAddHof = dialog.findViewById(R.id.relativeLayContainerImgNNameVPopUpDialogAddHof);
        addNxtAlumniBtnPopupDialogAddHoFAdm = dialog.findViewById(R.id.addNxtAlumniBtnPopupDialogAddHoFAdm);
        tvShowAlumniCountPopupDialogAddHofAdm = dialog.findViewById(R.id.tvShowAlumniCountPopupDialogAddHofAdm);
        tvShowAlumniCountPopupDialogAddHofAdm.setText(new StringBuilder().append("1").append(setTvFormat).append(totalAlumnisToAdd).toString());

        finalAddAlumniBtnPopupDialogAddHof = dialog.findViewById(R.id.finalAddAlumniBtnPopupDialogAddHof);
       // Log.i("new dialog --->", totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr.getText().toString().trim());
        addAlumniImgVPopupDialogAddHof = dialog.findViewById(R.id.addAlumniImgVPopupDialogAddHof);
        addAlumniImgVPopupDialogAddHof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"Select Picture"),PICK_IMAGE);
            }
        });

        editTvAlumniNamePopupDialogAddHofAdm = dialog.findViewById(R.id.editTvAlumniNamePopupDialogAddHofAdm);
        editTvAlumniNamePopupDialogAddHofAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        addNxtAlumniBtnPopupDialogAddHoFAdm = dialog.findViewById(R.id.addNxtAlumniBtnPopupDialogAddHoFAdm);
        addNxtAlumniBtnPopupDialogAddHoFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNUpdateDialogData();
            }
            private void saveNUpdateDialogData() {
                //phle to text n img ka no update hoga n dusra dialog clear ho for new entry n data save rhega local me
                // till the end to send to server
                tvShowAlumniCountPopupDialogAddHofAdm.setText(new StringBuilder().append(currentCountOfAlumniHoF).append(setTvFormat).append(totalAlumnisToAdd).toString());
                if(currentCountOfAlumniHoF<totalAlumnisToAdd){
                    currentCountOfAlumniHoF++;
                    if(currentCountOfAlumniHoF == totalAlumnisToAdd){
                        alumniHoFNames.add(editTvAlumniNamePopupDialogAddHofAdm.getText().toString().trim());
                        alumniHoFImgs.add(Uri.parse(uri.getPath()));
                    }
                    alumniHoFNames.add(editTvAlumniNamePopupDialogAddHofAdm.getText().toString().trim());
                    alumniHoFImgs.add(Uri.parse(uri.getPath()));

                }else{
                    //Todo bahar aojao save kro data send kro
                    Log.i(TAG, "else block executed");
//                    scrollViewHoFMainAdm.setVisibility(View.GONE);
                    relativeLayContainerImgNNameVPopUpDialogAddHof.setVisibility(View.GONE);
                    addNxtAlumniBtnPopupDialogAddHoFAdm.setVisibility(View.GONE);
                    tvShowAlumniCountPopupDialogAddHofAdm.setVisibility(View.GONE);
                    linearLayConfirmSavingDataPopupDialogAddHof.setVisibility(View.VISIBLE);
//                    finalAddAlumniBtnPopupDialogAddHof.setVisibility(View.VISIBLE);
                    yesBtnTvPopupSavingDataPopupDialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(dialog.getContext(), "Yes Clicked", Toast.LENGTH_SHORT).show();
                            dialog.setCancelable(true);dialog.dismiss();
                        }
                    });
                    NoTvPopupConfirmSavingData.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(dialog.getContext(), "No", Toast.LENGTH_SHORT).show();
                            dialog.setCancelable(true);dialog.dismiss();
                        }
                    });
//                        openConfirmSavingDataPopupDialog();
                    //Todo sendDataToServer();
                    }
                //Todo check kar lena imgv wala default img save nahi ho raha ho db me
                editTvAlumniNamePopupDialogAddHofAdm.getText().clear();
                addAlumniImgVPopupDialogAddHof.setImageResource(R.drawable.ic_baseline_account_circle_24);
            }

//            private void openConfirmSavingDataPopupDialog() {
//                Dialog dialog = new Dialog(getContext());
//                dialog.setContentView(R.layout.confirm_savingdata_popupdialog);
//                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//                dialog.setCancelable(false);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
//
//
//                yesBtnTvPopupSavingDataPopupDialog = dialog.findViewById(R.id.yesBtnTvPopupSavingDataPopupDialog);
//                NoTvPopupConfirmSavingData = dialog.findViewById(R.id.NoTvPopupConfirmSavingData);
//
//                //Todo Send Data To Server
//
//                yesBtnTvPopupSavingDataPopupDialog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(dialog.getContext(), "Yes Clicked", Toast.LENGTH_SHORT).show();
//                        dialog.setCancelable(true);dialog.dismiss();
//
//                    }
//                });
//
//                NoTvPopupConfirmSavingData.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(dialog.getContext(), "No", Toast.LENGTH_SHORT).show();
//                        dialog.setCancelable(true);dialog.dismiss();
//                    }
//                });
//
//                dialog.show();
//            }
        });

        finalAddAlumniBtnPopupDialogAddHof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(dialog.getContext(), "Saving Info...without backend", Toast.LENGTH_SHORT).show();
                dialog.setCancelable(true);dialog.dismiss();
            }
        });

        cancelBtnPopupDialogFinalAddHof = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);
        cancelBtnPopupDialogFinalAddHof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setCancelable(true);dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            uri = data.getData();
            addAlumniImgVPopupDialogAddHof.setImageURI(uri);
            Log.i("image path ---> ",uri.getPath());
        }
    }

    private void addData() {
        DataModelHallOfFrame card1 = new DataModelHallOfFrame(R.drawable.apple,"apple");
        dataHolder.add(card1);
        DataModelHallOfFrame card2 = new DataModelHallOfFrame(R.drawable.banana,"banana");
        dataHolder.add(card2);
        dataHolder.add(card1);
    }
}