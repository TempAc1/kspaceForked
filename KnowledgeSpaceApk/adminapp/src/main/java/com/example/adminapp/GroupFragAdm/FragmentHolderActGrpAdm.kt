package com.example.adminapp.GroupFragAdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.adminapp.R

class FragmentHolderActGrpAdm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_holder_act_grp_adm)
        //default fragment hold
        replaceFrag(GroupOverviewFragGrpAdm())
    }

    fun replaceFrag(fragment: Fragment?) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment!!)
        fragmentTransaction.commit()
    }
}