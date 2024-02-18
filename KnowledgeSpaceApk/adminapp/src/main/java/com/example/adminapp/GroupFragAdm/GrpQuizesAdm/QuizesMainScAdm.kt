package com.example.adminapp.GroupFragAdm.GrpQuizesAdm

import android.app.Dialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Calendar

class QuizesMainScAdm : Fragment() {
    private var parentRecVQuizesFragMainScAdm: RecyclerView? = null
    private val adapter: adapterRecVQuizesMainScAdm? = null
    private var dataHolder: ArrayList<dataModelRecVQuizesMainScAdm>? = null
    private var floatingActionBtnQuizeMainScAdm: FloatingActionButton? = null
    private var cancelBtnCusDiaQuiz: ImageView? = null
    private var proceedBtnCusDiaQuiz: Button? = null
    private var setTotalQusCusDiaQuiz: EditText? = null
    private var setDurationCusDiaQuiz: TextView? = null
    private val quizData = QuizData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_quizes_main_sc_adm, container, false)
        floatingActionBtnQuizeMainScAdm = view.findViewById(R.id.floatingActionBtnQuizeMainScAdm)
        parentRecVQuizesFragMainScAdm = view.findViewById(R.id.parentRecVQuizesFragMainScAdm)
        parentRecVQuizesFragMainScAdm?.setLayoutManager(LinearLayoutManager(context))
        addObjToHolder()
        parentRecVQuizesFragMainScAdm?.setAdapter(adapterRecVQuizesMainScAdm(dataHolder))
        floatingActionBtnQuizeMainScAdm?.setOnClickListener(View.OnClickListener { openDialogBox() })

        //TODO
//        view.setFocusableInTouchMode(true);
//        view.requestFocus();
//        view.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//
//
//                return false;
//            }
//        });
        return view
    }

    private fun openDialogBox() {
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.custom_dialog_addquiz)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.animation
        setTotalQusCusDiaQuiz = dialog.findViewById(R.id.setTotalQuesCusDiaQuiz)
        setDurationCusDiaQuiz = dialog.findViewById(R.id.setDurationCusDiaQuiz)
        setDurationCusDiaQuiz?.setOnClickListener(View.OnClickListener {
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
            val minute = mcurrentTime[Calendar.MINUTE]
            val mTimePicker: TimePickerDialog
            mTimePicker = TimePickerDialog(
                setDurationCusDiaQuiz?.getContext(),
                { timePicker, selectedHour, selectedMinute -> setDurationCusDiaQuiz?.setText("$selectedHour:$selectedMinute") },
                hour,
                minute,
                true
            ) //Yes 24 hour time
            mTimePicker.setTitle("Select Time")
            mTimePicker.show()
        })
        cancelBtnCusDiaQuiz = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
        cancelBtnCusDiaQuiz?.setOnClickListener(View.OnClickListener {
            dialog.dismiss()
            dialog.setCancelable(true)
        })
        proceedBtnCusDiaQuiz = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm)
        proceedBtnCusDiaQuiz?.setOnClickListener(View.OnClickListener {
//            try {
//                quizData.quizTime(setDurationCusDiaQuiz?.getText().toString())
//                quizData.getQuizTime()?.let { it1 -> Log.i("Duration ", it1) }
//            } catch (e: NumberFormatException) {
//                Toast.makeText(context, "Invalid Time Format", Toast.LENGTH_SHORT).show()
//            }
//            try {
//                quizData.setQuizTotalQues(setTotalQusCusDiaQuiz?.getText().toString())
//                quizData.getQuizTotalQues()?.let { it1 -> Log.i("Ques : ", it1) }
//            } catch (e: NumberFormatException) {
//                Toast.makeText(context, "Invalid ques", Toast.LENGTH_SHORT).show()
//            }
            dialog.setCancelable(true)
            dialog.dismiss()
            val bundle = Bundle()
            bundle.putString("duration", quizData.quizTime)
            bundle.putString("totalQ", quizData.quizTotalQues)
            val fragment: Fragment = AddQuizQuesFAdm()
            fragment.arguments = bundle
            val fl = dialog.findViewById<FrameLayout>(R.id.frameLayGrpOverview)
            val fragmentTransaction = requireFragmentManager().beginTransaction()
            fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit()
            fragmentTransaction.addToBackStack(null)
        })
        dialog.show()
    }

    private fun addObjToHolder() {
        dataHolder = ArrayList()
        val obj = QuizData()
        val time = obj.quizTime
        val ques = obj.quizTotalQues
        val obj1 = dataModelRecVQuizesMainScAdm("IOT", ques, time)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
        dataHolder!!.add(obj1)
    }


}