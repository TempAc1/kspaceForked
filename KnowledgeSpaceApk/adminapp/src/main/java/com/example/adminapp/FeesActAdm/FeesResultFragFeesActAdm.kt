package com.example.adminapp.FeesActAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class FeesResultFragFeesActAdm : Fragment() {
    private var dataHolder: ArrayList<DataModelRecVFeesResultFAdm>? = null
    private val adapter: AdapterFeesResultFAdm? = null
    private var recyclerVFeesResultFAdm: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_fees_result_frag_fees_act_adm, container, false)
        recyclerVFeesResultFAdm = view.findViewById(R.id.recyclerVFeesResultFAdm)
        recyclerVFeesResultFAdm?.setLayoutManager(LinearLayoutManager(context))
        addDataToHolder()
        recyclerVFeesResultFAdm?.setAdapter(AdapterFeesResultFAdm(dataHolder))
        return view
    }

    private fun addDataToHolder() {
        dataHolder = ArrayList()
        val obj = DataModelRecVFeesResultFAdm(
            452680, "Shrikant",
            56000
        )
        dataHolder!!.add(obj)
    }
}