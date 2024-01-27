package com.example.knowledgespaceapk.GroupAct.DiscussionPanel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;
import com.google.android.material.circularreveal.cardview.CircularRevealCardView;

import java.util.ArrayList;

public class AdapterDiscussionPanelF extends RecyclerView.Adapter<AdapterDiscussionPanelF.myviewholder>{

    private ArrayList<DataModelRecVDiscussionPanelF> dataHolder;
    private ArrayList<DataModelRecVDiscussionPanelF> dataHolderBackup;

    public AdapterDiscussionPanelF(ArrayList<DataModelRecVDiscussionPanelF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup  = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_des_recv_dispanel_mainsc_f,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.titleTvSingleRDDisPanelMainScF.setText(dataHolder.get(position).getTitle());
        holder.descripTvSingleRDDisPanelMainScF.setText(dataHolder.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        CircularRevealCardView circularCardVSingleRDDisPanelMainScF;
        TextView titleTvSingleRDDisPanelMainScF,descripTvSingleRDDisPanelMainScF;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            circularCardVSingleRDDisPanelMainScF = itemView.findViewById(R.id.circularCardVSingleRDDisPanelMainScF);
            titleTvSingleRDDisPanelMainScF = itemView.findViewById(R.id.titleTvSingleRDDisPanelMainScF);
            descripTvSingleRDDisPanelMainScF = itemView.findViewById(R.id.descripTvSingleRDDisPanelMainScF);
        }
    }
}
