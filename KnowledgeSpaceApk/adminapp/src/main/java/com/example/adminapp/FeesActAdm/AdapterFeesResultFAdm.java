package com.example.adminapp.FeesActAdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class AdapterFeesResultFAdm extends RecyclerView.Adapter<AdapterFeesResultFAdm.myviewholder> {

    private ArrayList<DataModelRecVFeesResultFAdm> dataHolder;
    private ArrayList<DataModelRecVFeesResultFAdm> dataHolderBackup;

    public AdapterFeesResultFAdm(ArrayList<DataModelRecVFeesResultFAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_resdes_recv_fees_resultf_feesact_adm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.stdIdTvSingleRDRecVFeesResultFeesActAdm.setText(new StringBuilder().append(dataHolder.get(position).getStdIdTvSingleRDRecVFeesResultFeesActAdm()).append("").toString());
        holder.stdNameTvSingleRDRecVFeesResultFeesActAdm.setText(dataHolder.get(position).getStdNameTvSingleRDRecVFeesResultFeesActAdm());
        holder.feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm.setText(new StringBuilder().append(dataHolder.get(position).getFeeAmountPaidTvSingleRDRecVFeesResultFeesActAdm()).append("").toString());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView stdIdTvSingleRDRecVFeesResultFeesActAdm,stdNameTvSingleRDRecVFeesResultFeesActAdm,
                feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            stdIdTvSingleRDRecVFeesResultFeesActAdm = itemView.findViewById(R.id.stdIdTvSingleRDRecVFeesResultFeesActAdm);
            stdNameTvSingleRDRecVFeesResultFeesActAdm = itemView.findViewById(R.id.stdNameTvSingleRDRecVFeesResultFeesActAdm);
            feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm = itemView.findViewById(R.id.feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm);
        }
    }
}
