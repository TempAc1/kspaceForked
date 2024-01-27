package com.example.knowledgespaceapk.Alumni.Directory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class AdapterAlumniSearchResultF extends RecyclerView.Adapter<AdapterAlumniSearchResultF.myviewholder> {

    ArrayList<DataModelAlumniSearchResultF> dataHolder;
    ArrayList<DataModelAlumniSearchResultF> dataHolderBackup;

    public AdapterAlumniSearchResultF(ArrayList<DataModelAlumniSearchResultF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resdes_recv_alumnisearch_f,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.imgVAlumniSearchResultF.setImageResource(dataHolder.get(position).getPersonImgVAlumniSearchResultF());
        holder.tVNameAlumniSearchResultF.setText(dataHolder.get(position).gettVNameAlumniSearchResultF());
        holder.tVDeptNameAlumniSearchResultF.setText(dataHolder.get(position).gettVDeptNameAlumniSearchResultF());
        holder.tVRegNoAlumniSearchResultF.setText(dataHolder.get(position).gettVRegNoAlumniSearchResultF());
        holder.linkedInImgVSingleResDesAlumniSearchF.setImageResource(dataHolder.get(position).linkedInImgVSingleResDesAlumniSearchF);
        holder.tVBatchYrAlumniSearchResultF.setText(dataHolder.get(position).gettVBatchYrAlumniSearchResultF());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView tVNameAlumniSearchResultF,tVBatchYrAlumniSearchResultF,tVRegNoAlumniSearchResultF,tVDeptNameAlumniSearchResultF,updateAlumniTvSingleResDesRecVAlumniSearchF;
        ImageView imgVAlumniSearchResultF,linkedInImgVSingleResDesAlumniSearchF;

        private TextView popupDeleteDialogTvYesBtn,popupDeleteDialogTvNoBtn;
        private ImageView imgVRegNoEditAlumniDetailsF,imgVDeptEditAlumniDetailsF,
                imgVBatchYrEditAlumniDetailsF,imgVEditTvNameEditAlumniDetailsF;
        private TextView editTvRegNoEditAlumniDetailsF,editTvBatchYrEditAlumniDetailsF,editTvDeptNameEditAlumniDetailsF,
                editTvNameEditAlumniDetailsF;
        private ImageView imgVEditAlumniDetailsF,cancelBtnImgVEditAlumniDetailsF;
        private Button updateAlumniBtnEditAlumniDetailsF;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            tVNameAlumniSearchResultF = itemView.findViewById(R.id.tVNameAlumniSearchResultF);
            tVBatchYrAlumniSearchResultF = itemView.findViewById(R.id.tVBatchYrAlumniSearchResultF);
            tVRegNoAlumniSearchResultF = itemView.findViewById(R.id.tVRegNoAlumniSearchResultF);
            tVDeptNameAlumniSearchResultF = itemView.findViewById(R.id.tVDeptNameAlumniSearchResultF);

            imgVAlumniSearchResultF = itemView.findViewById(R.id.imgVAlumniSearchResultF);
            linkedInImgVSingleResDesAlumniSearchF = itemView.findViewById(R.id.linkedInImgVSingleResDesAlumniSearchF);

        }
    }
}
