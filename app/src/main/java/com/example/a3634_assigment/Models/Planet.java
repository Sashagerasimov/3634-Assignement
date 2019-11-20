package com.example.a3634_assigment.Models;

public class Planet {

    //declaring attributes
    private int id;
    private String name;
    private int imageDrawableId;

    //declaring constructor
    public Planet(int id, String name, int imageDrawableId) {
        this.id = id;
        this.name = name;
        this.imageDrawableId = imageDrawableId;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }
}
