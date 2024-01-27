package com.example.adminapp.ApplicationActAdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class AdapterApplicationMainFAdm extends RecyclerView.Adapter<AdapterApplicationMainFAdm.myviewholder> {

    private ArrayList<DataModelRecVApplicationMainFAdm> dataHolder;
    private ArrayList<DataModelRecVApplicationMainFAdm> dataHolderBackup;

    public AdapterApplicationMainFAdm(ArrayList<DataModelRecVApplicationMainFAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_resd_recv_application_fadm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView applicationSenderIdTvSingleRdRecVApplicationDefaultFAdm,
                appTitleTvSingleRdRecVApplicationDefaultFAdm,appDescTvSingleRdRecVApplicationDefaultFAdm;
        CardView cardVSingleResDRecVApplicationFAdm;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            applicationSenderIdTvSingleRdRecVApplicationDefaultFAdm = itemView.findViewById(R.id.applicationSenderIdTvSingleRdRecVApplicationDefaultFAdm);
            appTitleTvSingleRdRecVApplicationDefaultFAdm  = itemView.findViewById(R.id.appTitleTvSingleRdRecVApplicationDefaultFAdm);
            appDescTvSingleRdRecVApplicationDefaultFAdm = itemView.findViewById(R.id.appDescTvSingleRdRecVApplicationDefaultFAdm);
        
            cardVSingleResDRecVApplicationFAdm = itemView.findViewById(R.id.cardVSingleResDRecVApplicationFAdm);
            cardVSingleResDRecVApplicationFAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FrameLayout fl = activity.findViewById(R.id.frameLayApplicationActAdm);
                    fl.removeAllViews();
                    Fragment fragment = new ApplicationDetailsFAdm();
                    FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayApplicationActAdm, fragment).commit();
                    fragmentTransaction.addToBackStack(null);
                    Toast.makeText(itemView.getContext(), "No backend", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
