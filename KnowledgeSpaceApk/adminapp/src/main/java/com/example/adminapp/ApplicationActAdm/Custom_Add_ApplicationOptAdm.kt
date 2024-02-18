package com.example.adminapp.ApplicationActAdm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adminapp.R

class Custom_Add_ApplicationOptAdm : Fragment() {
    private var receiverIdEditTvCusAddApplicationOptAdm: EditText? = null
    private var applicationSubjectEditTvCusAddApplicationOptAdm: EditText? = null
    private var applicationBodyEditTvCusAddApplicationOptAdm: EditText? = null
    private var applicationAttachmentEditTvCusAddApplicationOptAdm: TextView? = null
    private var sendApplicationBtnCusAddApplicationOptAdm: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_custom__add__application_opt_adm, container, false)
        receiverIdEditTvCusAddApplicationOptAdm =
            view.findViewById(R.id.receiverIdEditTvCusAddApplicationOptAdm)
        applicationSubjectEditTvCusAddApplicationOptAdm =
            view.findViewById(R.id.applicationSubjectEditTvCusAddApplicationOptAdm)
        applicationBodyEditTvCusAddApplicationOptAdm =
            view.findViewById(R.id.applicationBodyEditTvCusAddApplicationOptAdm)
        applicationAttachmentEditTvCusAddApplicationOptAdm =
            view.findViewById(R.id.applicationAttachmentEditTvCusAddApplicationOptAdm)
        sendApplicationBtnCusAddApplicationOptAdm =
            view.findViewById(R.id.sendApplicationBtnCusAddApplicationOptAdm)
        applicationAttachmentEditTvCusAddApplicationOptAdm?.setOnClickListener(View.OnClickListener {
            val ADDATTACHMENT_RESULT_CODE = 1
            val accessFileIntent = Intent(Intent.ACTION_GET_CONTENT)
            accessFileIntent.setType("*" + "/*")
            startActivityForResult(accessFileIntent, ADDATTACHMENT_RESULT_CODE)
        })
        sendApplicationBtnCusAddApplicationOptAdm?.setOnClickListener(View.OnClickListener {
            if (requireFragmentManager().backStackEntryCount != 0) {
                requireFragmentManager().popBackStack()
            }
            Toast.makeText(context, "No Backend", Toast.LENGTH_SHORT).show()
        })
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val filePath = data!!.data!!.path
                Log.i("file path ----- ", filePath!!)
                applicationAttachmentEditTvCusAddApplicationOptAdm!!.text = filePath
            }
        }
    }
}