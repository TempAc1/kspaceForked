package com.example.knowledgespaceapk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterRecVFeeHistoryFrag extends RecyclerView.Adapter<adapterRecVFeeHistoryFrag.MyViewHolder> {
    ArrayList<dataModelRecVFeeHistoryFrag> feeHistoryArrayList;

    public adapterRecVFeeHistoryFrag(ArrayList<dataModelRecVFeeHistoryFrag> feeHistoryArrayList) {
        this.feeHistoryArrayList = feeHistoryArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design_rec_fees_historyf,
                                                parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        dataModelRecVFeeHistoryFrag feeHistory = feeHistoryArrayList.get(position);
        holder.txtVSingleRDFeeHist.setText(feeHistoryArrayList.get(position).getFeeHistoryDetails());
        holder.imgVSingleRDFeeHist.setImageResource(feeHistoryArrayList.get(position).getTransactionStatus());
    }

    @Override
    public int getItemCount() {
        return feeHistoryArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtVSingleRDFeeHist;   ImageView imgVSingleRDFeeHist;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVSingleRDFeeHist = itemView.findViewById(R.id.txtVSingleRDFeeHist);
            imgVSingleRDFeeHist = itemView.findViewById(R.id.imgVSingleRDFeeHist);

        }
    }
}
