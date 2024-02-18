package com.example.adminapp.UsersCommentScAdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UsersCommentScAdm : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: adapterUsersCommentScAdm? = null
    private var dataHolder: ArrayList<dataModelUsersCommentScAdm>? = null
    var auth = FirebaseAuth.getInstance()
    private var uId: String? = null
    private var uEmail: String? = null
    private var currentDate: String? = null
    private var currentTime: String? = null
    private var uName: String? = null
    private var uDp: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_comment_sc_adm)
        uId = auth.uid
        uEmail = auth.currentUser!!.email
        uName = auth.currentUser!!.displayName
        uDp = auth.currentUser!!.providerId
        currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        recyclerView = findViewById(R.id.recyclerVUsersCommentScAdm)
        recyclerView?.setLayoutManager(LinearLayoutManager(applicationContext))
        setDataHolder()
        adapter = adapterUsersCommentScAdm(this, dataHolder, uId, uId)
        recyclerView?.setAdapter(adapter)
    }

    private fun setDataHolder() {
        dataHolder = ArrayList()
        val obj1 = dataModelUsersCommentScAdm(
            uId, "Hello", currentTime, uDp, uEmail, uId, uName
        )
        var i = 1
        while (i < 15) {
            dataHolder!!.add(obj1)
            i++
        }
    }
}