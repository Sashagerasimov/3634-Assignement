package com.example.a3634_assigment.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3634_assigment.Database.SampleData;
import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.Fragments.AchievementsFragment;
import com.example.a3634_assigment.Fragments.LearnFragment;
import com.example.a3634_assigment.Fragments.NotesFragment;
import com.example.a3634_assigment.Models.User;
import com.example.a3634_assigment.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    //LOGIN CLASS


    //declare widgets

    public Button rego;
    public TextInputLayout username;
    public TextInputLayout password;
    public Button login;
    public TextView message;

    // implements NavigationView.OnNavigationItemSelectedListener
    /*
    Resource link: https://codinginflow.com/tutorials/android/textinputlayout
    Source Date: 2019
    Author: Coding in Flow
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));
        //instantiates database once activity opens
        SessionInfo.createDB(this);

        //populates with Sample Data
        SampleData.createSampleUsers();


        //linked widgets to xml
        rego = findViewById(R.id.button);
        username = findViewById(R.id.un);
        password = findViewById(R.id.pw);
        login = findViewById(R.id.login);
        message = findViewById(R.id.message);

        //if user does not have account, takes user to Register page
        rego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, RegisterActivity.class);
                context.startActivity(intent);
                finish();
            }
        });

        //do following if login button clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retrieves user by username from instantiated database
                User loginUser = SessionInfo.mUserDatabase.userDao().returnOneUserByUserName(username.getEditText().getText().toString());
                //if user doesn't exist, show toast
                if (loginUser == null) {
                    Toast.makeText(getApplicationContext(), "Credentials incorrect or User doesn't exist", Toast.LENGTH_SHORT).show();
                }
                // Missing Username Field
                else if (username.getEditText().getText().toString().equals("")) {
                    username.setError("Username field empty!");
                }
                // Missing Password Field
                else if (password.getEditText().getText().toString().equals("")) {
                    password.setError("Password field empty!");
                }
                //username and password match with what is kept in database
                else if (loginUser.getPassword().equals(password.getEditText().getText().toString())) {
                    //go to dashboard activity
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DashboardActivity.class);
                    context.startActivity(intent);
                    //sets current user object to the user that has logged in
                    SessionInfo.currentUser = loginUser;
                    finish();
                }

            }
        });


    }
}

