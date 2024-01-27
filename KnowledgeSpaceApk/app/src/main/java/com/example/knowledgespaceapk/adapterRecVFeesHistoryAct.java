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

public class adapterRecVFeesHistoryAct extends RecyclerView.Adapter<adapterRecVFeesHistoryAct.myviewholder> {

    ArrayList<dataModelRecVFeesHistory> userDataList;

    public adapterRecVFeesHistoryAct(ArrayList<dataModelRecVFeesHistory> userDataList) {
        this.userDataList = userDataList;
    }

    @NonNull
    @Override
    public adapterRecVFeesHistoryAct.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_design_rec_fees_historyact,parent,false);
        return new myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterRecVFeesHistoryAct.myviewholder holder, int position) {
        holder.transactionStatusImgV.setImageResource(userDataList.get(position).getTransactionStatusImgV());
        holder.typeOfFeesFeesHistTV.setText(userDataList.get(position).getTypeOfFeesFeesHistTV());
        holder.feesAmtFeesHistTV.setText(userDataList.get(position).getFeesAmtFeesHistTV());
        holder.transStatusFeesHistTV.setText(userDataList.get(position).getTransStatusFeesHistTV());
        holder.orderIDFeesHistTV.setText(userDataList.get(position).getOrderIDFeesHistTV());
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView typeOfFeesFeesHistTV, feesAmtFeesHistTV, transStatusFeesHistTV,orderIDFeesHistTV;
        ImageView transactionStatusImgV;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            transactionStatusImgV = itemView.findViewById(R.id.transactionStatusImgV);
            typeOfFeesFeesHistTV =itemView.findViewById(R.id.typeOfFeesFeesHistTV);
            feesAmtFeesHistTV = itemView.findViewById(R.id.feesAmtFeesHistTV);
            transStatusFeesHistTV = itemView.findViewById(R.id.transStatusFeesHistTV);
            orderIDFeesHistTV = itemView.findViewById(R.id.orderIDFeesHistTV);

        }
    }
}//End adapter
