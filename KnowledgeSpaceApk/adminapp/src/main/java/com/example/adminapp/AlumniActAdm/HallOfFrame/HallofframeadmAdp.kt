package com.example.adminapp.AlumniActAdm.HallOfFrame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.adminapp.R

class HallofframeadmAdp(var dataHolder: ArrayList<DataModelHallOfFrame>) : BaseAdapter() {
    var dataHolderBackup: ArrayList<DataModelHallOfFrame>

    init {
        dataHolderBackup = ArrayList(
            dataHolder
        )
    }

    override fun getCount(): Int {
        return dataHolder.size
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, view: View, parent: ViewGroup): View {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_resource_layout_hallofframe, null)

        // Link those objects with their respective id's
        // that we have given in .XML file
        val name = view.findViewById<TextView>(R.id.imgNameTvSingleResDesHallOfFrame)
        val image = view.findViewById<ImageView>(R.id.imgVSingleResHallOfFrame)

         val item = dataHolder[position]
        name.text = item.imgNameTvSingleResDesHallOfFrame
        image.setImageResource(item.imgVSingleResHallOfFrame)

        return view
    }
}













