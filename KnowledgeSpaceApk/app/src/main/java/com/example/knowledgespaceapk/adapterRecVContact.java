package com.example.knowledgespaceapk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapterRecVContact extends RecyclerView.Adapter<adapterRecVContact.holder> {

    ArrayList<dataModelRecVContactAct> dataHolder;
    ArrayList<dataModelRecVContactAct> dataHolderBackup;

    public void setFilteredList(List<dataModelRecVContactAct> filteredList){
        this.dataHolder = (ArrayList<dataModelRecVContactAct>) filteredList;
        notifyDataSetChanged();
    }

    public adapterRecVContact(ArrayList<dataModelRecVContactAct> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row_design_rec_contact
                                        ,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tvContactName.setText(dataHolder.get(position).getContactName());
        holder.tvContactNo.setText(dataHolder.get(position).getContactNumber());
        holder.img.setImageResource(dataHolder.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class holder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tvContactName,tvContactNo;

        public holder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.iVSubNameAttendance);
            tvContactName = itemView.findViewById(R.id.tVPNameAttendance);
            tvContactNo = itemView.findViewById(R.id.tVPAttendence);
        }
    }
}
