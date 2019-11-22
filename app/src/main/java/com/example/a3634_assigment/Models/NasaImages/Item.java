
package com.example.a3634_assigment.Models.NasaImages;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

import com.example.a3634_assigment.AsyncTasks.ObjectConverters.Converters;
import com.example.a3634_assigment.AsyncTasks.ObjectConverters.ConvertersTwo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Item {

    @PrimaryKey@NonNull
    @TypeConverters(Converters.class)
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @TypeConverters(ConvertersTwo.class)
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    @SerializedName("href")
    @Expose
    private String href;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
