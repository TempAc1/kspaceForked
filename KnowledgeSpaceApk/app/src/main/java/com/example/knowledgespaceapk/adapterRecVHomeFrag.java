package com.example.knowledgespaceapk;

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
import java.util.ArrayList;

public class adapterRecVHomeFrag  extends  RecyclerView.Adapter<adapterRecVHomeFrag.myviewholder> implements Filterable {

    ArrayList<dataModelRecVFragHome> dataHolder;
    ArrayList<dataModelRecVFragHome> dataHolderBackup;

    public adapterRecVHomeFrag(ArrayList<dataModelRecVFragHome> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design_rec_homef
                                    ,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.img.setImageResource(dataHolder.get(position).getImage());
        holder.title.setText(dataHolder.get(position).getTitle());
        holder.desc.setText(dataHolder.get(position).getDescription());
        holder.likeImg.setImageResource(dataHolder.get(position).getLikeImg());
        holder.commentImg.setImageResource(dataHolder.get(position).getCommentImg());
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
                ArrayList<dataModelRecVFragHome> filteredData = new ArrayList<>();

                if(keyword.toString().isEmpty())
                    filteredData.addAll(dataHolderBackup);

                else {
                    for (dataModelRecVFragHome obj : dataHolderBackup) {
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
                dataHolder.addAll((ArrayList<dataModelRecVFragHome>)filterResults.values);
                notifyDataSetChanged();
            }
        };



    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img,likeImg,commentImg;
        TextView title,desc;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageVSingleRowDesRecHomeF);
            title = itemView.findViewById(R.id.titleTxtVSingleRDesRecHomeF);
            desc = itemView.findViewById(R.id.descriptionTxtVSingleRDesRecHomeF);
            likeImg = itemView.findViewById(R.id.likeImgVSingleRDesRecHomeF);
            commentImg = itemView.findViewById(R.id.commentImgVSingleRDesRecHomeF);

            likeImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "Liked", Toast.LENGTH_SHORT).show();
                }
            });

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // Apply activity transition
                commentImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(view.getContext(),commentSc.class);
                        itemView.getContext().startActivity(i);
                    }
                });
            } else {
                // Swap without transition
                commentImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "clicked", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(view.getContext(),commentSc.class);
                        itemView.getContext().startActivity(i);
                    }
                });
            }

        }//End myViewHolder
    }//End classMyViewHolder
}
