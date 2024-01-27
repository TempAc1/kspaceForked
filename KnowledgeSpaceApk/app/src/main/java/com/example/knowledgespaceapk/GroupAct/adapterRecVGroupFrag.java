package com.example.knowledgespaceapk.GroupAct;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;
import com.google.android.material.card.MaterialCardView;

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
        holder.groupIcon.setImageResource(dataHolder.get(position).getGroupImg());
        holder.groupName.setText(dataHolder.get(position).getGroupName());

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView groupName;
        ImageView groupIcon;
        MaterialCardView cardVSingleRowDesRecVGrpF;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.tVSingRDResGrpF);

            groupIcon = itemView.findViewById(R.id.imgVSingRDRecGrpF);


            cardVSingleRowDesRecVGrpF = itemView.findViewById(R.id.cardVSingleRowDesRecVGrpF);
            cardVSingleRowDesRecVGrpF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Intent i = new Intent(activity.getApplicationContext(), GroupScHolderAct.class);
                    activity.startActivity(i);
                }
            });
        }
    }
}
