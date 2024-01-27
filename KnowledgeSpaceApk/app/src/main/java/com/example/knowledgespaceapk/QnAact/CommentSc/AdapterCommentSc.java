package com.example.knowledgespaceapk.QnAact.CommentSc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterCommentSc extends RecyclerView.Adapter<AdapterCommentSc.myViewHolder> {

    ArrayList<DataModelCommentSc> dataHolder;
    ArrayList<DataModelCommentSc> dataHolderBackup;

    public AdapterCommentSc(ArrayList<DataModelCommentSc> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_resdes_commentsc,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.commentorNameTVSingleRdRecVCommentSc.setText(dataHolder.get(position).getCommentatorName());
        holder.commentorRemarkTVSingleRdRecVCommentSc.setText(dataHolder.get(position).getCommentatorRemarks());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView commentorNameTVSingleRdRecVCommentSc,commentorRemarkTVSingleRdRecVCommentSc;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            commentorNameTVSingleRdRecVCommentSc = itemView.findViewById(R.id.commentorNameTVSingleRdRecVCommentSc);
            commentorRemarkTVSingleRdRecVCommentSc = itemView.findViewById(R.id.commentorCommentTVSingleRdRecVCommentSc);

        }
    }
}
