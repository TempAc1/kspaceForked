package com.example.adminapp.PlacementActAdm

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PlacementDefaultFAdm : Fragment() {
    private var dataHolder: ArrayList<DataModelRecVPlacementDefaultFAdm>? = null
    private var recyclerView: RecyclerView? = null
    private val adapter: AdapterPlacementDefaultFAdm? = null
    private var floatingBtnPlacementDefaultFAdm: FloatingActionButton? = null

    //    Dialog box
    private var cancelBtnImgVCusDiaAddPlacementOffer: ImageView? = null
    private val setOfferTitleTvCusDiaAddPlacementOffer: EditText? = null
    private val setOfferLinkTvCusDiaAddPlacementOffer: EditText? = null
    private val setOfferDescriptionTvCusDiaAddPlacementOffer: EditText? = null
    private var addOfferBtnCusDiaAddPlacementOffer: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_placement_default_f_adm, container, false)

        //All Ui need to add here:
        recyclerView = view.findViewById(R.id.recyclerVPlacementDefaultFAdm)
        floatingBtnPlacementDefaultFAdm = view.findViewById(R.id.floatingBtnPlacementDefaultFAdm)


        //Setting Up Recycler View:
        recyclerView?.setLayoutManager(LinearLayoutManager(context))
        addObjToHolder()
        recyclerView?.setAdapter(AdapterPlacementDefaultFAdm(dataHolder))
        floatingBtnPlacementDefaultFAdm?.setOnClickListener(View.OnClickListener {
            openDialog()
            Toast.makeText(context, "Clicked yeah", Toast.LENGTH_SHORT).show()
        })
        return view
    }

    private fun openDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.cus_dia_add_placement_offer_fadm)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.animation
        cancelBtnImgVCusDiaAddPlacementOffer =
            dialog.findViewById(R.id.cancelBtnImgVCusDiaAddPlacementOffer)
        cancelBtnImgVCusDiaAddPlacementOffer?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        addOfferBtnCusDiaAddPlacementOffer =
            dialog.findViewById(R.id.addOfferBtnCusDiaAddPlacementOffer)
        addOfferBtnCusDiaAddPlacementOffer?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
            Toast.makeText(context, "Adding Offer...without backend", Toast.LENGTH_SHORT).show()
        })
        dialog.show()
    }

    private fun addObjToHolder() {
        dataHolder = ArrayList()
        val obj = DataModelRecVPlacementDefaultFAdm(
            "Jio Platforms",
            "Dear Students Greetings from D. Y. Patil International University, Akurdi! It gives us immense pleasure to invite you for the Campus Recruitment of Pi Techniques Private Limited for 2023 Graduating Batch",
            "https://www.pitechniques.com/"
        )
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