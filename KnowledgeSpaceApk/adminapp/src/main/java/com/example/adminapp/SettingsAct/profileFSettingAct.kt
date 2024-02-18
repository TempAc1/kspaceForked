package com.example.adminapp.SettingsAct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adminapp.R
import com.google.android.material.button.MaterialButton

class profileFSettingAct : Fragment() {
    private var passTvProfileFSettingAct: TextView? = null
    private var confPassTvProfileFSettingAct: TextView? = null
    private var showPassImgProfileFSettingAct: ImageView? = null
    private var showConfPassImgProfileFSettingAct: ImageView? = null
    private var signOutBtn: MaterialButton? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_profile_f_setting_act, container, false)
        showPassImgProfileFSettingAct =
            view.findViewById(R.id.showPassImgProfileFSettingActAdminApp)
        showConfPassImgProfileFSettingAct =
            view.findViewById(R.id.showConfPassImgProfileFSettingActAdminApp)
        passTvProfileFSettingAct = view.findViewById(R.id.passTvProfileFSettingActAdminApp)
        confPassTvProfileFSettingAct = view.findViewById(R.id.confPassTvProfileFSettingActAdminApp)
        signOutBtn = view.findViewById(R.id.saveMaterialBtnProfileFSettingActAdminApp)
        signOutBtn?.setOnClickListener(View.OnClickListener { view1: View ->
            Toast.makeText(
                view1.context,
                "Saved Successfully",
                Toast.LENGTH_SHORT
            ).show()
        })
        showPass()
        showConfPass()
        return view
    }

    private fun showPass() {
        showPassImgProfileFSettingAct!!.setOnClickListener {
            passTvProfileFSettingAct!!.transformationMethod = null
        }
    }

    private fun showConfPass() {
        showConfPassImgProfileFSettingAct!!.setOnClickListener {
            confPassTvProfileFSettingAct!!.transformationMethod = null
        }
    }
}