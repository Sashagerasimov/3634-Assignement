package com.example.a3634_assigment.Database;

import com.example.a3634_assigment.Models.User;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static void createSampleUsers(){
        List<User> sampleUsers = new ArrayList<>();
        sampleUsers.add(new User("gavin", "password", 700, 1));

        SessionInfo.mUserDatabase.userDao().insertAll(sampleUsers);
    }
}
