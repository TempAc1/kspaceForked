package com.example.adminapp.SettingsAct

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.adminapp.databinding.ActivitySettingBinding

class settingAct : AppCompatActivity() {
    private var binding: ActivitySettingBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        actClicked()
    }

    private fun actClicked() {
        binding!!.profileSettingTvSettingsAct.setOnClickListener { view ->
            val i = Intent(applicationContext, settingFrManagerAct::class.java)
            i.putExtra("view", getTag(view))
            //                Log.i("Id ====== ",getTag(view));
            startActivity(i)
        }
        binding!!.tNcTvSettingsAct.setOnClickListener { view ->
            val i = Intent(applicationContext, settingFrManagerAct::class.java)
            i.putExtra("view", getTag(view))
            //                Log.i("Id ====== ",getTag(view));
            startActivity(i)
        }
        binding!!.signOutTvSettingsAct.setOnClickListener { view ->
            val i = Intent(applicationContext, settingFrManagerAct::class.java)
            i.putExtra("view", getTag(view))
            //                Log.i("Id ====== ",getTag(view));
            startActivity(i)
        }
    }

    private fun getTag(view: View): String {
        return view.tag as String
    }
}