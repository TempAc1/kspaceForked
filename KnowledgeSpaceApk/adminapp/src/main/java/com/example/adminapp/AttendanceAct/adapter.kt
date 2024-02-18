package com.example.adminapp.AttendanceAct

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class adapter(var dataHolder: ArrayList<dataModel>?) : RecyclerView.Adapter<adapter.holder>() {
    var dataHolderBackup: ArrayList<dataModel>
    var present = 0
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
            .inflate(R.layout.single_row_des_attendance_act, parent, false)
        return holder(view)
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.img.setImageResource(dataHolder!![position].getpImg())
        holder.pName.text = dataHolder!![position].getpName()
        holder.pRollNo.text = dataHolder!![position].getpRollNo()
        holder.radioBtnSingleRowAttendanceAct.setOnClickListener { view ->
            if (!holder.radioBtnSingleRowAttendanceAct.isSelected) {
                holder.radioBtnSingleRowAttendanceAct.isChecked = true
                holder.radioBtnSingleRowAttendanceAct.isSelected = true
                present++
                //                    Log.i("present", String.valueOf(present));
                val intent = Intent("message_subject_intent")
                intent.putExtra("presentCount", present.toString())
                LocalBroadcastManager.getInstance(view.context).sendBroadcast(intent)
            } else {
                holder.radioBtnSingleRowAttendanceAct.isChecked = false
                holder.radioBtnSingleRowAttendanceAct.isSelected = false
                present--
                //                    Log.i("present", String.valueOf(present));
                val intent = Intent("message_subject_intent")
                intent.putExtra("presentCount", present.toString())
                LocalBroadcastManager.getInstance(view.context).sendBroadcast(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var pName: TextView
        var pRollNo: TextView
        val radioBtnSingleRowAttendanceAct: RadioButton

        init {
            img = itemView.findViewById(R.id.pImgVSingleRowAttendanceAct)
            pName = itemView.findViewById(R.id.pNameSingleRowAttendanceAct)
            pRollNo = itemView.findViewById(R.id.pRollNoSingleRowAttendanceAct)
            radioBtnSingleRowAttendanceAct =
                itemView.findViewById(R.id.radioBtnSingleRowAttendanceAct)
        }
    }
}
