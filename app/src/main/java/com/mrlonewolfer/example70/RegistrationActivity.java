package com.mrlonewolfer.example70;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtUserName,edtMobile,edtEmail,edtPassword;
    CheckBox chbState;
    Button btnSignUp;
    String name,mobile,pass,email;
    UserBean userBean;
    SharedPrefrenceExample sharedPrefrenceExample;
    int age;
    Boolean state;
    Context context;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        context=this;
        edtUserName=findViewById(R.id.edtUserName);
        edtEmail=findViewById(R.id.edtEmail);
        edtMobile=findViewById(R.id.edtMobile);
        edtPassword=findViewById(R.id.edtPassword);
        btnSignUp=findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);

        AppDataBaseCon appDataBaseCon= Room.databaseBuilder(this,AppDataBaseCon.class,Const.reg_db)
                .allowMainThreadQueries()
                .build();
        userDao=appDataBaseCon.userDao();



    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnSignUp){
            StoreDataInSharedPrefrence();
        }

    }

    private void StoreDataInSharedPrefrence() {

        userBean= new UserBean();
        userBean.setName(edtUserName.getText().toString());
        userBean.setMobile(edtMobile.getText().toString());
        userBean.setEmail(edtEmail.getText().toString());
        userBean.setPass(edtPassword.getText().toString());
        userBean.setStatus(Const.Status_True);

        //store data in room database
        userDao.insertUser(userBean);


        //store data in sharedprefrence
        sharedPrefrenceExample = new SharedPrefrenceExample(Const.FILE_NAME,context);
        sharedPrefrenceExample.setSharedPreferences(userBean);

        Toast.makeText(this, "Your Data is Succussfully Stored.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();


    }
}
