package com.example.a3634_assigment.Databases;

import com.example.a3634_assigment.Models.User;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static void createSampleUsers(){
        List<User> sampleUsers = new ArrayList<>();
        sampleUsers.add(new User("Gavin", "password", 1000, 1));

        SessionInfo.mUserDatabase.userDao().insertAll(sampleUsers);
    }
}
