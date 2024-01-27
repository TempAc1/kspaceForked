package com.example.adminapp.PlacementActAdm;

import android.text.method.LinkMovementMethod;
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
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class AdapterPlacementDefaultFAdm extends RecyclerView.Adapter<AdapterPlacementDefaultFAdm.myviewholder> {
    
    ArrayList<DataModelRecVPlacementDefaultFAdm> dataHolder;
    ArrayList<DataModelRecVPlacementDefaultFAdm> dataHolderBackup;

    public AdapterPlacementDefaultFAdm(ArrayList<DataModelRecVPlacementDefaultFAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resd_recv_placementdefault_fadm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.companyTitleTvSingleRdRecVPlacementDefaultFAdm.setText(dataHolder.get(position).getCompanyTitleTvSingleRdRecVPlacementDefaultFAdm());
        holder.offerDescriptionTvSingleRdRecVPlacementDefaultFAdm.setText(dataHolder.get(position).getOfferDescriptionTvSingleRdRecVPlacementDefaultFAdm());
        holder.regLinkTvSingleRdRecVPlacementDefaultFAdm.setText(dataHolder.get(position).getRegLinkTvSingleRdRecVPlacementDefaultFAdm());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        
        TextView companyTitleTvSingleRdRecVPlacementDefaultFAdm,offerDescriptionTvSingleRdRecVPlacementDefaultFAdm,
                regLinkTvSingleRdRecVPlacementDefaultFAdm;
        CardView androidXCardVSingleRdRecVPlacementDefaultFAdm;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            companyTitleTvSingleRdRecVPlacementDefaultFAdm = itemView.findViewById(R.id.applicationSenderIdTvSingleRdRecVApplicationDefaultFAdm);
            offerDescriptionTvSingleRdRecVPlacementDefaultFAdm = itemView.findViewById(R.id.appTitleTvSingleRdRecVApplicationDefaultFAdm);
            regLinkTvSingleRdRecVPlacementDefaultFAdm = itemView.findViewById(R.id.appDescTvSingleRdRecVApplicationDefaultFAdm);

            regLinkTvSingleRdRecVPlacementDefaultFAdm.setMovementMethod(LinkMovementMethod.getInstance());

            androidXCardVSingleRdRecVPlacementDefaultFAdm = itemView.findViewById(R.id.androidXCardVSingleRdRecVPlacementDefaultFAdm);
            androidXCardVSingleRdRecVPlacementDefaultFAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FrameLayout fl = activity.findViewById(R.id.frameLayPlacementMainActAdm);
                    fl.removeAllViews();
                    Fragment fr = new PlacementOfferDetailsFAdm();
                    FragmentManager fm = activity.getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frameLayPlacementMainActAdm,fr).commit();
                    ft.addToBackStack(null);
                }
            });

        }


    }
}
