package com.example.knowledgespaceapk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class adapterRecVNotificationFrag extends RecyclerView.Adapter<adapterRecVNotificationFrag.myviewholder> {

    ArrayList<dataModelRecVFragNotification> dataHolder;
    ArrayList<dataModelRecVFragNotification> dataHolderBackup;

    public adapterRecVNotificationFrag(ArrayList<dataModelRecVFragNotification> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design_rec_notif
                                    ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
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

            notiTxt = itemView.findViewById(R.id.tvLinearLaySingleRowDesRecNotiF);

        } //End myViewHolder
    } //End classMyViewHolder
} //EndAdapter