package com.example.adminapp.HomeworkActAdm;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class CreateHomeworkFragAdm extends Fragment {
    final Calendar myCal = Calendar.getInstance();
    private TextView startDateTVCreateHomeworkFragAdm,endDateTVCreateHomeworkFragAdm
            ,startTimeTVCreateHomeworkFragAdm,endTimeTVCreateHomeworkFragAdm,attachmentTvCreateHomeworkFragAdm;
   private String uStartTime,uEndTime;
   private String uEndDate,uStartDate;
    private int Hour,Minute;
    private Date endDateObj,startDateObj;
    private Button postHomeWoreBtnCreateHomeworkFragAdm;
    private Boolean startDateTvClicked=false,endDateTvClicked=false,startTimeTvClicked=false,endTimeTvClicked=false;

    public CreateHomeworkFragAdm() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(
                R.layout.fragment_create_homework_frag_adm,container,false);
        startDateTVCreateHomeworkFragAdm = view.findViewById(R.id.startDateTVCreateHomeworkFragAdm);
        endDateTVCreateHomeworkFragAdm = view.findViewById(R.id.endDateTVCreateHomeworkFragAdm);
        postHomeWoreBtnCreateHomeworkFragAdm = view.findViewById(R.id.postHomeWoreBtnCreateHomeworkFragAdm);

        startTimeTVCreateHomeworkFragAdm = view.findViewById(R.id.startTimeTVCreateHomeworkFragAdm);
        endTimeTVCreateHomeworkFragAdm = view.findViewById(R.id.endTimeTVCreateHomeworkFragAdm);

        startTimeTVCreateHomeworkFragAdm = view.findViewById(R.id.startTimeTVCreateHomeworkFragAdm);
        endTimeTVCreateHomeworkFragAdm = view.findViewById(R.id.endTimeTVCreateHomeworkFragAdm);


        DatePickerDialog.OnDateSetListener startDate =  new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCal.set(Calendar.YEAR,year);
                myCal.set(Calendar.MONTH,month);
                myCal.set(Calendar.DAY_OF_MONTH,day);
                startDateUpdateLabel();
            }
        };
        DatePickerDialog.OnDateSetListener endDate =  new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCal.set(Calendar.YEAR,year);
                myCal.set(Calendar.MONTH,month);
                myCal.set(Calendar.DAY_OF_MONTH,day);
                endDateUpdateLabel();
            }
        };

        startDateTVCreateHomeworkFragAdm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                startDateTvClicked = true;
                new MaterialStyledDatePickerDialog(view.getContext(),startDate,
                        myCal.get(Calendar.YEAR),myCal.get(Calendar.MONTH),myCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        endDateTVCreateHomeworkFragAdm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                endDateTvClicked = true;
                new MaterialStyledDatePickerDialog(view.getContext(),endDate,
                        myCal.get(Calendar.YEAR),myCal.get(Calendar.MONTH),myCal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        startTimeTVCreateHomeworkFragAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimeTvClicked = true;
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
                startTimeTVCreateHomeworkFragAdm.setText(selectedHour + ":" + selectedMinute + " " + AM_PM);
                uStartTime = startTimeTVCreateHomeworkFragAdm.getText().toString();
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),onTimeSetListener,Hour,Minute,false);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }

        });
        endTimeTVCreateHomeworkFragAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endTimeTvClicked = true;
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
                endTimeTVCreateHomeworkFragAdm.setText(selectedHour + ":" + selectedMinute + " " + AM_PM);
                uEndTime = endTimeTVCreateHomeworkFragAdm.getText().toString();
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),onTimeSetListener,Hour,Minute,false);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        attachmentTvCreateHomeworkFragAdm = view.findViewById(R.id.attachmentTvCreateHomeworkFragAdm);
        attachmentTvCreateHomeworkFragAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int PICKFILE_RESULT_CODE=1;
                Intent acessFilesIntent = new Intent(Intent.ACTION_GET_CONTENT);
                acessFilesIntent.setType("*/*");
                startActivityForResult(acessFilesIntent,PICKFILE_RESULT_CODE);

            }
        });


        postHomeWoreBtnCreateHomeworkFragAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postButtonClicked();
            }
        });
        return view;
    }//End OnCreate:



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String filePath = data.getData().getPath();
                    attachmentTvCreateHomeworkFragAdm.setText(filePath);
                }
        }
    }

    private void endDateUpdateLabel() {
        String myFormat="dd/MM/yy";
        SimpleDateFormat endDateFormat=new SimpleDateFormat(myFormat, Locale.US);
        uEndDate = endDateFormat.format(myCal.getTime());
        endDateTVCreateHomeworkFragAdm.setText(uEndDate);
        try {
            endDateObj=new SimpleDateFormat("dd/MM/yyyy").parse(uEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void startDateUpdateLabel() {
        String myFormat="dd/MM/yy";
        SimpleDateFormat startDateFormat=new SimpleDateFormat(myFormat);
        uStartDate = startDateFormat.format(myCal.getTime());
        startDateTVCreateHomeworkFragAdm.setText(uStartDate);
        try {
            startDateObj=new SimpleDateFormat("dd/MM/yyyy").parse(uStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /*use compareTo() for dates compare */
    private void postButtonClicked(){
        //TODO : sendDataTOApi() & Toast sahi krna hai
        validateNverify();
    }

    private void validateNverify(){
        //check click hua h date n time par
        if(startDateTvClicked && endDateTvClicked && startTimeTvClicked && endTimeTvClicked) {
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