package com.example.knowledgespaceapk.FeesAct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterRecVFeesHistF extends RecyclerView.Adapter<AdapterRecVFeesHistF.myviewholder> {

    private ArrayList<DataModelRecVFeesHistF> dataHolder;
    private ArrayList<DataModelRecVFeesHistF> dataHolderBackup;

    public AdapterRecVFeesHistF(ArrayList<DataModelRecVFeesHistF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_rowdes_recv_feeshist_f,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.paymentIdTvSingleRdRecVFeesHistF.setText(new StringBuilder().append(dataHolder.get(position).getPaymentIdTvSingleRdRecVFeesHistF()).append("").toString());
        holder.paymentDateNTimeTvSingleRdRecVFeesHistF.setText(dataHolder.get(position).getPaymentDateNTimeTvSingleRdRecVFeesHistF());
        holder.paymentTypeTvSingleRdRecVFeesHistF.setText(dataHolder.get(position).getPaymentTypeTvSingleRdRecVFeesHistF());
        holder.paymentAmountTvSingleRdRecVFeesHistF.setText(String.valueOf(dataHolder.get(position).getPaymentAmountTvSingleRdRecVFeesHistF()));
        holder.paymentStatusTvSingleRdRecVFeesHistF.setText(dataHolder.get(position).getPaymentStatusTvSingleRdRecVFeesHistF());
        holder.paymentStatusImgVSingleRdRecVFeesHistF.setImageResource(dataHolder.get(position).getPaymentStatusImgVSingleRdRecVFeesHistF());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView paymentIdTvSingleRdRecVFeesHistF,paymentDateNTimeTvSingleRdRecVFeesHistF,
                paymentTypeTvSingleRdRecVFeesHistF,paymentAmountTvSingleRdRecVFeesHistF,
                paymentStatusTvSingleRdRecVFeesHistF;
        ImageView paymentStatusImgVSingleRdRecVFeesHistF;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            paymentIdTvSingleRdRecVFeesHistF = itemView.findViewById(R.id.paymentIdTvSingleRdRecVFeesHistF);
            paymentDateNTimeTvSingleRdRecVFeesHistF = itemView.findViewById(R.id.paymentDateNTimeTvSingleRdRecVFeesHistF);
            paymentTypeTvSingleRdRecVFeesHistF = itemView.findViewById(R.id.paymentTypeTvSingleRdRecVFeesHistF);
            paymentAmountTvSingleRdRecVFeesHistF = itemView.findViewById(R.id.paymentAmountTvSingleRdRecVFeesHistF);
            paymentStatusTvSingleRdRecVFeesHistF = itemView.findViewById(R.id.paymentStatusTvSingleRdRecVFeesHistF);
            paymentStatusImgVSingleRdRecVFeesHistF = itemView.findViewById(R.id.paymentStatusImgVSingleRdRecVFeesHistF);
        }
    }
}
