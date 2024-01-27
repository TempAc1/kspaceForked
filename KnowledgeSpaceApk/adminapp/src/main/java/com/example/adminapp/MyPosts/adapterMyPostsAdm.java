package com.example.adminapp.MyPosts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class adapterMyPostsAdm extends RecyclerView.Adapter<adapterMyPostsAdm.myviewholder> {

    ArrayList<dataModelRecVMyPostsAdm> dataHolder;
    ArrayList<dataModelRecVMyPostsAdm> dataHolderBackup;

    public adapterMyPostsAdm(ArrayList<dataModelRecVMyPostsAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_des_mypost_adm,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.postTitleTvSingleRdMyPostActAdm.setText(dataHolder.get(position).getPostTitleTvSingleRdMyPostActAdm());
        holder.postDesTvSingleRdMyPostActAdm.setText(dataHolder.get(position).getPostDesTvSingleRdMyPostActAdm());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        CardView cardVSingleRowDesMyPostAdm;
        TextView postTitleTvSingleRdMyPostActAdm,postDesTvSingleRdMyPostActAdm;
        FrameLayout parentFrameLayout;
        RecyclerView parentRecyclerView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            postTitleTvSingleRdMyPostActAdm =itemView.findViewById(R.id.postTitleTvSingleRdMyPostActAdm);
            postDesTvSingleRdMyPostActAdm = itemView.findViewById(R.id.postDesTvSingleRdMyPostActAdm);
            
            //Access items of recyclerV here:
            cardVSingleRowDesMyPostAdm = itemView.findViewById(R.id.cardVSingleRowDesMyPostAdm);
            cardVSingleRowDesMyPostAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //ACCESS PARENT VIEW ITEM USING ACTIVITY CODE :
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    parentFrameLayout = activity.findViewById(R.id.frameLayMyPostActAdm);
                    parentRecyclerView = activity.findViewById(R.id.recyclerVMyPostActAdm);
                    parentFrameLayout.setVisibility(View.VISIBLE);
                    parentRecyclerView.setVisibility(View.GONE);


                    Fragment fragment = new SinglePostFragMyPostActAdm();
                    FragmentManager manager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = manager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayMyPostActAdm, fragment).commit();
                }
            });
        
        }
    }
}
