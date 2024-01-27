package com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.RecyclerVMainSc;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.AlumniActAdm.HallOfFrame.PreviousYrHoF.UpdateAlumniDetailsThroughDeleteUpdateAlumniDialogPrevYrHoF;
import com.example.adminapp.R;

import java.util.ArrayList;

public class AdapterRecVMainScPrevYrHoFAdm extends RecyclerView.Adapter<AdapterRecVMainScPrevYrHoFAdm.myviewholder> {

    ArrayList<DataModelRecVMainScPrevYrHoF> dataHolder;
    ArrayList<DataModelRecVMainScPrevYrHoF> dataHolderBackup;
    private static final int PICK_IMG_UPDATE_DIALOG_PREVYR = 103;

    public AdapterRecVMainScPrevYrHoFAdm(ArrayList<DataModelRecVMainScPrevYrHoF> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resdes_recv_prevyr_hof_mainsc_adm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.alumniImgVSingleRdRecVPrevYrHoFMainScAdm.setImageResource(dataHolder.get(position).getAlumniImgVSingleRdRecVPrevYrHoFMainScAdm());
        holder.alumniNameTvSingleRdRecVPrevYrHoFMainScAdm.setText(dataHolder.get(position).getAlumniNameTvSingleRdRecVPrevYrHoFMainScAdm());
        holder.alumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm.setText(dataHolder.get(position).getAlumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm());
        holder.alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm.setImageResource(dataHolder.get(position).getAlumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        ImageView alumniImgVSingleRdRecVPrevYrHoFMainScAdm,alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm;
        TextView alumniNameTvSingleRdRecVPrevYrHoFMainScAdm,alumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm;
        CardView cardVSingleResDesRecVPrevYrHofMainScAdm;

//        private Button deleteAlumniFromHoFBtnDeleteUpdateAlumniDialogPrevYrHoF,updateAlumniDetailsBtnDeleteUpdateAlumniDialogPrevYrHoF;
//        private ImageView cancelBtnDeleteUpdateAlumniDialogPrevYrHoF;

        private TextView noTvAlumniDetailsUpdateAlumniDialogPrevYrHoF,yesTvAlumniDetailsUpdateAlumniDialogPrevYrHoF;
        private ImageView cancelBtnUpdateAlumniDialogPrevYrHoF;
        //Dialog Delete details:
        private TextView noTvPopupDeleteDialog,
                popupDeleteDialogTvYesBtn;

        //Dialog askRemoveAlumniFrmHof:
        private TextView popupYesTvAskRemoveAlumniFrmHofDialog,noTvPopupAskRemoveAlumniFrmHofDialog;

        public myviewholder(@NonNull View itemView) {
            super(itemView);


            alumniImgVSingleRdRecVPrevYrHoFMainScAdm = itemView.findViewById(R.id.alumniImgVSingleRdRecVPrevYrHoFMainScAdm);
            alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm = itemView.findViewById(R.id.alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm);

            alumniNameTvSingleRdRecVPrevYrHoFMainScAdm = itemView.findViewById(R.id.alumniNameTvSingleRdRecVPrevYrHoFMainScAdm);
            alumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm = itemView.findViewById(R.id.alumniDeptNameTvSingleRdRecVPrevYrHoFMainScAdm);

            alumniLinkedinImgVSingleRdRecVPrevYrHoFMainScAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "No Backend", Toast.LENGTH_SHORT).show();
                }
            });

            cardVSingleResDesRecVPrevYrHofMainScAdm = itemView.findViewById(R.id.cardVSingleResDesRecVPrevYrHofMainScAdm);
            cardVSingleResDesRecVPrevYrHofMainScAdm.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Dialog dialog = new Dialog(itemView.getContext());
                    dialog.setContentView(R.layout.dialog_ask_admin_update_ornot_alumni_details_prevyr_hof);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.setCancelable(false);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(255,241,249)));
                    dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                    cancelBtnUpdateAlumniDialogPrevYrHoF = dialog.findViewById(R.id.cancelBtnUpdateAlumniDialogPrevYrHoF);
                    noTvAlumniDetailsUpdateAlumniDialogPrevYrHoF = dialog.findViewById(R.id.noTvAlumniDetailsUpdateAlumniDialogPrevYrHoF);
                    yesTvAlumniDetailsUpdateAlumniDialogPrevYrHoF = dialog.findViewById(R.id.yesTvAlumniDetailsUpdateAlumniDialogPrevYrHoF);

                    cancelBtnUpdateAlumniDialogPrevYrHoF.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.setCancelable(true);dialog.dismiss();
                        }
                    });

                    yesTvAlumniDetailsUpdateAlumniDialogPrevYrHoF.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Open UpdateAlumniDetailsFrag:

                            AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
                            FrameLayout fl = activity.findViewById(R.id.frameLayPrevYrHoFMainSc);
                            fl.removeAllViews();
                            Fragment fragment = new UpdateAlumniDetailsThroughDeleteUpdateAlumniDialogPrevYrHoF();
                            FragmentManager manager = activity.getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = manager.beginTransaction();
                            fragmentTransaction.replace(R.id.frameLayPrevYrHoFMainSc,fragment);
                            fragmentTransaction.disallowAddToBackStack().commit();
//                            fragmentTransaction.addToBackStack("frag_prev_yr_hof_mainsc");


                            dialog.setCancelable(true);dialog.dismiss();

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
                        }
                    });


                    noTvAlumniDetailsUpdateAlumniDialogPrevYrHoF.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            //As soon open close main dialog:
                            dialog.setCancelable(true);dialog.dismiss();
                            Toast.makeText(v.getContext(), "No Backend", Toast.LENGTH_SHORT).show();
                            
                        }
                    });

                    dialog.show();
                    return true;
                }
            });
            
            
            
            

            //OnPress RemoveFromHoF For that particular Yr opt dedo:
            cardVSingleResDesRecVPrevYrHofMainScAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog removeFrmHofDialog = new Dialog(itemView.getContext(),R.style.DialogFragmentStyle);
                    removeFrmHofDialog.setContentView(R.layout.popup_ask_removealumni_frm_hof);
                    removeFrmHofDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    removeFrmHofDialog.setCancelable(false);
                    removeFrmHofDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(255,241,249)));
                    removeFrmHofDialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                    popupYesTvAskRemoveAlumniFrmHofDialog = removeFrmHofDialog.findViewById(R.id.popupYesTvAskRemoveAlumniFrmHofDialog);
                    popupYesTvAskRemoveAlumniFrmHofDialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            removeFrmHofDialog.setCancelable(true);removeFrmHofDialog.dismiss();
                            Toast.makeText(removeFrmHofDialog.getContext(), "Without backend", Toast.LENGTH_SHORT).show();

                            //Todo Add Backend for remove object frm arraylist :
                            dataHolder.remove(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());


                        }
                    });

                    noTvPopupAskRemoveAlumniFrmHofDialog = removeFrmHofDialog.findViewById(R.id.noTvPopupAskRemoveAlumniFrmHofDialog);
                    noTvPopupAskRemoveAlumniFrmHofDialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            removeFrmHofDialog.setCancelable(true);removeFrmHofDialog.dismiss();
                            Toast.makeText(removeFrmHofDialog.getContext(), "No Backend", Toast.LENGTH_SHORT).show();
                        }
                    });

                    removeFrmHofDialog.show();
                }
            });
            
        }

    }


}
