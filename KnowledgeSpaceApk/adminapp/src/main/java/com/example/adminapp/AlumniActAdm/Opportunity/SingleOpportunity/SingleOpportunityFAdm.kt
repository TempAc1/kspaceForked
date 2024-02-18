package com.example.adminapp.AlumniActAdm.Opportunity.SingleOpportunity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adminapp.R

class SingleOpportunityFAdm : Fragment() {
    private var applyForOpportunityBtnSingleOpportFAdm: Button? = null
    private var updateOpportBtnSingleOpportFAdm: Button? = null
    private var opportTitleTvSingleOpportFAdm: EditText? = null
    private var opportDescTvSingleOpportFAdm: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_single_opportunity_f_adm, container, false)
        applyForOpportunityBtnSingleOpportFAdm =
            view.findViewById(R.id.applyForOpportunityBtnSingleOpportFAdm)
        updateOpportBtnSingleOpportFAdm = view.findViewById(R.id.updateOpportBtnSingleOpportFAdm)
        opportDescTvSingleOpportFAdm = view.findViewById(R.id.opportDescTvSingleOpportFAdm)
        opportTitleTvSingleOpportFAdm = view.findViewById(R.id.opportTitleTvSingleOpportFAdm)
        //Todo create backend
        applyForOpportunityBtnSingleOpportFAdm?.setOnClickListener(View.OnClickListener {
            Toast.makeText(view.context, "Clicked without backend", Toast.LENGTH_SHORT).show()
            //                if(b != null){
//                    Uri uri = Uri.parse(String.valueOf(b)); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(getContext(), "Error Catching", Toast.LENGTH_SHORT).show();
//                }
        })
        updateOpportBtnSingleOpportFAdm?.setOnClickListener(View.OnClickListener {
            opportTitleTvSingleOpportFAdm?.setEnabled(true)
            opportDescTvSingleOpportFAdm?.setEnabled(true)
            Toast.makeText(view.context, "Clicked update without backend", Toast.LENGTH_SHORT)
                .show()
        })
        return view
    }
}