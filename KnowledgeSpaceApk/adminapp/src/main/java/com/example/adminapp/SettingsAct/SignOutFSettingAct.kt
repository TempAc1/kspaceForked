package com.example.adminapp.SettingsAct

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adminapp.MainActivity
import com.example.adminapp.R
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.CubeGrid
import com.google.firebase.auth.FirebaseAuth

class SignOutFSettingAct : Fragment() {
    private val auth = FirebaseAuth.getInstance()
    private var progressBar: ProgressBar? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_out_f_setting_act, container, false)
        progressBar = view.findViewById(R.id.progressBarSignOutAct)
        gSignOut().execute()
        return view
    }

    inner class gSignOut : AsyncTask<Void?, Void?, Void?>() {
        override fun onPreExecute() {
            super.onPreExecute()
            progressBar!!.visibility = View.VISIBLE
            val barType: Sprite = CubeGrid()
            progressBar!!.indeterminateDrawable = barType
            Toast.makeText(activity, "Signing Out...", Toast.LENGTH_SHORT).show()
        }

        protected override fun doInBackground(vararg params: Void?): Void? {
            try {
                auth.signOut()
            } catch (e: Exception) {
                Toast.makeText(activity, "Internal Server Error", Toast.LENGTH_SHORT).show()
            }
            return null
        }

        override fun onPostExecute(unused: Void?) {
            super.onPostExecute(unused)
            startActivity(Intent(activity, MainActivity::class.java))
        }
    }
}