package com.example.adminapp.AlumniActAdm.Opportunity

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.AlumniActAdm.Opportunity.SingleOpportunity.SingleOpportunityFAdm
import com.example.adminapp.R

class AdapterOpportunityFAdm(var dataHolder: ArrayList<DataModelOpportunityFAdm>) :
    RecyclerView.Adapter<AdapterOpportunityFAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<DataModelOpportunityFAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_rowd_recv_alumniopportunity_f_adm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.opportunityTitleTvSingleRdRecVFAdm.text =
            dataHolder[position].opportunityTitleTvSingleRdRecVFAdm
        holder.opportunityDescTvSingleRdRecVFAdm.text =
            dataHolder[position].opportunityDescTvSingleRdRecVFAdm
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardVSingleRDRecVAlumniOpportunityFAdm: CardView
        var opportunityTitleTvSingleRdRecVFAdm: TextView
        var opportunityDescTvSingleRdRecVFAdm: TextView
        private var popupDeleteDialogTvYesBtn: TextView? = null
        private var popupDeleteDialogTvNoBtn: TextView? = null

        init {
            opportunityTitleTvSingleRdRecVFAdm =
                itemView.findViewById(R.id.opportunityTitleTvSingleRdRecVFAdm)
            opportunityDescTvSingleRdRecVFAdm =
                itemView.findViewById(R.id.opportunityDescTvSingleRdRecVFAdm)
            cardVSingleRDRecVAlumniOpportunityFAdm =
                itemView.findViewById(R.id.cardVSingleRDRecVAlumniOpportunityFAdm)
            cardVSingleRDRecVAlumniOpportunityFAdm.setOnClickListener {
                val activity = itemView.context as AppCompatActivity
                val fl = activity.findViewById<FrameLayout>(R.id.frameLayAlumniOpportunityFragAdm)
                fl.removeAllViews()
                val fragment: Fragment = SingleOpportunityFAdm()
                val manager = activity.supportFragmentManager
                val fragmentTransaction = manager.beginTransaction()
                fragmentTransaction.replace(R.id.frameLayAlumniFragHomeSc, fragment).commit()
                fragmentTransaction.addToBackStack(null)
            }
            cardVSingleRDRecVAlumniOpportunityFAdm.setOnLongClickListener { v ->
                val dialog = Dialog(v.context)
                dialog.setContentView(R.layout.popup_dialog_delete)
                dialog.window!!
                    .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                dialog.setCancelable(false)
                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.rgb(255, 241, 249)))
                dialog.window!!.attributes.windowAnimations = R.style.animation

                //Todo edittextv ka data save karna hai n then post karna hai usko dusre screen me
                popupDeleteDialogTvYesBtn = dialog.findViewById(R.id.popupDeleteDialogTvYesBtn)
                popupDeleteDialogTvNoBtn =
                    dialog.findViewById(R.id.totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr)
                popupDeleteDialogTvYesBtn?.setOnClickListener(View.OnClickListener {
                    dialog.dismiss()
                    dialog.setCancelable(true)
                    Toast.makeText(itemView.context, "Deleting without backend", Toast.LENGTH_SHORT)
                        .show()
                })
                popupDeleteDialogTvNoBtn?.setOnClickListener(View.OnClickListener {
                    dialog.dismiss()
                    dialog.setCancelable(true)
                    Toast.makeText(
                        itemView.context,
                        "No Deleted Without backend",
                        Toast.LENGTH_SHORT
                    ).show()
                })
                dialog.show()
                true
            }
        }
    }
}
