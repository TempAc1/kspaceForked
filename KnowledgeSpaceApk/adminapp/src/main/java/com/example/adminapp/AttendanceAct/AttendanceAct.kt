package com.example.adminapp.AttendanceAct

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.RadioButton
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class AttendanceAct : AppCompatActivity() {
    private var recyclerV: RecyclerView? = null
    private var dataHolder: ArrayList<dataModel>? = null
    private var searchView: SearchView? = null
    private var itemAdapter: adapter? = null
    private var timeSpinnerAttendanceAct: TextView? = null
    private var dateSpinnerAttendanceAct: TextView? = null
    private var presentTvAttendanceAct: TextView? = null
    private var absentTvAttendanceAct: TextView? = null
    private var datePickerDialog: DatePickerDialog? = null
    private var Hour = 0
    private var Minute = 0
    private var radioBtnSingleRowAttendanceAct: RadioButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)
//        radioBtnSingleRowAttendanceAct = findViewById(R.id.radioBtnSingleRowAttendanceAct)
        absentTvAttendanceAct = findViewById(R.id.absentTvAttendanceAct)
        presentTvAttendanceAct = findViewById(R.id.presentTvAttendanceAct)
        timeSpinnerAttendanceAct = findViewById(R.id.timeSpinnerAttendanceAct)
        dateSpinnerAttendanceAct = findViewById(R.id.dateSpinnerAttendanceAct)
        dateSpinnerAttendanceAct?.setText(todayDate)
        recyclerV = findViewById(R.id.recyclerVAttendanceAct)
        searchView = findViewById(R.id.searchVAttendanceAct)
        searchView?.clearFocus()
        datePicker()
        timeSpinnerAttendanceAct?.setText(currentTime)
        popTime()
        recyclerV?.setLayoutManager(LinearLayoutManager(applicationContext))
        getDataHolder()
        itemAdapter = adapter(dataHolder)
        recyclerV?.setAdapter(itemAdapter)
        search()
        /**CODE TO GET PRESENT VALUE FROM RECYCLERV INTO ACTIVITY  */
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mMessageReceiver, IntentFilter("message_subject_intent"))
    }

    private fun popTime() {
        timeSpinnerAttendanceAct!!.setOnClickListener {
            timeSpinnerAttendanceAct!!.text = ""
            timePicker()
        }
    }

    private val currentTime: String
        private get() {
            val formatter: DateFormat = SimpleDateFormat("hh:mm a")
            return formatter.format(Date())
        }
    private val todayDate: String
        private get() {
            val cal = Calendar.getInstance()
            val year = cal[Calendar.YEAR]
            var month = cal[Calendar.MONTH]
            month = month + 1
            val day = cal[Calendar.DAY_OF_MONTH]
            return makeDateStr(day, month, year)
        }

    private fun datePicker() {
        val dateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            var month = month
            month = month + 1
            val date = makeDateStr(day, month, year)
            dateSpinnerAttendanceAct!!.text = date
        }
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val day = cal[Calendar.DAY_OF_MONTH]
        val style = AlertDialog.THEME_HOLO_LIGHT
        datePickerDialog = DatePickerDialog(this, style, dateSetListener, year, month, day)
        dateSpinnerAttendanceAct!!.setOnClickListener { datePickerDialog!!.show() }
    }

    private fun makeDateStr(day: Int, month: Int, year: Int): String {
        return getMonthFormat(month) + " " + day + " " + year
    }

    private fun getMonthFormat(month: Int): String {
        when (month) {
            1 -> return "JAN"
            2 -> return "FEB"
            3 -> return "MAR"
            4 -> return "APR"
            5 -> return "MAY"
            6 -> return "JUN"
            7 -> return "JULY"
            8 -> return "AUG"
            9 -> return "SEPT"
            10 -> return "OCT"
            11 -> return "NOV"
            12 -> return "DEC"
        }
        //default jan
        return "JAN"
    }

    private fun timePicker() {
        val onTimeSetListener =
            TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                Hour = selectedHour
                Minute = selectedMinute
                val AM_PM: String
                AM_PM = if (selectedHour < 12) {
                    "AM"
                } else {
                    "PM"
                }
                timeSpinnerAttendanceAct!!.text = "$selectedHour:$Minute $AM_PM"
                //                timeSpinnerAttendanceAct.setText(String.format(Locale.getDefault(),time,Hour,Minute));
            }
        val timePickerDialog = TimePickerDialog(this, onTimeSetListener, Hour, Minute, false)
        timePickerDialog.setTitle("Select Time")
        timePickerDialog.show()
    }

    private fun getDataHolder() {
        dataHolder = ArrayList()
        val obj1 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj1)
        val obj2 = dataModel(R.drawable.apple, "shatani", "1511FB")
        dataHolder!!.add(obj2)
        val obj3 = dataModel(R.drawable.apple, "Reema", "378CB8")
        dataHolder!!.add(obj3)
        val obj4 = dataModel(R.drawable.apple, "yash", "378CB8")
        dataHolder!!.add(obj4)
        val obj5 = dataModel(R.drawable.apple, "itanu", "1664Br")
        dataHolder!!.add(obj5)
        val obj6 = dataModel(R.drawable.apple, "zebra", "8452Cv")
        dataHolder!!.add(obj6)
        val obj7 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj7)
        val obj8 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj8)
        val obj9 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj9)
        val obj10 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj10)
        val obj11 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj11)
        val obj12 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj12)
        val obj13 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj13)
        val obj14 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj14)
        val obj15 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj15)
        val obj16 = dataModel(R.drawable.apple, "Khushal", "378CB8")
        dataHolder!!.add(obj16)
    }

    private fun search() {
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                filterList(s)
                return true
            }
        })
    } //Search end

    private fun filterList(text: String) {
        val filteredList = ArrayList<dataModel>()
        for (item in dataHolder!!) {
            if (item.getpName()!!
                    .lowercase(Locale.getDefault())
                    .contains(text.lowercase(Locale.getDefault())) || item.getpRollNo()!!
                    .lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))
            ) {
                filteredList.add(item)
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found ☹️", Toast.LENGTH_SHORT).show()
            searchView!!.clearFocus()
        } else {
            itemAdapter!!.setFilteredList(filteredList)
        }
    }

    /**CODE TO GET PRESENT VALUE FROM RECYCLERV INTO ACTIVITY  */
    var mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val presentCount = intent.getStringExtra("presentCount")
            presentTvAttendanceAct!!.text = "Present : $presentCount"
        }
    }
} //Main end
