package com.example.adminapp.contactAct;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class adapterRecV extends RecyclerView.Adapter<adapterRecV.holder> {

    ArrayList<dataModel> dataHolder;
    ArrayList<dataModel> dataHolderBackup;

    public  void setFilteredList(ArrayList<dataModel> filteredList){
        this.dataHolder = (ArrayList<dataModel>) filteredList;
        notifyDataSetChanged();
    }

    public adapterRecV(ArrayList<dataModel> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public adapterRecV.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design_contact_act,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterRecV.holder holder, int position) {
        holder.tvContactName.setText(dataHolder.get(position).getContactName());
        holder.tvContactNo.setText(dataHolder.get(position).getNumber());
        holder.img.setImageResource(dataHolder.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class holder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvContactName,tvContactNo;

        public holder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.iVPersonContactAct);
            tvContactName = itemView.findViewById(R.id.tVPNameContactAct);
            tvContactNo = itemView.findViewById(R.id.tVPNoContactAct);
        }
    }
}
