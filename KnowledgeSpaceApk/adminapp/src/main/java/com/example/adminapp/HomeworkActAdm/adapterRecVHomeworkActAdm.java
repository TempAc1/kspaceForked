package com.example.adminapp.HomeworkActAdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class adapterRecVHomeworkActAdm extends RecyclerView.Adapter<adapterRecVHomeworkActAdm.myviewholder> {

    ArrayList<dataModelRecVHomeworkActAdm> dataHolder;
    ArrayList<dataModelRecVHomeworkActAdm> dataHolderBackup;

    public adapterRecVHomeworkActAdm(ArrayList<dataModelRecVHomeworkActAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_des_homeworkdefault_fragadm,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.hwTitleHomeworkDefaultFragAdm.setText(dataHolder.get(position).getHwTitleHomeworkDefaultFragAdm());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView hwTitleHomeworkDefaultFragAdm;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            hwTitleHomeworkDefaultFragAdm = itemView.findViewById(R.id.homeTitleTvSingleRdHomeworkDefaultFragAdm);
        }
    }
}
