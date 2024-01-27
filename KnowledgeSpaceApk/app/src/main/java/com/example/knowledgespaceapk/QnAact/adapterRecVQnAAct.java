package com.example.knowledgespaceapk.QnAact;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.QnAact.CommentSc.QNAnsCommentAct;
import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class adapterRecVQnAAct extends RecyclerView.Adapter<adapterRecVQnAAct.holder> {

    ArrayList<dataModelRecVQnAAct> dataHolder;
    ArrayList<dataModelRecVQnAAct> dataHolderBackup;

    public void setFilteredList(ArrayList<dataModelRecVQnAAct> filteredList){
        this.dataHolder = filteredList;
        notifyDataSetChanged();
    }

    public adapterRecVQnAAct(ArrayList<dataModelRecVQnAAct> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup =  new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  =   inflater.inflate(R.layout.single_row_design_qand_n_act,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.titleTv.setText(dataHolder.get(position).getTitle());
        holder.descriptionTv.setText(dataHolder.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        TextView titleTv,descriptionTv;
        ImageView commentImgVSingleRDesRecQnAAct,likeImgVSingleRDesRecQnAAct;

        public holder(@NonNull View itemView) {
            super(itemView);
            titleTv =  itemView.findViewById(R.id.titleTxtVSingleRDesQnAAct);
            descriptionTv = itemView.findViewById(R.id.descriptionTxtVSingleRDesRecQnNAct);

            commentImgVSingleRDesRecQnAAct = itemView.findViewById(R.id.commentImgVSingleRDesRecQnAnsAct);
            AppCompatActivity appCompatActivity = (AppCompatActivity) itemView.getContext();
            commentImgVSingleRDesRecQnAAct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appCompatActivity.startActivity(new Intent(v.getContext(), QNAnsCommentAct.class));
                }
            });

            likeImgVSingleRDesRecQnAAct = itemView.findViewById(R.id.likeImgVSingleRDesRecQnAAct);
            likeImgVSingleRDesRecQnAAct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(appCompatActivity, "Upvoted No Backend", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
