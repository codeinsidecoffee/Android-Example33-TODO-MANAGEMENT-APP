package com.mrlonewolfer.example70;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<ImageBean> imgArrayList;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        context=this;
        gridView=findViewById(R.id.gridView);
        preaparedData();
        ImageAdapter imageAdapter= new ImageAdapter(context,imgArrayList);
        gridView.setAdapter(imageAdapter);
    }

    private void preaparedData() {

        imgArrayList= new ArrayList<>();
        imgArrayList.add(new ImageBean(R.drawable.a));
        imgArrayList.add(new ImageBean(R.drawable.b));
        imgArrayList.add(new ImageBean(R.drawable.c));
        imgArrayList.add(new ImageBean(R.drawable.d));
        imgArrayList.add(new ImageBean(R.drawable.e));
        imgArrayList.add(new ImageBean(R.drawable.f));
        imgArrayList.add(new ImageBean(R.drawable.g));
        imgArrayList.add(new ImageBean(R.drawable.h));
    }
}
