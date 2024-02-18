package com.example.adminapp.GroupFragAdm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.adminapp.GroupFragAdm.DiscussionPanelFragAdm.DiscussionPanelMainScFAdm
import com.example.adminapp.GroupFragAdm.GrpQuizesAdm.QuizData
import com.example.adminapp.GroupFragAdm.GrpQuizesAdm.QuizesMainScAdm
import com.example.adminapp.R

class GroupOverviewFragGrpAdm : Fragment() {
    private var grpTitleCardVDetailsGrpOverviewAdm: TextView? = null
    private var grpShortDescCardVDetailsGrpOverviewAdm: TextView? = null
    private var grpAdminNameCardVDetailsGrpOverviewAdm: TextView? = null
    private var grpOption1GrpOverviewFrag: TextView? = null
    private var grpOption2GrpOverviewFrag: TextView? = null
    private var grpOption3GrpOverviewFrag: TextView? = null
    private var grpOption4GrpOverviewFrag: TextView? = null
    private val cancelBtnCusDiaQuiz: ImageView? = null
    private val proceedBtnCusDiaQuiz: Button? = null
    private val setTotalQusCusDiaQuiz: EditText? = null
    private val setDurationCusDiaQuiz: TextView? = null
    private val quizData = QuizData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_group_overview_frag_grp_adm, container, false)
        grpTitleCardVDetailsGrpOverviewAdm =
            view.findViewById(R.id.grpTitleCardVDetailsGrpOverviewAdm)
        grpShortDescCardVDetailsGrpOverviewAdm =
            view.findViewById(R.id.grpShortDescCardVDetailsGrpOverviewAdm)
        grpAdminNameCardVDetailsGrpOverviewAdm =
            view.findViewById(R.id.grpAdminNameCardVDetailsGrpOverviewAdm)
        grpOption1GrpOverviewFrag = view.findViewById(R.id.grpOption1GrpOverviewFrag)
        grpOption2GrpOverviewFrag = view.findViewById(R.id.grpOption2GrpOverviewFrag)
        grpOption3GrpOverviewFrag = view.findViewById(R.id.grpOption3GrpOverviewFrag)
        grpOption4GrpOverviewFrag = view.findViewById(R.id.grpOption4GrpOverviewFrag)
        // openSpecificFrag(R.id.grpAdminNameCardVDetailsGrpOverviewAdm);
        grpOption1GrpOverviewFrag?.setOnClickListener(View.OnClickListener { view ->
            val activity = view.context as AppCompatActivity
            val fl = activity.findViewById<FrameLayout>(R.id.frameLayGrpOverview)
            fl.removeAllViews()
            val fragment: Fragment = CourseSelectedFAdm()
            val manager = activity.supportFragmentManager
            val fragmentTransaction = manager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit()
            fragmentTransaction.addToBackStack(R.layout.fragment_group_overview_frag_grp_adm.toString())
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        })
        grpOption2GrpOverviewFrag?.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                context,
                "Clicked 2",
                Toast.LENGTH_SHORT
            ).show()
        })
        grpOption3GrpOverviewFrag?.setOnClickListener(View.OnClickListener {
            val fragment: Fragment = QuizesMainScAdm()
            val fragmentTransaction = requireFragmentManager().beginTransaction()
            fragmentTransaction.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit()
            fragmentTransaction.addToBackStack(null)
        })
        grpOption4GrpOverviewFrag?.setOnClickListener(View.OnClickListener {
            val fragment: Fragment = DiscussionPanelMainScFAdm()
            val ft = requireFragmentManager().beginTransaction()
            ft.replace(R.id.frameLayFragHolderActGrpAdm, fragment).commit()
            ft.addToBackStack(null)
            Toast.makeText(context, "Clicked 4", Toast.LENGTH_SHORT).show()
        })
        return view
    }

    private fun openSpecificFrag(id: Int) {
        when (id) {
            R.id.grpOption1GrpOverviewFrag -> Toast.makeText(
                context, "opt1 clicked", Toast.LENGTH_SHORT
            ).show()

            R.id.grpOption2GrpOverviewFrag -> Toast.makeText(
                context, "opt2 clicked", Toast.LENGTH_SHORT
            ).show()

            R.id.grpOption3GrpOverviewFrag -> Toast.makeText(
                context, "opt3 clicked", Toast.LENGTH_SHORT
            ).show()

            R.id.grpOption4GrpOverviewFrag -> Toast.makeText(
                context, "opt4 clicked", Toast.LENGTH_SHORT
            ).show()
        }
    }
}