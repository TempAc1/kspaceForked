package com.example.adminapp.GroupFragAdm;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.adminapp.GroupFragAdm.DiscussionPanelFragAdm.DiscussionPanelMainScFAdm;
import com.example.adminapp.GroupFragAdm.GrpQuizesAdm.AddQuizQuesFAdm;
import com.example.adminapp.GroupFragAdm.GrpQuizesAdm.QuizData;
import com.example.adminapp.GroupFragAdm.GrpQuizesAdm.QuizesMainScAdm;
import com.example.adminapp.R;
import java.util.Calendar;


public class GroupOverviewFragGrpAdm extends Fragment {

    private TextView grpTitleCardVDetailsGrpOverviewAdm,grpShortDescCardVDetailsGrpOverviewAdm,
            grpAdminNameCardVDetailsGrpOverviewAdm,grpOption1GrpOverviewFrag,grpOption2GrpOverviewFrag,
            grpOption3GrpOverviewFrag,grpOption4GrpOverviewFrag;
    private ImageView cancelBtnCusDiaQuiz;
    private Button proceedBtnCusDiaQuiz;
    private EditText setTotalQusCusDiaQuiz;
    private TextView setDurationCusDiaQuiz;
    private QuizData quizData = new QuizData();

    public GroupOverviewFragGrpAdm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_group_overview_frag_grp_adm,container,false);
        grpTitleCardVDetailsGrpOverviewAdm = view.findViewById(R.id.grpTitleCardVDetailsGrpOverviewAdm);
        grpShortDescCardVDetailsGrpOverviewAdm = view.findViewById(R.id.grpShortDescCardVDetailsGrpOverviewAdm);
        grpAdminNameCardVDetailsGrpOverviewAdm = view.findViewById(R.id.grpAdminNameCardVDetailsGrpOverviewAdm);
        grpOption1GrpOverviewFrag = view.findViewById(R.id.grpOption1GrpOverviewFrag);
        grpOption2GrpOverviewFrag = view.findViewById(R.id.grpOption2GrpOverviewFrag);
        grpOption3GrpOverviewFrag = view.findViewById(R.id.grpOption3GrpOverviewFrag);
        grpOption4GrpOverviewFrag = view.findViewById(R.id.grpOption4GrpOverviewFrag);
       // openSpecificFrag(R.id.grpAdminNameCardVDetailsGrpOverviewAdm);

        grpOption1GrpOverviewFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FrameLayout fl = activity.findViewById(R.id.frameLayGrpOverview);
                fl.removeAllViews();
                Fragment fragment = new CourseSelectedFAdm();
                FragmentManager manager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit();
                fragmentTransaction.addToBackStack(String.valueOf(R.layout.fragment_group_overview_frag_grp_adm));
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        grpOption2GrpOverviewFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Clicked 2", Toast.LENGTH_SHORT).show();
            }
        });

        grpOption3GrpOverviewFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new QuizesMainScAdm();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit();
                fragmentTransaction.addToBackStack(null);
            }
        });



        grpOption4GrpOverviewFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new DiscussionPanelMainScFAdm();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayFragHolderActGrpAdm,fragment).commit();
                ft.addToBackStack(null);
                Toast.makeText(getContext(), "Clicked 4", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }



    private void openSpecificFrag(int id){
        switch (id){
            case R.id.grpOption1GrpOverviewFrag:
                Toast.makeText(getContext(), "opt1 clicked", Toast.LENGTH_SHORT).show();break;
            case R.id.grpOption2GrpOverviewFrag:
                Toast.makeText(getContext(), "opt2 clicked", Toast.LENGTH_SHORT).show();break;
            case R.id.grpOption3GrpOverviewFrag:
                Toast.makeText(getContext(), "opt3 clicked", Toast.LENGTH_SHORT).show();break;
            case R.id.grpOption4GrpOverviewFrag:
                Toast.makeText(getContext(), "opt4 clicked", Toast.LENGTH_SHORT).show();break;
        }
    }
}