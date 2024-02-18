package com.example.adminapp.PlacementActAdm

import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class AdapterPlacementDefaultFAdm(var dataHolder: ArrayList<DataModelRecVPlacementDefaultFAdm>?) :
    RecyclerView.Adapter<AdapterPlacementDefaultFAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<DataModelRecVPlacementDefaultFAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_resd_recv_placementdefault_fadm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.companyTitleTvSingleRdRecVPlacementDefaultFAdm.text =
            dataHolder!![position].companyTitleTvSingleRdRecVPlacementDefaultFAdm
        holder.offerDescriptionTvSingleRdRecVPlacementDefaultFAdm.text =
            dataHolder!![position].offerDescriptionTvSingleRdRecVPlacementDefaultFAdm
        holder.regLinkTvSingleRdRecVPlacementDefaultFAdm.text =
            dataHolder!![position].regLinkTvSingleRdRecVPlacementDefaultFAdm
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var companyTitleTvSingleRdRecVPlacementDefaultFAdm: TextView
        var offerDescriptionTvSingleRdRecVPlacementDefaultFAdm: TextView
        var regLinkTvSingleRdRecVPlacementDefaultFAdm: TextView
        var androidXCardVSingleRdRecVPlacementDefaultFAdm: CardView

        init {
            companyTitleTvSingleRdRecVPlacementDefaultFAdm =
                itemView.findViewById(R.id.applicationSenderIdTvSingleRdRecVApplicationDefaultFAdm)
            offerDescriptionTvSingleRdRecVPlacementDefaultFAdm =
                itemView.findViewById(R.id.appTitleTvSingleRdRecVApplicationDefaultFAdm)
            regLinkTvSingleRdRecVPlacementDefaultFAdm =
                itemView.findViewById(R.id.appDescTvSingleRdRecVApplicationDefaultFAdm)
            regLinkTvSingleRdRecVPlacementDefaultFAdm.movementMethod =
                LinkMovementMethod.getInstance()
            androidXCardVSingleRdRecVPlacementDefaultFAdm =
                itemView.findViewById(R.id.androidXCardVSingleRdRecVPlacementDefaultFAdm)
            androidXCardVSingleRdRecVPlacementDefaultFAdm.setOnClickListener { view ->
                val activity = view.context as AppCompatActivity
                val fl = activity.findViewById<FrameLayout>(R.id.frameLayPlacementMainActAdm)
                fl.removeAllViews()
                val fr: Fragment = PlacementOfferDetailsFAdm()
                val fm = activity.supportFragmentManager
                val ft = fm.beginTransaction()
                ft.replace(R.id.frameLayPlacementMainActAdm, fr).commit()
                ft.addToBackStack(null)
            }
        }
    }
}
