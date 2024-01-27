package com.example.adminapp.GroupFragAdm.GrpQuizesAdm;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Trace;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.GroupFragAdm.GroupOverviewFragGrpAdm;
import com.example.adminapp.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;


public class AddQuizQuesFAdm extends Fragment {

    private Chip checkBox1AddQuizQuesFAdm,checkBox2AddQuizQuesFAdm,checkBox3AddQuizQuesFAdm,checkBox4AddQuizQuesFAdm;
    private ChipGroup chip_group_add_quiz_ques;
    private String tag;
    private Button imgBtnSetNextQues,closeFragBtnAddQuizQuesFAdm;
    private TextView questionNoTvAddQuizQuesFAdm;
    private EditText EnterQuesEditTvAddQuizQuesFAdm,opt1TvAddQuizQuesFAdm,opt2TvAddQuizQuesFAdm,opt3TvAddQuizQuesFAdm,opt4TvAddQuizQuesFAdm;
    private String correctAnsString ="Not defined",question="Not defined";
    private Boolean isChipSelected = false;
    private boolean[] counterClicked = new boolean[1];
    private String getTotalDuration,getTotalQues;
    private int totalQuesCounter,currentQuesCounter=1;


    public AddQuizQuesFAdm() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_add_quiz_ques_f_adm,container,false);

        EnterQuesEditTvAddQuizQuesFAdm = view.findViewById(R.id.EnterQuesEditTvAddQuizQuesFAdm);
        opt1TvAddQuizQuesFAdm = view.findViewById(R.id.opt1TvAddQuizQuesFAdm);
        opt2TvAddQuizQuesFAdm = view.findViewById(R.id.opt2TvAddQuizQuesFAdm);
        opt3TvAddQuizQuesFAdm = view.findViewById(R.id.opt3TvAddQuizQuesFAdm);
        opt4TvAddQuizQuesFAdm = view.findViewById(R.id.opt4TvAddQuizQuesFAdm);
        chip_group_add_quiz_ques = view.findViewById(R.id.chip_group_add_quiz_ques);
        chip_group_add_quiz_ques.setSelectionRequired(true);
        checkBox1AddQuizQuesFAdm = view.findViewById(R.id.checkBox1AddQuizQuesFAdm);
        checkBox1AddQuizQuesFAdm.setClickable(false);
        checkBox2AddQuizQuesFAdm = view.findViewById(R.id.checkBox2AddQuizQuesFAdm);
        checkBox2AddQuizQuesFAdm.setClickable(false);
        checkBox3AddQuizQuesFAdm = view.findViewById(R.id.checkBox3AddQuizQuesFAdm);
        checkBox3AddQuizQuesFAdm.setClickable(false);
        checkBox4AddQuizQuesFAdm = view.findViewById(R.id.checkBox4AddQuizQuesFAdm);
        checkBox4AddQuizQuesFAdm.setClickable(false);
        imgBtnSetNextQues = view.findViewById(R.id.imgBtnSetNextQues);
        closeFragBtnAddQuizQuesFAdm = view.findViewById(R.id.closeFragBtnAddQuizQuesFAdm);
//        closeFragBtnAddQuizQuesFAdm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        imgBtnSetNextQues.setText("Next");
        imgBtnSetNextQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEditTvValid();
                isChipSelected();
                setCorrectAnsString();
                Log.i("correct ans - ", correctAnsString);
                Log.i("correct ques - ", question);
                clearEverythingForFreshInputs();
                Log.i("current countef val - ", String.valueOf(currentQuesCounter));
                Log.i("total ques val - ", String.valueOf(totalQuesCounter));
            }
        });

        questionNoTvAddQuizQuesFAdm= view.findViewById(R.id.questionNoTvAddQuizQuesFAdm);
        setQuesCounter();

        return view;
    }

    private void closeFrag(){
        if(currentQuesCounter == totalQuesCounter){
            closeFragBtnAddQuizQuesFAdm.setVisibility(View.VISIBLE);
            imgBtnSetNextQues.setVisibility(View.GONE);
            closeFragBtnAddQuizQuesFAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragment = new QuizesMainScAdm();
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit();
                    fragmentTransaction.addToBackStack(null);
                }
            });
        }

    }

    private void updateCurrentQuesCounter() {
        if(currentQuesCounter<totalQuesCounter){
            currentQuesCounter++;
            questionNoTvAddQuizQuesFAdm.setText(new StringBuilder().append(currentQuesCounter).append("/").append(getTotalQues).toString());
        }else{
            closeFrag();
        }
    }

    private void setQuesCounter(){
        try{
            getTotalDuration = getArguments().getString("duration");
            getTotalQues = getArguments().getString("totalQ");
            totalQuesCounter = Integer.parseInt(getTotalQues);
            questionNoTvAddQuizQuesFAdm.setText(new StringBuilder().append(currentQuesCounter).append("/").append(getTotalQues).toString());
        }catch (Exception e){
            Toast.makeText(getContext(), "Invalid Dialog", Toast.LENGTH_SHORT).show();
        }
    }

    /** Make sure edittextv is not empty and given ans is not a blank space
     * chip press hua hai n user ke koi chip ko select kiya hai
     * pressed chip ke according tv ka value hoga correct ans
     * jab dusra chip select kar rhe hai to correct ans ka value should get changed
     * sab kch karne ke bad send btn ko order do dbs me data send karne ka
     */

    /** Making sure edittv is not empty**/
    private boolean isEditTvValid(){
        boolean counter;
        if(!EnterQuesEditTvAddQuizQuesFAdm.toString().trim().isEmpty() && !EnterQuesEditTvAddQuizQuesFAdm.toString().trim().equals(" ")
                && !opt1TvAddQuizQuesFAdm.getText().toString().trim().isEmpty() && !opt1TvAddQuizQuesFAdm.getText().toString().trim().equals(" ")
                && !opt2TvAddQuizQuesFAdm.getText().toString().trim().isEmpty() && !opt2TvAddQuizQuesFAdm.getText().toString().trim().equals(" ")
                && !opt3TvAddQuizQuesFAdm.getText().toString().trim().isEmpty() && !opt3TvAddQuizQuesFAdm.getText().toString().trim().equals(" ")
                && !opt4TvAddQuizQuesFAdm.getText().toString().trim().isEmpty() && !opt4TvAddQuizQuesFAdm.getText().toString().trim().equals(" ")){
            //opts are valid
            counter = true;
            checkBox1AddQuizQuesFAdm.setClickable(true);
            checkBox2AddQuizQuesFAdm.setClickable(true);
            checkBox3AddQuizQuesFAdm.setClickable(true);
            checkBox4AddQuizQuesFAdm.setClickable(true);
        }else {
            //iska mtlb kahi par to koi opt invalid hai toast krdo ya dekh lo
            counter = false;
        }
        return counter;
    }

    private boolean isChipSelected(){
        checkBox1AddQuizQuesFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = "1";
                counterClicked[0] = true;
            }
        });
        checkBox2AddQuizQuesFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = "2";
                counterClicked[0] = true;
            }
        });
        checkBox3AddQuizQuesFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = "3";
                counterClicked[0] = true;
            }
        });
        checkBox4AddQuizQuesFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = "4";
                counterClicked[0] = true;
            }
        });
//        Log.i("counter clickedvalue - ", String.valueOf(counterClicked[0]));
        return counterClicked[0];
    }

    private boolean setCorrectAnsString(){
        if(isChipSelected() && isEditTvValid()){
            switch (tag){
                case "1":
                    correctAnsString = opt1TvAddQuizQuesFAdm.getText().toString().trim();break;
                case "2":
                    correctAnsString = opt2TvAddQuizQuesFAdm.getText().toString().trim();break;
                case "3":
                    correctAnsString = opt3TvAddQuizQuesFAdm.getText().toString().trim();break;
                case "4":
                    correctAnsString = opt4TvAddQuizQuesFAdm.getText().toString().trim();break;
            }
            question = EnterQuesEditTvAddQuizQuesFAdm.getText().toString().trim();
            updateCurrentQuesCounter();
            return true;
        }else{
            Toast.makeText(getContext(), "Invalid Selection", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    //TODO
    private void sentQuizData(boolean setCorrectAnsStr){
        //Send kar diya ans and now erase everything n give user next place to add next set of ques
        //after sending code ....
        clearEverythingForFreshInputs();
    }

    private void clearEverythingForFreshInputs() {
        EnterQuesEditTvAddQuizQuesFAdm.getText().clear();
        opt1TvAddQuizQuesFAdm.getText().clear();
        opt2TvAddQuizQuesFAdm.getText().clear();
        opt3TvAddQuizQuesFAdm.getText().clear();
        opt4TvAddQuizQuesFAdm.getText().clear();
    }



}