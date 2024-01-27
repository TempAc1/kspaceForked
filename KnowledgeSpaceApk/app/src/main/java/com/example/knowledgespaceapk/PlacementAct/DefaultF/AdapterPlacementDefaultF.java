package com.example.knowledgespaceapk.PlacementAct.DefaultF;

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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.PlacementAct.PlacementOfferDetailsF;
import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterPlacementDefaultF extends RecyclerView.Adapter<AdapterPlacementDefaultF.myviewholder> {

    ArrayList<DataModelPlacementDefaultF> dataHolder;
    ArrayList<DataModelPlacementDefaultF> dataHolderBackup;

    public AdapterPlacementDefaultF(ArrayList<DataModelPlacementDefaultF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resdes_recv_placementdefault_f,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.companyTitleTvSingleRdRecVPlacementDefaultF.setText(dataHolder.get(position).getCompanyTitleTvSingleRdRecVPlacementDefaultF());
        holder.offerDescriptionTvSingleRdRecVPlacementDefaultF.setText(dataHolder.get(position).getOfferDescriptionTvSingleRdRecVPlacementDefaultF());
        holder.regLinkTvSingleRdRecVPlacementDefaultF.setText(dataHolder.get(position).getRegLinkTvSingleRdRecVPlacementDefaultF());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView companyTitleTvSingleRdRecVPlacementDefaultF,offerDescriptionTvSingleRdRecVPlacementDefaultF,
                regLinkTvSingleRdRecVPlacementDefaultF;
        CardView androidXCardVSingleRdRecVPlacementDefaultF;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            companyTitleTvSingleRdRecVPlacementDefaultF = itemView.findViewById(R.id.applicationSenderIdTvSingleRdRecVApplicationDefaultF);
            offerDescriptionTvSingleRdRecVPlacementDefaultF = itemView.findViewById(R.id.appTitleTvSingleRdRecVApplicationDefaultF);
            regLinkTvSingleRdRecVPlacementDefaultF = itemView.findViewById(R.id.appDescTvSingleRdRecVApplicationDefaultF);

            regLinkTvSingleRdRecVPlacementDefaultF.setMovementMethod(LinkMovementMethod.getInstance());

            androidXCardVSingleRdRecVPlacementDefaultF = itemView.findViewById(R.id.androidXCardVSingleRdRecVPlacementDefaultF);
            androidXCardVSingleRdRecVPlacementDefaultF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();

                    final NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_placementMainScF_to_placementOfferDetailsF);

//                    FrameLayout fl = activity.findViewById(R.id.frameLayPlacementMainAct);
//                    fl.removeAllViews();
//                    Fragment fr = new PlacementOfferDetailsF();
//                    FragmentManager fm = activity.getSupportFragmentManager();
//                    FragmentTransaction ft = fm.beginTransaction();
//                    ft.replace(R.id.frameLayPlacementMainAct,fr).commit();
//                    ft.addToBackStack(null);
                }
            });

        }
    }
}
