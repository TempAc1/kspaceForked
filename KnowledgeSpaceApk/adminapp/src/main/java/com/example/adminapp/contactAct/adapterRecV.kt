package com.example.adminapp.contactAct

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.example.adminapp.contactAct.MVCARCHITECTURECONTACTACT.dataModel

class adapterRecV(var dataHolder: ArrayList<dataModel>?) :
    RecyclerView.Adapter<adapterRecV.holder>() {
    var dataHolderBackup: ArrayList<dataModel>
    fun setFilteredList(filteredList: ArrayList<dataModel>?) {
        dataHolder = filteredList
        notifyDataSetChanged()
    }

    init {
        dataHolderBackup = ArrayList(
            dataHolder
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_row_design_contact_act, parent, false)
        return holder(view)
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.tvContactName.text = dataHolder!![position].contactName
        holder.tvContactNo.text = dataHolder!![position].number
        holder.img.setImageResource(dataHolder!![position].img)
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var tvContactName: TextView
        var tvContactNo: TextView

        init {
            img = itemView.findViewById(R.id.iVPersonContactAct)
            tvContactName = itemView.findViewById(R.id.tVPNameContactAct)
            tvContactNo = itemView.findViewById(R.id.tVPNoContactAct)
        }
    }
}
