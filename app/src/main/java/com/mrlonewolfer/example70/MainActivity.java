package com.mrlonewolfer.example70;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
* Create One School TODOs App this app will contain:

 One Splash Screen, this screen will appear when application will start and
 this screen show on for  three second.

 After three second splash screen will finish from application and

        launch Registration or Login Screen
        (if user first time install application at that time must appear Registration Screen)

 After done registration process never show registration,
 only once time show registration page,
 second time directly open login page.

Registration information will store in sqlite database.
Also login process username,password will verify from database.
After Login in app show School Home Screen,
this screen will contain Gellary name Button,
School information Button,
Faculty information Button,About us Button,
on Home Screen.
If press on Gallery at that time show school image gallery.
If press on school information button at that time
show about school courses and standards with streams.

If press on faculty button at that time
 show all faculty information with respective subject and profile pictures.

 If press on about us button this will show school contact detail address,etc.


* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogout,btnSInfo,btnFinfo,btnAboutUS,btnGallery;
    UserBean userBean;
    Context context;
    SharedPrefrenceExample sharedPrefrenceExample;
    UserDao userDao;
    ListView listView;
    private List<UserBean> listuserInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        btnLogout=findViewById(R.id.logout);
        btnGallery=findViewById(R.id.btnGallery);
        btnSInfo=findViewById(R.id.btnSInfo);
        btnFinfo=findViewById(R.id.btnFInfo);
        btnAboutUS=findViewById(R.id.btnAboutUs);

        btnLogout.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
        btnSInfo.setOnClickListener(this);
        btnFinfo.setOnClickListener(this);
        btnAboutUS.setOnClickListener(this);

        retriveDataFromStorePrefrenceData();

        AppDataBaseCon appDataBaseCon= Room.databaseBuilder(this,AppDataBaseCon.class,Const.reg_db)
                .allowMainThreadQueries()
                .build();
        userDao=appDataBaseCon.userDao();


    }

    private void retriveDataFromStorePrefrenceData() {
      sharedPrefrenceExample =new SharedPrefrenceExample(Const.FILE_NAME,context);
        userBean=sharedPrefrenceExample.getSharedPreferences();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.logout){

            sharedPrefrenceExample.logout();

            userBean.setStatus(Const.Status_False);
            userDao.updateUser(userBean);

            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        if(v.getId()==R.id.btnGallery){
            showMyGallery();
        }
        if(v.getId()==R.id.btnFInfo){
            showFacultyInfo();
        }
        if(v.getId()==R.id.btnSInfo){
            showSchoolInfo();
        }
        if(v.getId()==R.id.btnAboutUs){
            showAboutUs();
        }
    }

    private void showAboutUs() {
        Intent intent=new Intent(this,AboutUsActivity.class);
        startActivity(intent);
    }

    private void showSchoolInfo() {
        Intent intent=new Intent(this,SchoolInfoActivity.class);
        startActivity(intent);
    }

    private void showFacultyInfo() {
        Intent intent=new Intent(this,FacultyActivity.class);
        startActivity(intent);
    }

    private void showMyGallery() {
        Intent intent=new Intent(this,GalleryActivity.class);
        startActivity(intent);
    }
}
