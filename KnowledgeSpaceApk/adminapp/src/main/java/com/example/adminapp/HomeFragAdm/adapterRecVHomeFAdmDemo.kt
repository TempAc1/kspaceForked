package com.example.adminapp.HomeFragAdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.HomeFragAdm.adapterRecVHomeFAdmDemo.PostViewHolder
import com.example.adminapp.R
import com.example.adminapp.mvc_posts_collections.dataModelPostCollection
import com.squareup.picasso.Picasso

class adapterRecVHomeFAdmDemo(private var postList: MutableList<dataModelPostCollection>?) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_row_design_recv_homef_adm, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList!![position]
        holder.pTitleTv.text = post.postTitle
        holder.pDescTv.text = post.postDesc
        Picasso.get()
            .load(post.postAttachments)
            .error(R.drawable.ic_baseline_error_24)
            .into(holder.pImgV)
    }

    override fun getItemCount(): Int {
        return if (postList != null) postList!!.size else 0
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var pTitleTv: TextView
        var pDescTv: TextView
        var pImgV: ImageView

        init {
            pTitleTv = itemView.findViewById(R.id.titleTxtVSingleRDesRecHomeFAdm)
            pDescTv = itemView.findViewById(R.id.descriptionTxtVSingleRDesRecHomeFAdm)
            pImgV = itemView.findViewById(R.id.imageVSingleRowDesRecHomeFAdm)
        }
    }

    // Method to update the posts in the adapter
    fun updatePosts(newPosts: List<dataModelPostCollection>?) {
        if (postList == null) {
            postList = ArrayList() // Initialize postList if it's null
        }
        postList!!.clear() // Clear the existing posts
        postList!!.addAll(newPosts!!) // Add the new posts
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }
}
