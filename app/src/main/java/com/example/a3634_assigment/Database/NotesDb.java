package com.example.a3634_assigment.Database;
/*
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import androidx.room.RoomDatabase;


import com.example.a3634_assigment.Models.Notes;


@Database(entities = {Notes.class}, version = 1)
public abstract class NotesDb extends RoomDatabase {
    public abstract NotesDao notesDao() ;
    private static NotesDb instance;
    public static NotesDb getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, NotesDb.class, "notesDb")
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



 */