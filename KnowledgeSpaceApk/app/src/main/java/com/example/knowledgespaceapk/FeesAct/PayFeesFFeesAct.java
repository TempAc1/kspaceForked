package com.example.knowledgespaceapk.FeesAct;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.R;
import com.google.android.material.button.MaterialButton;


public class PayFeesFFeesAct extends Fragment {

    TextView studentCurrentBatchDetailsTvPayFeesF;
    LinearLayout linearLayPayFeesFFeesAct;
    TextView tr2c1AcademicFeesTvPayFeesF,tr2c2AcademicsFeesAmtTvPayFeesF,tr3c1StdInsurancesTvPayFeesF,
            tr3c2StdInsurancesFeesAmtTvPayFeesF,tr4c1LibraryFeesTvPayFeesF,tr4c2LibraryFeesAmtTvPayFeesF,
            tr5c1DevelopmentFeesTvPayFeesF,tr5c2DevelopmentFeesAmtTvPayFeesF,tr6c1OtherFeesTvPayFeesF,
            tr6c2OtherFeesAmtTvPayFeesF;
    MaterialButton payFeesBtnPayFeesFPayFeesAct;

    public PayFeesFFeesAct() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_pay_fees_f_fees_act, container, false);

        linearLayPayFeesFFeesAct = view.findViewById(R.id.linearLayPayFeesFFeesAct);
        studentCurrentBatchDetailsTvPayFeesF = view.findViewById(R.id.studentCurrentBatchDetailsTvPayFeesF);
        tr2c1AcademicFeesTvPayFeesF = view.findViewById(R.id.tr2c1AcademicsTvPayFeesFFeesAct);
        tr2c2AcademicsFeesAmtTvPayFeesF = view.findViewById(R.id.tr2c2AcademicsFeesAmtTvPayFeesF);
        tr3c1StdInsurancesTvPayFeesF = view.findViewById(R.id.tr3c1StdInsurancesTvPayFeesF);
        tr3c2StdInsurancesFeesAmtTvPayFeesF = view.findViewById(R.id.tr3c2StdInsurancesFeesAmtTvPayFeesF);
        tr4c1LibraryFeesTvPayFeesF = view.findViewById(R.id.tr4c1LibraryFeesTvPayFeesF);
        tr4c2LibraryFeesAmtTvPayFeesF = view.findViewById(R.id.tr4c2LibraryFeesAmtTvPayFeesF);
        tr5c1DevelopmentFeesTvPayFeesF = view.findViewById(R.id.tr5c1DevelopmentFeesTvPayFeesF);
        tr5c2DevelopmentFeesAmtTvPayFeesF = view.findViewById(R.id.tr5c2DevelopmentFeesAmtTvPayFeesF);
        tr6c1OtherFeesTvPayFeesF = view.findViewById(R.id.tr6c1OtherFeesTvPayFeesF);
        tr6c2OtherFeesAmtTvPayFeesF = view.findViewById(R.id.tr6c2OtherFeesAmtTvPayFeesF);

        payFeesBtnPayFeesFPayFeesAct = view.findViewById(R.id.payFeesBtnPayFeesFPayFeesAct);
        payFeesBtnPayFeesFPayFeesAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "No-Backend", Toast.LENGTH_SHORT).show();
            }
        });

        //Todo amt set karna hai backend se class banakar

        return view;
    }
}