package com.example.adminapp.GroupFragAdm.DiscussionPanelFragAdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;
import com.google.android.material.circularreveal.cardview.CircularRevealCardView;

import java.util.ArrayList;

public class adapterRecVDisPanelMainSc extends RecyclerView.Adapter<adapterRecVDisPanelMainSc.myviewholder> {

    private ArrayList<DiscussionPanelData> dataHolder;
    private ArrayList<DiscussionPanelData> dataHolderBackup;

    public adapterRecVDisPanelMainSc(ArrayList<DiscussionPanelData> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_des_recv_dispanel_mainsc_fadm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.titleTvSingleRDDisPanelMainScFAdm.setText(dataHolder.get(position).getTitle());
        holder.descripTvSingleRDDisPanelMainScFAdm.setText(dataHolder.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        CircularRevealCardView circularCardVSingleRDDisPanelMainScFAdm;
        TextView titleTvSingleRDDisPanelMainScFAdm,descripTvSingleRDDisPanelMainScFAdm;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            circularCardVSingleRDDisPanelMainScFAdm = itemView.findViewById(R.id.circularCardVSingleRDDisPanelMainScFAdm);
            titleTvSingleRDDisPanelMainScFAdm = itemView.findViewById(R.id.titleTvSingleRDDisPanelMainScFAdm);
            descripTvSingleRDDisPanelMainScFAdm = itemView.findViewById(R.id.descripTvSingleRDDisPanelMainScFAdm);
        }
    }
}
