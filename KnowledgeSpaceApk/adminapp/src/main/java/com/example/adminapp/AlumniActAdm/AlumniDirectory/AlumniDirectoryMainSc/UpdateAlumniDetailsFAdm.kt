package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.adminapp.R

class UpdateAlumniDetailsFAdm : Fragment() {
    private var imgVRegNoUpdateAlumniDetailFAdm: ImageView? = null
    private var imgVDeptUpdateAlumniDetailFAdm: ImageView? = null
    private var imgVBatchYrUpdateAlumniDetailFAdm: ImageView? = null
    private var imgVEditTvNameUpdateAlumniDetailFAdm: ImageView? = null
    private var editTvRegNoUpdateAlumniDetailFAdm: TextView? = null
    private var editTvBatchYrUpdateAlumniDetailFAdm: TextView? = null
    private var editTvDeptNameUpdateAlumniDetailFAdm: TextView? = null
    private var editTvNameUpdateAlumniDetailFAdm: TextView? = null
    private var imgVUpdateAlumniDetailFAdm: ImageView? = null
    private var updateAlumniBtnUpdateAlumniDetailFAdm: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_update_alumni_details_f_adm, container, false)
        imgVUpdateAlumniDetailFAdm = view.findViewById(R.id.imgVUpdateAlumniDetailFAdm)
        imgVUpdateAlumniDetailFAdm?.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(
                Intent.createChooser(intent, "Select Alumni Picture"),
                AdapterAlumniSearchResultFAdm.Companion.PICK_IMAGE
            )
        })
        imgVEditTvNameUpdateAlumniDetailFAdm =
            view.findViewById(R.id.imgVEditTvNameUpdateAlumniDetailFAdm)
        editTvNameUpdateAlumniDetailFAdm = view.findViewById(R.id.editTvNameUpdateAlumniDetailFAdm)
        editTvNameUpdateAlumniDetailFAdm?.setEnabled(false)
        imgVEditTvNameUpdateAlumniDetailFAdm?.setOnClickListener(View.OnClickListener {
            editTvNameUpdateAlumniDetailFAdm?.setEnabled(
                true
            )
        })
        imgVBatchYrUpdateAlumniDetailFAdm =
            view.findViewById(R.id.imgVBatchYrUpdateAlumniDetailFAdm)
        editTvBatchYrUpdateAlumniDetailFAdm =
            view.findViewById(R.id.editTvBatchYrUpdateAlumniDetailFAdm)
        editTvBatchYrUpdateAlumniDetailFAdm?.setEnabled(false)
        imgVBatchYrUpdateAlumniDetailFAdm?.setOnClickListener(View.OnClickListener {
            editTvBatchYrUpdateAlumniDetailFAdm?.setEnabled(
                true
            )
        })
        imgVDeptUpdateAlumniDetailFAdm = view.findViewById(R.id.imgVDeptUpdateAlumniDetailFAdm)
        editTvDeptNameUpdateAlumniDetailFAdm =
            view.findViewById(R.id.editTvDeptNameUpdateAlumniDetailFAdm)
        editTvDeptNameUpdateAlumniDetailFAdm?.setEnabled(false)
        imgVDeptUpdateAlumniDetailFAdm?.setOnClickListener(View.OnClickListener {
            editTvDeptNameUpdateAlumniDetailFAdm?.setEnabled(
                true
            )
        })
        imgVRegNoUpdateAlumniDetailFAdm = view.findViewById(R.id.imgVRegNoUpdateAlumniDetailFAdm)
        editTvRegNoUpdateAlumniDetailFAdm =
            view.findViewById(R.id.editTvRegNoUpdateAlumniDetailFAdm)
        editTvRegNoUpdateAlumniDetailFAdm?.setEnabled(false)
        imgVRegNoUpdateAlumniDetailFAdm?.setOnClickListener(View.OnClickListener {
            editTvRegNoUpdateAlumniDetailFAdm?.setEnabled(
                true
            )
        })


//        cancelBtnImgVUpdateAlumniDetailFAdm = view.findViewById(R.id.cancelBtnImgVUpdateAlumniDetailFAdm);
//        cancelBtnImgVUpdateAlumniDetailFAdm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                view.setCancelable(true);
////                view.dismiss();
//            }
//        });
        updateAlumniBtnUpdateAlumniDetailFAdm =
            view.findViewById(R.id.updateAlumniBtnUpdateAlumniDetailFAdm)
        updateAlumniBtnUpdateAlumniDetailFAdm?.setOnClickListener(View.OnClickListener { requireFragmentManager().popBackStack() })
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMG && resultCode == Activity.RESULT_OK) {
            val uri = data!!.data
            imgVUpdateAlumniDetailFAdm!!.setImageURI(uri)
            Log.i("image path ---> ", uri!!.path!!)
        }
    }

    companion object {
        private const val PICK_IMG = 1
    }
}