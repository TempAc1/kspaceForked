package com.example.adminapp.ApplicationActAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ApplicationActMainFAdm : Fragment() {
    private var recyclerVApplicationActMainFAdm: RecyclerView? = null
    private var frameLayApplicationActMainFAdm: FrameLayout? = null
    private var floatingBtnApplicationActMainFAdm: FloatingActionButton? = null
    private var dataHolder: ArrayList<DataModelRecVApplicationMainFAdm?>? = null
    private val adapter: AdapterApplicationMainFAdm? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_application_act_main_f_adm, container, false)
        recyclerVApplicationActMainFAdm = view.findViewById(R.id.recyclerVApplicationActMainFAdm)
        frameLayApplicationActMainFAdm = view.findViewById(R.id.frameLayApplicationActMainFAdm)
        floatingBtnApplicationActMainFAdm =
            view.findViewById(R.id.floatingBtnApplicationActMainFAdm)
        floatingBtnApplicationActMainFAdm?.setOnClickListener(View.OnClickListener {
            val fragment: Fragment = Custom_Add_ApplicationOptAdm()
            val fragmentTransaction = requireFragmentManager().beginTransaction()
            fragmentTransaction.replace(R.id.frameLayApplicationActAdm, fragment).commit()
            fragmentTransaction.addToBackStack(null)
        })
        recyclerVApplicationActMainFAdm?.setLayoutManager(LinearLayoutManager(context))
        addDataToHolder()
        recyclerVApplicationActMainFAdm?.setAdapter(AdapterApplicationMainFAdm(dataHolder))
        return view
    }

    private fun addDataToHolder() {
        dataHolder = ArrayList()
        val obj = DataModelRecVApplicationMainFAdm(
            "#58464",
            "Leave Application",
            "Demo Description here"
        )
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
        dataHolder!!.add(obj)
    }
}