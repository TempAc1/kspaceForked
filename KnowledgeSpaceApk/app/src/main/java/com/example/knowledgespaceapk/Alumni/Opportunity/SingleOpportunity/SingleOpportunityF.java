package com.example.knowledgespaceapk.Alumni.Opportunity.SingleOpportunity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingleOpportunityF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleOpportunityF extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button applyForOpportunityBtnSingleOpportF,deleteOpportBtnSingleOpportF;

    public SingleOpportunityF() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingleOpportunityF.
     */
    // TODO: Rename and change types and number of parameters
    public static SingleOpportunityF newInstance(String param1, String param2) {
        SingleOpportunityF fragment = new SingleOpportunityF();
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
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_single_opportunity, container, false);

        applyForOpportunityBtnSingleOpportF = view.findViewById(R.id.applyForOpportunityBtnSingleOpportF);


        //Todo create backend
        applyForOpportunityBtnSingleOpportF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(), "Clicked without backend", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}