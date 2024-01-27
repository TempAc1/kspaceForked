package com.example.knowledgespaceapk.PlacementAct.Resources;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterPlacementResourcesF extends RecyclerView.Adapter<AdapterPlacementResourcesF.myviewholder> {

    private ArrayList<DataModelPlacementResourcesF> dataHolder;
    private ArrayList<DataModelPlacementResourcesF> dataHolderBackup;

    public AdapterPlacementResourcesF(ArrayList<DataModelPlacementResourcesF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_resdes_recv_placement_resources_f,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.resourceTitleTvSingleRdRecVPlacementResourcesF.setText(dataHolder.get(position).getResourceTitleTvSingleRdRecVPlacementResourcesF());
        holder.resourceTvSingleRdRecVPlacementResourcesF.setText(dataHolder.get(position).getResourceTvSingleRdRecVPlacementResourcesF());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView resourceTitleTvSingleRdRecVPlacementResourcesF,resourceTvSingleRdRecVPlacementResourcesF;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            resourceTitleTvSingleRdRecVPlacementResourcesF = itemView.findViewById(R.id.resourceTitleTvSingleRdRecVPlacementResourcesF);
            resourceTvSingleRdRecVPlacementResourcesF = itemView.findViewById(R.id.resourceTvSingleRdRecVPlacementResourcesF);
        }
    }
}
