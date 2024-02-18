package com.example.adminapp.GroupFragAdm.DiscussionPanelFragAdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.circularreveal.cardview.CircularRevealCardView

class adapterRecVDisPanelMainSc(private val dataHolder: ArrayList<DiscussionPanelData>?) :
    RecyclerView.Adapter<adapterRecVDisPanelMainSc.myviewholder>() {
    private val dataHolderBackup: ArrayList<DiscussionPanelData>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_row_des_recv_dispanel_mainsc_fadm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.titleTvSingleRDDisPanelMainScFAdm.text = dataHolder!![position].title
        holder.descripTvSingleRDDisPanelMainScFAdm.text = dataHolder[position].description
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var circularCardVSingleRDDisPanelMainScFAdm: CircularRevealCardView
        var titleTvSingleRDDisPanelMainScFAdm: TextView
        var descripTvSingleRDDisPanelMainScFAdm: TextView

        init {
            circularCardVSingleRDDisPanelMainScFAdm =
                itemView.findViewById(R.id.circularCardVSingleRDDisPanelMainScFAdm)
            titleTvSingleRDDisPanelMainScFAdm =
                itemView.findViewById(R.id.titleTvSingleRDDisPanelMainScFAdm)
            descripTvSingleRDDisPanelMainScFAdm =
                itemView.findViewById(R.id.descripTvSingleRDDisPanelMainScFAdm)
        }
    }
}
