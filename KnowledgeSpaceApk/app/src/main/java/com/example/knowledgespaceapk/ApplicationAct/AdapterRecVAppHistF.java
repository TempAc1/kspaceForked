package com.example.knowledgespaceapk.ApplicationAct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterRecVAppHistF extends RecyclerView.Adapter<AdapterRecVAppHistF.myviewholder> {

    private ArrayList<DataModelRecVAppHistF> dataHolder;
    private ArrayList<DataModelRecVAppHistF> dataHolderBackup;

    public AdapterRecVAppHistF(ArrayList<DataModelRecVAppHistF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_rowdes_recv_apphist_f,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.applicationSenderIdTvSingleRdRecVAppHistF.setText(dataHolder.get(position).getApplicationSenderIdTvSingleRdRecVAppHistF());
        holder.appSubjectTvSingleRdRecVAppHistF.setText(dataHolder.get(position).getAppSubjectTvSingleRdRecVAppHistF());
        holder.appDescTvSingleRdRecVAppHistF.setText(dataHolder.get(position).getAppDescTvSingleRdRecVAppHistF());
        holder.applicationStatusTvAppHistF.setText(dataHolder.get(position).getApplicationStatusTvAppHistF());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView applicationSenderIdTvSingleRdRecVAppHistF,appSubjectTvSingleRdRecVAppHistF,
                appDescTvSingleRdRecVAppHistF,applicationStatusTvAppHistF;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            applicationSenderIdTvSingleRdRecVAppHistF = itemView.findViewById(R.id.applicationSenderIdTvSingleRdRecVAppHistF);
            appSubjectTvSingleRdRecVAppHistF = itemView.findViewById(R.id.appSubjectTvSingleRdRecVAppHistF);
            appDescTvSingleRdRecVAppHistF = itemView.findViewById(R.id.appDescTvSingleRdRecVAppHistF);
            applicationStatusTvAppHistF = itemView.findViewById(R.id.applicationStatusTvAppHistF);
        }
    }
}