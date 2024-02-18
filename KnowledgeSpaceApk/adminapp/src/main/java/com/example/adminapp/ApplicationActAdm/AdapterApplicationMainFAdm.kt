package com.example.adminapp.ApplicationActAdm

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
import com.example.adminapp.R

class AdapterApplicationMainFAdm(private val dataHolder: ArrayList<DataModelRecVApplicationMainFAdm?>?) :
    RecyclerView.Adapter<AdapterApplicationMainFAdm.myviewholder>() {
    private val dataHolderBackup: ArrayList<DataModelRecVApplicationMainFAdm?>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_resd_recv_application_fadm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {}
    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var applicationSenderIdTvSingleRdRecVApplicationDefaultFAdm: TextView
        var appTitleTvSingleRdRecVApplicationDefaultFAdm: TextView
        var appDescTvSingleRdRecVApplicationDefaultFAdm: TextView
        var cardVSingleResDRecVApplicationFAdm: CardView

        init {
            applicationSenderIdTvSingleRdRecVApplicationDefaultFAdm =
                itemView.findViewById(R.id.applicationSenderIdTvSingleRdRecVApplicationDefaultFAdm)
            appTitleTvSingleRdRecVApplicationDefaultFAdm =
                itemView.findViewById(R.id.appTitleTvSingleRdRecVApplicationDefaultFAdm)
            appDescTvSingleRdRecVApplicationDefaultFAdm =
                itemView.findViewById(R.id.appDescTvSingleRdRecVApplicationDefaultFAdm)
            cardVSingleResDRecVApplicationFAdm =
                itemView.findViewById(R.id.cardVSingleResDRecVApplicationFAdm)
            cardVSingleResDRecVApplicationFAdm.setOnClickListener { view ->
                val activity = view.context as AppCompatActivity
                val fl = activity.findViewById<FrameLayout>(R.id.frameLayApplicationActAdm)
                fl.removeAllViews()
                val fragment: Fragment = ApplicationDetailsFAdm()
                val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frameLayApplicationActAdm, fragment).commit()
                fragmentTransaction.addToBackStack(null)
                Toast.makeText(itemView.context, "No backend", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
