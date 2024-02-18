package com.example.adminapp.GroupFragAdm

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
import com.google.android.material.floatingactionbutton.FloatingActionButton

class adapterRecVCourseSelectedFAdm(var dataHolder: ArrayList<dataModelRecVCourseSelectedFAdm>?) :
    RecyclerView.Adapter<adapterRecVCourseSelectedFAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<dataModelRecVCourseSelectedFAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_row_des_course_selectedf_adm, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.chapterNameSingleRDCourseSelectedFAdm.text = dataHolder!![position].chapterName
        holder.totalNoOfModulesTvSingleRDCourseSelectedFAdm.text =
            StringBuilder().append("No Of Modules")
                .append(" : ").append(dataHolder!![position].totalNoOfModules).toString()
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chapterNameSingleRDCourseSelectedFAdm: TextView
        var totalNoOfModulesTvSingleRDCourseSelectedFAdm: TextView
        var cardVSingleResDesCourseSelectedFAdm: CardView
        var parentFrameLayout: FrameLayout? = null
        var parentRecyclerView: RecyclerView? = null
        var parentFloatingBtns: FloatingActionButton? = null

        init {
            chapterNameSingleRDCourseSelectedFAdm =
                itemView.findViewById(R.id.chapterNameSingleRDCourseSelectedFAdm)
            totalNoOfModulesTvSingleRDCourseSelectedFAdm =
                itemView.findViewById(R.id.totalNoOfModulesTvSingleRDCourseSelectedFAdm)


            //Access items of recyclerV:
            cardVSingleResDesCourseSelectedFAdm =
                itemView.findViewById(R.id.cardVSingleResDesCourseSelectedFAdm)
            cardVSingleResDesCourseSelectedFAdm.setOnClickListener { view -> //ACCESS PARENT VIEW ITEM USING ACTIVITY CODE :
                val activity = view.context as AppCompatActivity
                parentFrameLayout = activity.findViewById(R.id.parentFrameLayCourseSelectedOptFAdm)
                parentRecyclerView = activity.findViewById(R.id.recyclerVCourseSelectedOptAdm)
                parentFrameLayout?.setVisibility(View.VISIBLE)
                parentRecyclerView?.setVisibility(View.GONE)
                parentFloatingBtns = activity.findViewById(R.id.floatingBtnCourseSelectedOptAdm)
                parentFloatingBtns?.setVisibility(View.GONE)
                val fragment: Fragment = SpecificChapterDetailsFAdm()
                val manager = activity.supportFragmentManager
                val fragmentTransaction = manager.beginTransaction()
                fragmentTransaction.replace(R.id.parentFrameLayCourseSelectedOptFAdm, fragment)
                    .commit()
            }
        }
    }
}
