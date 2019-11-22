package com.example.a3634_assigment.Databases;


import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.a3634_assigment.DAOs.NotesDao;
import com.example.a3634_assigment.Models.Notes;

@Database(entities = {Notes.class}, version = 1, exportSchema = false)
public abstract class NotesDb extends RoomDatabase {
    public abstract NotesDao notesDao();
}



