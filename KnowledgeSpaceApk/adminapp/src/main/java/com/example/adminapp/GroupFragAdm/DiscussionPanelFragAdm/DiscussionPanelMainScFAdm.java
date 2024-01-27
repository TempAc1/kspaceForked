package com.example.adminapp.GroupFragAdm.DiscussionPanelFragAdm;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class DiscussionPanelMainScFAdm extends Fragment {

    private RecyclerView recyclerVMainScDisPanelFAdm;
    private FloatingActionButton floatingActionBtnMainScDisPanelFAdm;
    private ImageButton cancelBtnCusDiaAddDiscussion;
    private Button postBtnCusDiaDisPanelMainScFAdm;
    private EditText setDiscussionTitleTvCusDiaMainScFAdm, setDiscussionDescription;
    private TextView attachmentTvDisPanelFAdm;
    private DiscussionPanelData obj = new DiscussionPanelData();
    private ArrayList<DiscussionPanelData> dataHolder;
    private adapterRecVDisPanelMainSc adapter;

    public DiscussionPanelMainScFAdm() {
        // Required empty public constructor
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_discussion_panel_main_sc_f_adm, container, false);

        recyclerVMainScDisPanelFAdm = view.findViewById(R.id.recyclerVMainScDisPanelFAdm);
        recyclerVMainScDisPanelFAdm.setLayoutManager(new LinearLayoutManager(getContext()));
        setDataHolder();
        adapter = new adapterRecVDisPanelMainSc(dataHolder);
        recyclerVMainScDisPanelFAdm.setAdapter(adapter);

        floatingActionBtnMainScDisPanelFAdm = view.findViewById(R.id.floatingActionBtnMainScDisPanelFAdm);
        floatingActionBtnMainScDisPanelFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_dia_add_discussion_mainsc_dispanel_fadm);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                setDiscussionTitleTvCusDiaMainScFAdm = dialog.findViewById(R.id.setDiscussionTitleTvCusDiaMainScFAdm);
                setDiscussionDescription = dialog.findViewById(R.id.setDiscussionDescription);
                attachmentTvDisPanelFAdm = dialog.findViewById(R.id.attachmentTvDisPanelFAdm);
                cancelBtnCusDiaAddDiscussion = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);
                postBtnCusDiaDisPanelMainScFAdm = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm);

                attachmentTvDisPanelFAdm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int PICKFILE_RESULT_CODE=1;
                        Intent acessFilesIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        acessFilesIntent.setType("*/*");
                        startActivityForResult(acessFilesIntent,PICKFILE_RESULT_CODE);
                    }
                });

                cancelBtnCusDiaAddDiscussion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.setCancelable(true);
                        dialog.dismiss();
                    }
                });

                postBtnCusDiaDisPanelMainScFAdm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!setDiscussionTitleTvCusDiaMainScFAdm.getText().toString().trim().isEmpty()
                                && !setDiscussionTitleTvCusDiaMainScFAdm.getText().toString().trim().equals(" ")
                                && !setDiscussionDescription.getText().toString().trim().isEmpty()
                                && !setDiscussionDescription.getText().toString().trim().equals(" ")) {
                            obj.setTitle(setDiscussionTitleTvCusDiaMainScFAdm.getText().toString().trim());
                            obj.setDescription(setDiscussionDescription.getText().toString().trim());
                            //obj.setResources(Integer.parseInt(attachmentTvDisPanelFAdm.getText().toString().trim()));

                            Toast.makeText(getContext(), "Posting...noBackend", Toast.LENGTH_SHORT).show();
                            dialog.setCancelable(true);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(getContext(), "Invalid Discussion", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                dialog.show();
            }
        });

        return view;
    }

    private void setDataHolder() {
        dataHolder = new ArrayList<>();
        //TODO backend se lana prega na obj banane ke liye title n description
        DiscussionPanelData discussionPanelData = new DiscussionPanelData();
        DiscussionPanelData obj1 = new DiscussionPanelData("Demo Discussion Title here ", "Idk just testing out things only for demo purposes here");
        dataHolder.add(obj1);
        DiscussionPanelData obj2 = new DiscussionPanelData(discussionPanelData.getTitle(),discussionPanelData.description);
        dataHolder.add(obj2);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String filePath = data.getData().getPath();
                    Log.i("file path - ", filePath);
                    //TODO
                    //obj.setResources(Integer.parseInt(filePath));
                    attachmentTvDisPanelFAdm.setText(filePath);
                }
        }
    }
}