package com.example.adminapp.HomeFragAdm

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.HomeScAdm
import com.example.adminapp.R
import com.example.adminapp.UsersCommentScAdm.UsersCommentScAdm
import java.util.Locale

internal class adapterRecVHomeFragAdm(var dataHolder: ArrayList<dataModelRecVHomeFragAdm>) :
    RecyclerView.Adapter<adapterRecVHomeFragAdm.myviewholder>(), Filterable {
    var dataHolderBackup: ArrayList<dataModelRecVHomeFragAdm> = ArrayList(dataHolder)
    var homeScAdm = HomeScAdm()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_row_design_recv_homef_adm, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.img.setImageResource(dataHolder[position].image)
        holder.likeImg.setImageResource(dataHolder[position].likeImg)
        holder.commentImg.setImageResource(dataHolder[position].commentImg)
        holder.title.text = dataHolder[position].title
        holder.desc.text = dataHolder[position].description
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }

    override fun getFilter(): Filter {
        return myFilter
    }

    var myFilter: Filter = object : Filter() {
        override fun performFiltering(keyword: CharSequence): FilterResults {

            //tempo array list for filtered data
            val filteredData = ArrayList<dataModelRecVHomeFragAdm>()
            if (keyword.toString().isEmpty()) filteredData.addAll(dataHolderBackup) else {
                for (obj in dataHolderBackup) {
                    if (obj.title.toString().lowercase(Locale.getDefault()).trim { it <= ' ' }
                            .contains(keyword
                                .toString().lowercase(Locale.getDefault()).trim { it <= ' ' }) ||
                        obj.description.toString().lowercase(Locale.getDefault())
                            .trim { it <= ' ' }
                            .contains(keyword
                                .toString().lowercase(Locale.getDefault()).trim { it <= ' ' })
                    ) filteredData.add(obj)
                }
            }
            val results = FilterResults()
            results.values = filteredData
            return results
        }

        //Main thread ui
        override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
            dataHolder.clear()
            dataHolder.addAll((filterResults.values as ArrayList<dataModelRecVHomeFragAdm>))
            notifyDataSetChanged()
        }
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var likeImg: ImageView
        var commentImg: ImageView
        var title: TextView
        var desc: TextView
        var context: Context

        init {
            context = itemView.context
            img = itemView.findViewById(R.id.imageVSingleRowDesRecHomeFAdm)
            likeImg = itemView.findViewById(R.id.likeBtnHomeFragAdm)
            commentImg = itemView.findViewById(R.id.commentBtnHomeFragAdm)
            title = itemView.findViewById(R.id.titleTxtVSingleRDesRecHomeFAdm)
            desc = itemView.findViewById(R.id.descriptionTxtVSingleRDesRecHomeFAdm)
            likeImg.setOnClickListener {
                updateUPoints()
                Toast.makeText(itemView.context, "Liked", Toast.LENGTH_SHORT).show()
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //Apply transaction
                commentImg.setOnClickListener {
                    val intent: Intent
                    updateUPoints()
                    val uPoints = homeScAdm.uPoints
                    intent = Intent(context, UsersCommentScAdm::class.java)
                    context.startActivity(intent)
                    Toast.makeText(itemView.context, uPoints.toString(), Toast.LENGTH_SHORT).show()
                }
            } else {
                val intent: Intent
                //Don't apply transaction
                intent = Intent(context, UsersCommentScAdm::class.java)
                context.startActivity(intent)
                Toast.makeText(itemView.context, "Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateUPoints() {
        homeScAdm.setuPoints(
            homeScAdm.uPoints + 1
        )
    }
} //End Main
