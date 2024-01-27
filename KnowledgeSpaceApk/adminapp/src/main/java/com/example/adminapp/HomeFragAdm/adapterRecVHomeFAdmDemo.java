package com.example.adminapp.HomeFragAdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;
import com.example.adminapp.mvc_posts_collections.dataModelPostCollection;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class adapterRecVHomeFAdmDemo extends RecyclerView.Adapter<adapterRecVHomeFAdmDemo.PostViewHolder> {

    private List<dataModelPostCollection> postList;

    public adapterRecVHomeFAdmDemo(List<dataModelPostCollection> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public adapterRecVHomeFAdmDemo.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design_recv_homef_adm,parent,false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterRecVHomeFAdmDemo.PostViewHolder holder, int position) {
        dataModelPostCollection post = postList.get(position);
        holder.pTitleTv.setText(post.getPostTitle());
        holder.pDescTv.setText(post.getPostDesc());

        Picasso.get()
                .load(post.getPostAttachments())
                .error(R.drawable.ic_baseline_error_24)
                .into(holder.pImgV);
    }

    @Override
    public int getItemCount() {
        return postList!=null ? postList.size() : 0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView pTitleTv, pDescTv;
        ImageView pImgV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            pTitleTv = itemView.findViewById(R.id.titleTxtVSingleRDesRecHomeFAdm);
            pDescTv = itemView.findViewById(R.id.descriptionTxtVSingleRDesRecHomeFAdm);
            pImgV = itemView.findViewById(R.id.imageVSingleRowDesRecHomeFAdm);


        }
    }

    // Method to update the posts in the adapter
    public void updatePosts(List<dataModelPostCollection> newPosts) {
        if (postList == null) {
            postList = new ArrayList<>(); // Initialize postList if it's null
        }
        postList.clear();  // Clear the existing posts
        postList.addAll(newPosts);  // Add the new posts
        notifyDataSetChanged();  // Notify the adapter that the data has changed
    }
}
