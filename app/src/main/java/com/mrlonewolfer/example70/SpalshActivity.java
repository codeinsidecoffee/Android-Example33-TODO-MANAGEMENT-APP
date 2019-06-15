package com.mrlonewolfer.example70;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SpalshActivity extends AppCompatActivity {
SharedPrefrenceExample sharedPrefrenceExample;
UserBean userBean;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        context=this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userBean= new UserBean();
                sharedPrefrenceExample = new SharedPrefrenceExample(Const.FILE_NAME,context);
                userBean=sharedPrefrenceExample.getSharedPreferences();
                Log.e("myuserbean", "myuserbean "+userBean.getName() );
                if(userBean.getName() != null){
                    if(userBean.getStatus().equals(Const.Status_True)){
                        Intent intent = new Intent(SpalshActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    if(userBean.getStatus().equals(Const.Status_False)) {
                        Intent intent = new Intent(SpalshActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
                else{
                    Intent intent = new Intent(SpalshActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);


    }
}
