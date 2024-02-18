package com.example.adminapp.FeesActAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adminapp.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class DefaultFragFeesActAdm : Fragment() {
    private var viewFeesBtnDefaultFFeesActAdm: Button? = null
    private var downloadFeesBtnDefaultFFeesActAdm: Button? = null
    private var roleEditTvFeesActMainScAdm: EditText? = null
    private var rolePassEditTvFeesActMainScAdm: EditText? = null
    private var chipGrpDefaultFragFeesActAdm: ChipGroup? = null
    private var feesPaidChipBtnChipGrpDefaultFragFeesActAdm: Chip? = null
    private var feesNotPaidChipBtnChipGrpDefaultFragFeesActAdm: Chip? = null
    private var allFeesChipBtnChipGrpDefaultFragFeesActAdm: Chip? = null
    private var textInputLayDefaultFeesFragAdm: AutoCompleteTextView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_default_frag_fees_act_adm, container, false)
        viewFeesBtnDefaultFFeesActAdm = view.findViewById(R.id.viewFeesBtnDefaultFFeesActAdm)
        downloadFeesBtnDefaultFFeesActAdm =
            view.findViewById(R.id.downloadFeesBtnDefaultFFeesActAdm)
        roleEditTvFeesActMainScAdm = view.findViewById(R.id.roleEditTvFeesActMainScAdm)
        rolePassEditTvFeesActMainScAdm = view.findViewById(R.id.rolePassEditTvFeesActMainScAdm)
        chipGrpDefaultFragFeesActAdm = view.findViewById(R.id.chipGrpDefaultFragFeesActAdm)
        chipGrpDefaultFragFeesActAdm?.setSelectionRequired(true)
        feesPaidChipBtnChipGrpDefaultFragFeesActAdm =
            view.findViewById(R.id.feesPaidChipBtnChipGrpDefaultFragFeesActAdm)
        feesNotPaidChipBtnChipGrpDefaultFragFeesActAdm =
            view.findViewById(R.id.feesNotPaidChipBtnChipGrpDefaultFragFeesActAdm)
        allFeesChipBtnChipGrpDefaultFragFeesActAdm =
            view.findViewById(R.id.allFeesChipBtnChipGrpDefaultFragFeesActAdm)
        textInputLayDefaultFeesFragAdm = view.findViewById(R.id.autoCompleteTextViewDefaultFFeesAdm)

        //We will use this data to inflate the drop-down items
        val authorityLevel =
            arrayOf("Administrator", "Teacher-Guardian", "Class Teacher", "H.O.D", "Principle")

        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val adapter = ArrayAdapter(
            requireContext(), R.layout.dropdown_menuitems_defaultfees_f_adm, authorityLevel
        )
        textInputLayDefaultFeesFragAdm?.setAdapter(adapter)
        textInputLayDefaultFeesFragAdm?.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(
                context,
                "" + textInputLayDefaultFeesFragAdm?.getText().toString(),
                Toast.LENGTH_SHORT
            ).show()
        })
        viewFeesBtnDefaultFFeesActAdm?.setOnClickListener(View.OnClickListener {
            val fr: Fragment = FeesResultFragFeesActAdm()
            val ft = requireFragmentManager().beginTransaction()
            ft.replace(R.id.frameLayFeesActMainScAdm, fr).commit()
            ft.addToBackStack(null)
        })
        return view
    }
}