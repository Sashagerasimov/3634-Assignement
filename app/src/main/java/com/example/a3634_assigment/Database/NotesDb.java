package com.example.a3634_assigment.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.a3634_assigment.Models.Notes;

@Database(entities = {Notes.class}, version = 1, exportSchema = false)
public abstract class NotesDb extends RoomDatabase {
    public abstract NotesDao notesDao();          // Replace BookDao with whatever you name your DAO


}



