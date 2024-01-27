package com.example.knowledgespaceapk.GroupAct.SpecificChapDetailsF;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterSpecificChapDetailsF extends RecyclerView.Adapter<AdapterSpecificChapDetailsF.myviewholder> {

    ArrayList<DataModelRecVSpecificChapDetailsF> dataHolder;
    ArrayList<DataModelRecVSpecificChapDetailsF> dataHolderBackup;

    public AdapterSpecificChapDetailsF(ArrayList<DataModelRecVSpecificChapDetailsF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_resdes_recv_specificchap_details_f,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.moduleSelectNameTvSpecChapF.setText(dataHolder.get(position).getModuleSelectNameTvSpecChapF());
        holder.moduleDesTvCardLaySpecChapF.setText(dataHolder.get(position).getModuleDesTvCardLaySpecChapF());
        holder.moduleNameInSelectedChapTvCardLaySpecChapF.setText(dataHolder.get(position).getModuleNameInSelectedChapTvCardLaySpecChapF());

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView moduleSelectNameTvSpecChapF,moduleNameInSelectedChapTvCardLaySpecChapF,
                moduleDesTvCardLaySpecChapF,resourcesForThatModuleTvCardLaySpecificChapDetailsF;
        FrameLayout parentFrameLayout;
        RecyclerView parentRecyclerView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            moduleSelectNameTvSpecChapF = itemView.findViewById(R.id.moduleSelectNameTvSpecChapF);
            moduleNameInSelectedChapTvCardLaySpecChapF = itemView.findViewById(R.id.moduleNameInSelectedChapTvCardLaySpecChapF);
            moduleDesTvCardLaySpecChapF = itemView.findViewById(R.id.moduleDesTvCardLaySpecChapF);
            resourcesForThatModuleTvCardLaySpecificChapDetailsF = itemView.findViewById(R.id.resourcesForThatModuleTvCardLaySpecificChapDetailsF);
        }
    }
}
