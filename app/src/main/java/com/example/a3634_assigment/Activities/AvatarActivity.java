package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.Models.User;
import com.example.a3634_assigment.R;

public class AvatarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
    }


    //Officially registers user
    public void onClickRegister(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = getIntent().getExtras();
                if(bundle == null){
                    Toast.makeText(AvatarActivity.this, "failed!", Toast.LENGTH_SHORT).show();
                }
                else {
                    User user = new User(bundle.getString(RegisterActivity.NEW_USERNAME), bundle.getString(RegisterActivity.NEW_PASSWORD));

                    SessionInfo.mUserDatabase.userDao().insertOneUser(user);
                    SessionInfo.currentUser = user;
                }
            }
        }) .start();

        //takes user to Main Page/Dashboard
        Intent intent = new Intent(AvatarActivity.this, DashboardActivity.class);
        startActivity(intent);
    }
}
