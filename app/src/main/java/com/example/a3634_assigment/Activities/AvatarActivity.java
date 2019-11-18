package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.Models.Images;
import com.example.a3634_assigment.Models.User;
import com.example.a3634_assigment.R;

public class AvatarActivity extends AppCompatActivity {

    int newAvatar = 0;
    ImageView avatarSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
        avatarSample = findViewById(R.id.sample);
    }


    //Officially registers user

    public void selectAvatar(View view){
        int[] avatars = {
                R.id.avatar1,
                R.id.avatar2,
                R.id.avatar3,
                R.id.avatar4,
                R.id.avatar5,
                R.id.avatar6,
        };

        int newAvatar = 0;
        while (newAvatar < avatars.length) {
            if (view.getId() == avatars[newAvatar])
                break;
            newAvatar++;
        }
        avatarSample.setImageResource(Images.avatars[newAvatar]);

    }

    public void onClickRegister(View view){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = getIntent().getExtras();
                if(bundle == null){
                    Toast.makeText(AvatarActivity.this, "failed!", Toast.LENGTH_SHORT).show();
                }
                else {
                    User user = new User(bundle.getString(RegisterActivity.NEW_USERNAME), bundle.getString(RegisterActivity.NEW_PASSWORD), newAvatar);
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
