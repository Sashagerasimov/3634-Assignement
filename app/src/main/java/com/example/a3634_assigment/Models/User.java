package com.example.a3634_assigment.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @NonNull
    @PrimaryKey
    private String username;
    private String password;
    private int score;
    private int avatar;


    @Ignore
    public User(@NonNull  String username, String password, int avatar) {
        this.username = username;
        this.password = password;
        this.score = 0;
        this.avatar = avatar;

    }


    public User(@NonNull  String username, String password, int score, int avatar) {
        this.username = username;
        this.password = password;
        this.score = score;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Users{" +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", avatar=" + avatar +
                '}';
    }
}
