package com.example.adminapp.MyPosts

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

class adapterMyPostsAdm(var dataHolder: ArrayList<dataModelRecVMyPostsAdm>?) :
    RecyclerView.Adapter<adapterMyPostsAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<dataModelRecVMyPostsAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_row_des_mypost_adm, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.postTitleTvSingleRdMyPostActAdm.text =
            dataHolder!![position].postTitleTvSingleRdMyPostActAdm
        holder.postDesTvSingleRdMyPostActAdm.text =
            dataHolder!![position].postDesTvSingleRdMyPostActAdm
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardVSingleRowDesMyPostAdm: CardView
        var postTitleTvSingleRdMyPostActAdm: TextView
        var postDesTvSingleRdMyPostActAdm: TextView
        var parentFrameLayout: FrameLayout? = null
        var parentRecyclerView: RecyclerView? = null

        init {
            postTitleTvSingleRdMyPostActAdm =
                itemView.findViewById(R.id.postTitleTvSingleRdMyPostActAdm)
            postDesTvSingleRdMyPostActAdm =
                itemView.findViewById(R.id.postDesTvSingleRdMyPostActAdm)

            //Access items of recyclerV here:
            cardVSingleRowDesMyPostAdm = itemView.findViewById(R.id.cardVSingleRowDesMyPostAdm)
            cardVSingleRowDesMyPostAdm.setOnClickListener { view -> //ACCESS PARENT VIEW ITEM USING ACTIVITY CODE :
                val activity = view.context as AppCompatActivity
                parentFrameLayout = activity.findViewById(R.id.frameLayMyPostActAdm)
                parentRecyclerView = activity.findViewById(R.id.recyclerVMyPostActAdm)
                parentFrameLayout?.setVisibility(View.VISIBLE)
                parentRecyclerView?.setVisibility(View.GONE)
                val fragment: Fragment = SinglePostFragMyPostActAdm()
                val manager = activity.supportFragmentManager
                val fragmentTransaction = manager.beginTransaction()
                fragmentTransaction.replace(R.id.frameLayMyPostActAdm, fragment).commit()
            }
        }
    }
}
