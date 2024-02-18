package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.R

class AdapterAlumniSearchResultFAdm(var dataHolder: ArrayList<DataModelAlumniSearchResultFAdm>) :
    RecyclerView.Adapter<AdapterAlumniSearchResultFAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<DataModelAlumniSearchResultFAdm>

    init {
        dataHolderBackup = ArrayList(dataHolder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_resdes_recv_alumnisearch_f_adm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.imgVAlumniSearchResultFAdm.setImageResource(dataHolder[position].personImgVAlumniSearchResultFAdm)
        holder.tVNameAlumniSearchResultFAdm.text =
            dataHolder[position].gettVNameAlumniSearchResultFAdm()
        holder.tVDeptNameAlumniSearchResultFAdm.text =
            dataHolder[position].gettVDeptNameAlumniSearchResultFAdm()
        holder.tVRegNoAlumniSearchResultFAdm.text =
            dataHolder[position].gettVRegNoAlumniSearchResultFAdm()
        holder.linkedInImgVSingleResDesAlumniSearchFAdm.setImageResource(dataHolder[position].linkedInImgVSingleResDesAlumniSearchFAdm)
        holder.tVBatchYrAlumniSearchResultFAdm.text =
            dataHolder[position].gettVBatchYrAlumniSearchResultFAdm()
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var deleteAlumniTvSingleResDesRecVAlumniSearchFAdm: TextView
        var tVNameAlumniSearchResultFAdm: TextView
        var tVBatchYrAlumniSearchResultFAdm: TextView
        var tVRegNoAlumniSearchResultFAdm: TextView
        var tVDeptNameAlumniSearchResultFAdm: TextView
        var updateAlumniTvSingleResDesRecVAlumniSearchFAdm: TextView
        var imgVAlumniSearchResultFAdm: ImageView
        var linkedInImgVSingleResDesAlumniSearchFAdm: ImageView
        private var popupDeleteDialogTvYesBtn: TextView? = null
        private var popupDeleteDialogTvNoBtn: TextView? = null
        private val imgVRegNoEditAlumniDetailsFAdm: ImageView? = null
        private val imgVDeptEditAlumniDetailsFAdm: ImageView? = null
        private val imgVBatchYrEditAlumniDetailsFAdm: ImageView? = null
        private val imgVEditTvNameEditAlumniDetailsFAdm: ImageView? = null
        private val editTvRegNoEditAlumniDetailsFAdm: TextView? = null
        private val editTvBatchYrEditAlumniDetailsFAdm: TextView? = null
        private val editTvDeptNameEditAlumniDetailsFAdm: TextView? = null
        private val editTvNameEditAlumniDetailsFAdm: TextView? = null
        private val imgVEditAlumniDetailsFAdm: ImageView? = null
        private val cancelBtnImgVEditAlumniDetailsFAdm: ImageView? = null
        private val updateAlumniBtnEditAlumniDetailsFAdm: Button? = null

        init {
            tVNameAlumniSearchResultFAdm = itemView.findViewById(R.id.tVNameAlumniSearchResultFAdm)
            tVBatchYrAlumniSearchResultFAdm =
                itemView.findViewById(R.id.tVBatchYrAlumniSearchResultFAdm)
            tVRegNoAlumniSearchResultFAdm =
                itemView.findViewById(R.id.tVRegNoAlumniSearchResultFAdm)
            tVDeptNameAlumniSearchResultFAdm =
                itemView.findViewById(R.id.tVDeptNameAlumniSearchResultFAdm)
            imgVAlumniSearchResultFAdm = itemView.findViewById(R.id.imgVAlumniSearchResultFAdm)
            linkedInImgVSingleResDesAlumniSearchFAdm =
                itemView.findViewById(R.id.linkedInImgVSingleResDesAlumniSearchFAdm)
            deleteAlumniTvSingleResDesRecVAlumniSearchFAdm =
                itemView.findViewById(R.id.deleteAlumniTvSingleResDesRecVAlumniSearchFAdm)
            deleteAlumniTvSingleResDesRecVAlumniSearchFAdm.setOnClickListener { v ->
                val dialog = Dialog(v.context)
                dialog.setCancelable(false)
                dialog.setContentView(R.layout.popup_dialog_delete)
                dialog.window!!
                    .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                dialog.window!!.attributes.windowAnimations = R.style.animation
                popupDeleteDialogTvYesBtn = dialog.findViewById(R.id.popupDeleteDialogTvYesBtn)
                popupDeleteDialogTvYesBtn?.setOnClickListener(View.OnClickListener { v ->
                    dialog.setCancelable(true)
                    dialog.dismiss()
                    Toast.makeText(v.context, "Deleting without backend", Toast.LENGTH_SHORT).show()
                })
                popupDeleteDialogTvNoBtn =
                    dialog.findViewById(R.id.totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr)
                popupDeleteDialogTvNoBtn?.setOnClickListener(View.OnClickListener { v ->
                    dialog.setCancelable(true)
                    dialog.dismiss()
                    Toast.makeText(v.context, "Ok without backend", Toast.LENGTH_SHORT).show()
                })
                dialog.show()
            }
            updateAlumniTvSingleResDesRecVAlumniSearchFAdm =
                itemView.findViewById(R.id.updateAlumniTvSingleResDesRecVAlumniSearchFAdm)
            updateAlumniTvSingleResDesRecVAlumniSearchFAdm.setOnClickListener {
                val activity = itemView.context as AppCompatActivity
                val fl = activity.findViewById<FrameLayout>(R.id.frameLayAlumniSearchFAdm)
                fl.removeAllViews()
                val fragment: Fragment = UpdateAlumniDetailsFAdm()
                val manager = activity.supportFragmentManager
                val fragmentTransaction = manager.beginTransaction()
                fragmentTransaction.replace(R.id.frameLayAlumniSearchFAdm, fragment).commit()
                fragmentTransaction.addToBackStack(null)
            }

//            updateAlumniTvSingleResDesRecVAlumniSearchFAdm.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
//                    Dialog dialog = new Dialog(v.getContext());
//                    dialog.setCancelable(false);
//                    dialog.setContentView(R.layout.edit_alumni_details_popup_adm);
//                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
//                    dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
//                    int SELECT_IMG = 200;
//
//
//                    Toast.makeText(itemView.getContext(), "Clicked   ", Toast.LENGTH_SHORT).show();
//
//                    imgVEditAlumniDetailsFAdm = dialog.findViewById(R.id.imgVEditAlumniDetailsFAdm);
//                    imgVEditAlumniDetailsFAdm.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent();
//                            intent.setType("image/*");
//                            intent.setAction(Intent.ACTION_GET_CONTENT);
//                            activity.startActivityForResult(Intent.createChooser(intent, "Select Alumni Picture"),SELECT_IMG);
//                        }
//                    });
//
//                    dialog.show();
//
//
//                    imgVEditTvNameEditAlumniDetailsFAdm = dialog.findViewById(R.id.imgVEditTvNameEditAlumniDetailsFAdm);
//                    editTvNameEditAlumniDetailsFAdm = dialog.findViewById(R.id.editTvNameEditAlumniDetailsFAdm);
//                    editTvNameEditAlumniDetailsFAdm.setEnabled(false);
//                    imgVEditTvNameEditAlumniDetailsFAdm.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            editTvNameEditAlumniDetailsFAdm.setEnabled(true);
//                        }
//                    });
//
//
//
//                    imgVBatchYrEditAlumniDetailsFAdm = dialog.findViewById(R.id.imgVBatchYrEditAlumniDetailsFAdm);
//                    editTvBatchYrEditAlumniDetailsFAdm = dialog.findViewById(R.id.editTvBatchYrEditAlumniDetailsFAdm);
//                    editTvBatchYrEditAlumniDetailsFAdm.setEnabled(false);
//                    imgVBatchYrEditAlumniDetailsFAdm.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            editTvBatchYrEditAlumniDetailsFAdm.setEnabled(true);
//                        }
//                    });
//
//
//                    imgVDeptEditAlumniDetailsFAdm = dialog.findViewById(R.id.imgVDeptEditAlumniDetailsFAdm);
//                    editTvDeptNameEditAlumniDetailsFAdm = dialog.findViewById(R.id.editTvDeptNameEditAlumniDetailsFAdm);
//                    editTvDeptNameEditAlumniDetailsFAdm.setEnabled(false);
//                    imgVDeptEditAlumniDetailsFAdm.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            editTvDeptNameEditAlumniDetailsFAdm.setEnabled(true);
//                        }
//                    });
//
//
//                    imgVRegNoEditAlumniDetailsFAdm = dialog.findViewById(R.id.imgVRegNoEditAlumniDetailsFAdm);
//                    editTvRegNoEditAlumniDetailsFAdm = dialog.findViewById(R.id.editTvRegNoEditAlumniDetailsFAdm);
//                    editTvRegNoEditAlumniDetailsFAdm.setEnabled(false);
//                    imgVRegNoEditAlumniDetailsFAdm.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            editTvRegNoEditAlumniDetailsFAdm.setEnabled(true);
//                        }
//                    });
//
//
//                    cancelBtnImgVEditAlumniDetailsFAdm = dialog.findViewById(R.id.cancelBtnImgVEditAlumniDetailsFAdm);
//                    cancelBtnImgVEditAlumniDetailsFAdm.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            dialog.setCancelable(true);
//                            dialog.dismiss();
//                        }
//                    });
//
//                    updateAlumniBtnEditAlumniDetailsFAdm = dialog.findViewById(R.id.updateAlumniBtnEditAlumniDetailsFAdm);
//                    updateAlumniBtnEditAlumniDetailsFAdm.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            dialog.setCancelable(true);dialog.dismiss();
//                            Toast.makeText(dialog.getContext(), "Updated without backend", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                    dialog.show();
//
//                }//onClick End
//            });
//
        }
    }

    companion object {
        const val PICK_IMAGE = 1
    }
}
