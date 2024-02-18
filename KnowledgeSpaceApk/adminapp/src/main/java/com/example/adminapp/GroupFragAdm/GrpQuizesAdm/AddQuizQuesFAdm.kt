package com.example.adminapp.GroupFragAdm.GrpQuizesAdm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.adminapp.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class AddQuizQuesFAdm : Fragment() {
    private var checkBox1AddQuizQuesFAdm: Chip? = null
    private var checkBox2AddQuizQuesFAdm: Chip? = null
    private var checkBox3AddQuizQuesFAdm: Chip? = null
    private var checkBox4AddQuizQuesFAdm: Chip? = null
    private var chip_group_add_quiz_ques: ChipGroup? = null
    private var tag: String? = null
    private var imgBtnSetNextQues: Button? = null
    private var closeFragBtnAddQuizQuesFAdm: Button? = null
    private var questionNoTvAddQuizQuesFAdm: TextView? = null
    private var EnterQuesEditTvAddQuizQuesFAdm: EditText? = null
    private var opt1TvAddQuizQuesFAdm: EditText? = null
    private var opt2TvAddQuizQuesFAdm: EditText? = null
    private var opt3TvAddQuizQuesFAdm: EditText? = null
    private var opt4TvAddQuizQuesFAdm: EditText? = null
    private var correctAnsString = "Not defined"
    private var question = "Not defined"
    private val isChipSelected: Boolean
        private get() {
            checkBox1AddQuizQuesFAdm!!.setOnClickListener {
                tag = "1"
                counterClicked[0] = true
            }
            checkBox2AddQuizQuesFAdm!!.setOnClickListener {
                tag = "2"
                counterClicked[0] = true
            }
            checkBox3AddQuizQuesFAdm!!.setOnClickListener {
                tag = "3"
                counterClicked[0] = true
            }
            checkBox4AddQuizQuesFAdm!!.setOnClickListener {
                tag = "4"
                counterClicked[0] = true
            }
            //        Log.i("counter clickedvalue - ", String.valueOf(counterClicked[0]));
            return counterClicked[0]
        }
    private val counterClicked = BooleanArray(1)
    private var getTotalDuration: String? = null
    private var getTotalQues: String? = null
    private var totalQuesCounter = 0
    private var currentQuesCounter = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_add_quiz_ques_f_adm, container, false)
        EnterQuesEditTvAddQuizQuesFAdm = view.findViewById(R.id.EnterQuesEditTvAddQuizQuesFAdm)
        opt1TvAddQuizQuesFAdm = view.findViewById(R.id.opt1TvAddQuizQuesFAdm)
        opt2TvAddQuizQuesFAdm = view.findViewById(R.id.opt2TvAddQuizQuesFAdm)
        opt3TvAddQuizQuesFAdm = view.findViewById(R.id.opt3TvAddQuizQuesFAdm)
        opt4TvAddQuizQuesFAdm = view.findViewById(R.id.opt4TvAddQuizQuesFAdm)
        chip_group_add_quiz_ques = view.findViewById(R.id.chip_group_add_quiz_ques)
        chip_group_add_quiz_ques?.setSelectionRequired(true)
        checkBox1AddQuizQuesFAdm = view.findViewById(R.id.checkBox1AddQuizQuesFAdm)
        checkBox1AddQuizQuesFAdm?.setClickable(false)
        checkBox2AddQuizQuesFAdm = view.findViewById(R.id.checkBox2AddQuizQuesFAdm)
        checkBox2AddQuizQuesFAdm?.setClickable(false)
        checkBox3AddQuizQuesFAdm = view.findViewById(R.id.checkBox3AddQuizQuesFAdm)
        checkBox3AddQuizQuesFAdm?.setClickable(false)
        checkBox4AddQuizQuesFAdm = view.findViewById(R.id.checkBox4AddQuizQuesFAdm)
        checkBox4AddQuizQuesFAdm?.setClickable(false)
        imgBtnSetNextQues = view.findViewById(R.id.imgBtnSetNextQues)
        closeFragBtnAddQuizQuesFAdm = view.findViewById(R.id.closeFragBtnAddQuizQuesFAdm)
        //        closeFragBtnAddQuizQuesFAdm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
        imgBtnSetNextQues?.setText("Next")
        imgBtnSetNextQues?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                isEditTvValid
                isChipSelected
                setCorrectAnsString()
                Log.i("correct ans - ", correctAnsString)
                Log.i("correct ques - ", question)
                clearEverythingForFreshInputs()
                Log.i("current countef val - ", currentQuesCounter.toString())
                Log.i("total ques val - ", totalQuesCounter.toString())
            }
        })
        questionNoTvAddQuizQuesFAdm = view.findViewById(R.id.questionNoTvAddQuizQuesFAdm)
        setQuesCounter()
        return view
    }

    private fun closeFrag() {
        if (currentQuesCounter == totalQuesCounter) {
            closeFragBtnAddQuizQuesFAdm!!.visibility = View.VISIBLE
            imgBtnSetNextQues!!.visibility = View.GONE
            closeFragBtnAddQuizQuesFAdm!!.setOnClickListener {
                val fragment: Fragment = QuizesMainScAdm()
                val fragmentTransaction = requireFragmentManager().beginTransaction()
                fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit()
                fragmentTransaction.addToBackStack(null)
            }
        }
    }

    private fun updateCurrentQuesCounter() {
        if (currentQuesCounter < totalQuesCounter) {
            currentQuesCounter++
            questionNoTvAddQuizQuesFAdm!!.text =
                StringBuilder().append(currentQuesCounter).append("/").append(getTotalQues)
                    .toString()
        } else {
            closeFrag()
        }
    }

    private fun setQuesCounter() {
        try {
            getTotalDuration = requireArguments()?.getString("duration")
            getTotalQues = requireArguments()?.getString("totalQ")
            totalQuesCounter = getTotalQues!!.toInt()
            questionNoTvAddQuizQuesFAdm!!.text =
                StringBuilder().append(currentQuesCounter).append("/").append(getTotalQues)
                    .toString()
        } catch (e: Exception) {
            Toast.makeText(context, "Invalid Dialog", Toast.LENGTH_SHORT).show()
        }
    }

    /** Make sure edittextv is not empty and given ans is not a blank space
     * chip press hua hai n user ke koi chip ko select kiya hai
     * pressed chip ke according tv ka value hoga correct ans
     * jab dusra chip select kar rhe hai to correct ans ka value should get changed
     * sab kch karne ke bad send btn ko order do dbs me data send karne ka
     */
    private val isEditTvValid: Boolean
        /** Making sure edittv is not empty */
        private get() {
            val counter: Boolean
            if (!EnterQuesEditTvAddQuizQuesFAdm.toString().trim { it <= ' ' }
                    .isEmpty() && EnterQuesEditTvAddQuizQuesFAdm.toString()
                    .trim { it <= ' ' } != " "
                && !opt1TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
                    .isEmpty() && opt1TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' } != " "
                && !opt2TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
                    .isEmpty() && opt2TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' } != " "
                && !opt3TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
                    .isEmpty() && opt3TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' } != " "
                && !opt4TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
                    .isEmpty() && opt4TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' } != " "
            ) {
                //opts are valid
                counter = true
                checkBox1AddQuizQuesFAdm!!.isClickable = true
                checkBox2AddQuizQuesFAdm!!.isClickable = true
                checkBox3AddQuizQuesFAdm!!.isClickable = true
                checkBox4AddQuizQuesFAdm!!.isClickable = true
            } else {
                //iska mtlb kahi par to koi opt invalid hai toast krdo ya dekh lo
                counter = false
            }
            return counter
        }

    private fun setCorrectAnsString(): Boolean {
        if (isChipSelected && isEditTvValid) {
            when (tag) {
                "1" -> correctAnsString = opt1TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
                "2" -> correctAnsString = opt2TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
                "3" -> correctAnsString = opt3TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
                "4" -> correctAnsString = opt4TvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
            }
            question = EnterQuesEditTvAddQuizQuesFAdm!!.text.toString().trim { it <= ' ' }
            updateCurrentQuesCounter()
            return true
        } else {
            Toast.makeText(context, "Invalid Selection", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    //TODO
    private fun sentQuizData(setCorrectAnsStr: Boolean) {
        //Send kar diya ans and now erase everything n give user next place to add next set of ques
        //after sending code ....
        clearEverythingForFreshInputs()
    }

    private fun clearEverythingForFreshInputs() {
        EnterQuesEditTvAddQuizQuesFAdm!!.text.clear()
        opt1TvAddQuizQuesFAdm!!.text.clear()
        opt2TvAddQuizQuesFAdm!!.text.clear()
        opt3TvAddQuizQuesFAdm!!.text.clear()
        opt4TvAddQuizQuesFAdm!!.text.clear()
    }
}