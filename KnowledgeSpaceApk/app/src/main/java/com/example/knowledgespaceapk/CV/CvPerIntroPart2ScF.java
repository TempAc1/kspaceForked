package com.example.knowledgespaceapk.CV;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;


public class CvPerIntroPart2ScF extends Fragment {

    private EditText perLang1EditTvCvPerIntroSc,perLang2EditTvCvPerIntroSc,perLang3EditTvCvPerIntroSc,
            perLang4EditTvCvPerIntroSc, per1SkillsEditTvCvPerIntroSc, per2SkillsEditTvCvPerIntroSc,
            per3SkillsEditTvCvPerIntroSc, per4SkillsEditTvCvPerIntroSc, per5SkillsEditTvCvPerIntroSc;

    private Button NxtBtnCvPerIntroPart2Sc;

    private CharacterCountValidator characterCountValidator = new CharacterCountValidator();
    private Drawable drawable;

    public CvPerIntroPart2ScF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cv_per_intro_part2_sc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        drawable = ContextCompat.getDrawable(getContext(),R.drawable.ic_baseline_error_outline_24);
        characterCountValidator.setErrorDrawable(drawable);

        perLang1EditTvCvPerIntroSc = view.findViewById(R.id.perLang1EditTvCvPerIntroSc);
        characterCountValidator.addEditText(perLang1EditTvCvPerIntroSc,20);
        perLang2EditTvCvPerIntroSc = view.findViewById(R.id.perLang2EditTvCvPerIntroSc);
        characterCountValidator.addEditText(perLang2EditTvCvPerIntroSc,20);
        perLang3EditTvCvPerIntroSc = view.findViewById(R.id.perLang3EditTvCvPerIntroSc);
        characterCountValidator.addEditText(perLang3EditTvCvPerIntroSc,20);
        perLang4EditTvCvPerIntroSc = view.findViewById(R.id.perLang4EditTvCvPerIntroSc);
        characterCountValidator.addEditText(perLang4EditTvCvPerIntroSc,20);


        per1SkillsEditTvCvPerIntroSc = view.findViewById(R.id.per1SkillsEditTvCvPerIntroSc);
        characterCountValidator.addEditText(per1SkillsEditTvCvPerIntroSc,20);
        per2SkillsEditTvCvPerIntroSc = view.findViewById(R.id.per2SkillsEditTvCvPerIntroSc);
        characterCountValidator.addEditText(per2SkillsEditTvCvPerIntroSc,20);
        per3SkillsEditTvCvPerIntroSc = view.findViewById(R.id.per3SkillsEditTvCvPerIntroSc);
        characterCountValidator.addEditText(per3SkillsEditTvCvPerIntroSc,20);
        per4SkillsEditTvCvPerIntroSc = view.findViewById(R.id.per4SkillsEditTvCvPerIntroSc);
        characterCountValidator.addEditText(per4SkillsEditTvCvPerIntroSc,20);
        per5SkillsEditTvCvPerIntroSc = view.findViewById(R.id.per5SkillsEditTvCvPerIntroSc);
        characterCountValidator.addEditText(per5SkillsEditTvCvPerIntroSc,20);

        NxtBtnCvPerIntroPart2Sc = view.findViewById(R.id.NxtBtnCvPerIntroPart2Sc);
        NxtBtnCvPerIntroPart2Sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(characterCountValidator.validate()
//                        && validateDataFormat(perLang1EditTvCvPerIntroSc.getText().toString().trim(),
//                        perLang2EditTvCvPerIntroSc.getText().toString().trim(),perLang3EditTvCvPerIntroSc.getText().toString().trim(),
//                        perLang4EditTvCvPerIntroSc.getText().toString().trim(),per1SkillsEditTvCvPerIntroSc.getText().toString().trim(),
//                        per2SkillsEditTvCvPerIntroSc.getText().toString().trim(),per3SkillsEditTvCvPerIntroSc.getText().toString().trim(),
//                        per4SkillsEditTvCvPerIntroSc.getText().toString().trim(),per5SkillsEditTvCvPerIntroSc.getText().toString().trim(),
//                        perLang1EditTvCvPerIntroSc,perLang2EditTvCvPerIntroSc,perLang3EditTvCvPerIntroSc,perLang4EditTvCvPerIntroSc,
//                        per1SkillsEditTvCvPerIntroSc,per2SkillsEditTvCvPerIntroSc,per3SkillsEditTvCvPerIntroSc,per4SkillsEditTvCvPerIntroSc,
//                        per5SkillsEditTvCvPerIntroSc)
                        ) {

                    Bundle b = getArguments();
                    CVPersonalDetails cv = b.getParcelable("userDataIntroSc1");
                    cv.setPerLang1EditTvCvPerIntroSc(perLang1EditTvCvPerIntroSc.getText().toString().trim());
                    cv.setPerLang2EditTvCvPerIntroSc(perLang2EditTvCvPerIntroSc.getText().toString().trim());
                    cv.setPerLang3EditTvCvPerIntroSc(perLang3EditTvCvPerIntroSc.getText().toString().trim());
                    cv.setPerLang4EditTvCvPerIntroSc(perLang4EditTvCvPerIntroSc.getText().toString().trim());

                    cv.setPer1SkillsEditTvCvPerIntroSc(per1SkillsEditTvCvPerIntroSc.getText().toString().trim());
                    cv.setPer2SkillsEditTvCvPerIntroSc(per2SkillsEditTvCvPerIntroSc.getText().toString().trim());
                    cv.setPer3SkillsEditTvCvPerIntroSc(per3SkillsEditTvCvPerIntroSc.getText().toString().trim());
                    cv.setPer4SkillsEditTvCvPerIntroSc(per4SkillsEditTvCvPerIntroSc.getText().toString().trim());
                    cv.setPer5SkillsEditTvCvPerIntroSc(per5SkillsEditTvCvPerIntroSc.getText().toString().trim());


                    b.putParcelable("userDataIntroSc2", cv);

                    navController.navigate(R.id.action_cvPerIntroPart2ScF_to_CV3rdScF,b);
                }
            }
        });


    }

    private boolean validateDataFormat(String perLang1,String perLang2,String perLang3,String perLang4,String skill1,
                                       String skill2,String skill3,String skill4,String skill5,EditText perLang1EditTvCvPerIntroSc,
                                       EditText perLang2EditTvCvPerIntroSc,EditText perLang3EditTvCvPerIntroSc,
                                       EditText perLang4EditTvCvPerIntroSc,EditText per1SkillsEditTvCvPerIntroSc,
                                       EditText per2SkillsEditTvCvPerIntroSc, EditText per3SkillsEditTvCvPerIntroSc,
                                       EditText per4SkillsEditTvCvPerIntroSc,EditText per5SkillsEditTvCvPerIntroSc){

        boolean isValid = true;

        final String DES_REGEX = "^[a-zA-Z\\\\s.,'’]+$";


        // Check for null inputs
        if(TextUtils.isEmpty(perLang1) || TextUtils.isEmpty(perLang2) || TextUtils.isEmpty(perLang3)
                || TextUtils.isEmpty(perLang4)
            || TextUtils.isEmpty(skill1) || TextUtils.isEmpty(skill2) || TextUtils.isEmpty(skill3) ||
                TextUtils.isEmpty(skill4)
                || TextUtils.isEmpty(skill5)){
            characterCountValidator.setErrorDrawable(drawable);
            Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            isValid = false;
        }else{
            //Validate perL1:
            if(!perLang1.matches(DES_REGEX)){
                perLang1EditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate perL2:
            if(!perLang2.matches(DES_REGEX)){
                perLang2EditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate perL3:
            if(!perLang3.matches(DES_REGEX)){
                perLang3EditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate perL4:
            if(!perLang4.matches(DES_REGEX)){
                perLang4EditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }


            //Validate skill1:
            if(!skill1.matches(DES_REGEX)){
                per1SkillsEditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate skill2:
            if(!skill2.matches(DES_REGEX)){
                per2SkillsEditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate skill1:
            if(!skill3.matches(DES_REGEX)){
                per3SkillsEditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate skill1:
            if(!skill4.matches(DES_REGEX)){
                per4SkillsEditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }

            //Validate skill1:
            if(!skill5.matches(DES_REGEX)){
                per5SkillsEditTvCvPerIntroSc.setError("Invalid characters found");
                characterCountValidator.setErrorDrawable(drawable);
                isValid = false;
            }
        }
        return isValid;
    }
}