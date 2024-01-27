package com.example.adminapp.AttendanceAct;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.holder> {

    ArrayList<dataModel> dataHolder;
    ArrayList<dataModel> dataHolderBackup;
    int present;

    public  void setFilteredList(ArrayList<dataModel> filteredList){
        this.dataHolder = filteredList;
        notifyDataSetChanged();
    }

    public adapter(ArrayList<dataModel> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup =  new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public adapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_des_attendance_act,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.holder holder, int position) {
        holder.img.setImageResource(dataHolder.get(position).getpImg());
        holder.pName.setText(dataHolder.get(position).getpName());
        holder.pRollNo.setText(dataHolder.get(position).getpRollNo());
        holder.radioBtnSingleRowAttendanceAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!holder.radioBtnSingleRowAttendanceAct.isSelected()){
                    holder.radioBtnSingleRowAttendanceAct.setChecked(true);
                    holder.radioBtnSingleRowAttendanceAct.setSelected(true);
                    present++;
//                    Log.i("present", String.valueOf(present));
                    Intent intent = new Intent("message_subject_intent");
                    intent.putExtra("presentCount" ,String.valueOf(present));
                    LocalBroadcastManager.getInstance(view.getContext()).sendBroadcast(intent);
                }else{
                    holder.radioBtnSingleRowAttendanceAct.setChecked(false);
                    holder.radioBtnSingleRowAttendanceAct.setSelected(false);
                    present--;
//                    Log.i("present", String.valueOf(present));
                    Intent intent = new Intent("message_subject_intent");
                    intent.putExtra("presentCount" ,String.valueOf(present));
                    LocalBroadcastManager.getInstance(view.getContext()).sendBroadcast(intent);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class holder extends RecyclerView.ViewHolder {
       ImageView img;
        TextView pName,pRollNo;
        private RadioButton radioBtnSingleRowAttendanceAct;
        public holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.pImgVSingleRowAttendanceAct);
            pName = itemView.findViewById(R.id.pNameSingleRowAttendanceAct);
            pRollNo = itemView.findViewById(R.id.pRollNoSingleRowAttendanceAct);
            radioBtnSingleRowAttendanceAct = itemView.findViewById(R.id.radioBtnSingleRowAttendanceAct);
        }
    }
}
