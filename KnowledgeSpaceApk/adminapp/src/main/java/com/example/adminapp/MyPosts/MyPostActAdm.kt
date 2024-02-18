package com.example.adminapp.MyPosts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adminapp.databinding.ActivityMyPostActAdmBinding

class MyPostActAdm : AppCompatActivity() {
    private var binding: ActivityMyPostActAdmBinding? = null
    private var adapter: adapterMyPostsAdm? = null
    private var dataHolder: ArrayList<dataModelRecVMyPostsAdm>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPostActAdmBinding.inflate(
            layoutInflater
        )
        val view: View = binding!!.root
        setContentView(view)
        binding!!.recyclerVMyPostActAdm.layoutManager = LinearLayoutManager(applicationContext)
        data
        adapter = adapterMyPostsAdm(dataHolder)
        binding!!.recyclerVMyPostActAdm.adapter = adapter
    }

    private val data: Unit
        private get() {
            dataHolder = ArrayList()
            //Add data
            val obj1 = dataModelRecVMyPostsAdm(
                "Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp"
            )
            dataHolder!!.add(obj1)
            val obj2 = dataModelRecVMyPostsAdm(
                "Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp"
            )
            dataHolder!!.add(obj2)
            val obj3 = dataModelRecVMyPostsAdm(
                "Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp"
            )
            dataHolder!!.add(obj3)
            val obj4 = dataModelRecVMyPostsAdm(
                "Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp joaijspdjpwajdpw pjpwadmpmwpwmpo pjsapdjpwmpwajwm pojdpampwmp"
            )
            dataHolder!!.add(obj4)
            val obj5 = dataModelRecVMyPostsAdm(
                "Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp"
            )
            dataHolder!!.add(obj5)
            val obj6 = dataModelRecVMyPostsAdm(
                "Demo Text Here With A Title Demoooooooooooo",
                "Demo desakpasdmpsampdmpll kwdmakmwpam ejjpjfs fkae pojpwmpd apo pmdp wm " +
                        "knpiwpadmpowadpm owapdmpwmadpj odwamwmdwapdw omadpkdwmdp"
            )
            dataHolder!!.add(obj6)
            dataHolder!!.add(obj5)
            dataHolder!!.add(obj5)
            dataHolder!!.add(obj5)
            dataHolder!!.add(obj5)
            dataHolder!!.add(obj5)
        }
}