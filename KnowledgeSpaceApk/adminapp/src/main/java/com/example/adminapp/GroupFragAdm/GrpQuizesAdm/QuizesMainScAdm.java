package com.example.adminapp.GroupFragAdm.GrpQuizesAdm;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;


public class QuizesMainScAdm extends Fragment {

    private RecyclerView parentRecVQuizesFragMainScAdm;
    private adapterRecVQuizesMainScAdm adapter;
    private ArrayList<dataModelRecVQuizesMainScAdm> dataHolder;

    private FloatingActionButton floatingActionBtnQuizeMainScAdm;
    private ImageView cancelBtnCusDiaQuiz;
    private Button proceedBtnCusDiaQuiz;
    private EditText setTotalQusCusDiaQuiz;
    private TextView setDurationCusDiaQuiz;
    private QuizData quizData = new QuizData();

    public QuizesMainScAdm() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_quizes_main_sc_adm, container, false);
        floatingActionBtnQuizeMainScAdm = view.findViewById(R.id.floatingActionBtnQuizeMainScAdm);
        parentRecVQuizesFragMainScAdm = view.findViewById(R.id.parentRecVQuizesFragMainScAdm);
        parentRecVQuizesFragMainScAdm.setLayoutManager(new LinearLayoutManager(getContext()));
        addObjToHolder();
        parentRecVQuizesFragMainScAdm.setAdapter(new adapterRecVQuizesMainScAdm(dataHolder));


        floatingActionBtnQuizeMainScAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogBox();
            }
        });

        //TODO
//        view.setFocusableInTouchMode(true);
//        view.requestFocus();
//        view.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//
//
//                return false;
//            }
//        });

        return view;
    }

    private void openDialogBox() {
        Dialog dialog =  new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_addquiz);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;



        setTotalQusCusDiaQuiz = dialog.findViewById(R.id.setTotalQuesCusDiaQuiz);
        setDurationCusDiaQuiz = dialog.findViewById(R.id.setDurationCusDiaQuiz);

        setDurationCusDiaQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(setDurationCusDiaQuiz.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        setDurationCusDiaQuiz.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });


        cancelBtnCusDiaQuiz = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);
        cancelBtnCusDiaQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog.setCancelable(true);
            }
        });

        proceedBtnCusDiaQuiz = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm);
        proceedBtnCusDiaQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    quizData.setQuizTime(setDurationCusDiaQuiz.getText().toString());
                    Log.i("Duration ",quizData.getQuizTime());
                }catch (NumberFormatException e){
                    Toast.makeText(getContext(), "Invalid Time Format", Toast.LENGTH_SHORT).show();
                }

                try{
                    quizData.setQuizTotalQues(setTotalQusCusDiaQuiz.getText().toString());
                    Log.i("Ques : ", quizData.getQuizTotalQues());
                }catch (NumberFormatException e){
                    Toast.makeText(getContext(), "Invalid ques", Toast.LENGTH_SHORT).show();
                }
                dialog.setCancelable(true);
                dialog.dismiss();

                Bundle bundle = new Bundle();
                bundle.putString("duration", quizData.getQuizTime());
                bundle.putString("totalQ", quizData.getQuizTotalQues());
                Fragment fragment = new AddQuizQuesFAdm();
                fragment.setArguments(bundle);
                FrameLayout fl = dialog.findViewById(R.id.frameLayGrpOverview);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        dialog.show();
    }


    private void addObjToHolder() {
        dataHolder = new ArrayList<>();
        QuizData obj = new QuizData();
        String time = obj.getQuizTime();
        String ques = obj.getQuizTotalQues();
        dataModelRecVQuizesMainScAdm obj1 = new dataModelRecVQuizesMainScAdm("IOT", ques,time);
        dataHolder.add(obj1);
        dataHolder.add(obj1);dataHolder.add(obj1);
        dataHolder.add(obj1);dataHolder.add(obj1);
        dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);
        dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);dataHolder.add(obj1);
    }



}