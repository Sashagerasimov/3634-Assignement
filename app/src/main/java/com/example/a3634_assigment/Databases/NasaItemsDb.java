package com.example.a3634_assigment.Databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.a3634_assigment.DAOs.NasaItemsDao;
import com.example.a3634_assigment.Models.NasaImages.Item;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class NasaItemsDb extends RoomDatabase {
    public abstract NasaItemsDao nasaItemsDao();

    private static NasaItemsDb instance;
    public static NasaItemsDb getInstance(Context context) {

        if(instance == null) {
            instance = Room.databaseBuilder(context, NasaItemsDb.class, "nasaItems")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
