package com.example.adminapp.UsersCommentScAdm;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class adapterUsersCommentScAdm extends RecyclerView.Adapter<adapterUsersCommentScAdm.MyHolder> {


    Context context;
    ArrayList<dataModelUsersCommentScAdm> arrayList;

    public adapterUsersCommentScAdm(Context context, ArrayList<dataModelUsersCommentScAdm> arrayList, String myuid, String postid) {
        this.context = context;
        this.arrayList = arrayList;
        this.myuid = myuid;
        this.postid = postid;
    }

    String myuid;
    String postid;


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.users_comment_scadm, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final String uid = arrayList.get(position).getUid();
        String name = arrayList.get(position).getUname();
        String email = arrayList.get(position).getUemail();
        String image = arrayList.get(position).getUdp();
        final String cid = arrayList.get(position).getcId();
        String comment = arrayList.get(position).getComment();
        String timestamp = arrayList.get(position).getPtime();
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
//        calendar.setTimeInMillis(Long.parseLong(timestamp));
        String timedate = DateFormat.format("dd/MM/yyyy hh:mm aa", calendar).toString();

        holder.name.setText(name);
        holder.time.setText(timedate);
        holder.comment.setText(comment);
//        try {
//            Glide.with(context).load(image).into(holder.imagea);
//        } catch (Exception e) {
//
//        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ImageView imagea;
        TextView name, comment, time;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagea = itemView.findViewById(R.id.loadcomment);
            name = itemView.findViewById(R.id.commentname);
            comment = itemView.findViewById(R.id.commenttext);
            time = itemView.findViewById(R.id.commenttime);
        }
    }
}
