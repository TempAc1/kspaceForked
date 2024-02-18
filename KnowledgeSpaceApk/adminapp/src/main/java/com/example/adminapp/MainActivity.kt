package com.example.adminapp

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.CubeGrid

class MainActivity : AppCompatActivity() {
    var imgviewMainactAdm: ImageView? = null
    var tVMainAct2Adm: TextView? = null
    var textViewMainActAdm: TextView? = null
    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgviewMainactAdm = findViewById(R.id.imgviewMainactAdm)
        tVMainAct2Adm = findViewById(R.id.tVMainAct2Adm)
        textViewMainActAdm = findViewById(R.id.textViewMainActAdm)
        progressBar = findViewById<View>(R.id.spin_kit) as ProgressBar
        showLoadingSpinner()
        Handler().postDelayed({
            hideAll()
            supportFragmentManager.beginTransaction()
                .add(R.id.containerFragMainActAdm, LoginScAdmFrag()).commitAllowingStateLoss()
            //               progressBar.setVisibility(View.GONE);
        }, 2000)
    }

    private fun hideAll() {
        imgviewMainactAdm!!.visibility = View.GONE
        textViewMainActAdm!!.visibility = View.GONE
        tVMainAct2Adm!!.visibility = View.GONE
        progressBar!!.visibility = View.GONE
    }

    private fun showLoadingSpinner() {
        val cubeGrid: Sprite = CubeGrid()
        progressBar!!.indeterminateDrawable = cubeGrid
        progressBar!!.visibility = View.VISIBLE
    }
}