package com.example.adminapp.GroupFragAdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class adapterRecVSpecificChapDetailsGrpFAdm extends RecyclerView.Adapter<adapterRecVSpecificChapDetailsGrpFAdm.myviewholder> {

    ArrayList<dataModelRecVSpecificChapDetailsFAdm> dataHolder;
    ArrayList<dataModelRecVSpecificChapDetailsFAdm> dataHolderBackup;

    public adapterRecVSpecificChapDetailsGrpFAdm(ArrayList<dataModelRecVSpecificChapDetailsFAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_des_recyclerv_specific_chap_detailsf_adm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.moduleSelectNameTvSpecChapFAdm.setText(dataHolder.get(position).getModuleSelectNameTvSpecChapFAdm());
        holder.moduleDesTvCardLaySpecChapFAdm.setText(dataHolder.get(position).getModuleDesTvCardLaySpecChapFAdm());
        holder.moduleNameInSelectedChapTvCardLaySpecChapFAdm.setText(dataHolder.get(position).getModuleNameInSelectedChapTvCardLaySpecChapFAdm());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView moduleSelectNameTvSpecChapFAdm,moduleNameInSelectedChapTvCardLaySpecChapFAdm,
                moduleDesTvCardLaySpecChapFAdm,resourcesForThatModuleTvCardLaySpecificChapDetailsFAdm;
        FrameLayout parentFrameLayout;
        RecyclerView parentRecyclerView;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            moduleSelectNameTvSpecChapFAdm = itemView.findViewById(R.id.moduleSelectNameTvSpecChapFAdm);
            moduleNameInSelectedChapTvCardLaySpecChapFAdm = itemView.findViewById(R.id.moduleNameInSelectedChapTvCardLaySpecChapFAdm);
            moduleDesTvCardLaySpecChapFAdm = itemView.findViewById(R.id.moduleDesTvCardLaySpecChapFAdm);
            resourcesForThatModuleTvCardLaySpecificChapDetailsFAdm = itemView.findViewById(R.id.resourcesForThatModuleTvCardLaySpecificChapDetailsFAdm);

        }
    }
}
