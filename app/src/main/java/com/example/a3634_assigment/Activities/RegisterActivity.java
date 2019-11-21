package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;

import com.example.a3634_assigment.Models.User;
import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.R;

public class RegisterActivity extends AppCompatActivity {

    //declare Strings to pass as intents later
    public final static String NEW_USERNAME = "com.example.a3634_assigment.new_username";
    public final static String NEW_PASSWORD = "com.example.a3634_assigment.new_password";

    //initialise widgets
    private TextInputLayout newUsername;
    private TextInputLayout newPassword;
    private TextInputLayout newPassword2;
    private Button submit;
    private Button backToLoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //link widgets to xml
        newUsername = findViewById(R.id.newUsername);
        newPassword = findViewById(R.id.newPassword);
        newPassword2 = findViewById(R.id.newPassword2);
        submit = findViewById(R.id.submit);
        backToLoginActivity = findViewById(R.id.back);

    }

    //passes data to user database and switches to activity for user to choose avatar
    public void press(View view) {
        Intent intent = new Intent(RegisterActivity.this, AvatarActivity.class);
        intent.putExtra(NEW_USERNAME, newUsername.getEditText().getText().toString());
        intent.putExtra(NEW_PASSWORD, newPassword.getEditText().getText().toString());
        if (newUsername.getEditText().getText().toString().equals("")) {
            // Missing Username Field
            Toast.makeText(getApplicationContext(), "Username field empty!", Toast.LENGTH_SHORT).show();
        } else if (newPassword.getEditText().getText().toString().equals("")) {
            // Missing Password Field
            Toast.makeText(getApplicationContext(), "Password Field empty!", Toast.LENGTH_SHORT).show();
        } else if (newPassword2.getEditText().getText().toString().equals(newPassword.getEditText().getText().toString()) == false){
            Toast.makeText(getApplicationContext(), "Password does not match!", Toast.LENGTH_SHORT).show();
        }

        else {
                startActivity(intent);
            }
        }

        public void backToLogin(View view){
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }



    //ignoring register - for test purposes only
        public void ignoreRegister(View view){
            Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
            startActivity(intent);
        }
    }




