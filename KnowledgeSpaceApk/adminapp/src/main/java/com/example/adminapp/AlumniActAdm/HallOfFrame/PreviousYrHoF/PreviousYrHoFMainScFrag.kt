package com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.RecyclerVMainSc.AdapterRecVMainScPrevYrHoFAdm
import com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.RecyclerVMainSc.DataModelRecVMainScPrevYrHoF
import com.example.adminapp.R

class PreviousYrHoFMainScFrag : Fragment(), AdapterView.OnItemSelectedListener {
    private var recyclerVPrevYrHoFMainScAdm: RecyclerView? = null
    private val selectYrPrevYrHoFMainScFAdm: TextView? = null
    private var searchBtnPrevYrHoFMainScFragAdm: Button? = null
    private var dataHolder: ArrayList<DataModelRecVMainScPrevYrHoF>? = null
    private var spinnerSelectYearPrevYrHoFMainScFAdm: Spinner? = null
    private var dataHolderSpinner: ArrayList<DataModelForSpinnerPrevYrOpts>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_previous_yr_ho_f_main_sc, container, false)
        recyclerVPrevYrHoFMainScAdm = view.findViewById(R.id.recyclerVPrevYrHoFMainScAdm)
        //        selectYrPrevYrHoFMainScFAdm = view.findViewById(R.id.selectYrPrevYrHoFMainScFAdm);
        searchBtnPrevYrHoFMainScFragAdm = view.findViewById(R.id.searchBtnPrevYrHoFMainScFragAdm)
        spinnerSelectYearPrevYrHoFMainScFAdm =
            view.findViewById(R.id.spinnerSelectYearPrevYrHoFMainScFAdm)

        //Todo koi method h iske liye?
        dataHolderSpinner = ArrayList()
        addSpinnerData()
        val arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item, years
        )
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        spinnerSelectYearPrevYrHoFMainScFAdm?.setAdapter(arrayAdapter)
        spinnerSelectYearPrevYrHoFMainScFAdm?.setOnItemSelectedListener(this)
        val gridLayoutManager = GridLayoutManager(view.context, 2)
        recyclerVPrevYrHoFMainScAdm?.setLayoutManager(gridLayoutManager)
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerVPrevYrHoFMainScAdm?.addItemDecoration(dividerItemDecoration)
        dataHolder = ArrayList()
        addData()
        recyclerVPrevYrHoFMainScAdm?.setAdapter(AdapterRecVMainScPrevYrHoFAdm(dataHolder!!))
        return view
    }

    private fun addSpinnerData() {
        val obj = DataModelForSpinnerPrevYrOpts(2019)
        dataHolderSpinner!!.add(obj)
        dataHolderSpinner!!.add(obj)
        val obj2 = DataModelForSpinnerPrevYrOpts(2020)
        dataHolderSpinner!!.add(obj2)
        val obj3 = DataModelForSpinnerPrevYrOpts(2022)
        dataHolderSpinner!!.add(obj3)
        val obj4 = DataModelForSpinnerPrevYrOpts(2023)
        dataHolderSpinner!!.add(obj4)
        val obj5 = DataModelForSpinnerPrevYrOpts(2024)
        dataHolderSpinner!!.add(obj5)
        val obj6 = DataModelForSpinnerPrevYrOpts(2025)
        dataHolderSpinner!!.add(obj6)
    }

    //Todo add backend linked profile link
    private fun addData() {
        val card1 = DataModelRecVMainScPrevYrHoF(
            R.drawable.ic_baseline_person_24,
            R.drawable.linkedin,
            "Shrikant", "Computer"
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
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        when (position) {
            0 -> {}
            1 -> Toast.makeText(context, "1", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(context, "3", Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(context, "4", Toast.LENGTH_SHORT).show()
            5 -> Toast.makeText(context, "5", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    companion object {
        private val years = arrayOf("20XX", "2019", "2020", "2021", "2022", "2023")
    }
}