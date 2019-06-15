package com.mrlonewolfer.example70;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CpuUsageInfo;
import android.util.Log;

public class SharedPrefrenceExample {



    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String prefName;
    Context context;
    UserBean userBean;

    public SharedPrefrenceExample(String prefName, Context context) {
        this.prefName = prefName;
        this.context = context;
        sharedPreferences=context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public UserBean getSharedPreferences() {

        userBean = new UserBean();
        userBean.setName(sharedPreferences.getString(Const.PREF_UNAME,null));
        userBean.setMobile(sharedPreferences.getString(Const.PREF_Mobile,null));
        userBean.setPass(sharedPreferences.getString(Const.PREF_Pass,null));
        userBean.setEmail(sharedPreferences.getString(Const.PREF_EMAIL,null));
        userBean.setStatus(sharedPreferences.getString(Const.PREF_STATUS,null));
        return userBean;
    }

    public void setSharedPreferences(UserBean userBean) {

        editor.putString(Const.PREF_UNAME,userBean.getName());
        editor.putString(Const.PREF_Mobile,userBean.getMobile());
        editor.putString(Const.PREF_EMAIL,userBean.getEmail());
        editor.putString(Const.PREF_Pass,userBean.getPass());
        editor.putString(Const.PREF_STATUS,userBean.getStatus());
        editor.commit();
        Log.e("setSharedPreferences", "setSharedPreferences: "+userBean.getName() );
    }

    public void logout(){
        sharedPreferences=context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Const.PREF_STATUS,Const.Status_False);
        editor.commit();
    }
}
