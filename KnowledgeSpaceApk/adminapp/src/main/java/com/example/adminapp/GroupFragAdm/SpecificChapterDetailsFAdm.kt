package com.example.adminapp.GroupFragAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class SpecificChapterDetailsFAdm : Fragment() {
    private var recyclerView: RecyclerView? = null
    private val adapter: adapterRecVSpecificChapDetailsGrpFAdm? = null
    private var dataHolder: ArrayList<dataModelRecVSpecificChapDetailsFAdm>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_specific_chapter_details_f_adm, container, false)

        //ADD YOUR CODE HERE
        recyclerView = view.findViewById(R.id.recyclerVSpecificChapDetailsFAdm)
        recyclerView?.setLayoutManager(LinearLayoutManager(context))
        dataHolder = ArrayList()
        addData()
        recyclerView?.setAdapter(adapterRecVSpecificChapDetailsGrpFAdm(dataHolder!!))
        return view
    }

    private fun addData() {
        val obj1 = dataModelRecVSpecificChapDetailsFAdm(
            "Blockchain 7201856",
            "Module first", "Chapter Decentenralize",
            "Not available"
        )
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
    }
}