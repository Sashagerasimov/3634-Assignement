package com.example.a3634_assigment.Databases;


import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.a3634_assigment.DAOs.UserDao;
import com.example.a3634_assigment.Models.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDb extends RoomDatabase {
    public abstract UserDao userDao();
}



