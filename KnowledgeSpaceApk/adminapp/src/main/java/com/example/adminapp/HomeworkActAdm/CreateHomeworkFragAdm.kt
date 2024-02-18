package com.example.adminapp.HomeworkActAdm

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adminapp.R
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class CreateHomeworkFragAdm : Fragment() {
    val myCal = Calendar.getInstance()
    private var startDateTVCreateHomeworkFragAdm: TextView? = null
    private var endDateTVCreateHomeworkFragAdm: TextView? = null
    private var startTimeTVCreateHomeworkFragAdm: TextView? = null
    private var endTimeTVCreateHomeworkFragAdm: TextView? = null
    private var attachmentTvCreateHomeworkFragAdm: TextView? = null
    private var uStartTime: String? = null
    private var uEndTime: String? = null
    private var uEndDate: String? = null
    private var uStartDate: String? = null
    private var Hour = 0
    private var Minute = 0
    private var endDateObj: Date? = null
    private var startDateObj: Date? = null
    private var postHomeWoreBtnCreateHomeworkFragAdm: Button? = null
    private var startDateTvClicked = false
    private var endDateTvClicked = false
    private var startTimeTvClicked = false
    private var endTimeTvClicked = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context).inflate(
            R.layout.fragment_create_homework_frag_adm, container, false
        )
        startDateTVCreateHomeworkFragAdm = view.findViewById(R.id.startDateTVCreateHomeworkFragAdm)
        endDateTVCreateHomeworkFragAdm = view.findViewById(R.id.endDateTVCreateHomeworkFragAdm)
        postHomeWoreBtnCreateHomeworkFragAdm =
            view.findViewById(R.id.postHomeWoreBtnCreateHomeworkFragAdm)
        startTimeTVCreateHomeworkFragAdm = view.findViewById(R.id.startTimeTVCreateHomeworkFragAdm)
        endTimeTVCreateHomeworkFragAdm = view.findViewById(R.id.endTimeTVCreateHomeworkFragAdm)
        startTimeTVCreateHomeworkFragAdm = view.findViewById(R.id.startTimeTVCreateHomeworkFragAdm)
        endTimeTVCreateHomeworkFragAdm = view.findViewById(R.id.endTimeTVCreateHomeworkFragAdm)
        val startDate = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            myCal[Calendar.YEAR] = year
            myCal[Calendar.MONTH] = month
            myCal[Calendar.DAY_OF_MONTH] = day
            startDateUpdateLabel()
        }
        val endDate = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            myCal[Calendar.YEAR] = year
            myCal[Calendar.MONTH] = month
            myCal[Calendar.DAY_OF_MONTH] = day
            endDateUpdateLabel()
        }
        startDateTVCreateHomeworkFragAdm?.setOnClickListener(View.OnClickListener { view ->
            startDateTvClicked = true
//            MaterialStyledDatePickerDialog(
//                view.context, startDate,
//                myCal[Calendar.YEAR], myCal[Calendar.MONTH], myCal[Calendar.DAY_OF_MONTH]
//            ).show()

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // Date Picker Dialog
            val datePickerDialog = DatePickerDialog(view.context,
                { view, year, monthOfYear, dayOfMonth ->
                    // This is where you handle the date the user has selected
                    val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                    // Example: Show the selected date
//                    Toast.makeText(view, "Selected Date: $selectedDate", Toast.LENGTH_LONG).show()
                }, year, month, day)
            datePickerDialog.show()

        })
        endDateTVCreateHomeworkFragAdm?.setOnClickListener(View.OnClickListener { view ->
            endDateTvClicked = true
//            MaterialStyledDatePickerDialog(
//                view.context, endDate,
//                myCal[Calendar.YEAR], myCal[Calendar.MONTH], myCal[Calendar.DAY_OF_MONTH]
//            ).show()

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // Date Picker Dialog
            val datePickerDialog = DatePickerDialog(view.context,
                { view, year, monthOfYear, dayOfMonth ->
                    // This is where you handle the date the user has selected
                    val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                    // Example: Show the selected date
//                    Toast.makeText(view, "Selected Date: $selectedDate", Toast.LENGTH_LONG).show()
                }, year, month, day)
            datePickerDialog.show()

        })
        startTimeTVCreateHomeworkFragAdm?.setOnClickListener(View.OnClickListener {
            startTimeTvClicked = true
            val onTimeSetListener =
                TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                    val AM_PM: String
                    Hour = selectedHour
                    Minute = selectedMinute
                    AM_PM = if (selectedHour < 12) {
                        "AM"
                    } else {
                        "PM"
                    }
                    startTimeTVCreateHomeworkFragAdm?.setText("$selectedHour:$selectedMinute $AM_PM")
                    uStartTime = startTimeTVCreateHomeworkFragAdm?.getText().toString()
                }
            val timePickerDialog = TimePickerDialog(context, onTimeSetListener, Hour, Minute, false)
            timePickerDialog.setTitle("Select Time")
            timePickerDialog.show()
        })
        endTimeTVCreateHomeworkFragAdm?.setOnClickListener(View.OnClickListener {
            endTimeTvClicked = true
            val onTimeSetListener =
                TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                    val AM_PM: String
                    Hour = selectedHour
                    Minute = selectedMinute
                    AM_PM = if (selectedHour < 12) {
                        "AM"
                    } else {
                        "PM"
                    }
                    endTimeTVCreateHomeworkFragAdm?.setText("$selectedHour:$selectedMinute $AM_PM")
                    uEndTime = endTimeTVCreateHomeworkFragAdm?.getText().toString()
                }
            val timePickerDialog = TimePickerDialog(context, onTimeSetListener, Hour, Minute, false)
            timePickerDialog.setTitle("Select Time")
            timePickerDialog.show()
        })
        attachmentTvCreateHomeworkFragAdm =
            view.findViewById(R.id.attachmentTvCreateHomeworkFragAdm)
        attachmentTvCreateHomeworkFragAdm?.setOnClickListener(View.OnClickListener {
            val PICKFILE_RESULT_CODE = 1
            val acessFilesIntent = Intent(Intent.ACTION_GET_CONTENT)
            acessFilesIntent.setType("*/*")
            startActivityForResult(acessFilesIntent, PICKFILE_RESULT_CODE)
        })
        postHomeWoreBtnCreateHomeworkFragAdm?.setOnClickListener(View.OnClickListener { postButtonClicked() })
        return view
    } //End OnCreate:

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val filePath = data!!.data!!.path
                attachmentTvCreateHomeworkFragAdm!!.text = filePath
            }
        }
    }

    private fun endDateUpdateLabel() {
        val myFormat = "dd/MM/yy"
        val endDateFormat = SimpleDateFormat(myFormat, Locale.US)
        uEndDate = endDateFormat.format(myCal.time)
        endDateTVCreateHomeworkFragAdm!!.text = uEndDate
        try {
            endDateObj = SimpleDateFormat("dd/MM/yyyy").parse(uEndDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }

    private fun startDateUpdateLabel() {
        val myFormat = "dd/MM/yy"
        val startDateFormat = SimpleDateFormat(myFormat)
        uStartDate = startDateFormat.format(myCal.time)
        startDateTVCreateHomeworkFragAdm!!.text = uStartDate
        try {
            startDateObj = SimpleDateFormat("dd/MM/yyyy").parse(uStartDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
    }

    /*use compareTo() for dates compare */
    private fun postButtonClicked() {
        //TODO : sendDataTOApi() & Toast sahi krna hai
        validateNverify()
    }

    private fun validateNverify() {
        //check click hua h date n time par
        if (startDateTvClicked && endDateTvClicked && startTimeTvClicked && endTimeTvClicked) {
            //tv are clicked atleast
            if (uStartDate == uEndDate && uStartTime == uEndTime) {
                //start n end date same dala hai n time diff h
                Toast.makeText(
                    context,
                    "Since Dates r equal Time cannot be same",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (uStartDate == uEndDate && uStartTime != uEndTime) {
                Toast.makeText(context, "2nd executed", Toast.LENGTH_SHORT).show()
            } else if (startDateObj!!.compareTo(endDateObj) < 0) {
                //agar start date chota h end se to time se kya hi mtlb
                Toast.makeText(
                    context,
                    "start date less than end ok ideal case",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (startDateObj!!.compareTo(endDateObj) > 0) {
                //mtlb start date bara h end se OR YEH ALLOW NAHI HAI
                Toast.makeText(context, "start great then last no valid", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Last else part executed", Toast.LENGTH_SHORT).show()
        }
    }
}