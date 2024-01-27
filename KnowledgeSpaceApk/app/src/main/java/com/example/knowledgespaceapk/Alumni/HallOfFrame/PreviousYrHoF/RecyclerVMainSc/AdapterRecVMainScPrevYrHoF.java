package com.example.knowledgespaceapk.Alumni.HallOfFrame.PreviousYrHoF.RecyclerVMainSc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterRecVMainScPrevYrHoF extends RecyclerView.Adapter<AdapterRecVMainScPrevYrHoF.myviewholder>{

    ArrayList<DataModelRecVMainScPrevYrHoF> dataHolder;
    ArrayList<DataModelRecVMainScPrevYrHoF> dataHolderBackup;
    private static final int PICK_IMG_UPDATE_DIALOG_PREVYR = 103;

    public AdapterRecVMainScPrevYrHoF(ArrayList<DataModelRecVMainScPrevYrHoF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resdes_recv_prevyr_hof_mainsc,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.alumniImgVSingleRdRecVPrevYrHoFMainSc.setImageResource(dataHolder.get(position).getAlumniImgVSingleRdRecVPrevYrHoFMainSc());
        holder.alumniNameTvSingleRdRecVPrevYrHoFMainSc.setText(dataHolder.get(position).getAlumniNameTvSingleRdRecVPrevYrHoFMainSc());
        holder.alumniDeptNameTvSingleRdRecVPrevYrHoFMainSc.setText(dataHolder.get(position).getAlumniDeptNameTvSingleRdRecVPrevYrHoFMainSc());
        holder.alumniLinkedinImgVSingleRdRecVPrevYrHoFMainSc.setImageResource(dataHolder.get(position).getAlumniLinkedinImgVSingleRdRecVPrevYrHoFMainSc());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView alumniImgVSingleRdRecVPrevYrHoFMainSc,alumniLinkedinImgVSingleRdRecVPrevYrHoFMainSc;
        TextView alumniNameTvSingleRdRecVPrevYrHoFMainSc,alumniDeptNameTvSingleRdRecVPrevYrHoFMainSc;
        CardView cardVSingleResDesRecVPrevYrHofMainSc;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            alumniImgVSingleRdRecVPrevYrHoFMainSc = itemView.findViewById(R.id.alumniImgVSingleRdRecVPrevYrHoFMainSc);
            alumniLinkedinImgVSingleRdRecVPrevYrHoFMainSc = itemView.findViewById(R.id.alumniLinkedinImgVSingleRdRecVPrevYrHoFMainSc);

            alumniNameTvSingleRdRecVPrevYrHoFMainSc = itemView.findViewById(R.id.alumniNameTvSingleRdRecVPrevYrHoFMainSc);
            alumniDeptNameTvSingleRdRecVPrevYrHoFMainSc = itemView.findViewById(R.id.alumniDeptNameTvSingleRdRecVPrevYrHoFMainSc);

            alumniLinkedinImgVSingleRdRecVPrevYrHoFMainSc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "No Backend", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
