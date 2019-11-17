package com.example.a3634_assigment.Database;

import android.content.Context;

import androidx.room.Room;

import com.example.a3634_assigment.Models.User;

public class SessionInfo {
    public static User currentUser = new User("username", "password");
    public static UserDb mUserDatabase;

    public static void createDB(Context context) {

        mUserDatabase = Room.databaseBuilder(context.getApplicationContext(),
                UserDb.class, "user_db").allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    ;
}


