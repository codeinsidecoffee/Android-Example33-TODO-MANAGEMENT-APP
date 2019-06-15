package com.mrlonewolfer.example70;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class FacultyActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<FacultyBean> factArrayList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        context = this;
        gridView = findViewById(R.id.facultyView);
        preaparedData();
        FacultyAdapter facultyAdapter= new FacultyAdapter(context,factArrayList);
        gridView.setAdapter(facultyAdapter);

    }

    private void preaparedData() {
        factArrayList = new ArrayList<>();
        factArrayList.add(new FacultyBean(R.drawable.a, "My Name iS A", "My DOb is A", "My address is A", "My Department is A", "my Subject is A"));
        factArrayList.add(new FacultyBean(R.drawable.b, "My Name iS b", "My DOb is b", "My address is b", "My Department is b", "my Subject is b"));
        factArrayList.add(new FacultyBean(R.drawable.c, "My Name iS c", "My DOb is c", "My address is c", "My Department is c", "my Subject is c"));
    }

}
