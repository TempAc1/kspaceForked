package com.example.adminapp.FeesActAdm

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.adminapp.R

class FeesActMainScAdm : AppCompatActivity() {
    private var frameLayFeesActMainScAdm: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fees_act_main_sc_adm)
        frameLayFeesActMainScAdm = findViewById(R.id.frameLayFeesActMainScAdm)
        val fragment: Fragment = DefaultFragFeesActAdm()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayFeesActMainScAdm, fragment).commit()
        fragmentTransaction.addToBackStack(null)
    }
}