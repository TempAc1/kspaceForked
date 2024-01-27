package com.example.knowledgespaceapk.GroupAct.GrpQuizes;

import android.os.Bundle;

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

import com.example.knowledgespaceapk.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;


public class AddQuizQuesF extends Fragment {

    private Chip checkBox1AddQuizQuesF,checkBox2AddQuizQuesF,checkBox3AddQuizQuesF,checkBox4AddQuizQuesF;
    private ChipGroup chip_group_add_quiz_ques;
    private String tag;
    private Button imgBtnSetNextQues,closeFragBtnAddQuizQuesF;
    private TextView questionNoTvAddQuizQuesF;
    private EditText EnterQuesEditTvAddQuizQuesF,opt1TvAddQuizQuesF,opt2TvAddQuizQuesF,opt3TvAddQuizQuesF,opt4TvAddQuizQuesF;
    private String correctAnsString ="Not defined",question="Not defined";
    private Boolean isChipSelected = false;
    private boolean[] counterClicked = new boolean[1];
    private String getTotalDuration,getTotalQues;
    private int totalQuesCounter,currentQuesCounter=1;

    public AddQuizQuesF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_add_quiz_ques,container,false);

        EnterQuesEditTvAddQuizQuesF = view.findViewById(R.id.EnterQuesEditTvAddQuizQuesF);
        opt1TvAddQuizQuesF = view.findViewById(R.id.opt1TvAddQuizQuesF);
        opt2TvAddQuizQuesF = view.findViewById(R.id.opt2TvAddQuizQuesF);
        opt3TvAddQuizQuesF = view.findViewById(R.id.opt3TvAddQuizQuesF);
        opt4TvAddQuizQuesF = view.findViewById(R.id.opt4TvAddQuizQuesF);
        chip_group_add_quiz_ques = view.findViewById(R.id.chip_group_add_quiz_ques);
        chip_group_add_quiz_ques.setSelectionRequired(true);
        checkBox1AddQuizQuesF = view.findViewById(R.id.checkBox1AddQuizQuesF);
        checkBox1AddQuizQuesF.setClickable(false);
        checkBox2AddQuizQuesF = view.findViewById(R.id.checkBox2AddQuizQuesF);
        checkBox2AddQuizQuesF.setClickable(false);
        checkBox3AddQuizQuesF = view.findViewById(R.id.checkBox3AddQuizQuesF);
        checkBox3AddQuizQuesF.setClickable(false);
        checkBox4AddQuizQuesF = view.findViewById(R.id.checkBox4AddQuizQuesF);
        checkBox4AddQuizQuesF.setClickable(false);
        imgBtnSetNextQues = view.findViewById(R.id.imgBtnSetNextQues);
        closeFragBtnAddQuizQuesF = view.findViewById(R.id.closeFragBtnAddQuizQuesF);
//        closeFragBtnAddQuizQuesF.setOnClickListener(new View.OnClickListener() {
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

        questionNoTvAddQuizQuesF= view.findViewById(R.id.questionNoTvAddQuizQuesF);
        setQuesCounter();

        return view;
    }

    private void closeFrag(){
        if(currentQuesCounter == totalQuesCounter){
            closeFragBtnAddQuizQuesF.setVisibility(View.VISIBLE);
            imgBtnSetNextQues.setVisibility(View.GONE);
            closeFragBtnAddQuizQuesF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragment = new QuizesMainSc();
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayGrpScHolderAct, fragment).commit();
                    fragmentTransaction.addToBackStack(null);
                }
            });
        }

    }


    private void updateCurrentQuesCounter() {
        if(currentQuesCounter<totalQuesCounter){
            currentQuesCounter++;
            questionNoTvAddQuizQuesF.setText(new StringBuilder().append(currentQuesCounter).append("/").append(getTotalQues).toString());
        }else{
            closeFrag();
        }
    }


    private void setQuesCounter(){
        try{
            getTotalDuration = getArguments().getString("duration");
            getTotalQues = getArguments().getString("totalQ");
            totalQuesCounter = Integer.parseInt(getTotalQues);
            questionNoTvAddQuizQuesF.setText(new StringBuilder().append(currentQuesCounter).append("/").append(getTotalQues).toString());
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
        if(!EnterQuesEditTvAddQuizQuesF.toString().trim().isEmpty() && !EnterQuesEditTvAddQuizQuesF.toString().trim().equals(" ")
                && !opt1TvAddQuizQuesF.getText().toString().trim().isEmpty() && !opt1TvAddQuizQuesF.getText().toString().trim().equals(" ")
                && !opt2TvAddQuizQuesF.getText().toString().trim().isEmpty() && !opt2TvAddQuizQuesF.getText().toString().trim().equals(" ")
                && !opt3TvAddQuizQuesF.getText().toString().trim().isEmpty() && !opt3TvAddQuizQuesF.getText().toString().trim().equals(" ")
                && !opt4TvAddQuizQuesF.getText().toString().trim().isEmpty() && !opt4TvAddQuizQuesF.getText().toString().trim().equals(" ")){
            //opts are valid
            counter = true;
            checkBox1AddQuizQuesF.setClickable(true);
            checkBox2AddQuizQuesF.setClickable(true);
            checkBox3AddQuizQuesF.setClickable(true);
            checkBox4AddQuizQuesF.setClickable(true);
        }else {
            //iska mtlb kahi par to koi opt invalid hai toast krdo ya dekh lo
            counter = false;
        }
        return counter;
    }


    private boolean isChipSelected(){
        checkBox1AddQuizQuesF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = "1";
                counterClicked[0] = true;
            }
        });
        checkBox2AddQuizQuesF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = "2";
                counterClicked[0] = true;
            }
        });
        checkBox3AddQuizQuesF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = "3";
                counterClicked[0] = true;
            }
        });
        checkBox4AddQuizQuesF.setOnClickListener(new View.OnClickListener() {
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
                    correctAnsString = opt1TvAddQuizQuesF.getText().toString().trim();break;
                case "2":
                    correctAnsString = opt2TvAddQuizQuesF.getText().toString().trim();break;
                case "3":
                    correctAnsString = opt3TvAddQuizQuesF.getText().toString().trim();break;
                case "4":
                    correctAnsString = opt4TvAddQuizQuesF.getText().toString().trim();break;
            }
            question = EnterQuesEditTvAddQuizQuesF.getText().toString().trim();
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
        EnterQuesEditTvAddQuizQuesF.getText().clear();
        opt1TvAddQuizQuesF.getText().clear();
        opt2TvAddQuizQuesF.getText().clear();
        opt3TvAddQuizQuesF.getText().clear();
        opt4TvAddQuizQuesF.getText().clear();
    }


}