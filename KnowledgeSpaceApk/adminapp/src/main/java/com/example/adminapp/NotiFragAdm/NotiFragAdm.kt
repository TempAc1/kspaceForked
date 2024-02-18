package com.example.adminapp.NotiFragAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class NotiFragAdm : Fragment() {
    private var recyclerVFragNotiSc: RecyclerView? = null
    var adapter: adapterRecVNotiFragAdm? = null
    private var dataHolderNotiFrag: ArrayList<dataModelRecVFragNotiAdm>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =
            LayoutInflater.from(context).inflate(R.layout.fragment_noti_frag_adm, container, false)
        recyclerVFragNotiSc = view.findViewById(R.id.recyclerVNotiFragAdm)
        recyclerVFragNotiSc?.setLayoutManager(LinearLayoutManager(context))
        dataHolderNotiFrag = ArrayList()
        for (i in 0..49) {
            val obj1 = dataModelRecVFragNotiAdm(
                "You have a pending assignment Lab-" + i
                        + "Please Submit it before tomorrow 2 p.m at school teacher office to Sir.Y.K Pandey"
            )
            dataHolderNotiFrag!!.add(obj1)
        }
        recyclerVFragNotiSc?.setAdapter(adapterRecVNotiFragAdm(dataHolderNotiFrag!!))
        return view
    }
}