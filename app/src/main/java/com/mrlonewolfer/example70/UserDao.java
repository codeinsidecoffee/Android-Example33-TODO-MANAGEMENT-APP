package com.mrlonewolfer.example70;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Insert
    void insertUser(UserBean userBean);

    @Update
    void updateUser(UserBean userBean);


    @Delete
    void deleteUser(UserBean userBean);

    @Query("select * from userbean")
    List<UserBean> getUserInfo();
}
