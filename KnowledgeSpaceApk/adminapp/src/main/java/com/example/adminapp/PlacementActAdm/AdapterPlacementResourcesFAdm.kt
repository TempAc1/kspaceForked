package com.example.adminapp.PlacementActAdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class AdapterPlacementResourcesFAdm(private val dataHolder: ArrayList<DataModelRecVPlacementResourcesFAdm>?) :
    RecyclerView.Adapter<AdapterPlacementResourcesFAdm.myviewholder>() {
    private val dataHolderBackup: ArrayList<DataModelRecVPlacementResourcesFAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_resdes_recv_placement_resources_fadm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.resourceTitleTvSingleRdRecVPlacementResourcesFAdm.text =
            dataHolder!![position].resourceTitleTvSingleRdRecVPlacementResourcesFAdm
        holder.resourceTvSingleRdRecVPlacementResourcesFAdm.text =
            dataHolder[position].resourceTvSingleRdRecVPlacementResourcesFAdm
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var resourceTitleTvSingleRdRecVPlacementResourcesFAdm: TextView
        var resourceTvSingleRdRecVPlacementResourcesFAdm: TextView

        init {
            resourceTitleTvSingleRdRecVPlacementResourcesFAdm =
                itemView.findViewById(R.id.resourceTitleTvSingleRdRecVPlacementResourcesFAdm)
            resourceTvSingleRdRecVPlacementResourcesFAdm =
                itemView.findViewById(R.id.resourceTvSingleRdRecVPlacementResourcesFAdm)
        }
    }
}
