package com.example.adminapp.UsersCommentScAdm

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.example.adminapp.UsersCommentScAdm.adapterUsersCommentScAdm.MyHolder
import java.util.Calendar
import java.util.Locale

class adapterUsersCommentScAdm(
    var context: Context,
    var arrayList: ArrayList<dataModelUsersCommentScAdm>?,
    var myuid: String?,
    var postid: String?
) : RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.users_comment_scadm, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val uid = arrayList!![position].uid
        val name = arrayList!![position].uname
        val email = arrayList!![position].uemail
        val image = arrayList!![position].udp
        val cid = arrayList!![position].comment
        val comment = arrayList!![position].comment
        val timestamp = arrayList!![position].ptime
        val calendar = Calendar.getInstance(Locale.ENGLISH)
        //        calendar.setTimeInMillis(Long.parseLong(timestamp));
        val timedate = DateFormat.format("dd/MM/yyyy hh:mm aa", calendar).toString()
        holder.name.text = name
        holder.time.text = timedate
        holder.comment.text = comment
        //        try {
//            Glide.with(context).load(image).into(holder.imagea);
//        } catch (Exception e) {
//
//        }
    }

    override fun getItemCount(): Int {
        return arrayList!!.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagea: ImageView
        var name: TextView
        var comment: TextView
        var time: TextView

        init {
            imagea = itemView.findViewById(R.id.loadcomment)
            name = itemView.findViewById(R.id.commentname)
            comment = itemView.findViewById(R.id.commenttext)
            time = itemView.findViewById(R.id.commenttime)
        }
    }
}
