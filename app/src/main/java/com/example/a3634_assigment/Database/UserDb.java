package com.example.a3634_assigment.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.a3634_assigment.Models.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDb extends RoomDatabase {
    public abstract UserDao userDao();          // Replace BookDao with whatever you name your DAO


}



