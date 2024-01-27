package com.example.knowledgespaceapk.CV;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;

import java.util.Calendar;


public class CVPerIntroScF extends Fragment {

    EditText perSummaryEditTvCvPerIntroSc,internshipJobTitleEditTvCvPerIntroScF,internshipJobPeriodEditTvCvPerIntroScF,
            companyNameEditTvCvPerIntroScF,expDescEditTvCvPerIntroScF,currentBranchNameCvPerIntroScF,
            currentInstituteNameCvPerIntroScF,higherSecondarySchoolNameCvPerIntroScF,secondarySchoolNameCvPerIntroScF;

    TextView higherSecondarySchoolYearCvPerIntroScF,secondarySchoolYearCvPerIntroScF;
    private CharacterCountValidator characterCountValidator = new CharacterCountValidator();
    private Drawable drawable;

    public CVPerIntroScF() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_v_per_intro_sc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        drawable = ContextCompat.getDrawable(getContext(),R.drawable.ic_baseline_error_outline_24);
        characterCountValidator.setErrorDrawable(drawable);

        perSummaryEditTvCvPerIntroSc = view.findViewById(R.id.perSummaryEditTvCvPerIntroSc);
        characterCountValidator.addEditText(perSummaryEditTvCvPerIntroSc,214);
        internshipJobTitleEditTvCvPerIntroScF = view.findViewById(R.id.internshipJobTitleEditTvCvPerIntroScF);
        characterCountValidator.addEditText(internshipJobTitleEditTvCvPerIntroScF,50);
        internshipJobPeriodEditTvCvPerIntroScF = view.findViewById(R.id.internshipJobPeriodEditTvCvPerIntroScF);
        characterCountValidator.addEditText(internshipJobPeriodEditTvCvPerIntroScF,3);
        companyNameEditTvCvPerIntroScF = view.findViewById(R.id.companyNameEditTvCvPerIntroScF);
        characterCountValidator.addEditText(companyNameEditTvCvPerIntroScF,50);
        expDescEditTvCvPerIntroScF = view.findViewById(R.id.expDescEditTvCvPerIntroScF);
        characterCountValidator.addEditText(expDescEditTvCvPerIntroScF,150);

        higherSecondarySchoolNameCvPerIntroScF = view.findViewById(R.id.higherSecondarySchoolNameCvPerIntroScF);
        characterCountValidator.addEditText(higherSecondarySchoolNameCvPerIntroScF,40);
        secondarySchoolNameCvPerIntroScF = view.findViewById(R.id.secondarySchoolNameCvPerIntroScF);
        characterCountValidator.addEditText(secondarySchoolNameCvPerIntroScF,40);
        currentBranchNameCvPerIntroScF = view.findViewById(R.id.currentBranchNameCvPerIntroScF);
        characterCountValidator.addEditText(currentBranchNameCvPerIntroScF,40);
        currentInstituteNameCvPerIntroScF = view.findViewById(R.id.currentInstituteNameCvPerIntroScF);
        characterCountValidator.addEditText(currentInstituteNameCvPerIntroScF,40);

        higherSecondarySchoolYearCvPerIntroScF = view.findViewById(R.id.higherSecondarySchoolYearCvPerIntroScF);
        higherSecondarySchoolYearCvPerIntroScF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickYear(higherSecondarySchoolYearCvPerIntroScF);
            }
        });
        secondarySchoolYearCvPerIntroScF = view.findViewById(R.id.secondarySchoolYearCvPerIntroScF);
        secondarySchoolYearCvPerIntroScF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickYear(secondarySchoolYearCvPerIntroScF);
            }
        });


//        characterCountValidator(perSummaryEditTvCvPerIntroSc,214);
//        EditText perExperienceEditTvCvPerIntroSc = view.findViewById(R.id.perExperienceEditTvCvPerIntroSc);
//        EditText perEducationEditTvCvPerIntroSc = view.findViewById(R.id.perEducationEditTvCvPerIntroSc);


        Button NxtBtnCvPerIntroSc = view.findViewById(R.id.NxtBtnCvPerIntroSc);
        NxtBtnCvPerIntroSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = getArguments();
                CVPersonalDetails cv = b.getParcelable("userDataSc1");

                if(characterCountValidator.validate()
//                        && validateUserData(
//                        perSummaryEditTvCvPerIntroSc.getText().toString().trim(),
//                        internshipJobTitleEditTvCvPerIntroScF.getText().toString().trim(),
//                        internshipJobPeriodEditTvCvPerIntroScF.getText().toString().trim(),
//                        companyNameEditTvCvPerIntroScF.getText().toString().trim(),
//                        expDescEditTvCvPerIntroScF.getText().toString().trim(),
//                        currentBranchNameCvPerIntroScF.getText().toString().trim(),
//                        currentInstituteNameCvPerIntroScF.getText().toString().trim(),
//                        higherSecondarySchoolNameCvPerIntroScF.getText().toString().trim(),
//                        secondarySchoolNameCvPerIntroScF.getText().toString().trim(),
//                        perSummaryEditTvCvPerIntroSc,internshipJobTitleEditTvCvPerIntroScF,
//                        internshipJobPeriodEditTvCvPerIntroScF,companyNameEditTvCvPerIntroScF,
//                        expDescEditTvCvPerIntroScF,currentBranchNameCvPerIntroScF,
//                        currentInstituteNameCvPerIntroScF,higherSecondarySchoolNameCvPerIntroScF,
//                        secondarySchoolNameCvPerIntroScF)) {
                ){


//                Log.i("uName------>>>>>>>>>",cv.getpNameEditTvCvMainScF());
                    cv.setPerSummaryEditTvCvPerIntroSc(perSummaryEditTvCvPerIntroSc.getText().toString().trim());
                    cv.setInternshipJobTitleEditTvCvPerIntroScF(internshipJobTitleEditTvCvPerIntroScF.getText().toString().trim());
                    cv.setInternshipJobPeriodEditTvCvPerIntroScF(internshipJobPeriodEditTvCvPerIntroScF.getText().toString().trim());
                    cv.setCompanyNameEditTvCvPerIntroScF(companyNameEditTvCvPerIntroScF.getText().toString().trim());
                    cv.setExpDescEditTvCvPerIntroScF(expDescEditTvCvPerIntroScF.getText().toString().trim());
                    cv.setCurrentBranchNameCvPerIntroScF(currentBranchNameCvPerIntroScF.getText().toString().trim());
                    cv.setCurrentInstituteNameCvPerIntroScF(currentInstituteNameCvPerIntroScF.getText().toString().trim());
                    cv.setHigherSecondarySchoolNameCvPerIntroScF(higherSecondarySchoolNameCvPerIntroScF.getText().toString().trim());
                    cv.setHigherSecondarySchoolYearCvPerIntroScF(Integer.parseInt(higherSecondarySchoolYearCvPerIntroScF.getText().toString().trim()));
                    cv.setSecondarySchoolNameCvPerIntroScF(secondarySchoolNameCvPerIntroScF.getText().toString().trim());
                    cv.setSecondarySchoolYearCvPerIntroScF(Integer.parseInt(secondarySchoolYearCvPerIntroScF.getText().toString().trim()));

//                Log.i("hobbies", cv.getPer1stHobbiesEditTvCvPerIntroSc());

                    b.putParcelable("userDataIntroSc1", cv);


                    navController.navigate(R.id.action_CVPerIntroScF_to_cvPerIntroPart2ScF, b);
                }
            }
        });

    }



    private boolean validateUserData(String summary, String internshipJobTitleEditTvCvPerIntroScF,
                                     String internshipJobPeriodEditTvCvPerIntroScF, String companyNameEditTvCvPerIntroScF,
                                     String expDescEditTvCvPerIntroScF,String currentBranchNameCvPerIntroScF,
                                     String currentInstituteNameCvPerIntroScF,String higherSecondarySchoolNameCvPerIntroScF,
                                     String secondarySchoolNameCvPerIntroScF,
                                     EditText summaryETv, EditText internshipJobTitleEditTvCvPerIntroScFETv,
                                     EditText internshipJobPeriodEditTvCvPerIntroScFETv,
                                     EditText companyNameEditTvCvPerIntroScFEdTv,
                                     EditText expDescEditTvCvPerIntroScFEdTv,
                                     EditText currentBranchNameCvPerIntroScFEdTv,EditText currentInstituteNameCvPerIntroScFEdTv,
                                     EditText higherSecondarySchoolNameCvPerIntroScFEdTv,
                                     EditText secondarySchoolNameCvPerIntroScFEdTv) {

        boolean isValid = true;

        final String DES_REGEX = "^[a-zA-Z\\\\s\\\\-\\\\.,']+$";
        final String TITLE_NAME_REGEX = "^[\\p{L} .'-]+$";



        // Check for null inputs
        if (TextUtils.isEmpty(summary)  || TextUtils.isEmpty(internshipJobTitleEditTvCvPerIntroScF)  ||
                TextUtils.isEmpty(internshipJobPeriodEditTvCvPerIntroScF)
                || TextUtils.isEmpty(companyNameEditTvCvPerIntroScF)
                || TextUtils.isEmpty(expDescEditTvCvPerIntroScF)
                || TextUtils.isEmpty(currentBranchNameCvPerIntroScF)
                ||TextUtils.isEmpty(currentInstituteNameCvPerIntroScF)
                || TextUtils.isEmpty(higherSecondarySchoolNameCvPerIntroScF) ) {
            Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            isValid = false;
        }else{

            // Validate summary
            if (!summary.matches(DES_REGEX)) {
                summaryETv.setError("Invalid name format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            // Validate internshipJobTitleEditTvCvPerIntroScF
            if (!internshipJobTitleEditTvCvPerIntroScF.matches(TITLE_NAME_REGEX)) {
                internshipJobTitleEditTvCvPerIntroScFETv.setError("Invalid format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            // Validate internshipJobPeriodEditTvCvPerIntroScF
            if (!internshipJobPeriodEditTvCvPerIntroScF.matches("^(1[0-2]|[1-9])$")) {
                internshipJobPeriodEditTvCvPerIntroScFETv.setError("Invalid period format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            // Validate companyNameEditTvCvPerIntroScF
            if (!companyNameEditTvCvPerIntroScF.matches(TITLE_NAME_REGEX)) {
                companyNameEditTvCvPerIntroScFEdTv.setError("Invalid format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate Company Desc
            if(!expDescEditTvCvPerIntroScF.matches(DES_REGEX)){
                expDescEditTvCvPerIntroScFEdTv.setError("Invalid format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate currentBranchNameCvPerIntroScF
            if(!currentBranchNameCvPerIntroScF.matches(TITLE_NAME_REGEX)){
                currentBranchNameCvPerIntroScFEdTv.setError("Invalid format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate currentInstituteNameCvPerIntroScF
            if(!currentInstituteNameCvPerIntroScF.matches(TITLE_NAME_REGEX)){
                currentInstituteNameCvPerIntroScFEdTv.setError("Invalid format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate higherSecondarySchoolNameCvPerIntroScF
            if(!higherSecondarySchoolNameCvPerIntroScF.matches(TITLE_NAME_REGEX)){
                higherSecondarySchoolNameCvPerIntroScFEdTv.setError("Invalid format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate secondarySchoolNameCvPerIntroScF
            if(!secondarySchoolNameCvPerIntroScF.matches(TITLE_NAME_REGEX)){
                secondarySchoolNameCvPerIntroScFEdTv.setError("Invalid format");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }
        }

        return isValid;
    }



    private void pickYear(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_dialog_yearpicker);
        // Set the dialog window width to match parent
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        dialog.setTitle("Select Year");
        // Find the NumberPicker and set its properties
        final NumberPicker yearPicker = dialog.findViewById(R.id.yearPicker);
        yearPicker.setWrapSelectorWheel(false);
        yearPicker.setMinValue(1980);
        yearPicker.setMaxValue(year);
        yearPicker.setValue(year);
        // Find the OK button and set its click listener
        Button okButton = dialog.findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected year and set it in the TextView
                int year = yearPicker.getValue();
                textView.setText(String.valueOf(year));

                // Dismiss the dialog
                dialog.dismiss();
            }
        });

        // Show the dialog
        dialog.show();


    }





}//End Main