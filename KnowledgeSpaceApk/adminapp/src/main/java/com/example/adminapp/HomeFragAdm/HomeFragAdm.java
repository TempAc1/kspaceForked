package com.example.adminapp.HomeFragAdm;

import static android.app.Activity.RESULT_OK;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.adminapp.R;
import com.example.adminapp.mvc_posts_collections.controllerPostCollections;
import com.example.adminapp.mvc_posts_collections.dataModelPostCollection;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class HomeFragAdm extends Fragment {

    private RecyclerView recyclerVFragHomeSc;
    adapterRecVHomeFAdmDemo adapter;
    Toolbar toolbar;
    private MenuItem menuItem;
    private SearchView searchView;
    private ArrayList<dataModelPostCollection> dataHolder;
    private ImageView commentImgVSingleRDesRecHomeF,btnCancel;
    private FloatingActionButton floatingActionBtnHomeFragAdm,createPostFloatingActBtnHomeFragAdm,
            createEventFloatingActBtnHomeFragAdm;
    private Button postBtnCreatePostHomeFrag,postBtnCreateEventHomeFragAdm;
    private TextView attachmentTvHomeFAdm,startDateTvCreateEventDialogAdm,endDateTvCreateEventDialogAdm,
            startTimeTvCreateEventDialogAdm,endTimeTvCreateEventDialogAdm,venueTvCreateEventHomeFAdm;
    private boolean isFabBtnVisible = false,startDateTvClicked=false,endDateTvClicked=false,
            startTimeClicked=false,endTimeClicked=false;
    private int Hour,Minute;
//    private String uEndDate,uStartDate,
    private String uStartDate,uEndDate,uStartTime,uEndTime;
    private Date endDateObj,startDateObj;

    final Calendar myCal = Calendar.getInstance();






    private FirebaseFirestore db;
    private controllerPostCollections controllerPostCollections;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();


    public HomeFragAdm() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home_frag_adm,container,false);

        commentImgVSingleRDesRecHomeF = view.findViewById(R.id.commentBtnHomeFragAdm);
        floatingActionBtnHomeFragAdm = view.findViewById(R.id.floatingActionBtnHomeFragAdm);
        createPostFloatingActBtnHomeFragAdm = view.findViewById(R.id.createPostFloatingActBtnHomeFragAdm);
        createEventFloatingActBtnHomeFragAdm = view.findViewById(R.id.createEventFloatingActBtnHomeFragAdm);

        floatingBtnClicked();

//        recyclerVFragHomeSc.setLayoutManager(new LinearLayoutManager(getContext()));
//        dataHolder=new ArrayList<>();

//        dataModelRecVHomeFragAdm obj1 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj1);
//        dataModelRecVHomeFragAdm obj2 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj2);
//        dataModelRecVHomeFragAdm obj3 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj3);
//        dataModelRecVHomeFragAdm obj4 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj4);
//        dataModelRecVHomeFragAdm obj5 = new dataModelRecVHomeFragAdm(R.drawable.fest,"Techno-fest 2k23","Presenting " +
//                "you techno fest for this year.",R.drawable.like_64,R.drawable.oval_comment);
//        dataHolder.add(obj5);
//        recyclerVFragHomeSc.setAdapter(new adapterRecVHomeFragAdm(dataHolder));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        String cUser = auth.getCurrentUser().getEmail();

       String dateTimeStamp = String.valueOf(new Timestamp(new Date()));

        controllerPostCollections = new controllerPostCollections();


        //Sendig post to DB
//        if(!cUser.matches("")) {
//
//            dataModelPostCollection dataModelPostCollection = new dataModelPostCollection("postTitle", "This is a post for testing purposes", "https://api.slingacademy.com/public/sample-photos/1.jpeg", dateTimeStamp, cUser, "dypcoe#0841AKMHIN");
//
//            controllerPostCollections.addPost(dataModelPostCollection);
//
//            Toast.makeText(getContext(), "post added", Toast.LENGTH_SHORT).show();
//            Log.i("dataModel", dataModelPostCollection.toString());
//
//
//
//        }

        recyclerVFragHomeSc =  view.findViewById(R.id.RecyclerVHomeFragAdm);
        recyclerVFragHomeSc.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new adapterRecVHomeFAdmDemo(dataHolder);
        recyclerVFragHomeSc.setAdapter(adapter);


        //Getting post from db
        controllerPostCollections.getPosts(new controllerPostCollections.FetchPostsCallback() {
            @Override
            public void onPostsFetched(List<dataModelPostCollection> postList) {
                adapter.updatePosts(postList);
            }

            @Override
            public void onFetchPostsFailure(Exception e) {

            }
        });



        //Updating post from DB
        //Testing
        // Initialize Firestore
//        db = FirebaseFirestore.getInstance();
//
//        String postId = "ahvdEkeqBcyNR6gzkSc8";
//
//        // Get a reference to the post document
//        DocumentReference postRef = db.collection("Posts").document(postId);
//
//        // Create a map with the new post data
//        Map<String, Object> newPost = new HashMap<>();
//        newPost.put("title", "New Post Title");
//        newPost.put("content", "New post content.");
//
//        postRef.update(newPost)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            // Post updated successfully
//                            Toast.makeText(getContext(), "Post updated", Toast.LENGTH_SHORT).show();
//                        } else {
//                            // Handle the error
//                            Toast.makeText(getContext(), "Post update Error", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });


    }

    private void floatingBtnClicked() {
        floatingActionBtnHomeFragAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Button Animatation lagana hai
               if(!isFabBtnVisible){
                   createPostFloatingActBtnHomeFragAdm.setVisibility(View.VISIBLE);
                   createEventFloatingActBtnHomeFragAdm.setVisibility(View.VISIBLE);
                   isFabBtnVisible = true;
               }else{
                   createPostFloatingActBtnHomeFragAdm.setVisibility(View.GONE);
                   createEventFloatingActBtnHomeFragAdm.setVisibility(View.GONE);
                    isFabBtnVisible = false;
               }
            }
        });

        createPostFloatingActBtnHomeFragAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog =  new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_dialog_homef_createpost);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

                //Code for attachement textv
                attachmentTvHomeFAdm = (TextView) dialog.findViewById(R.id.courseNameTvAddModuleCourseSelectedF);

                //Code for Dialog Cancel Btn
                btnCancel = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);
                postBtnCreatePostHomeFrag = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm);

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        dialog.setCancelable(true);
                    }
                });
                postBtnCreatePostHomeFrag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.setCancelable(true);
                        dialog.dismiss();
                        Toast.makeText(getActivity(), "Posting...", Toast.LENGTH_SHORT).show();
                    }
                });
                attachmentTvHomeFAdm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int PICKFILE_RESULT_CODE=1;
                        Intent acessFilesIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        acessFilesIntent.setType("*/*");
                        startActivityForResult(acessFilesIntent,PICKFILE_RESULT_CODE);
                    }
                });
                dialog.show();
            }
        });

        createEventFloatingActBtnHomeFragAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
                checkDNT();
            }
        });
    }//End postMethod


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String filePath = data.getData().getPath();
                    attachmentTvHomeFAdm.setText(filePath);
                }
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.custom_toolbar_menu_adm,menu);
        menuItem = menu.findItem(R.id.search_button);

        searchView = (SearchView)menuItem.getActionView();

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                //mysearch(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if(adapter != null){
//                    adapter.getFilter().filter(newText);
//                }else{
//                    Toast.makeText(getContext(), "invalid search", Toast.LENGTH_SHORT).show();
//                }
//                return false;
//            }
//        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    private void openDialog() {
        Dialog dialog =  new Dialog(getActivity());
        dialog.setContentView(R.layout.create_event_dialog_homef_adm);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;


        attachmentTvHomeFAdm = (TextView) dialog.findViewById(R.id.courseNameTvAddModuleCourseSelectedF);
        startDateTvCreateEventDialogAdm = dialog.findViewById(R.id.startDateTvCreateEventDialogAdm);
        endDateTvCreateEventDialogAdm = dialog.findViewById(R.id.endDateTvCreateEventDialogAdm);
        startTimeTvCreateEventDialogAdm = dialog.findViewById(R.id.startTimeTvCreateEventDialogAdm);
        endTimeTvCreateEventDialogAdm = dialog.findViewById(R.id.endTimeTvCreateEventDialogAdm);
        venueTvCreateEventHomeFAdm = dialog.findViewById(R.id.venueTvCreateEventHomeFAdm);
        postBtnCreateEventHomeFragAdm = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm);

        //CODE FOR DIALOG BUTTONS
        btnCancel = dialog.findViewById(R.id.cancelBtnPopupDialogFinalAddHof);
        postBtnCreatePostHomeFrag = dialog.findViewById(R.id.postBtnCusDiaDisPanelMainScFAdm);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog.setCancelable(true);
            }
        });
        postBtnCreateEventHomeFragAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postBtnCreateEventClicked();
            }
        });
        attachmentTvHomeFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int PICKFILE_RESULT_CODE=1;
                Intent acessFilesIntent = new Intent(Intent.ACTION_GET_CONTENT);
                acessFilesIntent.setType("*/*");
                startActivityForResult(acessFilesIntent,PICKFILE_RESULT_CODE);
            }
        });


        dialog.show();
    }

    private void postBtnCreateEventClicked() {
        //TODO : sendDataTOApi() & Toast sahi krna hai
        validateNverify();
    }




    private void checkDNT() {
        //START DATE PICKER
        DatePickerDialog.OnDateSetListener startDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCal.set(Calendar.YEAR,year);
                myCal.set(Calendar.MONTH,month);
                myCal.set(Calendar.DAY_OF_MONTH,day);
                UpdateStartDateLabel();
            }
        };

        //END DATE PICKER
        DatePickerDialog.OnDateSetListener endDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                myCal.set(Calendar.YEAR,year);
                myCal.set(Calendar.MONTH,month);
                myCal.set(Calendar.DAY_OF_MONTH,day);
                UpdateEndDateLabel();
            }
        };

        startDateTvCreateEventDialogAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDateTvClicked = true;
                new DatePickerDialog(view.getContext(),startDateSetListener,myCal.get(Calendar.YEAR)
                ,myCal.get(Calendar.MONTH),myCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        endDateTvCreateEventDialogAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endDateTvClicked = true;
                new DatePickerDialog(view.getContext(),endDateSetListener,myCal.get(Calendar.YEAR)
                        ,myCal.get(Calendar.MONTH),myCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        startTimeTvCreateEventDialogAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimeClicked=true;
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String AM_PM ;
                        Hour = selectedHour;
                        Minute = selectedMinute;
                        if(selectedHour < 12) {
                            AM_PM = "AM";
                        } else {
                            AM_PM = "PM";
                        }
                        //Set text
                        startTimeTvCreateEventDialogAdm.setText(selectedHour + ":" + selectedMinute + " " + AM_PM);
                        uStartTime = startTimeTvCreateEventDialogAdm.getText().toString();
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),onTimeSetListener,Hour,Minute,false);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });
        endTimeTvCreateEventDialogAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endTimeClicked = true;
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String AM_PM ;
                        Hour = selectedHour;
                        Minute = selectedMinute;
                        if(selectedHour < 12) {
                            AM_PM = "AM";
                        } else {
                            AM_PM = "PM";
                        }
                        //Set Text
                        endTimeTvCreateEventDialogAdm.setText(selectedHour + ":" + selectedMinute + " " + AM_PM);
                        uEndTime = endTimeTvCreateEventDialogAdm.getText().toString();
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),onTimeSetListener,Hour,Minute,false);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        venueTvCreateEventHomeFAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO

            }
        });
    }

    private void UpdateStartDateLabel() {
        String myFormat="dd/MM/yy";
        SimpleDateFormat DateFormat=new SimpleDateFormat(myFormat);
        uStartDate = DateFormat.format(myCal.getTime());
        try{
            startDateObj=new SimpleDateFormat("dd/MM/yyyy").parse(uStartDate);
        }catch (Exception e){
            Toast.makeText(getContext(), "Error occured", Toast.LENGTH_SHORT).show();
        }
        startDateTvCreateEventDialogAdm.setText(uStartDate);

    }

    private void UpdateEndDateLabel(){
        String myFormat="dd/MM/yy";
        SimpleDateFormat endDateFormat=new SimpleDateFormat(myFormat, Locale.US);
        uEndDate = endDateFormat.format(myCal.getTime());
        endDateTvCreateEventDialogAdm.setText(uEndDate);
        try {
            endDateObj=new SimpleDateFormat("dd/MM/yyyy").parse(uEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void validateNverify() {
        //check click hua h date n time par
        if(startDateTvClicked && endDateTvClicked && startTimeClicked && endTimeClicked){
            //tv are clicked atleast
            if(uStartDate.equals(uEndDate) && uStartTime.equals(uEndTime)){
                //start n end date same dala hai n time diff h
                Toast.makeText(getContext(), "Since Dates r equal Time cannot be same", Toast.LENGTH_SHORT).show();
            }else if(uStartDate.equals(uEndDate) && !uStartTime.equals(uEndTime)){
                Toast.makeText(getContext(), "2nd executed", Toast.LENGTH_SHORT).show();
            } else if(startDateObj.compareTo(endDateObj)<0){
                //agar start date chota h end se to time se kya hi mtlb
                Toast.makeText(getContext(), "start date less than end ok ideal case", Toast.LENGTH_SHORT).show();
            }else if(startDateObj.compareTo(endDateObj)>0){
                //mtlb start date bara h end se OR YEH ALLOW NAHI HAI
                Toast.makeText(getContext(), "start great then last no valid", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getContext(), "Last else part executed", Toast.LENGTH_SHORT).show();
        }
    }
}