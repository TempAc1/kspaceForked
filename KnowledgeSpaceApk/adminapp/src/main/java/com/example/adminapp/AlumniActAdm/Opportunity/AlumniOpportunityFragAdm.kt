package com.example.adminapp.AlumniActAdm.Opportunity

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AlumniOpportunityFragAdm : Fragment() {
    private var recyclerVAlumniOpportunityFragAdm: RecyclerView? = null
    private var frameLayAlumniOpportunityFragAdm: FrameLayout? = null
    private var dataHolder: ArrayList<DataModelOpportunityFAdm>? = null
    private var floatingBtnAlumniOpportFragAdm: FloatingActionButton? = null
    private var cancelBtnImgVCusDiaAddOpportunityFAdm: ImageButton? = null
    private var setOfferDescriptionTvCusDiaAddOpportunityFAdm: EditText? = null
    private var setOfferTitleTvCusDiaAddOpportunityFAdm: EditText? = null
    private var setOfferLinkTvCusDiaAddOpportunityFAdm: EditText? = null
    private var addOfferBtnCusDiaAddOpportunityFAdm: Button? = null
    var offerLink: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_alumni_opportunity_frag_adm, container, false)
        recyclerVAlumniOpportunityFragAdm =
            view.findViewById(R.id.recyclerVAlumniOpportunityFragAdm)
        frameLayAlumniOpportunityFragAdm = view.findViewById(R.id.frameLayAlumniOpportunityFragAdm)
        val gridLayoutManager = GridLayoutManager(view.context, 2)
        recyclerVAlumniOpportunityFragAdm?.setLayoutManager(gridLayoutManager)
        dataHolder = ArrayList()
        addData()
        recyclerVAlumniOpportunityFragAdm?.setAdapter(AdapterOpportunityFAdm(dataHolder!!))
        floatingBtnAlumniOpportFragAdm = view.findViewById(R.id.floatingBtnAlumniOpportFragAdm)
        floatingBtnAlumniOpportFragAdm?.setOnClickListener(View.OnClickListener { openAddOpportDialog() })
        return view
    }

    private fun openAddOpportDialog() {
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.dialog_add_opportunity_f_adm)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.animation

        //Todo edittextv ka data save karna hai n then post karna hai usko dusre screen me
        cancelBtnImgVCusDiaAddOpportunityFAdm =
            dialog.findViewById(R.id.cancelBtnImgVCusDiaAskAdminAlumniAddFAdm)
        addOfferBtnCusDiaAddOpportunityFAdm =
            dialog.findViewById(R.id.addOfferBtnCusDiaAddOpportunityFAdm)
        setOfferTitleTvCusDiaAddOpportunityFAdm =
            dialog.findViewById(R.id.setOfferTitleTvCusDiaAddOpportunityFAdm)
        setOfferDescriptionTvCusDiaAddOpportunityFAdm =
            dialog.findViewById(R.id.setOfferDescriptionTvCusDiaAddOpportunityFAdm)
        setOfferLinkTvCusDiaAddOpportunityFAdm =
            dialog.findViewById(R.id.setOfferLinkTvCusDiaAddOpportunityFAdm)
        //Todo link to next frag me apply btn me integrate karna prega
        cancelBtnImgVCusDiaAddOpportunityFAdm?.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
            dialog.setCancelable(true)
        })
        addOfferBtnCusDiaAddOpportunityFAdm?.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
            dialog.setCancelable(true)
            Toast.makeText(dialog.context, "Posting without backend", Toast.LENGTH_SHORT).show()
        })
        dialog.show()
    }

    private fun addData() {
        val card1 = DataModelOpportunityFAdm(
            "Tagus Info",
            "Generating random paragraphs can be an excellent way for writers to get their creative flow going at the beginning of the day. The writer has no idea what topic the random paragraph will be about when it appears. This forces the writer to use creativity to complete one of three common writing challenges. The writer can use the paragraph as the first one of a short story and build upon it. A second option is to use the random paragraph somewhere in a short story they create. The third option is to have the random paragraph be the ending paragraph in a short story. No matter which of these challenges is undertaken, the writer is forced to use creativity to incorporate the paragraph into their writing."
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
    }
}