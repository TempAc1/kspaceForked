package com.example.knowledgespaceapk.Alumni.Opportunity;

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

import com.example.knowledgespaceapk.Alumni.Opportunity.SingleOpportunity.SingleOpportunityF;
import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterOpportunityF extends RecyclerView.Adapter<AdapterOpportunityF.myviewholder> {

    ArrayList<DataModelOpportunityF> dataHolder;
    ArrayList<DataModelOpportunityF> dataHolderBackup;

    public AdapterOpportunityF(ArrayList<DataModelOpportunityF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_rowd_recv_alumniopportunity_f,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.opportunityTitleTvSingleRdRecVF.setText(dataHolder.get(position).getOpportunityTitleTvSingleRdRecVF());
        holder.opportunityDescTvSingleRdRecVF.setText(dataHolder.get(position).getOpportunityDescTvSingleRdRecVF());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        CardView cardVSingleRDRecVAlumniOpportunityF;
        TextView opportunityTitleTvSingleRdRecVF,opportunityDescTvSingleRdRecVF;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            opportunityTitleTvSingleRdRecVF = itemView.findViewById(R.id.opportunityTitleTvSingleRdRecVF);
            opportunityDescTvSingleRdRecVF = itemView.findViewById(R.id.opportunityDescTvSingleRdRecVF);



            cardVSingleRDRecVAlumniOpportunityF = itemView.findViewById(R.id.cardVSingleRDRecVAlumniOpportunityF);
            cardVSingleRDRecVAlumniOpportunityF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final NavController navController = Navigation.findNavController(itemView);
                    navController.navigate(R.id.action_alumniOpportunityFrag_to_singleOpportunityF);
                }
            });

        }
    }

}
