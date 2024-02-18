package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class AlumniSearchResultFAdm : Fragment() {
    private var recyclerVAlumniSearchResultFAdm: RecyclerView? = null
    private var dataHolder: ArrayList<DataModelAlumniSearchResultFAdm>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_alumni_search_result_f_adm, container, false)
        recyclerVAlumniSearchResultFAdm = view.findViewById(R.id.recyclerVAlumniSearchResultFAdm)
        recyclerVAlumniSearchResultFAdm?.setLayoutManager(LinearLayoutManager(context))
        dataHolder = ArrayList()
        addData()
        recyclerVAlumniSearchResultFAdm?.setAdapter(AdapterAlumniSearchResultFAdm(dataHolder!!))
        return view
    }

    private fun addData() {
        val card1 = DataModelAlumniSearchResultFAdm(
            "Shrikant",
            "2023",
            "56218",
            "Computer",
            R.drawable.linkedin,
            R.drawable.ic_baseline_person_24
        )
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
        dataHolder!!.add(card1)
    }
}