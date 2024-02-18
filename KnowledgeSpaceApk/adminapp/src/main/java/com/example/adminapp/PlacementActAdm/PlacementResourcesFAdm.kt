package com.example.adminapp.PlacementActAdm

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PlacementResourcesFAdm : Fragment() {
    private var dataHolder: ArrayList<DataModelRecVPlacementResourcesFAdm>? = null
    private val adapter: AdapterPlacementResourcesFAdm? = null
    private var recyclerVPlacementResourcesFAdm: RecyclerView? = null
    private var floationBtnAddResourcesPlacementResourcesFAdm: FloatingActionButton? = null

    //cus Dialog:
    private var cancelBtnImgVCusDiaAddResources: ImageView? = null
    private var setResourceTvCusDiaAddResources: TextView? = null
    private val setResourceTitleTvCusDiaAddResources: EditText? = null
    private var addResourceBtnCusDiaAddResources: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_placement_resources_f_adm, container, false)
        recyclerVPlacementResourcesFAdm = view.findViewById(R.id.recyclerVPlacementResourcesFAdm)
        floationBtnAddResourcesPlacementResourcesFAdm =
            view.findViewById(R.id.floationBtnAddResourcesPlacementResourcesFAdm)
        recyclerVPlacementResourcesFAdm?.setLayoutManager(LinearLayoutManager(context))
        addObjToHolder()
        recyclerVPlacementResourcesFAdm?.setAdapter(AdapterPlacementResourcesFAdm(dataHolder))

        //FloatingBtn:
        floationBtnAddResourcesPlacementResourcesFAdm?.setOnClickListener(View.OnClickListener { openDialog() })
        return view
    }

    private fun openDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.cus_dia_add_resources_fadm)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.animation
        cancelBtnImgVCusDiaAddResources = dialog.findViewById(R.id.cancelBtnImgVCusDiaAddResources)
        cancelBtnImgVCusDiaAddResources?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        addResourceBtnCusDiaAddResources =
            dialog.findViewById(R.id.addResourceBtnCusDiaAddResources)
        addResourceBtnCusDiaAddResources?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
            Toast.makeText(context, "Adding Offer...without backend", Toast.LENGTH_SHORT).show()
        })
        setResourceTvCusDiaAddResources = dialog.findViewById(R.id.setResourceTvCusDiaAddResources)
        setResourceTvCusDiaAddResources?.setOnClickListener(View.OnClickListener {
            val PICKFILE_RESULT_CODE = 1
            val acessFilesIntent = Intent(Intent.ACTION_GET_CONTENT)
            acessFilesIntent.setType("*/*")
            startActivityForResult(acessFilesIntent, PICKFILE_RESULT_CODE)
        })
        dialog.show()
    }

    private fun addObjToHolder() {
        dataHolder = ArrayList()
        val obj = DataModelRecVPlacementResourcesFAdm(
            "Demo",
            "demo"
        )
        dataHolder!!.add(obj)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val filePath = data!!.data!!.path
                Log.i("file path ----- ", filePath!!)
                setResourceTvCusDiaAddResources!!.text = filePath
            }
        }
    }
}