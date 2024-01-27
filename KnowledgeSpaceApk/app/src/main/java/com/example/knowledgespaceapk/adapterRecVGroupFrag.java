package com.example.knowledgespaceapk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterRecVGroupFrag extends RecyclerView.Adapter<adapterRecVGroupFrag.myviewholder> {


    ArrayList<dataModelRecVFragGroup> dataHolder;
    ArrayList<dataModelRecVFragGroup> dataHolderBackup;

    public adapterRecVGroupFrag(ArrayList<dataModelRecVFragGroup> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public adapterRecVGroupFrag.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design_rec_groupf
                                            ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapterRecVGroupFrag.myviewholder holder, int position) {
        holder.groupIcon1.setImageResource(dataHolder.get(position).getGroupImg1());
        holder.groupName1.setText(dataHolder.get(position).getGroupName1());
        holder.groupIcon2.setImageResource(dataHolder.get(position).getGroupImg2());
        holder.groupName2.setText(dataHolder.get(position).getGroupName2());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView groupName1,groupName2;
        ImageView groupIcon1,groupIcon2;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            groupName1 = itemView.findViewById(R.id.tVSingRDResGrpF);
            groupName2 = itemView.findViewById(R.id.tVSingRDRecGrpF1);
            groupIcon1 = itemView.findViewById(R.id.imgVSingRDRecGrpF);
            groupIcon2 = itemView.findViewById(R.id.imgVSingRDRecGrpF1);
        }
    }
}
