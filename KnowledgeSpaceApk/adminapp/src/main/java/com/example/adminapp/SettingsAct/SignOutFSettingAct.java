package com.example.adminapp.SettingsAct;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.adminapp.MainActivity;
import com.example.adminapp.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.google.firebase.auth.FirebaseAuth;


public class SignOutFSettingAct extends Fragment {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private ProgressBar progressBar;

    public SignOutFSettingAct() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_out_f_setting_act,container,false);
        progressBar = view.findViewById(R.id.progressBarSignOutAct);
        new gSignOut().execute();
        return view;
    }

    public class gSignOut extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            Sprite barType = new CubeGrid();
            progressBar.setIndeterminateDrawable(barType);
            Toast.makeText(getActivity(), "Signing Out...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try{
                auth.signOut();
            }catch (Exception e){
                Toast.makeText(getActivity(), "Internal Server Error", Toast.LENGTH_SHORT).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            startActivity(new Intent(getActivity(),MainActivity.class));
        }
    }

}