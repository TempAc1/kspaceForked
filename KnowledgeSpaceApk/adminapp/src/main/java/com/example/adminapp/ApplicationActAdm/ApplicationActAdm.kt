package com.example.adminapp.ApplicationActAdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.adminapp.R

class ApplicationActAdm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_act_adm)
        val fragment: Fragment = ApplicationActMainFAdm()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayApplicationActAdm, fragment).commit()
        fragmentTransaction.addToBackStack(null)
    }
}