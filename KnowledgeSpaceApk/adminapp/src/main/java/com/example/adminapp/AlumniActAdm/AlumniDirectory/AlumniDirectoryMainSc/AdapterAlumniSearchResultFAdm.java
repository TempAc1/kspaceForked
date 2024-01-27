package com.example.adminapp.AlumniActAdm.AlumniDirectory.AlumniDirectoryMainSc;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class AdapterAlumniSearchResultFAdm extends RecyclerView.Adapter<AdapterAlumniSearchResultFAdm.myviewholder> {

    ArrayList<DataModelAlumniSearchResultFAdm> dataHolder;
    ArrayList<DataModelAlumniSearchResultFAdm> dataHolderBackup;

    public static final int PICK_IMAGE = 1;


    public AdapterAlumniSearchResultFAdm(ArrayList<DataModelAlumniSearchResultFAdm> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resdes_recv_alumnisearch_f_adm,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.imgVAlumniSearchResultFAdm.setImageResource(dataHolder.get(position).getPersonImgVAlumniSearchResultFAdm());
        holder.tVNameAlumniSearchResultFAdm.setText(dataHolder.get(position).gettVNameAlumniSearchResultFAdm());
        holder.tVDeptNameAlumniSearchResultFAdm.setText(dataHolder.get(position).gettVDeptNameAlumniSearchResultFAdm());
        holder.tVRegNoAlumniSearchResultFAdm.setText(dataHolder.get(position).gettVRegNoAlumniSearchResultFAdm());
        holder.linkedInImgVSingleResDesAlumniSearchFAdm.setImageResource(dataHolder.get(position).linkedInImgVSingleResDesAlumniSearchFAdm);
        holder.tVBatchYrAlumniSearchResultFAdm.setText(dataHolder.get(position).gettVBatchYrAlumniSearchResultFAdm());

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }




    public class myviewholder extends RecyclerView.ViewHolder{
        TextView deleteAlumniTvSingleResDesRecVAlumniSearchFAdm,tVNameAlumniSearchResultFAdm,tVBatchYrAlumniSearchResultFAdm,tVRegNoAlumniSearchResultFAdm,tVDeptNameAlumniSearchResultFAdm,updateAlumniTvSingleResDesRecVAlumniSearchFAdm;
        ImageView imgVAlumniSearchResultFAdm,linkedInImgVSingleResDesAlumniSearchFAdm;

        private TextView popupDeleteDialogTvYesBtn,popupDeleteDialogTvNoBtn;
        private ImageView imgVRegNoEditAlumniDetailsFAdm,imgVDeptEditAlumniDetailsFAdm,
                            imgVBatchYrEditAlumniDetailsFAdm,imgVEditTvNameEditAlumniDetailsFAdm;
        private TextView editTvRegNoEditAlumniDetailsFAdm,editTvBatchYrEditAlumniDetailsFAdm,editTvDeptNameEditAlumniDetailsFAdm,
                editTvNameEditAlumniDetailsFAdm;
        private ImageView imgVEditAlumniDetailsFAdm,cancelBtnImgVEditAlumniDetailsFAdm;
        private Button updateAlumniBtnEditAlumniDetailsFAdm;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            tVNameAlumniSearchResultFAdm = itemView.findViewById(R.id.tVNameAlumniSearchResultFAdm);
            tVBatchYrAlumniSearchResultFAdm = itemView.findViewById(R.id.tVBatchYrAlumniSearchResultFAdm);
            tVRegNoAlumniSearchResultFAdm = itemView.findViewById(R.id.tVRegNoAlumniSearchResultFAdm);
            tVDeptNameAlumniSearchResultFAdm = itemView.findViewById(R.id.tVDeptNameAlumniSearchResultFAdm);

            imgVAlumniSearchResultFAdm = itemView.findViewById(R.id.imgVAlumniSearchResultFAdm);
            linkedInImgVSingleResDesAlumniSearchFAdm = itemView.findViewById(R.id.linkedInImgVSingleResDesAlumniSearchFAdm);
            deleteAlumniTvSingleResDesRecVAlumniSearchFAdm = itemView.findViewById(R.id.deleteAlumniTvSingleResDesRecVAlumniSearchFAdm);
            deleteAlumniTvSingleResDesRecVAlumniSearchFAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(v.getContext());
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.popup_dialog_delete);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.getWindow().getAttributes().windowAnimations = R.style.animation;


                    popupDeleteDialogTvYesBtn = dialog.findViewById(R.id.popupDeleteDialogTvYesBtn);
                    popupDeleteDialogTvYesBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.setCancelable(true);dialog.dismiss();
                            Toast.makeText(v.getContext(), "Deleting without backend", Toast.LENGTH_SHORT).show();
                        }
                    });

                    popupDeleteDialogTvNoBtn = dialog.findViewById(R.id.totalNoOfAlumnisToEnterEditTvPopupAskAdmAddHofNoOfAlumnisNYr);
                    popupDeleteDialogTvNoBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.setCancelable(true);dialog.dismiss();
                            Toast.makeText(v.getContext(), "Ok without backend", Toast.LENGTH_SHORT).show();
                        }
                    });

                    dialog.show();
                }
            });


            updateAlumniTvSingleResDesRecVAlumniSearchFAdm = itemView.findViewById(R.id.updateAlumniTvSingleResDesRecVAlumniSearchFAdm);
            updateAlumniTvSingleResDesRecVAlumniSearchFAdm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
                    FrameLayout fl = activity.findViewById(R.id.frameLayAlumniSearchFAdm);
                    fl.removeAllViews();
                    Fragment fragment = new UpdateAlumniDetailsFAdm();
                    FragmentManager manager = activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = manager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayAlumniSearchFAdm,fragment).commit();
                    fragmentTransaction.addToBackStack(null);
                }
            });

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
}
