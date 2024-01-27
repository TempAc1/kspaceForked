package com.example.adminapp.NotiFragAdm;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class adapterRecVNotiFragAdm extends RecyclerView.Adapter<adapterRecVNotiFragAdm.myviewholder>{
    ArrayList<dataModelRecVFragNotiAdm> dataHolder;
    ArrayList<dataModelRecVFragNotiAdm> dataHolderBackup;

    public adapterRecVNotiFragAdm(ArrayList<dataModelRecVFragNotiAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup =  new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public adapterRecVNotiFragAdm.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design_rec_notif_adm
                ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapterRecVNotiFragAdm.myviewholder holder, int position) {
        holder.notiTxt.setText(dataHolder.get(position).getNotiTxt());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView notiTxt;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            notiTxt = itemView.findViewById(R.id.tvLinearLaySingleRowDesRecNotiFAdm);

            notiTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    Intent i = new Intent(activity.getApplicationContext(), NotiActMainScAdm.class);
                    activity.startActivity(i);
                }
            });
        }
    }
}