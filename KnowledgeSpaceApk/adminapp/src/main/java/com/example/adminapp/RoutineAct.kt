package com.example.adminapp

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class RoutineAct : AppCompatActivity() {
    private var routineBtn: Button? = null
    private var routineImgV: ImageView? = null
    private val PICKFILE_RESULT_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)
        routineBtn = findViewById(R.id.uploadRoutineBtn)
        routineImgV = findViewById(R.id.routineImgVRoutineAct)
        uploadRoutine()
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICKFILE_RESULT_CODE && data != null && data.data != null) {
            val uri = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                // Log.d(TAG, String.valueOf(bitmap));
                //TODO BACKEND
                routineImgV!!.setImageBitmap(bitmap)
            } catch (e: IOException) {
                Toast.makeText(this, "Internal Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun uploadRoutine() {
        routineBtn!!.setOnClickListener {
            val intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                PICKFILE_RESULT_CODE
            )
        }
    }
}