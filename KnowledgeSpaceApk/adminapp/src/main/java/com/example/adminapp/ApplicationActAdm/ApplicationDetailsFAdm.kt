package com.example.adminapp.ApplicationActAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adminapp.R

class ApplicationDetailsFAdm : Fragment() {
    private var imgBtnApplicationDetailsFAdm: ImageButton? = null
    private var receiverIdTvApplicationDetailsFAdm: TextView? = null
    private var applicationSubjectTvApplicationDetailsFAdm: TextView? = null
    private var applicationBodyTvApplicationDetailsFAdm: TextView? = null
    private var applicationAttachmentTvApplicationDetailsFAdm: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_application_details_f_adm, container, false)
        receiverIdTvApplicationDetailsFAdm =
            view.findViewById(R.id.receiverIdTvApplicationDetailsFAdm)
        applicationSubjectTvApplicationDetailsFAdm =
            view.findViewById(R.id.applicationSubjectTvApplicationDetailsFAdm)
        applicationBodyTvApplicationDetailsFAdm =
            view.findViewById(R.id.applicationBodyTvApplicationDetailsFAdm)
        applicationAttachmentTvApplicationDetailsFAdm =
            view.findViewById(R.id.applicationAttachmentTvApplicationDetailsFAdm)
        imgBtnApplicationDetailsFAdm = view.findViewById(R.id.imgBtnApplicationDetailsFAdm)
        imgBtnApplicationDetailsFAdm?.setOnClickListener(View.OnClickListener {
            if (requireFragmentManager().backStackEntryCount != 0) {
                requireFragmentManager().popBackStack()
            }
            Toast.makeText(context, "No Backend", Toast.LENGTH_SHORT).show()
        })
        return view
    }
}