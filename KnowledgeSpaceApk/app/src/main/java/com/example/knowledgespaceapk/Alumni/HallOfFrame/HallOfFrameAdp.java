package com.example.knowledgespaceapk.Alumni.HallOfFrame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.knowledgespaceapk.R;

import java.util.ArrayList;

public class HallOfFrameAdp extends BaseAdapter {


    ArrayList<DataModelHallOfFrame> dataHolder;
    ArrayList<DataModelHallOfFrame> dataHolderBackup;


    public HallOfFrameAdp(ArrayList<DataModelHallOfFrame> dataHolder) {
        this.dataHolder = dataHolder;
        dataHolderBackup = new ArrayList<>(dataHolder);
    }

    @Override
    public int getCount() {
        return dataHolder.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_resource_layout_hallofframe, null);
        TextView name = view.findViewById(R.id.imgNameTvSingleResDesHallOfFrame);
        ImageView image = view.findViewById(R.id.imgVSingleResHallOfFrame);

        // Set the data in text view
        name.setText(dataHolder.get(i).getImgNameTvSingleResDesHallOfFrame());

        // Set the image in Image view
        image.setImageResource(dataHolder.get(i).getImgVSingleResHallOfFrame());


        return view;
    }
}
