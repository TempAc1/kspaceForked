package com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.RecyclerVMainSc

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.UpdateAlumniDetailsThroughDeleteUpdateAlumniDialogPrevYrHoF
import com.example.adminapp.R

class AdapterRecVMainScPrevYrHoFAdm(var dataHolder: ArrayList<DataModelRecVMainScPrevYrHoF>) :
    RecyclerView.Adapter<AdapterRecVMainScPrevYrHoFAdm.myviewholder>() {
    var dataHolderBackup: ArrayList<DataModelRecVMainScPrevYrHoF>

    init {
        dataHolderBackup = ArrayList(
            dataHolder
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_resdes_recv_prevyr_hof_mainsc_adm, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {

        holder.alumniNameTvSingleRdRecVPrevYrHoFMainScAdm.text =
            dataHolder[position].getAlumniNameTvSingleRdRecVPrevYrHoFMainScAdm()
        holder.alumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm.text =
            dataHolder[position].getAlumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm()
        holder.alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm.setImageResource(dataHolder[position].getAlumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm())
        holder.alumniImgVSingleRdRecVPrevYrHoFMainScAdm.setImageResource(dataHolder[position].getAlumniImgVSingleRdRecVPrevYrHoFMainScAdm())
    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }

    inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var alumniImgVSingleRdRecVPrevYrHoFMainScAdm: ImageView
        var alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm: ImageView
        var alumniNameTvSingleRdRecVPrevYrHoFMainScAdm: TextView
        var alumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm: TextView
        var cardVSingleResDesRecVPrevYrHofMainScAdm: CardView

        //        private Button deleteAlumniFromHoFBtnDeleteUpdateAlumniDialogPrevYrHoF,updateAlumniDetailsBtnDeleteUpdateAlumniDialogPrevYrHoF;
        //        private ImageView cancelBtnDeleteUpdateAlumniDialogPrevYrHoF;
        private var noTvAlumniDetailsUpdateAlumniDialogPrevYrHoF: TextView? = null
        private var yesTvAlumniDetailsUpdateAlumniDialogPrevYrHoF: TextView? = null
        private var cancelBtnUpdateAlumniDialogPrevYrHoF: ImageView? = null

        //Dialog Delete details:
        private val noTvPopupDeleteDialog: TextView? = null
        private val popupDeleteDialogTvYesBtn: TextView? = null

        //Dialog askRemoveAlumniFrmHof:
        private var popupYesTvAskRemoveAlumniFrmHofDialog: TextView? = null
        private var noTvPopupAskRemoveAlumniFrmHofDialog: TextView? = null

        init {
            alumniImgVSingleRdRecVPrevYrHoFMainScAdm =
                itemView.findViewById(R.id.alumniImgVSingleRdRecVPrevYrHoFMainScAdm)
            alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm =
                itemView.findViewById(R.id.alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm)
            alumniNameTvSingleRdRecVPrevYrHoFMainScAdm =
                itemView.findViewById(R.id.alumniNameTvSingleRdRecVPrevYrHoFMainScAdm)
            alumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm =
                itemView.findViewById(R.id.alumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm)
            alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "No Backend",
                    Toast.LENGTH_SHORT
                ).show()
            }
            cardVSingleResDesRecVPrevYrHofMainScAdm =
                itemView.findViewById(R.id.cardVSingleResDesRecVPrevYrHofMainScAdm)
            cardVSingleResDesRecVPrevYrHofMainScAdm.setOnLongClickListener {
                val dialog = Dialog(itemView.context)
                dialog.setContentView(R.layout.dialog_ask_admin_update_ornot_alumni_details_prevyr_hof)
                dialog.window!!
                    .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                dialog.setCancelable(false)
                dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.rgb(255, 241, 249)))
                dialog.window!!.attributes.windowAnimations = R.style.animation
                cancelBtnUpdateAlumniDialogPrevYrHoF =
                    dialog.findViewById(R.id.cancelBtnUpdateAlumniDialogPrevYrHoF)
                noTvAlumniDetailsUpdateAlumniDialogPrevYrHoF =
                    dialog.findViewById(R.id.noTvAlumniDetailsUpdateAlumniDialogPrevYrHoF)
                yesTvAlumniDetailsUpdateAlumniDialogPrevYrHoF =
                    dialog.findViewById(R.id.yesTvAlumniDetailsUpdateAlumniDialogPrevYrHoF)
                cancelBtnUpdateAlumniDialogPrevYrHoF?.setOnClickListener(View.OnClickListener {
                    dialog.setCancelable(true)
                    dialog.dismiss()
                })
                yesTvAlumniDetailsUpdateAlumniDialogPrevYrHoF?.setOnClickListener(View.OnClickListener {
                    //Open UpdateAlumniDetailsFrag:
                    val activity = itemView.context as AppCompatActivity
                    val fl = activity.findViewById<FrameLayout>(R.id.frameLayPrevYrHoFMainSc)
                    fl.removeAllViews()
                    val fragment: Fragment =
                        UpdateAlumniDetailsThroughDeleteUpdateAlumniDialogPrevYrHoF()
                    val manager = activity.supportFragmentManager
                    val fragmentTransaction = manager.beginTransaction()
                    fragmentTransaction.replace(R.id.frameLayPrevYrHoFMainSc, fragment)
                    fragmentTransaction.disallowAddToBackStack().commit()
                    //                            fragmentTransaction.addToBackStack("frag_prev_yr_hof_mainsc");
                    dialog.setCancelable(true)
                    dialog.dismiss()

//                            Dialog dialogUpdate = new Dialog(itemView.getContext(),R.style.DialogFragmentStyle);
//                            dialogUpdate.setContentView(R.layout.dialog_update_alumnidetails_prevyr_hof);
//                            dialogUpdate.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
//                            dialogUpdate.setCancelable(false);
//                            dialogUpdate.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(255,241,249)));
//                            dialogUpdate.getWindow().getAttributes().windowAnimations = R.style.animation;
//
//                            updateBtnDialogAlumniDetailsPrevyrHoF = dialogUpdate.findViewById(R.id.updateBtnDialogAlumniDetailsPrevyrHoF);
//
//                            imgVEditTvNameEditDialogUpdateAlumniDetailsPrevYrHoF = dialogUpdate.findViewById(R.id.imgVEditTvNameEditDialogUpdateAlumniDetailsPrevYrHoF);
//                            alumniNameTvDialogUpdateAlumniDetailsPrevYrHoF =dialogUpdate.findViewById(R.id.alumniNameTvDialogUpdateAlumniDetailsPrevYrHoF);
//                            imgVEditTvNameEditDialogUpdateAlumniDetailsPrevYrHoF.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    alumniNameTvDialogUpdateAlumniDetailsPrevYrHoF.setEnabled(true);
//                                    alumniNameTvDialogUpdateAlumniDetailsPrevYrHoF.setFocusable(true);
//                                    alumniNameTvDialogUpdateAlumniDetailsPrevYrHoF.setCursorVisible(true);
//                                    //Todo
//                                }
//                            });
//
//                            imgVEditTvDeptNameEditDialogUpdateAlumniDetailsPrevYrHoF = dialogUpdate.findViewById(R.id.imgVEditTvDeptNameEditDialogUpdateAlumniDetailsPrevYrHoF);
//                            alumniDeptNameTvDialogUpdateAlumniDetailsPrevYrHoF = dialogUpdate.findViewById(R.id.alumniDeptNameTvDialogUpdateAlumniDetailsPrevYrHoF);
//                            imgVEditTvDeptNameEditDialogUpdateAlumniDetailsPrevYrHoF.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    alumniDeptNameTvDialogUpdateAlumniDetailsPrevYrHoF.setEnabled(true);
//                                    alumniDeptNameTvDialogUpdateAlumniDetailsPrevYrHoF.setFocusable(true);
//                                    alumniDeptNameTvDialogUpdateAlumniDetailsPrevYrHoF.setCursorVisible(true);
//                                }
//                            });
//
//                            imgVEditTvSocialLinkEditDialogUpdateAlumniDetailsPrevYrHoF = dialogUpdate.findViewById(R.id.imgVEditTvSocialLinkEditDialogUpdateAlumniDetailsPrevYrHoF);
//                            alumniSocialLinkTvDialogUpdateAlumniDetailsPrevYrHoF = dialogUpdate.findViewById(R.id.alumniSocialLinkTvDialogUpdateAlumniDetailsPrevYrHoF);
//                            imgVEditTvSocialLinkEditDialogUpdateAlumniDetailsPrevYrHoF.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    alumniSocialLinkTvDialogUpdateAlumniDetailsPrevYrHoF.setEnabled(true);
//                                    alumniSocialLinkTvDialogUpdateAlumniDetailsPrevYrHoF.setFocusable(true);
//                                    alumniSocialLinkTvDialogUpdateAlumniDetailsPrevYrHoF.setCursorVisible(true);
//
//                                }
//                            });
//
//                            updateBtnDialogAlumniDetailsPrevyrHoF.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    Toast.makeText(dialogUpdate.getContext(), "Closing Without backend", Toast.LENGTH_SHORT).show();
//                                    dialog.setCancelable(true);dialog.dismiss();
//                                }
//                            });
//
//                            //Handle Backpress:
//                            dialogUpdate.setOnKeyListener(new DialogInterface.OnKeyListener() {
//                                @Override
//                                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
//                                    if(keyCode == KeyEvent.KEYCODE_BACK){
//                                        dialogUpdate.setCancelable(true);dialogUpdate.dismiss();
//                                    }
//                                    return true;
//                                }
//                            });
//
//                            //Handle ImgV Intent:
//                            alumniImgVDialogUpdateAlumniDetailsPrevYrHoF = dialogUpdate.findViewById(R.id.alumniImgVDialogUpdateAlumniDetailsPrevYrHoF);
//                            alumniImgVDialogUpdateAlumniDetailsPrevYrHoF.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    Intent selectImgIntent = new Intent();
//                                    selectImgIntent.setType("image/*");
//                                    selectImgIntent.setAction(Intent.ACTION_GET_CONTENT);
//
//                                    activity.startActivityForResult(Intent.createChooser(selectImgIntent,"Select Picture"),PICK_IMG_UPDATE_DIALOG_PREVYR);
//                                }
//                            });
//
//                            dialogUpdate.show();
                })
                noTvAlumniDetailsUpdateAlumniDialogPrevYrHoF?.setOnClickListener(View.OnClickListener { v -> //As soon open close main dialog:
                    dialog.setCancelable(true)
                    dialog.dismiss()
                    Toast.makeText(v.context, "No Backend", Toast.LENGTH_SHORT).show()
                })
                dialog.show()
                true
            }


            //OnPress RemoveFromHoF For that particular Yr opt dedo:
            cardVSingleResDesRecVPrevYrHofMainScAdm.setOnClickListener {
                val removeFrmHofDialog = Dialog(itemView.context, R.style.DialogFragmentStyle)
                removeFrmHofDialog.setContentView(R.layout.popup_ask_removealumni_frm_hof)
                removeFrmHofDialog.window!!
                    .setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                removeFrmHofDialog.setCancelable(false)
                removeFrmHofDialog.window!!.setBackgroundDrawable(
                    ColorDrawable(
                        Color.rgb(
                            255,
                            241,
                            249
                        )
                    )
                )
                removeFrmHofDialog.window!!.attributes.windowAnimations = R.style.animation
                popupYesTvAskRemoveAlumniFrmHofDialog =
                    removeFrmHofDialog.findViewById(R.id.popupYesTvAskRemoveAlumniFrmHofDialog)
                popupYesTvAskRemoveAlumniFrmHofDialog?.setOnClickListener(View.OnClickListener {
                    removeFrmHofDialog.setCancelable(true)
                    removeFrmHofDialog.dismiss()
                    Toast.makeText(
                        removeFrmHofDialog.context,
                        "Without backend",
                        Toast.LENGTH_SHORT
                    ).show()

                    //Todo Add Backend for remove object frm arraylist :
                    dataHolder.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                })
                noTvPopupAskRemoveAlumniFrmHofDialog =
                    removeFrmHofDialog.findViewById(R.id.noTvPopupAskRemoveAlumniFrmHofDialog)
                noTvPopupAskRemoveAlumniFrmHofDialog?.setOnClickListener(View.OnClickListener {
                    removeFrmHofDialog.setCancelable(true)
                    removeFrmHofDialog.dismiss()
                    Toast.makeText(removeFrmHofDialog.context, "No Backend", Toast.LENGTH_SHORT)
                        .show()
                })
                removeFrmHofDialog.show()
            }
        }
    }

    companion object {
        private const val PICK_IMG_UPDATE_DIALOG_PREVYR = 103
    }
}
