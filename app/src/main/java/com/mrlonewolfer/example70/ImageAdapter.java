package com.mrlonewolfer.example70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    Context context;
    ArrayList<ImageBean> imgArrayList;
    ImageBean imageBean;
    ImageView imageView;

    public ImageAdapter(Context context, ArrayList<ImageBean> imgArrayList) {
        this.context = context;
        this.imgArrayList = imgArrayList;
    }

    @Override
    public int getCount() {
        return imgArrayList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            convertView=inflater.inflate(R.layout.gridview_row_item,parent,false);
        }

        imageBean=imgArrayList.get(position);
        imageView=convertView.findViewById(R.id.grid_image);
        imageView.setImageResource(imageBean.getImgId());
        return convertView;
    }
}
