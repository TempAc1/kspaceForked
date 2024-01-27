package com.example.adminapp.HomeFragAdm;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.HomeScAdm;
import com.example.adminapp.R;
import com.example.adminapp.UsersCommentScAdm.UsersCommentScAdm;

import java.util.ArrayList;

class adapterRecVHomeFragAdm extends RecyclerView.Adapter<adapterRecVHomeFragAdm.myviewholder> implements Filterable{

    ArrayList<dataModelRecVHomeFragAdm> dataHolder;
    ArrayList<dataModelRecVHomeFragAdm> dataHolderBackup;
    HomeScAdm homeScAdm = new HomeScAdm();

    public adapterRecVHomeFragAdm(ArrayList<dataModelRecVHomeFragAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup =  new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public adapterRecVHomeFragAdm.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.single_row_design_recv_homef_adm,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull adapterRecVHomeFragAdm.myviewholder holder, int position) {
        holder.img.setImageResource(dataHolder.get(position).getImage());
        holder.likeImg.setImageResource(dataHolder.get(position).getLikeImg());
        holder.commentImg.setImageResource(dataHolder.get(position).getCommentImg());
        holder.title.setText(dataHolder.get(position).getTitle());
        holder.desc.setText(dataHolder.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {

            //tempo array list for filtered data
            ArrayList<dataModelRecVHomeFragAdm> filteredData = new ArrayList<>();

            if(keyword.toString().isEmpty())
                filteredData.addAll(dataHolderBackup);

            else {
                for (dataModelRecVHomeFragAdm obj : dataHolderBackup) {
                    if (obj.getTitle().toString().toLowerCase().trim().contains(keyword
                            .toString().toLowerCase().trim()) ||
                            obj.getDescription().toString().toLowerCase().trim().contains(keyword
                                    .toString().toLowerCase().trim()))
                        filteredData.add(obj);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredData;
            return  results;
        }

        //Main thread ui
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            dataHolder.clear();
            dataHolder.addAll((ArrayList<dataModelRecVHomeFragAdm>)filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class myviewholder extends RecyclerView.ViewHolder{

        ImageView img,likeImg,commentImg;
        TextView title,desc;
        Context context;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            img = itemView.findViewById(R.id.imageVSingleRowDesRecHomeFAdm);
            likeImg = itemView.findViewById(R.id.likeBtnHomeFragAdm);
            commentImg = itemView.findViewById(R.id.commentBtnHomeFragAdm);
            title = itemView.findViewById(R.id.titleTxtVSingleRDesRecHomeFAdm);
            desc = itemView.findViewById(R.id.descriptionTxtVSingleRDesRecHomeFAdm);

            likeImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateUPoints();
                    Toast.makeText(itemView.getContext(), "Liked", Toast.LENGTH_SHORT).show();
                }
            });

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                //Apply transaction
                commentImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        updateUPoints();
                        float uPoints = homeScAdm.getUPoints();
                        intent =  new Intent(context, UsersCommentScAdm.class);
                        context.startActivity(intent);
                        Toast.makeText(itemView.getContext(),String.valueOf(uPoints), Toast.LENGTH_SHORT).show();

                    }
                });
            }else{
                final Intent intent;
                //Don't apply transaction
                intent =  new Intent(context, UsersCommentScAdm.class);
                context.startActivity(intent);
                Toast.makeText(itemView.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void updateUPoints() {
        homeScAdm.setuPoints(
                homeScAdm.getUPoints() + 1
        );
    }
}//End Main