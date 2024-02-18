package com.example.adminapp.GroupFragAdm

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
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseSelectedFAdm : Fragment() {
    private var recyclerVCourseSelectedOptAdm: RecyclerView? = null
    private var addModuleTvCourseSelectedFAdm: TextView? = null
    private var addCourseTvCourseSelectedFAdm: TextView? = null
    private var autoCompleteTvDropDownSpinnerAddModuleDia: TextView? = null
    private var moduleAttachmentTvCusDiaAddModuleAdm: TextView? = null
    private var floatingBtnCourseSelectedOptAdm: FloatingActionButton? = null
    private var addModuleFloatingBtnCourseSelectedFAdm: FloatingActionButton? = null
    private var addCourseFloatingBtnCourseSelectedFAdm: FloatingActionButton? = null
    private val adapter: adapterRecVCourseSelectedFAdm? = null
    private var dataHolder: ArrayList<dataModelRecVCourseSelectedFAdm>? = null
    private var isBtnVisible = false
    private var cancelBtnAddCourseDialog: ImageView? = null
    private var cancelBtnCusDiaAddModuleAdm: ImageView? = null
    private var addCourseBtnCusDiaAddCourseAdm: Button? = null
    private val courseAvailable = arrayOf("A.I", "Blockchain", "Data Science", "Maths", "Physics")
    private var stringArrayAdapter: ArrayAdapter<String>? = null
    private var addModuleBtnCusDiaAddModuleAdm: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_course_selected_f_adm, container, false)
        floatingBtnCourseSelectedOptAdm = view.findViewById(R.id.floatingBtnCourseSelectedOptAdm)
        addCourseFloatingBtnCourseSelectedFAdm =
            view.findViewById(R.id.addCourseFloatingBtnCourseSelectedFAdm)
        addCourseTvCourseSelectedFAdm = view.findViewById(R.id.addCourseTvCourseSelectedFAdm)
        addModuleFloatingBtnCourseSelectedFAdm =
            view.findViewById(R.id.addModuleFloatingBtnCourseSelectedFAdm)
        addModuleTvCourseSelectedFAdm = view.findViewById(R.id.addModuleTvCourseSelectedFAdm)
        recyclerVCourseSelectedOptAdm = view.findViewById(R.id.recyclerVCourseSelectedOptAdm)
        recyclerVCourseSelectedOptAdm?.setLayoutManager(LinearLayoutManager(context))
        addObjToHolder()
        recyclerVCourseSelectedOptAdm?.setAdapter(adapterRecVCourseSelectedFAdm(dataHolder))
        floatingBtnCourseSelectedOptAdm?.setOnClickListener(View.OnClickListener { setBtnVisibility() })
        addCourseFloatingBtnCourseSelectedFAdm?.setOnClickListener(View.OnClickListener { openAddCourseDialog() })
        addModuleFloatingBtnCourseSelectedFAdm?.setOnClickListener(View.OnClickListener { openAddModuleDialog() })
        return view
    }

    private fun openAddModuleDialog() {
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.custom_dialog_addmodule_courseselected_f_adm)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.animation

        //Code for dropdown spinner
        autoCompleteTvDropDownSpinnerAddModuleDia =
            dialog.findViewById(R.id.autoCompleteTvDropDownSpinnerAddModuleDia)
        stringArrayAdapter = ArrayAdapter(
            dialog.context, R.layout.course_name_dropdown_item_addmodulef_adm,
            courseAvailable
        )

//        autoCompleteTvDropDownSpinnerAddModuleDia.addTextChangedListener((TextWatcher) dialog.getContext());
        //autoCompleteTvDropDownSpinnerAddModuleDia

        //Code For Add Attachment of Module:
        moduleAttachmentTvCusDiaAddModuleAdm =
            dialog.findViewById(R.id.moduleAttachmentTvCusDiaAddModuleAdm)
        moduleAttachmentTvCusDiaAddModuleAdm?.setOnClickListener(View.OnClickListener {
            val PICKFILE_RESULT_CODE = 20
            val acessFilesIntent = Intent(Intent.ACTION_GET_CONTENT)
            acessFilesIntent.setType("*/*")
            startActivityForResult(acessFilesIntent, PICKFILE_RESULT_CODE)
        })

        //Code for Dialog Cancel Btn
        addModuleBtnCusDiaAddModuleAdm = dialog.findViewById(R.id.addModuleBtnCusDiaAddModuleAdm)
        cancelBtnCusDiaAddModuleAdm = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
        cancelBtnCusDiaAddModuleAdm?.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
            dialog.setCancelable(true)
        })
        addModuleBtnCusDiaAddModuleAdm?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
            Toast.makeText(activity, "Posting...", Toast.LENGTH_SHORT).show()
        })
        dialog.show()
    }

    private fun openAddCourseDialog() {
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.custom_dialog_addcourse_courseselected_f_adm)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.animation

        //Code for Dialog Cancel Btn
        addCourseBtnCusDiaAddCourseAdm = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm)
        cancelBtnAddCourseDialog = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
        cancelBtnAddCourseDialog?.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
            dialog.setCancelable(true)
        })
        addCourseBtnCusDiaAddCourseAdm?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
            Toast.makeText(activity, "Posting...", Toast.LENGTH_SHORT).show()
        })
        dialog.show()
    }

    private fun setBtnVisibility() {
        if (!isBtnVisible) {
            addCourseFloatingBtnCourseSelectedFAdm!!.visibility = View.VISIBLE
            addCourseTvCourseSelectedFAdm!!.visibility = View.VISIBLE
            addModuleFloatingBtnCourseSelectedFAdm!!.visibility = View.VISIBLE
            addModuleTvCourseSelectedFAdm!!.visibility = View.VISIBLE
            isBtnVisible = true
        } else {
            addCourseFloatingBtnCourseSelectedFAdm!!.visibility = View.GONE
            addCourseTvCourseSelectedFAdm!!.visibility = View.GONE
            addModuleFloatingBtnCourseSelectedFAdm!!.visibility = View.GONE
            addModuleTvCourseSelectedFAdm!!.visibility = View.GONE
            isBtnVisible = false
        }
    }

    private fun addObjToHolder() {
        dataHolder = ArrayList()
        val obj1 = dataModelRecVCourseSelectedFAdm("Blochain", 8)
        dataHolder!!.add(obj1)
        val obj2 = dataModelRecVCourseSelectedFAdm("Iot", 10)
        dataHolder!!.add(obj2)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj2)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj2)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj2)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj2)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj2)
        dataHolder!!.add(obj2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val filePath = data!!.data!!.path
                Log.i("file path ----- ", filePath!!)
                moduleAttachmentTvCusDiaAddModuleAdm!!.text = filePath
            }
        }
    }
}