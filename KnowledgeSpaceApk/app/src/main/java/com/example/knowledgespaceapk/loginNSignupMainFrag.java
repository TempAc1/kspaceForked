package com.example.knowledgespaceapk;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgespaceapk.HomeSc.homeSc;
import com.github.ybq.android.spinkit.style.Wave;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginNSignupMainFrag extends Fragment {


    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String email,pass;
    ProgressBar progressBar;
    EditText emailTvLoginSc,passTvLoginSc;
    Button loginBtnLogicSc;
    private TextView contactHereTvLoginSc;

    public loginNSignupMainFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_n_signup_main, container, false);
        loginBtnLogicSc = view.findViewById(R.id.loginBtnLogicSc);
        emailTvLoginSc = view.findViewById(R.id.emailTvLoginSc);
        passTvLoginSc = view.findViewById(R.id.passTvLoginSc);
        progressBar = view.findViewById(R.id.loadingSpinnerCVUploadDownloadDialog);
        loginBtnLogicSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.GONE);
                getProgressBar();
                gAuth();
            }
        });

        contactHereTvLoginSc = view.findViewById(R.id.contactHereTvLoginSc);
        contactHereTvLoginSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://forms.gle/UDmeu48AaDU3PSq78"));
                startActivity(browserIntent);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            startActivity(new Intent(getActivity(), homeSc.class));
        } else {
            gAuth();
        }
    }

    private void gAuth() {
        if(emailTvLoginSc.getText()!=null && passTvLoginSc.getText()!=null){
            email = emailTvLoginSc.getText().toString().trim();
            pass = passTvLoginSc.getText().toString().trim();
            if(!email.matches("") && !pass.matches("")){
                mAuth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getActivity(), "Login Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getActivity(),homeSc.class));
                                }else{
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(getActivity(), "Login Failure", Toast.LENGTH_SHORT).show();
                                    Log.i("Else part",task.getException().getMessage());
                                    Log.i("Else part",pass);
                                }
                            }
                        });
            }else{
                Drawable customErrorDrawable = getResources().getDrawable(R.drawable.ic_baseline_error_outline_24);
                customErrorDrawable.setBounds(0,0,customErrorDrawable.getIntrinsicWidth(),
                        customErrorDrawable.getIntrinsicHeight());
                emailTvLoginSc.setError("Field cannot be empty");
                passTvLoginSc.setError("Field cannot be empty");
            }
        }else{
            Toast.makeText(getActivity(), "Field cannot be left empty", Toast.LENGTH_SHORT).show();
        }

    }

    private void getProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        Wave barType = new Wave();
        progressBar.setIndeterminateDrawable(barType);
    }
}