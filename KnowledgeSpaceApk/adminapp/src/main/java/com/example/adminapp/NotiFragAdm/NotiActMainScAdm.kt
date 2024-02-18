package com.example.adminapp.NotiFragAdm

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adminapp.R

class NotiActMainScAdm : AppCompatActivity() {
    var notiHeadingTvNotiActMainScAdm: TextView? = null
    var notiDescriptionTvNotiActMainScAdm: TextView? = null
    var deleteNotiBtnNotificationMainScAdm: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noti_act_main_sc_adm)
        notiHeadingTvNotiActMainScAdm = findViewById(R.id.notiHeadingTvNotiActMainScAdm)
        notiDescriptionTvNotiActMainScAdm = findViewById(R.id.notiDescriptionTvNotiActMainScAdm)
        notiDescriptionTvNotiActMainScAdm?.setMovementMethod(ScrollingMovementMethod())
        deleteNotiBtnNotificationMainScAdm = findViewById(R.id.deleteNotiBtnNotificationMainScAdm)
        deleteNotiBtnNotificationMainScAdm?.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                applicationContext, "Deleting without backend", Toast.LENGTH_SHORT
            ).show()
        })
    }
}