package com.example.a3634_assigment.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.a3634_assigment.Models.User;

@Dao
public interface UserDao {

    @Insert
    void insertOneUser (User user);

   // @Query("SELECT * FROM User WHERE username = :username")
   // User fetchOneUserByUserName (String userName);
}
