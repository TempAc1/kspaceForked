package com.example.adminapp.AlumniActAdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adminapp.R

class AlumniActMainScAdm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumni_act_main_sc_adm)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayAlumniActAdm, AlumniFragHomeSc())
        fragmentTransaction.commit()
    }
}