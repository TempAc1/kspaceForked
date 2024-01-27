package com.example.knowledgespaceapk.GroupAct.DiscussionPanel;

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

import com.example.knowledgespaceapk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class DiscussionPanelMainScF extends Fragment {

    private RecyclerView recyclerVMainScDisPanelF;
    private FloatingActionButton floatingActionBtnMainScDisPanelF;
    private ImageButton cancelBtnCusDiaAddDiscussion;
    private Button postBtnCusDiaDisPanelMainScF;
    private EditText setDiscussionTitleTvCusDiaMainScF, setDiscussionDescription;
    private TextView attachmentTvDisPanelF;
    private DataModelRecVDiscussionPanelF obj = new DataModelRecVDiscussionPanelF();
    private ArrayList<DataModelRecVDiscussionPanelF> dataHolder;
    private AdapterDiscussionPanelF adapter;

    public DiscussionPanelMainScF() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_discussion_panel_main_sc, container, false);

        recyclerVMainScDisPanelF = view.findViewById(R.id.recyclerVMainScDisPanelF);
        recyclerVMainScDisPanelF.setLayoutManager(new LinearLayoutManager(getContext()));
        setDataHolder();
        adapter = new AdapterDiscussionPanelF(dataHolder);
        recyclerVMainScDisPanelF.setAdapter(adapter);

        floatingActionBtnMainScDisPanelF = view.findViewById(R.id.floatingActionBtnMainScDisPanelF);
        floatingActionBtnMainScDisPanelF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_dia_add_discussion_mainsc_dispanel_f);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                setDiscussionTitleTvCusDiaMainScF = dialog.findViewById(R.id.setDiscussionTitleTvCusDiaMainScF);
                setDiscussionDescription = dialog.findViewById(R.id.setDiscussionDescription);
                attachmentTvDisPanelF = dialog.findViewById(R.id.attachmentTvDisPanelF);
                cancelBtnCusDiaAddDiscussion = dialog.findViewById(R.id.cancelBtnCusDiaAddDiscussion);
                postBtnCusDiaDisPanelMainScF = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScF);

                attachmentTvDisPanelF.setOnClickListener(new View.OnClickListener() {
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

                postBtnCusDiaDisPanelMainScF.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!setDiscussionTitleTvCusDiaMainScF.getText().toString().trim().isEmpty()
                                && !setDiscussionTitleTvCusDiaMainScF.getText().toString().trim().equals(" ")
                                && !setDiscussionDescription.getText().toString().trim().isEmpty()
                                && !setDiscussionDescription.getText().toString().trim().equals(" ")) {
                            obj.setTitle(setDiscussionTitleTvCusDiaMainScF.getText().toString().trim());
                            obj.setDescription(setDiscussionDescription.getText().toString().trim());
                            //obj.setResources(Integer.parseInt(attachmentTvDisPanelF.getText().toString().trim()));

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
//        DataModelRecVDiscussionPanelF discussionPanelData = new DataModelRecVDiscussionPanelF();
//        DataModelRecVDiscussionPanelF obj1 = new DataModelRecVDiscussionPanelF("Demo Discussion Title here ", "Idk just testing out things only for demo purposes here");
//        dataHolder.add(obj1);

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
                    attachmentTvDisPanelF.setText(filePath);
                }
        }
    }
}