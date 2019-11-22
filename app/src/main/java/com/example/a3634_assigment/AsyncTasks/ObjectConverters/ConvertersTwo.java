package com.example.a3634_assigment.AsyncTasks.ObjectConverters;

import androidx.room.TypeConverter;

import com.example.a3634_assigment.Models.NasaImages.Link;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ConvertersTwo {

    //converting the Link list into strings
    @TypeConverter
    public static List<Link> stringToLinkList(String data) {

        Gson gson = new Gson();

        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Link>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String linkListToString(List<Link> Link) {

        Gson gson = new Gson();
        
        return gson.toJson(Link);
    }
}
