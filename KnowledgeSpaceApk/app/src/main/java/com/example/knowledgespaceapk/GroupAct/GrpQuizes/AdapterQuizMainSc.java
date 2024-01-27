package com.example.knowledgespaceapk.GroupAct.GrpQuizes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterQuizMainSc extends RecyclerView.Adapter<AdapterQuizMainSc.myviewholder>{

    ArrayList<DataModelRecVQuizMainSc> dataHolder;
    ArrayList<DataModelRecVQuizMainSc> dataHolderBackup;

    public AdapterQuizMainSc(ArrayList<DataModelRecVQuizMainSc> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_des_recv_quizes_mainsc,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.quizeTitleSingleRdsQuizesMainSc.setText(dataHolder.get(position).getQuizeTitleSingleRdsQuizesMainSc());
        holder.quizeDurationSingleRdsQuizesMainSc.setText(new StringBuffer().append("Quiz Duration : ").append(dataHolder.get(position).getQuizeDurationSingleRdsQuizesMainSc()));
        holder.totalNoQuestionsSingleRdsQuizesMainSc.setText(new StringBuffer().append("Total Questions : ").append(dataHolder.get(position).getTotalNoQuestionsSingleRdsQuizesMainSc()));
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView quizeTitleSingleRdsQuizesMainSc,quizeDurationSingleRdsQuizesMainSc,totalNoQuestionsSingleRdsQuizesMainSc;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            quizeTitleSingleRdsQuizesMainSc = itemView.findViewById(R.id.quizeTitleSingleRdsQuizesMainSc);
            quizeDurationSingleRdsQuizesMainSc = itemView.findViewById(R.id.quizeDurationSingleRdsQuizesMainSc);
            totalNoQuestionsSingleRdsQuizesMainSc = itemView.findViewById(R.id.totalNoQuestionsSingleRdsQuizesMainSc);
        }
    }
}
