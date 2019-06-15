package com.mrlonewolfer.example70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class FacultyAdapter extends BaseAdapter {

    Context context;
    ArrayList<FacultyBean> factArrayList;
    ImageView gridimage;
    TextView txtName,txtDob,txtaddress,txtDepart,txtSubject;
    FacultyBean facultyBean;


    public FacultyAdapter(Context context, ArrayList<FacultyBean> factArrayList) {
        this.context = context;
        this.factArrayList = factArrayList;
    }

    @Override
    public int getCount() {
        return factArrayList.size();
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
            LayoutInflater inflater= LayoutInflater.from(parent.getContext());
            convertView=inflater.inflate(R.layout.faculty_row_layout,parent,false);
        }
        gridimage=convertView.findViewById(R.id.gridimage);
        txtName=convertView.findViewById(R.id.txtName);
        txtaddress=convertView.findViewById(R.id.txtaddress);
        txtDepart=convertView.findViewById(R.id.txtDepart);
        txtDob=convertView.findViewById(R.id.txtDob);
        txtSubject=convertView.findViewById(R.id.txtSubject);
        facultyBean=factArrayList.get(position);


        gridimage.setImageResource(facultyBean.factId);
        txtName.setText(facultyBean.factName);
        txtSubject.setText(facultyBean.factSubject);
        txtDob.setText(facultyBean.factDob);
        txtDepart.setText(facultyBean.factDeprt);
        txtaddress.setText(facultyBean.factAddress);


        return  convertView;
    }
}
