package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass.
 * Use the [AlumniDirectoryMainScFAdm.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlumniDirectoryMainScFAdm : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    //Mine Declarations:
    private var editTextTextPersonNameAlumniDirectoryMainScFAdm: EditText? = null
    private var editTvBatchYrAlumniDirMainScFAdm: EditText? = null
    private var editTvDeptNameAlumniDirMainScFAdm: EditText? = null
    private var editTvRegNoAlumniDirMainScFAdm: EditText? = null
    private var searchBtnAlumniDirectoryMainScFAdm: Button? = null
    private var floatingBtnAddAlumniAlumniDirMainScFAdm: FloatingActionButton? = null
    private var editTextTextPersonNameAddCusDialogAlumniDirectoryFAdm: EditText? = null
    private var editTvBatchYrCusDialogAlumniDirMainScFAdm: EditText? = null
    private var editTvDeptNameCusDialogAlumniDirMainScFAdm: EditText? = null
    private var editTvRegNoCusDialogAlumniDirMainScFAdm: EditText? = null
    private var addAlumniBtnCusDialogAlumniDirFAdm: Button? = null
    private var imgVCusDialogAddAlumniDirFAdm: ImageView? = null
    private var cancelBtnImgVCusDiaAddAlumniDirFAdm: ImageView? = null
    private var cancelBtnImgVCusDiaAskAdminAlumniAddFAdm: ImageView? = null
    var RESULT_LOAD_IMAGE = 100
    private var batchTvAskAdminAddInBatchOrSingleAlumniDialog: TextView? = null
    private var singleTvAskAdminAddInBatchOrSingleAlumniDialog: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
            mParam2 = requireArguments().getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_alumni_directory_main_sc_f_adm, container, false)
        editTextTextPersonNameAlumniDirectoryMainScFAdm =
            view.findViewById(R.id.editTvNameCusDialogAddAlumniFAdm)
        editTvBatchYrAlumniDirMainScFAdm =
            view.findViewById(R.id.editTvBatchYrCusDialogAlumniDirMainScFAdm)
        editTvDeptNameAlumniDirMainScFAdm =
            view.findViewById(R.id.editTvDeptNameCusDialogAlumniDirMainScFAdm)
        editTvRegNoAlumniDirMainScFAdm =
            view.findViewById(R.id.editTvRegNoCusDialogAlumniDirMainScFAdm)
        searchBtnAlumniDirectoryMainScFAdm =
            view.findViewById(R.id.searchBtnAlumniDirectoryMainScFAdm)
        searchBtnAlumniDirectoryMainScFAdm?.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Opening without backend", Toast.LENGTH_SHORT).show()
            val activity = view.context as AppCompatActivity
            val fl = activity.findViewById<FrameLayout>(R.id.frameLayAlumniFragHomeSc)
            fl.removeAllViews()
            val fragment: Fragment = AlumniSearchResultFAdm()
            val manager = activity.supportFragmentManager
            val fragmentTransaction = manager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayAlumniFragHomeSc, fragment).commit()
            fragmentTransaction.addToBackStack(R.layout.fragment_alumni_frag_home_sc.toString())
        })
        floatingBtnAddAlumniAlumniDirMainScFAdm =
            view.findViewById(R.id.floatingBtnAddAlumniAlumniDirMainScFAdm)
        floatingBtnAddAlumniAlumniDirMainScFAdm?.setOnClickListener(View.OnClickListener { openAddAlumniDialog() })
        return view
    }

    private fun openAddAlumniDialog() {
        val dialog = Dialog(requireActivity())
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_askadmin_add_in_batchorsingle_alumni)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.animation
        batchTvAskAdminAddInBatchOrSingleAlumniDialog =
            dialog.findViewById(R.id.batchTvAskAdminAddInBatchOrSingleAlumniDialog)
        batchTvAskAdminAddInBatchOrSingleAlumniDialog?.setOnClickListener(View.OnClickListener {
            openBatchAddAlumniDialog()
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        singleTvAskAdminAddInBatchOrSingleAlumniDialog =
            dialog.findViewById(R.id.singleTvAskAdminAddInBatchOrSingleAlumniDialog)
        singleTvAskAdminAddInBatchOrSingleAlumniDialog?.setOnClickListener(View.OnClickListener {
            openSingularAddAlumniDialog()
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        cancelBtnImgVCusDiaAskAdminAlumniAddFAdm =
            dialog.findViewById(R.id.cancelBtnImgVCusDiaAskAdminAlumniAddFAdm)
        cancelBtnImgVCusDiaAskAdminAlumniAddFAdm?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        dialog.show()
    }

    private fun openBatchAddAlumniDialog() {}
    private fun openSingularAddAlumniDialog() {
        val dialog = Dialog(requireActivity())
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_add_alumni_dir_f_adm)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog.window!!.attributes.windowAnimations = R.style.animation
        editTextTextPersonNameAddCusDialogAlumniDirectoryFAdm =
            dialog.findViewById(R.id.editTvNameCusDialogAddAlumniFAdm)
        editTvBatchYrCusDialogAlumniDirMainScFAdm =
            dialog.findViewById(R.id.editTvBatchYrCusDialogAlumniDirMainScFAdm)
        editTvRegNoCusDialogAlumniDirMainScFAdm =
            dialog.findViewById(R.id.editTvRegNoCusDialogAlumniDirMainScFAdm)
        editTvDeptNameCusDialogAlumniDirMainScFAdm =
            dialog.findViewById(R.id.editTvDeptNameCusDialogAlumniDirMainScFAdm)
        imgVCusDialogAddAlumniDirFAdm = dialog.findViewById(R.id.imgVCusDialogAddAlumniDirFAdm)
        imgVCusDialogAddAlumniDirFAdm?.setOnClickListener(View.OnClickListener {
            val i = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(i, RESULT_LOAD_IMAGE)
        })
        cancelBtnImgVCusDiaAddAlumniDirFAdm =
            dialog.findViewById(R.id.cancelBtnImgVCusDiaAskAdminAlumniAddFAdm)
        cancelBtnImgVCusDiaAddAlumniDirFAdm?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        addAlumniBtnCusDialogAlumniDirFAdm =
            dialog.findViewById(R.id.addAlumniBtnCusDialogAlumniDirFAdm)
        addAlumniBtnCusDialogAlumniDirFAdm?.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Added without backend", Toast.LENGTH_SHORT).show()
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        dialog.show()
    }

    //TODO editext ka value save karna hai backend me av kch v save nahi ho raha h
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK) {
            val uri = data!!.data
            imgVCusDialogAddAlumniDirFAdm!!.setImageURI(uri)
            Log.i("image path ---> ", uri!!.path!!)
        }
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AlumniDirectoryMainScFAdm.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): AlumniDirectoryMainScFAdm {
            val fragment = AlumniDirectoryMainScFAdm()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}