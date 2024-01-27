package com.example.adminapp.GroupFragAdm;

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

import com.example.adminapp.MyPosts.SinglePostFragMyPostActAdm;
import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class adapterRecVCourseSelectedFAdm extends RecyclerView.Adapter<adapterRecVCourseSelectedFAdm.myviewholder> {

    ArrayList<dataModelRecVCourseSelectedFAdm> dataHolder;
    ArrayList<dataModelRecVCourseSelectedFAdm> dataHolderBackup;

    public adapterRecVCourseSelectedFAdm(ArrayList<dataModelRecVCourseSelectedFAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_des_course_selectedf_adm
                        ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.chapterNameSingleRDCourseSelectedFAdm.setText(dataHolder.get(position).getChapterName());
        holder.totalNoOfModulesTvSingleRDCourseSelectedFAdm.setText(new StringBuilder().append("No Of Modules")
                .append(" : ").append(dataHolder.get(position).getTotalNoOfModules()).toString());


    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView chapterNameSingleRDCourseSelectedFAdm,totalNoOfModulesTvSingleRDCourseSelectedFAdm;
        CardView cardVSingleResDesCourseSelectedFAdm;
        FrameLayout parentFrameLayout;
        RecyclerView parentRecyclerView;
        FloatingActionButton parentFloatingBtns;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            chapterNameSingleRDCourseSelectedFAdm = itemView.findViewById(R.id.chapterNameSingleRDCourseSelectedFAdm);
            totalNoOfModulesTvSingleRDCourseSelectedFAdm = itemView.findViewById(R.id.totalNoOfModulesTvSingleRDCourseSelectedFAdm);


            //Access items of recyclerV:
            cardVSingleResDesCourseSelectedFAdm =itemView.findViewById(R.id.cardVSingleResDesCourseSelectedFAdm);
            cardVSingleResDesCourseSelectedFAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //ACCESS PARENT VIEW ITEM USING ACTIVITY CODE :
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    parentFrameLayout = activity.findViewById(R.id.parentFrameLayCourseSelectedOptFAdm);
                    parentRecyclerView = activity.findViewById(R.id.recyclerVCourseSelectedOptAdm);
                    parentFrameLayout.setVisibility(View.VISIBLE);
                    parentRecyclerView.setVisibility(View.GONE);
                    parentFloatingBtns = activity.findViewById(R.id.floatingBtnCourseSelectedOptAdm);
                    parentFloatingBtns.setVisibility(View.GONE);


                    Fragment fragment = new SpecificChapterDetailsFAdm();
                    FragmentManager manager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = manager.beginTransaction();
                    fragmentTransaction.replace(R.id.parentFrameLayCourseSelectedOptFAdm, fragment).commit();
                }
            });
        }
    }
}
