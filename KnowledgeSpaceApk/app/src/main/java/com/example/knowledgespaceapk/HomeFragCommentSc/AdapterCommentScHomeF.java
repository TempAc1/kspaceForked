package com.example.knowledgespaceapk.HomeFragCommentSc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterCommentScHomeF extends RecyclerView.Adapter<AdapterCommentScHomeF.MyViewHolder> {

    ArrayList<DataModelCommentScHomeF> dataHolder;
    ArrayList<DataModelCommentScHomeF> dataHolderBackup;

    public AdapterCommentScHomeF(ArrayList<DataModelCommentScHomeF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.single_resdes_recv_commentsc_homef,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.commentatorNameTVSingleRdRecVCommentScHomeFrag.setText(dataHolder.get(position).getCommentatorNameTVSingleRdRecVCommentScHomeFrag());
        holder.commentatorCommentTVSingleRdRecVCommentScHomeFrag.setText(dataHolder.get(position).getCommentatorCommentTVSingleRdRecVCommentScHomeFrag());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView commentatorCommentTVSingleRdRecVCommentScHomeFrag,commentatorNameTVSingleRdRecVCommentScHomeFrag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            commentatorNameTVSingleRdRecVCommentScHomeFrag = itemView.findViewById(R.id.commentatorNameTVSingleRdRecVCommentScHomeFrag);
            commentatorCommentTVSingleRdRecVCommentScHomeFrag = itemView.findViewById(R.id.commentatorNameTVSingleRdRecVCommentScHomeFrag);
        }
    }
}
