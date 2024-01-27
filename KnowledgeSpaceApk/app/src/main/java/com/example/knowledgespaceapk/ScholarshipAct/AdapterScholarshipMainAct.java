package com.example.knowledgespaceapk.ScholarshipAct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterScholarshipMainAct  extends RecyclerView.Adapter<AdapterScholarshipMainAct.myviewholder>{

    ArrayList<DataModelScholarMainAct> dataHolder;
    ArrayList<DataModelScholarMainAct> dataHolderBackup;

    public AdapterScholarshipMainAct(ArrayList<DataModelScholarMainAct> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup =  new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_des_scholarship,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.titleTxtVSingleRdScholarshipAct.setText(dataHolder.get(position).getTitleTxtVSingleRdScholarshipAct());
        holder.linkTxtVSingleRdScholarshipAct.setText(dataHolder.get(position).getLinkTxtVSingleRdScholarshipAct());
        holder.imgVSingleRdScholarshipAct.setImageResource(dataHolder.get(position).getImgVSingleRdScholarshipAct());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView titleTxtVSingleRdScholarshipAct,linkTxtVSingleRdScholarshipAct;
        ImageView imgVSingleRdScholarshipAct;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            titleTxtVSingleRdScholarshipAct = itemView.findViewById(R.id.titleTxtVSingleRdScholarshipAct);
            linkTxtVSingleRdScholarshipAct = itemView.findViewById(R.id.linkTxtVSingleRdScholarshipAct);
            imgVSingleRdScholarshipAct = itemView.findViewById(R.id.imgVSingleRdScholarshipAct);
        }
    }
}
