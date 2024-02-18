package com.example.adminapp.HomeworkActAdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class adapterRecVHomeworkActAdm(var dataHolder: ArrayList<dataModelRecVHomeworkActAdm>) :
    RecyclerView.Adapter<adapterRecVHomeworkActAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<dataModelRecVHomeworkActAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_row_des_homeworkdefault_fragadm, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.hwTitleHomeworkDefaultFragAdm.text =
            dataHolder[position].hwTitleHomeworkDefaultFragAdm
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var hwTitleHomeworkDefaultFragAdm: TextView

        init {
            hwTitleHomeworkDefaultFragAdm =
                itemView.findViewById(R.id.homeTitleTvSingleRdHomeworkDefaultFragAdm)
        }
    }
}
