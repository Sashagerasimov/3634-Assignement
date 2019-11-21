package com.example.a3634_assigment.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverter;

import com.example.a3634_assigment.Models.NasaImages.Item;
import com.example.a3634_assigment.Models.Notes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface NasaItemsDao {

    @Query("SELECT * FROM item")
    List<Item> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Item> items);

}


