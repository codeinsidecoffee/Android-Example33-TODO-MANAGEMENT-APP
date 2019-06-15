package com.mrlonewolfer.example70;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail,edtPass;
    UserBean userBean;
    Button btnSignIN;
    SharedPrefrenceExample sharedPrefrenceExample;
    Context context;
    UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=this;
        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPassword);
        btnSignIN=findViewById(R.id.signin);
        btnSignIN.setOnClickListener(this);
        sharedPrefrenceExample=new SharedPrefrenceExample(Const.FILE_NAME,context);
        userBean=sharedPrefrenceExample.getSharedPreferences();

        AppDataBaseCon appDataBaseCon= Room.databaseBuilder(this,AppDataBaseCon.class,Const.reg_db)
                .allowMainThreadQueries()
                .build();

        userDao=appDataBaseCon.userDao();


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signin){
            String email=edtEmail.getText().toString();
            String pass=edtPass.getText().toString();

            if(userBean.getEmail().equals(email) && userBean.getPass().equals(pass)){
                userBean.setStatus(Const.Status_True);

                //update db
                userDao.updateUser(userBean);


                //update shared prefrence
                sharedPrefrenceExample.setSharedPreferences(userBean);
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(context, "Please Enter Valid UserName And PassWord", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
