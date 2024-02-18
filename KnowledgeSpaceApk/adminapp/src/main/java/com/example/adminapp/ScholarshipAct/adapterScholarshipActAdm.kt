package com.example.adminapp.ScholarshipAct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class adapterScholarshipActAdm(var dataHolder: ArrayList<dataModelRecVScholarshipActAdm>?) :
    RecyclerView.Adapter<adapterScholarshipActAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<dataModelRecVScholarshipActAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_row_des_scholarshipadm_act, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.titleTxtVSingleRdScholarshipActAdm.text =
            dataHolder!![position].titleTxtVSingleRdScholarshipActAdm
        holder.linkTxtVSingleRdScholarshipActAdm.text =
            dataHolder!![position].linkTxtVSingleRdScholarshipActAdm
        holder.imgVSingleRdScholarshipActAdm.setImageResource(dataHolder!![position].imgVSingleRdScholarshipActAdm)
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTxtVSingleRdScholarshipActAdm: TextView
        var linkTxtVSingleRdScholarshipActAdm: TextView
        var imgVSingleRdScholarshipActAdm: ImageView

        init {
            titleTxtVSingleRdScholarshipActAdm =
                itemView.findViewById(R.id.titleTxtVSingleRdScholarshipActAdm)
            linkTxtVSingleRdScholarshipActAdm =
                itemView.findViewById(R.id.linkTxtVSingleRdScholarshipActAdm)
            imgVSingleRdScholarshipActAdm =
                itemView.findViewById(R.id.imgVSingleRdScholarshipActAdm)
        }
    }
}
