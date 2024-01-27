package com.example.knowledgespaceapk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterRecVAttendanceAct extends RecyclerView.Adapter<adapterRecVAttendanceAct.holder> {

    ArrayList<dataModelRecVAttendanceAct> dataHolder;
    ArrayList<dataModelRecVAttendanceAct> dataHolderBackup;

    public adapterRecVAttendanceAct(ArrayList<dataModelRecVAttendanceAct> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row_design_rec_attendance,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.subName.setText(dataHolder.get(position).getSubName());
        holder.pName.setText(dataHolder.get(position).getpName());
        holder.subAttendance.setText(Integer.toString(dataHolder.get(position).getSubAttendance()));
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class holder extends RecyclerView.ViewHolder {

        TextView subName,pName,subAttendance;

        public holder(@NonNull View itemView) {
            super(itemView);

            subName = itemView.findViewById(R.id.tVSubNameAttendanceAct);
            pName = itemView.findViewById(R.id.tVPNameAttendance);
            subAttendance = itemView.findViewById(R.id.tVPSubAttendance);
        }
    }
}
