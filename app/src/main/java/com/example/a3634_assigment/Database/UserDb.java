package com.example.a3634_assigment.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.a3634_assigment.Models.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDb extends RoomDatabase {
    public abstract UserDao userDao();          // Replace BookDao with whatever you name your DAO


    private static UserDb instance;

    public static UserDb getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, UserDb.class, "user_db")
//                    .allowMainThreadQueries()   // <== IMPORTANT TO NOTE:
                    //     This is NOT correct to do in a completed app.
                    //     Next week we will fix it, but for now this
                    //     line is necessary for the app to work.
                    //     This line will basically allow the database
                    //     queries to freeze the app.
                    .build();
        }
        return instance;
    }


}



