package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3634_assigment.Models.User;
import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.R;

public class RegisterActivity extends AppCompatActivity {


    public final static String NEW_USERNAME = "com.example.a3634_assigment.new_username";
    public final static String NEW_PASSWORD = "com.example.a3634_assigment.new_password";

    private TextView newUsername;
    private TextView newPassword;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newUsername = findViewById(R.id.newUsername);
        newPassword = findViewById(R.id.newPassword);
        submit = findViewById(R.id.submit);

        /*
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, RegisterActivity.class);
                context.startActivity(intent);
            }
        });

         */
    }

    //passes data to user database and switches to dashboard activity
    public void press(View view) {
        /*
        User user = new User(newUsername.getText().toString(), newPassword.getText().toString());
        SessionInfo.mUserDatabase.userDao().insertOneUser(user);
        SessionInfo.currentUser = user;

        /*
         */


        Intent intent = new Intent(RegisterActivity.this, AvatarActivity.class);
        intent.putExtra(NEW_USERNAME, newUsername.getText().toString());
        intent.putExtra(NEW_PASSWORD, newPassword.getText().toString());
        if (intent != null) {
            startActivity(intent);
        } else {
            System.out.println("hello");
        }


    }

    public void ignoreRegister(View view) {
        Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
        startActivity(intent);

    }
}

/*
User user = new User(newUsername.getText().toString(), newPassword.getText().toString());
                SessionInfo.mUserDatabase.userDao().insertOneUser(user);
                SessionInfo.currentUser = user;

            }
        }) .start();
 */