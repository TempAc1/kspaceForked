package com.example.adminapp.HomeworkActAdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeworkActAdm : AppCompatActivity() {
    private val createHwBtn: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_act_adm)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.parentFrameLayoutHomeworkAdm, HomeworkDefaultFragAdm())
        fragmentTransaction.commit()
    }
}