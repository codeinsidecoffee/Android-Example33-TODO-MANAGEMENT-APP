package com.mrlonewolfer.example70;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserBean.class},version =1,exportSchema = false)
public abstract class AppDataBaseCon extends RoomDatabase {

    public abstract UserDao userDao();
}
