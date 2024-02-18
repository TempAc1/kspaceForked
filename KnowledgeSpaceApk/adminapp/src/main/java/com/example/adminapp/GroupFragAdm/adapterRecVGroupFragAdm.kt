package com.example.adminapp.GroupFragAdm

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.card.MaterialCardView

class adapterRecVGroupFragAdm(var dataHolder: ArrayList<dataModelRecVGroupFragAdm>) :
    RecyclerView.Adapter<adapterRecVGroupFragAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<dataModelRecVGroupFragAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_row_design_recv_groupf_adm, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.groupIcon1.setImageResource(dataHolder[position].groupImg1)
        holder.groupName1.text = dataHolder[position].groupName1
        holder.groupIcon2.setImageResource(dataHolder[position].groupImg2)
        holder.groupName2.text = dataHolder[position].groupName2
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var groupName1: TextView
        var groupName2: TextView
        var groupIcon1: ImageView
        var groupIcon2: ImageView
        var materialCardVSingleRDRecVGrpFAdm: MaterialCardView

        init {
            groupName1 = itemView.findViewById(R.id.tVSingRDResGrpFAdm)
            groupName2 = itemView.findViewById(R.id.tVSingRDRecGrpF1Adm)
            groupIcon1 = itemView.findViewById(R.id.imgVSingRDRecGrpFAdm)
            groupIcon2 = itemView.findViewById(R.id.imgVSingRDRecGrpF1Adm)
            materialCardVSingleRDRecVGrpFAdm =
                itemView.findViewById(R.id.materialCardVSingleRDRecVGrpFAdm)
            materialCardVSingleRDRecVGrpFAdm.setOnClickListener { view ->
                val activity = view.context as AppCompatActivity
                val i = Intent(activity.applicationContext, FragmentHolderActGrpAdm::class.java)
                activity.startActivity(i)
            }
        }
    }
}
