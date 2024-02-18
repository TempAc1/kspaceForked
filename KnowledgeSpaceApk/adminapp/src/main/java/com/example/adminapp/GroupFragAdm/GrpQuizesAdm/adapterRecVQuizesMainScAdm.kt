package com.example.adminapp.GroupFragAdm.GrpQuizesAdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class adapterRecVQuizesMainScAdm(var dataHolder: ArrayList<dataModelRecVQuizesMainScAdm>?) :
    RecyclerView.Adapter<adapterRecVQuizesMainScAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<dataModelRecVQuizesMainScAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_row_des_recv_quizes_mainsc_adm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.quizeTitleSingleRdsQuizesMainScAdm.text =
            dataHolder!![position]. quizeTitleSingleRdsQuizesMainScAdm
        holder.quizeDurationSingleRdsQuizesMainScAdm.text =
            StringBuffer().append("Quiz Duration : ").append(
                dataHolder!![position].quizeDurationSingleRdsQuizesMainScAdm
            )
        holder.totalNoQuestionsSingleRdsQuizesMainScAdm.text =
            StringBuffer().append("Total Questions : ").append(
                dataHolder!![position].totalNoQuestionsSingleRdsQuizesMainScAdm
            )
    }

    override fun getItemCount(): Int {
        return dataHolder!!.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quizeTitleSingleRdsQuizesMainScAdm: TextView
        var quizeDurationSingleRdsQuizesMainScAdm: TextView
        var totalNoQuestionsSingleRdsQuizesMainScAdm: TextView

        init {
            quizeTitleSingleRdsQuizesMainScAdm =
                itemView.findViewById(R.id.quizeTitleSingleRdsQuizesMainScAdm)
            quizeDurationSingleRdsQuizesMainScAdm =
                itemView.findViewById(R.id.quizeDurationSingleRdsQuizesMainScAdm)
            totalNoQuestionsSingleRdsQuizesMainScAdm =
                itemView.findViewById(R.id.totalNoQuestionsSingleRdsQuizesMainScAdm)
        }
    }
}
