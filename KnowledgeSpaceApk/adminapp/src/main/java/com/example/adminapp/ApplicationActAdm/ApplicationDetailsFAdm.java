package com.example.adminapp.ApplicationActAdm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.R;


public class ApplicationDetailsFAdm extends Fragment {

    private ImageButton imgBtnApplicationDetailsFAdm;
    private TextView receiverIdTvApplicationDetailsFAdm,applicationSubjectTvApplicationDetailsFAdm,
            applicationBodyTvApplicationDetailsFAdm,applicationAttachmentTvApplicationDetailsFAdm;

    public ApplicationDetailsFAdm() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_application_details_f_adm, container, false);
        receiverIdTvApplicationDetailsFAdm = view.findViewById(R.id.receiverIdTvApplicationDetailsFAdm);
        applicationSubjectTvApplicationDetailsFAdm = view.findViewById(R.id.applicationSubjectTvApplicationDetailsFAdm);
        applicationBodyTvApplicationDetailsFAdm = view.findViewById(R.id.applicationBodyTvApplicationDetailsFAdm);
        applicationAttachmentTvApplicationDetailsFAdm = view.findViewById(R.id.applicationAttachmentTvApplicationDetailsFAdm);
        imgBtnApplicationDetailsFAdm = view.findViewById(R.id.imgBtnApplicationDetailsFAdm);

        imgBtnApplicationDetailsFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getFragmentManager().getBackStackEntryCount() != 0) {
                    getFragmentManager().popBackStack();
                }
                Toast.makeText(getContext(), "No Backend", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}