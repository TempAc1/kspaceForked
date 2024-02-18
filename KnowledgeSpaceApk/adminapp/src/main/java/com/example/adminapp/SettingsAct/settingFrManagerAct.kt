package com.example.adminapp.SettingsAct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adminapp.R

class settingFrManagerAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_fr_manager)
        val intent = intent
        val viewTag = intent.getStringExtra("view")
        loadFrag(viewTag)
    }

    private fun loadFrag(viewTag: String?) {
        when (viewTag) {
            "profile" -> {
                val fmp = supportFragmentManager
                val ftp = fmp.beginTransaction()
                ftp.add(R.id.frameLSettingAct, profileFSettingAct())
                ftp.commit()
            }

            "signout" -> {
                val fms = supportFragmentManager
                val fts = fms.beginTransaction()
                fts.add(R.id.frameLSettingAct, SignOutFSettingAct())
                fts.commit()
            }

            "tnc" -> {
                val fmtnc = supportFragmentManager
                val fttnc = fmtnc.beginTransaction()
                fttnc.add(R.id.frameLSettingAct, TnCFSettingAct())
                fttnc.commit()
            }
        }
    }
}