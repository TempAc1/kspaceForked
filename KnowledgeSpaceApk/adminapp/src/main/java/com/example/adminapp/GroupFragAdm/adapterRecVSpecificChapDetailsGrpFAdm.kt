package com.example.adminapp.GroupFragAdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class adapterRecVSpecificChapDetailsGrpFAdm(var dataHolder: ArrayList<dataModelRecVSpecificChapDetailsFAdm>) :
    RecyclerView.Adapter<adapterRecVSpecificChapDetailsGrpFAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<dataModelRecVSpecificChapDetailsFAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.single_row_des_recyclerv_specific_chap_detailsf_adm,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.moduleSelectNameTvSpecChapFAdm.text =
            dataHolder[position].moduleSelectNameTvSpecChapFAdm
        holder.moduleDesTvCardLaySpecChapFAdm.text =
            dataHolder[position].moduleDesTvCardLaySpecChapFAdm
        holder.moduleNameInSelectedChapTvCardLaySpecChapFAdm.text =
            dataHolder[position].moduleNameInSelectedChapTvCardLaySpecChapFAdm
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var moduleSelectNameTvSpecChapFAdm: TextView
        var moduleNameInSelectedChapTvCardLaySpecChapFAdm: TextView
        var moduleDesTvCardLaySpecChapFAdm: TextView
        var resourcesForThatModuleTvCardLaySpecificChapDetailsFAdm: TextView
        var parentFrameLayout: FrameLayout? = null
        var parentRecyclerView: RecyclerView? = null

        init {
            moduleSelectNameTvSpecChapFAdm =
                itemView.findViewById(R.id.moduleSelectNameTvSpecChapFAdm)
            moduleNameInSelectedChapTvCardLaySpecChapFAdm =
                itemView.findViewById(R.id.moduleNameInSelectedChapTvCardLaySpecChapFAdm)
            moduleDesTvCardLaySpecChapFAdm =
                itemView.findViewById(R.id.moduleDesTvCardLaySpecChapFAdm)
            resourcesForThatModuleTvCardLaySpecificChapDetailsFAdm =
                itemView.findViewById(R.id.resourcesForThatModuleTvCardLaySpecificChapDetailsFAdm)
        }
    }
}
