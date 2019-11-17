package com.example.a3634_assigment.Models.Bodies;

public class Body {

    private String id;
    private String name;
    private String englishName;
    private boolean isPlanet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public boolean isPlanet() {
        return isPlanet;
    }

    public void setPlanet(boolean planet) {
        isPlanet = planet;
    }
}
