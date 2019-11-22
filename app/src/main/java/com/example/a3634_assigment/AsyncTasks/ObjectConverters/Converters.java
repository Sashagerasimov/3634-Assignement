package com.example.a3634_assigment.AsyncTasks.ObjectConverters;

import androidx.room.TypeConverter;

import com.example.a3634_assigment.Models.NasaImages.Datum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class Converters {

    //converting the datum list in to strings
    @TypeConverter
    public static List<Datum> stringToDatumList(String data) {

        Gson gson = new Gson();

        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Datum>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String datumListToString(List<Datum> datum) {

        Gson gson = new Gson();
        
        return gson.toJson(datum);
    }
}
