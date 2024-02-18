package com.example.adminapp.AlumniActAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc.AlumniDirectoryMainScFAdm
import com.example.adminapp.AlumniActAdm.HallOfFrame.HallOfFrameMainFrag
import com.example.adminapp.AlumniActAdm.Opportunity.AlumniOpportunityFragAdm
import com.example.adminapp.R
import com.google.android.material.card.MaterialCardView

class AlumniFragHomeSc : Fragment() {
    private var frameLayAlumniFragHomeSc: FrameLayout? = null
    private var scrollVAlumniFragHomeSc: ScrollView? = null
    private var HallOfFrameMaterialCardVAlumniFragMainSc: MaterialCardView? = null
    private var OpportunitiesMaterialCardVAlumniFragMainSc: MaterialCardView? = null
    private var AlumniDirectoryMaterialCardVAlumniFragMainSc: MaterialCardView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_alumni_frag_home_sc, container, false)
        frameLayAlumniFragHomeSc = view.findViewById(R.id.frameLayAlumniFragHomeSc)
        scrollVAlumniFragHomeSc = view.findViewById(R.id.scrollVAlumniFragHomeSc)
        OpportunitiesMaterialCardVAlumniFragMainSc =
            view.findViewById(R.id.OpportunitiesMaterialCardVAlumniFragMainSc)
        OpportunitiesMaterialCardVAlumniFragMainSc?.setOnClickListener(View.OnClickListener {
            val activity = view.context as AppCompatActivity
            val fl = activity.findViewById<FrameLayout>(R.id.frameLayAlumniFragHomeSc)
            fl.removeAllViews()
            val fragment: Fragment = AlumniOpportunityFragAdm()
            val manager = activity.supportFragmentManager
            val fragmentTransaction = manager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayAlumniFragHomeSc, fragment).commit()
            fragmentTransaction.addToBackStack(R.layout.fragment_alumni_frag_home_sc.toString())
        })
        AlumniDirectoryMaterialCardVAlumniFragMainSc =
            view.findViewById(R.id.AlumniDirectoryMaterialCardVAlumniFragMainSc)
        AlumniDirectoryMaterialCardVAlumniFragMainSc?.setOnClickListener(View.OnClickListener {
            val activity = view.context as AppCompatActivity
            val fl = activity.findViewById<FrameLayout>(R.id.frameLayAlumniFragHomeSc)
            fl.removeAllViews()
            val fragment: Fragment = AlumniDirectoryMainScFAdm()
            val manager = activity.supportFragmentManager
            val fragmentTransaction = manager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayAlumniFragHomeSc, fragment).commit()
            fragmentTransaction.addToBackStack(R.layout.fragment_alumni_frag_home_sc.toString())
        })
        HallOfFrameMaterialCardVAlumniFragMainSc =
            view.findViewById(R.id.HallOfFrameMaterialCardVAlumniFragMainSc)
        HallOfFrameMaterialCardVAlumniFragMainSc?.setOnClickListener(View.OnClickListener {
            val activity = view.context as AppCompatActivity
            val fl = activity.findViewById<FrameLayout>(R.id.frameLayAlumniFragHomeSc)
            fl.removeAllViews()
            val fragment: Fragment = HallOfFrameMainFrag()
            val manager = activity.supportFragmentManager
            val fragmentTransaction = manager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayAlumniFragHomeSc, fragment).commit()
            fragmentTransaction.addToBackStack(R.layout.fragment_alumni_frag_home_sc.toString())
        })
        return view
    }
}