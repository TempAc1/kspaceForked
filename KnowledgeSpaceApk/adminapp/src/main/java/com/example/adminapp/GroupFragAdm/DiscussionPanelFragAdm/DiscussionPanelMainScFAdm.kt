package com.example.adminapp.GroupFragAdm.DiscussionPanelFragAdm

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
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DiscussionPanelMainScFAdm : Fragment() {
    private var recyclerVMainScDisPanelFAdm: RecyclerView? = null
    private var floatingActionBtnMainScDisPanelFAdm: FloatingActionButton? = null
    private var cancelBtnCusDiaAddDiscussion: ImageButton? = null
    private var postBtnCusDiaDisPanelMainScFAdm: Button? = null
    private var setDiscussionTitleTvCusDiaMainScFAdm: EditText? = null
    private var setDiscussionDescription: EditText? = null
    private var attachmentTvDisPanelFAdm: TextView? = null
    private val obj = DiscussionPanelData()
    private var dataHolder: ArrayList<DiscussionPanelData>? = null
    private var adapter: adapterRecVDisPanelMainSc? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_discussion_panel_main_sc_f_adm, container, false)
        recyclerVMainScDisPanelFAdm = view.findViewById(R.id.recyclerVMainScDisPanelFAdm)
        recyclerVMainScDisPanelFAdm?.setLayoutManager(LinearLayoutManager(context))
        setDataHolder()
        adapter = adapterRecVDisPanelMainSc(dataHolder)
        recyclerVMainScDisPanelFAdm?.setAdapter(adapter)
        floatingActionBtnMainScDisPanelFAdm =
            view.findViewById(R.id.floatingActionBtnMainScDisPanelFAdm)
        floatingActionBtnMainScDisPanelFAdm?.setOnClickListener(View.OnClickListener {
            val dialog = Dialog(requireActivity())
            dialog.setContentView(R.layout.custom_dia_add_discussion_mainsc_dispanel_fadm)
            dialog.window!!
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.attributes.windowAnimations = R.style.animation
            setDiscussionTitleTvCusDiaMainScFAdm =
                dialog.findViewById(R.id.setDiscussionTitleTvCusDiaMainScFAdm)
            setDiscussionDescription = dialog.findViewById(R.id.setDiscussionDescription)
            attachmentTvDisPanelFAdm = dialog.findViewById(R.id.attachmentTvDisPanelFAdm)
            cancelBtnCusDiaAddDiscussion = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
            postBtnCusDiaDisPanelMainScFAdm =
                dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm)
            attachmentTvDisPanelFAdm?.setOnClickListener(View.OnClickListener {
                val PICKFILE_RESULT_CODE = 1
                val acessFilesIntent = Intent(Intent.ACTION_GET_CONTENT)
                acessFilesIntent.setType("*/*")
                startActivityForResult(acessFilesIntent, PICKFILE_RESULT_CODE)
            })
            cancelBtnCusDiaAddDiscussion?.setOnClickListener(View.OnClickListener {
                dialog.setCancelable(true)
                dialog.dismiss()
            })
            postBtnCusDiaDisPanelMainScFAdm?.setOnClickListener(View.OnClickListener {
                if (!setDiscussionTitleTvCusDiaMainScFAdm?.getText().toString().trim { it <= ' ' }
                        .isEmpty()
                    && setDiscussionTitleTvCusDiaMainScFAdm?.getText().toString()
                        .trim { it <= ' ' } != " "
                    && !setDiscussionDescription?.getText().toString().trim { it <= ' ' }.isEmpty()
                    && setDiscussionDescription?.getText().toString().trim { it <= ' ' } != " "
                ) {

                    obj.title
                    obj.description
//                    (
//                        setDiscussionDescription?.getText().toString().trim { it <= ' ' })
                    obj.resources
//                    (Integer.parseInt(attachmentTvDisPanelFAdm?.getText().toString().trim()));
                    Toast.makeText(context, "Posting...noBackend", Toast.LENGTH_SHORT).show()
                    dialog.setCancelable(true)
                    dialog.dismiss()
                } else {
                    Toast.makeText(context, "Invalid Discussion", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.show()
        })
        return view
    }

    private fun setDataHolder() {
        dataHolder = ArrayList()
        //TODO backend se lana prega na obj banane ke liye title n description
        val discussionPanelData = DiscussionPanelData()
        val obj1 = DiscussionPanelData(
            "Demo Discussion Title here ",
            "Idk just testing out things only for demo purposes here"
        )
        dataHolder!!.add(obj1)
        val obj2 =
            DiscussionPanelData(discussionPanelData.title, discussionPanelData.description)
        dataHolder!!.add(obj2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val filePath = data!!.data!!.path
                Log.i("file path - ", filePath!!)
                //TODO
                //obj.setResources(Integer.parseInt(filePath));
                attachmentTvDisPanelFAdm!!.text = filePath
            }
        }
    }
}