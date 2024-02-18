package com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.adminapp.R

class UpdateAlumniDetailsThroughDeleteUpdateAlumniDialogPrevYrHoF : Fragment() {
    private var imgVEditTvNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof: ImageView? =
        null
    private var imgVEditTvDeptNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof: ImageView? =
        null
    private var imgVEditTvSocialLinkEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof: ImageView? =
        null
    private var alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof: ImageView? = null
    private var alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof: EditText? =
        null
    private var alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof: EditText? =
        null
    private var alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof: EditText? =
        null
    private var updateBtnDialogAlumniDetailsPrevyrHoF: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context).inflate(
            R.layout.fragment_update_alumni_details_through_delete_update_alumni_dialog_prev_yr_ho,
            container,
            false
        )
        updateBtnDialogAlumniDetailsPrevyrHoF =
            view.findViewById(R.id.updateBtnDialogAlumniDetailsPrevyrHoF)
        imgVEditTvNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof =
            view.findViewById(
                R.id.imgVEditTvNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof
            )
        alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof =
            view.findViewById(R.id.alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof)
        imgVEditTvNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setOnClickListener(
            View.OnClickListener {
                alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setEnabled(true)
                alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setFocusable(
                    true
                )
                alumniNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setCursorVisible(
                    true
                )
                //Todo
            })
        imgVEditTvDeptNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof =
            view.findViewById(
                R.id.imgVEditTvDeptNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof
            )
        alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof = view.findViewById(
            R.id.alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof
        )
        imgVEditTvDeptNameEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setOnClickListener(
            View.OnClickListener {
                alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setEnabled(
                    true
                )
                alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setFocusable(
                    true
                )
                alumniDeptNameTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setCursorVisible(
                    true
                )
            })
        imgVEditTvSocialLinkEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof =
            view.findViewById(
                R.id.imgVEditTvSocialLinkEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof
            )
        alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof =
            view.findViewById(
                R.id.alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof
            )
        imgVEditTvSocialLinkEditUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setOnClickListener(
            View.OnClickListener {
                alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setEnabled(
                    true
                )
                alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setFocusable(
                    true
                )
                alumniSocialLinkTvUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setCursorVisible(
                    true
                )
            })
        updateBtnDialogAlumniDetailsPrevyrHoF?.setOnClickListener(View.OnClickListener { v ->
            Toast.makeText(view.context, "Closing Without backend", Toast.LENGTH_SHORT).show()
            val activity = v.context as AppCompatActivity
            val fl =
                activity.findViewById<FrameLayout>(R.id.frameLayUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof)
            fl.removeAllViews()
            val fragment: Fragment = PreviousYrHoFMainScFrag()
            val manager = activity.supportFragmentManager
            val fragmentTransaction = manager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayPrevYrHoFMainSc, fragment).commit()
            fragmentTransaction.disallowAddToBackStack()
        })

        //Handle ImgV Intent:
        alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof =
            view.findViewById(R.id.alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof)
        alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof?.setOnClickListener(View.OnClickListener {
            val selectImgIntent = Intent()
            selectImgIntent.setType("image/*")
            selectImgIntent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(
                Intent.createChooser(selectImgIntent, "Select Picture"),
                PICK_IMG_UPDATE_DIALOG_PREVYR
            )
        })
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMG_UPDATE_DIALOG_PREVYR && resultCode == Activity.RESULT_OK) {
            try {
                val uri = data!!.data
                alumniImgVUpdateAlumniDetailsThrDeleteUpdateAlumniDialogPrevYrHof!!.setImageURI(uri)
                Log.i(ContentValues.TAG, uri!!.path!!)
            } catch (e: Exception) {
                Toast.makeText(context, "Could not fetch image", Toast.LENGTH_SHORT).show()
            }
        }
        Log.i(ContentValues.TAG, "hii")
    }

    companion object {
        private const val PICK_IMG_UPDATE_DIALOG_PREVYR = 1
    }
}