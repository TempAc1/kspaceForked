package com.example.adminapp.ScholarshipAct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class adapterScholarshipActAdm extends RecyclerView.Adapter<adapterScholarshipActAdm.myviewholder> {

    ArrayList<dataModelRecVScholarshipActAdm> dataHolder;
    ArrayList<dataModelRecVScholarshipActAdm> dataHolderBackup;

    public adapterScholarshipActAdm(ArrayList<dataModelRecVScholarshipActAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup =  new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_des_scholarshipadm_act,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.titleTxtVSingleRdScholarshipActAdm.setText(dataHolder.get(position).getTitleTxtVSingleRdScholarshipActAdm());
        holder.linkTxtVSingleRdScholarshipActAdm.setText(dataHolder.get(position).getLinkTxtVSingleRdScholarshipActAdm());
        holder.imgVSingleRdScholarshipActAdm.setImageResource(dataHolder.get(position).getImgVSingleRdScholarshipActAdm());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView titleTxtVSingleRdScholarshipActAdm,linkTxtVSingleRdScholarshipActAdm;
        ImageView imgVSingleRdScholarshipActAdm;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            titleTxtVSingleRdScholarshipActAdm = itemView.findViewById(R.id.titleTxtVSingleRdScholarshipActAdm);
            linkTxtVSingleRdScholarshipActAdm = itemView.findViewById(R.id.linkTxtVSingleRdScholarshipActAdm);
            imgVSingleRdScholarshipActAdm = itemView.findViewById(R.id.imgVSingleRdScholarshipActAdm);
        }
    }
}
