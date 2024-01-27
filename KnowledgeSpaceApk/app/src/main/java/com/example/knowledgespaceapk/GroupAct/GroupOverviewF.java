package com.example.knowledgespaceapk.GroupAct;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.GroupAct.CourseSelectedF.CourseSelectedF;
import com.example.knowledgespaceapk.GroupAct.DiscussionPanel.DiscussionPanelMainScF;
import com.example.knowledgespaceapk.GroupAct.GrpQuizes.QuizesMainSc;
import com.example.knowledgespaceapk.R;


public class GroupOverviewF extends Fragment {

    private TextView grpTitleCardVDetailsGrpOverview,grpShortDescCardVDetailsGrpOverview,
            grpAdminNameCardVDetailsGrpOverview,grpOption1GrpOverviewFrag,grpOption2GrpOverviewFrag,
            grpOption3GrpOverviewFrag,grpOption4GrpOverviewFrag;
    private ImageView cancelBtnCusDiaQuiz;
    private Button proceedBtnCusDiaQuiz;
    private EditText setTotalQusCusDiaQuiz;
    private TextView setDurationCusDiaQuiz;

    public GroupOverviewF() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =LayoutInflater.from(getContext()).inflate(R.layout.fragment_group_overview, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        grpTitleCardVDetailsGrpOverview = view.findViewById(R.id.grpTitleCardVDetailsGrpOverview);
        grpShortDescCardVDetailsGrpOverview = view.findViewById(R.id.grpShortDescCardVDetailsGrpOverview);
        grpAdminNameCardVDetailsGrpOverview = view.findViewById(R.id.grpAdminNameCardVDetailsGrpOverview);
        grpOption1GrpOverviewFrag = view.findViewById(R.id.grpOption1GrpOverviewFrag);
        grpOption2GrpOverviewFrag = view.findViewById(R.id.grpOption2GrpOverviewFrag);
        grpOption3GrpOverviewFrag = view.findViewById(R.id.grpOption3GrpOverviewFrag);
        grpOption4GrpOverviewFrag = view.findViewById(R.id.grpOption4GrpOverviewFrag);

        grpOption1GrpOverviewFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                FrameLayout fl = activity.findViewById(R.id.frameLayGrpScHolderAct);
//                fl.removeAllViews();
//                Fragment fragment = new CourseSelectedF();
//                FragmentManager manager = activity.getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = manager.beginTransaction();
//                fragmentTransaction.replace(R.id.frameLayGrpScHolderAct, fragment).commit();
//                fragmentTransaction.addToBackStack(String.valueOf(R.layout.fragment_group_overview));
                final NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_groupOverviewF_to_courseSelectedF);
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
//                Fragment fragment = new QuizesMainSc();
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.frameLayGrpScHolderAct, fragment).commit();
//                fragmentTransaction.addToBackStack(null);
                final NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_groupOverviewF_to_quizesMainSc);
            }
        });

        grpOption4GrpOverviewFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragment = new DiscussionPanelMainScF();
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayGrpScHolderAct,fragment).commit();
//                ft.addToBackStack(null);
//                Toast.makeText(getContext(), "Clicked 4", Toast.LENGTH_SHORT).show();
                final NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_groupOverviewF_to_discussionPanelMainScF);
            }
        });


    }
}