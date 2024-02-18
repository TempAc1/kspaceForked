package com.example.adminapp.contactAct

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R
import com.example.adminapp.contactAct.MVCARCHITECTURECONTACTACT.dataModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Locale

class ContactAct : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var dataHolder: ArrayList<dataModel>? = null
    private var searchView: SearchView? = null
    private var itemAdapter: adapterRecV? = null
    private var add_fab: FloatingActionButton? = null
    private var btnCancel: ImageView? = null
    private var imgVCustomDialog: ImageView? = null
    private var saveBtn: Button? = null
    val selectPic = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        searchView = findViewById(R.id.searchVContact)
        recyclerView = findViewById(R.id.recyclerVContacts)
        add_fab = findViewById(R.id.add_fab)
        searchView?.clearFocus()
        recyclerView?.setLayoutManager(LinearLayoutManager(applicationContext))
        //        dataModel = new ArrayList<>();
        getDataHolder()
        itemAdapter = adapterRecV(dataHolder)
        recyclerView?.setAdapter(itemAdapter)
        search()
        addFabOnPress()
    }

    private fun addFabOnPress() {
        add_fab!!.setOnClickListener {
            val dialog = Dialog(this@ContactAct)
            dialog.setContentView(R.layout.custom_dialog_contact_add)
            dialog.window!!
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.attributes.windowAnimations = R.style.animation
            imgVCustomDialog = dialog.findViewById(R.id.imgVCustomDialog)
            imgVCustomDialog?.setOnClickListener(View.OnClickListener {
                val i = Intent()
                i.setType("image/**")
                i.setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(Intent.createChooser(i, "Select Picture"), selectPic)
            })
            btnCancel = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof)
            saveBtn = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm)
            btnCancel?.setOnClickListener(View.OnClickListener {
                dialog.dismiss()
                dialog.setCancelable(true)
            })
            saveBtn?.setOnClickListener(View.OnClickListener {
                dialog.dismiss()
                dialog.setCancelable(true)
                Toast.makeText(this@ContactAct, "Saved Successfully", Toast.LENGTH_SHORT).show()
            })
            dialog.show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == selectPic) {
                if (data != null) {
                    imgVCustomDialog!!.setImageURI(data.data)
                }
            }
        }
    }

    private fun search() {
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(text: String) {
        val filteredList = ArrayList<dataModel>()
        for (item in dataHolder!!) {
            if (item.contactName?.lowercase(Locale.getDefault())?.contains(text.lowercase(Locale.getDefault())) == true
            ) {
                filteredList.add(item)
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found ☹", Toast.LENGTH_SHORT).show()
        } else {
            itemAdapter!!.setFilteredList(filteredList)
        }
    }

    private fun getDataHolder() {
        dataHolder = ArrayList()
        //Add data to array-list "dataHolder"
        val obj1 = dataModel(
            "Mrs.Repma Patel",
            "8985848687", R.drawable.apple
        )
        dataHolder!!.add(obj1)
        val obj2 = dataModel(
            "Mrs.Subtoshi Pandey",
            "9897949596", R.drawable.apple
        )
        dataHolder!!.add(obj2)
        val obj3 = dataModel(
            "Mr.Dablu Kochi",
            "5651545253", R.drawable.apple
        )
        dataHolder!!.add(obj3)
        val obj4 = dataModel(
            "Mr.Girate Patel",
            "4845464241", R.drawable.apple
        )
        dataHolder!!.add(obj4)
        val obj5 = dataModel(
            "Mrs. Joti Japan",
            "2326242521", R.drawable.apple
        )
        dataHolder!!.add(obj5)
        val obj6 = dataModel(
            "Mrs.Yarisma Patel",
            "8985848687", R.drawable.apple
        )
        dataHolder!!.add(obj6)
        val obj7 = dataModel(
            "Mrs.Rinku Hiesenberg",
            "8985848687", R.drawable.apple
        )
        dataHolder!!.add(obj7)
    }
}