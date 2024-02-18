package com.example.adminapp.HomeworkActAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeworkDefaultFragAdm : Fragment() {
    private var recyclerView: RecyclerView? = null
    var adapter: adapterRecVHomeworkActAdm? = null
    private var dataHolder: ArrayList<dataModelRecVHomeworkActAdm>? = null
    private var createHwBtn: FloatingActionButton? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_homework_default_frag_adm, container, false)
        recyclerView = view.findViewById(R.id.recyclerVHomeworkDefaultFragAdm)
        recyclerView?.setLayoutManager(LinearLayoutManager(context))
        dataHolder = ArrayList()
        for (i in 0..19) {
            val obj1 = dataModelRecVHomeworkActAdm("Lp-3 Assignment 4")
            dataHolder!!.add(obj1)
        }
        recyclerView?.setAdapter(adapterRecVHomeworkActAdm(dataHolder!!))
        createHwBtn = view.findViewById(R.id.floatingBtnHomeworkDefaultFragAdm)
        createHwBtn?.setOnClickListener(View.OnClickListener {
            val fragmentTransaction = activity?.getSupportFragmentManager()?.beginTransaction()
            fragmentTransaction?.replace(R.id.parentFrameLayoutHomeworkAdm, CreateHomeworkFragAdm())
            fragmentTransaction?.commit()
        })
        return view
    }
}