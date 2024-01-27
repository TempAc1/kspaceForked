package com.example.adminapp.PlacementActAdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class AdapterPlacementResourcesFAdm extends RecyclerView.Adapter<AdapterPlacementResourcesFAdm.myviewholder>{

    private ArrayList<DataModelRecVPlacementResourcesFAdm> dataHolder;
    private ArrayList<DataModelRecVPlacementResourcesFAdm> dataHolderBackup;

    public AdapterPlacementResourcesFAdm(ArrayList<DataModelRecVPlacementResourcesFAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_resdes_recv_placement_resources_fadm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.resourceTitleTvSingleRdRecVPlacementResourcesFAdm.setText(dataHolder.get(position).getResourceTitleTvSingleRdRecVPlacementResourcesFAdm());
        holder.resourceTvSingleRdRecVPlacementResourcesFAdm.setText(dataHolder.get(position).getResourceTvSingleRdRecVPlacementResourcesFAdm());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView resourceTitleTvSingleRdRecVPlacementResourcesFAdm,resourceTvSingleRdRecVPlacementResourcesFAdm;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            resourceTitleTvSingleRdRecVPlacementResourcesFAdm = itemView.findViewById(R.id.resourceTitleTvSingleRdRecVPlacementResourcesFAdm);
            resourceTvSingleRdRecVPlacementResourcesFAdm = itemView.findViewById(R.id.resourceTvSingleRdRecVPlacementResourcesFAdm);

        }
    }
}
