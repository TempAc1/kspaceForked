package com.example.adminapp.GroupFragAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class GroupFragAdm : Fragment() {
    private var recyclerVFragGroupSc: RecyclerView? = null
    var adapter: adapterRecVGroupFragAdm? = null
    private var dataHolder: ArrayList<dataModelRecVGroupFragAdm>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =
            LayoutInflater.from(context).inflate(R.layout.fragment_group_frag_adm, container, false)
        recyclerVFragGroupSc = view.findViewById(R.id.recyclerVFragGroupScAdm)
        recyclerVFragGroupSc?.setLayoutManager(LinearLayoutManager(context))
        dataHolder = ArrayList()
        val obj1 = dataModelRecVGroupFragAdm(
            "Apple", "Orange",
            R.drawable.apple, R.drawable.orange
        )
        dataHolder!!.add(obj1)
        val obj2 = dataModelRecVGroupFragAdm(
            "Apple", "Orange",
            R.drawable.apple, R.drawable.orange
        )
        dataHolder!!.add(obj2)
        val obj3 = dataModelRecVGroupFragAdm(
            "Apple", "Orange",
            R.drawable.apple, R.drawable.orange
        )
        dataHolder!!.add(obj3)
        val obj4 = dataModelRecVGroupFragAdm(
            "Apple", "Orange",
            R.drawable.apple, R.drawable.orange
        )
        dataHolder!!.add(obj4)
        val obj5 = dataModelRecVGroupFragAdm(
            "Apple", "Orange",
            R.drawable.apple, R.drawable.orange
        )
        dataHolder!!.add(obj5)
        val obj6 = dataModelRecVGroupFragAdm(
            "Random",
            "Robotics", R.drawable.banana, R.drawable.orange
        )
        dataHolder!!.add(obj6)
        recyclerVFragGroupSc?.setAdapter(adapterRecVGroupFragAdm(dataHolder!!))
        return view
    }
}