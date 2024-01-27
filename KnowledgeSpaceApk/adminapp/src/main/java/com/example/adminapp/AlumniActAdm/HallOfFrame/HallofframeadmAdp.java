package com.example.adminapp.AlumniActAdm.HallOfFrame;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminapp.R;

import java.util.ArrayList;

public class HallofframeadmAdp extends BaseAdapter {


    ArrayList<DataModelHallOfFrame> dataHolder;
    ArrayList<DataModelHallOfFrame> dataHolderBackup;


    public HallofframeadmAdp(ArrayList<DataModelHallOfFrame> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }


    @Override
    public int getCount() {
        return dataHolder.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resource_layout_hallofframe, null);

        // Link those objects with their respective id's
        // that we have given in .XML file
        TextView name = view.findViewById(R.id.imgNameTvSingleResDesHallOfFrame);
        ImageView image = view.findViewById(R.id.imgVSingleResHallOfFrame);

        // Set the data in text view
        name.setText(dataHolder.get(position).getImgNameTvSingleResDesHallOfFrame());

        // Set the image in Image view
        image.setImageResource(dataHolder.get(position).getImgVSingleResHallOfFrame());


        return view;
    }



}
