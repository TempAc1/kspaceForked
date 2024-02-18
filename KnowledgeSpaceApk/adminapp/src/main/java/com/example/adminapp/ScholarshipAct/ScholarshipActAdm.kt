package com.example.adminapp.ScholarshipAct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class ScholarshipActAdm : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var dataHolder: ArrayList<dataModelRecVScholarshipActAdm>? = null
    private var adapter: adapterScholarshipActAdm? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scholarship_act_adm)
        recyclerView = findViewById(R.id.recyclerVScholarshipActAdm)
        recyclerView?.setLayoutManager(LinearLayoutManager(applicationContext))
        setData()
        adapter = adapterScholarshipActAdm(dataHolder)
        recyclerView?.setAdapter(adapter)
    }

    private fun setData() {
        dataHolder = ArrayList()
        //Add data
        val obj1 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj1)
        val obj2 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj2)
        val obj3 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj3)
        val obj4 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj4)
        val obj5 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj5)
        val obj6 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj6)
        val obj7 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj7)
        val obj8 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj8)
        val obj9 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj9)
        val obj10 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj10)
        val obj11 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj11)
        val obj12 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj12)
        val obj13 = dataModelRecVScholarshipActAdm("Demo", "demo.com", R.drawable.maths_quize)
        dataHolder!!.add(obj13)
    }
}