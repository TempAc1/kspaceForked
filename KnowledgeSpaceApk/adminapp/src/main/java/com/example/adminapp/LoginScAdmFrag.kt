package com.example.adminapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.CubeGrid
import com.google.firebase.auth.FirebaseAuth
import java.util.Objects

class LoginScAdmFrag : Fragment() {
    var emailTvLoginScAdm: EditText? = null
    var passTvLoginScAdm: EditText? = null
    var loginBtnLogicScAdm: Button? = null
    private val mAuth = FirebaseAuth.getInstance()
    private var email: String? = null
    private var pass: String? = null
    var progressBar: ProgressBar? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login_sc_adm, container, false)
        loginBtnLogicScAdm = view.findViewById(R.id.loginBtnLogicScAdm)
        emailTvLoginScAdm = view.findViewById(R.id.emailTvLoginScAdm)
        passTvLoginScAdm = view.findViewById(R.id.passTvLoginScAdm)
        progressBar = view.findViewById(R.id.loadingSpinnerLoginScAdmFrag)
        loginBtnLogicScAdm?.setOnClickListener(View.OnClickListener {
            progressBar?.setVisibility(View.GONE)
            getProgressBar()
            gAuth()
        })
        return view
    }

    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            startActivity(Intent(activity, HomeScAdm::class.java))
        } else {
            gAuth()
        }
    }

    private fun gAuth() {
        if (emailTvLoginScAdm!!.text != null && passTvLoginScAdm!!.text != null) {
            email = emailTvLoginScAdm!!.text.toString().trim { it <= ' ' }
            pass = passTvLoginScAdm!!.text.toString().trim { it <= ' ' }
            if (!email!!.matches("".toRegex()) && !pass!!.matches("".toRegex())) {
                mAuth.signInWithEmailAndPassword(email!!, pass!!)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {

                            //Testing
                            val toast = Objects.requireNonNull(mAuth.currentUser)?.email
                            Toast.makeText(activity, toast, Toast.LENGTH_SHORT).show()
                            Toast.makeText(activity, "welcome", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(activity, HomeScAdm::class.java))
                        } else {
                            progressBar!!.visibility = View.GONE
                            Toast.makeText(activity, "Login Failure", Toast.LENGTH_SHORT).show()
                            Log.i("Else part", task.exception!!.message!!)
                            Log.i("Else part", pass!!)
                        }
                    }
            } else {
                val customErrorDrawable = resources.getDrawable(R.drawable.ic_baseline_error_24)
                customErrorDrawable.setBounds(
                    0, 0, customErrorDrawable.intrinsicWidth,
                    customErrorDrawable.intrinsicHeight
                )
                emailTvLoginScAdm!!.error = "Field cannot be empty"
                passTvLoginScAdm!!.error = "Field cannot be empty"
            }
        } else {
            Toast.makeText(activity, "Field cannot be left empty", Toast.LENGTH_SHORT).show()
        }
    } //End googleAuth

    private fun getProgressBar() {
        progressBar!!.visibility = View.VISIBLE
        val barType: Sprite = CubeGrid()
        progressBar!!.indeterminateDrawable = barType
    }
}