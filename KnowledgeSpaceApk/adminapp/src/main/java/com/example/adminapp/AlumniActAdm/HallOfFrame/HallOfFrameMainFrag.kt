package com.example.adminapp.AlumniActAdm.HallOfFrame

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterViewFlipper
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.PreviousYrHoFMainScFrag
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar

class HallOfFrameMainFrag : Fragment() {
    private var dataHolder: ArrayList<DataModelHallOfFrame>? = null
    private var adapterViewFlipper: AdapterViewFlipper? = null
    private var floatingBtnAddHoF: FloatingActionButton? = null
    private var relativeLayContainerImgNNameVPopUpDialogAddHof: RelativeLayout? = null
    private var viewAllAlumniTvHallOfFrameMainActAdm: Button? = null

    //Dialog Box:
    private var totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr: EditText? = null
    private var selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr: TextView? = null
    private var proceedNxtBtnPopupAskAdmAddHofNoOfAlumnisNYrAdm: Button? = null
    private var cancelBtnPopupDialogAddHof: ImageView? = null

    //Dialog Box Add Alumni Details:
    private var tvShowAlumniCountPopupDialogAddHofAdm: TextView? = null
    private var yesBtnTvPopupSavingDataPopupDialog: TextView? = null
    private var NoTvPopupConfirmSavingData: TextView? = null
    private var editTvAlumniNamePopupDialogAddHofAdm: EditText? = null
    private var addNxtAlumniBtnPopupDialogAddHoFAdm: Button? = null
    private var finalAddAlumniBtnPopupDialogAddHof: Button? = null
    private var addAlumniImgVPopupDialogAddHof: ImageView? = null
    private var cancelBtnPopupDialogFinalAddHof: ImageView? = null
    private var currentCountOfAlumniHoF = 1
    private var uri: Uri? = null
    private var linearLayConfirmSavingDataPopupDialogAddHof: LinearLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_hall_of_frame_main, container, false)
        adapterViewFlipper = view.findViewById(R.id.adapterViewFlipper)
        dataHolder = ArrayList()
        addData()
        adapterViewFlipper?.setAdapter(HallofframeadmAdp(dataHolder!!))
        adapterViewFlipper?.setFlipInterval(2600)
        adapterViewFlipper?.setAutoStart(true)
        viewAllAlumniTvHallOfFrameMainActAdm =
            view.findViewById(R.id.viewAllAlumniTvHallOfFrameMainActAdm)
        viewAllAlumniTvHallOfFrameMainActAdm?.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            val activity = view.context as AppCompatActivity
            val frameLayout = activity.findViewById<FrameLayout>(R.id.frameLayHallOfFrameMainSc)
            frameLayout.removeAllViews()
            val fragment: Fragment = PreviousYrHoFMainScFrag()
            val manager = fragmentManager
            val fragmentTransaction = manager!!.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayHallOfFrameMainSc, fragment).commit()
            fragmentTransaction.addToBackStack(R.layout.fragment_hall_of_frame_main.toString())
        })
        floatingBtnAddHoF = view.findViewById(R.id.floatingBtnAddHoF)
        floatingBtnAddHoF?.setOnClickListener(View.OnClickListener { openPopUpAskAdmAddHof() })
        return view
    }

    private fun openPopUpAskAdmAddHof() {
//        scrollViewHoFMainAdm.setVisibility(View.GONE);
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.popup_askadm_addhof_noofalumnis_n_yr)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog.setCancelable(false)
        //  dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.window!!.attributes.windowAnimations = R.style.animation
        totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr =
            dialog.findViewById(R.id.totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr)

        //Todo datapicker me bas year show krna hai + noOfAlumnis me make sure sahi no enter ho see diary 4 more details
        selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr =
            dialog.findViewById(R.id.selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr)
        selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr?.setOnClickListener(View.OnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH]
            val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(
                dialog.context,
                { view, year, month, dayOfMonth ->
                    selectYearTvPopupAskAdmAddHofNoOfAlumnisNYr?.setText(
                        year
                    )
                },
                year,
                month,
                dayOfMonth
            )
            datePickerDialog.datePicker.minDate = System.currentTimeMillis()
            datePickerDialog.show()
        })
        proceedNxtBtnPopupAskAdmAddHofNoOfAlumnisNYrAdm =
            dialog.findViewById(R.id.proceedNxtBtnPopupAskAdmAddHofNoOfAlumnisNYrAdm)
        proceedNxtBtnPopupAskAdmAddHofNoOfAlumnisNYrAdm?.setOnClickListener(View.OnClickListener {
            openPopUpAddHof()
            Log.i(
                "No of alumis ---> ",
                totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr?.getText().toString()
                    .trim { it <= ' ' })
            Toast.makeText(dialog.context, "Saving...without backend", Toast.LENGTH_SHORT).show()
            dialog.setCancelable(true)
            dialog.dismiss()
            //                scrollViewHoFMainAdm.setVisibility(View.VISIBLE);
        })
        cancelBtnPopupDialogAddHof = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
        cancelBtnPopupDialogAddHof?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
            //                scrollViewHoFMainAdm.setVisibility(View.VISIBLE);
        })
        dialog.show()
    }

    private fun openPopUpAddHof() {
        val alumniHoFImgs = ArrayList<Uri>()
        val alumniHoFNames = ArrayList<String>()
        val totalAlumnisToAdd =
            totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr!!.text.toString()
                .trim { it <= ' ' }
                .toInt()
        Log.i("prev dialog inou---> ", totalAlumnisToAdd.toString())
        val setTvFormat = "/"


        //Todo yr v save kr lo jo same hai for all from prev dialog n check for try n catch error while str to int conversion
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.popupdialog_add_hof)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog.setCancelable(false)
        //  dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.window!!.attributes.windowAnimations = R.style.animation
        yesBtnTvPopupSavingDataPopupDialog =
            dialog.findViewById(R.id.yesBtnTvPopupSavingDataPopupDialog)
        NoTvPopupConfirmSavingData = dialog.findViewById(R.id.NoTvPopupConfirmSavingData)
        linearLayConfirmSavingDataPopupDialogAddHof =
            dialog.findViewById(R.id.linearLayConfirmSavingDataPopupDialogAddHof)
        linearLayConfirmSavingDataPopupDialogAddHof?.setVisibility(View.GONE)
        relativeLayContainerImgNNameVPopUpDialogAddHof =
            dialog.findViewById(R.id.relativeLayContainerImgNNameVPopUpDialogAddHof)
        addNxtAlumniBtnPopupDialogAddHoFAdm =
            dialog.findViewById(R.id.addNxtAlumniBtnPopupDialogAddHoFAdm)
        tvShowAlumniCountPopupDialogAddHofAdm =
            dialog.findViewById(R.id.tvShowAlumniCountPopupDialogAddHofAdm)
        tvShowAlumniCountPopupDialogAddHofAdm?.setText(
            StringBuilder().append("1").append(setTvFormat).append(totalAlumnisToAdd).toString()
        )
        finalAddAlumniBtnPopupDialogAddHof =
            dialog.findViewById(R.id.finalAddAlumniBtnPopupDialogAddHof)
        // Log.i("new dialog --->", totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr.getText().toString().trim());
        addAlumniImgVPopupDialogAddHof = dialog.findViewById(R.id.addAlumniImgVPopupDialogAddHof)
        addAlumniImgVPopupDialogAddHof?.setOnClickListener(View.OnClickListener {
            val i = Intent()
            i.setType("image/*")
            i.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(i, "Select Picture"), PICK_IMAGE)
        })
        editTvAlumniNamePopupDialogAddHofAdm =
            dialog.findViewById(R.id.editTvAlumniNamePopupDialogAddHofAdm)
        editTvAlumniNamePopupDialogAddHofAdm?.setOnClickListener(View.OnClickListener { })
        addNxtAlumniBtnPopupDialogAddHoFAdm =
            dialog.findViewById(R.id.addNxtAlumniBtnPopupDialogAddHoFAdm)
        addNxtAlumniBtnPopupDialogAddHoFAdm?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                saveNUpdateDialogData()
            }

            private fun saveNUpdateDialogData() {
                //phle to text n img ka no update hoga n dusra dialog clear ho for new entry n data save rhega local me
                // till the end to send to server
                tvShowAlumniCountPopupDialogAddHofAdm?.setText(
                    StringBuilder().append(
                        currentCountOfAlumniHoF
                    ).append(setTvFormat).append(totalAlumnisToAdd).toString()
                )
                if (currentCountOfAlumniHoF < totalAlumnisToAdd) {
                    currentCountOfAlumniHoF++
                    if (currentCountOfAlumniHoF == totalAlumnisToAdd) {
                        alumniHoFNames.add(
                            editTvAlumniNamePopupDialogAddHofAdm?.getText().toString()
                                .trim { it <= ' ' })
                        alumniHoFImgs.add(Uri.parse(uri!!.path))
                    }
                    alumniHoFNames.add(
                        editTvAlumniNamePopupDialogAddHofAdm?.getText().toString()
                            .trim { it <= ' ' })
                    alumniHoFImgs.add(Uri.parse(uri!!.path))
                } else {
                    //Todo bahar aojao save kro data send kro
                    Log.i(ContentValues.TAG, "else block executed")
                    //                    scrollViewHoFMainAdm.setVisibility(View.GONE);
                    relativeLayContainerImgNNameVPopUpDialogAddHof?.setVisibility(View.GONE)
                    addNxtAlumniBtnPopupDialogAddHoFAdm?.setVisibility(View.GONE)
                    tvShowAlumniCountPopupDialogAddHofAdm?.setVisibility(View.GONE)
                    linearLayConfirmSavingDataPopupDialogAddHof?.setVisibility(View.VISIBLE)
                    //                    finalAddAlumniBtnPopupDialogAddHof.setVisibility(View.VISIBLE);
                    yesBtnTvPopupSavingDataPopupDialog?.setOnClickListener(View.OnClickListener {
                        Toast.makeText(dialog.context, "Yes Clicked", Toast.LENGTH_SHORT).show()
                        dialog.setCancelable(true)
                        dialog.dismiss()
                    })
                    NoTvPopupConfirmSavingData?.setOnClickListener(View.OnClickListener {
                        Toast.makeText(dialog.context, "No", Toast.LENGTH_SHORT).show()
                        dialog.setCancelable(true)
                        dialog.dismiss()
                    })
                    //                        openConfirmSavingDataPopupDialog();
                    //Todo sendDataToServer();
                }
                //Todo check kar lena imgv wala default img save nahi ho raha ho db me
                editTvAlumniNamePopupDialogAddHofAdm?.text?.clear()
                addAlumniImgVPopupDialogAddHof?.setImageResource(R.drawable.ic_baseline_account_circle_24)
            } //            private void openConfirmSavingDataPopupDialog() {
            //                Dialog dialog = new Dialog(getContext());
            //                dialog.setContentView(R.layout.confirm_savingdata_popupdialog);
            //                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            //                dialog.setCancelable(false);
            //                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            //                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
            //
            //
            //                yesBtnTvPopupSavingDataPopupDialog = dialog.findViewById(R.id.yesBtnTvPopupSavingDataPopupDialog);
            //                NoTvPopupConfirmSavingData = dialog.findViewById(R.id.NoTvPopupConfirmSavingData);
            //
            //                //Todo Send Data To Server
            //
            //                yesBtnTvPopupSavingDataPopupDialog.setOnClickListener(new View.OnClickListener() {
            //                    @Override
            //                    public void onClick(View v) {
            //                        Toast.makeText(dialog.getContext(), "Yes Clicked", Toast.LENGTH_SHORT).show();
            //                        dialog.setCancelable(true);dialog.dismiss();
            //
            //                    }
            //                });
            //
            //                NoTvPopupConfirmSavingData.setOnClickListener(new View.OnClickListener() {
            //                    @Override
            //                    public void onClick(View v) {
            //                        Toast.makeText(dialog.getContext(), "No", Toast.LENGTH_SHORT).show();
            //                        dialog.setCancelable(true);dialog.dismiss();
            //                    }
            //                });
            //
            //                dialog.show();
            //            }
        })
        finalAddAlumniBtnPopupDialogAddHof?.setOnClickListener(View.OnClickListener {
            Toast.makeText(dialog.context, "Saving Info...without backend", Toast.LENGTH_SHORT)
                .show()
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        cancelBtnPopupDialogFinalAddHof = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
        cancelBtnPopupDialogFinalAddHof?.setOnClickListener(View.OnClickListener {
            dialog.setCancelable(true)
            dialog.dismiss()
        })
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            uri = data!!.data
            addAlumniImgVPopupDialogAddHof!!.setImageURI(uri)
            Log.i("image path ---> ", uri!!.path!!)
        }
    }

    private fun addData() {
        val card1 = DataModelHallOfFrame(R.drawable.apple, "apple")
        dataHolder!!.add(card1)
        val card2 = DataModelHallOfFrame(R.drawable.banana, "banana")
        dataHolder!!.add(card2)
        dataHolder!!.add(card1)
    }

    companion object {
        private const val PICK_IMAGE = 301
    }
}