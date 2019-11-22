package com.example.a3634_assigment.Models;

public class Badges {

    private int badgeID;
    private String name;

    private int icon;

    public Badges(int badgeID, String name, int icon) {
        this.badgeID = badgeID;
        this.name = name;
        this.icon = icon;

    }

    public int getBadgeID() {
        return badgeID;
    }

    public void setBadgeID(int badgeID) {
        this.badgeID = badgeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Badges{" +
                "badgeID=" + badgeID +
                ", name='" + name + '\'' +
                ", icon=" + icon +
                '}';
    }
}
