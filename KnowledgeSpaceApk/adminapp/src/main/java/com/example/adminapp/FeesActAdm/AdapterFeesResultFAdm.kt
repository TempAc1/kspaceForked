package com.example.adminapp.FeesActAdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class AdapterFeesResultFAdm(private val dataHolder: ArrayList<DataModelRecVFeesResultFAdm>?) :
    RecyclerView.Adapter<AdapterFeesResultFAdm.myviewholder>() {
    private val dataHolderBackup: ArrayList<DataModelRecVFeesResultFAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_resdes_recv_fees_resultf_feesact_adm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.stdIdTvSingleRDRecVFeesResultFeesActAdm.text = StringBuilder().append(
            dataHolder!![position].stdIdTvSingleRDRecVFeesResultFeesActAdm
        ).append("").toString()
        holder.stdNameTvSingleRDRecVFeesResultFeesActAdm.text =
            dataHolder!![position].stdNameTvSingleRDRecVFeesResultFeesActAdm
        holder.feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm.text = StringBuilder().append(
            dataHolder[position].feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm
        ).append("").toString()
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var stdIdTvSingleRDRecVFeesResultFeesActAdm: TextView
        var stdNameTvSingleRDRecVFeesResultFeesActAdm: TextView
        var feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm: TextView

        init {
            stdIdTvSingleRDRecVFeesResultFeesActAdm =
                itemView.findViewById(R.id.stdIdTvSingleRDRecVFeesResultFeesActAdm)
            stdNameTvSingleRDRecVFeesResultFeesActAdm =
                itemView.findViewById(R.id.stdNameTvSingleRDRecVFeesResultFeesActAdm)
            feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm =
                itemView.findViewById(R.id.feeAmountPaidTvSingleRDRecVFeesResultFeesActAdm)
        }
    }
}
