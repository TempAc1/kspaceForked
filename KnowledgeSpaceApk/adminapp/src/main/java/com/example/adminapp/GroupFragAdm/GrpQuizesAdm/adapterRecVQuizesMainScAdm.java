package com.example.adminapp.GroupFragAdm.GrpQuizesAdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class adapterRecVQuizesMainScAdm extends RecyclerView.Adapter<adapterRecVQuizesMainScAdm.myviewholder> {
    ArrayList<dataModelRecVQuizesMainScAdm> dataHolder;
    ArrayList<dataModelRecVQuizesMainScAdm> dataHolderBackup;

    public adapterRecVQuizesMainScAdm(ArrayList<dataModelRecVQuizesMainScAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_des_recv_quizes_mainsc_adm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.quizeTitleSingleRdsQuizesMainScAdm.setText(dataHolder.get(position).getQuizeTitleSingleRdsQuizesMainScAdm());
        holder.quizeDurationSingleRdsQuizesMainScAdm.setText(new StringBuffer().append("Quiz Duration : ").append(dataHolder.get(position).getQuizeDurationSingleRdsQuizesMainScAdm()));
        holder.totalNoQuestionsSingleRdsQuizesMainScAdm.setText(new StringBuffer().append("Total Questions : ").append(dataHolder.get(position).getTotalNoQuestionsSingleRdsQuizesMainScAdm()));
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView quizeTitleSingleRdsQuizesMainScAdm,quizeDurationSingleRdsQuizesMainScAdm,totalNoQuestionsSingleRdsQuizesMainScAdm;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            quizeTitleSingleRdsQuizesMainScAdm = itemView.findViewById(R.id.quizeTitleSingleRdsQuizesMainScAdm);
            quizeDurationSingleRdsQuizesMainScAdm = itemView.findViewById(R.id.quizeDurationSingleRdsQuizesMainScAdm);
            totalNoQuestionsSingleRdsQuizesMainScAdm = itemView.findViewById(R.id.totalNoQuestionsSingleRdsQuizesMainScAdm);
        }
    }
}
