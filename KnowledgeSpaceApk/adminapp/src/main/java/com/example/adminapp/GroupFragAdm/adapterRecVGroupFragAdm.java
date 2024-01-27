package com.example.adminapp.GroupFragAdm;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;
import com.google.android.material.card.MaterialCardView;


import java.util.ArrayList;

public class adapterRecVGroupFragAdm extends RecyclerView.Adapter<adapterRecVGroupFragAdm.myviewholder> {
    ArrayList<dataModelRecVGroupFragAdm> dataHolder;
    ArrayList<dataModelRecVGroupFragAdm> dataHolderBackup;

    public adapterRecVGroupFragAdm(ArrayList<dataModelRecVGroupFragAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup =  new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design_recv_groupf_adm
                ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
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
        MaterialCardView materialCardVSingleRDRecVGrpFAdm;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            groupName1 = itemView.findViewById(R.id.tVSingRDResGrpFAdm);
            groupName2 = itemView.findViewById(R.id.tVSingRDRecGrpF1Adm);
            groupIcon1 = itemView.findViewById(R.id.imgVSingRDRecGrpFAdm);
            groupIcon2 = itemView.findViewById(R.id.imgVSingRDRecGrpF1Adm);
            materialCardVSingleRDRecVGrpFAdm = itemView.findViewById(R.id.materialCardVSingleRDRecVGrpFAdm);


            materialCardVSingleRDRecVGrpFAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Intent i = new Intent(activity.getApplicationContext(),FragmentHolderActGrpAdm.class);
                    activity.startActivity(i);
                }
            });
        }
    }
}
