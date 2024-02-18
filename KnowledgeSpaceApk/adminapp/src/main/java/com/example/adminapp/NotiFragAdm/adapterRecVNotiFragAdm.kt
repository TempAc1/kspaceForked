package com.example.adminapp.NotiFragAdm

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class adapterRecVNotiFragAdm(var dataHolder: ArrayList<dataModelRecVFragNotiAdm>) :
    RecyclerView.Adapter<adapterRecVNotiFragAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<dataModelRecVFragNotiAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_row_design_rec_notif_adm, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.notiTxt.text = dataHolder[position].notiTxt
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var notiTxt: TextView

        init {
            notiTxt = itemView.findViewById(R.id.tvLinearLaySingleRowDesRecNotiFAdm)
            notiTxt.setOnClickListener { v ->
                val activity = v.context as AppCompatActivity
                val i = Intent(activity.applicationContext, NotiActMainScAdm::class.java)
                activity.startActivity(i)
            }
        }
    }
}