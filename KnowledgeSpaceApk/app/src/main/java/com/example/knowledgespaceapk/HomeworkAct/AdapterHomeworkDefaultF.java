package com.example.knowledgespaceapk.HomeworkAct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterHomeworkDefaultF extends RecyclerView.Adapter<AdapterHomeworkDefaultF.myviewholder>{

    ArrayList<DataModelHomeworkDefaultF> dataHolder;
    ArrayList<DataModelHomeworkDefaultF> dataHolderBackup;

    public AdapterHomeworkDefaultF(ArrayList<DataModelHomeworkDefaultF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_rowdes_recv_homework_default_f,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.hwTitleHomeworkDefaultFrag.setText(dataHolder.get(position).getHwTitleHomeworkDefaultFrag());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView hwTitleHomeworkDefaultFrag;
        CardView cardVAndroidXSingleRdScholarship;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            hwTitleHomeworkDefaultFrag = itemView.findViewById(R.id.homeTitleTvSingleRdHomeworkDefaultFrag);

            cardVAndroidXSingleRdScholarship = itemView.findViewById(R.id.cardVAndroidXSingleRdScholarship);
            cardVAndroidXSingleRdScholarship.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayHomeworkMainAct,new HomeworkDetailsF());
                    fragmentTransaction.addToBackStack(String.valueOf(new HomeworkDetailsF()));
                    fragmentTransaction.commit();
                }
            });
        }
    }
}
