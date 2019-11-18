package com.example.a3634_assigment.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a3634_assigment.Models.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertOneUser (User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);

   @Query("SELECT * FROM User WHERE username = :username")
   User returnOneUserByUserName (String username);
    }


