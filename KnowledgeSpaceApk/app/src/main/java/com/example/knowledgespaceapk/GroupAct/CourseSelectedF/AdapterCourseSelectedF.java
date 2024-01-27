package com.example.knowledgespaceapk.GroupAct.CourseSelectedF;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.GroupAct.SpecificChapDetailsF.SpecificChapterDetailsF;
import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class AdapterCourseSelectedF extends RecyclerView.Adapter<AdapterCourseSelectedF.myviewholder>{

    ArrayList<DataModelCourseSelectedF> dataHolder;
    ArrayList<DataModelCourseSelectedF> dataHolderBackup;


    private NavController navController;

    public AdapterCourseSelectedF(NavController navController,ArrayList<DataModelCourseSelectedF> dataHolder) {
        this.navController = navController;
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resdes_recv_courseselected_f
                ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.chapterNameSingleRDCourseSelectedF.setText(dataHolder.get(position).getChapterName());
        holder.totalNoOfModulesTvSingleRDCourseSelectedF.setText(new StringBuilder().append("No Of Modules")
                .append(" : ").append(dataHolder.get(position).getTotalNoOfModules()).toString());

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder  extends RecyclerView.ViewHolder{

        TextView chapterNameSingleRDCourseSelectedF,totalNoOfModulesTvSingleRDCourseSelectedF;
        CardView cardVSingleResDesCourseSelectedF;
        FrameLayout parentFrameLayout;
        RecyclerView parentRecyclerView;
        FloatingActionButton parentFloatingBtns;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            chapterNameSingleRDCourseSelectedF = itemView.findViewById(R.id.chapterNameSingleRDCourseSelectedF);
            totalNoOfModulesTvSingleRDCourseSelectedF = itemView.findViewById(R.id.totalNoOfModulesTvSingleRDCourseSelectedF);

            //Access items of recyclerV:
            cardVSingleResDesCourseSelectedF =itemView.findViewById(R.id.cardVSingleRedDRecVCourseSelectedF);
            cardVSingleResDesCourseSelectedF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //ACCESS PARENT VIEW ITEM USING ACTIVITY CODE :
//                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                    parentFrameLayout = activity.findViewById(R.id.frameLayCourseSelectedF);
//                    parentRecyclerView = activity.findViewById(R.id.recyclerVCourseSelectedOpt);
//                    parentFrameLayout.setVisibility(View.VISIBLE);
//                    parentRecyclerView.setVisibility(View.GONE);
//                    parentFloatingBtns = activity.findViewById(R.id.floatingBtnCourseSelectedOpt);
//                    parentFloatingBtns.setVisibility(View.GONE);
//
//                    Fragment fragment = new SpecificChapterDetailsF();
//                    FragmentManager manager = activity.getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = manager.beginTransaction();
//                    fragmentTransaction.replace(R.id.frameLayCourseSelectedF, fragment).commit();

                    navController.navigate(R.id.action_courseSelectedF_to_specificChapterDetailsF);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
